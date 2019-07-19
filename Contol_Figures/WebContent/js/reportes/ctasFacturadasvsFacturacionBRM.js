	

	
function format ( d ) {
	
	if(d.archivo=='BRM'){
		return 'No se encontro en Interfactura (Check)'
	}else{
		return '<div class="col-md-12">'+
		'<div class="row">'+
		'<div class="col-md-3">'+
		'<table class="table-bordered" >'+
	    '<tr>'+
	        '<td><b>Factura Internet</b></td>'+
	        '<td>'+d.folio3+'</td>'+
	    '</tr>'+
	    '<tr>'+
	        '<td>Folio Fiscal:</td>'+
	        '<td>'+d.folio_fiscal3+'</td>'+
	    '</tr>'+
	    '<tr>'+
	        '<td>Monto:</td>'+
	        '<td>'+d.total3+'</td>'+
	    '</tr>'+
	'</table>'+'</div>'+

	'<div class="col-md-3">'+
	'<table class="table-bordered" >'+
	'<tr>'+
	    '<td><b>Factura Television.</b></td>'+
	    '<td>'+d.folio1+'</td>'+
	'</tr>'+
	'<tr>'+
	    '<td>Folio Fiscal:</td>'+
	    '<td>'+d.folio_fiscal+'</td>'+
	'</tr>'+
	'<tr>'+
	    '<td>Monto:</td>'+
	    '<td>'+d.total1+'</td>'+
	'</tr>'+
	'</table>'+'</div>'+

	'<div class="col-md-3">'+
	'<table class="table-bordered" >'+
	'<tr>'+
	    '<td><b>Factura Total Box.</b></td>'+
	    '<td>'+d.folio2+'</td>'+
	'</tr>'+
	'<tr>'+
	    '<td>Folio Fiscal:</td>'+
	    '<td>'+d.folio_fiscal2+'</td>'+
	'</tr>'+
	'<tr>'+
	    '<td>Monto:</td>'+
	    '<td>'+d.total2+'</td>'+
	'</tr>'+
	'</table>'+'</div>'+

	'<div class="col-md-3">'+
	'<table class="table-bordered" >'+
	'<tr>'+
	    '<td><b>Estado de Cuenta</b></td>'+
	    '<td>Estado de cuenta: '+d.account_no+'</td>'+
	'</tr>'+
	'<tr>'+
	    '<td>Folio Fiscal:</td>'+
	    '<td>N/A</td>'+
	'</tr>'+
	'<tr>'+
	    '<td>Monto:</td>'+
	    '<td>$0</td>'+
	'</tr>'+
	'</table>'+'</div>'+

	'</div>'+
	'</div>';
	}
	
	
	
    //return 'Esto es un ejemplo';
//    'Full name: '+d.first_name+' '+d.last_name+'<br>'+
//        'Salary: '+d.salary+'<br>'+
//        'The child row can contain any data you wish, including links, images, inner tables etc.';
}
//	
		
	    
	 
	    // Array to track the ids of the details displayed rows
