//alert("BRM-SN vs IPTV-STB");

function cleanModal(){
	$('#tableModal').bootstrapTable('destroy');
	$('#NoData').text('');
	$('.tituloTabla').text('');	
}
$('.detalle').click(function() {
	$('#myModal').modal('show');
	$('.table-result').show();
});
$('#opc1').click(function() {
	cleanModal();
	var id_detalle = $('#idDetalleTabla').val();
//	console.log($('.datepicker').val());
//	console.log($('#fecha').val()+id_detalle);
	pintaReporte1($('#fecha').val(),id_detalle);
});

$('#opc2').click(function() {
	cleanModal();
	var id_detalle = $('#idDetalleTabla').val();
	pintaReporte2($('#fecha').val(), id_detalle);
	});

function pintaReporte1(fech, id_detalle){
	
	if(fech != ""){	
		
		$.ajax({
			url : 'exportDetallePaqTvBrmRedIPTVIncluidoTablaJson',
			type : "POST",
			async : true,
			data : {'fechaTabla' :fech,
					'idDetalleTabla': id_detalle},
			dataType : "json",
			 beforeSend: function( xhr ) {
				 $('#wait').modal({backdrop: 'static', keyboard: false});
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#wait').modal('hide');
				if(jsonResponse.success){					
					//console.log("jsonResponse.success: " + jsonResponse.success);										
					$('.tituloTabla').text("Detalle de las cuentas existentes en BRM y no en IPTV ");
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
					        field: 'id_conciliacion',
					        title: 'Id Conciliación',
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
					        field: 'stb',
					        title: 'STB',
					        sortable: true
					    }, {
					        field: 'tmcode',
					        title: 'TM Code',
					        sortable: true
					    }, ]
					});
					
					 					
				}else{
					$('.tituloTabla').text('');
					$('#NoData').text("No se encontraron datos");
					console.log("Error en la tabla");
										
				}
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
			}
		});
	}
}

function pintaReporte2(fech, id_detalle){
	
	if(fech != ""){		
		$.ajax({
			url : 'exportDetallePaqTvBrmRedIPTVIncluidoTablaJson2',
			type : "POST",
			async : true,
			data : {'fechaTabla' :fech,
					'idDetalleTabla': id_detalle},
			dataType : "json",
			 beforeSend: function( xhr ) {
				 $('#wait').modal({backdrop: 'static', keyboard: false});
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#wait').modal('hide');
				if(jsonResponse.success){
										
					$('.tituloTabla').text("Detalle de las cuentas existentes en IPTV y no en BRM");
					//console.log("Detalle de las cuentas existentes en BRM y no en SAP");
					
					
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
					        field: 'id_conciliacion',
					        title: 'Id Conciliación',
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
					        field: 'stb',
					        title: 'STB',
					        sortable: true
					    }, ]
					});
							
										
				}else{
					$('.tituloTabla').text('');
					$('#NoData').text("No se encontraron datos");
					//console.log("Error en la tabla: " + jsonResponse.success);
										
				}
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
			}
		});
	}
}




$(function() {
	initFunction();
	$('#aseg2 span').addClass('desabilitado'); //----esconde la opcion en donde se encuentra
	
});

