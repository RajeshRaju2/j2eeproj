<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee-List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<form action="EmployeeController?action=SEARCH" method="get">
		<div class="form-row">

			<div class="form-group">
				<label for="lbleid">Employee ID</label> 
				<input type="number" class="form-control" id="lbleid" name="txteid" placeholder="Enter EID">
			</div>
		<button type="submit"  name="action" value="SEARCH"  class="btn btn-primary">Search</button>
			
		</div>
	</form>
<table class="table">
  <thead>
    <tr>
      <th scope="col">eid</th>
      <th scope="col">ename</th>
      <th scope="col">dept</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="emp" items="${allemp}">
    <tr>
     	<td><c:out value="${emp.eid}"></c:out></td>
        <td><c:out value="${emp.ename}"></c:out></td>
        <td><c:out value="${emp.dept}"></c:out></td>
        <td><a href="EmployeeController?action=EDIT&eid=${emp.eid}&ename=${emp.ename}&dept=${emp.dept}">Edit</a></td>
         <td><a href="EmployeeController?action=DELETE&eid=${emp.eid}">Delete</a></td>
    </tr>
   </c:forEach>
  </tbody>
</table>

</body>
</html>