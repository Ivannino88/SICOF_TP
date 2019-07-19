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
$('#back').click(function(){
	back();
});
function back(){
	$('#empresas1').hide('fade');
	$('#empresas2').hide('fade');
	$('#opc1').show('fade');
	$('#opc2').show('fade');
	$('#back').hide('fade');
	$('#tableModal').bootstrapTable('destroy');
	$('.tituloTabla').text('');
	$('#NoData').text('');
	$('.consultaX').text(''); // mensaje actual de consulta
}
function cleanX(){
	$('.consultaX').text('');
	$('#NoData').text('');
	$('.tituloTabla').text('');
	$('#tableModal').bootstrapTable('destroy');
	$('.table-result').show();	
}
//consultas opcion 1
function consultaTp1(){
	cleanX();
//	console.log('consulta 1.1');
//	console.log($('.datepicker').val());
//	console.log($('.btn1').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn1').val());
	pintaReporte1($('.datepicker').val(), $('.btn1').val());
}
function consultaEnl1(){
	cleanX();
//	console.log('consulta 2.1');
//	console.log($('.btn2').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn2').val());
	pintaReporte1($('.datepicker').val(), $('.btn2').val());
}
function consultaTfe1(){
	cleanX();
//	console.log('consulta 3.1');
//	console.log($('.btn3').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn3').val());
	pintaReporte1($('.datepicker').val(), $('.btn3').val());
}
function consultaTt1(){
	cleanX();
//	console.log('consulta 4.1');
//	console.log($('.btn4').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn4').val().toUpperCase());
	pintaReporte1($('.datepicker').val(), $('.btn4').val());
}
//consultas opcion 2
function consultaTp2(){
	cleanX();
//	console.log('consulta 1.2');
//	console.log($('.btn1').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn1').val());
	pintaReporte2($('.datepicker').val(), $('.btn1').val());
}

function consultaEnl2(){
	cleanX();
//	console.log('consulta 2.2');
//	console.log($('.btn2').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn2').val());
	pintaReporte2($('.datepicker').val(), $('.btn2').val());
}
function consultaTfe2(){
	cleanX();
//	console.log('consulta 3.2');
//	console.log($('.btn3').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn3').val());
	pintaReporte2($('.datepicker').val(), $('.btn3').val());
}
function consultaTt2(){
	cleanX();
//	console.log('consulta 4.2');
//	console.log($('.btn4').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn4').val().toUpperCase());
	pintaReporte2($('.datepicker').val(), $('.btn4').val());
}

