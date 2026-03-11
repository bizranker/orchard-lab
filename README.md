# 🌳 orchard-lab

AWS micro-lab for platform engineering, Terraform workflows, and cloud reliability experiments.

Orchard Lab is a hands-on infrastructure repository designed to demonstrate practical DevOps and Site Reliability Engineering patterns in AWS. The lab focuses on reproducible infrastructure, TLS-enabled ingress, compute provisioning, and cloud foundations that can be expanded into more complete platform engineering scenarios.

---

## Architecture Overview

```
Internet
   │
   ▼
Application Load Balancer (TLS)
   │
   ▼
EC2 Instance
   │
   ▼
Security Group Controls
   │
   ▼
AWS VPC
```

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

```
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
```

---

## 🚀 Quick Start

Clone the repository and deploy the lab environment using Terraform.

```bash
git clone https://github.com/bizranker/orchard-lab.git
cd orchard-lab/infra
cp terraform.tfvars.example terraform.tfvars
terraform init
terraform plan
terraform apply
```

---

## 🧪 Purpose

Orchard Lab is designed as a **platform engineering playground** where infrastructure patterns can be tested and refined.

It serves as a demonstration environment for:

- Terraform infrastructure workflows
- AWS networking and compute provisioning
- TLS ingress architecture
- DevOps experimentation
- infrastructure reproducibility

The lab can later evolve into larger platform experiments including container platforms, CI/CD pipelines, and production-style infrastructure patterns.

---

## 📜 License

This repository is intended for educational and experimentation purposes.
