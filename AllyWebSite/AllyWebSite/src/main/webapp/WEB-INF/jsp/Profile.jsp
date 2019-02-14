<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
<link href="css/style.css" media="screen" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: 50px;
  text-align: center;
  font-family: arial;
}
 
.title {
  color: grey;
  font-size: 18px;
}
 
button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}
 
 
button:hover, a:hover {
  opacity: 0.7;
}
.image {
    height:auto;
    padding-right: 50px;
    padding-left:50px;
}
</style>

<title>Ally_World</title>
</head>
<body>


	<nav class="navbar navbar-expand-sm bg-info navbar-dark fb-nav">
		<div class="wrapper">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExampleDefault"
				aria-controls="navbarsExampleDefault" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarsExampleDefault">
				<a class="navbar-brand">ALLY-WORLD</a>
				<spring:form class="form-inline top-form" action="searchPeople">
					<input class="form-control" type="text" name="fullName" value="" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-secondary " type="submit">
						<i class="fas fa-search"> </i>
					</button>
				</spring:form>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="home">Home</a>
					</li>
					<span class="border-right"></span>
					<li class="nav-item active"><a class="nav-link"
						href="Profile.jsp" routerLink="/profile-view"><img src=""
							width="30" height="30" style="border-radius: 50%" alt=""><strong>Profile</strong></a>
					</li>
					<span class="border-right"></span>
					<li class="nav-item"><a class="nav-link" href="#"><i
							class="fas fa-user-friends"></i></a></li>
					<li class="nav-item"><a class="nav-link"
						routerLink="https://localhost:8080"><i
							class="fas fa-comment-alt"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="#"><i
							class="fas fa-bell"></i></a></li>
					<li class="nav-item"><a class="nav-link" href="#"><i
							class="fas fa-question-circle"></i></a></li>
					<span class="border-right"></span>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="dropdown01"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></a>
						<div>
							 <a href="logout">LogOut</a>
						</div></li>
				</ul>
			</div>
			</div>
	</nav>

<spring:form action="Profilepage" modelAttribute="profile">
<h2 style="text-align:center">Profile Details</h2>
 <div class="card">
  <img class="image" src="images/ally.png" alt="John" style="width:100%">
  <h1>${message.fullName}</h1>
  <p class="title">Lives in ${message.currentAddress }</p>
  <p>From ${message.permanentAddress }</p>
  <p>Born on ${message.dateOfBirth }</p>
  <p>relationship status ${message.relationShipStatus}</p>
   
  <p><button>Update Profile</button></p>
</div>
</spring:form>
</body>
</html>