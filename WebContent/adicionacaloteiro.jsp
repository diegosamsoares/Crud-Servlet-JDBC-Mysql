<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adiciona Caloteiro</title>
</head>
<body>
<c:import url="cabecalho.jsp"/>
<hr>
Usuario logado=${usuarioLogado.nome }
<hr>

<h1 id="titulo">CADASTRO DE CALOTEIROS</h1>

<div>


<c:import url="cabecalho.jsp"/>
<form action="sistema?acao=AdicionaCaloteiro" method="Post" id="formAdicionaCaloteiros">

<input type="hidden"  name="acao" value="AdicionaCaloteiro" />
<table>


  <tr>
    <td>Nome:<input type="text" name="nome" /></td>
  </tr>

   <tr>
     <td>Email:<input type="text" name="email" /></td>
   </tr>
   
   <tr>
     <td>Devendo:<input type="text" name="devendo" id="labelDevendo"/></td>
   </tr>
   
   <tr>
     <td>Data:<input type="text" name="dataDivida"/></td>
   </tr>
   
   <tr>
     <td><input  id="botaosalvar" type="submit" value="Salvar"/></td>
   </tr>
	</table>
	</form>



		

</div>
	
<c:import url="rodape.jsp"/>
</body>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/jquery.maskMoney.min.js"></script>
<script src="js/jquery.validate.js"></script>
<script src="js/validacoes.js"></script>


</html>