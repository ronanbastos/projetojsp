package modelo;

import java.sql.*;

import javax.swing.JOptionPane;

import visao.TelaCaixa;
import visao.TelaMenu;

public class ManipulaBD {
	Conexao cn = new Conexao();
	public boolean logado = false;
	private String dados;
	public int ent;
	public String user;

	
	public void controleentrada(String p,String cpf,String n,String en) {
        cn.Conecta();
        //executeQuery so serve para select e preciso um resultSet
        //Para todos as outro use o update sem requerimento do resultSet
        // Os outro inset into,delete,update
        // O execute query retorna um array
        // O execute update retorna inteiro 
        try {
            Statement st = cn.con.createStatement(); //paramento do banco
            st.executeUpdate("INSERT INTO controlee(placa,cpf,nome,entrada) VALUES" +
            "('"+ p +"','"+ cpf +"','"+n+"','"+en+"')");

           
            JOptionPane.showConfirmDialog(null,"Entrada efetuada Sucesso!!");
        	TelaMenu tM = new TelaMenu();
            tM.setVisible(true);
            st.close();
            cn.Desconecta();
        }catch(SQLException err){
            System.out.println("Erro,login:" + err);

        }

     }

	public void controlesaida(String p,String cpf,String n,String en,int i) {
        cn.Conecta();
        //executeQuery so serve para select e preciso um resultSet
        //Para todos as outro use o update sem requerimento do resultSet
        // Os outro inset into,delete,update
        // O execute query retorna um array
        // O execute update retorna inteiro 
        try {
            Statement st = cn.con.createStatement(); //paramento do banco
            st.executeUpdate("INSERT INTO controles(idplaca,saida,atraso,status,total) VALUES" +
            "('"+ p +"','"+ cpf +"','"+n+"','"+en+"','"+i+"')");

           
            JOptionPane.showConfirmDialog(null,"Entrada efetuada Sucesso!!");
        	TelaMenu tM = new TelaMenu();
            tM.setVisible(true);
            st.close();
            cn.Desconecta();
        }catch(SQLException err){
            System.out.println("Erro,login:" + err);

        }

     }

	public void Login(String u,String s) {
		TelaMenu tM = new TelaMenu();
		cn.Conecta();
		//executeQuery so serve para select e preciso um resultSet
		//Para todos as outro use o update sem requerimento do resultSet
		// Os outro inset into,delete,update
		// O execute query retorna um array
		// O execute update retorna inteiro 
		TelaCaixa tc = new TelaCaixa();
		try {
		Statement st = cn.con.createStatement(); //paramento do banco
		ResultSet rs = st.executeQuery("SELECT*FROM  usuario WHERE usu='"+ u +"' AND sen='"+ s +"';");
		while(rs.next()) {
			logado = true;
			JOptionPane.showMessageDialog(null,"Usuario Logado!!!");
			 user = rs.getString("usu");	 	
			String admin = "admin";
			if(user.trim().equals(admin))
			{
				tM.getClass();
				tM.setVisible(true);
				
			}else
			{
				tc.getClass();
				tc.setVisible(true);
			}
		}
		st.close();
		rs.close();
		}catch(SQLException e){
		System.out.println("Erro,login:" + e);
	
	}
 }

	public void puxadados(String p) {
		cn.Conecta();
		
		
		//executeQuery so serve para select e preciso um resultSet
		//Para todos as outro use o update sem requerimento do resultSet
		// Os outro inset into,delete,update
		// O execute query retorna um array
		// O execute update retorna inteiro 
		
		try {
		Statement st = cn.con.createStatement(); //paramento do banco
		ResultSet rs = st.executeQuery("SELECT entrada FROM  controlee WHERE placa='"+ p +"';");
		dados = p;
		if(p != dados)
		{
			JOptionPane.showMessageDialog(null,"Esta placa não existe: ");	
			
		}
		while(rs.next()) 
		{
		 ent = rs.getInt("entrada");	 	
			if(dados == p)
			{
				JOptionPane.showMessageDialog(null,"Esta placa existe: "+ dados+",Sua entrada: "+ ent);	
				
			}
			
				
		
		}
		st.close();
		rs.close();
		}catch(SQLException e){
		System.out.println("Erro,em verificar:Esta placa não existe!" + e);
	
	}
 }

	

}