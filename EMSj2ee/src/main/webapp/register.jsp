<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<h1> Register Form</h1>
<form action="Login?action=NEWUSER" method="get">
			<table style="with: 50%">
				<tr>
					<td>Empoyee Id</td>
					<td><input type="number" name="EmployeeID" /></td>
				</tr>
				<tr>
					<td>Full Name</td>
					<td><input type="text" name="fullname" /></td>
				</tr>
				
					<tr>
					<td>Password</td>
					<td><input type="text" name="password" /></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><input type="number" name="contact" /></td>
				</tr>				
				</table>
				<button type="submit" name="action" value="NEWUSER" class="btn btn-primary">Submit</button>
				
			</form>	
</body>
</html>
 