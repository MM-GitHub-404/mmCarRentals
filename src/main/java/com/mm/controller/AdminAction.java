package com.mm.controller;

import com.mm.dao.CarInfoMapper;
import com.mm.entity.Admin;
import com.mm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 茂茂
 * @create 2022-02-11 16:57
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {

    @Autowired
    AdminService adminService;

    @ExceptionHandler(value = NullPointerException.class)
    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request) {
        //调用业务逻辑层login方法获取用户信息
        Admin admin = adminService.login(name, pwd);
        if (admin != null) {
            //登录成功后获取登录用户名,添加欢迎信息,跳转main界面.
            request.setAttribute("name", admin.getaName());
            return "main";
        }
        //登陆失败后添加错误信息,重回login界面.
        request.setAttribute("errmsg", "<h3 style='color:mediumseagreen'>用户名或密码错误</h3>");
        return "login";
    }
}
