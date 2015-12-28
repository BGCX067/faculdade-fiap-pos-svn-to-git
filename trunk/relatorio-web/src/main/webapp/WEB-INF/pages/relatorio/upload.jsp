<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<script type="text/javascript" src="jquery-1.2.6.min.js"></script>
<title>Upload Nota Fiscal</title>
</head>
<body>

	<center>
		<h2>Upload Nota Fiscal</h2>
		<h3>Selecione o arquivo para upload !</h3>

		<form:form method="post" enctype="multipart/form-data"
			modelAttribute="uploadedFile" action="fileUpload.htm">
			<table>
				<tr>
					<td>Upload File: </td>
					<td><input type="file" name="file" accept="text/xml" /></td>
					<td style="color: red; font-style: italic;"><form:errors
							path="file" /></td>
				</tr>
				<tr>
					<td> </td>
					<td><input type="submit" value="Upload" /></td>
					<td> </td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>

