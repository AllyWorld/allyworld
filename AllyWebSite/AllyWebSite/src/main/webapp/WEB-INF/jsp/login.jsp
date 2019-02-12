<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Allyworld</title>
 <link rel="stylesheet" href='images/ally.png'>
    
<style>
label {
	font-size: 28px;
	color: orange;
	line-height: 70px;
}

input {
	font-size: 24px;
}

.one {
	font-size: 26px;
	position: absolute;
	left: 600px;
}

.two {
	font-size: 26px;
	position: absolute;
	left: 800px;
}

div {
	background-image: url("friends.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	width: 1408px;
	height: 620px;
	position: absolute;
	top: 90px;
}

hr {
	margin-top: -20px;
}

#lin {
	float: left;
	position: absolute;
	top: 10px;
}
</style>
</head>
<body>
${msg}
	<a id="lin" href="#"> <img src="ally.png" alt="allyworld Logo"
		width="200px" height="50px"></a>
	<h1 style="text-align: center; color: navy">Allyworld</h1>
	<hr>
	<div>
		<spring:form action="login" modelAttribute="profile">
			<h1 style="font-size: 50px; text-align: center">Login</h1>
			<table align=center>
				<tr>
					<td><label>UserName:</label></td>
					<td><input type="text" name="userId" value=""></td>
				</tr>
				<tr>
					<td><label>Password:</label></td>
					<td><input type="password" name="password" value=""></td>
				</tr>
				<tr>
					<td><input class="one" type="submit" name="submit"
						value="SUBMIT"></td>
					<td><input class="two" type="submit" name="submit"
						value="SignUp" formaction="RegistrationForm.jsp"></td>
				</tr>
			</table>
		</spring:form>
	</div>
</body>
</html>