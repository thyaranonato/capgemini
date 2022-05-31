package com.example.talentos.dto;

import java.util.List;

import javax.persistence.Transient;

import com.example.talentos.entidades.AreaProfissional;
import com.example.talentos.entidades.Talento;

public class TalentoDTO {
	private String nome;
	private String sobrenome;
	private String fone;
	private String email;
	private String profissao;
	private String cidade;
	private String estado;
	private List<AreaProfissional> area;
	
	public TalentoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TalentoDTO(Talento talento) {
		this.nome = talento.getNome();
		this.sobrenome = talento.getSobrenome();
		this.fone = talento.getFone();
		this.email = talento.getEmail();
		this.profissao = talento.getProfissao();
		this.cidade = talento.getCidade();
		this.estado = talento.getEstado();
		this.area = talento.getArea();
	}
	
	public TalentoDTO(String nome, String sobrenome, String fone, String email, String profissao, String cidade,
			String estado, List<AreaProfissional> area) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.fone = fone;
		this.email = email;
		this.profissao = profissao;
		this.cidade = cidade;
		this.estado = estado;
		this.area = area;
	}


	public List<AreaProfissional> getArea() {
		return area;
	}

	public void setArea(List<AreaProfissional> area) {
		this.area = area;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getFone() {
		return fone;
	}
	
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getProfissao() {
		return profissao;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
