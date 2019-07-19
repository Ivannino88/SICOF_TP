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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.mx.totalplay.dao.CtasActBRMvsU2000DAO;
import com.mx.totalplay.vo.CtasActBRMvsU2000VO;
import com.mx.totalplay.vo.Detalle2000NoBrmVO;
import com.mx.totalplay.vo.DetalleBrmNoU2000VO;
import com.mx.totalplay.vo.ServiceResponse;
import com.mx.totalplay.vo.cuentasactivasbrmvsimsVO;
import com.mx.totalplay.vo.cuentasactivasimsvsbrmVO;

public class CtasActBRMvsU2000Action extends CifrasControlAction{

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(CtasActBRMvsU2000Action.class);
	CtasActBRMvsU2000DAO ctasActBRMvsU2000DAO = new CtasActBRMvsU2000DAO();
	String fecha;
	String fechaReporte;
	private String fechaTabla;
	
	private String filtro;
	
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


	private List<DetalleBrmNoU2000VO> ctasActBRMvsU2000VOList = new ArrayList<DetalleBrmNoU2000VO>();
	@SuppressWarnings("unused")
	private List<Detalle2000NoBrmVO> ctasActBRMvsU2000VOList2 = new ArrayList<Detalle2000NoBrmVO>();
	@SuppressWarnings("unused")
	private List<DetalleBrmNoU2000VO> brmNoU2000SinOnt = new ArrayList<DetalleBrmNoU2000VO>();
	
	private String reportFile;
	private InputStream inputStream;

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
	public List<DetalleBrmNoU2000VO> getCtasActBRMvsU2000VOList() {
		return ctasActBRMvsU2000VOList;
	}

	public void setCtasActBRMvsU2000VOList(List<DetalleBrmNoU2000VO> ctasActBRMvsU2000VOList) {
		this.ctasActBRMvsU2000VOList = ctasActBRMvsU2000VOList;
	}

	public String getReportFile() {
		return reportFile;
	}

