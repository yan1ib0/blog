package com.Excalibur.blog.service;

import cn.hutool.crypto.digest.DigestUtil;
import com.Excalibur.blog.dao.UserMapper;
import com.Excalibur.blog.entity.User;
import com.Excalibur.blog.entity.UserExample;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public User login(String name, String password) {

        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        if(StringUtils.isNotBlank(name)){
            criteria.andNameEqualTo(name);
        }
        password=DigestUtil.md5Hex(password);
        if(StringUtils.isNotBlank(password)){
            criteria.andPasswordEqualTo(password);
        }
        List<User> userList =userMapper.selectByExample(userExample);
        if(userList.size()==0) return null;
        User user= userList.get(0);
        return user;


    }
}
