

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
			url : 'exportDetalleSalidasAlmacenCvsEntradasSubalmacTabla',
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
														
					$('.tituloTabla').text("Detalle BRM No Interfactura ");
					//console.log("Detalle BRM No Interfactura");
					
					
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    columns: [{
					        field: 'pedido',
					        title: 'Pedido'
					    }, {
					        field: 'plaza',
					        title: 'Plaza'
					    }, {
					        field: 'fecha_pedido',
					        title: 'Fecha de Pedido'
					    }, {
					        field: 'nombre',
					        title: 'Nombre'
					    }, {
					        field: 'descripcion',
					        title: 'Descripción'
					    }, {
					        field: 'cantidad',
					        title: 'Cantidad'
					    }, {
					        field: 'semaforo',
					        title: 'Semáforo'
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
			url : 'getSalidasAlmacenCvsEntradasSubalmac',
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
			+ '<th><small># Pedido</small></th>'
			+ '<th><small>Plaza</small></th>'
			+ '<th><small>Fecha Pedido</small></th>'
			+ '<th><small>Fecha Inserci&oacute;n</small></th>'
			+ '<th><small>Nombre</small></th>'
			+ '<th><small>Descripci&oacute;n</small></th>' 
			+ '<th><small>Cantidad</small></th>'
			+ '<th><small><img src="/CifrasControl/img/dashboard-icon-copy-2.png"></small></th>'
			+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	$
			.each(
					jsonResponse.result,
					function(index, arrayValores) {
						html = '<tr><td>';
						html = html + arrayValores.pedido;
						html = html + '</td>';
						html = html + '<td>';
						html = html + arrayValores.plaza;
						html = html + '</td>';
						html = html + '<td>';
						html = html + arrayValores.fecha_pedido;
						html = html + '</td>';
						html = html + '<td>';
						html = html + arrayValores.fecha_insercion;
						html = html + '</td>';
						html = html + '<td>';
						html = html + arrayValores.nombre;
						html = html + '</td>';
						html = html + '<td>';
						html = html + arrayValores.descripcion;
						html = html + '</td>';
						html = html + '<td>';
						html = html + arrayValores.cantidad;
						html = html + '</td>';
						html = html + '<td align="center">';
						var details = "";
						if(arrayValores.semaforo == "verde"){
							details = '<img src="/CifrasControl/img/green.png" class="semaforo_green">';
						}else if(arrayValores.semaforo == "amarillo"){
							details = '<img src="/CifrasControl/img/yellow.png" class="semaforo_yellow">';
						}else{
							details = '<img src="/CifrasControl/img/red.png" class="semaforo_red">';
						}
						
						
						html = html + details;
						html = html + '</td>';
						
						
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

//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
function getValor() {
//	console.log("Salidas Almac&eacute;n Central <br/> vs <br/> Entradas Sub almacenes");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}
