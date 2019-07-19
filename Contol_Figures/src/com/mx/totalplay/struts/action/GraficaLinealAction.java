package com.mx.totalplay.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.mx.totalplay.dao.GraficaLinealDao;
import com.mx.totalplay.vo.BeanGraficaVo;
import com.mx.totalplay.vo.ServiceResponse;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import org.apache.log4j.Logger;



public class GraficaLinealAction extends CifrasControlAction {
	private static final Logger logger = Logger.getLogger(GraficaLinealAction.class);
	private static final long serialVersionUID = 1L;
	GraficaLinealDao datosGrafica = new GraficaLinealDao();
	List<BeanGraficaVo> lista = new ArrayList<BeanGraficaVo>();
	private String semana;
	private String mes;
	private String anio;
	
	public String getDatosGraficaSemana(){
//		logger.info("GraficaLinealAction.getDatosGraficaSemana()");
		String resultAction=SUCCESS;
		ServiceResponse result = new ServiceResponse();
		
		
		try {
			ServiceResponse resDet = new ServiceResponse();
			resDet=datosGrafica.getDatosGraficaSemana(getSemana(),getAnio());
			
//			logger.info("### resultado action es ----"+resDet);
			
			if (resDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(resDet.getMensaje());
				result.setResult(resDet.getResult());
				System.out.println("inicio de if");
			} else {
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(resDet.getMensaje());

			}
		} catch (Exception e) {
			// TODO: handle exception
			setActionError("error al consultar datos a graficar");
			resultAction="## ERRORPAGE!";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println("fin metodo semana");
		return null;
	}
// -------------###############  CONSULTA POR MES -------------------
	public String getDatosGraficaMes(){
//		logger.info("GraficaLinealAction.getDatosGraficaMes()");
//		logger.info("mes: "+getMes()+" anio: "+getAnio());
		String resultAction=SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse resDet = new ServiceResponse();
			resDet=datosGrafica.getDatosGraficaMes(getMes(),getAnio());
			if (resDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(resDet.getMensaje());
				result.setResult(resDet.getResult());
				
			} else {
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(resDet.getMensaje());

			}
		} catch (Exception e) {
			// TODO: handle exception
			setActionError("error al consultar datos a graficar");
			resultAction="## ERRORPAGE!";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println("fin metodo mes");
		return null;
	}
	
	
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getSemana() {
		return semana;
	}
	public void setSemana(String semana) {
		this.semana = semana;
	}

}
