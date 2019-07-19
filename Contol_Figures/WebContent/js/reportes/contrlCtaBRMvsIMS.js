//alert('BRM-DN vs IMS-DN');

$('.detalle').click(function() {
	$('#myModal').modal('show');
	$('.table-result').show();
});
function cleanModal(){
	$('#tableModal').bootstrapTable('destroy');
	$('#NoData').text('');
	$('.tituloTabla').text('');	
}
$('#opc1').click(function() {
	cleanModal();
//	console.log($('#fecha').val());
	pintaReporte1($('#fecha').val());
});

$('#opc2').click(function() {
	cleanModal();
	pintaReporte2($('#fecha').val());
	});

function pintaReporte1(fech){
//	console.log("js json #1- "+fech);
	if(fech != ""){	
		
		$.ajax({
			url : 'exportDetalleReporteBRMvsIMSdetailTabla',
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
//            cache: false,
			success : function(jsonResponse, textStatus, jqXHR){
				//$('#wait').modal('hide');
				if(jsonResponse.success){
																			
					$('.tituloTabla').text("Detalle de dn's que estan en BRM y no existen en IMS");
					//console.log("Detalle BRM No IMS");
					
										
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
					        field: 'cuenta',
					        title: 'Cuenta',
					        sortable: true
					    }, {
					        field: 'plan',
					        title: 'Plan',
					        sortable: true
					    }, {
					        field: 'dn',
					        title: 'DN',
					        sortable: true
					    }, {
					        field: 'tmcode',
					        title: 'TMCODE',
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

function pintaReporte2(fech2){
//	console.log("js json #2- "+fech2);
	if(fech2 != ""){	
		
		$.ajax({
			url : 'exportDetalleReporteBRMvsIMSdetailTabla2',
			type : "POST",
			async : true,
			data : {'fechatabla' :fech2},
			dataType : "json",
			beforeSend: function( xhr ) {
				$('#wait').modal({backdrop: 'static', keyboard: false});
			},
			complete: function () {
				$('#wait').modal('hide');
            },
			success : function(jsonResponse, textStatus, jqXHR){
				if(jsonResponse.success){
																			
					$('.tituloTabla').text("Detalle de dn's que estan en IMS y no existen en BRM");
					//console.log("Detalle IMS No BRM");
					
										
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
					        field: 'dn',
					        title: 'DN',
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
function consultainfo(){
//	alert("XXXXXxx---"+$('#fecha').val());
	if($('#fecha').val() != ""){
		$.ajax({
			url : 'getReporteBRMvsIMS',
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
					if(jsonResponse.result.length > 0){
						$('#fechaReporteTabla').val($('#fecha').val());
						$("#op1").prop("checked", false);
						$("#op2").prop("checked", false);
				    	$('#tableModal').bootstrapTable('destroy');
				    	$('.tituloTabla').text('');
				    	$('#NoData').text('');
				    	
				    	$('.filtros').hide();
				    	$('#r1').show();
				    	$('#r2').show();			    	
				    	$("#op1").prop("checked", false);
				    	$("#op2").prop("checked", false);
						
						setCtasActBRMvsIMS(jsonResponse.result);
						$('#descargaArchivo').show();
						$('#fechaReporte').val( $('#fecha').val() );
						$('.contentMessage').hide('fade');
						$('.contentReporte').show('fade');
					}else{
						$('.dateFail').text($('#fecha').val());
						$('#errorModal').modal();
						$('.contentMessage').show('fade');
						$('.contentReporte').hide('fade');
					}
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


function setCtasActBRMvsIMS(result){
	$('#grafica').text(''); //-- variable grafica
	var botones = '';
	var total = 0;
	var t_conciliados  = 0;
	var porcentajeConc = 0;
	var t_no_conciliados = 0;
	var porcentajeNoConc = 0;
	var error_brm = 0;
	var error_brm_tp=0;
	var error_brm_enl=0;
	var error_brm_tfe=0;
	var error_u2000 = 0;
	var total_brm = 0;
	var porcentajeerrorbrm = 0;
	var total_u2000 = 0;
	var porcentajeerroru2000 = 0;
	var porcentajeerrorbrm_tp = 0;
	var porcentajeerrorbrm_enl = 0;
	var porcentajeerrorbrm_tfe = 0;

	
	$('.fechaEt').text($('#fecha').val());
	limpiaCampos();
	
	$.each(result, function(index, valores){ 
		
		total += parseInt(valores.total);
		t_conciliados += parseInt(valores.t_conciliados);
		t_no_conciliados  += parseInt(valores.error_total);
		error_brm += parseInt(valores.error_brm);
		error_u2000 += parseInt(valores.error_ims);
		total_brm += parseInt(valores.no_brm);
		total_u2000 += parseInt(valores.no_ims);
		error_brm_tp+=parseInt(valores.error_brm_tp);
		error_brm_enl+=parseInt(valores.error_brm_enl);
		error_brm_tfe+=parseInt(valores.error_brm_tfe);
		
	});
	$('.statusConcT').html("Conciliado");
	$('.t_conciliadosT').html(""+accounting.formatNumber(t_conciliados));
	porcentajeConc = (t_conciliados * 100)/total;
	$('.porcentajeConcT').text(accounting.toFixed(porcentajeConc,2) + '%');
	
	$('.statusNoConcT').html("No Conciliado");
	$('.t_no_conciliadosT').html(accounting.formatNumber(t_no_conciliados));
	porcentajeNoConc = (t_no_conciliados * 100)/total;
	$('.porcentajeNoConcT').html(accounting.toFixed(porcentajeNoConc,2) + '%');
	
	$('.error_brmT').html(""+accounting.formatNumber(error_brm));
	$('.error_brm_tp').html(""+accounting.formatNumber(error_brm_tp));
	$('.error_brm_enl').html(""+accounting.formatNumber(error_brm_enl));
	$('.error_brm_tfe').html(""+accounting.formatNumber(error_brm_tfe));
	
	
	$('.error_u2000T').html(""+accounting.formatNumber(error_u2000));
	
	porcentajeerrorbrm =   (total>0)?((error_brm * 100)/total):0;
	porcentajeerrorbrm_tp= (total>0)?((error_brm_tp * 100)/total):0;
	porcentajeerrorbrm_enl=(total>0)?((error_brm_enl * 100)/total):0;
	porcentajeerrorbrm_tfe=(total>0)?((error_brm_tfe * 100)/total):0;

	
	$('.porcentajeerrorbrmT').html(""+accounting.toFixed(porcentajeerrorbrm,2)+ '%');
	$('.porcentajeerrorbrm_tp').html(""+accounting.toFixed(porcentajeerrorbrm_tp,2)+ '%');
	$('.porcentajeerrorbrm_enl').html(""+accounting.toFixed(porcentajeerrorbrm_enl,2)+ '%');
	$('.porcentajeerrorbrm_tfe').html(""+accounting.toFixed(porcentajeerrorbrm_tfe,2)+ '%');
	
	
	porcentajeerroru2000 = (error_u2000 * 100)/total;
	$('.porcentajeerroru2000T').text(""+accounting.toFixed(porcentajeerroru2000,2)+ '%');

	$('.totalBRMT').html(""+accounting.formatNumber(total_brm));
	$('.totalU2000T').html(""+accounting.formatNumber(total_u2000));
	$('.totalT').html(""+accounting.formatNumber(total));
	
	
	if(porcentajeConc == 100 ){
		$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	}else{
		$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	}

	if(porcentajeerrorbrm ==100){
		botones = '<img src="/CifrasControl/img/green.png">';
//	}else if(porcentajeerrorbrm > 1 && porcentajeerrorbrm <= 15 ){
//		botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
	}else if(porcentajeerrorbrm <100 ){
		botones = '<img src="/CifrasControl/img/red.png">';
	}
	$('.bcolorBRMT').html(botones);
	
	if(porcentajeerroru2000 ==100){
		botones = '<img src="/CifrasControl/img/green.png">';
//	}else if(porcentajeerroru2000 > 1 && porcentajeerroru2000 <= 15 ){
//		botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
	}else if(porcentajeerroru2000 <100 ){
		botones = '<img src="/CifrasControl/img/red.png">';
	}
	$('.bcolorU2000T').html(botones);
	// ------------------- GRAFICA ----------------
	var TOTAL;
	TOTAL= new JustGage({
	    id:"grafica",
	    //label: "label",
//	    title: "TOTAL",
//	    titleFontColor: "#4c56de", // color azul
//	    titleFontFamily: "Georgia",
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
	
}

function limpiaCampos(){

		$('.statusConcT').text("Conciliado");
		$('.t_conciliadosT').text('-');
		$('.porcentajeConcT').text('0%');
		
		$('.statusNoConcT').text("No Conciliado");
		$('.t_no_conciliadosT').text('-');
		$('.porcentajeNoConcT').text('0%');
		
		$('.error_brmT').text('');
		$('.error_brm_tp').text('0');
		$('.error_brm_enl').text('0');
		$('.error_brm_tfe').text('0');
		$('.error_u2000T').text('');
		
		$('.porcentajeerrorbrmT').text('0%');
		$('.porcentajeerrorbrm_tp').text('0%');
		$('.porcentajeerrorbrm_enl').text('0%');
		$('.porcentajeerrorbrm_tfe').text('0%');
		$('.porcentajeerroru2000T').text('0%');
		
		$('.totalBRMT').text('');
		$('.totalU2000T').text('');
		$('.totalT').text('');
}
$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });

//같같같같같같같같같같같같같같같같같같같같같같같같같같같�
function getValor() {
//	console.log("BRM-DN vs IMS-DN");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}