<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-select.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/generic.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/desplegable.css" /> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/dataTable/css/jquery.dataTables.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/estilosDIVS.css" />
<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png">	
<title>Proyectos sin transacciones</title>
</head>
<!-- onload="puestoAll()"  carga lista de puestos -->
<body onload="getValor()">
<jsp:include page="/jsp/generic/errorModal.jsp"/>

  <div class="row fondo">       <!-- inicio contenedor head -->
      <jsp:include page="/jsp/header/etiquetarh.jsp" />
 <div class="col-md-8 etiquetaDivGeneral"> 
 <div class="col-md-12" style=" background-color: "> 
					<div  class="col-md-3"></div>
					<div class="col-md-4 ">
					</div> 
					<div class="col-xs-6 col-md-2" style="height:97px; padding-top:15px;" align="center"> 
				       <p class="elemento text-center">
							<span>Año:</span><br>
							<select class="selectpicker" data-width="80px" data-live-search="true" id="selectanio">
							</select></p>
				    </div>
<!-- contenedor 4 -->	
				<div class="col-xs-6 col-md-2" style="height:97px; padding-top:15px;" align="center">
							<p class="elemento text-center">
							<span>No.&nbsp;de&nbsp;Semana:</span><br>
							<select class="selectpicker" data-width="60px" data-live-search="true" id="selectsem" onchange="consultareporteh();">
							</select>
							</p>
				</div>
				<div class="col-md-1"><!-- vacio --></div>
   				 </div>  <!-- fin div  contenedor elementos head  -->
   				 </div>
				</div>			
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding-right: 55px; padding-left: 55px;">
	<div class="row">
<!-- modulo menu y boton de descarga detalle -->		
				<div class="row" style="padding-top:31px; padding-bottom:32px;">
				<div class="col-md-1"></div>
				<div class="col-md-5" id="desplegable"> 
<input type="hidden" id="desable_cifra" value="20">		
				<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="/CifrasControl/img/recursoshumanos-icon2.png">
    							&emsp;Transaccionalidad de empleados</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
				</div>	
				
				<div class="col-xs-12 col-md-5" >
				<div class="contentReporte" id="descargaArchivo">
						  	<form action="exportDetalleRhProyectoSinTransacciones" method="get">
						  	<input type="hidden" id="semanaH" name="semana">
						  	<input type="hidden" id="anioH" name="anio">
								<font color="white">
									<button id="btn-Reporte" type="submit" class="btn btn-xs btn-inverse2" style="display: none;">
										&emsp;&emsp;Descargar detalle
									</button>
								</font>
							</form>
						</div>	
				</div>
				<div class="col-md-1"></div>					
				</div>
<!-- fin modulo menu y boton de descarga detalle -->	
<br><br>
<br><br>
<!-- mensaje -->					
				<div class="col_md_12 text-center contentMessage">
						<h3 class="colorTitleInit">Seleccione la semana</h3>
				</div>
				
<!-- modulo reporte -->				
				<div class="col-md-12 contentReporte" >
				<div class="col-md-1"></div>
				<div class="row-fluid col-md-10">
					<br/><br/>
					<div id="divReport"></div>
				</div>
				<div class="col-md-1"></div>
				</div>
<!-- fin modulo reporte -->	
			
				<div class="modal fade" id="modalhr" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
 				 	<div class="modal-dialog modal-lg" role="document" style="width:90%;">
 				  	 <div class="modal-content">
     					<div class="modal-header">
        					<button type="button" id="btn-dC" class="close" data-dismiss="modal" aria-label="Close" style="display: none;"><span aria-hidden="true">&times;</span></button>
        					<h3 class="modal-title" style="color: #7337ff;">Detalle de consulta</h3>
      					</div>
      					
<!-- °°°°°°°°°°°°°°°°°°°°°°°°°°  FORM MENU °°°°°°°°°°°°°°°°°°°°°°°°°° -->
      				
      					
       					
<!-- °°°°°°°°°°°°°°°°°°°°°°°°°°  FORM MENU °°°°°°°°°°°°°°°°°°°°°°°°°° -->
      					<div class="modal-body">
      					<div class="container-fluid">
      					<div class="contentReporteModal">
      						<button id="regresar" style="display:none" onclick="cmodal(this)" type="button" class="btn btn-success">Regresar</button>
      						<div class="row">
	      						<div id="descargaArchivoModal" style="display:block">
	      							<form action="exportDetalleRhProyectoSinTransaccionesModal" method="get">
	      									<input type="hidden" id="semanaM" name="semana">
							  				<input type="hidden" id="anioM" name="anio">
							  				<input type="hidden" id="idM" name="id">
							  				<input type="hidden" id="idconciliacion1" name="idconciliacion">
							  				
	      								<font color="white">
										<button id="btn-ReporteModal" type="submit" class="btn btn-xs btn-inverse2" style="display:none; float:right; disabled" >
											&emsp;&emsp;Descargar detalle
										</button>
										</font>
	      							</form>
	      						</div>
	      						<div id="descargaArchivoModal2" style="display:none">
	      							<form action="exportDetalleRhProyectoSinTransaccionesModalDetail" method="get">
	      									<input type="hidden" id="semanaM" name="semana">
							  				<input type="hidden" id="anioM" name="anio">
							  				<input type="hidden" id="idM" name="id">
							  				<input type="hidden" id="idempleado" name="idempleado">
							  				<input type="hidden" id="idconciliacion" name="idconciliacion">
							  				
	      								<font color="white">
										<button id="btn-ReporteModal" type="submit" class="btn btn-xs btn-inverse2" style="display:none; float:right; disabled">
											&emsp;&emsp;Detalle empleado
										</button>
										</font>
	      							</form>
      							</div>
      						</div> 
      						
      						<div class="row">
      						<br />
      							<div id="divReportModal"></div>
							</div>
							
       					</div>
       					</div>
      						</div>
    					</div>
  					</div>
				</div>

  			</div>	
		</div>
<br>

<!-- DEMO DE FORM -->
<!--  
<div class="row col-md-12">
<div class="col-md-6" style="display: none;" >

	<form  action="#"   onsubmit="getDatos()">
      	<span id="menuP"></span>
	    <input  type="submit" class="btn btn-lg">
		Consultar
		</input>
	</form>
	
</div>

<div class="col-md-5">
<div >
<span id="menuDemo" ></span>
<input  type="submit" class="btn btn-lg"  onclick="obtenerDato()" value="consultar">
</div>
</div>
</div>
<span id="salida"></span>
-->    
	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"	type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/dataTable/js/jquery.dataTables.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/rhProyectoSinTransacciones.js" type="text/javascript"></script>
	
</body>
</html>