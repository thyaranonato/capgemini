package com.aulas.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aulas.mvc.entidades.Compromisso;
import com.aulas.mvc.entidades.Contato;
import com.aulas.mvc.interfaces.IDAO;
import com.aulas.mvc.utilidades.Conexao;

public class DaoCompromisso implements IDAO<Compromisso> {

	@Override
	public boolean salvar(Compromisso obj) {
		String sql = "insert into compromisso(data, hora, local, idcontato) values(?,?,?,?)";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setDate(1, obj.getData());
			stm.setTime(2, obj.getHora());
			stm.setString(3, obj.getLocal());
			stm.setInt(4, obj.getContato().getId());
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexao.closeConection();
		}
		
		return true;
	}

	@Override
	public Compromisso getOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compromisso> getAll() {
		List<Compromisso> lista = new ArrayList<>();
		Connection con = Conexao.conectar();
		try {
			String sql = "select comp.id as idcompromisso, comp.data, comp.hora, comp.local, ct.id as idcontato, ct.nome, ct.email from compromisso comp, contato ct where comp.idcontato = ct.id";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Contato ct = new Contato(rs.getInt("idcontato"), rs.getString("nome"), rs.getString("email"));
				lista.add(new Compromisso(rs.getInt("idcompromisso"), rs.getDate("data"), rs.getTime("hora"), rs.getString("local"), ct));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Conexao.closeConection();
		}
		return lista;
	}

	@Override
	public boolean alterar(Compromisso obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletar(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<Compromisso> getFilter(String filtro) {
		List<Compromisso> lista = new ArrayList<>();
		Connection con = Conexao.conectar();
		try {
			String sql = "select comp.id as idcompromisso, comp.data, comp.hora, comp.local, ct.id as idcontato, ct.nome, ct.email from compromisso comp, contato ct where comp.idcontato = ct.id and lower(ct.nome) like lower('"+filtro+"%')";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Contato ct = new Contato(rs.getInt("idcontato"), rs.getString("nome"), rs.getString("email"));
				lista.add(new Compromisso(rs.getInt("idcompromisso"), rs.getDate("data"), rs.getTime("hora"), rs.getString("local"), ct));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			Conexao.closeConection();
		}
		return lista;
	}

}
