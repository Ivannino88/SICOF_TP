//console.log("#>$ Megas TFE");

$('.detalle').click(function(){
	cleanX();
	$('#myModal').modal('show');
});
function cleanX(){
	$('#NoData').text('');
	$('.tituloTabla').text('');
	$('#tableModal').bootstrapTable('destroy');
	$('.table-result').show();	
}
function consultaX(){
cleanX();
pintaReporte1($('#fecha').val());
}


function cargaReporteTest(){
	//alert( $('#fecha').val() );
	$('#fechaConsulta').text('DIA: ' + $('#fecha').val() );
	cargaReporte();
}

function cargaReporte(){
	$('.contentReporte').hide('fade');
	$('#grafica').text(''); //-- inicializar bacio
	$('.idConsulta').val('');
	$('input[name="radiob"]').attr('checked', false);
	console.log("entrando a cargaReporte()"+$('#fecha').val());
	if($('#fecha').val() != ""){
//		console.log("fecha de Entrada"+$('#fecha').val());
		$.ajax({
			url : 'getMegasTfeJson',
			type : "POST",
			async : false,
			data : {'fecha' : $('#fecha').val()},
			dataType : "json",
			 beforeSend: function( xhr ) {
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#loadModal').modal('hide');
				if(jsonResponse.success){
					
					
					$.each(jsonResponse.result, function(index, valores){ 
//					console.log("carga reporte radio button  valor id:"+valores.id);
					$('.idConsulta').val(valores.id);
//					console.log("carga reporte tipo_conciliacion :"+valores.tipo_conciliacion);
					
					
				});
					
					$('.ver_detalle').hide('fade');                        // boton detalle
					$('.botones_radio').show('fade');                        // radio button
					$('.contentMessage').hide('fade');
//					$('.contentReporte').show('fade');
//					$('#descargaArchivo').show();
//					$('#fechaReporte').val( $('#fecha').val() );
					
//					$('#fechaReporteTabla').val($('#fecha').val());
					
			    	$('#tableModal').bootstrapTable('destroy');
//			    	$('.tituloTabla').text('');
//			    	$('#NoData').text('');
					
					setReporte(jsonResponse.result);
					
				}else{
					limpiaCampos();
//					$('.dateFail').text($('#fecha').val());
					$('#errorModal').modal();
					$('.contentMessage').show('fade');
//					$('.contentReporte').hide('fade');
					$('#descargaArchivo').hide();
					$('.ver_detalle').hide('fade');                        // boton detalle
					$('.botones_radio').hide('fade');                        // radio button
				}
			},
			error : function(jqXHR, textStatus, errorThrown){
//				console.log("error de json");
				console.log(textStatus);
			}
		});
	}
}
function setReporte(result){
	$('#grafica').text(''); //-- inicializar bacio
	$.each(result, function(index, valores){

		//Conciliado
		$('#T_Conciliados').html(accounting.formatNumber( valores.t_conciliados ));
		var porcentaje = (valores.total>0)?((parseInt(valores.t_conciliados)/parseInt(valores.total))*100):0 ;
		$('.porcentajeTconciliados').html(accounting.toFixed(porcentaje, 2) + ' %' );
		
		//No conciliado
		$('#Error_Total').html(accounting.formatNumber( valores.error_total ));
		var porcentajeErr = (valores.total>0)?((parseInt(valores.error_total)/parseInt(valores.total))*100):0 ;
		$('#porcentajeError_Total').html(accounting.toFixed(porcentajeErr, 2) + ' %' );
		
		$('#Error_Brm').html(accounting.formatNumber( valores.error_brm ));
		var porcentajeErrorBRM =(valores.total>0)?((parseInt(valores.error_brm)/parseInt(valores.total))*100):0;
		$('#porcentajeErrorBRM').html(accounting.toFixed(porcentajeErrorBRM, 2) + ' %' );
		
		$('#Error_U2000').html(accounting.formatNumber( valores.error_u2000 ));
		var porcentajeErrorU2000 = (valores.total>0)?((parseInt(valores.error_u2000)/parseInt(valores.total))*100):0 ;
		$('#porcentajeErrorU2000').html(accounting.toFixed(porcentajeErrorU2000, 2) + ' %' ); 
		
		$('#No_Brm').html(accounting.formatNumber( valores.no_brm));
		$('#No_u2000').html(accounting.formatNumber( valores.no_u2000 ));
		$('.Total_t').html(accounting.formatNumber( valores.total ));
		
		var porcentajeTotal = (valores.total>0)?((parseInt(valores.t_conciliados)/parseInt(valores.total))*100):0 ;
		$('#porcentajeTotal').html(accounting.toFixed(porcentajeTotal, 2) + ' %' );
		
		var botones = '';
		
		if(porcentajeErrorBRM >= 100){
		
			botones = '<img src="/CifrasControl/img/green.png">';
		}else{
			botones = '<img src="/CifrasControl/img/red.png" >';
		}
		$('.bcolorBRM').html(botones);
		
		if(porcentajeErrorU2000 >=100){
			botones = '<img src="/CifrasControl/img/green.png">';
		}else{
			botones = '<img src="/CifrasControl/img/red.png">';
		}
		$('.bcolorU2000').html(botones);
		 gTOTAL= new JustGage({
			    id:"grafica",
			    value: porcentaje,
			    valueFontColor: " #757669 ",
			    valueFontSize: "5px",
			    min: 0,
			    max: 100,
			    decimals: 1,
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
			    donut: true
			  });
		$('.bcolorPM').html(botones);
	});
}


