package com.example.demo.model;

import lombok.Data;

@Data
public class MailMessage {

	private String sendTo;
	private Message message;
}
