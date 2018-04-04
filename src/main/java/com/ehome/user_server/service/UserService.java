package com.ehome.user_server.service;

import com.ehome.user_server.dao.UserDao;
import com.ehome.user_server.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

/**
 * 此处编写本类功能说明
 * author：SunTianJie
 * create time：2018/3/29 10:56
 */
@Service
public class UserService {

    @Autowired
    public UserDao userDao;

    /***
     * 新增用户信息-主业务逻辑
     * @param user
     */
    @Transactional(rollbackOn = Exception.class)
    public void  addUser(UserInfo user){
        userDao.save(user);
    }

    /***
     * 修改用户信息-主业务逻辑
     * @param user
     */
    @Transactional(rollbackOn = Exception.class)
    public void  updateUser(UserInfo user){
        userDao.saveAndFlush(user);
    }

    /***
     * 删除用户信息-主业务逻辑
     * @param user
     */
    @Transactional(rollbackOn = Exception.class)
    public void  delUser(UserInfo user){
        userDao.delete(user);
    }

    /***
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    @Transactional(rollbackOn = Exception.class)
    public UserInfo  findById(Long id){
        UserInfo userInfo = userDao.findById(id).get();
        return  userInfo;
    }

    /***
     * 分页查询用户信息
     * @param page 数据起始值
     * @param count 每页获取条数
     * @return
     */
    @Transactional(rollbackOn = Exception.class)
    public List<UserInfo> findList(Integer page, Integer count){
        Pageable pageable = new PageRequest(page, count);
        return  userDao.findAll(pageable).getContent();
    }

}
