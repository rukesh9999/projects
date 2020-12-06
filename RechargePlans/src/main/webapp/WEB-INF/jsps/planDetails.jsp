<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored = "false"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-family:consolas ;font-size: 18px">
   <h2>Matching Plans</h2>
   <c:forEach items="${dtolist}" var="plan">
      ${plan.planNo} 
      ${plan.planName} 
      ${plan.plantype} 
      ${plan.validity} 
      ${plan.amount} 
   </c:forEach>
</body>
</html>