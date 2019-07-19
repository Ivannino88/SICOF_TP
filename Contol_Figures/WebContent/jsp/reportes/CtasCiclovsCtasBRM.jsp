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

<title>Cuentas por Ciclo-BRM vs Cuentas Facturadas-BRM</title>
</head>
<body onload="getValor()">

<jsp:include page="/jsp/generic/errorModal.jsp"/>
<!-- inicio contenedor head -->
    <div class="row container-fluid fondo">       
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
									<input readonly  type="text" id="fecha" class="datepicker  form-control">
								</div>
							</div>
				    </div>
				<div class="col-md-1"><!--  **************div vacio *************  --></div>
				</div>
    </div>  <!-- fin div  contenedor elementos head  -->
</div>

<!--  ********************* modulo de menu desplegable ********************* -->
<!-- espacio -->
<br><br>
<div class="col-md-12">
<!-- menu desplegable --> 
	<div class="col-md-1"></div>
<div class="col-md-5" id="desplegable"> 
<input type="hidden" id="desable_cifra" value="10">
		<jsp:include page="/jsp/generic/loadModal.jsp" />	
	<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="/CifrasControl/img/aseguramientodeingreso-icon2.png">
    							 &emsp;Cuentas por Ciclo-BRM vs Cuentas Facturadas-BRM</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
  							
	</div>		
	<div class="col-md-5"><!-- en espera --></div>
	<div class="col-md-1  text-right contentReporte"></div>
	
</div>
<div class="col-md-12"><br><br><br><br></div>
<!--  mensaje temporal -->
	<div class="col_md_12 text-center contentMessage">
		<h3 class="colorTitleInit">Seleccione el d&iacute;a que desea
			consultar</h3>
	</div>


<!-- modal vista detalles -->
	
	    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  onselectstart="return false;">
				    <div class="modal-dialog modal-lg" role="document" style="width:90%;">
				      <div class="modal-content">
				        	<div class="modal-header">	        					
	        					<div class="col-md-12"><h2 class="modal-title text-center" style="color: #0000CD;">Elige consulta</h2></div>
	      					</div> <!-- fin de header -->
	      			<div class="col-md-12">
  						<div class="col-md-6 text-rigth" style="color: #5BC687;"><h3><span class="consultaX"></span></h3></div>
						<div class="col-md-6 pull-right"><button type="button" id="back" class="btn btn-warning pull-right btn-lg" style="display: none;" >
							<span class="glyphicon glyphicon-menu-left" aria-hidden="true">&emsp;</span>REGRESAR</button></div>
  					</div>
					        <div class="modal-body">
					        <div class="col-md-12">
			  					<div class="col-md-6"><button class="btn btn-info btn-lg" id="opc1">Detalle de cuentas que no facturaron</button></div>
			  					<div class="col-md-6"><button class="btn btn-success btn-lg" id="opc2">Detalle de facturas que no estaban en su ciclo</button></div>
  							</div>
  							<div class="col-md-12"><br></div>
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
					        <br><br>					        	
					        	<div class="table-result" style="display:none; text-alig:center">		        
						       		<h3 class="tituloTabla text-center" style="color: #7337ff;"></h3>
									<table id="tableModal" data-show-columns="true" data-page-list="[100, 500,1000]" data-page-size="100" ></table>
									<h2 class="text-center" id="NoData" style="color: #7337ff;"></h2>
								</div>
							<br><br>
							<div class="col-md-12"><br><br><br></div>	
					        </div>
				      </div>
				    </div>

<!--  imagen cargando -->
				    <div id="wait" class="modal" >
					  	<div class="modal-dialog modal-lg" role="document" style="width:10%; top:20%">						  	 						  	 	 
							  <center><img style="width:110px;height:110px" src="${pageContext.request.contextPath}/img/giphy.gif">
							  <h3 style="color: #A2D9CE;">Cargando..</h3>
							  </center>																					 			 		
					  	</div>	
		  			</div>
		 </div>
		 
<div class="col-md-12">	</div>	

<!-------------- PRIMER MODULO TOTALPLAY ------->
  <div class="container-fluid">
    <div class="col-md-12  contentReporte">
      <div  class="col-sm-1"></div>
      <div class="col-sm-6 contenedorR">
        <h2 class="tituloPlay">TOTALPLAY</h2>
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
              <td><b class="t_conciliadosTP"/></td>
              <td><b class="porcentajeConcTP"/></td>
            </tr>
             <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="t_no_conciliadosTP"/></td>
              <td><b class=porcentajeNoConcTP /></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Cuentas Encontradas</div></td>
              <td class="tdx"><div class="divx1"><span class="error_cicloTP"></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorcuentasTP"></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Facturas Encontradas</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_facturadasTP"></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerrorfacturadasTP"></div></td>
            </tr>
            <tr>
              <td><div class="ttotal"><b class="Totalx">Total</div></td>
              <td><div class="ttotal"><b class="Totalx totalTP"></div></td>
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
              <th>Total de Base Cuentas</th>
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
              <td class="headTable">Total de Base Facturadas</td>
            </tr>
            <tr>
              <td class="lateralBlue">
              <font class=" totalimsTP estado"></font>
              <div class="pull-right bcolorimsTP"></div>
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
<div class="col-md-12"><br><br></div>	

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
              <th>Cuentas</th>
              <th>Porcentaje</th>
            </tr>
          </thead>
          <tbody class="filasText">
            <tr>
              <td><b>Conciliado</td>
              <td><b class="t_conciliadosENL"/></td>
              <td><b class="porcentajeConcENL"/></td>
            </tr>
            <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="t_no_conciliadosENL"/></td>
              <td><b class="porcentajeNoConcENL"/></td>
            </tr>
            
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Cuentas Encontradas</div></td>
              <td class="tdx"><div class="divx1"><span class="error_cicloENL"></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorcuentasENL"></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Facturas Encontradas</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_facturadasENL"></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerrorfacturadasENL"></div></td>
            </tr>
            <tr>
              <td><div class="ttotal"><b class="Totalx">Total</div></td>
              <td><div class="ttotal"><b class="Totalx totalENL"></div></td>
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
              <th>Total de Base Cuentas</th>
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
              <td class="headTable">Total de Base Facturadas</td>
            </tr>
            <tr>
              <td class="lateralCyan">
              <font class=" totalimsENL estado"></font>
              <div class="pull-right bcolorimsENL"></div>
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
<div class="col-md-12"><br><br></div>

