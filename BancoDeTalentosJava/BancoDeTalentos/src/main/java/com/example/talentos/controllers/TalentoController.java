package com.example.talentos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.talentos.dto.TalentoDTO;
import com.example.talentos.entidades.Talento;
import com.example.talentos.services.TalentoService;

@RestController
@RequestMapping("/talento")
@CrossOrigin
public class TalentoController {
	@Autowired
	TalentoService service;
	
	@GetMapping
	public ResponseEntity<List<TalentoDTO>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@PostMapping
    public ResponseEntity<TalentoDTO> create(@RequestBody Talento talento) {
		TalentoDTO talent = service.create(talento);
        return new ResponseEntity<>(talent, HttpStatus.CREATED);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<TalentoDTO> getById(@PathVariable("id") int id) {
		TalentoDTO talentoDTO = service.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(talentoDTO);			
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TalentoDTO> update(@PathVariable("id") int id, @RequestBody Talento talento) {
		return ResponseEntity.status(HttpStatus.OK).body(service.update(id, talento));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		try {
			service.delete(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Talento excluído com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Talento não encontrado!");
		}
	}
	
}
