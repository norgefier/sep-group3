<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="styleSheet.css">
<style>
.carousel-inner img { margin: auto; }
p { color:white; }
h3 { color:white; }
</style>
<title>TravelPlanner Home Page</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<%if(session.getAttribute("message")!=null){%>
<div class="alert alert-<%=session.getAttribute("messageType")%>">
  	<%=session.getAttribute("message")%>
</div>
<%
	session.removeAttribute("message");
	session.removeAttribute("messageType");
} %>
<div class="container clear-top" style="box-shadow: 0px 0px 5px 2px #888888; background-color: #fff; padding: 18px">
<%User currentUser = (User)session.getAttribute("currentUser");%>
<div class = "row">
	<div class = "col-md-2">
	</div>
	<div class = "col-md-8">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
      <!-- image taken from https://66.media.tumblr.com/18435dacd3a8ab8f6461305cfb53c7e6/tumblr_nbaqc8zjMy1rxwrzxo1_500.gif -->
        <img src="lets_travel.gif" alt="world map with text lets travel">
        <div class="carousel-caption">
          <h3>TravelPlanner</h3>
          <p>The online trip planning website</p>
        </div>
      </div>

      <div class="item">
        <img src="hotel.jpg" alt="hotel room">
        <!-- image taken from http://24.media.tumblr.com/8d644f50b56105ea7c73733c3e560037/tumblr_n194u8v6Cd1sjzbu2o1_500.jpg -->
        <div class="carousel-caption">
          <h3>Accommodation</h3>
          <p>Keep track of accommodation locations and check in times</p>
        </div>
      </div>
    
      <div class="item">
        <img src="flights.jpg" alt="clouds out a plane window">
        <!-- image taken from http://az616578.vo.msecnd.net/files/2016/04/01/635951230043337648-217735111_Jet%20lag.jpg -->
        <div class="carousel-caption">
        <h3>Flights</h3>
          <p>Manage plane tickets so you never miss another flight</p>
        </div>
      </div>
      
      <div class="item">
        <img src="activity.jpg" alt="bungee jumping">
        <!-- image taken from https://s-media-cache-ak0.pinimg.com/originals/0a/bc/07/0abc075676f37b54e5864ee957b5fd94.jpg -->
        <div class="carousel-caption">
        <h3>Activities</h3>
          <p>Plan activities for while you travel</p>
        </div>
      </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a> 
    </div>
  </div>
	</div>
</div>
	
</div>
<jsp:include page="footer.jsp"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
