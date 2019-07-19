<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-select.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/generic.css" />
<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png">	
<title>Almac&eacute;n Central vs. Entradas Sub Almacenes</title>
</head>
<body>
<jsp:include page="/jsp/generic/errorModal.jsp"/>
<jsp:include page="/jsp/generic/loadModal.jsp"/>
    <div class="row container-fluid fondo">       <!-- inicio contenedor head -->
      <jsp:include page="/jsp/header/etiqueta.jsp"/>
   			<div class="col-md-7 etiquetaDivGeneral" >  
<!-- contenedor 1 -->
					<div  class="col-md-3"><!--  **************div vacio 1*************  --></div>
<!-- contenedor 2 -->
					<div class="col-md-3 "><!--  **************div vacio 2*************  --></div> 
<!-- contenedor 3 -->					
					<div class="col-md-3">
				      <p class="text-center elemento" >
								<span>D&iacute;a: </span>
					 </p>
					 		<div class="form-group">
								<div class='input-group date' id='datetimepicker1'>
									<input readonly onchange="sendSolicitud();" type="text" id="fecha" class="datepicker  form-control"> 
									<span class="input-group-addon"> 
										<span class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
				    </div>
<!-- contenedor 4 -->
				<div class="col-md-3"><!--  **************div vacio 4*************  -->	</div>
				    </div>  <!-- fin div  contenedor elementos head  -->
				    
	<div class="container-fluid">
		<br />
		<div class="row">
			
			<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9">
<!--  
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-4 text-right">
						<div class="col-md-4">
							<p class="text-right" style="margin-top: 10px; float: right;">
								<span class="">&nbsp;</span><span>D&iacute;a: </span>
							</p>
						</div>
						<div class="col-md-8">
							<div class="form-group">
								<div class='input-group date' id='datetimepicker1'>
									<input readonly onchange="sendSolicitud();" type="text" id="fecha" class="datepicker  form-control"> 
									<span class="input-group-addon"> 
										<span class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>

						</div>
					</div>
				</div>
-->				
				<div class="row">
				<div class="col-md-10" style="color: #fbb042;" align="center">
						<h4>DIA: <b class="fechaEt"></b></h4>
					</div></div>
				
				<div class="row">
					<div class="col-md-10" style="color: #fbb042;" align="center">
						<h4>Almac&eacute;n Central vs. Entradas Sub Almacenes</h4>
					</div>
					<div class="col-md-2" style="color: #fbb042;">
						<h4 class="fechaaCentral"></h4>
					</div>
				</div>
				<br><br>
			<div class="col_md_12 text-center contentMessage">
				<h3 class="colorTitleInit">Seleccione el d&iacute;a del reporte que desea consultar</h3>
			</div>
			<div class="col-md-12 contentReporte" >
				<div class="row">
					<div class="col-md-4">
						
					</div>
					<div class="col-md-2" align = "center">
						   
						   <b>RESULTADO</b> 
						    <div class="pull-right decision"></div>
					</div>
					<div class="col-md-2">
						
					</div>
				</div>	
				<br>
				<div class="row">
					<div class="col-md-1" align="right">

					</div>
					<div class="col-md-3" align = "center">
						<blockquote>
						  <p>ESTATUS</p>
						</blockquote>
					</div>
					<div class="col-md-2" align = "center">
						<blockquote>
						  <p>DISPOSITIVOS</p>
						</blockquote>	
					</div>
					<div class="col-md-2" align = "center">
						<blockquote>
						  <p>PORCENTAJE</p>
						</blockquote>		
					</div>
					<div class="col-md-2">
						
					</div>
				</div>	
				
				<div class="row">
					
					<div class="col-md-3 colorDivVerde alert col-md-offset-1 text-center">
						<b class="status"></b>
					</div>
					<div class="col-md-2 colorDivVerde alert text-center">
						<b class="cantidad"></b>	
					</div>
					<div class="col-md-2 colorDivVerde alert text-center">
						<b class="porcentaje"></b>	
					</div>
					
					<div class="col-md-2" align="center">
						<b style="color: #ccbeff;">TOTAL DE BASE</b>  <div class="pull-right bcolor"></div>
						<b style="color: #727276;"><font size="5" class="total1"></font></b><br>
						
					</div>
				</div>	
				<div class="row">
					<div class="col-md-1">
						
					</div>
					<div class="col-md-3" align = "center">
												
					</div>
					<div class="col-md-2" align = "center">
						
					</div>
					<div class="col-md-2" align = "center">
						
					</div>
					<div class="col-md-2" align="center">
						
					</div>
				</div>	
				<div class="row">
					<div class="col-md-1">
						
					</div>
					<div class="col-md-3" align = "center">
						 
					</div>
					<div class="col-md-2" align = "center">
							
					</div>
					<div class="col-md-2" align = "center">
						
					</div>
					<div class="col-md-2" align="center">
						
					</div>
				</div>	
				<div class="row">
					<div class="col-md-1">
						
					</div>
					<div class="col-md-3 alert" align = "center">
						
					</div>
					<div class="col-md-2 alert" align = "center">
							
					</div>
					<div class="col-md-2 alert" align = "center">
							
					</div>
					<div class="col-md-2" align="center">
						<b style="color: #ccbeff;">TOTAL DE BASE</b><div class="pull-right bcolor"></div>
						<b style="color: #727276;"><font size="5" class="total2"></font></b><br>
						
					</div>
				</div>	
				<div class="row">
					<div class="col-md-1">
						
					</div>
					<div class="col-md-3" align = "center">
												
					</div>
					<div class="col-md-2" align = "center">
						
					</div>
					<div class="col-md-2" align = "center">
						
					</div>
					<div class="col-md-2" align="center">
						
					</div>
				</div>
				<div class="row">
					<div class="col-md-1">
						
					</div>
					<div class="col-md-3" align = "center">
						 
					</div>
					<div class="col-md-2" align = "center">
							
					</div>
					<div class="col-md-2" align = "center">
						
					</div>
					<div class="col-md-2" align= "center">
						
					</div>
				</div>	
				<div class="row">
					<div class="col-md-1">
						
					</div>
					<div class="col-md-3" align = "center">
						
					</div>
					<div class="col-md-2" align = "center">
							
					</div>
					<div class="col-md-2" align = "center">
						
					</div>
					<div class="col-md-2" align="center">
						<b style="color: #ccbeff;">TOTAL GENERAL</b> <br>
						<b style="color: #727276;"><font size="6" class="totalg"></font></b><br>
						<b style="color: #727276;"><font size="4" class="porcentaje2"></font></b><br><br>
					</div>
				</div>
				<div class="row">
					<div class="col-md-1">
						
					</div>
					<div class="col-md-3" align = "center">
						
					</div>
					<div class="col-md-2" align = "center">
							
					</div>
					<div class="col-md-2" align = "center">
						<font color="white"><button class="btn btn-xs btn-inverse" style="float:right;"><apan class= "glyphicon glyphicon-save">&nbsp;</apan>DESCARGAR DETALLE</button></font>
					</div>
					<div class="col-md-2" align="center">
						
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"	type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/functionaCentralvsEntradaSa.js" type="text/javascript"></script>

</body>
</html>