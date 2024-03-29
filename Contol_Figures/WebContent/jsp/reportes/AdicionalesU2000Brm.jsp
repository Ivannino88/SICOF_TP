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
<link rel="stylesheet" href="${pageContext.request.contextPath}/dataTable/css/jquery.dataTables.css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.min.css" />

<title>Megas Contratados-BRM vs Aprovisionados-U2000</title>
</head>
<body onload="getValor()">
<jsp:include page="/jsp/generic/errorModal.jsp"/>

    <div class="row container-fluid fondo">       <!-- inicio contenedor head -->
      <jsp:include page="/jsp/header/etiqueta.jsp"/>
   			<div class="col-md-7 etiquetaDivGeneral" >
   			<div class="col-md-12" style=" background-color: ">  
					<div  class="col-md-3"><!--  **************div vacio *************  --></div>
					<div class="col-md-3 "><!--  **************div vacio *************  --></div> 
					<div class="col-md-2"><!--  **************div vacio *************  --></div>
					<div class="col-md-3" align="center">
				      <p class="text-center elemento" >
								<span>Selecciona&nbsp;una&nbsp;fecha: </span>
					 </p>
					 		<div class="form-group">
								<div class='input-group date' id='datetimepicker1'>
									<span class="input-group-addon"> 
										<span class="glyphicon glyphicon-calendar"></span>
									</span>
									<input readonly onchange="init();" type="text" id="fecha" class="datepicker form-control"> 
								</div>
							</div>
				    </div>
				<div class="col-md-1"><!--  **************div vacio *************  -->	</div>
				</div>
				    </div>  <!-- fin div  contenedor elementos head  -->
</div>
<br><br>

<!-- ********* menu desplegable*********** --> 
<div class="col-md-12">
		<div class="col-md-1"><!-- en espera --></div>
<div class="col-md-5" id="desplegable"> 
<input type="hidden" id="desable_cifra" value="18">
		<jsp:include page="/jsp/generic/loadModal.jsp" />
	<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="/CifrasControl/img/aseguramientodeingreso-icon2.png">
    							 &emsp;Megas Contratados-BRM vs Aprovisionados-U2000</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
	</div>
	<div class="col-md-3"></div>
   <div class="col-md-2 col-sm-6" id="cifra29">
  	<button id="nueva_seccion_boton" type="button" class="btn btn btn-primary" onclick="muestra_seccion();" data-toggle="modal"  data-target="#promocion">
		Promociones
	</button>
	<button id="reporte_boton" type="button" class="btn btn btn-primary reporte_boton nueva_seccion" onclick="regresa_reporte();">
		Regresar al reporte
	</button>
	<div  class="col-md-1"></div>
	</div>
	<br><br>
	<br><br>
	
	<div class="col-md-6"></div>
	<div class="col-md-1"></div>
		<div class="col-md-3 text-center contentReporte">
			<button type="submit" class="detalle " onclick="getCount('2');">&emsp;Ver Detalle&emsp;</button>
		</div>		
		<div class="col-md-2 text-right contentReporte dropdown">
				<div id="descargaArchivo elemento">
				<form action="exportDetalleConciliacionAddonsBrmU2000Details" onsubmit="return false;">
					<input type="hidden" id="fechaReporte" name="fecha">
					<font color="white">
<!-- TRABAJANDO  같같같같같같같같  -->
						<button id="btn-Reporte" type="submit" onclick="getCount()" class="btn btn-xs btn-inverse2 excel" >
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
				
				<jsp:include page="/jsp/generic/loadModal.jsp" />
				
				
