package com.backend.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    private static final String CONSTANT_EMAIL = "tostudybuddyss2025@gmail.com"; 

    public void sendEmail(String email, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(CONSTANT_EMAIL); 
        message.setSubject(subject);

        // Combine the email, subject, and text into the message body
        String fullMessage = "Email: " + email + "\n\n" + text;
        message.setText(fullMessage);

        mailSender.send(message);
    }
}