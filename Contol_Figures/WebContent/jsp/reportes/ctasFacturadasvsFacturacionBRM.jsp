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

<title>Cuentas Facturadas-BRM vs Facturaci&oacute;n-INTERFACTURA</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.min.css" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/DataTables/DataTables-1.10.18/css/jquery.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/DataTables/Buttons-1.5.6/css/buttons.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/DataTables/FixedColumns-3.2.5/css/fixedColumns.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/DataTables/FixedHeader-3.1.4/css/fixedHeader.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/DataTables/Responsive-2.2.2/css/responsive.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/DataTables/RowGroup-1.1.0/css/rowGroup.dataTables.min.css"/>
<!-- contenedor 
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.dataTables.min.css" />
 -->

 
</head>
<body onload="getReport(); getValor()">
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
									<input readonly onchange="getReport();" type="text" id="fecha" class="datepicker  form-control">
								</div>
							</div>
				    </div>
<!-- contenedor 4 -->
				<div class="col-md-1"><!--  **************div vacio 4*************  --></div>
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
<input type="hidden" id="desable_cifra" value="11">
		<jsp:include page="/jsp/generic/loadModal.jsp" />	
	<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="/CifrasControl/img/aseguramientodeingreso-icon2.png">
    							 &emsp;Cuentas Facturadas-BRM vs Facturaci&oacute;n-INTERFACTURA</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
  								
	</div>		
	<div class="col-md-5"><!-- en espera --></div>
	<div class="col-md-1  "></div></div>

<div class="col-md-1  "></div>
<div class="col-md-6 opciones"><br>
			<form>
  				<div class="col-md-4">
  				<label><input type="radio" id="enviadas" checked="checked" name="radiob" value="enviadas" onclick="getReport()">&emsp;ENVIADAS</label>
  				</div>  
  				<div class="col-md-4">
  				<label><input type="radio" id="montos" name="radiob" value="montos" onclick="getReport()">&emsp;MONTOS</label>
  				</div>
  				<div class="col-md-4">
  				</div>
  			</form>	
		</div>
		<div class="col-md-6 "></div>
		
<!--  mensaje temporal -->
<div class="col_md_12 text-center contentMessage"><BR><BR><BR><BR>
					<h3 class="colorTitleInit">Seleccione el d&iacute;a que desea consultar</h3>
				</div>
				
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" onselectstart="return false;">
				    <div class="modal-dialog modal-lg" role="document" style="width:90%;">
				      <div class="modal-content">
				        	<div class="modal-header">	        					
	        					<div class="col_md_12"><h2 class="modal-title text-center" style="color: #0000CD;">Elige consulta</h2></div>
	        					<div class="col-md-12">
				  					<div class="col-md-6 text-rigth" ></div>
									<div class="col-md-6 pull-right" style="color: #5BC687;"><h3><span class="consultaX"></span></h3></div>
			  					</div>
	      					</div> <!-- fin header -->
					        <div class="modal-body">
					        <div class="col-md-12">
					        <div class="col-md-6"><button class="btn btn-primary btn-lg" id="opc1">Detalle de Facturas que estan en BRM y que no se encontraron en la respuesta de interfactura</button></div>
					        </div>
		<div class="col-md-12">
		<!-- #1 -->
    		<div id="empresas1">
      		<br>
			<button type="button" value="TOTALPLAY"  class="btn btn-info btn1" onclick="consultaTp1()">TOTALPLAY</button>
			<button type="button" value="ENLACE" 	 class="btn btn-info btn2" onclick="consultaEnl1()">ENLACE</button>
			<button type="button" value="TFE" 		 class="btn btn-info btn3" onclick="consultaTfe1()">TFE</button>
			<button type="button" value="total" 	 class="btn btn-info btn4" onclick="consultaTt1()">TOTAL</button>
			</div>
		</div>
		<br><br>
		<div class="col-md-12">				        	
					        	<div class="table-result" style="display:none; text-alig:center">		        
						       		<div id="ti"><h3 class="tituloTabla text-center" style="color: #7337ff;"></h3></div>
									<table id="tableModal" data-show-columns="true" data-page-list="[100, 500,1000]" data-page-size="100" ></table>
									<h2 class="text-center" id="NoData" style="color: #7337ff;"></h2>
								</div>
								<br><br>
		</div>						
					        </div> <!-- fin body -->
				      </div> <!-- content -->
				    </div> <!-- modal dialog -->
				  </div> <!-- fin modal -->
