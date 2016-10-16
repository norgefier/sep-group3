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
<%String path = request.getContextPath(); %>
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
	<h1>Add Accomodation</h1>
	<form method="post" action="travelPlanForm.jsp">

	  <table id="t01">
	  <tr>
	    <th colspan="3"><img src="https://aphv-a.akamaihd.net/sites/default/files/bedrooms_icon.png" alt="Accommodation"> ACCOMODATION </th>
	  </tr>
	  <tr>
	    <td colspan="3"><label>Name of Accommodation</label><br><input type="text" name="accomName"></td>
	  </tr>	
	  <tr>
	    <td><label>City</label><br><input type="text" name="accomCity"></td>
		<td><label>Address</label><br><input type="text" name="accomAddress"></td>
	  </tr>	
	  <tr>
	    <td><label for="checkInDate">Check-In Date</label><br><input id="checkInDate" type="date" value="dd/mm/yyyy" name="checkInDate"></td>
	    <td><label for="checkInTime">Check-In Time</label><br><input id="checkInTime" type="time" value="hh:mm AM" name="checkInTime"></td>
	  </tr>
	  <tr>
	    <td><label for="checkOutDate">Check-Out Date</label><br><input id="checkOutDate" type="date" value="dd/mm/yyyy" name="checkOutDate"></td>
	    <td><label for="checkOutTime">Check-Out Time</label><br><input id="checkOutTime" type="time" value="hh:mm AM" name="checkOutTime"></td>
	  </tr>
	  <tr>
	    <td><label>Price ($AUD)</label><br><input type="text" name="accomPrice"></td>
	    <td><label>Paid</label><br>
	    	<select name="activityPaid">
	    		<option value="yes">Yes</option>
	    		<option value="no">No</option>
	    	</select>
	    </td>
	  </tr>
	  <tr>
	  	<td colspan="3"><label>Notes</label>
	  	<br><textarea rows="4" cols="70" id='accomNotes' name='accomNotes' ></textarea></td>
	  </tr>	
	  </table>
	  
	<br>
	<input type="submit" value="Submit">
	<input type="button" value="Cancel" onclick="parent.location='travelPlanForm.jsp'">
	</form>
</body>
</html>
