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
import com.example.talentos.entidades.AreaProfissional;
import com.example.talentos.entidades.Talento;
import com.example.talentos.services.AreaProfissionalService;

@RestController
@RequestMapping("/area")
@CrossOrigin
public class AreaProfissionalController {
	@Autowired
	AreaProfissionalService service;
	
	@GetMapping
	public ResponseEntity<List<AreaProfissional>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AreaProfissional> getById(@PathVariable("id") int id) {
		AreaProfissional area = service.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(area);			
	}
	
	@PostMapping
    public ResponseEntity<AreaProfissional> create(@RequestBody AreaProfissional area) {
		AreaProfissional ar = service.create(area);
        return ResponseEntity.status(HttpStatus.CREATED).body(ar);
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<AreaProfissional> update(@PathVariable("id") int id, @RequestBody AreaProfissional area) {
		return ResponseEntity.status(HttpStatus.OK).body(service.update(id, area));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
