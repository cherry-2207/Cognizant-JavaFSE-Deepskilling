package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        User user = new User();
        user.setName("John");
        userRepository.save(user);
        List<User> users = userRepository.findByName("John");
        assertFalse(users.isEmpty());
        assertEquals("John", users.get(0).getName());
    }
}