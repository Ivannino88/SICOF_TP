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

<title>Consumos VOD'S-BRM vs VOD'S-IPTV
 </title>
</head>
<body onload="getValor()">
	<jsp:include page="/jsp/generic/errorModal.jsp"/>
    <div class="row container-fluid fondo">       <!-- inicio contenedor head -->
      <jsp:include page="/jsp/header/etiqueta.jsp"/>
   			<div class="col-md-7 etiquetaDivGeneral" > 
   			<div class="col-md-12" style=" background-color: "> 
					
					<div  class="col-md-2" align="center"  >
						<div style="display: none;" id="mes" >
							<p class="text-center elemento" > <span>Mes:</span> 	</p>
											<select class="form-control" style="width: 110px;"  id="selectMes" ></select>
						</div>
					
					</div>
					<div class="col-md-2" align="center"  >
									<div style="display: none;" id="semana" >
										<p class="text-center elemento" > <span>Semana:</span> </p>
										<select class="form-control" style="width: 70px;"  id="selectsem"  onchange="consultaXsemana()"> </select>
									</div>
					</div>
					<div class="col-md-2" align="center"  >
									<div style="display: none; margin-left: -14px; " id="anhio" >
										<p class="text-center elemento" ><span>Año:</span></p>
										
										     <select class="form-control" style="width: 75px;"  id="selectanio"> </select> 
										   <fieldset >
										   <!--  <button type="submit" class="btn btn-default "><span class="anhioActual" ></span></button> -->
										 </fieldset>
									</div>
					
					</div> 
					<div class="col-md-2 "  align="center"  >
							<p class="text-center elemento" ><span>Consulta:</span></p>
							<div style="display: none;  margin-left: -14px" class="semanaBtn"><button type="button" class="btn btn-info" id="Xsemana">Por Semana</button></div>	
							<div style="display: none;" class="diaBtn"><button type="button" class="btn btn-primary " id="Xdia">	Por Dia</button></div>
					</div>
					<div class="col-md-3" align="center" id="calendario">
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
				<div class="col-md-1"><!--  **************div vacio 4*************  -->	</div>
				</div>
				    </div>  <!-- fin div  contenedor elementos head  -->
</div>
<br><br>
<!--  ********************* modulo de menu desplegable ********************* -->
<div class="col-md-12">
		<div class="col-md-1"><!-- en espera --></div>
<div class="col-md-5" id="desplegable"> 
<input type="hidden" id="desable_cifra" value="19">
		<jsp:include page="/jsp/generic/loadModal.jsp" />
	<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="/CifrasControl/img/aseguramientodeingreso-icon2.png">
    							 &emsp;Consumos VOD'S-BRM vs VOD'S-IPTV</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
	
	</div>	
	
	<div class="col-md-1"></div>
	<div class="col-md-3 text-center contentReporte">
		<button type="submit" class="detalle detalleDia"> &emsp;Ver Detalle&emsp; </button>
	</div>
	<div class="col-md-3 text-center contentReporte02">
		<button type="submit" class=" detalle detalleSemana" style="display: none;"> &emsp;Detalle Semana&emsp; </button>
	</div>		
	<div class="col-md-2 text-right contentReporte dropdown">
		<div id="descargaArchivo elemento">
				<form action="exportgetDetalleVods" method="get">
					<input type="hidden" id="fechaReporte" name="fecha">
						<font color="white">
								<button id="btn-Reporte" type="submit" class="btn btn-xs btn-inverse2" style="display: none;" >
									&emsp;&emsp;Descargar detalle
								</button>
						</font>
				</form>
		</div>
	</div>
	<div class="col-md-2 text-right contentReporte02 " >
		<div id="descargaArchivo elemento">
		<form action="exportgetDetalleVodsSemana" method="get">
			<input type="hidden"  id="semanaActual"  name ="selectsem">
			<input type="hidden"  id="fechaAnhioS"  name ="fechaAnhioDown">
						<font color="white">
								<button  id="btn-Reporte2" type="submit" class="btn btn-xs btn-inverse2" style="display: none;" >
									 &emsp;&emsp;Descargar detalle
								</button>
						</font>
		</form>
