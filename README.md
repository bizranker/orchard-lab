# 🌳 orchard-lab

AWS micro-lab for platform engineering, Terraform workflows, and cloud reliability experiments.

Orchard Lab is a hands-on infrastructure repository designed to demonstrate practical DevOps and Site Reliability Engineering patterns in AWS. The lab focuses on reproducible infrastructure, TLS-enabled ingress, compute provisioning, and cloud foundations that can be expanded into more complete platform engineering scenarios.

---

## ✨ Current Scope

This repository currently contains a Terraform-based AWS micro-lab with:

- VPC and foundational infrastructure components
- EC2 provisioning
- Security group configuration
- ACM certificate resources
- TLS-enabled ALB experimentation
- bootstrap scripting for host initialization
- archived alternate configurations for future expansion

---

## 📁 Repository Layout

```text
orchard-lab/
├── infra/
│   ├── acm.tf
│   ├── acm_wildcard.tf
│   ├── alb_tls.tf
│   ├── bootstrap.ps1
│   ├── ec2.tf
│   ├── main.tf
│   ├── providers.tf
│   ├── sg_web.tf
│   ├── terraform.tfvars.example
│   ├── variables.tf
│   └── archived/
│       ├── alb_core.tf.off
│       ├── alb_https.tf.off
│       ├── alb_tls.tf.DISABLED
│       ├── gitlab.tf.off
│       ├── outputs.tf.off
│       └── versions.tf.off
