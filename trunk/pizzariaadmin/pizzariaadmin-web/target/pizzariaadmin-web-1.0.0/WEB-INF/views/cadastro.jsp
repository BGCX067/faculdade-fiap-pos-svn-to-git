<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<title>Baralho Pizza</title>

<link rel="stylesheet"
	href='<spring:url value="/resources/css/templatemo_style.css"/>' />
<link rel="stylesheet"
	href='<spring:url value="/resources/css/orman.css"/>' />
<link rel="stylesheet"
	href='<spring:url value="/resources/css/nivo-slider.css"/>' />
<link rel="stylesheet"
	href='<spring:url value="/resources/css/ddsmoothmenu.css"/>' />
<script type="text/javascript"
	src='<spring:url value="/resources/js/jquery.min.js"/> '></script>
<script type="text/javascript"
	src='<spring:url value="/resources/js/ddsmoothmenu.js"/> '></script>
<link rel="icon" href="../resources/images/pizza_ico.ico">
</script>




<script>
	ddsmoothmenu.init({
		mainmenuid : "templatemo_menu", //menu DIV id
		orientation : 'h', //Horizontal or vertical menu: Set to "h" or "v"
		classname : 'ddsmoothmenu', //class added to menu's outer DIV
		//customtheme: ["#1c5a80", "#18374a"],
		contentsource : "markup" //"markup" or ["container_id", "path_to_menu_file"]
	});

	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}
</script>


<link rel="stylesheet"
	href='<spring:url value="/resources/css/slimbox2.css"/>' />
<script type="text/javascript"
	src='<spring:url value="/resources/js/slimbox2.js"/> '></script>


</head>

<body>


	<div id="templatemo_wrapper">
		<div id="templatemo_header">
			<div id="site_title">
				<a href="#" rel="nofollow">Web Templates</a>
			</div>

		</div>
		<!-- END of templatemo_header -->
		<div id="templatemo_menu" class="ddsmoothmenu">
			<ul>

				<li><a href="blog.html">Pedidos</a></li>
				<li><a href="contact.html" class="selected">Cadastro</a></li>
			</ul>
			<br style="clear: left" />
		</div>
		<!-- end of templatemo_menu -->
		<div id="templatemo_main">

			<h2>Cadastro de Pizzas</h2>

			<div class="col two-third">

				<div class="clear h40"></div>
				<div id="contact_form">
					<form:form method="post" modelAttribute="pizza" action="salvar">
						<label for="sabor">Sabor:</label>
						<form:input path="sabor" id="sabor" class="input_field" />

						<div class="clear h20"></div>
						<form:select path="tamanho" id="tamanho" class="input_field">
							<form:option value="">Selecionar Tamanho Pizza</form:option>
							<form:option value="PEQUENO">Pequeno</form:option>
							<form:option value="MEDIO">Médio</form:option>
							<form:option value="GRANDE">Grande</form:option>
						</form:select>

						<div class="clear h20"></div>
						<label for="valor">Valor:</label>
						<form:input path="valor" id="valor" class="input_field" />

						<div class="clear h20"></div>
						<label for="ingredientes">Ingredientes:</label>

						<c:forEach items="${pizza.ingredientes}" var="ingrediente"
							varStatus="status">
							<input name="ingredientes[${status.index}].descricao"
								value="${ingrediente.descricao}" class="input_field" />
							</td>
						</c:forEach>

						<div class="clear h20"></div>

						<input type="submit" class="submit_btn left" name="submit"
							id="submit" value="Send" />




					</form:form>
				</div>

				<c:if test='${not empty "${pizzas}"}'>
					<table >
						<tr>
							<th>Sabor:</th>
						</tr>
						<c:forEach items="${pizzas}" var="pizza">
							<tr>
								<td align="center">${pizza.sabor}</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>




			</div>


			<div class="clear"></div>
		</div>
		<!-- END of templatemo_main -->
	</div>
	<!-- END of templatemo_wrapper -->

	<div id="templatemo_footer_wrapper">
		<div id="templatemo_footer">
			<p>
				Copyright © 2014 <a href="#">Barbero Company</a> | <a rel="nofollow"
					href="#">Barbero Solutions</a>
			</p>
		</div>
		<!-- END of templatemo_footer -->
	</div>
	<!-- END of templatemo_footer_wrapper -->

	<script type="text/javascript"
		src='<spring:url value="/resources/js/logging.js"/> '></script>



</body>
</html>
