function changeSemana(){ 
	$('#menu_mes').hide('fade');
	$('#menu_semana').show();
}

function changeMes(){ 
	$('#menu_semana').hide('fade');
	$('#menu_mes').show();
}

function hideGraf(){ 
	$('#miGrafica').hide('fade');
	
}
// -- FUNCION OBTENER #SEMANA, #MES  Y AÑO ----
function fechaActual() {
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
//-------------------CONSULTA DATOS POR SEMANA PARA GRAFICA LINEAL ----------
function setEvalSema(){
	$('#graficaG').remove(); // this is my <canvas> element
	$('#miGrafica').append('<canvas id="graficaG"><canvas>');
	
	$('#miGrafica').show('fade');
	if($('#selectsem').val() != "" &&  $('#selectanio').val() != ""){
//		console.log("valor de semana es ---> "+$('#selectsem').val());
//		console.log("valor de anio  es ---> "+$('#selectanio').val());
		$.ajax({
		url : 'getDatosGrafica',
		type : 'POST',
		data : {
			'semana' : $('#selectsem').val(),
			'anio'	 : $('#selectanio').val()
			},
		dataType : "json",
		beforeSend: function( xhr ) {
			 $('#loadModal').modal();
		 },
		success : function(jsonResponse, textStatus, jqXHR){
			$('#loadModal').modal('hide');
			if(jsonResponse.success){
//				console.log(jsonResponse);
				if(jsonResponse.result.length > 0){
//					console.log("-># consulta de semana ok..");
					construyeReporteSemana(jsonResponse);
					$('#graficaG').text('');
					$('#graficaG').show('fade');
				}else{
					$('#errorModal').modal();
//					console.log("-># consulta de semana sin datos");
					$('#graficaG').hide('fade');
				}
			}
		},
	});
	}
}
// -------------------CONSULTA DATOS POR MES PARA GRAFICA LINEAL ----------
function setEvalMes (){
	$('#graficaG').text('');
	$('#miGrafica').show('fade');
	$('#graficaG').remove(); // this is my <canvas> element
	$('#miGrafica').append('<canvas id="graficaG"><canvas>');
	var mesNumero=0;
	if($('#selectMes').val()=="Enero"){
//		console.log(mesNumero);
		mesNumero = "1";
	}if($('#selectMes').val()=="Febrero"){
		mesNumero = "2";
	}if($('#selectMes').val()=="Marzo"){
		mesNumero = "3";
	}if($('#selectMes').val()=="Abril"){
		mesNumero = "4";
	}if($('#selectMes').val()=="Mayo"){
		mesNumero = "5";
	}if($('#selectMes').val()=="Junio"){
		mesNumero = "6";
	}if($('#selectMes').val()=="Julio"){
		mesNumero = "7";
	}if($('#selectMes').val()=="Agosto"){
		mesNumero = "8";
	}if($('#selectMes').val()=="Septiembre"){
		mesNumero = "9";
	}if($('#selectMes').val()=="Octubre"){
		mesNumero = "10";
	}if($('#selectMes').val()=="Noviembre"){
		mesNumero = "11";
	}if($('#selectMes').val()=="Diciembre"){
		mesNumero = "12";
	}
/*	
	console.log("valor del mes es---> "+$('#selectMes').val());
	console.log("numero de mes es--->"+mesNumero);
	console.log("valor de anio es---> "+$('#selectanio').val());
*/	
	
	
	if( mesNumero != "" &&  $('#selectanio').val() != ""){
		$.ajax({
		url : 'getDatosGraficaMes',
		type : 'POST',
		data : {
			'mes' : mesNumero,
			'anio'	 : $('#selectanio').val()
			},
		dataType : "json",
		beforeSend: function( xhr ) {
			 $('#loadModal').modal();
		 },
		success : function(jsonResponse, textStatus, jqXHR){
			$('#loadModal').modal('hide');
			if(jsonResponse.success){
//				console.log(jsonResponse);
				if(jsonResponse.result.length > 0){
//					console.log("-># consulta por mes ok...");
					construyeReporteMes(jsonResponse);
					$('#graficaG').text('');
					$('#graficaG').show('fade');
				}else{
//					console.log("-># consulta por mes sin datos");
					$('#errorModal').modal();
					$('#graficaG').hide('fade');
					
					
				}
			}
		},
	});
	}
}
//-- DATOS POR SEMANA 
function construyeReporteSemana(jsonResponse) {
	var arrTp = new Array();
	var arrEnl = new Array();
	var arrTfe = new Array();
	
	var total=0;
	var t_conciliados=0;
	var totalTp=0;
	var totalEnl=0;
	var totalTfe=0;
	
	$.each(
		jsonResponse.result,
		function(index, arrayValores) {
			total += parseInt(arrayValores.total);
			t_conciliados += arrayValores.t_conciliados;
			if (arrayValores.empresa == 'TOTALPLAY') {
				totalTp = Math.round((total>0)?((t_conciliados*100)/total):0);
//				console.log("valores de totalplay -->"+totalTp);
				if(totalTp>0 && totalTp!=''){
				arrTp.push(totalTp);			
				}
			}
			if (arrayValores.empresa == 'ENLACE') {
				  totalEnl = Math.round((total>0)?((t_conciliados * 100)/total):0);
//				console.log("valores enlace--> ## "+totalEnl);
					if(totalEnl>0 && totalEnl!=''){
					arrEnl.push(totalEnl);			
					}
			}
			if (arrayValores.empresa == 'TFE') {
				totalTfe = Math.round((total>0)?((t_conciliados * 100)/total):0);
//				console.log("valores tfe--> ## "+totalTfe);
				if(totalTfe>0 && totalTfe!=''){
				arrTfe.push(totalTfe);			
				}
			}
		});
	
//	llamado a graficas 	1
		modelo1(arrTp,arrEnl,arrTfe);
		
}
//-- DATOS POR MES
function construyeReporteMes(jsonResponse) {
	var arrTp_mes = new Array();
	var arrEnl_mes = new Array();
	var arrTfe_mes = new Array();
	var diasTp_mes = new Array();
	
	var total_mes = 0;
	var t_conciliados_mes  = 0;
	var totalTp_mes=0;
	var totalEnl_mes=0;
	var totalTfe_mes=0;
	var dias = 0;
	
	$.each(
		jsonResponse.result,
		function(index, arrayValores) {
			total_mes += parseInt(arrayValores.total);
			t_conciliados_mes += parseInt(arrayValores.t_conciliados);
//			console.log("total_mes---># "+total_mes);
			if (arrayValores.empresa == 'TOTALPLAY') {
				totalTp_mes = Math.round((total_mes>0)?((t_conciliados_mes*100)/total_mes):0);
//				console.log("valores de totalplay -->"+totalTp);
				if(totalTp_mes>0 && totalTp_mes!=''){
				arrTp_mes.push(totalTp_mes);			
				}
				var date = new Date(arrayValores.fecha);
				var mifecha = date.getDate()  + '/' + (date.getMonth() + 1) + '/' +  date.getFullYear()
				diasTp_mes.push(mifecha);
			}
			if (arrayValores.empresa == 'ENLACE') {
				totalEnl_mes = Math.round((total_mes>0)?((t_conciliados_mes * 100)/total_mes):0);
//				console.log("valores enlace--> ## "+totalEnl);
				if(totalEnl_mes>0 && totalEnl_mes!=''){
					arrEnl_mes.push(totalEnl_mes);			
				}
				
			}
			if (arrayValores.empresa == 'TFE') {
				totalTfe_mes = Math.round((total_mes>0)?((t_conciliados_mes * 100)/total_mes):0);
//				console.log("valores tfe--> ## "+totalTfe);
				if(totalTfe_mes>0 && totalTfe_mes!=''){
					arrTfe_mes.push(totalTfe_mes);			
				}
				
			}
		});
//	llamado a graficas 	
	modeloMes(arrTp_mes,arrEnl_mes,arrTfe_mes, diasTp_mes);
	
}

function modelo1(arr1,arr2,arr3){
	var entrada1 = new Array();
	var entrada2 = new Array();
	var entrada3 = new Array();

	entrada1=arr1;
	entrada2=arr2;
	entrada3=arr3;
//	comentarios de salida
//	console.log("datos a evaluar");
//	console.log("modeloTp ----------->"+entrada1);
//	console.log("modeloEnl ----------->"+entrada2);
//	console.log("modeloTfe ----------->"+entrada3);
	var config = {
            type: 'line',
            data: {
                labels: ["Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"],
                datasets: [{
                    label: "TOTALPLAY",		                     /* etiqueta */
                    borderColor: "blue",       /* color de linea */
                    backgroundColor: "blue",    /* fondo */
                    data: entrada1,	             /* datos */
                    fill: false,			                         /* relleno de fondo */
                }, {
                    label: "ENLACE",
                    backgroundColor:"green",
                    borderColor: "green",
                    data: entrada2,
                    fill: false,
                },
                {
                    label: "TFE",
                    backgroundColor: "orange",
                    borderColor: "orange",
                    data: entrada3,
                    fill: false,
                }]
            },
            options: {
                responsive: true,
                title:{
                    display:true,
                    text:'Detalle Semanal de Produccion'
                },
                tooltips: {
                	mode: 'index',
                    intersect: false, 	
                },
                hover: {
                	mode: 'nearest',
                    intersect: true
                	},
                scales: {
                    xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Valoracion %'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Monitoreo'
                        },
                        ticks: {
                            fontFamily: "Montserrat",
                            reverse : false,
                            min: 0,
                            max: 100,
                        },
                    }]
                }
            }
        };
	
     var ctx = document.getElementById("graficaG").getContext("2d");
     window.myLine = new Chart(ctx, config);
}


