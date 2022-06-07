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

import com.example.talentos.dto.TalentoDTO;
import com.example.talentos.entidades.Talento;
import com.example.talentos.services.TalentoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class TalentoTestIntegracao {
	
	private int idExistente;
	private int idInexistente;
	private TalentoDTO talentoExistente;
	private Talento talentoNovo;
	private List<Talento> lista;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private TalentoService service;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		idExistente = 3;
		idInexistente = 100;
		talentoExistente = new TalentoDTO(idExistente, "Joana", "da Silva", "48999997070", "joana@gmail.com", "Desenvolvedora", "Florianópolis", "SC", null);
		talentoNovo = new Talento();
		lista = new ArrayList<>();	
	}
	
	// pesquisar por id
	@Test
	void retornaStatusOkQuandoPesquisaTalentoIdExistente() throws Exception {
		ResultActions result =  mockMvc.perform(get("/talento/{id}", idExistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
	}
	
	@Test
	void retornaNotFoundQuandoPesquisaIdInexistenteIt() throws Exception {
		ResultActions result =  mockMvc.perform(get("/talento/{id}", idInexistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
	
	// salvar
	@Test
	void deveRetornarCreatedQndoSalvoComSucessoIt() throws Exception {
		talentoNovo.setNome("Joana");
		String jsonBody = objectMapper.writeValueAsString(talentoNovo);
		
		ResultActions result = mockMvc.perform(post("/talento").content(jsonBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
	}
	
	// alterar
	@Test
	void retornaStatus200QndoAlterarTalentoComSucessoIt() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(talentoExistente);
		
		ResultActions result = mockMvc.perform(put("/talento/{id}", idExistente).content(jsonBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
	}
	
	@Test
	void retornaStatus404QndoAlterarContatoInexistenteIt() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(talentoNovo);
		
		ResultActions result = mockMvc.perform(put("/talento/{id}", idInexistente).content(jsonBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
	
	// deletar por id
	@Test
	void deveRetornar204QuandoDeletaIdExistenteIt() throws Exception {
		ResultActions result =  mockMvc.perform(delete("/talento/{id}", idExistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNoContent());
	}
	
	@Test
	void retornaNotFoundQuandoDeletaIdInexistenteIt() throws Exception {
		ResultActions result =  mockMvc.perform(delete("/talento/{id}", idInexistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
	
	// getAll
	@Test
	void retornaListaQuandoConsultaTodosIt() throws Exception {
		ResultActions result =  mockMvc.perform(get("/talento").accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
	}
}
