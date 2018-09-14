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
<%
String nome=request.getParameter("nome");
String situacao=request.getParameter("situacao");
int idade=Integer.parseInt(request.getParameter("idade"));
String ano=request.getParameter("ano");
String anolet=request.getParameter("anolet");

out.println(nome+" e você tem "+idade+" anos!!");
if(idade >=18)
{
  out.println("Você é maior de idade!");
  situacao = "maior de idade";
}else
{
	 out.println("Você é menor de idade!");
	  situacao = "menor de idade";
}

Connection con=null;
PreparedStatement linguagem=null;
try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	con=DriverManager.getConnection("jdbc:mysql://localhost/exerciciosjava","root","");
	String sql="insert into statos(idade,nome,ano,anoat,situacao) values('"+idade+"','"+nome+"','"+ano+"','"+anolet+"','"+situacao+"')";
	linguagem=con.prepareStatement(sql);
	linguagem.executeUpdate();
	out.println("Cadastrado com Sucesso!!");
}catch(Exception e){
	out.println("Erro"+e);
}
%>
<a href="Exercicio08.xhtml">cadastrar aluno</a>

</body>
</html>