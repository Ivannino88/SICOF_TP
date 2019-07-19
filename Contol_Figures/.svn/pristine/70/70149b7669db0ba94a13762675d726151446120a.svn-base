function cargaReporte(){
	console.log('function cargaReporte()');
	if($('#fecha').val() != ""){
		$.ajax({
			url : 'getSeriesSap',
			type : "POST",
			async : false,
			data : {'fecha' : $('#fecha').val()},
			dataType : "json",
			 beforeSend: function( xhr ) {
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#loadModal').modal('hide');
				if(jsonResponse.success){
					
					
					$.each(jsonResponse.result, function(index, valores){ 
					$('.idConsulta').val(valores);
				
				});
					$('.contentMessage').hide('fade');
			    	$('#tableModal').bootstrapTable('destroy');
					setReporte(jsonResponse.result);
					
				}else{
					limpiaCampos();
					$('#errorModal').modal();
					$('.contentMessage').show('fade');
				}
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
			}
		});
	}else{
		console.log('sin fecha de entrada');
	}
}