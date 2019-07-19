//alert("Product Master vs Productos-BRM");

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

function pintaReporte1(fech){
	
	if(fech != ""){	
		
		$.ajax({
			url : 'exportPaquetesServiciosActivadosBrmPMDetailsTablaJson',
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
																			
					$('.tituloTabla').text("Detalle de los productos existentes en BRM ");
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
					    },{
					        field: 'empresa',
					        title: 'Empresa',
					        sortable: true
					    }, {
					        field: 'tipo_servicio',
					        title: 'Tipo de Servicio',
					        sortable: true
					    }, {
					        field: 'poid_product',
					        title: 'POID_Product',
					        sortable: true
					    }, {
					        field: 'nombre_producto',
					        title: 'Nombre del Producto',
					        sortable: true
					    }, {
					        field: 'descr',
					        title: 'Descripción',
					        sortable: true
					    },{
					        field: 'cantidad',
					        title: 'Cantidad',
					        sortable: true
					    }, {
					        field: 'tipo_producto',
					        title: 'Tipo de Producto',
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


function cargaReporteTest(){
	//alert( $('#fecha').val() );
	$('#fechaConsulta').text('DIA: ' + $('#fecha').val() );
	cargaReporte();
}

function cargaReporte(){
	if($('#fecha').val() != ""){
		//$(".modal").show();
		$.ajax({
			url : 'getPaquetesServiciosActivadosBrmPMService',
			type : "POST",
			async : false,
			data : {'fecha' : $('#fecha').val()},
			dataType : "json",
			 beforeSend: function( xhr ) {
				 //$('#loadModal').modal();
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
	var status="";
	$.each(result, function(index, valores){
		
		//$('#fechaConsulta').text('DIA: ' + $('#fecha').val() );
		$('.fechaConsulta').html($('#fecha').val() );
		
		//Conciliado
		$('#T_Conciliados').html(accounting.formatNumber( valores.t_conciliados ));
		var porcentaje = (valores.total>0)?((parseInt(valores.t_conciliados)/parseInt(valores.total))*100):0 ;
//		var porcentaje = (1 - ((parseInt(valores.total) - parseInt(valores.t_conciliados)) / 0))*100 ;
		$('#porcentaje').html(accounting.toFixed(porcentaje, 2) + ' %' );
		//No conciliado
		$('#Error_Total').html(accounting.formatNumber( valores.error_total ));
		var porcentajeErr = (valores.total>0)?((parseInt(valores.error_total)/parseInt(valores.total))*100):0 ;
		$('#porcentajeError_Total').html(accounting.toFixed(porcentajeErr, 2) + ' %' );
		$('#Error_Brm').html(accounting.formatNumber( valores.error_brm ));
		$('#Error_Pm').html(accounting.formatNumber( valores.error_pm ));
		
		$('#No_Brm').html(accounting.formatNumber( valores.no_brm ));
		$('#No_Pm').html(accounting.formatNumber( valores.no_pm ));
		$('.Totalpm').html(accounting.formatNumber( valores.total ));
		
		var porcentajeErrorBRM =(valores.total>0)?((parseInt(valores.error_brm)/parseInt(valores.total))*100):0;
		var porcentajeErrorPM = (valores.total>0)?((parseInt(valores.error_pm)/parseInt(valores.total))*100):0 ;
		$('#porcentajeErrorBRM').html(accounting.toFixed(porcentajeErrorBRM, 2) + ' %' );
		$('#porcentajeErrorPM').html(accounting.toFixed(porcentajeErrorPM, 2) + ' %' );
		
		var porcentajeTotal = (valores.total>0)?((parseInt(valores.t_conciliados)/parseInt(valores.total))*100):0 ;
		$('#porcentajeTotal').html(accounting.toFixed(porcentajeTotal, 2) + ' %' );
		
		$('#Empresa').html('TOTALPLAY');
		if(true){
			$('#conciliado').css( "background", "#bed539" );
			$('#conciliado1').css( "background", "#bed539" );
			$('#conciliado2').css( "background", "#bed539" );
			$('#noConciliado').css( "background", "#bed539" );
			$('#noConciliado1').css( "background", "#bed539" );
			$('#noConciliado2').css( "background", "#bed539" );
			$('#totalFFM').css( "color", "#bed539" );
			$('#totalBRM').css( "color", "#bed539" );
			$('#totalGeneral').css( "color", "#bed539" );
			
			
			
		}
		
		
		
		if(valores.status == 'SI' ){
			$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
		}else{
			$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
		}
		
		var botones = '';
		var porcentajeBRM =(valores.total>0)?((parseInt(valores.error_brm)/parseInt(valores.total))*100):0; 
		var porcentajePM = (valores.total>0)?((parseInt(valores.error_pm) /parseInt(valores.total))*100):0;
//		alert(porcentajeBRM);
//		alert(porcentajeIPTV);
		
		if(porcentajeBRM ==100){
		
			botones = '<img src="/CifrasControl/img/green.png">';
//		}else if(porcentajeBRM > 1 && porcentajeBRM <= 15 ){
//			botones = '<img src="/CifrasControl/img/yellow.png" height="40" width="40" class="img-responsive" alt="Responsive image">';
		}else{
			botones = '<img src="/CifrasControl/img/red.png" >';
		}
		$('.bcolorBRM').html(botones);
		
		if(porcentajePM ==100){
			botones = '<img src="/CifrasControl/img/green.png">';
//		}else if(porcentajePM > 1 && porcentajePM <= 15 ){
//			botones = '<img src="/CifrasControl/img/yellow.png" height="40" width="40" class="img-responsive" alt="Responsive image">';
		}else{
			botones = '<img src="/CifrasControl/img/red.png">';
		}
		
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
		$('.bcolorPM').html(botones);
		
		
//		$(".modal").hide();
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

//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
function getValor() {
//	console.log("Product Master vs Productos-BRM");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}


