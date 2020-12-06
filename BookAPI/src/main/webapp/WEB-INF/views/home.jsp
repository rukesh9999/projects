<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>

<style type="text/css">

body{
            font-family: "Comic Sans MS", sans-serif;
            margin: 0;
           // background-image: url("images/water_flow.gif");
            background-size: cover;
            color: white;
        }
        
        
td{
    color:yellow;
    padding: 7px;
    font-size: 18px;
   }  
   
   
   footer{
   text-align: center;
   }   
   
  
</style>



<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<div style="background-color:DodgerBlue;">
<center> <h2>  BOOK DETAILS </h2></center>
</div>

<div style="background-color: orange;">
   <marquee behavior="scroll" direction="left" style="color: blue">

   </marquee>
 </div>

 
   
  

<center>  <table style="width:80%"  border="5">
  <tr>
   <th> ID</th>
   <th> Author</th>
   <th> TITLE </th>
       
   </tr>  
   
    <c:forEach items="${bookslist}" var="book" >
    
      <tr> 
       <td>${book.id} </td>
       <td>${book.title} </td>
       <td>${book.author}</td>
      <%--  <td><a href="editRecruitedCandidate?id=${book.id}">edit</a>  
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <a href="deleteRecruitedCandidateServlet?id=${book.id}">delete</a>  </td>
    --%>    
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