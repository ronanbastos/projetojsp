<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controle Funcionario</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	<h3>Funcionario Consultado</h3>
<c:if test="${fn:length(listafuncionario)>0 }">
	<table>
		<tr>
			<th>ID do Funcionario</th>
			<th>Nome do Funcionario</th>
			<th>E-mail</th>
			<th>Telefone</th>
			<th>Login</th>
			<th>Senha</th>
			<th>CPF do Funcionario</th>
			<th>Ações</th>
		</tr>
		<c:forEach var="funcionario" items="${listaFuncionario}">
			<td>${funcionario.codfuncionario}</td>
			<td>${funcionario.nomefuncionario}</td>
			<td>${funcionario.cargo}</td>
			<td>${funcionario.login}</td>
			<td>${funcionario.senha}</td>
			<td>${funcionario.cpf}</td>
			<td><a href="editarfuncionario.html?cpf=${funcionario.cpf}">Alterar</a></td>
				<td><a href="excluirfuncionario.html?cpf=${funcionario.cpf}">Excluir</a></td>
		</c:forEach>	
	</table>	
</c:if>
</body>
</html>