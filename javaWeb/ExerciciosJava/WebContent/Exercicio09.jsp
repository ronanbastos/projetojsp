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
String identidade=request.getParameter("identidade");
String cpf=request.getParameter("cpf");
double salario=Double.parseDouble(request.getParameter("Salario"));
String funcao="";
double inss=0;

if(salario >= 2800){

	 out.println("O funcinario tem um salario de "+salario+" que é 11%"+"<br>");
	inss=salario*0.11;
	 out.println(inss);
	 out.println("<a href='Exercicio09.xhtml'>Voltar</a><br>");	
}else if ((salario < 2800) && (salario >= 1000 )){

	out.println("O funcinario"+nome+" tem um salario de"+salario+" que é 9%"+"total <br>");
	inss=salario*0.09;
	
	 out.println(inss+"<br>");
	out.println("<a href='Exercicio09.xhtml'>Voltar</a><br>");	
}else if(salario < 1000)
{
	
	inss=salario*0.08;
	 out.println(inss+"<br>");
	out.println("O funcinario "+nome+" tem um salario "+salario+" que é 8%"+"total <br>");
	 out.println("<a href='Exercicio09.html'>Voltar</a><br>");		
}else if(salario>=1500 )
{
	inss=salario*0.06;
	 out.println(inss+"<br>");
	out.println("O funcinario "+nome+" tem um salario "+salario+" que é 8%"+"total <br>");
	 out.println("<a href='Exercicio09.html'>Voltar</a><br>");		
}
else if(salario<1500 )
{
	inss=salario*0.05+150;
	 out.println(inss+"<br>");
	out.println("O funcinario "+nome+" tem um salario "+salario+" que é 8%"+"total <br>");
	 out.println("<a href='Exercicio09.html'>Voltar</a><br>");		
}
if(salario < 2000 ){
	funcao="vendedor";
}else
{
	funcao="Gerente";
}






Connection con=null;
PreparedStatement linguagem=null;
try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	con=DriverManager.getConnection("jdbc:mysql://localhost/exerciciosjava","root","");
	String sql="insert into empresa(nome,cpf,identidade,salario,funcao) values('"+nome+"','"+cpf+"','"+identidade+"','"+salario+"','"+funcao+"')";
	linguagem=con.prepareStatement(sql);
	linguagem.executeUpdate();
	out.println("Cadastrado com Sucesso!!");
}catch(Exception e){
	out.println("Erro"+e);
}



%>
</body>
</html>