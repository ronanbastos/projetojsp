package br.com.aula15.dao;

import br.com.aula15.entidade.Admin;

import java.sql.*;


public class AdminDao extends Dao {
	public Admin consultarLoginSenha(String login, String senha,int nivel) throws SQLException, ClassNotFoundException{
		open();
		String sql = "select * from admin where login = ? and senha = ? and nivel=?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, login);
		stmt.setString(2, senha);
		stmt.setInt(3, nivel);
		
		rs = stmt.executeQuery();
		
		Admin admin = null;
		
		if(rs.next()){
			admin = new Admin(rs.getString("login"), 
							  rs.getString("senha"),
							  rs.getInt("nivel"));			
		}
		close();
		return admin;
	}
}
