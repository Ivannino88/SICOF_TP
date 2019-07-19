package com.mx.totalplay.struts.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.struts2.ServletActionContext;

import com.mx.totalplay.dao.ConciliaPolizasIngresosDAO;
import com.mx.totalplay.vo.ServiceResponse;

public class ConciliaPolizasIngresosAction extends CifrasControlAction {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ConciliaPolizasIngresosAction.class);
	ConciliaPolizasIngresosDAO conciPolIngresos =  new ConciliaPolizasIngresosDAO();
	private String fecha;
	
	@SuppressWarnings("unused")
	public String getConciliaPolizasIngresosAction(){
		//System.out.println("ConciliaPolizasIngresosAction.getConciliaPolizasIngresos()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = conciPolIngresos.getConciliaPolizasIngresos(getFecha());
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
			} else {
			//	logger.error("getConciliaPolizasIngresosAction ERROR");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}

		} catch (Exception e) {
			setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
// ------------------ setter y getters ----------	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
