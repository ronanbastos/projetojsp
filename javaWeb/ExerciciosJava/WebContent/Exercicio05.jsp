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
String cpf=request.getParameter("cpf");
double av1=Double.parseDouble(request.getParameter("av1"));
double av2=Double.parseDouble(request.getParameter("av2"));
double av3=Double.parseDouble(request.getParameter("av2"));
double total;
String situacao="";

total = (av1+av2+av3)/3;

if(total >= 7 )
{
 situacao = "aprovado";
}
else if ((total < 7) && (total >= 5))
{
	situacao = "Recuperação";
}
else
{
 situacao = "Reprovado";
}

Connection con=null;
PreparedStatement linguagem=null;
try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	con=DriverManager.getConnection("jdbc:mysql://localhost/exerciciosjava","root","");
	String sql="insert into aluno(cpf,nome,av1,av2,av3,media,situacao) values('"+cpf+"','"+nome+"','"+av1+"','"+av2+"','"+av3+"','"+total+"','"+situacao+"')";
	linguagem=con.prepareStatement(sql);
	linguagem.executeUpdate();
	out.println("Cadastrado com Sucesso!!");
}catch(Exception e){
	out.println("Erro"+e);
}


%>
</body>
</html>