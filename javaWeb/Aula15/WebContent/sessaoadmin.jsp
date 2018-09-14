<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="adicionarproduto.jsp">Cadastrar Produto</a></li>
					<li><a href="buscarproduto.jsp">Atualizar Produto</a></li>
					<li><a href="buscarproduto.jsp">Excluir Produto</a></li>
					<li><a href="buscarproduto.jsp">Buscar Produto</a></li>							
					<%if(request.getSession().getAttribute("login") != null){%>
						<li><a href="sairAdmin.html">Sair</a></li>	
							<li>Seja-Bem vindo, ${login}</li>
												
						<%}%>		                                                                                               
				</ul>
</body>
</html>