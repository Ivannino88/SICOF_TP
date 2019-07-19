$(function() {
	
	selectactual();
	
});



//creaccion de la lista de semanas y año---------------
function selectactual() {
	
	$('#rh1 span').addClass('desabilitado');
	
	$.ajax({
		url : 'getFechaActual',
		type : "POST",
		dataType : "json",
		async: false,
		success : function(jsonResponse, textStatus, jqXHR){				
			if(jsonResponse.success){
				$
				.each(jsonResponse.result,function(index, arrayValores) {
				 semanaactual=arrayValores.fecha_semana;	
				 anioactual=arrayValores.fecha_anio;
				});
			}},
		error : function(jqXHR, textStatus, errorThrown){
		}
			});
    for(var i=1;i<53;i++){
    if(i==semanaactual){
    	 $("#selectsem").append('<option value="'+i+'" selected="'+i+'">'+i+'</option>');
    } else{
    	 $("#selectsem").append('<option value="'+i+'">'+i+'</option>');
    	}
    }    
    var arr=["2017","2018"];
	   for(var i=0;i<arr.length;i++){
		   if(arr[i]==anioactual){
			   $("#selectanio").append('<option value="'+arr[i]+'" selected="'+arr[i]+'">'+arr[i]+'</option>');
		    } else{
		    	  $("#selectanio").append('<option value="'+arr[i]+'">'+arr[i]+'</option>');
		    	}
	   }  
	
    consultareporteh();
    
}
function consultareporteh(){	
		console.log("principal");
	$('#semanaH').val($('#selectsem').val());
	$('#anioH').val($('#selectanio').val());
	
		var semana=$('#selectsem').val();
		var anio=$('#selectanio').val();
		
		
		if($('#selectanio').val()!="" && $('#selectsem').val()!=""){
			
			$.ajax({
			url : 'getRhProyectoSinTransacciones',
			type : "POST",
			data : {
				'semana'		:	semana,
				'anio'		:	anio,
				
					},
			dataType : "json",
			beforeSend: function( xhr ) {
				 $('#loadModal').modal();
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#loadModal').modal('hide');
				if(jsonResponse.success){
					
					console.log(jsonResponse);
					contruyeReporte(jsonResponse);
					if(jsonResponse.result.length > 0){
						$('.contentMessage').hide('fade');
						$('.contentReporte').show('fade');
						$( "#btn-Reporte" ).prop( "disabled", false );
						
					}else{
						$('.dateFail').text($('#selectsem').val());
						$('.dateFailanio').text($('#selectanio').val());
						
						$('#errorModalsem').modal();
						$('.contentMessage').show('fade');
						$('.contentReporte').hide('fade');
						$( "#btn-Reporte" ).prop( "disabled", true );
						
					}
				}else{		
					$('.dateFail').text($('#selectsem').val());
					$('.dateFailanio').text($('#selectanio').val());
					$('#errorModalsem').modal();
				}
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
				$('#loadModal').modal('hide');
			}
		});
	}	
}
function contruyeReporte(jsonResponse) {
	
	$('.fechaAnio').text($('#selectanio').val());
	$('.fechaSem').text($('#selectsem').val());
	$('#divReport').text('');
	var html, table, body = '';
	var header = '<table id="listaTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer  table-striped">' + '<THEAD>'
	+ '<tr>' 
	+ '<th><small>Area</small></th>'
	+ '<th><small>Empresa</small></th>'
	+ '<th><small>Semana</small></th>'
	+ '<th><small><img src="/CifrasControl/img/dashboard-icon-copy-2.png">&nbsp;&nbsp;&nbsp;Alta</small></th>'
	+ '<th><small><img src="/CifrasControl/img/dashboard-icon-copy-2.png">&nbsp;&nbsp;&nbsp;Media</small></th>'
	+ '<th><small><img src="/CifrasControl/img/dashboard-icon-copy-2.png">&nbsp;&nbsp;&nbsp;Baja</th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
			
				html = '<tr><td><a onclick="cmodal(this)" data-value="'+arrayValores.id+'" href="#">';
				html = html + arrayValores.nombre;
				html = html + '</a></td>';
				html = html + '<td>';
				html = html + arrayValores.empresa;
				html = html + '</td>';
				html = html + '<td>';
				html = html + arrayValores.semana;
				html = html + '</td>';
				html = html + '<td align="left"><small>';
					
					var semaforo1 = '<span class="semaforotext">'+arrayValores.semaforo_verde+'</span>'+
					'<span class="semaforoicon"><img src="/CifrasControl/img/green.png" class="semaforo_green"></span>';
					var semaforo2 = '<span class="semaforotext">'+arrayValores.semaforo_amarillo+'</span>'+
					'<span class="semaforoicon"><img src="/CifrasControl/img/yellow.png" class="semaforo_yellow"></span>';
					var semaforo3 = '<span class="semaforotext">'+arrayValores.semaforo_rojo+'</span>'+
					'<span class="semaforoicon"><img src="/CifrasControl/img/red.png" class="semaforo_red"></span>';
					
					html = html + semaforo1;
					html = html + '</small></td>';
					html = html + '<td align="left"><small>';
					html = html + semaforo2;
					html = html + '</small></td>';
					html = html + '<td align="left"><small>';
					html = html + semaforo3;
					html = html + '</small></td>';
				
				html = html + '</tr>';
				body = body + html;
			});
	
	table = header + body + footer;
	$(table).appendTo('#divReport');
	$('#listaTable').dataTable({
		"language" : {
			"sProcessing"	: "Procesando...",
			"sLengthMenu"	: "Mostrar _MENU_ registros",
			"sZeroRecords" 	: "No se encontraron resultados",
			"sEmptyTable" 	: "Ning\u00fana OT disponible ",
			"sInfo" 		: "",
			"sInfoEmpty" 	: "",
			"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
			"sInfoPostFix" 	: "",
			"sSearch" 		: "Buscar:",
			"oPaginate" 	: {
					"sFirst" 	: "Primero",
					"sLast"		: "\u00daltimo",
					"sNext"		: ">",
					"sPrevious" : "<"
					}
		}
	});
	 
}
function cmodal(valor){
	console.log("carga modal");
	console.log("valor: " + valor);
	var id=valor.getAttribute("data-value");
	console.log("id: " + id);
	var semana=$('#selectsem').val();
	var anio=$('#selectanio').val();
	
	$('#semanaM').val(semana);
	$('#anioM').val(anio);
	$('#idM').val(id);
	
	$('#idconciliacion1').val(id);
	 
	 $.ajax({
		url : 'getRhProyectoSinTransaccionesModal',
		type : "POST",
		data : {
				'semana'		:	semana,
				'anio'		:	anio,
				'id'		:	id,
				},
		dataType : "json",
		beforeSend: function( xhr ) {
					 $('#loadModal').modal();
				 },
		success : function(jsonResponse, textStatus, jqXHR){
			$('#loadModal').modal('hide');
			console.log("jsonResponse: " + jsonResponse);
			if(jsonResponse.success){
				contruyeReporteModal(jsonResponse);
				if(jsonResponse.result.length > 0){
					 $('#modalhr').modal('show');
					 $( "#btn-ReporteModal" ).prop( "disabled", false );
				}else{
					$('#errorModalsem').modal();
					$( "#btn-ReporteModal" ).prop( "disabled", true );
				}
			}else{
				$('#errorModalsem').modal();
			}
				},
				error : function(jqXHR, textStatus, errorThrown){
					console.log(textStatus);
					$('#loadModal').modal('hide');
				}
	 });	 
	 
}


