package br.com.aula9.DAO;

import java.sql.*;

import br.com.aula9.entidade.Cliente;

public class ClienteDao extends Dao{
	public void adicionar(Cliente cliente)throws ClassNotFoundException{
		String sql = "insert into cliente " + "(nome,email,telefone,login,senha,cpf)" + " values (?,?,?,?,?,?)";
		try{
			//chama o método de conexão
			open();
			//tratar a linguagem sql
			stmt=conexao.prepareStatement(sql);
			//setar os valores
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getLogin());
			stmt.setString(5, cliente.getSenha());
			stmt.setString(6, cliente.getCpf());
			
			//executar o sql
			stmt.execute();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
