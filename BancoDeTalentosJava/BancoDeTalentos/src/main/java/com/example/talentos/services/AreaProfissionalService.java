package com.example.talentos.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.talentos.dto.TalentoDTO;
import com.example.talentos.entidades.AreaProfissional;
import com.example.talentos.entidades.Talento;
import com.example.talentos.repositorys.AreaProfissionalRepositorio;
import com.example.talentos.service.exceptions.RecursoNaoEncontrado;

@Service
public class AreaProfissionalService {
	@Autowired
	AreaProfissionalRepositorio repo;
	
	public List<AreaProfissional> getAll() {
		List<AreaProfissional> area = repo.findAll();
				
		return area;
	}
	
	public AreaProfissional getById(int id) {
		Optional<AreaProfissional> obj = repo.findById(id);
		AreaProfissional area = obj.orElseThrow(() -> new RecursoNaoEncontrado("Talento não encontrado!"));
		
		return area;
	}
	
	public AreaProfissional create(AreaProfissional area) {
		AreaProfissional ar = repo.save(area);
		 return ar;
	}
	
	public AreaProfissional update(int id, AreaProfissional area) {
		Optional<AreaProfissional> obj = repo.findById(id);
		
		AreaProfissional ar = obj.orElseThrow(() -> new RecursoNaoEncontrado("Área não encontrada!"));
		
		ar.setArea(area.getArea());

		ar = repo.save(ar);
		return ar;
	}
	
	public void delete(int id) {
		try {
			repo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontrado("Talento não encontrado!");
		}
	}
}
