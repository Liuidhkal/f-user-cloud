package com.lxs.demo.service;

import com.github.pagehelper.PageInfo;
import com.lxs.demo.po.User;

import java.util.List;

public interface UserService {

    /**
     * 分页查询
     * @param b
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<User> listPage(User b, int pageNum, int pageSize);

    /**
     * 查询
     * @param conditioin 查询条件
     * @return
     */
    public List<User> find(User conditioin);

    /**
     * 添加
     * @param user
     * @return
     */
    public int add(User user);

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    public User findById(Integer id);

    /**
     * 修改
     * @param user
     * @return
     */
    public int update(User user);

    /**
     * 添加修改
     * ID  = null： 添加
     * ID != null： 修改
     * @param user
     */
    public void save(User user);


    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int delete(List<Integer> ids);


}
