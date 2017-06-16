package com.fboot.controllers;

import com.fboot.entities.Etudiant;
import com.fboot.entities.Professeur;
import com.fboot.repositories.EtudiantRepository;
import com.fboot.repositories.ProfesseurRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    private final EtudiantRepository etudiantRepository;
    private final ProfesseurRepository professeurRepository;

    @Autowired
    public HomeController(EtudiantRepository etudiantRepository, ProfesseurRepository professeurRepository) {
        this.etudiantRepository = etudiantRepository;
        this.professeurRepository = professeurRepository;
    }

    @RequestMapping()
    public ModelAndView welcome() {
        ModelAndView mav = new ModelAndView("welcome");
        return mav;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("welcome");
        return mav;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
        ModelAndView mav = new ModelAndView("welcome");

        List<Etudiant> etudiants = etudiantRepository.findByEmail(name);
        List<Professeur> professeurs = professeurRepository.findByEmail(name);
        
        if(etudiants.size()>0){
            if(etudiants.get(0).getPassWord().equals(password)){
                mav = new ModelAndView("redirect:/etudiant");
                return mav;
            }
        }
        if(professeurs.size()>0){
            if(professeurs.get(0).getPassWord().equals(password)){
                mav = new ModelAndView("redirect:/professeur");
                return mav;
            }
        }
        
        mav = new ModelAndView("redirect:/");
        return mav;
    }

}
