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

<title>Ajustes-BRM vs Ajustes-SalesForce</title>
</head>
<!-- body onload="cargaReporte();"-->
<body onload="javascript: cargaReporte(); getValor()">
<jsp:include page="/jsp/generic/errorModal.jsp"/>

<div class="row container-fluid fondo">       <!-- inicio contenedor head -->
      <jsp:include page="/jsp/header/etiquetaCobranza.jsp"/>
   			 <div class="col-md-7 etiquetaDivGeneral" >
		<div class="col-md-12" style=" background-color: "> 
		<div  class="col-md-3"><!--  **************div vacio *************  --></div>
		<div class="col-md-3 "> <!--  **************div vacio *************  --></div>
		<div class="col-md-2 "> <!--  **************div vacio *************  --></div> 
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
<input type="hidden" id="desable_cifra" value="25">
		<jsp:include page="/jsp/generic/loadModal.jsp" />	
			<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="${pageContext.request.contextPath}/img/controldeinventarios-icon2.png">
    							&emsp;Ajustes-BRM vs Ajustes-SaleForce</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
  								

	</div>		
	<div class="col-md-5"></div>
			<div class="col-md-1"></div>
			
</div>	

<!--  mensaje -->
<div class="col-md-12 contentMessage" ><br><br><br><br></div>
<div class="col_md_12 text-center contentMessage">
          <h3 class="colorTitleInit">Seleccione el d&iacute;a del reporte que desea consultar</h3>
</div>

			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  onselectstart="return false;">
				    <div class="modal-dialog modal-lg" role="document" style="width:90%;">
				    				
				      <div class="modal-content">
				        	<div class="modal-header">	        					
	        					<div class="col-md-12"><h2 class="modal-title text-center" style="color: #0000CD;">Elige consulta</h2></div>
								
	      					</div> <!-- fin head -->
	      					<div class="col-md-12">
			  					<div class="col-md-6 text-rigth" style="color: #5BC687;"><h3><span class="consultaX"></span></h3></div>
								<div class="col-md-6 pull-right"><button type="button" id="back" class="btn btn-warning pull-right " style="display: none;" >
								<span class="glyphicon glyphicon-menu-left" aria-hidden="true">&emsp;</span>REGRESAR</button></div>
		  					</div>
					        <div class="modal-body">
					        <div class="col-md-12">
			  					<div class="col-md-6"><button class="btn btn-info" id="opc1">Detalle de ajustes que se encuentran en SalesForce y no en BRM</button></div>
			  					<div class="col-md-6"><button class="btn btn-success" id="opc2">Detalle de ajustes que se encuentran en BRM y no en SalesForce</button></div>
			  				</div>
			  				<div class="col-md-12">
								<!-- #1 -->
						    		<div id="empresas1" style="display: none;">
						      		<br>
									<button type="button" value="TOTALPLAY"  class="btn btn-info btn1" onclick="consultaTp1()">TOTALPLAY</button>
									<button type="button" value="ENLACE" 	 class="btn btn-info btn2" onclick="consultaEnl1()">ENLACE</button>
									<button type="button" value="TFE" 		 class="btn btn-info btn3" onclick="consultaTfe1()">TFE</button>
									<button type="button" value="total" 	 class="btn btn-info btn4" onclick="consultaTt1()">TOTAL</button>
									</div>
							<!-- #2 -->
								<div id="empresas2" style="display: none;">
						      		<br>
									<button type="button" value="TOTALPLAY"  class="btn btn-success btn1" onclick="consultaTp2()">TOTALPLAY</button>
									<button type="button" value="ENLACE" 	 class="btn btn-success btn2" onclick="consultaEnl2()">ENLACE</button>
									<button type="button" value="TFE" 		 class="btn btn-success btn3" onclick="consultaTfe2()">TFE</button>
									<button type="button" value="total" 	 class="btn btn-success btn4" onclick="consultaTt2()">TOTAL</button>
								</div>
			  				</div>
					        <div class="col-md-12">					        	
					        	<div class="table-result" style="display:none; text-alig:center">		        
						       		<h3 class="tituloTabla text-center" style="color: #7337ff;"></h3>
									<table id="tableModal" data-show-columns="true" data-page-list="[100, 500,1000]" data-page-size="100" ></table>
									<h2 class="text-center" id="NoData" style="color: #7337ff;"></h2>
								</div>
							</div>
							<div class="col-md-12"><br><br></div>	
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

