//alert("Product Master vs Servicios-BRM");
$('.detalle').click(function(){
	cleanX();
	$('#myModal').modal('show');
});
function cleanX(){
	$('#NoData').text('');
	$('.tituloTabla').text('');
	$('#tableModal').bootstrapTable('destroy');
	$('.table-result').show();	
}
function consultaX(){
	cleanX();
	pintaReporte1($('#fecha').val());
	}



$('#myform').on('submit', function(ev) {
	
//	var fech = $('#fechaReporteTabla').val();	
//	console.log("fecha de consulta-: " + $('#fecha').val());
	
	$('#radioButtonContainerId input:radio').click(function() {
		
		$('.table-result').show();
	    if ($(this).val() === '1') {
	    	$('#tableModal').bootstrapTable('destroy');
	    	$("#op1").prop("checked", false);
	    	$('#NoData').text('');
	    	$('.tituloTabla').text('');
	    	pintaReporte1($('#fecha').val());
	    	
	    } 
//	    else if ($(this).val() === '2') {
//	    	$('#tableModal').bootstrapTable('destroy');
//	    	$("#op1").prop("checked", false);
//	    	$('#NoData').text('');
//	    	pintaReporte2(fech);
//	    } 
	});
	
    $('#myModal').modal('show');
    ev.preventDefault();
});


function pintaReporte1(fech){
	
	if(fech != ""){	
		
		$.ajax({
			url : 'exportPaqvsProductIncBRMTablaJson',
			type : "POST",
			async : true,
			data : {'fechaTabla' :fech},
			dataType : "json",
			 beforeSend: function( xhr ) {
				 $('#wait').modal({backdrop: 'static', keyboard: false});
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#wait').modal('hide');
				if(jsonResponse.success){
																			
					$('.tituloTabla').text("Detalle de paquetes por cliente vs Productos Incluidos BRM - PM");
					//console.log("Detalle VODS");
										
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    search: true, 
					    
					    columns: [{
					        field: 'id',
					        title: 'Id',
					        sortable: true
					    }, {
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
					        field: 'tmcode',
					        title: 'TM Code',
					        sortable: true
					    },{
					        field: 'empresa',
					        title: 'Empresa',
					        sortable: true
					    }, {
					        field: 'tipo_servicio',
					        title: 'Tipo de Servicio',
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

function sendSolicitud(){
	if($('#fecha').val() != ""){
		$.ajax({
			url : 'getPaqvsProductIncBRM',
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
					
					$('#fechaReporteTabla').val($('#fecha').val());
					
					$("#op1").prop("checked", false);
			    	$('#tableModal').bootstrapTable('destroy');
			    	$('.tituloTabla').text('');
			    	$('#NoData').text('');
					
					
					setPaqvsProductIncBRM(jsonResponse.result);
					
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
function setPaqvsProductIncBRM(result){

	var botones = '';
	limpiaCampos();
	
	$.each(result, function(index, valores){ 

		$('.statusConcTP').text("Conciliado");
		$('.t_conciliadosTP').text(accounting.formatNumber(valores.t_conciliados));
		$('.porcentajeConcTP').text(valores.porcentajeconciliado + '%');
		
		$('.statusNoConcTP').text("No Conciliado");
		$('.t_no_conciliadosTP').text(accounting.formatNumber(valores.error_total));
		$('.porcentajeNoConcTP').text(valores.porcentajenoconciliado + '%');
		
		$('.error_pmTP').text(accounting.formatNumber(valores.error_pm));
		$('.error_brmTP').text(accounting.formatNumber(valores.error_brm));
		
		$('.porcentajeerrorpmTP').text(valores.porcentajeerrorpm+ '%');
		$('.porcentajeerrorbrmTP').text(valores.porcentajeerrorbrm+ '%');

		$('.totalPMTP').text(accounting.formatNumber(valores.no_pm));
		$('.totalBRMTP').text(accounting.formatNumber(valores.no_brm));
		$('.totalTP').text(accounting.formatNumber(valores.total));	
	

		if(valores.estatus == "SI" ){
			$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
		}else{
			$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
		}
		
		if(valores.porcentajeerrorpm ==100){
			if(valores.estatus== "SI"){
				botones = '<img src="/CifrasControl/img/green.png">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png">';
			}
//		}else if(valores.porcentajeerrorpm <99 && valores.porcentajeerrorpm >=75){
//			botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
		}else{
			if(valores.estatus== "SI"){
				botones = '<img src="/CifrasControl/img/green.png">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png">';
			}
		}
		$('.bcolorPMTP').html(botones);
		
		if(valores.porcentajeerrorbrm ==100){
			if(valores.estatus== "SI"){
				botones = '<img src="/CifrasControl/img/green.png">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png">';
			}
//		}else if(valores.porcentajeerrorbrm >= 1 && valores.porcentajeerrorbrm < 26 ){
//			botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
		}else if(valores.porcentajeerrorbrm <100 ){
			if(valores.estatus== "SI"){
				botones = '<img src="/CifrasControl/img/green.png">';
			}else{
				botones = '<img src="/CifrasControl/img/red.png">';
			}
		}
		var gTOTAL; 
		 gTOTAL= new JustGage({
			    id:"grafica",
			    //label: "label",
//			    title: "TOTAL",
//			    titleFontColor: "#4c56de", // color azul
//			    titleFontFamily: "Georgia",
//		        titlePosition: "up",
			    value: valores.porcentajeconciliado,
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
		$('.bcolorBRMTP').html(botones);
	});
	
}

function limpiaCampos(){
	$('#grafica').text(''); //-- inicializar bacio
	$('.decision').html("");
	
	$('.statusConcTP').text("Conciliado");
	$('.t_conciliadosTP').text('-');
	$('.porcentajeConcTP').text('0%');
	$('.statusNoConcTP').text("No Conciliado");
	$('.t_no_conciliadosTP').text('-');
	$('.porcentajeNoConcTP').text('0%');
	$('.error_pmTP').text('');
	$('.error_brmTP').text('');
	$('.porcentajeerrorpmTP').text('0%');
	$('.porcentajeerrorbrmTP').text('0%');
	$('.totalPMTP').text('');
	$('.totalBRMTP').text('');
	$('.totalTP').text('');	
	
	$('.bcolorPMTP').html('');
	$('.bcolorBRMTP').html('');
}
$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });

//같같같같같같같같같같같같같같같같같같같같같같같같같같같�
function getValor() {
//	console.log("Product Master vs Servicios-BRM");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}