function limpiaCampos(){
	
	var valorInicial = 0.0;
	$('.decision').html("");
	$('.bcolorBRM').text('');
	$('.bcolorFFM').text('');
	$('#T_Conciliados').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentaje').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#Error_Total').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentajeError_Total').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#Error_Brm').html(accounting.toFixed(valorInicial, 2 ));
	$('#Error_ffm').html(accounting.toFixed(valorInicial, 2 ));
	$('#No_Ffm').html(accounting.toFixed(valorInicial, 2 ));
	$('#No_Brm').html(accounting.toFixed(valorInicial, 2 ));
	$('#Total').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentajeErrorBRM').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#porcentajeErrorFFM').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#porcentajeTotal').html(accounting.toFixed(valorInicial, 2) + ' %' );
	
	$('#Empresa').html(" ");
}

$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });


//   ----------------    			CONSULTA MEGAS POR SUBIDA Y BAJADAS
function sendOpcion(){
	
	$('.idConsulta').val('');
	console.log("sendOpcion()------"+ $('#idConsulta').val());
	if(document.getElementById("subida").checked){
			opcion=1;
			url='getMegasTfeSoB';
//			console.log("sendOpcion()-> "+ opcion);
		}
		if(document.getElementById("bajada").checked){
			opcion=2;
			url='getMegasTfeSoB';
//			console.log("sendOpcion()-> "+ opcion);
		}
		
		if($('#fecha').val() != ""){
			$('#divReport').hide('fade');
			$('.oculto').hide('fade');
			$('#internas_boton').show('fade');
			$('.lineas_internas').hide('fade');
			$('.botones_radio').show();
		
			
			$.ajax({
				url : url,
				type : "POST",
				async : false,
				data : {
					'fecha' : $('#fecha').val(),
					'conciliacion' : opcion
				},
				dataType : "json",
				beforeSend: function( xhr ) {
					 $('#loadModal').modal();
				 },
				success : function(jsonResponse, textStatus, jqXHR){
					$('#loadModal').modal('hide');
					if(jsonResponse.success){
						
						$.each(jsonResponse.result, function(index, valores){ 
							console.log("id:--"+valores.id);
							$('.idConsulta').val(valores.id);
						});
						//$('#descargaArchivo').show();
						$('.fechaEt').text($('#fecha').val());
						$('.contentMessage').hide('fade');
						$('.contentMessage2').hide('fade');
						$('.lineas_ocultas').hide('fade');
						$('.contentReporte').show('fade');
						$('#internas_boton').show('fade');
						$('.ver_detalle').show('fade');
						
						$('#fechaReporteTabla').val($('#fecha').val());
						$('#idDetalleTabla').val(opcion);
//						cleanModal();
						setReporte(jsonResponse.result);
						
						
					}else{					
						$('.dateFail').text($('#fecha').val());
						$('#errorModal').modal();
						$('.contentMessage').hide('fade');
						$('.contentMessage2').show('fade');
						$('.contentReporte').hide('fade');
						$('.ver_detalle').hide('fade');
					}
				},
				error : function(jqXHR, textStatus, errorThrown){
					console.log(textStatus);
					$('#loadModal').modal('hide');
				}
			});
		}
}
/*
function reporteDetalles(){
	console.log("reporteDetalles() -- dato a enviar es: "+$('.idConsulta').val());
	
	var conciliacion=$('.idConsulta').val();
	
//	if ($('input[name="radiob"]').is(':checked')) {
//       console.log("---->> " +conciliacion);
//    }
//	else {
//        alert('Debe seleccionar al menos una opcion');
//    }
	
	
	
	if(conciliacion != ""){	
		
		$.ajax({
			url : 'getMegasTfeSoBDetalle',
			type : "POST",
			async : true,
			data : {'id_conciliacion' :conciliacion},
			dataType : "json",
			 beforeSend: function( xhr ) {
				 $('#wait').modal({backdrop: 'static', keyboard: false});
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#wait').modal('hide');
				if(jsonResponse.success){
																			
					$('.tituloTabla').text("Detalle Megas Tfe ");
					console.log("armando reporte...");
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    search: true,
					    
					    columns: [{
					        field: 'id_conciliacion',
					        title: 'ID_CONCILIACION',
					        sortable: true
					    }, {
					        field: 'fecha',
					        title: 'FECHA',
					        sortable: true
					    }, {
					        field: 'sn',
					        title: 'SN',
					        sortable: true
					    }, {
					        field: 'megas_red',
					        title: 'MEGAS RED',
					        sortable: true
					    }, {
					        field: 'megas_brm',
					        title: 'MEGAS BRM',
					        sortable: true
					    },{
					        field: 'accion',
					        title: 'ACCION',
					        sortable: true,
					        checkbox: false,
					        clickToSelect: true,
					    } ]
					});
				}else{
					$('.tituloTabla').text('');
					$('#NoData').text("No se encontraron datos");
					//console.log("Error en la tabla");
				}
			}
			 ,
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
				$('#wait').modal('hide');
			}
		});
	}
}
*/



