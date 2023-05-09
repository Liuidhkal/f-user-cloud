package com.lxs.demo.web.controller;

import com.lxs.demo.po.Dept;
import com.lxs.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/list")
    public List<Dept> list() {
        return deptService.list();
    }

    //这个是测试练习的方法
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
