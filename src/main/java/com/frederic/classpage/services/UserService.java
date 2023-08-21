package com.frederic.classpage.services;

import com.frederic.classpage.mappers.UserMapper;
import com.frederic.classpage.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    public boolean authenticateUser(String username, String password) {
        // 获取用户信息
        User user = userMapper.findByUsername(username);
        String encryptedPassword = passwordEncoder.encode(password);

        // 验证用户信息
        if (user != null && user.getPassword().equals(encryptedPassword)) {
            return true; // 验证通过
        }

        return false; // 验证失败
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    public void registerUser(String username, String password, String email, String role) {
        // Check if user already exists
        User existingUser = userMapper.findByUsername(username);
        if (existingUser != null) {
            throw new RuntimeException("Username already exists");
        }

        // Encrypt the password
        String encryptedPassword = passwordEncoder.encode(password);

        // Create a new user
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(encryptedPassword);


        // Insert the user into the database
        userMapper.insertUser(newUser);
    }

    // Other methods...
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

}
