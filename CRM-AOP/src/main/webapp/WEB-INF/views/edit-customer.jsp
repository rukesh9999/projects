<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/listcustomers.css">
<title>Update Customer</title>
</head>
<body>
 
 <form:form action="saveCustomer" modelAttribute="customer" method="post">
   <table>
   <tbody>
   
   <tr>
   <td> <label>Id : </label></td>
   <td><form:hidden path="id"/></td>
   
   </tr>
   
   <tr>
   <td> <label>First Name: </label></td>
   <td><form:input path="firstName"/></td>
   </tr>
   
   <tr>
   <td> <label>Last Name: </label></td>
   <td><form:input path="lastName"/></td>
   </tr>
   
   <tr>
   <td> <label>Email : </label></td>
   <td><form:input path="email"/></td>
   </tr>
   
   <tr>
   <td> <label> </label></td>
   <td><input type="submit" value="Save" class="btn btn-primary"></td>
   </tr>
   
   </tbody>
   
   </table>
 </form:form>
 
  <div style="clear;both;">
  <p>
    <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
  </p>
  </div>
 
</body>
</html>