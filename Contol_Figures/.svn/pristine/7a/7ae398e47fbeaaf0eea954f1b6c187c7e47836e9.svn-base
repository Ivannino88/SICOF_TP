package com.mx.totalplay.struts.action;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mx.totalplay.dao.EvaluacionTfeDAO;
import com.mx.totalplay.vo.EvaluacionTfeVO;
import com.mx.totalplay.vo.ImpleVO;
import com.mx.totalplay.vo.LineasInternasVO;
import com.mx.totalplay.vo.ServiceResponse;

public class EvaluacionTfeAction extends CifrasControlAction {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CtasActBRMvsU2000LOAction.class);
	EvaluacionTfeDAO evaluacionTfeDAO = new EvaluacionTfeDAO();
	List<ImpleVO> lista = new ArrayList<ImpleVO>();
	ServiceResponse result = new ServiceResponse();
	private File myFile;
	private String tablaResultado;
	private String snVal;
	private String json_string;

	//*************METODOS PARA PREVISUALIZAR EXCEL***********************
		@SuppressWarnings("unused")
		public String getEvaluaTfe_Excel() throws IOException{
			logger.info("EvaluacionTfeAction.getEvaluaTfe_Excel()");
			try{
				result = evaluacionTfeDAO.getEvaluacionTfeExcel(getMyFile());
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
				logger.error("Action getCtasActBRMvsU2000>>>"+e);
			}
			sendJSONObjectToResponse(result);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			return null;
		}
//  CONSULTA PRINCIPAL 		
		public String consultaImplemenPrincipal(){
			logger.info("EvaluacionTfeAction.consultaImplemenPrincipal()");
			String jjson="";
			try {
				result=evaluacionTfeDAO.consultaImplementacionTfe();
				if(result.isSuccess()){
					result.setMensaje(result.getMensaje());
					result.setResult(result.getResult());
					result.setSuccess(true);
				}else{
					result.setMensaje(result.getMensaje());
					result.setResult(result.getResult());
					result.setSuccess(false);
				}		
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			sendJSONObjectToResponse(result);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			Gson json = new Gson();
			jjson=json.toJson(result);
//			System.out.println("json--> ### "+jjson);
			return null;
		}

		
		// INSERTA ELEMENTO
		public String insertaElemento(){
		logger.info("Elemento Sn: "+getSnVal());
			
		evaluacionTfeDAO.guardaUnDato(getSnVal());
			return null;
		}
		
		
// VALIDAR UN DATO SI EXISTE YA NO AGREGAR 		
		
		public String validaDato(){
			logger.info("EvaluacionTfeAction.validaDato()");
//			System.out.println(getSnVal());
			String jjson="";
			try {
				result=evaluacionTfeDAO.validarElemento(getSnVal().trim());
				if(result.isSuccess()){
					result.setMensaje(result.getMensaje());
					result.setResult(result.getResult());
					result.setSuccess(true);
				}else{
					result.setMensaje(result.getMensaje());
					result.setResult(result.getResult());
					result.setSuccess(false);
				}		
			} catch (Exception e) {
				// TODO: handle exception
			}
			sendJSONObjectToResponse(result);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			Gson json = new Gson();
			jjson=json.toJson(result);
//			System.out.println("resultado es"+jjson);
			
			return null;
		}
		
		// ELIMINA TODO
		public String eliminarTodo(){
			logger.info("EvaluacionTfeAction.eliminarTodo()");
			try{
				result = evaluacionTfeDAO.eliminarTodoDao();
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
//				logger.error("Action getCtasActBRMvsU2000>>>"+e);
			}
			sendJSONObjectToResponse(result);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			return null;
		}
		
		// ELIMINA SELECCION DE ELEMENTOS
		@SuppressWarnings("unchecked")
		public String eliminarSeleccion(){
			logger.info("EvaluacionTfeAction.eliminarSeleccion()");
			Gson gson = new Gson();
			Type listType = new TypeToken<List<ImpleVO>>(){}.getType();
			List<ImpleVO> listas = (List<ImpleVO>) gson.fromJson(getJson_string(), listType);
			System.out.println("lista obtenida es: "+listas);
				for (ImpleVO  x: listas) {
					System.out.println("valor: "+x.getSn());
				}
				try{
					result = evaluacionTfeDAO.eliminaElementosSeleccionadosDAO(listas);
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
//					logger.error("Action getCtasActBRMvsU2000>>>"+e);
				}
				sendJSONObjectToResponse(result);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				return null;
		}
		
		
		public String leeTabla(){
			logger.info("EvaluacionTfeAction.leeTabla()");
//			System.out.println("datos puros desde web "+getTablaResultado());
			try {
				evaluacionTfeDAO.guardarDatos(getTablaResultado());	
				if(result.isSuccess()){
					result.setMensaje(result.getMensaje());
					result.setResult(result.getResult());
					result.setSuccess(true);
				}else{
					result.setMensaje(result.getMensaje());
					result.setResult(result.getResult());
					result.setSuccess(false);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			sendJSONObjectToResponse(result);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			return null;
		}
		
		public File getMyFile() { return myFile; }
		public void setMyFile(File myFile) { this.myFile = myFile; }
		public String getTablaResultado() { return tablaResultado; }
		public void setTablaResultado(String tablaResultado) { this.tablaResultado = tablaResultado; }
		public String getSnVal() { return snVal; }
		public void setSnVal(String snVal) { this.snVal = snVal; }
		public String getJson_string() {
			return json_string;
		}
		public void setJson_string(String json_string) {
			this.json_string = json_string;
		}
		
		
		
		
		
}
