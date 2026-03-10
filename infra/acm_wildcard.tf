resource "aws_acm_certificate" "orchard_wildcard" {
  domain_name               = "*.orchard-lab.usreliance.com"
  subject_alternative_names = ["orchard-lab.usreliance.com"]
  validation_method         = "DNS"

  tags = {
    Name = "orchard-lab-wildcard-acm"
  }
}

resource "aws_acm_certificate_validation" "orchard_wildcard" {
  certificate_arn = aws_acm_certificate.orchard_wildcard.arn

  validation_record_fqdns = [
    for dvo in aws_acm_certificate.orchard_wildcard.domain_validation_options :
    dvo.resource_record_name
  ]
}