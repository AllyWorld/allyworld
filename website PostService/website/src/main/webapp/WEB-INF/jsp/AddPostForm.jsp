<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="createNewPost" >
		Enter PostId: <input type="text" name="postId"/> <br /> <br />
		Enter ProfileId:<input type="text" name="profileId"/> <br /> <br />
		Enter Status:  <input type="text" name="status"/><br /> <br />
		Enter Url: <input type="url" name="url"/> <br /> <br />
		Enter No Of Likes Of Post:<input type="number" name="likes"> <br /> <br />
		Enter Id's Of Profile Likes Post: <input type="number" name="likesProfileId"/> <br /> <br /> 
		Enter Id's Of Profile comments Post: <input type="number" name="commentProfileId"/> <br /> <br />
		Comment On Post: <input type="text" name="comment"/> <br /> <br />
		Enter No Of Likes Of Comment:<input type="number" name="likesComment"><br /> <br />
  		<input type="submit" value="submit">
		<input type="Reset" value="Reset">
	</form><br />
	<div>
		<jsp:include page="HomeLink.html"></jsp:include>
	</div>
</body>
</html>                                                                                                                                                                                                                                                                                                                                         