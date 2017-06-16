package com.fboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping()
    public ModelAndView welcome() {
        ModelAndView mav = new ModelAndView("welcome");
        return mav;
    }

}
