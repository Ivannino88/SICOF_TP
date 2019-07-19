<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!--DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
 

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

<title>Validación de Series TotalPlay</title>
</head>
<body onload="contruye(''); getValor();">
<jsp:include page="/jsp/generic/errorModal.jsp"/>

<div class="row container-fluid fondo">       <!-- inicio contenedor head -->
      <jsp:include page="/jsp/header/etiquetaCtrlInven.jsp"/>
   			 <div class="col-md-7 etiquetaDivGeneral" >
		<div class="col-md-12" style=" background-color: "> 
		<div  class="col-md-3"><!--  **************div vacio *************  --></div>
		<div class="col-md-3 "> <!--  **************div vacio *************  --></div>
		<div class="col-md-2 "> <!--  **************div vacio *************  --></div> 
          <div class="col-md-3" align="center">
				    </div>
				<div class="col-md-1"><!--  **************div vacio 4*************  --></div>
				</div>
    </div>  <!-- fin div  contenedor elementos head  -->
</div>
 <br><br>

<!--  ********************* modulo de menu desplegable ********************* -->
<div class="col-md-12">
		<div class="col-md-1"><!-- en espera --></div>
<div class="col-md-5" id="desplegable"> 
<input type="hidden" id="desable_cifra" value="6">
		<jsp:include page="/jsp/generic/loadModal.jsp" />
			<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="${pageContext.request.contextPath}/img/controldeinventarios-icon2.png">
    							&emsp;Validación de Series TotalPlay-Finanzas</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
  								

	</div>		
	<div class="col-md-5 text-right dropdown ">
						</div>
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
 					 <li class="active"><a style="background-color: #fcfcfc;">Datos a importar</a></li>
				</ul>
				
				<br><br>
				<p class="elemento"><span>Archivo de series</span></p>
			
   		 		
   		 		<div id="descargaArchivo elemento">
   		 		
				<form action="exportvalidacionSeriesTPDetail" id="descarga_detalle" method="post" enctype = "multipart/form-data">
					
					<!--  <input type="hidden" name="json_string" id="cadjson"> -->
					<!-- <input type="hidden" name="ruta" id="ruta" value="${pageContext.request.contextPath}/file/" > -->
   		 			<div class="col-md-4">
   		 			<input type="file" name="myFile" id="sfile" onchange="validadorarchivo();" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
						<!--  <div class="cargar_documento">
   		 					<p style="color:red;" id="respuesta"></p>
   		 				</div>-->
					</div>
					<div class="col-md-6 contentReporte">
						<button id="btn-Reporte" type="submit" class="btn btn-primary" style="display: none;">Descargar detalle</button>
					</div>
				 </form>
			</div>
   		 		
   		 		 <!--<button id="button_import" type="button" class="btn btn-primary" onclick="importar();">Importar</button>
   		 		 <button id="button_valid" type="button" class="btn btn-primary" onclick="validar()">Validar</button> 
   		 		 <button id="button_limpiar" type="button" class="btn btn-primary" onclick="contruye('');">Limpiar</button> --> 

			</div>
			<div  class="col-md-1"></div>
		</div>
		<div class="col-md-12">
	<div class="col-md-1"><!-- en espera --></div>
	<div class="col-md-10">
		<div class="row-fluid">
<br><br>
<br><br>
					<div id="divReport" class="hidden"></div>
				</div>
	</div>
	<div class="col-md-1"></div>
</div>
</div>
<br><br>
<br><br>

<!-- ******************* modal - confirmacion de validacion -->
<div class="modal fade" id="confmodal">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
      <h4 class="modal-title">Validar
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button></h4>
      </div>
      <div class="modal-body">
        <p id="msj_validar">Esta seguro de que desea validar el archivo seleccionado?</p>
      </div>
      <div class="text-right" style="padding-right:25px;">
       
        <button  class="btn btn-primary" id="btnYes" onclick="cargaprevio();">Confirmar</button>
        <button class="btn btn-secondary" id="btnCancelar" data-dismiss="modal">Cancelar</button>
      </div>
      <br>
    </div>
  </div>
</div>

<!--  ******************* modal - ocurrio un problema -->
				
<div class="modal fade" id="modal_problema">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
      <h4 class="modal-title">Error
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button></h4>
      </div>
      <div class="modal-body">
        <p id="msj_validar">Ocurrio un problema</p>
      </div>
      <div class="text-right" style="padding-right:25px;">
      </div>
      <br>
    </div>
  </div>
</div>

				
	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"	type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/reportes/validacionSeriesTP.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/dataTable/js/jquery.dataTables.js" type="text/javascript"></script>
<script >
		$('#c6 span').addClass('desabilitado');
	</script>

</body>
</html>