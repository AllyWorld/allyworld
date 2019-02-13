<%@ page isELIgnored="false"  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
 
 
<!-- jQuery library -->
 
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
 
<!-- Popper JS -->
 
<script
    src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
 
 
<!-- Latest compiled JavaScript -->
 
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
 
 
</head>
<style type="text/css">
th, td {
    padding: 1px;
    background-color: lightblue
}
</style>
 
<body>

<table class="table table-bordered">
		<tr> 
			<th> PostId </th>
			<th> ProfileId </th>
			<th> Status</th>
			<th> Url </th>
			<th> Date </th>
			<th> Likes </th>
			<th> LikesProfileIds </th>
			<th> CommentsProfileIds </th>
			<th> Comments </th>
			<th> commentTime </th>
			<th> commentLikes </th>
		</tr>
		<jstl:if test="${post !=null}">
				<tr>
				<td>${post.postId}</td>
				<td>${post.profileId }</td>
				<td>${post.status}</td>
				<td>${post.url}</td>
				<td>${post.date}</td>
				<td>${post.likes.likes}</td>
				<td>${post.likes.likesProfileId}</td>
				<td>${post.comments.commentProfileId}</td>
				<td>${post.comments.comment}</td>
				<td>${post.comments.commentTime}</td>
				<td>${post.comments.likes}</td>
				</tr>
		</jstl:if> 
		<jstl:if test="${posts!=null}">
			<jstl:forEach var="post" items="${posts}">
				<tr>
					<td>${post.postId}</td>
					<td>${post.profileId}</td>
					<td>${post.status}</td>
					<td>${post.url}</td>
					<td>${post.date}</td>
					<td>${post.likes.likes}</td>
					<td>${post.likes.likesProfileId}</td>
					<td>${post.comments.commentProfileId}</td>
					<td>${post.comments.comment}</td>
					<td>${post.comments.commentTime}</td>
					<td>${post.comments.likes}</td>
				</tr>
			</jstl:forEach>
		</jstl:if>
	</table>
</body>
</html>