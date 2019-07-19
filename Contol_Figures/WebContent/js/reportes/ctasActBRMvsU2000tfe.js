$( document ).ready(function() {
		$("#implementacionTfe_boton").hide();
});

function ImplementacionTfe(){
//	console.log("ImplementacionTfe()..");
	$('.contentMessage').hide('fade');
	$('#implementacionTfDiv').show('fade');
	$('.contentReporte').hide('fade');
	$('.lineas_internas').hide('fade');
	$('#reporte_boton').show('fade');
	$('#internas_boton').hide('hide');
	cargaPrincipal();
}

function insertarTfe(){
//	console.log("insertarTfe()");
	$('#nota').hide('fade');
	$('#Previa').bootstrapTable('destroy');
	 $('#vistaPreviaExcel').bootstrapTable('destroy');
	 $('.cargaArchivoTfe').modal('show');
	 $('.vistaPrevia').show('fade');        //------
 	 $("#archivoTfe").val('');
	 $('#cargarDocumentoTfe').show('fade');
	 $('.inserta').hide('fade');
	 $('#exito').hide();
}	

// --- CARGA CONSULTA ---
function cargaPrincipal(){
//	console.log("cargaPrincipal()");
	$('#existente').text('');
	$(".snInsert").val('');
	$('#tablaTfe').text('');
	$('#vistaPreviaExcel').bootstrapTable('destroy');
	$('#sinDato').hide();
	$.ajax({
		url : 'consultaTfe',
		type : 'GET',
		async : false,
		dataType : "json",
		beforeSend: function( xhr ) {
//			 $('#loadModal').modal('show');
			 $('#loadModal').modal({backdrop: 'static', keyboard: false});
		 },
		 success : function(jsonResponse, textStatus, jqXHR){
			 $('#loadModal').modal('hide');
			 if(jsonResponse.success){
					if(jsonResponse.result!=0){
//						console.log("-----previsualizacion : "+jsonResponse);
						TablaTotalTfe(jsonResponse);
						$('.vistaPrevia').show('fade');
//						console.log("si hay datos");
						
						$('#vistaPreviaExcel').bootstrapTable({
						    data : jsonResponse.result,
						    pagination:true,
						    striped: true,
						    search: true,
						    ignoreClickToSelectOn: true,
						    columns: [{
						        field: 'sn',
						        title: 'ONT',
						    }
						    ]
						});
					}
				} // fin if
				else{
//					console.log('sin informacion');
					$('#loadModal').modal('hide');
					$('#sinDato').show('fade');
				} // fin else
					} // fin success
	});
	
}

// VISTA PREVIA DEL EXCEL A CARGAR.
function vistaPrevia(){
//	console.log("vistaPrevia()");
	var arrList = [];
	 var arr = {};   
	$('#Previa').bootstrapTable('destroy');
	$('#exito').hide('fade');
	var formData ='';
	formData = new FormData();
	formData.append('myFile', $('#archivoTfe')[0].files[0]);
//		console.log("---datos  --->> "+formData);
		$.ajax({
				url : 'evaluacionTfe',
				type : "POST",
				data : formData,
				dataType : "json",
				processData: false,
				contentType: false,
				beforeSend: function( xhr ) {
					$('#load').modal({backdrop: 'static', keyboard: false});
						 },
				complete: function () {
								$('#load').modal('hide');
								$('#cargarDocumentoTfe').hide('fade');
				},
				success : function(jsonResponse, textStatus, jqXHR){
					
					if(jsonResponse.success && jsonResponse.result!=0){
						
//						console.log("datos validados:- "+ jsonResponse.result);
						$('#nota').show('fade');
						$('.vistaPrevia').show('fade');
						$('.inserta').show('fade');
							
							$('#Previa').bootstrapTable({
							    data : jsonResponse.result,
							    pagination:true,
							    striped: true,
							    search: true,					    
							    columns: [{
							        field: 'cuenta',
							        title: 'ONT',
							        sortable: true
							    }]
							});
					} // fin if
					else{
						$('#nota').hide('fade');
						$('.vistaPrevia').hide('fade');
						$('.inserta').hide('fade');
						alert("archivo sin informacion seleccione otro archivo");
//						
					} // fin else
						} // fin success
			 });
}

// INSERTAR EL EXCEL EN LA TABLA VALIDANDO DATOS EN EXISTENCIA.
function insertarExcel(){
//	console.log("insertarExcel()");
	$('.vistaPrevia').hide('fade');
	
	var temporal = JSON.stringify($("#Previa").bootstrapTable('getData'));
		$.ajax({
			url : 'evaluacionTfeTabla',
			type : "POST",
			traditional:true,
			data : { 'tablaResultado': temporal }
				,
			dataType : "json",
			beforeSend: function( xhr ) {
				$('#sending').modal({backdrop: 'static', keyboard: false});
				$('.inserta').hide('fade');
				$('#nota').hide('fade');
					 },
			complete: function () {
				$('#sending').modal('hide');
//				console.log("exitoso------- completado");
				$('#Previa').bootstrapTable('destroy');
				$('#exito').show('fade');
				$('.inserta').hide('fade');
				
			},
			success : function(response){
				if (response.success == true) {
					console.log(response.mensaje+"exitoso");
				} 
			}
		});
//		console.log("transaccion correcta");
		 $('#vistaPreviaExcel').text('');
	}


