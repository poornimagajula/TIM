<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
File: <br />
<form action="UploadDocServlet" method="post"
                        enctype="multipart/form-data">
<input type="file" name="test_file" size="50" />
<br />
<input type="submit" value="Upload" />
</form>
</body>
</html>

