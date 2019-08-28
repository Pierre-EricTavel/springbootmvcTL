package net.itta.springbootmvc.controllers;

import java.util.List;
import javax.validation.Valid;
import net.itta.springbootmvc.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class RootController {
    
    @Value("${sweethome.message}")
    private String message;
    
    @Autowired
    private List<Personne> people;
    
    @GetMapping("/")
    public String Home(Model model){
        model.addAttribute("message", message);
        return "sweethome";
    }

    
    @GetMapping("/liste")
    public String Liste(Model model){
        model.addAttribute("people", people);
        return "liste";
    }
    
    @GetMapping("/addPersonne")
    public String Addpersonne(Model model){
        if(!model.containsAttribute("personne"))
            model.addAttribute("personne", new Personne(1,"nom","prenom", null));
        return "personne";
    }
    @PostMapping("/AddpersonneToList")
    public String AddpersonneToList(@Validated @ModelAttribute("personne") Personne personne, BindingResult results,Model model ){
        if(results.hasErrors()){
             model.addAttribute("personne",personne);
            return "personne";
        }
        people.add(personne);
        return "redirect:liste";
    }
}
