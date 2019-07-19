//alert("ONLINE VERSUS");
function cargaReporteTest(){
	//alert( $('#fecha').val() );
	$('#fechaConsulta').text('DIA: ' + $('#fecha').val() );
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
	if(fech != ""){	
		
		$.ajax({
			url : 'exportInstalacionesNuevasCuentasActivadasFfmBrmDetailsTabla',
			type : "POST",
			async : true,
			data : {'fechatabla' :fech},
			dataType : "json",
			 beforeSend: function( xhr ) {
				 $('#wait').modal({backdrop: 'static', keyboard: false});
			 },
			 complete: function () {
					$('#wait').modal('hide');
	            },
			success : function(jsonResponse, textStatus, jqXHR){
				if(jsonResponse.success){
														
					$('.tituloTabla').text("Detalle de las cuentas existentes en FFM y no en BRM ");
					//console.log("Detalle de los cuentas existentes en FFM y no en BRM ");
					
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
					        title: 'Id conciliación',
					        sortable: true
					    }, {
					        field: 'cuenta',
					        title: 'Cuenta',
					        sortable: true
					    }, {
					        field: 'fecha_activacion',
					        title: 'Fecha Activación',
					        sortable: true
					    }, {
					        field: 'empresa',
					        title: 'Empresa',
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
			url : 'exportInstalacionesNuevasCuentasActivadasFfmBrmDetailsTabla2',
			type : "POST",
			async : true,
			data : {'fechatabla' :fech},
			dataType : "json",
			 beforeSend: function( xhr ) {
				 $('#wait').modal({backdrop: 'static', keyboard: false});
			 },
			 complete: function () {
					$('#wait').modal('hide');
	            },
			success : function(jsonResponse, textStatus, jqXHR){
				if(jsonResponse.success){
						$('.tituloTabla').text("Detalle de las cuentas existentes en BRM y no en FFM");
						//console.log("Detalle de los cuentas existentes en BRM y no en FFM");
						
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
						        title: 'Id conciliación',
						        sortable: true
						    }, {
						        field: 'cuenta',
						        title: 'Cuenta',
						        sortable: true
						    }, {
						    	field: 'fecha_activacion',
							    title: 'Fecha Activación',
							    sortable: true
							    }, {
							    field: 'empresa',
							    title: 'Empresa',
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
		$('#fechaReporte').val($('#fecha').val());
		//$(".modal").show();
	
		$.ajax({
			url : 'getInstalacionesNuevasCuentasActivadasFfmBrmService',
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
					$('#fechaConsulta').val($('#fecha').val());
					$('.contentMessage').hide('fade');
					$('.contentReporte').show('fade');
					$('#descargaArchivo').show();
					
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
	$('#grafica').text(''); //-- inicializar bacio
	$('.fechaEt').text($('#fecha').val());
	$.each(result, function(index, valores){
		//Conciliado
		$('#T_Conciliados').html(accounting.formatNumber( valores.t_conciliacion ));
		var porcentaje = (parseInt(valores.total)>0)?((parseInt(valores.t_conciliacion)/parseInt(valores.total))*100):0;
		$('#porcentaje').html(accounting.toFixed(porcentaje, 2) + ' %' );
		//No conciliado
		$('#Error_Total').html(accounting.formatNumber( valores.error_total ));
		var porcentajeErr = (parseInt(valores.total)>0)?((parseInt(valores.error_total)/parseInt(valores.total))*100):0 ;
		$('#porcentajeError_Total').html(accounting.toFixed(porcentajeErr, 2) + ' %' );
		$('#Error_Brm').html(accounting.formatNumber( valores.error_brm ));
		$('#Error_ffm').html(accounting.formatNumber( valores.error_ffm ));
		
		$('#No_Brm').html(accounting.formatNumber( valores.no_brm ));
		$('#No_Ffm').html(accounting.formatNumber( valores.no_ffm ));
		$('.TotalAct').html(accounting.formatNumber( valores.total ));
		
		var porcentajeErrorBRM = (parseInt(valores.total)>0)?((parseInt(valores.error_brm)/parseInt(valores.total))*100):0;
		var porcentajeErrorFFM = (parseInt(valores.total)>0)?((parseInt(valores.error_ffm)/parseInt(valores.total))*100):0;
		$('#porcentajeErrorBRM').html(accounting.toFixed(porcentajeErrorBRM, 2) + ' %' );
		$('#porcentajeErrorFFM').html(accounting.toFixed(porcentajeErrorFFM, 2) + ' %' );
		
		var porcentajeTotal = (parseInt(valores.total)>0)?((parseInt(valores.t_conciliacion)/parseInt(valores.total))*100):0;
		$('#porcentajeTotal').html(accounting.toFixed(porcentajeTotal, 2) + ' %' );
		
		$('#Empresa').html(valores.empresa);
		if(valores.empresa == 'TOTALPLAY'){
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
		var porcentajeBRM = (parseInt(valores.total)>0)?((parseInt(valores.error_brm)/parseInt(valores.total))*100):0; 
		var porcentajeFFM = (parseInt(valores.total)>0)?((parseInt(valores.error_ffm)/parseInt(valores.total))*100):0;
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
		
		if(porcentajeFFM ==100){
			if(valores.status == 'SI' ){
				botones = '<img src="/CifrasControl/img/green.png">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png">';
			}
//		}else if(porcentajeFFM > 1 && porcentajeFFM <= 15 ){
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
		
		$('.bcolorFFM').html(botones);
		
		
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
	$('.TotalAct').html(accounting.toFixed(valorInicial, 2 ));
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
//	console.log("Instalaciones vs. Salidas de Almac&eacute;n SAP - BRM");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
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
    url : 'getSemanaInstalacionesNuevasCuentasActivadasFfmBrmService',
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
		t_conciliados += arrayValores.t_conciliacion;
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
		    chart: { zoomType: 'xy'           },
		    title: 	  { text: '--TOTALPLAY--' },
		    subtitle: {  text: 'Gráfica'      },
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
		        	//align: 'left',
//		        	layout: 'vertical',
		            text: 'PORCENTAJE',
		            style: { color: Highcharts.getOptions().colors[1] }
		        	}
		    		},{ // Secondary yAxis
		        title: {  text: '' }, // PORCENTAJE
		        labels: {
		            //format: '{value}%',
		            style: { color: Highcharts.getOptions().colors[0] }
		        },
		        opposite: true
		    }],
		    tooltip: { shared: true   },
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
//		        color: Highcharts.getOptions().colors[2]
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
    url : 'getMesInstalacionesNuevasCuentasActivadasFfmBrmService',
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
		t_conciliados += arrayValores.t_conciliacion;
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
		    chart: {
		        zoomType: 'xy'
		    },
		    title: {
		        text: '--TOTALPLAY--'
		    },
		    subtitle: {
		        text: 'Gráfica'
		    },
		    xAxis: [{
		        categories: arrFechas,
		        crosshair: true
		    }],
		    yAxis: [{ // Primary yAxis
		        labels: {
		            format: '{value}%',
		            style: {
		                color: Highcharts.getOptions().colors[1]
		            }
		        },
		        max: 100,
		        title: {
		          align: 'left',
		          layout: 'vertical',
		            text: 'PORCENTAJE',
		            style: {
		                color: Highcharts.getOptions().colors[1]
		            }
		        }
		    }, { // Secondary yAxis
		        title: {
		            text: '', // PORCENTAJE
		            style: {
		                color: Highcharts.getOptions().colors[0]
		            }
		        },
		        labels: {
		            format: '{value}%',
		            style: {
		                color: Highcharts.getOptions().colors[0]
		            }
		        },
		        opposite: true
		    }],
		    tooltip: {
		        shared: false
		    },
		    legend: {
		        layout: 'vertical',
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
		        tooltip: {
		            valueSuffix: '%'
		        }
		    	}, 
		    	{
		        name: 'TOTAL',
		        type: 'spline',
		        data: arrTp,
		        tooltip: {
		            valueSuffix: '%'
		        }
		    }]
		});
	// --- fin pinta grafica ---	 
}




