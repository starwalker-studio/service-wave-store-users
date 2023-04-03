package com.wavestore.service.users.validation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;

import com.wavestore.service.users.commons.models.entity.User;
import com.wavestore.service.users.constants.Constants.DateFormat;
import com.wavestore.service.users.constants.Constants.ResponseMessages;

public class UserRegisterValidation {

	private static final Logger log = Logger.getLogger(UserRegisterValidation.class);
	private Map<String, Object> map;
	private Date date;
	private SimpleDateFormat todayFormat;

	public UserRegisterValidation() {
		map = new HashMap<>();
		date = new Date();
		todayFormat = new SimpleDateFormat(DateFormat.SIMPLE_DATE_FORMAT);
	}

	public Map<String, Object> setValidUserData(User user) {
		log.info("REGISTER_NEW_USERNAME: " + user.getUsername());
		log.info("DATE: " + todayFormat.format(date));
		map.put("date", todayFormat.format(date));
		map.put("title", "WAVE_STORE_NEW_USER_REGISTRATION");
		user.setRegisterDate(todayFormat.format(date));
		user.setUserPhone("12365");
		user.setImg("---");
		map.put("status", HttpStatus.CREATED.value());
		map.put("message", ResponseMessages.NEW_USER_CREATED);
		map.put("created", true);
		log.info(ResponseMessages.NEW_USER_CREATED);
		return map;
	}

	public Map<String, Object> setInvalidUserData() {
		map.put("status", ResponseMessages.INVALID_NEW_USER_CODE);
		map.put("message", ResponseMessages.INVALID_NEW_USER);
		map.put("created", false);
		log.error(ResponseMessages.INVALID_NEW_USER);
		return map;
	}

}
