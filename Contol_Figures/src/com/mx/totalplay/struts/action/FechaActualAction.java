package com.mx.totalplay.struts.action;

import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.mx.totalplay.dao.FechaActualDAO;
import com.mx.totalplay.vo.ServiceResponse;

public class FechaActualAction extends CifrasControlAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(FechaActualAction.class);
	FechaActualDAO fechaActual=new FechaActualDAO();
	private InputStream inputStream;
	private String reportFile;
	
	@SuppressWarnings("unused")
	public String getFechaActual(){
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = fechaActual.getFechaActual();
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
			} else {
//				logger.error("getFechaActual ERROR");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}
		}catch (Exception e) {
//			logger.error("getFechaActual, ###ERROR### " + e);
			setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
		
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getReportFile() {
		return reportFile;
	}
	public void setReportFile(String reportFile) {
		this.reportFile = reportFile;
	}	
}
