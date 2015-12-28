<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="br.com.fiap.javaweb.provaonline.bean.Categoria" %>
	<%@ page import="java.util.List" %>
	
<%
Categoria categoria = (Categoria)session.getAttribute("categoria");
if(categoria == null){
	categoria = new Categoria();
	categoria.setDescricao("");
}
%>
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
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div id="container" class="ltr">

		<h1 id="logo">
			<a href="" title="Cadastro de Categorias">Cadastro de Categorias</a>
		</h1>

		<form id="form64" name="form64" class="wufoo topLabel page" autocomplete="off" method="post" novalidate action="CadastroCategorias">
			<header id="header" class="info">
				<h2>Cadastro de Categorias</h2>
			</header>
			<input type="hidden" id="id" name="id" value="<% if(categoria.getId() != null) out.print(categoria.getId()); %>" />
			<ul>

				<li id="foli1" class="notranslate">
					<label class="desc" id="title1" for="Field1">
						Descrição da categoria
						<span id="req_1" class="req">*</span>
				    </label>
					<div>
						<input id="descr" name="descr" type="text" size="100" class="field text medium" maxlength="255" tabindex="2" required
						value="<% out.print(categoria.getDescricao()); %>" />
					</div>
				</li>
				<li class="buttons">
					<div>
						<input id="saveForm" name="salvar" class="btTxt submit" type="submit" value="Submit" />
						<button id="voltar" type="button" class="btTxt submit">Voltar</button>
					</div>
				</li>

			</ul>
		</form>
		<hr />
		
		<div style="margin:15px;">
			<table>
		<%
			List<Categoria> categorias = (List<Categoria>)session.getAttribute("categorias");
			if(categorias != null){
		%>
				<header id="header" class="info wufoo">
					<h2>Lista de categorias</h2>
				</header>
		<% 
				for(Categoria c : categorias){
					if(c.getId() != null){
						out.print("<tr><td>");
						out.print("<a href=CadastroCategorias?id="+ c.getId() + ">" + c.getDescricao() + "</a> ");
						out.print("</td><td>");
						out.print("<a href=CadastroCategorias?id="+ c.getId() + "&operacao=del> X </a><br />");
						out.print("</td></tr>");
					}
				}
					
			} %>
			</table>
		</div>
	</div>
	<!--container-->
</body>
</html>