package com.aulas.mvc.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulas.mvc.entidades.Locacao;
import com.aulas.mvc.feignclient.LocalFeignClient;
import com.aulas.mvc.repositorio.LocacaoRepositorio;

@Service
public class LocacaoService {
	@Autowired
	LocacaoRepositorio repositorio;
	
	@Autowired
	LocalFeignClient localFeignClient;
	
	public List<Locacao> getAll() {
		return repositorio.findAll();
	}
	
	public Locacao save(Locacao locacao) {
		localFeignClient.reservar(locacao.getLocal(), true);
		return repositorio.save(locacao);
	}
	
	public void cancelar(Long id) {
		Optional<Locacao> obj = repositorio.findById(id);
		Locacao locacao = obj.orElseThrow(() -> new EntityNotFoundException("Locação não encontrada!"));
		localFeignClient.reservar(locacao.getLocal(), false);
		repositorio.delete(locacao);
	}
}
