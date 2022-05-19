package com.aulas.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aulas.mvc.dao.DaoUsuario;
import com.aulas.mvc.entidades.Usuario;

@Controller
@RequestMapping("/usuario")

public class UsuarioController {
	@GetMapping("/cadastro")
	public String formUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		
		return "cadastro";
	}
	
	@PostMapping("/cadastro")
	public String createUser(@ModelAttribute Usuario usuario) {
		if(new DaoUsuario().create(usuario)) {
			return "redirect:/usuario/consulta";
		}
		return "cadastro";
		
	}
	
	@GetMapping("/consulta")
	public String getAllUsers(Model model) {
		List<Usuario> lista = new DaoUsuario().getAll();
		model.addAttribute("lista", lista);
		
		return "consulta";
		
	}
	
	@GetMapping("/consulta/{idUsuario}")
	public String getOneUser(@PathVariable("idUsuario") int idUsuario, Model model) {
		Usuario usuario = new DaoUsuario().getOne(idUsuario);
		model.addAttribute("usuario", usuario);
		
		return "editarUsuario";
		
	}
	
	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute Usuario usuario) {
		if (new DaoUsuario().update(usuario)) {
			return "redirect:/usuario/consulta";
		}
		
		return "editarUsuario";
	}
	
	@GetMapping("/deletar/{idUsuario}")
	public String deleteUser(@PathVariable("idUsuario") int idUsuario) {
		new DaoUsuario().delete(idUsuario);
		return "redirect:/usuario/consulta";
	}
}
