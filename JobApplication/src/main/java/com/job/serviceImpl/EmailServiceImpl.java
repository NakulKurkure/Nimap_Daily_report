package com.job.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.job.entity.User;
import com.job.serviceInterface.EmailServiceInterface;

@Service
public class EmailServiceImpl implements EmailServiceInterface{

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public long generateOtp() {
		long min = 100;
		long max = 999;

		long random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return random_int;
		
	}

	@Override
	public String sendMail(String email, String subject, String text, User user) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("noreply@gmail.com");
		simpleMailMessage.setTo(user.getEmail());
		simpleMailMessage.setSubject("Apply sucessfully");
		simpleMailMessage.setText("Text demo");
		javaMailSender.send(simpleMailMessage);
		return "Email Send";
		
	}

	@Override
	public void sendSimpleMessage(String emailTo, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("noreply@gmail.com");
		message.setTo(emailTo);
		message.setSubject(subject);
		message.setText(text);
		javaMailSender.send(message);
		
	}

}
