package com.frederic.classpage.services;

import com.frederic.classpage.mappers.UserMapper;
import com.frederic.classpage.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAuthenticateUser() {
        String username = "testUser";
        String password = "testPassword";

        User mockUser = new User();
        mockUser.setUsername(username);
        String encryptedPassword = "encryptedPassword";
        mockUser.setPassword(encryptedPassword);

        when(userMapper.findByUsername(username)).thenReturn(mockUser);
        when(passwordEncoder.encode(password)).thenReturn(encryptedPassword);

        boolean result = userService.authenticateUser(username, password);
        assertTrue(result);

        verify(userMapper, times(1)).findByUsername(username);
    }

    @Test
    public void testLoadUserByUsername() {
        String username = "testUser";

        User mockUser = new User();
        mockUser.setUsername(username);
        mockUser.setPassword("mockPassword");

        when(userMapper.findByUsername(username)).thenReturn(mockUser);

        org.springframework.security.core.userdetails.UserDetails userDetails = userService.loadUserByUsername(username);

        assertNotNull(userDetails);
        assertEquals(username, userDetails.getUsername());
        assertEquals(mockUser.getPassword(), userDetails.getPassword());
        assertEquals(1, userDetails.getAuthorities().size());

        verify(userMapper, times(1)).findByUsername(username);
    }

    @Test
    public void testRegisterUser() {
        String username = "newUser";
        String password = "newPassword";
        String email = "new@example.com";

        when(userMapper.findByUsername(username)).thenReturn(null);
        when(passwordEncoder.encode(password)).thenReturn("encryptedPassword");

        assertDoesNotThrow(() -> userService.registerUser(username, password, email,"null"));

        verify(userMapper, times(1)).findByUsername(username);
        verify(passwordEncoder, times(1)).encode(password);
        verify(userMapper, times(1)).insertUser(any(User.class));
    }
}