function initFunction() {
	
	if($('.lineas_internas').is(":visible")){
		$("#cuentas").prop("checked", true); 
		lineas_consulta();
		
	}
	else{
		document.getElementById("stb").checked = true;
		sendSolicitud();
		
	}	
}
//----------- consulta si está en la seccion de reportes o en la seccion de lineas internas
function sendSolicitud(){
	if(document.getElementById("stb").checked){
			opcion=1;
			url='getConciliacionIptvBrmService';	
		}
		if(document.getElementById("ctas").checked){
			opcion=2;
			url='getConciliacionIptvBrmService';
		}
		if(document.getElementById("stb_ctas").checked){
			opcion=3;
			url='getConciliacionIptvBrmService';
		}
		if($('#fecha').val() != ""){
			$('#divReport').hide('fade');
			$('.oculto').hide('fade');
			$('#internas_boton').show('fade');
			$('.lineas_internas').hide('fade');
			$('.botones_radio').show();
		
			
			$.ajax({
				url : url,
				type : "POST",
				async : false,
				data : {
					'fecha' : $('#fecha').val(),
					'conciliacion' : opcion
				},
				dataType : "json",
				beforeSend: function( xhr ) {
					 $('#loadModal').modal();
				 },
				success : function(jsonResponse, textStatus, jqXHR){
					$('#loadModal').modal('hide');
					if(jsonResponse.success){
						$('#descargaArchivo').show();
						$('.fechaEt').text($('#fecha').val());
						$('.contentMessage').hide('fade');
						$('.contentMessage2').hide('fade');
						$('.lineas_ocultas').hide('fade');
						$('.contentReporte').show('fade');
						$('#internas_boton').show('fade');
					//	$('#modalGrafica').modal().show('fade'); -- GRAFICA- se carga al consultar la fecha --
						
						$('.ver_detalle').show('fade');
						
						$('#fechaReporteTabla').val($('#fecha').val());
						$('#idDetalleTabla').val(opcion);
						cleanModal();
						setReporte(jsonResponse.result);
					}else{					
						$('.dateFail').text($('#fecha').val());
						$('#errorModal').modal();
						$('.contentMessage').hide('fade');
						$('.contentMessage2').show('fade');
						$('.contentReporte').hide('fade');
						$('.ver_detalle').hide('fade');
					}
				},
				error : function(jqXHR, textStatus, errorThrown){
					console.log(textStatus);
					$('#loadModal').modal('hide');
				}
			});
		}
}

// ----------------------
function datosG(result){
	var conci=0;
	$.each(result, function(index, valores){
		conci=valores.T_Conciliados;
//		console.log('valor de grafica'+conci);
	});
	
}
// ----------------------



