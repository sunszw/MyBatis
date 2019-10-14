package com.study.mapper;

import com.study.entity.User;
import com.study.entity.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {

    Integer insertUser(User user);

    Integer deleteUserByIds(List<Integer> ids);

    Integer updatePasswordById(@Param("password")String password,@Param("id")Integer id);

    List<User> showUsers(@Param("where") String where,
                         @Param("orderBy") String orderBy,
                         @Param("offset") Integer offSet,
                         @Param("count") Integer count
                         );

    UserVO findUserVOById(Integer id);
}
