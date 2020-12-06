<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">

<h2>EDIT CUSTOMER</h2>
<form:form  action="/savecustomer.htm" method="post" modelAttribute="savecustomer">

<table  border="0" cellpadding="5">
    
    <tr>
       <td> ID:</td>
       <td>${customer.id}
         <form:hidden path="id"/>
       </td>
    </tr>
    
    <tr>
       <td>NAME:</td>
       <td><form:input path="name"/></td>
    </tr>
     
     <tr>
        <td>EMAIL</td>
        <td><form:input path="email"/></td>
    </tr>
     
     <tr>
       <td>ADDRESS</td>
       <td><form:input path="address"/></td>
    </tr>
     
     <tr>
       <td colspan="2"><input type="submit" value="submit"></td>
    </tr>
     
     
     
</table>

</form:form>

</div>

</body>
</html>