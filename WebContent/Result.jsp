<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Success Page</title>
</head>
<body>
<% String msg = (String)request.getAttribute("message");
   out.println(msg);
%>
</body>
</html>