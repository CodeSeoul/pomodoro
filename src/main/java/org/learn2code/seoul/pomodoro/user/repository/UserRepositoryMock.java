package org.learn2code.seoul.pomodoro.user.repository;

import org.learn2code.seoul.pomodoro.user.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryMock implements UserRepository {

	private long counter = 1;
	private List<User> mockTable = new ArrayList<>();

	public UserRepositoryMock() {
		for (int i = 0; i < 10; i++) {
			mockTable.add(new User(counter, "user" + counter + "@ltcs.com", "pass"));
			counter++;
		}
	}

	@Override
	public void create(User user) {
		user.setId(counter);
		counter++;
		mockTable.add(user);
	}

	@Override
	public void modify(User user, Long id) {
		User userToModify = find(id);
		userToModify.setEmail(user.getEmail());
		userToModify.setPassword(user.getPassword());
	}

	@Override
	public void remove(Long id) {
		User userToRemove = find(id);
		mockTable.remove(userToRemove);
	}

	/*
	TODO: We can do better than the linear search which runs in O(n).
	 */
	@Override
	public User find(Long id) {
		for (int i = 0; i < mockTable.size(); i++) {
			System.out.println(mockTable.get(i));
			if(mockTable.get(i).getId().longValue() == id){
				return mockTable.get(i);
			}
		}
		throw new RuntimeException("No data");
	}

	@Override
	public List<User> findAll() {
		if (mockTable.isEmpty()) {
			throw new RuntimeException("No data");
		}
		return mockTable;
	}
}
