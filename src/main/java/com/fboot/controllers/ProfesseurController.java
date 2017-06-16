package com.fboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fboot.entities.Qcm;
import com.fboot.repositories.QcmRepository;

@Controller
@RequestMapping("/professeur")
public class ProfesseurController {

    @Autowired
    private QcmRepository qcmRepo;

    @RequestMapping("")
    public ModelAndView welcome() {
        ModelAndView mav = new ModelAndView("accueilProf");
        return mav;
    }

    @RequestMapping("/addQcm")
    public ModelAndView addQcm() {
        ModelAndView mav = new ModelAndView("addQcm");
        mav.addObject("qcm", new Qcm());
        return mav;
    }

    @RequestMapping(value = "/addQcm", method = RequestMethod.POST)
    public String saveQcm(Qcm qcm) {
        qcmRepo.save(qcm);
        return "redirect:";
    }

}