function pintaReporte1(fechaFiltro, filtro){
	
	if(fechaFiltro != ""){	
		
		$.ajax({
			url : 'exportDetalleCicloBRMDetailsTablaJson',
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
				//$('#loadModal').modal('hide');
				if(jsonResponse.success){
															
					$('.tituloTabla').text("Detalle de cuentas que no facturaron");
					//console.log("Detalle de los cuentas existentes en SAP y no en BRM ");
										
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
					        field: 'nombreCliente',
					        title: 'Nombre Cliente',
					        sortable: true
					    }, 
					    {
					        field: 'monto',
					        title: 'Monto',
					        sortable: true
					    },
					    {
					        field: 'bill_no',
					        title: 'Folio',
					        sortable: true
					    }
					    ]
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


function pintaReporte2(fechaFiltro2, filtro){
	
	if(fechaFiltro2 != ""){	
		
		$.ajax({
			url : 'exportDetalleCicloBRMDetailsTablaJson2',
			type : "POST",
			async : true,
			data : {'fechaTabla' :fechaFiltro2,
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
				//$('#loadModal').modal('hide');
				if(jsonResponse.success){
																			
					$('.tituloTabla').text("Detalle de facturas que no estaban en su ciclo");
					//console.log("Detalle de los cuentas existentes en SAP y no en BRM ");
										
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
					        field: 'cuenta',
					        title: 'Cuenta',
					        sortable: true
					    }, {
					        field: 'empresa',
					        title: 'Empresa',
					        sortable: true
					    },{
					        field: 'folio',
					        title: 'Folio',
					        sortable: true
					    }, {
					        field: 'monto',
					        title: 'Monto',
					        sortable: true
					    }, {
					        field: 'fecha_factura',
					        title: 'Fecha de Factura',
					        sortable: true
					    }, {
					        field: 'fecha_vencimiento',
					        title: 'Fecha de Vencimiento',
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





//alert("online v1.1");
$(function() {
	init();
	$('#aseg4 span').addClass('desabilitado'); //----esconde la opcion en donde se encuentra
//	alert("online");
});
function init() {
	initComponents();
	intReporte();
}
function initComponents() {
	$('#datetimepicker').datepicker({
		setDate : new Date(),
		format : 'dd/mm/yyyy',
		autoclose : true,
		language : 'es',
		todayHighlight : true
	});
} 

function intReporte(){
	$('.datepicker').change(function () {
		
	if($('#fecha').val() != ""){
		$('#fechaConsulta').text('DIA: ' + $('#fecha').val() );
		$.ajax({
			url : 'getCtasCiclovsCtasBRM',
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
					$('#fechaReporte').val( $('#fecha').val() );
					
					//$('#fechaReporteTabla').val($('#fecha').val());
					
			    	$('#tableModal').bootstrapTable('destroy');
			    	$('.tituloTabla').text('');
			    	$('#NoData').text('');
					setCtasCiclovsCtasBRMD(jsonResponse.result);					
						
			}else{
				//alert(jsonResponse.success);
				limpiaCampos();
				$('.dateFail').text($('#fecha').val());
				$('#errorModal').modal();
				$('.contentMessage').show('fade');
				$('.contentReporte').hide('fade');
				
			}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				var error = new Object();
				error.mensaje = "Ocurrio un error al intentar procesar su peticion, por favor reintentelo.";
				$('.dateFail').text($('#fecha').val());
				$('#errorModal').modal();
			}
		});
	}
	});
}
function setCtasCiclovsCtasBRMD(result){
	$('#graficaALL').text(''); //-- inicializar bacio
	$('#graficaTP').text(''); //-- inicializar bacio
	$('#graficaEnlace').text(''); //-- inicializar bacio
	$('#graficaTFE').text(''); //-- inicializar bacio

	var botones = '';
	var total = 0;
	var t_conciliados  = 0;
	var porcentajeConc = 0;
	var t_no_conciliados = 0;
	var porcentajeNoConc = 0;
	var error_ciclo = 0;
	var error_facturadas = 0;
	var total_brm = 0;
	var porcentajeerrorcuentas = 0;
	var total_ims = 0;
	var porcentajeerrorfacturadas = 0;
	
	$('#fechaReporte').val($('#fecha').val());
	limpiaCampos();
	
	$.each(result, function(index, valores){ 
		
		total += parseInt(valores.total);
		t_conciliados += parseInt(valores.t_conciliados);
		t_no_conciliados  += parseInt(valores.error_total);
		error_ciclo += parseInt(valores.error_ciclo);
		error_facturadas += parseInt(valores.error_facturadas);
		total_brm += parseInt(valores.no_cuentas);
		total_ims += parseInt(valores.no_facturadas);
//------------------------------------------------------------TOTALPLAY--------------------------------------------------
		if(valores.empresa == 'TOTALPLAY'){
			$('.statusConcTP').text("Conciliado");
			$('.t_conciliadosTP').text(accounting.formatNumber(valores.t_conciliados));
			$('.porcentajeConcTP').text(valores.porcentajeconc + '%');
			
			$('.statusNoConcTP').text("No Conciliado");
			$('.t_no_conciliadosTP').text(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcTP').text(valores.porcentajenoconc + '%');
			
			$('.error_cicloTP').text(accounting.formatNumber(valores.error_ciclo));
			$('.error_facturadasTP').text(accounting.formatNumber(valores.error_facturadas));
			
			porcentajeerrorcuentas =(total>0)?((valores.error_ciclo * 100)/total):0;
			$('.porcentajeerrorcuentasTP').text(accounting.toFixed(porcentajeerrorcuentas,2)+ '%');
			porcentajeerrorfacturadas =(total>0)?((valores.error_facturadas * 100)/total):0;
			$('.porcentajeerrorfacturadasTP').text(accounting.toFixed(porcentajeerrorfacturadas,2)+ '%');
//			$('.porcentajeerrorcuentasTP').text(valores.porcentajeerrorcuentas+ '%');
//			$('.porcentajeerrorfacturadasTP').text(valores.porcentajeerrorfacturadas+ '%');

			$('.totalBRMTP').text(accounting.formatNumber(valores.no_cuentas));
			$('.totalimsTP').text(accounting.formatNumber(valores.no_facturadas));
			$('.totalTP').text(accounting.formatNumber(valores.total));	
		
			if(valores.status == "1"  ){
				$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}else{
				$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}
			
			if(valores.porcentajeerrorcuentas ==100){
				if(parseInt(valores.error_total)==0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}else {
				if(parseInt(valores.error_total)==0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			$('.bcolorBRMTP').html(botones);
			
			if(valores.porcentajeerrorfacturadas ==100){
				if(parseInt(valores.error_total)==0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}else{
				if(parseInt(valores.error_total)==0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}

//---------   GRAFICA  TOTALPLAY -----	
			var gTP;
			 gTP= new JustGage({
				    id:"graficaTP",
				    //label: "label",
//				    title: "TOTAL",
//				    titleFontColor: "#4c56de", // color azul
//				    titleFontFamily: "Georgia",
			        titlePosition: "up",
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
			
			$('.bcolorimsTP').html(botones);
			
			//------------------------------------------------------------ENLACE--------------------------------------------------			
		} else if(valores.empresa == 'ENLACE'){
			$('.statusConcENL').text("Conciliado");
			$('.t_conciliadosENL').text(accounting.formatNumber(valores.t_conciliados));
			$('.porcentajeConcENL').text(valores.porcentajeconc + '%');
			
			$('.statusNoConcENL').text("No Conciliado");
			$('.t_no_conciliadosENL').text(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcENL').text(valores.porcentajenoconc + '%');
			
			$('.error_cicloENL').text(accounting.formatNumber(valores.error_ciclo));
			$('.error_facturadasENL').text(accounting.formatNumber(valores.error_facturadas));
			
			porcentajeerrorcuentas =(total>0)?((valores.error_ciclo*100)/total):0;
			$('.porcentajeerrorcuentasENL').text(accounting.toFixed(porcentajeerrorcuentas,2)+ '%');
			porcentajeerrorfacturadas =(total>0)?((valores.error_facturadas*100)/total):0;
			$('.porcentajeerrorfacturadasENL').text(accounting.toFixed(porcentajeerrorfacturadas,2)+ '%');
//			$('.porcentajeerrorcuentasENL').text(valores.porcentajeerrorcuentas+ '%');
//			$('.porcentajeerrorfacturadasENL').text(valores.porcentajeerrorfacturadas+ '%');

			$('.totalBRMENL').text(accounting.formatNumber(valores.no_cuentas));
			$('.totalimsENL').text(accounting.formatNumber(valores.no_facturadas));
			$('.totalENL').text(accounting.formatNumber(valores.total));
			

			if(valores.status == "1"  ){
				$('.decisionENL').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}else{
				$('.decisionENL').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}
			if(valores.porcentajeerrorcuentas ==100){
				if(parseInt(valores.error_total)==0){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}else{
				if(parseInt(valores.error_total)==0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			$('.bcolorBRMENL').html(botones);
			
			if(valores.porcentajeerrorfacturadas ==100){
				if(parseInt(valores.error_total)==0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}else{
				if(parseInt(valores.error_total)==0){
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
			        titlePosition: "up",
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
			$('.bcolorimsENL').html(botones);
			//------------------------------------------------------------TFE--------------------------------------------------			
		} else if(valores.empresa == 'TFE'){
			$('.statusConcTFE').text("Conciliado");
			$('.t_conciliadosTFE').text(accounting.formatNumber(valores.t_conciliados));
			$('.porcentajeConcTFE').text(valores.porcentajeconc + '%');
			
			$('.statusNoConcTFE').text("No Conciliado");
			$('.t_no_conciliadosTFE').text(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcTFE').text(valores.porcentajenoconc + '%');
			
			$('.error_cicloTFE').text(accounting.formatNumber(valores.error_ciclo));
			$('.error_facturadasTFE').text(accounting.formatNumber(valores.error_facturadas));
			
			porcentajeerrorcuentas =(total>0)?((valores.error_ciclo*100)/total):0;
			$('.porcentajeerrorcuentasTFE').text(accounting.toFixed(porcentajeerrorcuentas,2)+ '%');
			porcentajeerrorfacturadas =(total>0)?((valores.error_facturadas*100)/total):0;
			$('.porcentajeerrorfacturadasTFE').text(accounting.toFixed(porcentajeerrorfacturadas,2)+ '%');
			
			
//			$('.porcentajeerrorcuentasTFE').text(valores.porcentajeerrorcuentas+ '%');
//			$('.porcentajeerrorfacturadasTFE').text(valores.porcentajeerrorfacturadas+ '%');

			$('.totalBRMTFE').text(accounting.formatNumber(valores.no_cuentas));
			$('.totalimsTFE').text(accounting.formatNumber(valores.no_facturadas));
			$('.totalTFE').text(accounting.formatNumber(valores.total));
			

			if(valores.status == "1"  ){
				$('.decisionTFE').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}else{
				$('.decisionTFE').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}
			if(valores.porcentajeerrorcuentas ==100){
				if(parseInt(valores.error_total)==0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}else{
				if(parseInt(valores.error_total)==0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			$('.bcolorBRMTFE').html(botones);
			
			if(valores.porcentajeerrorfacturadas ==100){
				if(parseInt(valores.error_total)==0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}else {
				if(parseInt(valores.error_total)==0){
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
			        titlePosition: "up",
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
			$('.bcolorimsTFE').html(botones);
		}
	});
	
	$('.statusConcT').text("Conciliado");
	$('.t_conciliadosT').text(accounting.formatNumber(t_conciliados));
	porcentajeConc = (total>0)?((t_conciliados*100)/total):0;
	$('.porcentajeConcT').text(accounting.toFixed(porcentajeConc,2) + '%');
	
	$('.statusNoConcT').text("No Conciliado");
	$('.t_no_conciliadosT').text(accounting.formatNumber(t_no_conciliados));
	porcentajeNoConc = (total>0)?((t_no_conciliados * 100)/total):0;
	$('.porcentajeNoConcT').text(accounting.toFixed(porcentajeNoConc,2) + '%');
	
	$('.error_cicloT').text(accounting.formatNumber(error_ciclo));
	$('.error_facturadasT').text(accounting.formatNumber(error_facturadas));
	
	porcentajeerrorcuentas =(total>0)?((error_ciclo * 100)/total):0;
	$('.porcentajeerrorcuentasT').text(accounting.toFixed(porcentajeerrorcuentas,2)+ '%');
	porcentajeerrorfacturadas =(total>0)?((error_facturadas * 100)/total):0;
	$('.porcentajeerrorfacturadasT').text(accounting.toFixed(porcentajeerrorfacturadas,2)+ '%');

	$('.totalBRMT').text(accounting.formatNumber(total_brm));
	$('.totalimsT').text(accounting.formatNumber(total_ims));
	$('.totalT').text(accounting.formatNumber(total));
	
	
	//---------   GRAFICA  TOTAL TODO -----	
	var gALL;
	 gALL= new JustGage({
		    id:"graficaALL",
		    //label: "label",
//		    title: "TOTAL",
//		    titleFontColor: "#4c56de", // color azul
//		    titleFontFamily: "Georgia",
	        titlePosition: "up",
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
	
	//------------------------------------------------------------TOTAL--------------------------------------------------
	if(porcentajeConc == 100 ){
		$('.decisionT').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	}else{
		$('.decisionT').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	}

	if(porcentajeerrorcuentas ==100){
		botones = '<img src="/CifrasControl/img/green.png" >';
//	}else if(porcentajeerrorcuentas > 1 && porcentajeerrorcuentas <= 15 ){
//		botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
	}else if(porcentajeerrorcuentas<100 ){
		botones = '<img src="/CifrasControl/img/red.png" >';
	}
	$('.bcolorBRMT').html(botones);
	
	if(porcentajeerrorfacturadas ==100){
		botones = '<img src="/CifrasControl/img/green.png" >';
//	}else if(porcentajeerrorfacturadas > 1 && porcentajeerrorfacturadas <= 15 ){
//		botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
	}else if(porcentajeerrorfacturadas<100 ){
		botones = '<img src="/CifrasControl/img/red.png" >';
	}
	$('.bcolorimsT').html(botones);
}

function limpiaCampos(){
		
		$('.decision').html("");
	
		$('.statusConcTP').text("Conciliado");
		$('.t_conciliadosTP').text('-');
		$('.porcentajeConcTP').text('0%');
		
		$('.statusNoConcTP').text("No Conciliado");
		$('.t_no_conciliadosTP').text('-');
		$('.porcentajeNoConcTP').text('0%');
		
		$('.error_cicloTP').text('');
		$('.error_facturadasTP').text('');
		
		$('.porcentajeerrorcuentasTP').text('0%');
		$('.porcentajeerrorfacturadasTP').text('0%');

		$('.totalBRMTP').text('');
		$('.totalIMSTP').text('');
		$('.totalTP').text('');	
	
		$('.statusConcENL').text("Conciliado");
		$('.t_conciliadosENL').text('-');
		$('.porcentajeConcENL').text('0%');
		
		$('.statusNoConcENL').text("No Conciliado");
		$('.t_no_conciliadosENL').text('-');
		$('.porcentajeNoConcENL').text('0%');
		
		$('.error_cicloENL').text('');
		$('.error_facturadasENL').text('');
		
		$('.porcentajeerrorcuentasENL').text('0%');
		$('.porcentajeerrorfacturadasENL').text('0%');

		$('.totalBRMENL').text('');
		$('.totalimsENL').text('');
		$('.totalENL').text('');
		
		$('.statusConcTFE').text("Conciliado");
		$('.t_conciliadosTFE').text('-');
		$('.porcentajeConcTFE').text('0%');
		
		$('.statusNoConcTFE').text("No Conciliado");
		$('.t_no_conciliadosTFE').text('-');
		$('.porcentajeNoConcTFE').text('0%');
		
		$('.error_cicloTFE').text('');
		$('.error_facturadasTFE').text('');
		
		$('.porcentajeerrorcuentasTFE').text('0%');
		$('.porcentajeerrorfacturadasTFE').text('0%');

		$('.totalBRMTFE').text('');
		$('.totalIMSTFE').text('');
		$('.totalTFE').text('');	

		$('.statusConcT').text("Conciliado");
		$('.t_conciliadosT').text('-');
		$('.porcentajeConcT').text('0%');
		
		$('.statusNoConcT').text("No Conciliado");
		$('.t_no_conciliadosT').text('-');
		$('.porcentajeNoConcT').text('0%');
		
		$('.error_cicloT').text('');
		$('.error_facturadasT').text('');
		
		$('.porcentajeerrorcuentasT').text('0%');
		$('.porcentajeerrorfacturadasT').text('0%');
		
		$('.totalBRMT').text('');
		$('.totalIMST').text('');
		$('.totalT').text('');
}
$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });
//같같같같같같같같같같같같같같같같같같같같같같같같같같같�
function getValor() {
//	console.log("Ajustes-BRM vs Ajustes-SalesForce");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}