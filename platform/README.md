# Orchard Lab Platform

This directory contains the multi-tenant platform engineering layer for Orchard Lab.

## Purpose

The goal is to evolve Orchard Lab from a single observability demo into a private platform engineering environment that demonstrates:

- namespace isolation
- fictional enterprise tenant onboarding
- secure service exposure
- GitOps-ready manifest layout
- policy and ingress control
- observability across multiple verticals

## Tenants

### aurelia-finance
A fictional fintech tenant representing a regulated financial services client.

### northstar-logistics
A fictional enterprise logistics tenant representing a high-throughput B2B operations client.

## Layout

- `namespaces/` tenant-specific namespace definitions and notes
- `ingress/` ingress definitions and routing plans
- `policies/` network and security policy manifests
- `services/` shared and tenant-facing service definitions
- `manifests/` consolidated deployment manifests and future GitOps entry points

## Operating Principle

Public traffic continues to enter through:

ALB -> nginx -> internal services

K3s will be introduced behind nginx, not as the owner of ports 80 and 443.

## Current Intent

This platform layer is being prepared for:

1. controlled K3s reintroduction
2. tenant namespace creation
3. safe service exposure
4. ArgoCD / GitOps integration
5. observability expansion across client verticals
