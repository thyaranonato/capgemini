package com.aulas.mvc.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
	static Connection con = null;
	
	public static Connection conect() {
		String url = "jdbc:postgresql://ec2-3-224-125-117.compute-1.amazonaws.com:5432/ddepau574rgdlr";
		String user = "rwgbjtxgojbgja";
		String password = "bb0f0a87d845a40861863138ce235cbb99fab08e6ee2713dfaa6820338d60207";
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return con;
	}
	
	public static void closeConnection() {
		con = null;
	}
}
