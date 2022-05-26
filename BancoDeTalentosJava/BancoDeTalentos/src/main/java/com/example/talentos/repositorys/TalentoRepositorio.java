package com.example.talentos.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.talentos.entidades.Talento;

@Repository
public interface TalentoRepositorio extends JpaRepository<Talento, Integer> {

}
