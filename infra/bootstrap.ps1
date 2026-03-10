<#
Bootstrap Terraform AWS Micro-Lab (EC2 + SG + Nginx)
- Creates/overwrites: versions.tf, providers.tf, variables.tf, main.tf, outputs.tf
- Optionally runs: terraform fmt/init/validate/plan

Run (as your normal user) from the infra folder:
  cd "$HOME\OrchardLab\aws-micro-lab\infra"
  .\bootstrap.ps1

If execution policy blocks it:
  Set-ExecutionPolicy -Scope CurrentUser RemoteSigned
#>

$ErrorActionPreference = "Stop"

# --- Target directory (current folder by default)
$InfraDir = (Get-Location).Path

Write-Host "Working directory: $InfraDir" -ForegroundColor Cyan

# --- File contents (IMPORTANT: use SINGLE-QUOTED here-strings @' '@ to prevent PowerShell interpolation)
$files = @{

  "versions.tf" = @'
terraform {
  required_version = ">= 1.5.0"
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}
'@

  "providers.tf" = @'
provider "aws" {
  region = var.aws_region
}
'@

  "variables.tf" = @'
variable "aws_region" {
  type    = string
  default = "us-west-2"
}

variable "instance_type" {
  type    = string
  default = "t3.micro"
}

variable "name_prefix" {
  type    = string
  default = "orchard-lab"
}
'@

  "main.tf" = @'
data "aws_vpc" "default" {
  default = true
}

data "aws_subnets" "default" {
  filter {
    name   = "vpc-id"
    values = [data.aws_vpc.default.id]
  }
}

data "aws_ami" "al2023" {
  most_recent = true
  owners      = ["amazon"]

  filter {
    name   = "name"
    values = ["al2023-ami-*-x86_64*"]
  }
}

resource "aws_security_group" "web" {
  name        = "${var.name_prefix}-web-sg"
  description = "Allow HTTP inbound"
  vpc_id      = data.aws_vpc.default.id

  ingress {
    description = "HTTP"
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    description = "All outbound"
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = { Name = "${var.name_prefix}-web-sg" }
}

resource "aws_instance" "web" {
  ami                         = data.aws_ami.al2023.id
  instance_type               = var.instance_type
  subnet_id                   = data.aws_subnets.default.ids[0]
  vpc_security_group_ids      = [aws_security_group.web.id]
  associate_public_ip_address = true

  user_data = <<-EOF
#!/bin/bash
set -euxo pipefail
dnf -y update
dnf -y install nginx
systemctl enable --now nginx
echo "AVE IMPERATOR — Orchard Lab is alive." > /usr/share/nginx/html/index.html
EOF

  tags = { Name = "${var.name_prefix}-web" }
}
'@

  "outputs.tf" = @'
output "public_ip" {
  value       = aws_instance.web.public_ip
  description = "Public IP of the web instance"
}
'@
}

# --- Write files (UTF-8, overwrite)
foreach ($name in $files.Keys) {
  $path = Join-Path $InfraDir $name
  $files[$name] | Out-File -FilePath $path -Encoding utf8 -Force
  Write-Host "Wrote $name" -ForegroundColor Green
}

Write-Host "`nFiles created/updated:" -ForegroundColor Cyan
Get-ChildItem $InfraDir -File | Where-Object Name -match '\.tf$|bootstrap\.ps1' |
  Select-Object Name, Length, LastWriteTime | Format-Table -AutoSize

# --- Optional: run Terraform workflow
$RunTerraform = $true   # set $false if you only want to generate files

if ($RunTerraform) {
  Write-Host "`nRunning Terraform..." -ForegroundColor Cyan

  terraform version | Out-Host
  aws sts get-caller-identity | Out-Host

  terraform fmt | Out-Host
  terraform init | Out-Host
  terraform validate | Out-Host
  terraform plan | Out-Host
}
