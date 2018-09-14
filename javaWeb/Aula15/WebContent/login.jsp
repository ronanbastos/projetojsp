<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Acessar Sistema</h3>

	<form method="post" action="logarcliente.html">
		
			Login:
			<input type="text" name="login" placeholder="Login"><br>
		
			Senha:
			<input type="password" name="senha" placeholder="Senha"><br>
			
			Tipo de Usuário:
			<select name="nivel">
			<option value="">Administrador</option>
			<option value="">Cliente</option>				
			</select>
		
		<input type="submit" value="Logar">
		<a href="adicionaCliente.jsp">Cadastrar (Caso não tenha cadastro)</a>
	</form>



</body>
</html>