	public void setReportFile(String reportFile) {
		this.reportFile = reportFile;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
	public String getFechaTabla() {
		return fechaTabla;
	}

	public void setFechaTabla(String fechaTabla) {
		this.fechaTabla = fechaTabla;
	}



	ServiceResponse result = new ServiceResponse();
// ------------------CONSULTA PRINCIPAL -------------------	
	public String getCtasActBRMvsU2000(){
//		System.out.println("frcha normal:"+getFecha());
		
		CtasActBRMvsU2000VO ctasActBrmVO = new CtasActBRMvsU2000VO();
		ctasActBrmVO.setFecha(getFecha());
		ctasActBrmVO.setTipo_conciliacion("1");

		////logger.debug("Action>getCtasActBRMvsU2000>fecha>" + getFecha());

		try{
			result = ctasActBRMvsU2000DAO.getCtasActBRMvsU2000(ctasActBrmVO);
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
	
	public String exportCtasActivasBRMvsU2000DetailsTPTablaJson(){
//		System.out.println("fecha tabla:"+getFechaTabla());
//		System.out.println(" json* #1");
		try{
			ServiceResponse respDet = new ServiceResponse();
			//logger.info("**getFiltro(): "+getFiltro());
			//logger.info("**getFechaTabla(): "+getFechaTabla());
			if (getFiltro().equals("total")){
				respDet = ctasActBRMvsU2000DAO.detalleCtasActBRMvsU2000(getFechaTabla());
//				System.out.println("---total---");
			}else{
				respDet = ctasActBRMvsU2000DAO.detalleCtasActBRMvsU2000Filtro(getFechaTabla(), getFiltro());
//				System.out.println("--- con filtro --");
			}
			
			if(respDet.isSuccess()){
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				result.setSuccess(true);
			}else{
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				result.setSuccess(false);
			}			
		}catch(Exception e){
		//	logger.error("Action getConciliacionVodBrm>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	public String exportCtasActivasBRMvsU2000DetailsTPTablaJson2(){
		//logger.debug("***Action: getConciliacionVodBrm(Fecha: "+fecha+")");
//		System.out.println(" json* #2");	
		try{
			ServiceResponse respDet = new ServiceResponse();
			if (getFiltro().equals("total")){
				respDet = ctasActBRMvsU2000DAO.detalleCtasActU2000(getFechaTabla());
			}else{
				respDet = ctasActBRMvsU2000DAO.detalleCtasActU2000Filtro(getFechaTabla(), getFiltro());
			}
			
			if(respDet.isSuccess()){
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				result.setSuccess(true);
			}else{
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				result.setSuccess(false);
			}			
		}catch(Exception e){
		//	logger.error("Action getConciliacionVodBrm>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	public String exportCtasActivasBRMvsU2000DetailsTPTablaJson3(){
//		System.out.println(" json* #3");
		try{
			ServiceResponse respDet = new ServiceResponse();
			if (getFiltro().equals("total")){
				respDet = ctasActBRMvsU2000DAO.detalleCtasActU2000SN(getFechaTabla());
			}else{
				respDet = ctasActBRMvsU2000DAO.detalleCtasActU2000SNFiltro(getFechaTabla(), getFiltro());
			}
			
			if(respDet.isSuccess()){
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				result.setSuccess(true);
			}else{
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				result.setSuccess(false);
			}			
		}catch(Exception e){
		//	logger.error("Action getConciliacionVodBrm>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	public String exportCtasActivasBRMvsU2000DetailsTPTablaJson4(){	
//		System.out.println(" json* #4");
		try{
			ServiceResponse respDet = new ServiceResponse();
			if (getFiltro().equals("total")){
				respDet = ctasActBRMvsU2000DAO.detalleCtasActBRMvsU2000sinOnt(getFechaTabla());
			}else{
				respDet = ctasActBRMvsU2000DAO.detalleCtasActBRMvsU2000sinOntFiltro(getFechaTabla(), getFiltro());
			}
			
			if(respDet.isSuccess()){
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				result.setSuccess(true);
			}else{
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				result.setSuccess(false);
			}			
		}catch(Exception e){
		//	logger.error("Action getConciliacionVodBrm>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	
	//   ------------------------- GRAFICA LINEAL----------------------
	private String semana;
	private String mes;
	private String anio;
	// #######---datos por semana	
public String getDatosGraficaSemana(){
//	System.out.println("CtasActBRMvsU2000Action.getDatosGraficaSemana()");
	System.out.println("CtasActBRMvsU2000Action.getCtasActBRMvsU2000()-semana");
	String resultAction = SUCCESS;
			ServiceResponse result = new ServiceResponse();
			try {
				ServiceResponse respDet = new ServiceResponse();
				respDet = ctasActBRMvsU2000DAO.getDatosGraficaSemana(getSemana(),getAnio());
				
				if (respDet.isSuccess()) {
					result.setSuccess(true);
					result.setMensaje(respDet.getMensaje());
					result.setResult(respDet.getResult());
				} else {
					result.setSuccess(false);
					result.setResult(null);
					result.setMensaje(respDet.getMensaje());
				}
			} catch (Exception e) {
				setActionError("Error.");
				resultAction = "ERRORPAGE";
			}
			sendJSONObjectToResponse(result);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			return null;
}
// #######---datos por mes
public String getDatosGraficaMes(){
//	System.out.println("CtasActBRMvsU2000Action.getDatosGraficaMes()");
	System.out.println("CtasActBRMvsU2000Action.getCtasActBRMvsU2000()-mes");
	String resultAction = SUCCESS;
			ServiceResponse result = new ServiceResponse();
			try {
				ServiceResponse respDet = new ServiceResponse();
				respDet = ctasActBRMvsU2000DAO.getDatosGraficaMes(getMes(),getAnio());
				
				if (respDet.isSuccess()) {
					result.setSuccess(true);
					result.setMensaje(respDet.getMensaje());
					result.setResult(respDet.getResult());
				} else {
					result.setSuccess(false);
					result.setResult(null);
					result.setMensaje(respDet.getMensaje());
				}
			} catch (Exception e) {
				setActionError("Error.");
				resultAction = "ERRORPAGE";
			}
			sendJSONObjectToResponse(result);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			return null;
}	
public String getSemana() { return semana; 	}
public void setSemana(String semana) { this.semana = semana;}
public String getMes() { return mes; }
public void setMes(String mes) { this.mes = mes; }
public String getAnio() { return anio; }
public void setAnio(String anio) { this.anio = anio; }
//----------------- FIN GRAFICA LINEAL--------------------------

	
	

	@SuppressWarnings({ "unchecked", "unused" })
	public String exportCtasActivasBRMvsU2000DetailsTP() {
		System.out.println("creacion del excel ....****************************");
		XSSFWorkbook  myWorkBook = new XSSFWorkbook ();
		XSSFSheet  mySheet = myWorkBook.createSheet("DETALLE_BRM_NO_U2000");
		XSSFSheet  mySheetIPTV = myWorkBook.createSheet("DETALLE_2000_NO_BRM");
		XSSFSheet  mySheetSNCUENTA = myWorkBook.createSheet("DETALLE_SN_NO_CUENTA");
		XSSFSheet  mySheetSNCUENTAsinONT = myWorkBook.createSheet("DETALLE_BRM_NO_U2000_SIN_ONT");
		
		try {
			Calendar calendar = Calendar.getInstance();
			ServiceResponse detalleBeans1 = ctasActBRMvsU2000DAO.detalleCtasActBRMvsU2000(getFechaReporte());
			ServiceResponse detalleBeans2 = ctasActBRMvsU2000DAO.detalleCtasActU2000(getFechaReporte());
			ServiceResponse detalleBeans3 = ctasActBRMvsU2000DAO.detalleCtasActU2000SN(getFechaReporte());
			ServiceResponse detalleBeans4 = ctasActBRMvsU2000DAO.detalleCtasActBRMvsU2000sinOnt(getFechaReporte());// #########################
				System.out.println("sin_ont-> ## "+detalleBeans4);
			String reportFile = "Cuentas_Activas_BRMvscCuentas"+ calendar.get(Calendar.YEAR) + "-"+ calendar.get(Calendar.MONTH) + "-"+ calendar.get(Calendar.DAY_OF_MONTH) + "".concat(".xlsx");
			setDetailedAllInfoCtasActBRMU2000( myWorkBook,mySheet, (List<DetalleBrmNoU2000VO>) detalleBeans1.getResult());
			setDetailedAllInfo2000(            myWorkBook,mySheetIPTV, (List<Detalle2000NoBrmVO>) detalleBeans2.getResult());
			setDetailedAllInfoSNCUENTA(        myWorkBook,mySheetSNCUENTA, (List<DetalleBrmNoU2000VO>) detalleBeans3.getResult());
			setDetailedAllInfoSNCUENTASinOnt(  myWorkBook,mySheetSNCUENTAsinONT, (List<DetalleBrmNoU2000VO>) detalleBeans4.getResult());
			System.out.println("NOMBRE DEL REPORTE "+reportFile +   "------------------------------------------------------");

			try {
				ByteArrayOutputStream boas = new ByteArrayOutputStream();
				if(boas!=null)
				boas.close();
				myWorkBook.write(boas);
				setInputStream(new ByteArrayInputStream(boas.toByteArray()));
				
				
				if(boas!=null)
		            boas.close();
			} catch (IOException e) {
			//	e.printStackTrace();
			}
		} catch (Exception e) {
		//	e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings("deprecation")
	private void setDetailedAllInfoCtasActBRMU2000(XSSFWorkbook  myWorkBook,XSSFSheet  mySheet, List<DetalleBrmNoU2000VO> detalleBeans) {
		int rowNum = 3;
		XSSFRow myRow = null;
		//stylo de titulo
		XSSFFont headfont = myWorkBook.createFont();
        headfont.setFontName("Arial");
        headfont.setFontHeightInPoints((short) 12);
        headfont.setColor(new XSSFColor(Color.WHITE));
        headfont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        XSSFCellStyle headstyle = myWorkBook.createCellStyle();
        headstyle.setFont(headfont);
        headstyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        headstyle.setFillForegroundColor(new XSSFColor(Color.decode("#7b03df")));
        headstyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        headstyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        
        XSSFCellStyle headstyle2 = myWorkBook.createCellStyle();
        headstyle2.setFont(headfont);
        headstyle2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        headstyle2.setFillForegroundColor(new XSSFColor(Color.decode("#489dfa")));
        headstyle2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        headstyle2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
       
        headstyle2.setBorderTop(XSSFCellStyle.BORDER_THIN);
        headstyle2.setTopBorderColor(HSSFColor.WHITE.index);
        headstyle2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        headstyle2.setLeftBorderColor(HSSFColor.WHITE.index);
        headstyle2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        headstyle2.setLeftBorderColor(HSSFColor.WHITE.index);
        headstyle2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        headstyle2.setBottomBorderColor(HSSFColor.WHITE.index);
        
      //stylo de celda
        XSSFFont cellfont = myWorkBook.createFont();
      	cellfont.setFontName("Arial");
      	cellfont.setFontHeightInPoints((short) 10);
      	cellfont.setColor(new XSSFColor(Color.BLACK));
      	cellfont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        XSSFCellStyle cellstyle = myWorkBook.createCellStyle();
        cellstyle.setFont(cellfont);
        
		final String[] errorSource = { "Id", "Fecha Conciliación", "Cuenta", "Empresa", "Plan", "SN", "Status de Cuenta",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Cuentas activas BRM VS U2000, IPTV, IMS - BRM");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle Cuentas Activas BRM U2000 TP");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);			
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,6));
			for (DetalleBrmNoU2000VO detalleBean : detalleBeans) {
				
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getId_conciliacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getFecha_conciliacion().substring(0, 11));
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getCuenta());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getEmpresa());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getPlan());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getSn());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getStatus_cuenta());
				monthCell.setCellStyle(cellstyle);
			}
		} catch (Exception e) {
		//	e.printStackTrace();
		}

	}
	
	
	
	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo2000(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<Detalle2000NoBrmVO> detalleBeans) {
		int rowNum = 3;
		XSSFRow myRow = null;
		
		//stylo de titulo
				XSSFFont headfont = myWorkBook.createFont();
		        headfont.setFontName("Arial");
		        headfont.setFontHeightInPoints((short) 12);
		        headfont.setColor(new XSSFColor(Color.WHITE));
		        headfont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		        XSSFCellStyle headstyle = myWorkBook.createCellStyle();
		        headstyle.setFont(headfont);
		        headstyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		        headstyle.setFillForegroundColor(new XSSFColor(Color.decode("#7b03df")));
		        headstyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		        headstyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		        
		        XSSFCellStyle headstyle2 = myWorkBook.createCellStyle();
		        headstyle2.setFont(headfont);
		        headstyle2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		        headstyle2.setFillForegroundColor(new XSSFColor(Color.decode("#489dfa")));
		        headstyle2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		        headstyle2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		       
		        headstyle2.setBorderTop(XSSFCellStyle.BORDER_THIN);
		        headstyle2.setTopBorderColor(HSSFColor.WHITE.index);
		        headstyle2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		        headstyle2.setLeftBorderColor(HSSFColor.WHITE.index);
		        headstyle2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		        headstyle2.setLeftBorderColor(HSSFColor.WHITE.index);
		        headstyle2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		        headstyle2.setBottomBorderColor(HSSFColor.WHITE.index);
		        
		      //stylo de celda
		        XSSFFont cellfont = myWorkBook.createFont();
		      	cellfont.setFontName("Arial");
		      	cellfont.setFontHeightInPoints((short) 10);
		      	cellfont.setColor(new XSSFColor(Color.BLACK));
		      	cellfont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		        XSSFCellStyle cellstyle = myWorkBook.createCellStyle();
		        cellstyle.setFont(cellfont);
		        
		final String[] errorSource = { "Fecha Conciliación", "Cuenta", "Empresa","Nombre","SN","Nombre ONT", "Etiqueta","" };
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Cuentas Activas U2000 vs BRM");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				 monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
			
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,6));
			for (Detalle2000NoBrmVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getFecha_conciliacion().substring(0, 11));
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getCuenta());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getEmpresa());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getNombre());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getSn());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getNombreont());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getEtiqueta());
				monthCell.setCellStyle(cellstyle);

			}
		} catch (Exception e) {
		//	e.printStackTrace();
		}

	}
	@SuppressWarnings("deprecation")
	private void setDetailedAllInfoSNCUENTA(XSSFWorkbook  myWorkBook,XSSFSheet  mySheet, List<DetalleBrmNoU2000VO> detalleBeans) {
		int rowNum = 3;
		XSSFRow myRow = null;
		//stylo de titulo
		XSSFFont headfont = myWorkBook.createFont();
        headfont.setFontName("Arial");
        headfont.setFontHeightInPoints((short) 12);
        headfont.setColor(new XSSFColor(Color.WHITE));
        headfont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        XSSFCellStyle headstyle = myWorkBook.createCellStyle();
        headstyle.setFont(headfont);
        headstyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        headstyle.setFillForegroundColor(new XSSFColor(Color.decode("#7b03df")));
        headstyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        headstyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        
        XSSFCellStyle headstyle2 = myWorkBook.createCellStyle();
        headstyle2.setFont(headfont);
        headstyle2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        headstyle2.setFillForegroundColor(new XSSFColor(Color.decode("#489dfa")));
        headstyle2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        headstyle2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
       
        headstyle2.setBorderTop(XSSFCellStyle.BORDER_THIN);
        headstyle2.setTopBorderColor(HSSFColor.WHITE.index);
        headstyle2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        headstyle2.setLeftBorderColor(HSSFColor.WHITE.index);
        headstyle2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        headstyle2.setLeftBorderColor(HSSFColor.WHITE.index);
        headstyle2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        headstyle2.setBottomBorderColor(HSSFColor.WHITE.index);
        
      //stylo de celda
        XSSFFont cellfont = myWorkBook.createFont();
      	cellfont.setFontName("Arial");
      	cellfont.setFontHeightInPoints((short) 10);
      	cellfont.setColor(new XSSFColor(Color.BLACK));
      	cellfont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        XSSFCellStyle cellstyle = myWorkBook.createCellStyle();
        cellstyle.setFont(cellfont);
        
		final String[] errorSource = { "Id", "Fecha Conciliación", "Cuenta", "Empresa", "Plan", "SN", "Status de Cuenta",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Cuentas activas BRM VS U2000");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle de No. De Serie que se encuentran en las dos Bases con diferente Cuenta");
			monthCell.setCellStyle(headstyle);

			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
			
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,6));
			for (DetalleBrmNoU2000VO detalleBean : detalleBeans) {
				
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getId_conciliacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getFecha_conciliacion().substring(0, 11));
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getCuenta());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getEmpresa());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getPlan());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getSn());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getStatus_cuenta());
				monthCell.setCellStyle(cellstyle);
			}
			for (int i = 0; i < myWorkBook.getNumberOfSheets(); i++) {
	            XSSFSheet thisSheet = myWorkBook.getSheetAt(i);
	            XSSFRow rowexcel = thisSheet.getRow(thisSheet.getLastRowNum());
	            for (short j = 0; j < rowexcel.getLastCellNum(); j++) {
	            	myWorkBook.getSheetAt(i).autoSizeColumn(j);
	            }
	            // Freezing the top row
	            myWorkBook.getSheetAt(i).createFreezePane(0, 1);
			}
		} catch (Exception e) {
		//	e.printStackTrace();
		}

	}
	
	@SuppressWarnings("deprecation")
	private void setDetailedAllInfoSNCUENTASinOnt(XSSFWorkbook  myWorkBook,XSSFSheet  mySheet, List<DetalleBrmNoU2000VO> detalleBeans) {
		int rowNum = 3;
		XSSFRow myRow = null;
		//stylo de titulo
		XSSFFont headfont = myWorkBook.createFont();
        headfont.setFontName("Arial");
        headfont.setFontHeightInPoints((short) 12);
        headfont.setColor(new XSSFColor(Color.WHITE));
        headfont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        XSSFCellStyle headstyle = myWorkBook.createCellStyle();
        headstyle.setFont(headfont);
        headstyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        headstyle.setFillForegroundColor(new XSSFColor(Color.decode("#7b03df")));
        headstyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        headstyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        
        XSSFCellStyle headstyle2 = myWorkBook.createCellStyle();
        headstyle2.setFont(headfont);
        headstyle2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        headstyle2.setFillForegroundColor(new XSSFColor(Color.decode("#489dfa")));
        headstyle2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        headstyle2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
       
        headstyle2.setBorderTop(XSSFCellStyle.BORDER_THIN);
        headstyle2.setTopBorderColor(HSSFColor.WHITE.index);
        headstyle2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        headstyle2.setLeftBorderColor(HSSFColor.WHITE.index);
        headstyle2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        headstyle2.setLeftBorderColor(HSSFColor.WHITE.index);
        headstyle2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        headstyle2.setBottomBorderColor(HSSFColor.WHITE.index);
        
      //stylo de celda
        XSSFFont cellfont = myWorkBook.createFont();
      	cellfont.setFontName("Arial");
      	cellfont.setFontHeightInPoints((short) 10);
      	cellfont.setColor(new XSSFColor(Color.BLACK));
      	cellfont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        XSSFCellStyle cellstyle = myWorkBook.createCellStyle();
        cellstyle.setFont(cellfont);
        
		final String[] errorSource = { "Id", "Fecha Conciliación", "Cuenta", "Empresa", "Plan", "SN", "Status de Cuenta",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Cuentas activas BRM VS U2000 SIN ONT");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("-> Detalle Cuentas Activas BRM U2000 <- ");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);			
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,6));
			for (DetalleBrmNoU2000VO detalleBean : detalleBeans) {
				
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getId_conciliacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getFecha_conciliacion().substring(0, 11));
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getCuenta());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getEmpresa());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getPlan());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getSn());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getStatus_cuenta());
				monthCell.setCellStyle(cellstyle);
			}
		} catch (Exception e) {
		//	e.printStackTrace();
		}

	}

	public List<DetalleBrmNoU2000VO> getBrmNoU2000SinOnt() {
		return brmNoU2000SinOnt;
	}

	public void setBrmNoU2000SinOnt(List<DetalleBrmNoU2000VO> brmNoU2000SinOnt) {
		this.brmNoU2000SinOnt = brmNoU2000SinOnt;
	}
	


}
