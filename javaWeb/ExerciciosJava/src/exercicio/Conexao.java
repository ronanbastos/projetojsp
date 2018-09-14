package exercicio;


import java.sql.*; 

import javax.swing.JOptionPane;

public class Conexao {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost/exerciciosjava","root","");
		  System.out.println("Conectado!!");	
		}catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro no Drive"+e.getMessage());
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no comando sql"+e.getMessage());
			
	}

}
}