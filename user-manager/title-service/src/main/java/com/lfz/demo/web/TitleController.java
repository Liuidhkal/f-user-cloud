package com.lfz.demo.web;

import com.github.pagehelper.PageInfo;
import com.lfz.demo.pojo.Title;
import com.lfz.demo.service.TitleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/title")
public class TitleController {
    @Resource
    private TitleService titleService;

    //分页查询
    @GetMapping("/page")
    public PageInfo<Title> page(
            @RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(name = "rows", defaultValue = "5", required = false) Integer rows
            ){
        PageInfo<Title> pageInfo = titleService.findAllPage(page, rows);

        return pageInfo;
    }

    //根据题目id删除
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        titleService.delete(id);
        return "删除成功";
    }

    //修改
}
