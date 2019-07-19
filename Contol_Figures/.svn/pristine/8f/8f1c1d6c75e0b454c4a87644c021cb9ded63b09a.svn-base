

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
			url : 'getInstVsSalidasAlmacenSAPService',
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

					$('.fechaEt').text($('#fecha').val());
					$('#fechaReporte').val($('#fecha').val());
					
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
	$('.fechaReporte').text($('#fecha').val());
	$.each(result, function(index, valores){
		
		
		
		//Conciliado
		$('#T_Conciliados').html(accounting.formatNumber( valores.t_conciliados ));
		var porcentaje = (1 - ((parseInt(valores.total) - parseInt(valores.t_conciliados)) / parseInt(valores.total)))*100 ;
		$('#porcentaje').html(accounting.toFixed(porcentaje, 2) + ' %' );
//		//No conciliado
		$('#Error_Total').html(accounting.formatNumber( valores.error_total ));
		var porcentajeErr = (1 - ((parseInt(valores.total) - parseInt(valores.error_total)) / parseInt(valores.total)))*100 ;
		$('#porcentajeError_Total').html(accounting.toFixed(porcentajeErr, 2) + ' %' );
		$('#Error_Brm').html(accounting.formatNumber( valores.error_brm ));
		$('#Error_sap').html(accounting.formatNumber( valores.error_sap ));
//		
		$('#No_Brm').html(accounting.formatNumber( valores.no_brm ));
		$('#No_Sap').html(accounting.formatNumber( valores.no_sap ));
		$('#Total').html(accounting.formatNumber( valores.total ));
		
		var porcentajeErrorBRM = (1 - ((parseInt(valores.no_brm) - parseInt(valores.error_brm)) / parseInt(valores.no_brm)))*100 ;
		var porcentajeErrorSAP = (1 - ((parseInt(valores.no_sap) - parseInt(valores.error_sap)) / parseInt(valores.no_sap)))*100 ;
		$('#porcentajeErrorBRM').html(accounting.toFixed(porcentajeErrorBRM, 2) + ' %' );
		$('#porcentajeErrorSAP').html(accounting.toFixed(porcentajeErrorSAP, 2) + ' %' );
		
		var porcentajeTotal = (1 - ((parseInt(valores.total) - parseInt(valores.t_conciliados)) / parseInt(valores.total)))*100 ;
		$('#porcentajeTotal').html(accounting.toFixed(porcentajeTotal, 2) + ' %' );
		
		$('#Empresa').html(valores.empresa);
		if(valores.empresa == 'TOTALPLAY'){
			$('#conciliado').css( "background", "#bed539" );
			$('#conciliado1').css( "background", "#bed539" );
			$('#conciliado2').css( "background", "#bed539" );
			$('#noConciliado').css( "background", "#bed539" );
			$('#noConciliado1').css( "background", "#bed539" );
			$('#noConciliado2').css( "background", "#bed539" );
			$('#totalSAP').css( "color", "#bed539" );
			$('#totalBRM').css( "color", "#bed539" );
			$('#totalGeneral').css( "color", "#bed539" );
			
			
			
		}
		
		
		
		if(valores.status == 'SI' ){
			$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
		}else{
			$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
		}
		
		var botones = '';
		var porcentajeBRM = (1 - ((parseInt(valores.no_brm) - parseInt(valores.error_brm)) / parseInt(valores.no_brm)))*100; 
		var porcentajeSAP = (1 - ((parseInt(valores.no_sap) - parseInt(valores.error_sap)) / parseInt(valores.no_sap)))*100;
//		alert(porcentajeBRM);
//		alert(porcentajeIPTV);
		
		if(porcentajeBRM ==100){
			if(valores.status == 'SI' ){
				botones = '<img src="/CifrasControl/img/green.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}
//		}else if(porcentajeBRM > 1 && porcentajeBRM <= 15 ){
//			botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
		}else{
			if(valores.status == 'SI' ){
				botones = '<img src="/CifrasControl/img/green.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}
		}
		$('.bcolorBRM').html(botones);
		
		if(porcentajeSAP ==100){
			if(valores.status == 'SI' ){
				botones = '<img src="/CifrasControl/img/green.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}
//		}else if(porcentajeSAP > 1 && porcentajeSAP <= 15 ){
//			botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
		}else{
			if(valores.status == 'SI' ){
				botones = '<img src="/CifrasControl/img/green.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}
		}
		$('.bcolorSAP').html(botones);
		
		
////		$(".modal").hide();
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
	$('#Total').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentajeErrorBRM').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#porcentajeErrorSAP').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#porcentajeTotal').html(accounting.toFixed(valorInicial, 2) + ' %' );
	
	$('#Empresa').html(" ");
}

$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });

// 같같같같같같같같같같같같같같같같같같같같같같같같같같같�
function getValor() {
//	console.log("Instalaciones vs. Salidas de Almac&eacute;n SAP - BRM");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}


