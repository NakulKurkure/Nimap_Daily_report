package com.job.serviceInterface;

import com.job.entity.User;

public interface EmailServiceInterface {

	long generateOtp();

	String sendMail(String email, String string, String string2, User user);

	void sendSimpleMessage(String email, String string, String url);

//	String sendSimpleMessage(String email, String string);

	String sendMessage(String email, String string, String job);




}
