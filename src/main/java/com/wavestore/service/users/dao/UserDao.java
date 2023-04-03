package com.wavestore.service.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.wavestore.service.users.commons.models.entity.User;

@RepositoryRestResource(path = "users")
public interface UserDao extends JpaRepository<User, Integer> {

	@RestResource(path = "search-username")
	public User findByUsername(@Param("user") String username);

}
