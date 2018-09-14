<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<h3 >Página de Edição de Informações</h3>

<form method="post" action="confirmarproduto.html">
	
		Nome do Produto: <input type="text" name="nome" value="${produto.nome}" id="nome"/><br>
			
		Valor do Produto: <input type="text" name="valor" value="${produto.valor}" id="valor"/><br>
		
		Quantidade no Estoque:<input type="text" name="quantidade"  value="${produto.quantidade}" id="quantidade"><br>
			
		Fornecedor: <input type="text" name="fornecedor" value="${produto.fornecedor}"  id="fornecedor"/><br>
			
		ID do Produto:<input type="text" name="idproduto" value="${produto.idproduto}"  id="idproduto" readonly> <br>
	<input	type="submit" value="Editar Produto"/>

</form>

</body>
</html>