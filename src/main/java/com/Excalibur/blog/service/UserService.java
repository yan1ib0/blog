package com.Excalibur.blog.service;

import com.Excalibur.blog.entity.User;

public interface UserService {

    User login(String name,String password);

}
