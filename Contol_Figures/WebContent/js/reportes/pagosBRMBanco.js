



function renovar(){
	
}







function dowloadTest2(url){
	
	 var empresa=$("#empresaH").val();
	  var canal=$("#canalH").val();
	  var id_conciliacion=$("#id_conciliacion").val();
	$.ajax({
		 cache: false,
		 type: "get",
		   url : 'exportDetallePagosBRMBanco',
		   data:{'empresa':empresa,'canal':canal,'id_conciliacion':id_conciliacion},
		   contentType: "application/json",
		   dataType: "text",

		   success: function (respose,status, xhr) {
//			   var form = document.createElement("form");
//		        form.method = "post";
//		        form.action = url;
//		        document.body.appendChild(form);
//		        form.submit();
//		        document.body.removeChild(form);
			   var filename = xhr.getResponseHeader("Content-disposition");//Obtenemos el nombre del fichero a desgargar
	            alert(filename);
	            filename = filename.substring(filename.lastIndexOf("=") +1) || "download";
	            alert(filename);
	            var b64Data = $.base64.decode(respose);
	            alert(b64Data);
			    var a = document.createElement("a");
		        a.href = b64Data; 
		        a.download = filename;
		        document.body.appendChild(a);
		        a.click();
		        a.remove();
		   }
		});
}


function base64ToBlob(base64, mimetype, slicesize) {
    if (!window.atob || !window.Uint8Array) {
        // The current browser doesn't have the atob function. Cannot continue
        return null;
    }
    mimetype = mimetype || '';
    slicesize = slicesize || 512;
    
    var bytechars = window.btoa(encodeURIComponent(base64));
    var bytearrays = [];
    for (var offset = 0; offset < bytechars.length; offset += slicesize) {
        var slice = bytechars.slice(offset, offset + slicesize);
        var bytenums = new Array(slice.length);
        for (var i = 0; i < slice.length; i++) {
            bytenums[i] = slice.charCodeAt(i);
        }
        var bytearray = new Uint8Array(bytenums);
        bytearrays[bytearrays.length] = bytearray;
    }
    return new Blob(bytearrays, {type: mimetype});
};


function dowloadTest(){
	alert('here');
	 var empresa=$("#empresaH").val();
	  var canal=$("#canalH").val();
	  var id_conciliacion=$("#id_conciliacion").val();
	$.ajax({
		   type: "get",
		   url : 'exportDetallePagosBRMBanco',
		   data:{'empresa':empresa,'canal':canal,'id_conciliacion':id_conciliacion},
		   contentType: "application/json",
		   dataType: "text",

		   success: function (result,status, xhr) {
			   var contentType = xhr.getResponseHeader("Content-Type"); //Obtenemos el tipo de los datos
	           
	            var filename = xhr.getResponseHeader("Content-disposition");//Obtenemos el nombre del fichero a desgargar
	            alert(filename);
	            filename = filename.substring(filename.lastIndexOf("=") +1) || "download";
	            alert(filename);
			   
			   
			   var a = document.createElement('a');
			   if (window.URL && window.Blob && ('download' in a) && window.atob) {
			       // Do it the HTML5 compliant way
			       var blob = base64ToBlob(result, contentType);
			       var url = window.URL.createObjectURL(blob);
			       a.href = url;
			       a.download = filename;
			       a.click();
			       window.URL.revokeObjectURL(url);
			   }
		   }
		});
}


