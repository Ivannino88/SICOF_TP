<div id="" >

	<!--  <img src="${pageContext.request.contextPath}/img/back.png"> -->  
	 
</div>

<div class="row" id="relleno" style="height:34px; background:#f4f6f8;">
		<div class="col-sm-7" >
		</div>
		<div class="col-sm-2" style="text-align:center; font-size:12px; margin-top: 12px;" >
		<b>Selecciona una Fecha</b>
		</div>
	
</div>

<div class="row" id="cajaControl">
	   	
		<div class="col-sm-1" id="separacion">			
			<a href="menuprincipal"><img src="${pageContext.request.contextPath}/img/shape.png"></a>					
		</div>
		
		<div class="col-sm-3" >			
			<div id="tituloControl">
				Control de inventarios			
			</div>		
		</div>
		
		<div class="col-sm-3" >
		</div>
		
		<div class="col-sm-2" style="text-align:center; font-size:12px;" >
			
			<div class='input-group date' id='datetimepicker1' style="border-radius:4px;">
				 
				<span class="input-group-addon"> 
					<span class="glyphicon glyphicon-calendar"></span>
				</span>
				<input readonly onchange="cargaReporte();" type="text" id="fecha" class="datepicker  form-control">
			</div>
		</div>
		
	
</div>

<div class="row" id="relleno" style="height:14px; background:#f4f6f8;">

</div>


	





