<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-select.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/generic.css" />
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/generic/desplegable.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/estilosDIVS.css" />
<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png">	
<title>Pagos BRM vs  Bancos - BRM - BANCOS </title>
</head>
<body>
	<div class="col-xs-12 col-sm-12 col-md-2 col-lg-2 menuContent">
	</div>
	<jsp:include page="/jsp/generic/errorModal.jsp"/>
<jsp:include page="/jsp/generic/loadModal.jsp"/>
	<div class="container-fluid">
		<br />
		<div class="row">
			
			<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9">
				
				<div class="row">
					<div class="col-md-12 text-right">
						<div class="col-md-1">
							<p class="text-right" style="margin-top: 10px; float: right;">
								<span class="">&nbsp;</span><span>D&iacute;a: </span>
							</p>
						</div>
						
						<div class="col-md-3">
							<div class="form-group">
								<div class='input-group date' id='datetimepicker1'>
									<input readonly type="text" id="fecha" onchange="consultaReporte();" class="datepicker  form-control"> 
									<span class="input-group-addon"> 
										<span class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>

						</div>
						<div class="col-md-1">
						<p class="text-right" style="margin-top: 10px; float: right;">
							<span class="">&nbsp;</span><span>Empresa: </span>
						</p>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
						
							<select id="selectEmpresa" class="select  form-control" onchange="listaCanales();"  title="Empresa">
								<option value="">--Selecciona--</option>
								<option value="TOTALPLAY">TotalPlay</option>
								<option value="ENLACE">Enlace</option>
								<option value="TFE">TFE</option>
							</select>
						</div>
					</div>
					<div class="col-md-1">
						<p class="text-right" style="margin-top: 10px; float: right;">
							<span class="">&nbsp;</span><span>Canal: </span>
						</p>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<select id="selectCanal" class="select  form-control" onchange="consultaReporte();"  title="Canal">
								<option value="">--Selecciona--</option>								
							</select>
						</div>
					</div>
					</div>
				</div>
				
				<div class="row">
				<div class="col-md-11" style="color: #fbb042;" align="center">
						<h4><b>D&Iacute;A:</b> <b class="fechaEt"></b></h4>
					</div></div>
				
				<div class="row">
					<div class="col-md-11" style="color: #fbb042;" align="center">
						<h4><b>Pagos BRM vs Bancos - BRM - BANCOS</b> </h4>
					</div>
				
				</div>
				
				<br><br>
				<div class="col_md_12 text-center contentMessage">
					<h3 class="colorTitleInit">Seleccione el d&iacute;a, empresa y canal del reporte que desea consultar</h3>
				</div>
				<div class="col-md-12 contentReporte" >
							
				
				<!-- ***** INICIA BLOQUE TOTALPLAY ****** -->
				<div id="totalplay">
				<div class="row">
					<div class="col-md-4"> </div>
					<div class="col-md-2" align = "center">
						<b>RESULTADO </b>
						<div class="pull-right decision"></div>
					</div>
					<div class="col-md-2"> </div>
				</div>	
				
				<br>
			
				<div class="row">
					<div class="col-md-1"> </div>
					<div class="col-md-6" align = "left" style="color: #727276;">
						<h3><b id="empresa"> </b></h3>
					</div>
					<div class="col-md-2"> </div>
				</div>	
				
				<br>
				
				<div class="row">
					<div class="col-md-1" align="right">
					</div>
					<div class="col-md-2" align = "center">
						<blockquote>
							<b>ESTATUS</b>
						</blockquote>
					</div>
					
					<div class="col-md-2" align = "center">
						<blockquote>
							<b> CUENTAS</b>			
						</blockquote>			
					</div>
					<div class="col-md-2" align = "center">
						<blockquote>
							<b>PORCENTAJE</b>
						</blockquote>
					</div>
					<div class="col-md-2">
					<br><br>
					<b style="color: #bed539;">TOTAL DE BASE BRM</b>   <br/> 
					</div>
				</div>	
				
				<div class="row">
					<div class="col-md-2  col-md-offset-1 text-center colorDivVerde">
						<b class="statusConcTP"></b>
					</div>
					<div class="col-md-2  text-center colorDivVerde">
						<b class="t_conciliadosTP"></b>	
					</div>
					<div class="col-md-2  text-center colorDivVerde">
						<b class="porcentajeConcTP"></b>	
					</div>
					<div class="col-md-2" >
						
						<b style="color: #727276;"><font size="6" class="totalBRMTP"></font><div class="pull-right bcolorBRMTP"></div></b><br>
					</div>
				</div>	
				
				<div class="row">
					<div class="col-md-1"> </div>
					<div class="col-md-2" align = "center"> </div>
					<div class="col-md-2" align = "center"> </div>
					<div class="col-md-2" align = "center"> </div>
					<div class="col-md-2" align = "center"> </div>
				</div>	
				
				<div class="row">
					<div class="col-md-1"> </div>
					<div class="col-md-2" align = "center"> </div>
					<div class="col-md-2" align = "center"> </div>
					<div class="col-md-2" align = "center"> </div>
					<div class="col-md-2" >					
						<b style="color: #bed539;">TOTAL DE BASE PAGOS</b>
					 </div>
				</div>
				
				<div class="row">
					<div class="col-md-2  col-md-offset-1 text-center colorDivVerde">
						<b class="statusNoConcTP"></b>
					</div>
					<div class="col-md-2  text-center colorDivVerde">
						<b class="t_no_conciliadosTP"></b>	
					</div>
					<div class="col-md-2  text-center colorDivVerde">
						<b class="porcentajeNoConcTP"></b>	
					</div>
					<div class="col-md-2" >
						<b style="color: #727276;"><font size="6" class="totalpagosTP"></font><div class="pull-right bcolorPAGOSTP"></div> </b><br>
					</div>
				</div>	
				
				<div class="row">
					<div class="col-md-1"> </div>
					<div class="col-md-2" align = "center">
						<small><b>Encontrados en BRM</b>	</small>				
					</div>
					<div class="col-md-2" align = "center" ><b class="error_brmTP"></b> </div>
					<div class="col-md-2" align = "center"><b class="porcentajeerrorbrmTP"></b></div>
					<div class="col-md-2" align="center"> </div>
				</div>
				
				<div class="row">
					<div class="col-md-1"> </div>
					<div class="col-md-2" align = "center">
						<small><b>Encontrados en PAGOS</b></small>
					</div>
					<div class="col-md-2" align = "center" ><b class="error_pagosTP"></b></div>
					<div class="col-md-2" align = "center"><b class="porcentajeerrorpagosTP"></b></div>
					<div class="col-md-2">						
						<b style="color: #bed539;"><font size="3">TOTAL TOTALPLAY</font></b> <br>
						<b style="color: #727276;"><font size="7" class="totalTP"></font></b>
						<b style="color: #727276;"><font size="6" class="porcentajeConcTP"></font></b><br><br>
					</div>
				</div>	
				
				
				
					</div>
				<!-- TERMINA BLOQUE TOTALPLAY -->
				
					
				
					

			
					<div class="col-md-2" align="center"> </div>
				</div>
				<div class="row"> </div>
				
				<!-- TERMINA BLOQUE TOTAL GRAL -->									
			</div>
		</div>
	
	
	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"	type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/conciliacionBrmBancos.js" type="text/javascript"></script>
</body>
</html>