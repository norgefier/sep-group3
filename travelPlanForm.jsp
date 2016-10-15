<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
input[type=button] {color:black; background-color:lightgrey}
input[type=submit] {color:black; background-color:lightgrey}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%String path = request.getContextPath(); 
String depLoc = (String) request.getParameter("depLoc");
String arrLoc = (String) request.getParameter("arrLoc");
String depDate = (String) request.getParameter("depDate");
String depTime = (String) request.getParameter("depTime");
String flightNo = (String) request.getParameter("flightNo");
String seatNo = (String) request.getParameter("seatNo");

String accomName = (String) request.getParameter("accomName");
String accomCity = (String) request.getParameter("accomCity");
String accomAddress = (String) request.getParameter("accomAddress");
String checkInDate = (String) request.getParameter("checkInDate");
String checkInTime = (String) request.getParameter("checkInTime");
String checkOutDate = (String) request.getParameter("checkOutDate");
String checkOutTime = (String) request.getParameter("checkOutTime");

String activityName = (String) request.getParameter("activityName");
String activityAddress = (String) request.getParameter("activityAddress");
String activityStartDate = (String) request.getParameter("activityStartDate");
String activityStartTime = (String) request.getParameter("activityStartTime");
String activityEndDate = (String) request.getParameter("activityEndDate");
String activityEndTime = (String) request.getParameter("activityEndTime");
String activityPrice = (String) request.getParameter("activityPrice");

%>
<title>Travel Plan</title>
<style>

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
</head>
<body>
	<h1>Travel Plan</h1>
	<form method="post" action="welcome.jsp">

	<tr>
	<td><label>Plan Name </label><input id="planName" type="text"></td>
	<td><br></td>
	<td><label for="startDate">Start Date </label><input id="startDate" type="date" value="dd/mm/yyyy" name="startDate"/></td>
	<td><label for="endDate">End Date </label><input id="endDate" type="date" value="dd/mm/yyyy" name="endDate"/>
	<td><br></td>
	<td colspan="3"><label>Description</label>
	  	<br><textarea rows="4" cols="70" id='description' name='description' ></textarea></td>

	<!-- Date and Time just apply for Chrome 20 & Opera 11-->
	</tr>
	<br>

	<table id="t01">
		<tr>
		  <th colspan="8"><img src="https://www.tripotrip.com/sutitravel_contentfiles/agent_b2c/tripotrip/images/flight-icon2.png" alt="Flight"> FLIGHT </th>
		</tr>
		<tr><td><b>Departure Location</b></td>
			<td><b>Arrival Location</b></td>
			<td><b>Departure Date/Time</b></td>
			<td><b>Flight No.</b></td>
			<td><b>Seat No.</b></td>
			<td><b>Edit</b></td>
			<td><b>Delete</b></td>

		<tr><td><%= depLoc %></td>
			<td><%= arrLoc %></td>
			<td><%= depDate %> / <%= depTime %></td>
			<td><%= flightNo %></td>
			<td><%= seatNo %></td>
			<td><input type="button" value="Edit" onclick="parent.location='addFlight.jsp'"></td>
			<td><input type="button" id="deleteRow" value="X" onClick="deleteRow(this)"></td>
	   </table>
	   <br>
		</tr>	
		<tr><td><input type="button" value="Add Flight" onclick="parent.location='addFlight.jsp'"></td></tr>
		<br>
		
<script language="JavaScript">
var count=0;

function deleteRow(row){
	var i=row.parentNode.parentNode.rowIndex;
	document.getElementById("t01").deleteRow(i);
}

function insRow()
{
	var table=document.getElementById('t01');
	var rowCount = table.rows.length;
	var row = table.insertRow(rowCount);
	
	var tripTitle = row.insertCell(0);
	var element1 = document.createTextNode("depLoc");
	tripTitle.appendChild(element1);
	
	var tripTitle = row.insertCell(1);
	var element1 = document.createTextNode("arrLoc");
	tripTitle.appendChild(element1);
	
	var destination = row.insertCell(2);
	var element1 = document.createTextNode("DepDate");
	destination.appendChild(element1);
	
	var departDate = row.insertCell(3);
	var element1 = document.createTextNode("flightNo");
	departDate.appendChild(element1);
	
	var retDate = row.insertCell(4);
	var element1 = document.createTextNode("seatNo");
	retDate.appendChild(element1);
	
	var share = row.insertCell(5);
	var element1 = document.createElement("input");
	element1.type = "button";
	element1.value = "Edit";
	share.appendChild(element1);
	
	var del = row.insertCell(6);
	var delButt = document.createElement("input");
	delButt.type = "button";
	delButt.value = "Delete";
	del.appendChild(delButt);
}
</script>

	   
	  <table id="t01">
	  <tr>
	    <th colspan="8"><img src="https://aphv-a.akamaihd.net/sites/default/files/bedrooms_icon.png" alt="Accommodation"> ACCOMODATION </th>
	  </tr>
	  <tr><td><b>Name</b></td>
			<td><b>City</b></td>
			<td><b>Address</b></td>
			<td><b>Check In Date/Time</b></td>
			<td><b>Check Out Date/Time</b></td>
			<td><b>Edit</b></td>
			<td><b>Delete</b></td>

		<tr><td><%= accomName %></td>
			<td><%= accomCity %></td>
			<td><%= accomAddress %></td>
			<td><%= checkInDate %> / <%= checkInTime %></td>
			<td><%= checkOutDate %> / <%= checkOutTime %></td>
			<td><input type="button" value="Edit" onclick="parent.location='addAccomodation.jsp'"></td>
			<td><input type="button" id="deleteRow" value="X" onClick="deleteRow(this)"></td>
	   </table>
	   <br>
		</tr>	
		<tr><td><input type="button" value="Add Accomodation" onclick="parent.location='addAccomodation.jsp'"></td></tr>
		<br>
		
