package com.dugout.dugoutcore.controller;

import com.dugout.dugoutcore.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/debug")
@Slf4j
public class DebugController {

    @Autowired
    UserService userService;

    @GetMapping("/health")
    public ResponseEntity<?> isHealthy(){
        log.info("Hello World!!");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}