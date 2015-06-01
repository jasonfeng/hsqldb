package com.test.hsqldb;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:app-context.xml" })
public class AppTest {
	@Autowired
	private UserService userService;

	@Test
	public void testUserMapper() {
		Assert.assertNotNull(userService.getUser(1));
		Assert.assertEquals("User1", userService.getUser(1).getName());
	}

	@Test
	public void testAddUserMapper() {
		User user = new User();
		user.setId(3);
		user.setName("test");
		userService.add(user);
		userService.updateUser(user);
		userService.delUser(user);
	}
}
