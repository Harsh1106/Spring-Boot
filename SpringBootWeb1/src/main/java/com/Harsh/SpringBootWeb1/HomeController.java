package com.Harsh.SpringBootWeb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @ModelAttribute("course")
    public String courseName(){
        return "Java";
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

//    servlet way of handling requests
//    @RequestMapping("add")
//    public String add(HttpServletRequest req, HttpSession session){
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int res = num1 + num2;
//        session.setAttribute("res", res);
//        //we have to pass 2 things in session one is name and second is data
//        return "result.jsp";
//    }

//    spring ways of handling request
//    @RequestMapping("add")
//    public String add(@RequestParam("num1") int num, @RequestParam("num2") int num2, Model model){
//        int res = num + num2;
//        model.addAttribute("res", res);
//        return "result";
//    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelAndView mv){
        int res = num1 + num2;
        mv.addObject("res",res);
        mv.setViewName("result"); // it will call view
        return mv;
    }

    @RequestMapping("addAlien")
    public String addAlien(/*@ModelAttribute("alien1")*/ Alien alien){
//ModelAttribute annotation is responsible to assign the value to the alien object
//ModelAttribute is an optional, it is responsible to add data to the alien, so when you don't want to have a different name you can completely skip model attribute.
        return "result";
    }
}
