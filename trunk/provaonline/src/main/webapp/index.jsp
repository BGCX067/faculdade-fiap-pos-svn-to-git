<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" />

<title>Login</title>
</head>
<body>
	<div id="box">
		<div class="elements">
			<div class="avatar"></div>
			<form action="login" method="post">
				<%if(request.getParameter("e")!= null){ %>
					<p style="color:red;font-size:12px;">Incorrect login or password</p>
				<%}else{out.print("<p />");} %>
				<input type="text" name="username" class="username"
					placeholder="Username" /> <input type="password" name="password"
					class="password" placeholder="•••••••••" />
				<input type="submit" name="submit" class="submit" value="Sign In" />
			</form>
		</div>
	</div>
	<div class="signup">
		Not a registered user yet? <a href="cadastrarUsuario.jsp">Sign up now!</a>
	</div>

</body>
</html>
