package com.luckyBoy;

import com.luckyBoy.model.User;
import com.luckyBoy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-01-02
 * Time: 16:47
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService service;

    @Test
    void add() {
        User user = new User();
        user.setUsername("listen");
        user.setPassword("123");
        System.out.println(service.login(user));
    }

}
