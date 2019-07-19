<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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


<title>BRM-SN vs U2000-ONT</title>
</head>
<body onload="getValor(); fechaActual();" style="width: 1072">


<jsp:include page="/jsp/generic/errorModal.jsp"/>
 <!-- inicio contenedor head principal -->
    <div class="row container-fluid fondo">      
      <jsp:include page="/jsp/header/etiqueta.jsp"/>
        <div class="col-md-7 etiquetaDivGeneral" >
		<div class="col-md-12" style=" background-color: "> 
		<div  class="col-md-4"><!--  **************div vacio *************  --></div>
			<div class="col-md-2 contentReporte" align="center" style="margin-top: 32px;">
          		<!--  		<button type="button" class="btn btn-info" data-toggle="modal"  data-target=".ModakGrafica">
                  			Gr&aacute;fica&emsp;<span class="glyphicon glyphicon-stats"></span></button>  -->
          	</div>  
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
                  <input readonly onchange="seleccion()" type="text" id="fecha" class="datepicker  form-control">
                </div>
              </div>
            </div>
<!-- contenedor 4 --> 
        <div class="col-md-1"><!--  **************div vacio *************  --> </div>
        </div>
    </div>  
</div>  <!-- div principal -->


<!-- ********* menu desplegable*********** --> 
<div class="col-md-12"><br><br></div>
<div class="col-md-12">
 <!-- <div class="col-md-1 "></div> -->
  <div class="col-md-4" id="desplegable"> 
  <input type="hidden" id="desable_cifra" value="7">
		<jsp:include page="/jsp/generic/loadModal.jsp" />
  <button type="button" class="btn btn-default dropdown-toggle menuLocal" data-toggle="dropdown" aria-expanded="false">
                   <span class="centrado"><img src="/CifrasControl/img/aseguramientodeingreso-icon2.png">
                   &emsp;BRM-SN vs U2000-ONT</span> <span class="glyphicon glyphicon-menu-down" id="menuDown"></span> 
                  </button>
                  
  </div> 
  	<div class="col-md-2 "></div>
    <div class="col-md-2" id="cifra31" style="display:none;" > 
  	<button  id="implementacionTfe_boton" type="button" class="btn btn-warning implementacionTfe_boton" type="submit" onclick="ImplementacionTfe();" >
		Implementaci&oacuten TFE
	</button>
  </div> 
  
  <div class="col-md-2" id="cifra26" style="display:none;">
  	<button id="internas_boton" type="button" class=" btn btn-primary internas_boton" type="submit" onclick="lineas_internas();">
		Lineas Internas
	</button>
	
  </div>  
  <div class="col-md-2">
  <button id="reporte_boton" type="button" class=" btn btn-primary reporte_boton lineas_internas" type="submit" onclick="reporte_botonf();">
		Regresar al reporte
	</button>
  </div>
  
</div>

<!--  mensaje temporal -->
<div class="col-md-12 contentMessage" ><br><br><br><br></div>
<div class="col_md_12 text-center contentMessage">
          <h3 class="colorTitleInit">Seleccione el d&iacute;a del reporte que desea consultar</h3>
          
</div>

