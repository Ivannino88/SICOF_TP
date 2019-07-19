package com.mx.totalplay.struts.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.mx.totalplay.dao.LimiteDeCreditoDAO;
import com.mx.totalplay.vo.LimiteDeCreditoVO;

public class LimiteDeCreditoAction extends CifrasControlAction {

	
	private static final long serialVersionUID = 1L;
//	private String status;
	
	LimiteDeCreditoDAO consulta = new LimiteDeCreditoDAO();
	List<LimiteDeCreditoVO> lista = new ArrayList<LimiteDeCreditoVO>(); 
	
	public String getLimiteCredito(){
//		System.out.println("LimiteDeCreditoAction.getLimiteCredito()");
		String result;
		lista=consulta.getLimiteDeCredito();
		Gson json=new Gson();
		result=json.toJson(lista);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("json #-> "+result);
		return null;
	}
}
