package com.usreliance.orchardlab;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RealmController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>USRELIANCE Realm | Orchard Lab</title>
  <link rel="icon" href="/favicon.ico" />
  <style>
    :root{
      --bg:#071426;
      --panel:#0d1b2f;
      --panel2:#122741;
      --line:#28476d;
      --text:#e9eef7;
      --muted:#9db3d1;
      --gold:#d4af37;
      --blue:#4da3ff;
      --green:#39d98a;
    }
    *{box-sizing:border-box}
    body{
      margin:0;
      font-family:Arial,Helvetica,sans-serif;
      background:linear-gradient(180deg,#05101d 0%,#071426 100%);
      color:var(--text);
    }
    .wrap{max-width:1280px;margin:0 auto;padding:30px 20px 60px}
    .hero,.section{
      background:linear-gradient(180deg,var(--panel),var(--panel2));
      border:1px solid var(--line);
      border-radius:20px;
      padding:28px 24px;
      margin-bottom:20px;
    }
    .eyebrow{
      color:var(--gold);
      font-size:12px;
      letter-spacing:2px;
      text-transform:uppercase;
      margin-bottom:10px;
    }
    h1{margin:0;font-size:42px}
    h2{margin:0 0 14px;font-size:24px}
    .sub{margin-top:14px;color:var(--muted);font-size:18px;line-height:1.6}
    .badge{
      display:inline-block;
      margin-top:18px;
      padding:10px 16px;
      border-radius:999px;
      border:1px solid #3a618f;
      background:rgba(77,163,255,0.08);
      font-weight:700;
    }
    .actions{display:flex;flex-wrap:wrap;gap:12px;margin-top:22px}
    .button{
      display:inline-block;
      padding:12px 16px;
      border-radius:12px;
      border:1px solid #4d86c2;
      background:linear-gradient(135deg,#234f85,#2f78c8);
      color:#fff;
      font-weight:700;
      text-decoration:none;
    }
    .button.alt{
      background:rgba(255,255,255,0.03);
      border-color:var(--line);
      color:var(--text);
    }
    .grid{
      display:grid;
      grid-template-columns:repeat(auto-fit,minmax(260px,1fr));
      gap:16px;
      margin-top:14px;
    }
    .card{
      background:rgba(0,0,0,0.18);
      border:1px solid #2f4868;
      border-radius:16px;
      padding:18px;
    }
    .card h3{margin:0 0 10px}
    .card p{margin:0;color:var(--muted);line-height:1.55}
    .shots{
      display:grid;
      grid-template-columns:repeat(auto-fit,minmax(320px,1fr));
      gap:16px;
      margin-top:16px;
    }
    .shot{
      background:rgba(0,0,0,0.18);
      border:1px solid #2f4868;
      border-radius:16px;
      overflow:hidden;
    }
    .shot img{
      display:block;
      width:100%;
      height:auto;
      min-height:180px;
      background:#081321;
      object-fit:cover;
    }
    .caption{padding:12px 14px;color:var(--muted);font-size:14px;line-height:1.5}
    ul{color:var(--muted);line-height:1.7}
    .footer{margin-top:24px;text-align:center;color:var(--muted);font-size:14px}
  </style>
</head>
<body>
  <div class="wrap">
    <section class="hero">
      <div class="eyebrow">USRELIANCE REALM • ORCHARD LAB • PLATFORM ENGINEERING</div>
      <h1>Orchard Lab: The Observability Gate of the Realm</h1>
      <div class="sub">
        Orchard Lab is the secure USRELIANCE engineering outpost: a Spring Boot service fronted by Nginx and TLS,
        monitored through Prometheus and Grafana, and shaped by the allegiance of the Grand Imperator and Voximus Maximus.
      </div>
      <div class="badge">⚔️ Grand Imperator Brian • Voximus Maximus • Secure Realm Entry Point</div>

      <div class="actions">
        <a class="button" href="/hello">Test /hello</a>
        <a class="button" href="/work">Invoke /work</a>
        <a class="button alt" href="/actuator/prometheus">Metrics Endpoint</a>
	<a class="button alt" href="https://orchard.usreliance.com/grafana/d/ad7xm6r/orchard-observability?orgId=1&from=now-6h&to=now&timezone=browser" target="_blank">Grafana Dashboard</a>
        <a class="button alt" href="https://orchard.usreliance.com/prometheus/">Prometheus</a>
        <a class="button alt" href="https://orchard-lab.usreliance.com/">Status Page</a>
      </div>
    </section>

    <section class="section">
      <h2>What Is Running Now</h2>
      <div class="grid">
        <div class="card">
          <h3>Spring Boot Service</h3>
          <p>java-demo is running behind Nginx with HTTPS at orchard.usreliance.com.</p>
        </div>
        <div class="card">
          <h3>Prometheus</h3>
          <p>Prometheus is scraping JVM and HTTP metrics from the actuator endpoint.</p>
        </div>
        <div class="card">
          <h3>Grafana</h3>
          <p>Grafana visualizes traffic, latency, CPU usage, heap usage, threads, GC activity, and errors.</p>
        </div>
        <div class="card">
          <h3>Secure Edge</h3>
          <p>Nginx terminates TLS using Let's Encrypt certificates issued by Certbot.</p>
        </div>
      </div>
    </section>

<section class="section">
  <h2>Project Journal and Entry Points</h2>
  <ul>
    <li>Repository: <a href="https://github.com/bizranker/orchard-lab" target="_blank" style="color:#4da3ff;">github.com/bizranker/orchard-lab</a></li>
    <li>README: the living project log and architectural source of truth for Orchard Lab</li>
    <li>Primary secure app entry: <a href="https://orchard.usreliance.com" target="_blank" style="color:#4da3ff;">orchard.usreliance.com</a></li>
    <li>Status dashboard: <a href="https://orchard-lab.usreliance.com/" target="_blank" style="color:#4da3ff;">orchard-lab.usreliance.com</a></li>
    <li>Controlled access: privileged changes remain case-by-case, not public sandbox access</li>
  </ul>
</section>

<section class="section">
  <h2>Next Expansion of the Realm</h2>
  <div class="grid">
    <div class="card">
      <h3>K3s</h3>
      <p>Lightweight Kubernetes foundation for platform and workload demonstrations.</p>
    </div>
    <div class="card">
      <h3>Rancher</h3>
      <p>Cluster visibility, lifecycle operations, and multi-environment management.</p>
    </div>
    <div class="card">
      <h3>ArgoCD</h3>
      <p>GitOps deployment flow for declarative application promotion and rollback.</p>
    </div>
    <div class="card">
      <h3>API Security</h3>
      <p>Future demo surface for secure ingress, auth, policy, and observability patterns.</p>
    </div>
  </div>
</section>

    <div class="footer">
      USRELIANCE Realm • Orchard Lab • Secure Platform Engineering Gateway
    </div>
  </div>
</body>
</html>
""";
    }
}
