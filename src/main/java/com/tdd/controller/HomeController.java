package com.tdd.controller;

import com.google.gson.Gson;
import com.tdd.service.Basic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by TDD on 2017/4/5.
 */
@Controller
public class HomeController {

    @RequestMapping({"/","/home"})
    @ResponseBody
    public void showHomePage(HttpServletRequest req,HttpServletResponse rep) throws IOException {
        String contextPath = req.getContextPath();
        PrintWriter out = rep.getWriter();
        Gson gson = new Gson();
        out.print(gson.toJson(contextPath));
        out.close();
    }
    @RequestMapping("/test")
    @ResponseBody
    public void test(HttpServletRequest req,HttpServletResponse rep) throws IOException {
        String contextPath = req.getContextPath();
        String header = req.getHeader("referer");
        PrintWriter out = rep.getWriter();
        Gson gson = new Gson();
        out.print(gson.toJson(contextPath)+gson.toJson(header));
        out.close();
    }
}
