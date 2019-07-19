//alert("Megas Contratados-BRM vs Aprovisionados-U2000");
$('.detalle').click(function(){
	$('#myModal').modal('show');
});

var tab=null;

function cleanX(){
	$('#NoData').text('');
	$('.tituloTabla').text('');
	$('#tableModal').bootstrapTable('destroy');
	$('.table-result').show();
	$('#PA').show();
	$('#PC').show();
	$('#remove').show();
}
function consultaX1(){
	cleanX();
	pintaReporte1($('#fecha').val());
	}
function consultaX2(){
	cleanX();
	pintaReporte2($('#fecha').val());
	}

function changeValue(obj){
	
	 if (obj.is(":checked")) {
		 obj.val('true');
	    } else {
	    	obj.val('false');
	    }
	
}

function getTableData(fech,row1,row2){
	console.log("getTableData ------");

		//aqui		
		$.ajax({
			url : 'exportDetalleConciliacionAddonsBrmU2000DetailsTablaJson2',
			type : "POST",
			async : false,
			data : {'fechaTabla' :fech,'row1':row1,'row2':row2},
			dataType : "json",

			success : function(jsonResponse, textStatus, jqXHR){
				//$('#wait').modal('hide');
				
				if(jsonResponse.success){
					$('#tableModal').bootstrapTable('append', jsonResponse.result
					);
				}

			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
			}
		});
	
}


function pintaReporte3(fech,row1,row2){
	console.log("pintaReporte1  #1 ------");
 
//	pintaPorcentaje();
//	
//	//pintaPorcentaje();
//	$('#PA').hide();
//	$('#PC').hide();
//	$('#remove').hide();
		//aqui		
		$.ajax({
			url : 'exportDetalleConciliacionAddonsBrmU2000DetailsTablaJson2',
			type : "POST",
			async : false,
			data : {'fechaTabla' :fech,'row1':row1,'row2':row2},
			dataType : "json",
			 beforeSend: function( xhr ) {
				 $('#wait').modal({backdrop: 'static', keyboard: false});
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#wait').modal('hide');
				
				if(jsonResponse.success){
					
															
					$('.tituloTabla').text("Detalle de megas contratados en BRM que estan inconsistentes en U2000");
					//console.log("Detalle de los cuentas existentes en SAP y no en BRM ");
					
					
					tab=$('#tableModal').bootstrapTable({   	// dibuja tabla
					    data : jsonResponse.result,
					    pagination:true,
  						search:true,
 						toolbar:'#toolbar',
  						clickToSelect:"true",
					    
					    columns: [{
					        field: 'accion1',
					        title: 'Acci&oacute;n',
					        checkbox:true,
					        
					    },{
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
					        field: 'addons',
					        title: 'Addons',
					        sortable: true
					    }, {
					        field: 'megas',
					        title: 'Megas Brm',
					        sortable: true
					    }, {
					        field: 'descr',
					        title: 'Megas Red',
					        sortable: true
					    }, {
					        field: 'ont',
					        title: 'Ont',
					        sortable: true
					    },]
					});
					$('#PA').show();		 			// porcentaje actual.
					$('#PC').show(); 					// porcentaje  proyectado.
					//$('#remove').show();			// boton de No corregir.
//					$(".fechaModal").show();  // fecha del modal.
				}else{
					$('.tituloTabla').text('');
					$('#NoData').text("No se encontraron datos");
					$('#PA').hide();				 // porcentaje actual.
					$('#PC').hide();				// porcentaje  proyectado.
					//$('#remove').hide();		// boton de No corregir
//					$(".fechaModal").hide();  // fecha del modal.
				}
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
			}
		});
	
}



function pintaReporte1(fech,row1,row2){
	console.log("pintaReporte1  #1 ------");
	
//	var valor=$('.porcentajeConcTP').text();
//    var valor1=$('.porcentajeNoConcTP').text();
	
	// provicional 
	pintaPorcentaje();
	
	//pintaPorcentaje();
	$('#PA').hide();
	$('#PC').hide();
	$('#remove').hide();
	if(fech != ""){	
		//aqui
		
//		if(conteo>10000){
			//construir la tabla
			$.ajax({
				url : 'exportDetalleConciliacionAddonsBrmU2000DetailsTablaJson',
				type : "POST",
				async : false,
				cache:false,
				data : {'fechaTabla' :fech,'row1':row1,'row2':row2},
				 beforeSend: function( xhr ) {
					 $('#wait').modal({backdrop: 'static', keyboard: false});
				 },
				dataType : "json",
				success : function(jsonResponse, textStatus, jqXHR){
					$('#wait').modal('hide');
					
					if(jsonResponse.success){	
						$('.tituloTabla').text("Detalle de megas contratados en BRM que estan inconsistentes en U2000");
						$("#btn-Reporte").show();
						
						var check="";
						var value="false";
						$.each( jsonResponse.result, function( i, v ) {
							//console.log(v.cuenta);
							if(v.accion=='1'){
								check='checked';
								value="true";
							}
							$("#bodyTableModal").append('<tr class="data-index">'+
									'<td class="bs-checkbox">'+'<input id="tester" onchange="changeValue($(this))" value="'+value+'"  name="btSelectItem" type="checkbox" '+check+'>'+
									'<td>'+v.fecha+'</td>'+
									'<td>'+v.cuenta+'</td>'+
									'<td>'+v.plan+'</td>'+
									'<td>'+v.addons+'</td>'+
									'<td>'+v.megas+'</td>'+
									'<td>'+v.descr+'</td>'+
									'<td>'+v.ont+'</td>'+
									'<td>'+v.id_conciliacion+'</td>'+
									'<td>'+v.accion+'</td>'+
									'</tr>');
//							console.log(key);
							});
					}else{
						alert('No hay Contenido') ;
						$('.tituloTabla').text('');
						$('#NoData').text("No se encontraron datos");
						$('#PA').hide();				 // porcentaje actual.
						$('#PC').hide();				// porcentaje  proyectado.
						$('#remove').hide();		// boton de No corregir
					}
				},
				error : function(jqXHR, textStatus, errorThrown){
					console.log(textStatus);
				}
			});

	}
}

