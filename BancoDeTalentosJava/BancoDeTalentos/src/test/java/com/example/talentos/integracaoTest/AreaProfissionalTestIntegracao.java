package com.example.talentos.integracaoTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.talentos.entidades.AreaProfissional;
import com.example.talentos.services.AreaProfissionalService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class AreaProfissionalTestIntegracao {
	
	private int idExistente;
	private int idInexistente;
	private AreaProfissional area;
	private AreaProfissional areaNova;
	private List<AreaProfissional> lista;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private AreaProfissionalService service;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		idExistente = 2;
		idInexistente = 100;
		area = new AreaProfissional(idExistente, "Medicina");
		areaNova = new AreaProfissional();
		lista = new ArrayList<>();
		
	}
	
	// pesquisar por id
	@Test
	void deveRetornarOkQuandoPesquisaIdExistente() throws Exception {
		ResultActions result =  mockMvc.perform(get("/area/{id}", idExistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
	}
	
	@Test
	void retornaNotFoundQuandoPesquisaIdInexistente() throws Exception {
		ResultActions result =  mockMvc.perform(get("/area/{id}", idInexistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
	
	// salvar
	@Test
	void deveRetornarCreatedQndoSalvoComSucesso() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(area);
		
		ResultActions result = mockMvc.perform(post("/area").content(jsonBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
	}
	
	// alterar
	@Test
	void retornaStatusOKQndoAlterarComSucesso() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(area);
		
		ResultActions result = mockMvc.perform(put("/area/{id}", idExistente).content(jsonBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
	}
	
	@Test
	void retornaStatus404QndoAlterarContatoInexistenteIt() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(areaNova);
		
		ResultActions result = mockMvc.perform(put("/area/{id}", idInexistente).content(jsonBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
	
	// deletar por id
	@Test
	void deveRetornar204QuandoDeletaIdExistenteIt() throws Exception {
		ResultActions result =  mockMvc.perform(delete("/area/{id}", idExistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNoContent());
	}
	
	@Test
	void retornaNotFoundQuandoDeletaIdInexistenteIt() throws Exception {
		ResultActions result =  mockMvc.perform(delete("/area/{id}", idInexistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
	
	// getAll
	@Test
	void retornaListaQuandoConsultaTodosIt() throws Exception {
		ResultActions result =  mockMvc.perform(get("/area").accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
	}
}
