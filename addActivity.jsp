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
	<h1>Add Activity</h1>
	<form method="post" action="travelPlanForm.jsp">

	  <table id="t01">
	  <tr>
	    <th colspan="3"><img src="http://www.endolite.com/catalogue/icons/icon-activitylevel.jpg" alt="Activity"> ACTIVITIES </th>	
	  </tr>
	  <tr>
	    <td><label>Name of Activity</label><br><input type="text" name="activityName"></td>
	  	<td><label>Address</label><br><input type="text" name="activityAddress"></td>
	  </tr>
	  <tr>
	    <td><label for="activityStartDate">Start Date</label><br><input id="activityStartDate" type="date" value="dd/mm/yyyy" name="activityStartDate"></td>
	    <td><label for="activityStartTime">Start Time</label><br><input id="activityStartTime" type="time" value="hh:mm AM" name="activityStartTime"></td>
	  </tr>
	  <tr>
	    <td><label for="activityEndDate">End Date</label><br><input id="activityEndDate" type="date" value="dd/mm/yyyy" name="activityEndDate"></td>
	    <td><label for="activityEndTime">End Time</label><br><input id="activityEndTime" type="time" value="hh:mm AM" name="activityEndTime"></td>
	  </tr>
	  <tr>
	    <td><label>Price ($AUD)</label><br><input type="text" name="activityPrice"></td>
	    <td><label>Paid</label><br>
	    	<select name="activityPaid">
	    		<option value="yes">Yes</option>
	    		<option value="no">No</option>
	    	</select>
	    </td>
	  </tr>
	  </table>

	<br>
	<input type="submit" value="Submit">
	<input type="button" value="Cancel" onclick="parent.location='travelPlanForm.jsp'">
	</form>
</body>
</html>