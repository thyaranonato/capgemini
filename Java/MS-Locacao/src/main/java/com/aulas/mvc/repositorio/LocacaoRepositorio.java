package com.aulas.mvc.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulas.mvc.entidades.Locacao;

@Repository
public interface LocacaoRepositorio extends JpaRepository<Locacao, Long> {

}
