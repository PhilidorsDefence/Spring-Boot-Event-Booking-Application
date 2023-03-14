package com.jamesjian.ticketbooking.User;

import com.jamesjian.ticketbooking.exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void createUserTest() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");

        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.createUser(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getName()).isEqualTo("John Doe");
        assertThat(savedUser.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(savedUser.getPassword()).isEqualTo("password123");
    }

    @Test
    public void getAllUsersTest() {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        //user1.setId(1L);
        user1.setName("John Doe");
        user1.setEmail("john.doe@example.com");
        user1.setPassword("password123");
        userList.add(user1);

        User user2 = new User();
        //user2.setId(2L);
        user2.setName("Jane Doe");
        user2.setEmail("jane.doe@example.com");
        user2.setPassword("password456");
        userList.add(user2);

        when(userRepository.findAll()).thenReturn(userList);

        List<User> returnedUserList = userService.getAllUsers();

        assertThat(returnedUserList).hasSize(2);
        assertThat(returnedUserList.get(0).getName()).isEqualTo("John Doe");
        assertThat(returnedUserList.get(0).getEmail()).isEqualTo("john.doe@example.com");
        assertThat(returnedUserList.get(0).getPassword()).isEqualTo("password123");
        assertThat(returnedUserList.get(1).getName()).isEqualTo("Jane Doe");
        assertThat(returnedUserList.get(1).getEmail()).isEqualTo("jane.doe@example.com");
        assertThat(returnedUserList.get(1).getPassword()).isEqualTo("password456");
    }

    @Test
    public void getUserByIdTest() {
        User user = new User();
        //user.setId(1L);
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User returnedUser = userService.getUserById(1L);

        assertThat(returnedUser).isNotNull();
        assertThat(returnedUser.getName()).isEqualTo("John Doe");
        assertThat(returnedUser.getEmail()).isEqualTo("john.doe@example.com");
        assertThat(returnedUser.getPassword()).isEqualTo("password123");
    }

    @Test
    void testGetUserByIdWithInvalidId() {
        Long invalidId = 123L;
        assertThrows(UserNotFoundException.class, () -> userService.getUserById(invalidId));
    }


}
