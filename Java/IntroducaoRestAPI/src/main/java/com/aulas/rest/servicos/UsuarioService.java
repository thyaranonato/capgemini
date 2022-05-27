package com.aulas.rest.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulas.rest.dto.UsuarioDTO;
import com.aulas.rest.entidades.Usuario;
import com.aulas.rest.repositorios.UsuarioRepositorio;
import com.aulas.rest.servicos.excecoes.RecursoNaoEncontrado;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepositorio repo;
	
	public List<UsuarioDTO> getAll() {
		List<Usuario> usuarios = repo.findAll();
		
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		
		for(Usuario user : usuarios) {
			usuariosDTO.add(new UsuarioDTO(user));
		}
		
		return usuariosDTO;
	}
	
	public UsuarioDTO salvar(Usuario usuario) {
		 Usuario user = repo.save(usuario);
		 return new UsuarioDTO(user);
	}
	
	public UsuarioDTO getOneById(int id) {
		Optional<Usuario> obj = repo.findById(id);
		Usuario user = obj.orElseThrow(() -> new RecursoNaoEncontrado("Usuário não encontrado!"));
		
		return new UsuarioDTO(user);
	}
	
	public UsuarioDTO update(int id, Usuario usuario) {
		Optional<Usuario> obj = repo.findById(id);
		
		Usuario user = obj.orElseThrow(() -> new RecursoNaoEncontrado("Usuário não encontrado!"));
		
		user.setNome(usuario.getNome());
		user.setEmail(usuario.getEmail());
		user.setSenha(usuario.getSenha());
		user.setPerfil(usuario.getPerfil());
		
		user = repo.save(user);
		return new UsuarioDTO(user);
	}
	
	public void delete(int id) {
		repo.deleteById(id);

	}
}
