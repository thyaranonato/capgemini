package com.example.talentos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.talentos.dto.TalentoDTO;
import com.example.talentos.entidades.Talento;
import com.example.talentos.repositorys.TalentoRepositorio;
import com.example.talentos.service.exceptions.RecursoNaoEncontrado;

@Service
public class TalentoService {
	@Autowired
	TalentoRepositorio repo;
	
	public List<TalentoDTO> getAll() {
		List<Talento> talentos = repo.findAll();
		
		List <TalentoDTO> talentosDTO = new ArrayList<>();
		
		for(Talento talent : talentos) {
			talentosDTO.add(new TalentoDTO(talent));
		}
		
		return talentosDTO;
	}
	
	public TalentoDTO create(Talento talento) {
		 Talento talent = repo.save(talento);
		 return new TalentoDTO(talent);
	}
	
	public TalentoDTO getById(int id) {
		Optional<Talento> obj = repo.findById(id);
		Talento talent = obj.orElseThrow(() -> new RecursoNaoEncontrado("Talento não encontrado!"));
		
		return new TalentoDTO(talent);
	}
	
	public TalentoDTO update(int id, Talento talento) {
		Optional<Talento> obj = repo.findById(id);
		
		Talento talent = obj.orElseThrow(() -> new RecursoNaoEncontrado("Talento não encontrado!"));
		
		talent.setNome(talento.getNome());
		talent.setSobrenome(talento.getSobrenome());
		talent.setFone(talento.getFone());
		talent.setEmail(talento.getEmail());
		talent.setPassword(talento.getPassword());
		talent.setProfissao(talento.getProfissao());
		talent.setEstado(talento.getEstado());
		talent.setCidade(talento.getCidade());
		talent.setPerfil(talento.getPerfil());
		talent.setArea(talento.getArea());
		
		talent = repo.save(talent);
		return new TalentoDTO(talent);
	}
	
	public void delete(int id) {
		try {
			repo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontrado("Talento não encontrado!");
		}
	}

}
