
$(function() {
//	console.log("function()");
//METODOS PARA PERFILAMIENTO	
	if($('#encabezado').val()=="principal")
	validacion();
	else
	validacion_desplegables();
		
// METODO PARA CARGAR EL ELEMENTO DE FECHA	
	initialize();
});

// ***************************** DATEPICKER *******************************
// ************************************************************************
function initialize() {
//	console.log("initialize()");
//	var botonX =botonExc;
//	console.log("valor boton Excel-->>"+botonExcF);
	
	
	initComponents();
}
function initComponents() {
	$('#datetimepicker1').datepicker({
		setDate : new Date(),
		format : 'dd M, yyyy',
		autoclose : true,
		language : 'es',
		todayHighlight : true
		
	});
}

// *********** PERFILAMIENTO (MENU PRINCIPAL) *****************************
// ************************************************************************
function validacion() {
//	console.log("validacion()");
//	var btn='';
	var emp = $('#oculto').val();
	var encabezado = $('#encabezado').val();
	var last_connection= $('#last_connection').val();

	$('#oculto').val('');
			$.ajax({
				url : 'getControlAccesoAction',
				type : "POST",
				async : false,
				data : {'no_empleado' : emp,
						'last_connection':last_connection,
						},
				dataType : "json",
				beforeSend: function( xhr ) {
					 $('#loadModal').show();
				 },
				success : function(jsonResponse, textStatus, jqXHR){
					 $('#loadModal').hide();
						 if(jsonResponse.result.length > 0){ 
								 carga_principal(jsonResponse);
								 $('.modulos_cifras').show('fade');	
					 }
					 else{
						 $('#mensaje_error').show('fade');
					 }
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$('#mensaje_error').show('fade');
					$('#errorModaltxt').modal();
				}
			});
	}
//alert("trabajando");
function carga_principal(jsonResponse){
//	console.log("carga_principal");
	var id_modulo='';
	var pintamodulo='';
	var id_cifra='';
	var nombre_cifra='';
	var contador='';
	var temp='',tempUs=''; //-- quitar el valor a ''
	
	$.each(jsonResponse.result,function(index, arrayValores) {				
		id_modulo=arrayValores.id_modulo;
		nombre_modulo=arrayValores.nombre_modulo;
//		console.log("modulos -> "+arrayValores.id_modulo);
//		console.log("cifras -> "+arrayValores.id_cifra);
// modulo de perfilamiento INJ88
		if (arrayValores.id_cifra=='A1') {
			temp=arrayValores.id_cifra;
			sessionStorage.setItem("exce", temp);
//			console.log("valor a almacenar es:-> "+temp);
		}
		if (arrayValores.id_cifra=='USR') {
			tempUs=arrayValores.id_cifra;
			sessionStorage.setItem("exceUs", tempUs);
//			arrayValores.id_cifra+1;
//			console.log("valor a almacenar es:-> "+temp);
			
		}
		
		
//		if($('#MOD'+id_modulo).length==0 && id_modulo<='8' ){
//		if($('#MOD'+id_modulo).length==0 && id_modulo<=7 ){
			if($('#MOD'+id_modulo).length==0 && id_modulo<=7 ){
		//------ 8 por el modulo de lineas internas, es un modulo que no existe en el menu principal
		imagen_liga(id_modulo);
		
		var html='';
		
		html=html+'<div class="col-md-6 MOD'+id_modulo+'" align="center">'; 
		html=html+'<div data-toggle="collapse" data-target=".collapse_modulo'+id_modulo+'"  id="MOD'+id_modulo+'" onclick="clic_MOD(this);">';
		html=html+'<p class="tituloCuadro">';
		html=html+'<'+imagen_principal+' class="iconoCuadro">';
		html=html+'<br>'+nombre_modulo;
		html=html+'</div>';
		html=html+'<div class="collapse_modulo'+id_modulo+' collapse" align="center" id="divMOD'+id_modulo+'">';
		html=html+'<ul class="nav menu1" id="ul_modulo'+id_modulo+'">';
		html=html+'</ul>';
		html=html+'</div><br></div>';	
		contador++;
		
		if(contador==2){
			html=html+'</div><div class="col-md-12">';
			contador=0;
		}	
		$(html).appendTo('.modulos_cifras');
		}
		
		id_cifra=arrayValores.id_cifra;
		nombre_cifra=arrayValores.nombre_cifra;	
		elige_liga(id_cifra);
		
		var html='';
		html=html+'<li class="cifra'+id_cifra+'"><a href="'+cifra_liga+'" onclick="getValor();">'+nombre_cifra+'</a>';
		html=html+'<span class="glyphicon glyphicon-menu-right" id="icono"></span>';
		html=html+'</li>';					
		$(html).appendTo('#ul_modulo'+id_modulo);
	});	
}
//console.log("valor de cifra_liga"+cifra_liga);
var cifra_liga;
function elige_liga(id_cifra){
	switch(id_cifra){
	case 'A1':cifra_liga="controlAcceso";
		break;
	case '1':cifra_liga="instalacionesvsSalidasAlmacenSAP2";
		break;
	case '2':cifra_liga="instalacionesNuevasCuentasActivadasFfmBrm";
		break;
	case '3':cifra_liga="salidasAlmacenCvsEntradasSubalmac";
		break;
	case '4':cifra_liga="salidaSubalmacenesvsEntradasCuadrillas";
		break;
	case '5':cifra_liga="salidaEqvsEqCapitalizadosSAP";
		break;
	case '6':cifra_liga="validacionSeriesTP";
		break;
	case '7':cifra_liga="ctasActBRMvsU2000";
		break;
	case '8':cifra_liga="paqTvBrmRedIPTVIncluido";
		break;
	case '9':cifra_liga="ctasActBRMvsIMS";
		break;
	case '10':cifra_liga="CtasCiclovsCtasBRM";
		break;
	case '11':cifra_liga="ctasFACvsFACTBRM";
		break;
	case '12':cifra_liga="paquetesServiciosActivadosBrmPM";
		break;
	case '13':cifra_liga="paqvsProductIncBRM";
		break;
	case '14':cifra_liga="paqueteTvBrmRedIptvIncluidoParrillaTmcode";
		break;
	case '15':cifra_liga="CuentasCanceladasvsCuentasU2000BRM-U2000";
		break;
	case '16':cifra_liga="pagosBRMBanco";
		break;
	case '17':cifra_liga="canalesBRMvsIPTVAdicionales";
		break;
	case '18':cifra_liga="AdicionalesU2000Brm";
		break;
	case '19':cifra_liga="ConsumosVodBrmIptv";
		break;
	case '20':cifra_liga="rhProyectoSinTrans";
		break;
	case '21':cifra_liga="ajusteMantMact";
		break;
	case '22':cifra_liga="facturaAA";
		break;
	case '23':cifra_liga="getConciPolIngre";
		break;
	case '24':cifra_liga="smallWorld";
		break;
	case '25':cifra_liga="AjustesBrmvsAjustesSalesForce";
		break;
	case '29':cifra_liga="LimiteDeCredito";
	break;
	case '30':cifra_liga="MegasTfe";
	break;
//	case '31':cifra_liga="utilidadesDemo";
//	break;
		default:
			cifra_liga="#";
	}
}

var imagen_principal;
var imagen_desplegable;
function imagen_liga(id_modulo){
	switch(id_modulo){
	case '1':
		imagen_principal='img src="/CifrasControl/img/recursoshumanos-icon.png"';
		imagen_desplegable='img src="/CifrasControl/img/recursoshumanos-icon2.png"';
		break;
	case '2':
		imagen_principal='img src="/CifrasControl/img/controldeinventarios-icon.png"';
		imagen_desplegable='img src="/CifrasControl/img/controldeinventarios-icon2.png"';
		break;
	case '3':
		imagen_principal='img src="/CifrasControl/img/aseguramientodeingreso-icon.png"';
		imagen_desplegable='img src="/CifrasControl/img/aseguramientodeingreso-icon2.png"';
		break;
	case '4':
		imagen_principal='img src="/CifrasControl/img/recursoshumanos-icon.png"';
		imagen_desplegable='img src="/CifrasControl/img/recursoshumanos-icon2.png"';
		break;
	case '5':
		imagen_principal='img src="/CifrasControl/img/controldeinventarios-icon.png"';
		imagen_desplegable='img src="/CifrasControl/img/controldeinventarios-icon2.png"';
		break;
	case '6':
		imagen_principal='img src="/CifrasControl/img/aseguramientodeingreso-icon.png"';
		imagen_desplegable='img src="/CifrasControl/img/aseguramientodeingreso-icon2.png"';
		break;
	case '7':
		imagen_principal='img src="/CifrasControl/img/controldeinventarios-icon.png"';
		imagen_desplegable='img src="/CifrasControl/img/controldeinventarios-icon2.png"';
		break;
	case '8':
		imagen_principal='img src="/CifrasControl/img/utilidades-icon.png"';
		imagen_desplegable='img src="/CifrasControl/img/utilidades-icon2.png"';
		break;
		default:
			imagen_principal="";
			imagen_desplegable="";
	}
}
// ********************PERFILAMIENTO (DESPLEGABLES)***************************
// ***************************************************************************
function validacion_desplegables() {
			$.ajax({
				url : 'getControlAccesoDepslegablesAction',
				type : "POST",
				async : false,
				dataType : "json",
				beforeSend: function( xhr ) {
					 $('#loadModal').show();
				 },
				success : function(jsonResponse, textStatus, jqXHR){
					$('#loadModal').hide();
					identificador_modulo=$('#identificador').val();
					
					var html='';
					html=html+'<ul class="dropdown-menu mdesplegable" id="menu1Local" role="menu">';
					
					$.each(jsonResponse.result,function(index, arrayValores) {	
						id_cifra=arrayValores.id_cifra;
						nombre_cifra=arrayValores.nombre_cifra;	
						elige_liga(id_cifra);
						imagen_liga(arrayValores.id_modulo);
												
						if(identificador_modulo==arrayValores.id_modulo){
							html=html+'<li class="cifra'+id_cifra+'"><a href="'+cifra_liga+'">';
							html=html+'<'+imagen_desplegable;
							html=html+' style="position: relative;"> &emsp;<span>'+nombre_cifra+'</span></a>';
							html=html+'</li>';
							}
						if(arrayValores.id_modulo=='8'){
							$('#cifra'+id_cifra).show();
//							console.log("XXXXX---> "+$('#cifra'+id_cifra).show());
							}
					});	
					html=html+'</ul>';
					$(html).appendTo('#desplegable');
					
					var desable_cifra=$('#desable_cifra').val();
					$('.cifra'+desable_cifra+' span').addClass('desabilitado');
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$('#mensaje_error').show('fade');
					$('#errorModaltxt').modal();
				}
			});
	}
$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });

