package com.zdz.dao;

import com.zdz.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by zdz on 16/2/28.
 */
public interface UserDao {
    @Select("select * from user where id = #{id}")
    public User getById(int id);
}
