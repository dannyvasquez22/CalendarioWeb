<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="model.dto.EventDTO" %>
<%@ page import="model.bl.EventBL" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Calendario Prueba</title>
</head>
<body>	
	<%
		int idEvento = Integer.parseInt(request.getParameter("idevento"));
		int nuevoDia = Integer.parseInt(request.getParameter("nuevodia")); 
	
		EventDTO evento = new EventDTO(idEvento, null, null, 0, 0, nuevoDia, 0, 0, 0, 0);
		boolean value = EventBL.getInstance().update(evento);

		if (value) {
			//out.println("<meta http-equiv='refresh' content='0; url=../index.jsp'>");
			response.sendRedirect("../index.jsp"); 
		}
	%>
</body>
</html>