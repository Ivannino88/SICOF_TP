package com.mx.totalplay.struts.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.mx.totalplay.dao.CtasActBRMvsU2000DAO;
import com.mx.totalplay.dao.CtasActBRMvsU2000LO_Cuentas_DAO;
import com.mx.totalplay.dao.CtasActBRMvsU2000LO_ExcelCtas_DAO;
import com.mx.totalplay.dao.CtasActBRMvsU2000LO_ExcelSN_DAO;
import com.mx.totalplay.dao.CtasActBRMvsU2000LO_SN_DAO;
import com.mx.totalplay.vo.CtasActBRMvsU2000VO;
import com.mx.totalplay.vo.Detalle2000NoBrmVO;
import com.mx.totalplay.vo.DetalleBrmNoU2000VO;
import com.mx.totalplay.vo.LineasInternasVO;
import com.mx.totalplay.vo.ServiceResponse;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException; 
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;

public class CtasActBRMvsU2000LOAction extends CifrasControlAction{
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CtasActBRMvsU2000LOAction.class);
	CtasActBRMvsU2000LO_ExcelCtas_DAO ctasActBRMvsU2000DAOCtasexcel = new CtasActBRMvsU2000LO_ExcelCtas_DAO();
	CtasActBRMvsU2000LO_ExcelSN_DAO ctasActBRMvsU2000DAOSNexcel = new CtasActBRMvsU2000LO_ExcelSN_DAO();
	
	CtasActBRMvsU2000LO_Cuentas_DAO getCtasActBRMvsU2000LI_Cuentas =new CtasActBRMvsU2000LO_Cuentas_DAO();
	CtasActBRMvsU2000LO_SN_DAO getCtasActBRMvsU2000LI_SN =new CtasActBRMvsU2000LO_SN_DAO();
	
		
	private File myFile;
	private String myFileFileName;
	private String reportFile;
	private InputStream inputStream;
	private String fecha;
	private String todos;

	public String getTodos() {
		return todos;
	}
	public void setTodos(String todos) {
		this.todos = todos;
	}
	public String getMyFileFileName() {
	      return myFileFileName;
	   } 
	   public void setMyFileFileName(String myFileFileName) {
	      this.myFileFileName = myFileFileName;
	   }
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		Conversor conver=new Conversor();
		this.fecha=conver.conversor(fecha);
	}
	public String getReportFile() {
		return reportFile;
	}
	public void setReportFile(String reportFile) {
		this.reportFile = reportFile;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	ServiceResponse result = new ServiceResponse();
	
//*************METODOS PARA PREVISUALIZAR EXCEL***********************
	@SuppressWarnings("unused")
	public String getCtasActBRMvsU2000LOCtas_Excel(){
		String resultAction = SUCCESS;
		
		try{
			result = ctasActBRMvsU2000DAOCtasexcel.getCtasActBRMvsU2000_LO(getMyFile());
			if(result.isSuccess()){
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(true);
			}else{
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(false);
			}
		}catch(Exception e){
		//	logger.error("Action getCtasActBRMvsU2000>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	@SuppressWarnings("unused")
	public String getCtasActBRMvsU2000LOSN_Excel(){
		String resultAction = SUCCESS;
		
		try{
			result = ctasActBRMvsU2000DAOSNexcel.getCtasActBRMvsU2000_LO(getMyFile());
			if(result.isSuccess()){
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(true);
			}else{
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(false);
			}
		}catch(Exception e){
		//	logger.error("Action getCtasActBRMvsU2000>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
//*****************************METODOS PARA CARGAR LAS TABLAS PRINCIPALES*************************************
//************************************************************************************************************
	
	public String getCuentas_CtasActBRMvsU2000LO(){
	////logger.debug("***Action: getCtasActBRMvsU2000(Fecha: "+fecha+")");
		
		////logger.debug("Action>getCtasActBRMvsU2000>fecha>" + getFecha());

		try{
			result = getCtasActBRMvsU2000LI_Cuentas.getCtasActBRMvsU2000LO_Cuentas_DAO(getFecha(), getTodos());
			if(result.isSuccess()){
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(true);
			}else{
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(false);
			}
		}catch(Exception e){
//			logger.error("Action getCtasActBRMvsU2000 Lineas Internas >>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	
	public String getSN_CtasActBRMvsU2000LO(){
	////logger.debug("***Action: getCtasActBRMvsU2000(Fecha: "+fecha+")");
		
		LineasInternasVO lineasInternasVO = new LineasInternasVO();
		lineasInternasVO.setFecha(getFecha());

			////logger.debug("Action>getCtasActBRMvsU2000>fecha>" + getFecha());

			try{
				result = getCtasActBRMvsU2000LI_SN.getCtasActBRMvsU2000LO_SN_DAO(getFecha(),getTodos());
				if(result.isSuccess()){
					result.setMensaje(result.getMensaje());
					result.setResult(result.getResult());
					result.setSuccess(true);
				}else{
					result.setMensaje(result.getMensaje());
					result.setResult(result.getResult());
					result.setSuccess(false);
				}
			}catch(Exception e){
	//			logger.error("Action getCtasActBRMvsU2000>>>"+e);
			}
			sendJSONObjectToResponse(result);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			return null;
	}


//******************** METODO PARA INSERTAR Y BORRAR LOS DATOS DE LA TABLA CUENTAS **************************
//****************************************************************************************
	String json_string;
	public String getJson_string() {
		return json_string;
	}
	public void setJson_string(String json_string) {
		this.json_string = json_string;
	}
	
	
		@SuppressWarnings("unchecked")
		public String getCtasActBRMvsU2000LI_insertarCuentas(){
				
//			System.out.println("contenido del arreglo: "+getJson_string());
			
			Gson gson = new Gson();
			Type listType = new TypeToken<List<LineasInternasVO>>(){}.getType();
			List<LineasInternasVO> listas = (List<LineasInternasVO>) gson.fromJson(getJson_string(), listType);
				try{
					result = getCtasActBRMvsU2000LI_Cuentas.getCtasActBRMvsU2000LI_insertarCuentasDAO(listas);
					if(result.isSuccess()){
						result.setMensaje(result.getMensaje());
						result.setResult(result.getResult());
						result.setSuccess(true);
					}else{
						result.setMensaje(result.getMensaje());
						result.setResult(result.getResult());
						result.setSuccess(false);
					}
					
				}catch(Exception e){
		//			logger.error("Action getCtasActBRMvsU2000>>>"+e);
				}
				sendJSONObjectToResponse(result);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				return null;
		}
		
		
		@SuppressWarnings("unchecked")
		public String getCtasActBRMvsU2000LI_eliminarCuentas(){
				
//			System.out.println("contenido del arreglo: "+getJson_string());
			
			Gson gson = new Gson();
			Type listType = new TypeToken<List<LineasInternasVO>>(){}.getType();
			List<LineasInternasVO> listas = (List<LineasInternasVO>) gson.fromJson(getJson_string(), listType);
				try{
					

					result = getCtasActBRMvsU2000LI_Cuentas.getCtasActBRMvsU2000LI_eliminarCuentasDAO(listas);
					if(result.isSuccess()){
						result.setMensaje(result.getMensaje());
						result.setResult(result.getResult());
						result.setSuccess(true);
					}else{
						result.setMensaje(result.getMensaje());
						result.setResult(result.getResult());
						result.setSuccess(false);
					}
					
				}catch(Exception e){
			//		logger.error("Action getCtasActBRMvsU2000>>>"+e);
				}
				sendJSONObjectToResponse(result);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				return null;
		}

		public String getCtasActBRMvsU2000LI_eliminarTodoCuentas(){
		try{
					result = getCtasActBRMvsU2000LI_Cuentas.getEliminarTodoCuentasDAO();
					if(result.isSuccess()){
						result.setMensaje(result.getMensaje());
						result.setResult(result.getResult());
						result.setSuccess(true);
					}else{
						result.setMensaje(result.getMensaje());
						result.setResult(result.getResult());
						result.setSuccess(false);
					}		
				}catch(Exception e){
			//		logger.error("Action getCtasActBRMvsU2000>>>"+e);
				}
				sendJSONObjectToResponse(result);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				return null;
		}
		

		//******************** METODO PARA INSERTAR Y BORRAR LOS DATOS DE LA TABLA SN **************************
		//****************************************************************************************	
			
				@SuppressWarnings("unchecked")
				public String getCtasActBRMvsU2000LI_insertarSN(){
						
//					System.out.println("contenido del arreglo: "+getJson_string());
					
					Gson gson = new Gson();
					Type listType = new TypeToken<List<LineasInternasVO>>(){}.getType();
					List<LineasInternasVO> listas = (List<LineasInternasVO>) gson.fromJson(getJson_string(), listType);
						try{
							result = getCtasActBRMvsU2000LI_SN.getCtasActBRMvsU2000LI_insertarSNDAO(listas);
							if(result.isSuccess()){
								result.setMensaje(result.getMensaje());
								result.setResult(result.getResult());
								result.setSuccess(true);
							}else{
								result.setMensaje(result.getMensaje());
								result.setResult(result.getResult());
								result.setSuccess(false);
							}
							
						}catch(Exception e){
			//				logger.error("Action getCtasActBRMvsU2000>>>"+e);
						}
						sendJSONObjectToResponse(result);
						HttpServletResponse response = ServletActionContext.getResponse();
						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						return null;
				}
				
				
				@SuppressWarnings("unchecked")
				public String getCtasActBRMvsU2000LI_eliminarSN(){
						
//					System.out.println("contenido del arreglo: "+getJson_string());
					
					Gson gson = new Gson();
					Type listType = new TypeToken<List<LineasInternasVO>>(){}.getType();
					List<LineasInternasVO> listas = (List<LineasInternasVO>) gson.fromJson(getJson_string(), listType);
						try{
							result = getCtasActBRMvsU2000LI_SN.getCtasActBRMvsU2000LI_eliminarSNDAO(listas);
							if(result.isSuccess()){
								result.setMensaje(result.getMensaje());
								result.setResult(result.getResult());
								result.setSuccess(true);
							}else{
								result.setMensaje(result.getMensaje());
								result.setResult(result.getResult());
								result.setSuccess(false);
							}
							
						}catch(Exception e){
		//					logger.error("Action getCtasActBRMvsU2000>>>"+e);
						}
						sendJSONObjectToResponse(result);
						HttpServletResponse response = ServletActionContext.getResponse();
						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						return null;
				}
				
				public String getCtasActBRMvsU2000LI_eliminarTodoSN(){
				try{
							result = getCtasActBRMvsU2000LI_SN.getEliminarTodoSNDAO();
							if(result.isSuccess()){
								result.setMensaje(result.getMensaje());
								result.setResult(result.getResult());
								result.setSuccess(true);
							}else{
								result.setMensaje(result.getMensaje());
								result.setResult(result.getResult());
								result.setSuccess(false);
							}
							
						}catch(Exception e){
		//					logger.error("Action getCtasActBRMvsU2000>>>"+e);
						}
						sendJSONObjectToResponse(result);
						HttpServletResponse response = ServletActionContext.getResponse();
						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						return null;
				}
				
}