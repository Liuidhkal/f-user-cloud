package com.lxs.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxs.demo.po.User;

import java.util.List;


public interface UserDao extends BaseMapper<User> {

    public List<User> select(User b);

}