<!--		
		<form action="verValor" method="get">
			<input type="hidden"  id="semanaActual"  name="selectsem">
								<button  type="submit" class="btn btn-success"  id="semanaActual" >
									&emsp;&emsp;ver valor
								</button>
						
		</form>
-->		
				<!--  
				<form action="exportgetDetalleVodsSemana" method="get">
					<input type="hidden" id="fechaReporte" name="fecha">
						<font color="white">
								<button id="btn-Reporte" type="submit" class="btn btn-xs btn-inverse2" style="display: none;" >
									&emsp;&emsp;Descargar detalle02
								</button>
						</font>
				</form>
				-->
		</div>
	</div>
						
</div>	
<br><br>
<br><br>
<!-- *******************************************    mensajes de aviso   ************************** -->
				<div class="col_md_12 text-center contentMessage">
					<h3 class="colorTitleInit">Seleccione el d&iacute;a del reporte que desea consultar</h3>
				</div>
<!-- modal ver detalle -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" onselectstart="return false;">
				    <div class="modal-dialog modal-lg" role="document" style="width:90%;">
				      <div class="modal-content">
				        	<div class="modal-header" id="radioButtonContainerId">	        					
	        					<div class="col-md-12"><h2 class="modal-title text-center" style="color: #0000CD;">Elige consulta</h2></div>
	      					</div>
					        <div class="modal-body">
					        <div class="col-md-12">
					        <div class="col-md-6"><button class="btn btn-info" onclick="consultaX()">Detalle VODS</button></div>
					        <div class="col-md-6"></div>
					        </div>
					        <div class="col-md-12">
					        	<br><br>					        	
					        	<div class="table-result" style="display:none; text-alig:center">		        
						       		<h3 class="tituloTabla text-center" style="color: #7337ff;"></h3>
						       		
									<table id="tableModal" data-show-columns="true" data-page-list="[100, 500,1000]" data-page-size="100"></table>
									<h2 class="text-center" id="NoData" style="color: #7337ff;"></h2>
								</div>
								<br><br>
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
		        
				
<!--    ************************   cuerpo de informacion***********************  -->
<!--  MODULO DE INFORMACION -->
<div class="container-fluid">
    <div class="col-md-12 contentReporte ">
      <div  class="col-sm-1"></div>
      <div class="col-sm-6 contenedorR">
       
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
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado BRM</div></td>
              <td class="tdx"><div class="divx1"><span class="error_brmT"></span></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorbrmT"></span></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado IPVT</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_u2000T"></span></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerroru2000T"></span></div></td>
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
      <div  class="col-sm-1"></div>
      
      <div class="col-sm-3 contenedorR">
     
        <table class="table">
          <thead class="headTable">
            <tr>
              <th>Total de Base BRM</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="lateralBlue ">
              <span class="aln totalBRMT" id="totalBRMT"></span>
							<div class="pull-right bcolorBRMT"></div>
              </td>
            </tr>
            <tr>
              <td><br></td>
              <td></td>
              <td></td>
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
              <P class="totalBlue totalT"></P>
              <P class="finalBlue porcentajeConcT">%</P>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div  class="col-sm-1"></div>
    </div>
</div> 

