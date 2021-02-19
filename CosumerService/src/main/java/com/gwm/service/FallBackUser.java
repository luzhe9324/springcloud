package com.gwm.service;

import com.gwm.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FallBackUser implements UserClient{

        //针对操作的降级处理
        //没有熔断，正常执行
        //如果出现熔断，执行这里的降级方法代码


    @Override
    public String getUserInfo(Integer admin_id) {
      return null;
    }

    @Override
    public String update(User user) {
        return null;
    }

    @Override
    public String saveUser(User user) {
       return null;

    }

    @Override
    public String deleteUserById(Integer id) {

        return null;
    }

    @Override
    public List<User> getUserList(User user) {
        return null;
    }








}