function setReporte(result){
	
//	$('#g1').text(''); //-- inicializar bacio
//	$('#g2').text(''); //-- inicializar bacio
	$('#grafica').text(''); //-- inicializar bacio
	
	$.each(result, function(index, valores){
//	console.log(valores.Id);
	$('#id_detalle').val(valores.Id);
	$('#fechaReporte').val($('#fecha').val());
//	console.log(val('#fechaReporte'));
		
	
		//Conciliado
		$('.T_Conciliados').html(accounting.formatNumber( valores.T_Conciliados ));
//		var porcentaje =(1-((parseInt(valores.Total) - parseInt(valores.T_Conciliados))/parseInt(valores.Total)))*100 ;
		var porcentaje =(parseInt(valores.Total)>0)?((parseInt(valores.T_Conciliados)/parseInt(valores.Total))*100):0;
		
//		if(valores.Total>0){
//			porcentaje = (1 - ((parseInt(valores.Total) - parseInt(valores.T_Conciliados)) / parseInt(valores.Total)))*100 ;
//		}else{
//			porcentaje=0;
//		}
		$('#porcentaje').html(accounting.toFixed(porcentaje, 2) + ' %' );
		//No conciliado
		$('#Error_Total').html(accounting.formatNumber( valores.Error_Total ));
		
		var porcentajeErr = (parseInt(valores.Total)>0)?((parseInt(valores.Error_Total)/parseInt(valores.Total))*100):0;
		$('#porcentajeError_Total').html(accounting.toFixed(porcentajeErr, 2) + ' %' );
		$('.Error_Brm').html(accounting.formatNumber( valores.Error_Brm ));
		$('.Error_Iptv').html(accounting.formatNumber( valores.Error_Iptv ));
		
		$('#No_Iptv').html(accounting.formatNumber( valores.No_Iptv ));
		$('#No_Brm').html(accounting.formatNumber( valores.No_Brm ));
		$('#Total').html(accounting.formatNumber( valores.Total ));
		
		var porcentajeErrorBRM =(parseInt(valores.Total)>0)?((parseInt(valores.Error_Brm)/parseInt(valores.Total))*100):0;
//		if(valores.No_Brm>0){
//			porcentajeErrorBRM = (1 - ((parseInt(valores.No_Brm) - parseInt(valores.Error_Brm)) / parseInt(valores.No_Brm)))*100 ;
//		}else{
//			porcentajeErrorBRM=0;
//		}
		
		var porcentajeErrorIPTV = (parseInt(valores.Total)>0)?((parseInt(valores.Error_Iptv)/parseInt(valores.Total))*100):0;
//		if(valores.No_Iptv>0){
//			porcentajeErrorIPTV = (1 - ((parseInt(valores.No_Iptv) - parseInt(valores.Error_Iptv)) / parseInt(valores.No_Iptv)))*100 ;
//		}else{
//			porcentajeErrorIPTV=0;
//		}
		$('#porcentajeErrorBRM').html(accounting.toFixed(porcentajeErrorBRM, 2) + ' %' );
		$('#porcentajeErrorIPTV').html(accounting.toFixed(porcentajeErrorIPTV, 2) + ' %' );
		
		var porcentajeTotal = (parseInt(valores.Total)>0)?((parseInt(valores.T_Conciliados)/parseInt(valores.Total))*100):0;
//		if(valores.Total>0){
//			porcentajeTotal = (1 - ((parseInt(valores.Total) - parseInt(valores.T_Conciliados)) / parseInt(valores.Total)))*100 ;
//		}else{
//			porcentajeTotal=0;
//		}
		$('#porcentajeTotal').html(accounting.toFixed(porcentajeTotal, 2) + ' %' );
		
		$('#Empresa').html(valores.Empresa);

		if(valores.Status == 'SI' ){
			$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
		}else{
			$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
		}
		
		var botones = '';
		var porcentajeBRM =  (parseInt(valores.Total)>0)?((parseInt(valores.Error_Brm)/parseInt(valores.Total))*100):0; 
		var porcentajeIPTV = (parseInt(valores.Total)>0)?((parseInt(valores.Error_Iptv)/parseInt(valores.Total))*100):0;

		
		if(porcentajeBRM==100){
			botones = '<img src="/CifrasControl/img/green.png">';
//		}else if(porcentajeBRM <99 && porcentajeBRM >=75 ){
//			botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
		}else {
			botones = '<img src="/CifrasControl/img/red.png">';
		}
		$('.bcolorBRM').html(botones);
		
		if(porcentajeIPTV ==100){
			botones = '<img src="/CifrasControl/img/green.png">';
//		}else if(porcentajeIPTV > 1 && porcentajeIPTV <26 ){
//			botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
		}else if(porcentajeIPTV <100 ){
			botones = '<img src="/CifrasControl/img/red.png">';
		}
		$('.bcolorIPTV').html(botones);
//		$(".modal").hide();                        -------------------------- grafica modal
 	
	// --------------------- grafica -------------------------
//		var porcion={percentageInnerCutout: 80};
//		var cifras = [ {
//			value : valores.Error_Total,
//			color : "#DC3714",
//			highlight : "#DC3714",
//			label : " NO CONCILIADO "
//		}, {
//			value : valores.Error_Brm,
//			color : "#E3A21D",
//			highlight : "#E3A21D",
//			label : " BRM "
//		}, {
//			value : valores.Error_Iptv,
//			color : "#67F00F",
//			highlight : "#67F00F",
//			label : " IPTV "
//		}];
//		var graficaAnillo = document.getElementById('GraAnillo').getContext("2d");
//		window.myPie = new Chart(graficaAnillo).Doughnut(cifras,porcion);
		
//		$("#fechaTotal").html(accounting(valores.Fecha ));
		var g1,g2,gTOTAL;
		
		
//		document.addEventListener("DOMContentLoaded", function(event) {
	 g1 = new JustGage({
            id: "g1",
            title: "TOTAL",
            label:valores.Fecha ,
            lableFontSize: "10px",
            min: 0,
            max: 100,
            titleFontColor: "#2FAECD",
            titleFontFamily: "Georgia",
            titlePosition: "up",
            value: porcentaje,                       //------------------- valores grafica 1
//            value: 50, 
            valueFontColor: "#BDC8C7",
            //valueFontFamily: "Georgia",
            valueMinFontSize: "10px",
            decimals: 2,
            pointer: true,
            symbol: '%',
            pointerOptions: {
              toplength: -21,   // posicion hacia abajo
              bottomlength: 60, // tamaño de la aguja
              bottomwidth: 4,    // grosor aguja 
              color: '#cd6155',   // color de la aguja   
             },
            customSectors : [{"lo":0, "hi":30, "color":"#F72020"},
                             {"lo":31,"hi":60, "color":"#F7F420"},
                             {"lo":61,"hi":100,"color":"#36F44A"}],
            gaugeWidthScale: 0.5,
            counter: true
        });
	 g2 = new JustGage({
         id: "g2",
         title: "TOTAL",
//         label:valores.Fecha ,
         lableFontSize: "10px",
         min: 0,
         max: 100,
         titleFontColor: "#2FAECD",
         titleFontFamily: "Georgia",
         titlePosition: "up",
         value: porcentaje,                       //------------------- valores grafica 1
//         value: 50, 
         valueFontColor: "#BDC8C7",
         valueFontFamily: "Georgia",
//         valueMinFontSize: "20px",
//         decimals: 2,
         pointer: true,
         symbol: '%',
         pointerOptions: {
           toplength: -21,   // posicion hacia abajo
           bottomlength: 60, // tamaño de la aguja
           bottomwidth: 4,    // grosor aguja 
           color: '#cd6155',   // color de la aguja   
          },
         customSectors : [{"lo":0, "hi":30, "color":"#F72020"},
                          {"lo":31,"hi":60, "color":"#F7F420"},
                          {"lo":61,"hi":100,"color":"#36F44A"}],
         gaugeWidthScale: 0.5,
         counter: true,
         donut:true
     });
// -----   GRAFICA TOTALES ------------------	 
	 var gTOTAL;
	 gTOTAL= new JustGage({
		    id:"grafica",
		    //label: "label",
//		    title: "TOTAL",
//		    titleFontColor: "#4c56de", // color azul
//		    titleFontFamily: "Georgia",
//	        titlePosition: "up",
		    value: porcentaje,
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
	//-----------fin grafica----------------------------------
		
	//	$('#modalporcen').hover(function(){
	//		$('#modalGrafica').modal('show');
	//	});
	});
}

function limpiaCampos(){
	var valorInicial = 0.0;
	$('.decision').html("");
	$('.bcolorBRM').text('');
	$('.bcolorIPTV').text('');
	$('#T_Conciliados').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentaje').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#Error_Total').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentajeError_Total').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#Error_Brm').html(accounting.toFixed(valorInicial, 2 ));
	$('#Error_Iptv').html(accounting.toFixed(valorInicial, 2 ));
	$('#No_Iptv').html(accounting.toFixed(valorInicial, 2 ));
	$('#No_Brm').html(accounting.toFixed(valorInicial, 2 ));
	$('#Total').html(accounting.toFixed(valorInicial, 2 ));
	$('#porcentajeErrorBRM').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#porcentajeErrorIPTV').html(accounting.toFixed(valorInicial, 2) + ' %' );
	$('#porcentajeTotal').html(accounting.toFixed(valorInicial, 2) + ' %' );	
	$('#Empresa').html(" ");
	$('#g2').html(accounting.toFixed(valorInicial, 2));
	
}

