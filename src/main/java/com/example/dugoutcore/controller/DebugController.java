package com.example.dugoutcore.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/debug")
@Slf4j
public class DebugController {

    @GetMapping("/")
    public ResponseEntity<?> isHealthy(){
        log.info("Hello World!!");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
