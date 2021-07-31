<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
		<h1 >Add Employee</h1>
		<form action="EmployeeController" method="post">
		<div class="form-row">

			<div class="form-group">
				<label for="lbleid">Employee ID</label> 
				<input type="number" class="form-control" id="lbleid" name="txteid" placeholder="Enter EID">
			</div>

			<div class="form-group">
				<label for="lblename">Employee Name </label> 
				<input type="text"	class="form-control" id="lblename" name="txtename" placeholder="Enter Name">
			</div>
			<div class="form-group">
				<label for="lbldept">Department </label> 
				<input type="text"	class="form-control" id="lbldept" name="txtdept" placeholder="Enter Department">
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Add Employee</button>
	</form>
</body>
</html>