<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" 	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" 	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-select.min.css" />
<link rel="stylesheet" 	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet" 	href="${pageContext.request.contextPath}/css/generic/generic.css" />
<link rel="stylesheet" 	href="${pageContext.request.contextPath}/dataTable/css/jquery.dataTables.css" />
<link rel="icon" 	    href="${pageContext.request.contextPath}/img/favicon.png">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/generic/desplegable.css" />
<link rel="stylesheet"  href="${pageContext.request.contextPath}/css/generic/estilosDIVS.css" />
<title>  Utilidades Demo 01  </title>
</head>
<body >
	
<jsp:include page="/jsp/generic/errorModal.jsp"/>
 <!-- inicio contenedor head principal -->
    <div class="row container-fluid fondo">      
      <jsp:include page="/jsp/header/etiquetaUtilidades.jsp"/>
        <div class="col-md-7 etiquetaDivGeneral" >
		<div class="col-md-12" style=" background-color: "> 
		<div class="col-md-4"><!--  **************div vacio *************  --></div>
		<div class="col-md-4"><!--  **************div vacio *************  --></div>  
        <div class="col-md-4"><!--  **************div vacio *************  --> </div>
        </div>
    </div>  
</div>  <!-- fin head div principal -->



<br>
<br>

<!-- menu desplegable -->
<!--   
<div class="col-md-12">
	<div class="col-md-1"></div>
<div class="col-md-5" id="desplegable"> 
<input type="hidden" id="desable_cifra" value="31">
		<jsp:include page="/jsp/generic/loadModal.jsp" />
	<button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
       					 	 <span class="centrado"><img src="/CifrasControl/img/logistica-icon1.png">
    							&emsp;Utilidades Demo</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
  								</button>
	</div>
	<div class="col-md-1"></div>				
</div>	
-->

<!--     ------------- espacio  --------- -->
	<jsp:include page="/jsp/generic/errorModal.jsp" />
	
<div class="col-md-12"><br><br></div>
<div class="col-md-12"><br><br></div>

	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/dataTable/js/jquery.dataTables.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
		
</body>
</html>