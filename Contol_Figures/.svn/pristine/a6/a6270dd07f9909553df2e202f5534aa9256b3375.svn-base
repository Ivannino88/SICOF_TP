
$('#myform').on('submit', function(ev) {
	
	var fech = $('#fechaReporteTabla').val();	
	//console.log("fechaReporte: " + fech);
	
	$('#radioButtonContainerId input:radio').click(function() {
		
		$('.table-result').show();
	    if ($(this).val() === '1') {
	    	$('#tableModal').bootstrapTable('destroy');
	    	$("#op2").prop("checked", false);
	    	$('#NoData').text('');
	    	pintaReporte1(fech);
	    	
	    } else if ($(this).val() === '2') {
	    	$('#tableModal').bootstrapTable('destroy');
	    	$("#op1").prop("checked", false);
	    	$('#NoData').text('');
	    	pintaReporte2(fech);
	    } 
	});
	
    $('#myModal').modal('show');
    ev.preventDefault();
});


function pintaReporte1(fech){
	
	if(fech != ""){	
		
		$.ajax({
			url : 'getDetalleSalidasSubalmacenvsEntradasCuadrillasTabla',
			type : "POST",
			async : false,
			data : {'fechatabla' :fech},
			dataType : "json",
			 beforeSend: function( xhr ) {
				 //$('#loadModal').modal();
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#loadModal').modal('hide');
				if(jsonResponse.success){
																			
					$('.tituloTabla').text("Detalle SAP Regional Cuadrillas ");
					//console.log("Detalle SAP Regional Cuadrillas");
					
										
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    columns: [{
					        field: 'centro',
					        title: 'Plaza'
					    }, {
					        field: 'cuadrilla',
					        title: 'Cuadrilla'
					    }, {
					        field: 'fecha_consulta',
					        title: 'Fecha de Consulta'
					    }, {
					        field: 'verde',
					        title: 'Verde'
					    }, {
					        field: 'amarillo',
					        title: 'Amarillo'
					    }, {
					        field: 'rojo',
					        title: 'Rojo'
					    }, ]
					});
												
					
				}else{
					$('.tituloTabla').text('');
					$('#NoData').text("No se encontraron datos");
					//console.log("Error en la tabla");
										
				}
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
			}
		});
	}
}

function consultaReporte(){
	$('#fechaH').val($('#fecha').val());
	$('#almacenH').val($('#selectAlmacen').val());
	if($('#fecha').val() != "" ){
		$.ajax({
			url : 'getSalidasSubalmacenvsEntradasCuadrillas',
			type : "POST",
			data : {
				'fecha'		:	$('#fecha').val(),
//				'almacen'	:	 $('#selectAlmacen').val().toString()
				},
			dataType : "json",
			beforeSend: function( xhr ) {
				 $('#loadModal').modal();
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#loadModal').modal('hide');
				if(jsonResponse.success){
					//console.log(jsonResponse);
					
					$('#fechaReporteTabla').val($('#fecha').val());
					
					$("#op1").prop("checked", false);
					$("#op2").prop("checked", false);
			    	$('#tableModal').bootstrapTable('destroy');
			    	$('.tituloTabla').text('');
			    	$('#NoData').text('');
					
					
					contruyeReporte(jsonResponse);
					if(jsonResponse.result.length > 0){
						$('.contentMessage').hide('fade');
						$('.contentReporte').show('fade');
						$( "#btn-Reporte" ).prop( "disabled", false );
					}else{
						$('.dateFail').text($('#fecha').val());
						$('#errorModal').modal();
						$('.contentMessage').show('fade');
						$('.contentReporte').hide('fade');
						$( "#btn-Reporte" ).prop( "disabled", true );
					}
				}else{					
					$('.dateFail').text($('#fecha').val());
					$('#errorModal').modal();
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
	$('.fechaEt').text($('#fecha').val());
	$('#divReport').text('');
	var html, table, body = '';
	var header = '<table id="almacenTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer table-striped">' + '<THEAD>'
			+ '<tr>' 
			+ '<th><small>Plaza</small></th>'
			+ '<th><small>Cuadrilla</small></th>'
			+ '<th><small>Fecha Consulta</small></th>'
			+ '<th class="text-center"><small><img src="/CifrasControl/img/dashboard-icon-copy-2.png"></small></th>'
			+ '<th class="text-center"><small><img src="/CifrasControl/img/dashboard-icon-copy-2.png"></small></th>'
			+ '<th class="text-center"><small><img src="/CifrasControl/img/dashboard-icon-copy-2.png"></small></th>'
			+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	$
			.each(
					jsonResponse.result,
					function(index, arrayValores) {
						html = '<tr><td>';
						html = html + arrayValores.centro;
						html = html + '</td>';
						html = html + '<td>';
						html = html + arrayValores.cuadrilla;
						html = html + '</td>';
						html = html + '<td>';
						html = html + arrayValores.fecha_consulta;
						html = html + '</td>';
//inicio de cambio						
						html = html + '<td align="left"><small>';
							var semaforo1 = '<span class="semaforotext">'+arrayValores.verde+'</span>'+
							'<span class="semaforoicon"><img src="/CifrasControl/img/green.png" class="semaforo_green"></span>';
						html = html + semaforo1;
						html = html + '</small></td>';
//fin modulo nuevo
						html = html + '<td align="left"><small>';
							var semaforo2 = '<span class="semaforotext">'+arrayValores.amarillo+'</span>'+
							'<span class="semaforoicon"><img src="/CifrasControl/img/yellow.png" class="semaforo_yellow"></span>';
						html = html + semaforo2;
						html = html + '</small></td>';
						
						html = html + '<td align="left"><small>';
							var semaforo3 = '<span class="semaforotext">'+arrayValores.rojo+'</span>'+
							'<span class="semaforoicon"><img src="/CifrasControl/img/red.png" class="semaforo_red"></span>';
						html = html + semaforo3;
						html = html + '</small></td>';						
						
						html = html + '</tr>';
						body = body + html;
					});

	table = header + body + footer;
	$(table).appendTo('#divReport');
	$('#almacenTable').dataTable({
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

//같같같같같같같같같같같같같같같같같같같같같같같같같같같�
function getValor() {
//	console.log("Salidas Sub almacenes  <br/> vs <br/> Entradas Cuadrillas");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}