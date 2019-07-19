<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!--DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
 

<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-select.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/generic.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/estilosDIVS.css" />
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/generic/desplegable.css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.min.css" />

<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png">
<title>Instalaciones Nuevas vs. Salidas de Almac&eacute;n SAP - FFM-BRM</title>
<style type="text/css">


</style>

</head>
<body onload="getValor(); fechaActual();">
	
	<jsp:include page="/jsp/generic/errorModal.jsp"/>


<div class="row container-fluid fondo">       <!-- inicio contenedorR head -->
      <jsp:include page="/jsp/header/etiquetaCtrlInven.jsp"/>
<!-- divs encabezado -->
   			<div class="col-md-8 etiquetaDivGeneral" >  
					<div class="col-md-12" style=" background-color: ">
					<div  class="col-md-3"><!--  **************div vacio 1*************  --></div>
					<div class="col-md-3 "><!--  **************div vacio 2************* --></div> 
					<div class="col-md-2 contentReporte" align="center" style="margin-top: 32px;">
          				<button type="button" class="btn btn-info" data-toggle="modal"  data-target=".ModakGrafica">
                  			Gr&aacute;fica&emsp;<span class="glyphicon glyphicon-stats"></span></button>
          			</div>  
					<div class="col-md-3" align="center">
				      <p  class="elemento"><span>Selecciona&nbsp;una&nbsp;fecha:</span></p>
					 		<div class="form-group" >
							<div class='input-group date' id='datetimepicker1'>
							<span class="input-group-addon">
									<span class="glyphicon glyphicon-calendar"></span>
								</span>
								<input readonly onchange="cargaReporte();" type="text" id="fecha" class="datepicker  form-control"> 
							</div>
						</div>
				    </div>
				<div class="col-md-1"><!--  **************div vacio 4*************  -->	</div>
				</div>
    </div>  <!-- fin div  contenedorR elementos head  -->
</div>  <!-- div principal -->
<br>
<br>
<!-- ***********************  menu desplegable  *****************  -->
		<div class="col-md-12">
		<div class="col-md-1"><!-- en espera --></div>
		<div class="col-md-5" id="desplegable" > 
		<input type="hidden" id="desable_cifra" value="2">
		<jsp:include page="/jsp/generic/loadModal.jsp" />	
			<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="/CifrasControl/img/controldeinventarios-icon2.png">
    							&emsp;Instalaciones Nuevas vs Cuentas Activadas FFM - BRM</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>	
															
								
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-3 text-center contentReporte">
					<button class="detalle " >&emsp;Ver Detalle&emsp;</button>
			</div>
  								
			<div class="col-md-2 text-right contentReporte dropdown">
					<div id="descargaArchivo elemento">
					  	<form action="exportInstalacionesNuevasCuentasActivadasFfmBrmDetails">
					  		<input type="hidden" id="fechaReporte" name="fechaReporte">
							<font color="white">
								<button id="btn-Reporte" type="submit" class="btn btn-xs btn-inverse2" style="display: none">
									&emsp;&emsp;Descargar detalle
								</button>
							</font>
						</form>
							
					</div>
			</div>
						
</div>	
<br><br>
<br><br>
<!-- *******************************************    mensajes de aviso   ************************** -->
				<div class="col_md_12 text-center contentMessage">
					<h3 class="colorTitleInit">Seleccione el d&iacute;a del reporte que desea consultar</h3>
				</div>
				
<!-- ***** modal de data table**** -->				
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  onselectstart="return false;">
				    <div class="modal-dialog modal-lg" role="document" style="width:90%;">
				     			
				      <div class="modal-content">
				      <div class="modal-header">
				      <h2 class="modal-title text-center" style="color: #0000CD;">Elige consulta</h2>
		<!--  		        	<div class="modal-header" id="radioButtonContainerId">	        					
	        					
	        					
	        					<div class="radio">
								  <label><input type="radio" name="1" value="1" id="op1">Detalle de las cuentas existentes en FFM y no en BRM</label>
								</div>
								<div class="radio">
								  <label><input type="radio" name="2" value="2" id="op2">Detalle de las cuentas existentes en BRM y no en FFM</label>
								</div>
								-->
	      					</div>
					        <div class="modal-body">
					         <div class="col-md-12 text-left">
	      						<button class="btn btn-info" id="opc1">Detalle de las cuentas existentes en FFM y no en BRM</button>
	      						<button class="btn btn-success" id="opc2">Detalle de las cuentas existentes en BRM y no en FFM</button>
	      					</div>
	      					<div class="row"><br><br><br><br></div>
					        	<br><br>					        	
					        	<div class="table-result" style="display:none; text-alig:center">		        
						       		<h3 class="tituloTabla text-center" style="color: #7337ff;"></h3>
						       		
									<table id="tableModal" data-show-columns="true" data-page-list="[100, 500,1000]" data-page-size="100" ></table>
									<h2 class="text-center" id="NoData" style="color: #7337ff;"></h2>
								</div>
								<br><br>
					        </div>
				      </div>
				    </div>
				</div>
