package com.trainticket.dao.login;

import com.trainticket.entity.CustomUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author user
 * @Date 2020/12/15 2:48 PM
 * @Version 1.0
 */
@Component
public interface CustomUserDao {
    @Select("select * from custom_user where username = #{username} and deleted = 0")
    CustomUser findCustomByUsername(@Param("username") String s);

    int save(CustomUser user);
}
