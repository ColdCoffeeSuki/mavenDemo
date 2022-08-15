package com.Dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * Select user by username and password
     * @param username
     * @param password
     * @return
     */
    User select (@Param("username") String username, @Param("password") String password);

    /**
     * Select user by username
     * @param username
     * @return
     */
    User selectByUsername(String username);

    /**
     * Add an user
     * @param user
     */
    void add(User user);
}