//function pintaPorcentaje(valor){
function pintaPorcentaje(){
	console.log("paintPorcentaje()");
	var valor=$('.contadorCon').text();
	var temporal=0;
	var conciliado=$('#t_conciliadosTP').text();
	var total=$("#totalC").text();
	var Rproyectado=0;
	
	var estable=$("#totalActual").text();
	console.log("VALOR ESTABLE v1 = "+ parseFloat(estable));
	var estableTemp=parseFloat(estable);
	var valorEstable=estableTemp.toFixed(1);
//	console.log("VALOR ESTABLE v2 = "+ estable1);
		
	
	
	
	
	var conc1 = conciliado.replace(",", "");
	var conc2 = conc1.replace(",", "");
	
	
	var total1= total.replace(",", "");
	var total2 = total1.replace(",", "");
	
	
//	valorEstable= parseInt(conciliado)*100/parseInt(total);
//	console.log("## valor estable  "+valorEstable.toFixed(1));
	temporal=Number(conc2)+Number(valor);
	Rproyectado=Number(temporal)*100/Number(total2);
	
	console.log("CONCILIADO: "+ conciliado + " TOTAL: "+ total+ "resultado = "+ Rproyectado.toFixed(1));
	
	$('.estatusValEstable').text(valorEstable);  // pinta valor estable
	document.getElementById("barraProgresoEstable").style.width =valorEstable+"%";
	$('.estatusValEstable1').text( Rproyectado.toFixed(1));  // pinta valor estable
	document.getElementById("barraProgreso").style.width = Rproyectado.toFixed(1)+"%";
	$('.fechaDeHoy').text($('#fecha').val());  // pinta valor estable
//	$('.conciliadoVar').text($('#t_conciliadosTP').text());  // pinta valor estable
	$('.conciliadoVar').text(temporal);  // pinta valor estable
	
}

//$('#tableModal').delegate(':checkbox','change',function(){
//	alert('t');
//	  var $elem = $(this),
//	  $tr = $elem.closest('tr');
//
//	  if($elem.is(':checked')){
//	    $tr.addClass('selected');
//	  }else{
//	    $tr.removeClass('selected');
//	  }
//	  return false;
//
//	});


function calculaProyeccion(valor){
	console.log("calculaProyeccion() valor de entrada "+ valor);
	$('.conciliadoVar').text(valor);  // pinta valor estable
	
	var conciliado=$(".conciliadoVar").text();
	var total=$("#totalC").text();
//	var Rporcentaje=0;
	
	
	var conc1 = conciliado.replace(",", "");
	var conc2 = conc1.replace(",", "");
	var total1= total.replace(",", "");
	var total2 = total1.replace(",", "");
	
	Rproyectado=Number(conc2)*100/Number(total2);
//	console.log("CONCILIADO: "+ conciliado + " TOTAL: "+ total+ "resultado = "+ Rproyectado.toFixed(1));
	$('.estatusValEstable1').text( Rproyectado.toFixed(1)); 
	document.getElementById("barraProgreso").style.width = Rproyectado.toFixed(1)+"%";
	return valor;
}


//  ***************************** ---------------- NICIO NUEVA FUNCIONALIDAD

//CONTAR SELECCIONADOS	
var tableSumar = $('#tableModal');
var remove = $('#remove');
//-------------------  seleccionar uno por uno -----------
$(function() {
	tableSumar.on('check.bs.table',
					function(row, $element) {
		//aqui2
		var fechaActualizaCorregido =$('#fecha').val();
						var exportDataE=[];
						exportDataE.push(
								 
								 {"fecha":$element.fecha.toString(),
						          "accion": $element.accion.toString(),
									"accion1": $element.accion1, 
									"addons":  $element.addons.toString(),
									"cuenta":  $element.cuenta.toString(),
									"descr":  $element.descr.toString(),
									id_conciliacion:  $element.id_conciliacion.toString(),
									"megas":  $element.megas.toString(),
									"ont":  $element.ont.toString(),
									"plan":  $element.plan.toString()}
						          
						);
						$.ajax({
							url :'getJsonActualizar',
							type : "POST",
							cache:false,
							data : { 'jsonDatos':JSON.stringify(exportDataE),"fechActuCorre":fechaActualizaCorregido},
							dataType : "json",
							
							success : function(response){
//								remove.prop('disabled', !tableSumar.bootstrapTable('getSelections').length);
								console.log(tableRestar.bootstrapTable('getSelections').length);
								tableRestar.bootstrapTable('getSelections').length;
								console.log("  seleccionar uno por uno..");
								var actual=$('.conciliadoVar').text();
								var total=$('#t_conciliadosTP').text();
								
								var actual1= actual.replace(",", "");
								var actual2 = actual1.replace(",", "");
								var total1= total.replace(",", "");
								var total2 = total1.replace(",", "");
								
								var actual1=Number(actual2)+1;

								actual=parseInt(actual1)+1;
								calculaProyeccion(actual1);
								alert('Ok');
							},
							error : function(xhr, ajaxOptions, thrownError) {
								alert('Ocurrio un problema');
					}		
						});	
						
						
					});

//		remove.prop('disabled', true);
});

//-------------------  desSeleccionar Uno a Uno -----------
var tableRestar = $('#tableModal');
var remove = $('#remove');
$(function() {
	
tableRestar.on('uncheck.bs.table',
					function(row, $element) {
	
	var fechaActualizaCorregido =$('#fecha').val();
	var exportDataE=[];
	exportDataE.push(
			 {"fecha":$element.fecha.toString(),
	          "accion": $element.accion.toString(),
				"accion1": $element.accion1, 
				"addons":  $element.addons.toString(),
				"cuenta":  $element.cuenta.toString(),
				"descr":  $element.descr.toString(),
				"id_conciliacion":  $element.id_conciliacion.toString(),
				"megas":  $element.megas.toString(),
				"ont":  $element.ont.toString(),
				"plan":  $element.plan.toString()}
	          
	);
	$.ajax({
		url :'getJsonActualizar',
		type : "POST",
		cache:false,
		data : { 'jsonDatos':JSON.stringify(exportDataE),"fechActuCorre":fechaActualizaCorregido},
		dataType : "json",
		success : function(response){
//			remove.prop('disabled', !tableRestar.bootstrapTable('getSelections').length);
			console.log(tableRestar.bootstrapTable('getSelections').length);
			tableRestar.bootstrapTable('getSelections').length;
			var actual=$('.conciliadoVar').text();
			var total=$('#t_conciliadosTP').text();
			var actual1= actual.replace(",", "");
			var actual2 = actual1.replace(",", "");
			var total1= total.replace(",", "");
			var total2 = total1.replace(",", "");
			console.log(" ------> actual2 : "+ actual2 + "    ------>total2: " +total2 );
			var actual1=Number(actual2)-1;
			actual=parseInt(actual1)-1;
			calculaProyeccion(actual1);
			alert('Ok');
		},
		error : function(xhr, ajaxOptions, thrownError) {
			alert('Ocurrio un problema');
}		
	});	
						
					});

//		remove.prop('disabled', true);
});

