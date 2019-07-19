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
<link rel="icon" 	   href="${pageContext.request.contextPath}/img/favicon.png"> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/dataTable/css/jquery.dataTables.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/desplegable.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/estilosDIVS.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.min.css" />


<title>Megas Tfe</title>
</head>
<body onload="getValor();">

<jsp:include page="/jsp/generic/errorModal.jsp"/>
 <!-- inicio contenedor head principal -->
    <div class="row container-fluid fondo">      
      <jsp:include page="/jsp/header/etiqueta.jsp"/>
        <div class="col-md-7 etiquetaDivGeneral" >
		<div class="col-md-12" style=" background-color: "> 
		<div class="col-md-4"><!--  **************div vacio *************  --></div>
		<div class="col-md-2"><!--  **************div vacio *************  --></div>  
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
                  <input readonly onchange="cargaReporte();" type="text" id="fecha" class="datepicker  form-control">
                </div>
              </div>
            </div>
<!-- contenedor 4 --> 
        <div class="col-md-1"><!--  **************div vacio *************  --> </div>
        </div>
    </div>  
</div>  <!-- fin head div principal -->

<!-- ********* menu desplegable*********** --> 
<div class="col-md-12"><br><br></div>
<div class="col-md-12">
 <div class="col-md-1 "></div>
  <div class="col-md-5" id="desplegable"> 
  <input type="hidden" id="desable_cifra" value="30">
		<jsp:include page="/jsp/generic/loadModal.jsp" />
  <button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
                   <span class="centrado"><img src="/CifrasControl/img/aseguramientodeingreso-icon2.png">
                   &emsp;MEGAS TFE</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
                  </button>
                  
  </div>  
  	<div class="col-md-3 text-center"> 
  		<!--  <button type="submit" class="detalle">&emsp;Ver Detalle&emsp;</button> -->	
  	 </div>
  	 <!--  valor de id  -->
  <div class="col-md-2"> <input type="hidden"  class="idConsulta" name="custId" value=""> </div>  
</div> <!-- fin menu desplegable -->

<!-- espacio vacio  -->
<div class="col-md-12"><br> <br></div>

	<!--  INICIO DE  radios -->
<div class="row">
		<div  class="col-md-1"></div>
		
		<div class="col-md-6 botones_radio">
			<form>
			<div class="col-md-1"></div>  
  				<div class="col-md-3">
  				<label><input type="radio" id="subida" name="radiob"  value="subida" onclick="sendOpcion()">&emsp;SUBIDA</label>
  				</div>  
  				<div class="col-md-3">
  				<label><input type="radio" id="bajada" name="radiob"  value="bajada" onclick="sendOpcion()">&emsp;BAJADA</label>
  				</div>
  				<div class="col-md-3">
  				<!--  <label><input type="radio" id="general" name="radiob"  value="general" onclick="cargaReporte()">&emsp;general</label> -->
  				</div>
  				<div class="col-md-2"></div>
  			</form>
		</div>
		<div class="col-md-2 "></div>
		<div class="col-md-2 ver_detalle" style="display:none">
		<button type="submit" class="detalle " >
		                           &emsp;Ver Detalle&emsp;
		</button>
				<form id="myform">
						<input type="hidden" id="fechaReporteTabla" name="fechaReporte">
						<input type="hidden" id="idDetalleTabla" name="idDetalleTabla">								
						
				</form>	
		</div>
		</div>
		<!--  fin de radios -->

<!-- *******************************************    mensaje   ************************** -->
				<div class="col_md_12 text-center contentMessage">
					<h3 class="colorTitleInit">Seleccione el d&iacute;a del reporte que desea consultar</h3>
				</div>

<!-- espacio vacio -->
<div class="col-md-12"><br></div>

<!--   COLUMNAS DE INFORMACION   -->
<!-- <div class="container-fluid contentReporte"> -->
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
							<td><b id="T_Conciliados"></td>
							<td><b class=" porcentajeTconciliados"></td>
						</tr>
						<tr>
							<td><BR></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><b>No conciliado</td>
							<td><b  id="Error_Total"></td>
							<td><b  id="porcentajeError_Total"></b></td>
						</tr>
						<tr>
							<td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado BRM</div></td>
							<td class="tdx"><div class="divx1"><span  id="Error_Brm" /></div></td>
							<td class="tdx"><div class="divx1"><span  id="porcentajeErrorBRM" /></div></td>
						</tr>
						<tr>
							<td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado U2000</div></td>
							<td style="border:0px;"><div class="divx2"><span  id="Error_U2000" /></div></td>
							<td style="border:0px;"><div class="divx2"><span  id="porcentajeErrorU2000" /></div></td>
						</tr>
						<tr>
              				<td><div ><b class="Totalx">Total</div></td>
              				<td><div ><b class=" Totalx Total_t"></div></td>
              				<td></td>
            			</tr>
					</tbody>
				</table>
				
				<div class="sizegraf center-block" id="grafica"></div>  <!-- grafica total conciliado -->
			</div>
			<div  class="col-md-1"></div>
			
			<div class="col-md-3 contenedorR">
			<h2 class="espacio"  style="right:10px;">
			
			<div id="descargaArchivo elemento">
						<form action="exportMegasTfe">
							<input type="hidden"  class="idConsulta" name="idConsulta">
							<input type="hidden" id="id_detalle" name="id_detalle">
								<font color="white">
									<button id="btn-Reporte" type="submit" class="btn btn-xs btn-inverse2" style="display: none;">
										&emsp;&emsp;Descargar detalle
										
									</button>
								</font>
						</form>
					</div>
			
			
			
			</h2>
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
							<td class="headTable">Total de Base U2000</td>
						</tr>
						<tr>
							<td class="lateralBlue">							
							<span class="aln" id="No_u2000"></span>
							<div class="pull-right bcolorU2000"></div>
							</td>
						</tr>
						
						<tr>
							<td ><h2 class="espacio"></h2>
							<P class="Total">Total General</P>
							<P class="totalBlue"><b class="Total_t"> </b></P>
							<P class="finalBlue"><b class="porcentajeTconciliados"></b></P>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div  class="col-md-1"></div>
		</div>
</div> <!--   fin de columnas de informacion   -->

<!-- modal ver detalles -->		
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" onselectstart="return false;">
				    <div class="modal-dialog modal-lg" role="document" style="width:90%;">
				    
				
				      <div class="modal-content">
				        	<div class="modal-header">	        					
	        					<div class="col-md-12"><h2 class="modal-title text-center" style="color: #0000CD;">DETALLE MEGAS TFE</h2></div>
	        					
	      					</div> <!-- fin header -->
					        <div class="modal-body">
					        <div class="col-md-12">
					        <div class="col-md-6"><button class="btn btn-info" onclick="reporteDetalles()">MEGAS TFE</button></div>
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
		       				

<div class="row"><br><br><br></div>

	<script src="${pageContext.request.contextPath}/js/graficaLineal/highcharts.js" ></script>          
	<script src="${pageContext.request.contextPath}/js/graficaLineal/exporting.js"></script>
	<script src="${pageContext.request.contextPath}/js/graficaLineal/dark-unica.js"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/actualFecha.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"  type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/js/reportes/MegasTfe.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/dataTable/js/jquery.dataTables.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/js/grafica/raphael-2.1.4.min.js" ></script>					
  	<script src="${pageContext.request.contextPath}/js/grafica/justgage.js" ></script>
  	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-table-es-SP.js" type="text/javascript"></script>
</body>
</html>