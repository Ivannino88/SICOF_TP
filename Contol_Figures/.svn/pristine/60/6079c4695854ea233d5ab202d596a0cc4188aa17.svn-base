package com.mx.totalplay.struts.action;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.mx.totalplay.dao.ConciliacionBrmBancosDAO;
import com.mx.totalplay.vo.ConciliacionBrmBancosVO;
import com.mx.totalplay.vo.ServiceResponse;

public class ConciliacionBrmBancosAction {
	
	private static final Logger logger = Logger.getLogger(ConciliacionBrmBancosAction.class);
	ConciliacionBrmBancosDAO conciliacionBrmBancosDAO = new ConciliacionBrmBancosDAO();
	private InputStream inputStream;
	String fecha;
	String empresa;
	String tipo_conciliacion;
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		Conversor conver=new Conversor();
		this.fecha=conver.conversor(fecha);
	}
	
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTipo_conciliacion() {
		return tipo_conciliacion;
	}

	public void setTipo_conciliacion(String tipo_conciliacion) {
		this.tipo_conciliacion = tipo_conciliacion;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	ServiceResponse result = new ServiceResponse();
	
	
	public String getListaCanal(){
		//logger.debug("***Action: getListaCanal(Empresa: "+empresa+")");
		
		ConciliacionBrmBancosVO conciliacionBrmBancosVO = new ConciliacionBrmBancosVO();
		conciliacionBrmBancosVO.setEmpresa(getEmpresa());
		
		//logger.debug("Action>getListaCanal>empresa>"+getEmpresa());
		
		try{
			result = conciliacionBrmBancosDAO.getListaCanal(empresa);
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
		//	logger.error("Action getListaCanal>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	public String getConciliacionBrmBancos(){
		//logger.debug("***Action: getConciliacionBrmBancos(Fecha: "+fecha+")");
		//logger.debug("***Action: getConciliacionBrmBancos(Empresa: "+empresa+")");
		//logger.debug("***Action: getConciliacionBrmBancos(Canal: "+tipo_conciliacion+")");
		
		ConciliacionBrmBancosVO conciliacionBrmBancosVO = new ConciliacionBrmBancosVO();
		conciliacionBrmBancosVO.setFecha(getFecha());
		conciliacionBrmBancosVO.setEmpresa(getEmpresa());
		conciliacionBrmBancosVO.setTipo_conciliacion(getTipo_conciliacion());
		
		//logger.debug("Action>getConciliacionBrmBancos>fecha>"+getFecha());
		//logger.debug("Action>getConciliacionBrmBancos>empresa>"+getEmpresa());
		//logger.debug("Action>getConciliacionBrmBancos>canal>"+getTipo_conciliacion());
		
		try{
			result = conciliacionBrmBancosDAO.getConciliacionBrmBancos(conciliacionBrmBancosVO);
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
		//	logger.error("Action getConciliacionBrmBancos>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	
	protected void sendJSONObjectToResponse(Object objToSend){
		Gson gson = new Gson();
		String jsonResult = gson.toJson(objToSend);	      
	      HttpServletResponse response = ServletActionContext.getResponse();
	      response.setContentType("application/json");
	      response.setCharacterEncoding("UTF-8");
	      try {
	    	  //logger.debug("SEND JSON " + jsonResult);
	    	  response.getWriter().write(jsonResult );
		} catch (IOException e) {
		//	System.out.println("Imposible generar la respuesta. Error: " + e.getMessage());
		//	e.printStackTrace();			
		}
	}
	
}
