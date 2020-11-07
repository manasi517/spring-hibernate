<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import ="com.mindtree.service.ServiceImpl,java.util.List,com.mindtree.entity.ProjectDetails,
	com.mindtree.entity.EmployeeDetails"%>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Tasks</title>
 <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
 <script src="/AjaxWithSpringMVC2Annotations/js/jquery.js"></script>
</head>
<script type="text/javascript">

function getEmps(projectName)
{
	var val="";
	var request=null;
	var url="/MvcProgram/getEmps?project="+projectName;  
	
	if(window.XMLHttpRequest){  
		request=new XMLHttpRequest();  
		}  
		else if(window.ActiveXObject){  
		request=new ActiveXObject("Microsoft.XMLHTTP");  
		}  
	 
	request.onreadystatechange = function() {
		  if (this.readyState == 4 && this.status == 200) {
			  val=this.responseText; 
				var options = '<select multiple="multiple" id="employeeName" name="employeeName">'+val+'</select>';
				document.getElementById( 'employeeName' ).outerHTML = options;
		  }
		};

	request.open("POST",url,true);  
	request.send();  
	 
}




</script>
<body>
<div id ="main">
	<form action="/MvcProgram/assignTask">
		<h1>Assign Tasks</h1>
		<table>

			<tr>
				<td>Project*</td>
				<td><select name="project" class="target" onchange="getEmps(this.value)">
				<option id=0 >Select the project</option>
				<%
				ServiceImpl service = new ServiceImpl();
				List<ProjectDetails> projects = service.getProjects();
				for(int i=0;i<projects.size();i++)
				{%>
					
					<option id=<%=i+1 %> value=<%=projects.get(i).getProjectId() %>><%=projects.get(i).getProjectName() %></option>
					
				<%}
				%>
				</select></td>
			</tr>

			<tr>
				<td>Description*</td>
				<td><input type="text" name="desc" /></td>
			</tr>

			<tr>
				<td>Start Date of Task[mm-dd-yyyy]*</td>
				<td><input type="date" name="startDate" /></td>
			</tr>

			<tr>
				<td>Due Date of Task[mm-dd-yyyy]*</td>
				<td><input type="date" name="endDate" /></td>
			</tr>

			<tr>
				<td>Who should do this?*</td>
				<td><select id="employeeName" name="employeeName">
				<option>select emp</option>
				</select></td>
			</tr>

			<tr>
				<td><input type="submit" name="addTask" value="Add a task" /></td>
				<td><input type="button" name="cancel" value="Cancel" onclick="document.location.href ='index.jsp'"/></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>