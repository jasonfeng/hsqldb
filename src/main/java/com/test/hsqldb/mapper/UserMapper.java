package com.test.hsqldb.mapper;

import com.test.hsqldb.HsqldbMapper;
import com.test.hsqldb.User;

public interface UserMapper extends HsqldbMapper {

	User getUser(Integer id);

	void addUser(User user);

	void delUser(User user);

	void updateUser(User user);

}