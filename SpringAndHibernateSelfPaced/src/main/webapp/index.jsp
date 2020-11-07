<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
<%
String taskAssigned="";
taskAssigned=request.getParameter("taskAssigned");
if(null != taskAssigned && taskAssigned.equalsIgnoreCase("true"))
{
out.print("Details added successfully");
%>
<br>
<%
}
%>
<a href="AssignTasks.jsp">Assign Tasks </a>
 <br><br>
 <a href="TaskView.jsp">Task view </a>

</body>
</html>

