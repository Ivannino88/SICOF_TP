<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" 	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-select.min.css" />
<link rel="stylesheet" 	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet" 	href="${pageContext.request.contextPath}/css/generic/generic.css" />
<link rel="stylesheet" 	href="${pageContext.request.contextPath}/dataTable/css/jquery.dataTables.css" />
<link rel="icon" 	    href="${pageContext.request.contextPath}/img/favicon.png">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/generic/desplegable.css" />
<link rel="stylesheet"  href="${pageContext.request.contextPath}/css/generic/estilosDIVS.css" />

<title>  Conciliacion Polizas Ingresos</title>
</head>
<body>
  <div class="row container-fluid fondo">       <!-- inicio contenedor head -->
      <jsp:include page="/jsp/header/etiquetaContraloría.jsp"/>
   			<div class="col-md-8 etiquetaDivGeneral"  >  
<div class="col-md-12">
			<div class="col-md-8" ><!-- espacio bacio --></div>
			
			<!-- seleccione una fecha -->
			<div class=" col-md-3 " align="center">
				<p class="text-center elemento">
					<span>Selecciona&nbsp;una&nbsp;fecha:</span>
				</p>
				<div class="form-group">
					<div class='input-group date pull-center' id='datetimepicker1'>
						<span class="input-group-addon"> <span
							class="glyphicon glyphicon-calendar"></span>
						</span> <input readonly onchange="consultaReporte();" type="text"
							id="fecha" class="datepicker  form-control">
					</div>
				</div>
			</div>
			<div  class="col-md-1" ><!-- espacio bacio --></div>
			
	</div>
    </div>  <!-- fin div  contenedor elementos head  -->
</div>  <!-- div principal -->
<br>
<br>
	<!-- menu desplegable --> 
<div class="col-md-12">
	<div class="col-md-1"></div>
<div class="col-md-5" id="desplegable"> 
<input type="hidden" id="desable_cifra" value="23">
		<jsp:include page="/jsp/generic/loadModal.jsp" />
	<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="/CifrasControl/img/logistica-icon1.png">
    							&emsp;Polizas Ingresos vs Facturac&iacute;on BRM</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
  							

	</div>
	<div class="col-md-5 text-right contentReporte">
	<!--  		<div id="descargaArchivo elemento">
				<form action="exportDetalleFacturaAntAct" method="get">
					<input type="hidden" id="fechaH" name="fecha"> 
					  <input type="hidden" id="empresaH" name="empresa"> 
					  <input type="hidden" id="canalH" name="canal"> 
					  <font color="white">
						<button id="btn-Reporte" type="submit" class="btn btn-xs btn-inverse2">
							&emsp;&emsp;Descargar detalle
						</button>
					</font>
				</form>
			</div>
	-->		
		</div>
	<div class="col-md-1"><!-- en espera --></div>				
</div>		
<!--     ------------- espacio  --------- -->
<br>
<br>
<br>
<br>
<!--     ------------- mensaje  --------- -->	
	<div class="col_md_12 text-center contentMessage">
			<h3 class="colorTitleInit">
				Seleccione d&iacute;a
			</h3>
	</div>
<!-- espacio --> 
<br><br>

<!-- ********************  modulo reporte   **********************   -->		
<div class="col-md-12 contentReporte">
	<div class="col-md-1"><!-- en espera --></div>
	<div class="col-md-10">
		<div class="row-fluid">
					<br/>
					<div id="divReport"></div>
				</div>
	</div>
	<div class="col-md-1"></div>
</div>
<br>

	<jsp:include page="/jsp/generic/errorModal.jsp" />
	<jsp:include page="/jsp/generic/loadModal.jsp" />
<!-- espacio --> 
<div class="col-md-12"><br><br></div>
<div class="col-md-12"><br><br></div>
	<script
		src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/generic/accounting.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/dataTable/js/jquery.dataTables.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/reportes/ConciliaPolizasIngresos.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script> $('#contra3 span').addClass('desabilitado');
			$('#empresa').hide();
	</script>			
</body>
</html>