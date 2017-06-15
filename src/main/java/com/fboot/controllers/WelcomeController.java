package com.fboot.controllers;

import com.fboot.entities.Project;
import com.fboot.repositories.ProjectRepository;
import com.fboot.repositories.UserRepository;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author RipPer
 */
@Controller
@RequestMapping("/project")
public class WelcomeController {
    
    public final ProjectRepository projectRepository;
    public final UserRepository userRepository;
    
    @Autowired
    public WelcomeController(ProjectRepository projectRepository, UserRepository userRepository){
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String greeting(HttpServletRequest request, @RequestParam(value="name", required=true) String name, Model model){
        model.addAttribute("name", name);
        
        request.getSession().setAttribute("name", "Not found!");
        
        try {
            Project project;
            project = projectRepository.find(name).get(0);
            File file = new ClassPathResource(project.getPathP()).getFile();
            //String content = readFile("proj1", Charset.defaultCharset());
            Scanner scanner = new Scanner( file, "UTF-8" );
            String text = scanner.useDelimiter("\\A").next();
            scanner.close();
            System.out.println(file.getPath());
            System.out.println(text);
            request.getSession().setAttribute("name", text);
            
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "web/index";
    }
    
    @GetMapping("/list")
    public String ProjectList(){
        return "web/showProjects";
    }
    
    @RequestMapping(value = "/details" , method = RequestMethod.GET)
    public ModelAndView showDetails(@RequestParam("name") String name){
        ModelAndView mav = new ModelAndView("web/projectDetails");
        mav.addObject("users", userRepository.find(name));
        return mav;
    }
    
    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public String saveProject(@RequestParam("jsontxt") String jsontxt, @RequestParam("projid") String projid) throws IOException{
    File file = new ClassPathResource(projid).getFile();
        FileWriter fstream = new FileWriter(file,false);
        BufferedWriter out = new BufferedWriter(fstream);
        out.write(jsontxt);
        System.out.println(jsontxt);
        out.close();

    return "redirect:/project?name="+projid;
    }
    
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
