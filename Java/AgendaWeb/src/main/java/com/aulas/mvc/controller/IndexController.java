package com.aulas.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aulas.mvc.entidades.Contato;

@Controller
@RequestMapping("/")
public class IndexController {
	@GetMapping
	public String irIndex(Model model) {
		model.addAttribute("nome", "José da Silva");
		return "index";
	}
	
	@GetMapping("/cadastro")
	public String criarUsuario(Model model) {
		model.addAttribute("contato", new Contato());
		return "cadastro";
		
	}
	
	@PostMapping("/cadastro")
	public String mostrarContatoCadastrado(@ModelAttribute final Contato ct) {
		return "viewContato";
	}
}
