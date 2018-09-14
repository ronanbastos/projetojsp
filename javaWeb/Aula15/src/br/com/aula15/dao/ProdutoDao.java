package br.com.aula15.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.aula15.entidade.Produto;

public class ProdutoDao extends Dao {
	// método adicionar produto

	public void cadastrarproduto(Produto produto) throws SQLException {
			open();
			String sql = "insert into produto(nomeproduto,valor,quantidade,fornecedor)" + "values(?,?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getValor());
			stmt.setInt(3, produto.getQuantidade());
			stmt.setString(4, produto.getFornecedor());
			stmt.execute();
			close();
		}

	// método buscar produto

	public Produto buscarprodutoporid(int idproduto) throws SQLException {
			open();
			String sql = "select * from produto where idproduto = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idproduto);
			
			Produto produto = null;
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				produto = new Produto(rs.getInt("idproduto"),
						  rs.getString("nomeproduto"),
						  rs.getDouble("valor"),
						  rs.getInt("quantidade"),
						  rs.getString("fornecedor"));
			}
			close();
			return produto;
		}

	// método listar produto

	public List<Produto> buscarproduto(String nomeproduto) throws SQLException{
			open();
			String sql = "select * from produto where nomeproduto like ?"; 
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nomeproduto+"%");
			
			//Objeto que recebe a lista completa do stmt, para seleção dos dados		
			rs = stmt.executeQuery();
			List<Produto> lista = new ArrayList<Produto>();
			
			while(rs.next()) {
				Produto produto = new Produto(rs.getInt("idproduto"),
											  rs.getString("nomeproduto"),
											  rs.getDouble("valor"),
											  rs.getInt("quantidade"),
											  rs.getString("fornecedor"));
				
				
				lista.add(produto);
			}
			
			close();
			return lista;
		}

	// método editar produto

	public void atualizarproduto(Produto produto) throws SQLException {
			open();
			String sql = "UPDATE produto set nomeproduto = ?, valor = ?, quantidade = ?,fornecedor = ? where idproduto = ?";
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getValor());
			stmt.setInt(3, produto.getQuantidade());
			stmt.setString(4, produto.getFornecedor());
			stmt.setInt(5, produto.getIdproduto());
			stmt.executeUpdate();
			close();
			
			
		}

	// método excluir produto

	public void excluirproduto(int idproduto) throws SQLException {
			open();
			String sql = "delete from produto where idproduto = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idproduto);
			stmt.execute();
			close();
		}


}