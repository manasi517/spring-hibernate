package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.mindtree.entity.EmployeeDetails;
import com.mindtree.entity.TaskDetails;
import com.mindtree.entity.TaskViewDto;
import com.mindtree.service.ServiceImpl;
import com.mindtree.service.ServiceInterface;

@Controller
public class ControllerClass {
	
	/*@Autowired
	ServiceInterface serviceInterface;*/
	ServiceImpl serviceInterface = new ServiceImpl();
	@RequestMapping(value="/assignTask", method = RequestMethod.GET)
	public void assignTask(HttpServletRequest request,HttpServletResponse response) throws ParseException, IOException
	{
		String projectName = request.getParameter("project");
		SimpleDateFormat d=new SimpleDateFormat("mm-dd-yyyy");
	    Date startDate = d.parse(request.getParameter("startDate"));
		Date endDate = d.parse(request.getParameter("endDate"));
		String description=request.getParameter("desc");
		String[] emp = request.getParameterValues("employeeName");
		boolean taskAssigned=serviceInterface.assignTask(projectName, startDate, endDate, description, emp);
		
		response.sendRedirect("index.jsp?taskAssigned="+taskAssigned);
		
	}

	
	@RequestMapping(value="/getEmps", method = RequestMethod.POST)
	@ResponseBody 
	public void  getEmps( @RequestParam("project") String p,
			 HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		List<EmployeeDetails> l=serviceInterface.getEmployees(p);
		String data = "";
		for(int i=0;i<l.size();i++)
		data+="<option id="+0+" value="+l.get(i).getEmpId()+" >"+l.get(i).getEmpName()+"</option>";
	    response.getWriter().print(data);
	
	}
	
	@RequestMapping(value="/taskView", method = RequestMethod.POST)
	@ResponseBody 
	public void  getProjectDetails( @RequestParam("project") String project,
			 HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter p=response.getWriter();
		List<TaskViewDto> l=serviceInterface.getTaskDetails(project);

		ObjectMapper objectMapper = new ObjectMapper();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		objectMapper.setDateFormat(df);
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		String arrayToJson = objectMapper.writeValueAsString(l);
		
		p.print(arrayToJson);
		
	}
}