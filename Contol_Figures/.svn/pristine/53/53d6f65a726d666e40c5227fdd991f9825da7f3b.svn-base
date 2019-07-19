//	alert("online");
$('.detalleDia').click(function(){
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
	//console.log("fechaReporte: " + fech);
	
	$('#radioButtonContainerId input:radio').click(function() {
		
		$('.table-result').show();
	    if ($(this).val() === '1') {
	    	$('#tableModal').bootstrapTable('destroy');
	    	$("#op2").prop("checked", false);
	    	$('#NoData').text('');
	    	pintaReporte1($('#fecha').val());
	    	
	    } else if ($(this).val() === '2') {
	    	$('#tableModal').bootstrapTable('destroy');
	    	$("#op1").prop("checked", false);
	    	$('#NoData').text('');
	    	pintaReporte2($('#fecha').val());
	    } 
	});
	
    $('#myModal').modal('show');
    ev.preventDefault();
});


function pintaReporte1(fech){
//	console.log("reporte #1---");
	if(fech != ""){	
		
		$.ajax({
			url : 'exportgetDetalleVodsTablaJson',
			type : "POST",
			async : true,
			data : {'fechatabla' :fech},
			dataType : "json",
			 beforeSend: function( xhr ) {
				 $('#wait').modal({backdrop: 'static', keyboard: false});
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#wait').modal('hide');
				if(jsonResponse.success){
																			
					$('.tituloTabla').text("Detalle VODS ");
					//console.log("Detalle VODS");

										
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
					        field: 'account',
					        title: 'Cuenta',
					        sortable: true
					    }, {
					        field: 'usuario',
					        title: 'Usuario',
					        sortable: true
					    }, {
					        field: 'serie',
					        title: 'Serie',
					        sortable: true
					    }, {
					        field: 'titulo',
					        title: 'Título',
					        sortable: true
					    }, {
					        field: 'categoria',
					        title: 'Categoría',
					        sortable: true
					    }, {
					        field: 'calida',
					        title: 'Calidad',
					        sortable: true
					    }, {
					        field: 'precio',
					        title: 'Precio',
					        sortable: true
					    }, {
					        field: 'fecha_pe',
					        title: 'Fecha PE',
					        sortable: true
					    }, {
					        field: 'hora',
					        title: 'Hora',
					        sortable: true
					    }, {
					        field: 'numero_parte',
					        title: 'Número de Parte',
					        sortable: true
					    }, {
					        field: 'date_insert',
					        title: 'Date Insert',
					        sortable: true
					    }, {
					        field: 'date_last_update',
					        title: 'Date Last Update',
					        sortable: true
					    }, {
					        field: 'status',
					        title: 'Status',
					        sortable: true
					    }, {
					        field: 'login',
					        title: 'Login',
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
		console.log('consultainfo()');
		if($('#fecha').val() != ""){
		$.ajax({
			url : 'getConciliacionVodBrm',
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
						
						setCtasActBRMvsIMS(jsonResponse.result);
						$('#descargaArchivo').show();
						$('#fechaReporte').val( $('#fecha').val() );
						$('.contentMessage').hide('fade');
						$('.contentReporte').show('fade');
						$('.contentReporte02').hide('fade');  // **
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
	
	$('#fechaReporte').text($('#fecha').val());
	limpiaCampos();
	
	$.each(result, function(index, valores){ 
		total += parseInt(valores.total);
		t_conciliados += parseInt(valores.t_conciliacion);
		t_no_conciliados  += parseInt(valores.error_total);
		error_brm += parseInt(valores.error_brm);
		error_u2000 += parseInt(valores.error_vod);
		total_brm += parseInt(valores.no_brm);
		total_u2000 += parseInt(valores.no_vod);

		if(valores.empresa == 'FULL'){
			console.log("entrando a FULL ----- ");
			$('.statusConcTP').text("Conciliado");
			$('.t_conciliadosTP').text(accounting.formatNumber(valores.t_conciliados));
			$('.porcentajeConcTP').text(valores.porcentajeconc + '%');
			
			$('.statusNoConcTP').text("No Conciliado");
			$('.t_no_conciliadosTP').text(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcTP').text(valores.porcentajenoconc + '%');
			
			$('.error_brmTP').text(accounting.formatNumber(valores.error_brm));
			$('.error_u2000TP').text(accounting.formatNumber(valores.error_vod));
			
			$('.porcentajeerrorbrmTP').text(valores.porcentajeerrorbrm+ '%');
			$('.porcentajeerroru2000TP').text(valores.porcentajeerrorvod+ '%');

			$('.totalBRMTP').text(accounting.formatNumber(valores.no_brm));
			$('.totalU2000TP').text(accounting.formatNumber(valores.no_vod));
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
			console.log("entrando a ENLACE ----- ");
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
			console.log("entrando a TFE ----- ");
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

// --------############################################_______MODULO DE CONSULTA POR SEMANA_______

$(document).ready(function(){
	//console.log('entrando a vods Xxx');
	$('.semanaBtn').show('fade');
	$('.contentReporte02').hide('fade');
	fechaActualiptv();
	
});

function fechaActualiptv(){
	console.log('online fechaActual' );

//		console.log("dentro de fecha actual");
		$.ajax({
			url : 'getFechaActual',
			type : "POST",
			dataType : "json",
			async: false,
			success : function(jsonResponse, textStatus, jqXHR){				
				if(jsonResponse.success){
					$.each(jsonResponse.result,function(index, arrayValores) {
					$('#grafica').text('');
					 semanaactual=arrayValores.fecha_semana;	
					 mesactual=arrayValores.fecha_mes;
					 anioactual=arrayValores.fecha_anio;
					 $('.anhioActual').text(anioactual);
					});
				}},
			error : function(jqXHR, textStatus, errorThrown){
			}
			});
//		semana actual
	    for(var i=1;i<=53;i++){
	    if(i==semanaactual){
	    	 $("#selectsem").append('<option value="'+i+'" selected="'+i+'">'+i+'</option>');
	    } else{
	    	 $("#selectsem").append('<option value="'+i+'">'+i+'</option>');
	    	}
	    } 
//	    mes actual
	    var arrM=["Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"];
	    for(var j=0;j<arrM.length;j++){
			   if(j==mesactual-1){
				   $("#selectMes").append('<option value="'+arrM[j]+'" selected="'+arrM[j]+'">'+arrM[j]+'</option>');
			    } 
			   else{
			    	  $("#selectMes").append('<option value="'+arrM[j]+'">'+arrM[j]+'</option>');
			    	}
		   }
//	    año actual
	    var arr=["2016","2017","2018","2019"];
		   for(var i=0;i<arr.length;i++){
			   if(arr[i]==anioactual){
				   $("#selectanio").append('<option value="'+arr[i]+'" selected="'+arr[i]+'">'+arr[i]+'</option>');
			    	
			    } else{
			    	  $("#selectanio").append('<option value="'+arr[i]+'">'+arr[i]+'</option>');
			    	}
		   }  
//		   sendSolicitud();
}
//______________CONSULTA______________

	$('#Xsemana').click(function(){
		console.log('online por semana');
		$('#semana').show('fade');
		$('#anhio').show('fade');
		$('.diaBtn').show('fade');
		$('.semanaBtn').hide('fade');
		$('#calendario').hide('fade');
		$('.contentReporte').hide('fade');
		$('.contentReporte02').hide('fade');
		
		
		});
	
	$('#Xdia').click(function(){
		console.log('online por dia');
		$('#semana').hide('fade');
		$('#anhio').hide('fade');
		$('.diaBtn').hide('fade');
		$('.semanaBtn').show('fade');
		$('#calendario').show('fade');
		$('.contentReporte').hide('fade');
		$('.contentReporte02').hide('fade');
		 $('#grafica02').text(''); //-- inicializar bacio
		
		});
	
	
// grafica #2 consulta por semana:	
	function consultaXsemana(){
		console.log("consultaXsemana()_V1**");
		$('#grafica02').text(''); //-- inicializar bacio
		console.log('semana actual es: '+$( "select#selectsem option:checked" ).val());
		console.log('valor de anhio'+$('.anhioActual').text());
		console.log('año actual es: '+$( "select#selectanio option:checked" ).val());
		
		
		$('.contentReporte02').show('fade');
		if($( "select#selectsem option:checked" ).val() != ""){
		$.ajax({
			url : 'getConciliacionVodBrm02',
			type : "POST",
			async : false,
			data : {'semana' : $( "select#selectsem option:checked" ).val(),
						'fechaAnhio': $( "select#selectanio option:checked" ).val()},
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
				    	$('.detalleSemana').show('fade');
				    	setCtasActBRMvsIMS02(jsonResponse.result);
						$('#descargaArchivo').show();
						$('#semanaActual').val( $("select#selectsem option:checked").val() );
						$('#fechaAnhioS').val($( "select#selectanio option:checked" ).val());
//						console.log("XXXXXXXXXXXXXXXXxxxxx---->"+$("select#selectsem option:checked").val());
						$('.contentMessage').hide('fade');
						$('.contentReporte02').show('fade');
					}else{
						$('.dateFail').text($('#fecha').val());
						$('#errorModal').modal();
						$('.contentMessage').show('fade');
						$('.contentReporte02').hide('fade');
					}
				}else{
					$('.dateFail').text($('#fecha').val());
					$('#errorModal').modal();
					$('.contentMessage').show('fade');
					$('.contentReporte02').hide('fade');
					$('.detalleSemana').hide('fade');
				}		
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
				$('#loadModal').modal('hide');
			}
		});
	}
}

//  -- GENERA TABLA DE RESULTADOS --- 
	
	function setCtasActBRMvsIMS02(result){
		console.log('setCtasActBRMvsIMS02(result)');
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
		
		
		limpiaCampos();
		
		$.each(result, function(index, valores){ 
			total += parseInt(valores.total);
			t_conciliados = parseInt(valores.t_conciliacion);
			t_no_conciliados  = parseInt(valores.error_total);
			error_brm = parseInt(valores.error_brm);
			error_u2000 = parseInt(valores.error_vod);
			total_brm = parseInt(valores.no_brm);
			total_u2000 = parseInt(valores.no_vod);
			console.log(valores.tipo_conciliacion);
		});
	
		
		$('.t_conciliadosSem').html(""+accounting.formatNumber(t_conciliados));
		porcentajeConc = (total>0)?((t_conciliados * 100)/total):0;
		$('.porcentajeConcSem').text(accounting.toFixed(porcentajeConc,2) + '%');
		
		
		$('.t_no_conciliadosSem').html(accounting.formatNumber(t_no_conciliados));
		porcentajeNoConc = (total>0)?((t_no_conciliados * 100)/total):0;
		$('.porcentajeNoConcSem').html(accounting.toFixed(porcentajeNoConc,2) + '%');
		
		$('.error_brmSem').html(""+accounting.formatNumber(error_brm));
		$('.error_u2000Sem').html(""+accounting.formatNumber(error_u2000));
		
		porcentajeerrorbrm = (total>0)?((error_brm * 100)/total):0;
		$('.porcentajeerrorbrmSem').html(""+accounting.toFixed(porcentajeerrorbrm,2)+ '%');
		porcentajeerroru2000 = (total>0)?((error_u2000 * 100)/total):0;
		$('.porcentajeerroru2000Sem').text(""+accounting.toFixed(porcentajeerroru2000,2)+ '%');

		$('.totalBRMSem').html(""+accounting.formatNumber(total_brm));
		$('.totalU2000Sem').html(""+accounting.formatNumber(total_u2000));
		$('.totalSem').html(""+accounting.formatNumber(total));
		
		
		if(porcentajeConc == 100 ){
			$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
		}else{
			$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
		}

		if(porcentajeerrorbrm ==100){
			botones = '<img src="/CifrasControl/img/green.png">';
		}else if(porcentajeerrorbrm <100 ){
			botones = '<img src="/CifrasControl/img/red.png">';
		}
		$('.bcolorBRMT').html(botones);
		
		if(porcentajeerroru2000 ==100){
			botones = '<img src="/CifrasControl/img/green.png">';
		}else if(porcentajeerroru2000 <100 ){
			botones = '<img src="/CifrasControl/img/red.png">';
		}
		// -----   GRAFICA TOTALES ------------------	 
		 var gTOTAL;
		 gTOTAL= new JustGage({
			    id:"grafica02",
			    value: porcentajeConc,
			    //value: 20,
			    valueFontColor: " #757669 ",
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
			    donut: true
			  });
		$('.bcolorU2000T').html(botones);
	}

// ----------- MODAL DETALLE SEMANA 
	
	$('.detalleSemana').click(function(){
		cleanSem();
		$('#myModal02').modal('show');
		$('#actual').text($( "select#selectsem option:checked" ).val());
	});

	
	function reporteSemana(){
	console.log("*****************************");
	semana = 	$( "select#selectsem option:checked" ).val();
	console.log("reporte semana---"+ semana);
		if(semana != ""){	
			
			$.ajax({
				url : 'exportgetDetalleVodsTablaJsonSemana',
				type : "POST",
				async : true,
				data : {'semana' :$( "select#selectsem option:checked" ).val(),
							'fechaAnhio': $( "select#selectanio option:checked" ).val()},
				dataType : "json",
				 beforeSend: function( xhr ) {
					 $('#cargando').modal({backdrop: 'static', keyboard: false});
//					 $('').show('fade');
				 },
				success : function(jsonResponse, textStatus, jqXHR){
					$('#cargando').modal('hide');
					if(jsonResponse.success){
																				
						$('.tituloTabla').text("Detalle VODS ");
						//console.log("Detalle VODS");

											
						$('#tableModalSemana').bootstrapTable({
						    data : jsonResponse.result,
						    pagination:true,
						    striped: true,
						    search: true,
						    
						    columns: [{
						        field: 'fecha',
						        title: 'Fecha',
						        sortable: true
						    }, {
						        field: 'account',
						        title: 'Cuenta',
						        sortable: true
						    }, {
						        field: 'usuario',
						        title: 'Usuario',
						        sortable: true
						    }, {
						        field: 'serie',
						        title: 'Serie',
						        sortable: true
						    }, {
						        field: 'titulo',
						        title: 'Título',
						        sortable: true
						    }, {
						        field: 'categoria',
						        title: 'Categoría',
						        sortable: true
						    }, {
						        field: 'calidad',
						        title: 'Calidad',
						        sortable: true
						    }, {
						        field: 'precio',
						        title: 'Precio',
						        sortable: true
						    }, {
						        field: 'fecha_pe',
						        title: 'Fecha PE',
						        sortable: true
						    }, {
						        field: 'hora',
						        title: 'Hora',
						        sortable: true
						    }, {
						        field: 'numero_parte',
						        title: 'Número de Parte',
						        sortable: true
						    }, {
						        field: 'date_insert',
						        title: 'Date Insert',
						        sortable: true
						    }, {
						        field: 'date_last_update',
						        title: 'Date Last Update',
						        sortable: true
						    }, {
						        field: 'status',
						        title: 'Status',
						        sortable: true
						    }, {
						        field: 'login',
						        title: 'Login',
						        sortable: true
						    }, {
						        field: 'vpu_id',
						        title: 'VPU_ID',
						        sortable: true
						    }]
						});
													
						
					}else{
						$('.tituloTabla02').text('');
						$('#NoData02').text("No se encontraron datos");
						//console.log("Error en la tabla");
											
					}
				},
				error : function(jqXHR, textStatus, errorThrown){
					console.log(textStatus);
				}
			});
		}
		
	
	}
	
	function cleanSem(){
		$('#NoData02').text('');
		$('.tituloTabla02').text('');
		$('#tableModalSemana').bootstrapTable('destroy');
		$('.table-result02').show();	
	}	
	
// °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
function getValor() {
//console.log("Consumos VOD'S-BRM vs VOD'S-IPTV");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
		$('#btn-Reporte2').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
}