<script language="JavaScript">
var count=0;

function deleteRow(row){
	var i=row.parentNode.parentNode.rowIndex;
	document.getElementById("t01").deleteRow(i);
}

function insRow()
{
	var table=document.getElementById('t01');
	var rowCount = table.rows.length;
	var row = table.insertRow(rowCount);
	
	var tripTitle = row.insertCell(0);
	var element1 = document.createTextNode("accomName");
	tripTitle.appendChild(element1);
	
	var destination = row.insertCell(1);
	var element1 = document.createTextNode("accomCity");
	destination.appendChild(element1);
	
	var departDate = row.insertCell(2);
	var element1 = document.createTextNode("accomAddress");
	departDate.appendChild(element1);
	
	var retDate = row.insertCell(3);
	var element1 = document.createTextNode("checkInDate");
	retDate.appendChild(element1);
	
	var retDate = row.insertCell(4);
	var element1 = document.createTextNode("checkOutDate");
	retDate.appendChild(element1);
	
	var share = row.insertCell(5);
	var element1 = document.createElement("input");
	element1.type = "button";
	element1.value = "Edit";
	share.appendChild(element1);
	
	var del = row.insertCell(6);
	var delButt = document.createElement("input");
	delButt.type = "button";
	delButt.value = "Delete";
	del.appendChild(delButt);
}
</script>
	  
	  <table id="t01">
	  <tr>
	    <th colspan="8"><img src="http://www.endolite.com/catalogue/icons/icon-activitylevel.jpg" alt="Activity"> ACTIVITIES </th>	
	  </tr>
	  <tr><td><b>Name</b></td>
			<td><b>Address</b></td>
			<td><b>Start Date/Time</b></td>
			<td><b>End Date/Time</b></td>
			<td><b>Price</b></td>
			<td><b>Edit</b></td>
			<td><b>Delete</b></td>

		<tr><td><%= activityName %></td>
			<td><%= activityAddress %></td>
			<td><%= activityStartDate %> / <%= activityStartTime %></td>
			<td><%= activityEndDate %> / <%= activityEndTime %></td>
			<td><%= activityPrice %></td>
			<td><input type="button" value="Edit" onclick="parent.location='addActivity.jsp'"></td>
			<td><input type="button" id="deleteRow" value="X" onClick="deleteRow(this)"></td>
	   </table>
	   <br>
		</tr>	
		<tr><td><input type="button" value="Add Activity" onclick="parent.location='addActivity.jsp'"></td></tr>
		<br>
		
<script language="JavaScript">
var count=0;

function deleteRow(row){
	var i=row.parentNode.parentNode.rowIndex;
	document.getElementById("t01").deleteRow(i);
}

function insRow()
{
	var table=document.getElementById('t01');
	var rowCount = table.rows.length;
	var row = table.insertRow(rowCount);
	
	var tripTitle = row.insertCell(0);
	var element1 = document.createTextNode("activityName");
	tripTitle.appendChild(element1);
	
	var destination = row.insertCell(1);
	var element1 = document.createTextNode("activityAddress");
	destination.appendChild(element1);
	
	var departDate = row.insertCell(2);
	var element1 = document.createTextNode("activityStartDate");
	departDate.appendChild(element1);
	
	var retDate = row.insertCell(3);
	var element1 = document.createTextNode("activityEndDate");
	retDate.appendChild(element1);
	
	var retDate = row.insertCell(3);
	var element1 = document.createTextNode("activityPrice");
	retDate.appendChild(element1);
	
	var share = row.insertCell(5);
	var element1 = document.createElement("input");
	element1.type = "button";
	element1.value = "Edit";
	share.appendChild(element1);
	
	var del = row.insertCell(4);
	var delButt = document.createElement("input");
	delButt.type = "button";
	delButt.value = "Delete";
	del.appendChild(delButt);

}
</script>

	<br>
	<input type="button" value="Save" onclick="parent.location='profile.jsp'">
	<input type="button" value="Cancel" onclick="parent.location='profile.jsp'">
	</form>
</body>
</html>