<!--  modal vista detalles -->	
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" onselectstart="return false;">
				   <div class="modal-dialog modal-lg" role="document" style="width:95%;">			
				      <div class="modal-content">
				        	<div class="modal-header" >	        					
	        					<div class="col-md-12"><h2 class="modal-title text-center" style="color: #0000CD;">Elige consulta</h2></div>
	        					
    				</div>
  					<div class="col-md-12">
  					<div class="col-md-6 text-rigth" style="color: #5BC687;"><h3><span class="consultaX"></span></h3></div>
					<div class="col-md-6 pull-right"><button type="button" id="back" class="btn btn-danger pull-right" style="display: none;" >
					<span class="glyphicon glyphicon-menu-left" aria-hidden="true">&emsp;</span>REGRESAR</button></div>
  					</div>
        <div class="modal-body">
        	<div class="col-md-12">
        		<div class="col-md-12">
  					<div class="col-md-6"><button class="btn btn-info"    id="opc1">Detalle de dispositivos que se encuentran en BRM y no en U2000 </button></div>
  					<div class="col-md-6"><button class="btn btn-success" id="opc2">Detalle de dispositivos que se encuentran en U2000 y no en BRM</button></div>
  				</div>
  				<div class="col-md-12">
  					<div class="col-md-12"><br></div>
  					<div class="col-md-8"><button class="btn btn-warning" id="opc3">Detalle de dispositivos que se encuentran en los 2 sistemas pero no coincide su cuenta </button></div>
  					<div class="col-md-4 pull-right"><button class="btn btn-primary" id="opc4">Detalle que no se considera para esta cifra </button></div>
  				</div>
  			</div>
        	
	<div class="col-md-12">
		
		<!-- #1 -->
    		<div id="empresas1" style="display: none;">
      		<br>
			<button type="button" value="TOTALPLAY"  class="btn btn-info btn1" onclick="consultaTp1()">TOTALPLAY</button>
			<button type="button" value="ENLACE" 	 class="btn btn-info btn2" onclick="consultaEnl1()">ENLACE</button>
			<button type="button" value="TFE" 		 class="btn btn-info btn3" onclick="consultaTfe1()">TFE</button>
			<button type="button" value="total" 	 class="btn btn-info btn4" onclick="consultaTt1()">TOTAL</button>
			</div>
	<!-- #2 -->
		<div id="empresas2" style="display: none;">
      		<br>
			<button type="button" value="TOTALPLAY"  class="btn btn-success btn1" onclick="consultaTp2()">TOTALPLAY</button>
			<button type="button" value="ENLACE" 	 class="btn btn-success btn2" onclick="consultaEnl2()">ENLACE</button>
			<button type="button" value="TFE" 		 class="btn btn-success btn3" onclick="consultaTfe2()">TFE</button>
			<button type="button" value="total" 	 class="btn btn-success btn4" onclick="consultaTt2()">TOTAL</button>
		</div>
		
	<!-- #3 -->
		<div id="empresas3" style="display: none;">
      		<br>
			<button type="button" value="TOTALPLAY"  class="btn btn-warning btn1" onclick="consultaTp3()">TOTALPLAY</button>
			<button type="button" value="ENLACE" 	 class="btn btn-warning btn2" onclick="consultaEnl3()">ENLACE</button>
			<button type="button" value="TFE" 		 class="btn btn-warning btn3" onclick="consultaTfe3()">TFE</button>
			<button type="button" value="total" 	 class="btn btn-warning btn4" onclick="consultaTt3()">TOTAL</button>
		</div>
	<!-- #4 -->
		<div id="empresas4" style="display: none;">
      		<br>
			<button type="button" value="TOTALPLAY"  class="btn btn-primary btn1" onclick="consultaTp4()">TOTALPLAY</button>
			<button type="button" value="ENLACE" 	 class="btn btn-primary btn2" onclick="consultaEnl4()">ENLACE</button>
			<button type="button" value="TFE" 		 class="btn btn-primary btn3" onclick="consultaTfe4()">TFE</button>
			<button type="button" value="total" 	 class="btn btn-primary btn4" onclick="consultaTt4()">TOTAL</button>
		</div>
	</div>
    
	<div class="col-md-12">
		<div class="table-result" style="display:none; text-alig:center">		        
       		<h3 class="tituloTabla text-center" style="color: #7337ff;"></h3>
			<table id="tableModal" data-show-columns="true" data-page-list="[100, 500,1000]" data-page-size="100"  ></table>
			<h2 class="text-center" id="NoData" style="color: #7337ff;"></h2>
		</div>
	</div>
       	
	<div class="col-md-12"><br><br></div>						
</div>	<!-- fin body -->				       
	</div> <!-- fin modal content -->
				   </div><!-- fin modal-dialog -->
		    </div><!-- fin modal principal -->

<!-- mensaje cargando -->				    
				    <div id="wait" class="modal">
					  	<div class="modal-dialog modal-lg" role="document" style="width:10%; top:20%">						  	 						  	 	 
							  <center><img style="width:110px;height:110px" src="${pageContext.request.contextPath}/img/giphy.gif">
							  <h3 style="color: #A2D9CE;">Cargando..</h3></center>																					 			 		
					  	</div>	
		  			</div>		    
		    
			
			

