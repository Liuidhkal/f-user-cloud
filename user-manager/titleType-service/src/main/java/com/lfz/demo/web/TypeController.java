package com.lfz.demo.web;

import com.lfz.demo.pojo.TitleType;
import com.lfz.demo.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/type")
public class TypeController {
    @Resource
    private TypeService typeService;

    //查询
    @GetMapping("/list")
    public List<TitleType> list(){
        return typeService.list();
    }

}
