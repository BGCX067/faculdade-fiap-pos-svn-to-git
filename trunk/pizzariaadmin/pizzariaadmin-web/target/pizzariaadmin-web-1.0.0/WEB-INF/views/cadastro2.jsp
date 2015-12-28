<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
<script type="text/javascript"
	src="http://malsup.github.com/jquery.form.js"></script>
<script type="text/javascript">


$("document").ready(function(){
    $("#file").change(function() {
    	$("#form").submit();
   });


    $("#salvarPizza").click(function(){
    	   alert('chamou');
        $.ajax({
		
            
             
            type: "POST",
            data: { primeiro:a, segundo:b },
             
            url: "./pizza/salvar",
            dataType: "json",
            success: function(result){
            },
            beforeSend: function(){
                $('#loading').css({display:"block"});
            },
            complete: function(msg){
                $('#loading').css({display:"none"});
            }
        });
         
    });
});




$('#form').ajaxForm({

	uploadProgress : function(event, position, total, percentComplete) {
		$('progress').attr('value', percentComplete);
		$('#porcentagem').html(percentComplete + '%');
	},
	success : function(data) {
		$('progress').attr('value', '100');
		$('#porcentagem').html('100%');
		$('pre').html(data);
		$('#imagemPizza').text(JSON.stringify(data));
	}

});




	
</script>
<title>Baralho Pizza</title>
</head>
<body>

	<input type="hidden" id="imagemPizza" />
	
	<input type="button" value="salvar" id="salvarPizza" />

	<form action="./upload" method="post" id="form">

		<div id="file">
			<label for="file">Arquivo para fazer upload</label> <input
				type="file" name="file" id="file"> <br>
			<br>
			<progress value="0" max="100"></progress>
			<span id="porcentagem">0%</span>

		</div>
		<br /> 
	</form>

</body>
</html>
