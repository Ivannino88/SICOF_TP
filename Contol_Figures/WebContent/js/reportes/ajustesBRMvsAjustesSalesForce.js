//alert("safeforce online");
$('.detalle').click(function(){
	$('#myModal').modal('show');
});

$('#opc1').click(function(){
	$('#empresas1').show('fade');
	$('#opc2').hide('fade');
	$('#back').show('fade');
	
});
$('#opc2').click(function(){
	$('#empresas2').show('fade');
	$('#opc1').hide('fade');
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
	$('.consultaX').text('');
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
//	console.log($('.btn1').val());
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


function pintaReporte1(fechaFiltro, filtro){
//	console.log("pintaReporte1"+fechaFiltro);
	if(fechaFiltro != ""){	
		
		$.ajax({
			url : 'exportAjustesBRMvsAjustesSalesForceDetailsTablaJson',
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
																			
					$('.tituloTabla').text("Detalle Ajustes SF NO BRM");
					//console.log("Detalle VODS");
															
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    search: true,
					    columns: [{
					        field: 'id',
					        title: 'Id',
					        sortable: true
					    }, {
					        field: 'fechaShort',
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
					        field: 'item_no',
					        title: 'Item no',
					        sortable: true
					    },{
					        field: 'item_total',
					        title: 'Item total',
					        sortable: true
					    }, {
					        field: 'fecha_ajusteShort',
					        title: 'Fecha Ajuste',
					        sortable: true
					    }, {
					        field: 'descr',
					        title: 'Descripción',
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


function pintaReporte2(fechaFiltro2, filtro){
//	console.log("pintaReporte2"+fechaFiltro2);
	if(fechaFiltro2 != ""){	
		$.ajax({
			url : 'exportAjustesBRMvsAjustesSalesForceDetailsTablaJson2',
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
				$('#loadModal').modal('hide');
				if(jsonResponse.success){
																			
					$('.tituloTabla').text("Detalle Ajustes BRM NO SF");
					//console.log("Detalle VODS"); 
										
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    search: true,
					    
					    columns: [{
					        field: 'id',
					        title: 'Id',
					        sortable: true
					    }, {
					        field: 'fechaShort',
					        title: 'Fecha',
					        sortable: true
					    }, {
					        field: 'log',
					        title: 'Log',
					        sortable: true
					    }, {
					        field: 'nombre',
					        title: 'Nombre',
					        sortable: true,
					    }, {
					        field: 'cuenta',
					        title: 'Cuenta',
					        sortable: true
					    }, {
					        field: 'empresa',
					        title: 'Empresa',
					        sortable: true
					    }, {
					        field: 'accion',
					        title: 'Acción',
					        sortable: true
					    }, {
					        field: 'fecha_ajusteShort',
					        title: 'Fecha Ajuste',
					        sortable: true
					    },{
					        field: 'monto',
					        title: 'Monto',
					        sortable: true
					    }, {
					        field: 'respuesta',
					        title: 'Respuesta',
					        sortable: true
					    }, {
					        field: 'comentario',
					        title: 'Comentario',
					        sortable: true
					    }, {
					        field: 'usuario',
					        title: 'Usuario',
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



function cargaReporte(){
	if($('#fecha').val() != ""){
		$.ajax({
			url : 'getAjustesBRMvsAjutesSalesForce',
			type : "POST",
			async : false,
			data : {'fecha' : $('#fecha').val()},
			dataType : "json",
			 beforeSend: function( xhr ) {
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#loadModal').modal('hide');
				if(jsonResponse.success){
				
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
				}
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
			}
		});
	}
}


function setReporte(result){
	$('#graficaTP').text(''); //-- inicializar bacio
	$('#graficaEnlace').text(''); //-- inicializar bacio
	$('#graficaALL').text(''); //-- inicializar bacio
	var botones = '';
	var total = 0;
	var t_conciliados  = 0;
	var porcentajeConc = 0;
	var t_no_conciliados = 0;
	var porcentajeNoConc = 0;
	var error_brm = 0;
	var error_sf = 0;
	var total_brm = 0;
	var porcentajeerrorbrm = 0;
	var total_sf = 0;
	var porcentajeerrorsf = 0;

	limpiaCampos();
	
	$.each(result, function(index, valores){ 
		
		total += parseInt(valores.total);
		t_conciliados += parseInt(valores.t_conciliados);
		t_no_conciliados  += parseInt(valores.error_total);
		error_brm += parseInt(valores.error_brm);
		error_sf += parseInt(valores.error_sf);
		total_brm += parseInt(valores.no_brm);
		total_sf += parseInt(valores.no_sf);
		
//---------------------------------------------------------------------------------------- TOTALPLAY -----------------------------------------------------------------------------
		if(valores.empresa == 'TOTALPLAY'){
			$('.statusConcTP').text("Conciliado");
			$('.t_conciliadosTP').text(accounting.formatNumber(valores.t_conciliados));
			$('.porcentajeConcTP').text(valores.porcentajeconc + '%');
			
			$('.statusNoConcTP').text("No Conciliado");
			$('.t_no_conciliadosTP').text(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcTP').text(valores.porcentajenoconc + '%');
			
			$('.error_brmTP').text(accounting.formatNumber(valores.error_brm));
			$('.error_sfTP').text(accounting.formatNumber(valores.error_sf));
			
			$('.porcentajeerrorbrmTP').text(valores.porcentajeerrorbrm+ '%');
			$('.porcentajeerrorsfTP').text(valores.porcentajeerrorsf+ '%');

			$('.totalBRMTP').text(accounting.formatNumber(valores.no_brm));
			$('.totalsfTP').text(accounting.formatNumber(valores.no_sf));
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
			}else {
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			$('.bcolorBRMTP').html(botones);
			
			if(valores.porcentajeerrorsf ==100){
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}else{
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			$('.bcolorsfTP').html(botones);
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
			$('.error_sfENL').text(accounting.formatNumber(valores.error_sf));
			
			$('.porcentajeerrorbrmENL').text(valores.porcentajeerrorbrm+ '%');
			$('.porcentajeerrorsfENL').text(valores.porcentajeerrorsf+ '%');

			$('.totalBRMENL').text(accounting.formatNumber(valores.no_brm));
			$('.totalsfENL').text(accounting.formatNumber(valores.no_sf));
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
			}else{
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			$('.bcolorBRMENL').html(botones);
			
			if(valores.porcentajeerrorsf ==100){
				if(parseInt(valores.error_total) == 0){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
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
			$('.bcolorsfENL').html(botones);
		} 
	});
//---------------------------------------------------------------------------------------- TOTAL -----------------------------------------------------------------------------	

	$('.statusConcT').text("Conciliado");
	$('.t_conciliadosT').text(accounting.formatNumber(t_conciliados));
	porcentajeConc = (total>0)?((t_conciliados * 100)/total):0;
	$('.porcentajeConcT').text(accounting.toFixed(porcentajeConc,2) + '%');
	
	$('.statusNoConcT').text("No Conciliado");
	$('.t_no_conciliadosT').text(accounting.formatNumber(t_no_conciliados));
	porcentajeNoConc = (total>0)?((t_no_conciliados * 100)/total):0;
	$('.porcentajeNoConcT').text(accounting.toFixed(porcentajeNoConc,2) + '%');
	
	$('.error_brmT').text(accounting.formatNumber(error_brm));
	$('.error_sfT').text(accounting.formatNumber(error_sf));
	
	porcentajeerrorbrm = (total>0)?((error_brm * 100)/total):0;
	$('.porcentajeerrorbrmT').text(accounting.toFixed(porcentajeerrorbrm,2)+ '%');
	porcentajeerrorsf = (total>0)?((error_sf * 100)/total):0;
	$('.porcentajeerrorsfT').text(accounting.toFixed(porcentajeerrorsf,2)+ '%');

	$('.totalBRMT').text(accounting.formatNumber(total_brm));
	$('.totalsfT').text(accounting.formatNumber(total_sf));
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
	
	if(porcentajeerrorsf ==100){
		botones = '<img src="/CifrasControl/img/green.png" >';
//	}else if(porcentajeerroru2000 > 1 && porcentajeerroru2000 <26){
//		botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
	}else if(porcentajeerrorsf <100 ){
		botones = '<img src="/CifrasControl/img/red.png" >';
	}

	$('.bcolorsfT').html(botones);
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
	$('.error_sfTP').text('');
	
	$('.porcentajeerrorbrmTP').text('0%');
	$('.porcentajeerrorsfTP').text('0%');

	$('.totalBRMTP').text('');
	$('.totalsfTP').text('');
	$('.totalTP').text('');	

	$('.statusConcENL').text("Conciliado");
	$('.t_conciliadosENL').text('-');
	$('.porcentajeConcENL').text('0%');
	
	$('.statusNoConcENL').text("No Conciliado");
	$('.t_no_conciliadosENL').text('-');
	$('.porcentajeNoConcENL').text('0%');
	
	$('.error_brmENL').text('');
	$('.error_sfENL').text('');
	
	$('.porcentajeerrorbrmENL').text('0%');
	$('.porcentajeerrorsfENL').text('0%');

	$('.totalBRMENL').text('');
	$('.totalsfENL').text('');
	$('.totalENL').text('');
	
	$('.statusConcT').text("Conciliado");
	$('.t_conciliadosT').text('-');
	$('.porcentajeConcT').text('0%');
	
	$('.statusNoConcT').text("No Conciliado");
	$('.t_no_conciliadosT').text('-');
	$('.porcentajeNoConcT').text('0%');
	
	$('.error_brmT').text('');
	$('.error_sfT').text('');
	
	$('.porcentajeerrorbrmT').text('0%');
	$('.porcentajeerrorsfT').text('0%');
	
	$('.totalBRMT').text('');
	$('.totalsfT').text('');
	$('.totalT').text('');
}

$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });
//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
function getValor() {
//	console.log("Ajustes-BRM vs Ajustes-SalesForce");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}



