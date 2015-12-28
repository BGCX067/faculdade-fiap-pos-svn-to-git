<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="../resources/jquery-1.10.1.min.js"></script>
        
	    <script>
			$(document).ready(function(){
			
			var formData = '{"texto":"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"}'; 
			
			 
			 $('#botao').click(function(){
			 		$.ajax({
				    url : "./comentario/adicionar",
				    type: "POST",
				    data : formData,
				    contentType:"application/json; charset=utf-8",
				    dataType: 'json',
				    success: function(data, textStatus, jqXHR)
				    {
				        alert(data.texto);
				    },
				    error: function (jqXHR, textStatus, errorThrown)
				    {
				 		alert(jqXHR.responseText );
				    }
				});
			 	}
			 );
			 
			});
		</script>
        
    </head>
    <body>
        <button id="botao" type="button">Chamar</button>

    </body>
</html>
