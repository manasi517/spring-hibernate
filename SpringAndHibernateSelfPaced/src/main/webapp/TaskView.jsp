<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.mindtree.service.ServiceImpl,java.util.List,com.mindtree.entity.ProjectDetails,
	com.mindtree.entity.EmployeeDetails"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

 <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script language="javascript" type="text/javascript">  

function getProjectDetails(project)
{
	console.log(project);
	$.ajax({
		
		type:'POST',
		url:'/MvcProgram/taskView?project='+project,
		headers:{
			Accept:"application/json; charset=utf-8",
			"Content-Type":"application/json; charset=utf-8"
		},
		success: function(response)
		{
			var data = "";
			var f=JSON.parse(response);
			console.log(f[0]);
			
			$.each(f,function(i,j){
				console.log(j.taskDetails);
				console.log((((j.taskDetails)[0]).projectId).projectName)
				 data += "<b>Project: </b>"+ (((j.taskDetails)[0]).projectId).projectName
				 +"<br><br>";
				 
				 $.each((j.taskDetails), function(x,y){
					
					 data += "<b>Task Description: </b>"+y.description+"<br>"
					 +"<b>Task Start Date: </b>"+y.startDate+"<br>"
					 +"<b>Task End Date: </b>"+y.endDate+"<br>";
					 
					 data += "<table border='1'><tr><th>MID</th><th>Employee Name</th><tr>"
					 
					 $.each((y.emps), function(a,b){
						 
						 data += "<tr><td>"+b.empId+"</td><td>"+b.empName+"</td></tr>";
						 
					 });
					 
					 data += "</table><br><br>";
					 
				 });
				 
			});
			
			document.getElementById( 'main' ).innerHTML = data;
		}
		
	});
 }
 </script>

</head>
<body>
	<h1>View Tasks</h1>
	Filter by Project
	<select name="project" onchange="getProjectDetails(this.value)">
		<option>Select project</option>
		<option value="allProjects">All Projects</option>
		<%
				ServiceImpl service = new ServiceImpl();
				List<ProjectDetails> projects = service.getProjects();
				for(int i=0;i<projects.size();i++)
				{%>

		<option id=<%=i+1 %> value=<%=projects.get(i).getProjectId() %>><%=projects.get(i).getProjectName() %></option>

		<%}
				%>
	</select>


	<br>
	<br>

<div id="main">
</div>

</body>
</html>