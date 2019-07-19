//alert("Instalaciones vs. Salidas de Almac&eacute;n SAP - BRM");
function cargaReporteTest(){
	//alert( $('#fecha').val() );
	$('#fechaEt').text( $('#fecha').val() );
	cargaReporte();
}
function cleanModal(){
	$('#tableModal').bootstrapTable('destroy');
	$('#NoData').text('');
	$('.tituloTabla').text('');	
}
$('.detalle').click(function() {
	$('#myModal').modal('show');
	$('.table-result').show();
});

$('#opc1').click(function() {
	cleanModal();
	pintaReporte1($('#fecha').val());
});

$('#opc2').click(function() {
	cleanModal();
	pintaReporte2($('#fecha').val());
	});

function pintaReporte1(fech){
//	console.log("pintaReporte1");
	if(fech != ""){	
		
		$.ajax({
			url : 'exportInstalacionesvsSalidasAlmacenSAPDetailsTabla',
			type : "POST",
			async : true,
			data : {'fechatabla' :fech},
			dataType : "json",
			beforeSend: function( ) {
				$('.wait').modal({backdrop: 'static', keyboard: false});
			},
			complete: function () {
				$('.wait').modal('hide');
            },
			success : function(jsonResponse, textStatus, jqXHR){
				if(jsonResponse.success){
					
															
					$('.tituloTabla').text("Detalle de las cuentas existentes en SAP y no en BRM ");
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
					        field: 'id_conciliacion',
					        title: 'Id Conciliación',
					        sortable: true
					    }, {
					        field: 'no_serie',
					        title: 'No. de Serie',
					        sortable: true
					    }, {
					        field: 'fe_contable',
					        title: 'Fecha Contable',
					        sortable: true
					    }, {
					        field: 'numero_material',
					        title: 'No. de Material',
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
			url : 'exportInstalacionesvsSalidasAlmacenSAPDetailsTabla2',
			type : "POST",
			async : true,
			data : {'fechatabla' :fech},
			dataType : "json",
			beforeSend: function( ) {
				$('.wait').modal({backdrop: 'static', keyboard: false});
			},
			complete: function () {
				$('.wait').modal('hide');
            },
			success : function(jsonResponse, textStatus, jqXHR){
				if(jsonResponse.success){
										
					$('.tituloTabla').text("Detalle de las cuentas existentes en BRM y no en SAP");
					//console.log("Detalle de las cuentas existentes en BRM y no en SAP");
					
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
					        field: 'id_conciliacion',
					        title: 'Id Conciliación',
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
					        field: 'sn',
					        title: 'SN',
					        sortable: true
					    }, ]
					});
							
										
				}else{
					$('.tituloTabla').text('');
					$('#NoData').text("No se encontraron datos");
					//console.log("Error en la tabla: " + jsonResponse.success);
										
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
		$('#fechaEt').text( $('#fecha').val() );
		$.ajax({
			url : 'getInstVsSalidasAlmacenSAPService',
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
					cleanModal();
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
	$('#graficaTp').text(''); //-- inicializar bacio
	$('.fechaReporte').text($('#fecha').val());
	var botones = '';
	var total = 0;
	var t_conciliados  = 0;
	var porcentajeConc = 0;
	var t_no_conciliados = 0;
	var porcentajeNoConc = 0;
	var error_brm = 0;
	var error_sap = 0;
	var total_brm = 0;
	var porcentajeerrorbrm = 0;
	var total_sap = 0;
	var porcentajeerrorsap = 0;
	
	$.each(result, function(index, valores){
		
//		console.log("index: " + index);
		
		total += parseInt(valores.total);
		t_conciliados += parseInt(valores.t_conciliados);
		t_no_conciliados  += parseInt(valores.error_total);
		error_brm += parseInt(valores.error_brm);
		error_sap += parseInt(valores.error_sap);
		total_brm += parseInt(valores.no_brm);
		total_sap += parseInt(valores.no_sap);
		
		
		if (result.length==2){
			
			//$('.reporteEmpresarial').show();			
			////$('.TotalSapBrm').show();
			
		}
		else{
		/*	$('.reporteEmpresarial').hide();
			$('#grafica2').remove(); // this is my <canvas> element
			$('#caja_grafica2').append('<div class="sizegraf center-block" id="grafica2"></div>');
			
			$('.TotalSapBrm').hide();
			$('#graficaALL').remove(); // this is my <canvas> element
			$('#caja_grafica3').append('<div class="sizegraf center-block" id="graficaALL"></div>');
			*/
		}
		
		//if(valores.tipo_conciliacion == '1'){
		
				//Conciliado
				$('#T_Conciliados').html(accounting.formatNumber( valores.t_conciliados ));
				var porcentaje = (parseInt(valores.total)>0)?((parseInt(valores.t_conciliados)/parseInt(valores.total))*100):0 ;
				$('#porcentaje').html(accounting.toFixed(porcentaje, 2) + ' %' );
		//		//No conciliado
				$('#Error_Total').html(accounting.formatNumber( valores.error_total ));
				var porcentajeErr = (parseInt(valores.total)>0)?((parseInt(valores.error_total)/parseInt(valores.total))*100):0 ;
				$('#porcentajeError_Total').html(accounting.toFixed(porcentajeErr, 2) + ' %' );
				$('#Error_Brm').html(accounting.formatNumber( valores.error_brm ));
				$('#Error_sap').html(accounting.formatNumber( valores.error_sap ));
		//		
				$('#No_Brm').html(accounting.formatNumber( valores.no_brm ));
				$('#No_Sap').html(accounting.formatNumber( valores.no_sap ));
				$('.Totalsap2').html(accounting.formatNumber( valores.total ));
				
				var porcentajeErrorBRM = (parseInt(valores.total)>0)?((parseInt(valores.error_brm)/parseInt(valores.total))*100):0 ;
				var porcentajeErrorSAP = (parseInt(valores.total)>0)?(( parseInt(valores.error_sap)/parseInt(valores.total))*100):0 ;
				$('#porcentajeErrorBRM').html(accounting.toFixed(porcentajeErrorBRM, 2) + ' %' );
				$('#porcentajeErrorSAP').html(accounting.toFixed(porcentajeErrorSAP, 2) + ' %' );
				
				var porcentajeTotal = (parseInt(valores.total)>0)?((parseInt(valores.t_conciliados)/ parseInt(valores.total))*100):0 ;
				$('#porcentajeTotal').html(accounting.toFixed(porcentajeTotal, 2) + ' %' );
				
				$('#Empresa').html(valores.empresa);
//				console.log("valores.tipo_conciliacion: " + valores.tipo_conciliacion + " valores.id: " + valores.id);
				
				
				if(valores.status == 'SI' ){
					$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
				}else{
					$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
				}
				
				var botones = '';
				var porcentajeBRM = (parseInt(valores.total)>0)?((parseInt(valores.error_brm) / parseInt(valores.total))*100):0; 
				var porcentajeSAP = (parseInt(valores.total)>0)?((parseInt(valores.error_sap) / parseInt(valores.total))*100):0;
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
				}else{
					if(valores.status == 'SI' ){
						botones = '<img src="/CifrasControl/img/green.png">';
					}else{
						botones = '<img src="/CifrasControl/img/red.png">';
					}
				}
				$('.bcolorBRM').html(botones);
				
				if(porcentajeSAP ==100){
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
				// -----   GRAFICA TOTALES ------------------
				 var gTOTAL;
				 gTOTAL= new JustGage({
					    id:"graficaTp",
				        titlePosition: "up",
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
				$('.bcolorSAP').html(botones);
	});
}
function limpiaCampos(){
	var valorInicial = 0.0;
	
	$('.decision').html("");
	$('.bcolorBRM').text('');
	$('.bcolorSAP').text('');
	$('#T_Conciliados').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentaje').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#Error_Total').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentajeError_Total').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#Error_Brm').html(accounting.toFixed(valorInicial, 2 ));
	$('#Error_sap').html(accounting.toFixed(valorInicial, 2 ));
	$('#No_Sap').html(accounting.toFixed(valorInicial, 2 ));
	$('#No_Brm').html(accounting.toFixed(valorInicial, 2 ));
	$('.Totalsap2').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentajeErrorBRM').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#porcentajeErrorSAP').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#porcentajeTotal').html(accounting.toFixed(valorInicial, 2) + ' %' );
	
	$('#Empresa').html(" ");
}

$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });

function getValor() {
//	console.log("Instalaciones vs. Salidas de Almac&eacute;n SAP - BRM");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}

// ----------------------------------------------------------- GRAFICA LINEAL -----------------------------------------------
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
    url : 'datosSemInstVsSalidasAlmacenSAPService',
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
          reporteSemana(jsonResponse.result);
        }else{
          $('#NoDataX').text("No se encontraron datos");
          $('#graficaLx').hide('fade');
        }
      }
    },
  });
  }
}
function reporteSemana(result){
	var arrTp = new Array();
	var arrFechas = new Array();
	var total=0;
	var t_conciliados=0;
	var totalTp=0;
	
	 $.each(result,function(index, arrayValores) {
		total += parseInt(arrayValores.total);
		t_conciliados += arrayValores.t_conciliados;
		arrFechas.push(arrayValores.fecha);
//		console.log('fechasss'+arrFechas);
		if (total >0) {
			totalTp = Math.round((total>0)?((t_conciliados*100)/total):0);
//			console.log("valores de totalplay -->"+totalTp);
			if(totalTp>0 && totalTp!=''){
			arrTp.push(totalTp);
			}
		}
       });
//	 console.log('arreglo total'+arrTp);
	 $('#graficaLx').show();
// --- dibuja grafica ---
	 Highcharts.chart('graficaLx', {
		    chart: { zoomType: 'xy' },
		    title: { text: '--TOTALPLAY--' },
		    subtitle: { text: 'Gráfica'    },
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
//		          align: 'left',
//		          layout: 'vertical',
		            text: 'PORCENTAJE',
		            style: { color: Highcharts.getOptions().colors[1] }
		        }
		    }, { // Secondary yAxis
		        title: {  text: '' }, // PORCENTAJE
		        labels: {
		            // format: '{value}%',
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
		        name: 'Total General',
		        type: 'column',
		        data: arrTp,
		        tooltip: { valueSuffix: '%' }
		    	}, 
		    	{
		        name: 'TOTAL',
		        type: 'spline',
		        data: arrTp,
		        tooltip: { valueSuffix: '%' }
		    }]
		});
	// --- fin pinta grafica ---	 
}

