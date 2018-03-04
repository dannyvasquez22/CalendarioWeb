<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="model.dto.UserDTO" %>
<%@ page import="model.bl.UserBL" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Calendario Prueba</title>
</head>
<body>	
	<%
		String user = request.getParameter("usuario");
		String pass = request.getParameter("password");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		
		boolean value = UserBL.getInstance().insert(new UserDTO(user, pass, nombre, apellido, email));
		
		if (value) {
			//out.println("<meta http-equiv='refresh' content='0; url=../login.jsp' >");
			session.setAttribute("usuario", request.getAttribute("usuario"));
			response.sendRedirect("../login.jsp"); 
		}
		
	%>
</body>
</html>