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
    .button:hover{filter:brightness(1.08)}
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
    .journal-links a{
      color:var(--blue);
      text-decoration:none;
    }
    .journal-links a:hover{
      text-decoration:underline;
    }
    .shots{
      display:grid;
      grid-template-columns:repeat(auto-fit,minmax(360px,1fr));
      gap:18px;
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
      min-height:260px;
      background:#081321;
      object-fit:contain;
    }
    .caption{
      padding:12px 14px;
      color:var(--muted);
      font-size:14px;
      line-height:1.5;
    }
    ul{color:var(--muted);line-height:1.8}
    code{
      background:rgba(255,255,255,0.06);
      padding:2px 6px;
      border-radius:6px;
      color:#d7e7ff;
    }
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
        <a class="button" href="/hello" target="_blank" rel="noopener noreferrer">Test /hello</a>
        <a class="button" href="/work" target="_blank" rel="noopener noreferrer">Invoke /work</a>
        <a class="button alt" href="/actuator/prometheus" target="_blank" rel="noopener noreferrer">Metrics Endpoint</a>
        <a class="button alt" href="https://orchard.usreliance.com/prometheus/targets" target="_blank" rel="noopener noreferrer">Prometheus Targets</a>
        <a class="button alt" href="https://orchard.usreliance.com/grafana/d/ad7xm6r/orchard-observability?orgId=1&from=now-6h&to=now&timezone=browser" target="_blank" rel="noopener noreferrer">Grafana Dashboard</a>
        <a class="button alt" href="https://orchard-lab.usreliance.com/" target="_blank" rel="noopener noreferrer">Status Page</a>
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

    <section class="section journal-links">
      <h2>Project Journal and Entry Points</h2>
      <ul>
        <li><strong>Repository:</strong> <a href="https://github.com/bizranker/orchard-lab" target="_blank" rel="noopener noreferrer">github.com/bizranker/orchard-lab</a></li>
        <li><strong>Local project root:</strong> <code>/opt/orchard-lab</code></li>
        <li><strong>Java app source:</strong> <code>/opt/orchard-lab/java-demo</code></li>
        <li><strong>Runtime jar:</strong> <code>/opt/orchard-runtime/orchard-demo.jar</code></li>
        <li><strong>Service unit:</strong> <code>/etc/systemd/system/orchard-demo.service</code></li>
        <li><strong>Observability stack:</strong> Prometheus, Grafana, Tempo, Spring Boot Actuator, Nginx, TLS, ALB, Terraform, Docker Compose</li>
        <li><strong>Architecture/docs:</strong> use the repo README plus the <code>architecture</code>, <code>docs</code>, <code>observability</code>, and <code>platform</code> directories as the living source of truth</li>
        <li><strong>Future state:</strong> Orchard Lab will expand into a platform engineering demo with fictional client verticals, isolated namespaces, secure API communication, and controlled ingress through the USRELIANCE realm</li>
      </ul>
    </section>

    <section class="section">
      <h2>Architecture and Screenshots</h2>
      <div class="shots">
        <div class="shot">
          <a href="/grafana-dashboard.png" target="_blank" rel="noopener noreferrer">
            <img src="/grafana-dashboard.png" alt="Grafana dashboard">
          </a>
          <div class="caption">Grafana observability dashboard for request rate, latency, CPU, error rate, heap usage, threads, and GC activity. Click image to open full size.</div>
        </div>
        <div class="shot">
          <a href="/prometheus-targets.png" target="_blank" rel="noopener noreferrer">
            <img src="/prometheus-targets.png" alt="Prometheus targets">
          </a>
          <div class="caption">Prometheus targets view confirming successful scraping of the Spring Boot actuator metrics endpoint. Click image to open full size.</div>
        </div>
        <div class="shot">
          <a href="/status-page.png" target="_blank" rel="noopener noreferrer">
            <img src="/status-page.png" alt="Status page">
          </a>
          <div class="caption">The Orchard status page showing instance metadata, system load, memory, disk, and network information. Click image to open full size.</div>
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
