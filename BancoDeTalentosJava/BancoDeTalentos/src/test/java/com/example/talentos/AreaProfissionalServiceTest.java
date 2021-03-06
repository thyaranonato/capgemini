package com.example.talentos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.talentos.entidades.AreaProfissional;
import com.example.talentos.repositorys.AreaProfissionalRepositorio;
import com.example.talentos.service.exceptions.RecursoNaoEncontrado;
import com.example.talentos.services.AreaProfissionalService;

@ExtendWith(SpringExtension.class)
public class AreaProfissionalServiceTest {
	private int idExistente;
	private int idInexistente;
	private AreaProfissional area;
	private List<AreaProfissional> lista;
	
	@InjectMocks
	private AreaProfissionalService service;
	
	@Mock
	private AreaProfissionalRepositorio repository;
	
	@BeforeEach
	void setup() {
		idExistente = 1;
		idInexistente = 100;
		area = new AreaProfissional();
		lista = new ArrayList<>();
		
		// getAll
		Mockito.when(repository.findAll()).thenReturn(lista);
		
		// create
		Mockito.when(repository.save(area)).thenReturn(area);
		//Mockito.doThrow(IllegalArgumentException.class).when(repository).save(area2);
		
		// delete
		Mockito.doNothing().when(repository).deleteById(idExistente);
		
		// update
		
		
		// getById
		Mockito.when(repository.findById(idExistente)).thenReturn(Optional.of(area));
		Mockito.doThrow(RecursoNaoEncontrado.class).when(repository).findById(idInexistente);
	}
	
	// getAll
	@Test
	void retornaListaQuandoConsultaTodas() {
		List<AreaProfissional> list = service.getAll();
		Assertions.assertNotNull(list);
	}
	
	// delete
	@Test
	void naoFazNadaQuandoDeletaIdExistente() {
		Assertions.assertDoesNotThrow(() -> {
			service.delete(idExistente);
		});
		Mockito.verify(repository, Mockito.times(1)).deleteById(idExistente);
	}
	
	// create
	@Test
	void retornaTalentoQuandoSalvaComSucesso() {
		AreaProfissional ar = service.create(area);
		Assertions.assertEquals(ar, area);
		Mockito.verify(repository).save(area);
	}
	
	// getById
	@Test
	void retornaNaoNuloQuandoBuscaIdExistente() {
		Assertions.assertNotNull(service.getById(idExistente));
			
		Mockito.verify(repository).findById(idExistente);
	}
	
	// getById
	@Test
	void excecaoQuandoProcuraIdInexistente() {
		Assertions.assertThrows(RecursoNaoEncontrado.class, () -> {
			service.getById(idInexistente);
		});
		Mockito.verify(repository).findById(idInexistente);
	}
	
	// update
	@Test
	void retornaContatoQuandoAlteradoComSucesso() {	
		AreaProfissional ar = service.update(idExistente, area);
		Assertions.assertEquals(ar, area);
		Mockito.verify(repository).save(area);
	}
}