<!-- PRIMER MODULO TOTALPLAY -->
  <div class="container-fluid">
    <div class="col-md-12  contentReporte"><br><br><br><br>
    <div class="col-md-12 contentReporte" ></div>
      <div  class="col-sm-1"></div>
      <div class="col-sm-6 contenedorR">
        <h2 class="tituloPlay">TOTALPLAY</h2>
        <table class="table">
          <thead class="headTable">
            <tr>
              <th>Estatus</th>
              <th>Dispositivos</th>
              <th>Porcentaje</th>
            </tr>
          </thead>
          <tbody class="filasText">
            <tr>
              <td><b>Conciliado</td>
              <td><b class="t_conciliadosTP"></td>
              <td><b class="porcentajeConcTP"></td>
            </tr>
            <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="t_no_conciliadosTP"></td>
              <td><b class="porcentajeNoConcTP"></b></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado BRM</div></td>
              <td class="tdx"><div class="divx1"><span class="error_brmTP"></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorbrmTP"></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado en U2000</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_u2000TP"></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerroru2000TP"></div></td>
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
              <td class="headTable">Total de Base U2000</td>
            </tr>
            <tr>
              <td class="lateralBlue">
              <font class=" totalU2000TP estado"></font>
              <div class="pull-right bcolorU2000TP "></div>
              </td>
            </tr>
            
            <tr>
              <td ><h2 class="espacio"></h2>
              <P class="Total">Total  Totalplay</P>
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
<div class="col-md-12 contentReporte"><br><br></div>

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
              <th>Dispositivos</th>
              <th>Porcentaje</th>
            </tr>
          </thead>
          <tbody class="filasText">
            <tr>
              <td><b>Conciliado</td>
              <td><b class="t_conciliadosENL"></td>
              <td><b class="porcentajeConcENL"></td>
            </tr>
            <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="t_no_conciliadosENL"></td>
              <td><b class="porcentajeNoConcENL"></b></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado BRM</div></td>
              <td class="tdx"><div class="divx1"><span class="error_brmENL"></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorbrmENL"></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado en U2000</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_u2000ENL"></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerroru2000ENL"></div></td>
            </tr>
 			<tr>
 				<td><div class="ttotal"><b class="Totalx">Total</div></td>
 				<td><div class="ttotal"><b class="Totalx totalENL"></div></td>
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
              <font class="totalBRMENL estado"></font>
              <div class="pull-right bcolorBRMENL"></div>
              </td>
            </tr>
            <tr>
              <td><br></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td class="headTable">Total de Base U2000</td>
            </tr>
            <tr>
              <td class="lateralCyan">
              <font class=" totalU2000ENL estado"></font>
              <div class="pull-right bcolorU2000ENL"></div>
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
<div class="col-md-12 contentReporte"><br><br></div>

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
              <th>Dispositivos</th>
              <th>Porcentaje</th>
            </tr>
          </thead>
          <tbody class="filasText">
            <tr>
              <td><b>Conciliado</td>
              <td><b class="t_conciliadosTFE"></td>
              <td><b class="porcentajeConcTFE"></td>
            </tr>
            <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="t_no_conciliadosTFE"></td>
              <td><b class="porcentajeNoConcTFE"></b></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1"></div>&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado BRM</td>
              <td class="tdx"><div class="divx1"><span class="error_brmTFE"></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorbrmTFE"></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado en U2000</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_u2000TFE"></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerroru2000TFE"></div></td>
            </tr>
            <tr>
              <td><div class="ttotal"><b class="Totalx">Total</div></td>
              <td><div class="ttotal"><b class="Totalx totalTFE"></b></div></td>
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
              <td class="headTable">Total de Base U2000</td>
            </tr>
            <tr>
              <td class="lateralTfe">
              <font class=" totalU2000TFE estado"></font>
              <div class="pull-right bcolorU2000TFE"></div>
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
     
    </div>
  
