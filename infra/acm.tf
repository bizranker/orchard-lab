#############################################
# ACM certificate for orchard-lab.usreliance.com
#############################################

variable "app_domain" {
  type        = string
  description = "DNS name for the lab"
}

resource "aws_acm_certificate" "orchard" {
  domain_name       = var.app_domain
  validation_method = "DNS"

  tags = {
    Name = "orchard-lab-acm"
  }

  lifecycle {
    create_before_destroy = true
  }
}

output "acm_dns_validation_records" {
  value = [
    for dvo in aws_acm_certificate.orchard.domain_validation_options : {
      domain = dvo.domain_name
      name   = dvo.resource_record_name
      type   = dvo.resource_record_type
      value  = dvo.resource_record_value
    }
  ]
}