<!-- imagen wait	 -->			 
		   <div id="wait" class="modal" >
					  	<div class="modal-dialog modal-lg" role="document" style="width:10%; top:20%">						  	 						  	 	 
							  <center><img style="width:110px;height:110px" src="${pageContext.request.contextPath}/img/giphy.gif">
							  <h3 class="text-center" style="color: #A2D9CE;">Cargando..</h3>
							  </center>																					 			 		
					  	</div>	
		  </div>
		  


<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title center" id="exampleModalCenterTitle">Detalle Interfactura</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <div class="row">
      	<div class="col-md-12">
      	<table id="detailInterfactura" class="display" style="width:100%">
        <thead>
            <tr>
              	<th></th>
            	<th>Fecha</th>
            	<th>Cuenta</th>
            	<th>Factura</th>
            	<th>Archivo</th>
            	<th>Empresa</th>
<!--             	<th>Fecha Factura</th> -->
<!--             	<th>Fecha Vencimiento</th> -->
            	<th>Monto</th>
<!--             	<th>Docs Timbrados</th> -->
            </tr>
            </thead>
            
            <tbody id="bodyDetailInterfactura">
            </tbody>
          
            </table>
      	</div>
      </div>
      <div class="row">
      <div class="col-md-4">
      
      </div>
      
      
      <div class="col-md-4">
      		<table  id="tableResumeInterfactura" class="row-border table" style="display:none;">
  			<thead>
    			<tr>
      				<th >COMPLEMENTOS PAGO</th>
      				<th >ESTADOS CTA.</th>
      				<th >FACTURAS</th>
      				<th >NOTAS</th>
      				<th >NO EN INFRAESTRUCTURA</th>
    			</tr>
  			</thead>
  			<tbody id="bodyResumeInterfactura">
   				
  			</tbody>
		</table>
      </div>
      <div class="col-md-4"></div>
      </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        
      </div>
    </div>
  </div>
</div>
		  			
<div class="col-md-12"><br><br></div>				
<div class="col-md-12"></div>	


	<!-- PRIMER MODULO TOTALPLAY -->
  <div class="container-fluid">
    <div class="col-md-12  contentReporte"><BR>
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
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontradas en BRM</div></td>
              <td class="tdx"><div class="divx1"><span class="error_brmTP"></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorbrmTP"></div></td>
            </tr>
            <tr>
              <td style="border:0px;">&emsp;&emsp;&emsp;&emsp;&emsp;Encontradas en Interfactura<div class="divx2"></div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_if"></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerrorIF"></div></td>
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
      <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" onclick="getDetailInterfactura()" 
>
 		Detalle De Interfactura
