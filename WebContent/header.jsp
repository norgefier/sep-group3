<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%User currentUser = (User)session.getAttribute("currentUser");
String active = request.getParameter("active");
if(active == null){
	active = "home";
}
//Nav Bar display
//User logged in
if(currentUser != null){%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">TravelPlanner</a>
    </div>
    <ul class="nav navbar-nav">
      <li <%if(active.equals("home")){ %>class="active"<%} %>><a href="index.jsp">Home</a></li>
      <li <%if(active.equals("profile")){ %>class="active"<%} %>><a href="profile.jsp"> Your Profile</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
	  <a href="logout.jsp" class = "btn btn-default btn-lg" role="button">Log out</a>
    </ul>
  </div>
</nav>
<!--user not logged in -->
<%}else{%>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand">TravelPlanner</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li <%if(active.equals("home")){ %>class="active"<%} %>><a href="index.jsp">Home</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
		  <a href="register.jsp" class = "btn btn-default btn-lg" role="button">Register</a>
		  <a href="login.jsp" class = "btn btn-default btn-lg" role="button">Login</a>
	    </ul>
	  </div>
</nav>
<%}%>
</html>
