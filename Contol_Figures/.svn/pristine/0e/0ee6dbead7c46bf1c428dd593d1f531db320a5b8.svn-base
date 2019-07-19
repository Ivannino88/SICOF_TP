package com.mx.totalplay.struts.action;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;



import org.apache.log4j.Logger;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
//import org.apache.poi.hssf.usermodel.HSSFFont;
//import org.apache.poi.hssf.usermodel.HSSFPatriarch;
//import org.apache.poi.hssf.usermodel.HSSFPicture;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.hssf.util.HSSFColor;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.ClientAnchor;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.util.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.mx.totalplay.dao.AddONSCanalesBRMvsIPTVAdicionalesDAO;
import com.mx.totalplay.vo.AddONSCanalesBRMvsIPTVAdicionalesVO;
import com.mx.totalplay.vo.DetalleBRMAddONSNoIPTVVO;
import com.mx.totalplay.vo.DetalleIPTVAddONSNoBRMVO;
import com.mx.totalplay.vo.ServiceResponse;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;



public class AddONSCanalesBRMvsIPTVAdicionalesAction extends CifrasControlAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(AddONSCanalesBRMvsIPTVAdicionalesAction.class);
	AddONSCanalesBRMvsIPTVAdicionalesDAO canalesBRMvsIPTVAdicionalesDAO = new AddONSCanalesBRMvsIPTVAdicionalesDAO();
	private InputStream inputStream;
	String fecha;
	
	private String fechaTabla;
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		Conversor conver=new Conversor();
		this.fecha=conver.conversor(fecha);
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
		Conversor conversion= new Conversor();
		this.fechaTabla = conversion.conversor(fechaTabla);
	}



	ServiceResponse result = new ServiceResponse();
	
	
	
	
	public String getCanalesBRMvsIPTVAdicionales(){
		//logger.debug("***Action: getCanalesBRMvsIPTVAdicionales(Fecha: "+fecha+")");
		
		AddONSCanalesBRMvsIPTVAdicionalesVO ctasActBrmVO = new AddONSCanalesBRMvsIPTVAdicionalesVO();
		ctasActBrmVO.setFecha(getFecha());
		ctasActBrmVO.setTipo_conciliacion("1");
		
		//logger.debug("Action>getCanalesBRMvsIPTVAdicionales>fecha>"+getFecha());
		
		try{
			result = canalesBRMvsIPTVAdicionalesDAO.getCanalesBRMvsIPTVAdicionales(ctasActBrmVO);
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
		//	logger.error("Action getCanalesBRMvsIPTVAdicionales>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
		

	/***
	 * NYOA EXPORTAR DETALLE ADD ONS Canales BRM vs IPTV - Adicionales 
	 */
	// json* #1
	public String exportDetalleCanalesBRMvsIPTVAdicionalesDetailsTablaJson(){
//		System.out.println("fecha entrada json #1--"+ getFechaTabla());
		try{
			ServiceResponse respDet = new ServiceResponse();
			//logger.info("**getFechaTabla(): "+getFechaTabla());
		
			respDet = canalesBRMvsIPTVAdicionalesDAO.getDetalleIPTVAddONSNoBRM(getFechaTabla());
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
	// json* #2	
	public String exportDetalleCanalesBRMvsIPTVAdicionalesDetailsTablaJson2(){
//		System.out.println("fecha entrada json 2--"+ getFechaTabla());
		try{
			ServiceResponse respDet = new ServiceResponse();
			
			//logger.info("**getFechaTabla(): "+getFechaTabla());
			//respDet = ctasActBRMvsU2000DAO.detalleCtasActBRMvsU2000(getFechaTabla());
			respDet = canalesBRMvsIPTVAdicionalesDAO.getDetalleBRMAddONSNoIPTV(getFechaTabla());
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
	

	@SuppressWarnings({ "unused", "unchecked", "deprecation" })
	public String exportDetalleCanalesBRMvsIPTVAdicionalesDetails() {
		//logger.debug("*********Action: exportDetalleCanalesBRMvsIPTVAdicionalesDetails()");
		
		XSSFWorkbook myWorkBook = new XSSFWorkbook();
		XSSFCellStyle style_col = myWorkBook.createCellStyle();
		style_col.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		style_col.setAlignment(XSSFCellStyle.ALIGN_JUSTIFY);
		 
		XSSFSheet mySheet = myWorkBook.createSheet("DETALLE_IPTV_ADDONS_NO_BRM");
		XSSFSheet mySheetIPTV = myWorkBook.createSheet("DETALLE_BRM_ADDONS_NO_IPTV");
		try {
			Calendar calendar = Calendar.getInstance();

			ServiceResponse detalleBeans1 = canalesBRMvsIPTVAdicionalesDAO.getDetalleIPTVAddONSNoBRM(getFecha());
			ServiceResponse detalleBeans2 = canalesBRMvsIPTVAdicionalesDAO.getDetalleBRMAddONSNoIPTV(getFecha());

			String reportFile = "ADD ONS Canales BRM vs IPTV - Adicionales "+ calendar.get(Calendar.YEAR) + "-"+ calendar.get(Calendar.MONTH) + "-"+ calendar.get(Calendar.DAY_OF_MONTH) + "".concat(".xls");
			setDetailedAllInfo(myWorkBook,mySheet, (List<DetalleIPTVAddONSNoBRMVO>) detalleBeans1.getResult());
			setDetailedAllInfoIptv(myWorkBook,mySheetIPTV, (List<DetalleBRMAddONSNoIPTVVO>) detalleBeans2.getResult());

			try {
				ByteArrayOutputStream boas = new ByteArrayOutputStream();
				if(boas!=null)
				boas.close();
				myWorkBook.write(boas);
				setInputStream(new ByteArrayInputStream(boas.toByteArray()));
				
				
				if(boas!=null)
		            boas.close();
				
			} catch (Exception e) {
				//e.printStackTrace();
			} 
		} catch (Exception e) {
		//	e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleIPTVAddONSNoBRMVO> detalleBeans) throws IOException {
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
        
        
        
         
        
        String[] errorSource = { "Fecha", "Cuenta","Nombre","Plan","Status Cuenta","Paquete Principal", "Add On","Fecha Aprovisionamiento",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("ADD ONS Canales BRM vs IPTV - Adicionales");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,7));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle IPTV ADD ONS No BRM");
			monthCell.setCellStyle(headstyle);

			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);				
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,7));
			for (DetalleIPTVAddONSNoBRMVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getCuenta());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getNombre());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getPlan());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getStatus_cuenta());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getPaquete_principal());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getAddon());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(detalleBean.getFecha_aprovisanamiento());
				monthCell.setCellStyle(cellstyle);
				
			}
			
		
			for (int i = 0; i < myWorkBook.getNumberOfSheets(); i++) {
	            XSSFSheet thisSheet = myWorkBook.getSheetAt(i);
	            XSSFRow rowexcel = thisSheet.getRow(thisSheet.getLastRowNum());
	            if(rowexcel != null){
	            for (short j = 0; j < rowexcel.getLastCellNum(); j++) {	          
	            if(myWorkBook.getSheetAt(i) != null){
	            	myWorkBook.getSheetAt(i).autoSizeColumn(j);
	            	}
	            }
	            // Freezing the top row
	            myWorkBook.getSheetAt(i).createFreezePane(0, 1);
	        }
			}
			
		} catch (Exception e) {
		//	e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	private void setDetailedAllInfoIptv(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleBRMAddONSNoIPTVVO> detalleBeans) {
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
        
		final String[] errorSource = {"Fecha", "Cuenta", "Tipo de Servicio","Poid Puschased Product", "Poid Product","Nombre del Producto", "Desc.","" };
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("ADD ONS Canales BRM vs IPTV - Adicionales");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle BRM ADDONS_NO IPTV");
			monthCell.setCellStyle(headstyle);
			
			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
				
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,6));
			for (DetalleBRMAddONSNoIPTVVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getCuenta());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getTipo_servicio());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getPoid_purchased_product());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getPoid_product());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getNombre_producto());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getDescr());				
				monthCell.setCellStyle(cellstyle);
			}
			
				for (int i = 0; i < myWorkBook.getNumberOfSheets(); i++) {
					XSSFSheet thisSheet = myWorkBook.getSheetAt(i);
					XSSFRow rowexcel = thisSheet.getRow(thisSheet
							.getLastRowNum());
				 if(rowexcel != null){
					for (short j = 0; j < rowexcel.getLastCellNum(); j++) {
						myWorkBook.getSheetAt(i).autoSizeColumn(j);
					}
					// Freezing the top row
					myWorkBook.getSheetAt(i).createFreezePane(0, 1);
				}
				}
			
		} catch (Exception e) {
			//e.printStackTrace();
		}

	}
	

}
