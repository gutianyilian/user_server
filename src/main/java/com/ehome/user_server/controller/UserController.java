package com.ehome.user_server.controller;

import com.ehome.user_server.Utils.CommonUtils;
import com.ehome.user_server.entity.UserInfo;
import com.ehome.user_server.exception.StatusCode;
import com.ehome.user_server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 此处编写本类功能说明
 * author：SunTianJie
 * create time：2018/3/29 10:43
 */
@RestController
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    /***
     * 新增用户信息接口
     * @param name
     * @return
     */
    @GetMapping("/addUser")
    public Map<String, Object> addUser(String name){
        UserInfo user = new UserInfo();
        user.setName(name);
        userService.addUser(user);
        return CommonUtils.returnDataFormat(StatusCode.CODE_SUCCESS.CODE_VALUE,null);
    }

    /***
     * 修改用户信息接口
     * @param id
     * @param name
     * @return
     */
    @GetMapping("/updateUser")
    public Map<String, Object> addUser(long id,String name){
        UserInfo userInfo= new UserInfo();
        userInfo.setId(id);
        userInfo.setName(name);
        userService.updateUser(userInfo);
        return CommonUtils.returnDataFormat(StatusCode.CODE_SUCCESS.CODE_VALUE,null);
    }

    /***
     * 删除用户信息接口
     * @param id
     * @return
     */
    @GetMapping("/delUser")
    public Map<String, Object> delUser(long id){
        UserInfo userInfo= new UserInfo();
        userInfo.setId(id);
        userService.delUser(userInfo);
        return CommonUtils.returnDataFormat(StatusCode.CODE_SUCCESS.CODE_VALUE,null);
    }

    /***
     * 根据用户ID查询用户信息接口
     * @param id
     * @return
     */
    @GetMapping("/findUserById")
    public Map<String, Object> findUserById(long id){
        UserInfo userInfo= null;
        userInfo = userService.findById(id);
        return CommonUtils.returnDataFormat(StatusCode.CODE_SUCCESS.CODE_VALUE,userInfo);
    }

    /***
     * 普通分页查询用户信息列表
     * @param page
     * @param count
     * @return
     */
    @GetMapping("/findList")
    public Map<String, Object> findList(Integer page, Integer count){
        List<UserInfo> list= null;
        list = userService.findList(page, count);
        return CommonUtils.returnDataFormat(StatusCode.CODE_SUCCESS.CODE_VALUE,list);
    }
}
