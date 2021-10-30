package com.example.demo.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demo.model.MailMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(MailMessage mailMessage) throws MessagingException{
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo(mailMessage.getSendTo());
		helper.setSubject(mailMessage.getMessage().getSubject());
		helper.setText(mailMessage.getMessage().getMessage());
		javaMailSender.send(msg);
	}

	public void sendEmailWithAttachment(MailMessage mailMessage)
			throws MessagingException, IOException {

		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo(mailMessage.getSendTo());
		helper.setSubject(mailMessage.getMessage().getSubject());
		helper.setText(mailMessage.getMessage().getMessage());

//		helper.addAttachment("add attachment here", bds);
		javaMailSender.send(msg);
	}
}
