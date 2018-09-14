<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h3>Cliente consultado</h3>
<c:if test="${fn:length(listaCliente)>0 }">
	<table>
		<tr>
			<th>ID do Cliente</th>
			<th>Nome do Cliente</th>
			<th>E-mail</th>
			<th>Telefone</th>
			<th>Login</th>
			<th>Senha</th>
			<th>CPF do Cliente</th>
			<th>Ações</th>
		</tr>
		<c:forEach var="cliente" items="${listaCliente}">
			<td>${cliente.idCliente}</td>
			<td>${cliente.nome}</td>
			<td>${cliente.email}</td>
			<td>${cliente.telefone}</td>
			<td>${cliente.login}</td>
			<td>${cliente.senha}</td>
			<td>${cliente.cpf}</td>
			<td><a href="editarcliente.html?cpf=${cliente.cpf}">Alterar</a></td>
				<td><a href="excluircliente.html?cpf=${cliente.cpf}">Excluir</a></td>
		</c:forEach>	
	</table>	
</c:if>
</body>
</html>