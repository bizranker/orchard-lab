# Orchard Lab Platform Expansion

This section of the repository defines the next phase of the Orchard Lab realm:

- multi-tenant verticals
- GitOps onboarding through ArgoCD
- future K3s deployment targets
- future Rancher visibility and lifecycle management
- secure API communication patterns between fictional clients
- observability integration

## Fictional Client Verticals

### Aurelia Finance
A fictional financial services tenant used to demonstrate:
- namespace isolation
- API ingress
- token-based service communication
- future transaction-style API flows

### Northstar Logistics
A fictional logistics tenant used to demonstrate:
- separate namespace and traffic boundary
- API ingress
- token-based service communication
- future shipment/event-style API flows

## Planned Runtime Model

K3s cluster
↓
ArgoCD manages vertical manifests from Git
↓
Rancher provides operational visibility
↓
each tenant runs in its own namespace
↓
traffic enters through ingress/TLS
↓
tenant APIs communicate through controlled service endpoints
↓
Prometheus and Grafana monitor health and traffic

## Notes

These manifests are the first GitOps scaffold.

They establish:
- namespaces
- placeholder API deployments
- services
- ingress objects
- network policy boundaries
- ArgoCD project and application definitions

A later phase will replace placeholder application images with real services and implement stronger API security patterns such as signed JWTs or mTLS.
