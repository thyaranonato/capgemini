package com.aulas.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.aulas.rest.entity.Contato;
import com.aulas.rest.service.ContatoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ContatoControllerTest {
	private Long idExistente;
	private Long idInexistente;
	private Contato contatoExistente;
	private Contato contatoNovo;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ContatoService service;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		idExistente = 1L;
		idInexistente = 2L;
		contatoExistente = new Contato(idExistente, "Maria", "maria@gmail.com");
		contatoNovo = new Contato();
		
		// pesquisar por id
		Mockito.when(service.pesquisar(idExistente)).thenReturn(contatoExistente);
		Mockito.when(service.pesquisar(idInexistente)).thenThrow(EntityNotFoundException.class);
		
		// salvar
		Mockito.when(service.salvar(any())).thenReturn(contatoExistente);
		
		// alterar
		Mockito.when(service.alterar(eq(idExistente), any())).thenReturn(contatoExistente);
		Mockito.when(service.alterar(eq(idInexistente), any())).thenThrow(EntityNotFoundException.class);
		
		// deletar por id
		Mockito.doNothing().when(service).delete(idExistente);
		Mockito.doThrow(EntityNotFoundException.class).when(service).delete(idInexistente);
	}
	
	// pesquisar por id
	@Test
	void deveRetornarOkQuandoPesquisaIdExistente() throws Exception {
		ResultActions result =  mockMvc.perform(get("/contato/{idcontato}", idExistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
	}
	
	@Test
	void retornaNotFoundQuandoPesquisaIdInexistente() throws Exception {
		ResultActions result =  mockMvc.perform(get("/contato/{idcontato}", idInexistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
	
	// salvar
	@Test
	void deveRetornarCreatedQndoSalvoComSucesso() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(contatoNovo);
		
		ResultActions result = mockMvc.perform(post("/contato").content(jsonBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
	}
	
	// alterar
	@Test
	void retornaStatus200QndoAlterarComSucesso() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(contatoExistente);
		
		ResultActions result = mockMvc.perform(put("/contato/{idcontato}", idExistente).content(jsonBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
	}
	
	@Test
	void retornaStatus404QndoAlterarContatoInexistente() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(contatoNovo);
		
		ResultActions result = mockMvc.perform(put("/contato/{idcontato}", idInexistente).content(jsonBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
	
	// deletar por id
	@Test
	void deveRetornar204QuandoDeletaIdExistente() throws Exception {
		ResultActions result =  mockMvc.perform(delete("/contato/{idcontato}", idExistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNoContent());
	}
	
	@Test
	void retornaNotFoundQuandoDeletaIdInexistente() throws Exception {
		ResultActions result =  mockMvc.perform(delete("/contato/{idcontato}", idInexistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
}
