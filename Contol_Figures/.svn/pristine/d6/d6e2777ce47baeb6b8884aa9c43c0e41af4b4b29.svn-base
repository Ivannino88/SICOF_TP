package com.mx.totalplay.struts.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.mx.totalplay.dao.aCentralvsEntradaSaDAO;
import com.mx.totalplay.vo.ServiceResponse;

public class aCentralvsEntradaSaAction  extends CifrasControlAction{

	/**
	 *
	 *
	 * @category Reportes
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CifrasControlAction.class);
	aCentralvsEntradaSaDAO dao = new aCentralvsEntradaSaDAO();

	/*
	 * Declaracion de variables
	 * */
	ServiceResponse result = new ServiceResponse();

	private String fecha;	

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		Conversor conver=new Conversor();
		this.fecha=conver.conversor(fecha);
	}


	@SuppressWarnings("unused")
	public String getCentalvsEntradaAlamacen(){
		//logger.debug("***Action: getCentalvsEntradaAlamacen(Fecha: "+fecha+")");
		String resultAction = SUCCESS;
		try{
			result = dao.getCentalvsEntradaAlamacen(fecha);
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
			resultAction = "ERRORPAGE";
		//	logger.error(e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
}
