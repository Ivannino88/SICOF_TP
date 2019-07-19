$(function() {
	init();
});
function init() {
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

function listaCanales(){
	if($('#selectEmpresa').val()!=""){
		$.ajax({
			url : 'getListaCanal',
			type : "POST",
			data : {
			'empresa'	:	 $('#selectEmpresa').val().toString()
				},
			dataType : "json",
			beforeSend: function( xhr ) {
				 $('#loadModal').modal();
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#loadModal').modal('hide');
				if(jsonResponse.success){
					console.log(jsonResponse);
					listaCanal(jsonResponse);					
				}
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
				$('#loadModal').modal('hide');
			}
		});
		
	}
}

function listaCanal(jsonResponse){
	$( "#selectCanal option:selected" ).text("--Selecciona--");
	$.each(jsonResponse.result, function(index, arrayValores){ 		
		 $('#selectCanal').append($('<option>', { 
		        value: arrayValores.canal,
		        text : arrayValores.canal 
		    }));
	});
}

function consultaReporte(){
	if($('#fecha').val() != "" && $('#selectEmpresa').val() != ""  &&  $('#selectCanal').val() != "" ){
		$.ajax({
			url : 'getConciliacionBrmBancos',
			type : "POST",
			async : false,
			data : {
				'fecha' : $('#fecha').val(),
				'empresa' : $('#selectEmpresa').val(),
				'tipo_conciliacion' : $('#selectCanal').val()
				},
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
					
					setCtasActBRMvsPAGOS(jsonResponse.result);
					
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
}
function setCtasActBRMvsPAGOS(result){
	var botones = '';
	var total = 0;
	var t_conciliados  = 0;
	var t_no_conciliados = 0;
	var error_brm = 0;
	var error_pagos = 0;
	var total_brm = 0;
	var total_pagos = 0;

	limpiaCampos();
	
	$.each(result, function(index, valores){ 
		
		total += parseInt(valores.total);
		t_conciliados += parseInt(valores.t_conciliados);
		t_no_conciliados  += parseInt(valores.error_total);
		error_brm += parseInt(valores.error_brm);
		error_pagos += parseInt(valores.error_pagos);
		total_brm += parseInt(valores.no_brm_pagos);
		total_pagos += parseInt(valores.no_pagos);

			
			$('#empresa').text(valores.empresa);
			$('.statusConcTP').text("Conciliado");
			$('.t_conciliadosTP').text(accounting.formatNumber(valores.t_conciliados));
			$('.porcentajeConcTP').text(valores.porcentajeconc + '%');
			
			$('.statusNoConcTP').text("No Conciliado");
			$('.t_no_conciliadosTP').text(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcTP').text(valores.porcentajenoconc + '%');
			
			$('.error_brmTP').text(accounting.formatNumber(valores.error_brm));
			$('.error_pagosTP').text(accounting.formatNumber(valores.error_pagos));
			
			$('.porcentajeerrorbrmTP').text(valores.porcentajeerrorbrm+ '%');
			$('.porcentajeerrorpagosTP').text(valores.porcentajeerrorpagos+ '%');

			$('.totalBRMTP').text(accounting.formatNumber(valores.no_brm_pagos));
			$('.totalpagosTP').text(accounting.formatNumber(valores.no_pagos));
			$('.totalTP').text(accounting.formatNumber(valores.total));	
		

			if(valores.status == "SI" ){
				$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}else{
				$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}
			
			if(valores.porcentajeerrorbrm ==100){
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
				}
//			}else if(valores.porcentajeerrorbrm <99 && valores.porcentajeerrorbrm >=75){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else if(valores.porcentajeerrorbrm <100 ){
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
				}
			}
			$('.bcolorBRMTP').html(botones);
			
			if(valores.porcentajeerrorpagos ==100){
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
				}
//			}else if(valores.porcentajeerrorpagos >= 1 && valores.porcentajeerrorpagos < 26 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else if(valores.porcentajeerrorpagos <100 ){
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
				}
			}
			$('.bcolorPAGOSTP').html(botones);
			
			
		
	});
	
	
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
		$('.error_pagosTP').text('');
		
		$('.porcentajeerrorbrmTP').text('0%');
		$('.porcentajeerrorpagosTP').text('0%');

		$('.totalBRMTP').text('');
		$('.totalPAGOSTP').text('');
		$('.totalTP').text('');	
		}
$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });