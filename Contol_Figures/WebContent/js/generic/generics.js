
/***
 * Funcion Para mostrar en la seccion de errores (warnContainer y errorContainer) el mensaje y los errores indicados.
 * se puede mandar array de errores en la propiedad result. Ej. jsonObject.result = ['idUno|error propiedad uno','idDos|Error en la propiedad2']
 * para mostrar un error general se debe settear propiedad mensaje Ej. jsonObject.mensaje="ocurrio un problema con su operacion"
 * @param jsonObject var obj = new Object(); obj.mensaje="Mensaje de error";obj.result= ['idUno|error propiedad uno','idDos|Error en la propiedad2'];
 */
function parseActionErrors(jsonObject){
	

	if(jsonObject!=null){
		if("NOSESSION"== jsonObject.mensaje){
			$("#errorContainer").hide();
			$("#successContainer").hide();

			$("#warnText").html("Estimado usuario, su sesi&oacute;n ya no es v&aacute;lida, por favor inicie sesi&oacute;n nuevamente.");
			$("#warnContainer").slideDown("fast");					
		}else{
			if(jsonObject.result!=null && jsonObject.result.length>0){
				for(var i=0;i<jsonObject.result.length;i++){
					var err = jsonObject.result[i];
					//logger('ERROR: '+ err);
					if(err!=null && err.length>3 && err.indexOf('|')>1){
						var indx = err.indexOf('|');
						var idErr = err.substring(0,indx);
						var txtErr= err.substring((indx+1),err.length);
						logger('ID: ' + idErr + ', ' + txtErr);
						var obj = $("#"+idErr);
						if(obj[0]){
							obj.siblings(".actionError").text(txtErr);
						}
					}
				}
			}

			$("#successContainer").hide();
			$("#warnContainer").hide();
			if(jsonObject.mensaje!=null && jsonObject.mensaje!=""){
				$("#errorText").html(jsonObject.mensaje);
				$("#errorContainer").slideDown('fast');
				clearTimeout(msgTimmer);
				msgTimmer = setTimeout(function(){$("#errorContainer").fadeOut(1000);}, 8000);
			}
		}
	}else{
		$("#errorContainer").hide();
		$("#successContainer").hide();
		$("#warnText").html("Estimado usuario, su sesi&oacute;n ya no es v&aacute;lida, por favor inicie sesi&oacute;n nuevamente.");
		$("#warnContainer").slideDown("fast");
		clearTimeout(msgTimmer);
		msgTimmer = setTimeout(function(){$("#warnContainer").fadeOut(1000);}, 8000);
	}
}

/***
 * Funcion para mostrar de manera segura un mensaje en la consola de JS del navegador. 
 * @param msg
 */
function logger(msg){
	try{
		//no funciona en IE
		console.log('logger>'+msg);
	}catch(err){}//nada
}


function soloNumeros(event) {
	if ((event.which < 48 || event.which > 57)) {
		event.preventDefault();
	}
	event.stopPropagation();
}

function soloLetrasNumeros(event){
    key = event.keyCode || event.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz1234567890";
     if(letras.indexOf(tecla)==-1 ){
    	 event.preventDefault();
    	 
     }
}
function soloLetrasNumerosSinEspacios(event){
    key = event.keyCode || event.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = "abcdefghijklmnñopqrstuvwxyz1234567890";
     if(letras.indexOf(tecla)==-1 ){
    	 event.preventDefault();
     }
}
function soloLetrasNumerosUrl(event){
    key = event.keyCode || event.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = "abcdefghijklmnñopqrstuvwxyz1234567890:.-_/?=";
     if(letras.indexOf(tecla)==-1 ){
    	 event.preventDefault();
     }
}

function inhabilitado(event){
	 event.preventDefault();
}




