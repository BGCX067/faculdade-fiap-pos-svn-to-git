<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->
<link href="css/structure.css" rel="stylesheet">
<link href="css/form.css" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
<!-- JavaScript -->
	<script src="scripts/wufoo.js">
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
			<a href="" title="Cadastro de Usuários">Cadastro de Usuários</a>
		</h1>

		<form id="form64" name="form64" class="wufoo topLabel page"
			autocomplete="off" method="post" novalidate action="CadastrarUsuario">

			<header id="header" class="info">
			<h2>Cadastro de Usuários</h2>
			</header>

			<ul>

				<li id="foli1" class="notranslate      "><label class="desc"
					id="title1" for="Field1"> Nome <span id="req_1" class="req">*</span>
				</label> <span> <input id="Field1" name="nome" type="text"
						class="field text fn" size="8" tabindex="1" required /> <label
						for="Field1">Nome</label>
				</span> <span> <input id="Field2" name="sobrenome" type="text"
						class="field text ln" size="14" tabindex="2" required /> <label
						for="Field2">Sobrenome</label>
				</span></li>
				<li id="foli3" class="notranslate      "><label class="desc"
					id="title3" for="Field3"> Email <span id="req_3"
						class="req">*</span>
				</label>
					<div>
						<input id="Field3" name="email" type="text" spellcheck="false"
							class="field text medium" maxlength="255" tabindex="3" required />
					</div></li>
				<li id="foli3" class="notranslate      "><label class="desc"
					id="title3" for="Field3"> Senha <span id="req_3"
						class="req">*</span>
				</label>
					<div>
						<input id="Field3" name="password" type="password"
							spellcheck="false" class="field text medium" maxlength="255"
							tabindex="3" required />
					</div></li>

				<li id="foli3" class="notranslate      "><label class="desc"
					id="title3" for="Field3"> Tipo de Usuário <span id="req_3"
						class="req">*</span>
				</label>
					<div>
						<select name="tipoAluno">
							<option value="ALUNO">ALUNO</option>
							<option value="ADMIN">ADMIN</option>
						</select>
					</div></li>
				<li class="buttons ">
					<div>

						<input id="saveForm" name="salvar" class="btTxt submit"
							type="submit" value="Submit" />

						<button id="voltar" type="button" class="btTxt submit">Voltar</button>
					</div>
				</li>

			</ul>
		</form>

	</div>
	<!--container-->



</body>
</html>