package org.learn2code.seoul.pomodoro.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hector on 1/7/17.
 */

@Controller
public class UserController {

    @RequestMapping("/practice")
    public void practice(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setStatus(200);
        PrintWriter writer = res.getWriter();
        writer.write("<!doctype html><body><h1>Users</h1></body></html>");
    }

}