function contruyeReporteModal(jsonResponse) {
	$('#divReportModal').text('');
	$("#regresar").hide();
	
	$("#descargaArchivoModal2").hide();
	$("#descargaArchivoModal").show();
	var html, table, body = '';
	var header = '<table id="listaTableModal" class="table table-condensed table-hover table-responsive datatable dataTable no-footer table-striped">' + '<THEAD>'
	+ '<tr>' 
	+ '<th><small>No. de Empleado</small></th>'
	+ '<th><small>Situacion</small></th>'
	+ '<th><small>Nombre</small></th>'
	+ '<th><small>Centro de Costos</small></th>'
	+ '<th><small>Puesto</small></th>'
	+ '<th><small>AreaNominaDesc</small></th>'	
	+ '<th><small>Dias de actividad</small></th>'
	+ '<th class="text-left"><small><img src="/CifrasControl/img/dashboard-icon-copy-2.png"></small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	
	
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				html = '<tr><td>';
				html = html + '<a onclick="modalDetail(this)" data-value="'+arrayValores.noempleado+";"+arrayValores.idconciliacion+'" href="#">';
				html = html + arrayValores.noempleado;
				html = html + '</a></td>';
				html = html + '<td>';
				html = html + arrayValores.situacion;
				html = html + '</td>';
				html = html + '<td>';
				html = html + arrayValores.nombre;
				html = html + '</td>';
				html = html + '<td>';
				html = html + arrayValores.centrocostos;
				html = html + '</td>';
				html = html + '<td>';
				html = html + arrayValores.puesto;
				html = html + '</td>';
				html = html + '<td>';
				html = html + arrayValores.areanominadesc;
				html = html + '</td>';
				html = html + '<td>';
				html = html + arrayValores.diasactividad;
				html = html + '</td>';
								
				html = html + '<td align="left"><small>';			
				var semaf="";
				if(arrayValores.semaforo=="V")
				semaf ='<span class="semaforoicon"><img src="/CifrasControl/img/green.png" class="semaforo_green"><p style="display:none;">verde</p></span>';
				
				if(arrayValores.semaforo=="A")
				semaf ='<span class="semaforoicon"><img src="/CifrasControl/img/yellow.png" class="semaforo_yellow"><p style="display:none;">amarillo</p></span>';
				
				if(arrayValores.semaforo=="R")
				semaf ='<span class="semaforoicon"><img src="/CifrasControl/img/red.png" class="semaforo_red"><p style="display:none;">rojo</p></span>';
						
				html = html + semaf;
				html = html + '</small></td>';
				
				
				
				html = html + '</tr>';
				body = body + html;
			});
	
	table = header + body + footer;
	console.log("table: " + table);
	$(table).appendTo('#divReportModal');
	$('#listaTableModal').dataTable({
		"language" : {
			"sProcessing"	: "Procesando...",
			"sLengthMenu"	: "Mostrar _MENU_ registros",
			"sZeroRecords" 	: "No se encontraron resultados",
			"sEmptyTable" 	: "Ning\u00fana OT disponible ",
			"sInfo" 		: "",
			"sInfoEmpty" 	: "",
			"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
			"sInfoPostFix" 	: "",
			"sSearch" 		: "Buscar:",
			"oPaginate" 	: {
					"sFirst" 	: "Primero",
					"sLast"		: "\u00daltimo",
					"sNext"		: ">",
					"sPrevious" : "<"
					}
		}
	});
	 
}

