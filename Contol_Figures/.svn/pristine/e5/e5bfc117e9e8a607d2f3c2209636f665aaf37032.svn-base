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

public class CtasActBRMvsIMSAction extends CifrasControlAction{

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(CtasActBRMvsIMSAction.class);
	CtasActBRMvsU2000DAO ctasActBRMvsU2000DAO = new CtasActBRMvsU2000DAO();
	private String fecha;
	private String fechaReporte;
	private String reportFile;
	private InputStream inputStream;
	private String fechatabla;
	
	private String filtro;
	
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
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
	
	public String getFechatabla() {
		return fechatabla;
	}

	public void setFechatabla(String fechatabla) {
		Conversor conver=new Conversor();
		this.fechatabla =conver.conversor(fechatabla);
	}
	
	ServiceResponse result = new ServiceResponse();
// ************************************* BRM VS IMS ************************************
// *************************************************************************************
	
	public String getReporteBRMvsIMS() {
	//	logger.debug("***Action getReporteBRMvsIMS(Fecha: " + fecha + ")");

		CtasActBRMvsU2000VO ctasActBrmVO = new CtasActBRMvsU2000VO();
		// ctasActBrmVO.setFecha("07/06/17");
		ctasActBrmVO.setFecha(getFecha());
		ctasActBrmVO.setTipo_conciliacion("1");
		try {
			result = ctasActBRMvsU2000DAO.getCtasActBRMvsIMS(ctasActBrmVO);
			if (result.isSuccess()) {
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(true);
			} else {
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(false);
			}
		} catch (Exception e) {
		//	logger.error("Action getCtasActBRMvsU2000>>>" + e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}

	/***
	 * JRMM EXPORTAR DETALLE Cuentas Activas BRM vs IMS aqui
	 */
	
	@SuppressWarnings("unused")
	public String exportDetalleReporteBRMvsIMSdetailTablaJson(){		
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
//		System.out.println("----*** json* #1***--"+getFechatabla());
		try {
			ServiceResponse respDet = new ServiceResponse();
//			if (getFiltro().equals("total")){
//				respDet = ctasActBRMvsU2000DAO.getDetallebrmnoimsJson(getFechatabla());		
//			}else{
//				respDet = ctasActBRMvsU2000DAO.getDetallebrmnoimsJsonFiltro(getFechatabla(), getFiltro());
//			}
			respDet = ctasActBRMvsU2000DAO.getDetallebrmnoimsJson(getFechatabla());		
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
	
	@SuppressWarnings("unused")
	public String exportDetalleReporteBRMvsIMSdetailTablaJson2(){
//		System.out.println("----*** json* #2--"+getFechatabla());
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();			
			respDet = ctasActBRMvsU2000DAO.getDetalleimsnobrmJson(getFechatabla());			
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

	
	@SuppressWarnings({ "unused" })
	public String exportDetalleReporteBRMvsIMSdetail() {
	//	logger.debug("*********Action: exportDetalleDetalleNoBrmIptvDetails()");
		
		
		try {
			XSSFWorkbook myWorkBook = new XSSFWorkbook();
			XSSFSheet mySheet = myWorkBook.createSheet("Detalle BRM NO IMS");
			XSSFSheet mySheetIPTV = myWorkBook.createSheet("Detalle IMS NO BRM");
			
			Calendar calendar = Calendar.getInstance();


			String reportFile = "CuentasActivasBRMvsIMS"+ calendar.get(Calendar.YEAR) + "-"+ calendar.get(Calendar.MONTH) + "-"+ calendar.get(Calendar.DAY_OF_MONTH) + "".concat(".xlsx");
			setDetailedAllInfo(myWorkBook,mySheet, (List<cuentasactivasbrmvsimsVO>) ctasActBRMvsU2000DAO.getDetallebrmnoims(getFecha()));
			setDetailedAllInfoIptv(myWorkBook,mySheetIPTV, (List<cuentasactivasimsvsbrmVO>) ctasActBRMvsU2000DAO.getDetalleimsnobrm(getFecha()));

			try {
				ByteArrayOutputStream boas = new ByteArrayOutputStream();
				if(boas!=null)
				boas.close();
				myWorkBook.write(boas);
				setInputStream(new ByteArrayInputStream(boas.toByteArray()));
				
				
				if(boas!=null)
		            boas.close();
				
			} catch (Exception e) {
			//	logger.error(e.getCause());
			}
		} catch (Exception e) {
		//	e.printStackTrace();
		}
	//	logger.debug("Termino todo");
		return SUCCESS;
	}


	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<cuentasactivasbrmvsimsVO> detalleBeans) {
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

		final String[] errorSource = { "Fecha", "Cuenta","Plan","DN","TMCODE", ""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Cuentas Activas BRM vs IMS");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
			
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellStyle(headstyle);
			monthCell = header.createCell(1);
			monthCell.setCellValue("Detalle BRM NO IMS");
			monthCell.setCellStyle(headstyle);
			monthCell = header.createCell(2);
			monthCell.setCellStyle(headstyle);
			monthCell = header.createCell(3);
			monthCell.setCellStyle(headstyle);
			monthCell = header.createCell(4);
			monthCell.setCellStyle(headstyle);
			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
				
			}
		//	logger.debug("Termino el Titulo de registros");
			for (cuentasactivasbrmvsimsVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getCuenta());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getPlan());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getDn());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getTmcode());
				monthCell.setCellStyle(cellstyle);
			}
		} catch (Exception e) {
		//	e.printStackTrace();
		}

	}

	

	@SuppressWarnings("deprecation")
	private void setDetailedAllInfoIptv(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<cuentasactivasimsvsbrmVO> detalleBeans) {
		int rowNum = 3;
		XSSFRow myRow = null;
		//logger.debug("detalleBeans.size(): "+ detalleBeans.size());
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
		        
		final String[] errorSource = { "Fecha", "DN", "" };
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Cuentas Activas BRM vs IMS");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellStyle(headstyle);
			monthCell = header.createCell(1);
			monthCell.setCellValue("Detalle IMS NO BRM");
			monthCell.setCellStyle(headstyle);
			
			
			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				 monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
				
			}
		//	logger.debug("Termino el Titulo de registros");
			for (cuentasactivasimsvsbrmVO detalleBean : detalleBeans) {
//				logger.debug(detalleBean.toString());
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getDn());
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


}
