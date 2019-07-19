//alert("canalesBRMvsIPTVAdicionales");
$('.detalle').click(function(){
	$('#myModal').modal('show');
});
function cleanX(){
	$('#NoData').text('');
	$('.tituloTabla').text('');
	$('#tableModal').bootstrapTable('destroy');
	$('.table-result').show();	
}
function consultaX1(){
	cleanX();
	pintaReporte1($('#fecha').val());
	}
function consultaX2(){
	cleanX();
	pintaReporte2($('#fecha').val());
	}

function pintaReporte1(fech){
	if(fech != ""){	
		$.ajax({
			url : 'exportDetalleCanalesBRMvsIPTVAdicionalesDetailsTablaJson',
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
					$('.tituloTabla').text("Detalle de IPTV adicionales que no estan en BRM ");
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
					        field: 'nombre',
					        title: 'Nombre',
					        sortable: true
					    }, {
					        field: 'plan',
					        title: 'Plan',
					        sortable: true
					    }, {
					        field: 'status_cuenta',
					        title: 'Status Cuenta',
					        sortable: true
					    }, {
					        field: 'nombre',
					        title: 'Nombre',
					        sortable: true
					    }, {
					        field: 'addon',
					        title: 'Add On',
					        sortable: true
					    }, {
					        field: 'fecha_aprovisanamiento',
					        title: 'Fecha Aprovisionamiento',
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
			url : 'exportDetalleCanalesBRMvsIPTVAdicionalesDetailsTablaJson2',
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
					$('.tituloTabla').text("Detalle de BRM adicionales que no estan en IPTV");
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
					        field: 'tipo_servicio',
					        title: 'Tipo de Servicio',
					        sortable: true
					    }, {
					        field: 'poid_purchased_product',
					        title: 'Poid Puschased Product',
					        sortable: true
					    }, {
					        field: 'poid_product',
					        title: 'Poid Product',
					        sortable: true
					    },  {
					        field: 'nombre_producto',
					        title: 'Nombre del Producto',
					        sortable: true
					    }, {
					        field: 'descr',
					        title: 'Descripción',
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
//	alert("configurando");
		if($('#fecha').val() != ""){
		$.ajax({
			url : 'getCanalesBRMvsIPTVAdicionales',
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
						
				    	$('#tableModal').bootstrapTable('destroy');
				    	$('.tituloTabla').text('');
				    	$('#NoData').text('');
						
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
	var botones = '';
	var total = 0;
	var t_conciliados  = 0;
	var porcentajeConc = 0;
	var t_no_conciliados = 0;
	var porcentajeNoConc = 0;
	var error_brm = 0;
	var error_u2000 = 0;
	var total_brm = 0;
	var porcentajeerrorbrm = 0;
	var total_u2000 = 0;
	var porcentajeerroru2000 = 0;
	
	$('#fechaReporte').val($('#fecha').val());
	limpiaCampos();
	
	$.each(result, function(index, valores){ 
		total += parseInt(valores.total);
		t_conciliados += parseInt(valores.t_conciliados);
		t_no_conciliados  += parseInt(valores.error_total);
		error_brm += parseInt(valores.error_brm);
		error_u2000 += parseInt(valores.error_iptv);
		total_brm += parseInt(valores.no_brm);
		total_u2000 += parseInt(valores.no_iptv);		
		if(valores.empresa == 'FULL'){
			$('.statusConcTP').text("Conciliado");
			$('.t_conciliadosTP').text(accounting.formatNumber(valores.t_conciliados));
			
			$('.porcentajeConcTP').text(valores.porcentajeconc + '%');
			
			$('.statusNoConcTP').text("No Conciliado");
			$('.t_no_conciliadosTP').text(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcTP').text(valores.porcentajenoconc + '%');
			
			$('.error_brmTP').text(accounting.formatNumber(valores.error_brm));
			$('.error_u2000TP').text(accounting.formatNumber(valores.error_iptv));
			
			$('.porcentajeerrorbrmTP').text(valores.porcentajeerrorbrm+ '%');
			$('.porcentajeerroru2000TP').text(valores.porcentajeerroru2000+ '%');

			$('.totalBRMTP').text(accounting.formatNumber(valores.no_brm));
			$('.totalU2000TP').text(accounting.formatNumber(valores.no_iptv));
			$('.totalTP').text(accounting.formatNumber(valores.total));	
		
			

			
			if(valores.porcentajeerrorbrm ==100){
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
//			}else if(valores.porcentajeerrorbrm > 1 && valores.porcentajeerrorbrm <= 15 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}
			$('.bcolorBRMTP').html(botones);
			
			if(valores.porcentajeerroru2000 ==100){
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
//			}else if(valores.porcentajeerroru2000 > 1 && valores.porcentajeerroru2000 <= 15 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}
			

			$('.bcolorU2000TP').html(botones);
			
			
		} else if(valores.empresa == 'ENLACE'){
			$('.statusConcENL').text("Conciliado");
			$('.t_conciliadosENL').text(accounting.formatNumber(valores.t_conciliados));
			$('.porcentajeConcENL').text(valores.porcentajeconc + '%');
			
			$('.statusNoConcENL').text("No Conciliado");
			$('.t_no_conciliadosENL').text(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcENL').text(valores.porcentajenoconc + '%');
			
			$('.error_brmENL').text(accounting.formatNumber(valores.error_brm));
			$('.error_u2000ENL').text(accounting.formatNumber(valores.error_u2000));
			
			$('.porcentajeerrorbrmENL').text(valores.porcentajeerrorbrm+ '%');
			$('.porcentajeerroru2000ENL').text(valores.porcentajeerroru2000+ '%');

			$('.totalBRMENL').text(accounting.formatNumber(valores.no_brm));
			$('.totalU2000ENL').text(accounting.formatNumber(valores.no_u2000));
			$('.totalENL').text(accounting.formatNumber(valores.total));
			
			if(valores.porcentajeerrorbrm ==100){
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
//			}else if(valores.porcentajeerrorbrm > 1 && valores.porcentajeerrorbrm <= 15 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}
			$('.bcolorBRMENL').html(botones);
			
			if(valores.porcentajeerroru2000 ==100){
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
//			}else if(valores.porcentajeerroru2000 > 1 && valores.porcentajeerroru2000 <= 15 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}
			$('.bcolorU2000ENL').html(botones);
			
		} else if(valores.empresa == 'TFE'){
			$('.statusConcTFE').text("Conciliado");
			$('.t_conciliadosTFE').text(accounting.formatNumber(valores.t_conciliados));
			$('.porcentajeConcTFE').text(valores.porcentajeconc + '%');
			
			$('.statusNoConcTFE').text("No Conciliado");
			$('.t_no_conciliadosTFE').text(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcTFE').text(valores.porcentajenoconc + '%');
			
			$('.error_brmTFE').text(accounting.formatNumber(valores.error_brm));
			$('.error_u2000TFE').text(accounting.formatNumber(valores.error_u2000));
			
			$('.porcentajeerrorbrmTFE').text(valores.porcentajeerrorbrm+ '%');
			$('.porcentajeerroru2000TFE').text(valores.porcentajeerroru2000+ '%');

			$('.totalBRMTFE').text(accounting.formatNumber(valores.no_brm));
			$('.totalU2000TFE').text(accounting.formatNumber(valores.no_u2000));
			$('.totalTFE').text(accounting.formatNumber(valores.total));
			
			if(valores.porcentajeerrorbrm ==100){
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
//			}else if(valores.porcentajeerrorbrm > 1 && valores.porcentajeerrorbrm <= 15 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}
			$('.bcolorBRMTFE').html(botones);
			
			if(valores.porcentajeerroru2000 ==100){
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
//			}else if(valores.porcentajeerroru2000 > 1 && valores.porcentajeerroru2000 <= 15 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				if(valores.status == "SI"){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}
			$('.bcolorU2000TFE').html(botones);
		}
	});
	
	$('.statusConcT').html("Conciliado");
	$('.t_conciliadosT').html(""+accounting.formatNumber(t_conciliados));
	porcentajeConc = (total>0)?((t_conciliados * 100)/total):0;
	$('.porcentajeConcT').text(accounting.toFixed(porcentajeConc,2) + '%');
	
	$('.statusNoConcT').html("No Conciliado");
	$('.t_no_conciliadosT').html(accounting.formatNumber(t_no_conciliados));
	porcentajeNoConc = (total>0)?((t_no_conciliados * 100)/total):0;
	$('.porcentajeNoConcT').html(accounting.toFixed(porcentajeNoConc,2) + '%');
	
	$('.error_brmT').html(""+accounting.formatNumber(error_brm));
	$('.error_u2000T').html(""+accounting.formatNumber(error_u2000));
	
	porcentajeerrorbrm = (total>0)?((error_brm * 100)/total):0;
	$('.porcentajeerrorbrmT').html(""+accounting.toFixed(porcentajeerrorbrm,2)+ '%');
	porcentajeerroru2000 = (total>0)?((error_u2000 * 100)/total):0;
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
	// -----   GRAFICA TOTALES ------------------	 
	 var gTOTAL;
	 gTOTAL= new JustGage({
		    id:"grafica",
		    //label: "label",
//		    title: "TOTAL",
//		    titleFontColor: "#4c56de", // color azul
//		    titleFontFamily: "Georgia",
//	        titlePosition: "up",
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
	$('.bcolorU2000T').html(botones);
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
		
		$('.error_brmTP').text('');
		$('.error_u2000TP').text('');
		
		$('.porcentajeerrorbrmTP').text('0%');
		$('.porcentajeerroru2000TP').text('0%');

		$('.totalBRMTP').text('');
		$('.totalU2000TP').text('');
		$('.totalTP').text('');	
	
		$('.statusConcENL').text("Conciliado");
		$('.t_conciliadosENL').text('-');
		$('.porcentajeConcENL').text('0%');
		
		$('.statusNoConcENL').text("No Conciliado");
		$('.t_no_conciliadosENL').text('-');
		$('.porcentajeNoConcENL').text('0%');
		
		$('.error_brmENL').text('');
		$('.error_u2000ENL').text('');
		
		$('.porcentajeerrorbrmENL').text('0%');
		$('.porcentajeerroru2000ENL').text('0%');

		$('.totalBRMENL').text('');
		$('.totalU2000ENL').text('');
		$('.totalENL').text('');
		
		$('.statusConcTFE').text("Conciliado");
		$('.t_conciliadosTFE').text('-');
		$('.porcentajeConcTFE').text('0%');
		
		$('.statusNoConcTFE').text("No Conciliado");
		$('.t_no_conciliadosTFE').text('-');
		$('.porcentajeNoConcTFE').text('0%');
		
		$('.error_brmTFE').text('');
		$('.error_u2000TFE').text('');
		
		$('.porcentajeerrorbrmTFE').text('0%');
		$('.porcentajeerroru2000TFE').text('0%');

		$('.totalBRMTFE').text('');
		$('.totalU2000TFE').text('');
		$('.totalTFE').text('');	

		$('.statusConcT').text("Conciliado");
		$('.t_conciliadosT').text('-');
		$('.porcentajeConcT').text('0%');
		
		$('.statusNoConcT').text("No Conciliado");
		$('.t_no_conciliadosT').text('-');
		$('.porcentajeNoConcT').text('0%');
		
		$('.error_brmT').text('');
		$('.error_u2000T').text('');
		
		$('.porcentajeerrorbrmT').text('0%');
		$('.porcentajeerroru2000T').text('0%');
		
		$('.totalBRMT').text('');
		$('.totalU2000T').text('');
		$('.totalT').text('');
}
$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });


//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
function getValor() {
//	console.log("Adicionales TV-BRM vs Adicionales IPTV");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')|| (botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}