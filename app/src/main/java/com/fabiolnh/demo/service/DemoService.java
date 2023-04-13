package com.fabiolnh.demo.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Service
public class DemoService {

    private final AtomicInteger gauge;
    private final Counter counter;
    public DemoService(MeterRegistry meterRegistry) {
        gauge = meterRegistry.gauge("custom_gauge_test", new AtomicInteger(0));
        counter = meterRegistry.counter("custom_counter_test");
    }

    @Scheduled(fixedRateString = "1000", initialDelayString = "0")
    public void scheduling() {
        System.out.println("testing...");
        gauge.set(new Random().nextInt());
        counter.increment();
    }
}
