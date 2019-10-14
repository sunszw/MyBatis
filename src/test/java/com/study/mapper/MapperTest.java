package com.study.mapper;

import com.alibaba.druid.pool.DruidDataSource;
import com.study.entity.DeptVO;
import com.study.entity.User;
import com.study.entity.UserVO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MapperTest {

    private ClassPathXmlApplicationContext classPathXmlApplicationContext;
    private UserMapper userMapper;
    private DeptMapper deptMapper;

    @Before
    public void init() {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        userMapper = classPathXmlApplicationContext.getBean("userMapper", UserMapper.class);
        deptMapper= classPathXmlApplicationContext.getBean("deptMapper",DeptMapper.class);
    }

    @After
    public void destroy() {
        classPathXmlApplicationContext.close();
    }

    @Test
    public void testConnection() throws SQLException {
        DruidDataSource dataSource = classPathXmlApplicationContext.getBean("dataSource", DruidDataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("cvbx");
        user.setPassword("1234");
        Integer rows = userMapper.insertUser(user);
        System.out.println("rows=" + rows);
    }

    @Test
    public void testDeleteUserByIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(10);
        ids.add(11);
        ids.add(12);
        Integer rows = userMapper.deleteUserByIds(ids);
        System.out.println("rows=" + rows);
    }

    @Test
    public void testUpdatePasswordById() {
        Integer rows = userMapper.updatePasswordById("asdasd", 9);
        System.out.println("rows=" + rows);
    }

    @Test
    public void testShowUsers() {
        List<User> users = userMapper.showUsers("username='盲僧'", "id", 0, 10);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserVOById(){
        UserVO userVO=userMapper.findUserVOById(6);
        System.out.println(userVO);
    }

    @Test
    public void testFindVOById(){
        DeptVO deptVO=deptMapper.findVOById(1);
        System.out.println(deptVO);
    }


}
