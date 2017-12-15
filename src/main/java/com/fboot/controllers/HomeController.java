package com.fboot.controllers;

import com.fboot.entities.Etudiant;
import com.fboot.entities.Professeur;
import com.fboot.repositories.EtudiantRepository;
import com.fboot.repositories.ProfesseurRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	// private final EtudiantRepository etudiantRepository;
	// private final ProfesseurRepository professeurRepository;
	private List<String> logins;
	private List<String> passwords;

	@Autowired
	public HomeController(/*
							 * EtudiantRepository etudiantRepository, ProfesseurRepository
							 * professeurRepository
							 */) {
		// this.etudiantRepository = etudiantRepository;
		// this.professeurRepository = professeurRepository;
		logins = Arrays.asList("bennouna", "balbal");
		passwords = Arrays.asList("1234", "1235");
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

	private String getPassword(int index) {
		return passwords.get(index);
	}

	private String getLogin(int index) {
		return logins.get(index);
	}

	private boolean isCorrectLogin(String login) {
		for (String l : logins) {
			if (l.equals(login))
				return true;
		}
		return false;
	}

	public boolean isCorrectLoginPassword(String login, String password) {
		if (isCorrectLogin(login))
			return logins.indexOf(login) == passwords.indexOf(password);
		return false;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, @RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password) {
		// ModelAndView mav = new ModelAndView("welcome");

		// List<Etudiant> etudiants = etudiantRepository.findByEmail(name);
		// List<Professeur> professeurs = professeurRepository.findByEmail(name);

		if (isCorrectLoginPassword(name, password)) {
			System.out.println("Correct Credentials");
			return new ModelAndView("redirect:/etudiant/");
		}
		System.out.println("Wrong Credentials");
		return new ModelAndView("redirect:/");

		/*
		 * if(etudiants.size()>0){ if(etudiants.get(0).getPassWord().equals(password)){
		 * mav = new ModelAndView("redirect:/etudiant/");
		 * request.getSession().setAttribute("userName",etudiants.get(0).getNom());
		 * request.getSession().setAttribute("userId",etudiants.get(0).getID()); return
		 * mav; } } if(professeurs.size()>0){
		 * if(professeurs.get(0).getPassWord().equals(password)){ mav = new
		 * ModelAndView("redirect:/professeur/");
		 * request.getSession().setAttribute("userName",professeurs.get(0).getNom());
		 * request.getSession().setAttribute("userId",professeurs.get(0).getID());
		 * return mav; } }
		 */

	}

}
