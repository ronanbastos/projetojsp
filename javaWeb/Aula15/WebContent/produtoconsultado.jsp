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
<h3>Produto Consultado</h3>
<c:if test="${fn:length(lista) > 0}">

	<table class="table table-bordered">
		<tr align="center">
			<th>ID  DO PRODUTO</th>
			<th>NOME PRODUTO</th>
			<th>VALOR</th>
			<th>QUANTIDADE</th>
			<th>FORNECEDOR</th>
			<th colspan="2">AÇÕES</th>
		</tr>
		
		<c:forEach var="produto" items="${lista}">
			<tr>
				<td id="idproduto">${produto.idproduto}</td>
				<td id="idnome">${produto.nome}</td>
				<td id="idquantidade">${produto.quantidade}</td>
				<td id="idvalor">${produto.valor}</td>
				<td id="idfornecedor">${produto.fornecedor}</td>
				<td><a href="editarproduto.html?idproduto=${produto.idproduto}">Alterar</a></td>
				<td><a href="excluirproduto.html?idproduto=${produto.idproduto}">Excluir</a></td>
			</tr>
		</c:forEach>
		</table>
</c:if>
</body>
</html>