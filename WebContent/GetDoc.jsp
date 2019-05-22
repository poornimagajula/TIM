<!DOCTYPE html>
<%@page import="com.regnant.tim.operations.DocFileBean"%>
<%@page import="java.util.List"%>
<%@page import="com.regnant.tim.operations.DocCRUDOperations"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Documents Page</title>
<link rel="stylesheet" type="text/css" href="GetDoc.css">
<link href="https://fonts.googleapis.com/css?family=Bree+Serif|Libre+Baskerville|Rubik&display=swap" rel="stylesheet">
</head>
<body>
	<div class="header">
		<div class="company_name">
			<div class="company"><a href="Home.html">Trust In Me</a></div>				
			<span class="tagline">S H A R E S&nbsp;&nbsp;I N&nbsp;&nbsp;C A R T</span>			
		</div>
	</div>
	
	<%
		DocCRUDOperations dop=new DocCRUDOperations();
		List<DocFileBean> list=dop.getDoc();
		for(DocFileBean d:list) {		
	%>
	<div class="Document">
		<a href=<%=d.getFilepath() %> class="anchor"><%=d.getFilepath() %></a>
	</div>
	<%}%>
		
	
</body>
</html>