$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });
//******************* SECCION DE LINEAS INTERNAS **********************//
//******************* TABLA PRINCIPALES **********************//

$('#confmodal').on('hide.bs.modal', function () {
	lineas_consulta();
	 });
$('#confmodal_eliminarTodo').on('hide.bs.modal', function () {
	lineas_consulta();
	 });
$('#modal_archivo').on('hide.bs.modal', function () {
	console.log("entro modal_archivo");
	lineas_consulta();
	 });
function lineas_internas(){
	$('.contentMessage').hide('fade');
	$('.contentMessage2').hide('fade');
	$('.contentReporte').hide('fade');
	$('.lineas_internas').show('fade');
	$('#internas_boton').hide('fade');
	$("#cuentas").prop("checked", true); 
	$("#SN").prop("checked", false); 
	$('.botones_radio').hide('fade');
	lineas_consulta();
}
function reporte_botonf(){
	sendSolicitud();
	$('.lineas_internas').hide('fade');
	$('#internas_boton').show('fade');
	$('.botones_radio').show('fade');	
}
function lineas_consulta() {
	if ($('#check_todo').is(":checked"))
		todos=1;
	else
		todos=0;
	if(document.getElementById("cuentas").checked){
	opcion=1;
	url='PaqTvBrmRedIPTVIncluidoLI_Ctas';
	}
	if(document.getElementById("SN").checked){
	opcion=2;
	url='PaqTvBrmRedIPTVIncluidoLI_SN';
	}
	console.log(opcion);
	$.ajax({
		url : url,
		type : "POST",
		data : {
			'fecha' : $('#fecha').val(),
			'todos'	:todos
				},
		dataType : "json",
		beforeSend: function( xhr ) {
			 $('#loadModal').modal();
		 },
		success : function(jsonResponse, textStatus, jqXHR){
			$('#loadModal').modal('hide');
			
			

			if(jsonResponse.success){
			console.log(jsonResponse);
			
			$('.insertar_boton').show('fade');
			$('.eliminar_boton').show('fade');
			
			if(opcion==1)
				contruyeCuentas(jsonResponse);
			if(opcion==2)
				contruyeSN(jsonResponse);
				
			}else{		
				$('.dateFail').text($('#fecha').val());
				$('#errorModal').modal();
			}
		},
		error : function(jqXHR, textStatus, errorThrown){
			console.log(textStatus);
			$('#loadModal').modal('hide');
		}
	});
}
	
