<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-select.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/generic.css" />
<link rel="icon" 	   href="${pageContext.request.contextPath}/img/favicon.png"> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/dataTable/css/jquery.dataTables.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/desplegable.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/estilosDIVS.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/generic/bootstrap-table.min.css" />

<title>Insert title here</title>
</head>
<body>

<jsp:include page="/jsp/generic/errorModal.jsp"/>
 <!-- inicio contenedor head principal -->
    <div class="row container-fluid fondo">      
      <jsp:include page="/jsp/header/etiqueta.jsp"/>
        <div class="col-md-7 etiquetaDivGeneral" >
		<div class="col-md-12" style=" background-color: "> 
		<div class="col-md-4"><!--  **************div vacio *************  --></div>
		<div class="col-md-2"><!--  **************div vacio *************  --></div>  
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
                  <input readonly onchange="cargaReporte();" type="text" id="fecha" class="datepicker  form-control">
                </div>
              </div>
            </div>
<!-- contenedor 4 --> 
        <div class="col-md-1"><!--  **************div vacio *************  --> </div>
        </div>
    </div>  
</div>  <!-- fin head div principal -->
<h1><center>cambios de equipo</center></h1>

<a href="#" onclick="cargaReporte()"> DEMO_SICOF</a>



<script src="${pageContext.request.contextPath}/js/graficaLineal/highcharts.js" ></script>          
	<script src="${pageContext.request.contextPath}/js/graficaLineal/exporting.js"></script>
	<script src="${pageContext.request.contextPath}/js/graficaLineal/dark-unica.js"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/actualFecha.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"  type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/js/reportes/CambiosEquipoSap.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/dataTable/js/jquery.dataTables.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/js/grafica/raphael-2.1.4.min.js" ></script>					
  	<script src="${pageContext.request.contextPath}/js/grafica/justgage.js" ></script>
  	<script src="${pageContext.request.contextPath}/js/bootstrap-table.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js" type="text/javascript"></script>
  	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-table-es-SP.js" type="text/javascript"></script>
</body>
</html>