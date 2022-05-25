package com.aulas.rest.controles;

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

import com.aulas.rest.dto.UsuarioDTO;
import com.aulas.rest.entidades.Usuario;
import com.aulas.rest.servicos.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody Usuario usuario) {
        UsuarioDTO user = service.salvar(usuario);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> getOneById(@PathVariable("id") int id) {
		try {
			UsuarioDTO userDTO = service.getOneById(id);
			return ResponseEntity.status(HttpStatus.OK).body(userDTO);			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable("id") int id, @RequestBody Usuario usuario) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, usuario));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UsuarioDTO> delete(@PathVariable("id") int id) {
		try {
			service.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
