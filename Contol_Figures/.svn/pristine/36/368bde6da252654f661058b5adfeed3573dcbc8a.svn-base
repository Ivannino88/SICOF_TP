$(function (){
	init();
});
function init(){
	initCalendar();
}
function initCalendar(){
	$('#datetimepicker').datepicker({
		setDate : new Date(),
		format : 'dd/mm/yyyy',
		autoclose : true,
		language : 'es',
		todayHighlight : true
	});
}
function sendSolicitud(){
	if($('#fecha').val() != ""){
		$('.fechaaCentral').text('D\u00CDA: '+$('#fecha').val());
		$('#fechaReporte').val($('#fecha').val());
		$.ajax({
			url : 'getSmallWorld',
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
$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });