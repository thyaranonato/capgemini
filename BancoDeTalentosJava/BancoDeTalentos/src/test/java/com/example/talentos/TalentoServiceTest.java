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

import com.example.talentos.dto.TalentoDTO;
import com.example.talentos.entidades.Talento;
import com.example.talentos.repositorys.TalentoRepositorio;
import com.example.talentos.service.exceptions.RecursoNaoEncontrado;
import com.example.talentos.services.TalentoService;

@ExtendWith(SpringExtension.class)
public class TalentoServiceTest {
	private int idExistente;
	private int idInexistente;
	private Talento talento;
	private List<Talento> lista;
	
	@InjectMocks
	private TalentoService service;
	
	@Mock
	private TalentoRepositorio repository;
	
	@BeforeEach
	void setup() {
		idExistente = 1;
		idInexistente = 100;
		talento = new Talento();
		lista = new ArrayList<>();
		
		// getAll
		Mockito.when(repository.findAll()).thenReturn(lista);
		
		// create
		Mockito.when(repository.save(talento)).thenReturn(talento);
		//Mockito.doThrow(IllegalArgumentException.class).when(repository).save(talento2);
		
		// delete
		Mockito.doNothing().when(repository).deleteById(idExistente);
		
		// update
				
		// getById
		Mockito.when(repository.findById(idExistente)).thenReturn(Optional.of(talento));
		Mockito.doThrow(RecursoNaoEncontrado.class).when(repository).findById(idInexistente);
	}
	
	// getAll
	@Test
	void retornaListaQuandoConsultaTodos() {
		List<TalentoDTO> list = service.getAll();
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
	
	// getById
	@Test
	void retornaNaoNuloQuandoBuscaIdExistente() {
		Assertions.assertNotNull(service.getById(idExistente));
			
		Mockito.verify(repository).findById(idExistente);
	}
	
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
		TalentoDTO c = service.update(idExistente, talento);
		Assertions.assertNotNull(c);
		Mockito.verify(repository).save(talento);
	}
	
	// create
	@Test
	void retornaTalentoQuandoSalvaComSucesso() {
//		Talento talent = service.create(talento);
//		Assertions.assertEquals(talent, talento);
//		Mockito.verify(repository).save(talento);
		Assertions.assertNotNull(service.create(talento));
		Mockito.verify(repository).save(talento);
	}
	
}
