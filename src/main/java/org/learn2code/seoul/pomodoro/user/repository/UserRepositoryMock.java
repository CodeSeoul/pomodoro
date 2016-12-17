package org.learn2code.seoul.pomodoro.user.repository;

import org.learn2code.seoul.pomodoro.user.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryMock implements UserRepository {

	private long counter = 1;
	private Map<Long, User> mockHashTable = new HashMap<>();

	public UserRepositoryMock() {
		for (int i = 0; i < 10; i++) {
			mockHashTable.put(counter, new User(counter, "user" + counter + "@ltcs.com", "pass"));
			counter++;
		}
	}

	@Override
	public void create(User user) {
		user.setId(counter);
		mockHashTable.put(counter, user);
		counter++;
	}

	@Override
	public void modify(User user, Long id) {
		User foundUser = mockHashTable.get(id);
		foundUser.setEmail(user.getEmail());
		foundUser.setPassword(user.getPassword());
	}

	@Override
	public void remove(Long id) {
		if(!mockHashTable.containsKey(id)){
			throw new RuntimeException("No data");
		}
		mockHashTable.remove(id);
	}

	@Override
	public User find(Long id) {
		if(!mockHashTable.containsKey(id)){
			throw new RuntimeException("No data");
		}
		return mockHashTable.get(id);
	}

	@Override
	public List<User> findAll(){
		if(!mockHashTable.isEmpty()){
			return new ArrayList<>(mockHashTable.values());
		}
		throw new RuntimeException("No data");
	}
}