<!-- PRIMER MODULO TOTALPLAY -->
  <div class="container-fluid">
    <div class="col-md-12  contentReporte"><br><br><br><br>
    <div class="col-md-12 contentReporte" ></div>
      <div  class="col-sm-1"></div>
      <div class="col-sm-6 contenedorR">
        <h2 class="tituloPlay">TOTALPLAY</h2>
        <table class="table">
          <thead class="headTable">
            <tr>
              <th>Estatus</th>
              <th>Ajustes</th>
              <th>Porcentaje</th>
            </tr>
          </thead>
          <tbody class="filasText">
            <tr>
              <td><b>Conciliado</td>
              <td><b class="t_conciliadosTP"></td>
              <td><b class="porcentajeConcTP"></td>
            </tr>
            <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="t_no_conciliadosTP"></td>
              <td><b class="porcentajeNoConcTP"></b></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado BRM</div></td>
              <td class="tdx"><div class="divx1"><span class="error_brmTP"></span></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorbrmTP"></span></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado en SF</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_sfTP"></span></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerrorsfTP"></span></div></td>
            </tr>
            <tr>
              <td><div class="ttotal"><b class="Totalx">Total</div></td>
              <td><div class="ttotal"><b class=" Totalx totalTP"></div></td>
              <td></td>
            </tr>
          </tbody>
        </table>
        
		 <div class="sizegraf center-block" id="graficaTP"></div>
      </div>
      <div  class="col-sm-1"></div>
      
      <div class="col-sm-3 contenedorR">
      <h2 class="espacio"></h2>
        <table class="table">
          <thead class="headTable">
            <tr>
              <th>Total de Base BRM</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="lateralBlue ">
              <font class="totalBRMTP estado"></font>
              <div class="pull-right bcolorBRMTP"></div>
              </td>
            </tr>
            <tr>
              <td><br></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="headTable">Total de Base SF</td>
            </tr>
            <tr>
              <td class="lateralBlue">
              <font class=" totalsfTP estado"></font>
              <div class="pull-right bcolorsfTP "></div>
              </td>
            </tr>
            
            <tr>
              <td ><h2 class="espacio"></h2>
              <P class="Total">Total Totalplay</P>
              <P class="totalBlue totalTP"></P>
              <P class="finalBlue porcentajeConcTP">%</P>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div  class="col-sm-1"></div>
    </div>
  
</div>  
<div class="col-md-12 contentReporte"><br><br></div>

<!-- SEGUNDO MODULO  ENLACE -->
<div class="container-fluid">
    <div class="col-md-12 contentReporte ">
      <div  class="col-sm-1"></div>
      <div class="col-sm-6 contenedorR">
        <h2 class="tituloEnlace">ENLACE</h2>
        <table class="table">
          <thead class="headTable">
            <tr>
              <th>Estatus</th>
              <th>Ajustes</th>
              <th>Porcentaje</th>
            </tr>
          </thead>
          <tbody class="filasText">
            <tr>
              <td><b>Conciliado</td>
              <td><b class="t_conciliadosENL"></td>
              <td><b class="porcentajeConcENL"></td>
            </tr>
            <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="t_no_conciliadosENL"></td>
              <td><b class="porcentajeNoConcENL"></b></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado BRM</div></td>
              <td class="tdx"><div class="divx1"><span class="error_brmENL"></span></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorbrmENL"></span></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado en SF</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_sfENL"></span></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerrorsfENL"></span></div></td>
            </tr>
  			<tr>
              <td><div class="ttotal"><b class="Totalx">Total</div></td>
              <td><div class="ttotal"><b class=" Totalx totalENL"></div></td>
              <td></td>
           </tr>
          </tbody>
        </table>
        
		 <div class="sizegraf center-block" id="graficaEnlace"></div>
      </div>
      <div  class="col-sm-1"></div>
      
      <div class="col-sm-3 contenedorR">
      <h2 class="espacio"></h2>
        <table class="table">
          <thead class="headTable">
            <tr>
              <th>Total de Base BRM</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="lateralCyan ">
              <font class="totalBRMENL estado"></font>
              <div class="pull-right bcolorBRMENL"></div>
              </td>
            </tr>
            <tr>
              <td><br></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="headTable">Total de Base SF</td>
            </tr>
            <tr>
              <td class="lateralCyan">
              <font class=" totalsfENL estado"></font>
              <div class="pull-right bcolorsfENL"></div>
              </td>
            </tr>
            
            <tr>
              <td ><h2 class="espacio"></h2>
              <P class="Total">Total Enlace</P>
              <P class="totalCyan totalENL"></P>
              <P class="finalCyan porcentajeConcENL">%</P>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div  class="col-sm-1"></div>
    </div>
  
