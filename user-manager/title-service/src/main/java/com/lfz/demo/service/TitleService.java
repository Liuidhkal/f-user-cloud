package com.lfz.demo.service;

import com.github.pagehelper.PageInfo;
import com.lfz.demo.pojo.Title;

public interface TitleService {
    public PageInfo<Title> findAllPage(Integer page, Integer size);

    //删除
    public void delete(Long id);
}
