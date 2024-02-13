package com.example.dugoutcore.controller;

import com.example.dugoutcore.dto.UserDTO;
import com.example.dugoutcore.service.UserService;
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

    @GetMapping("/")
    public ResponseEntity<?> isHealthy(){
        log.info("Hello World!!");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDTO requestDto) {
        return new ResponseEntity<>(userService.createUser(requestDto), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUer(id), HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO requestDto) {
        return new ResponseEntity<>(userService.updateUser(requestDto), HttpStatus.OK);
    }
}
