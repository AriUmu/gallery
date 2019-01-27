package com.example.gallery.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

  @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
  public ModelAndView index(){
    System.out.println("Looking in the index controller.........");
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("index");
    return modelAndView;
  }

//  @RequestMapping("/hello")
//  public String hello() {
//    return "index";
//  }
}
