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
<title>Grafica Lineal</title>
</head>
<body onload="fechaActual();">
<jsp:include page="/jsp/generic/errorModal.jsp"/>
 <!-- inicio contenedor head principal -->
    <div class="row container-fluid fondo">      
      <jsp:include page="/jsp/header/etiqueta.jsp"/>
        <div class="col-md-7 etiquetaDivGeneral" >
		<div class="col-md-12" style=" background-color: "> 
		

		<div  class="col-md-3" align="center">
			<p class=" text-center elemento ">
				<div class="dropdown " >			
				    <button onclick="hideGraf();" class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Opción busqueda
				    <span class="caret"></span></button>
				    <ul class="dropdown-menu">
				      <li><a onclick="changeSemana();" href="#"><b>Semana</b></a></li>
				      <li><a onclick="changeMes();" href="#"><b>Mes</b></a></li>		      
				    </ul>
				
				</div>
			</p>
		</div>
		<div class="col-md-3 " align="center"> 
				<p class=" text-center elemento" style="display: none" id="menu_mes">
					<span>Mes:</span><br>
					<select class="selectpicker"   data-width="100px" data-live-search="true" onchange="setEvalMes();" id="selectMes" >
					<option value="1" ></option>
					</select>
				</p>
				<p class=" text-center elemento " style="display: none" id="menu_semana">
					<span>No.&nbsp;de&nbsp;Semana:</span><br>
					<select class="selectpicker"   data-width="60px" data-live-search="true" onchange="setEvalSema();" id="selectsem">
					</select>
				</p>
		</div>
		<div class="col-md-2" align="center"> 
				<p class="text-center elemento ">
							<span>Año:</span><br>
							<select class="selectpicker"  data-width="80px" data-live-search="true" onchange="" id="selectanio"  >
							</select></p>
		</div> 
         
          <div class="col-md-3" align="center">
            </div>
<!-- contenedor 4 --> 
        <div class="col-md-1"><!--  **************div vacio *************  --> </div>
        </div>
    </div>  
</div>  <!-- div principal -->
<div class="row container"><br><br></div>
<div class="row container">
	<div class="col-md-12 container center-block">	
		<div class="col-md-2"><br><br></div>	
		<div class="col-md-8" id="miGrafica"  style=" width: 1024px; height: 640px; display: none;" align="center">
   			<canvas id="graficaG"><br><br></canvas>
		</div>
		<div class="col-md-2"></div>		
	</div>
	<br>
	<br>
	<!--  
	<div class="col-md-12">		
		<div  style="width: 1000px; height: 500px; display: none;">
   			<canvas id="graficaMes" id="canvas"></canvas>
		</div>		
	</div>
	-->
	<br>
	<br>
</div>

<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"  type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/generic/accounting.js" type="text/javascript"></script>
  <!--  <script src="${pageContext.request.contextPath}/js/reportes/ctasActBRMvsU2000.js" type="text/javascript"></script> -->
  <script src="${pageContext.request.contextPath}/js/reportes/grafica.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/dataTable/js/jquery.dataTables.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/grafica/raphael-2.1.4.min.js" ></script>					
  <script src="${pageContext.request.contextPath}/js/grafica/justgage.js" ></script>
  	
  <script src="${pageContext.request.contextPath }/js/grafica/Chart.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/grafica/utils.js"></script>
  <script src="${pageContext.request.contextPath }/js/grafica/Chart.bundle.js"></script>
  
</body>
</html>