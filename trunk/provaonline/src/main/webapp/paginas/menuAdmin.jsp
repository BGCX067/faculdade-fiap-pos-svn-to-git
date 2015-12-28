<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link href="./css/structure.css" rel="stylesheet">
<link href="./css/form.css" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
<!-- JavaScript -->
	<script src="./scripts/wufoo.js">
</script>
<title>Menu</title>
</head>
<body>
	<div id="container" class="ltr">

		<h1 id="logo">
			<a href="" title="Menu Admini Prova Online">Admin Prova Online</a>
		</h1>

		<ul>

			<li id="foli1" class="notranslate      "><label class="desc"
				id="title1" for="Field1"> <a href="paginas/CadastroCategorias">Cadastrar Categoria</a> <span id="req_1"
					class="req"></span>
			<li id="foli1" class="notranslate      "><label class="desc"
				id="title1" for="Field1"> <a href="paginas/CadastrarPerguntas">Cadastrar Perguntas</a> <span id="req_1"
					class="req"></span>
			</label> 

			</li>

		</ul>
		<form action="Navegacao">
			<input type="hidden" value="logout" name="logout">
			<input type="submit" value="Logout">
		</form>

		

	</div>
	<!--container-->



</body>
</html>