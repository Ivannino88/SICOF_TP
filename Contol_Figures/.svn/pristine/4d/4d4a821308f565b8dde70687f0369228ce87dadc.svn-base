package com.mx.totalplay.struts.action;

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
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFBorderFormatting;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.mx.totalplay.dao.RhProyectoSinTransaccionesModalDao;
import com.mx.totalplay.vo.RhProyectoSinTransaccionesModalDetailVO;
import com.mx.totalplay.vo.RhProyectoSinTransaccionesModalVO;
import com.mx.totalplay.vo.RhProyectoSinTransaccionesVO;
import com.mx.totalplay.vo.ServiceResponse;

public class RhProyectoSinTransaccionesActionModal extends CifrasControlAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RhProyectoSinTransaccionesActionModal.class);
	RhProyectoSinTransaccionesModalDao RhProyectoSinTransaccionesModal=new RhProyectoSinTransaccionesModalDao();
	private String semana;
	private String anio;
	private String id;
	private String idconciliacion;
	private String idempleado;
	private InputStream inputStream;
	private String reportFile;
//	private String p1;
//	private String p2;
//	private String p3;
//	private String p4;
	
	private List<String> listaArray;
//	List<String> puestos = new ArrayList<String>();
	private List<RhProyectoSinTransaccionesModalVO> listaPuesto = new ArrayList<RhProyectoSinTransaccionesModalVO>();
	
	private String seleccion;
	// --------------- CONSULTA 1 ------------------------		
	@SuppressWarnings("unused")
	public String getRhProyectoSinTransaccionesModal(){
		System.out.println("consulta 1");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = RhProyectoSinTransaccionesModal.getRhProyectoSinTransaccionesModal(getSemana(),getAnio(),getId());
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
			} else {
//				logger.error("getRhProyectoSinTransaccionesModal ERROR");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}
		}catch (Exception e) {
//			logger.error("getRhProyectoSinTransaccionesModal, ###ERROR### " + e);
			setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
			resultAction = "ERRORPAGE";
		}
		//logger.info("result.mensaje: " + result.getMensaje());
		//logger.info("result.result: " + result.getResult());
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println("fin consulta 1");
		return null;
	}
	//°°°°°°°°°°°°°°°°°°°°°°°°°°°° OBTENER JSON PARA EL MENU°°°°°°°°°°°°°°°°°
/*	
	public String getPuesto(){
		
		System.out.println("obtenerPuesto()");
		String result;
		listaPuesto=RhProyectoSinTransaccionesModal.getPuestosLista();
		System.out.println("lista -->#"+listaPuesto);
		Gson json = new Gson();
		result=json.toJson(listaPuesto);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("JSON->"+result);
		return null;
	}
*/	
	
	// --------------- SELECT PUESTOS Y GET RESULTADO ------------------------		
		@SuppressWarnings("unused")
		public String getPuestoModal(){
			System.out.println("Action_.getPuestoModal()");
			String resultAction = SUCCESS;
			ServiceResponse result = new ServiceResponse();
			try {
				ServiceResponse respDet = new ServiceResponse();
				respDet = RhProyectoSinTransaccionesModal.getConsultaPuestoSelect(getSeleccion(),getSemana(),getAnio());
				if (respDet.isSuccess()) {
					result.setSuccess(true);
					result.setMensaje(respDet.getMensaje());
					result.setResult(respDet.getResult());
				} else {
//					logger.error("getRhProyectoSinTransaccionesModal ERROR");
					result.setSuccess(false);
					result.setResult(null);
					result.setMensaje(respDet.getMensaje());
				}
			}catch (Exception e) {
//				logger.error("getRhProyectoSinTransaccionesModal, ###ERROR### " + e);
				setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
				resultAction = "ERRORPAGE";
			}
			//logger.info("result.mensaje: " + result.getMensaje());
			//logger.info("result.result: " + result.getResult());
			sendJSONObjectToResponse(result);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println("fin consulta 1");
			listaPuesto=RhProyectoSinTransaccionesModal.getPuestoDemo(getSeleccion(),getSemana(),getAnio());
			return null;
		}
 
	
