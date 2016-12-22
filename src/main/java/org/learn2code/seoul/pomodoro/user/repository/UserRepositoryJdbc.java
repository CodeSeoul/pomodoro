package org.learn2code.seoul.pomodoro.user.repository;

import org.learn2code.seoul.pomodoro.user.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryJdbc implements UserRepository {

	private static final String URL = "jdbc:h2:tcp://localhost/~/test";

	@Override
	public void create(User user) {
		int rows = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(URL);
			stmt = conn.createStatement();
			long id = user.getId();
			String email = user.getEmail();
			String password = user.getPassword();
			String sql = "INSERT INTO users VALUES ('" + id + "', '" + email + "', '"+ "'"
					+ password +"');";
			System.out.println(sql);
			//rows = stmt.executeUpdate("SELECT * FROM users WHERE id ='" + id + "'");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rows != 1) {
			throw new RuntimeException("No data inserted");
		}
	}
	@Override
	public void modify(User user, Long id) {

	}

	@Override
	public void remove(Long id) {

	}

	@Override
	public User find(Long id) {
		User user = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM users WHERE id ='" + id + "'");
			if (rs.next()) {
				String email = rs.getString("email");
				String password = rs.getString("password");
				user = new User(id, email, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (user == null) {
			throw new RuntimeException("No data");
		} else {
			return user;
		}
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM users");
			while (rs.next()) {
				Long id = rs.getLong("id");
				String email = rs.getString("email");
				String password = rs.getString("password");
				User user = new User(id, email, password);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (users == null || users.isEmpty()) {
			throw new RuntimeException("No data");
		} else {
			return users;
		}
	}
}
