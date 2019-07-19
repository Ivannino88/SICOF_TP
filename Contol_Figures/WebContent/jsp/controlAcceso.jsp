<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-select.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/generic.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/dataTable/css/jquery.dataTables.css" />
<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png">	
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/estilosDIVS.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/desplegable.css" />

<title>Control de Acceso</title>
</head>
<body onload="listaModulos();">
<jsp:include page="/jsp/generic/errorModal.jsp"/>
<div class="row container-fluid fondo">       <!-- inicio contenedor head -->
      <jsp:include page="/jsp/header/etiquetaAdministrador.jsp"/>
   			 <div class="col-md-7 etiquetaDivGeneral" >
		<div class="col-md-12" style=" background-color: "> 
		<div  class="col-md-3"></div>
		<div class="col-md-3 "></div>
		<div class="col-md-2 "> </div>
          <div class="col-md-3" align="center">
				    </div>
				<div class="col-md-1"></div>
				</div>
    </div>  <!-- fin div  contenedor elementos head  -->
</div>
 <br><br>

<!--  ********************* modulo de menu desplegable ********************* -->
<div class="col-md-12">
		<div class="col-md-1"><!-- en espera --></div>
		<div class="col-md-5" id="desplegable" > 
			<input type="hidden" id="desable_cifra" value="A1">
			<jsp:include page="/jsp/generic/loadModal.jsp" />
			<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="${pageContext.request.contextPath}/img/controldeinventarios-icon2.png">
    							&emsp;Control de Acceso</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
  								
  								

	</div>		
	<div class="col-md-5"></div>
	<div class="col-md-1"><!-- en espera --></div>
</div>	
<br><br>
<br><br>
<!-- ********************************************************************* -->			

				
		<div class="container-fluid ">
		<div class="col-md-12">
			<div  class="col-md-1"></div>
			<div class="col-md-10">
				<ul class="nav nav-tabs">
 					 <li class="active"><a style="background-color: #fcfcfc;">Información</a></li>
				</ul>
			</div>
			<div  class="col-md-1"></div>
		</div>
		
		<div class="col-md-12">
			<div  class="col-md-1"></div>
			<div class="col-md-11">
			<p class="elemento"><span>No. Empleado</span></p></div>
		</div>
		
		<div class="col-md-12">
		<div  class="col-md-1"></div>
		<div class="col-md-5">
			<div class="col-md-6" style="padding-left:0px">
				<input type="text" class="form-control" id="no_emp">
				<div id="alerta" class="alert alert-warning" role="alert" style="display:none;">
						<span id="respuesta">..&nbsp;No&nbsp;existe&nbsp;información!</span>
				</div>
			</div>
			<div class="container-fluid">
				<button id="buscar" type="button" class="btn btn-success" onclick="busca_Emp();">Buscar</button>&nbsp;
				<button id="actualizar" style="display:none;" type="button" class="btn btn-info" onclick="actualizarbf();">Actualizar</button>
				<button id="agregar" type="button" class="btn btn-primary " onclick="agregar();">Agregar</button></div>
		
			<div class="col-md-1"><!-- en espera --></div>
			
					<p class="elemento"><span>Nombre</span></p>
						<input type="text" class="form-control" id="nombre_emp">
					<p class="elemento"><span>Apellidos</span></p>
						<input type="text" class="form-control" id="apellido_emp">	
					<p class="elemento"><span>Ultima conexion</span></p>
					<p id="ultima_conexion"></p>
					<br>
					<button id="eliminar" style="display:none;" type="button" class="btn btn-danger" onclick="eliminarbf();">Eliminar empleado</button>
						
			</div>
			<div class="col-md-5">	
			<strong id="mensaje"></strong><br>		
<div id="accordion">

</div>		
			</div>
				
			<div class="col-md-1"></div>
		</div>
</div>


  <div class="modal fade" id="confmodal" data-backdrop="static">
  <div class="modal-dialog modal-md" role="document"style="margin-top: 180px;">
    <div class="modal-content">
    <!--  
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Eliminar</h4>
      </div>
      -->
      <div class="modal-body">
        <h3><p id="msj_eliminar" class="text-center">¿Está seguro de eliminar el empleado seleccionado?</p></h3>
      </div>
      <div class="text-right" style="padding-right:25px;">
       
        <button  class="btn btn-success" id="btnYes" onclick="eliminar();">Confirmar</button>
        <button class="btn btn-danger" id="btnCancelar" data-dismiss="modal">Cancelar</button>
      </div>
      <br>
    </div>
  </div>
</div>

  <div class="modal fade" id="actualizar_modal" data-backdrop="static">
  <div class="modal-dialog modal-md" role="document" style="margin-top: 180px;">
    <div class="modal-content">
      <!--  
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Actualizar</h4>
      </div>
      -->
      <div class="modal-body">
        <h3><p id="msj_actualizar" class="text-center">¿Actualizar información del empleado seleccionado?</p></h3>
      </div>
      <div class="text-right" style="padding-right:25px;">
       
        <button  class="btn btn-success" id="btnYes" onclick="actualizar();">Confirmar</button>
        <button class="btn btn-danger" id="btnCancelar" data-dismiss="modal">Cancelar</button>
      </div>
      <br>
    </div>
  </div>
</div>

<br><br>
<br><br>
<script>
</script >
		
	
<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"	type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script><!-- contiene info de perfilamiento -->
<script src="${pageContext.request.contextPath}/js/generic/controlAcceso.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/dataTable/js/jquery.dataTables.js" type="text/javascript"></script>
<script >
	</script>

</body>
</html>