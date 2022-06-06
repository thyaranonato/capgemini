package com.aulas.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.aulas.rest.entity.Contato;
import com.aulas.rest.service.ContatoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ContatoTestIntegration {
	private Long idExistente;
	private Long idInexistente;
	private Contato contatoExistente;
	private Contato contatoNovo;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ContatoService service;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		idExistente = 1L;
		idInexistente = 2L;
		contatoExistente = new Contato(idExistente, "Maria", "maria@gmail.com");
		contatoNovo = new Contato();
	}
	
	// pesquisar por id
	@Test
	 void deveRetornarOkQuandoPesquisaIdExistenteIt() throws Exception {
	    ResultActions result =	mockMvc.perform(get("/contato/{idcontato}", idExistente)
		       .accept(MediaType.APPLICATION_JSON));
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
		contatoNovo.setNome("josefa");
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
