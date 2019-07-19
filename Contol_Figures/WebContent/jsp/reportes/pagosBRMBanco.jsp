<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head jqueryui="true"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" 	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet"	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-select.min.css" />
<link rel="stylesheet"	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/generic/generic.css" />
<link rel="stylesheet"	href="${pageContext.request.contextPath}/dataTable/css/jquery.dataTables.css" />
<link rel="icon" 	    href="${pageContext.request.contextPath}/img/favicon.png">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/generic/desplegable.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/estilosDIVS.css" />

<title>Pagos-BRM vs Bancos</title>
</head>
<body onload="loadEmpresasAjax(); loadCanalesAjax(); getValor()">


	<jsp:include page="/jsp/generic/errorModal.jsp" />
   
  <div class="row container-fluid fondo">       <!-- inicio contenedor head -->
      <jsp:include page="/jsp/header/etiqueta.jsp"/>
   			<div class="col-md-7 etiquetaDivGeneral" >  
			<div class="col-md-12" style=" background-color: ">
					<div  class="col-md-2"><!-- espacio bacio --></div>
					<div class=" col-md-3 " align="center">
							<p class="text-center elemento"><span>Selecciona&nbsp;una&nbsp;fecha:</span></p>
							<div class="form-group">
								<div class='input-group date' id='datetimepicker1'>
								<span class="input-group-addon"> 
										<span class="glyphicon glyphicon-calendar"></span>
									</span>
									<input readonly onchange="consultaReporte();" type="text" id="fecha" class="datepicker  form-control"> 
								</div>
							</div>
					</div> 
<!-- contenedor empresa -->					
					<div class="col-md-3 col-xs-6" style="left:15px;" align="center">
				        <p class="text-center elemento" >
							<span class="">&nbsp;</span><span>Empresa:</span>
						</p>
						<div class="form-group">
							<select class="form-control" id="selectEmpresa" onchange="consultaReporte();" title="Empresa">
								<option value="0">--</option>
							</select>
						</div>
				    </div>
<!-- contenedor canal -->	
				<div class="col-md-3 col-xs-6" style="margin-left: 0px;" align="center">
						<p class="text-center elemento" >
							<span>&nbsp;</span><span>Canal: </span>
						</p>
						<div class="form-group">
							<select id="selectCanal" class="form-control" onchange="consultaReporte();" title="Canal">
								<option value="0">--</option>
							</select>
						</div>
				</div>
				<div  class="col-md-1"><!-- espacio bacio --></div>
				</div>
    </div>  <!-- fin div  contenedor elementos head  -->
</div>  <!-- div principal -->
 
<br>
<br>	
	<!-- menu desplegable --> 
<div class="col-md-12">
	<div class="col-md-1"></div>
<div class="col-md-5" id="desplegable"> 
<input type="hidden" id="desable_cifra" value="16">
		<jsp:include page="/jsp/generic/loadModal.jsp" />
	<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="/CifrasControl/img/aseguramientodeingreso-icon2.png">
    							&emsp;Pagos-BRM vs Bancos</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
  								
	
	
	</div>
	<div class="col-md-5 text-right contentReporte">
			<div id="descargaArchivo elemento">
				<form action="exportDetallePagosBRMBanco" method="get" onsubmit="return false;">
					<input type="hidden" id="fechaH" name="fecha"> 
					  <input type="hidden" id="empresaH" name="empresa"> 
					  <input type="hidden" id="canalH" name="canal"> 
					  <input type="hidden" id="id_conciliacion" name="id_conciliacion">
					  <font color="white">
						<button id="btn-Reporte" type="submit" onclick="callReport()" class="btn btn-xs btn-inverse2" ">
							&emsp;&emsp;Descargar detalle
						</button>
						
					</font>
				</form>
				<button class="exportToExcel" onclick="exportExcel()" id="exportToExcel">Export to XLS</button>
			</div>
			
			
			<div id="testReport"></div>
		</div>
	<div class="col-md-1"><!-- en espera --></div>				
</div>		
<!--     ------------- espacio  --------- -->
<br>
<br>
<br>
<br>
<!--     ------------- mensaje  --------- -->	
	<div class="col_md_12 text-center contentMessage">
					<h3 class="colorTitleInit">Seleccione el d&iacute;a, la empresa y el canal para el reporte que desea consultar</h3>
	</div>
	<div class="col_md_12 text-center contentMessage" id="divReportMessage" style="display:none;">
					<h3 class="colorTitleInit"><span id="reportMessage"></span></h3>
	</div>
<!-- espacio --> 
<br><br>
<!-- ********************  modulo reporte   **********************   -->		
<div class="col-md-12 contentReporte">
	<div class="col-md-1"><!-- en espera --></div>
	<div class="col-md-10">
		<div class="row-fluid">
					<br/>
					<div id="divReport">
						<table id="pagosTable"  data-tableName="table2excel" class="table2excel table table-condensed table-hover table-responsive datatable dataTable no-footer table-striped">
							<thead>
							<tr>
							<th>Fecha</th>
							<th>No. Pagos BRM</th>
							<th>Importe BRM</th>
							<th>No. Pagos Banco</th>
							<th>Importe Bancos</th>
							<th>Canal</th>
							<th>Empresa</th>
							<th class="text-center"><small><img src="/CifrasControl/img/dashboard-icon-copy-2.png"></small></th>
							</tr>
							</thead>
							<tbody id="bPagosTable">
							</tbody>
						</table>
					</div>
				</div>
	</div>
	<div class="col-md-1"></div>
</div>
<br>
	<script	src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/dataTable/js/jquery.dataTables.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/pagosBRMBanco.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/jquery.table2excel.min.js" type="text/javascript"></script>
	<script> $('#aseg10 span').addClass('desabilitado');</script>		
</body>
</html>