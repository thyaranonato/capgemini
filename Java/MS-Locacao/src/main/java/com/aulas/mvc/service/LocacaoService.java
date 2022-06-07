package com.aulas.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulas.mvc.entidades.Locacao;
import com.aulas.mvc.repositorio.LocacaoRepositorio;

@Service
public class LocacaoService {
	@Autowired
	LocacaoRepositorio repositorio;
	
	public List<Locacao> getAll() {
		return repositorio.findAll();
	}
	
	public Locacao save(Locacao locacao) {
		return repositorio.save(locacao);
	}
}
