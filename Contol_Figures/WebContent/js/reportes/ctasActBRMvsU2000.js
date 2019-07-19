//alert("BRM-SN vs U2000-ONT");
$('.detalle').click(function(){
	$('#myModal').modal('show');
});

$('#opc1').click(function(){
	$('#empresas1').show('fade');
	$('#opc2').hide('fade');
	$('#opc3').hide('fade');
	$('#opc4').hide('fade');
	$('#back').show('fade');
	
});
$('#opc2').click(function(){
	$('#empresas2').show('fade');
	$('#opc1').hide('fade');
	$('#opc3').hide('fade');
	$('#opc4').hide('fade');
	$('#back').show('fade');
});
$('#opc3').click(function(){
	$('#empresas3').show('fade');
	$('#opc1').hide('fade');
	$('#opc2').hide('fade');
	$('#opc4').hide('fade');
	$('#back').show('fade');
});
$('#opc4').click(function(){
	$('#empresas4').show('fade');
	$('#opc1').hide('fade');
	$('#opc2').hide('fade');
	$('#opc3').hide('fade');
	$('#back').show('fade');
});
$('#back').click(function(){
	back();
});
function back(){
	$('#empresas1').hide('fade');
	$('#empresas2').hide('fade');
	$('#empresas3').hide('fade');
	$('#empresas4').hide('fade');
	$('#opc1').show('fade');
	$('#opc2').show('fade');
	$('#opc3').show('fade');
	$('#opc4').show('fade');
	$('#back').hide('fade');
	$('#tableModal').bootstrapTable('destroy');
	$('.tituloTabla').text('');
	$('#NoData').text('');
	$('.consultaX').text('');
}
function cleanX(){
	$('.consultaX').text('');
	$('#NoData').text('');
	$('.tituloTabla').text('');
	$('#tableModal').bootstrapTable('destroy');
	$('.table-result').show();	
}

// consultas opcion 1
function consultaTp1(){
	cleanX();
//	console.log('consulta 1.1');
//	console.log($('.btn1').val());
//	console.log("fecha"+$('#fecha').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn1').val());
	pintaReporte1($('#fecha').val(), $('.btn1').val());
}
function consultaEnl1(){
	cleanX();
//	console.log('consulta 2.1');
//	console.log($('.btn2').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn2').val());
	pintaReporte1($('#fecha').val(), $('.btn2').val());
}
function consultaTfe1(){
	cleanX();
//	console.log('consulta 3.1');
//	console.log($('.btn3').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn3').val());
	pintaReporte1($('#fecha').val(), $('.btn3').val());
}
function consultaTt1(){
	cleanX();
//	console.log('consulta 4.1');
//	console.log($('.btn4').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn4').val().toUpperCase());
	pintaReporte1($('#fecha').val(), $('.btn4').val());
}
//consultas opcion 2
function consultaTp2(){
	cleanX();
//	console.log('consulta 1.2');
//	console.log($('.btn1').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn1').val());
	pintaReporte2($('#fecha').val(), $('.btn1').val());
}

function consultaEnl2(){
	cleanX();
//	console.log('consulta 2.2');
//	console.log($('.btn2').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn2').val());
	pintaReporte2($('#fecha').val(), $('.btn2').val());
}
function consultaTfe2(){
	cleanX();
//	console.log('consulta 3.2');
//	console.log($('.btn3').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn3').val());
	pintaReporte2($('#fecha').val(), $('.btn3').val());
}
function consultaTt2(){
	cleanX();
//	console.log('consulta 4.2');
//	console.log($('.btn4').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn4').val().toUpperCase());
	pintaReporte2($('#fecha').val(), $('.btn4').val());
}

//consultas opcion 3
function consultaTp3(){
	cleanX();
//	console.log('consulta 1.3');
//	console.log($('.btn1').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn1').val());
	pintaReporte3($('#fecha').val(), $('.btn1').val());
}

function consultaEnl3(){
	cleanX();
//	console.log('consulta 2.3');
//	console.log($('.btn2').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn2').val());
	pintaReporte3($('#fecha').val(), $('.btn2').val());
}
function consultaTfe3(){
	cleanX();
//	console.log('consulta 3.3');
//	console.log($('.btn3').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn3').val());
	pintaReporte3($('#fecha').val(), $('.btn3').val());
}
function consultaTt3(){
	cleanX();
//	console.log('consulta 4.3');
//	console.log($('.btn4').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn4').val().toUpperCase());
	pintaReporte3($('#fecha').val(), $('.btn4').val());
}

//consultas opcion 4
function consultaTp4(){
	cleanX();
//	console.log('consulta 1.4');
//	console.log($('.btn1').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn1').val());
	pintaReporte4($('#fecha').val(), $('.btn1').val());
}

function consultaEnl4(){
	cleanX();
//	console.log('consulta 2.4');
//	console.log($('.btn2').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn2').val());
	pintaReporte4($('#fecha').val(), $('.btn2').val());
}
function consultaTfe4(){
	cleanX();
//	console.log('consulta 3.4');
//	console.log($('.btn3').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn3').val());
	pintaReporte4($('#fecha').val(), $('.btn3').val());
}
function consultaTt4(){
	cleanX();
//	console.log('consulta 4.4');
//	console.log($('.btn4').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn4').val().toUpperCase());
	pintaReporte4($('#fecha').val(), $('.btn4').val());
}

function clearjQueryCache(){
    for (var x in jQuery.cache){
        delete jQuery.cache[x];
    }
}

