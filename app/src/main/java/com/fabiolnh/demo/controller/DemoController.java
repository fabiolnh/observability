package com.fabiolnh.demo.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.annotation.Timed;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class DemoController {

    @GetMapping("/balances/{account_id}")
    public ResponseEntity<String> getBalance(@PathVariable("account_id") String accountId) {

        return ResponseEntity.ok("teste");
    }


}
