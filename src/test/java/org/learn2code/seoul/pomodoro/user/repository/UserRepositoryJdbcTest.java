package org.learn2code.seoul.pomodoro.user.repository;

import org.junit.Test;
import org.learn2code.seoul.pomodoro.user.domain.User;

import static org.junit.Assert.assertEquals;

public class UserRepositoryJdbcTest {

	private UserRepositoryJdbc repo = new UserRepositoryJdbc();

	@Test
	public void testFind(){
		User foundUser = repo.find(2L);

		System.out.println(foundUser);

		assertEquals(2L, foundUser.getId().longValue());
		assertEquals("user2@ltcs.com", foundUser.getEmail());
		assertEquals("pass", foundUser.getPassword());
	}

}