function descargaReporte(){
	
	  var empresa=$("#empresaH").val();
	  var canal=$("#canalH").val();
	  var id_conciliacion=$("#id_conciliacion").val();
	  
	
	$.ajax({
		url : 'exportDetallePagosBRMBanco',
		type : "get",
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		 dataType: 'binary',
         //headers: { 'X-Requested-With': 'XMLHttpRequest' },
		data:{'empresa':empresa,'canal':canal,'id_conciliacion':id_conciliacion},
		beforeSend: function(){
			$('#loadModal').modal();
		},
		success: function(data, status, xhr) {
	         alert('');
	         
	        //Ocultamos el loader
	         
	        //Si se han devuelto datos
	        if (data != null && data != "FAIL") {
	            var b64Data = window.btoa(encodeURIComponent(data));
	            	//window.btoa(encodeURIComponent(data));
	            	//window.btoa(unescape(encodeURIComponent(data)));
	            var contentType = xhr.getResponseHeader("Content-Type"); //Obtenemos el tipo de los datos
	            var filename = xhr.getResponseHeader("Content-disposition");//Obtenemos el nombre del fichero a desgargar
	            alert(filename);
	            filename = filename.substring(filename.lastIndexOf("=") +1) || "download";
	            alert(filename);
	            var sliceSize = 512;
	            
	            
	             var a = document.createElement("a");
	             a.href = jQuery.isPlainObject(data) ? data.file : '/'; 
	             a.download = jQuery.isPlainObject(data) ? data.filename : filename;
	             document.body.appendChild(a);
	             a.click();
	             a.remove();
	             
	             
	            var byteCharacters = atob(b64Data);
	            var byteArrays = [];
	 
	            for (var offset = 0; offset < byteCharacters.length; offset += sliceSize) {
	                var slice = byteCharacters.slice(offset, offset + sliceSize);
	                var byteNumbers = new Array(slice.length);
	                for (var i = 0; i < slice.length; i++) {
	                    byteNumbers[i] = slice.charCodeAt(i);
	                }
	                var byteArray = new Uint8Array(byteNumbers);
	                byteArrays.push(byteArray);
	            }
	            //Tras el procesado anterior creamos un objeto blob
	            var blob = new Blob(byteArrays, {
	                type : contentType
	            });
	 
	          
	            //Descargamos el fichero obtenido en la petición ajax
	                var url = URL.createObjectURL(blob);
	                alert(filename);
	                alert(url);
	                var link = document.createElement('a');
	                link.href = url;
	                link.download = filename;
	                $("#testReport").html(link);
	                document.body.appendChild(link);
	                link.click();
	                document.body.removeChild(link);
	            
	 
	        }
	    },
		error : function(jqXHR, textStatus, errorThrown){
			console.log(textStatus);
			$('#loadModal').modal('hide');
		}
	});
}


