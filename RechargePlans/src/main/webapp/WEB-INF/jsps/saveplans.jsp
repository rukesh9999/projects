<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Search Plans</title>
</head>
<body style="font-family:consolas ;font-size: 18px">
<h2>SAVE PLANS</h2>
 <form action="/planDetails.htm"  method="post">
 <table>
 
 <tr>
 <td>PlanNo</td>
 <td><input type="text" name="planNo"></td>
 </tr>
 
 <tr>
 <td>PlanName</td>
 <td><input type="text" name="planName"></td>
 </tr>
 
 
 
 <tr>
 	<td>PlanType</td>
 	<td><select name="planType">
 	     <option value="recharge">Recharge</option>
 	     <option value="dataplan">Dataplan</option>
 	     <option value="InfinityPlan">InfinityPlan</option>
 	  </select></td>
 </tr>
 
 <tr>
 <td>Amount</td>
 <td><input type="text" name="amount"></td>
 </tr>
 
 <tr>
 <td>Validity</td>
 <td><input type="text" name="validity"></td>
 </tr>
 
 <tr>
 
 
 <td><input type="submit" value="Save"></td>
 </tr> 
  
 </table>
 </form>

</body>
</html>
