package com.lfz.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfz.demo.dao.TitleDao;
import com.lfz.demo.pojo.Title;
import com.lfz.demo.service.TitleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {
    @Resource
    private TitleDao titleDao;

    @Override
    public PageInfo<Title> findAllPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Title> list = titleDao.select();
        PageInfo<Title> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void delete(Long id) {
        titleDao.delete(id);
    }
}
