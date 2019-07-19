//alert("Cuentas Canceladas-BRM vs U2000");
$('.detalle').click(function(){
	cleanX();
	$('#myModal').modal('show');
});
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

function pintaReporte1(fecha,filtro){
	
	if(fecha !='' && filtro !=''){	
//		console.log("fecha que entra al ajax ----"+fecha);
		$.ajax({
			
			cache: false,
			url : 'exportCCanceladasvsU2000TablaJson',
			type : "POST",
			async : true,
			data : {'fechaTabla' :fecha,
					'filtro': filtro},
			dataType : "json",
			beforeSend: function( xhr ) {
				$('#wait').modal({backdrop: 'static', keyboard: false});
			},
			complete: function () {
				$('#wait').modal('hide');
            },
            
			success : function(jsonResponse, textStatus, jqXHR){
				//$('#loadModal').modal('hide');
				if(jsonResponse.success){
																				
					$('.tituloTabla').text("Detalle de cuentas canceladas BRM y que su ONT sigue activa en U2000 ");
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
					        field: 'plan',
					        title: 'Plan',
					        sortable: true
					    }, {
					        field: 'empresa',
					        title: 'Empresa',
					        sortable: true
					    }, {
					        field: 'fecha_cancelacion',
					        title: 'Fecha Cancelación',
					        sortable: true
					    }, {
					        field: 'sn_stb',
					        title: 'SN_STB',
					        sortable: true
					    }, {
					        field: 'tmcode',
					        title: 'TMCode',
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



function sendSolicitud(){
//	alert("configurando");
	$('#fechaReporte').val($('#fecha').val());
//	console.log("fecha obtenida de datepiker-->"+$('#fecha').val());
	if($('#fecha').val() != ""){
		$('.fechaaCentral').text($('#fecha').val());
		
		;
		$.ajax({
			url : 'getcCanceladasvsU2000',
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
					
//					$('#fechaReporteTabla').val($('#fecha').val());
					
					$("#op1").prop("checked", false);
			    	$('#tableModal').bootstrapTable('destroy');
			    	$('.tituloTabla').text('');
			    	$('#NoData').text('');
			    	
			    	$('.filtros').hide();
			    	$('#r1').show();
			    	$("#op1").prop("checked", false);
			    	
					setcCanceladasvsU2000(jsonResponse.result);
				}else{
				
					$('.dateFail').text($('#fecha').val());
					$('#errorModal').modal();
					$('.contentMessage').show('fade');
					$('.contentReporte').hide('fade');
				}		
			},
			error : function(jqXHR, textStatus, error_totalhrown){
				console.log(textStatus);
			}
		});
	}
}
function setcCanceladasvsU2000(result){
	$('#graficaTP').text(''); //-- inicializar bacio
	$('#graficaEnlace').text(''); //-- inicializar bacio
	$('#graficaTFE').text(''); //-- inicializar bacio
	$('#graficaALL').text(''); //-- inicializar bacio
	
	//Variables TotalPlay
	var tp_status = 0;  
	var tp_t_conciliados = 0;
	var tp_porcentaje = 0;
	var tp_porcentaje_noC=0;
	var tp_total = 0;
	var tp_no_brm = 0;
	var tp_no_u2000 = 0;
	var tp_error_total =0;
	var tp_error_u2000=0;
	var tp_error_brm=0;
	
	//Variables Enlace
	var statuse = 0;
	var en_t_conciliados = 0;
	var en_porcentaje = 0;
	var en_porcentaje_noC=0;
	var en_total = 0;
	var en_no_brm = 0;
	var en_no_u2000 = 0;
	var en_error_total =0;
	var en_error_brm=0;
	var en_error_u2000=0;
	
	//Variables TFE
	var statustfe = 0;
	var tfe_t_conciliados = 0;
	var tfe_porcentaje = 0;
	var tfe_porcentaje_noC=0;
	var tfe_total = 0;
	var tfe_no_brm = 0;
	var tfe_no_u2000 = 0;
	var tfe_error_total =0;
	var tfe_error_brm=0;
	var tfe_error_u2000=0;
	
	//Variables Total
	var t_conciliados = 0;
	var porcentaje = 0;
	var porcentaje_noC=0;
	var total = 0;
	var no_brm = 0;
	var no_u2000 = 0;
	var error_total =0;
	var error_brm=0;
	var error_u2000=0;
	//-----
	$.each(result, function(index, valores){
		t_conciliados += parseInt(valores.t_conciliados);
		total += parseInt(valores.total);
		no_brm += parseInt(valores.no_brm);
		no_u2000 += parseInt(valores.no_u2000);
		error_total += parseInt(valores.error_total);
		error_brm+=parseInt(valores.error_brm);;
		error_u2000+=parseInt(valores.error_u2000);;
		
		
		//--TOTALPLAY---
		if(valores.orden== "1"){
			tp_t_conciliados += parseInt(valores.t_conciliados);
			tp_total += parseInt(valores.total);
			tp_no_brm += parseInt(valores.no_brm);
			tp_no_u2000 += parseInt(valores.no_u2000);
			tp_error_total += parseInt(valores.error_total);
			tp_error_brm += parseInt(valores.error_brm);
			tp_error_u2000 += parseInt(valores.error_u2000);
			
			if(valores.status == "SI"){
				tp_status = 1;
			}
		}
		//--ENLACE---
		if(valores.orden== "2"){
			en_t_conciliados += parseInt(valores.t_conciliados);
			en_total += parseInt(valores.total);
			en_no_brm += parseInt(valores.no_brm);
			en_no_u2000 += parseInt(valores.no_u2000);
			en_error_total += parseInt(valores.error_total);
			en_error_brm+=parseInt(valores.error_brm);;
			en_error_u2000+=parseInt(valores.error_u2000);;
			if(valores.status == "SI"){
				statuse = 1;			
			}
		}
		//--TFE---
		if(valores.orden== "3"){
			tfe_t_conciliados += parseInt(valores.t_conciliados);
			tfe_total += parseInt(valores.total);
			tfe_no_brm += parseInt(valores.no_brm);
			tfe_no_u2000 += parseInt(valores.no_u2000);
			tfe_error_total += parseInt(valores.error_total);
			tfe_error_brm+=parseInt(valores.error_brm);;
			tfe_error_u2000+=parseInt(valores.error_u2000);;
			if(valores.status == "SI"){
				statustfe = 1;
			}
		}
	});
	ststus = tp_status + statuse +statustfe;
	$('.tp_status').text("Conciliado");
	$('.statuse').text("Conciliado");
	$('.statustfe').text("Conciliado");
	$('.status').text("Conciliado");
	
	// -- TOTALPLAY --- parseInt
	tp_porcentaje 	= (tp_total>0)?((Math.round(((tp_t_conciliados*100)/tp_total)* 100) / 100)):0;  // PORCENTAJE TOTAL PLAY
	tp_porcentaje_noC =(tp_total>0)?((Math.round(((tp_error_total*100)/tp_total)* 100) / 100)):0 ;  // PORCENTAJE no conciliado
//	tp_porcentaje 	= (tp_total>0)?( ((tp_t_conciliados*100)/(tp_total))*100):0;  // PORCENTAJE TOTAL PLAY
//	tp_porcentaje_noC =(tp_total>0)?(((tp_error_total*100)/(tp_total))* 100):0 ;  // PORCENTAJE no conciliado
	$('.tp_t_conciliados').text(tp_t_conciliados);
	$('.tp_porcentaje').text(tp_porcentaje+ '%');   // porcentaje totalplay
	$('.tp_error_total').text(tp_error_total);
	$('.porce_noConciliado').text(tp_porcentaje_noC+ '%');
	$('.tp_t_error_brm').text(tp_error_brm); 
	$('.tp_t_error_u2000').text(tp_error_u2000);
	
	$('.tp_porcentajeBrm').text((tp_total>0)?(((Math.round(((tp_error_brm*100)/tp_total)*100))/100)):0+'%');
	$('.tp_porcentajeU2000').text((tp_total>0)?(((Math.round((tp_error_u2000*100)/(tp_total)* 100))/100)):0+'%');
	
	//---------   GRAFICA  TOTALPLAY -----	
	var gTP;
	 gTP= new JustGage({
		    id:"graficaTP",
		    //label: "label",
//		    title: "TOTAL",
//		    titleFontColor: "#4c56de", // color azul
//		    titleFontFamily: "Georgia",
//	        titlePosition: "up",
		    value: tp_porcentaje,
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
	
	//--- lateral ---------
	$('.tp_no_brm').text(tp_no_brm); // -- TOTALPLAY -- TOTAL DE BASE BRM
	$('.tp_no_u2000').text(tp_no_u2000); //-- TOTALPLAY -- TOTAL DE BASE U2000
	$('.tp_total').text(tp_total); //-- TOTALPLAY -- TOTAL 
	$('.tp_porcentaje').text(tp_porcentaje + '%');  // -- TOTALPLAY  PORCENTAJE P_IZQUIERDO--
	
	// -----  ENLACE ------
	en_porcentaje 	= (en_total>0)?((Math.round(((en_t_conciliados*100)/en_total)* 100) / 100)):0 ;    // PORCENTAJE ENLACE
	en_porcentaje_noC =(en_total>0)?((Math.round(((en_error_total*100)/en_total)* 100) / 100)):0 ;  // PORCENTAJE no conciliado
	$('.en_t_conciliados').text(en_t_conciliados);
	$('.en_porcentaje').text(en_porcentaje  + '%');	   // porcentaje ENLACE
	$('.en_error_total').text(en_error_total);
	$('.en_porcentajeNC').text(en_porcentaje_noC  + '%');	   // 
	$('.en_error_u2000').text(en_error_u2000);
	$('.en_error_brm').text(en_error_brm);
	$('.en_porcentaje1').text((en_total>0)?((Math.round(((en_error_brm*100)/en_total)* 100) / 100)):0+'%');
	$('.en_porcentaje2').text((en_total>0)?((Math.round(((en_error_u2000*100)/en_total)* 100) / 100)):0+'%');
	// --- lateral--
	$('.en_no_brm').text(en_no_brm);
	$('.en_no_u2000').text(en_no_u2000);
	$('.en_total').text(en_total);
	$('.en_porcentaje').text(en_porcentaje + '%');
	
	//---------   GRAFICA  ENLACE -----	
	var gENLACE;
	 gENLACE= new JustGage({
		    id:"graficaEnlace",
		    //label: "label",
//		    title: "TOTAL",
//		    titleFontColor: "#4c56de", // color azul
//		    titleFontFamily: "Georgia",
//	        titlePosition: "up",
		    value: en_porcentaje,
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
	//--- lateral--
	
	
	// ------ TFE -------
	tfe_porcentaje = (tfe_total>0)?((Math.round(((tfe_t_conciliados*100)/tfe_total)* 100) / 100)):0;// PORCENTAJE TFE
	tfe_porcentaje_noC =(tfe_total>0)?((Math.round(((tfe_error_total*100)/tfe_total)* 100) / 100)):0;  // PORCENTAJE no conciliado
	$('.tfe_t_conciliados').text(tfe_t_conciliados);
	$('.tfe_porcentaje').text(tfe_porcentaje  + '%'); // porcentaje TFE
	$('.tfe_error_total').text(tfe_error_total);
	$('.tfe_porcentajeNC').text(tfe_porcentaje_noC  + '%');	   //
	$('.tfe_error_brm').text(tfe_error_brm);
	$('.tfe_error_u2000').text(tfe_error_u2000);
	$('.tfe_porcentaje1').text((tfe_total>0)?((Math.round(((tfe_error_brm*100)/tfe_total)* 100)/100)):0+'%');
	$('.tfe_porcentaje2').text((tfe_total>0)?((Math.round(((tfe_error_u2000*100)/tfe_total)* 100)/100)):0+'%');
	
	//---------   GRAFICA  TFE -----	
	var gTFE;
	 gTFE= new JustGage({
		    id:"graficaTFE",
		    //label: "label",
//		    title: "TOTAL",
//		    titleFontColor: "#4c56de", // color azul
//		    titleFontFamily: "Georgia",
//	        titlePosition: "up",
		    value: tfe_porcentaje,
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
	
	// --- lateral--
	$('.tfe_no_brm').text(tfe_no_brm);
	$('.tfe_no_u2000').text(tfe_no_u2000);
	$('.tfe_total').text(tfe_total);
	$('.porcentaje2tfe').text(tfe_porcentaje + '%');
	
	
//	no_brm=tp_no_brm+en_no_brm+tfe_no_brm;
//	console.log("total----->no_brm"+no_brm);
	// ---- TOTAL----
	porcentaje = (total>0)?((Math.round(((t_conciliados*100)/total)* 100)/100)):0 ;      // PORCENTAJE TOTAL
	porcentaje_noC =(total>0)?((Math.round(((error_total*100)/total)* 100) / 100)):0 ;  // PORCENTAJE no conciliado
	$('.t_conciliados').text(t_conciliados);
	$('.porcentaje').text(porcentaje + '%');       // porcentaje total
	$('.error_total').text(error_total);
	$('.porcentajeNC').text(porcentaje_noC  + '%');	   //
	$('.error_brm').text(error_brm);
	$('.error_u2000').text(error_u2000);
	$('.porcentaje1').text((total>0)?((Math.round(((error_brm*100)/total)* 100) / 100)):0+'%');
	$('.porcentaje2').text((total>0)?((Math.round(((error_u2000*100)/total)* 100) / 100)):0+'%');
	
	//---------   GRAFICA  TOTAL TODO -----	
	var gALL;
	 gALL= new JustGage({
		    id:"graficaALL",
		    //label: "label",
//		    title: "TOTAL",
//		    titleFontColor: "#4c56de", // color azul
//		    titleFontFamily: "Georgia",
//	        titlePosition: "up",
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
	// ---- lateral ---
	$('.no_brm').text(no_brm);
	$('.no_u2000').text(no_u2000);
	$('.total').text(total);
	$('.porcentaje').text(porcentaje + '%');
	
	
	$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	$('.decisiontp').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	$('.decisiontfe').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	$('.decisione').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	if(porcentaje == 100){
		$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
		$('#nconcilia').addClass("colorDivGris");
		$('#nconciliad').addClass("colorDivGris");
		$('#nconciliap').addClass("colorDivGris");
		$('#nconcilia').html('<b>No Conciliado</b>');
		$('#nconciliad').html('<b>0</b>');
		$('#nconciliap').html('<b>0%</b>');
		$('.bcolor1').html( '<img src="/CifrasControl/img/green.png">');
		$('.bcolor2').html( '<img src="/CifrasControl/img/green.png">');
	}else{
		var perror= (total>0)?((Math.round(((error_total*100)/total)* 100) / 100)):0;
		
		$('#nconcilia').addClass("colorDivGris");
		$('#nconciliad').addClass("colorDivGris");
		$('#nconciliap').addClass("colorDivGris");
		$('#nconcilia').html('<b>No Conciliado</b>');
		$('#nconciliad').html('<b>'+error_total+'</b>');
		$('#nconciliap').html('<b>'+perror+'%</b>');
		
		if(perror <100){
			if(statuse  == 1){
				$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
				$('.bcolor1').html( '<img src="/CifrasControl/img/green.png">');
				$('.bcolor2').html( '<img src="/CifrasControl/img/green.png">');
			}else{
				$('.bcolor1').html( '<img src="/CifrasControl/img/red.png">');
				$('.bcolor2').html( '<img src="/CifrasControl/img/red.png">');
			}
//		}else if(perror >= 1 && perror < 15){
//			$('.bcolor1').html( '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">');
//			$('.bcolor2').html( '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">');
		}else{
			if(statuse  == 1){
				$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
				$('.bcolor1').html( '<img src="/CifrasControl/img/green.png">');
				$('.bcolor2').html( '<img src="/CifrasControl/img/green.png">');
			}else{
				$('.bcolor1').html( '<img src="/CifrasControl/img/red.png">');
				$('.bcolor2').html( '<img src="/CifrasControl/img/red.png">');
			}
		}
	}
	if(tp_porcentaje == 100){
		$('.decisiontp').html('<img src="/CifrasControl/img/tick.png" height="30" width="30" class="img-responsive" alt="Responsive image">');
		$('#nconciliatp').addClass("colorDivVerde");
		$('#nconciliadtp').addClass("colorDivVerde");
		$('#nconciliaptp').addClass("colorDivVerde");
		$('#nconciliatp').html('<b>No Conciliado</b>');
		$('#nconciliadtp').html('<b>0</b>');
		$('#nconciliaptp').html('<b>0%</b>');
		$('.bcolor1tp').html( '<img src="/CifrasControl/img/green.png">');
		$('.bcolor2tp').html( '<img src="/CifrasControl/img/green.png">');
	}else{
		var perror_totalp = (tp_total>0)?((Math.round(((tp_error_total*100)/tp_total)* 100) / 100)):0;
		$('#nconciliatp').addClass("colorDivVerde");
		$('#nconciliadtp').addClass("colorDivVerde");
		$('#nconciliaptp').addClass("colorDivVerde");
		$('#nconciliatp').html('<b>No Conciliado</b>');
		$('#nconciliadtp').html('<b>'+tp_error_total+'</b>');
		$('#nconciliaptp').html('<b>'+perror_totalp+'%</b>');
		if(perror_totalp <100){
			if(tp_status == 1){
				$('.decisiontp').html('<img src="/CifrasControl/img/tick.png" height="30" width="30" class="img-responsive" alt="Responsive image">');
				$('.bcolor1tp').html( '<img src="/CifrasControl/img/green.png">');
				$('.bcolor2tp').html( '<img src="/CifrasControl/img/green.png">');
			}else{
				$('.bcolor1tp').html( '<img src="/CifrasControl/img/red.png">');
				$('.bcolor2tp').html( '<img src="/CifrasControl/img/red.png">');
			}
//		}else if(perror_totalp >= 1 && perror_totalp < 15){
//			$('.bcolor1tp').html( '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">');
//			$('.bcolor2tp').html( '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">');
		}else{
				if(tp_status == 1){
					$('.decisiontp').html('<img src="/CifrasControl/img/tick.png" height="30" width="30" class="img-responsive" alt="Responsive image">');
					$('.bcolor1tp').html( '<img src="/CifrasControl/img/green.png">');
					$('.bcolor2tp').html( '<img src="/CifrasControl/img/green.png">');
				}else{
					$('.bcolor1tp').html( '<img src="/CifrasControl/img/red.png">');
					$('.bcolor2tp').html( '<img src="/CifrasControl/img/red.png">');
				}
				
		}
	}
	if(tfe_porcentaje == 100){
		$('.decisiontfe').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
		$('#nconciliatfe').addClass("colorDivAzul");
		$('#nconciliadtfe').addClass("colorDivAzul");
		$('#nconciliaptfe').addClass("colorDivAzul");
		$('#nconciliatfe').html('<b>No Conciliado</b>');
		$('#nconciliadtfe').html('<b>0</b>');
		$('#nconciliaptfe').html('<b>0%</b>');
		$('.bcolor1tfe').html( '<img src="/CifrasControl/img/green.png" >');
		$('.bcolor2tfe').html( '<img src="/CifrasControl/img/green.png" >');
	}else{
		var perror_totalfe = (tfe_total>0)?((Math.round(((tfe_error_total*100)/tfe_total)* 100) / 100)):0;
		$('#nconciliatfe').addClass("colorDivAzul");
		$('#nconciliadtfe').addClass("colorDivAzul");
		$('#nconciliaptfe').addClass("colorDivAzul");
		$('#nconciliatfe').html('<b>No Conciliado</b>');
		$('#nconciliadtfe').html('<b>'+tfe_error_total+'</b>');
		$('#nconciliaptfe').html('<b>'+perror_totalfe+'%</b>');
		
		if(perror_totalfe <100){
			if(statustfe == 1){
				$('.bcolor1tfe').html( '<img src="/CifrasControl/img/green.png" >');
				$('.bcolor2tfe').html( '<img src="/CifrasControl/img/green.png">');
				$('.decisiontfe').html('<img src="/CifrasControl/img/tick.png">');
			}else{
				$('.bcolor1tfe').html( '<img src="/CifrasControl/img/red.png">');
				$('.bcolor2tfe').html( '<img src="/CifrasControl/img/red.png">');
			}
//		}else if(perror_totalfe >= 1 && perror_totalfe < 15){
//			$('.bcolor1tfe').html( '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">');
//			$('.bcolor2tfe').html( '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">');
		}else{
			if(statustfe == 1){
				$('.decisiontfe').html('<img src="/CifrasControl/img/tick.png">');
				$('.bcolor1tfe').html( '<img src="/CifrasControl/img/green.png">');
				$('.bcolor2tfe').html( '<img src="/CifrasControl/img/green.png">');
			}else{
				$('.bcolor1tfe').html( '<img src="/CifrasControl/img/red.png">');
				$('.bcolor2tfe').html( '<img src="/CifrasControl/img/red.png">');
			}
		}
	}
	if(en_porcentaje == 100){
		$('.decisione').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
		$('#nconciliae').addClass("colorDivNaranja");
		$('#nconciliade').addClass("colorDivNaranja");
		$('#nconciliape').addClass("colorDivNaranja");
		$('#nconciliae').html('<b>No Conciliado</b>');
		$('#nconciliade').html('<b>0</b>');
		$('#nconciliape').html('<b>0%</b>');
		$('.bcolor1e').html( '<img src="/CifrasControl/img/green.png">');
		$('.bcolor2e').html( '<img src="/CifrasControl/img/green.png">');
	}else{
		var perrore = (en_total>0)?((Math.round(((en_error_total*100)/en_total)* 100) / 100)):0;
		$('#nconciliae').addClass("colorDivNaranja");
		$('#nconciliade').addClass("colorDivNaranja");
		$('#nconciliape').addClass("colorDivNaranja");
		$('#nconciliae').html('<b>No Conciliado</b>');
		$('#nconciliade').html('<b>'+en_error_total+'</b>');
		$('#nconciliape').html('<b>'+perrore+'%</b>');
		
		if(perrore <100){
			$('.bcolor1e').html( '<img src="/CifrasControl/img/red.png">');
			$('.bcolor2e').html( '<img src="/CifrasControl/img/red.png">');
//		}else if(perrore >= 1 && perrore < 15){
//			$('.bcolor1e').html( '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">');
//			$('.bcolor2e').html( '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">');
		}else{
			$('.bcolor1e').html( '<img src="/CifrasControl/img/green.png">');
			$('.bcolor2e').html( '<img src="/CifrasControl/img/green.png">');
		}
	}
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