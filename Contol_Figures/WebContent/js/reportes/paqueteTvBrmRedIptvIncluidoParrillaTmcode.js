//alert("BRM-TMCODE vs IPTV-Parrillas");
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

function consultaX1(){
	cleanX();
	pintaReporte1($('#fecha').val());
	}
function consultaX2(){
	cleanX();
	pintaReporte2($('#fecha').val());
	}

function pintaReporte1(fech){
	
	if(fech != ""){	
		
		$.ajax({
			url : 'exportPaqueteTvBrmRedIptvIncluidoParrillaTmcodeDetailsTablaJson',
			type : "POST",
			async : true,
			data : {'fechaTabla' :fech},
			dataType : "json",
			 beforeSend: function( xhr ) {
				 $('#wait').modal({backdrop: 'static', keyboard: false});
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#wait').modal('hide');
				if(jsonResponse.success){
																			
					$('.tituloTabla').text("Detalle de paquetes que estan en IPTV y no en BRM ");
					//console.log("Detalle VODS");
										
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    search: true,
					    
					    columns: [{
					        field: 'fecha',
					        title: 'Fecha',
					        sortable: true
					    }, {
					        field: 'id',
					        title: 'Id',
					        sortable: true
					    }, {
					        field: 'cuenta',
					        title: 'Cuenta',
					        sortable: true
					    }, {
					        field: 'plan',
					        title: 'Plan',
					        sortable: true
					    }, {
					        field: 'tmcode',
					        title: 'TM Code',
					        sortable: true
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


function pintaReporte2(fech){
	
	if(fech != ""){	
		
		$.ajax({
			url : 'exportPaqueteTvBrmRedIptvIncluidoParrillaTmcodeDetailsTablaJson2',
			type : "POST",
			async : true,
			data : {'fechaTabla' :fech},
			dataType : "json",
			 beforeSend: function( xhr ) {
				 $('#wait').modal({backdrop: 'static', keyboard: false});
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#wait').modal('hide');
				if(jsonResponse.success){
																			
					$('.tituloTabla').text("Detalle de paquetes que estan en BRM y no en IPTV ");
					//console.log("Detalle VODS");

										
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    search: true,
					    
					    columns: [{
					        field: 'fecha',
					        title: 'Fecha',
					        sortable: true
					    }, {
					        field: 'id',
					        title: 'Id',
					        sortable: true
					    }, {
					        field: 'cuenta',
					        title: 'Cuenta',
					        sortable: true
					    }, {
					        field: 'plan',
					        title: 'Plan',
					        sortable: true
					    }, {
					        field: 'tmcode',
					        title: 'TM Code',
					        sortable: true
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




$(function() {
	initFunction();
});
function initFunction() {
	if($('.nueva_seccion').is(":visible")){
	}
	else{
		sendSolicitud();
	}	
}
function sendSolicitud(){
		if($('#fecha').val() != ""){
			
			$('#nueva_seccion_boton').show('fade');
			$('.nueva_seccion').hide('fade');
			$('.oculto').hide('fade');
			
			$.ajax({
				url : 'getPaqueteTvBrmRedIptvIncluidoParrillaTmcodeService',
				type : "POST",
				async : false,
				data : {'fecha' : $('#fecha').val()},
				dataType : "json",
				beforeSend: function( xhr ) {
					 $('#loadModal').modal();
				 },
				success : function(jsonResponse, textStatus, jqXHR){
					$('#loadModal').modal('hide');
					if(jsonResponse.success){
						$('#descargaArchivo').show();
						$('#fechaReporte').val( $('#fecha').val() );
						$('.contentMessage').hide('fade');
						$('.contentReporte').show('fade');
						
						$('#fechaReporteTabla').val($('#fecha').val());
						
						
				    	$('#tableModal').bootstrapTable('destroy');
				    	$('.tituloTabla').text('');
				    	$('#NoData').text('');
						
						
						setReporte(jsonResponse.result);
						
					}else{					
						$('.dateFail').text($('#fecha').val());
						$('#errorModal').modal();
						$('.contentMessage').show('fade');
						$('.contentReporte').hide('fade');
					}
				},
				error : function(jqXHR, textStatus, errorThrown){
					console.log(textStatus);
					$('#loadModal').modal('hide');
				}
			});
		}
}
function setReporte(result){
//	var demo=-2;
	$('#grafica').text(''); //-- inicializar bacio
	$('.fechaConsulta').text($('#fecha').val());	
	$.each(result, function(index, valores){
		
		//Conciliado
		$('#T_Conciliados').html(accounting.formatNumber( valores.t_conciliados ));
		var porcentaje = (valores.total>0)?((parseInt(valores.t_conciliados)/parseInt(valores.total))*100):0;
//		var porcentaje = (demo!=0)?((1 - ((parseInt(valores.total) - parseInt(valores.t_conciliados)) / demo))*100):0;
		$('#porcentaje').html(accounting.toFixed(porcentaje, 2) + ' %' );
		//No conciliado
		$('#Error_Total').html(accounting.formatNumber( valores.error_total ));
		var porcentajeErr = (valores.total>0)?((parseInt(valores.error_total)/parseInt(valores.total))*100):0;
		$('#porcentajeError_Total').html(accounting.toFixed(porcentajeErr, 2) + ' %' );
		$('#Error_Brm').html(accounting.formatNumber( valores.error_brm ));
		$('#Error_Iptv').html(accounting.formatNumber( valores.error_iptv ));
		
		$('#No_Iptv').html(accounting.formatNumber( valores.no_iptv ));
		$('#No_Brm').html(accounting.formatNumber( valores.no_brm ));
		$('.Totalprr').html(accounting.formatNumber( valores.total ));
		
		var porcentajeErrorBRM = (valores.total>0)?((parseInt(valores.error_brm)/parseInt(valores.total))*100):0;
		var porcentajeErrorIPTV = (valores.total>0)?((parseInt(valores.error_iptv)/parseInt(valores.total))*100):0;
		$('#porcentajeErrorBRM').html(accounting.toFixed(porcentajeErrorBRM, 2) + ' %' );
		$('#porcentajeErrorIPTV').html(accounting.toFixed(porcentajeErrorIPTV, 2) + ' %' );
		
		var porcentajeTotal = (valores.total>0)?((parseInt(valores.t_conciliados)/parseInt(valores.total))*100):0 ;
		$('#porcentajeTotal').html(accounting.toFixed(porcentajeTotal, 2) + ' %' );
		
		$('#Empresa').html('TOTALPLAY');
		
		
		if(valores.status == 'SI' ){
			$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
		}else{
			$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
		}
		
		var botones = '';
		var porcentajeBRM = (valores.total>0)?((parseInt(valores.error_brm)/parseInt(valores.total))*100):0; 
		var porcentajeIPTV = (valores.total>0)?((parseInt(valores.error_iptv)/parseInt(valores.total))*100):0;
//		alert(porcentajeBRM);
//		alert(porcentajeIPTV);
		
		if(porcentajeBRM ==100){
			if(valores.status == 'SI' ){
				botones = '<img src="/CifrasControl/img/green.png">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png">';
			}
//		}else if(porcentajeBRM > 1 && porcentajeBRM <= 15 ){
//			botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
		}else {
			if(valores.status == 'SI' ){
				botones = '<img src="/CifrasControl/img/green.png">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png">';
			}
		}
		$('.bcolorBRM').html(botones);
		
		if(porcentajeIPTV ==100){
			if(valores.status == 'SI' ){
				botones = '<img src="/CifrasControl/img/green.png">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png">';
			}
//		}else if(porcentajeIPTV > 1 && porcentajeIPTV <= 15 ){
//			botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
		}else{
			if(valores.status == 'SI' ){
				botones = '<img src="/CifrasControl/img/green.png">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png">';
			}
		}
		// -----   GRAFICA TOTALES ------------------
		var gTOTAL; 
		 gTOTAL= new JustGage({
			    id:"grafica",
			    //label: "label",
//			    title: "TOTAL",
//			    titleFontColor: "#4c56de", // color azul
//			    titleFontFamily: "Georgia",
//		        titlePosition: "up",
			    value: porcentaje,
		        //value: 22.10,
			    valueFontColor: " #757669 ",
			    //valueFontFamily: "Georgia",
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
			    //levelColorsGradient: false,
			    //counter: true,
			    donut: true
			  });
		 
		$('.bcolorIPTV').html(botones);
		$(".modal").hide();
	});
	
}


function limpiaCampos(){
	
	var valorInicial = 0.0;
	$('.decision').html("");
	$('.bcolorBRM').text('');
	$('.bcolorIPTV').text('');
	$('#T_Conciliados').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentaje').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#Error_Total').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentajeError_Total').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#Error_Brm').html(accounting.toFixed(valorInicial, 2 ));
	$('#Error_Iptv').html(accounting.toFixed(valorInicial, 2 ));
	$('#No_Iptv').html(accounting.toFixed(valorInicial, 2 ));
	$('#No_Brm').html(accounting.toFixed(valorInicial, 2 ));
	$('.Totalprr').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentajeErrorBRM').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#porcentajeErrorIPTV').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#porcentajeTotal').html(accounting.toFixed(valorInicial, 2) + ' %' );
	
	$('#Empresa').html(" ");
}

$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });
//***********************************************************************************************
//****************************************** NUEVA SECCIÓN
$('#confmodal').on('hide.bs.modal', function () {
	nueva_seccion_consulta();
	 });

function muestra_seccion(){
	$('.contentMessage').hide();
	$('.contentReporte').hide();
	$('#nueva_seccion_boton').hide();
	$('.nueva_seccion').show('fade');
	nueva_seccion_consulta();
}
function regresa_reporte(){
	$('.nueva_seccion').hide('fade');
	$('#nueva_seccion_boton').show();	
	sendSolicitud();
}
// --------------------------------- CONSULTA SECCION NUEVA
function nueva_seccion_consulta() {
	$.ajax({
		url : 'getParrillasvsTMCodeTabla',
		type : "POST",
		dataType : "json",
		beforeSend: function( xhr ) {
			 $('#loadModal').modal();
		 },
		success : function(jsonResponse, textStatus, jqXHR){
			$('#loadModal').modal('hide');

			if(jsonResponse.success){
					$('.insertar_boton').show('fade');
					contruyeTabla(jsonResponse);
			}else{		
					$('#errorModaltxt').modal();
			}
		},
		error : function(jqXHR, textStatus, errorThrown){
			$('#errorModaltxt').modal();
			$('#loadModal').modal('hide');
		}
	});
}
//--------------------------------- CONSTRUYE TABLA SECCION NUEVA
function contruyeTabla(jsonResponse){	
	$('#divReport').text('');
	$('#divReport').show('fade');
	
	var html, table, body = '';
	var header = '<table id="listaTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer  table-striped">' + '<THEAD>'
	+ '<tr>' 
	+ '<th><small>Paquete BRM</small></th>'
	+ '<th><small>Paquete IPTV</small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				html = '<tr onclick="tr_sel(this)"><td name="cuenta">';
				html = html + arrayValores.paquete_brm;
				html = html + '</td>';
				html = html + '<td name="empresa">';
				html = html + arrayValores.paquete_iptv;
				html = html + '</td>';
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
			"sEmptyTable" 	: "Ning\u00fan dato disponible  ",
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
	$('#divReport').show('fade');
}
//-------------------------------------- INSERTAR NUEVA SECCION
function insertarb(){
	if($('#paq_brm').val()!=''&&$('#paq_iptv').val()!=''){
	$('#msj').text('¿Está seguro de que desea insertar los datos seleccionados?');
	$('.botones').show();
	$('#confmodal').modal('show');
	}
}
function consulta_insertar(){
	if($('#paq_brm').val()!=''&&$('#paq_iptv').val()!='')
	{
			
	$.ajax({
		url :'getParrillasvsTMCodeInsert',
		type : "POST",
		traditional:true,
		data : { 'paquete_brm': $('#paq_brm').val(),
				 'paquete_iptv':$('#paq_iptv').val()
				}
			,
		dataType : "json",
		beforeSend: function( xhr ) {
					 $('#loadModal').modal();
				 },
		success : function(response){
			$('#loadModal').modal('hide');
			if (response.success == true) {
					$('.botones').hide();
					$('#msj').text('Se agregó registro');
					$('#confmodal').modal('show');
					$('#paq_brm').val('');
					$('#paq_iptv').val('');
					
			} else {
					$('.botones').hide();
					$('#msj').text('No se agregó registro');
					$('#confmodal').modal('show');
			}
		},
		error : function(xhr, ajaxOptions, thrownError) {	
			$('#loadModal').modal('hide');
			$('#errorModaltxt').modal();
			
		}
	});
	
	}
}

//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
function getValor() {
//	console.log("BRM-TMCODE vs IPTV-Parrillas");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}