</div>
<div class="col-md-12 contentReporte"><br><br></div> 

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
              <th>Dispositivos</th>
              <th>Porcentaje</th>
            </tr>
          </thead>
          <tbody class="filasText">
            <tr>
              <td><b>Conciliado</td>
              <td><b class="t_conciliadosT"></td>
              <td><b class="porcentajeConcT"></td>
            </tr>
            <tr>
              <td><BR></td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td><b>No conciliado</td>
              <td><b class="t_no_conciliadosT"></td>
              <td><b class="porcentajeNoConcT"></b></td>
            </tr>
            <tr>
              <td class="tdx"><div class="divx1">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado BRM</div></td>
              <td class="tdx"><div class="divx1"><span class="error_brmT"></div></td>
              <td class="tdx"><div class="divx1"><span class="porcentajeerrorbrmT"></div></td>
            </tr>
            <tr>
              <td style="border:0px;"><div class="divx2">&emsp;&emsp;&emsp;&emsp;&emsp;Encontrado en U2000</div></td>
              <td style="border:0px;"><div class="divx2"><span class="error_u2000T"></div></td>
              <td style="border:0px;"><div class="divx2"><span class="porcentajeerroru2000T"></div></td>
            </tr>
            <tr>
              <td><div class="ttotal"><b class="Totalx">Total</b></div></td>
              <td><div class="ttotal"><b class="Totalx totalT"></b></div></td>
              <td></td>
            </tr> 
          </tbody>
        </table>
       
		 <div class="sizegraf center-block" id="graficaALL"></div>
        
      </div>
      <div  class="col-sm-1"></div>
      
      <div class="col-sm-3 contenedorR">
      <div id="descargaArchivo" class="xY"  >
                              <form action="exportCtasActivasBRMvsU2000DetailsTP" >
                              <input type="hidden" id="fechaReporte" name="fechaReporte">
                              <button id="btn-Reporte" type="submit" class="btn btn-primary" style="display: none;">
                              &emsp;Descarga Detalle&emsp;<span class="glyphicon glyphicon-save" aria-hidden="true"></span>&emsp;
                              </button>
                          	</form>
        </div>
        <div id="" class="xY"  >
			<button type="submit" class="detalle" >
	                           &emsp;Ver Detalle&emsp;
	         </button>	
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
              <td class="headTable">Total de Base U2000</td>
            </tr>
            <tr>
              <td class="lateralFin">
              <font class=" totalU2000T estado"></font>
              <div class="pull-right bcolorU2000T"></div>
              </td>
            </tr>
            
            <tr>
              <td ><h2 class="espacio"></h2>
              <P class="Total">Total General</P>
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
<!-- fin inicio -->
<br>
<div class="container-fluid lineas_internas"><br>
	<div class="row text-center"><label style="font-size:18px;">Lineas Internas</label></div>
	
	<div class="row">
  	<div class="col-md-1"></div>
  	<div class="col-md-10">
  		&emsp;<label class="">
   			 <input id="check_todo" class="form-check-input" type="checkbox" onchange="lineas_consulta();"> Mostrar todas las Lineas Internas
 		 </label>
  	</div>
  	<div class="col-md-1"></div>
  </div><br>
	
	
  <div class="row">
  <div class="col-md-1"></div>
  <div class="col-md-4">
  	<form>
  		<div class="col-md-6">
  			<label><input type="radio" id="cuentas" name="radiob" value="cuentas" onclick="lineas_consulta();">&emsp;Cuentas</label>
  		</div>  
  		<div class="col-md-6">
  			<label><input type="radio" id="SN" name="radiob" value="SN" onclick="lineas_consulta();">&emsp;SN</label>
  		</div>
  	</form>	
  	</div>
  <div class="col-md-6 text-right">
  		<button id="insertar_boton" type="button" class="btn btn-info insertar_boton oculto" type="submit" onclick="insertarb();">
			Insertar desde Excel
		</button>
		&nbsp;
		<button id="eliminar_boton" type="button" class="btn btn-warning eliminar_boton oculto" type="submit" onclick="eliminarbf();">
			Eliminar
		</button>
		&nbsp;
		<button id="eliminar_botonTodos" type="button" class="btn btn-danger eliminar_boton oculto" type="submit" onclick="eliminarTodo();">
			Eliminar Todo
		</button>
		
  </div>
  </div>  
  
  <div class="row">
  	<div class="col-md-1"></div>
  	<div class="col-md-10">
  		<br><br><br>
  		<div id="divReport"></div>
  	</div>
  	<div class="col-md-1"></div>
  </div> 
</div>

