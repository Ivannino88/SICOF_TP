
//------------- MODAL PARA BOTON IMPORTAR
function importar(){
	 $('#confmodal').modal('show');
}

function validadorarchivo(){
	if($('#sfile').val()!=null){
	$('#button_import').prop('disabled', false);
	$('#button_limpiar').prop('disabled', false);
	$('#respuesta').text('');
	$('.contentReporte').show('fade');
	}
}
// ************************************ CONSULTA - CARGAR DOCUMENTO DE EXCEL
function cargaprevio(){
//	console.log("cargaprevio()");
	$('#respuesta').text('');
	$('#confmodal').modal('hide');
	var formData = new FormData();
	formData.append('myFile', $('#sfile')[0].files[0]);
	
	$.ajax({
			url : 'getvalidacionSeriesTPprevio',
			type : "POST",
			data : formData,
			dataType : "json",
			processData: false,
			contentType: false,
			beforeSend: function( xhr ) {
			//	$('#confmodal').modal('hide');
				 $('#loadModal').modal();
					 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#loadModal').modal('hide');	
				
				if(jsonResponse.success){
					contruye(jsonResponse);
					$('.contentReporte').show('fade');
				}
				else{
				$('#modal_problema').modal('show');
				$('#respuesta').text(jsonResponse.mensaje);
				}
					},
					error : function(jqXHR, textStatus, errorThrown){
						console.log(textStatus);
						$('#loadModal').modal('hide');
						$('#modal_problema').modal('show');
						$('#respuesta').text(jsonResponse.mensaje);
					}
		 });
}
// ****************************************************CONSTRUCCION DE TABLA - PREVISUALIZACION EXCEL
function contruye(jsonResponse){
//	console.log("contruye(jsonResponse)");
	if(jsonResponse==''){
		$('#sfile').val('');
		$('#button_valid').prop('disabled', true);
		$('#button_limpiar').prop('disabled', true);
	}
	else
		$('#button_valid').prop('disabled', false);
		$('#button_import').prop('disabled', true);

	$('#divReport').text('');
	var html, table, body = '';
	var header = '<table id="listaPrevia" class="table table-condensed table-hover table-responsive datatable dataTable no-footer  table-striped">' + '<THEAD>'
	+ '<tr >' 
	+ '<th><small>Cuenta</small></th>'
	+ '<th><small>Serie</small></th>'
	/*+ '<th><small>Estatus</small></th>'
	+ '<th><small>Ultimo Cambio Estatus</small></th>'
	+ '<th><small>Encontrado BRM</small></th>'*/
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				html = '<tr>';
				html = html + '<td name="ACCOUNT_T_ACCOUNT_NO">';
				if(arrayValores.ACCOUNT_T_ACCOUNT_NO!=null)
					html = html + arrayValores.ACCOUNT_T_ACCOUNT_NO;
				html = html + '</td>';
				html = html + '<td name="SERVICE_T_LOGIN">';
				if(arrayValores.SERVICE_T_LOGIN!=null)
					html = html + arrayValores.SERVICE_T_LOGIN;
				html = html + '</td>';
				/*html = html + '<td name="SERVICE_T_STATUS">';
				if(arrayValores.SERVICE_T_STATUS=="10100")
					html = html + "ACTIVO";
				
				if(arrayValores.SERVICE_T_STATUS=="10102")
					html = html + "INACTIVO";
				
				if(arrayValores.SERVICE_T_STATUS=="10103")
					html = html + "CANCELADO";
				
				html = html + '</td>';
				html = html + '<td name="SERVICE_T_LAST_STATUS_T">';
				if(arrayValores.SERVICE_T_LAST_STATUS_T!=null)
					html = html + arrayValores.SERVICE_T_LAST_STATUS_T;
				html = html + '</td>';
				html = html + '<td name="STATUS_BRM">';
						if(arrayValores.STATUS_BRM=="1")
							html = html + "ENCONTRADO";
						if(arrayValores.STATUS_BRM=="0")
							html = html + '<p style="color:red; margin:0px;"> NO ENCONTRADO </p>';
				html = html + '</td>';*/
				
				html = html + '</tr>';
				body = body + html;
			});
	table = header + body + footer;
	$(table).appendTo('#divReport');
	$('#listaPrevia').dataTable({
		"language" : {
			"sProcessing"	: "Procesando...",
			"sLengthMenu"	: "Mostrar _MENU_ registros",
			"sZeroRecords" 	: "No se encontraron resultados",
			"sEmptyTable" 	: "Ninguna coincidencia",
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

// --------------------------- VALIDACION EN LA BASE DE DATOS
function validar() {
//	console.log("validar()");
	if ($('#sfile').val() != '') {
		var lineas = new Array();

		table = $('#listaPrevia').DataTable();
		table.rows().every(function(rowIdx, tableLoop, rowLoop) {
			var rowNode = this.node();
			json = "";
			$(rowNode).find("td").each(function() {
				$this = $(this);
				json += ',"' + $this.attr("name") + '":"' + $this.html() + '"';
			});
			obj = JSON.parse('{' + json.substr(1) + '}');
			lineas.push(obj);
		});
		// console.log(lineas);
		json_string = JSON.stringify(lineas);
		// console.log(json_string);

		$.ajax({
			url : 'getvalidacionSeriesTP',
			type : "POST",
			traditional : true,
			data : {
				'json_string' : json_string
			},
			dataType : "json",
			beforeSend : function(xhr) {
				$('#loadModal').modal();
			},
			success : function(jsonResponse, textStatus, jqXHR) {
				$('#loadModal').modal('hide');

				if (jsonResponse.success) {
					contruye(jsonResponse);
				} else
					$('#modal_problema').modal('show');
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus);
				$('#loadModal').modal('hide');
				$('#modal_problema').modal('show');
			}
		});
	}
}
// ****************************************************************
// ************************** DESCARGA EXCEL **********************

function metodo_verifica(){	
	var lineas = new Array();
	console.log("se ha ejecutado comando para descargar detalle");
	table = $('#listaPrevia').DataTable();
	table.rows().every(function(rowIdx, tableLoop, rowLoop) {
		var rowNode = this.node();
		json = "";
		$(rowNode).find("td").each(function() {
			$this = $(this);
			json += ',"' + $this.attr("name") + '":"' + $this.html() + '"';
		});
		obj = JSON.parse('{' + json.substr(1) + '}');
		lineas.push(obj);
	});
	json_string = JSON.stringify(lineas);
	$('#cadjson').val(json_string);
	
	$('#descarga_detalle').submit();
	$('#cadjson').val('');
	
}

$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });

//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
function getValor() {
//	console.log("Validación de Series TotalPlay");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}
