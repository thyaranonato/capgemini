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
public class AreaProfissional implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String area;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Talento> talento;
	
	public List<Talento> getTalento() {
		return talento;
	}

	public void setTalento(List<Talento> talento) {
		this.talento = talento;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public AreaProfissional() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AreaProfissional(int id, String area, List<Talento> talento) {
		super();
		this.id = id;
		this.area = area;
		this.talento = talento;
	}

	
	
	
	
}
