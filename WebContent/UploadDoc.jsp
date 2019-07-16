<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Documents Page</title>
<link rel="stylesheet" type="text/css" href="GetDoc.css">
<link href="https://fonts.googleapis.com/css?family=Bree+Serif|Libre+Baskerville|Rubik&display=swap" rel="stylesheet">
</head>
<body background="uploaddoc_bg.png">
<!-- 	<div class="header">
		<div class="company_name">
			<div class="company"><a href="Home.html">Trust In Me</a></div>				
			<span class="tagline">S H A R E S&nbsp;&nbsp;I N&nbsp;&nbsp;C A R T</span>			
		</div>
	</div> -->
	
	<div class="upload">
		File: <form action="UploadDocServlet" method="post" enctype="multipart/form-data">
			<input type="file" name="test_file" size="50" /><br />
			<input class="button" type="submit" value="Upload" />
		</form>
	</div>
</body>
</html>



	
	
	
