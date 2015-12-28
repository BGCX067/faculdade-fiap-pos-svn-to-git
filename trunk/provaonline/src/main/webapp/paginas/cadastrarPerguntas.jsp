<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link href="../css/structure.css" rel="stylesheet">
<link href="../css/form.css" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
<!-- JavaScript -->
	<script src="../scripts/wufoo.js">
</script>
<script>
	$(document).ready(function() {
		$("#voltar").click(function() {
			parent.history.back();
			return false;
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div id="container" class="ltr">

		<h1 id="logo">
			<a href="" title="Cadastrar Perguntas">Cadastrar Perguntas</a>
		</h1>

		<form id="form64" name="form64" class="wufoo topLabel page"
			autocomplete="off" method="post" novalidate action="CadastrarPerguntas">

			<header id="header" class="info">
			<h2>Cadastro de Perguntas</h2>
			</header>

			<ul>

				<li id="foli1" class="notranslate      "><label class="desc"
					id="title1" for="Field1"> Pergunta <span id="req_1" class="req">*</span>
				</label>
				
				<select  name="categoria">
				    <c:forEach items="${listaCategoria}" var="categoria">
				        <option value="${categoria.id}" >${categoria.descricao}</option>
				    </c:forEach>
				</select>
				
				<textarea rows="6" cols="70" name="questao">Digite sua pergunta....</textarea> 
				
				<li id="foli3" class="notranslate      "><label class="desc"
					id="title3" for="Field3"> Alternativa 1 <span id="req_3"
						class="req">*</span>
				</label>
					<div>
						<input id="alternativa1" name="alternativa1" type="text" spellcheck="false" size="150"
							class="field text large" maxlength="255" tabindex="3" required />
							Correta <input type="radio" name="correta" value="correta1">
					</div></li>
					
				<li id="foli3" class="notranslate      "><label class="desc"
					id="title3" for="Field3">Alternativa 2 <span id="req_3"
						class="req">*</span>
				</label>
					<div>
						<input id="alternativa2" name="alternativa2" type="text" spellcheck="false" size="150"
							class="field text large" maxlength="255" tabindex="3" required />
							Correta <input type="radio" name="correta" value="correta2">
					</div></li>
					
					
				<li id="foli3" class="notranslate      "><label class="desc"
					id="title3" for="Field3">Alternativa 3<span id="req_3"
						class="req">*</span>
				</label>
					<div>
						<input id="alternativa3" name="alternativa3" type="text" spellcheck="false" size="150"
							class="field text large" maxlength="255" tabindex="3" required />
						Correta <input type="radio" name="correta" value="correta3">
					</div></li>
						
			</li>
				<li class="buttons ">
					<div>

						<input id="saveForm" name="salvar" class="btTxt submit"
							type="submit" value="Submit" />

						<button id="voltar" type="button" class="btTxt submit">Voltar</button>
					</div>
				</li>

			</ul>
		</form>

	
	<!--container-->
	<c:if test="${not empty listaQuestoes}">
		<div style="margin:15px;">
			<header id="header" class="info wufoo">
						<h2>Perguntas Cadastradas</h2>
			</header>
			
			<table cellspacing="0">
				 <c:forEach items="${listaQuestoes}" var="questoes">
				 	<tr><c:out value="${questoes.categoria}" /></tr>
					<tr style="background:#dddddd;">
						<c:out value="${questoes.questao}" />
					</tr>
					<tr>
					<c:forEach items="${questoes.alternativas}" var="alternativa">
						<c:out value="${alternativa.alternativa}"/>
					</c:forEach>
					
					</tr>  
					<tr>
						<a href=CadastrarPerguntas?id=${questoes.id}&operacao=del> Deletar </a><br />
					</tr>
				</c:forEach>
			</table>
		
		</div>
	</c:if>

</div>

</body>
</html>