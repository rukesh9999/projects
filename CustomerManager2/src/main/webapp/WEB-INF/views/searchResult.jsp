<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div align="center">
              <h1>SEARCH RESULT</h1>     
         <table border="1" padding="5">
         
          <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>EMAIL</th>
            <th>ADDRESS</th>
            <th>ACTION</th>
          </tr>
          
          
          
          <c:forEach items="${searchcustomer} " var="customer">
            <tr>
             <td>${customer.id}</td>
             <td>${customer.name} </td>
             <td>${customer.email}</td>
             <td>${customer.address}</td>      
            </tr>
          </c:forEach>
        
         </table>
         
   </div>
         
         
</body>
</html>