var dt='';
	    $(document).ready(function() {
	    	
	    	  var detailRows = [];
	    	  
	    	  $('#bodyDetailInterfactura').on('click', 'td.details-control', function () {
	    		  
	    	        var tr = $(this).closest('tr');
	    	        var row = dt.row( tr );
	    	      
	    	        var idx = $.inArray( tr.attr('id'), detailRows );
	    	       
	    	 
	    	        if ( row.child.isShown() ) {
	    	        	console.log('remover clase details');
	    	            tr.removeClass( 'details' );
	    	            row.child.hide();
	    	 
	    	            // Remove from the 'open' array
	    	            detailRows.splice( idx, 1 );
	    	        }
	    	        else {
	    	        	console.log('agregar clase details');
	    	            tr.addClass( 'details' );
	    	            row.child( format( row.data() ) ).show();
	    	 
	    	            // Add to the 'open' array
	    	            if ( idx === -1 ) {
	    	                detailRows.push( tr.attr('id') );
	    	            }
	    	        }
	    	    } );
	    	  
	    	  
	    	  $("#detailInterfactura").on( 'draw.dt', function () {
	    		 
	    	        $.each( detailRows, function ( i, id ) {
	    	            $('#'+id+' td.details-control').trigger( 'click' );
	    	        } );
	    	    } );
	   
	} );
	    
	    

	    
	   
	    
	    function getDetailInterfactura(){
        	var fecha=$("#fecha").val();
        	var cptfeTabla=$('#cptfeTabla').val();
        	var cptpTabla=$('#cptpTabla').val();
        	var cpenlTabla=$('#cpenlTabla').val();
        	//alert(cptfeTabla+" "+cptpTabla+" "+cpenlTabla);
        	if (! ($.fn.dataTable.isDataTable( '#detailInterfactura' )) ) {
        		$.ajax({
            		url:'getDetailInterfactura',
            		type:'POST',
            		dataType:'JSON',
            		cache:false,
            		//async:false,
            		data:{'fecha':fecha,'cptfeTabla':cptfeTabla, 
    					'cptpTabla': cptpTabla, 
    					'cpenlTabla': cpenlTabla},
            		beforeSend: function( xhr ) {
            			$('#wait').modal({backdrop: 'static', keyboard: false});
            		},
            		complete: function () {
            			$('#wait').modal('hide');
                    },
            		success: function(data){
            			console.log(data.result);
            			
            				//dt.destroy(); 
            				$("#bodyDetailInterfactura").empty();
            				dt = $('#detailInterfactura').DataTable( {
            					 dom: 'Bfrtip',
            					 buttons: [
    					             'copy', 'csv', 'excel'
    					         ],
                		        "processing": true,
                		        //"serverSide": true,
                		        retrieve: true,
                		        //paging: false,
                		       "data": data.result,
                		        "columns": [
                		            {
                		                "class":          "details-control",
                		                "orderable":      false,
                		                "data":           '',
                		                "defaultContent": '<img src="images/sort_desc.png" >'
                		            },
                		            { "data": 'fecha_i' },
                		            { 'data': 'account_no'},
                		            { "data": 'num_factura'},
                		            { "data": 'archivo' },
                		            { "data": '','defaultContent':'TOTALPLAY' },
                		            { "data":null,
                		            	"render": function ( data, type, row ) { 
                		                	//console.log(row.total1);
                		                   return parseFloat(row.total1,2)+parseFloat(row.total2,2)+parseFloat(row.total3,2);}
                		                 }


                		        ],
                		        "order": [[4, 'desc']]
                		    } );
            			
            				$.post( "getResumeInterfactura",{'fecha':fecha}, function( data ) {
            					
            					$("#bodyResumeInterfactura").empty();
            					 	$("#tableResumeInterfactura").show();
            					 	$.each(data.result,function(i,v){
            					 		$("#bodyResumeInterfactura").append('<tr>'+
                					 			'<th>'+v.TOTAL_COMP+'</th>'+
                					 			'<th>'+v.TOTAL_EDO_CTA+'</th>'+
                					 			'<th>'+v.TOTAL_FACT+'</th>'+
                					 			'<th>'+v.TOTAL_NOTAS+'</th>'+
                					 			'<th>'+v.no_brm+'</th>'+
                					 			'</tr>'+
                					 			'<tr>'                					 			+
                					 			//'<th>'+parseInt(v.TOTAL_COMP)*(0.36)+'<th>'
//                					 			'<th>'+v.TOTAL_EDO_CTA*0.18+'<th>'
//                					 			'<th>'+v.TOTAL_FACT*0.18+'<th>'
//                					 			'<th>'+v.TOTAL_NOTAS*0.18+'<th>'+
                					 			'</tr>'
                					 			
                					 			);
            					 	});
            					 	$("#tableResumeInterfactura").DataTable({
            					 		 dom: 'Bfrtip',
            					 		 buttons: [
            					              'excel', 'pdf'
            					         ],
            					         "searching": false
            					 	});
            					 	
            					  //
            					});
            			
            		}, 
            		error : function(jqXHR, textStatus, errorThrown){
        				console.log(textStatus);
        			}
            	});
        		
        	}
        	 
        }
	    
	 





