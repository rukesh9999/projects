<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>

<style type="text/css">

</style>

<meta charset="ISO-8859-1">
<title>CRM-Customer Relation Management</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/listcustomers.css">
</head>
<body>
<div style="background-color:DodgerBlue;">
<center> <h2>  CRM-Customer Relation Management </h2></center>
</div>

<div style="background-color: orange;">
   <marquee behavior="scroll" direction="left" style="color: blue">
      CRM-Customer Relation Management
   </marquee>
 </div><br/><br/>

 
<!--    add customer button -->  
<div>
   <button class="btn btn-primary" onclick="window.location.href='showFormForAddCustomer';return false">ADD Customer</button>
</div>

<form:form action="search" method="get">
<label style="color: green">Search customer:</label><input style="color: red" type="text" name="searchByName" />
<input type="submit" onclick="window.location.href='search';return false" value="search" class="btn btn-primary" >
</form:form>

<center>  <table style="width:80%"  border="5">
  <tr>
   <th> Id</th>
   <th> FirstName</th>
   <th> lastName </th>
   <th> Email </th>
   <th> Action </th>
   
   </tr>  
   
    <c:forEach items="${listOfCustomers}" var="customer" >
    
    <c:url var="updateLink" value="/customer/showFormForUpdate" >
        <c:param name="customerId" value="${customer.id}"/>
    </c:url>
    
    <c:url var="deleteLink" value="/customer/deleteCustomer" >
        <c:param name="customerId" value="${customer.id}"/>
    </c:url>
    
      <tr> 
       <td>${customer.id}</td>
       <td>${customer.firstName} </td>
       <td>${customer.lastName} </td>
       <td>${customer.email}</td>
        
      <!-- display update and delete  link using path variable -->  
      <%--  <td><a href="${pageContext.request.contextPath}/customer/showFormForUpdate/${customer.id}">edit</a>  
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath}/customer/deleteCustomer/${customer.id}">delete</a>  
       </td>  --%>
       
       
      <!-- display update and delete  link using RequesrParam variable -->  
       
     <td><a href="${updateLink}">Update</a> 
         <a style="color:red" href="${deleteLink}" onclick="if(!(confirm('Are you sure You want to delete this customer?'))) return false">delete</a></td>
         </tr>
   </c:forEach>
   
     
  </table></center></br></br>
 
 
<div style="background-color:DodgerBlue;">
<footer>
  <h2>CopyRight &copy; 2018 Pioneer-Soft</h2>
  <p>All Rights are Reserved</p>
  <p>Developed & maintained by Pioneer-Soft</p>
</footer>
</div>



</body>
</html>