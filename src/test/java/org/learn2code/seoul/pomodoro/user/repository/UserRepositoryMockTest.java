package org.learn2code.seoul.pomodoro.user.repository;

import org.junit.Test;
import org.learn2code.seoul.pomodoro.user.domain.User;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UserRepositoryMockTest {

	private UserRepositoryMock repo = new UserRepositoryMock();

	@Test
	public void testCreate() {
		User user1 = new User("ben@ltcs.com", "pass");
		repo.create(user1);

		User foundUser = repo.find(user1.getId());

		System.out.println(foundUser);

		assertEquals(11L, foundUser.getId().longValue());
		assertEquals(user1.getEmail(), foundUser.getEmail());
		assertEquals(user1.getPassword(), foundUser.getPassword());
	}

	@Test
	public void testFindAll() {
		List<User> userList = repo.findAll();
		System.out.println(userList);
		assertEquals(10, userList.size());

		User user5 = userList.get(5);
		assertEquals(6L, user5.getId().longValue());
		assertEquals("user6@ltcs.com", user5.getEmail());
		assertEquals("pass", user5.getPassword());
	}

	@Test
	public void testFind(){
		User foundUser = repo.find(2L);
		System.out.println(foundUser);
		assertEquals(2L, foundUser.getId().longValue());
		assertEquals("user2@ltcs.com", foundUser.getEmail());
		assertEquals("pass", foundUser.getPassword());
	}

	@Test
	public void testFindAbnormal(){
		try {
			repo.find(2000L);
			fail();
		} catch (Exception e) {
			System.out.println(e);
			assertEquals("No data", e.getMessage());
		}
	}

	@Test
	public void testRemove() {
		repo.find(7L);

		repo.remove(7L);

		try {
			repo.find(7L);
			fail();
		} catch (Exception e) {
			System.out.println(e);
			assertEquals("No data", e.getMessage());
		}
	}

	@Test
	public void testModify() {
		User modifiedUser = new User("dale@ltcs.com", "pass");
		repo.modify(modifiedUser, 4L);

		User foundUser = repo.find(4L);

		assertEquals(4L, foundUser.getId().longValue());
		assertEquals("dale@ltcs.com", foundUser.getEmail());
		assertEquals("pass", foundUser.getPassword());
	}


}