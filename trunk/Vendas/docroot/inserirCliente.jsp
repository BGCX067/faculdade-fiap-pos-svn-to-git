<%@ page contentType="text/html; charset=ISO-8859-1" %>

<html> 
	<head>
		<title>Cadastrar Cliente</title>
		<script type="text/javascript">
		<!--
			function setarFoco( campo ) {
				if( document.getElementById("uc54_dscSistemaCaixa").style.display != "none" ) {
					document.formulario.elements[campo].focus();
				}
			}
			
			function setStatus( texto ) {
				window.status=texto;
			}
		

			function confirmation() {
				document.formulario.submit();
			}
		//-->
		</script>
	
	</head>
<body>
	<div id="sep_topodestaqueb"><img src="images/space.gif" width="1" height="1" /></div>
	<div id="conteudo-fb">
		<div id="margem">
			<div id="uc54_tela_principal_cadastrar_sistema">
				<span class="texto_corpo_pequeno">Cadastros  </span><span class="texto_titulos_pequeno">&raquo; Cadastrar Cliente <br />  <br /></span>  <span class="texto_titulos_grande">&raquo; Cadastrar Cliente <br />  <br /></span><span class="texto_titulos_grande"> </span>
				
				<form id="formulario" name="formulario" action="vendas.do?action=InserirCliente" method="post">
	  				
	  				<table width="95%" border="0" cellspacing="3" cellpadding="0">
	    				<tr>
	      					<td height="20" colspan="2" bgcolor="#8993A7" class="texto_titulos_tabela">&nbsp;&nbsp;<strong>Dados Gerais </strong></td>
	    				</tr>
	    				<tr>
	      					<td width="200" height="20" bgcolor="#F5F5F7" class="texto_corpo"><div align="right"><span class="texto_vermelho">*</span> nome&nbsp;</div></td>
					      	<td bgcolor="#F5F5F7"><input name="nome" type="text" class="forms" size="15" maxlength="15" /></td>
					    </tr>
	    				<tr>
	      					<td width="200" height="20" bgcolor="#F5F5F7" class="texto_corpo"><div align="right"><span class="texto_vermelho">*</span> Endereço&nbsp;</div></td>
					      	<td bgcolor="#F5F5F7"><input name="endereco" type="text" class="forms" size="15" maxlength="15" /></td>
					    </tr>
	    				<tr>
	      					<td width="200" height="20" bgcolor="#F5F5F7" class="texto_corpo"><div align="right"><span class="texto_vermelho">*</span> Telefone&nbsp;</div></td>
					      	<td bgcolor="#F5F5F7"><input name="telefone" type="text" class="forms" size="15" maxlength="15" /></td>
					    </tr>
	    				<tr>
	      					<td width="200" height="20" bgcolor="#F5F5F7" class="texto_corpo"><div align="right"><span class="texto_vermelho">*</span> Situacao&nbsp;</div></td>
					      	<td bgcolor="#F5F5F7"><input name="situacao" type="text" class="forms" size="15" maxlength="15" /></td>
					    </tr>
				 	</table>
				 	<br />
				 	
	  				<table width="95%" border="0" cellspacing="3" cellpadding="0">
	    				<tr>
	      					<td width="200" height="20" bgcolor="#F5F5F7" class="texto_corpo"><div align="right"><span class="texto_vermelho">*</span> CPF&nbsp;</div></td>
					      	<td bgcolor="#F5F5F7"><input name="cpf" type="text" class="forms" size="15" maxlength="15" /></td>
					    </tr>
	    				<tr>
	      					<td width="200" height="20" bgcolor="#F5F5F7" class="texto_corpo"><div align="right"><span class="texto_vermelho">*</span> CNPJ&nbsp;</div></td>
					      	<td bgcolor="#F5F5F7"><input name="cnpj" type="text" class="forms" size="15" maxlength="15" /></td>
					    </tr>
	    				<tr>
	      					<td width="200" height="20" bgcolor="#F5F5F7" class="texto_corpo"><div align="right"><span class="texto_vermelho">*</span> IE&nbsp;</div></td>
					      	<td bgcolor="#F5F5F7"><input name="ie" type="text" class="forms" size="15" maxlength="15" /></td>
					    </tr>
				 	</table>
				 	
				 	
					<table width="95%" border="0" cellpadding="0" cellspacing="3">
						<tr id="uc54_Cadastrar">
					    	<td width="200">&nbsp;</td>
					      	<td><input name="Button" type="button" class="texto_corpo" value="Cadastrar" onclick="confirmation()"/></td>
					    </tr>
					    <tr>
					      	<td width="200" height="20">&nbsp;</td>
					      	<td><span class="texto_corpo">(<span class="texto_vermelho">*</span>) Campos de preenchimento obrigat&oacute;rio. </span></td>
					    </tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	
	<div id="menue-fb">
		<div class="paddingwrap">
    		<ul>
      			<li id="mlink"><a href="#"><span>Ajuda</span></a></li>
      			<li id="mlink"><a href="javascript:history.go(-1)"><span>Voltar</span></a></li>
    		</ul>
		</div>
	</div>

</body>
</html>