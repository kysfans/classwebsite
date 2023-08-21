package com.frederic.classpage.controllers;

import com.frederic.classpage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @PostMapping("/login")
    String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        boolean isAuthenticated = userService.authenticateUser(username, password);

        if (isAuthenticated) {
            // 登录成功，执行你想要的操作，比如设置用户信息到 session
            // ...

            return "redirect:/index.html"; // 重定向到首页或其他页面
        } else {
            model.addAttribute("errorMessage", "用户名或密码错误");
            return "login"; // 登录失败，返回登录页面，并显示错误信息
        }
    }
}