// --------------- CONSULTA 2 ------------------------	
	@SuppressWarnings("unused")
	public String getRhProyectoSinTransaccionesModalDetail(){
	System.out.println("consulta 2");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		//logger.info("getId(): " + getId());
		//logger.info("getId(): " + getId() + " getIdconciliacion(): " + getIdconciliacion());
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = RhProyectoSinTransaccionesModal.getRhProyectoSinTransaccionesModalDetail(getId(), getIdconciliacion());
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
			} else {
//				logger.error("getRhProyectoSinTransaccionesModal ERROR");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}
		}catch (Exception e) {
//			logger.error("getRhProyectoSinTransaccionesModal, ###ERROR### " + e);
			setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
			resultAction = "ERRORPAGE";
		}
		//logger.info("result.mensaje: " + result.getMensaje());
		//logger.info("result.result: " + result.getResult());
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
// --------------- LLAMADO A EXCEL  ------------------------		
	@SuppressWarnings({ "unused", "unchecked" })
	public String exportDetalleRhProyectoSinTransaccionesModalDetail() {
		XSSFWorkbook myWorkBook = new XSSFWorkbook();
		XSSFSheet mySheet = myWorkBook.createSheet("DETALLE_EMPLEADO");		
		
		try {
			Calendar calendar = Calendar.getInstance();
			//logger.info("exportDetalleRhProyectoSinTransaccionesModalDetail");
			//logger.info("getIdempleado(): " + getIdempleado() + " getCon(): " + getIdconciliacion());
			
			ServiceResponse detalleBeans1 = RhProyectoSinTransaccionesModal.getRhProyectoSinTransaccionesModalDetail(getIdempleado(), getIdconciliacion());
			
			
			String reportFile = "Rh_ProyectoSinTransaccionesDetalleEmpleado.xlsx";
			
			setModalDetail(myWorkBook,mySheet, (List<RhProyectoSinTransaccionesModalDetailVO>) detalleBeans1.getResult());
			
		
			try {
				ByteArrayOutputStream boas = new ByteArrayOutputStream();
				if(boas!=null)
				boas.close();
				myWorkBook.write(boas);
				setInputStream(new ByteArrayInputStream(boas.toByteArray()));
				
				
				if(boas!=null)
		            boas.close();
				
			} catch (Exception e) {
//				e.printStackTrace();
			}
		}catch (Exception e) {
//				e.printStackTrace();
			}
		return SUCCESS;
		}
// ---------- CREACION DE EXCEL ------------------	
	@SuppressWarnings("deprecation")
	private void setModalDetail(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<RhProyectoSinTransaccionesModalDetailVO> detalleBeans) {
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

        
        
		final String[] errorSource = {"Fecha","Semana","No. Empleado", "Situación","Nombre","Centro de Costos","Puesto","Area Nómina Desc", "Fecha de Actividad"};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("RH Transaccionalidad de empleados - Detalle");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,8));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle - Empleado");
			monthCell.setCellStyle(headstyle);
			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,8));
			for (RhProyectoSinTransaccionesModalDetailVO detalleBean : detalleBeans) {
				//logger.info("detalleBean.getIdconciliacion(): " + detalleBean.getIdconciliacion());
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getSemana());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getNoempleado());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getSituacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getNombre());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getCentrocostos());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getPuesto());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(detalleBean.getAreanominadesc());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(8).setCellValue(detalleBean.getFechaactividad());
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
//			e.printStackTrace();
		}
	}
	
// ---------- CREACION DE LIBROS EXCEL ------------------	
	@SuppressWarnings({ "unused", "unchecked" })
	public String exportDetalleRhProyectoSinTransaccionesModal() {
		XSSFWorkbook myWorkBook = new XSSFWorkbook();
		XSSFSheet mySheet = myWorkBook.createSheet("TRANSACCIONALIDAD_ALTA");
		XSSFSheet mySheet2 = myWorkBook.createSheet("TRANSACCIONALIDAD_MEDIA");
		XSSFSheet mySheet3 = myWorkBook.createSheet("TRANSACCIONALIDAD_BAJA");
		
		
		try {
			Calendar calendar = Calendar.getInstance();
			ServiceResponse detalleBeans1 = RhProyectoSinTransaccionesModal.getRhProyectoSinTransaccionesModalDetalleV(getSemana(),getAnio(),getId());
			ServiceResponse detalleBeans2 = RhProyectoSinTransaccionesModal.getRhProyectoSinTransaccionesModalDetalleA(getSemana(),getAnio(),getId());
			ServiceResponse detalleBeans3 = RhProyectoSinTransaccionesModal.getRhProyectoSinTransaccionesModalDetalleR(getSemana(),getAnio(),getId());
			
			
			String reportFile = "Rh_ProyectoSinTransacciones.xlsx";
			
			setDetailedAllInfo(myWorkBook,mySheet, (List<RhProyectoSinTransaccionesModalVO>) detalleBeans1.getResult());
			setDetailedAllInfo2(myWorkBook,mySheet2, (List<RhProyectoSinTransaccionesModalVO>) detalleBeans2.getResult());
			setDetailedAllInfo3(myWorkBook,mySheet3, (List<RhProyectoSinTransaccionesModalVO>) detalleBeans3.getResult());
		
			try {
				ByteArrayOutputStream boas = new ByteArrayOutputStream();
				boas.close();
				myWorkBook.write(boas);
				setInputStream(new ByteArrayInputStream(boas.toByteArray()));
				
				
				if(boas!=null)
		            boas.close();
				
			} catch (Exception e) {
//				e.printStackTrace();
			}
		}catch (Exception e) {
//				e.printStackTrace();
			}
		return SUCCESS;
		}
