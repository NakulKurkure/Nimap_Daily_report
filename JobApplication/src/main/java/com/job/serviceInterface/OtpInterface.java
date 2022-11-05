package com.job.serviceInterface;

import com.job.dto.ForgotPasswordRequestDto;
import com.job.dto.OtpDto;
import com.job.entity.OtpEntity;
import com.job.entity.User;

public interface OtpInterface {

	public OtpEntity saveOtp(ForgotPasswordRequestDto otpDto, User user) throws Exception;
}