<!-- modal ver detalle -->				
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" onselectstart="return false;">
				    <div class="modal-dialog modal-lg" role="document" style="width:90%;">
				
				      <div class="modal-content">
				        	<div class="modal-header">	        					
	        					<div class="col-md-12"><h2 class="modal-title text-center" style="color: #0000CD;">Detalle de megas contratados en BRM que estan inconsistentes en U2000</h2></div>
	      					</div>
					        <div class="modal-body">
					        <div class="col-md-12">
					           <!-- <div class="col-md-6"><button class="btn btn-primary" onclick="consultaX1()">Detalle de megas contratados en BRM que estan inconsistentes en U2000</button></div>
					              <div class="col-md-6"  ><button class="btn btn-info" onclick="consultaX2()">Detalle de megas contratados en U2000 que estan inconsistentes en BRM</button></div>-->
					        </div>
					        
					        <div class="col-md-12"><br><br></div>
					        	<div class="col-md-12">				        	
					        	 <div id="divDetalle" style="display:none; text-alig:center">		        
						       		<!--   <h3 class="tituloTabla text-center" style="color: #7337ff;"></h3> -->
							
							<div class="col-md-12" > <!--                  DIV PRINCIPAL NUEVO DISE�O DEMO                      -->
							<div class="col-md-3"    id="PA" style="display: none">
									<span style="font-size: 19px;"><center>Porcentaje Conciliado</center></span>
									<span style="font-size: 22px;">
												<center>
												<span class="estatusValEstable" id="ValorActual"></span>%
												</center></span>
										<div class="progress"  style="height: 10px; margin-bottom:0px;">
											<div class="progress-bar progress-bar"
											role="progressbar" aria-valuenow="20" aria-valuemin="0"
											aria-valuemax="100"  id="barraProgresoEstable">
											<span class="sr-only">40% completado (�xito)</span>
											</div>
										</div>
							</div>
							<div class="col-md-3" id="PC"  style="display: none;">
										<span style="font-size: 19px;"><center>Porcentaje No Conciliado</center></span>
										<span style="font-size: 22px;">
										<center>
												<span class="estatusValEstable1" id="ValorActual"></span>%
										</center>
										</span>
										<div class="progress" style="height: 10px; margin-bottom:0px;">
											<div class="progress-bar progress-bar-info"
											role="progressbar" aria-valuenow="40" aria-valuemin="0"
											aria-valuemax="100"  id="barraProgreso">
											<span class="sr-only">40% completado (�xito)</span>
											</div>
										</div>
							</div>
							<div class="col-md-2"><div style="display: none " class="conciliadoVar"><span></span></div></div>
							<div class="col-md-2"><div style="display:  none" class="contadorCon"><span></span></div></div>
							<div class="col-md-2" >
							<div  class="fechaModal"  style="display: none;"> 
							<center>
												<span class="fechaDeHoy" ></span>
							</center>
							</div>
							</div>
							
							</div>  <!--                                           CIERRE DIV PRINCIPAL    DISE�O NUEVO                     -->
							
							
							<table id="tableModal" data-show-columns="true" data-page-list="[100, 500,1000]" data-page-size="100">
								<!--  <thead>
									<tr>
										<th class="bs-checkbox " style="width: 36px; " data-field="accion"><div class="th-inner "><input name="btSelectAll" type="checkbox"></div><div class="fht-cell"></div></th>
										<th  data-field="fecha"><div class="th-inner sortable both">Fecha</div><div class="fht-cell"></div></th>
										<th  data-field="cuenta"><div class="th-inner sortable both">Cuenta</div><div class="fht-cell"></div></th>
										<th  data-field="plan"><div class="th-inner sortable both">Plan</div><div class="fht-cell"></div></th>
										<th  data-field="addons"><div class="th-inner sortable both">Addons</div><div class="fht-cell"></div></th>
										<th  data-field="megas"><div class="th-inner sortable both">Megas Brm</div><div class="fht-cell"></div></th>
										<th  data-field="descr"><div class="th-inner sortable both">Megas Red</div><div class="fht-cell"></div></th>
										<th  data-field="ont"><div class="th-inner sortable both">Ont</div><div class="fht-cell"></div></th>
										<th  data-field="id_conciliacion" style="display:none;"></th>
										<th  data-field="accion1" style="display:none;"></th>
									</tr>
								</thead>
								<tbody id="bodyTableModal">
								</tbody>-->
							</table>
							<button type="button" class="btn btn-lg btn-primary"  id="remove" onclick="updateAll('0')" style="display:none;" >Corregir</button>
							<button type="button" class="btn btn-lg btn-primary"  id="remove1" onclick="updateAll('1')"  style="display:none;" >No Corregir</button>
							<!--   <button id="seleccion" class="btn btn-default">Ver Seleccionados</button> -->
						<!--  	
							<div id="toolbar"> <button id="remove" class="btn btn-danger" disabled>
    									<i class="glyphicon glyphicon-remove"></i> Delete
  														</button>
							</div>
						-->
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

