package com.aulas.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aulas.rest.entity.Contato;
import com.aulas.rest.repository.ContatoRepository;
import com.aulas.rest.service.ContatoService;

@ExtendWith(SpringExtension.class)
public class ContatoServiceTest {
	private Long idExistente;
	private Long idInexistente;
	private Contato contato;
	private Contato contato2;
	private List<Contato> lista;
	
	@InjectMocks
	private ContatoService service;
	
	@Mock
	private ContatoRepository repository;
	
	@BeforeEach
	void setup() {
		idExistente = 1L;
		idInexistente = 100L;
		contato = new Contato();
		lista = new ArrayList<>();
		
		// deletar
		Mockito.doNothing().when(repository).deleteById(idExistente);
		Mockito.doThrow(EmptyResultDataAccessException.class).when(repository).deleteById(idInexistente);
		
		// pesquisar por id
		Mockito.when(repository.findById(idExistente)).thenReturn(Optional.of(contato));
		Mockito.doThrow(EntityNotFoundException.class).when(repository).findById(idInexistente);
		
		// salvar
		Mockito.when(repository.save(contato)).thenReturn(contato);
		Mockito.doThrow(IllegalArgumentException.class).when(repository).save(contato2);
		
		// pesquisar todos
		Mockito.when(repository.findAll()).thenReturn(lista);
		
		// alterar
		// Mockito.doThrow(EntityNotFoundException.class).when(repository).save(contato2);
	}
	
	@Test
	void naoFazNadaQuandoDeletaIdExistente() {
		Assertions.assertDoesNotThrow(() -> {
			service.delete(idExistente);
		});
		Mockito.verify(repository, Mockito.times(1)).deleteById(idExistente);
	}
	
	@Test
	void excecaoQuandoDeletaIdInexistente() {
		Assertions.assertThrows(EntityNotFoundException.class, () -> {
			service.delete(idInexistente);
		});
		Mockito.verify(repository, Mockito.times(1)).deleteById(idInexistente);
	}
	
	@Test
	void retornaNaoNuloQuandoBuscaIdExistente() {
		Assertions.assertNotNull(service.pesquisar(idExistente));
		// Contato c = service.pesquisar(idExistente);
		// Assertions.assertEquals(c, contato);
			
		Mockito.verify(repository).findById(idExistente);
	}
	
	@Test
	void excecaoQuandoProcuraIdInexistente() {
		Assertions.assertThrows(EntityNotFoundException.class, () -> {
			service.pesquisar(idInexistente);
		});
		Mockito.verify(repository).findById(idInexistente);
	}
	
	@Test
	void retornaContatoQuandoSalvaComSucesso() {
		// Assertions.assertNotNull(service.salvar(contato));	
		Contato c = service.salvar(contato);
		Assertions.assertEquals(c, contato);
		Mockito.verify(repository).save(contato);
	}
	
	@Test
	void retornaExcecaoQuandoNaoSalva() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.salvar(contato2);
		});
		Mockito.verify(repository).save(contato2);
	}
	
	@Test
	void retornaContatoQuandoAlteradoComSucesso() {	
		Contato c = service.alterar(idExistente, contato);
		Assertions.assertEquals(c, contato);
		Mockito.verify(repository).save(contato);
	}
	
//	@Test
//	void excecaoQuandoAlteraIdInexistente() {
//		Assertions.assertThrows(EntityNotFoundException.class, () -> {
//			service.alterar(idInexistente, contato2);
//		});
//		Mockito.verify(repository).save(contato2);
//	}
	
	@Test
	void retornaListaQuandoConsultaTodos() {
		List<Contato> list = service.getAllC();
		Assertions.assertNotNull(list);
	}
}
