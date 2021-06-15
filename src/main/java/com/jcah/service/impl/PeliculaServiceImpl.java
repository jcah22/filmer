package com.jcah.service.impl;

import com.jcah.dao.IPeliculasDAO;
import com.jcah.entities.Pelicula;
import com.jcah.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaServiceImpl  implements IPeliculasService {

    @Autowired
    private IPeliculasDAO peliculasDAO;

    @Override
    public void save(Pelicula pelicula) {

        peliculasDAO.save(pelicula);
    }
}

