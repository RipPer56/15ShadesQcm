package com.fboot.controllers;

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
import com.fboot.repositories.QcmRepository;
import com.fboot.repositories.QuestionRepository;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {
	
	@Autowired
	private QcmRepository qcmRepo;
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@RequestMapping("/")
    public ModelAndView welcome() {
        ModelAndView mav = new ModelAndView("accueilEtudiant");
        return mav;
    }
	@RequestMapping("/qcm/{type}")
    public ModelAndView choisirType(@PathVariable String type,HttpServletRequest request) {
		request.getSession().setAttribute("score", 0);
		List<Qcm> qcms = qcmRepo.findByType(type);
        ModelAndView mav = new ModelAndView("typeQcm");
        mav.addObject("qcms",qcms);
        mav.addObject("type",type);
        return mav;
    }
	
	@RequestMapping("/qcm/{idQcm}/{n}")
	 public ModelAndView afficherQuestion(@PathVariable int idQcm,@PathVariable int n) {
		ModelAndView mav = new ModelAndView();
		Question question;
		if(questionRepo.findQuestions(idQcm, n).size()>0){
			 question = questionRepo.findQuestions(idQcm, n).get(0);
			 mav = new ModelAndView("question");
			mav.addObject("question",question);
			
		}
		else{
			 mav = new ModelAndView("finQcm");
		}
		
		 return mav;
	}
	
	@RequestMapping(value = "/qcm/{idQcm}/{n}",method = RequestMethod.POST)
	public ModelAndView afficherReponse(HttpServletRequest request,@PathVariable int idQcm,@PathVariable int n,@RequestParam(value = "choix") String choix) {
		ModelAndView mav = new ModelAndView();
		List<Choix> listes;
		Choix correcte=null;
		String s;
		if(questionRepo.findQuestions(idQcm, n).size()>0){
			 listes = questionRepo.findQuestions(idQcm, n).get(0).getChoix();
			 for (Choix choi : listes) {
				if(choi.isCorrecte()) {correcte = choi;break;}
			}
			 mav = new ModelAndView("reponse");
		}
		
		if(correcte.getValeur().equals(choix)) {s="Vous avez raison";int score=(int)request.getSession().getAttribute("score");score++;request.getSession().setAttribute("score", score);}
		else s = "Mauvaise réponse";
		mav.addObject("correcte",correcte);
		mav.addObject("phrase",s);
		return mav;
	}
	
}