//-------------------  seleccionar todos -----------
$(function() {
	tableSumar.on('check-all.bs.table',
					function() {
		//alert('2');
//						remove.prop('disabled', !tableSumar.bootstrapTable('getSelections').length);
		console.log('xxx'+tableRestar.bootstrapTable('getSelections').length);
		tableRestar.bootstrapTable('getSelections').length;
						console.log(" seleccionar todos ..");
						var actual=100;
						var total=$("#totalC").text();
						$('.estatusValEstable1').text(actual); 
						document.getElementById("barraProgreso").style.width = actual+"%";
						$(".conciliadoVar").text($("#totalC").text());
						$('#remove').hide();
						$('#remove1').show();
					});

		//remove.prop('disabled', true);
});








//-------------------  DesSeleccionar todos -----------
var tableRestar = $('#tableModal');
var remove = $('#remove');
$(function() {
tableRestar.on('uncheck-all.bs.table',
					function() {
	//alert('4');
//						remove.prop('disabled', !tableRestar.bootstrapTable('getSelections').length);
	console.log(tableRestar.bootstrapTable('getSelections').length);
	tableRestar.bootstrapTable('getSelections').length;
						console.log("deseleccionar todos ..");
						var  valor = $('#ValorActual').text();
						var vaolorDesc;
						vaolorDesc=valor.substring(0, 4);
						// pinta resultado en barra y porcentaje
						$('.estatusValEstable1').text(vaolorDesc); 
						document.getElementById("barraProgreso").style.width = vaolorDesc+"%";
						var resetCon= $('#t_conciliadosTP').text() ;
						console.log("reseteo de variable: "+ resetCon);
						$('.conciliadoVar').text(resetCon);
						//remove.prop('disabled', false);
						$('#remove').show();
						$('#remove1').hide();
					});
//remove.prop('disabled', true);
});






// OBTENER SOLO SELECCIONDOS
/*
var table1 = $('#tableModal');
var button1 = $('#remove');
$(function() {
	button1.click(function() {
//		alert('getSelections: '+ JSON.stringify(table1.bootstrapTable('getSelections')));
		var arreglo= new Array();
		arreglo=JSON.stringify(table1.bootstrapTable('getSelections'));
		actualizarTabla(arreglo);
	});
});
*/

//OBTENER TODA LA TABLA

function updateAll(opc){
	//alert(opc);
	var fecha=$("#fecha").val();
	//alert(fecha);
	$.ajax({
		url :'updateListAll',
		type : "POST",
		cache:false,
		data : { 'fechActuCorre':fecha,"accion":opc},
		dataType : "json",
		success : function(response){
			if(response.success){
				alert('Ok');
			}
			
		},
		error : function(xhr, ajaxOptions, thrownError) {
			alert('Ocurrio un problema');
}		
	});
}

//var table = $('#tableModal');
//var button1 = $('#remove');
//
//$(function() {
//button1.click(function() {
//	console.log("select_all()");
////	alert(JSON.stringify(table.bootstrapTable('getData')));
//	var arreglo= new Array();
//	arreglo=JSON.stringify(table.bootstrapTable('getData'));
//	actualizarTabla(arreglo);
//});
//});



// SE RECUPERA MODAL DATATABLE Y SE PROCESAN LOS DATOS A ACTUALIZAR

function actualizarTabla(arreglo){
	console.log("actualizarTabla()");
	var fechaActualizaCorregido =$('#fecha').val();
	var datos =new Array();
	datos=arreglo;

	$.ajax({
		url :'getJsonActualizar',
		type : "POST",
		traditional:true,
		data : { 'jsonDatos': datos,"fechActuCorre":fechaActualizaCorregido},
		dataType : "json",
		beforeSend: function( xhr ) {
			$('#waitActualiza').modal({backdrop: 'static', keyboard: false});
			console.log("succes : cargando ");
				 },
		success : function(response){
			$('#waitActualiza').modal('hide');
			console.log("succes : ok ");
		},
		error : function(xhr, ajaxOptions, thrownError) {
//			console.log(response.mensaje);
			$('#waitActualiza').modal('hide');
			$('#mensaje').text('Ocurrio un problema');
}		
	});	
}

//  recarga resultados actualizados al guardar los estatus.
$("#myModal").on("hidden.bs.modal", function () {
    // put your default event here
	console.log("close modal(update)");
	intReporte();
});

// ***************************** ----------------  FIN NUEVA FUNCIONALIDAD


$(function() {
	init();
	
});
function init() {
//	alert("online");
	if($('.nueva_seccion').is(":visible")){
	}
	else{
		intReporte();
	}	
}

function intReporte(){
	console.log("intReporte()");
	if($('#fecha').val() != ""){
		$('#nueva_seccion_boton').show('fade');
//		$('#muestra').modal('show');
//		$('.nueva_seccion').hide('fade');
		$('.oculto').hide('fade');
		
		$('#fechaConsulta').text('DIA: ' + $('#fecha').val() );
		$.ajax({
			url : 'getConciliacionAddonsBrmU2000',
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
					$('#fechaReporte').val( $('#fecha').val() );
					
					$('#fechaReporteTabla').val($('#fecha').val());
					
					$("#op1").prop("checked", false);
					$("#op2").prop("checked", false);
			    	$('#tableModal').bootstrapTable('destroy');
			    	$('.tituloTabla').text('');
			    	$('#NoData').text('');
					
					setCtasCiclovsCtasBRMD(jsonResponse.result);					
						
			}else{
				//alert(jsonResponse.success);
				limpiaCampos();
				$('.dateFail').text($('#fecha').val());
				$('#errorModal').modal();
				$('.contentMessage').show('fade');
				$('.contentReporte').hide('fade');
				
			}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				var error = new Object();
				error.mensaje = "Ocurrio un error al intentar procesar su peticion, por favor reintentelo.";
				$('.dateFail').text($('#fecha').val());
				$('#errorModal').modal();
			}
		});
	}
}

