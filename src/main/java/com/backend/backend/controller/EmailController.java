package com.backend.backend.controller;

import com.backend.backend.entity.EmailRequest;
import com.backend.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest.getEmail(), emailRequest.getSubject(), emailRequest.getText());
        return "Email sent successfully!";
    }
}