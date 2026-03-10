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

variable "acm_certificate_arn" {
  description = "ACM certificate ARN used by the ALB HTTPS listener"
  type        = string
}

variable "my_ip_cidr" {
  description = "Your public IP in CIDR form (x.x.x.x/32)"
  type        = string
}