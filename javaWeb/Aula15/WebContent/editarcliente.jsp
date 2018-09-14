<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h3 >Página de Edição de Informações</h3>
Olá ${cliente.nome}
<form method="post" action="confirmarcliente.html">
	
		Nome do Cliente: <input type="text" name="nome" value="${cliente.nome}" id="nome"/><br>
			
		E-mail: <input type="text" name="email" value="${cliente.email}" id="email"/><br>
		
		Telefone:<input type="text" name="telefone"  value="${cliente.telefone}" id="telefone"><br>
			
		Login: <input type="text" name="login" value="${cliente.login}"  id="login"/><br>
			
		Senha: <input type="text" name="senha" value="${cliente.senha}" id="senha"/><br>
			
		CPF: <input type="text" id="cpf" name="cpf" value="${cliente.cpf}" id="cpf"/><br>
		
		ID:<input type="text" name="idcliente" value="${cliente.idCliente}"  readonly> <br>
	<input	type="submit" value="Editar Cliente"/>

</form>



</body>
</html>