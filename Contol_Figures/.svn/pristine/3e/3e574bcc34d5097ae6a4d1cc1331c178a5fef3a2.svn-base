//alert("small");
$('.detalle').click(function(){
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
function consultaX3(){
	cleanX();
	pintaReporte3($('#fecha').val());
	}

//detalle vista json* #1
function pintaReporte1(fech){
//	console.log("jason* #1");
	if(fech != ""){	
		
		$.ajax({
			url : 'exportDetalleFfmCuentasNoSwDetailsTablaJson',
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
																			
					$('.tituloTabla').text("Detalle de FFM que no esta Small World");
					//console.log("Detalle VODS");
					$('#tableModal').bootstrapTable({
						 
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    search: true,
					    
					    columns: [{
					        field: 'fechaShort',
					        title: 'Fecha',
					        sortable: true
					    }, {
					        field: 'id_conciliacion',
					        title: 'Id Conciliación',
					        sortable: true
					    }, {
					        field: 'num_cuenta',
					        title: 'No. de Cuenta',
					        sortable: true
					    }, {
					        field: 'splitter',
					        title: 'Splitter',
					        sortable: true
					    }, {
					        field: 'puerto_asignado',
					        title: 'Puerto Asignado',
					        sortable: true
					    },{
					        field: 'candado',
					        title: 'Candado',
					        sortable: true
					    }, {
					        field: 'fecha_modificacionShort',
					        title: 'Fecha de Modificación',
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

//detalle vista json* #2
function pintaReporte2(fech){
//	console.log("jason* #2");
	if(fech != ""){	
		
		$.ajax({
			url : 'exportDetalleFfmCuentasNoSwDetailsTablaJson2',
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
																			
					$('.tituloTabla').text("Detalle de Small World que no esta en FFM");
					//console.log("Detalle VODS"); 
										
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    search: true,
					    
					    columns: [{
					        field: 'fechaShort',
					        title: 'Fecha',
					        sortable: true
					    }, {
					        field: 'id_conciliacion',
					        title: 'ID Conciliación',
					        sortable: true
					    }, {
					        field: 'cuentas',
					        title: 'Cuenta',
					        sortable: true
					    }, {
					        field: 'splitter',
					        title: 'Splitter',
					        sortable: true
					    }, {
					        field: 'puerto_asignado',
					        title: 'Puerto Asignado',
					        sortable: true
					    },{
					        field: 'candado',
					        title: 'Candado',
					        sortable: true
					    }, {
					        field: 'fecha_modificacionShort',
					        title: 'Fecha de Modificación',
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
//detalle vista json* #3
function pintaReporte3(fech){
//	console.log("jason* #3");
	if(fech != ""){	
		
		$.ajax({
			url : 'exportDetalleFfmCuentasNoSwDetailsTablaJson3',
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
																			
					$('.tituloTabla').text("Detalle Datos Inconsistentes");
					//console.log("Detalle VODS");
										
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    search: true,
					    
					    columns: [{
					        field: 'fechaShortSw',
					        title: 'Fecha',
					        sortable: true
					    }, {
					        field: 'id_conciliacion',
					        title: 'ID Conciliación',
					        sortable: true
					    }, {
					        field: 'cuentas_ffm',
					        title: 'Cuentas FFM',
					        sortable: true
					    }, {
					        field: 'splitter_ffm',
					        title: 'Splitter FFM',
					        sortable: true
					    }, {
					        field: 'puerto_asignado_ffm',
					        title: 'Puerto Asignado FFM',
					        sortable: true
					    },{
					        field: 'candado_ffm',
					        title: 'Candado FFM',
					        sortable: true
					    }, {
					        field: 'fecha_modificacion_ffmShort',
					        title: 'Fecha de Modificación FFM',
					        sortable: true
					    }, {
					        field: 'cuentas_sw',
					        title: 'Cuentas SW',
					        sortable: true
					    }, {
					        field: 'splitter_sw',
					        title: 'Splitter SW',
					        sortable: true
					    }, {
					        field: 'puerto_asignado_sw',
					        title: 'Puerto Asignado SW',
					        sortable: true
					    },{
					        field: 'candado_sw',
					        title: 'Candado SW',
					        sortable: true
					    }, {
					        field: 'fecha_modificacionShortSw',
					        title: 'Fecha de Modificación SW',
					        sortable: true
					    },]
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




function cargaReporteTest(){
	//alert( $('#fecha').val() );
	$('#fechaEt').text( $('#fecha').val() );
	cargaReporte();
}

function cargaReporte(){
	if($('#fecha').val() != ""){
		//$(".modal").show();
		$('#fechaEt').text( $('#fecha').val() );
		$.ajax({
			url : 'getSmallWorld',
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
					$('.contentMessage').hide('fade');
					$('.contentReporte').show('fade');
					$('#descargaArchivo').show();

					$('.fechaEt').text($('#fecha').val());
					$('#fechaReporte').val($('#fecha').val());
					
					$('#fechaReporteTabla').val($('#fecha').val());
					
			    	$('#tableModal').bootstrapTable('destroy');
			    	$('.tituloTabla').text('');
			    	$('#NoData').text('');
					
					setReporte(jsonResponse.result);
					
				}else{
					//alert(jsonResponse.success);
					limpiaCampos();
					
					$('.dateFail').text($('#fecha').val());
					$('#errorModal').modal();
					$('.contentMessage').show('fade');
					$('.contentReporte').hide('fade');
					$('#descargaArchivo').hide();
					
					
				}
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
			}
		});
	}
}
function setReporte(result){
	$('#grafica').text(''); //-- inicializar bacio
	$('.fechaReporte').text($('#fecha').val());
	$.each(result, function(index, valores){
		//Conciliado
		$('#T_Conciliados').html(accounting.formatNumber( valores.t_conciliados ));
		var porcentaje = (parseInt(valores.total)>0)?((parseInt(valores.t_conciliados)/parseInt(valores.total))*100):0;
		$('#porcentaje').html(accounting.toFixed(porcentaje, 2) + ' %' );
////		//No conciliado
		$('#Error_Total').html(accounting.formatNumber( valores.error_total ));
		var porcentajeErr = (parseInt(valores.total)>0)?((parseInt(valores.error_total)/parseInt(valores.total))*100):0 ;
		$('#porcentajeError_Total').html(accounting.toFixed(porcentajeErr, 2) + ' %' );
		$('#Error_Ffm').html(accounting.formatNumber( valores.error_ffm ));
		$('#Error_sw').html(accounting.formatNumber( valores.error_sw ));
//		
		$('#No_ffm').html(accounting.formatNumber( valores.no_ffm ));
		$('#No_Sw').html(accounting.formatNumber( valores.no_sw ));
		$('.Totalsmall').html(accounting.formatNumber( valores.total ));
//		
		var porcentajeErrorFFM = valores.porcentaje_error_ffm;   // (1 - ((parseInt(valores.no_ffm) - parseInt(valores.error_ffm)) / parseInt(valores.no_ffm)))*100 ;
		var porcentajeErrorSW =  valores.porcentaje_error_sm;  //(1 - ((parseInt(valores.no_sw) - parseInt(valores.error_sw)) / parseInt(valores.no_sw)))*100 ;
		//alert(porcentajeErrorFFM + ' - ' + porcentajeErrorSW);
		$('#porcentajeErrorFFM').html(accounting.toFixed(porcentajeErrorFFM,2) + ' %' );
		$('#porcentajeErrorSW').html(accounting.toFixed(porcentajeErrorSW,2) + ' %' );
		
		var porcentajeTotal = (parseInt(valores.total)>0)?((parseInt(valores.t_conciliados)/parseInt(valores.total))*100):0 ;
		$('#porcentajeTotal').html(accounting.toFixed(porcentajeTotal, 2) + ' %' );
//		
		$('#Empresa').html(valores.empresa);
		if(valores.empresa == 'TOTALPLAY'){
			$('#conciliado').css( "background", "#bed539" );
			$('#conciliado1').css( "background", "#bed539" );
			$('#conciliado2').css( "background", "#bed539" );
			$('#noConciliado').css( "background", "#bed539" );
			$('#noConciliado1').css( "background", "#bed539" );
			$('#noConciliado2').css( "background", "#bed539" );
			$('#totalSW').css( "color", "#bed539" );
			$('#totalFFM').css( "color", "#bed539" );
			$('#totalGeneral').css( "color", "#bed539" );
			
		}
		
		
		
		if(valores.status == 'SI' ){
			$('.decision').html('<img src="/CifrasControl/img/tick.png">');
		}else{
			$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png">');
		}
//		
		var botones = '';
		var porcentajeFFM=(parseInt(valores.total)>0)?((parseInt(valores.error_ffm)/parseInt(valores.total))*100):0; 
		var porcentajeSW =(parseInt(valores.total)>0)?((parseInt(valores.error_sw)/parseInt(valores.total))*100):0;
////		alert(porcentajeBRM);
////		alert(porcentajeIPTV);
//		
		if(porcentajeFFM ==100){
			if(valores.status == 'SI' ){
				botones = '<img src="/CifrasControl/img/green.png">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png">';
			}
//		}else if(porcentajeBRM > 1 && porcentajeBRM <= 15 ){
//			botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
		}else{
			if(valores.status == 'SI' ){
				botones = '<img src="/CifrasControl/img/green.png">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png">';
			}
		}
		$('.bcolorFFM').html(botones);
		
		if(porcentajeSW ==100){
			if(valores.status == 'SI' ){
				botones = '<img src="/CifrasControl/img/green.png">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png">';
			}
//		}else if(porcentajeSAP > 1 && porcentajeSAP <= 15 ){
//			botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
		}else{
			if(valores.status == 'SI' ){
				botones = '<img src="/CifrasControl/img/green.png">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png">';
			}
		}
		
// -------------------------------------------   GRAFICA TOTALES ------------------	 
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
		
		
		
		$('.bcolorSW').html(botones);
		
		
////		$(".modal").hide();
	});
	
}


function limpiaCampos(){
	var valorInicial = 0.0;
	$('.decision').html("");
	$('.bcolorFFM').text('');
	$('.bcolorSW').text('');
	$('#T_Conciliados').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentaje').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#Error_Total').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentajeError_Total').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#Error_Ffm').html(accounting.toFixed(valorInicial, 2 ));
	$('#Error_sw').html(accounting.toFixed(valorInicial, 2 ));
	$('#No_Sw').html(accounting.toFixed(valorInicial, 2 ));
	$('#No_Ffm').html(accounting.toFixed(valorInicial, 2 ));
	$('.Totalsmall').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentajeErrorFFM').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#porcentajeErrorSW').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#porcentajeTotal').html(accounting.toFixed(valorInicial, 2) + ' %' );
	
	$('#Empresa').html(" ");
}

$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });

//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
function getValor() {
//	console.log("Instalaciones vs. Salidas de Almac&eacute;n SAP - BRM");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}


