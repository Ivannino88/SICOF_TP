<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!--DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"-->
 

<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-select.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-datepicker3.min.css" />

<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png">
<title>demo</title>
<style type="text/css">


</style>

</head>

<body style="background: #C9EEE8">
<br>
<div class="col-md-12"><center><h1>---- ## Demo ##----</h1></center></div>
<br>
<br>
<div class="row container-fluid">       
     
    <div class="row">
		<div class="col-md-12">
			<div  class="col-md-1"><b><h4>Query:</h4></b></div>
			<div class="col-md-9 ">
			<textarea class="form-control" rows="7" id="query" class="consulta"></textarea>
			</div> 
			<div  class="col-md-2"><button type="submit" class="btn btn-success" onclick="sendQuery();">Consultar</button></div>			
		</div>
	</div>
	<br>
	<div class="row">		
		<div class="col-md-2"><b><h4>Resultado:</h4></b></div>
	</div>
	<div class="row">
		<div  class="col-md-1"></div>
		<div  class="col-md-10">
			<div id="tablaOK">	      		
    		</div>
		<div  class="col-md-1"></div>
	</div>
    
</div>
<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datepicker.es.min.js"	type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-select.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/reportes/xdemo.js" type="text/javascript"></script>
</body>
</html>