// ---------- CREACION DE EXCEL ------------------	
	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<RhProyectoSinTransaccionesModalVO> detalleBeans) {
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

        
        
		final String[] errorSource = { "No. Empleado", "Situación","Nombre","Centro de Costos","Puesto","Area Nómina Desc","Semana","Año",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("RH Transaccionalidad de empleados - Detalle");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,7));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Transaccionalidad - Alta");
			monthCell.setCellStyle(headstyle);
			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,7));
			for (RhProyectoSinTransaccionesModalVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getNoempleado());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getSituacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getNombre());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getCentrocostos());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getPuesto());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getAreanominadesc());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(getSemana());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(getAnio());
				monthCell.setCellStyle(cellstyle);
			}
			
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}
	
// ---------- CREACION DE EXCEL ------------------	
	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo2(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<RhProyectoSinTransaccionesModalVO> detalleBeans) {
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
        
		final String[] errorSource = { "No. Empleado", "Situación","Nombre","Centro de Costos","Puesto","Area Nómina Desc","Semana","Año",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("RH Transaccionalidad de empleados - Detalle");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,7));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Transaccionalidad - Media");
			monthCell.setCellStyle(headstyle);
			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,7));
			for (RhProyectoSinTransaccionesModalVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getNoempleado());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getSituacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getNombre());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getCentrocostos());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getPuesto());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getAreanominadesc());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(getSemana());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(getAnio());
				monthCell.setCellStyle(cellstyle);
				
			}
			
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	
// ---------- CREACION DE EXCEL ------------------
	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo3(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<RhProyectoSinTransaccionesModalVO> detalleBeans) {
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
        
		final String[] errorSource = { "No. Empleado", "Situación","Nombre","Centro de Costos","Puesto","Area Nómina Desc","Semana","Año",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("RH Transaccionalidad de empleados - Detalle");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,7));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Transaccionalidad - Baja");
			monthCell.setCellStyle(headstyle);
			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,7));
			for (RhProyectoSinTransaccionesModalVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getNoempleado());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getSituacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getNombre());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getCentrocostos());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getPuesto());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getAreanominadesc());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(getSemana());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(getAnio());
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
//			e.printStackTrace();
		}
	}

	
// -- GETTERS Y SETTERS ----------
	public InputStream getInputStream() { 	return inputStream;	}
	public void setInputStream(InputStream inputStream) { 	this.inputStream = inputStream; 	}
	public String getReportFile() {  return reportFile; 	}
	public void setReportFile(String reportFile) { 	this.reportFile = reportFile; 	}
	public String getSemana() {     return semana;	}
	public void setSemana(String semana) { 	this.semana = semana; 	}
	public String getAnio() { 	    return anio; 	}
	public void setAnio(String anio) { 		this.anio = anio; 	}
	public String getId() { 		return id; 	}
	public void setId(String id) { 	this.id = id; 	}
	public String getIdconciliacion() { return idconciliacion; 	}
	public void setIdconciliacion(String idconciliacion) { 	this.idconciliacion = idconciliacion; 	}
	public String getIdempleado() { return idempleado; 	}
	public void setIdempleado(String idempleado) { 	this.idempleado = idempleado;	}
	
	public String getSeleccion() { return seleccion; }
	public void setSeleccion(String seleccion) { this.seleccion = seleccion; }
	public List<RhProyectoSinTransaccionesModalVO> getListaPuesto() { return listaPuesto; }
	public void setListaPuesto(List<RhProyectoSinTransaccionesModalVO> listaPuesto) { this.listaPuesto = listaPuesto;}

	public List<String> getListaArray() { return listaArray; }
	public void setListaArray(List<String> listaArray) { this.listaArray = listaArray; }

	
}
