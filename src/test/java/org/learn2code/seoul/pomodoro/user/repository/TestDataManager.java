package org.learn2code.seoul.pomodoro.user.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDataManager {

	private static final String URL = "jdbc:h2:tcp://localhost/~/test";

	public static void initialize() {
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(URL);
			stmt = conn.createStatement();

			String dropSql = "DROP TABLE IF EXISTS users";
			stmt.executeUpdate(dropSql);

			String createSql = "CREATE TABLE users (\n" +
					"    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
					"    email VARCHAR(100),\n" +
					"    password VARCHAR(255)\n" +
					")";
			stmt.executeUpdate(createSql);

			for (int i = 1; i <= 10; i ++) {
				String email = "user" + i + "@ltcs.com";
				String password = "pass";
				String insertSql = "INSERT INTO users VALUES (null, '" + email + "', '" + password + "')";
				stmt.executeUpdate(insertSql);
			}

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
	}

	public static void cleanUp() {
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection(URL);
			stmt = conn.createStatement();

			String dropSql = "DROP TABLE IF EXISTS users";
			stmt.executeUpdate(dropSql);
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

	}

}
