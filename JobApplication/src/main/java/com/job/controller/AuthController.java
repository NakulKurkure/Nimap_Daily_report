package com.job.controller;

import java.util.Calendar;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.dto.AuthRequestDto;
import com.job.dto.AuthResponseDto;
import com.job.dto.AuthSuccessDto;
import com.job.dto.ErrorResponseDto;
import com.job.dto.ForgotPasswordDto;
import com.job.dto.ForgotPasswordRequestDto;
import com.job.dto.SuccessResponseDto;
import com.job.dto.UserDto;
import com.job.entity.Logger;
import com.job.entity.OtpEntity;
import com.job.entity.User;
import com.job.repository.OtpRepository;
import com.job.repository.UserRepository;
import com.job.security.JwtTokenUtil;
import com.job.security.UserDetailService;
import com.job.serviceImpl.OtpServiceImpl;

import com.job.serviceInterface.EmailServiceInterface;
import com.job.serviceInterface.ForgotPassConfirmInterface;
import com.job.serviceInterface.LoggerServiceInterface;
import com.job.serviceInterface.UserServiceInterface;
import com.job.validation.PasswordValidation;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserServiceInterface userServiceInterface;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDetailService userDetailService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private LoggerServiceInterface loggerServiceInterface;

	@Autowired
	private EmailServiceInterface emailServiceInterface;

	@Autowired
	private OtpServiceImpl otpServiceImpl;

	@Autowired
	private OtpRepository otpRepository;

	@Autowired
	private ForgotPassConfirmInterface forgotPassConfirmInterface;

	@PostMapping
	@RequestMapping("/register")
	public ResponseEntity<?> addUsers(@Valid @RequestBody UserDto userDto) {
		String email = userDto.getEmail();
		String password = userDto.getPassword();

		User user = userRepository.findByEmailContainingIgnoreCase(email);

		if (PasswordValidation.isValidforEmail(email)) {
			if (PasswordValidation.isValid(password)) {

				if (user == null) {

					userServiceInterface.addUser(userDto);

					return new ResponseEntity<>(new SuccessResponseDto("Success", "Successfully Added User"),
							HttpStatus.CREATED);

				} else {
					return new ResponseEntity<>(
							new ErrorResponseDto("Alredy present in Database..", "Enter New Email.."),
							HttpStatus.NOT_FOUND);

				}

			} else {

				return new ResponseEntity<>(new ErrorResponseDto("Please Enter Proper format of Password..",
						"Password should be 8 to 30 characters in One Uppercase,One lowercase,One digit and One Unique Symbol..."),
						HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(new ErrorResponseDto("Please Enter Proper format of Email .",
					"Email should be 8 to 30 characters in One Uppercase,One lowercase,One digit and One Unique Symbol..."),
					HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody AuthRequestDto authRequestDto) {

		try {

			User user = userRepository.findByEmailContainingIgnoreCase(authRequestDto.getEmail());

			if (this.userDetailService.comparePassword(authRequestDto.getPassword(), user.getPassword())) {
				User users = this.userRepository.findByEmailContainingIgnoreCase(authRequestDto.getEmail());

				System.out.println("email.." + this.userDetailService.loadUserByUsername(authRequestDto.getEmail()));
				UserDetails userDetails = this.userDetailService.loadUserByUsername(authRequestDto.getEmail());
				System.out.println("userDetails" + userDetails);
				String token = this.jwtTokenUtil.generateToken(userDetails);
				System.out.println("Token" + token);
				AuthResponseDto authResponse = new AuthResponseDto();

				Logger logger = new Logger();
				Calendar calendar = Calendar.getInstance();
				calendar.add(calendar.MINUTE, 5);
				logger.setToken(token);
				logger.setExpireAt(calendar.getTime());
				logger.setUserId(user);

				loggerServiceInterface.createLogger(logger, user);

				authResponse.setToken(token);

				return new ResponseEntity<>(new AuthSuccessDto("Login Successfully", "Successfully", authResponse),
						HttpStatus.ACCEPTED);
			} else {
				throw new Exception("Invalid Username and password..");
			}
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto("Invalid email or Password..", "Invalid.."),
					HttpStatus.NO_CONTENT);
		}

	}

	@Transactional
	@GetMapping("/logout")
	public ResponseEntity<?> logOut(@RequestHeader("Authorization") String token) {

		loggerServiceInterface.logOutUser(token);

		return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully LOgout User"),
				HttpStatus.ACCEPTED);

	}

	@PostMapping("/forgot")
	public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequestDto otpDto) {

		try {

			User user = userRepository.findByEmailContainingIgnoreCase(otpDto.getEmail());

			System.out.println("Email" + user.getEmail());
			final long otp = emailServiceInterface.generateOtp();
			System.out.println("OTP" + otp);
			final String url = "OTP FOR FORGOT PASSWORD IS " + otp;
			System.out.println("URL" + url);

			Calendar calender = Calendar.getInstance();
			calender.add(Calendar.MINUTE, 5);
			System.out.println("URL" + otpDto + user.getEmail());

			User user2 = userRepository.findByEmailContainingIgnoreCase(otpDto.getEmail());
			System.out.println("User" + user2.getEmail());

			OtpEntity entities = new OtpEntity();
			entities.setUserId(user);
			entities.setEmail(otpDto.getEmail());
			entities.setOtp(otp);
			System.out.println("OTP" + otp);
			entities.setExpireAt(calender.getTime());

			otpServiceImpl.saveOtp(otpDto, user, entities);

			String email = otpDto.getEmail();

			OtpEntity otpEntity = otpRepository.findByOtp(otp).orElseThrow();

			System.out.println("OtpEntity" + otpEntity);

			emailServiceInterface.sendMail(user.getEmail(), "OTP ", "Expire within 5 Minutes..", user, otpEntity);

			emailServiceInterface.sendSimpleMessage(user.getEmail(), "subject", url);

			return new ResponseEntity<>(
					new AuthSuccessDto("OTP SEND SUCCESSFULLY...", "Otp send to user Successfully..", user.getEmail()),
					HttpStatus.OK);
//				}
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto("Email Not Found!..", "Please Enter Valid Email!!"),
					HttpStatus.BAD_REQUEST);

		}

	}

	@PostMapping("forgot-password-conf")
	public ResponseEntity<?> forgotPasswordConfirm(@RequestBody ForgotPasswordDto forgotPasswordDto) {

		try {

			if (PasswordValidation.isValid(forgotPasswordDto.getPassword())) {

				if (PasswordValidation.isValid(forgotPasswordDto.getConfirmPassword())) {

					forgotPassConfirmInterface.forgotPasswordConfirm(forgotPasswordDto);

					return new ResponseEntity<>(
							new SuccessResponseDto("Success..", "SuccessFully Passsword Updated ..."),
							HttpStatus.CREATED);
				} else {
					return new ResponseEntity<>(new ErrorResponseDto(
							"Confirm Password should have Minimum 8 and maximum 50 characters, at least one uppercase letter, one lowercase letter, one number and one special character and No White Spaces.",
							"Please Enter Valid Password..."), HttpStatus.CREATED);

				}

			} else {
				return new ResponseEntity<>(new ErrorResponseDto(
						"Password should have Minimum 8 and maximum 50 characters, at least one uppercase letter, one lowercase letter, one number and one special character and No White Spaces.",
						"Please Enter Valid Confirm Password..."), HttpStatus.CREATED);

			}
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), e.getLocalizedMessage()),
					HttpStatus.CREATED);

		}
	}

}