//alert("configurando pagina");
$('.detalle').click(function(){
	$('#myModal').modal('show');
	cleanX();
});

$('#opc1').click(function(){
	$('#empresas1').show('fade');
	$('#back').show('fade');
});

function cleanX(){
	$('.consultaX').text('');
	$('#NoData').text('');
	$('.tituloTabla').text('');
	$('#tableModal').bootstrapTable('destroy');
	$('.table-result').show();	
}
//consultas opcion 1
function consultaTp1(){
	cleanX();
//	console.log('consulta 1.1');
//	console.log($('.btn1').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn1').val());
	pintaReporte1($('#cptfeTabla').val(), $('#cptpTabla').val(), $('#cpenlTabla').val(), $('.btn1').val());
}
function consultaEnl1(){
	cleanX();
//	console.log('consulta 2.1');
//	console.log($('.btn2').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn2').val());
	pintaReporte1($('#cptfeTabla').val(), $('#cptpTabla').val(), $('#cpenlTabla').val(), $('.btn2').val());
}
function consultaTfe1(){
	cleanX();
//	console.log('consulta 3.1');
//	console.log($('.btn3').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn3').val());
	pintaReporte1($('#cptfeTabla').val(), $('#cptpTabla').val(), $('#cpenlTabla').val(), $('.btn3').val());
}
function consultaTt1(){
	cleanX();
//	console.log('consulta 4.1');
//	console.log($('.btn4').val());
	$('.consultaX').text("Consulta Actual: "+$('.btn4').val().toUpperCase());
	pintaReporte1($('#cptfeTabla').val(), $('#cptpTabla').val(), $('#cpenlTabla').val(), $('.btn4').val());
}