<!--  ______________________         MODULO DE INFORMACION   ________________  # 02 -->
<div class="container-fluid contentReporte02" style="display: none;" >
    <div class="col-md-12 " >
      <div  class="col-sm-1"></div>
      <div class="col-sm-6 contenedorR">
       
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
              <td><b class="t_conciliadosSem"     /></td>
              <td><b class="porcentajeConcSem" /></td>
            </tr>
            <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="t_no_conciliadosSem"/></td>
              <td><b class="porcentajeNoConcSem"/></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado BRM</div></td>
              <td class="tdx"><div class="divx1"><span class="error_brmSem"></span></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorbrmSem"></span></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado IPVT</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_u2000Sem"></span></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerroru2000Sem"></span></div></td>
            </tr>
            <tr>
               <td><div class="ttotal"><b class="Totalx">Total</div></td>
               <td><div class="ttotal"><b class=" Totalx totalSem"></div></td>
               <td></td>
            </tr>

          </tbody>
        </table>
        
				<div class="sizegraf center-block" id="grafica02"></div>  <!-- grafica total conciliado -->
      </div>
      <div  class="col-sm-1"></div>
      
      <div class="col-sm-3 contenedorR">
     
        <table class="table">
          <thead class="headTable">
            <tr>
              <th>Total de Base BRM</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="lateralBlue ">
              <span class="aln totalBRMSem" ></span>
							<div class="pull-right bcolorBRMT"></div>
              </td>
            </tr>
            <tr>
              <td><br></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="headTable">Total de Base IPTV</td>
            </tr>
            <tr>
              <td class="lateralBlue">
              <span class="aln totalU2000Sem" ></span>
							<div class="pull-right bcolorU2000T"></div>
              </td>
            </tr>
            
            <tr>
              <td ><h2 class="espacio"></h2>
              <P class="Total">Total General</P>
              <P class="totalBlue totalSem"></P>
              <P class="finalBlue porcentajeConcSem">%</P>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div  class="col-sm-1"></div>
    </div>
</div> 

<!-- modal ver detalle02 -->
				<div class="modal fade" id="myModal02" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" onselectstart="return false;">
				    <div class="modal-dialog modal-lg" role="document" style="width:90%;">
				      <div class="modal-content">
				        	<div class="modal-header" >	        					
	        					<div class="col-md-12"><h2 class="modal-title text-center" style="color: #0000CD;">Consulta Semanal</h2></div>
	      					</div>
					        <div class="modal-body">
					        <div class="col-md-12">
					        <div class="col-md-6"><button class="btn btn-info" onclick="reporteSemana()">Detalle VODS semana &emsp;<span id="actual"></span></button></div>
					        <div class="col-md-6"></div>
					        </div>
					        <div class="col-md-12">
					        	<br><br>	
				        	
					        	<div class="table-result02" style="display:none; text-alig:center">		        
						       		<h3 class="tituloTabla02 text-center" style="color: #7337ff;"></h3>
						       		
									<table id="tableModalSemana" data-show-columns="true" data-page-list="[100, 500,1000]" data-page-size="100"></table>
									<h2 class="text-center" id="NoData02" style="color: #7337ff;"></h2>
								</div>
								<br><br>
								</div>
								<div class="col-md-12"><br><br></div>	
					        </div>
				      </div>
				    </div>
		        </div>
		        
<!-- imagen esperando datos	 -->	       
		       <div id="cargando" class="modal" >
					  	<div class="modal-dialog modal-lg" role="document" style="width:10%; top:20%">						  	 						  	 	 
							  <center><img style="width:80px;height:80px" src="${pageContext.request.contextPath}/img/giphy.gif">
							  <h3 style="color: #A2D9CE;">Cargando..</h3>
							  </center>																					 			 		
					  	</div>	
		  		</div>		

<div class="col-md-12"><br><br><br></div>
			
	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"	type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/consumosVodBrmIptv.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/grafica/raphael-2.1.4.min.js" ></script>					
    <script src="${pageContext.request.contextPath}/js/grafica/justgage.js" ></script>	
    
    <script src="${pageContext.request.contextPath}/js/bootstrap-table.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-table-es-SP.js" type="text/javascript"></script>
	<script >
	$('#aseg13 span').addClass('desabilitado');
	</script>
</body>
</html>