// VALORES PRESENTADOS EN LA TABLA INICIAL Y LA GRAFICA DE DONA
function setCtasCiclovsCtasBRMD(result){
	console.log("setCtasCiclovsCtasBRMD");
	var botones = '';
	var total = 0;
	var t_conciliacion  = 0;
	var porcentajeConc = 0;
	var t_no_conciliados = 0;
	var porcentajeNoConc = 0;
	var error_ciclo = 0;
	var error_facturadas = 0;
	var total_brm = 0;
	var porcentajeerrorcuentas = 0;
	var total_ims = 0;
	var porcentajeerrorfacturadas = 0;
	var corregido=0;
	
	$('#fechaReporte').val($('#fecha').val());
	limpiaCampos();
	
	$.each(result, function(index, valores){ 
		// retorna valor corregido 
		corregido+=parseInt(valores.corregido);
		$('.contadorCon').text(corregido);
		
		
		
		total += parseInt(valores.total);
		t_conciliacion += parseInt(valores.t_conciliacion);
		
		t_no_conciliados  += parseInt(valores.error_total);
		error_ciclo += parseInt(valores.error_brm);
		error_facturadas += parseInt(valores.error_u2000);
		total_brm += parseInt(valores.no_brm);
		total_ims += parseInt(valores.no_u2000);

		if(valores.empresa == 'TOTALPLAY'){
			$('.statusConcTP').text("Conciliado");
			$('.t_conciliadosTP').text(accounting.formatNumber(valores.t_conciliacion));
			$('.porcentajeConcTP').text(valores.porcentajeconc + '%');
			
			$('.statusNoConcTP').text("No Conciliado");
			$('.t_no_conciliadosTP').text(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcTP').text(valores.porcentajenoconc + '%');
			
			$('.error_cicloTP').text(accounting.formatNumber(valores.error_brm));
			$('.error_facturadasTP').text(accounting.formatNumber(valores.error_u2000));
			
			$('.porcentajeerrorcuentasTP').text(valores.porcentajeerrorbrm+ '%');
			$('.porcentajeerrorfacturadasTP').text(valores.porcentajeerroru2000+ '%');

			$('.totalBRMTP').text(accounting.formatNumber(valores.no_brm));
			$('.totalimsTP').text(accounting.formatNumber(valores.no_u2000));
			$('.totalTP').text(accounting.formatNumber(valores.total));	
		
			if(valores.status == "SI"  ){
				$('.decision').html('<img src="/CifrasControl/img/tick.png">');
			}else{
				$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png">');
			}
			
			if(valores.porcentajeerrorbrm ==100){
				if(valores.status == "SI"  ){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}else{
				if(valores.status == "SI"  ){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}
			$('.bcolorBRMTP').html(botones);
			
			if(valores.porcentajeerroru2000 ==100){
				if(valores.status == "SI"  ){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}else{
				if(valores.status == "SI"  ){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}
			
//			console.log("valor de porcentaje ################## "+ valores.porcentajeconc);
			// -----   GRAFICA TOTALES ------------------	 
			 var gTOTAL;
			 gTOTAL= new JustGage({
				    id:"grafica",
				    //label: "label",
//				    title: "TOTAL",
//				    titleFontColor: "#4c56de", // color azul
//				    titleFontFamily: "Georgia",
//			        titlePosition: "up",
				    value: valores.porcentajeconc,
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
			
			$('.bcolorimsTP').html(botones);
			
			
		} else if(valores.empresa == 'ENLACE'){
			$('.statusConcENL').text("Conciliado");
			$('.t_conciliadosENL').text(accounting.formatNumber(valores.t_conciliacion));
			$('.porcentajeConcENL').text(valores.porcentajeconc + '%');
			
			$('.statusNoConcENL').text("No Conciliado");
			$('.t_no_conciliadosENL').text(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcENL').text(valores.porcentajenoconc + '%');
			
			$('.error_cicloENL').text(accounting.formatNumber(valores.error_brm));
			$('.error_facturadasENL').text(accounting.formatNumber(valores.error_u2000));
			
			
			$('.porcentajeerrorcuentasENL').text(valores.porcentajeerrorbrm+ '%');
			$('.porcentajeerrorfacturadasENL').text(valores.porcentajeerroru2000+ '%');

			$('.totalBRMENL').text(accounting.formatNumber(valores.no_brm));
			$('.totalimsENL').text(accounting.formatNumber(valores.no_u2000));
			$('.totalENL').text(accounting.formatNumber(valores.total));
			

			if(valores.status == "SI"  ){
				$('.decisionENL').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}else{
				$('.decisionENL').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}
			if(valores.porcentajeerrorbrm ==100){
				if(valores.status == "SI"  ){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}else{
				if(valores.status == "SI"  ){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}
			$('.bcolorBRMENL').html(botones);
			
			if(valores.porcentajeerroru2000 ==100){
				if(valores.status == "SI"  ){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}else{
				if(valores.status == "SI"  ){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}
			$('.bcolorimsENL').html(botones);
			
		} else if(valores.empresa == 'TFE'){
			$('.statusConcTFE').text("Conciliado");
			$('.t_conciliadosTFE').text(accounting.formatNumber(valores.t_conciliacion));
			$('.porcentajeConcTFE').text(valores.porcentajeconc + '%');
			
			$('.statusNoConcTFE').text("No Conciliado");
			$('.t_no_conciliadosTFE').text(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcTFE').text(valores.porcentajenoconc + '%');
			
			$('.error_cicloTFE').text(accounting.formatNumber(valores.error_brm));
			$('.error_facturadasTFE').text(accounting.formatNumber(valores.error_u2000));
			
			$('.porcentajeerrorcuentasTFE').text(valores.porcentajeerrorbrm+ '%');
			$('.porcentajeerrorfacturadasTFE').text(valores.porcentajeerroru2000+ '%');

			$('.totalBRMTFE').text(accounting.formatNumber(valores.no_brm));
			$('.totalimsTFE').text(accounting.formatNumber(valores.no_u2000));
			$('.totalTFE').text(accounting.formatNumber(valores.total));
			

			if(valores.status == "SI"  ){
				$('.decisionTFE').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}else{
				$('.decisionTFE').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}
			if(valores.porcentajeerrorbrm ==100){
				if(valores.status == "SI"  ){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}else{
				if(valores.status == "SI"  ){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}
			$('.bcolorBRMTFE').html(botones);
			
			if(valores.porcentajeerroru2000 ==100){
				if(valores.status == "SI"  ){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}else {
				if(valores.status == "SI"  ){
					botones = '<img src="/CifrasControl/img/green.png">';
				}else{
					botones = '<img src="/CifrasControl/img/red.png">';
				}
			}
			$('.bcolorimsTFE').html(botones);
		}
	});
	
	$('.statusConcT').text("Conciliado");
	$('.t_conciliadosT').text(accounting.formatNumber(t_conciliacion));
	porcentajeConc = (total>0)?((t_conciliacion * 100)/total):0;
	$('.porcentajeConcT').text(accounting.toFixed(porcentajeConc,2) + '%');
	
	$('.statusNoConcT').text("No Conciliado");
	$('.t_no_conciliadosT').text(accounting.formatNumber(t_no_conciliados));
	porcentajeNoConc = (total>0)?((t_no_conciliados * 100)/total):0;
	$('.porcentajeNoConcT').text(accounting.toFixed(porcentajeNoConc,2) + '%');
	
	$('.error_cicloT').text(accounting.formatNumber(error_ciclo));
	$('.error_facturadasT').text(accounting.formatNumber(error_facturadas));
	
	porcentajeerrorcuentas =(total>0)?((error_ciclo * 100)/total):0;
	$('.porcentajeerrorcuentasT').text(accounting.toFixed(porcentajeerrorcuentas,2)+ '%');
	porcentajeerrorfacturadas =(total>0)?((error_facturadas * 100)/total):0;
	$('.porcentajeerrorfacturadasT').text(accounting.toFixed(porcentajeerrorfacturadas,2)+ '%');

	$('.totalBRMT').text(accounting.formatNumber(total_brm));
	$('.totalimsT').text(accounting.formatNumber(total_ims));
	$('.totalT').text(accounting.formatNumber(total));
	
	

	if(porcentajeConc == 100 ){
		$('.decisionT').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	}else{
		$('.decisionT').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	}

	if(porcentajeerrorcuentas ==100){
		botones = '<img src="/CifrasControl/img/green.png">';
//	}else if(porcentajeerrorcuentas > 1 && porcentajeerrorcuentas <= 15 ){
//		botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
	}else if(porcentajeerrorcuentas<100 ){
		botones = '<img src="/CifrasControl/img/red.png">';
	}
	$('.bcolorBRMT').html(botones);
	
	if(porcentajeerrorfacturadas ==100){
		botones = '<img src="/CifrasControl/img/green.png">';
//	}else if(porcentajeerrorfacturadas > 1 && porcentajeerrorfacturadas <= 15 ){
//		botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
	}else if(porcentajeerrorfacturadas<100 ){
		botones = '<img src="/CifrasControl/img/red.png">';
	}
	$('.bcolorimsT').html(botones);
}

// LIMPIA CAMPOS 
function limpiaCampos(){
	console.log("limpiaCampos");
	    $('#grafica').text(''); //-- inicializar bacio
		$('.decision').html("");
	
		$('.statusConcTP').text("Conciliado");
		$('.t_conciliadosTP').text('-');
		$('.porcentajeConcTP').text('0%');
		
		$('.statusNoConcTP').text("No Conciliado");
		$('.t_no_conciliadosTP').text('-');
		$('.porcentajeNoConcTP').text('0%');
		
		$('.error_cicloTP').text('');
		$('.error_facturadasTP').text('');
		
		$('.porcentajeerrorcuentasTP').text('0%');
		$('.porcentajeerrorfacturadasTP').text('0%');

		$('.totalBRMTP').text('');
		$('.totalIMSTP').text('');
		$('.totalTP').text('');	
	
		$('.statusConcENL').text("Conciliado");
		$('.t_conciliadosENL').text('-');
		$('.porcentajeConcENL').text('0%');
		
		$('.statusNoConcENL').text("No Conciliado");
		$('.t_no_conciliadosENL').text('-');
		$('.porcentajeNoConcENL').text('0%');
		
		$('.error_cicloENL').text('');
		$('.error_facturadasENL').text('');
		
		$('.porcentajeerrorcuentasENL').text('0%');
		$('.porcentajeerrorfacturadasENL').text('0%');

		$('.totalBRMENL').text('');
		$('.totalimsENL').text('');
		$('.totalENL').text('');
		
		$('.statusConcTFE').text("Conciliado");
		$('.t_conciliadosTFE').text('-');
		$('.porcentajeConcTFE').text('0%');
		
		$('.statusNoConcTFE').text("No Conciliado");
		$('.t_no_conciliadosTFE').text('-');
		$('.porcentajeNoConcTFE').text('0%');
		
		$('.error_cicloTFE').text('');
		$('.error_facturadasTFE').text('');
		
		$('.porcentajeerrorcuentasTFE').text('0%');
		$('.porcentajeerrorfacturadasTFE').text('0%');

		$('.totalBRMTFE').text('');
		$('.totalIMSTFE').text('');
		$('.totalTFE').text('');	

		$('.statusConcT').text("Conciliado");
		$('.t_conciliadosT').text('-');
		$('.porcentajeConcT').text('0%');
		
		$('.statusNoConcT').text("No Conciliado");
		$('.t_no_conciliadosT').text('-');
		$('.porcentajeNoConcT').text('0%');
		
		$('.error_cicloT').text('');
		$('.error_facturadasT').text('');
		
		$('.porcentajeerrorcuentasT').text('0%');
		$('.porcentajeerrorfacturadasT').text('0%');
		
		$('.totalBRMT').text('');
		$('.totalIMST').text('');
		$('.totalT').text('');
}
$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });

//************************************************************************************************
//************************************************************************************
//********************************************************** NUEVA SECCION
$('#confmodal').on('hide.bs.modal', function () {
	consulta_tabla();
});

// -------------------------------  TRABAJANDO -----------------------
function muestra_seccion(){
	console.log("muestra_seccion()");
	
	$('.contentMessage').hide();
//	$('.contentReporte').hide();
	$('#nueva_seccion_boton').show();
//	$('.nueva_seccion').show('fade');
}
function regresa_reporte(){
//	$('.nueva_seccion').hide('fade');
	$('#nueva_seccion_boton').show();	
	intReporte();
}
//---------------------------------------Funcionamiento de Radio Buttons
function consulta_tabla() {
	
	if(document.getElementById("pdcat").checked){
		opcion=1;
	}
	if(document.getElementById("pi").checked){
		opcion=2;
		}
	if(document.getElementById("ccat").checked){
		opcion=3;
	}
	if(document.getElementById("addcat").checked){
		opcion=4;
	}

	$.ajax({
		url : 'getConciliacionAddonsBrmPromocionesU2000',
		type : "POST",
		async : false,
		data : {
			'opcion': opcion
		},
		dataType : "json",
		beforeSend: function( xhr ) {
			 $('#loadModal').modal();
		 },
		success : function(jsonResponse, textStatus, jqXHR){
			 $('#loadModal').modal('hide');
			if(jsonResponse.success){
				$('.insertar_boton').show('fade');
				
				if(opcion==1)
				contruyePDCAT(jsonResponse);
				if(opcion==2)
				contruyePI(jsonResponse);
				if(opcion==3)
				contruyeCCAT(jsonResponse);
				if(opcion==4)
				contruyeADDCAT(jsonResponse);
		}else{
			
			if(opcion==1)
				contruyePDCAT(jsonResponse);
				if(opcion==2)
				contruyePI(jsonResponse);
				if(opcion==3)
				contruyeCCAT(jsonResponse);
				if(opcion==4)
				contruyeADDCAT(jsonResponse);			
		}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$('#loadModal').modal('hide');
			$('#errorModal').modal();
		}
	});
}


 //  *********************************************  INICIO   MODULO DE PROMOCIONES 

// Promocion Doble CAT  = PDCAT
function contruyePDCAT(jsonResponse){	
	console.log("contruyePDCAT");
	$('#divReport').text('');
	var html, table, body = '';
	var header = '<table id="listaTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer  table-striped">' + '<THEAD>'
	+ '<tr>' 
	+ '<th><small>POID</small></th>'
	+ '<th><small>Producto</small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				html = '<tr><td name="poid">';
				html = html + arrayValores.poid;
				html = html + '</td>';
				html = html + '<td name="producto">';
				html = html + arrayValores.producto;
				html = html + '</td>';
				html = html + '</tr>';
				body = body + html;
			});
	
	$('#textos').text('');
	var textos='';
	textos=textos+'<div class="col-md-2"><p class="elemento"><span>POID</span></p>';
	textos=textos+'<input type="text" class="form-control" id="poid" onKeyUp="this.value=this.value.toUpperCase();"></div>';
	
	textos=textos+'<div class="col-md-2"><p class="elemento"><span>Producto</span></p>';
	textos=textos+'<input type="text" class="form-control" id="producto" onKeyUp="this.value=this.value.toUpperCase();"></div>';
	$(textos).appendTo('#textos');
	
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

//    Paquete Intermedia  = PI
function contruyePI(jsonResponse){	
	console.log("contruyePI");
	$('#divReport').text('');
	var html, table, body = '';
	var header = '<table id="listaTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer  table-striped">' + '<THEAD>'
	+ '<tr>' 
	+ '<th><small>Paquete</small></th>'
	+ '<th><small>Megas Bajada</small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				
				html = '<tr><td name="paquete">';
				html = html + arrayValores.paquete;
				html = html + '</td>';
				html = html + '<td name="megas_bajada">';
				html = html + arrayValores.megas_bajada;
				html = html + '</td>';
				html = html + '</tr>';
				body = body + html;
			});
	
	$('#textos').text('');
	var textos='';
	textos=textos+'<div class="col-md-2"><p class="elemento"><span>Paquete</span></p>';
	textos=textos+'<input type="text" class="form-control" id="paquete" onKeyUp="this.value=this.value.toUpperCase();"></div>';
	
	textos=textos+'<div class="col-md-2"><p class="elemento"><span>Megas bajada</span></p>';
	textos=textos+'<input type="text" class="form-control" id="megas_bajada" onKeyUp="this.value=this.value.toUpperCase();"></div>';
	$(textos).appendTo('#textos');
		
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

//    Crecelo CAT  = CCAT
function contruyeCCAT(jsonResponse){	
	console.log("contruyeCCAT ");
	$('#divReport').text('');
	var html, table, body = '';
	var header = '<table id="listaTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer  table-striped">' + '<THEAD>'
	+ '<tr>' 
	+ '<th><small>POID</small></th>'
	+ '<th><small>Producto</small></th>'
	+ '<th><small>Megas</small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				html = '<tr><td name="poid">';
				html = html + arrayValores.poid;
				html = html + '</td>';
				html = html + '<td name="producto">';
				html = html + arrayValores.producto;
				html = html + '</td>';
				html = html + '<td name="megas">';
				html = html + arrayValores.megas;
				html = html + '</td>';
				html = html + '</tr>';
				body = body + html;
			});
	
	$('#textos').text('');
	var textos='';
	textos=textos+'<div class="col-md-2"><p class="elemento"><span>POID</span></p>';
	textos=textos+'<input type="text" class="form-control" id="poid" onKeyUp="this.value=this.value.toUpperCase();"></div>';
	
	textos=textos+'<div class="col-md-2"><p class="elemento"><span>Producto</span></p>';
	textos=textos+'<input type="text" class="form-control" id="producto" onKeyUp="this.value=this.value.toUpperCase();"></div>';
	
	textos=textos+'<div class="col-md-2"><p class="elemento"><span>Megas</span></p>';
	textos=textos+'<input type="text" class="form-control" id="megas" onKeyUp="this.value=this.value.toUpperCase();"></div>';
	
	$(textos).appendTo('#textos');
	
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

//  Adicionales CCAT   = ADDCAT

function contruyeADDCAT(jsonResponse){	
	console.log("contruyeADDCAT ");
	$('#divReport').text('');
	var html, table, body = '';
	var header = '<table id="listaTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer  table-striped">' + '<THEAD>'
	+ '<tr>' 
	+ '<th><small>POID</small></th>'
	+ '<th><small>Producto</small></th>'
	+ '<th><small>Megas</small></th>'
	+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
				html = '<tr><td name="poid">';
				html = html + arrayValores.poid;
				html = html + '</td>';
				html = html + '<td name="producto">';
				html = html + arrayValores.producto;
				html = html + '</td>';
				html = html + '<td name="megas">';
				html = html + arrayValores.megas;
				html = html + '</td>';
				html = html + '</tr>';
				body = body + html;
			});
	$('#textos').text('');
	var textos='';
	textos=textos+'<div class="col-md-2"><p class="elemento"><span>POID</span></p>';
	textos=textos+'<input type="text" class="form-control" id="poid" onKeyUp="this.value=this.value.toUpperCase();"></div>';
	
	textos=textos+'<div class="col-md-2"><p class="elemento"><span>Producto</span></p>';
	textos=textos+'<input type="text" class="form-control" id="producto" onKeyUp="this.value=this.value.toUpperCase();"></div>';
	
	textos=textos+'<div class="col-md-2"><p class="elemento"><span>Megas</span></p>';
	textos=textos+'<input type="text" class="form-control" id="megas" onKeyUp="this.value=this.value.toUpperCase();"></div>';
	$(textos).appendTo('#textos');
	
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
//----------------------- Insercci�n de elementos a la tabla de promociones
function insertarb(){
	console.log("insertarb()");
	validacion='';
	
	if(document.getElementById("pdcat").checked){
		if($('#poid').val()!=''&&$('#producto').val()!='')
			validacion="ok";
			console.log("poid: " + $('#poid').val() + " producto: " + $('#producto').val());
		}
	if(document.getElementById("pi").checked){	
		if($('#paquete').val()!=''&&$('#megas_bajada').val()!='')
			validacion="ok";
			console.log("paquete: " + $('#paquete').val() + " megas_bajada: " + $('#megas_bajada').val());
	}
	if(document.getElementById("ccat").checked){
		if($('#poid').val()!=''&&$('#producto').val()!=''&&$('#megas').val()!='')
			validacion="ok";
			console.log("poid: " + $('#poid').val() + " producto: " + $('#producto').val() + " megas: " + $('#megas').val());
	}
	if(document.getElementById("addcat").checked){
		if($('#poid').val()!=''&&$('#producto').val()!=''&&$('#megas').val()!='')
			validacion="ok";
			console.log("poid: " + $('#poid').val() + " producto: " + $('#producto').val() + " megas: " + $('#megas').val());
	}
	
	if(validacion=="ok"){
	$('#msj').text('�Est� seguro de que desea insertar los datos seleccionados?');
	$('.botones').show();
	$('#confmodal').modal('show');
	}
}

function consulta_insertar() {
	console.log("consulta_insertar()");
	var opcion=0;
	
	var paquete='';
	var megas_bajada='';
	var poid='';
	var producto='';
	var megas='';
	
	if(document.getElementById("pdcat").checked){
		opcion=1;
		poid= $('#poid').val();
		producto= $('#producto').val();
	}
	if(document.getElementById("pi").checked){
		opcion=2;
		paquete= $('#paquete').val();
		megas_bajada= $('#megas_bajada').val();
		}
	if(document.getElementById("ccat").checked){
		opcion=3;
		poid= $('#poid').val();
		producto= $('#producto').val();
		megas= $('#megas').val();
	}
	if(document.getElementById("addcat").checked){
		opcion=4;
		poid= $('#poid').val();
		producto= $('#producto').val();
		megas= $('#megas').val();
	}

	console.log("poid: "+poid+" producto: "+producto+" megas: "+megas+" paquete: "+paquete+" megas_bajada: "+megas_bajada+" opcion: "+opcion);
	$.ajax({
		url : 'insertarAdicionalesU2000BrmPromociones',
		type : "POST",
		data : {
			'opcion' : opcion,
			'paquete': paquete,
			'megas_bajada': megas_bajada,
			'poid': poid,
			'producto': producto,
			'megas' : megas
				},
		dataType : "json",
		beforeSend: function( xhr ) {
			 $('#loadModal').modal();
		 },
		success : function(jsonResponse, textStatus, jqXHR){
			$('#loadModal').modal('hide');

			if(jsonResponse.success){						
				$('#msj').text(jsonResponse.mensaje);
				$('.botones').hide('');
			}
		},
		error : function(jqXHR, textStatus, errorThrown){
			console.log(textStatus);
			$('#loadModal').modal('hide');
		}
	});
}

//*********************************************  FIN   MODULO DE PROMOCIONES
// valor de session descarga excel
function getValor() {
//	console.log("adicionalesU2000Brm");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1') ||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}



// ********* CODIGO DEMO *****


function pintaReporte2(fech){
	console.log("#2");
	$('#PA').hide();
	$('#PC').hide();
	$('#remove').hide();
	if(fech != ""){	
		$.ajax({
			url : 'exportDetalleConciliacionAddonsBrmU2000DetailsTablaJson2',
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
					
															
					$('.tituloTabla').text("Detalle de megas contratados en U2000 que estan inconsistentes en BRM");
					//console.log("Detalle de los cuentas existentes en SAP y no en BRM ");
					
					
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    search: true,
					    
					    columns: [{
					        field: 'accion',
					        title: 'ACCION',
					        sortable: true,
					        clickToSelect:true,
					        formatter: "CheckBoxDemo"
//					        checkbox:true,
					        
					    },{
					        field: 'fecha',
					        title: 'Fecha',
					        sortable: true
					    }, {
					        field: 'cuenta',
					        title: 'Cuenta',
					        sortable: true
					    }, {
					        field: 'addons',
					        title: 'ADDONS',
					        sortable: true
					    },{
					        field: 'megas',
					        title: 'Megas',
					        sortable: true
					    }, {
					        field: 'descr',
					        title: 'Descripci�n',
					        sortable: true
					    }, {
					        field: 'ont',
					        title: 'ONT',
					        sortable: true
					    }, {
					        field: 'perfil_bajada',
					        title: 'Perfil Bajada',
					        sortable: true
					    }, ]
					});
					$('#PA').show();
					$('#PC').show();
					$('#remove').show();
					 					
				}else{
					$('.tituloTabla').text('');
					$('#NoData').text("No se encontraron datos");
					$('#PA').hide();
					$('#PC').hide();
					$('#remove').hide();
					//console.log("Error en la tabla");
				}
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
			}
		});
	}
}


async function test(){
//	alert('1');
//	await downloadReport();
//	alert('2');
	$.get( "exportDetalleConciliacionAddonsBrmU2000Details", { fecha: $("#fechaReporte").val() } )
	  .done(function( data ) {
	    alert( "Data Loaded: " + data );
	  });
	
}

async function downloadReport(){
	console.log('into downloadReport');
	$('#loadModal').modal();
	return new Promise(function(resolve, reject){
	
		
		
	var form = document.createElement("form"); //created dummy form for submitting.
	var fechaI=$("#fechaReporte").val();
    var fechaHidden = document.createElement("input"); 
    form.method = "GET";
    form.action = "exportDetalleConciliacionAddonsBrmU2000Details";
    
    fechaHidden.value=fechaI; //its a json string I need to pass to server.
    fechaHidden.name="fecha";
    fechaHidden.type = 'hidden';
    
    form.appendChild(fechaHidden);
    
    document.body.appendChild(form);

    form.submit().then(function(){
    	alert('ya se termino');
    });
    
   
    resolve(1).then(function(n){
    	alert(n);
    });
   
	});
	
//	 $('#loadModal').modal('hide');
}

function getCount(tableOrReport){
	//1=reporte,2=tabla
	//pintaPorcentaje();
	$('#PA').hide();
	$('#PC').hide();
	$('#remove').hide();
	$('#remove1').hide();
	// provicional 
	pintaPorcentaje();
	var fech =$('#fechaReporte').val();
	
		$.ajax({
			url : 'getConteoDetails',
			type : "POST",
			async : true,
			cache:false,
			data : {'fechaTabla' :fech},
			dataType : "json",
			 beforeSend: function( xhr ) {
				 $('#wait').modal({backdrop: 'static', keyboard: false});
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				
				var elements = jsonResponse;
				
				if(elements>40000){
					
					//llamar en tres partes
					var mod = elements % 4;
					var div = elements / 4;

					var sizeLeft = parseInt(div);
					var sizeCenter = parseInt(div);
					var sizeCenter1 = parseInt(div);
					var sizeRight = parseInt(div + mod);
					

					if(tableOrReport=='2'){
						var data=null;
						$('#PA').hide();
						$('#PC').hide();
						$('#remove').hide();
						
						pintaReporte3(fech,1,sizeLeft);
						getTableData(fech,sizeLeft+sizeCenter+1,sizeLeft+sizeCenter+sizeCenter1);
						//$('#tableModal').bootstrapTable('refresh');
						getTableData(fech,sizeLeft+1,sizeLeft+sizeCenter)
						//$('#tableModal').bootstrapTable('refresh');
						getTableData(fech,sizeLeft+sizeCenter+sizeCenter1+1,elements);

						pintaPorcentaje();
						$('#divDetalle').show();
						$('#PA').show();		 			// porcentaje actual.
						$('#PC').show(); 					// porcentaje  proyectado.
						//$('#remove').show();			// boton de No corregir.
					}else{
						exportToExcelJson(fech,1,sizeLeft);
							exportToExcelJson(fech,sizeLeft+1,sizeLeft+sizeCenter);
								exportToExcelJson(fech,sizeLeft+sizeCenter+1,sizeLeft+sizeCenter+sizeCenter1);
									exportToExcelJson(fech,sizeLeft+sizeCenter+sizeCenter1+1,elements);
					}								
				}else{
					//traer todo
					
					if(tableOrReport=='2'){
						//$("#bodyTableModal").empty();
						pintaPorcentaje();
						
						//pintaPorcentaje();
						$('#PA').hide();
						$('#PC').hide();
						//$('#remove').hide();
						pintaReporte3(fech,1,elements);
						$('#divDetalle').show();
//						$('#tableModal').bootstrapTable({   	// dibuja tabla
//						    data : jsonResponse.result,
//						    pagination:true,
//	  						search:true,
//	 						toolbar:'#toolbar',
//	  						clickToSelect:"true"
//						});
//						$('#divDetalle').show();
//						$('#PA').show();		 			// porcentaje actual.
//						$('#PC').show(); 					// porcentaje  proyectado.
//						$('#remove').show();			// boton de No corregir.
					}else{
						exportToExcelJson(fech,1,elements);
					}
					
				}
				
				$('#wait').modal('hide');
				
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
			}
		});
	
	
}


 function exportToExcelJson(fech,row1,row2){
		$.ajax({
			url : 'exportDetalleConciliacionAddonsBrmU2000DetailsTablaJson',
			type : "POST",
			async : false,
			cache:false,
			data : {'fechaTabla' :fech,'row1':row1,'row2':row2},
			dataType : "json",
			success : function(jsonResponse, textStatus, jqXHR){
				$('#wait').modal('hide');
				
				if(jsonResponse.success){	
					$("#btn-Reporte").show();
					var exportDataE=[];
					//Encabezados
					exportDataE.push(
							[ 
					          {"text": 'addons'},
					          {"text": 'cuenta'},
					          {"text": 'descr'},
					          {"text": 'fecha'}
					          ]
					);
					//Contenido
					$.each( jsonResponse.result, function( key, value ) {
						exportDataE.push(
						        [ 
						          {"text": value.addons},
						          {"text": value.cuenta==undefined?"-":value.cuenta},
						          {"text": value.descr==undefined?"-":value.descr},
						          {"text": value.fecha==undefined?"-":value.fecha}

						 ]
						        );
//						console.log(key);
						});
					
					var tabularData = [{
					     "sheetName": "ReporteMegas",
					     "data": exportDataE
					 }];
					 
					 var options = {
					     fileName: "ReporteMegas"
					 };
					 Jhxlsx.export(tabularData, options);

				}else{
					alert('No hay Contenido') ;
				}
			},

			error : function(jqXHR, textStatus, errorThrown){
				console.log(textStatus);
			}
		});
	
}