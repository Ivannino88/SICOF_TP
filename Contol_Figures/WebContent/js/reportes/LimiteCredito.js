function cargaDatos(){
//	console.log("cargaDatos()");
	$.ajax({
		url : 'getLimiteDeCredito',
		type : 'GET',
		async : false,
		dataType : "json",
		beforeSend: function( xhr ) {
			 $('#loadModal').modal();
		 },
		success : function(result){
			if (result.length>0) {
				$(".contentMessage").hide('fade');
//				$('.contentMessage').modal('hide');
				$('#loadModal').modal('hide');
				construyeReporte(result);
				pintaReporte(result);
			}else{
				$(".contentMessage").show('fade');
//				$('.contentMessage').modal('show');
				$('#divReport').hide('fade');
				$('#loadModal').modal('hide');
				$('#errorConsulta').modal('show');
			}
	}
	});
}

function pintaReporte(result){
	console.log("pintaReporte1  #1 ------");
					//console.log("Detalle de los cuentas existentes en SAP y no en BRM ");
					$('#tableModal').bootstrapTable({   	// dibuja tabla
					    data : result,
					    pagination:true,
  						search:true,
 						toolbar:'#toolbar',
					    columns: [{
					        field: 'cuenta',
					        title: 'CUENTA',
					        sortable: true
					        
					    },{
					        field: 'estatusCuenta',
					        title: 'INDICADOR NVO',
					        sortable: true
					    },{
					        field: 'paquete',
					        title: 'PAQUETE',
					        sortable: true
					    }, {
					        field:'consumos_addons',
					        title: 'CONSUMO',
					        formatter: function (value, row, index) {
			                    return accounting.formatNumber(value);
			                },
					        sortable: true
					    }, {
					        field:'renta_paquete',
					        title: 'RENTA',
					        sortable: true,
					        formatter: function (value, row, index) {
			                    return accounting.formatMoney(value);
			                }
					    }, {
					        field: 'limite',
					        title: 'LIMITE',
					        formatter: function (value, row, index) {
			                    return accounting.formatNumber(value);
			                },
					        sortable: true
					    }, {
					        field: 'porcentaje',
					        title: 'PORCENTAJE',
					        formatter: function (value, row, index) {
			                    return accounting.formatNumber(value);
			                },
					        sortable: true
					    }, {
					        field: 'Nueva_fecha_activa',
					        title: 'FECHA ACTIVACION',
					        sortable: true
					    }, {
					        field: 'Nueva_fecha_entrada',
					        title: 'FECHA ENTRADA',
					        sortable: true
					    },{
					        field: 'saldo',
					        title: 'SALDO',formatter: function (value, row, index) {
			                    return accounting.formatMoney(value);
			                },
					        sortable: true
					    },{
					        field: 'status',
					        title: 'ESTATUS',
					        formatter: function (value, row, index) {
			                    return accounting.formatNumber(value);
			                },
					        sortable: true
					    },{
					        field: 'ciclo',
					        title: 'CICLO',
					        formatter: function (value, row, index) {
			                    return accounting.formatNumber(value);
			                },
					        sortable: true
					    },{
					        field: 'Nueva_ultima_factura',
					        title: 'ULTIMA FACTURA',
					        sortable: true
					    },]
					});
}

function construyeReporte(result) {
	console.log("construyeReporte()");
//	$(".contentMessage").hide('fade');
	$('#divReport').text('');
	var html, table, body = '';
	var header = '<table id="pagosTable" class="table table-condensed table-hover table-responsive datatable dataTable no-footer table-striped">' + '<THEAD>'
			+ '<tr>' 
			+ '<th><small>CUENTA</small></th>'
			+ '<th><small>PAQUETE</small></th>'
			+ '<th><small>CONSUMO ADDONS</small></th>'
			+ '<th><small>RENTA PAQUETE</small></th>'
			+ '<th><small>L&Iacute;MITE</small></th>'
			+ '<th><small>PORCENTAJE</small></th>'
			+ '<th><small>FECHA ACTIVACI&Oacute;N</small></th>'
			+ '<th><small>FECHA ENTRADA</small></th>'
			+ '<th><small>SALDO</small></th>'
			+ '<th><small>STATUS</small></th>'
			+ '<th><small>CICLO</small></th>'
			+ '<th><small>&Uacute;LTIMA FACTURA</small></th>'
			+ '</tr>' + '</THEAD><tbody>';
	var footer = '</tbody></table>';
	$.each(
		result,
		function(index, arrayValores) {
			html = '<tr><td>';
			html = html + arrayValores.cuenta;
			html = html + '</td>';
			html = html + '<td>';
			html = html + arrayValores.paquete;
			html = html + '</td>';
			html = html + '<td>';
			html = html + accounting.formatNumber(arrayValores.consumos_addons);
			html = html + '</td>';
			html = html + '<td>';
			html = html + accounting.formatMoney(arrayValores.renta_paquete);
			html = html + '</td>';
			html = html + '<td>';
			html = html + accounting.formatNumber(arrayValores.limite);
			html = html + '</td>';
			html = html + '<td>';
			html = html + accounting.formatNumber(arrayValores.porcentaje);
			html = html + '</td>';
			html = html + '<td>';
			html = html + arrayValores.Nueva_fecha_activa;
			html = html + '</td>';
			html = html + '<td>';
			html = html + arrayValores.Nueva_fecha_entrada;
			html = html + '</td>';
			html = html + '<td>';
			html = html + accounting.formatMoney(arrayValores.saldo);
			html = html + '</td>';
			html = html + '<td>';
			html = html + accounting.formatNumber(arrayValores.status);
			html = html + '</td>';
			html = html + '<td>';
			html = html + accounting.formatNumber(arrayValores.ciclo);
			html = html + '</td>';
			html = html + '<td>';
			html = html + arrayValores.Nueva_ultima_factura;
			html = html + '</td>';
			
			html = html + '</tr>';
			body = body + html;
		});

	table = header + body + footer;
	$(table).appendTo('#divReport');
	$('#pagosTable').dataTable({
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

//같같같같같같같같같같같같같같같같같같같같같같같같같같같�
function getValor() {
//	console.log("Adicionales TV-BRM vs Adicionales IPTV");
	var botonExc = sessionStorage.getItem("exce");
	var botonExcUs = sessionStorage.getItem("exceUs");
	if((botonExc!= null && botonExc=='A1')||(botonExcUs!= null && botonExcUs=='USR')){
		$('#btn-Reporte').show();
//		console.log("valor obtenido es:->"+botonExc);
	}
	}