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
					console.log(jsonResponse);
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
	var header = '<table id="almacenTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer">' + '<THEAD>'
			+ '<tr class="warning">' 
			+ '<th><small># Pedido</small></th>'
			+ '<th><small>Plaza</small></th>'
			+ '<th><small>Fecha Pedido</small></th>'
			+ '<th><small>Fecha Inserci&oacute;n</small></th>'
			+ '<th><small>Nombre</small></th>'
			+ '<th><small>Descripci&oacute;n</small></th>' 
			+ '<th><small>Cantidad</small></th>'
			+ '<th class="text-center"><small><span class="glyphicon glyphicon-scale"></span></small></th>'
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
							details = '<img src="/CifrasControl/img/green.png" height="20" width="20" class="img-responsive" alt="Responsive image">';
						}else if(arrayValores.semaforo == "amarillo"){
							details = '<img src="/CifrasControl/img/yellow.png" height="20" width="20" class="img-responsive" alt="Responsive image">';
						}else{
							details = '<img src="/CifrasControl/img/red.png" height="20" width="20" class="img-responsive" alt="Responsive image">';
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
					"sNext"		: "Siguiente",
					"sPrevious" : "Anterior"
					}
		}
	});
}
$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });