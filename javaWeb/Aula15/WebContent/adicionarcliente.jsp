<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Cadastro de Clientes</h3>

<form id="cadastro" method="post" action="cadastrarcliente.html">
   
	    Nome do Cliente:
	    <input type="text" name="nome" id="nome"><br>
	    Email:
	    <input type="text" name="email"  id="email"><br>
	    Telefone:
	    <input type="text" name="telefone"  id="telefone"><br>
	    Login:
	    <input type="text" name="login"  id="login"><br>
	    Senha:
	    <input type="password" name="senha"  id="senha"><br>
    	CPF:
    	<input type="text" id="cpf" name="cpf"  id="cpf"><br>
	<input type="submit" value="Cadastrar Cliente" />
		
</form> 


</body>
</html>