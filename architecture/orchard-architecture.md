# Orchard Lab Architecture

This document describes the architecture of the Orchard Lab platform engineering demonstration environment.

---

## High-Level Architecture

Internet
↓
orchard.usreliance.com
(Nginx TLS Reverse Proxy)
↓
Spring Boot Application (:8080)
↓
Prometheus Metrics Endpoint

Additional proxied services:

/grafana → Grafana dashboards  
/prometheus → Prometheus UI

Separate operational surface:

orchard-lab.usreliance.com

This host provides a lightweight operational status dashboard.

---

## Components

### Nginx

TLS termination and reverse proxy for all internal services.

Configuration:

/etc/nginx/conf.d/orchard.usreliance.com.conf

Responsibilities:

TLS termination via Let's Encrypt  
Reverse proxy to Spring Boot service  
Reverse proxy to Grafana  
Reverse proxy to Prometheus  
Serving static observability screenshots

---

### Spring Boot Demo Service

Application source:

/opt/orchard-lab/java-demo

Runtime JAR:

/opt/orchard-runtime/orchard-demo.jar

Primary controller:

/opt/orchard-lab/java-demo/src/main/java/com/usreliance/orchardlab/RealmController.java

Endpoints include:

/  
/hello  
/work  
/actuator/prometheus

---

### Prometheus

Prometheus scrapes metrics from the Spring Boot actuator endpoint.

Configuration:

/opt/orchard-lab/observability/prometheus/prometheus.yml

Prometheus runs via Docker Compose.

UI exposed through nginx:

https://orchard.usreliance.com/prometheus

---

### Grafana

Grafana visualizes application and system metrics.

Datasource configuration:

/opt/orchard-lab/observability/grafana/provisioning/datasources/prometheus.yml

UI exposed through nginx:

https://orchard.usreliance.com/grafana

---

### Terraform Infrastructure

Infrastructure provisioning lives in:

/opt/orchard-lab/infra

Terraform components include:

VPC configuration  
EC2 provisioning  
Security groups  
ACM certificate experiments  
Application Load Balancer experiments

Archived configurations remain in:

infra/archived

---

## Observability Stack

The observability stack runs using Docker Compose.

Compose file:

/opt/orchard-lab/observability/docker-compose.yml

Services include:

Prometheus  
Grafana  
Tempo (for distributed tracing experiments)

---

## Static Operational Assets

Nginx serves static screenshots from:

/usr/share/nginx/html

Files include:

grafana-dashboard.png  
prometheus-targets.png  
status-page.png  
favicon.ico

These assets provide quick operational visibility from the homepage.

---

## Repository

Source repository:

https://github.com/bizranker/orchard-lab

Local repository location:

/opt/orchard-lab

---

## Future Expansion

Orchard Lab is designed to evolve into a larger platform engineering environment.

Potential future components include:

K3s Kubernetes cluster  
Rancher cluster management  
ArgoCD GitOps deployment  
API security and gateway demonstrations  
Platform engineering automation experiments

