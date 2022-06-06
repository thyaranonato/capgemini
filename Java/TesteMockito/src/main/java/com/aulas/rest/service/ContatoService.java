package com.aulas.rest.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.aulas.rest.entity.Contato;
import com.aulas.rest.repository.ContatoRepository;

@Service
public class ContatoService {
   @Autowired
   ContatoRepository repository;
	
	public Contato salvar(Contato contato) {
	  return repository.save(contato);
    }
	
	public Contato pesquisar(Long id) {
	   Optional<Contato> obj = repository.findById(id);	
	   Contato ct = obj.orElseThrow(() -> new EntityNotFoundException("Contato inexistente"));
	   return ct;
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);	
		}
		catch(EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("Contato inexistente");
		}
	}
	
	public Contato alterar(Long id, Contato contato) {
		 Optional<Contato> obj = repository.findById(id);	
		 Contato ct = obj.orElseThrow(() -> new EntityNotFoundException("Contato inexistente"));
		
		 ct = contato;
		 
		 return repository.save(ct);
	}
	
	public List<Contato> getAllC() {
		// no caso de crudRepository (contatorepository)
//		Iterable<Contato> contato = repository.findAll();
//		List<Contato> lista = new ArrayList<>();
//		for(Contato ct : contato) {
//			lista.add(ct);
//		}
//		return lista;
		return repository.findAll();
	}
	
}