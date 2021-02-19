package com.gwm.mapper;


import com.gwm.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luzhe
 * @date 2021.2.7
 */
@Repository
public interface UserMapper {

    /**
     * 按照id查找用户
     * @param id
     * @return
     */
    User selectUserById(@Param("admin_id") Integer admin_id);


    /**
     * 按照id更新用户
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 删除用户
     * @param id
     * @return int类型id
     */
    int deleteUserById(@Param("admin_id") Integer id);

    /**
     * 获取用户列表
     * @param user
     * @return
     */
    List<User> selectUserList(User user);

}
