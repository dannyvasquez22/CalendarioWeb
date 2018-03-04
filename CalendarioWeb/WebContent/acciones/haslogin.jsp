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
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		int logeado = 0;
		
		UserDTO user = UserBL.getInstance().getLogin(usuario, password);
		
		if (user != null) {
			session.setAttribute("idUsuario", user.getIdUsuario());
			session.setAttribute("usuario",  usuario);
			out.println("<meta http-equiv='refresh' content='0; url=../index.jsp'>");
		} else {
			out.println("<meta http-equiv='refresh' content='0; url=../login.jsp'>");
		}

	%>
</body>
</html>
