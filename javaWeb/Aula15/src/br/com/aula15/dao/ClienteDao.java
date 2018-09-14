package br.com.aula15.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aula15.entidade.Cliente;
public class ClienteDao extends Dao {
	
	public void adicionar(Cliente cliente) throws ClassNotFoundException {
		String sql = "insert into cliente " + "(nome,email,telefone,login,senha,cpf)" + " values (?,?,?,?,?,?)";
		String sql1="insert into admin" +"(nome,login,senha)" + " values (?,?,?)";

		try {
			// prepared statement para inserção
			open();
			stmt = con.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getLogin());
			stmt.setString(5, cliente.getSenha());
			stmt.setString(6, cliente.getCpf());
			
			stmt2 = con.prepareStatement(sql1);
			stmt2.setString(1, cliente.getNome());
			stmt2.setString(2, cliente.getLogin());
			stmt2.setString(3, cliente.getSenha());
			

			// executa
			stmt.execute();
			stmt2.execute();
			close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Cliente> listarCliente(String cpf) throws ClassNotFoundException, SQLException {

		open();

		stmt = this.con.prepareStatement("select * from cliente where cpf = ?");
		stmt.setString(1, cpf);

		rs = stmt.executeQuery();
		List<Cliente> clientes = new ArrayList<Cliente>();

		while (rs.next()) {			// criando o objeto Cliente
			Cliente cliente = new Cliente();
			cliente.setIdcliente(rs.getInt("idcliente"));
			cliente.setNome(rs.getString("nome"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setEmail(rs.getString("email"));
			cliente.setLogin(rs.getString("login"));
			cliente.setSenha(rs.getString("senha"));
			cliente.setCpf(rs.getString("cpf"));

			// adicionando o objeto à lista
			clientes.add(cliente);
		}
		
		return clientes;

	}
	
	//buscar cliente por CPF
	
	public Cliente buscarCliente(String cpf) throws SQLException, ClassNotFoundException {

		open();
		String sql = "SELECT * FROM cliente WHERE cpf  = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, cpf);
		Cliente cliente = null;
		rs = stmt.executeQuery();

		if (rs.next()) {
			cliente = new Cliente(rs.getInt("idciente"), rs.getString("nome"), rs.getString("email"),
					rs.getString("telefone"),rs.getString("login"), rs.getString("senha"), rs.getString("cpf"));
		}
		//close();
		return cliente;

	}
	public void editar(Cliente cliente) throws ClassNotFoundException {
		String sql = "update cliente set nome=?, email=?, telefone=?, login=?, senha=? where cpf=?";

		try {
			open();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getLogin());
			stmt.setString(5, cliente.getSenha());
			stmt.setString(6, cliente.getCpf());
			//stmt.setLong(6, cliente.getIdcliente());

			stmt.execute();
			close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void excluir(Cliente cliente) throws ClassNotFoundException {

		try {
			open();
			stmt = con.prepareStatement("delete from cliente where cpf=?");
			stmt.setString(1, cliente.getCpf());
			stmt.execute();
			close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Cliente login(String login, String senha, int nivel) throws SQLException, ClassNotFoundException {
		open();
		String sql = "SELECT login, senha FROM cliente WHERE login = ? AND senha = ?";
		stmt = con.prepareStatement(sql);

		stmt.setString(1, login);
		stmt.setString(2, senha);

		rs = stmt.executeQuery();
		Cliente cliente = null;

		if (rs.next()) {
			cliente = new Cliente(rs.getString(1), rs.getString(2));
		}
		close();
		return cliente;
	}


}
