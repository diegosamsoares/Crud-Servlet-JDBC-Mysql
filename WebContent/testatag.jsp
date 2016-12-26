<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ c:include file="/include.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1 id="titulo">CADASTRO DE CALOTEIROS</h1>

<form action="adicionaCaloteiro" method="Post">
	
	<triadTag:campoTexto
		campoName="nome"
		label="Nome"
		id="labelNome"/></br>
	
	<triadTag:campoTexto
		campoName="email"
		label="Email"
		id="labelEmail"/></br>
		
		<triadTag:campoTexto
		campoName="devendo"
		label="Devendo"
		id="labelDevendo"/></br>
		
		<triadTag:campoTexto
		campoName="dataDivida"
		label="Data da Divida"
		id="labelData"/></br>

   
 
    <input  id="botaosalvar" type="submit" value="Salvar"/>

	
	</form>


	
<c:import url="rodape.jsp"/>
</body>
</html>