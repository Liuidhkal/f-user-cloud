package com.lxs.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxs.demo.dao.UserDao;
import com.lxs.demo.po.User;
import com.lxs.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public PageInfo<User> listPage(User b, int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> {
            userDao.select(b);
        });
    }

    @Override
    public List<User> find(User condition) {
        return userDao.selectList(Wrappers.query());
    }

    @Override
    public int add(User user) {
        return userDao.insert(user);
    }

    @Override
    public User findById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public int update(User user) {
        return userDao.updateById(user);
    }

    @Override
    public void save(User user) {
        if (null != user.getUid()) {
            userDao.updateById(user);
        } else {
            userDao.insert(user);
        }
    }

    @Override
    public int delete(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public int delete(List<Integer> ids) {
        return userDao.deleteBatchIds(ids);
    }


}
