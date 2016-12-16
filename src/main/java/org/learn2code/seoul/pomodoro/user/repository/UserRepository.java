package org.learn2code.seoul.pomodoro.user.repository;

import org.learn2code.seoul.pomodoro.user.domain.User;

import java.util.List;

public interface UserRepository {

	void create(User user);

	void modify(User user, Long id);

	void remove(Long id);

	User find(Long id);

	List<User> findAll();

}
