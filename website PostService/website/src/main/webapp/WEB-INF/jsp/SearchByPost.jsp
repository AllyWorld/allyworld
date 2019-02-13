<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="searchByPostId" method="post">
	Enter Post Id: <input type="number" name="postId" /><br /><br />
		 <input type="submit" value="Submit"><br />

	</form><br /><br />
	<div>
		<jsp:include page="HomeLink.html"></jsp:include>
	</div>
</body>
</html>