//같같같같같같같같같같같같같같같같같같같같같같같같같같같�
function getValor() {
//	console.log("Megas Tfe");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}




function cargaReporteDesable(){
	$('#grafica').text(''); //-- inicializar bacio
	$('.idConsulta').val('');
//	console.log("entrando a cargaReporte()"+$('#fecha').val());
	if($('#fecha').val() != ""){
//		console.log("fecha de Entrada"+$('#fecha').val());
		$.ajax({
			url : 'getMegasTfeJson',
			type : "POST",
			async : false,
			data : {'fecha' : $('#fecha').val()},
			dataType : "json",
			 beforeSend: function( xhr ) {
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#loadModal').modal('hide');
				if(jsonResponse.success){
					
					
					$.each(jsonResponse.result, function(index, valores){ 
//					console.log("carga reporte radio button  valor id:"+valores.id);
					$('.idConsulta').val(valores.id);
//					console.log("carga reporte tipo_conciliacion :"+valores.tipo_conciliacion);
					
					/*
					if(valores.tipo_conciliacion ==1){
						console.log("subida");
						document.getElementById("subida").unchecked = true;
						
					}else{
						console.log("bajada");
						document.getElementById("bajada").checked = true;
					}
					*/
				});
					
					$('.ver_detalle').show('fade');                        // boton detalle
					$('.botones_radio').show('fade');                        // radio button
					$('.contentMessage').hide('fade');
					$('.contentReporte').show('fade');
					$('#descargaArchivo').show();
					$('#fechaReporte').val( $('#fecha').val() );
					
					$('#fechaReporteTabla').val($('#fecha').val());
					
			    	$('#tableModal').bootstrapTable('destroy');
			    	$('.tituloTabla').text('');
			    	$('#NoData').text('');
					
					setReporte(jsonResponse.result);
					
				}else{
					limpiaCampos();
					$('.dateFail').text($('#fecha').val());
					$('#errorModal').modal();
					$('.contentMessage').show('fade');
					$('.contentReporte').hide('fade');
					$('#descargaArchivo').hide();
					$('.ver_detalle').hide('fade');                        // boton detalle
					$('.botones_radio').hide('fade');                        // radio button
				}
			},
			error : function(jqXHR, textStatus, errorThrown){
//				console.log("error de json");
				console.log(textStatus);
			}
		});
	}
}
 //  ******************************************************************************************************************************************************

function reporteDetalles(){
	console.log("DEMO ------- **************  "+$('.idConsulta').val());
	
	var conciliacion=$('.idConsulta').val();
	
	if(conciliacion != ""){	
		
		$.ajax({
			url : 'getMegasTfeSoBDetalle',
			type : "POST",
			async : true,
			data : {'id_conciliacion' :conciliacion},
			dataType : "json",
			 beforeSend: function( xhr ) {
				 $('#wait').modal({backdrop: 'static', keyboard: false});
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#wait').modal('hide');
				
				if(jsonResponse.success){
					$('.tituloTabla').text("Detalle Megas Tfe ");
					console.log("armando reporte...");
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    search: true,
					    
					    columns: [{
					        field: 'id_conciliacion',
					        title: 'ID_CONCILIACION',
					        sortable: true
					    }, {
					        field: 'fecha',
					        title: 'FECHA',
					        sortable: true
					    }, {
					        field: 'sn',
					        title: 'SN',
					        sortable: true
					    }, {
					        field: 'megas_red',
					        title: 'MEGAS RED',
					        sortable: true
					    }, {
					        field: 'megas_brm',
					        title: 'MEGAS BRM',
					        sortable: true
					    }
//					    ,{
//					        field: 'accion',
//					        title: 'ACCION',
//					        sortable: true,
//					        formatter: "CheckBoxFormat",
					        //checkbox: true,
					        //clickToSelect: true,
//					    }
					]
					});
				}else{
					$('.tituloTabla').text('');
					$('#NoData').text("No se encontraron datos");
					//console.log("Error en la tabla");
				}
			} ,
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
				$('#wait').modal('hide');
			}
		});
	}
}

function CheckBoxFormat(value, row) {
	console.log("CheckBoxFormat(value, row)"+value);
	if (value==1){
		return '<input type="checkbox" class="chk" data-ID="' + row.ID + '" onclick="AddRemoveItems(this);"/>';	
	}else{
		return '<input type="checkbox" class="chk" data-ID="' + row.ID + '" onclick="AddRemoveItems(this);"/>';
	}
    
}


