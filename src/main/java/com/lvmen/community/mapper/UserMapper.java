package com.lvmen.community.mapper;

import com.lvmen.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by lvmen on 2019/10/30
 */
@Mapper
public interface UserMapper {

    /**
     * 插入用户
     * @param user
     */
    @Insert("insert into user (name, account_id, token, gmt_create, gmt_modified, avatar_url) values (#{name}, #{accountId}, #{token}, #{gmtCreate}, #{gmtModified}, #{avatarUrl})")
    void insert(User user);

    /**
     * 根据cookie查询用户信息
     * @param cookieValue
     * @return
     */
    @Select("select * from user where token = #{token}")
    User findByToken(String cookieValue);
}
