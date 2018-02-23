package com.wipro.customertool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.customertool.data.User;
import com.wipro.customertool.entity.UserEntity;
import com.wipro.customertool.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;

	public void register(User user) {
		UserEntity entity = new UserEntity();
		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());
		entity.setPassword(user.getPassword());
		entity.setUserName(user.getUserName());
		
		repository.save(entity);
	}

	public User login(User user) {
		List<UserEntity> userEntities = repository.findByUserName(user.getUserName());
		if(userEntities == null || userEntities.size() == 0) {
			return null;
		}
		UserEntity entity = userEntities.get(0);
		if(!entity.getPassword().equals(user.getPassword())) {
			return null;
		}
		return new User().setUserId(entity.getUserId());
	}

}
