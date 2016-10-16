<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="styleSheet.css">
<title>Profile</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<% String filePath = application.getRealPath("WEB-INF/users.xml"); %>
<jsp:useBean id="users" class="models.TravelPlanner" scope="application">
    <jsp:setProperty name="users" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>

<%	User currentUser = (User) session.getAttribute("currentUser");
	if (currentUser == null)
	{
		try
		{
			currentUser = users.login(request.getParameter("email"), request.getParameter("password"));
			session.setAttribute("currentUser", currentUser);
		}
		catch (java.lang.IllegalArgumentException e)
		{
			session.setAttribute("message", e);
			session.setAttribute("messageType", "danger");
			String redirectURL = "login.jsp";
			response.sendRedirect(redirectURL);
		}
	}
	else
	{
		session.setAttribute("currentUser", currentUser);
%>

<div class="container clear-top" style="box-shadow: 0px 0px 5px 2px #888888; background-color: #fff; padding: 18px">
<h1>Look, it's a profile page</h1>
<h3>Welcome <%=currentUser.getFirstName()%></h3>
<!-- Profile page goes here -->


<% } %>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
