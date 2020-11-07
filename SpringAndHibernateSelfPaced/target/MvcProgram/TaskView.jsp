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
	alert(project);
	
	/* var val="";
	var request=null;
	var url="/MvcProgram/taskView?project="+project;  
	
	if(window.XMLHttpRequest){  
		request=new XMLHttpRequest();  
		}  
		else if(window.ActiveXObject){  
		request=new ActiveXObject("Microsoft.XMLHTTP");  
		}  
	 
	request.onreadystatechange = function() {
		  if (this.readyState == 4 && this.status == 200) {
			  val=this.responseText; 
				alert(val);
				var json=JSON.parse(JSON.stringify(val));
				alert(json);
				alert(json.first);
		  }
		};

	request.open("POST",url,true);  
	request.send();  */
	
	$.ajax({
		
		type:'POST',
		url:'/MvcProgram/taskView?project=abc',
		headers:{
			Accept:"application/json; charset=utf-8",
			"Content-Type":"application/json; charset=utf-8"
		},
		success: function(data)
		{
			alert(data);
			 var s=$.parseJSON(data);
			alert(s[0]); 
			
			$.each(s,function(i,j){
				alert(j);
				var t=$.parseJSON(j);
				alert(t);
			});
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


</body>
</html>