package com.jcah.dao;

import com.jcah.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeliculasDAO extends JpaRepository<Pelicula,Long> {


}
