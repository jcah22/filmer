package com.jcah.controllers;

import com.jcah.entities.Pelicula;
import com.jcah.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IPeliculasService peliculasService;


    @GetMapping("/peli-form")
    public String peliForm(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "admin/peliForm";
    }

    @PostMapping("/save-peli")
    public String savePeli(@RequestParam(name = "file") MultipartFile portada, Pelicula peli, RedirectAttributes mensajes) {
        if (!portada.isEmpty()) {
            String ruta = "C://Temp//uploads";
            String nombreUnico = UUID.randomUUID() + " " + portada.getOriginalFilename();

            try {
                byte[] bytes = portada.getBytes();
                Path rutaAbsoluta = Paths.get(ruta + "//" + nombreUnico);
                Files.write(rutaAbsoluta, bytes);
                peli.setPortada(nombreUnico);
                peliculasService.save(peli);
                mensajes.addFlashAttribute("peliculaGurdada", "Pelicula Guardada");


            } catch (Exception e) {
                e.getCause().getMessage();
            }
        }


        return "redirect:/admin/peli-form";
    }
}
