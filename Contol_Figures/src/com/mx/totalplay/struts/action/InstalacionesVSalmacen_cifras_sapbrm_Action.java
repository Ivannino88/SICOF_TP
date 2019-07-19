package com.mx.totalplay.struts.action;
/**
 * 
 * @author RicardoM
 * ACTION PARA EL REPORTE DE INSTALACIONES VS ALMACEN CIFRAS SAP-BRM
 */
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.mx.totalplay.dao.InstalacionesVSalmacen_cifras_sapbrm_DAO;
import com.mx.totalplay.vo.ServiceResponse;
public class InstalacionesVSalmacen_cifras_sapbrm_Action extends CifrasControlAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(InstalacionesVSalmacen_cifras_sapbrm_Action.class);
	InstalacionesVSalmacen_cifras_sapbrm_DAO InstalacionesVSalmacencifrassapbrmDAO = new InstalacionesVSalmacen_cifras_sapbrm_DAO();
	String fecha;
	
	
	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		Conversor conver=new Conversor();
		this.fecha=conver.conversor(fecha);
	}


	@SuppressWarnings("unused")
	public String getReporteInstalacionesVSalmacen_cifras_sapbrms(){
		//logger.debug("*** getReporteInstalacionesVSalmacen_cifras_sapbrms()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = InstalacionesVSalmacencifrassapbrmDAO.getReporteInstalacionesVSalmacen_cifras_sapbrms(getFecha());
			
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				//logger.debug("getReporteInstalacionesVSalmacen_cifras_sapbrms SUCCESS");
			} else {
//				logger.error("getReporteInstalacionesVSalmacen_cifras_sapbrms ERROR");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}

		} catch (Exception e) {
//			logger.error("getReporteInstalacionesnVScActivadas, ###ERROR### " + e);
			setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}

}
