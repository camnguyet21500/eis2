package com.application.zuulproxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    public String homepage() {
        return "home";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; //
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/showUser")
    public String showUser() {
        return "ShowUser";
    }

    @GetMapping("/addUser")
    public String addUser() {
        return "AddUser";
    }

    @GetMapping("/addInvoice")
    public String addInvoice() {
        return "AddInvoice";
    }

    @GetMapping("/showTypeInvoice")
    public String showTypeInvoice() {
        return "ShowTypeInvoice";
    }

    @GetMapping("/addTypeInvoice")
    public String addTypeInvoice() {
        return "AddTypeInvoice";
    }

    @GetMapping("/showCompany")
    public String showCompany() {
        return "ShowCompany";
    }

    @GetMapping("/addCompany")
    public String addCompany() {
        return "AddCompany";
    }

    @GetMapping("/chart")
    public String chart() {
        return "Chart";
    }

}