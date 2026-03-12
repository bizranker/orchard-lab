package com.usreliance.orchardlab;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class SyntheticWorkService {

    private static final Logger log = LoggerFactory.getLogger(SyntheticWorkService.class);

    private final Counter jobRuns;
    private final Counter jobFailures;
    private final Counter policySyncRuns;
    private final Counter artifactValidationRuns;
    private final Timer jobDuration;
    private final AtomicInteger lastJobDurationMs = new AtomicInteger(0);

    public SyntheticWorkService(MeterRegistry registry) {
        this.jobRuns = Counter.builder("orchard_demo_jobs_total")
                .description("Total scheduled synthetic jobs")
                .register(registry);

        this.jobFailures = Counter.builder("orchard_demo_job_failures_total")
                .description("Total failed scheduled synthetic jobs")
                .register(registry);

        this.policySyncRuns = Counter.builder("orchard_demo_policy_sync_total")
                .description("Total policy sync jobs")
                .register(registry);

        this.artifactValidationRuns = Counter.builder("orchard_demo_artifact_validation_total")
                .description("Total artifact validation jobs")
                .register(registry);

        this.jobDuration = Timer.builder("orchard_demo_job_duration_seconds")
                .description("Duration of scheduled synthetic jobs")
                .publishPercentileHistogram()
                .register(registry);

        Gauge.builder("orchard_demo_last_job_duration_ms", lastJobDurationMs, AtomicInteger::get)
                .description("Last synthetic job duration in milliseconds")
                .register(registry);
    }

    @PostConstruct
    public void init() {
        log.info("SyntheticWorkService initialized");
    }

    @Scheduled(fixedDelay = 5000)
    public void policySyncJob() {
        runSyntheticJob("policy-sync", policySyncRuns);
    }

    @Scheduled(fixedDelay = 9000, initialDelay = 2000)
    public void artifactValidationJob() {
        runSyntheticJob("artifact-validation", artifactValidationRuns);
    }

    private void runSyntheticJob(String jobName, Counter jobSpecificCounter) {
        jobDuration.record(() -> {
            jobRuns.increment();
            jobSpecificCounter.increment();

            int sleepMs = ThreadLocalRandom.current().nextInt(200, 1800);
            boolean fail = ThreadLocalRandom.current().nextInt(10) == 0;

            try {
                log.info("Starting synthetic job: {}", jobName);
                TimeUnit.MILLISECONDS.sleep(sleepMs);
                lastJobDurationMs.set(sleepMs);

                if (fail) {
                    jobFailures.increment();
                    log.warn("Synthetic job {} encountered a simulated failure after {} ms", jobName, sleepMs);
                    throw new RuntimeException("Simulated failure in " + jobName);
                }

                log.info("Synthetic job {} completed successfully in {} ms", jobName, sleepMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                jobFailures.increment();
                log.error("Synthetic job {} interrupted", jobName, e);
            } catch (RuntimeException e) {
                log.error("Synthetic job {} failed", jobName, e);
            }
        });
    }
}
