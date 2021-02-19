package com.gwm.controller;

import com.gwm.entity.User;
import com.gwm.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author luzhe
 * @date 2021.2.7
 */
@Api(value="用户controller",tags={"用户操作接口"})
@RestController
@RequestMapping("/test")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("按照id获取用户信息")
    @GetMapping("/getUserInfo/{admin_id}")
    public String getUserInfo(@RequestBody @ApiParam(name = "admin_id", value = "admin_id", required = true) @PathVariable Integer admin_id) {

        return userService.getUserInfo(admin_id).toString();

    }


    @PostMapping(value = "/update")
    @ApiOperation(value = "根据id更新用户信息", httpMethod = "POST")
    public String update(@RequestBody @ApiParam(name = "user", value = "用户", example = "") User user) {
        int result = userService.updateUser(user);
        if (result >= 1) {
            return "员工修改成功！";
        } else {
            return "员工修改失败！";
        }
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ApiOperation(value="添加用户信息",httpMethod = "POST")
    @PostMapping("/saveUser")
    public User saveUser(@RequestBody @ApiParam(name = "user", value = "json fromat", required = true) User user) {
        if (user.getAdmin_name() !=null){

            System.out.println("添加成功");
        }
        else{
            System.out.println("添加异常");
        }
       return userService.saveUser(user);

    }


    @ApiOperation(value = "删除用户信息")
    @GetMapping("delete/{id}")
    public String deleteUserById(@ApiParam(name = "id",value = "用户id",required = true) @PathVariable Integer id){

        int num = this.userService.deleteUserById(id);
        if(num >=1){
            return "删除成功";
        }
        else{

            return "用户不存在,或已删除";
        }



    }

    /**
     * 获取用户列表
     * @param user
     * @return
     */
    @ApiOperation("获取用户列表")
    @PostMapping(value = "getUser")
    public List<User> getUserList( @ApiParam(name = "user用户",value = "json") User user){
        return this.userService.getUserList(user);
    }


}