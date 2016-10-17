<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
input[type=button] {color:black; background-color:lightgrey}
input[type=submit] {color:black; background-color:lightgrey}
table {
	width:50%;
}

table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
}
table#t01 tr:nth-child(odd) {
   background-color: #eee;
}
table#t01 th {
    background-color: grey;
    color: white;
}
label {
	font-weight: bold;
}
</style>

<%String path = request.getContextPath(); %>

<title>Travel Planner - Add Flight</title>

</head>
<body>
	<h1>Add Flight</h1>
	<form method="post" action="travelPlanForm.jsp">

	<table id="t01">
	  <tr>
		
	    <th colspan="3"><img src="https://www.tripotrip.com/sutitravel_contentfiles/agent_b2c/tripotrip/images/flight-icon2.png" alt="Flight"> FLIGHT </th>
	  </tr>
	  <tr>
	    <td><label>Flight No.</label><br><input type="text" name="flightNo"></td>
	    <td><label>Seat No.</label><br><input type="text" name="seatNo"></td>
	    <td><label>Airline</label><br><input type="text" name="airline"></td>
	  </tr>
	  
	  <tr>
	    <td><label for="depDate">Departure Date</label><br><input id="depDate" type="date" value="dd/mm/yyyy" name="depDate"></td>
	    <td><label for="depTime">Departure Time</label><br><input id="depTime" type="time" value="hh:mm AM" name="depTime"></td>
	    <td><label>Departure Location</label><br><input type="text" name="depLoc"></td>
	  </tr>
	  
	  <tr>
	    <td><label for="arrDate">Arrival Date</label><br><input id="arrDate" type="date" value="dd/mm/yyyy" name="arrDate"></td>
	    <td><label for="arrTime">Arrival Time</label><br><input id="arrTime" type="time" value="hh:mm AM" name="arrTime"></td>
	    <td><label>Arrival Location</label><br><input type="text" name="arrLoc"></td>
	  </tr>
	  
	  <tr>
	  	<td colspan="3"><label>Notes</label>
	  	<br><textarea rows="4" cols="70" id='notes' name='notes' ></textarea></td>
	  </tr>
	  </table>
	   
	<br>
	<input type="Submit" value="Submit">
	<input type="button" value="Cancel" onclick="parent.location='travelPlanForm.jsp'">
	</form>
</body>
</html>