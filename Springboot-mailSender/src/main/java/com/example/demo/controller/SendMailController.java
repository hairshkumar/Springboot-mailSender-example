package com.example.demo.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.MailMessage;
import com.example.demo.service.EmailService;

@Controller
public class SendMailController {

	@Autowired
	private EmailService emailService;

	@GetMapping(path = "/sendmail")
	public ResponseEntity<String> sendMail(@RequestBody MailMessage mailMessage) throws MessagingException {
		System.out.println("Request body "+mailMessage);
		emailService.sendEmail(mailMessage);
		return ResponseEntity.ok().body("Mail sent successfully");
	}
}
