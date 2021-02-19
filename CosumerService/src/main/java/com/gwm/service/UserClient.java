package com.gwm.service;

import com.gwm.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(value="luzhe-service-prod",fallback = FallBackUser.class)
public interface UserClient {


    /**
     * 调用productservice 的controller中的方法
     * 按照admin_id获取用户信息
     * @param admin_id
     * @return
     */
    @GetMapping("/test/getUserInfo/{admin_id}")
    String  getUserInfo(@PathVariable Integer admin_id);


    /**
     * 调用productservice 的controller中的方法
     * 按照admin_id更新用户信息
     * @param user
     * @return
     */
    @PostMapping(value = "/test/update")
    String update(@RequestBody User user);


    /**
     * 调用productservice 的controller中的方法
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/test/saveUser")
    String saveUser(@RequestBody User user);

    /**
     * 按照id删除用户
     * @param admin_id
     * @return
     */
    @GetMapping("/test/delete/{admin_id}")
    String deleteUserById(@PathVariable Integer admin_id);


    @PostMapping(value = "/test/getUser")
    List<User> getUserList(@RequestBody User user);


}
