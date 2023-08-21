package com.frederic.classpage.controllers;

import com.frederic.classpage.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoginControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @InjectMocks
    private LoginController loginController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessLoginSuccess() {
        String username = "testUser";
        String password = "testPassword";

        when(userService.authenticateUser(username, password)).thenReturn(true);

        String result = loginController.processLogin(username, password, model);

        assertEquals("redirect:/", result); // 检查是否重定向到首页或其他页面
        verify(userService, times(1)).authenticateUser(username, password);
        verifyNoInteractions(model); // 验证 model 没有被使用
    }

    @Test
    public void testProcessLoginFailure() {
        String username = "testUser";
        String password = "wrongPassword";

        when(userService.authenticateUser(username, password)).thenReturn(false);

        String result = loginController.processLogin(username, password, model);

        assertEquals("login", result); // 检查是否返回登录页面
        verify(userService, times(1)).authenticateUser(username, password);
        verify(model, times(1)).addAttribute(eq("errorMessage"), anyString());
    }
}
