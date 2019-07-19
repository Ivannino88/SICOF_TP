package com.mx.totalplay.struts.action;

import com.mx.totalplay.dao.XdemoDAO;
import com.mx.totalplay.vo.ServiceResponse;
import com.opensymphony.xwork2.ActionSupport;

public class Xdemo extends CifrasControlAction{
	
	/**
	 * 
	 */
	
	private String cadena;
	private static final long serialVersionUID = 1L;
	XdemoDAO xdemoDAO = new XdemoDAO();
	public String obtenerCadena(){
//		System.out.println("Xdemo.obtenerCadena()");
		ServiceResponse respDet = new ServiceResponse();
//		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		respDet=xdemoDAO.valuarCadenaDao(getCadena());
//	cadena="cadena ok";
		return "success";
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

}
