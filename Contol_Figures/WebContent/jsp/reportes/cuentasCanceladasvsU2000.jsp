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

<title>Cuentas Canceladas-BRM vs U2000</title>
</head>
<body onload="getValor(); ">
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
									<input readonly onchange="sendSolicitud();" type="text" id="fecha" class="datepicker  form-control">
								</div>
							</div>
				    </div>
				<div class="col-md-1"><!--  **************div vacio 4*************  -->	</div>
				</div>
				    </div>  <!-- fin div  contenedor elementos head  -->
</div>


<!--  ********************* modulo de menu desplegable ********************* -->
<!-- espacio -->
<br><br>
<div class="col-md-12">	
<!-- menu desplegable --> 
	<div class="col-md-1" ></div>
<div class="col-md-5" id="desplegable"> 
<input type="hidden" id="desable_cifra" value="15">
		<jsp:include page="/jsp/generic/loadModal.jsp" />
	<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="/CifrasControl/img/aseguramientodeingreso-icon2.png">
    							&emsp;Cuentas Canceladas-BRM vs U2000</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
  								
	</div>		
	<div class="col-md-5"><!-- en espera --></div>
	<div class="col-md-1 "></div>
</div>
<!-- mensaje temporal -->
<div class="col-md-12"><br><br><br><br></div>
	<div class="col_md_12 text-center contentMessage">
		<h3 class="colorTitleInit">Seleccione el d&iacute;a que desea
			consultar</h3>
	</div>

<!-- modal vista detalle -->	
	 		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" onselectstart="return false;">
				    <div class="modal-dialog modal-lg" role="document" style="width:90%;">
				      <div class="modal-content">
				        	<div class="modal-header">	        					
	        					<div class="col-md-12"><h2 class="modal-title text-center" style="color: #0000CD;">Elige consulta</h2></div>

	      					</div> <!-- fin head -->
	      					<div class="col-md-12">
	      					<div class="col-md-6"><div class="col-md-6"><button class="btn btn-primary" id="opc1">Detalle de cuentas canceladas BRM y que su ONT sigue activa en U2000</button></div></div>
		  					<div class="col-md-6" style="color: #5BC687;"><h3><span class="consultaX"></span></h3></div>
		  					</div>
					        <div class="modal-body">
					       
				  			<div class="col-md-12">
							<!-- #1 -->
					    		<div >
								<button type="button" value="TOTALPLAY"  class="btn btn-info btn1" onclick="consultaTp1()">TOTALPLAY</button>
								<button type="button" value="ENLACE" 	 class="btn btn-info btn2" onclick="consultaEnl1()">ENLACE</button>
								<button type="button" value="TFE" 		 class="btn btn-info btn3" onclick="consultaTfe1()">TFE</button>
								<button type="button" value="total" 	 class="btn btn-info btn4" onclick="consultaTt1()">TOTAL</button>
								</div>
							</div>
							<div class="col-md-12">
					        	<br><br>				        	
					        	<div class="table-result" style="display:none; text-alig:center">		        
						       		<h3 class="tituloTabla text-center" style="color: #7337ff;"></h3>
									<table id="tableModal" data-show-columns="true" data-page-list="[100, 500,1000]" data-page-size="100" ></table>
									<h2 class="text-center" id="NoData" style="color: #7337ff;"></h2>
								</div>
							</div>
							<div class="col-md-12"><br><br></div>
					        </div> <!-- fin body -->
				      </div>
				    </div>
		       </div>
