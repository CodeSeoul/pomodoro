package org.learn2code.seoul.pomodoro.user.controller;

import org.learn2code.seoul.pomodoro.user.domain.User;
import org.learn2code.seoul.pomodoro.user.repository.UserRepository;
import org.learn2code.seoul.pomodoro.user.repository.UserRepositoryMock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by hector on 1/7/17.
 */

@Controller
public class UserController {

	private UserRepository repo = new UserRepositoryMock();

	private Random random = new Random();

	@RequestMapping("/users")
	public String users(Model model) {
		List<User> users = repo.findAll();
		model.addAttribute("users", users);
		return "users";
	}

	@RequestMapping("/users/{id}")
	public String user(Model model, @PathVariable Long id){
		System.out.println("id:" + id);
		User user = repo.find(id);
		model.addAttribute(user);
		return "user";
	}

    @RequestMapping("/practice")
    public void practice(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setStatus(200);
        PrintWriter writer = res.getWriter();
        writer.write("<!doctype html><body><h1>Users</h1></body></html>");
    }

	@RequestMapping("/practice1")
	public String practice1(Model model) throws IOException {
		// model.addAttribute("message", "ABCDE");

		return "test";
	}

	@RequestMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		int rand = random.nextInt(3);
		String message;
		switch (rand) {
			case 0:
				message = "Dale";
				break;
			case 1:
				message = "Ben";
				break;
			case 2:
				message = "Beege";
				break;
			default:
				message = "ZZZZ";
		}
		model.put("message", message);
		return "welcome";
	}


}