function contruyeCuentas(jsonResponse){	
	$('#divReport').show('fade');
	$('#divReport').text('');
	var html, table, body = '';
	var header = '<table id="listaTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer  table-striped">' + '<THEAD>'
	+ '<tr>' 
	+ '<th><small>Cuenta</small></th>'
	+ '<th><small>Empresa</small></th>'
	+ '<th><small>Fecha</small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				html = '<tr onclick="tr_sel(this)"><td name="cuenta">';
				html = html + arrayValores.cuenta;
				html = html + '</td>';
				html = html + '<td name="empresa">';
				html = html + arrayValores.empresa;
				html = html + '</td>';
				html = html + '<td name="fecha">';
				html = html + arrayValores.fecha;
				html = html + '</td>';
				html = html + '</tr>';
				body = body + html;
			});
	table = header + body + footer;
	$(table).appendTo('#divReport');
	$('#listaTable').dataTable({
		"language" : {
			"sProcessing"	: "Procesando...",
			"sLengthMenu"	: "Mostrar _MENU_ registros",
			"sZeroRecords" 	: "No se encontraron resultados",
			"sEmptyTable" 	: "Ning\u00fan dato disponible  ",
			"sInfo" 		: "",
			"sInfoEmpty" 	: "",
			"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
			"sInfoPostFix" 	: "",
			"sSearch" 		: "Buscar:",
			"oPaginate" 	: {
					"sFirst" 	: "Primero",
					"sLast"		: "\u00daltimo",
					"sNext"		: ">",
					"sPrevious" : "<"
					}
		}
	});
	$('#divReport').show('fade');
}