<!-- imagen Actualizando 	 -->	       
		       <div id="waitActualiza" class="modal" >
					  	<div class="modal-dialog modal-lg" role="document" style="width:10%; top:8%">						  	 						  	 	 
							  <center><img style="width:110px;height:110px" src="${pageContext.request.contextPath}/img/giphy.gif">
							  <h3 style="color: #A2D9CE;">Actualizando....</h3>
							  </center>																					 			 		
					  	</div>	
		  		</div>		   

								
				
				<div class="container-fluid contentReporte">
		<div class="col-md-12">
		<BR>
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
							<td><b class="t_conciliadosTP" id="t_conciliadosTP"></td>
							<td><b class="porcentajeConcTP"  id="totalActual"></td>
						</tr>
						<tr>
							<td><BR></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><b>No conciliado</td>
							<td><b class="t_no_conciliadosTP" id="t_no_conciliadosTP"></td>
							<td><b class="porcentajeNoConcTP" id="porcentajeNoConcTP"></td>
						</tr>
						<tr>
							<td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado BRM</div></td>
							<td class="tdx"><div class="divx1"><span class="error_cicloTP" id="error_cicloTP"></span></div></td>
							<td class="tdx"><div class="divx1"><span class="porcentajeerrorcuentasTP" id="porcentajeerrorcuentasTP"></span></div></td>
						</tr>
						<tr>
							<td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado U2000</div></td>
							<td style="border:0px;"><div class="divx2"><span class="error_facturadasTP" id="error_facturadasTP"></span></div></td>
							<td style="border:0px;"><div class="divx2"><span class="porcentajeerrorfacturadasTP" id="porcentajeerrorfacturadasTP"></span></div></td>
						</tr>
						<tr>
              				<td><div class="ttotal"><b class="Totalx">Total</div></td>
              				<td><div class="ttotal"><b class=" Totalx totalTP" id="totalC"></div></td>
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
							<span class="aln totalBRMTP" id="totalBRMTP"></span>
							<div class="pull-right bcolorBRMTP"></div>
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
							<span class="aln totalimsTP" id="totalimsTP"></span>
							<div class="pull-right bcolorimsTP"></div>
							</td>
						</tr>
						
						<tr>
							<td ><h2 class="espacio"></h2>
							<P class="Total">Total General</P>
							<P class="totalBlue"><b id="totalTP" class="totalTP"> </b></P>
							<P class="finalBlue"><b id="porcentajeConcTP" class="porcentajeConcTP"></b></P>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div  class="col-md-1"></div>
		</div>
	
</div>
<div class="row"><br><br><br></div>

<!-- ****************************************  NUEVA SECCION *******************************-->
<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" id="promocion">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">

<!-- $$$$$$$$$$$$$$ -->
<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        	<span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title text-center" id="myModalLabel"><label style="font-size:18px;">Promociones</label></h4>
      </div>
<div class="modal-body"><br>
	

		<br>	
	 <div class="row">
  <div class="col-md-1"></div>
  <div class="col-md-8">
  	<form>
  		<div class="col-md-3">
  			<label><input type="radio" id="pdcat" name="radiob" onclick="consulta_tabla();">&emsp;Promocion Doble CAT</label>
  		</div>  
  		<div class="col-md-3">
  			<label><input type="radio" id="pi" name="radiob" onclick="consulta_tabla();">&emsp;Paquete Intermedia</label>
  		</div>
  		<div class="col-md-3">
  			<label><input type="radio" id="ccat" name="radiob" onclick="consulta_tabla();">&emsp;Crecelo CAT</label>
  		</div>
  		<div class="col-md-3">
  			<label><input type="radio" id="addcat" name="radiob" onclick="consulta_tabla();">&emsp;Adicionales CAT</label>
  		</div>
  	</form>	
  	</div>
  </div>  
	
	<br><br>
	<br><br>
  <div class="row">
  <div class="col-md-1"></div>
  
  <div id="textos"></div>
  
	<div class="col-md-3" style="line-height:95px; align:bottom;">
			<button id="insertar_boton" type="button" class="btn btn-info insertar_boton" type="submit" onclick="insertarb();">
				<b>Insertar&nbsp;Registro</b>
			</button>
	</div>
		</div>
  
  <div class="row">
  	<div class="col-md-1"></div>
  	<div class="col-md-10">
  		<br><br>
  		<br><br>
  		<div id="divReport"></div>
  	</div>
  	<div class="col-md-1"></div>
  </div> 
</div>

<!-- $$$$$$$$$$$$$$ -->



 <div class="modal fade" id="confmodal">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
      <h4 class="modal-title">Confirmaci�n
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button></h4>
      </div>
      <div class="modal-body">
        <p id="msj"></p>
      </div>
      <div class="text-right" style="padding-right:25px;">
       
        <button  class="btn btn-primary botones" id="btnYesTodo" onclick="consulta_insertar();">Confirmar</button>
        <button class="btn btn-secondary botones" id="btnCancelarTodo" data-dismiss="modal">Cancelar</button>
      </div>
      <br>
    </div>
  </div>
</div>

	<br><br>
	<br><br>
	</div>
  </div>
</div>


	
		
<div class="row"><br><br><br></div>
	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"	type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/adicionalesU2000Brm.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/jhxlsx.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/FileSaver.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/Blob.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/xlsx.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/jszip.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/xlsx.core.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/grafica/raphael-2.1.4.min.js" ></script>					
    <script src="${pageContext.request.contextPath}/js/grafica/justgage.js" ></script>	
    <script src="${pageContext.request.contextPath}/dataTable/js/jquery.dataTables.js" type="text/javascript"></script>
    
    <script src="${pageContext.request.contextPath}/js/bootstrap-table.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-table-es-SP.js" type="text/javascript"></script>
  
    
	<script>
	$('#aseg12 span').addClass('desabilitado');
	</script>
	
</body>
</html>