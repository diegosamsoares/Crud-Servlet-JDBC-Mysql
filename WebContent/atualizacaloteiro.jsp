<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
       <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="cabecalho.jsp"/>

<h1 id="titulo">CADASTRO DE CALOTEIROS</h1>

<div>


<c:import url="cabecalho.jsp"/>
<form action="sistema" method="Post">
<table>
<input type="hidden"  name="acao" value="AtualizaCaloteiro" />
<tr>
    <td><input type="hidden" name="id"  value="${caloteiro.id }"/></td>
  </tr>


  <tr>
    <td>Nome:<input type="text" name="nome"  value="${caloteiro.nome }"/></td>
  </tr>

   <tr>
     <td>Email:<input type="text" name="email" value="${caloteiro.email }"/></td>
   </tr>
   
   <tr>
     <td>Devendo:<input type="text" name="devendo" value="${caloteiro.devendo }"/></td>
   </tr>
   
   <tr>
     <td>Data:<input type="text" name="dataDivida" 
      value="<fmt:formatDate pattern="dd/MM/yyyy" value="${caloteiro.dataDivida.time }"/>"/></td>
   </tr>
   
   <tr>
     <td><input  id="botaosalvar" type="submit" value="Salvar"/></td>
   </tr>
	</table>
	</form>



		

</div>
	
<c:import url="rodape.jsp"/>
</body>
</html>