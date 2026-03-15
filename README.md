sudo tee /opt/orchard-lab/README.md >/dev/null <<'EOF'
# 🌳 Orchard Lab

**Enterprise Platform Engineering Lab**

Orchard Lab is a private AWS-based platform engineering environment used to demonstrate real-world DevOps, Site Reliability Engineering, and FinTech infrastructure patterns.

This lab models how enterprise platforms support **multiple isolated financial clients (verticals)** using modern infrastructure tools including:

- AWS
- Terraform
- Nginx edge routing
- Spring Boot services
- Prometheus metrics
- Grafana dashboards
- Tempo tracing
- Kubernetes (K3s)
- multi-tenant namespace architecture

This repository exists as a **controlled enterprise-style showcase**, not a public sandbox.

---

# 🏗 Architecture Overview

    Internet
       │
       ▼
    Application Load Balancer (TLS)
       │
       ▼
    EC2 Instance
       │
       ├── Nginx Edge Layer
       │     ├── orchard.usreliance.com
       │     ├── orchard-lab.usreliance.com
       │     ├── /prometheus/
       │     └── /grafana/
       │
       ├── Spring Boot Platform Application
       │     ├── /
       │     ├── /hello
       │     ├── /work
       │     ├── /actuator/health
       │     └── /actuator/prometheus
       │
       ├── Observability Stack
       │     ├── Prometheus
       │     ├── Grafana
       │     └── Tempo
       │
       └── Kubernetes (K3s)
             ├── control plane
             ├── tenant namespaces
             └── client workloads

The **Nginx layer permanently owns ports 80 and 443** to prevent Kubernetes ingress controllers from taking control of the public edge.

---

# 🚀 Current Capabilities

Orchard Lab currently demonstrates:

### Infrastructure
- Terraform-based AWS provisioning
- TLS via AWS ACM
- Application Load Balancer routing

### Application Layer
- Spring Boot demo application
- Actuator health endpoints
- Prometheus metrics export

### Observability
- Prometheus metrics scraping
- Grafana dashboards
- Tempo tracing infrastructure

### Platform Layer
- K3s Kubernetes cluster
- multi-tenant namespace isolation
- client deployment bundles
- network policies

---

# 🌐 Live Service Endpoints

| Endpoint | Purpose |
|--------|--------|
| / | Orchard platform UI |
| /actuator/health | application health |
| /actuator/prometheus | Prometheus metrics |
| /prometheus/ | Prometheus UI |
| /grafana/ | Grafana dashboards |

Example:

    https://orchard.usreliance.com

Access is currently **restricted by security group rules**.

---

# 🏦 Vertical Architecture

Financial clients are represented as **verticals**.

Examples from real environments include:

- Bank of America
- Wells Fargo
- JP Morgan Chase

Each vertical runs in its own isolated infrastructure slice.

In Orchard Lab this model is implemented using **Kubernetes namespaces**:

    aurelia-finance
    northstar-logistics

Each namespace contains its own:

- deployments
- services
- secrets
- ingress rules
- network policies

---

# ⚙ Vertical Deployment Pattern

In enterprise environments, new client infrastructure is rarely built from scratch.

Instead a new vertical is created by:

1. cloning an existing vertical
2. performing targeted configuration replacements
3. adjusting container resources
4. deploying the workload bundle

Orchard Lab mirrors this approach using client bundles located under:

    platform/clients/

---

# 🧠 Infrastructure Intelligence Concept

Large FinTech platforms often maintain a **central metadata database** describing every server and service in the environment.

Tools such as:

- Nagios
- Puppet
- configuration automation systems

query this data to configure monitoring automatically.

Example concept:

    for server in inventory where role == "database":
        configure_database_monitoring(server)

Future versions of Orchard Lab may simulate this pattern.

---

# 💬 Message Processing Systems

Real FinTech systems rely heavily on asynchronous messaging.

DocMagic used **ActiveMQ** to process mortgage transaction pipelines.

Operational responsibilities included:

- detecting malformed messages
- replaying failed transactions
- monitoring queue health

Future lab expansions may simulate this operational model.

---

# 🧩 Repository Structure

    orchard-lab/
    ├── README.md
    ├── infra/
    ├── java-demo/
    ├── observability/
    └── platform/

---

# 🧪 Operational Verification

Useful platform checks:

    curl https://orchard.usreliance.com
    curl https://orchard.usreliance.com/actuator/health

Kubernetes checks:

    sudo k3s kubectl get nodes
    sudo k3s kubectl get pods -A

---

# 🔮 Planned Platform Evolution

Future improvements include:

- GitOps deployment pipelines
- ArgoCD platform integration
- Rancher cluster management
- tenant onboarding automation
- message queue simulation
- clustered database services
- disaster recovery simulation

---

# 🎯 Purpose

Orchard Lab demonstrates **realistic enterprise DevOps and platform engineering practices** modeled after production FinTech environments.

EOF
