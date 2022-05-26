package com.example.talentos.entidades;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Talento implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String sobrenome;
	private String fone;
	private String email;
	private String password;
	private String profissao;
	private String cidade;
	private String estado;
	private String perfil;
	
	@OneToMany(mappedBy = "talento", fetch = FetchType.EAGER)
	private List<AreaProfissional> area;
	
	public List<AreaProfissional> getArea() {
		return area;
	}

	public void setArea(List<AreaProfissional> area) {
		this.area = area;
	}
	
	public Talento(int id, String nome, String sobrenome, String fone, String email, String password, String profissao,
			String cidade, String estado, String perfil, List<AreaProfissional> area) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.fone = fone;
		this.email = email;
		this.password = password;
		this.profissao = profissao;
		this.cidade = cidade;
		this.estado = estado;
		this.perfil = perfil;
		this.area = area;
	}

	public Talento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
	public String getPerfil() {
		return perfil;
	}
	
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
	
}
