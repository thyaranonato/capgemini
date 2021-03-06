package com.aulas.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulas.rest.dtos.UsuarioDTO;
import com.aulas.rest.entity.Usuario;
import com.aulas.rest.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService service;
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> salvar(@RequestBody Usuario usuario) {
		UsuarioDTO usuarioDTO = service.salvar(usuario);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
	}

}
