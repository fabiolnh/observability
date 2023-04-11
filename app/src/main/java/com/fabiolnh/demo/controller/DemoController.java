package com.fabiolnh.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/balances/{account_id}")
    public ResponseEntity<String> getBalance(@PathVariable("account_id") String accountId) {
        return ResponseEntity.ok("teste");
    }
}