function consultaReporte(){
	
	$('#fechaH').val($('#fecha').val());
	$('#empresaH').val($('#selectEmpresa').val());
	$('#canalH').val($('#selectCanal').val());
	
	
	if( $('#fecha').val() != "" && 
			( $('#selectEmpresa').val() != "" && $('#selectEmpresa').val() != "0") && 
			( $('#selectCanal').val() != "" && $('#selectCanal').val() != "0") ){
		$("#divReport").hide();
		$.ajax({
			url : 'getPagosBRMBanco',
			type : "POST",
			data : {
				'fecha'		:	$('#fecha').val(),
				'empresa'	:	$('#selectEmpresa').val().toString(),
				'canal'		:	$('#selectCanal').val().toString()
				},
			dataType : "json",
			beforeSend: function( xhr ) {
				 $('#loadModal').modal();
			 },
			success : function(jsonResponse, textStatus, jqXHR){
				$('#loadModal').modal('hide');
				if(jsonResponse.success){
					console.log(jsonResponse);
					construyeReporte(jsonResponse);
					if(jsonResponse.result.length > 0){
						$('.contentMessage').hide('fade');
						$('.contentReporte').show('fade');
						$( "#btn-Reporte" ).prop( "disabled", false );
					}else{
						$('.dateFail').text($('#fecha').val());
						$('#errorModal').modal();
						$('.contentMessage').show('fade');
						$('.contentReporte').hide('fade');
						$( "#btn-Reporte" ).prop( "disabled", true );
					}
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
	}else{
		//$("#divReport").empty();
		$("#divReport").hide();
		$('.contentMessage').show('fade');
		$('.contentReporte').hide('fade');
	}
	
}

function construyeReporte(jsonResponse) {
	
	$('.fechaEt').text($('#fecha').val());
	//$('#divReport').text('');
	
	$("#bPagosTable").empty();
	
	$.each(jsonResponse.result,function(i,v){
		$('#id_conciliacion').val(v.id);
		var details = "";
		if(v.color == "V"){
			details = '<img src="/CifrasControl/img/green.png"  class="semaforo_green" >';
		}else if(v.color == "A"){
			details = '<img src="/CifrasControl/img/yellow.png" class="semaforo_yellow">';
		}else{
			details = '<img src="/CifrasControl/img/red.png" class="semaforo_red">';
		}
		$("#bPagosTable").append('<tr>'+
				'<td>'+v.fecha+'</td>'+
				'<td>'+accounting.formatNumber(v.numero_pagos)+'</td>'+
				'<td>'+accounting.formatMoney(v.importe_brm)+'</td>'+
				'<td>'+accounting.formatNumber(v.no_pagos_banco)+'</td>'+
				'<td>'+accounting.formatMoney(v.importe_bancos)+'</td>'+
				'<td>'+v.canal+'</td>'+
				'<td>'+v.empresa+'</td>'+
				'<td>'+details+'</td>'
				);
	});
	
	if ( $.fn.dataTable.isDataTable( '#pagosTable' ) ) {
	    table = $('#pagosTable').DataTable();
	}
	else {
	    table = $('#pagosTable').dataTable({
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
	}
	
	
	
	$("#divReport").show();
	
	

	
//	var html, table, body = '';
//	var header = '<table id="pagosTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer table-striped">' + '<THEAD>'
//			+ '<tr>' 
//			+ '<th><small>FECHA</small></th>'
//			+ '<th><small>No. PAGOS BRM</small></th>'
//			+ '<th><small>IMPORTE BRM</small></th>'
//			+ '<th><small>No. PAGOS BANCO</small></th>'
//			+ '<th><small>IMPORTE BANCOS</small></th>'
//			+ '<th class="text-center"><small><img src="/CifrasControl/img/dashboard-icon-copy-2.png"></small></th>'
//			+ '</tr>' + '</THEAD><tbody>';
//	var footer = '</tbody></table>';
//	$.each(
//		jsonResponse.result,
//		function(index, arrayValores) {
//			$('#id_conciliacion').val(arrayValores.id);
//			
//			
//			html = '<tr><td>';
//			html = html + arrayValores.fecha;
//			html = html + '</td>';
//			html = html + '<td>';
//			html = html + accounting.formatNumber(arrayValores.numero_pagos);
//			html = html + '</td>';
//			html = html + '<td>';
//			html = html + accounting.formatMoney(arrayValores.importe_brm);
//			html = html + '</td>';
//			html = html + '<td>';
//			html = html + accounting.formatNumber(arrayValores.no_pagos_banco);
//			html = html + '</td>';
//			html = html + '<td>';
//			html = html + accounting.formatMoney(arrayValores.importe_bancos);
//			html = html + '</td>';
//			html = html + '<td align="center">';
//			var details = "";
//			if(arrayValores.color == "V"){
//				details = '<img src="/CifrasControl/img/green.png"  class="semaforo_green" >';
//			}else if(arrayValores.color == "A"){
//				details = '<img src="/CifrasControl/img/yellow.png" class="semaforo_yellow">';
//			}else{
//				details = '<img src="/CifrasControl/img/red.png" class="semaforo_red">';
//			}
//			
//			
//			html = html + details;
//			html = html + '</td>';
//			
//			
//			html = html + '</tr>';
//			body = body + html;
//		});
//
//	table = header + body + footer;
//	$(table).appendTo('#divReport');
//	$('#pagosTable').dataTable({
//		"language" : {
//			"sProcessing"	: "Procesando...",
//			"sLengthMenu"	: "Mostrar _MENU_ registros",
//			"sZeroRecords" 	: "No se encontraron resultados",
//			"sEmptyTable" 	: "Ning\u00fana OT disponible ",
//			"sInfo" 		: "",
//			"sInfoEmpty" 	: "",
//			"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
//			"sInfoPostFix" 	: "",
//			"sSearch" 		: "Buscar:",
//			"oPaginate" 	: {
//					"sFirst" 	: "Primero",
//					"sLast"		: "\u00daltimo",
//					"sNext"		: ">",
//					"sPrevious" : "<"
//					}
//		}
//	});
}

/**Funcion para llenar el combo de Empresas**/
function loadEmpresasAjax() {
//	console.log('Entra a loadEmpresasAjax');
	$('#aseg10 span').addClass('desabilitado');
	$('#selectEmpresa')
    .find('option')
    .remove()
    .end()
    .append('<option value="0"></option>')
    .val('0');

	var select = '';

	$.ajax({
			url : 'loadEmpresas',
			type : "POST",
			dataType : "json",
			success : function(jsonResponse, textStatus, jqXHR) {
				requestBussy = false;
				if (jsonResponse.success == true) {
//					console.log('loadEmpresasAjax - Success::::');
					$.each(jsonResponse.result, function(index, arrayValores) {
						select = select + '<option value="' + arrayValores.id_empresa + '">' + arrayValores.empresa + '</option>"';
//						console.log('loadEmpresasAjax - '+arrayValores.id_empresa+','+arrayValores. empresa);
					});
					$(select).appendTo('#selectEmpresa');

				} else {
					console.log('loadEmpresas - parseActionErrors::::');
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				requestBussy = false;
				console.log("loadEmpresasAjax - Ocurrio un error en su peticion Errs_ " + textStatus + ", " + errorThrown);
				var error = new Object();
				error.mensaje = "Ocurrio un error al intentar procesar su petici&oacute;n, por favor reintentelo.";
			}
		});
}


/**Funcion para llenar el combo de Empresas**/
function loadCanalesAjax() {
//	console.log('Entra a loadCanalesAjax');
	
	$('#selectCanal')
    .find('option')
    .remove()
    .end()
    .append('<option value="0"></option>')
    .val('0');

	var select = '';

	$.ajax({
			url : 'loadCanales',
			type : "POST",
			dataType : "json",
			success : function(jsonResponse, textStatus, jqXHR) {
				requestBussy = false;
				if (jsonResponse.success == true) {
//					console.log('loadCanalesAjax - Success::::');
					$.each(jsonResponse.result, function(index, arrayValores) {
						select = select + '<option value="' + arrayValores.id_canal + '">' + arrayValores.canal + '</option>"';
//						console.log('loadCanalesAjax - '+arrayValores.id_canal+','+arrayValores.canal);
					});
					$(select).appendTo('#selectCanal');

				} else {
					console.log('loadCanales - parseActionErrors::::');
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				requestBussy = false;
				console.log("loadCanalesAjax - Ocurrio un error en su peticion Errs_ " + textStatus + ", " + errorThrown);
				var error = new Object();
				error.mensaje = "Ocurrio un error al intentar procesar su petici&oacute;n, por favor reintentelo.";
			}
		});
	
	
//	functioon buscar
	
	$(document).ready(function() {
		
		
//			$("#exportToExcel").click(function(e){
//				alert('click');
//				var table1=("#pagosTable");
//				var table = $(this).prev('.table2excel');
//				alert(table);
//				if(table1 && table1.length){
//					alert('1');
//					var preserveColors = (table.hasClass('table2excel_with_colors') ? true : false);
//					$(table1).table2excel({
//						exclude: ".noExl",
//						name: "Excel Document Name",
//						filename: "myFileName" + new Date().toISOString().replace(/[\-\:\.]/g, "") + ".xls",
//						fileext: ".xls",
//						exclude_img: true,
//						exclude_links: true,
//						exclude_inputs: true,
//						preserveColors: preserveColors
//					});
//				}
//			});
			
		

      
		
	    // Setup - add a text input to each footer cell
	    $('#buscar tfoot th').each( function () {
	    	
	        var title = $(this).text();
	        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
	    } );
	 
	    // DataTable
	    var table = $('#buscar').DataTable();
	 
	    // Apply the search
	    table.columns().every( function () {
	    	
	        var that = this;
	 
	        $( 'input', this.footer() ).on( 'keyup change', function () {
	            if ( that.search() !== this.value ) {
	                that
	                    .search( this.value )
	                    .draw();
	            }
	        } );
	    } );
	} );

$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });
}

//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
function getValor() {
//	console.log("Pagos-BRM vs Bancos");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}

//waitForMe().then(function(intentsArr){
//	alert(intentsArr);
//	  console.log('Finally, I can execute!!!');
//	},
//	function(err){
//	  console.log('This is error message.');
//	});
	    
	function exportExcel(){
	    // Returns promise
	    console.log('Inside waitForMe');
	$('#loadModal').modal();
	    
	    return new Promise(function(resolve, reject){
	    	var table1=("#pagosTable");
			//var preserveColors = (table1.hasClass('table2excel_with_colors') ? true : false);
			if(table1 && table1.length){
				
				$(table1).table2excel({
					exclude: ".noExl",
					name: "Excel Document Name",
					filename: "myFileName" + new Date().toISOString().replace(/[\-\:\.]/g, "") + ".xls",
					fileext: ".xls",
					exclude_img: true,
					exclude_links: true,
					exclude_inputs: true
//					,
//					preserveColors: preserveColors
				});
				console.log('waitForMe\'s function succeeded');
				$('#loadModal').modal('hide');
            	resolve();
				
			}else{
				console.log('waitForMe\'s else block failed');
				$('#loadModal').modal('hide');
            	resolve();
			}
//	        if(false){ // Try changing to 'false'
//	            setTimeout(function(){
//	            	console.log('waitForMe\'s function succeeded');
//	            	resolve();
//	            }, 2500);
//	        }
//	        else{
//	            setTimeout(function(){
//	            	console.log('waitForMe\'s else block failed');
//	            	resolve();
//	            }, 2500);
//	        }
	    });
	}



function downloadReport(){
	
	var form = document.createElement("form"); //created dummy form for submitting.
	var empresaI=$("#empresaH").val();
	  var canalI=$("#canalH").val();
	  var id_conciliacionI=$("#id_conciliacion").val();
    
    var empresaHidden = document.createElement("input"); 
    var canalHidden = document.createElement("input"); 
    var id_conciliacionHidden = document.createElement("input");
//    var data='?empresa='+empresaI+'&canal='+canalI+'&id_conciliacionI='+id_conciliacionI;
    form.method = "GET";
    form.action = "exportDetallePagosBRMBanco";
    
    empresaHidden.value=empresaI; //its a json string I need to pass to server.
    empresaHidden.name="empresa";
    empresaHidden.type = 'hidden';
    
    canalHidden.value=empresaI; //its a json string I need to pass to server.
    canalHidden.name="canal";
    canalHidden.type = 'hidden';
    
    id_conciliacionHidden.value=empresaI; //its a json string I need to pass to server.
    id_conciliacionHidden.name="id_conciliacion";
    id_conciliacionHidden.type = 'hidden';
    
    form.appendChild(canalHidden);
    form.appendChild(canalHidden);
    form.appendChild(id_conciliacionHidden);
    
 

    document.body.appendChild(form);

    form.submit();
}




	

	
	
	
	

	
	
	
	
	
	
	
	