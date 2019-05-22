<%@page import="com.regnant.tim.operations.DocFileBean"%>
<%@page import="java.util.List"%>
<%@page import="com.regnant.tim.operations.DocCRUDOperations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Download Document Page</title>
<link rel="stylesheet" type="text/css" href="DownloadDoc.css">
<link
	href="https://fonts.googleapis.com/css?family=Bree+Serif|Libre+Baskerville|Rubik&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="header">
		<div class="company_name">
			<div class="company">
				<a href="Home.html">Trust In Me</a>
			</div>
			<span class="tagline">S H A R E S&nbsp;&nbsp;I N&nbsp;&nbsp;C A R T</span>
		</div>
	</div>
	<div class="section">
		<%
			DocCRUDOperations dop = new DocCRUDOperations();
			List<DocFileBean> list = dop.getDoc();
			for (DocFileBean d : list) {
		%>

		<form action="DownloadDocServlet" method="post">
			<input class="Document" type="submit" name="filename"
				value="<%=d.getFilepath()%>" />
		</form>
		<%
			}
		%>
	</div>
</body>
</html>