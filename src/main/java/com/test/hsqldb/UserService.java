package com.test.hsqldb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.hsqldb.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	public User getUser(Integer id) {
		return userMapper.getUser(id);
	}

	public void add(User user) {
		userMapper.addUser(user);
	}

	public void delUser(User user) {
		userMapper.delUser(user);
	}

	public void updateUser(User user) {
		userMapper.updateUser(user);
	}
}
