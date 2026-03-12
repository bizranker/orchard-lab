package com.usreliance.orchardlab;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@RestController
public class WorkController {

    private final Counter helloCounter;
    private final Counter workSuccessCounter;
    private final Counter errorCounter;
    private final Timer workTimer;

    public WorkController(MeterRegistry registry) {
        this.helloCounter = Counter.builder("orchard_demo_hello_requests_total")
                .description("Total hello endpoint requests")
                .register(registry);

        this.workSuccessCounter = Counter.builder("orchard_demo_work_success_total")
                .description("Total successful work endpoint executions")
                .register(registry);

        this.errorCounter = Counter.builder("orchard_demo_errors_total")
                .description("Total simulated errors")
                .register(registry);

        this.workTimer = Timer.builder("orchard_demo_work_duration_seconds")
                .description("Duration of work endpoint")
                .publishPercentileHistogram()
                .register(registry);
    }

    @GetMapping("/hello")
    public ResponseEntity<Map<String, Object>> hello() {
        helloCounter.increment();
        return ResponseEntity.ok(Map.of(
                "message", "Ave Imperator",
                "service", "orchard-lab-demo",
                "timestamp", Instant.now().toString()
        ));
    }

    @GetMapping("/work")
    public ResponseEntity<Map<String, Object>> work() {
        return ResponseEntity.ok(workTimer.record(() -> {
            int sleepMs = ThreadLocalRandom.current().nextInt(150, 1200);
            try {
                TimeUnit.MILLISECONDS.sleep(sleepMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Work interrupted", e);
            }

            workSuccessCounter.increment();

            return Map.of(
                    "status", "ok",
                    "workDurationMs", sleepMs,
                    "timestamp", Instant.now().toString()
            );
        }));
    }

    @GetMapping("/error")
    public ResponseEntity<Map<String, Object>> error() {
        errorCounter.increment();
        throw new RuntimeException("Simulated application failure for observability testing");
    }
}
