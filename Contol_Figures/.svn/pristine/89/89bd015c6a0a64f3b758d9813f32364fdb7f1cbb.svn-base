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
<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/generic/desplegable.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/estilosDIVS.css" /> 

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.min.css" />



<title>Product Master vs Productos-BRM</title>
</head>
<!-- body onload="cargaReporte();"-->
<body onload="javascript: cargaReporte(); getValor();">
<jsp:include page="/jsp/generic/errorModal.jsp"/>

<div class="row container-fluid fondo">       <!-- inicio contenedor head -->
      <jsp:include page="/jsp/header/etiqueta.jsp"/>
   			<div class="col-md-7 etiquetaDivGeneral" >  
<div class="col-md-12" style=" background-color: ">
					<div  class="col-md-3"><!--  **************div vacio 1*************  --></div>
					<div class="col-md-3 "><!--  **************div vacio 2*************  --></div> 
					<div class="col-md-2 "><!--  **************div vacio 2*************  --></div> 	
					<div class="col-md-3" align="center">
					<p class="text-center elemento" >
					<span>Selecciona&nbsp;una&nbsp;fecha:</span>
					 </p>
					 		<div class="form-group">
								<div class='input-group date' id='datetimepicker1'>
									
									<span class="input-group-addon"> 
										<span class="glyphicon glyphicon-calendar"></span>
									</span>
									<input readonly onchange="cargaReporte();" type="text" id="fecha" class="datepicker  form-control"> 
								</div>
							</div>

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
<input type="hidden" id="desable_cifra" value="12">
		<jsp:include page="/jsp/generic/loadModal.jsp" />	
			<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="/CifrasControl/img/aseguramientodeingreso-icon2.png">
    							&emsp;Product Master vs Productos-BRM</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
  								
	</div>	
	<div class="col-md-1"></div>
	<div class="col-md-3 text-center contentReporte">
		
	<button type="submit" class="detalle">&emsp;Ver Detalle&emsp;</button>	
	
	</div>		
	<div class="col-md-2 text-right contentReporte dropdown">
					<div id="descargaArchivo elemento">
				<form action="exportPaquetesServiciosActivadosBrmPMDetails" method="get">
					<input type="hidden" id="fechaReporte" name="fechaReporte">
						<font color="white">
									<button id="btn-Reporte" type="submit" class="btn btn-xs btn-inverse2" style="display: none;" >
										&emsp;&emsp;Descargar detalle
									</button>
								</font>
				</form>
					</div>
						</div>
						
</div>	
<br><br>
<br><br>
<!-- *******************************************    mensaje   ************************** -->

				<div class="col_md_12 text-center contentMessage">
					<h3 class="colorTitleInit">Seleccione el d&iacute;a del reporte que desea consultar</h3>
				</div>
<!-- modal ver detalles -->		
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" onselectstart="return false;">
				    <div class="modal-dialog modal-lg" role="document" style="width:90%;">
				    
				
				      <div class="modal-content">
				        	<div class="modal-header">	        					
	        					<div class="col-md-12"><h2 class="modal-title text-center" style="color: #0000CD;">Elige consulta</h2></div>
	        					
	      					</div> <!-- fin header -->
					        <div class="modal-body">
					        <div class="col-md-12">
					        <div class="col-md-6"><button class="btn btn-info" onclick="consultaX()">Detalle de los productos existentes en BRM</button></div>
					        <div class="col-md-6"></div>
					        </div>
					        <div class="col-md-12">
								<br><br>					        	
					        	<div class="table-result" style="display:none; text-alig:center">		        
						       		<h3 class="tituloTabla text-center" style="color: #7337ff;"></h3>
									<table id="tableModal" data-show-columns="true" data-page-list="[100, 500,1000]" data-page-size="100" ></table>
									<h2 class="text-center" id="NoData" style="color: #7337ff;"></h2>
								</div>
								<br><br>		
							</div>
					        <div class="col-md-12"><br><br></div>				
					        </div> <!-- fin body -->
				      </div>
				      
				    </div>
				</div>
				
