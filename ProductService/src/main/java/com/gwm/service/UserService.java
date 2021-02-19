package com.gwm.service;

import com.gwm.entity.User;
import com.gwm.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author luzhe
 * @date 2021.2.7
 */
@Service
@MapperScan("com.gwm.mapper")
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 按照id找用户
     * @param admin_id
     * @return
     */
    public User getUserInfo(Integer admin_id) {

        return this.userMapper.selectUserById(admin_id);
    }

    /**
     * 更改用户信息
     * @param user
     * @return
     */
    public int updateUser(User user){
        return userMapper.update(user);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public User saveUser(User user){
        int add = userMapper.add(user);
        return user;

    }

    /**
     * 删除用户
     * @param id
     */
    public int deleteUserById(Integer id){

        return userMapper.deleteUserById(id);
    }

    /**
     * 查看用户列表
     * @param user
     * @return
     */
    public List<User> getUserList(User user){

        return this.userMapper.selectUserList(user);

    }

}
