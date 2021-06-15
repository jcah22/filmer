package com.jcah.controllers;

import com.jcah.entities.Pelicula;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/peli-form")
    public String peliForm(Model model){
        model.addAttribute("pelicula",new Pelicula());
        return "admin/peliForm";
    }

    public String savePeli(){


        return "";
    }
}
