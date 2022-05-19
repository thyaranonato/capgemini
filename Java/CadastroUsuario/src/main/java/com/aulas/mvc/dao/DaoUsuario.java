package com.aulas.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aulas.mvc.entidades.Usuario;
import com.aulas.mvc.interfaces.IDAO;
import com.aulas.mvc.utilidades.Conection;

public class DaoUsuario implements IDAO<Usuario> {

	@Override
	public boolean create(Usuario user) {
		String sql = "insert into usuarios(email, senha, perfil) values(?,?,?)";
		Connection con = Conection.conect();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, user.getEmail());
			stm.setString(2, user.getPassword());
			stm.setString(3, user.getPerfil());
			
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conection.closeConnection();
		}
		
		return true;
	}

	@Override
	public Usuario getOne(int id) {
		Usuario us = null;
		
		String sql = "select * from usuarios where id = ?";
		Connection con = Conection.conect();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				us = new Usuario();
				us.setId(rs.getInt("id"));
				us.setEmail(rs.getString("email"));
				us.setPassword(rs.getString("senha"));
				us.setPerfil(rs.getString("perfil"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conection.closeConnection();
		}
		
		return us;
	}

	@Override
	public List<Usuario> getAll() {
		List<Usuario> lista = new ArrayList<Usuario>();
		String sql = "select * from usuarios";
		Connection con = Conection.conect();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Usuario user = new Usuario();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("senha"));
				user.setPerfil(rs.getString("perfil"));
				lista.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conection.closeConnection();
		}
		return lista;
	}

	@Override
	public boolean update(Usuario user) {
		String sql = "update usuarios set email = ?, senha = ?, perfil = ? where id = ?";
		Connection con = Conection.conect();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1, user.getEmail());
			stm.setString(2, user.getPassword());
			stm.setString(3, user.getPerfil());
			stm.setInt(4, user.getId());
			
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conection.closeConnection();
		}
		
		return true;
	}

	@Override
	public boolean delete(int id) {
		Connection con = Conection.conect();
		try {
			PreparedStatement stm = con.prepareStatement("delete from usuarios where id = ?");
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conection.closeConnection();
		}
		
		return true;
	}

}
