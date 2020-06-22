package io.jontesgithub.jswish_microservice.controller;

import io.jontesgithub.jswish_microservice.service.JSwishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSwishController {

    private JSwishService jSwishService;

    @Autowired
    public JSwishController(JSwishService jSwishService) {
        this.jSwishService = jSwishService;
    }

    @GetMapping("/jswish/user")
    public ResponseEntity<String> findPhoneNumber(@RequestParam(name = "phonenumber") String phoneNumber) {
        if (jSwishService.findPhoneNumber(phoneNumber)) return ResponseEntity.ok("Phone number exsits.");

        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Phone number does not exsit.");
    }
}
