<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String msg = "seja bem vindo ao meu jsp"; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%out.println(msg); %></title>
</head>
<body>
	olá <%=request.getParameter("nome")%>, <%=msg %>
</body>
</html>