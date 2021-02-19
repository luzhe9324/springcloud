package com.gwm.controller;

import com.gwm.entity.User;
import com.gwm.service.UserClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/testfeign")
public class UserController {



    @Resource
    private UserClient userClient;

    /**
     * 按照id查看用户信息
     * @param admin_id
     * @return
     */
    @GetMapping(value = "/user/{admin_id}")
    @ResponseBody
    public String user(@RequestBody @PathVariable Integer admin_id){
        //传入id
        String user = this.userClient.getUserInfo(admin_id);
        return "通过feign获得用户信息"+"<br />"+user;
    }

    /**
     * 按照id更新用户信息
     * @param user
     * @return
     */
    @PostMapping("update")
    public String updateUserById(@RequestBody User user){
        String updateUser = this.userClient.update(user);
        return "通过feign更改用户信息"+"<br />"+updateUser;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("add")
    public String saveUser(@RequestBody User user){
        String user1 = this.userClient.saveUser(user);
        return user1+"feign调用,添加用户";
    }


    @GetMapping("delete/{admin_id}")
    public String deleteUser(@PathVariable("admin_id") Integer admin_id){
        String str = this.userClient.deleteUserById(admin_id);
        return str+"<br />"+"feign调用,删除用户";
    }

    @PostMapping(value = "getUserList")
    public String getUserList( User user){

        List<User> userList = this.userClient.getUserList(user);

        return "feign调用,获取用户列表"+"<br />"+userList;
    }





}