// INSERTAR UN ELEMENTO 
function insertaElemento(entrada){
	if(entrada != ""){
//		console.log("entrando a ajax...");
		$.ajax({
			url : 'insertaElemento',
			type : "POST",
			async : false,
			data : {'snVal' : entrada},
			dataType : "json",
			beforeSend: function( xhr ) {
//				 $('#loadModal').modal({backdrop: 'static', keyboard: false});
//				console.log("enviando....");
			 },
			 complete: function () {
//					console.log("datos guardados con exito");
					$('.mBody').hide('fade');
					$('.mFooter').hide('fade');
					$('#InExito').text("Se Guardo Correctamente").css({"color": "green"});
					$(".snInsert").val('');
				},
				error : function(xhr, ajaxOptions, thrownError) {
//					console.log("!algunos datos ya existen!");
		}
		});
	}else{
//		console.log("sin datos........");
		$('#datoRequerido').text("Inserte Un Dato").css({"color": "red"});
		
	}
}


//valida el dato antes de insertar
function validaDato(){
	$('#existente').text("");
	
	var entrada=$(".snInsert").val();
	
//	if (entrada.indexOf(" ") > -1) {
	if(entrada.trim()==""){
        console.log("Hay espacios.");
        $('#datoRequerido').text("Inserte Un Dato").css({"color": "red"});
    } else {
        console.log("No hay espacios.");
	if(entrada != " "){
		$.ajax({
			url : 'validarDato',
			type : "POST",
			async : false,
			data : {'snVal' : entrada},
			dataType : "json",
			beforeSend: function( xhr ) {
//				console.log("validando....");
			 },
			 success: function (jsonResponse, textStatus, jqXHR) {
				 if (jsonResponse.result>0 && jsonResponse.result!=null && jsonResponse.result==1) {
//					console.log(jsonResponse.result)	;
//					console.log("el dato existe ");
					$('#existente').text("dato existente..intente nuevamente").css({"color": "red"});
				} else {
//					console.log("el dato no existe y preparando para insertar");
					$('#existente').text(' ');
					insertaElemento(entrada);
				}
//					console.log("dato validado correctamente");
					
				},
				error : function(xhr, ajaxOptions, thrownError) {
//					console.log("!algunos datos ya existen!");
		}
		});
	}else{
		console.log("sin datos........");
		$('#datoRequerido').text("Inserte Un Dato").css({"color": "red"});
	}
    } 
}

function demo(){
//	console.log("DEMO() ");
	$('#existente').text('');
	$('#datoRequerido').text('');
}
function btnCancelarInser(){
	$('#existente').text('');
	$(".snInsert").val('');
}



// ELIMINAR TODOS LOS DATOS
function eliminaTodo(){
//	console.log("eliminaTodo()");
	$('.btnElimTD').show();
	$('.btnCancTD').show();
				$.ajax({
					url : 'eliminarTodosElementos',
					type : "POST",
					traditional:true,
					dataType : "json",
					beforeSend: function( xhr ) {
						console.log("eliminando....");
						 $('#eliminando').show({backdrop: 'static', keyboard: false});
//						$('#eliminando').show('fade');
						$('.elimina').hide();
						$('.btnElimTD').hide();
						$('.btnCancTD').hide();
							 },
					success : function(response){
						console.log("borrado exitoso ....");
						$('#eliminando').hide('fade');
						$('#borrado').show('fade');
						$('.btnElimTD').hide();
						$('.btnCancTD').hide();
					},
					error : function(xhr, ajaxOptions, thrownError) {
//						console.log("!error al intentar borrar todo!");
						$('.btnElimTD').show();
						$('.btnCancTD').show();
			}
				});	
}






function limpiaCampo(){
//	console.log("limpiaCampo()");
	$('#InExito').text("");
	$('#datoRequerido').text("");
	$('.mBody').show('fade');
	$('.mFooter').show('fade');
	
	$('#eliminando').hide();
	$('#borrado').hide();
	$('.elimina').show();
	$('.btnElimTD').show();
	$('.btnCancTD').show();
}

