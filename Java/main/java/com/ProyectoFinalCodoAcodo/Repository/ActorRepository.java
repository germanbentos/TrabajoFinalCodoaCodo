package com.ProyectoFinalCodoAcodo.Repository;

import com.ProyectoFinalCodoAcodo.Model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    Optional<Actor> findByNombreContainsIgnoreCase(String nombre);

    @Query("SELECT s FROM Autor s WHERE s.fechaNacimiento <= :fecha AND s.fechaMuerte >= :fecha")
    List<Actor> autorVivoEnCiertoAnio(@Param("fecha") Long fecha);
}
