package com.mx.totalplay.struts.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;
/**
 * Clase Struts2 
 * @author  
 * Mexico Octubre 2016
 */
public class CifrasControlAction extends ActionSupport implements SessionAware, ParameterNameAware{
	//Session care
	protected Map<String, Object> session ;
	private static final Logger logger = Logger.getLogger(CifrasControlAction.class);
	private static final long serialVersionUID = 1L;
	private String actionError;
	public String getActionError() {
		return actionError;
	}
	public void setActionError(String actionError) {
		this.actionError = actionError;
	}
	
	

	@Override
	public String execute() throws Exception{
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
	    	  response.getWriter().write(jsonResult);
		} catch (IOException e) {
		//	System.out.println("Imposible generar la respuesta. Error: " + e.getMessage());
		}
	}
	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) {					 
		this.session = session ;	
	}
	/* (non-Javadoc)
	 * Se implementa este método para prevenir que pidan un parámetro de nombre session
	 */
	@Override
	public boolean acceptableParameterName(String parameterName) {	     
	    boolean allowedParameterName = true ;	     
	    if ( parameterName.contains("session")  || parameterName.contains("request") ) {	     
	        allowedParameterName = false ;	         
	    } 	     
	    return allowedParameterName;
	}	
}