function modalDetail(valor){
	console.log("Detalle Modal");
	datos = [];
	console.log("valor detail: " + valor);
	var id=valor.getAttribute("data-value");
	console.log("id detail: " + id);
	
	datos = id.split(";");
	console.log("datos[0]: " + datos[0]);
	console.log("datos[1]: " + datos[1]);
	
	var semana=$('#selectsem').val();
	var anio=$('#selectanio').val();
	
	$('#semanaM').val(semana);
	$('#anioM').val(anio);
	
	$('#idempleado').val(datos[0]);
	$('#idconciliacion').val(datos[1]);
	
	
	 
	 $.ajax({
		url : 'getRhProyectoSinTransaccionesModalDetail',
		type : "POST",
		data : {
				'id':datos[0],
				'idconciliacion':datos[1],
				},
		dataType : "json",
		beforeSend: function( xhr ) {
					 $('#loadModal').modal();
				 },
		success : function(jsonResponse, textStatus, jqXHR){
			$('#loadModal').modal('hide');
			if(jsonResponse.success){
				contruyeReporteModalDetail(jsonResponse);
				if(jsonResponse.result.length > 0){
					 $('#modalhr').modal('show');
					 $( "#btn-ReporteModal" ).prop( "disabled", false );
				}else{
					$('#errorModalsem').modal();
					$( "#btn-ReporteModal" ).prop( "disabled", true );
				}
			}else{
				$('#errorModalsem').modal();
			}
				},
				error : function(jqXHR, textStatus, errorThrown){
					console.log(textStatus);
					$('#loadModal').modal('hide');
				}
	 });	 
	 
}
function contruyeReporteModalDetail(jsonResponse) {
	$('#divReportModal').text('');
	var boton = '<button type="button" class="btn btn-success">Regresar</button><br>';
	var id3 = $('#idconciliacion1').val();
	console.log("id3 " + id3);
	$("#regresar").show();
	$("#descargaArchivoModal").hide();
	$("#descargaArchivoModal2").show();
	
	$("#regresar").attr("data-value",id3);
	
	var html, table, body = '';
	var header = '<table id="listaTableModal" class="table table-condensed table-hover table-responsive datatable dataTable no-footer table-striped">' + '<THEAD>'
	+ '<tr>' 
	+ '<th><small>Fecha</small></th>'
	+ '<th><small>Semana</small></th>'
	+ '<th><small>No Empleado</small></th>'
	+ '<th><small>Situacion</small></th>'
	+ '<th><small>Nombre</small></th>'
	+ '<th><small>Centro de Costos</small></th>'
	+ '<th><small>Puesto</small></th>'
	+ '<th><small>AreaNominaDesc</small></th>'
	+ '<th><small>Fecha de actividad</small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				html = '<tr><td>';
				html = html + arrayValores.fecha;
				html = html + '</td>';
				html = html + '<td>';
				html = html + arrayValores.semana;
				html = html + '</td>';
				html = html + '<td>';
				html = html + arrayValores.noempleado;
				html = html + '</td>';
				html = html + '<td>';
				html = html + arrayValores.situacion;
				html = html + '</td>';
				html = html + '<td>';
				html = html + arrayValores.nombre;
				html = html + '</td>';
				html = html + '<td>';
				html = html + arrayValores.centrocostos;
				html = html + '</td>';
				html = html + '<td>';
				html = html + arrayValores.puesto;
				html = html + '</td>';
				html = html + '<td>';
				html = html + arrayValores.areanominadesc;
				html = html + '</td>';
				html = html + '<td>';
				html = html + arrayValores.fechaactividad;
				html = html + '</td>';
				
				
				html = html + '</tr>';
				body = body + html;
			});
	
	table = header + body + footer;
	console.log("table detail: " + table);
	$(table).appendTo('#divReportModal');
	$('#listaTableModal').dataTable({
		"language" : {
			"sProcessing"	: "Procesando...",
			"sLengthMenu"	: "Mostrar _MENU_ registros",
			"sZeroRecords" 	: "No se encontraron resultados",
			"sEmptyTable" 	: "Ning\u00fana OT disponible ",
			"sInfo" 		: "",
			"sInfoEmpty" 	: "",
			"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
			"sInfoPostFix" 	: "",
			"sSearch" 		: "Buscar:",
			"oPaginate" 	: {
					"sFirst" 	: "Primero",
					"sLast"		: "\u00daltimo",
					"sNext"		: ">",
					"sPrevious" : "<"
					}
		}
	});
	 
}
$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });

function puestoAll(){
		console.log("puestoAll");
		$.ajax({
			url : 'getPuesto',
			type : 'GET',
			async : false,
			dataType : "json",
			success : function(result){
				 $.each(result, function(i, field){
		            	console.log("puesto"+field.puesto);
//		            	$('#op').field.region_id;
//		            var	menu='<option value="'+field.region_id+'">'+field.region_name+'</option>"';
//		            	$(menu).appendTo('#menux');
				 		});
				 
				 
				 for (x in result){
					 console.log("name puesto: "+result[x].puesto);
					 var menu='<label class="checkbox-inline"><input type="checkbox" value="">'+result[x].puesto+'</label><input type="hidden" id="'+result[x].puesto+'" name="'+result[x].puesto+'">';
					 $(menu).appendTo('#menux');
				 }
				 console.log("termino de consulta ok");		 
		}
		});
}


// °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
function getValor() {
	console.log("Proyectos sin transacciones");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
		$('#btn-dC').show();
		$('#btn-ReporteModal').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}