function pintaReporte1(cptfeTabla, cptpTabla, cpenlTabla, filtro){
	
	//if(fech != ""){	
		
		$.ajax({
			url : 'exportDetallectasFactvsFactBRMIFTablaJson',
			type : "POST",
			async : true,
			data : {'cptfeTabla':cptfeTabla, 
					'cptpTabla': cptpTabla, 
					'cpenlTabla': cpenlTabla,
					'filtro': filtro},
			dataType : "json",
			beforeSend: function( xhr ) {
				$('#wait').modal({backdrop: 'static', keyboard: false});
			},
			complete: function () {
				$('#wait').modal('hide');
            },
            cache: false,
			success : function(jsonResponse, textStatus, jqXHR){
				//$('#loadModal').modal('hide');
				if(jsonResponse.success){
															
					$('.tituloTabla').text("Detalle de Montos que estan en BRM y que no se encontraron en la respuesta de interfactura");
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
					        field: 'empresa',
					        title: 'Empresa',
					        sortable: true
					    }, {
					        field: 'monto',
					        title: 'Monto',
					        sortable: true
					    }, {
					        field: 'fecha_factura',
					        title: 'Fecha de Factura',
					        sortable: true
					    },  {
					        field: 'fecha_vencimiento',
					        title: 'Fecha de Vencimiento',
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
	//}
}


function pintaReporte2(cptfeTabla, cptpTabla, cpenlTabla, filtro){
	
	//if(fech != ""){	
		
		$.ajax({
			url : 'exportDetallectasFactvsFactBRMIFTablaJson2',
			type : "POST",
			async : true,
			data : {'cptfeTabla':cptfeTabla, 
					'cptpTabla': cptpTabla, 
					'cpenlTabla': cpenlTabla,
					'filtro': filtro},
			dataType : "json",
			beforeSend: function( xhr ) {
				$('#wait').modal({backdrop: 'static', keyboard: false});
			},
			complete: function () {
				$('#wait').modal('hide');
            },
            cache: false,
			success : function(jsonResponse, textStatus, jqXHR){
				//$('#loadModal').modal('hide');
				if(jsonResponse.success){
																				
					$('.tituloTabla').text("Detalle de Montos que estan en BRM y que no se encontraron en la respuesta de interfactura");
					//console.log("Detalle de los cuentas existentes en SAP y no en BRM ");
									
					$('#tableModal').bootstrapTable({
					    data : jsonResponse.result,
					    pagination:true,
					    striped: true,
					    search: true,
					    columns: [{
					        field: 'id_conciliacion',
					        title: 'Id',
					        sortable: true
					    }, {
					        field: 'fecha_conci',
					        title: 'Fecha Conci',
					        sortable: true
					    }, {
					        field: 'empresa',
					        title: 'Empresa',
					        sortable: true
					    },{
					        field: 'archivo',
					        title: 'Archivo',
					        sortable: true
					    }, {
					        field: 'account_no',
					        title: 'Account no',
					        sortable: true
					    }, {
					        field: 'num_factura',
					        title: 'Num_factura',
					        sortable: true
					    }, {
					        field: 'folio1',
					        title: 'Folio1',
					        sortable: true
					    },  {
					        field: 'folio2',
					        title: 'Folio2',
					        sortable: true
					    },  {
					        field: 'folio3',
					        title: 'Folio3',
					        sortable: true
					    },  {
					        field: 'razon_social',
					        title: 'Raz�n_social',
					        sortable: true
					    },  {
					        field: 'total1',
					        title: 'Total1',
					        sortable: true
					    },  {
					        field: 'total2',
					        title: 'Total2',
					        sortable: true
					    },  {
					        field: 'total3',
					        title: 'Total3',
					        sortable: true
					    },  {
					        field: 'total2',
					        title: 'Total2',
					        sortable: true
					    },  {
					        field: 'ciclo',
					        title: 'Ciclo',
					        sortable: true
					    },  {
					        field: 'fecha',
					        title: 'Fecha',
					        sortable: true
					    },  {
					        field: 'tipo',
					        title: 'Tipo',
					        sortable: true
					    },  {
					        field: 'error_t',
					        title: 'Error_t',
					        sortable: true
					    }, {
					        field: 'fecha_i',
					        title: 'Fecha_i',
					        sortable: true
					    },  {
					        field: 'rfc',
					        title: 'Rfc',
					        sortable: true
					    },  {
					        field: 'folio_fiscal',
					        title: 'Folio fiscal',
					        sortable: true
					    },  {
					        field: 'folio_fiscal2',
					        title: 'Folio fiscal2',
					        sortable: true
					    },  {
					        field: 'folio_fiscal3',
					        title: 'Folio fiscal3',
					        sortable: true
					    },  {
					        field: 'serie1',
					        title: 'Serie1',
					        sortable: true
					    },  {
					        field: 'rs_facturante1',
					        title: 'Rs_facturante1',
					        sortable: true
					    },  {
					        field: 'serie2',
					        title: 'Serie2',
					        sortable: true
					    },  {
					        field: 'rs_facturante2',
					        title: 'Rs_facturante2',
					        sortable: true
					    },  {
					        field: 'serie3',
					        title: 'Serie3',
					        sortable: true
					    },  {
					        field: 'rs_facturante3',
					        title: 'Rs_facturante3',
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
	//}
}





$(function() {
	initcomponents();
//	alert("online Xxx");
});
function initcomponents(){
//	$('.datepicker').datepicker('setDate', new Date());
	var dateReport = $('.datepicker').val();
	$('.fechaEt').text('');
	$('.fechaEt').html(dateReport);
	
	
	
	$('.datepicker').on("changeDate",function () {
		var datec = $('.datepicker').val();
		$('#fechaReporte').val(datec);
		$('.fechaEt').text('');
		$('.fechaEt').html(datec);
		limpiaCampos();
		getReport();
	  });
}


function getReport(){
	//getDetailInterfactura();
	
	if(document.getElementById("enviadas").checked){
		t_conciliacion=1;
	}
	if(document.getElementById("montos").checked){
		t_conciliacion=2;
	}
	
	$('#opcion').val(t_conciliacion);
	
	if($('#fecha').val() != ""){
		$('.opciones').show('fade');
		
		$('#fechaReporte').val($('#fecha').val());
		$.ajax({
			url : 'reporteCtasFactvsFactBRMIF',
			type : "POST",
			async : false,
			data : {'fecha' : $('#fecha').val(),
					'opcion' : t_conciliacion				
			},
			dataType : "json",
			 beforeSend: function( xhr ) {
				 $('#loadModal').modal();
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				 $('#loadModal').modal('hide');
				if(jsonResponse.success){
					if(jsonResponse.result.length > 0){
						$('#fechaReporte').val( $('#fecha').val() );
						$('.contentMessage').hide('fade');
						$('.contentReporte').show('fade');
//						console.log(jsonResponse);
						pintaReporte(jsonResponse);	
						
						$('#fechaReporteTabla').val($('#fecha').val());
						$('#cptfeTabla').val(cptfe);
						$('#cptpTabla').val(cptp);
						$('#cpenlTabla').val(cpenl);						
						$('#opcionTabla').val(t_conciliacion);
						
						
				    	$('#tableModal').bootstrapTable('destroy');
				    	$('.tituloTabla').text('');
				    	$('#NoData').text('');
						
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

var cptp;
var cpenl;
var cptfe;

function pasar_paramentros(){
	$('#cptfe').val(cptfe);
	$('#cptp').val(cptp);
	$('#cpenl').val( cpenl);
}


function pintaReporte(jsonResponse){
	$('#graficaALL').text(''); //-- inicializar bacio
	$('#graficaTP').text(''); //-- inicializar bacio
	$('#graficaEnlace').text(''); //-- inicializar bacio
	$('#graficaTFE').text(''); //-- inicializar bacio
	
	
	var sum_tconciliacio=0;
	var sum_porc_disp=0;
	var sum_error_total=0;
	var sum_porc_error_total=0;
	var sum_error_brm=0;
	var sum_porc_error_brm=0;
	var sum_error_if=0;
	var sum_porc_error_if=0;
	var sum_no_brm=0;
	var sum_no_if=0;
	var sum_total=0;
	var resultado=0;
	$.each(jsonResponse.result, function(index, valores){ 
		sum_tconciliacio = parseFloat(sum_tconciliacio) + parseFloat(valores.t_conciliacion);
		sum_error_total = parseFloat(sum_error_total) + parseFloat(valores.error_total);
		sum_error_brm = parseFloat(sum_error_brm) + parseFloat(valores.error_brm);
		sum_error_if = parseFloat(sum_error_if) + parseFloat(valores.error_if);
		sum_no_brm = parseFloat(sum_no_brm) + parseFloat(valores.no_brm);
		sum_no_if = parseFloat(sum_no_if) + parseFloat(valores.no_if);
		sum_total = parseFloat(sum_total) + parseFloat(valores.total);
//************************************************************************************************************TOTALPLAY*******************************************************	
		if(valores.empresa == "TOTALPLAY"){
			cptp=valores.id;
		
			
			if(valores.estatus == "SI" ){
				resultado ++;
				$('.decision').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}else{
				$('.decision').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}
			
			if(parseInt(valores.porc_disp) ==100){
				if(valores.estatus == "SI"){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else {
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
//			}else if(valores.porc_disp < 99 && valores.porc_disp >=75 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else {
				if(valores.estatus == "SI"){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else {
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			$('.bcolorBRMTP').html(botones);
			
			if(parseInt(valores.porc_error_total) ==100){
				if(valores.estatus == "SI"){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else {
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
//			}else if(valores.porc_error_total > 1 && valores.porc_error_total ==1005 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				if(valores.estatus == "SI"){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else {
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			

			$('.bcolorifTP').html(botones);
			
			$('.statusConcTP').html("Conciliado");
			$('.t_conciliadosTP').html(accounting.formatNumber(valores.t_conciliacion));
			$('.porcentajeConcTP').html(valores.porc_disp+' %');
			$('.statusNoConcTP').html("No Conciliado");
			$('.t_no_conciliadosTP').html(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcTP').html(valores.porc_error_total+' %');
			$('.error_brmTP').html(accounting.formatNumber(valores.error_brm));
			$('.porcentajeerrorbrmTP').html(valores.porc_error_brm+' %');
			$('.error_if').html(accounting.formatNumber(valores.error_if));
			$('.porcentajeerrorIF').html(valores.porc_error_if+' %');
			$('.totalBRMTP').html(accounting.formatNumber(valores.no_brm));
			$('.totalIF').html(accounting.formatNumber(valores.no_if));
			$('.totalTP').html(accounting.formatNumber(valores.total));
			
			//---------   GRAFICA  TOTALPLAY -----	
			var gTP;
			 gTP= new JustGage({
				    id:"graficaTP",
				    //label: "label",
//				    title: "TOTAL",
//				    titleFontColor: "#4c56de", // color azul
//				    titleFontFamily: "Georgia",
//			        titlePosition: "up",
				    value: valores.porc_disp,
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
			
		}
//************************************************************************************************************ENLACE*******************************************************		
		if(valores.empresa == "ENLACE"){
		
			cpenl=valores.id;
			if(valores.estatus == "SI" ){
				resultado ++;
				$('.decision2').html('<img src="/CifrasControl/img/tick.png" >');
			}else{
				$('.decision2').html('<img src="/CifrasControl/img/icono_alerta.png" >');
			}
			if(parseInt(valores.porc_disp) ==100){
				if(valores.estatus == "SI"){
					botones = '<img src="/CifrasControl/img/green.png">';
					botones = '<img src="/CifrasControl/img/green.png" >';
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else {
					botones = '<img src="/CifrasControl/img/red.png">';
					botones = '<img src="/CifrasControl/img/red.png" >';
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
//			}else if(valores.porc_disp < 99 && valores.porc_disp >= 75 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else if(parseInt(valores.porc_disp) <100 ){
				if(valores.estatus == "SI"){
					botones = '<img src="/CifrasControl/img/green.png">';
					botones = '<img src="/CifrasControl/img/green.png" >';
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else {
					botones = '<img src="/CifrasControl/img/red.png">';
					botones = '<img src="/CifrasControl/img/red.png" >';
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
//--variable que pinta semaforo  -----------------------------------------------------------variable que pinta semaforo -------------------******************************
			$('.bcolorBRMENL').html(botones);
			
			if(parseInt(valores.porc_error_total) == 0){
				if(valores.estatus == "SI"){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else {
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
//			}else if(valores.porc_error_total > 1 && valores.porc_error_total ==1005 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else if(parseInt(valores.porc_error_total) > 0 ){
				if(valores.estatus == "SI"){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else {
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			$('.bcolorifENL').html(botones);
			$('.statusConcENL').html("Conciliado");
			$('.t_conciliadosENL').html(accounting.formatNumber(valores.t_conciliacion));
			$('.porcentajeConcENL').html(valores.porc_disp+' %');
			$('.statusNoConcENL').html("No Conciliado");
			$('.t_no_conciliadosENL').html(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcENL').html(valores.porc_error_total+' %');
			$('.error_brmENL').html(accounting.formatNumber(valores.error_brm));
			$('.porcentajeerrorbrmENL').html(valores.porc_error_brm+' %');
			$('.error_IFENL').html(accounting.formatNumber(valores.error_if));
			$('.porcentajeerrorIFENL').html(valores.porc_error_if+' %');
			$('.totalBRMENL').html(accounting.formatNumber(valores.no_brm));
			$('.totalIFENL').html(accounting.formatNumber(valores.no_if));
			$('.totalENL').html(accounting.formatNumber(valores.total));
			
			//---------   GRAFICA  ENLACE -----	
			var gENLACE;
			 gENLACE= new JustGage({
				    id:"graficaEnlace",
				    //label: "label",
//				    title: "TOTAL",
//				    titleFontColor: "#4c56de", // color azul
//				    titleFontFamily: "Georgia",
//			        titlePosition: "up",
				    value: valores.porc_disp,
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
		}
//************************************************************************************************************ TFE *******************************************************		
		if(valores.empresa == "TFE"){
			
			cptfe=valores.id;
			if(valores.estatus == "SI" ){
				resultado ++;
				$('.decision3').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}else{
				$('.decision3').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
			}
			if(parseInt(valores.porc_disp) ==100){
				if(valores.estatus == "SI"){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else {
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
//			}else if(valores.porc_disp < 99 && valores.porc_disp >= 75 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				if(valores.estatus == "SI"){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else {
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			$('.bcolorBRMTFE').html(botones);
			
			if(parseInt(valores.porc_error_total) == 0){
				if(valores.estatus == "SI"){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else {
					botones = '<img src="/CifrasControl/img/red.png" ">';
				}
//			}else if(valores.porc_error_total >= 1 && valores.porc_error_total ==1005 ){
//				botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
			}else{
				if(valores.estatus == "SI"){
					botones = '<img src="/CifrasControl/img/green.png" >';
				}else {
					botones = '<img src="/CifrasControl/img/red.png" >';
				}
			}
			$('.bcolorIFTFE').html(botones);
			
			$('.statusConcTFE').html("Conciliado");
			$('.t_conciliadosTFE').html(accounting.formatNumber(valores.t_conciliacion));
			$('.porcentajeConcTFE').html(valores.porc_disp+' %');
			
			$('.statusNoConcTFE').html("No Conciliado");
			$('.t_no_conciliadosTFE').html(accounting.formatNumber(valores.error_total));
			$('.porcentajeNoConcTFE').html(valores.porc_error_total+' %');
			
			
			$('.error_brmTFE').html(accounting.formatNumber(valores.error_brm));
			$('.porcentajeerrorbrmTFE').html(valores.porc_error_brm+' %');
			
			
			$('.error_IFTFE').html(accounting.formatNumber(valores.error_if));
			$('.porcentajeerrorIFTFE').html(valores.porc_error_if+' %');
			
			$('.totalBRMTFE').html(accounting.formatNumber(valores.no_brm));
			$('.totalIFTFE').html(accounting.formatNumber(valores.no_if));
			$('.totalTFE').html(accounting.formatNumber(valores.total));
			
			//---------   GRAFICA  TFE -----	
			var gTFE;
			 gTFE= new JustGage({
				    id:"graficaTFE",
				    //label: "label",
//				    title: "TOTAL",
//				    titleFontColor: "#4c56de", // color azul
//				    titleFontFamily: "Georgia",
//			        titlePosition: "up",
				    value: valores.porc_disp,
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
			
		}
	});
	
	if(resultado == 3 ){
		$('.decision4').html('<img src="/CifrasControl/img/tick.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	}else{
		$('.decision4').html('<img src="/CifrasControl/img/icono_alerta.png" height="20" width="20" class="img-responsive" alt="Responsive image">');
	}
	
	sum_porc_disp = ((sum_tconciliacio * 100)/ sum_total).toFixed(2);
	sum_porc_error_total = ((sum_error_total * 100)/ sum_total).toFixed(2);
	sum_porc_error_brm = ((sum_error_brm * 100)/ sum_total).toFixed(2);
	sum_porc_error_if = ((sum_error_if * 100)/ sum_total).toFixed(2);
	
//--------------------------------------------------------------------------------------------- TOTALES ---------------	
	if(sum_porc_disp ==100){
		botones = '<img src="/CifrasControl/img/green.png">';
//	}else if(sum_porc_disp < 99 && sum_porc_disp >= 75 ){
//		botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
	}else if(sum_porc_disp <100 ){
		botones = '<img src="/CifrasControl/img/red.png" >';
	}
	$('.bcolorBRMT').html(botones);
	
	if(sum_porc_error_total ==0){
		botones = '<img src="/CifrasControl/img/green.png" >';
//	}else if(sum_porc_error_total > 1 && sum_porc_error_total ==1005 ){
//		botones = '<img src="/CifrasControl/img/yellow.png" height="30" width="30" class="img-responsive" alt="Responsive image">';
	}else if(sum_porc_error_total > 0 ){
		botones = '<img src="/CifrasControl/img/red.png" >';
	}
	$('.bcolorIFT').html(botones);
	
	
	$('.statusConcT').html("Conciliado");
	$('.t_conciliadosT').html(accounting.formatNumber(sum_tconciliacio));
	$('.porcentajeConcT').html(sum_porc_disp+' %');
	
	$('.statusNoConcT').html("No Conciliado");
	$('.t_no_conciliadosT').html(accounting.formatNumber(sum_error_total));
	$('.porcentajeNoConcT').html(sum_porc_error_total+' %');
	
	
	$('.error_brmT').html(accounting.formatNumber(sum_error_brm));
	$('.porcentajeerrorbrmT').html(sum_porc_error_brm+' %');
	
	
	$('.error_ifT').html(accounting.formatNumber(sum_error_if));
	$('.porcentajeerroriffT').html(sum_porc_error_if+' %');
	
	$('.totalBRMT').html(accounting.formatNumber(sum_no_brm));
	$('.totalIFT').html(accounting.formatNumber(sum_no_if));
	$('.totalT').html(accounting.formatNumber(sum_total));
	
	//---------   GRAFICA  TOTAL TODO -----	
	var gALL;
	 gALL= new JustGage({
		    id:"graficaALL",
		    //label: "label",
//		    title: "TOTAL",
//		    titleFontColor: "#4c56de", // color azul
//		    titleFontFamily: "Georgia",
//	        titlePosition: "up",
		    value: sum_porc_disp,
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
}
function limpiaCampos(){
	$('.decision').text('');
	$('.bcolorBRMTP').text('');
	$('.bcolorifTP').text('');
	$('.statusConcTP').text('');
	$('.t_conciliadosTP').text('');
	$('.porcentajeConcTP').text('');
	$('.statusNoConcTP').text('');
	$('.t_no_conciliadosTP').text('');
	$('.porcentajeNoConcTP').text('');
	$('.error_brmTP').text('');
	$('.porcentajeerrorbrmTP').text('');
	$('.error_if').text('');
	$('.porcentajeerrorIF').text('');
	$('.totalBRMTP').text('');
	$('.totalIF').text('');
	$('.totalTP').text('');
	
	$('.bcolorBRMENL').text('');
	$('.bcolorifENL').text('');
	$('.decision2').text('');
	$('.statusConcENL').text('');
	$('.t_conciliadosENL').text('');
	$('.porcentajeConcENL').text('');
	$('.statusNoConcENL').text('');
	$('.t_no_conciliadosENL').text('');
	$('.porcentajeNoConcENL').text('');
	$('.error_brmENL').text('');
	$('.porcentajeerrorbrmENL').text('');
	$('.error_IFENL').text('');
	$('.porcentajeerrorIFENL').text('');
	$('.totalBRMENL').text('');
	$('.totalIFENL').text('');
	$('.totalENL').text('');
	
	$('.decision3').text('');
	$('.bcolorBRMTFE').text('');
	$('.bcolorIFTFE').text('');
	$('.statusConcTFE').text('');
	$('.t_conciliadosTFE').text('');
	$('.porcentajeConcTFE').text('');
	$('.statusNoConcTFE').text('');
	$('.t_no_conciliadosTFE').text('');
	$('.porcentajeNoConcTFE').text('');
	$('.error_brmTFE').text('');
	$('.porcentajeerrorbrmTFE').text('');	
	$('.error_IFTFE').text('');
	$('.porcentajeerrorIFTFE').text('');
	$('.totalBRMTFE').text('');
	$('.totalIFTFE').text('');
	$('.totalTFE').text('');
	
	$('.decision4').text('');
	$('.bcolorBRMT').text('');
	$('.bcolorIFT').text('');
	$('.statusConcT').text('');
	$('.t_conciliadosT').text('');
	$('.porcentajeConcT').text('');
	$('.statusNoConcT').text('');
	$('.t_no_conciliadosT').text('');
	$('.porcentajeNoConcT').text('');
	$('.error_brmT').text('');
	$('.porcentajeerrorbrmT').text('');
	$('.error_ifT').text('');
	$('.porcentajeerroriffT').text('');
	$('.totalBRMT').text('');
	$('.totalIFT').text('');
	$('.totalT').text('');
}
$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });

//�������������������������������������������������������
function getValor() {
//	console.log("Ajustes-BRM vs Ajustes-SalesForce");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}