package com.aulas.mvc.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulas.mvc.entidades.Local;

@Repository
public interface LocalRepositorio extends JpaRepository<Local, Long> {

}
