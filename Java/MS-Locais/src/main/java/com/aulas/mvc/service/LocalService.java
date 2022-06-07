package com.aulas.mvc.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulas.mvc.entidades.Local;
import com.aulas.mvc.repositorio.LocalRepositorio;

@Service
public class LocalService {
	@Autowired
	LocalRepositorio repositorio;
	
	public List<Local> getAll() {
		return repositorio.findAll();
	}
	
	public Local getOne(Long id) {
		Optional<Local> obj = repositorio.findById(id);
		
		Local local = obj.orElseThrow(() -> new EntityNotFoundException("Local não existe!"));
		
		return local;
	}
	
	public String reservar(Long idlocal, boolean reservar) {
		Local local = this.getOne(idlocal);
		local.setOcupado(reservar);
		repositorio.save(local);
		String msg = "Reserva realizada com sucesso";
		if(!reservar) {
			msg = "Cancelamento de reserva realizada com sucesso";
		}
		return msg;
	}
}
