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
		long min = 10000;
		long max = 99999;

		long random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return random_int;
		
	}

	@Override
	public String sendMail(String email, String subject, String text, User user) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		System.out.println("mail");
		simpleMailMessage.setFrom("nakulkurkure1998@gmail.com");
		simpleMailMessage.setTo(user.getEmail());
		simpleMailMessage.setSubject("Send sucessfully");
		simpleMailMessage.setText("Text demo");
		javaMailSender.send(simpleMailMessage);
		return "Email Send";
		
	}

	@Override
	public void sendSimpleMessage(String emailTo, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("nakulkurkure1998@gmail.com");
		message.setTo(emailTo);
		message.setSubject(subject);
		message.setText(text);
		javaMailSender.send(message);
		
	}

	@Override
	public String sendMessage(String email, String text,String job) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		System.out.println("mail");
		simpleMailMessage.setFrom("nakulkurkure1998@gmail.com");
		simpleMailMessage.setTo(email);
		simpleMailMessage.setSubject("sucessfully Applied To Job"+job);
		simpleMailMessage.setText(text);
		System.out.println("Email shjkshsjsk");
		javaMailSender.send(simpleMailMessage);
		return "Email Send";
		
	}
	
	
}
