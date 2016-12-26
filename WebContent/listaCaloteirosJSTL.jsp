
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Caloteiros</title>
</head>
<body>
<c:import url="cabecalho.jsp"/>

	<h1>Lista Caloteiros</br></h1>
	
	<table border="1" >
	<tr>
	<td>Id</td>
	<td>Nome</td>
	<td>Email</td>
	<td>Data</td>
	</tr>
	
	
	<c:forEach var="caloteiro"  items="${lista }">
		
	</c:forEach>	
			<c:forEach var="caloteiro"  items="${lista }" varStatus="id">
			<tr bgcolor="#${id.count %2 ==0 ? '#606060' : 'ffffff' }">
				 <td >${id.count} </td>
				 
				 <c:choose>
						<c:when test="${not empty caloteiro.email }">
							<td> <a href="mailto:${caloteiro.email }"> ${caloteiro.email }</a> </td>
						</c:when>		
						
						<c:otherwise>
							<td>Email não preenchido </td>
						</c:otherwise>		 
				 
				 </c:choose>
				 
				 <td><a href="sistema?acao=PreencheCaloteiro&id=${caloteiro.id }">${caloteiro.nome }</a> </td>
				
				 <td> <fmt:formatDate pattern="dd/MM/yyyy" value="${caloteiro.dataDivida.time }"/> </td>	
				<td><a href="sistema?acao=ExcluiCaloteiro&id=${caloteiro.id }">Deletar</a></td>	
			</tr>			
			</c:forEach>
	</table>
		
	
<c:import url="rodape.jsp"/>	
</body>
</html>