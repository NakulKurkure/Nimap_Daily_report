package com.job.serviceInterface;

import com.job.entity.Logger;
import com.job.entity.User;

public interface LoggerServiceInterface {

	void createLogger(Logger logger, User user);

	void logOutUser(String token);

}
