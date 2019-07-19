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
<link rel="stylesheet" href="${pageContext.request.contextPath}/dataTable/css/jquery.dataTables.css" />
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/generic/desplegable.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/estilosDIVS.css" /> 

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.min.css" />
	
<title>BRM-SN vs IPTV-STB</title>
</head>
<!-- body onload="cargaReporte();"-->
<body onload="getValor();">
<div class="row">	
	<jsp:include page="/jsp/generic/errorModal.jsp"/>
	
<div class="row container-fluid fondo">       <!-- inicio contenedor head -->
      <jsp:include page="/jsp/header/etiqueta.jsp"/>
   			<div class="col-md-7 etiquetaDivGeneral" >  
				<div class="col-md-12" style=" background-color: ">
					<div  class="col-md-4"><!--  **************div vacio 1*************  --></div>
					<div class="col-md-2 "><!--  **************div vacio 2*************  --></div>
					<div class="col-md-2" ><!--  **************div vacio 2*************  --></div>  
					 	
					<div class="col-md-3" align="center">
					 <p class="text-center elemento">
								<span>Selecciona&nbsp;una&nbsp;fecha:</span>
					 </p>
							<div class="form-group">
                <div class='input-group date' id='datetimepicker1'>
                   
                  <span class="input-group-addon"> 
                    <span class="glyphicon glyphicon-calendar"></span>
                  </span>
                  <input readonly onchange="initFunction();" type="text" id="fecha" class="datepicker  form-control">
                </div>
              </div>
				    </div>
				<div class="col-md-1"><!--  **************div vacio 4*************  --></div>
				</div>
				
</div>  <!-- fin div  contenedor elementos head  -->
</div>  
 <br><br>
<!-- ********* menu desplegable*********** --> 
<div class="col-md-12">
		<div class="col-md-1"><!-- en espera --></div>
<div class="col-md-5" id="desplegable"> 
<input type="hidden" id="desable_cifra" value="8">
		<jsp:include page="/jsp/generic/loadModal.jsp" />
			<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="/CifrasControl/img/aseguramientodeingreso-icon2.png">
    							&emsp;BRM-SN vs IPTV-STB</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
  								
			</div>
			<div class="col-md-3"></div> 
			<div class="col-md-2" id="cifra27" style="display:none;">
				<button id="internas_boton" type="button" class="btn btn btn-primary internas_boton" type="submit" onclick="lineas_internas();">
					Lineas Internas
				</button>
				<button id="reporte_boton" type="button" class="btn btn btn-primary reporte_boton lineas_internas" type="submit" onclick="reporte_botonf();">
					Regresar al reporte
				</button>
			</div> 
						
						</div>
						<div class="col-md-1"><!-- en espera --></div>
</div>	

<!-- ******************************** radios  ******************************** -->
<br>
<div class="row">
		<div  class="col-md-1"></div>
		
		<div class="col-md-6 botones_radio">
			<form>
  				<div class="col-md-4">
  				<label><input type="radio" id="stb" name="radiob" value="stb" onclick="sendSolicitud()">&emsp;STB</label>
  				</div>  
  				<div class="col-md-4">
  				<label><input type="radio" id="ctas" name="radiob" value="ctas" onclick="sendSolicitud()">&emsp;CUENTAS</label>
  				</div>
  				<div class="col-md-4">
  				<label><input type="radio" id="stb_ctas" name="radiob" value="stb_ctas" onclick="sendSolicitud()">&emsp;STB Y CUENTAS</label>
  				</div>
  				
  					
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
<!-- *******************************************    mensaje   ************************** -->

				<div class="col_md_12 text-center contentMessage"><br>
					<h3 class="colorTitleInit" id="">Seleccione el d&iacute;a del reporte que desea consultar</h3>
				</div>
				<div class="col_md_12 text-center contentMessage2"><br>
					<h3 class="colorTitleInit" id="">No hay información para esta opción</h3>
				</div>
