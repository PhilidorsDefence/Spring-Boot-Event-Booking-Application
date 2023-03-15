package com.jamesjian.ticketbooking.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    public void testCreateUser() {
        User user = new User(1L, "John Doe", "john.doe@example.com", "password123");
        Assertions.assertEquals(1L, user.getId());
        Assertions.assertEquals("John Doe", user.getName());
        Assertions.assertEquals("john.doe@example.com", user.getEmail());
        Assertions.assertEquals("password123", user.getPassword());
    }

    @Test
    public void testSetEmail() {
        User user = new User(1L, "John Doe", "john.doe@example.com", "password123");
        user.setEmail("jane.doe@example.com");
        Assertions.assertEquals("jane.doe@example.com", user.getEmail());
    }

    @Test
    public void testSetName() {
        User user = new User(1L, "John Doe", "john.doe@example.com", "password123");
        user.setName("Jane Doe");
        Assertions.assertEquals("Jane Doe", user.getName());
    }

    @Test
    public void testSetPassword() {
        User user = new User(1L, "John Doe", "john.doe@example.com", "password123");
        user.setPassword("newpassword");
        Assertions.assertEquals("newpassword", user.getPassword());
    }
}
