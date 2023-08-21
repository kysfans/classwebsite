package com.frederic.classpage.controllers;

import com.frederic.classpage.models.User;
import com.frederic.classpage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        User newUser = new User(); // 使用空值或默認值來調用構造函數
        model.addAttribute("user", newUser);
        return "register"; // 返回注册页面的Thymeleaf模板
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        // 验证用户名是否已存在
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null) {
            model.addAttribute("errorMessage", "用户名已存在");
            return "register"; // 返回注册页面并显示错误消息
        }

        // 其他输入验证逻辑，例如密码复杂度、邮箱格式等

        try {
            userService.registerUser(user.getUsername(), user.getPassword(),user.getEmail(), user.getRole());
            model.addAttribute("successMessage", "注册成功，请前往登录页面登录");
            return "register"; // 返回注册页面并显示成功消息
        } catch (Exception e) {
            model.addAttribute("errorMessage", "注册失败，请稍后重试");
            return "register"; // 返回注册页面并显示错误消息
        }
    }
}
