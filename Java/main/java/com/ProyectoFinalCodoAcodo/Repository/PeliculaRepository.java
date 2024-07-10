package com.ProyectoFinalCodoAcodo.Repository;

import com.ProyectoFinalCodoAcodo.Model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {

    Pelicula findByTituloContainsIgnoreCase(String nombreLibro);

    List<Pelicula> findByIdiomas(String idioma);


    Optional<Pelicula> findByTitulo(String titulo);
}