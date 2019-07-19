package com.mx.totalplay.struts.action;


import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import com.mx.totalplay.dao.QueryDAO;
import com.mx.totalplay.dao.UpdateDAO;
import com.mx.totalplay.dao.InsertDAO;
import com.mx.totalplay.vo.ServiceResponse;

import java.util.regex.*;

public class XdemoAction extends CifrasControlAction {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(XdemoAction.class);
	QueryDAO getQuery =  new QueryDAO();
	InsertDAO getInsert =  new InsertDAO();
	UpdateDAO getUpdate =  new UpdateDAO();
	
	private String cadena;
	
	public String getCadena() {
		return cadena;
	}
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	@SuppressWarnings("unused")
	public String getQuerys(){
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		
		//logger.info("cadena: " + cadena);
		String aguja = "select";             
		String pajar = cadena;   

		Pattern regex = Pattern.compile("\\b" + Pattern.quote(aguja) + "\\b", Pattern.CASE_INSENSITIVE);
		Matcher match = regex.matcher(pajar);


		if (match.find()) {
		
			//logger.info("*** getQuerys");
			
			try {
				ServiceResponse respDet = new ServiceResponse();
				ArrayList datos = new ArrayList();
				ArrayList<String> campos = new ArrayList<String>();
				int filas = 0;
				int r = 0;
				int z= 1;
				int y= 0;
				int n=0;
				int c=0;
				int m=0;
				int b=0;
				respDet = getQuery.getQuery(cadena);
				
				if (respDet.isSuccess()) {
					
					StringBuilder tablec = new StringBuilder();
					
					//System.out.println("respDet.getResult(): " + respDet.getResult());
					//System.out.println("respDet.getResult2(): " + respDet.getResult2());
					
					campos =  (ArrayList<String>) respDet.getResult();
					
					//System.out.println("campos: " + campos);
					
					tablec.append("<table class='table table-responsive table-striped table-bordered'>");
					tablec.append("<tr>");
					for(int j = 0; j< campos.size(); j++){	
						tablec.append("<td><strong>");
				    	tablec.append(campos.get(j));
				    	tablec.append("</strong></td>");
				    	r=j;
					}
					tablec.append("</tr>");
					
					datos =  (ArrayList) respDet.getResult2();				
					//System.out.println("datos: " + datos);
					
					filas =  (Integer) respDet.getResult3();				
					//System.out.println("filas: " + filas);
					
					if (filas == 1){
						tablec.append("<tr>");
						for(int i = 0; i< datos.size(); i++){	
							tablec.append("<td>");
					    	tablec.append(datos.get(i));
					    	tablec.append("</td>");
						}
		                tablec.append("</tr>");
		                tablec.append("</table>");
					}
					else if (filas > 1){
						tablec.append("<tr>");
						for(int i = 0; i< datos.size(); i++){
							
							tablec.append("<td>");
					    	tablec.append(datos.get(i));
					    	tablec.append("</td>");
					    	//System.out.println("i: " + i);
					    	//System.out.println("z: " + z);
					    	//System.out.println("r: " + r);
					    	y = i +1;
					    	n = z + r;
					    	//System.out.println("n: " + n);
					    	c=c+1;
					    	//System.out.println("z+r: " + z);
					    	//System.out.println("y: " + y);
					    	//System.out.println("c: " + c);
					    	
					    	
					    	int resto;			    	 
					    	resto = y%n;
					    	//System.out.println("resto: " + resto);
					    	//System.out.println("b: " + b);
					    	if (b>=1){
					    		c=b+1;
					    	}
					    	if (resto==0) {
					    		
					    		m = n*c;
						    	//System.out.println("Entra m: " + m);
						    	if (y==m){
						    		//System.out.println("Entra y==m: " + y+"="+m);
						    		tablec.append("</tr>");
						    		
						    		m=0;
						    		b=c;
						    		//System.out.println("c: " + c);
						    		//System.out.println("Cierra fila");
						    	}else {
						    		//System.out.println("No entra y:"+y+"<" + "m" + m );
						    		m=0;
						    		//System.out.println("m: " + m);
						    		//System.out.println("z: " + z);
						    	}
					    	}
					    	else{
					    		c=0;
					    	}
					    	
					    	
						}
						
		                tablec.append("</table>");
					}
					
					
	                //System.out.println("tablec: " + tablec.toString());
					
					
					result.setMensaje(respDet.getMensaje());
					result.setResult(tablec.toString());
					result.setSuccess(true);
					
					//logger.debug("getSalidasAlmacenCvsEntradasSubalmac SUCCESS");
				} else {
	//				logger.error("getSalidasAlmacenCvsEntradasSubalmac ERROR");
					result.setSuccess(false);
					result.setResult(null);
					result.setMensaje(respDet.getMensaje());
				}
	
			} catch (Exception e) {
	//			logger.error("getSalidasAlmacenCvsEntradasSubalmac, ###ERROR### " + e);
				setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
				resultAction = "ERRORPAGE";
			}
			sendJSONObjectToResponse(result);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			return null;
			
		}
		else {
			String aguja2 = "insert";             
			String pajar2 = cadena;  
			String[] cadena_execute = null;

			Pattern regex2 = Pattern.compile("\\b" + Pattern.quote(aguja2) + "\\b", Pattern.CASE_INSENSITIVE);
			Matcher match2 = regex2.matcher(pajar2);
			
			if (match2.find()) {
				//logger.info("getInserts");
				
		        int intIndex = cadena.indexOf(";");
		        //logger.info("intIndex: " + intIndex); 
		        if(intIndex == - 1){
		        	//logger.info("Palabra No Encontrada ");
					getInserts(cadena);
		        }
		        else
				 {
					//logger.info("Palabra Encontrada" );
					cadena_execute = cadena.split(";");
					if (cadena_execute.length==1){
						getInserts(cadena_execute[0]);
						
					}else {
						for (int i = 0; i < cadena_execute.length; i++){
							getInserts2(cadena_execute[i]);
						}
						StringBuilder tablec = new StringBuilder();
						
						tablec.append("<table class='table table-responsive table-striped table-bordered'>");
						tablec.append("<tr>");	
						tablec.append("<td><strong>");
						tablec.append("REGISTROS INSERTADOS");
					    tablec.append("</strong></td>");
						tablec.append("</tr>");
						tablec.append("</table>");
						
						result.setMensaje("Se insertaron los registros");
						result.setResult(tablec.toString());
						result.setSuccess(true);
						
						sendJSONObjectToResponse(result);
						HttpServletResponse response = ServletActionContext.getResponse();
						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
					}
					
				}
								
			 }
			 else{
				//logger.info("getUpdates");
				 int intIndex = cadena.indexOf(";");
			     //logger.info("intIndex: " + intIndex); 
			     if(intIndex == - 1){
			        //logger.info("; No Encontrado ");
					getUpdates(cadena);
			     }
			     else{
					cadena_execute = cadena.split(";");
					//logger.info("; Si Encontrado ");
					//logger.info("cadena_execute.length: " + cadena_execute.length);
					if (cadena_execute.length==1){
						getUpdates(cadena_execute[0]);
						
					}else {
						for (int i = 0; i < cadena_execute.length; i++){
							getUpdates2(cadena_execute[i]);
						}
						StringBuilder tablec = new StringBuilder();
						
						tablec.append("<table class='table table-responsive table-striped table-bordered'>");
						tablec.append("<tr>");	
						tablec.append("<td><strong>");
						tablec.append("REGISTROS ACTUALIZADOS");
					    tablec.append("</strong></td>");
						tablec.append("</tr>");
						tablec.append("</table>");
						
						result.setMensaje("Se actualizaron los registros");
						result.setResult(tablec.toString());
						result.setSuccess(true);
						
						sendJSONObjectToResponse(result);
						HttpServletResponse response = ServletActionContext.getResponse();
						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
					}
					
				}
			}
			
		}
		
		return null;
	}
	
	@SuppressWarnings("unused")
	public String getInserts(String sql_cadena){
		//logger.debug("*** getSalidasAlmacenCvsEntradasSubalmac()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			
			respDet = getInsert.getQuery(sql_cadena);
			//logger.info("Insert respDet: " + respDet);
			
			if (respDet.isSuccess()) {
				//logger.info("respDet.isSuccess(): " + respDet.isSuccess());
				
				StringBuilder tablec = new StringBuilder();
				
				tablec.append("<table class='table table-responsive table-striped table-bordered'>");
				tablec.append("<tr>");	
				tablec.append("<td><strong>");
				tablec.append("REGISTRO INSERTADO");
			    tablec.append("</strong></td>");
				tablec.append("</tr>");
				tablec.append("</table>");
				
				result.setMensaje(respDet.getMensaje());
				result.setResult(tablec.toString());
				result.setSuccess(true);
				
				//logger.debug("getSalidasAlmacenCvsEntradasSubalmac SUCCESS");
			} else {
//				logger.error("getSalidasAlmacenCvsEntradasSubalmac ERROR");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}

		} catch (Exception e) {
//			logger.error("getSalidasAlmacenCvsEntradasSubalmac, ###ERROR### " + e);
			setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	public String getInserts2(String sql_cadena){
		//logger.debug("*** getSalidasAlmacenCvsEntradasSubalmac()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			
			respDet = getInsert.getQuery(sql_cadena);
			//logger.info("Insert respDet: " + respDet);
			
			if (respDet.isSuccess()) {
				//logger.info("respDet.isSuccess(): " + respDet.isSuccess());
				
				//logger.debug("getSalidasAlmacenCvsEntradasSubalmac SUCCESS");
			} else {
//				logger.error("getSalidasAlmacenCvsEntradasSubalmac ERROR");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}

		} catch (Exception e) {
//			logger.error("getSalidasAlmacenCvsEntradasSubalmac, ###ERROR### " + e);
			setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
			resultAction = "ERRORPAGE";
		}
		
		return null;
	}
	
	@SuppressWarnings("unused")
	public String getUpdates(String sql_cadena){
		//logger.debug("*** getSalidasAlmacenCvsEntradasSubalmac()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			
			respDet = getUpdate.getQuery(sql_cadena);
			//logger.info("Update respDet: " + respDet);
			if (respDet.isSuccess()) {
				//logger.info("respDet.isSuccess(): " + respDet.isSuccess());
				StringBuilder tablec = new StringBuilder();
				
				tablec.append("<table class='table table-responsive table-striped table-bordered'>");
				tablec.append("<tr>");	
				tablec.append("<td><strong>");
				tablec.append("REGISTRO ACTUALIZADO");
			    tablec.append("</strong></td>");
				tablec.append("</tr>");
				tablec.append("</table>");
				
				result.setMensaje(respDet.getMensaje());
				result.setResult(tablec.toString());
				result.setSuccess(true);
				
				//logger.debug("getSalidasAlmacenCvsEntradasSubalmac SUCCESS");
			} else {
//				logger.error("getSalidasAlmacenCvsEntradasSubalmac ERROR");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}

		} catch (Exception e) {
//			logger.error("getSalidasAlmacenCvsEntradasSubalmac, ###ERROR### " + e);
			setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	@SuppressWarnings("unused")
	public String getUpdates2(String sql_cadena){
		//logger.debug("*** getSalidasAlmacenCvsEntradasSubalmac()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			
			respDet = getUpdate.getQuery(sql_cadena);
			//logger.info("Update respDet: " + respDet);
			if (respDet.isSuccess()) {
				//logger.info("respDet.isSuccess(): " + respDet.isSuccess());
				
				
				//logger.debug("getSalidasAlmacenCvsEntradasSubalmac SUCCESS");
			} else {
//				logger.error("getSalidasAlmacenCvsEntradasSubalmac ERROR");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}

		} catch (Exception e) {
//			logger.error("getSalidasAlmacenCvsEntradasSubalmac, ###ERROR### " + e);
			setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
			resultAction = "ERRORPAGE";
		}
		
		return null;
	}


}
