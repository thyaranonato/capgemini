package com.aulas.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulas.rest.entity.Contato;
import com.aulas.rest.service.ContatoService;

@RestController
@RequestMapping("/")
public class ContatoController {
	
	@Autowired
	ContatoService service;
	
	@GetMapping("/ola")
	public String ola() {
		return "Ola mundo";
	}
	
	@PostMapping("contato")
	public ResponseEntity<Contato> inserir(@RequestBody Contato contato){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(contato));
	}
	
	@GetMapping("contato/{idcontato}")
	public ResponseEntity<Contato> pesquisar(@PathVariable("idcontato") Long idcontato) {
		return ResponseEntity.status(HttpStatus.OK).body(service.pesquisar(idcontato));
	}
	
	@PutMapping("contato/{idcontato}")
	public ResponseEntity<Contato> alterar(@PathVariable("idcontato") Long idcontato, 
			@RequestBody Contato ct ){
        return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idcontato, ct));
	}
	
	@DeleteMapping("contato/{idcontato}")
	public ResponseEntity<Contato> delete(@PathVariable("idcontato") Long idcontato){
    	service.delete(idcontato);
    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
 
	}
	
	@GetMapping("contato")
	public ResponseEntity<List<Contato>> pesquisarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllC());
	}
	
}
