package com.example.talentos.controllertest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
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

import com.example.talentos.dto.TalentoDTO;
import com.example.talentos.entidades.Talento;
import com.example.talentos.service.exceptions.RecursoNaoEncontrado;
import com.example.talentos.services.TalentoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class TalentoControllerTest {
	private int idExistente;
	private int idInexistente;
	private TalentoDTO talentoExistente;
	private Talento talentoNovo;
	private List<TalentoDTO> lista;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TalentoService service;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		idExistente = 1;
		idInexistente = 2;
		talentoExistente = new TalentoDTO(idExistente, "Joana", "da Silva", "48999997070", "joana@gmail.com", "Desenvolvedora", "Florianópolis", "SC", null);
		talentoNovo = new Talento();
		lista = new ArrayList<>();
		
		// pesquisar por id
		Mockito.when(service.getById(idExistente)).thenReturn(talentoExistente);
		Mockito.when(service.getById(idInexistente)).thenThrow(RecursoNaoEncontrado.class);
		
		// salvar
		Mockito.when(service.create(any())).thenReturn(talentoExistente);
		
		// alterar
		Mockito.when(service.update(eq(idExistente), any())).thenReturn(talentoExistente);
		Mockito.when(service.update(eq(idInexistente), any())).thenThrow(RecursoNaoEncontrado.class);
		
		// deletar por id
		Mockito.doNothing().when(service).delete(idExistente);
		Mockito.doThrow(RecursoNaoEncontrado.class).when(service).delete(idInexistente);
		
		// getAll
		Mockito.when(service.getAll()).thenReturn(lista);
	}
	
	// pesquisar por id
	@Test
	void deveRetornarOkQuandoPesquisaIdExistente() throws Exception {
		ResultActions result =  mockMvc.perform(get("/talento/{id}", idExistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
	}
	
	@Test
	void retornaNotFoundQuandoPesquisaIdInexistente() throws Exception {
		ResultActions result =  mockMvc.perform(get("/talento/{id}", idInexistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
	
	// salvar
	@Test
	void deveRetornarCreatedQndoSalvoComSucesso() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(talentoNovo);
		
		ResultActions result = mockMvc.perform(post("/talento").content(jsonBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isCreated());
	}
	
	// alterar
	@Test
	void retornaStatus200QndoAlterarComSucesso() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(talentoExistente);
		
		ResultActions result = mockMvc.perform(put("/talento/{id}", idExistente).content(jsonBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
	}
	
	@Test
	void retornaStatus404QndoAlterarContatoInexistente() throws Exception {
		String jsonBody = objectMapper.writeValueAsString(talentoNovo);
		
		ResultActions result = mockMvc.perform(put("/talento/{id}", idInexistente).content(jsonBody).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
	
	// deletar por id
	@Test
	void deveRetornar204QuandoDeletaIdExistente() throws Exception {
		ResultActions result =  mockMvc.perform(delete("/talento/{id}", idExistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNoContent());
	}
	
	@Test
	void retornaNotFoundQuandoDeletaIdInexistente() throws Exception {
		ResultActions result =  mockMvc.perform(delete("/talento/{id}", idInexistente).accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isNotFound());
	}
	
	// getAll
	@Test
	void retornaListaQuandoConsultaTodos() throws Exception {
		ResultActions result =  mockMvc.perform(get("/talento").accept(MediaType.APPLICATION_JSON));
		
		result.andExpect(status().isOk());
	}

}
