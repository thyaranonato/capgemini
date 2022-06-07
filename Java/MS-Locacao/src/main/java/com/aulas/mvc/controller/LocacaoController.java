package com.aulas.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulas.mvc.entidades.Locacao;
import com.aulas.mvc.service.LocacaoService;

@RestController
@RequestMapping("/")
public class LocacaoController {
	@Autowired
	LocacaoService service;
	
	@GetMapping("/locacao")
	public ResponseEntity<List<Locacao>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}
	
	@PostMapping("/locacao")
	public ResponseEntity<Locacao> save(@RequestBody Locacao locacao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(locacao));
		
	}
	
	@DeleteMapping("/locacao/{id}")
	public ResponseEntity<Void> cancelar(@PathVariable("id") Long id) {
		service.cancelar(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
}