<!-- implementacion tfe xxx -->


<div class="container-fluid" id="implementacionTfDiv" style="display: none;" ><br>

	<div class="row text-center"><label style="font-size:18px;">Implementacion TFE</label></div>
	<div class="row"><br></div>
  <div class="row">
  <div class="col-md-8 text-left">
  		<button id="" type="button" class="btn btn-success" type="submit" onclick="insertarTfe()">
			Insertar Excel
		</button>
		&nbsp;
		<button  type="button" class="btn btn-warning" type="submit" onclick="eliminarElementos()" data-toggle="modal" >
			Eliminar Selecci&oacuten
		</button>
		&nbsp;
		<!--   <button type="button" class="btn btn-danger" type="submit" data-toggle="modal" data-target="#eliminaTodo" onclick="limpiaCampo()">  -->
			<button type="button" class="btn btn-danger" type="submit" data-toggle="modal" data-target="" onclick="validaExistencia(); limpiaCampo();">
			Eliminar Todo
		</button>
		&nbsp;
		<button type="button" class="btn btn-info" type="submit"   data-toggle="modal" data-target="#myModalInserta" onclick="limpiaCampo()">
			Insertar Elemento
		</button>
		
  </div>
   <div class="col-md-4"></div>
  </div>  
  
  <div class="row">
  
  	<div class="col-md-2"></div>
  	<div class="col-md-8">
  		<br>
  		<div id="tablaTfe"></div>
  		<!--  <table id="vistaPreviaExcel"  data-page-list="[100, 500,1000]" data-page-size="100" >
   		</table>  -->
   		<div  id="sinDato" style="display: none; color: red;" >
  			<center><h3>Sin Datos</h3></center>
  		</div>
  	</div>
  	
  	<div class="col-md-2">	</div>
  	
  </div> 
</div>

<!-- MODAL ELIMINA UN ELEMENTO  -->
<div class="modal fade" id="eliminaUnElemento" tabindex="-1" role="dialog"  data-backdrop="static">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="cargaPrincipal();" ><span aria-hidden="true">&times;</span></button>
      </div>
      <div class="modal-body">
        <h3 class="text-center" id="mensajeInicio">Eliminar Elementos Seleccionados&hellip;</p></h3>
        <div id="borrandoUno" style="display:none;">
  			<center><img src="${pageContext.request.contextPath}/img/giphy.gif" width="70"><br>
  						<h3>Eliminando..</h3></center>
  		</div>
  		
  		<div  id="borradoUno" style="display: none;">
  			<center><h3>Datos Borrados.</h3></center>
  		</div>
      </div>
      <div class="modal-footer">
        <button id="btnCancelar" type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
        <button id="btnElimina" type="submit" class="btn btn-success" onclick="eliminaOk()">Eliminar</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<!-- MODAL INSERTA ELEMENTO  -->
<div class="modal fade" id="myModalInserta" tabindex="-1" role="dialog"  data-backdrop="static">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="cargaPrincipal();"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Insertar Elemento</h4>
      </div>
      <center><h3 id="InExito"></h3></center>
      <div class="modal-body mBody" >
         <div class="form-group" >
    		<label for="">SN</label>&emsp;&emsp;<span id="existente"></span>
    		<input type="text" class="form-control snInsert"  id="snInput"placeholder="Introduce Nuevo Elemento"  maxlength="20" required onclick="demo()">
  		</div>
		 <center><h4 id="datoRequerido"></h4></center>
      </div>
     
      <div class="modal-footer mFooter">
        <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="btnCancelarInser()">Cancelar</button>
        <!--  <button type="submit" class="btn btn-success" onclick="insertaElemento()">Agregar Elemento</button> -->
        <button type="submit" class="btn btn-success" onclick="validaDato()">Agregar Elemento</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- MODAL ELIMINA TODO  -->
