package com.mx.totalplay.struts.action;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mx.totalplay.dao.CtasActBRMvsU2000LO_Cuentas_DAO;
import com.mx.totalplay.dao.CtasActBRMvsU2000LO_ExcelCtas_DAO;
import com.mx.totalplay.dao.CtasActBRMvsU2000LO_ExcelSN_DAO;
import com.mx.totalplay.dao.CtasActBRMvsU2000LO_SN_DAO;
import com.mx.totalplay.dao.PaqTvBrmRedIPTVIncluidoLI_Ctas_DAO;
import com.mx.totalplay.dao.PaqTvBrmRedIPTVIncluidoLI_SN_DAO;
import com.mx.totalplay.vo.LineasInternasVO;
import com.mx.totalplay.vo.ServiceResponse;

public class PaqTvBrmRedIPTVIncluidoLI_Action extends CifrasControlAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(PaqTvBrmRedIPTVIncluidoLI_Action.class);
	
	PaqTvBrmRedIPTVIncluidoLI_Ctas_DAO getPaqTvBrmRedIPTVIncluidoLI_Ctas_DAO =new PaqTvBrmRedIPTVIncluidoLI_Ctas_DAO();
	PaqTvBrmRedIPTVIncluidoLI_SN_DAO getPaqTvBrmRedIPTVIncluidoLI_SN_DAO =new PaqTvBrmRedIPTVIncluidoLI_SN_DAO();
	
	private String todos;	
	private File myFile;
	private String myFileFileName;
	private String reportFile;
	private InputStream inputStream;
	private String fecha;

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
//********************************************************************
	
	@SuppressWarnings("unused")
	public String PaqTvBrmRedIPTVIncluidoLI_CtasExcel(){
		String resultAction = SUCCESS;
		
		try{
			result = getPaqTvBrmRedIPTVIncluidoLI_Ctas_DAO.getPaqTvBrmRedIPTVIncluidoLI_Excel(getMyFile());
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
	
	@SuppressWarnings("unused")
	public String PaqTvBrmRedIPTVIncluidoLI_SNExcel(){
		String resultAction = SUCCESS;
		
		try{
			result = getPaqTvBrmRedIPTVIncluidoLI_SN_DAO.getPaqTvBrmRedIPTVIncluidoLI_Excel(getMyFile());
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
	
//*****************************METODOS PARA CARGAR LAS TABLAS PRINCIPALES*************************************
//************************************************************************************************************
	
	public String PaqTvBrmRedIPTVIncluidoLI_Ctas(){
	////logger.debug("***Action: getCtasActBRMvsU2000(Fecha: "+fecha+")");
		
		////logger.debug("Action>getCtasActBRMvsU2000>fecha>" + getFecha());

		try{
			result = getPaqTvBrmRedIPTVIncluidoLI_Ctas_DAO.getPaqTvBrmRedIPTVIncluidoLI_Ctas_DAO(getFecha(), getTodos());
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
	
	
	public String PaqTvBrmRedIPTVIncluidoLI_SN(){
	////logger.debug("***Action: getCtasActBRMvsU2000(Fecha: "+fecha+")");
		
		LineasInternasVO lineasInternasVO = new LineasInternasVO();
		lineasInternasVO.setFecha(getFecha());

			////logger.debug("Action>getCtasActBRMvsU2000>fecha>" + getFecha());

			try{
				result = getPaqTvBrmRedIPTVIncluidoLI_SN_DAO.getPaqTvBrmRedIPTVIncluidoLI_SN_DAO(getFecha(), getTodos());
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
		public String PaqTvBrmRedIPTVIncluidoLI_insertarCtas(){
				
//			System.out.println("contenido del arreglo: "+getJson_string());
			
			Gson gson = new Gson();
			Type listType = new TypeToken<List<LineasInternasVO>>(){}.getType();
			List<LineasInternasVO> listas = (List<LineasInternasVO>) gson.fromJson(getJson_string(), listType);
				try{
					result = getPaqTvBrmRedIPTVIncluidoLI_Ctas_DAO.getPaqTvBrmRedIPTVIncluidoLI_insertarCtas_DAO(listas);
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
		
		
		@SuppressWarnings("unchecked")
		public String PaqTvBrmRedIPTVIncluidoLI_eliminarCuentas(){
				
//			System.out.println("contenido del arreglo: "+getJson_string());
			
			Gson gson = new Gson();
			Type listType = new TypeToken<List<LineasInternasVO>>(){}.getType();
			List<LineasInternasVO> listas = (List<LineasInternasVO>) gson.fromJson(getJson_string(), listType);
				try{
					result = getPaqTvBrmRedIPTVIncluidoLI_Ctas_DAO.getPaqTvBrmRedIPTVIncluidoLI_eliminarCtas_DAO(listas);
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
		
		public String PaqTvBrmRedIPTVIncluidoLI_eliminarTodoCuentas(){
		try{
					result = getPaqTvBrmRedIPTVIncluidoLI_Ctas_DAO.getEliminarTodoCtas_DAO();
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

		//******************** METODO PARA INSERTAR Y BORRAR LOS DATOS DE LA TABLA SN **************************
		//****************************************************************************************	
			
				@SuppressWarnings("unchecked")
				public String PaqTvBrmRedIPTVIncluidoLI_insertarSN(){
						
//					System.out.println("contenido del arreglo: "+getJson_string());
					
					Gson gson = new Gson();
					Type listType = new TypeToken<List<LineasInternasVO>>(){}.getType();
					List<LineasInternasVO> listas = (List<LineasInternasVO>) gson.fromJson(getJson_string(), listType);
						try{
							result = getPaqTvBrmRedIPTVIncluidoLI_SN_DAO.getPaqTvBrmRedIPTVIncluidoLI_insertarSN_DAO(listas);
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
//							logger.error("Action getCtasActBRMvsU2000>>>"+e);
						}
						sendJSONObjectToResponse(result);
						HttpServletResponse response = ServletActionContext.getResponse();
						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						return null;
				}
				
				
				@SuppressWarnings("unchecked")
				public String PaqTvBrmRedIPTVIncluidoLI_eliminarSN(){
						
//					System.out.println("contenido del arreglo: "+getJson_string());
					
					Gson gson = new Gson();
					Type listType = new TypeToken<List<LineasInternasVO>>(){}.getType();
					List<LineasInternasVO> listas = (List<LineasInternasVO>) gson.fromJson(getJson_string(), listType);
						try{
							result = getPaqTvBrmRedIPTVIncluidoLI_SN_DAO.getPaqTvBrmRedIPTVIncluidoLI_eliminarSN_DAO(listas);
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
//							logger.error("Action getCtasActBRMvsU2000>>>"+e);
						}
						sendJSONObjectToResponse(result);
						HttpServletResponse response = ServletActionContext.getResponse();
						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						return null;
				}
			
				public String PaqTvBrmRedIPTVIncluidoLI_eliminarTodoSN(){
						try{
							result = getPaqTvBrmRedIPTVIncluidoLI_SN_DAO.getEliminarTodoSN_DAO();
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
//							logger.error("Action getCtasActBRMvsU2000>>>"+e);
						}
						sendJSONObjectToResponse(result);
						HttpServletResponse response = ServletActionContext.getResponse();
						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						return null;
				}
			

}