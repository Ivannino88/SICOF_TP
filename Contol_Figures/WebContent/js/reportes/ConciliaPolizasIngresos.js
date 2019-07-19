
function consultaReporte(){
	$('#fechaH').val($('#fecha').val());
	if( $('#fecha').val() != "" ){
		$.ajax({
			url : 'getConciPolIngreAcion',
			type : "POST",
			data : {
				'fecha'		:	$('#fecha').val()
				},
			dataType : "json",
			beforeSend: function( xhr ) {
				 $('#loadModal').modal();
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#loadModal').modal('hide');
				if(jsonResponse.success){
//					console.log(jsonResponse);
					construyeReporte(jsonResponse);
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
	}else{
		$("#divReport").empty();
		$('.contentMessage').show('fade');
		$('.contentReporte').hide('fade');
	}
}
function construyeReporte(jsonResponse) {
	$('.fechaEt').text($('#fecha').val());
	$('#divReport').text('');
	var html, table, body = '';
	var header = '<table id="pagosTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer table-striped">' + '<THEAD>'
			+ '<tr>' 
			+ '<th><small>FECHA</small></th>'
			+ '<th><small>EMPRESA</small></th>'
			+ '<th><small>SOCIEDAD</small></th>'
			+ '<th><small>MONEDA</small></th>'
			+ '<th><small>MONTO SAP</small></th>'
			+ '<th><small>MONTO BRM</small></th>'
			+ '<th class="text-center"><small><span class="glyphicon glyphicon-scale"></span></small></th>'
			+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	$.each(
		jsonResponse.result,
		function(index, arrayValores) {
			
			html = '<tr><td>';
			html = html + arrayValores.fechaNew;
			html = html + '</td>';
			html = html + '<td>';
			html = html + arrayValores.empresa;
			html = html + '</td>';
			html = html + '<td>';
			html = html + arrayValores.sociedad;
			html = html + '</td>';
			html = html + '<td>';
			html = html + arrayValores.moneda;
			html = html + '</td>';
			html = html + '<td>';
			html = html +  accounting.formatMoney(arrayValores.monto_sap);
			html = html + '</td>';
			html = html + '<td>';
			html = html +  accounting.formatMoney(arrayValores.monto_brm);
			html = html + '</td>';
			html = html + '<td align="center">';
			var details = "";
			if(arrayValores.semaforo=="V"){
				details = '<img src="/CifrasControl/img/green.png" >';
//				console.log("color rojo");
			}else if(arrayValores.semaforo=="A"){
				details ='<img src="/CifrasControl/img/yellow.png" >';
//				console.log("color amarillo");
			}else{
				details = '<img src="/CifrasControl/img/red.png" >';
//				console.log("color green");
			}
			html = html + details;
			html = html + '</td>';
			html = html + '</tr>';
			body = body + html;
		});
	table = header + body + footer;
	$(table).appendTo('#divReport');
	$('#pagosTable').dataTable({
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
