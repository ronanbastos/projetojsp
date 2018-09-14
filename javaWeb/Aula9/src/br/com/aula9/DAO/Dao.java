package br.com.aula9.DAO;

import java.sql.*;

public class Dao {
	protected Connection conexao;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	String url="jdbc:mysql://localhost/lojavirtual";
	String user="root";
	String pass="";
	
	protected void open(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexao=DriverManager.getConnection(url,user,pass);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