//----------------- GRAFICA POR MES
function evalMes(){
//  console.log("Grafica por Mes");
//  console.log('mes entrada '+$('#selectMes').val());
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
//  console.log("Grafica por semana");
//  console.log($('#selectsem').val());
  if( mes != ''  && $('#selectanio').val() != ""){
//   console.log("valor de mes es--> "+mes);
//    console.log("valor de anio es ---> "+$('#selectanio').val());
    $.ajax({
    url : 'datosMesInstVsSalidasAlmacenSAPService',
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
	var arrTp = new Array();
	var arrFechas = new Array();
	var total=0;
	var t_conciliados=0;
	var totalTp=0;
	 $.each(result,function(index, arrayValores) {
		total += parseInt(arrayValores.total);
		t_conciliados += arrayValores.t_conciliados;
		arrFechas.push(arrayValores.fecha);
//		console.log('fechasss mes'+arrFechas);
		if (total >0) {
			totalTp = Math.round((total>0)?((t_conciliados*100)/total):0);
//			console.log("valores de totalplay -->"+totalTp);
			if(totalTp>0 && totalTp!=''){
			arrTp.push(totalTp);
			}
		}
       });
//	 console.log('arreglo total'+arrTp);
	 $('#graficaLx').show();
// --- dibuja grafica ---
	 Highcharts.chart('graficaLx', {
		    chart: {    zoomType: 'xy' },
		    title: {    text: '--TOTALPLAY--' },
		    subtitle: { text: 'Gráfica'       },
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
//		          align: 'left',
//		          layout: 'vertical',
		            text: 'PORCENTAJE',
		            style: { color: Highcharts.getOptions().colors[1] }
		        }
		        }, { // Secondary yAxis
		        title: {     text: '' },
		        labels: {
//		            format: '{value}%',
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
		        name: 'Total General',
		        type: 'column',
		        data: arrTp,
		        tooltip: { valueSuffix: '%' }
		    	}, 
		    	{
		        name: 'TOTAL',
		        type: 'spline',
		        data: arrTp,
		        tooltip: { valueSuffix: '%' }
		    }]
		});
	// --- fin pinta grafica ---	 
}