function TablaTotalTfe(jsonResponse){	
//	console.log("TablaTotalTfe()"+jsonResponse);
	$('#tablaTfe').text('');
	var html, table, body = '';
	var header = '<table id="listaTableTfe" class="table table-condensed table-hover table-responsive datatable dataTable no-footer   table-striped  dataTables_info" data-page-length="100">' + '<THEAD>'
	+ '<tr>' 
	+ '<th><small>ONT</small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
//				console.log("valores: "+arrayValores.sn);
				html ='<tr  onclick="valorSeleccionado(this)"><td name="sn">';
				html = html + arrayValores.sn;
				html = html + '</td>';
				html = html + '</tr>';
				body = body + html;
			});	
	table = header + body + footer;
	$(table).appendTo('#tablaTfe');
	
	$('#listaTableTfe').dataTable({
		"language" : {
			"sProcessing"	: "Procesando...",
			"lengthMenu"	: 'Mostrar <select>'+
            					'<option value="100">100</option>'+
            					'<option value="250">250</option>'+
            					'<option value="500">500</option>'+
            					'<option value="1000">1000</option>'+
            					'<option value="-1">Todos</option>'+
            					'</select> Datos',
			"sZeroRecords" 	: "No se encontraron resultados",
			"sEmptyTable" 	: "Ning\u00fan dato disponible ",
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
	$('#tablaTfe').show('fade');
//	console.log("Fin_tablaTfe()");
}

$(document).ready(function(){
//	console.log("documento ready");
	$("#snInsert").click(function(){
		$('#datoRequerido').text("");
		if($(".snInsert").val('')==""){
			$('#existente').text('');
		}
	});
});


function valorSeleccionado(valor){
//	console.log("evento seleccionar");
	 $(valor).toggleClass('selected');
}
function eliminarElementos(){
//	console.log("eliminarElementos()");
	$('#mensajeInicio').show('fade');
	$('#borradoUno').hide('fade');
	$('#btnElimina').show();
	$('#btnCancelar').show();
	var table = $('#listaTableTfe').DataTable();
//	console.log(table.rows('.selected').count()+"entra");
	var rows_selected= table.rows('.selected').count();
//	console.log("seleccion:"+rows_selected);
	if(rows_selected>0){
	 $('#eliminaUnElemento').modal('show');
//	 console.log("seleccion:"+rows_selected);
}
} 
function eliminaOk(){
//	console.log("eliminaOk()");
	$('#borrandoUno').hide('fade');
	$('#borradoUno').hide('fade');
	$('#mensajeInicio').show('fade');
	var lineas=new Array();
	 var table = $('#listaTableTfe').DataTable();

	 table.rows('.selected').every( function ( rowIdx, tableLoop, rowLoop ) {			 
		 var rowNode = this.node();
		 json ="";
		 
		 $(rowNode).find("td").each(function (){
			 $this=$(this);
		      json+=',"'+$this.attr("name")+'":"'+$this.html()+'"';
     });
		   obj=JSON.parse('{'+json.substr(1)+'}');
//		   console.log("obj:->"+obj);                           // ver objeto que se borro
		   lineas.push(obj);
		   
		} );
//	 console.log("insertados: "+lineas);
	   
			json_string=JSON.stringify(lineas);
//			console.log("-----------------> "+json_string);
			
			$.ajax({
				url : 'eliminarSeleccion',
				type : "POST",
				traditional:true,
//				contentType: 'application/json',
				data : { 'json_string': json_string }
					,
				dataType : "json",
				beforeSend: function( xhr ) {
//							 $('#loadModal').modal();
							 $('#borrandoUno').show({backdrop: 'static', keyboard: false});
							 $('#mensajeInicio').hide('fade');
						 },
				success : function(response){
					$('#borrandoUno').hide('fade');
					$('#borradoUno').show('fade');
					$('#mensajeInicio').hide('fade');
					if (response != null && response.success == true) {
						$('#btnElimina').hide();
						$('#btnCancelar').hide();
//						$('#msj_eliminar').text("Se han eliminado "+response.result+" registros");
//						console.log("se borro con exito");
					} else {
						console.log(response.mensaje);
//						$('#msj_eliminar').text(response.mensaje);
					}
				},
				error : function(xhr, ajaxOptions, thrownError) {
					console.log(response.mensaje);
//					$('#loadModal').modal('hide');
					$('#borrandoUno').hide('fade');
					$('#borradoUno').hide('fade');
					$('#mensajeInicio').show('fade');
		}
			});	
			
			
			
}


// valida datos para el boton de eliminar todo
function validaExistencia(){
	$.ajax({
		url : 'consultaTfe',
		type : 'GET',
		async : false,
		dataType : "json",
		 success : function(jsonResponse, textStatus, jqXHR){
			 if(jsonResponse.success){
					if(jsonResponse.result!=0){
						TablaTotalTfe(jsonResponse);
//						console.log("si hay datos ");
						$('#eliminaTodo').modal('show');
					}
				} // fin if
				else{
//					console.log("no  hay datos para eliminar -------");
				} // fin else
					} // fin success
	});
}