function modeloMes(arr1,arr2,arr3, arr4){
	var entrada1 = new Array();
	var entrada2 = new Array();
	var entrada3 = new Array();
	entrada1=arr1;
	entrada2=arr2;
	entrada3=arr3;
/*	
	console.log('datos a evaluar ');
	console.log("modeloTpMes ----------->"+entrada1);
	console.log("modeloEnlMes ----------->"+entrada2);
	console.log("modeloTfeMes ----------->"+entrada3);
	console.log("fechasMes ----------->"+arr4);
*/	
	
	var config = {
            type: 'line',
            data: {
                labels: arr4,
                datasets: [{
                    label: "TOTALPLAY",		                     /* etiqueta */
                    borderColor: "blue",       /* color de linea */
                    backgroundColor: "blue",    /* fondo */
                    data: entrada1,	             /* datos */
                    fill: false,			                         /* relleno de fondo */
                }, {
                    label: "ENLACE",
                    backgroundColor:"green",
                    borderColor: "green",
                    data: entrada2,
                    fill: false,
                },
                {
                    label: "TFE",
                    backgroundColor: "orange",
                    borderColor: "orange",
                    data: entrada3,
                    fill: false,
                }]
            },
            options: {
                responsive: true,
                title:{
                    display:true,
                    text:'Detalle Mensual de Produccion'
                },
                tooltips: {
                	mode: 'index',
                    intersect: false, 	
                },
                hover: {
                	mode: 'nearest',
                    intersect: true
                	},
                scales: {
                    xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Valoracion %'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Monitoreo'
                        },
                        ticks: {
                            fontFamily: "Montserrat",
                            reverse : false,
                            min: 0,
                            max: 100,
                        },
                    }]
                }
            }
        };
	
     var ctx = document.getElementById("graficaG");
     window.myLine = new Chart(ctx, config);
}