<!-- TERCER  MODULO TFE -->
<div class="container-fluid">
    <div class="col-md-12  contentReporte">
      <div  class="col-sm-1"></div>
      <div class="col-sm-6 contenedorR">
        <h2 class="tituloTfe">TFE</h2>
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
              <td><b class="t_conciliadosTFE"/></td>
              <td><b class="porcentajeConcTFE"/></td>
            </tr>
            <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="t_no_conciliadosTFE"/></td>
              <td><b class="porcentajeNoConcTFE"/></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Cuentas Encontradas</div></td>
              <td class="tdx"><div class="divx1"><span class="error_cicloTFE"></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorcuentasTFE"></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Facturas Encontradas</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_facturadasTFE"></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerrorfacturadasTFE"></div></td>
           <tr>
              <td><div class="ttotal"><b class="Totalx">Total</div></td>
              <td><div class="ttotal"><b class="Totalx totalTFE"></div></td>
              <td></td>
            </tr>
          </tbody>
        </table>
        
		 <div class="sizegraf center-block" id="graficaTFE"></div>
        
      </div>
      <div  class="col-sm-1"></div>
      
      <div class="col-sm-3 contenedorR">
      <h2 class="espacio"></h2>
        <table class="table">
          <thead class="headTable">
            <tr>
              <th>Total de Base Cuentas</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="lateralTfe ">
              <font class="totalBRMTFE estado"></font>
              <div class="pull-right bcolorBRMTFE"></div>
              </td>
            </tr>
            <tr>
              <td><br></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="headTable">Total de Base Facturadas</td>
            </tr>
            <tr>
              <td class="lateralTfe">
              <font class=" totalimsTFE estado"></font>
              <div class="pull-right bcolorimsTFE"></div>
              </td>
            </tr>
            
            <tr>
              <td ><h2 class="espacio"></h2>
              <P class="Total">Total Tfe</P>
              <P class="totalTfe totalTFE"></P>
              <P class="finalTfe porcentajeConcTFE">%</P>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div  class="col-sm-1"></div>
    </div>
  
</div>
<div class="col-md-12"><br><br></div> 

<!-- CUARTO MODULO TOTAL -->
<div class="container-fluid">
    <div class="col-md-12  contentReporte">
      <div  class="col-sm-1"></div>
      <div class="col-sm-6 contenedorR">
        <h2 class="tituloFin">TOTAL</h2>
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
              <td><b class="t_conciliadosT"/></td>
              <td><b class="porcentajeConcT"/></td>
            </tr>
            <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="t_no_conciliadosT"/></td>
              <td><b class="porcentajeNoConcT"/></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Cuentas Encontradas</div></td>
              <td class="tdx"><div class="divx1"><span class="error_cicloT"></span></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorcuentasT"></span></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Facturas Encontradas</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_facturadasT"></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerrorfacturadasT"></div></td>
            </tr>
			<tr>
              <td><div class="ttotal"><b class="Totalx">Total</div></td>
              <td><div class="ttotal"><b class="Totalx totalT"></div></td>
              <td></td>
            </tr>
          </tbody>
        </table>
         
		 <div class="sizegraf center-block" id="graficaALL"></div>
      </div>
      <div  class="col-sm-1"></div>
      
      <div class="col-sm-3 contenedorR">
         <div id="descargaArchivo">
                            <form action="exportDetalleCicloBRMDetails" method="get">
                              <input type="hidden" id="fechaReporte" name="fecha">
                              <input type="image" src="${pageContext.request.contextPath}/img/btn-descarcargdetalletp.png" style="left:11%;top: 19px;position: relative; display:none;" id="btn-Reporte">
                          </form>
         </div>
         <div id="descargaArchivo" class="xY"  >
			<button type="submit" class="detalle " >&emsp;Ver Detalle&emsp;</button>
		</div>	
        <table class="table">
          <thead class="headTable">
            <tr>
              <th>Total de Base Cuentas</th>
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
              <td class="headTable">Total de Base Facturadas</td>
            </tr>
            <tr>
              <td class="lateralFin">
              <font class=" totalimsT estado"></font>
              <div class="pull-right bcolorimsT"></div>
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
  <div class="col-md-12"><br><br><br></div>

	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"	type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/CtasCiclovsCtasBRM.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/grafica/raphael-2.1.4.min.js" ></script>
	<script src="${pageContext.request.contextPath}/js/grafica/justgage.js" ></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-table-es-SP.js" type="text/javascript"></script>
  
	<script>
	$('#aseg4 span').addClass('desabilitado');
	</script>
</body>
</html>