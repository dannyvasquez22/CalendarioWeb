<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="model.dto.CalendarDTO" %>
<%@ page import="model.bl.EventCalendarBL" %>
<%@ page import="model.bl.CalendarBL" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Calendario Prueba</title>
</head>
<body>	
	<%
		int idCalendar = Integer.parseInt(request.getParameter("idcalendario"));
		
		EventCalendarBL.getInstance().delete(idCalendar);
		boolean value = CalendarBL.getInstance().delete(new CalendarDTO(idCalendar));
		
		if (value) {
			//out.println("<meta http-equiv='refresh' content='0; url=../index.jsp'>");
			response.sendRedirect("../index.jsp"); 
		}

	%>
</body>
</html>