<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-select.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/generic.css" />
<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png">	
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/generic/desplegable.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/estilosDIVS.css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.min.css" />


<title>Adicionales TV-BRM vs Adicionales IPTV</title>
</head>
<body onload="getValor()">
	<jsp:include page="/jsp/generic/errorModal.jsp"/>
    <div class="row container-fluid fondo">       <!-- inicio contenedor head -->
      <jsp:include page="/jsp/header/etiqueta.jsp"/>
   			<div class="col-md-7 etiquetaDivGeneral" > 
   			<div class="col-md-12" style=" background-color: "> 
					<div  class="col-md-3"><!--  **************div vacio *************  --></div>
					<div class="col-md-3 "><!--  **************div vacio *************  --></div> 
					<div class="col-md-2 "><!--  **************div vacio *************  --></div> 
					<div class="col-md-3" align="center">
				      <p class="text-center elemento" >
								<span>Selecciona&nbsp;una&nbsp;fecha:</span>
					 </p>
					 		<div class="form-group">
								<div class='input-group date' id='datetimepicker1'>
									
									<span class="input-group-addon"> 
										<span class="glyphicon glyphicon-calendar"></span>
									</span>
									<input readonly type="text" id="fecha" onchange="consultainfo();" class="datepicker  form-control"> 
								</div>
							</div>
				    </div>
<!-- contenedor 4 -->
				<div class="col-md-1"><!--  **************div vacio *************  -->	</div>
				</div>
				    </div>  <!-- fin div  contenedor elementos head  -->
</div>
<br><br>	
<!-- ********* menu desplegable*********** --> 
<div class="col-md-12">
		<div class="col-md-1"><!-- en espera --></div>
<div class="col-md-5" id="desplegable"> 
	<input type="hidden" id="desable_cifra" value="17">
		<jsp:include page="/jsp/generic/loadModal.jsp" />
		<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="/CifrasControl/img/aseguramientodeingreso-icon2.png">
    							 &emsp;Adicionales TV-BRM vs Adicionales IPTV</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
  								
	</div>	
	<div class="col-md-1"></div>
		<div class="col-md-3 text-center contentReporte">
			<button type="submit" class="detalle">&emsp;Ver Detalle&emsp;</button>	
	</div>	
	<div class="col-md-2 text-right contentReporte dropdown">
					<div id="descargaArchivo elemento">
				<form action="exportDetalleCanalesBRMvsIPTVAdicionalesDetails">
					<input type="hidden" id="fechaReporte" name="fecha">
						<font color="white">
									<button id="btn-Reporte" type="submit" class="btn btn-xs btn-inverse2" style="display: none;">
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
				
<!-- modal ver detalle -->				
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  onselectstart="return false;">
				    <div class="modal-dialog modal-lg" role="document" style="width:90%;">
				      <div class="modal-content">
				        	<div class="modal-header">	        					
	        					<div class="col-md-12"><h2 class="modal-title text-center" style="color: #0000CD;">Elige consulta</h2></div>
	        					
	      					</div>
					        <div class="modal-body">
					        <div class="col-md-12">
					           <div class="col-md-6"><button class="btn btn-primary" onclick="consultaX1()">Detalle de IPTV adicionales que no estan en BRM</button></div>
					           <div class="col-md-6"><button class="btn btn-info" onclick="consultaX2()">Detalle de BRM adicionales que no estan en IPTV</button></div>
					        </div>
					        <div class="col-md-12"><br><br></div>
					        	<div class="col-md-12">					        	
					        	<div class="table-result" style="display:none; text-alig:center">		        
						       		<h3 class="tituloTabla text-center" style="color: #7337ff;"></h3>
									<table id="tableModal" data-show-columns="true" data-page-list="[100, 500,1000]" data-page-size="100"></table>
									<h2 class="text-center" id="NoData" style="color: #7337ff;"></h2>
								</div>
								</div>
								<div class="col-md-12"><br><br> <br></div>
					        </div>
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
							<th>Add Ons</th>
							<th>Porcentaje</th>
						</tr>
					</thead>
					<tbody class="filasText">
						<tr>
							<td><b>Conciliado</td>
							<td><b class="t_conciliadosT" id="t_conciliadosT"></td>
							<td><b class="porcentajeConcT" id="porcentajeConcT"></td>
						</tr>
						<tr>
							<td><BR></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><b>No conciliado</td>
							<td><b class="t_no_conciliadosT" id="t_no_conciliadosT"></td>
							<td><b class="porcentajeNoConcT" id="porcentajeNoConcT"></b></td>
						</tr>
						<tr>
							<td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado BRM</div></td>
							<td class="tdx"><div class="divx1"><span class="error_brmT" id="error_brmT"></span></div></td>
							<td class="tdx"><div class="divx1"><span class="porcentajeerrorbrmT" id="porcentajeerrorbrmT"></span></div></td>
						</tr>
						<tr>
							<td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado en IPTV</div></td>
							<td style="border:0px;"><div class="divx2"><span class="error_u2000T" id="error_u2000T"></span></div></td>
							<td style="border:0px;"><div class="divx2"><span class="porcentajeerroru2000T" id="porcentajeerroru2000T"></span></div></td>
						</tr>
						<tr>
              				<td><div class="ttotal"><b class="Totalx">Total</div></td>
             				<td><div class="ttotal"><b class=" Totalx totalT"></div></td>
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
							<span class="aln totalBRMT" id="totalBRMT"></span>
							<div class="pull-right bcolorBRMT"></div>
							</td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
						<tr>
							<td class="headTable">Total de Base IPTV</td>
						</tr>
						<tr>
							<td class="lateralBlue">							
							<span class="aln totalU2000T" id="totalU2000T"></span>
							<div class="pull-right bcolorU2000T"></div>
							</td>
						</tr>
						
						<tr>
							<td ><h2 class="espacio"></h2>
							<P class="Total">Total General</P>
							<P class="totalBlue"><b id="totalT" class="totalT"> </b></P>
							<P class="finalBlue"><b id="porcentajeConcT" class="porcentajeConcT"></b></P>
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
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"	type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/addONSCanalesBRMvsIPTVAdicionales.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/grafica/raphael-2.1.4.min.js" ></script>					
    <script src="${pageContext.request.contextPath}/js/grafica/justgage.js" ></script>	
    
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-table-es-SP.js" type="text/javascript"></script>
</body>
</html>