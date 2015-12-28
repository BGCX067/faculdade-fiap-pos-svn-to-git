<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Livro jQuery Mobile do Maujor</title>
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
</head>
<body>
	<div data-role="page" data-theme="a">
		<div data-role="header" >
			<h1>Cadastro de Visitas</h1>
		</div>

		<div data-role="main" class="ui-content">
			<form method="post" action="../welcome/salvar">
				<div class="ui-field-contain">
					<label for="tel">Telefone:</label> <input type="tel" name="tel"
						id="tel">
				</div>
				<div class="ui-field-contain">
					<label for="fullname">Nome:</label> <input type="text"
						name="fullname" id="fullname">
				</div>
				<div class="ui-field-contain">
					<label for="bday">Data Nascimento:</label> <input type="date"
						name="bday" id="bday">
				</div>
				<div class="ui-field-contain">
					<label for="email">E-mail:</label> <input type="email" name="email"
						id="email" placeholder="Your email..">
				</div>

				<input type="submit" data-inline="true" value="Salvar">
			</form>
		</div>

		<div data-role="footer" >
			<h1>Footer</h1>
		</div>
	</div>

</body>
</html>