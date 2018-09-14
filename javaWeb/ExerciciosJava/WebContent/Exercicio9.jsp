<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
	<%@ page import="exercicio.Conexao"%>
<h1>Cliente consultado:</h1>

<table border="1">
<tr>
	<td>id </td> 
	<td>cpf </td>
	<td>nome</td>
	<td>Salario </td>
	<td>Função</td>
		

</tr>
<%

String nome=request.getParameter("nome");
int id;
String cpf;
String salario;
String funcao;
String indentidade;


	Connection conn=null;
	ResultSet linha=null;
	
	try{
	 Class.forName("com.mysql.jdbc.Driver").newInstance();
	 conn=DriverManager.getConnection("jdbc:mysql://localhost/exerciciosjava","root","");
	 String sql="select * from empresa where nome='"+nome+"'";
	 Statement linguagem=conn.createStatement();
	 linguagem.executeQuery(sql);
	 linha=linguagem.getResultSet();
	 while(linha.next())
	 {
		 id=linha.getInt("id");
		 nome=linha.getString("nome");
		 cpf=linha.getString("cpf");
		 salario=linha.getString("salario");
		 funcao=linha.getString("funcao");
		 indentidade=linha.getString("indentidade");
		
		
		
		%>
		<tr>
	<td><%=id %></td> 
	<td><%=cpf %></td>
	<td><%=nome %></td>
	<td><%=salario %></td>
	<td><%=funcao %></td>
	<td><%=indentidade %></td>
	
	</tr>
		
		<% 
	 }
	}catch(Exception e){
		
	out.println("Erro ao consultar"+e);
	}

%>


 </table>


</body>
</html>