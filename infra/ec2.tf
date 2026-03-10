resource "aws_instance" "web" {
  ami                         = "ami-038b8814ce7e93a90"
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

  tags = {
    Name = "${var.name_prefix}-web"
  }
}
