package com.lfz.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfz.demo.dao.TypeMapper;
import com.lfz.demo.pojo.TitleType;
import com.lfz.demo.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, TitleType> implements TypeService {

    @Resource
    private TypeMapper typeMapper;
}
