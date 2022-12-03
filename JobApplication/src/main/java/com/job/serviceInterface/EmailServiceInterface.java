package com.job.serviceInterface;

import com.job.entity.OtpEntity;
import com.job.entity.User;

public interface EmailServiceInterface {

	long generateOtp();

	String sendMail(String email, String string, String string2, User user, OtpEntity otpEntity);

	String sendMessage(String email, String text, String job);

	void sendSimpleMessage(String email, String string, String url);

}
