package com.wavestore.service.users.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wavestore.service.users.commons.models.entity.User;
import com.wavestore.service.users.constants.Constants.ResponseMessages;
import com.wavestore.service.users.exception.WaveUserException;
import com.wavestore.service.users.service.IUserService;
import com.wavestore.service.users.validation.UserRegisterValidation;

@RestController
public class UserController {

	private static final Logger log = Logger.getLogger(UserController.class);
	private Map<String, Object> map;

	@Autowired
	private IUserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	private UserRegisterValidation userRegisterValidation;

	public UserController() {
		userRegisterValidation = new UserRegisterValidation();
		map = new HashMap<>();
	}

	@RequestMapping(value = "/new-user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> addUser(@RequestBody User user) {
		try {
			userRegister(user);
		} catch (WaveUserException e) {
			log.error(e);
		}
		return map;
	}

	public void userRegister(User user) throws WaveUserException {
		if (userExist(user)) {
			map = userRegisterValidation.setValidUserData(user);
			encryptPassword(user);
			userService.save(user);
		} else {
			map = userRegisterValidation.setInvalidUserData();
			throw new WaveUserException(ResponseMessages.INVALID_NEW_USER_CODE);
		}
	}

	public boolean userExist(User user) {
		return userService.findByUsername(user.getUsername()) == null;
	}

	public void encryptPassword(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	}

}
