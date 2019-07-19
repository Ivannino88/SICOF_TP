
// -- FUNCION OBTENER #SEMANA, #MES  Y AÑO ----
function fechaActual() {
//	console.log("dentro de fecha actual");
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
				});
			}},
		error : function(jqXHR, textStatus, errorThrown){
		}
		});
//	semana actual
    for(var i=1;i<=53;i++){
    if(i==semanaactual){
    	 $("#selectsem").append('<option value="'+i+'" selected="'+i+'">'+i+'</option>');
    } else{
    	 $("#selectsem").append('<option value="'+i+'">'+i+'</option>');
    	}
    } 
//    mes actual
    var arrM=["Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"];
    for(var j=0;j<arrM.length;j++){
		   if(j==mesactual-1){
			   $("#selectMes").append('<option value="'+arrM[j]+'" selected="'+arrM[j]+'">'+arrM[j]+'</option>');
		    } 
		   else{
		    	  $("#selectMes").append('<option value="'+arrM[j]+'">'+arrM[j]+'</option>');
		    	}
	   }
//    año actual
    var arr=["2017","2018"];
	   for(var i=0;i<arr.length;i++){
		   if(arr[i]==anioactual){
			   $("#selectanio").append('<option value="'+arr[i]+'" selected="'+arr[i]+'">'+arr[i]+'</option>');
		    	
		    } else{
		    	  $("#selectanio").append('<option value="'+arr[i]+'">'+arr[i]+'</option>');
		    	}
	   }  
//	   sendSolicitud();
}