<div class="modal fade" id="eliminaTodo" tabindex="-1" role="dialog"  data-backdrop="static">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="cargaPrincipal();"><span aria-hidden="true">&times;</span></button>
      </div>
      <div class="modal-body">
        <h3 class="text-center elimina"><p>¡ Esta Seguro De Eliminar Todo !&hellip;</p></h3>
        
        <div id="eliminando" style="display:none;">
  			<center><img src="${pageContext.request.contextPath}/img/giphy.gif" width="70"><br>
  						<h3>Eliminando..</h3></center>
  		</div>
  		
  		<div  id="borrado" style="display: none;">
  			<center><h3>Datos Borrados.</h3></center>
  		</div>
  		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger  btnElimTD" data-dismiss="modal">Cancelar</button>
        <button type="button" class="btn btn-success btnCancTD" onclick="eliminaTodo()">Eliminar Todo</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- xxxx  -->
<div class="container-fluid " id="" style="display: none;"><br>
	
	<div class="row text-center"><label style="font-size:18px;">Implementacion TFE</label></div>
	<br>
	<div class="row">
	
  		<div class="col-md-6 text-center" >
  		<button id="" type="button" class="btn btn-success" type="submit" onclick="insertarTfe();">
			Insertar Excel
		</button>
	   </div>
  <div class="col-md-6 text-right"></div>
  </div>
</div>  
  
  <div class="row">
  	<div class="col-md-1"></div>
  	<div class="col-md-10">
  		<br><br><br>
  		<div id="divReport"></div>
  	</div>
  	<div class="col-md-1"></div>
  </div> 
  
  
  <div class="modal fade cargaArchivoTfe" id="" data-backdrop="" >
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
    
      <div class="modal-header">
        <h4 class="modal-title">Seleccion Información para validación 
        <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="cargaPrincipal()">
          <span aria-hidden="true">&times;</span>
        </button></h4>
      </div>
      
      <div class="modal-body">
      <div class="col-md-12"  id="nota" style="display:none;">
  			<center><h4 style="color: #BD3619;">¡ solo se guardaran los campos menores a 20 caracteres y que no esten registrados!</h4></center>
  		</div>
        
        <div class="col-md-10 " align="left">
        	<form id="cargarDocumentoTfe" method="post" enctype = "multipart/form-data" name="cargarDocumentoTfe">
        	<input type="hidden" value="${pageContext.request.contextPath}/file/" id="archivo">
   		 	<label for="archivoTfe">Selecione Archivo</label>
   		 	<input type="file" name="myFileTfe" id="archivoTfe" onchange="vistaPrevia()" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
   		 	</form>
   		 </div>
   		 
   		 <div class="col-md-2 " >
   		 <button type="button" class="btn btn-primary inserta" onclick="insertarExcel()" style="display: none;">Agregar</button>
   		 <br><br>
  		 <br>
   		 </div>
   		 
  		<div id="load" style="display:none;">
  			<center><img src="${pageContext.request.contextPath}/img/load5.gif" width="70"><br>
  						<h3>Vista Previa</h3></center>
  		</div>
  		<div id="sending" style="display:none;">
  			<center><img src="${pageContext.request.contextPath}/img/giphy.gif" width="70"><br>
  						<h3>Enviando..</h3></center>
  		</div>
  		<div id="" class="form-group">
  		</div>
  		<div class="form-group vistaPrevia" style="display: none;">
   		 	<table id="Previa" data-page-list="[100, 500,1000]" data-page-size="100" >
   		 	</table>
  		</div>
  		<div  id="exito" style="display: none;">
  			<center><h3>Datos Guardados.</h3></center>
  		</div>
  		
      </div>
  	
    </div>
  </div>
</div>

<!-- xxx  fin -->
<br><br>
   
   
  <div class="modal fade" id="confmodal">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
      <h4 class="modal-title">Eliminar
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button></h4>
      </div>
      <div class="modal-body">
        <p id="msj_eliminar"></p>
      </div>
      <div class="text-right" style="padding-right:25px;">
       
        <button  class="btn btn-primary" id="btnYes" onclick="elimina();">Confirmar</button>
        <button class="btn btn-secondary" id="btnCancelar" data-dismiss="modal">Cancelar</button>
      </div>
      <br>
    </div>
  </div>
</div>

<div class="modal fade" id="confmodal_eliminarTodo">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
      <h4 class="modal-title">Eliminar Todo
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button></h4>
      </div>
      <div class="modal-body">
        <p id="msj_eliminarTodo"></p>
      </div>
      <div class="text-right" style="padding-right:25px;">
       
        <button  class="btn btn-primary" id="btnYesTodo" onclick="eliminaTodo();">Confirmar</button>
        <button class="btn btn-secondary" id="btnCancelarTodo" data-dismiss="modal">Cancelar</button>
      </div>
      <br>
    </div>
  </div>
