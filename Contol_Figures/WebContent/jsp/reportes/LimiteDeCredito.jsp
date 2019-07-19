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
<link rel="stylesheet" 	href="${pageContext.request.contextPath}/dataTable/css/jquery.dataTables.css" />
<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/generic/desplegable.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/estilosDIVS.css" /> 

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.min.css" />

<title>Limite De Credito</title>
</head>
<body onload="getValor()">
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
					<button type="button" class="btn btn-primary" onclick="cargaDatos()">Consultar</button>
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
<input type="hidden" id="desable_cifra" value="29"> <!-- marca de agua en el menu -->
		<jsp:include page="/jsp/generic/loadModal.jsp" />	
			<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="${pageContext.request.contextPath}/img/controldeinventarios-icon2.png">
    							&emsp;L&iacute;mite De Cr&eacute;dito</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
	</div>		
	<div class="col-md-5"></div>
						<div class="col-md-1"><!-- en espera --></div>
</div>	

<!--  mensaje -->
<div class="col-md-12" ><br><br><br><br></div>
<div class="col_md_12 text-center contentMessage">
          <h3 class="colorTitleInit">Consulta L&iacute;mite De Cr&eacute;dito</h3>
</div>

<!--     ------------- espacio  --------- -->
<br>
<br>
<br>
<br>
<!-- ********************  modulo reporte   **********************   -->		
<div class="col-md-12">
	<div class="col-md-1"><!-- en espera --></div>
	<div class="col-md-10">
		<div class="row-fluid">
					<br/>
					<div id="divReport"></div>
				</div>
	</div>
	<div class="col-md-1"></div>
</div>


<div class="col-md-12">
	<div class="col-md-1"><!-- en espera --></div>
	<div class="col-md-10">
		<div class="row-fluid">
					<br/>
					<div id="tableModal"></div>
				</div>
	</div>
	<div class="col-md-1"></div>
</div>
<!-- fin -->
<div class="col-md-12" ><br><br><br><br></div>

	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/dataTable/js/jquery.dataTables.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/LimiteCredito.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/generics.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.min.js" type="text/javascript"></script>
	
	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-table-es-SP.js" type="text/javascript"></script>
	<!--  
	<script src="${pageContext.request.contextPath}/js/grafica/raphael-2.1.4.min.js" ></script>	
	<script src="${pageContext.request.contextPath}/js/grafica/justgage.js" ></script> -->	
	<script >
		$('#cb1 span').addClass('desabilitado');
	</script>

</body>
</html>