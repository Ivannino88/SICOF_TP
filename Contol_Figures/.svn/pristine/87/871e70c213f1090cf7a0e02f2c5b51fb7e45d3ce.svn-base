<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-select.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/generic.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/dataTable/css/jquery.dataTables.css" />
<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png">	
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/estilosDIVS.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/desplegable.css" />
<title>Salidas Sub almacenes  <br/> vs <br/> Entradas Cuadrillas</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.min.css" />


</head>
<body onload="getValor()">
<jsp:include page="/jsp/generic/errorModal.jsp"/>
    <div class="row container-fluid fondo">       <!-- inicio contenedor head -->
      <jsp:include page="/jsp/header/etiquetaCtrlInven.jsp"/>
   			<div class="col-md-8 etiquetaDivGeneral" >  
				<div class="col-md-12" style=" background-color: ">
					<div  class="col-md-3"><!--  **************div vacio 1*************  --></div>
					<div class="col-md-3 "><!--  **************div vacio 2*************  --></div> 
					<div class="col-md-2 "><!--  **************div vacio 2*************  --></div> 	
					<div class="col-md-3" align="center">
				      <p class="text-center elemento" ><span>Selecciona&nbsp;una&nbsp;fecha:</span> </p>
					 	<div class="form-group">
							<div class='input-group date' id='datetimepicker1'>
							<span class="input-group-addon"> 
									<span 
									class="glyphicon glyphicon-calendar"></span>
							</span>
							<input readonly onchange="consultaReporte();" type="text" id="fecha" class="datepicker  form-control"> 
							</div>
						</div>
				    </div>
				<div class="col-md-1"><!--  **************div vacio 4*************  -->	</div>
				</div>
				    </div>  <!-- fin div  contenedor elementos head  -->
</div>
<!-- espacio --> 
<br>
<br>
				<!-- ***********************  menu desplegable  *****************  -->
<div class="col-md-12">
<div class="col-md-1"><!-- en espera --></div>
	<div class="col-md-5" id="desplegable"> 
	<input type="hidden" id="desable_cifra" value="4">
		<jsp:include page="/jsp/generic/loadModal.jsp" />
	<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="/CifrasControl/img/controldeinventarios-icon2.png">
    							&emsp;Salidas de Sub almacenes vs Entrada a Cuadrillas</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
								
	</div>	
	
		
	<div class="col-md-5  text-right contentReporte">
		<div id="descargaArchivo elemento">
						  	<form action="getDetalleSalidasSubalmacenvsEntradasCuadrillas" method="get">
						  		<input type="hidden" id="fechaH" name="fecha">
						  		<input type="hidden" id="almacenH" name="almacen">
								<font color="white">
									<button id="btn-Reporte" type="submit" class="btn btn-xs btn-inverse2" style="display: none;" >
										&emsp;&emsp;Descargar detalle
									</button>
								</font>
							</form>
						<!-- 	<form id="myform">
								<input type="hidden" id="fechaReporteTabla" name="fechaReporte">								
									<button type="submit" class="detalle" >
		                              &emsp;Ver Detalle&emsp;
		                            </button>
							</form>	
							 -->
		</div>	
	</div>
	<div class="col-md-1"><!-- en espera --></div>
</div>	
<!-- espacio --> 
<br><br>
<br><br>
<!-- MENSAJE  -->
<div class="container-fluid">
		<div class="col_md_12 text-center  contentMessage">
					<h3 class="colorTitleInit">Seleccione el d&iacute;a del reporte que desea consultar</h3>
				</div>
				
		  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				    <div class="modal-dialog modal-lg" role="document" style="width:90%;">
				    
				
				      <div class="modal-content">
				        	<div class="modal-header" id="radioButtonContainerId">	        					
	        					<h3 class="modal-title" style="color: #7337ff;">Ver detalle de consulta</h3>
	        					
	        					<div class="radio">
								  <label><input type="radio" name="1" value="1" id="op1">Detalle SAP Regional Cuadrillas</label>
								</div>

	      					</div>
					        <div class="modal-body">
					        						        	
					        	<div class="table-result" style="display:none; text-alig:center">		        
						       		<h3 class="tituloTabla" style="color: #7337ff;"></h3>
						       		
									<table id="tableModal"></table>
									<h1 id="NoData" style="color: #7337ff;"></h1>
										
								</div>
								
					        </div>
					       
				      </div>
				      
				    </div>
			</div>
</div>


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
<!-- espacio -->
<br>
<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"	type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/dataTable/js/jquery.dataTables.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/reportes/salidasSubalmacenvsEntradasCuadrillas.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/bootstrap-table.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js" type="text/javascript"></script>

<script >
$('#c4 span').addClass('desabilitado');
</script>
</body>
</html>