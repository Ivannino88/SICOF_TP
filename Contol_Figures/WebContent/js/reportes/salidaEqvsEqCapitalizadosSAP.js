
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
			url : 'getSalidaEqvsEqCapitalizadosSAPTabla',
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
																			
					$('.tituloTabla').text("Salida de Eq vs Eq Capitalizados SAP ");
					//console.log("Salida de Eq vs Eq Capitalizados SAP");
					
										
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    columns: [{
					        field: 'fecha',
					        title: 'Fecha'
					    }, {
					        field: 'salida_almacen',
					        title: 'Salida de Almacén'
					    }, {
					        field: 'importe',
					        title: 'Importe'
					    }, {
					        field: 'activo_fijo',
					        title: 'Activo Fijo'
					    }, {
					        field: 'importe_activo_fijo',
					        title: 'Importe Activo Fijo'
					    }, {
					        field: 'estatus',
					        title: 'Estatus'
					    }, {
					        field: 'fecha_consulta',
					        title: 'Fecha de Consulta'
					    },  ]
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
	if($('#fecha').val() != ""){
		$.ajax({
			url : 'getSalidaEqvsEqCapitalizadosSAP',
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
					//console.log(jsonResponse);
					$('#fechaReporteTabla').val($('#fecha').val());
					
					$("#op1").prop("checked", false);
			    	$('#tableModal').bootstrapTable('destroy');
			    	$('.tituloTabla').text('');
			    	$('#NoData').text('');
			    	
					construyeReporte(jsonResponse);
					if(jsonResponse.result.length > 0){
						$('.contentMessage').hide('fade');
						$('.contentReporte').show('fade');
						$( "#btn-Reporte" ).prop( "disabled", false );
					}else{
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

function construyeReporte(jsonResponse) {
	
	$('.fechaEt').text($('#fecha').val());
	$('#divReport').text('');
	var totalAct=0;
	var html, table, body = '';
	var header = '<table id="almacenTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer table-striped">' + '<THEAD>'
			+ '<tr>' 
			+ '<th><small>FECHA</small></th>'
			+ '<th><small>SALIDA ALMACEN</small></th>'
			+ '<th><small>IMPORTE</small></th>'
			+ '<th><small>ACTIVO FIJO</small></th>'
			+ '<th><small>IMPORTE ACT FIJO</small></th>' 
//			+ '<th><small>ESTATUS</small></th>'
			+ '<th><small><img src="/CifrasControl/img/dashboard-icon-copy-2.png"></small></th>'
			+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
			$.each(
					jsonResponse.result,
					function(index, arrayValores) {
						html = '<tr><td align="center">';
						html = html + arrayValores.fecha;
						html = html + '</td>';
						html = html + '<td align="center">';
						html = html + accounting.formatNumber(arrayValores.salida_almacen);
						html = html + '</td>';
						html = html + '<td>';
						html = html + accounting.formatMoney(arrayValores.importe);
						html = html + '</td>';
						html = html + '<td>';
						html = html + accounting.formatNumber(arrayValores.activo_fijo);
						html = html + '</td>';
						html = html + '<td>';
						html = html + accounting.formatMoney(arrayValores.importe_activo_fijo);
						html = html + '</td>';
//						html = html + '<td>';
//						html = html + arrayValores.estatus;
//						html = html + '</td>';
						html = html + '<td align="center">';
						var details = "";
						if(arrayValores.estatus == "verde"){
							details = '<img src="/CifrasControl/img/green.png"  class="semaforo_green">';
						}else if(arrayValores.estatus == "amarillo"){
							details = '<img src="/CifrasControl/img/yellow.png" class="semaforo_yellow">';
						}else{
							details = '<img src="/CifrasControl/img/red.png" class="semaforo_red">';
						}
						
						
						html = html + details;
						html = html + '</td>';
						html = html + '</tr>';
						body = body + html;
						total= (arrayValores.importe>0)?((arrayValores.importe_activo_fijo*100)/arrayValores.importe):0;
//						console.log("ACTIVO_FIJOIJO-->"+arrayValores.importe_activo_fijo);
//						console.log("importe--> "+arrayValores.importe);
//						console.log("total es-------> "+total);
//						if (arrayValores.importe_activo_fijo >0){
//						total=(arrayValores.importe*100)/arrayValores.importe_activo_fijo;
//						
//						console.log("if TOTAL ES"+total);
//						}else{
//							total=0;
//							console.log("ELse TOTAL ES"+total);
//						}
						//---------   GRAFICA  CAPITALIZADOS  -----	
						$("#graficaTP").text('');  //-- inicializacion de grafica en vacio
						var gTP;
						 gTP= new JustGage({
							    id:"graficaTP",
							    //label: "label",
//							    title: "TOTAL",
//							    titleFontColor: "#4c56de", // color azul
//							    titleFontFamily: "Georgia",
//						        titlePosition: "up",
							    value: total,
						        //value: 22.10,
							    valueFontColor: " #757669 ",
							    //valueFontFamily: "Georgia",
							    valueFontSize: "5px",
							    min: 0,
							    max: 100,
							    decimals: 0,
							    symbol: '%',
							    gaugeWidthScale: 0.4,
							    pointer: true,
							    customSectors : [{"lo":0, "hi":30,  "color":"#F72020"},
							                     {"lo":31,"hi":60,  "color":"#F7F420"},
							                     {"lo":61,"hi":100, "color":"#36F44A"}
							                     ],
							    pointerOptions: {
							                  toplength: -17,
							                  bottomlength: 15,
							                  bottomwidth: 4,
							                  color: "#757669"
							                    },
							    //levelColorsGradient: false,
							    //counter: true,
							    donut: true
							  });
						
						
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

//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
function getValor() {
//	console.log("Salida de Equipos vs Equipos Capitalizados SAP");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}