<!-- imagen wait	 -->	       
		       <div id="wait" class="modal" >
					  	<div class="modal-dialog modal-lg" role="document" style="width:10%; top:20%">						  	 						  	 	 
							  <center><img style="width:110px;height:110px" src="${pageContext.request.contextPath}/img/giphy.gif">
							  <h3 style="color: #A2D9CE;">Cargando..</h3>
							  </center>																					 			 		
					  	</div>	
		  		</div>
		       				
				
				
<div class="container-fluid contentReporte">
		<div class="col-md-12">
			<div  class="col-md-1"></div>
			<div class="col-md-6 contenedorR">
				<h2 class=""></h2>
				<table class="table">
					<thead class="headTable">
						<tr>
							<th>Estatus</th>
							<th>Cuentas</th>
							<th>Porcentaje</th>
						</tr>
					</thead>
					<tbody class="filasText">
						<tr>
							<td><b>Conciliado</td>
							<td><b class="T_Conciliados" id="T_Conciliados"></td>
							<td><b class="porcentaje" id="porcentaje"></td>
						</tr>
						<tr>
							<td><BR></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><b>No conciliado</td>
							<td><b class="Error_Total" id="Error_Total"></td>
							<td><b class="porcentajeError_Total" id="porcentajeError_Total"></b></td>
						</tr>
						<tr>
							<td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado BRM</div></td>
							<td class="tdx"><div class="divx1"><span class="Error_Brm" id="Error_Brm" /></div></td>
							<td class="tdx"><div class="divx1"><span class="porcentajeErrorBRM" id="porcentajeErrorBRM" /></div></td>
						</tr>
						<tr>
							<td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado PM</div></td>
							<td style="border:0px;"><div class="divx2"><span class="Error_Pm" id="Error_Pm" /></div></td>
							<td style="border:0px;"><div class="divx2"><span class="porcentajeErrorPM" id="porcentajeErrorPM" /></div></td>
						</tr>
						<tr>
              				<td><div class="ttotal"><b class="Totalx">Total</div></td>
              				<td><div class="ttotal"><b class=" Totalx Totalpm"></div></td>
              				<td></td>
            			</tr>
					</tbody>
				</table>
				
				<div class="sizegraf center-block" id="grafica"></div>  <!-- grafica total conciliado -->
			</div>
			<div  class="col-md-1"></div>
			<div class="col-md-3 contenedorR">
			<h2 class="espacio"></h2>
				<table class="table">
					<thead class="headTable">
						<tr>
							<th>Total de Base BRM</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="lateralBlue"> 							
							<span class="aln" id="No_Brm"></span>
							<div class="pull-right bcolorBRM"></div>
							</td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
						<tr>
							<td class="headTable">Total de Base PM</td>
						</tr>
						<tr>
							<td class="lateralBlue">							
							<span class="aln" id="No_Pm"></span>
							<div class="pull-right bcolorPM"></div>
							</td>
						</tr>
						
						<tr>
							<td ><h2 class="espacio"></h2>
							<P class="Total">Total General</P>
							<P class="totalBlue"><b class="Totalpm"> </b></P>
							<P class="finalBlue"><b id="porcentajeTotal"></b></P>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div  class="col-md-1"></div>
		</div>
	
</div>

<div class="row"><br><br><br></div>
				
	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/paquetesServiciosActivadosBrmPM.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/generics.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/grafica/raphael-2.1.4.min.js" ></script>					
    <script src="${pageContext.request.contextPath}/js/grafica/justgage.js" ></script>	
    
    <script src="${pageContext.request.contextPath}/js/bootstrap-table.js" type="text/javascript"></script> 
    <script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-table-es-SP.js" type="text/javascript"></script>
	
	
	<script >
		$('#aseg6 span').addClass('desabilitado');
	</script>

</body>
</html>