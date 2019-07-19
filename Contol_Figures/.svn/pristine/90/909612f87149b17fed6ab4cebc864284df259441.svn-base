

function sendQuery(){
	
	
	var query = $("textarea#query").val();
	//var query2 = $("textarea.consulta").text();
	//var query = $("textarea#query").text();
	console.log("query: " + query);
	
	$.ajax({	
		url : 'getQuery',
		type : "POST",
		async : false,
		data : {'cadena': query },
		dataType : "json",
		success : function(jsonResponse, textStatus, jqXHR) {
			console.log("getQuery.result: " + jsonResponse);
			if(jsonResponse.success){
											
		    	//alert(jsonResponse.result);
		    	
		    	//$("textarea#cadena").text(jsonResponse.result);
		    	//$("textarea#cadena").text(jsonResponse.result2);
		    	$('#tablaOK').html(jsonResponse.result);
		    	console.log("jsonResponse.result: " + jsonResponse.result);
			    				
											
			}else{
				console.log("jsonResponse.mensaje: " + jsonResponse.mensaje);							
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(textStatus);
		}
	});		
}