</div>

<div class="modal fade" id="modal_archivo" data-backdrop="static" >
  <div class="modal-dialog modal-md" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Subir Información
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button></h4>
      </div>
      <div class="modal-body">
        <div class="col-md-10 cargar_documento" align="left">
        	<form id="cargar_documento" method="post" enctype = "multipart/form-data" name="cargar_documento">
        	<input type="hidden" name="ruta" id="ruta" value="${pageContext.request.contextPath}/file/" >
   		 	<label for="sfile">Selecione un Archivo</label>
   		 	<input type="file" name="myFile" id="sfile" onchange="bcargaf();" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
   		 	</form>
   		 </div>
   		 <div class="col-md-2 cargar_documento">
   		 <button type="button" class="btn btn-primary" onclick="inserta_excel();">Subir</button>
   		 <br><br>
  		 <br>
   		 </div>
  		
  		<div id="previo" class="form-group previo cargar_documento">
  		</div>
  		<div class="form-group">
   		 	<p id="respuesta"></p>
  		</div>
      </div>
  	
    </div>
  </div>
</div>

<!-- demo modal graficas  ivans-->
<div class="modal fade ModakGrafica" tabindex="-1" role="dialog" >
  <div class="modal-dialog modal-lg" role="document" style="width:95%;">
    <div class="modal-content" style="background-color: #edf2f5;">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h3 class="modal-title text-center" style="color: #307ac2;">Gr&aacute;fica Detalle</h3>
      </div>
            <div class="col-md-12">
			<div class="col-md-2 text-center elemento">
			<select class="selectpicker" data-width="120px" name="consulta">
          		<option>Opcion</option>
     	 		<option>Semana</option>
      			<option>Mes</option>
    		</select></div>	
			<div class="col-md-2">
				<p class=" text-center elemento " style="display: none" id="menu_semana">
		          <span>No.&nbsp;de&nbsp;Semana:</span>
		          <select class="selectpicker"   data-width="70px" data-live-search="false" onchange="evalSema();" id="selectsem">
		          </select>
		      	</p>
		      	<p class=" text-center elemento" style="display: none" id="menu_mes">
		        	<span>Mes:</span>
		        	<select class="selectpicker"   data-width="120px" data-live-search="false" onchange="evalMes();" id="selectMes" >
		        	</select>
      			</p>
			</div>	
			<div class="col-md-2">
				<p class="text-center elemento" style="display: none" id="menu_anhio">
        			<span>Año:</span>
       				<select class="selectpicker"  data-width="80px" data-live-search="false" onchange="" id="selectanio"  >
        			</select>
      			</p>
			</div>	
			<div class="col-md-6"></div>
		</div>
      <div class="modal-body">
  
  <div id="mensaje" style="display: none;" class="text-center">
      <img alt="" src="${pageContext.request.contextPath}/img/load5.gif" width="90"><br>
      <h3 class="text-center"  style="color: #307ac2;">Cargando...</h3>
      </div>
      <div class="row"><br><br></div>
      <div class=col-md-12>
      	<h2 class="text-center" id="NoDataX" style="color: #9d0406;"></h2>
      	<div id="graficaLx" style="height: 400px background-color: #73706F; display: none;"></div>
      </div>
      <div class="row"><br><br><br></div> 
      </div>
    </div><!-- fin modal-content -->
  </div><!-- fin modal-dialog -->
</div><!-- fin modal -->
<div class="row"><br><br><br></div>
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
  <script src="${pageContext.request.contextPath}/js/reportes/ctasActBRMvsU2000.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/dataTable/js/jquery.dataTables.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/generic/index.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/grafica/raphael-2.1.4.min.js" ></script>					
  <script src="${pageContext.request.contextPath}/js/grafica/justgage.js" ></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap-table.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap-table.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-table-es-SP.js" type="text/javascript"></script>
  
  <script src="${pageContext.request.contextPath}/js/reportes/ctasActBRMvsU2000tfe.js" type="text/javascript"></script>
  	
</body>
</html>