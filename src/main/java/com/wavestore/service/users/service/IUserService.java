package com.wavestore.service.users.service;

import java.util.List;

import com.wavestore.service.users.commons.models.entity.User;

public interface IUserService {
	
	public List<User> findAll();
	
	public void save(User user);
	
	public User findByUsername(String username);

}
