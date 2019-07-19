package com.mx.totalplay.struts.action;

/**
 *
 * Junio 2017
 * ACTION PARA EL REPORTE: 4. Cifra Control Cuentas Activas BRM vs. U2000
 */
import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mx.totalplay.dao.CtasActBRMvsU2000DAO;
import com.mx.totalplay.dao.ControlAccesoDAO;
import com.mx.totalplay.vo.ControlAccesoVO;
import com.mx.totalplay.vo.CtasActBRMvsU2000VO;
import com.mx.totalplay.vo.Detalle2000NoBrmVO;
import com.mx.totalplay.vo.DetalleBrmNoU2000VO;
import com.mx.totalplay.vo.LineasInternasVO;
import com.mx.totalplay.vo.ServiceResponse;
import com.mx.totalplay.vo.cuentasactivasbrmvsimsVO;
import com.mx.totalplay.vo.cuentasactivasimsvsbrmVO;
import com.opensymphony.xwork2.ActionContext;

public class ControlAccesoAction extends CifrasControlAction{
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(ControlAccesoAction.class);
	ControlAccesoDAO controlaccesodao = new ControlAccesoDAO();
	
	private String no_empleado;
	private String idModulo;
	private String json_string;
	private String nombre;
	private String apellido;
	private String last_connection;
	private String id_modulo_desplegable;
	
	
	ServiceResponse result = new ServiceResponse();
// **************************************************************************************
// ****************** CONTROL DE ACCESO (PANTALLA PRINCIPAL) ****************************
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getControlAccesoAction(){
//		System.out.println("ControlAccesoAction.getControlAccesoAction()");
//		logger.info("getNo_empleado(): "+getNo_empleado());
		try{
			result = controlaccesodao.getControlAcceso(getNo_empleado());
//			System.out.println("empleado ----> "+getNo_empleado());
			if(result.isSuccess()){
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(true);
			}else{
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(false);
			}
//			logger.info("result.isSuccess(): "+result.isSuccess());
//			logger.info("result.getMensaje(): "+result.getMensaje());
//			logger.info("result.getResult(): "+result.getResult());
		}catch(Exception e){
//			logger.info("Action getControlAccesoAction: "+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		
		Map session = ActionContext.getContext().getSession();
		session.put("result",result);
		return null;
	}
// **************************************************************************************
// ****************** CONTROL DE ACCESO (MENUS DESPLEGABLES) ****************************
	
	public String getControlAccesoDesplegablesAction(){
		
		sendJSONObjectToResponse(session.get("result"));
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		
		return null;
	}
// *****************************************************************************************	
// ****************** CARGA MODULOS Y CIFRAS PARA ADMINISTRADOR ****************************
	public String getControlAccesoModulosAction(){
		try{
			result = controlaccesodao.getControlAccesoModulos();
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
		//	logger.error("Action getCtasActBRMvsU2000>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		return null;
	}
	
	public String getControlAccesoCifrasAction(){
		try{
			result = controlaccesodao.getControlAccesoCifras(getIdModulo());
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
		//	logger.error("Action getCtasActBRMvsU2000>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		return null;
	}
// ********************************************************************************
// *************** CARGA DATOS DEL EMPLEADO (PARA ADMINISTRADOR) ******************
	public String getControlAccesoBuscaEmpAction(){
		try{
			result = controlaccesodao.getControlAccesoCifrasBuscarEmp(getNo_empleado());
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
		//	logger.error("Action getCtasActBRMvsU2000>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		return null;
	}
// ********************************************************************************
// ********* ACTUALIZA LOS PERMISOS DE EMPLEADO (ADMINISTRADOR) *******************

	@SuppressWarnings("unchecked")
	public String getControlAccesoUpdateAction(){
		
		Gson gson = new Gson();
		Type listType = new TypeToken<List<ControlAccesoVO>>(){}.getType();
		List<ControlAccesoVO> lista = (List<ControlAccesoVO>) gson.fromJson(getJson_string(), listType);
		try{
			result = controlaccesodao.getControlAccesoUpdatePermisos(lista, getNombre(), getApellido(), getNo_empleado());
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
		//	logger.error("Action getCtasActBRMvsU2000>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		return null;
	}
// ********************************************************************************
// *************** INSERTA NUEVO EMPLEADO Y PERMISOS (ADMINISTRADOR) **************
	@SuppressWarnings("unchecked")
	public String getControlAccesoNuevoAction(){
		
		Gson gson = new Gson();
		Type listType = new TypeToken<List<ControlAccesoVO>>(){}.getType();
		List<ControlAccesoVO> lista = (List<ControlAccesoVO>) gson.fromJson(getJson_string(), listType);
		
		try{
			result = controlaccesodao.getControlAccesoNuevoEmp(lista, getNombre(), getApellido(), getNo_empleado());
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
		//	logger.error("Action getCtasActBRMvsU2000>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		return null;
	}
// ********************************************************************************	
// ****************** ELIMINA EMPLEADO Y PERMISOS (ADMIN) *************************
	@SuppressWarnings("unchecked")
	public String getControlAccesoEliminarAction(){
		
		try{
			result = controlaccesodao.getControlAccesoEliminarEmp(getNo_empleado());
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
		//	logger.error("Action getCtasActBRMvsU2000>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		return null;
	}

	
	public String getId_modulo_desplegable() {
		return id_modulo_desplegable;
	}
	public void setId_modulo_desplegable(String id_modulo_desplegable) {
		this.id_modulo_desplegable = id_modulo_desplegable;
	}
	public String getLast_connection() {
		return last_connection;
	}
	public void setLast_connection(String last_connection) {
		this.last_connection = last_connection;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getJson_string() {
		return json_string;
	}
	public void setJson_string(String json_string) {
		this.json_string = json_string;
	}
	public String getNo_empleado() {
		return no_empleado;
	}
	public void setNo_empleado(String no_empleado) {
		this.no_empleado = no_empleado;
	}
	public String getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}
}
