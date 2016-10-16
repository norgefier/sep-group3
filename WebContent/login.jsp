 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="styleSheet.css">
<title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<% String filePath = application.getRealPath("WEB-INF/users.xml"); %>
<jsp:useBean id="users" class="models.TravelPlanner" scope="application">
    <jsp:setProperty name="users" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>

<div class="container clear-top" style="box-shadow: 0px 0px 5px 2px #888888; background-color: #fff; padding: 18px">
<% 
if(request.getParameter("regemail") != null)
{
	try
	{
		users.addUser(request.getParameter("regemail"), request.getParameter("regpassword"), request.getParameter("regfirstName"), request.getParameter("reglastName"), request.getParameter("regmobile"));
		session.setAttribute("message", "Registration complete. Please login.");
		session.setAttribute("messageType", "success");
	}
	catch(IllegalArgumentException e)
	{
		session.setAttribute("message", e);
		session.setAttribute("messageType", "danger");
	}
}%>

<%if(session.getAttribute("message")!=null){%>
	<div class="alert alert-<%=session.getAttribute("messageType")%>">
	  	<%=session.getAttribute("message")%>
	</div>
	<%
		session.removeAttribute("message");
		session.removeAttribute("messageType");
	} %>
	
<ol class="breadcrumb">
		  <li><a href="index.jsp">Home</a></li>
		  <li class="active">Login</li>
		</ol>
<h1 align="center">Login</h1>


<form action="profile.jsp" method="POST">
<table align="center" cellpadding="90">

<div class = "row">
	<div class = "col-md-4">
	</div>
	<div class = "col-md-4">
	<div class = "form-group">
        		<label for = "title" class = "control-label">Email:</label>
        		<input class = "form-control" type="text" name="email">
	</div>
	</div>
</div>

<div class = "row">
	<div class = "col-md-4">
	</div>
	<div class = "col-md-4">
		<div class = "form-group">
        		<label for = "title" class = "control-label">Password: </label>
        		<input class = "form-control" type="password" name="password">
		</div>
	</div>
</div>

<div class = "row">
	<div class = "col-md-4">
	</div>
	<div class = "col-md-4">
		<input class = "btn btn-primary" type="submit" value="Login">
	</div>
</div>


</table>
</form>
</div>
<jsp:include page="footer.jsp"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