<!-- modal ver detalle -->		   
		    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" onselectstart="return false;">
				    <div class="modal-dialog modal-lg" role="document" style="width:90%;">
				      <div class="modal-content">
				        	<div class="modal-header" id="radioButtonContainerId">	        					
	        					<h2 class="modal-title text-center" style="color: #0000CD;">Elige consulta</h2>
	      					</div>

					        <div class="modal-body">
					        
					        <div class="col-md-12 text-left">
	      						<button class="btn btn-info" id="opc1">Detalle de dispositivos que estan en BRM y que no existen en IPTV</button>
	      						<button class="btn btn-success" id="opc2">Detalle de dispositivos que estan en IPTV y que no existen en BRM</button>
	      					</div>
	      					<div class="row"><br><br><br><br></div>
					        <br><br>
					        	 					        	
					        	<div class="table-result" style="display:none; text-alig:center">		        
						       		<h3 class="tituloTabla text-center" style="color: #7337ff;"></h3>
						       		
									<table id="tableModal" data-show-columns="true" data-page-list="[100, 500,1000]" data-page-size="100"></table>
									<h2 class="text-center" id="NoData" style="color: #7337ff;"></h2>
								</div>
								 <br><br>
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
		       
			
		<div class="container-fluid contentReporte"><br>
		
			<div class="col-md-12">
			<div  class="col-md-1"></div>
			<div class="col-md-6 contenedorR">
				<h2 class=""></h2>
				<table class="table">
					<thead class="headTable">
						<tr>
							<th>Estatus</th>
							<th>Dispositivos</th>
							<th id="modalporcen">Porcentaje</th>
						</tr>
					</thead>
					<tbody class="filasText">
						<tr>
							<td><b>Conciliado</td>
							<td><b class="T_Conciliados" id=""></td>
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
							<td class="tdx"><div class="divx1"><span class="Error_Brm" id=""></div></td>
							<td class="tdx"><div class="divx1"><span class="porcentajeErrorBRM" id="porcentajeErrorBRM"></div></td>
						</tr>
						<tr>
							<td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado en IPTV</div></td>
							<td style="border:0px;"><div class="divx2"><span class="Error_Iptv" id=""></div></td>
							<td style="border:0px;"><div class="divx2"><span class="porcentajeErrorIPTV" id="porcentajeErrorIPTV"></div></td>
						</tr>
						<tr>
						<td><div class="ttotal"><b class="Totalx">Total</b></div></td>
						<td><div class="ttotal"><b class="Totalx" id="Total"></b></div></td>
						<td></td>
						</tr>
					</tbody>
				</table>
				
				<div class="sizegraf center-block" id="grafica"></div>  <!-- grafica total conciliado -->
			</div> <!-- fin de div table y grafica -->
			<div  class="col-md-1"></div>
			
			<div class="col-md-3 contenedorR">
			<h2 class="espacio" style="right:35px;">
			
			<div id="descargaArchivo elemento">
						<form action="exportDetallePaqTvBrmRedIPTVIncluido">
							<input type="hidden" id="fechaReporte" name="fechaReporte">
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
							<td class="headTable">Total de Base IPTV</td>
						</tr>
						<tr>
							<td class="lateralBlue">
							<span class="aln" id="No_Iptv"></span>
								<div class="pull-right bcolorIPTV"></div>
							</td>
						</tr>
						
						<tr>
							<td ><h2 class="espacio"></h2>
							<P class="Total">Total General</P>
							<P class="totalBlue"><b id="Total"> </b></P>
							<P class="finalBlue"><b id="porcentajeTotal"></b></P>
							</td>
						</tr>
					</tbody>
				</table>
			</div> <!-- fin de div lateral -->
			<div  class="col-md-1"></div>
		</div>
	</div>