</div>  
<div class="col-md-12 contentReporte"><br><br></div>

<!-- TERCER MODULO TOTAL -->
<div class="container-fluid">
    <div class="col-md-12  contentReporte">
      <div  class="col-sm-1"></div>
      <div class="col-sm-6 contenedorR">
        <h2 class="tituloFin">TOTAL</h2>
        <table class="table">
          <thead class="headTable">
            <tr>
              <th>Estatus</th>
              <th>Ajustes</th>
              <th>Porcentaje</th>
            </tr>
          </thead>
          <tbody class="filasText">
            <tr>
              <td><b>Conciliado</td>
              <td><b class="t_conciliadosT"></td>
              <td><b class="porcentajeConcT"></td>
            </tr>
            <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="t_no_conciliadosT"></td>
              <td><b class="porcentajeNoConcT"></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado BRM</div></td>
              <td class="tdx"><div class="divx1"><span class="error_brmT"></span></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorbrmT"></span></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado en SF</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_sfT"></span></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerrorsfT"></span></div></td>
            </tr>
   			<tr>
             	<td><div class="ttotal"><b class="Totalx">Total</div></td>
            	<td><div class="ttotal"><b class=" Totalx totalT"></div></td>
            	<td></td>
            </tr>
          </tbody>
        </table>
        
		 <div class="sizegraf center-block" id="graficaALL"></div>
        
      </div>
      <div  class="col-sm-1"></div>
      
      <div class="col-sm-3 contenedorR">
      <div id="descargaArchivo elemento">
	      <div style="width: 243px;"><br>
					<form action="exportAjustesBRMvsAjustesSalesForceDetails" method="get">
						<input type="hidden" id="fechaReporte" name="fechaReporte">
							<font color="white">
							
								<button id="btn-Reporte" type="submit" class="btn btn-xs btn-inverse2" style="display: none;">
									&emsp;&emsp;Descargar detalle
								</button>
							
						   </font>
					</form>
					
					
			</div>
			<br>
			<div id="descargaArchivo" class="xY"  >
				<button type="submit" class="detalle " >
		                           &emsp;Ver Detalle&emsp;
		                </button>
			</div>	
		</div>
		
        <table class="table">
          <thead class="headTable">
            <tr>
              <th>Total de Base BRM</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="lateralFin ">
              <font class="totalBRMT estado"></font>
              <div class="pull-right bcolorBRMT"></div>
              </td>
            </tr>
            <tr>
              <td><br></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="headTable">Total de Base SF</td>
            </tr>
            <tr>
              <td class="lateralFin">
              <font class=" totalsfT estado"></font>
              <div class="pull-right bcolorsfT"></div>
              </td>
            </tr>
            
            <tr>
              <td ><h2 class="espacio"></h2>
              <P class="Total">Total General</P>
              <P class="totalFin totalT"></P>
              <P class="finalFin porcentajeConcT">%</P>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div  class="col-sm-1"></div>
    </div>
</div>
<!-- fin -->
<br>
<br><br>
<div class="row"><br><br><br></div>

	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/ajustesBRMvsAjustesSalesForce.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/generics.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/grafica/raphael-2.1.4.min.js" ></script>	
	<script src="${pageContext.request.contextPath}/js/grafica/justgage.js" ></script>
	
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-table-es-SP.js" type="text/javascript"></script>
    	
	<script >
		$('#cb1 span').addClass('desabilitado');
	</script>

</body>
</html>