<!-- imagen wait -->	       
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
							<th>Dispositivos</th>
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
							<td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado FFM</div></td>
							<td class="tdx"><div class="divx1"><span class="Error_ffm" id="Error_ffm"></span></div></td>
							<td class="tdx"><div class="divx1"><span class="porcentajeErrorFFM" id="porcentajeErrorFFM"></span></div></td>
						</tr>
						<tr>
							<td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado en BRM</div></td>
							<td style="border:0px;"><div class="divx2"><span class="Error_Brm" id="Error_Brm"></span></div></td>
							<td style="border:0px;"><div class="divx2"><span class="porcentajeErrorBRM" id="porcentajeErrorBRM"></span></div></td>
						</tr>
						<tr>
              				<td><div class="ttotal"><b class="Totalx">Total</div></td>
              				<td><div class="ttotal"><b class=" Totalx TotalAct"></div></td>
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
							<td class="headTable">Total de Base FFM</td>
						</tr>
						<tr>
							<td class="lateralBlue">							
							<span class="aln" id="No_Ffm"></span>
								<div class="pull-right bcolorFFM"></div>
							</td>
						</tr>
						
						<tr>
							<td ><h2 class="espacio"></h2>
							<P class="Total">Total General</P>
							<P class="totalBlue TotalAct"></P>
							<P class="finalBlue"><b id="porcentajeTotal"></b></P>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div  class="col-md-1"></div>
		</div>
	
</div>	

<!-- demo modal graficas  ivans-->
<div class="modal fade ModakGrafica" tabindex="-1" role="dialog" >
  <div class="modal-dialog modal-lg" role="document" style="width:95%;">
    <div class="modal-content" style="background-color: #edf2f5;">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h3 class="modal-title text-left" style="color: #307ac2;">Gr&aacute;fica Detalle</h3>
      </div>
      <div class="col-md-12">
			<div class="col-md-2 text-center elemento">
			<select class="selectpicker" data-width="120px" name="consulta">
          		<option>Opcion</option>
     	 		<option>Semana</option>
      			<option>Mes</option>
    		</select></div>	
			<div class="col-md-2">
				<p class=" text-center elemento " style="display: none" id="menu_semana">
		          <span>No.&nbsp;de&nbsp;Semana:</span>
		          <select class="selectpicker"   data-width="70px" data-live-search="false" onchange="evalSema();" id="selectsem">
		          </select>
		      	</p>
		      	<p class=" text-center elemento" style="display: none" id="menu_mes">
		        	<span>Mes:</span>
		        	<select class="selectpicker"   data-width="120px" data-live-search="false" onchange="evalMes();" id="selectMes" >
		        	</select>
      			</p>
			</div>	
			<div class="col-md-2">
				<p class="text-center elemento" style="display: none" id="menu_anhio">
        			<span>Año:</span>
       				<select class="selectpicker"  data-width="80px" data-live-search="false" onchange="" id="selectanio"  >
        			</select>
      			</p>
			</div>	
			<div class="col-md-6"></div>
		</div>
      <div class="modal-body">
 		 <div id="mensaje" style="display: none;" class="text-center">
      		<img alt="" src="${pageContext.request.contextPath}/img/load5.gif" width="90"><br>
      		<h3 class="text-center"  style="color: #307ac2;">Cargando...</h3>
      	</div>
      <div class="row"><br><br></div>
      <div class=col-md-12>
      <h2 class="text-center" id="NoDataX" style="color: #9d0406;"></h2>
      <div id="graficaLx" style="height: 400px background-color: #73706F; display: none;"></div>
      </div>
      <div class="row"><br><br><br></div> 
      </div><!-- fin body -->
      
    </div><!-- fin content -->
  </div><!-- fin dialog -->
</div><!-- fin modal -->

<div class="row"><br><br><br></div>		
	
	<script src="${pageContext.request.contextPath}/js/graficaLineal/highcharts.js" ></script>          
   	<script src="${pageContext.request.contextPath}/js/graficaLineal/exporting.js"></script>
   	<script src="${pageContext.request.contextPath}/js/graficaLineal/dark-unica.js"></script>			
				
	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/instalacionesNuevasCuentasActivadasFfmBrm.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/generics.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/grafica/raphael-2.1.4.min.js" ></script>					
    <script src="${pageContext.request.contextPath}/js/grafica/justgage.js" ></script>	
    <script src="${pageContext.request.contextPath}/js/bootstrap-table.js" type="text/javascript"></script>
   	<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js" type="text/javascript"></script>
   	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-table-es-SP.js" type="text/javascript"></script>
   	<script src="${pageContext.request.contextPath}/js/reportes/actualFecha.js" type="text/javascript"></script>
    
	<script >
	$('#c2 span').addClass('desabilitado');
	</script>

</body>
</html>