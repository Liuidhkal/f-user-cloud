package com.lxs.demo.web.controller;

import com.github.pagehelper.PageInfo;
import com.lxs.demo.po.User;
import com.lxs.demo.model.ResponseBean;
import com.lxs.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class UserController  {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "hello user-service!";
    }

    @PostMapping("/page")
    @ApiOperation(value="分页查询", notes="分页查询用户")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "page", value = "当前页"),
            @ApiImplicitParam(name = "rows", value = "每页行数"),
    })
    public PageInfo<User> page(
            User user,
            @RequestParam(name = "page", defaultValue = "1", required = false) int page,
            @RequestParam(name = "rows", defaultValue = "10", required = false) int rows) {
        return userService.listPage(user, page, rows);
    }

    /**
     * 添加或者修改
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    @ApiOperation(value="加载用户", notes="根据ID查询")
    public User edit(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/save")
    @ApiOperation(value="保存", notes="ID存在修改，ID不存在添加")
    public ResponseBean save(User user) {
        ResponseBean rm = new ResponseBean();
        try {
            userService.save(user);

            rm.setModel(user);
        } catch (Exception e) {
            e.printStackTrace();
            rm.setSuccess(false);
            rm.setMsg("保存失败");
        }
        return rm;
    }

    /**
     * 删除
     */
    @GetMapping("/delete/{id}")
    @ApiOperation(value="删除", notes="根据ID删除")
    public ResponseBean delete(@PathVariable Integer id)  {
        ResponseBean rm = new ResponseBean();
        try {
            userService.delete(id);
            rm.setModel(null);
        } catch (Exception e) {
            e.printStackTrace();
            rm.setSuccess(false);
            rm.setMsg("保存失败");
        }
        return rm;
    }

    /**
     * 批量删除
     */
    @PostMapping("/delete")
    @ApiOperation(value="删除", notes="批量删除")
    public ResponseBean delete(@RequestParam List<Integer> ids) {
        ResponseBean rm = new ResponseBean();
        try {
            userService.delete(ids);
        } catch (Exception e) {
            e.printStackTrace();
            rm.setMsg("删除失败");
            rm.setSuccess(false);
        }
        return rm;
    }

}
