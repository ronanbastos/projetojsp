<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exercicio02</title>
</head>
<body>
<%
int n=2;
int r;
int c=0;
while(c<=10)
{
	

		r=n*c;
		out.println(n+" x "+c+": ");
		out.println(r+"<br>");
		c++;
}
%>
</body>
</html>