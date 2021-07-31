<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Login?action=VALIDATE" method="post">
	<div class="form-row">

			<div class="form-group">
				<label for="lbleid">Employee ID</label> 
				<input type="number" class="form-control" id="lbleid" name="txteid" placeholder="Enter EID">
			</div>
			
		<div class="form-group">
						<label for="lblpass">PassWord</label> 
				<input type="text" class="form-control" id="lbleid" name="txtpass" placeholder="Enter Pass Word">
		</div>
		</div>
		<button type="submit" name="action" value="VALIDATE" class="btn btn-primary">Submit</button>
		<div><a href="register.jsp">New User</a></div>
	</form>
	
</body>
</html>