<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
  	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<div class="container">
        <div class="col-md-6 col-md-offset-3 col-xs-12">
            <!-- @ Start login box wrapper -->
            <div class="blmd-wrapp">
                <div class="blmd-color-conatiner ripple-effect-All"></div>
                <div class="blmd-header-wrapp ">
                    <div class="blmd-switches">
                         <button class="btn btn-circle btn-lg btn-blmd ripple-effect btn-success blmd-switch-button">
                            <svg style="width:24px;height:24px" viewBox="0 0 24 24">
                                <path fill="#fff" d="M19,13H13V19H11V13H5V11H11V5H13V11H19V13Z" />
                             </svg>
                          </button>
                    </div> 
                    
                </div> 
                <div class="blmd-continer">
                    <!-- @ Login form container -->
                    <form method="post" class="clearfix" id="login-form" action="acciones/haslogin.jsp">
                        <h1>Credenciales</h1>
                        <div class="col-md-12">
                            
                            <div class="input-group blmd-form">
                                <div class="blmd-line">
                                    <input type="text" name="usuario" autocomplete="off" id="usuario-login" class="form-control">
                                    <label class="blmd-label">Usuario</label>
                                </div>
                            </div>
                            <div class="input-group blmd-form">
                                <div class="blmd-line">
                                    <input type="password" name="password" autocomplete="off" id="password-login" class="form-control">
                                    <label class="blmd-label">Contraseña</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 text-center">
                            <button type="submit" class="btn btn-blmd ripple-effect btn-success btn-lg btn-block">Ingresar</button>
                        </div>
                        <br/>
                    </form>
                    <!-- @ Login form container -->
                    <form method="post" class="clearfix form-hidden" id="Register-form" action="acciones/nuevologin.jsp">
                        <h1>Registrate</h1>
                        <div class="col-md-12">
                            
                            <div class="input-group blmd-form">
                                <div class="blmd-line">
                                    <input type="text" name="usuario" autocomplete="off" id="usuario" class="form-control">
                                    <label class="blmd-label">Usuario</label>
                                </div>
                            </div>
                            <div class="input-group blmd-form">
                                <div class="blmd-line">
                                    <input type="password" name="password" autocomplete="off" id="password" class="form-control">
                                    <label class="blmd-label">Contraseña</label>
                                </div>
                            </div>
                            <div class="input-group blmd-form">
                                <div class="blmd-line">
                                    <input type="text" name="nombre" autocomplete="off" id="nombre" class="form-control">
                                    <label class="blmd-label">Nombre</label>
                                </div>
                            </div>
                            <div class="input-group blmd-form">
                                <div class="blmd-line">
                                    <input type="text" name="apellido" autocomplete="off" id="apellido" class="form-control">
                                    <label class="blmd-label">Apellido</label>
                                </div>
                            </div>
                            <div class="input-group blmd-form">
                                <div class="blmd-line">
                                    <input type="text" name="email" autocomplete="off" id="email" class="form-control">
                                    <label class="blmd-label">E-mail</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 text-center">
                            <button type="submit" class="btn btn-blmd ripple-effect btn-warning btn-lg btn-block">Registrar</button>
                        </div>
                        <br/>
                    </form>
                </div>
            </div>
        </div>
    </div>
	
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
  	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	<script src="js/login.js"></script>
</body>
</html>