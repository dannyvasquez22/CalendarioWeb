<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="model.dto.EventDTO" %>
<%@ page import="model.bl.EventBL" %>
<%@ page import="model.dto.CalendarDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Calendario Prueba</title>
</head>
<body>
	<%
	
		int idCalendario = Integer.parseInt(request.getParameter("calendario"));
		String nombreEvento = request.getParameter("nombre");
		int anio = Integer.parseInt(request.getParameter("anio"));
		int mes = Integer.parseInt(request.getParameter("mes"));
		int dia = Integer.parseInt(request.getParameter("dia"));
		int hora = Integer.parseInt(request.getParameter("hora"));
		int minuto = Integer.parseInt(request.getParameter("minuto"));
		int segundo = 0;
		int duracion = Integer.parseInt(request.getParameter("duracion"));
		
		boolean value = EventBL.getInstance().insert(new EventDTO(new CalendarDTO(idCalendario), nombreEvento, anio, mes, dia, hora, minuto, segundo, duracion));
		
		if (value) {
			//out.println("<meta http-equiv='refresh' content='0; url=../index.jsp'>");
			response.sendRedirect("../index.jsp"); 
		}

	%>
</body>
</html>