<!-- imagen cargando -->
				    <div id="wait" class="modal" >
					  	<div class="modal-dialog modal-lg" role="document" style="width:10%; top:20%">						  	 						  	 	 
							  <center><img style="width:110px;height:110px" src="${pageContext.request.contextPath}/img/giphy.gif">
							  <h3 style="color: #A2D9CE;">Cargando..</h3>
							  </center>																					 			 		
					  	</div>	
		  			</div>
	
	<br><br><br><br>
							<!-- PRIMER MODULO TOTALPLAY -->
  <div class="container-fluid">
    <div class="col-md-12  contentReporte">
      <div  class="col-sm-1"></div>
      <div class="col-sm-6 contenedorR">
        <h2 class="tituloPlay">TOTALPLAY </h2>
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
              <td><b class="tp_t_conciliados"/></td> 
              <td><b class="tp_porcentaje"/></td>
            </tr>
            <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="tp_error_total"></td>
              <td><b class="porce_noConciliado"></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrados BRM</div></td>  
              <td class="tdx"><div class="divx1"><p class="tp_t_error_brm"></p></div></td> 
              <td class="tdx"><div class="divx1"><p class="tp_porcentajeBrm"></p></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontradas U2000</td> 
              <td style="border:0px;"><div class="divx2"><p class="tp_t_error_u2000"></p></div></td> 
              <td style="border:0px;"><div class="divx2"><p class="tp_porcentajeU2000"></p></div></td>
            </tr>
            <tr>
              <td><div class="ttotal"><b class="Totalx">Total</div></td>
              <td><div class="ttotal"><b class=" Totalx tp_total"></div></td>
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
              <th>Total de base BRM</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="lateralBlue ">
             <span class="aln tp_no_brm" id="total1tp"></span>
							<div class="pull-right bcolor1tp"></div>
              </td>
            </tr>
            <tr>
              <td><br></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="headTable">Total de Base U2000</td>
            </tr>
            <tr>
              <td class="lateralBlue">
             <span class="aln tp_no_u2000" id="total2tp"></span>
							<div class="pull-right bcolor2tp"></div>
              </td>
            </tr>
            
            <tr>
              <td ><h2 class="espacio"></h2>
              <P class="Total">Total Totalplay</P>
              <P class="totalBlue tp_total"></P>
              <P class="finalBlue tp_porcentaje">%</P>
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
        <h2 class="tituloEnlace">Enlace</h2>
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
              <td><b class="en_t_conciliados"/></td>
              <td><b class="en_porcentaje"/></td>
            </tr>
            <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="en_error_total"></td>
              <td><b class="en_porcentajeNC"></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrados BRM</div></td>
              <td class="tdx"><div class="divx1"><p class="en_error_brm"></div></td>
              <td class="tdx"><div class="divx1"><p class="en_porcentaje1"></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontradas U2000</div></td>
              <td style="border:0px;"><div class="divx2"><p class="en_error_u2000"></div></td>
              <td style="border:0px;"><div class="divx2"><p class="en_porcentaje2"></div></td>
            </tr>
            <tr>
              <td><div class="ttotal"><b class="Totalx">Total</div></td>
              <td><div class="ttotal"><b class=" Totalx en_total"></div></td>
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
              <span class="aln en_no_brm" id="total1e"></span>
							<div class="pull-right bcolor1e"></div>
              </td>
            </tr>
            <tr>
              <td><br></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="headTable">Total de Base U2000</td>
            </tr>
            <tr>
              <td class="lateralCyan">
              <span class="aln en_no_u2000" id="total2e"></span>
							<div class="pull-right bcolor2e"></div>
              </td>
            </tr>
            
            <tr>
              <td ><h2 class="espacio"></h2>
              <P class="Total">Total Enlace</P>
              <P class="totalCyan en_total"></P>
              <P class="finalCyan en_porcentaje">%</P>
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
              <td><b class="tfe_t_conciliados"/></td>
              <td><b class="tfe_porcentaje"/></td>
            </tr>
            <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="tfe_error_total"></td>
              <td><b class="tfe_porcentajeNC"></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrados BRM</div></td>
              <td class="tdx"><div class="divx1"><p class="tfe_error_brm"></div></td>
              <td class="tdx"><div class="divx1"><p class="tfe_porcentaje1"></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontradas U2000</div></td>
              <td style="border:0px;"><div class="divx2"><p class="tfe_error_u2000"></div></td>
              <td style="border:0px;"><div class="divx2"><p class="tfe_porcentaje2"></div></td>
            </tr>
            <tr>
              <td><div class="ttotal"><b class="Totalx">Total</div></td>
              <td><div class="ttotal"><b class=" Totalx tfe_total"></div></td>
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
              <th>Total de Base BRM</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="lateralTfe ">
              <span class="aln tfe_no_brm" id="total1tfe"></span>
							<div class="pull-right bcolor1tfe"></div>
              </td>
            </tr>
            <tr>
              <td><br></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="headTable">Total de Base U2000</td>
            </tr>
            <tr>
              <td class="lateralTfe">
              <span class="aln tfe_no_u2000" id="total2tfe"></span>
							<div class="pull-right bcolor2tfe"></div>
              </td>
            </tr>
            
            <tr>
              <td ><h2 class="espacio"></h2>
              <P class="Total">Total Tfe</P>
              <P class="totalTfe tfe_total"></P>
              <P class="finalTfe porcentaje2tfe">%</P>
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
              <td><b class="t_conciliados"/></td>
              <td><b class="porcentaje"/></td>
            </tr>
            <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="error_total"></td>
              <td><b class="porcentajeNC"></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrados BRM</div></td>
              <td class="tdx"><div class="divx1"><p class="error_brm" ></div></td>
              <td class="tdx"><div class="divx1"><p class="porcentaje1"></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontradas U2000</div></td>
              <td style="border:0px;"><div class="divx2"><p class="error_u2000"></div></td>
              <td style="border:0px;"><div class="divx2"><p class="porcentaje2"></div></td>
            </tr>
            <tr>
              <td><div class="ttotal"><b class="Totalx">Total</div></td>
              <td><div class="ttotal"><b class=" Totalx total"></div></td>
              <td></td>
            </tr>
          </tbody>
        </table>
        
		 <div class="sizegraf center-block" id="graficaALL"></div>
      </div>
      <div  class="col-sm-1"></div>
      
      <div class="col-sm-3 contenedorR">
      <div id="descargaArchivo" >
                   <form action="exportCCanceladasvsU2000">
                      <input type="hidden" id="fechaReporte" name="fechaReporte">
                      <input type="image" src="${pageContext.request.contextPath}/img/btn-descarcargdetalletp.png" style="left:11%;top: 19px;position: relative; display:none;" id="btn-Reporte">
                  </form>
      
       </div>
       <div id="descargaArchivo" class="xY"  >
			<button type="submit" class="detalle " >
	                           &emsp;Ver Detalle&emsp;
	        		</button>
			
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
              <span class="aln no_brm" id="total1"></span>
							<div class="pull-right bcolor1"></div>
              </td>
            </tr>
            <tr>
              <td><br></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="headTable">Total de Base U2000</td>
            </tr>
            <tr>
              <td class="lateralFin">
              <span class="aln no_u2000" id="total2"></span>
							<div class="pull-right bcolor2"></div>
              </td>
            </tr>
            <tr>
              <td ><h2 class="espacio"></h2>
              <P class="Total">Total General</P>
              <P class="totalFin total"></P>
              <P class="finalFin porcentaje">%</P>
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
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/functioncCanceladasvsU2000.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/grafica/raphael-2.1.4.min.js" ></script>					
  <script src="${pageContext.request.contextPath}/js/grafica/justgage.js" ></script>	
  
  <script src="${pageContext.request.contextPath}/js/bootstrap-table.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-table-es-SP.js" type="text/javascript"></script>
  
	<script >
		//alert("canceladas");
	$('#aseg9 span').addClass('desabilitado');
	</script>
</body>
</html>