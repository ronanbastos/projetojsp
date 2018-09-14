<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loja Virtual</title>
<script type="text/javascript">
function msg(){
	alert('Cadastrado com sucesso');
}
</script>
</head>
<body>
<%@ page import="br.com.aula9.controle.ControleCliente" %> 
<%@ page import="br.com.aula9.DAO.ClienteDao" %> 
<%@ page import="br.com.aula9.DAO.Dao" %> 
<%@ page import="br.com.aula9.entidade.Cliente" %> 
<h3>Cadastro de Clientes</h3>
<form action="adicionacliente.jsp" method="post">
<p><label>Nome:</label>
<input type="text" name="nome"/></p>
<p><label>E-mail:</label>
<input type="text" name="email"/></p>
<p><label>Telefone:</label>
<input type="text" name="telefone"/></p>
<p><label>Login:</label>
<input type="text" name="login"/></p>
<p><label>Senha:</label>
<input type="password" name="senha"/></p>
<p><label>CPF:</label>
<input type="text" name="cpf"/></p>
<input type="submit" value="Cadastrar" onclick="msg()"/>
</form>
</body>
</html>