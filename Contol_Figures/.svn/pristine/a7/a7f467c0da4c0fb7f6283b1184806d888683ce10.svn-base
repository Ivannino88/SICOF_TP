$(function() {
	initctasXCicloVsCtasFact();
	initCalendar();
});
function initCalendar(){
	$('.datepicker').datepicker('setDate', new Date());
}
function initctasXCicloVsCtasFact() {
	//initClass();
	initComponentsctasXCicloVsCtasFact();
}
function initComponentsctasXCicloVsCtasFact() {
	$('.datepicker').on("changeDate",function () {
		cargaReporte();
	  });
}

function cargaReporte(){
	$
	.ajax({
		url : 'getReporteInstalacionesVSalmacen_cifras_sapbrms',
		//async : false,
		type : "POST",
		dataType : "json",
		data : {
			'fecha'	: $('#fecha').val()
			},
		success : function(jsonResponse, textStatus, jqXHR) {
			if (jsonResponse.success == true) {
				console.log(jsonResponse);
				$('#totalDeBase').html(jsonResponse.result.no_brm);
				$('#totalDeBaseSap').html(jsonResponse.result.no_sap);
				$('#total').html(jsonResponse.result.total);
				$('#dispositivos').html(jsonResponse.result.t_conciliados);
				$('#porcentaje').html(jsonResponse.result.porcentaje+" %");
				$('#no_found_brm').html(jsonResponse.result.no_found_brm);
				$('#no_found_sap').html(jsonResponse.result.no_found_sap);
				$('#no_found_brm_porc').html(jsonResponse.result.no_found_brm_porc+" %");
				$('#no_found_sap_porc').html(jsonResponse.result.no_found_sap_porc+" %");
				$('#total_no_found').html(jsonResponse.result.no_founds_total);
				$('#total_no_founds_proc').html(jsonResponse.result.no_founds_porc_total+" %");
				if(jsonResponse.result.status == 'SI'){
					$('#imgResultado').attr('src','/CifrasControl/img/tick.png');
				}else{
					$('#imgResultado').attr('src','/CifrasControl/img/icono_alerta.png');
				}
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			var error = new Object();
			error.mensaje = "Ocurrio un error al intentar procesar su peticion, por favor reintentelo.";
		}
	});
}
$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });