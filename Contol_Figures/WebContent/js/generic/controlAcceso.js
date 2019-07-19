var cifras_array=new Array();
var mod_array=new Array();
var i=0;


function listaModulos(){
	
	$.ajax({
		url : 'getControlAccesoModulosAction',
		type : "POST",
		dataType : "json",
		async : false,
		beforeSend : function(xhr) {
		},
		success : function(jsonResponse, textStatus, jqXHR) {
			if (jsonResponse.success) {
				construyeModulos(jsonResponse);
			} 
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(textStatus);
		}
	});
}

function construyeModulos(jsonResponse){
	i=0;
	$('#accordion').text('');
	var html='';
	$
	.each(
			jsonResponse.result,
			function(index, arrayValores) {
			html='';
			html =html+ '<a class="list-group-item list-group-item-info collapsed"'+
			'data-toggle="collapse" data-target="#modulo_'+arrayValores.id_modulo+'" aria-expanded="false">'; 
			html = html +'<strong><input type="checkbox" id=input_'+arrayValores.id_modulo+' onchange="marcatodo(this);">&emsp;'+arrayValores.nombre+'</strong></a>';
			html = html +'<div id="modulo_'+arrayValores.id_modulo+'" class="divinput_'+arrayValores.id_modulo+' collapse" data-parent="#accordion" ></div>';
			//<input type="checkbox" id=input_'+arrayValores.id_modulo+' onchange="marcatodo(this);">
			
			$(html).appendTo('#accordion');	
			cargaCifras(arrayValores.id_modulo);
			
			});
}

function cargaCifras(idModulo){
	$.ajax({
		url : 'getControlAccesoCifrasAction',
		type : "POST",
		async : false,
		dataType : "json",
		data: {'idModulo':idModulo},
		beforeSend : function(xhr) {
		},
		success : function(jsonResponseCifras, textStatus, jqXHR) {
			if (jsonResponseCifras.success) {
				cifra='';	
				$
				.each(
						jsonResponseCifras.result,
						function(index, arrayValoresCifras) {
							cifra =cifra+'<a class="list-group-item list-group-item-action input_'+idModulo+' '+arrayValoresCifras.id_cifra+'">'+
							'<input id="'+arrayValoresCifras.id_cifra+'" onchange="activar_cifra(this);" '+
							'class="form-check-input input_'+idModulo+'" type="checkbox" >&emsp;';  
							cifra =cifra+'<label class="form-check-label" for="'+arrayValoresCifras.id_cifra+'">'+
							arrayValoresCifras.nombre+'</label></a>';
							
							cifras_array[i]=arrayValoresCifras.id_cifra;
							mod_array[i]=idModulo;
							i++;
//							console.log(arrayValoresCifras.id_cifra);
						});
				idmodulo='#modulo_'+idModulo;
				$(cifra).appendTo(idmodulo);	
			} 
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(textStatus);
		}
	});
}

function activar_cifra(valor){
	console.log("activar_cifra(valor)");
	var id=valor.getAttribute("id");
	
	if ($('#'+id).is(":checked")){
		$('.'+id).addClass('active');
	}
	else{
		$('.'+id).removeClass('active');
		
	}
}

function busca_Emp(){
	listaModulos();
	
	$('#nombre_emp').val('');
	$('#apellido_emp').val('');
	$('#ultima_conexion').text('');
	$('#alerta').hide('fade');	
	$('#actualizar').hide('fade');
	$('#eliminar').hide('fade');
	$('#mensaje').text('');
	
	no_empleado=$('#no_emp').val();
	
	$.ajax({
		url : 'getControlAccesoBuscaEmpAction',
		type : "POST",
		dataType : "json",
		data: {'no_empleado':no_empleado},
		beforeSend : function(xhr) {
		},
		success : function(jsonResponseCifras, textStatus, jqXHR) {
			if (jsonResponseCifras.success) {
				$
				.each(
						jsonResponseCifras.result,
						function(index, arrayValores) {
							$('#agregar').hide('fade');
							$('#nombre_emp').val(arrayValores.nombre);
							$('#apellido_emp').val(arrayValores.apellido);
							if(arrayValores.ultima_conexion!=null)
							$('#ultima_conexion').text(arrayValores.ultima_conexion+"");
							cargaRegistrado(arrayValores.no_empleado);
							$('#actualizar').show('fade');
							$('#eliminar').show('fade');

						});
			}
			else
			{
				$('#alerta').show('fade');
				$('#agregar').show('fade');
				
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(textStatus);
		}
	});
}

function cargaRegistrado(no_empleado){
	$.ajax({
		url : 'getControlAccesoAction',
		type : "POST",
		dataType : "json",
		data: {'no_empleado':no_empleado},
		beforeSend : function(xhr) 
		{ $('#loadModal').modal();
		},
		success : function(jsonResponse, textStatus, jqXHR) {
			 $('#loadModal').modal('hide');
			if (jsonResponse.success)
				{ 
				$
				.each(
						jsonResponse.result,
						function(index, arrayValores) {
							
							$('.'+arrayValores.id_cifra).addClass('active');
							$('#'+arrayValores.id_cifra).attr( 'checked',true );
							$('#modulo_'+arrayValores.id_modulo).addClass('collapse in');
							$('#actualizar').show('fade');
							$('#eliminar').show('fade');
						});
			} 
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(textStatus);
		}
	});
	
}

function actualizar(){
	$('#actualizar_modal').modal('hide');
	var no_emp=$('#no_emp').val();
	var nombre_emp=$('#nombre_emp').val();
	var apellido_emp=$('#apellido_emp').val();
	
	
	var x=0;
	json="";
	var arreglo=new Array();
	
	for(x;x<cifras_array.length;x++){
		
		json+=',"no_empleado":"'+no_emp+'"';
	    json+=',"id_modulo":"'+mod_array[x]+'"';
	    json+=',"id_cifra":"'+cifras_array[x]+'"';
	    
	    if($('#'+cifras_array[x]).is(":checked"))
	    json+=',"estatus":"V"';
	    else
	    json+=',"estatus":"F"';
	    	
	    obj=JSON.parse('{'+json.substr(1)+'}');
	    arreglo.push(obj);
	}
	json_string=JSON.stringify(arreglo);

	
	$.ajax({
		url :'getControlAccesoUpdateAction',
		type : "POST",
		traditional:true,
		data : { 'json_string': json_string,
				'nombre':nombre_emp,
				'apellido':apellido_emp,
				'no_empleado':no_emp
			
		},
		dataType : "json",
		beforeSend: function( xhr ) {
					 $('#loadModal').modal();
				 },
		success : function(response){
			$('#loadModal').modal('hide');
			$('#mensaje').text('Datos Actualizados correctamente');
		},
		error : function(xhr, ajaxOptions, thrownError) {
			console.log(response.mensaje);
			$('#loadModal').modal('hide');
			$('#errorModaltxt').modal();
			$('#mensaje').text('Ocurrio un problema');
}		
	});	
	
	
}

function agregar(){
var no_emp=$('#no_emp').val();
var nombre_emp=$('#nombre_emp').val();
var apellido_emp=$('#apellido_emp').val();
	var x=0;
	json="";
	var arreglo=new Array();
	
	for(x;x<cifras_array.length;x++){
		
		json+=',"no_empleado":"'+no_emp+'"';
	    json+=',"id_modulo":"'+mod_array[x]+'"';
	    json+=',"id_cifra":"'+cifras_array[x]+'"';
	    
	    if($('#'+cifras_array[x]).is(":checked"))
	    json+=',"estatus":"V"';
	    else
	    json+=',"estatus":"F"';
	    	
	    obj=JSON.parse('{'+json.substr(1)+'}');
	    arreglo.push(obj);
	}
	json_string=JSON.stringify(arreglo);

	
	$.ajax({
		url :'getControlAccesoNuevoAction',
		type : "POST",
		traditional:true,
		data : { 'json_string': json_string,
			'nombre':nombre_emp,
			'apellido':apellido_emp,
			'no_empleado':no_emp
		
		},
		dataType : "json",
		beforeSend: function( xhr ) {
					 $('#loadModal').modal();
				 },
		success : function(response){
			$('#loadModal').modal('hide');
			$('#alerta').hide('fade');	
			$('#agregar').hide('fade');
			$('#actualizar').show('fade');
			$('#eliminar').show('fade');
			$('#mensaje').text('Información agregada correctamente');
			

		},
		error : function(xhr, ajaxOptions, thrownError) {
			console.log(response.mensaje);
			$('#loadModal').modal('hide');
			$('#errorModaltxt').modal();
			$('#mensaje').text('Ocurrio un problema');
			
			
}
	});	
}

function eliminar(){
	 $('#confmodal').modal('hide');
	var no_emp=$('#no_emp').val();
		$.ajax({
			url :'getControlAccesoEliminarAction',
			type : "POST",
			data : { 
				'no_empleado':no_emp
			},
			dataType : "json",
			beforeSend: function( xhr ) {
						 $('#loadModal').modal();
					 },
			success : function(response){
				$('#loadModal').modal('hide');
				$('#agregar').show('fade');
				$('#actualizar').hide('fade');
				$('#eliminar').hide('fade');
				$('#mensaje').text('Se eliminó el empleado y su información');
				
			},
			error : function(xhr, ajaxOptions, thrownError) {
				console.log(response.mensaje);
				$('#loadModal').modal('hide');
				$('#errorModaltxt').modal();
				$('#mensaje').text('Ocurrio un problema');
	}
		});	
	
}

function eliminarbf(){
	 $('#confmodal').modal('show');
}

function actualizarbf(){
	 $('#actualizar_modal').modal('show');
} 

function marcatodo(valor){
	var id=valor.getAttribute("id");
		
	if($('#'+id).is(':checked')){
		$('.'+id).prop( "checked", true );
		$('.'+id).addClass('active');
	}
	else{
		$('.'+id).prop( "checked", false );
		$('.'+id).removeClass('active');
	}
}

$('.modal').on('show.bs.modal', function () {
	 $('body').css('padding-right', '0px');
	 });


	