function contruyeSN(jsonResponse){		
	$('#divReport').text('');
	var html, table, body = '';
	var header = '<table id="listaTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer  table-striped">' + '<THEAD>'
	+ '<tr>' 
	+ '<th><small>SN</small></th>'
	+ '<th><small>Empresa</small></th>'
	+ '<th><small>Fecha</small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				html ='<tr  onclick="tr_sel(this)"><td name="sn">';
				html = html + arrayValores.sn;
				html = html + '</td>';
				html = html + '<td name="empresa">';
				html = html + arrayValores.empresa;
				html = html + '</td>';
				html = html + '<td name="fecha">';
				html = html + arrayValores.fecha;
				html = html + '</td>';
				html = html + '</tr>';
				body = body + html;
			});	
	table = header + body + footer;
	$(table).appendTo('#divReport');
	$('#listaTable').dataTable({
		"language" : {
			"sProcessing"	: "Procesando...",
			"sLengthMenu"	: "Mostrar _MENU_ registros",
			"sZeroRecords" 	: "No se encontraron resultados",
			"sEmptyTable" 	: "Ning\u00fan dato disponible ",
			"sInfo" 		: "",
			"sInfoEmpty" 	: "",
			"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
			"sInfoPostFix" 	: "",
			"sSearch" 		: "Buscar:",
			"oPaginate" 	: {
					"sFirst" 	: "Primero",
					"sLast"		: "\u00daltimo",
					"sNext"		: ">",
					"sPrevious" : "<"
					}
		}
	});
	$('#divReport').show('fade');
}
//*********************************************************************//
//******************* BOTONES INSERTAR Y ELIMINAR**********************//

function elimina(){
	var lineas=new Array();
	 var table = $('#listaTable').DataTable();

	 table.rows('.selected').every( function ( rowIdx, tableLoop, rowLoop ) {			 
		 var rowNode = this.node();
		 json ="";
		 
		 $(rowNode).find("td").each(function (){
			 $this=$(this);
		      json+=',"'+$this.attr("name")+'":"'+$this.html()+'"';
     });
		   obj=JSON.parse('{'+json.substr(1)+'}');
		   lineas.push(obj);
		} );
//	 console.log(lineas);
	   
	   if(document.getElementById("cuentas").checked){
			opcion=1;
			url='PaqTvBrmRedIPTVIncluidoLI_eliminarCuentas';
			}
			if(document.getElementById("SN").checked){
			opcion=2;
			url='PaqTvBrmRedIPTVIncluidoLI_eliminarSN';
			}				
			json_string=JSON.stringify(lineas);
			$.ajax({
				url : url,
				type : "POST",
				traditional:true,
				//contentType: 'application/json',
				data : { 'json_string': json_string }
					,
				dataType : "json",
				beforeSend: function( xhr ) {
							 $('#loadModal').modal();
						 },
				success : function(response){
					$('#loadModal').modal('hide');
					if (response != null && response.success == true) {
						$('#btnYes').hide();
						$('#btnCancelar').hide();
						$('#msj_eliminar').text("Se han eliminado "+response.result+" registros");
					} else {
						$('#msj_eliminar').text(response.mensaje);
					}
				},
				error : function(xhr, ajaxOptions, thrownError) {
					console.log(response.mensaje);
					$('#loadModal').modal('hide');
		}
			});	
			
}

function eliminaTodo(){
	
	   if(document.getElementById("cuentas").checked){
			opcion=1;
			url='PaqTvBrmRedIPTVIncluidoLI_eliminarTodoCuentas';
			}
			if(document.getElementById("SN").checked){
			opcion=2;
			url='PaqTvBrmRedIPTVIncluidoLI_eliminarTodoSN';
			}	
			
			$.ajax({
				url : url,
				type : "POST",
				traditional:true,
				dataType : "json",
				beforeSend: function( xhr ) {
							 $('#loadModal').modal();
						 },
				success : function(response){
					$('#loadModal').modal('hide');
					
						$('#btnYesTodo').hide();
						$('#btnCancelarTodo').hide();
						$('#msj_eliminarTodo').text("Se han eliminado "+response.result+" registros");
						
					
				},
				error : function(xhr, ajaxOptions, thrownError) {
					$('#loadModal').modal('hide');
					$('#msj_eliminarTodo').text(response.mensaje);
		}
			});	
			
}

function tr_sel(valor){
	 $(valor).toggleClass('selected');
}
function eliminarbf(){
	$('#btnYes').show();
	$('#btnCancelar').show();
	
	var table = $('#listaTable').DataTable();
	console.log(table.rows('.selected').count()+"entra");
	var rows_selected= table.rows('.selected').count();
	
	if(rows_selected>0){
	$('#msj_eliminar').text('¿Está seguro de que desea eliminar los datos seleccionados?');
	 $('#confmodal').modal('show');
}
} 

function eliminarTodo(){
	$('#btnYesTodo').show();
	$('#btnCancelarTodo').show();
	
	$('#msj_eliminarTodo').text('¿Está seguro? Se borrarán TODOS los datos de la tabla');
	 $('#confmodal_eliminarTodo').modal('show');

} 

//******************* SECCION DE MODAL **********************//
//******************* CARGAR EXCEL **********************//
function insertarb(){	
	 $('#respuesta').text('');
	 $('#sfile').val('');
	 $('.cargar_documento').show();
	 $('.cargar_exitoso').hide();
	 $('#modal_archivo').modal('show');
	 $('#previo').text('');
} 
function bcargaf(){
	
	if($('#sfile').val()=='')
		$('#previo').text('');
		
	var formData = new FormData();
	formData.append('myFile', $('#sfile')[0].files[0]);
	
	if(document.getElementById("cuentas").checked){
		opcion=1;
		url='PaqTvBrmRedIPTVIncluidoLI_CtasExcel';	
		}
		if(document.getElementById("SN").checked){
		opcion=2;
		url='PaqTvBrmRedIPTVIncluidoLI_SNExcel';
		}
	
	$.ajax({
			url : url,
			type : "POST",
			data : formData,
			dataType : "json",
			processData: false,
			contentType: false,
			beforeSend: function( xhr ) {
						 $('#loadModal').modal();
					 },
			success : function(jsonResponse, textStatus, jqXHR){
				if(jsonResponse.success){
					if(jsonResponse.result.length > 0){
						
						if(opcion==1)
						contruyeInsertarCtas(jsonResponse);
						if(opcion==2)
							contruyeInsertarSN(jsonResponse);
					}
				}else{
					$('#previo').text('');
					$('#previo').append('<p style="color:red;">Archivo incorrecto, favor de verificar</p>');
				}
				
				$('#loadModal').modal('hide');
					},
					error : function(jqXHR, textStatus, errorThrown){
						console.log(textStatus);
						$('#loadModal').modal('hide');
					}
		 });
}
// tabla reporte 
function contruyeInsertarCtas(jsonResponse){	
	$('#previo').text('');
	var html, table, body = '';
	var header = '<table id="listaPrevia" class="table table-condensed table-hover table-responsive datatable dataTable no-footer  table-striped">' + '<THEAD>'
	+ '<tr >' 
	+ '<th><small>Cuenta</small></th>'
	+ '<th><small>Empresa</small></th>'
	+ '<th><small>Fecha</small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				html = '<tr onclick="tr_sel(this)"><td name="cuenta">';
				html = html + arrayValores.cuenta;
				html = html + '</a></td>';
				html = html + '<td name="empresa">';
				html = html + arrayValores.empresa;
				html = html + '</td>';
				html = html + '<td name="fecha">';
				html = html + arrayValores.fecha;
				html = html + '</td>';
				html = html + '</tr>';
				body = body + html;
			});
	table = header + body + footer;
	$(table).appendTo('.previo');
	$('#listaPrevia').dataTable({
		"language" : {
			"sProcessing"	: "Procesando...",
			"sLengthMenu"	: "Mostrar _MENU_ registros",
			"sZeroRecords" 	: "No se encontraron resultados",
			"sEmptyTable" 	: "Ning\u00fana OT disponible ",
			"sInfo" 		: "",
			"sInfoEmpty" 	: "",
			"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
			"sInfoPostFix" 	: "",
			"sSearch" 		: "Buscar:",
			"oPaginate" 	: {
					"sFirst" 	: "Primero",
					"sLast"		: "\u00daltimo",
					"sNext"		: ">",
					"sPrevious" : "<"
					}
		}
	});
	$('#listaPrevia_filter').text('');
	$('#listaPrevia_length').text('');
}
function contruyeInsertarSN(jsonResponse){	
	$('#previo').text('');
	var html, table, body = '';
	var header = '<table id="listaPrevia" class="table table-condensed table-hover table-responsive datatable dataTable no-footer  table-striped">' + '<THEAD>'
	+ '<tr>' 
	+ '<th><small>SN</small></th>'
	+ '<th><small>Empresa</small></th>'
	+ '<th><small>Fecha</small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				html = '<tr onclick="tr_sel(this)"><td name="sn">';
				html = html + arrayValores.sn;
				html = html + '</a></td>';
				html = html + '<td name="empresa">';
				html = html + arrayValores.empresa;
				html = html + '</td>';
				html = html + '<td name="fecha">';
				html = html + arrayValores.fecha;
				html = html + '</td>';
				html = html + '</tr>';
				body = body + html;
			});
	
	table = header + body + footer;
	$(table).appendTo('.previo');
	$('#listaPrevia').dataTable({
		"language" : {
			"sProcessing"	: "Procesando...",
			"sLengthMenu"	: "Mostrar _MENU_ registros",
			"sZeroRecords" 	: "No se encontraron resultados",
			"sEmptyTable" 	: "Ning\u00fana OT disponible ",
			"sInfo" 		: "",
			"sInfoEmpty" 	: "",
			"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
			"sInfoPostFix" 	: "",
			"sSearch" 		: "Buscar:",
			"oPaginate" 	: {
					"sFirst" 	: "Primero",
					"sLast"		: "\u00daltimo",
					"sNext"		: ">",
					"sPrevious" : "<"
					}
		}
	});
	$('#listaPrevia_filter').text('');
	$('#listaPrevia_length').text('');
}
//*************************INSERCCION EN LA BASE DE DATOS DESDE EXCEL*******************************
//**************************************************************************************************

