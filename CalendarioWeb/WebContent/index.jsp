<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.dto.CalendarDTO" %>
<%@ page import="model.dto.UserDTO" %>
<%@ page import="model.pojo.EventCalendar" %>
<%@ page import="model.bl.CalendarBL" %>
<%@ page import="model.bl.EventCalendarBL" %>
<% 
	if (session.getAttribute("usuario") == null) { out.println("<meta http-equiv='refresh' content='0; url=login.jsp'>"); }
	if (session.getAttribute("anio") == null) { session.setAttribute("anio", 2018); }
	if (session.getAttribute("mes") == null) { session.setAttribute("mes", 02); }
	int mesNumero = (Integer) session.getAttribute("mes");
	if (request.getParameter("mes") != null) { if (request.getParameter("mes").contains("anterior")) { session.setAttribute("mes", mesNumero - 1); } }
	if (request.getParameter("mes") != null) { if (request.getParameter("mes").contains("posterior")) { session.setAttribute("mes", mesNumero + 1); } }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>	Calendario Prueba </title>	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="http://webcalendario.com/favicons/09.ico">	
	<script src="lib/jquery-1.10.1.min.js"></script>
	<script src="lib/jquery-ui.js"></script>
	<script src="js/codigo.js"></script>
	<link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link rel="stylesheet" type="text/css" href="css/header.css">
	
<!-- 	<link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet"> -->
<!-- 	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
<!-- 	<link rel="stylesheet" type="text/css" href="css/calendar.css"> -->
<!-- 	<link rel="stylesheet" type="text/css" href="css/viewCalendar.css"> -->
<!-- 	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script> -->
<!-- 	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
<!-- 	<script src="js/calendar.js"></script> -->
<!-- 	<script src="js/viewCalendar.js"></script> -->
	
