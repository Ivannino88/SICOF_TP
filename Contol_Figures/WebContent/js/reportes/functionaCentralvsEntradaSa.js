function sendSolicitud(){
	if($('#fecha').val() != ""){
		$('.fechaaCentral').text('D\u00CDA: '+$('#fecha').val());
		$.ajax({
			url : 'getCentalvsEntradaAlamacen',
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
					setCentalvsEntradaAlamacen(jsonResponse.result);
				}else{
					$('.dateFail').text($('#fecha').val());
					$('#errorModal').modal();
					$('.contentMessage').show('fade');
					$('.contentReporte').hide('fade');
				}		
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
			}
		});
	}
}
function setCentalvsEntradaAlamacen(result){
	var botones = '';
	var cantidad  = 0;
	var cantidad_salida = 0;
	var porcentaje = 0;
	$.each(result, function(index, valores){
		cantidad += parseInt((valores.cantidad));
		cantidad_salida += parseInt((valores.cantidad_salida));
	});
	$('.status').text("Conciliado");
	$('.cantidad').text(cantidad);
	porcentaje = ((cantidad*100)/cantidad_salida);
	$('.porcentaje').text(porcentaje + '%');
	$('.total1').text(cantidad);
	$('.total2').text(cantidad_salida);
	
	$('.porcentaje2').text(porcentaje + '%');
	if(porcentaje == 100){
		$('.totalg').text(cantidad);
		$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	}else{
		$('.totalg').text('-'+(cantidad_salida-cantidad));
		$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	}
	if(porcentaje <100){
		botones = '<img src="/CifrasControl/img/red.png" height="20" width="20" class="img-responsive" alt="Responsive image">';
//	}else if(porcentaje > 30 && porcentaje <= 60 ){
//		botones = '<img src="/CifrasControl/img/yellow.png" height="20" width="20" class="img-responsive" alt="Responsive image">';
	}else{
		botones = '<img src="/CifrasControl/img/green.png" height="20" width="20" class="img-responsive" alt="Responsive image">';
	}
		
	$('.bcolor').html(botones);
}
$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });