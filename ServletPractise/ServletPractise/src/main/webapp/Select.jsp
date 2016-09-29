<%@ page language="java" import="com.demo.ServletPractise.OwnerDTO" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.demo.ServletPractise.OwnerDAO1" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
   OwnerDAO1 od=new OwnerDAO1();
  java.util. List<String> al= od.displayOwnerNames();
 
 %>
<form action="" method="get">
Select name:<select name="ownername">

  <%
   for(String x :al)
   {
	   
   
  %>
  <option value="<%=x%>"><%=x %></option>
  
  <%} %>
</select>
<input type="submit" name="search" value="Search">
</form>
<%
if(request.getParameter("search")!=null){
	String name=request.getParameter("ownername");
	out.println(name);
	//OwnerDAO1 dao=new OwnerDAO1();
	OwnerDTO o=od.findOwnerByName(name);
%>
<table>
<tr>
<td>
<%=o.getId()%></td>
<td>
<%=o.getFname()%></td>
<td>
<%=o.getLname()%></td>
<td>
<%=o.getAddress()%></td>
<td>
<%=o.getCity()%></td>
<td>
<%=o.getTelephone()%></td>
</table>
<%			
}
%>
</body>
</html>