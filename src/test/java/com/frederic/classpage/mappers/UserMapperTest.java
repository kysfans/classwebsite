package com.frederic.classpage.mappers;

import com.frederic.classpage.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    @Rollback // This is optional, it rolls back the transaction after the test
    public void testInsertAndFindUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("testpassword");
        user.setEmail("Email");

        userMapper.insertUser(user);

        User retrievedUser = userMapper.findByUsername("testuser");
        assertNotNull(retrievedUser);
        assertEquals("testuser", retrievedUser.getUsername());
        assertEquals("testpassword", retrievedUser.getPassword());
        assertEquals("Email", retrievedUser.getEmail());
    }

    @Test
    @Transactional
    @Rollback
    public void testUpdateUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("testpassword");
        user.setEmail("Email");

        userMapper.insertUser(user);

        user.setUsername("updateduser");
        user.setPassword("updatedpassword");
        user.setEmail("updateEmail");

        userMapper.update(user);

        User updatedUser = userMapper.findByUsername("updateduser");
        assertNotNull(updatedUser);
        assertEquals("updateduser", updatedUser.getUsername());
        assertEquals("updatedpassword", updatedUser.getPassword());
        assertEquals("updateEmail",updatedUser.getEmail());
    }

    // Add more test methods for other operations like findById, deleteById, findAll, etc.
}