<!-- fin -->			
<div class="container-fluid lineas_internas"><br>
	<div class="row text-center"><label style="font-size:18px;">Lineas Internas</label></div>
	
	<div class="row">
  	<div class="col-md-1"></div>
  	<div class="col-md-10">
  		&emsp;<label class="">
   			 <input id="check_todo" class="form-check-input" type="checkbox" onchange="lineas_consulta();"> Mostrar todas las Lineas Internas
 		 </label>
  	</div>
  	<div class="col-md-1"></div>
  </div><br>
	
  <div class="row">
  <div class="col-md-1"></div>
  <div class="col-md-4">
  	<form>
  		<div class="col-md-6">
  			<label><input type="radio" id="cuentas" name="radiob" value="cuentas" onclick="lineas_consulta();">&emsp;Cuentas</label>
  		</div>  
  		<div class="col-md-6">
  			<label><input type="radio" id="SN" name="radiob" value="SN" onclick="lineas_consulta();">&emsp;SN</label>
  		</div>
  	</form>	
  	</div>
  <div class="col-md-6 text-right">
  		<button id="insertar_boton" type="button" class="btn btn-info insertar_boton oculto" type="submit" onclick="insertarb();">
			Insertar desde Excel
		</button>
		&nbsp;
		<button id="eliminar_boton" type="button" class="btn btn-warning eliminar_boton oculto" type="submit" onclick="eliminarbf();">
			Eliminar
		</button>
		&nbsp;
		<button id="eliminar_botonTodos" type="button" class="btn btn-danger eliminar_boton oculto" type="submit" onclick="eliminarTodo();">
			Eliminar Todo
		</button>
		
  </div>
  </div>  
  
  <div class="row">
  	<div class="col-md-1"></div>
  	<div class="col-md-10">
  		<br><br><br>
  		<div id="divReport"></div>
  	</div>
  	<div class="col-md-1"></div>
  </div> 
</div>

<br><br>
   
   
  <div class="modal fade" id="confmodal">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
      <h4 class="modal-title">Eliminar
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button></h4>
      </div>
      <div class="modal-body">
        <p id="msj_eliminar"></p>
      </div>
      <div class="text-right" style="padding-right:25px;">
       
        <button  class="btn btn-primary" id="btnYes" onclick="elimina();">Confirmar</button>
        <button class="btn btn-secondary" id="btnCancelar" data-dismiss="modal">Cancelar</button>
      </div>
      <br>
    </div>
  </div>
</div>

  <div class="modal fade" id="confmodal_eliminarTodo">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
      <h4 class="modal-title">Eliminar Todo
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button></h4>
      </div>
      <div class="modal-body">
        <p id="msj_eliminarTodo"></p>
      </div>
      <div class="text-right" style="padding-right:25px;">
       
        <button  class="btn btn-primary" id="btnYesTodo" onclick="eliminaTodo();">Confirmar</button>
        <button class="btn btn-secondary" id="btnCancelarTodo" data-dismiss="modal">Cancelar</button>
      </div>
      <br>
    </div>
  </div>
</div>


<div class="modal fade" id="modal_archivo" data-backdrop="static">
  <div class="modal-dialog modal-md" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Subir Información
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button></h4>
      </div>
      <div class="modal-body">
        <div class="col-md-10 cargar_documento" align="left">
        	<form id="cargar_documento" method="post" enctype = "multipart/form-data" name="cargar_documento">
        	<input type="hidden" name="ruta" id="ruta" value="${pageContext.request.contextPath}/file/" >
   		 	<label for="sfile">Selecione un Archivo</label>
   		 	<input type="file" name="myFile" id="sfile" onchange="bcargaf();" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
   		 	</form>
   		 </div>
   		 <div class="col-md-2 cargar_documento">
   		 <button type="button" class="btn btn-primary" onclick="inserta_excel();">Subir</button>
   		 <br><br>
  		 <br>
   		 </div>
  		
  		<div id="previo" class="form-group previo cargar_documento">
  		</div>
  		<div class="form-group">
   		 	<p id="respuesta"></p>
  		</div>
      </div>
  	
    </div>
  </div>
</div>


<div class="row"><br><br><br></div>


	   	
	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/paqTvBrmRedIPTVIncluido.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/generics.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/dataTable/js/jquery.dataTables.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/grafica/raphael-2.1.4.min.js" ></script>					
    <script src="${pageContext.request.contextPath}/js/grafica/justgage.js" ></script>	
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-table-es-SP.js" type="text/javascript"></script>

</body>
</html>