</button>
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
              <td class="headTable">Total de Base Interfactura</td>
            </tr>
            <tr>
              <td class="lateralBlue">
              <font class=" totalIF estado"></font>
              <div class="pull-right bcolorifTP"></div>
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
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontradas en BRM</div></td>
              <td class="tdx"><div class="divx1"><span class="error_brmENL"></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorbrmENL"></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontradas en Interfactura</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_IFENL"></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerrorIFENL"></div></td>
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
              <div>
              <font class="totalBRMENL estado"></font>
              <div class="pull-right bcolorBRMENL"></div>
              </div>
              </td>
            </tr>
            <tr>
              <td><br></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="headTable">Total de Base Interfactura</td>
            </tr>
            <tr>
              <td class="lateralCyan">
              <font class=" totalIFENL estado"></font>
              <div class="pull-right bcolorifENL"></div>
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
              <td ><b>No conciliado</td>
              <td ><b class="t_no_conciliadosTFE"/></td>
              <td ><b class="porcentajeNoConcTFE"/></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontradas en BRM</div></td>
              <td class="tdx"><div class="divx1"></div><span class="error_brmTFE"></td>
              <td class="tdx"><div class="divx1"></div><span class="porcentajeerrorbrmTFE"></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontradas en Interfactura</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_IFTFE"></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerrorIFTFE"></div></td>
            </tr>
            <tr>
              <td><div class="ttotal"><b class="Totalx">Total</div></td>
              <td><div class="ttotal"><b class=" Totalx totalTFE"></div></td>
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
              <td class="headTable">Total de Base Interfactura</td>
            </tr>
            <tr>
              <td class="lateralTfe">
              <font class=" totalIFTFE estado"></font>
              <div class="pull-right bcolorIFTFE"></div>
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
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontradas en BRM</div></td>
              <td class="tdx"><div class="divx1"><span class="error_brmT"/></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorbrmT"/></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontradas en Interfactura</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_ifT"></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerroriffT"></div></td>
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
      <div id="descargaArchivo">
                            <form action="exportDetallectasFactvsFactBRMIF" method="get" onsubmit="pasar_paramentros();">
                            	<input type="hidden" id="cptp" name="cptp">
    							<input type="hidden" id="cpenl" name="cpenl">
 							    <input type="hidden" id="cptfe" name="cptfe">
 							    <input type="hidden" id="opcion" name="opcion">
                              	<input type="hidden" id="fechaReporte" name="fecha">
                              <input type="image" src="${pageContext.request.contextPath}/img/btn-descarcargdetalletp.png" style="left:11%;top: 19px;position: relative; display:none;" id="btn-Reporte">
                          </form>
           </div>
          <div id="descargaArchivo" class="xY"  >
	        <form id="myform"></form>
	        		<input type="hidden" id="cptpTabla" name="cptp">
					<input type="hidden" id="cpenlTabla" name="cpenl">
				    <input type="hidden" id="cptfeTabla" name="cptfe">
				    <input type="hidden" id="opcionTabla" name="opcion">
					<input type="hidden" id="fechaReporteTabla" name="fechaReporte">								
			<button type="submit" class="detalle">&emsp;Ver Detalle&emsp;</button>	
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
              <td class="headTable">Total de Base Interfactura</td>
            </tr>
            <tr>
              <td class="lateralFin">
              <font class=" totalIFT estado"></font>
              <div class="pull-right bcolorIFT"></div>
              </td>
            </tr>
            
            <tr>
              <td ><h2 class="espacio"></h2>
              <P class="total">Total General</P>
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
  <div class="col-md-12"><br><br></div>
	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
	
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"	type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/ctasFacturadasvsFacturacionBRM.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/grafica/raphael-2.1.4.min.js" ></script>					
    <script src="${pageContext.request.contextPath}/js/grafica/justgage.js" ></script>	
    <script src="${pageContext.request.contextPath}/js/bootstrap-table.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-table-es-SP.js" type="text/javascript"></script>
   
   <script type="text/javascript" src="${pageContext.request.contextPath}/DataTables/DataTables-1.10.18/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/DataTables/Buttons-1.5.6/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/DataTables/Buttons-1.5.6/js/buttons.flash.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/DataTables/JSZip-2.5.0/jszip.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/DataTables/pdfmake-0.1.36/pdfmake.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/DataTables/pdfmake-0.1.36/vfs_fonts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/DataTables/Buttons-1.5.6/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/DataTables/Buttons-1.5.6/js/buttons.print.min.js"></script>


<script type="text/javascript" src="${pageContext.request.contextPath}/DataTables/FixedColumns-3.2.5/js/dataTables.fixedColumns.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/DataTables/FixedHeader-3.1.4/js/dataTables.fixedHeader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/DataTables/Responsive-2.2.2/js/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/DataTables/RowGroup-1.1.0/js/dataTables.rowGroup.min.js"></script>
   <!-- 
    <script src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js" type="text/javascript"></script>
     <script src="${pageContext.request.contextPath}/js/dataTables.responsive.min.js" type="text/javascript"></script>
    fin -->
  
	<script >
	$('#aseg5 span').addClass('desabilitado');
	</script>
</body>
</html>