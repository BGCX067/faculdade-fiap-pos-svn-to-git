<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.fiap.javaweb.provaonline.bean.Questoes"%>
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link href="../css/structure.css" rel="stylesheet">
<link href="../css/form.css" rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
<!-- JavaScript -->
	<script src="scripts/wufoo.js">
</script>
<script>
	$(document).ready(function() {
		$("#voltar").click(function() {
			parent.history.back();
			return false;
		});
		$("#submit").click(function() {
			var x=document.getElementsByTagName("input");
			var count = 0;
			for(j = 0;j<x.length;j++){
				if(x[j].type == "radio"){
					count++;
				}
			}
			count /= 3;
			var countCheckeds = 0;
			$('#form64 input:radio').each(function() {
				if ( $(this).is(':checked') ) {
					countCheckeds++;
				}
			});
			if(count == countCheckeds){
				$('#form64').submit();
			}else{
				alert("Preencha todas questoes.");
			}
		});
		
		
	});
</script>
<title>Prova Online</title>
</head>
<body>
	<div id="container" class="ltr">

		<h1 id="logo">
			<a href="" title="Prova online">Prova online</a>
		</h1>
		<c:if test="${sessionScope.result != null}">
			<header id="header" class="info">
				<h2>Resultado:</h2>
			</header>
			<br />
			<c:out value="Você acertou ${sessionScope.result}% da prova"></c:out>
		</c:if>
		<c:if test="${sessionScope.questoes != null}">
			<form id="form64" name="form64" class="wufoo topLabel page" autocomplete="off" method="post" novalidate action="prova">
				<header id="header" class="info">
					<h2>Prova online</h2>
				</header>
				<c:set var="count" scope="session" value="1"/>
				<c:forEach items="${sessionScope.questoes}" var="item">
					${count})
					${item.questao}
					<br />
					<c:forEach items="${item.alternativas}" var="alternativas">
						&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="questao${count}" value="${alternativas.id}">${alternativas.alternativa}</input><br />
					</c:forEach>
					<br />
					<c:set var="count" scope="session" value="${count + 1}"/>
				</c:forEach>
			</form>
			<input type="button" id="submit"  value="Terminar Prova" />
			
		</c:if>
	</div>
	<!--container-->
</body>
</html>