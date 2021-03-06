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

import com.aulas.mvc.dao.DaoContato;
import com.aulas.mvc.entidades.Contato;

@Controller
@RequestMapping("/contato")
public class ContatoController {
	
	@GetMapping("/cadastro")
	public String formContato(Model model) {
		model.addAttribute("contato", new Contato());
		
		return "cadastro";
	}
	
	@GetMapping("/consulta")
	public String consultaTodosContatos(Model model) {
		List<Contato> lista = new DaoContato().getAll();
		model.addAttribute("lista", lista);
		
		return "consulta";
	}
	
	@PostMapping("/cadastro")
	public String cadastrarContato(@ModelAttribute Contato contato) {
		if(new DaoContato().salvar(contato)) {
			return "redirect:/contato/consulta";
		}
		return "cadastro";
		
	}
	
	@GetMapping("/consulta/{idcontato}")
	public String consultaContatoPorId(@PathVariable("idcontato") int idcontato, Model model) {
		Contato contato = new DaoContato().getOne(idcontato);

		model.addAttribute("contato", contato);
		return "editaContato";
	}

	/*outra forma de mapear*/
	@RequestMapping(value = "/alterar" , method = RequestMethod.POST)
	public String alterarContato(@ModelAttribute Contato contato) {
		if (new DaoContato().alterar(contato)) {
			return "redirect:/contato/consulta";
		}
		return "editaContato";
	}
	
	@GetMapping("/excluir/{idcontato}")
	public String excluirContato(@PathVariable("idcontato") int idcontato, Model model) {
	    new DaoContato().deletar(idcontato);
		return "redirect:/contato/consulta";
	}
	
}