</head>
<body>
	<div id="tituloprint">Calendario Web</div>
	<header>
		<div id="logo">			
			<h1>ORGANÍZATE</h1>
			<h2>Tu calendario en la nube</h2>
		</div>
		<nav>
			<ul>
				<li>Inicio</li>
				<li id="botonsignin">Regístrate</li>
				<li id="contacto">Contacto</li>
				<li id="contacto"><a href="">Cerrar Sesión</a></li>
			</ul>
		</nav>
	</header>
	<table width="100%">
		<tbody>
			<tr>
				<td id="aniotitulo">
					<h2><% out.println(session.getAttribute("mes")); %></h2><h1><% out.println(session.getAttribute("anio")); %></h1>
				</td>
				<td id="botones">
					<a href="?mes=anterior"><button> &lt;&lt; </button></a>
					<a href="?mes=posterior"><button> &gt;&gt; </button></a>
				</td>
				<td>
					<div id="calendarios">
						<%						
							ArrayList<CalendarDTO> listCalendario = new ArrayList<>();
							CalendarDTO calendario = null;
							UserDTO usuarioDTO = null; 
							int idUsuarioDTO = (Integer) session.getAttribute("idUsuario") == null ? 0 : (Integer) session.getAttribute("idUsuario");
							usuarioDTO = new UserDTO(idUsuarioDTO);
							listCalendario.clear();
							listCalendario = CalendarBL.getInstance().getByIdUser(usuarioDTO);
							
							for (CalendarDTO calendar : listCalendario) {
								out.println("<span class='calendariocol' idcalendario='" + calendar.getIdCalendario() + "' style='width:80px;background:rgb(" + calendar.getColor() + ");'>" + calendar.getNombre() + " - <a href='acciones/eliminarCalendario.jsp?idcalendario=" + calendar.getIdCalendario() + "' class='cierracalendarioX'>X</a></span>" );
							}						
						%>			
						<button id="anadirCalendario">Añadir Calendario</button>
					</div>
					<span class="calendariocol" style="background:grey;" id="ocultacalendarios">Ocultar Calendarios</span>
				</td>
			</tr>
		</tbody>
	</table>
	<div style="clear:both;"></div>
	<div id="calendario">
		<%
			int desfase = 0;
			if (session.getAttribute("mes").toString().equals("1")) {	desfase = 0;	}
			if (session.getAttribute("mes").toString().equals("2")) {	desfase = 3;	}
			if (session.getAttribute("mes").toString().equals("3")) {	desfase = 3;	}
			if (session.getAttribute("mes").toString().equals("4")) {	desfase = 6;	}
			if (session.getAttribute("mes").toString().equals("5")) {	desfase = 1;	}
			if (session.getAttribute("mes").toString().equals("6")) {	desfase = 4;	}
			if (session.getAttribute("mes").toString().equals("7")) {	desfase = 6;	}
			if (session.getAttribute("mes").toString().equals("8")) {	desfase = 2;	}
			if (session.getAttribute("mes").toString().equals("9")) {	desfase = 5;	}
			if (session.getAttribute("mes").toString().equals("10")) {	desfase = 0;	}
			if (session.getAttribute("mes").toString().equals("11")) {	desfase = 3;	}
			if (session.getAttribute("mes").toString().equals("12")) {	desfase = 5;	}
			
			for (int diavacio = 1; diavacio <= desfase; diavacio++) {
				out.println("<div class='dia ui-droppable' dia='' style='position:relative;'><div class='numerodia'><b></b></div>");
				out.println("</div>");
			}
			
			ArrayList<EventCalendar> listEventCalendario = new ArrayList<>();
			for (int dia = 1; dia <= 31; dia++) {
				int idUsuarioSession = (Integer) session.getAttribute("idUsuario") == null ? 0 : (Integer) session.getAttribute("idUsuario");
				int mesSession = (Integer) session.getAttribute("mes") == null ? 0 : (Integer) session.getAttribute("mes");
				int anio = 2018;
				listEventCalendario.clear();
				listEventCalendario = EventCalendarBL.getInstance().getByTime(anio, mesSession, dia, idUsuarioSession);
				
				out.println("<div class='dia ui-droppable' dia='" + dia + "' style='position:relative;'><div class='numerodia'><b>" + dia + "</b></div>");
				for (EventCalendar eventC : listEventCalendario) {
					out.println("  <div idevento='" + eventC.getIdEvento() + "' idcaldia='7' anio='2014' mes='9' dia='13' hora='9' nombre='IMF' class='evento ui-draggable' style='background:rgb(" + eventC.getColor() + ");width:90%;height:" + (eventC.getDuracion() * 0.1) + "%;position:absolute;top:" + ((eventC.getHora() * 4) + 2) + "%;'>" 
							+ eventC.getHora() + ":" + eventC.getMinuto()
							+ "		<span class='motivoevento'>" + eventC.getNombre() + "</span>"
							+ "			<div class='eliminar'>"
							+ "				<a style='color:#d7d7d7;' href='acciones/eliminarEvento.jsp?idevento=" + eventC.getIdEvento() + "'>X</a>"
							+ "			</div>"
							+ "</div>");
				}
				out.println("</div>");									
			}
		%>
	</div>
	<div id="nuevoevento" style="display: none;">
		<div id="contieneform">
			<div id="cerrarnuevoevento">X</div>
			<form action="http://localhost:8080/CalendarioWeb/acciones/nuevoEvento.jsp" method="POST">
				<input type="hidden" name="anio" value="2018">
				<input type="hidden" name="mes" value="02">
				<h3>Nuevo evento</h3>
				<table width="100%" id="tablanuevoevento" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td>Año:</td>
							<td>2018</td>				
						</tr>
						<tr>
							<td>Mes:</td>
							<td>02</td>
						</tr>
						<tr>
							<td>Dia:</td>
							<td><input type="text" name="dia" id="dimedia"></td>
						</tr>
						<tr>
							<td>Calendario:</td>
							<td>
								<select name="calendario">
									<%
										listCalendario.clear();
										listCalendario = CalendarBL.getInstance().getAll();
										
										for (CalendarDTO calendar : listCalendario) {
											out.println("<option value='" + calendar.getIdCalendario() + "'>" + calendar.getNombre() + "</option>");
										}										
									%>
								</select>
							</td>
						</tr>
						<tr>
							<td>Hora de inicio:</td>
							<td>
								<select name="hora">
									<%
										for (int hora = 0; hora <= 24; hora++) {
											out.println("<option value='" + hora + "'>" + hora + "</option>");
										}
									%>		
								</select>:
						
								<select name="minuto">
									<%
										for (int minuto = 0; minuto <= 60; minuto += 5) {
											out.println("<option value='" + minuto + "'>" + minuto + "</option>");
										}
									%>
								</select>
							</td>
						</tr>
						<tr>
							<td>Duración:</td>
							<td>
								<select name="duracion">
									<% 
										int valor = 0;
										for (int duracion = 0; duracion <= 23; duracion++) {
											out.println("<option value='" + (duracion + valor) * 30 + "'>" + duracion + "</option>");
											out.println("<option value='" + (duracion + valor + 1) * 30 + "'>" + duracion + ":30</option>");
											valor++;
										}
									%>
								</select>
							</td>
						</tr>
						<tr>
							<td>Nombre del evento:</td>
							<td><input type="text" name="nombre" placeholder="nombre" /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit"></td>
						</tr>
					</tbody>
				</table>	
			</form>
		</div>
	</div>
	<!-- ///////////////////  -->
	<div id="nuevocalendarioforma" style="display: none;">
		<div id="contieneform">
			<div id="cerrarnuevocalendario" >X</div>
			<form action="http://localhost:8080/CalendarioWeb/acciones/nuevoCalendario.jsp" method="POST">
				<input type="hidden" name="anio" value="2018">
				<input type="hidden" name="mes" value="02">
				<h3>Nuevo calendario</h3>
				<td><input type="text" name="nombrecalendario"></td>
				<td><input type="submit"></td>
			</form>
		</div>
	</div>
	<!-- //////////// -->
	<div id="ajax"></div>
	
<!-- 	<div id='wrap'> -->
<!-- 		<div id='calendar'></div> -->
<!-- 		<div style='clear:both'></div> -->
<!-- 	</div>	 -->
</body>
</html>