function pintaReporte1(fechaFiltro, filtro){
//	console.log("# f1");
	if(fechaFiltro != ""){	
		
		$.ajax({
			url : 'exportCtasActivasBRMvsU2000DetailsTPTablaJson',
			type : "POST",
			async : true,
			data : {'fechaTabla' :fechaFiltro,
					'filtro': filtro},
			dataType : "json",
			beforeSend: function( xhr ) {
				$('#wait').modal({backdrop: 'static', keyboard: false});
			},
			complete: function () {
				$('#wait').modal('hide');
            },
            cache: false,
			success : function(jsonResponse, textStatus, jqXHR){
				if(jsonResponse.success){
					//$('#wait').modal('hide');														
					$('.tituloTabla').text("Detalle de dispositivos que se encuentran en BRM y no en U2000 ");
										
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    search: true,					    
					    columns: [{
					        field: 'id_conciliacion',
					        title: 'Id Conciliación',
					        sortable: true
					    }, {
					        field: 'fecha_conciliacion',
					        title: 'Fecha Conciliación',
					        sortable: true
					    }, {
					        field: 'cuenta',
					        title: 'Cuenta',
					        sortable: true
					    }, {
					        field: 'empresa',
					        title: 'Empresa',
					        sortable: true
					    }, {
					        field: 'plan',
					        title: 'Plan',
					        sortable: true
					    }, {
					        field: 'sn',
					        title: 'SN',
					        sortable: true
					    }, {
					        field: 'status_cuenta',
					        title: 'Status de Cuenta',
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


function pintaReporte2(fech, filtro){
//	console.log("# f2");
	if(fech != ""){	
		
		$.ajax({
			url : 'exportCtasActivasBRMvsU2000DetailsTPTablaJson2',
			type : "POST",
			async : true,
			data : {'fechaTabla' :fech,
					'filtro': filtro},
			dataType : "json",
			beforeSend: function( ) {
				$('#wait').modal({backdrop: 'static', keyboard: false});
			},
			complete: function () {
				$('#wait').modal('hide');
            },
			success : function(jsonResponse, textStatus, jqXHR){				
				if(jsonResponse.success){																			
					$('.tituloTabla').text("Detalle de dispositivos que se encuentran en U2000 y no en BRM");
					//console.log("Detalle VODS");
															
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    search: true,
					    columns: [{
					        field: 'fecha_conciliacion',
					        title: 'Fecha Conciliación',
					        sortable: true
					    }, {
					        field: 'cuenta',
					        title: 'Cuenta',
					        sortable: true
					    }, {
					        field: 'empresa',
					        title: 'Empresa',
					        sortable: true
					    }, {
					        field: 'nombre',
					        title: 'Nombre',
					        sortable: true
					    }, {
					        field: 'sn',
					        title: 'SN',
					        sortable: true
					    }, {
					        field: 'nombreont',
					        title: 'Nombre ONT',
					        sortable: true
					    }, {
					        field: 'etiqueta',
					        title: 'Etiqueta',
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


function pintaReporte3(fech, filtro){
//	console.log("# f3");
	if(fech != ""){	
		
		$.ajax({
			url : 'exportCtasActivasBRMvsU2000DetailsTPTablaJson3',
			type : "POST",
			async : true,
			data : {'fechaTabla' :fech,
					'filtro': filtro},
			dataType : "json",
			beforeSend: function( ) {
				$('#wait').modal({backdrop: 'static', keyboard: false});
			},
			complete: function () {
				$('#wait').modal('hide');
            },
			success : function(jsonResponse, textStatus, jqXHR){
				if(jsonResponse.success){																			
					$('.tituloTabla').text("Detalle de dispositivos que se encuentran en los 2 sistemas pero no coincide su cuenta");

					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    search: true,
					    columns: [{
					        field: 'id_conciliacion',
					        title: 'Id Conciliación',
					        sortable: true
					    }, {
					        field: 'fecha_conciliacion',
					        title: 'Fecha Conciliación',
					        sortable: true
					    }, {
					        field: 'cuenta',
					        title: 'Cuenta',
					        sortable: true
					    }, {
					        field: 'empresa',
					        title: 'Empresa',
					        sortable: true
					    }, {
					        field: 'plan',
					        title: 'Plan',
					        sortable: true
					    }, {
					        field: 'sn',
					        title: 'SN',
					        sortable: true
					    }, {
					        field: 'status_cuenta',
					        title: 'Status de Cuenta',
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


function pintaReporte4(fech, filtro){
//	console.log("# f4");
	if(fech != ""){	
		
		$.ajax({
			url : 'exportCtasActivasBRMvsU2000DetailsTPTablaJson4',
			type : "POST",
			async : true,
			data : {'fechaTabla' :fech,
					'filtro': filtro},
			dataType : "json",
			beforeSend: function( ) {
				$('#wait').modal({backdrop: 'static', keyboard: false});
			},
			complete: function () {
				$('#wait').modal('hide');
            },
			success : function(jsonResponse, textStatus, jqXHR){
				if(jsonResponse.success){																			
					$('.tituloTabla').text("Detalle que no se considera para esta cifra");
															
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,				 
					    search: true,					    
					    columns: [{
					        field: 'id_conciliacion',
					        title: 'Id Conciliación',
					        sortable: true
					    }, {
					        field: 'fecha_conciliacion',
					        title: 'Fecha Conciliación',
					        sortable: true
					    }, {
					        field: 'cuenta',
					        title: 'Cuenta',
					        sortable: true
					    }, {
					        field: 'empresa',
					        title: 'Empresa',
					        sortable: true
					    }, {
					        field: 'plan',
					        title: 'Plan',
					        sortable: true
					    }, {
					        field: 'sn',
					        title: 'SN',
					        sortable: true
					    }, {
					        field: 'status_cuenta',
					        title: 'Status de Cuenta',
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
	$('#aseg1 span').addClass('desabilitado'); //----esconde la opcion en donde se encuentra
//	alert("online v1");
	/*$(document).ajaxStart(function(){
        $("#wait").css("display", "block");
    });
    $(document).ajaxComplete(function(){
        $("#wait").css("display", "none");
    });
    */
});
function initFunction() {
	initComponents();
}
function initComponents() {
	$('#datetimepicker1').datepicker({
		setDate : new Date(),
		format : 'dd/mm/yyyy',
		autoclose : true,
		language : 'es',
		todayHighlight : true
	});
}

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

//----------- consulta si está en la seccion de reportes o en la seccion de lineas internas
function seleccion(){ 
	if($('.lineas_internas').is(":visible")){
		$("#cuentas").prop("checked", true); 
		lineas_consulta();
	}
	else{
		sendSolicitud();
	}	
}

function changeWeek(){ 
	$('#menu_mes').hide('fade');
	$('#menu_semana').show();
}

function changeMonth(){ 
	$('#menu_semana').hide('fade');
	$('#menu_mes').show();
}

function hideGraf(){ 
	$('#miGrafica').hide('fade');
	
}


function sendSolicitud(){
//	console.log("sendSolicitud()"); //
	back(); // reset el menu
	clearjQueryCache();	
	$("#fechaReporteTabla").remove();
	
	//console.log("sendSolicitud: " + $('#fechaReporteTabla').val())
	
	$('#divReport').hide('fade');
	$('.oculto').hide('fade');
	
	$('#implementacionTfe_boton').show('fade'); // xxx
	$('#internas_boton').show('fade');
	$('#lineas_internas').hide('fade');
	
	if($('#fecha').val() != ""){
		$.ajax({
			url : 'getCtasActBRMvsU2000',
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
					$('#implementacionTfDiv').hide('fade');// xxx
					$('.contentMessage').hide('fade');
					$('.lineas_ocultas').hide('fade');
					$('.contentReporte').show('fade');
					
					$('.implementacionTfe_boton').show('fade');
					$('.internas_boton').show('fade');

					$('#descargaArchivo').show();
					$('.fechaEt').text($('#fecha').val());
					$('#fechaReporte').val($('#fecha').val());
					
					$('#fecFiltro').append('<input type="hidden" id="fechaReporteTabla" name="fechaReporteTabla" value="">');
					$('#fechaReporteTabla').val($('#fecha').val());
					
					// ivans
			    	$('#tableModal').bootstrapTable('destroy');
			    	$('.tituloTabla').text('');
			    	$('#NoData').text('');
			    	
					setCtasActBRMvsU2000(jsonResponse.result);
					
				}else{
					$('.dateFail').text($('#fecha').val());
					$('#errorModal').modal();
					$('.contentMessage').show('fade');
					$('.contentReporte').hide('fade');

					limpiaCampos();
					//$('#errorMessagge').show();
					$('#descargaArchivo').hide();
					//$(".modal").hide();	

				}
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
				$('.dateFail').text($('#fecha').val());
				$('#errorModal').modal();
			}
		});
	}
	//console.log("fechaReporteTabla: " + $('#fechaReporteTabla').val());
}
function setCtasActBRMvsU2000(result){
	$('#grafica').show('fade');
	$('#graficaTP').text(''); //-- inicializar bacio
	$('#graficaEnlace').text(''); //-- inicializar bacio
	$('#graficaTFE').text(''); //-- inicializar bacio
	$('#graficaALL').text(''); //-- inicializar bacio
	var botones = '';
	var total = 0;
	var t_conciliados  = 0;
	var porcentajeConc = 0;
	var t_no_conciliados = 0;
	var porcentajeNoConc = 0;
	var error_brm = 0;
	var error_u2000 = 0;
	var total_brm = 0;
	var porcentajeerrorbrm = 0;
	var total_u2000 = 0;
	var porcentajeerroru2000 = 0;

	limpiaCampos();
	
	$.each(result, function(index, valores){ 
		
		total += parseInt(valores.total);
		t_conciliados += parseInt(valores.t_conciliados);
		t_no_conciliados  += parseInt(valores.error_total);
		error_brm += parseInt(valores.error_brm);
		error_u2000 += parseInt(valores.error_u2000);
		total_brm += parseInt(valores.no_brm);
		total_u2000 += parseInt(valores.no_u2000);
//---------------------------------------------------------------------------------------- TOTALPLAY -----------------------------------------------------------------------------
		if(valores.empresa == 'TOTALPLAY'){
			$('.statusConcTP').text("Conciliado");
			$('.t_conciliadosTP').text(accounting.formatNumber(valores.t_conciliados));
			$('.porcentajeConcTP').text(valores.porcentajeconc + '%');
			
			$('.statusNoConcTP').text("No Conciliado");
			$('.t_no_conciliadosTP').text(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcTP').text(valores.porcentajenoconc + '%');
			
			$('.error_brmTP').text(accounting.formatNumber(valores.error_brm));
			$('.error_u2000TP').text(accounting.formatNumber(valores.error_u2000));
			
			$('.porcentajeerrorbrmTP').text(valores.porcentajeerrorbrm+ '%');
			$('.porcentajeerroru2000TP').text(valores.porcentajeerroru2000+ '%');

			$('.totalBRMTP').text(accounting.formatNumber(valores.no_brm));
			$('.totalU2000TP').text(accounting.formatNumber(valores.no_u2000));
			$('.totalTP').text(accounting.formatNumber(valores.total));	
		

			if(valores.status == "SI" ){
				$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}else{
				$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}
			
			if(valores.porcentajeerrorbrm ==100){
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
//			}else if(valores.porcentajeerrorbrm <99 && valores.porcentajeerrorbrm >=75){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else {
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			$('.bcolorBRMTP').html(botones);
			
			if(valores.porcentajeerroru2000 ==100){
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
//			}else if(valores.porcentajeerroru2000 >= 1 && valores.porcentajeerroru2000 < 26 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			$('.bcolorU2000TP').html(botones);
//---------   GRAFICA  TOTALPLAY -----	
			var gTP;
			 gTP= new JustGage({
				    id:"graficaTP",
				    //label: "label",
//				    title: "TOTAL",
//				    titleFontColor: "#4c56de", // color azul
//				    titleFontFamily: "Georgia",
//			        titlePosition: "up",
				    value: valores.porcentajeconc,
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
			
			
//---------------------------------------------------------------------------------------- ENLACE -----------------------------------------------------------------------------			
			
		} else if(valores.empresa == 'ENLACE'){
			$('.statusConcENL').text("Conciliado");
			$('.t_conciliadosENL').text(accounting.formatNumber(valores.t_conciliados));
			$('.porcentajeConcENL').text(valores.porcentajeconc + '%');
			
			$('.statusNoConcENL').text("No Conciliado");
			$('.t_no_conciliadosENL').text(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcENL').text(valores.porcentajenoconc + '%');
			
			$('.error_brmENL').text(accounting.formatNumber(valores.error_brm));
			$('.error_u2000ENL').text(accounting.formatNumber(valores.error_u2000));
			
			$('.porcentajeerrorbrmENL').text(valores.porcentajeerrorbrm+ '%');
			$('.porcentajeerroru2000ENL').text(valores.porcentajeerroru2000+ '%');

			$('.totalBRMENL').text(accounting.formatNumber(valores.no_brm));
			$('.totalU2000ENL').text(accounting.formatNumber(valores.no_u2000));
			$('.totalENL').text(accounting.formatNumber(valores.total));
			
			if(valores.status == "SI"  ){
				$('.decisionENL').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}else{
				$('.decisionENL').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}
			if(valores.porcentajeerrorbrm ==100){
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
//			}else if(valores.porcentajeerrorbrm <99 && valores.porcentajeerrorbrm >=75){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			$('.bcolorBRMENL').html(botones);
			
			if(valores.porcentajeerroru2000 ==100){
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
//			}else if(valores.porcentajeerroru2000 >= 1 && valores.porcentajeerroru2000 <26 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			
//---------   GRAFICA  ENLACE -----	
			var gENLACE;
			 gENLACE= new JustGage({
				    id:"graficaEnlace",
				    //label: "label",
//				    title: "TOTAL",
//				    titleFontColor: "#4c56de", // color azul
//				    titleFontFamily: "Georgia",
//			        titlePosition: "up",
				    value: valores.porcentajeconc,
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
			$('.bcolorU2000ENL').html(botones);
//---------------------------------------------------------------------------------------- TFE -----------------------------------------------------------------------------			
		} else if(valores.empresa == 'TFE'){
			$('.statusConcTFE').text("Conciliado");
			$('.t_conciliadosTFE').text(accounting.formatNumber(valores.t_conciliados));
			$('.porcentajeConcTFE').text(valores.porcentajeconc + '%');
			
			$('.statusNoConcTFE').text("No Conciliado");
			$('.t_no_conciliadosTFE').text(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcTFE').text(valores.porcentajenoconc + '%');
			
			$('.error_brmTFE').text(accounting.formatNumber(valores.error_brm));
			$('.error_u2000TFE').text(accounting.formatNumber(valores.error_u2000));
			
			$('.porcentajeerrorbrmTFE').text(valores.porcentajeerrorbrm+ '%');
			$('.porcentajeerroru2000TFE').text(valores.porcentajeerroru2000+ '%');

			$('.totalBRMTFE').text(accounting.formatNumber(valores.no_brm));
			$('.totalU2000TFE').text(accounting.formatNumber(valores.no_u2000));
			$('.totalTFE').text(accounting.formatNumber(valores.total));
			
			if(valores.status == "SI"  ){
				$('.decisionTFE').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}else{
				$('.decisionTFE').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}
			
			if(valores.porcentajeerrorbrm ==100){
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
//			}else if(valores.porcentajeerrorbrm <99 && valores.porcentajeerrorbrm >=75){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			$('.bcolorBRMTFE').html(botones);
			
			if(valores.porcentajeerroru2000 ==100){
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
//			}else if(valores.porcentajeerroru2000 >= 1 && valores.porcentajeerroru2000 < 26 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="20" class="img-responsive" alt="Responsive image">';
			}else{
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			
			
//---------   GRAFICA  TFE -----	
			var gTFE;
			 gTFE= new JustGage({
				    id:"graficaTFE",
				    //label: "label",
//				    title: "TOTAL",
//				    titleFontColor: "#4c56de", // color azul
//				    titleFontFamily: "Georgia",
//			        titlePosition: "up",
				    value: valores.porcentajeconc,
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
			$('.bcolorU2000TFE').html(botones);
		}
	});
	
	$('.statusConcT').text("Conciliado");
	$('.t_conciliadosT').text(accounting.formatNumber(t_conciliados));
	porcentajeConc = (total>0)?((t_conciliados * 100)/total):0;
//	if(total>0){
//		porcentajeConc = (t_conciliados * 100)/total;
//	}else{
//		porcentajeConc=0;	
//	}
	$('.porcentajeConcT').text(accounting.toFixed(porcentajeConc,2) + '%');
	$('.statusNoConcT').text("No Conciliado");
	$('.t_no_conciliadosT').text(accounting.formatNumber(t_no_conciliados));
	
	porcentajeNoConc = (total>0)?((t_no_conciliados * 100)/total):0;
//	if(total>0){
//		porcentajeNoConc = (t_no_conciliados * 100)/total;
//	}else{
//		porcentajeNoConc = 0;
//	}
	$('.porcentajeNoConcT').text(accounting.toFixed(porcentajeNoConc,2) + '%');
	$('.error_brmT').text(accounting.formatNumber(error_brm));
	$('.error_u2000T').text(accounting.formatNumber(error_u2000));
	porcentajeerrorbrm = (total>0)?((error_brm * 100)/total):0;
//	if(total_brm>0){
//		porcentajeerrorbrm = (error_brm * 100)/total_brm;
//	}else{
//		porcentajeerrorbrm=0;
//	}
	$('.porcentajeerrorbrmT').text(accounting.toFixed(porcentajeerrorbrm,2)+ '%');
	
	porcentajeerroru2000 = (total>0)?((error_u2000 * 100)/total):0;
//	if(total_u2000>0){
//		porcentajeerroru2000 = (error_u2000 * 100)/total_u2000;
//	}else{
//		porcentajeerroru2000 =0;
//	}
	$('.porcentajeerroru2000T').text(accounting.toFixed(porcentajeerroru2000,2)+ '%');
	$('.totalBRMT').text(accounting.formatNumber(total_brm));
	$('.totalU2000T').text(accounting.formatNumber(total_u2000));
	$('.totalT').text(accounting.formatNumber(total));
	//---------   GRAFICA  TOTAL TODO -----	
	var gALL;
	 gALL= new JustGage({
		    id:"graficaALL",
		    //label: "label",
//		    title: "TOTAL",
//		    titleFontColor: "#4c56de", // color azul
//		    titleFontFamily: "Georgia",
//	        titlePosition: "up",
		    value: porcentajeConc,
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
	
	//---------------------------------------------------------------------------------------- TOTAL -----------------------------------------------------------------------------	
	if(porcentajeConc == 100 ){
		$('.decisionT').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	}else{
		$('.decisionT').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	}

	if(porcentajeerrorbrm ==100){
		botones = '<img src="/CifrasControl/img/green.png" >';
//	}else if(porcentajeerrorbrm <99 && porcentajeerrorbrm >=75 ){
//		botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
	}else if(porcentajeerrorbrm <100 ){
		botones = '<img src="/CifrasControl/img/red.png" >';
	}
	$('.bcolorBRMT').html(botones);
	
	if(porcentajeerroru2000 ==100){
		botones = '<img src="/CifrasControl/img/green.png" >';
//	}else if(porcentajeerroru2000 > 1 && porcentajeerroru2000 <26){
//		botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
	}else if(porcentajeerroru2000 <100 ){
		botones = '<img src="/CifrasControl/img/red.png" >';
	}


	$('.bcolorU2000T').html(botones);
}

function limpiaCampos(){
		
		$('.decision').html("");
	
		$('.statusConcTP').text("Conciliado");
		$('.t_conciliadosTP').text('-');
		$('.porcentajeConcTP').text('0%');
		
		$('.statusNoConcTP').text("No Conciliado");
		$('.t_no_conciliadosTP').text('-');
		$('.porcentajeNoConcTP').text('0%');
		
		$('.error_brmTP').text('');
		$('.error_u2000TP').text('');
		
		$('.porcentajeerrorbrmTP').text('0%');
		$('.porcentajeerroru2000TP').text('0%');

		$('.totalBRMTP').text('');
		$('.totalU2000TP').text('');
		$('.totalTP').text('');	
	
		$('.statusConcENL').text("Conciliado");
		$('.t_conciliadosENL').text('-');
		$('.porcentajeConcENL').text('0%');
		
		$('.statusNoConcENL').text("No Conciliado");
		$('.t_no_conciliadosENL').text('-');
		$('.porcentajeNoConcENL').text('0%');
		
		$('.error_brmENL').text('');
		$('.error_u2000ENL').text('');
		
		$('.porcentajeerrorbrmENL').text('0%');
		$('.porcentajeerroru2000ENL').text('0%');

		$('.totalBRMENL').text('');
		$('.totalU2000ENL').text('');
		$('.totalENL').text('');
		
		$('.statusConcTFE').text("Conciliado");
		$('.t_conciliadosTFE').text('-');
		$('.porcentajeConcTFE').text('0%');
		
		$('.statusNoConcTFE').text("No Conciliado");
		$('.t_no_conciliadosTFE').text('-');
		$('.porcentajeNoConcTFE').text('0%');
		
		$('.error_brmTFE').text('');
		$('.error_u2000TFE').text('');
		
		$('.porcentajeerrorbrmTFE').text('0%');
		$('.porcentajeerroru2000TFE').text('0%');

		$('.totalBRMTFE').text('');
		$('.totalU2000TFE').text('');
		$('.totalTFE').text('');	

		$('.statusConcT').text("Conciliado");
		$('.t_conciliadosT').text('-');
		$('.porcentajeConcT').text('0%');
		
		$('.statusNoConcT').text("No Conciliado");
		$('.t_no_conciliadosT').text('-');
		$('.porcentajeNoConcT').text('0%');
		
		$('.error_brmT').text('');
		$('.error_u2000T').text('');
		
		$('.porcentajeerrorbrmT').text('0%');
		$('.porcentajeerroru2000T').text('0%');
		
		$('.totalBRMT').text('');
		$('.totalU2000T').text('');
		$('.totalT').text('');
}
$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });

//******************* SECCION DE LINEAS INTERNAS **********************//
//******************* TABLA PRINCIPALES **********************//

$('#confmodal').on('hide.bs.modal', function () {
	console.log("entro confmodal");
	lineas_consulta();
	 });
$('#confmodal_eliminarTodo').on('hide.bs.modal', function () {
	lineas_consulta();
	 });
$('#modal_archivo').on('hide.bs.modal', function () {
	console.log("entro modal_archivo");
	lineas_consulta();
	 });

function lineas_internas(){
	$('#implementacionTfDiv').hide('fade'); // xxx
	
	$('.contentMessage').hide('fade');
	$('.contentReporte').hide('fade');
	$('.lineas_internas').show('fade');
	$('#internas_boton').hide('fade');
	$("#SN").prop("checked", false); 
	$("#cuentas").prop("checked", true); 
	
	
	$('.implementacionTfe_boton').hide('fade');
	
	lineas_consulta();
	
}
function reporte_botonf(){
	sendSolicitud();
	$('#implementacionTfDiv').hide('fade'); //xxx
	$('.lineas_internas').hide('fade');
	$('#internas_boton').show('fade');
	
}

function lineas_consulta() {
	
	if ($('#check_todo').is(":checked"))
	todos=1;
	else
	todos=0;
	
	if(document.getElementById("cuentas").checked){
	opcion=1;
	url='Cuentas_CtasActBRMvsU2000LO';	
	}
	if(document.getElementById("SN").checked){
	opcion=2;
	url='SN_CtasActBRMvsU2000LO';
	}
	
	$.ajax({
		url : url,
		type : "POST",
		data : {
			'fecha' : $('#fecha').val(),
			'todos'	:todos
				},
		dataType : "json",
		beforeSend: function( xhr ) {
			 $('#loadModal').modal();
		 },
		success : function(jsonResponse, textStatus, jqXHR){
			$('#loadModal').modal('hide');

			if(jsonResponse.success){
			console.log(jsonResponse);
			
			$('.insertar_boton').show('fade');
			$('.eliminar_boton').show('fade');
			
			if(opcion==1)
				contruyeCuentas(jsonResponse);
			if(opcion==2)
				contruyeSN(jsonResponse);
			
				
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
	
function contruyeCuentas(jsonResponse){	
	
	$('#divReport').text('');
	var html, table, body = '';
	var header = '<table id="listaTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer  table-striped">' + '<THEAD>'
	+ '<tr>' 
	+ '<th><small>Cuenta</small></th>'
	+ '<th><small>Empresa</small></th>'
	+ '<th><small>Fecha</small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				html = '<tr onclick="tr_sel(this)"><td name="cuenta">';
				html = html + arrayValores.cuenta;
				html = html + '</td>';
				html = html + '<td name="empresa">';
				html = html + arrayValores.empresa;
				html = html + '</td>';
				html = html + '<td name="fecha">';
				html = html + arrayValores.fecha;
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

function contruyeSN(jsonResponse){	
	
	$('#divReport').text('');
	var html, table, body = '';
	var header = '<table id="listaTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer  table-striped">' + '<THEAD>'
	+ '<tr>' 
	+ '<th><small>SN</small></th>'
	+ '<th><small>Empresa</small></th>'
	+ '<th><small>Fecha</small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				html ='<tr  onclick="tr_sel(this)"><td name="sn">';
				html = html + arrayValores.sn;
				html = html + '</td>';
				html = html + '<td name="empresa">';
				html = html + arrayValores.empresa;
				html = html + '</td>';
				html = html + '<td name="fecha">';
				html = html + arrayValores.fecha;
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
	$('#divReport').show('fade');
}

//*********************************************************************//
//******************* BOTONES INSERTAR Y ELIMINAR**********************//

function elimina(){
	
	var lineas=new Array();
	 var table = $('#listaTable').DataTable();

	 table.rows('.selected').every( function ( rowIdx, tableLoop, rowLoop ) {			 
		 var rowNode = this.node();
		 json ="";
		 
		 $(rowNode).find("td").each(function (){
			 $this=$(this);
		      json+=',"'+$this.attr("name")+'":"'+$this.html()+'"';
     });
		   obj=JSON.parse('{'+json.substr(1)+'}');
		   lineas.push(obj);
		} );
//	 console.log(lineas);
	   
	   if(document.getElementById("cuentas").checked){
			opcion=1;
			url='getCtasActBRMvsU2000LI_eliminarCuentas';
			}
			if(document.getElementById("SN").checked){
			opcion=2;
			url='getCtasActBRMvsU2000LI_eliminarSN';
			}	
			
			json_string=JSON.stringify(lineas);
			$.ajax({
				url : url,
				type : "POST",
				traditional:true,
				//contentType: 'application/json',
				data : { 'json_string': json_string }
					,
				dataType : "json",
				beforeSend: function( xhr ) {
							 $('#loadModal').modal();
						 },
				success : function(response){
					$('#loadModal').modal('hide');
					if (response != null && response.success == true) {
						$('#btnYes').hide();
						$('#btnCancelar').hide();
						$('#msj_eliminar').text("Se han eliminado "+response.result+" registros");
					
					} else {
						$('#msj_eliminar').text(response.mensaje);
						
					}

				},
				error : function(xhr, ajaxOptions, thrownError) {
					console.log(response.mensaje);
					$('#loadModal').modal('hide');
		}
			});	
			
} 
function eliminaTodo(){
	
	   if(document.getElementById("cuentas").checked){
			opcion=1;
			url='getCtasActBRMvsU2000LI_eliminarTodoCuentas';
			}
			if(document.getElementById("SN").checked){
			opcion=2;
			url='getCtasActBRMvsU2000LI_eliminarTodoSN';
			}	
			
			$.ajax({
				url : url,
				type : "POST",
				traditional:true,
				dataType : "json",
				beforeSend: function( xhr ) {
							 $('#loadModal').modal();
						 },
				success : function(response){
					$('#loadModal').modal('hide');
					
						$('#btnYesTodo').hide();
						$('#btnCancelarTodo').hide();
						$('#msj_eliminarTodo').text("Se han eliminado "+response.result+" registros");
						
					
				},
				error : function(xhr, ajaxOptions, thrownError) {
					$('#loadModal').modal('hide');
					$('#msj_eliminarTodo').text(response.mensaje);
		}
			});	
			
}

function tr_sel(valor){
	 $(valor).toggleClass('selected');
}

function eliminarbf(){
	$('#btnYes').show();
	$('#btnCancelar').show();
	
	var table = $('#listaTable').DataTable();
	console.log(table.rows('.selected').count()+"entra");
	var rows_selected= table.rows('.selected').count();
	
	if(rows_selected>0){
	$('#msj_eliminar').text('¿Está seguro de que desea eliminar los datos seleccionados?');
	 $('#confmodal').modal('show');
}
} 

function eliminarTodo(){
	$('#btnYesTodo').show();
	$('#btnCancelarTodo').show();
	
	$('#msj_eliminarTodo').text('¿Está seguro? Se borrarán TODOS los datos de la tabla');
	 $('#confmodal_eliminarTodo').modal('show');

} 

//******************* SECCION DE MODAL **********************//
//******************* CARGAR EXCEL **********************//
function insertarb(){
	
	 $('#respuesta').text('');
	 $('#sfile').val('');
	 $('.cargar_documento').show();
	 $('.cargar_exitoso').hide();
	 $('#modal_archivo').modal('show');
	 $('#previo').text('');
	
	 
} 
function bcargaf(){
//	console.log("bcargaf()");
	if($('#sfile').val()=='')
		$('#previo').text('');
	
	var formData = new FormData();
	formData.append('myFile', $('#sfile')[0].files[0]);
	console.log("---$$$$$$$$$$$$ ---"+formData);
	if(document.getElementById("cuentas").checked){
		opcion=1;
		url='ctasActBRMvsU2000LOCtas_Excel';	
		}
		if(document.getElementById("SN").checked){
		opcion=2;
		url='ctasActBRMvsU2000LOSN_Excel';
		}
	
	$.ajax({
			url : url,
			type : "POST",
			data : formData,
			dataType : "json",
			processData: false,
			contentType: false,
			beforeSend: function( xhr ) {
						 $('#loadModal').modal();
					 },
			success : function(jsonResponse, textStatus, jqXHR){
				
				if(jsonResponse.success){
					if(jsonResponse.result.length > 0){
						
						if(opcion==1)
						contruyeInsertarCtas(jsonResponse);
						if(opcion==2)
							contruyeInsertarSN(jsonResponse);
					}
				}else{
					$('#previo').text('');
					$('#previo').append('<p style="color:red;">Archivo incorrecto, favor de verificar</p>');
				}
				$('#loadModal').modal('hide');
					},
					error : function(jqXHR, textStatus, errorThrown){
						console.log(textStatus);
						$('#loadModal').modal('hide');

					}
		 });
}

function contruyeInsertarCtas(jsonResponse){
//	console.log("contruyeInsertarCtas(jsonResponse)");
	$('#previo').text('');
	var html, table, body = '';
	var header = '<table id="listaPrevia" class="table table-condensed table-hover table-responsive datatable dataTable no-footer  table-striped">' + '<THEAD>'
	+ '<tr >' 
	+ '<th><small>Cuenta</small></th>'
	+ '<th><small>Empresa</small></th>'
	+ '<th><small>Fecha</small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				html = '<tr onclick="tr_sel(this)"><td name="cuenta">';
				html = html + arrayValores.cuenta;
				html = html + '</a></td>';
				html = html + '<td name="empresa">';
				html = html + arrayValores.empresa;
				html = html + '</td>';
				html = html + '<td name="fecha">';
				html = html + arrayValores.fecha;
				html = html + '</td>';
				html = html + '</tr>';
				body = body + html;
			});
	
	table = header + body + footer;
	$(table).appendTo('.previo');
	$('#listaPrevia').dataTable({
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
	$('#listaPrevia_filter').text('');
	$('#listaPrevia_length').text('');
	
}

function contruyeInsertarSN(jsonResponse){
	
	$('#previo').text('');
	var html, table, body = '';
	var header = '<table id="listaPrevia" class="table table-condensed table-hover table-responsive datatable dataTable no-footer  table-striped">' + '<THEAD>'
	+ '<tr>' 
	+ '<th><small>SN</small></th>'
	+ '<th><small>Empresa</small></th>'
	+ '<th><small>Fecha</small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				html = '<tr onclick="tr_sel(this)"><td name="sn">';
				html = html + arrayValores.sn;
				html = html + '</a></td>';
				html = html + '<td name="empresa">';
				html = html + arrayValores.empresa;
				html = html + '</td>';
				html = html + '<td name="fecha">';
				html = html + arrayValores.fecha;
				html = html + '</td>';
				html = html + '</tr>';
				body = body + html;
			});
	
	table = header + body + footer;
	$(table).appendTo('.previo');
	$('#listaPrevia').dataTable({
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
	$('#listaPrevia_filter').text('');
	$('#listaPrevia_length').text('');
}
//*************************INSERCCION EN LA BASE DE DATOS DESDE EXCEL*******************************
//**************************************************************************************************

function inserta_excel(){
	//console.log("inserta_excel()");
	if($('#sfile').val()!=''){	
		
		var lineas=new Array();
		 var table = $('#listaPrevia').DataTable();
	
		 table.rows().every( function ( rowIdx, tableLoop, rowLoop ) {			 
			 var rowNode = this.node();
			 json ="";
			 
			 $(rowNode).find("td").each(function (){
				 $this=$(this);
			      json+=',"'+$this.attr("name")+'":"'+$this.html()+'"';
         });
			   obj=JSON.parse('{'+json.substr(1)+'}');
			   lineas.push(obj);
			} );
	//	 console.log(lineas);
			
	if(document.getElementById("cuentas").checked){
		opcion=1;
		url='getCtasActBRMvsU2000LI_insertarCuentas';
		}
		if(document.getElementById("SN").checked){
		opcion=2;
		url='getCtasActBRMvsU2000LI_insertarSN';
		}	
		
		json_string=JSON.stringify(lineas);
		
	$.ajax({
		url : url,
		type : "POST",
		traditional:true,
		//contentType: 'application/json',
		data : { 'json_string': json_string }
			,
		dataType : "json",
		beforeSend: function( xhr ) {
					 $('#loadModal').modal();
					 console.log("se esta enviando");
				 },
		success : function(response){
			$('#loadModal').modal('hide');
			if (response != null && response.success == true) {
				console.log(response.mensaje+"exitoso");
				$('.cargar_documento').hide('fade');
				$('#respuesta').text(response.mensaje);
			
			} else {
				console.log(response.mensaje+"erroneo");
				$('.cargar_documento').hide('fade');
				$('#respuesta').text(response.mensaje);
			}
		},
		error : function(xhr, ajaxOptions, thrownError) {
			console.log("envio fallido");
			$('#loadModal').modal('hide');
}
	});
	}
}

// -- FUNCION OBTENER #SEMANA, #MES  Y AÑO ----
function selectactualG() {
	
	$.ajax({
		url : 'getFechaActual',
		type : "POST",
		dataType : "json",
		async: false,
		success : function(jsonResponse, textStatus, jqXHR){				
			if(jsonResponse.success){
				$.each(jsonResponse.result,function(index, arrayValores) {
				$('#grafica').text('');
				 semanaactual=arrayValores.fecha_semana;	
				 mesactual=arrayValores.fecha_mes;
				 anioactual=arrayValores.fecha_anio;
//				 console.log("mes actual :-> "+mesactual);
				});
			}},
		error : function(jqXHR, textStatus, errorThrown){
		}
			});
//	console.log("semana actual -> "+semanaactual);
    for(var i=1;i<=53;i++){
    if(i==semanaactual){
    	 $("#selectsem").append('<option value="'+i+'" selected="'+i+'">'+i+'</option>');
    } else{
    	 $("#selectsem").append('<option value="'+i+'">'+i+'</option>');
    	}
    } 
//    console.log("mes actual -> "+mesactual);
//    var mesD=12;
    var arrM=["Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"];
    for(var j=0;j<arrM.length;j++){
		   if(j==mesactual-1){
//			   console.log("meses------> "+j+ arrM[j]);
			   $("#selectMes").append('<option value="'+arrM[j]+'" selected="'+arrM[j]+'">'+arrM[j]+'</option>');
		    } 
		   else{
		    	  $("#selectMes").append('<option value="'+arrM[j]+'">'+arrM[j]+'</option>');
		    	}
	   }
//    console.log("año actual -> "+anioactual);
    var arr=["2017","2018"];
	   for(var i=0;i<arr.length;i++){
		   if(arr[i]==anioactual){
			   $("#selectanio").append('<option value="'+arr[i]+'" selected="'+arr[i]+'">'+arr[i]+'</option>');
		    	
		    } else{
		    	  $("#selectanio").append('<option value="'+arr[i]+'">'+arr[i]+'</option>');
		    	}
	   }  
//	   sendSolicitud();
}

// -------------------CONSULTA DATOS POR SEMANA PARA GRAFICA LINEAL ----------
function setEvalSema(){
	$('#graficaG').remove(); // this is my <canvas> element
	$('#miGrafica').append('<canvas id="graficaG"><canvas>');
	
	$('#miGrafica').show('fade');
	if($('#selectsem').val() != "" &&  $('#selectanio').val() != ""){
		console.log("valor de semana es ---> "+$('#selectsem').val());
		console.log("valor de anio  es ---> "+$('#selectanio').val());
		$.ajax({
		url : 'getDatosGrafica',
		type : 'POST',
		data : {
			'semana' : $('#selectsem').val(),
			'anio'	 : $('#selectanio').val()
			},
		dataType : "json",
		beforeSend: function( xhr ) {
			 $('#loadModal').modal();
		 },
		success : function(jsonResponse, textStatus, jqXHR){
			$('#loadModal').modal('hide');
			if(jsonResponse.success){
				console.log(jsonResponse);
				if(jsonResponse.result.length > 0){
					console.log("-># consulta de semana ok..");
					construyeReporteSemana(jsonResponse);
					$('#graficaG').text('');
					$('#graficaG').show('fade');
				}else{
					$('#errorModal').modal();
					console.log("-># consulta de semana sin datos");
					$('#graficaG').hide('fade');
				}
			}
		},
	});
	}
}
// -------------------CONSULTA DATOS POR MES PARA GRAFICA LINEAL ----------
function setEvalMes (){
	$('#graficaG').text('');
	$('#miGrafica').show('fade');
	
	$('#graficaG').remove(); // this is my <canvas> element
	$('#miGrafica').append('<canvas id="graficaG"><canvas>');
	var mesNumero=0;
	if($('#selectMes').val()=="Enero"){
//		console.log(mesNumero);
		mesNumero = "1";
	}if($('#selectMes').val()=="Febrero"){
		mesNumero = "2";
	}if($('#selectMes').val()=="Marzo"){
		mesNumero = "3";
	}if($('#selectMes').val()=="Abril"){
		mesNumero = "4";
	}if($('#selectMes').val()=="Mayo"){
		mesNumero = "5";
	}if($('#selectMes').val()=="Junio"){
		mesNumero = "6";
	}if($('#selectMes').val()=="Julio"){
		mesNumero = "7";
	}if($('#selectMes').val()=="Agosto"){
		mesNumero = "8";
	}if($('#selectMes').val()=="Septiembre"){
		mesNumero = "9";
	}if($('#selectMes').val()=="Octubre"){
		mesNumero = "10";
	}if($('#selectMes').val()=="Noviembre"){
		mesNumero = "11";
	}if($('#selectMes').val()=="Diciembre"){
		mesNumero = "12";
	}
	
	console.log("valor del mes es---> "+$('#selectMes').val());
	console.log("numero de mes es--->"+mesNumero);
	console.log("valor de anio es---> "+$('#selectanio').val());
	
	
	
	if( mesNumero != "" &&  $('#selectanio').val() != ""){
		$.ajax({
		url : 'getDatosGraficaMes',
		type : 'POST',
		data : {
			'mes' : mesNumero,
			'anio'	 : $('#selectanio').val()
			},
		dataType : "json",
		beforeSend: function( xhr ) {
			 $('#loadModal').modal();
		 },
		success : function(jsonResponse, textStatus, jqXHR){
			$('#loadModal').modal('hide');
			if(jsonResponse.success){
				console.log(jsonResponse);
				if(jsonResponse.result.length > 0){
					console.log("-># consulta por mes ok...");
					construyeReporteMes(jsonResponse);
					$('#graficaG').text('');
					$('#graficaG').show('fade');
				}else{
					console.log("-># consulta por mes sin datos");
					$('#errorModal').modal();
					$('#graficaG').hide('fade');
					
					
				}
			}
		},
	});
	}
}
//-- DATOS POR SEMANA 
function construyeReporteSemana(jsonResponse) {
	var arrTp = new Array();
	var arrEnl = new Array();
	var arrTfe = new Array();
	
	var total=0;
	var t_conciliados=0;
	var totalTp=0;
	var totalEnl=0;
	var totalTfe=0;
	
	$.each(
		jsonResponse.result,
		function(index, arrayValores) {
			total += parseInt(arrayValores.total);
			t_conciliados += arrayValores.t_conciliados;
			if (arrayValores.empresa == 'TOTALPLAY') {
				totalTp = Math.round((total>0)?((t_conciliados*100)/total):0);
//				console.log("valores de totalplay -->"+totalTp);
				if(totalTp>0 && totalTp!=''){
				arrTp.push(totalTp);			
				}
			}
			if (arrayValores.empresa == 'ENLACE') {
				  totalEnl = Math.round((total>0)?((t_conciliados * 100)/total):0);
//				console.log("valores enlace--> ## "+totalEnl);
					if(totalEnl>0 && totalEnl!=''){
					arrEnl.push(totalEnl);			
					}
			}
			if (arrayValores.empresa == 'TFE') {
				totalTfe = Math.round((total>0)?((t_conciliados * 100)/total):0);
//				console.log("valores tfe--> ## "+totalTfe);
				if(totalTfe>0 && totalTfe!=''){
				arrTfe.push(totalTfe);			
				}
			}
		});
	
//	llamado a graficas 	
		modelo1(arrTp,arrEnl,arrTfe);
		
}
//-- DATOS POR MES
function construyeReporteMes(jsonResponse) {
	var arrTp_mes = new Array();
	var arrEnl_mes = new Array();
	var arrTfe_mes = new Array();
	var diasTp_mes = new Array();
	
	
//	console.log("inicio de limpieza");
//	arrTp_mes.length=0;
//	arrEnl_mes.length=0;
//	arrTfe_mes.length=0;
//	diasTp_mes.length=0;
	
	
	var total_mes = 0;
	var t_conciliados_mes  = 0;
	var totalTp_mes=0;
	var totalEnl_mes=0;
	var totalTfe_mes=0;
	var dias = 0;
	
	$.each(
		jsonResponse.result,
		function(index, arrayValores) {
			total_mes += parseInt(arrayValores.total);
			t_conciliados_mes += parseInt(arrayValores.t_conciliados);
//			console.log("total_mes---># "+total_mes);
			if (arrayValores.empresa == 'TOTALPLAY') {
				totalTp_mes = Math.round((total_mes>0)?((t_conciliados_mes*100)/total_mes):0);
//				console.log("valores de totalplay -->"+totalTp);
				if(totalTp_mes>0 && totalTp_mes!=''){
				arrTp_mes.push(totalTp_mes);			
				}
				//let date = new Date( Date.parse(arrayValores.fecha) );
				//diasTp_mes.push(dateFormat(arrayValores.fecha , "d, m, yy"));
				//var formatted = $.datepicker.formatDate("M d, yy", new Date(arrayValores.fecha));
				var date = new Date(arrayValores.fecha);
				var mifecha = date.getDate()  + '/' + (date.getMonth() + 1) + '/' +  date.getFullYear()
				diasTp_mes.push(mifecha);
			}
			if (arrayValores.empresa == 'ENLACE') {
				totalEnl_mes = Math.round((total_mes>0)?((t_conciliados_mes * 100)/total_mes):0);
//				console.log("valores enlace--> ## "+totalEnl);
				if(totalEnl_mes>0 && totalEnl_mes!=''){
					arrEnl_mes.push(totalEnl_mes);			
				}
				
			}
			if (arrayValores.empresa == 'TFE') {
				totalTfe_mes = Math.round((total_mes>0)?((t_conciliados_mes * 100)/total_mes):0);
//				console.log("valores tfe--> ## "+totalTfe);
				if(totalTfe_mes>0 && totalTfe_mes!=''){
					arrTfe_mes.push(totalTfe_mes);			
				}
				
			}
		});
//	console.log("arreglo mes totalplay--------> "+arrTp_mes);
//	console.log("arreglo mes enlace--------> "+arrEnl_mes);
//	console.log("arreglo mes tfe--------> "+arrTfe_mes);
//	console.log("arreglo mes diasTp_mes--------> "+diasTp_mes);
//	llamado a graficas 	
	modeloMes(arrTp_mes,arrEnl_mes,arrTfe_mes, diasTp_mes);
	
}

function modelo1(arr1,arr2,arr3){
	var entrada1 = new Array();
	var entrada2 = new Array();
	var entrada3 = new Array();
//	entrada1.length=0;
//	entrada2.length=0;
//	entrada3.length=0;
	entrada1=arr1;
	entrada2=arr2;
	entrada3=arr3;
//	comentarios de salida
	console.log("datos a evaluar");
	console.log("modeloTp ----------->"+entrada1);
	console.log("modeloEnl ----------->"+entrada2);
	console.log("modeloTfe ----------->"+entrada3);
	var config = {
            type: 'line',
            data: {
                labels: ["Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"],
                datasets: [{
                    label: "TOTALPLAY",		                     /* etiqueta */
                    borderColor: "blue",       /* color de linea */
                    backgroundColor: "blue",    /* fondo */
                    data: entrada1,	             /* datos */
                    fill: false,			                         /* relleno de fondo */
                }, {
                    label: "ENLACE",
                    backgroundColor:"green",
                    borderColor: "green",
                    data: entrada2,
                    fill: false,
                },
                {
                    label: "TFE",
                    backgroundColor: "orange",
                    borderColor: "orange",
                    data: entrada3,
                    fill: false,
                }]
            },
            options: {
                responsive: true,
                title:{
                    display:true,
                    text:'Detalle Semanal de Produccion'
                },
                tooltips: {
                	mode: 'index',
                    intersect: false, 	
                },
                hover: {
                	mode: 'nearest',
                    intersect: true
                	},
                scales: {
                    xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Valoracion %'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Monitoreo'
                        },
                        ticks: {
                            fontFamily: "Montserrat",
                            reverse : false,
                            min: 0,
                            max: 100,
                        },
                    }]
                }
            }
        };
	
     var ctx = document.getElementById("graficaG").getContext("2d");
     window.myLine = new Chart(ctx, config);
}


function modeloMes(arr1,arr2,arr3, arr4){
	var entrada1 = new Array();
	var entrada2 = new Array();
	var entrada3 = new Array();
	entrada1=arr1;
	entrada2=arr2;
	entrada3=arr3;
	
	console.log('datos a evaluar ');
	console.log("modeloTpMes ----------->"+entrada1);
	console.log("modeloEnlMes ----------->"+entrada2);
	console.log("modeloTfeMes ----------->"+entrada3);
	console.log("fechasMes ----------->"+arr4);
	
	
	var config = {
            type: 'line',
            data: {
                labels: arr4,
                datasets: [{
                    label: "TOTALPLAY",		                     /* etiqueta */
                    borderColor: "blue",       /* color de linea */
                    backgroundColor: "blue",    /* fondo */
                    data: entrada1,	             /* datos */
                    fill: false,			                         /* relleno de fondo */
                }, {
                    label: "ENLACE",
                    backgroundColor:"green",
                    borderColor: "green",
                    data: entrada2,
                    fill: false,
                },
                {
                    label: "TFE",
                    backgroundColor: "orange",
                    borderColor: "orange",
                    data: entrada3,
                    fill: false,
                }]
            },
            options: {
                responsive: true,
                title:{
                    display:true,
                    text:'Detalle Mensual de Produccion'
                },
                tooltips: {
                	mode: 'index',
                    intersect: false, 	
                },
                hover: {
                	mode: 'nearest',
                    intersect: true
                	},
                scales: {
                    xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Valoracion %'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Monitoreo'
                        },
                        ticks: {
                            fontFamily: "Montserrat",
                            reverse : false,
                            min: 0,
                            max: 100,
                        },
                    }]
                }
            }
        };
	
     var ctx = document.getElementById("graficaG");
     window.myLine = new Chart(ctx, config);
}
//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
function getValor() {
//	console.log("BRM-SN vs U2000-ONT");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')|| (botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}

//----------------------------------------------------------- GRAFICA LINEAL -----------------------------------------------
$(document).ready(function(){
	  $("select[name=consulta]").change(function(){
	            if($('select[name=consulta]').val()=='Mes'){
//	              console.log("OPCION "+$('select[name=consulta]').val());
	              $('#menu_mes').show('fade');
	              $('#menu_semana').hide('fade');
	              $('#menu_anhio').show('fade');
	              $('#graficaLx').hide('fade');
	              
	            }
	            if($('select[name=consulta]').val()=='Semana'){
//	              console.log("OPCION "+$('select[name=consulta]').val());
	              $('#menu_mes').hide('fade');
	              $('#menu_semana').show('fade');
	              $('#menu_anhio').show('fade');
	              $('#graficaLx').hide('fade');
	            }
	            if($('select[name=consulta]').val()=='Opcion'){
//	              console.log("OPCION "+$('select[name=consulta]').val());
	              $('#menu_mes').hide('fade');
	              $('#menu_semana').hide('fade');
	              $('#menu_anhio').hide('fade');
	              $('#graficaLx').hide('fade');
	            }
	        });
	});

//--------------- GRAFICA POR SEMANA
function evalSema(){
	$('#NoDataX').text("");
//  console.log("Grafica por semana");
//  console.log($('#selectsem').val());
  
  if($('#selectsem').val() != "" &&  $('#selectanio').val() != ""){
//    console.log("valor de semana es--> "+$('#selectsem').val());
//    console.log("valor de anio es ---> "+$('#selectanio').val());
    $.ajax({
    url : 'getCtasActBRMvsU2000Semana',
    type : 'POST',
    async : true,
    data : {
      'semana' : $('#selectsem').val(),
      'anio'   : $('#selectanio').val()
      },
    dataType : "json",
    beforeSend: function( ) {
      $('#mensaje').show();
    },
    complete: function () {
      $('#mensaje').hide();
        },
    success : function(jsonResponse, textStatus, jqXHR){
      if(jsonResponse.success){
        if(jsonResponse.result.length > 0){
//          console.log("-># consulta de semana ok..");
          reporteSemana(jsonResponse);
        }else{
          $('#NoDataX').text("No se encontraron datos");
          $('#graficaLx').hide('fade');
        }
      }
    },
  });
  }
}
function reporteSemana(jsonResponse){
	var arrTp = [],arrEnlace = [],arrTfe = [],arrFechas = [];
		
	var total=0,t_conciliados=0;
	
	var totalTp=0,totalEnlace=0,totalTfe=0; 
	
	 $.each(jsonResponse.result,function(index, arrayValores) {
		arrFechas.push((arrayValores.fecha).toString().substring(0, 11));
		if (arrayValores.empresa=='TOTALPLAY') {
			 total = parseInt(arrayValores.total);
	      	 t_conciliados = arrayValores.t_conciliados;
	      	 totalTp =((total>0)?((t_conciliados*100)/total):0);
			if(totalTp>0 && totalTp!=''){
				arrTp.push(Math.round(totalTp));
			}
		}
		if (arrayValores.empresa=='ENLACE') {
			 total = parseInt(arrayValores.total);
	      	 t_conciliados = arrayValores.t_conciliados;
			 totalEnlace =(total>0)?((t_conciliados*100)/total):0;
			if(totalEnlace>0 && totalEnlace!=''){
				arrEnlace.push(Math.round(totalEnlace));
			}
		}
		if (arrayValores.empresa=='TFE') {
			 total = parseInt(arrayValores.total);
	      	 t_conciliados = arrayValores.t_conciliados;
			totalTfe =((total>0)?((t_conciliados*100)/total):0);
			if(totalTfe>0 && totalTfe!=''){
				arrTfe.push(Math.round(totalTfe));
			}
		}
       });
//	 console.log('ARRAY TOTALPLAY => '+arrTp);
//	 console.log('ARRAY ENLACE=====>'+arrEnlace);
//	 console.log('ARRAY TFE========>'+arrTfe);
// --------------- DIBUJA GRAFICA --------------------	 
	 $('#graficaLx').show();
	Highcharts.chart('graficaLx', {
				    chart: { zoomType: 'xy' },
				    title: { 
				    	text: '-- BALANCE GENERAL --',
				    	 margin: 20},
				    subtitle: { text: ''},
				    xAxis: [{
				        	categories: arrFechas,
				        	crosshair: true
				    }],
				    yAxis: [{ // Primary yAxis
				        labels: {
				            format: '{value}%',
				            style: { color: Highcharts.getOptions().colors[1] }
				        		},
				        max: 100,
				        title: {
				            text: 'TOTAL',
				            style: { color: Highcharts.getOptions().colors[1] }
				        }
				    }, { // Secondary yAxis
				        title: {  text: '' }, // PORCENTAJE
				        labels: {
				            style: { color: Highcharts.getOptions().colors[0] }
				        },
				        opposite: true
				    }],
				    tooltip: { shared: false }, // tooltip todos
				    legend: {
				        layout: 'horizontal',
				        align: 'left',
				        x: 0,
				        verticalAlign: 'top',
				        y: 0,
				        floating: false, // true dentro de la grafica
				        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
				    },
				    series: [{
				         name: 'TOTALPLAY',
				         type: 'spline',
				         data: arrTp,
				         tooltip: { valueSuffix: '%' },
				         animation: { duration: 2000 }
				    	}, 
				    	{
				    	 name: 'ENLACE',
				         type: 'spline',
				         data: arrEnlace,
				         tooltip: { valueSuffix: '%' },
				         animation: { duration: 2000 }
				    	}, 
				    	{
					     name: 'TFE',
					     type: 'spline',
					     data: arrTfe,
					     tooltip: { valueSuffix: '%' },
					     animation: { duration: 2000 }
					    },
					    
				    ]
		});

	// --- fin pinta grafica ---	 
}

//----------------- GRAFICA POR MES
function evalMes(){

	var mesNumero=0;
  if($('#selectMes').val()=="Enero"){
    mesNumero = "01";
  }if($('#selectMes').val()=="Febrero"){
    mesNumero = "02";
  }if($('#selectMes').val()=="Marzo"){
    mesNumero = "03";
  }if($('#selectMes').val()=="Abril"){
    mesNumero = "04";
  }if($('#selectMes').val()=="Mayo"){
    mesNumero = "05";
  }if($('#selectMes').val()=="Junio"){
    mesNumero = "06";
  }if($('#selectMes').val()=="Julio"){
    mesNumero = "07";
  }if($('#selectMes').val()=="Agosto"){
    mesNumero = "08";
  }if($('#selectMes').val()=="Septiembre"){
    mesNumero = "09";
  }if($('#selectMes').val()=="Octubre"){
    mesNumero = "10";
  }if($('#selectMes').val()=="Noviembre"){
    mesNumero = "11";
  }if($('#selectMes').val()=="Diciembre"){
    mesNumero = "12";
  }
//  console.log('mes salida '+mesNumero+ 'año '+ $('#selectanio').val());
  evalMes1(mesNumero);
}

//--------------- AJAX MES
function evalMes1(mes){
	$('#NoDataX').text("");
//  console.log("GRÁFICA MES "+mes+' '+$('#selectanio').val());
	
  if( mes != ''  && $('#selectanio').val() != ""){
    $.ajax({
    url : 'getCtasActBRMvsU2000Mes',
    type : 'POST',
    async : true,
    data : {
      'mes' : mes,
      'anio'   : $('#selectanio').val()
      },
    dataType : "json",
    beforeSend: function( ) {
      $('#mensaje').show();
    },
    complete: function () {
      $('#mensaje').hide();
        },
    success : function(jsonResponse, textStatus, jqXHR){
      if(jsonResponse.success){
        if(jsonResponse.result.length > 0){
//          console.log("-># consulta de mes ok..");
          reporteMes(jsonResponse.result);
        }else{
          $('#NoDataX').text("No se encontraron datos");
          $('#graficaLx').hide('fade');
        }
      }
    },
  });
  }
}
function reporteMes(result){
	var arrTp =[],arrEnlace =[],arrTfe =[],arrFechas =[];
	
	var total=0,t_conciliados=0;
	
	var totalTp=0,totalEnlace=0,totalTfe=0;
	
	 $.each(result,function(index, arrayValores) {
		arrFechas.push((arrayValores.fecha).toString().substring(0, 11));
		if (arrayValores.empresa=='TOTALPLAY') {
			total = parseInt(arrayValores.total);
        	t_conciliados = arrayValores.t_conciliados;
			totalTp = Math.round((total>0)?((t_conciliados*100)/total):0);
			if(totalTp>0 && totalTp!=''){
				arrTp.push(totalTp);
			}
			}
		if (arrayValores.empresa=='ENLACE') {
			total = parseInt(arrayValores.total);
        	t_conciliados = arrayValores.t_conciliados;
			totalEnlace = Math.round((total>0)?((t_conciliados*100)/total):0);
			if(totalEnlace>0 && totalEnlace!=''){
				arrEnlace.push(totalEnlace);
			}
			}
		if (arrayValores.empresa=='TFE') {
			total = parseInt(arrayValores.total);
        	t_conciliados = arrayValores.t_conciliados;
			totalTfe = Math.round((total>0)?((t_conciliados*100)/total):0);
			if(totalTfe>0 && totalTfe!=''){
				arrTfe.push(totalTfe);
			}
			}
       });
//	 console.log('valores totalplay --=> '+arrTp);
//	 console.log('valores totalplay --=> '+arrEnlace);
//	 console.log('valores totalplay --=> '+arrTfe);

// ---------------------- PINTA GRAFICA  -------------------------
	 $('#graficaLx').show();
	 Highcharts.chart('graficaLx', {
		    chart: {    zoomType: 'xy' },
		    title: {    text: '--BALANCE GENERAL--',
		    			margin:20},
		    subtitle: { text: ''       },
		    xAxis: [{
		           categories: arrFechas,
		           crosshair: true
		    }],
		    yAxis: [{ // Primary yAxis
		        labels: {
		            format: '{value}%',
		            style: { color: Highcharts.getOptions().colors[1] }
		        },
		        max: 100,
		        title: {
		            text: 'TOTAL',
		            style: { color: Highcharts.getOptions().colors[1] }
		        }
		        }, { // Secondary yAxis
		        title: {     text: '' },
		        labels: {
		            style: { color: Highcharts.getOptions().colors[0] }
		        },
		        opposite: true
		    }],
		    tooltip: { shared: false },
		    legend: {
		        	layout: 'horizontal',
		        	align: 'left',
		        	x: 0,
		        	verticalAlign: 'top',
		        	y: 0,
		        	floating: false, // true dentro de la grafica
		        	backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
		    },
		    series: [{
		        name: 'TOTAL',
		        type: 'spline',
		        data: arrTp,
		        tooltip: { valueSuffix: '%' },
		        animation: { duration: 2000 }
		    },{
		        name: 'ENLACE',
		        type: 'spline',
		        data: arrEnlace,
		        tooltip: { valueSuffix: '%' },
		        animation: { duration: 2000 }
		    },{
		        name: 'TFE',
		        type: 'spline',
		        data: arrTfe,
		        tooltip: { valueSuffix: '%' },
		        animation: { duration: 2000 }
		    }]
		});
	// --- fin pinta grafica ---	 
}
