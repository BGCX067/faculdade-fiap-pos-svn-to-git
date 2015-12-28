<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Upload com Sucesso</title>
</head>
<body>
 <center>

  <h2>Upload com Sucesso</h2>
  <h3>
   File name : <strong> ${message}</strong> gravado com sucesso !
  </h3>
  
  
   <table>
    <tr>
        <th>No.</th>
        <th>Name</th>
    </tr>
    <c:forEach items="${listFiles}" var="arquivos" varStatus="status">
        <tr>
            <td align="center">${status.count}</td>
            <td><a href="<c:url value="/relatorio/pdf?fileName=${arquivos.name}"/>">${arquivos.name}</a>
             </td>
            
        </tr>
    </c:forEach>
</table>  

 </center>
</body>
</html>
