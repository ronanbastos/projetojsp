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
					
					<% if(request.getSession().getAttribute("login") != null){%> 
						<li><a href="sairCliente.html">Sair</a></li>	
							<li>Seja-Bem vindo, ${nome}</li>
							<li><a href="buscarcliente.jsp">Buscar Cliente</a></li>		
						<% } %>	
						</ul>

</body>
</html>