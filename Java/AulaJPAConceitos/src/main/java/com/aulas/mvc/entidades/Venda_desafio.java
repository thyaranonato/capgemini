package com.aulas.mvc.entidades;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_venda_desafio")
public class Venda_desafio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "dia_compra")
	private Date data;
	@Transient
	private Cliente_desafio cliente;
	
	public Cliente_desafio getCliente() {
		return cliente;
	}
	public void setCliente(Cliente_desafio cliente) {
		this.cliente = cliente;
	}

	
	public Venda_desafio(int id, Date data, Cliente_desafio cliente) {
		super();
		this.id = id;
		this.data = data;
		this.cliente = cliente;
	}
	public Venda_desafio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
