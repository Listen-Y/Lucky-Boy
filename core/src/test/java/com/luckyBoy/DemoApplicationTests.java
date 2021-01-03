package com.luckyBoy;

import com.luckyBoy.mapper.UserMapper;
import com.luckyBoy.model.User;
import com.luckyBoy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {

        System.out.println(dataSource.toString());
    }

    @Test
    void setDataSource() {
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }

}