function inserta_excel(){
	if($('#sfile').val()!='')
	{
		 var lineas=new Array();
		 var table = $('#listaPrevia').DataTable();
	
		 table.rows().every( function ( rowIdx, tableLoop, rowLoop ) {			 
			 var rowNode = this.node();
			 json ="";
			 
			 $(rowNode).find("td").each(function (){
				 $this=$(this);
			      json+=',"'+$this.attr("name")+'":"'+$this.html()+'"';
          });
			   obj=JSON.parse('{'+json.substr(1)+'}');
			   lineas.push(obj);
			} );
	//	 console.log(lineas);
			
	if(document.getElementById("cuentas").checked){
		opcion=1;
		url='PaqTvBrmRedIPTVIncluidoLI_insertarCtas';
		}
		if(document.getElementById("SN").checked){
		opcion=2;
		url='PaqTvBrmRedIPTVIncluidoLI_insertarSN';
		}	
		
		json_string=JSON.stringify(lineas);
		
	$.ajax({
		url : url,
		type : "POST",
		traditional:true,
		//contentType: 'application/json',
		data : { 'json_string': json_string }
			,
		dataType : "json",
		beforeSend: function( xhr ) {
					 $('#loadModal').modal();
				 },
		success : function(response){
			$('#loadModal').modal('hide');
			if (response != null && response.success == true) {
				console.log(response.mensaje+"exitoso");
				$('.cargar_documento').hide('fade');
				$('#respuesta').text(response.mensaje);
			
			} else {
				console.log(response.mensaje+"erroneo");
				$('.cargar_documento').hide('fade');
				$('#respuesta').text(response.mensaje);
			}
		},
		error : function(xhr, ajaxOptions, thrownError) {
			console.log("envio fallido");
			$('#loadModal').modal('hide');
}
	});
	}
}

//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
function getValor() {
//	console.log("BRM-SN vs IPTV-STB");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}

