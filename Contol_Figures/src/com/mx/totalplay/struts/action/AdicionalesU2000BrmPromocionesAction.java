package com.mx.totalplay.struts.action;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFFont;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.hssf.util.CellRangeAddress;
//import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;

import com.mx.totalplay.dao.AdicionalesU2000BrmDAO;
import com.mx.totalplay.dao.AdicionalesU2000BrmPromocionesDAO;
import com.mx.totalplay.vo.AdicionalesU2000BrmVO;
import com.mx.totalplay.vo.DetalleAddonsBrmNoU2000VO;
import com.mx.totalplay.vo.DetalleAddonsU2000NoBrmVO;
import com.mx.totalplay.vo.ServiceResponse;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

public class AdicionalesU2000BrmPromocionesAction extends CifrasControlAction{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdicionalesU2000BrmPromocionesAction.class);
	String fecha;
	String fechaReporte;
	String opcion;
	
	String paquete;
	String megas_bajada;
	String poid;
	String producto;
	String megas;
	
	public String getPoid() {
		return poid;
	}
	public void setPoid(String poid) {
		this.poid = poid;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getMegas() {
		return megas;
	}
	public void setMegas(String megas) {
		this.megas = megas;
	}
	public String getPaquete() {
		return paquete;
	}
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
	public String getMegas_bajada() {
		return megas_bajada;
	}
	public void setMegas_bajada(String megas_bajada) {
		this.megas_bajada = megas_bajada;
	}
	public String getOpcion() {
		return opcion;
	}
	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		Conversor conver=new Conversor();
		this.fecha=conver.conversor(fecha);
	}
	public String getFechaReporte() {
		return fechaReporte;
	}
	public void setFechaReporte(String fechaReporte) {
		Conversor conver=new Conversor();
		this.fechaReporte=conver.conversor(fechaReporte);
	}

	ServiceResponse result = new ServiceResponse();
	
	AdicionalesU2000BrmPromocionesDAO promociones=new AdicionalesU2000BrmPromocionesDAO();
	public String getConciliacionAddonsBrmPromocionesU2000(){
		
		AdicionalesU2000BrmVO ctasActBrmVO = new AdicionalesU2000BrmVO();
		ctasActBrmVO.setFecha(getFecha());	
		ctasActBrmVO.setTipo_conciliacion("1");
				
		try{
			result = promociones.getPromocionesAddonsBrmU2000(getOpcion());
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
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	
	public String insertarAdicionalesU2000BrmPromociones(){
		ServiceResponse result = new ServiceResponse();
		
		try{
			opcion=getOpcion();
			//logger.info("Action Opcion: "+opcion+" poid: "+ getPoid()+" producto: "+getProducto()+" megas: "+getMegas()+" paquete: "+getPaquete()+" megas_bajada: "+getMegas_bajada());
			if(opcion.equals("1"))				
				result = promociones.InsertarAdicionalesU2000BrmPromo(getPoid(), getProducto(), getMegas(), opcion);
			if(opcion.equals("2"))				
				result = promociones.InsertarAdicionalesU2000BrmPromo(getPaquete(), getMegas_bajada(), getMegas(), opcion);
			if(opcion.equals("3"))
				result = promociones.InsertarAdicionalesU2000BrmPromo(getPoid(), getProducto(), getMegas(), opcion);
			if(opcion.equals("4"))
				result = promociones.InsertarAdicionalesU2000BrmPromo(getPoid(), getProducto(), getMegas(), opcion);
			
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
			logger.error("Action getConciliacionAddonsBrmU2000>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
}
