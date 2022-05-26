package com.example.talentos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.talentos.entidades.AreaProfissional;
import com.example.talentos.services.AreaProfissionalService;

@RestController
@RequestMapping("/area")
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
	
}
