# Orchard Lab Deployment Notes

This document records the runtime configuration and operational layout for the Orchard Lab environment.

---

## Application Runtime

The Spring Boot demo service runs as a systemd service.

Service name:

orchard-demo.service

Systemd unit location:

/etc/systemd/system/orchard-demo.service

Runtime JAR location:

/opt/orchard-runtime/orchard-demo.jar

Application source code:

/opt/orchard-lab/java-demo

Controller serving the main realm homepage:

/opt/orchard-lab/java-demo/src/main/java/com/usreliance/orchardlab/RealmController.java

---

## Service Management

Stop service:

sudo systemctl stop orchard-demo

Start service:

sudo systemctl start orchard-demo

Restart service:

sudo systemctl restart orchard-demo

Check status:

sudo systemctl status orchard-demo --no-pager -l

View logs:

sudo journalctl -u orchard-demo -n 100 --no-pager

---

## Build and Deploy Process

Navigate to the project directory:

cd /opt/orchard-lab/java-demo

Build the Spring Boot application:

mvn clean package -DskipTests

Copy the generated JAR into the runtime location:

sudo cp target/orchard-lab-demo-0.0.1-SNAPSHOT.jar /opt/orchard-runtime/orchard-demo.jar

Restart the service:

sudo systemctl restart orchard-demo

---

## Observability Stack

Prometheus and Grafana run using Docker Compose.

Compose file location:

/opt/orchard-lab/observability/docker-compose.yml

Prometheus configuration:

/opt/orchard-lab/observability/prometheus/prometheus.yml

Grafana datasource provisioning:

/opt/orchard-lab/observability/grafana/provisioning/datasources/prometheus.yml

---

## Public Endpoints

Primary secure entry point:

https://orchard.usreliance.com

Prometheus UI:

https://orchard.usreliance.com/prometheus

Grafana dashboards:

https://orchard.usreliance.com/grafana

Application metrics endpoint:

https://orchard.usreliance.com/actuator/prometheus

Status dashboard:

https://orchard-lab.usreliance.com

---

## Nginx Configuration

Main secure realm configuration:

/etc/nginx/conf.d/orchard.usreliance.com.conf

Status dashboard configuration:

/etc/nginx/conf.d/orchard-lab.usreliance.com.conf

Static assets served by nginx:

/usr/share/nginx/html

These include:

favicon.ico  
grafana-dashboard.png  
prometheus-targets.png  
status-page.png

---

## Repository

Source repository:

https://github.com/bizranker/orchard-lab

Repository root on instance:

/opt/orchard-lab

---

## Architecture Overview

Internet  
↓  
orchard.usreliance.com (Nginx TLS)  
↓  
Spring Boot Application (:8080)  
↓  
Prometheus metrics endpoint

Additional services proxied through nginx:

Grafana → /grafana  
Prometheus → /prometheus

Separate status surface:

orchard-lab.usreliance.com

---

## Notes

This repository represents a platform engineering demonstration environment combining:

Terraform infrastructure provisioning  
Spring Boot service deployment  
Nginx ingress and TLS termination  
Prometheus metrics collection  
Grafana observability dashboards  
AWS EC2 runtime environment

Future expansion may include:

K3s cluster deployment  
Rancher management plane  
ArgoCD GitOps workflows  
API security demonstration services
