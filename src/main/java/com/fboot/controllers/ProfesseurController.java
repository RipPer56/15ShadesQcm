package com.fboot.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fboot.entities.Choix;
import com.fboot.entities.Qcm;
import com.fboot.entities.Question;
import com.fboot.repositories.ChoixRepository;
import com.fboot.repositories.ProfesseurRepository;
import com.fboot.repositories.QcmRepository;
import com.fboot.repositories.QuestionRepository;

@Controller
@RequestMapping("/professeur")
public class ProfesseurController {
	
	@Autowired
	private QcmRepository qcmRepo;
	
	@Autowired
	private ChoixRepository choixRepo;
	
	@Autowired
	private ProfesseurRepository profRepo;
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@RequestMapping("/")
    public ModelAndView welcome() {
        ModelAndView mav = new ModelAndView("accueilProf");
        return mav;
    }
	
	@RequestMapping("/addQcm")
    public ModelAndView addQcm() {
        ModelAndView mav = new ModelAndView("addQcm");
        mav.addObject("qcm",new Qcm());
        return mav;
    }
	
	@RequestMapping(value = "/addQcm", method = RequestMethod.POST)
	 public String saveQcm(HttpServletRequest request,Qcm qcm) {
		qcm.setProfesseur(profRepo.findOne((int)request.getSession().getAttribute("userId")));
		qcmRepo.save(qcm);
		return "redirect:";
	}
	
	@RequestMapping("/ajouterQuestions")
	 public ModelAndView ajouterQuestion(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("listeQcm");
		List<Qcm> listes = qcmRepo.findByProfesseurID((int)request.getSession().getAttribute("userId"));
		mav.addObject("listes", listes);
		return mav;
	}
	@RequestMapping("/qcm/{idQcm}")
	 public ModelAndView question(@PathVariable int idQcm) {
		ModelAndView mav = new ModelAndView("ajouterQuestion");
		mav.addObject("idQcm", idQcm);
		return mav;
	}
	@RequestMapping(value = "/addQuestion/{idQcm}", method = RequestMethod.POST)
	 public String saveQuestion(@RequestParam(value = "enonce") String enonce,@RequestParam(value = "choix1") String choix1,@RequestParam(value = "choix2") String choix2,@RequestParam(value = "choix3") String choix3,@PathVariable int idQcm) {
		Question question = new Question();
		question.setEnonce(enonce);
		question.setQcm(qcmRepo.findOne(idQcm));
		questionRepo.save(question);
		
		Choix choix = new Choix();
		choix.setValeur(choix1);
		choix.setCorrecte(true);
		choix.setQuestion(question);
		choixRepo.save(choix);
		Choix choi = new Choix();
		choi.setValeur(choix2);
		choi.setCorrecte(false);
		choi.setQuestion(question);
		choixRepo.save(choi);
		Choix ch = new Choix();
		ch.setValeur(choix3);
		ch.setCorrecte(false);
		ch.setQuestion(question);
		choixRepo.save(ch);
		
		return "redirect:/professeur/qcm/"+question.getQcm().getID();
	}

}
