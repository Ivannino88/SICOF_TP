/**
 * 
 * 08 Agosto 2017
 */
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
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.ibm.wsdl.util.IOUtils;
import com.mx.totalplay.dao.PagosBRMBancoDAO;
import com.mx.totalplay.vo.PagosBMBancoBRM_PagosVO;
import com.mx.totalplay.vo.PagosBMBancoPaymentBATCHVO;
import com.mx.totalplay.vo.PagosBMBancoPaymentBAZVO;
import com.mx.totalplay.vo.PagosBMBancoPaymentDIESTELVO;
import com.mx.totalplay.vo.PagosBMBancoPaymentMIDVO;
import com.mx.totalplay.vo.PagosBMBancoPaymentOXXOVO;
import com.mx.totalplay.vo.PagosBMBancoPaymentRECVO;
import com.mx.totalplay.vo.PagosBMBancoPaymentREGALIVO;
import com.mx.totalplay.vo.PagosBMBancoVO;
import com.mx.totalplay.vo.ServiceResponse;

public class PagosBRMBancoAction extends CifrasControlAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(PagosBRMBancoAction.class);
	PagosBRMBancoDAO pagosBRMBanco =  new PagosBRMBancoDAO();
	
	private String fecha;
	private String empresa;
	private String canal;
	private String id_conciliacion;
	private InputStream inputStream;
	private String reportFile;
	private List<PagosBMBancoVO> pagosBRMBancoVOList = new ArrayList<PagosBMBancoVO>();
	
	
	@SuppressWarnings("unused")
	public String getPagosBRMBanco(){
		//logger.debug("*** getPagosBRMBanco()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = pagosBRMBanco.getPagosBRMBanco(getFecha(), getEmpresa(), getCanal());
			
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
			} else {
//				logger.error("getPagosBRMBanco ERROR");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}

		} catch (Exception e) {
//			logger.error("getPagosBRMBanco, ###ERROR### " + e);
			setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}

//***************************************************************************************************
//**************************** METODOS PARA DESCARGA DE DETALLES ****************************************
	@SuppressWarnings({ "unused", "unchecked" })
	public String exportDetallePagosBRMBanco() {
		
		try {
			Calendar calendar = Calendar.getInstance();
			
			XSSFWorkbook myWorkBook = new XSSFWorkbook();
			XSSFSheet mySheet = myWorkBook.createSheet("PAGOS BRM BANCO");
			XSSFSheet mySheet2 = myWorkBook.createSheet("PAGOS BRM DETALLE");
			
			
			if(getCanal().equals("1"))
				reportFile = "PagosBRMBanco-Detalle Ventanilla.xlsx";
			if(getCanal().equals("2"))
				reportFile = "PagosBRMBanco-Detalle Cargo Domiciliacion.xlsx";
			if(getCanal().equals("3"))
				reportFile = "PagosBRMBanco-Detalle BancoAzteca.xlsx";
			if(getCanal().equals("4"))
				reportFile = "PagosBRMBanco-Detalle Oxxo.xlsx";
			if(getCanal().equals("5"))
				reportFile = "PagosBRMBanco-Detalle Diestel.xlsx";
			if(getCanal().equals("6"))
				reportFile = "PagosBRMBanco-Detalle Regalii.xlsx";
			if(getCanal().equals("7"))
				reportFile = "PagosBRMBanco-Detalle CanalPropio.xlsx";
			if(getCanal().equals("8"))
				reportFile = "PagosBRMBanco-Detalle Otros.xlsx";
			
						
			setReportFile(reportFile);
			
			ServiceResponse detalleBeans = pagosBRMBanco.getPagosBRMBanco( getFecha(), getEmpresa(), getCanal() );
			ServiceResponse  detalleBeans2 = pagosBRMBanco.getPagosBRMBancoBRM_PAGOS(getCanal(), getId_conciliacion());
			
			Row headerRow = mySheet.createRow(0);
			headerRow.setHeightInPoints(50);
			Cell titleCell = headerRow.createCell(0);
			titleCell.setCellValue("Detalle de los Pagos BRM Banco " + getFecha() + "");
			
			setDetailedAllInfo(myWorkBook, mySheet, (List<PagosBMBancoVO>) detalleBeans.getResult());
			setDetailedAllInfo2(myWorkBook, mySheet2, (List<PagosBMBancoBRM_PagosVO>) detalleBeans2.getResult());
			
	//****************************************FILTRO DE DAOS DEPENDIENDO EL CANAL
		//VENTANILLA
			if(getCanal().equals("1")){
				XSSFSheet mySheet3 = myWorkBook.createSheet("PAYMENT-VENTANILLA");
				ServiceResponse  detalle_Ventanilla = pagosBRMBanco.getPagosBRMBancoPayment(getCanal(),getId_conciliacion());		
				setDetailedAllInfo_VENTANILLA(myWorkBook, mySheet3, (List<PagosBMBancoPaymentBATCHVO>) detalle_Ventanilla.getResult());
			}
		//CARGO DOMILICIACION
			if(getCanal().equals("2")){
				XSSFSheet mySheet3 = myWorkBook.createSheet("PAYMENT-CARGO DOMICILIACION");
				ServiceResponse  detalle_Rec = pagosBRMBanco.getPagosBRMBancoPayment(getCanal(),getId_conciliacion());		
				setDetailedAllInfo_REC(myWorkBook, mySheet3, (List<PagosBMBancoPaymentRECVO>) detalle_Rec.getResult());
			}
		//BANCO AZTECA		
			if(getCanal().equals("3")){
				XSSFSheet mySheet3 = myWorkBook.createSheet("PAYMENT-BANCO AZTECA");
				ServiceResponse  detalle_BancoAzteca = pagosBRMBanco.getPagosBRMBancoPayment(getCanal(),getId_conciliacion());		
				setDetailedAllInfo_BANCOAZTECA(myWorkBook, mySheet3, (List<PagosBMBancoPaymentBAZVO>) detalle_BancoAzteca.getResult());
			}
		//OXXO
			if(getCanal().equals("4")){
				XSSFSheet mySheet3 = myWorkBook.createSheet("PAYMENT-OXXO");
				ServiceResponse  detalle_OXXO = pagosBRMBanco.getPagosBRMBancoPayment(getCanal(),getId_conciliacion());		
				setDetailedAllInfo_OXXO(myWorkBook, mySheet3, (List<PagosBMBancoPaymentOXXOVO>) detalle_OXXO.getResult());
					}
		//DIESTEL
			if(getCanal().equals("5")){
				XSSFSheet mySheet3 = myWorkBook.createSheet("PAYMENT-DIESTEL");
				ServiceResponse  detalle_DIESTEL = pagosBRMBanco.getPagosBRMBancoPayment(getCanal(),getId_conciliacion());		
				setDetailedAllInfo_DIESTEL(myWorkBook, mySheet3, (List<PagosBMBancoPaymentDIESTELVO>) detalle_DIESTEL.getResult());
			}
		//REGALII
			if(getCanal().equals("6")){
				XSSFSheet mySheet3 = myWorkBook.createSheet("PAYMENT-REGALII");
				ServiceResponse  detalle_REGALI = pagosBRMBanco.getPagosBRMBancoPayment(getCanal(),getId_conciliacion());		
				setDetailedAllInfo_REGALI(myWorkBook, mySheet3, (List<PagosBMBancoPaymentREGALIVO>) detalle_REGALI.getResult());
			}
		//CANAL PROPIO
			if(getCanal().equals("7")){
				XSSFSheet mySheet3 = myWorkBook.createSheet("PAYMENT-CANAL PROPIO");
				ServiceResponse  detalle_CANAL_PROPIO = pagosBRMBanco.getPagosBRMBancoPayment(getCanal(),getId_conciliacion());		
				setDetailedAllInfo_MID(myWorkBook, mySheet3, (List<PagosBMBancoPaymentMIDVO>) detalle_CANAL_PROPIO.getResult());
	
			}
	//****************************************************************************
			try {
				ByteArrayOutputStream boas = new ByteArrayOutputStream();
				if(boas!=null)
				boas.close();
				myWorkBook.write(boas);
				setInputStream(new ByteArrayInputStream(boas.toByteArray()));
				//response.setContentType("application/vnd.ms-excel;base64");
				
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("application/vnd.ms-excel;base64");
				response.setHeader("Content-disposition", "attachment; filename=" + reportFile);
				response.setCharacterEncoding("UTF-8");
				
				if(boas!=null)
		            boas.close();
			} catch (IOException e) {
//				e.printStackTrace();
			}
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo(XSSFWorkbook myWorkBook, XSSFSheet mySheet, List<PagosBMBancoVO> detalleBeans) {
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
		        
		final String[] errorSource = {"Id","Fecha","N�mero de Pagos","Importe BRM","Num. de Pagos Banco","Empresa","Canal","Importe Bancos","Estatus", ""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Pagos BRM Bancos");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,8));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle Pagos BRM Bancos");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,8));
			for (PagosBMBancoVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getId());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getNumero_pagos());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getImporte_brm());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getNo_pagos_banco());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getEmpresa());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getCanal());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(detalleBean.getImporte_bancos());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(8).setCellValue( "R".equals(detalleBean.getColor())?"ROJO": "V".equals(detalleBean.getColor())?"VERDE":"AMARILLO" );
				monthCell.setCellStyle(cellstyle);
			}
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo2(XSSFWorkbook myWorkBook, XSSFSheet mySheet, List<PagosBMBancoBRM_PagosVO> detalleBeans) {
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
		        
		final String[] errorSource = {"Id","Fecha","Empresa","Cuenta","Monto","Fecha Pago","Descripci�n","Fecha Insert","Item No","Fecha BRM",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Pagos BRM Bancos");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,9));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle Pagos BRM Bancos");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,9));
			for (PagosBMBancoBRM_PagosVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getId_conciliacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getEmpresa());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getAccount_no());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(Float.parseFloat(detalleBean.getItem_total()));
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getFecha_pago());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getDescr());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(detalleBean.getFechainsert());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(8).setCellValue(detalleBean.getItem_no());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(9).setCellValue(detalleBean.getFechabrm());
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
	
	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo_VENTANILLA(XSSFWorkbook myWorkBook, XSSFSheet mySheet, List<PagosBMBancoPaymentBATCHVO> detalleBeans) {
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
		        
		final String[] errorSource = {"Id","Cuenta","Monto","Fecha Pago","Banco","Archivo", "Linea","Detalle","Fecha Insert","Negocio",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Pagos BRM Bancos");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,9));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle Payment-Ventanilla");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,9));
			for (PagosBMBancoPaymentBATCHVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getId_conciliacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getAccount());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(Float.parseFloat(detalleBean.getAmount()));
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getDate_payment());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getName_bank());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getFile_name());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getNumber_line());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(detalleBean.getFile_line());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(8).setCellValue(detalleBean.getDate_insert());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(9).setCellValue(detalleBean.getNegocio());
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
	
	
	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo_REC(XSSFWorkbook myWorkBook, XSSFSheet mySheet, List<PagosBMBancoPaymentRECVO> detalleBeans) {
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
		        
		final String[] errorSource = {"Id","Cuenta","Monto","Fecha Pago","Banco","Archivo", "Linea","Fecha Insert","Card","Authorization","Ciclo","Saldo","Negocio",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Pagos BRM Bancos");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,12));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle Payment-Cargo Domiciliaci�n");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,12));
			for (PagosBMBancoPaymentRECVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getId_conciliacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getAccount());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(Float.parseFloat(detalleBean.getAmount()));
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getDate_payment());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getName_bank());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getFile_name());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getNumber_line());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(detalleBean.getDate_insert());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(8).setCellValue("************"+detalleBean.getCard().substring(12));//oculta el numero de tarjeta
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(9).setCellValue(detalleBean.getAuthorization());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(10).setCellValue(detalleBean.getCiclo());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(11).setCellValue(detalleBean.getSaldo());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(12).setCellValue(detalleBean.getNegocio());
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
	
	
	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo_BANCOAZTECA(XSSFWorkbook myWorkBook, XSSFSheet mySheet, List<PagosBMBancoPaymentBAZVO> detalleBeans) {
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
		        
		final String[] errorSource = {"Id","Fecha","Empresa","Cuenta","Monto","Fecha Pago","Banco","Archivo", "Linea","Detalle","Fecha Insert","Negocio",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Pagos BRM Bancos");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,11));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle Payment-Banco Azteca");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,11));
			for (PagosBMBancoPaymentBAZVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getId_conciliacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getEmpresa());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getAccount());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(Float.parseFloat(detalleBean.getAmount()));
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getDate_payment());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getName_bank());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(detalleBean.getFile_name());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(8).setCellValue(detalleBean.getNumber_line());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(9).setCellValue(detalleBean.getFile_line());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(10).setCellValue(detalleBean.getDate_insert());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(11).setCellValue(detalleBean.getNegocio());
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
	
	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo_OXXO(XSSFWorkbook myWorkBook, XSSFSheet mySheet, List<PagosBMBancoPaymentOXXOVO> detalleBeans) {
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
		        
		final String[] errorSource = {"Id","Cuenta","Monto","Fecha Pago","Hora","Plaza", "Tienda","Folio","Authorizationcode","Ticket","Archivo","Linea","Detalle","Fecha insert","Negocio","Cr pyt",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Pagos BRM Bancos");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,15));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle Payment-OXXO");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,15));
			for (PagosBMBancoPaymentOXXOVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getId_conciliacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getAccount());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(Float.parseFloat(detalleBean.getAmount()));
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getDate_payment());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getHora());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getPlaza());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getTienda());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(detalleBean.getFolio());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(8).setCellValue(detalleBean.getAuthorizationcode());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(9).setCellValue(detalleBean.getTicket());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(10).setCellValue(detalleBean.getFile_name());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(11).setCellValue(detalleBean.getNumber_line());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(12).setCellValue(detalleBean.getFile_line());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(13).setCellValue(detalleBean.getDate_insert());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(14).setCellValue(detalleBean.getNegocio());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(15).setCellValue(detalleBean.getCr_pyt());
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
	
	
	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo_DIESTEL(XSSFWorkbook myWorkBook, XSSFSheet mySheet, List<PagosBMBancoPaymentDIESTELVO> detalleBeans) {
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
		        
		final String[] errorSource = {"Id","Pago Folio","Monto","Cuenta","Fecha de Transacci�n","Folio_ext","Pago Id","Fecha Insert","Cash_machine","Store","Ticket",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Pagos BRM Bancos");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,10));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle Payment-DIESTEL");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,10));
			for (PagosBMBancoPaymentDIESTELVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getId_conciliacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getPayment_folio());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(Float.parseFloat(detalleBean.getPayment_amount()));
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getPayment_account());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getPayment_tran_date());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getFolio_ext());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getPayment_id());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(detalleBean.getDate_insert());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(8).setCellValue(detalleBean.getCash_machine());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(9).setCellValue(detalleBean.getStore());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(10).setCellValue(detalleBean.getTicket());
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
	
	
	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo_REGALI(XSSFWorkbook myWorkBook, XSSFSheet mySheet, List<PagosBMBancoPaymentREGALIVO> detalleBeans) {
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
		        
			final String[] errorSource = {"Id","Pago Folio","Monto","Cuenta","Fecha de Transacci�n","Folio_ext","Pago Id","Fecha Insert","Cash_machine","Store","Ticket",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Pagos BRM Bancos");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,10));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle Payment-REGALI");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,10));
			for (PagosBMBancoPaymentREGALIVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getId_conciliacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getPayment_folio());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(Float.parseFloat(detalleBean.getPayment_amount()));
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getPayment_account());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getPayment_tran_date());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getFolio_ext());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getPayment_id());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(detalleBean.getDate_insert());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(8).setCellValue(detalleBean.getCash_machine());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(9).setCellValue(detalleBean.getStore());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(10).setCellValue(detalleBean.getTicket());
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
	
	
	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo_MID(XSSFWorkbook myWorkBook, XSSFSheet mySheet, List<PagosBMBancoPaymentMIDVO> detalleBeans) {
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
		        
		final String[] errorSource = {"Id","Cuenta","Fecha Pago","Authorizationcode","Monto","Canal","Banco","Fecha Insert","Negocio","Numero_tarjeta","Tipo_numero","Tipo_tarjeta",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Pagos BRM Bancos");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,11));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle Payment-Canal Propio");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,11));
			for (PagosBMBancoPaymentMIDVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getId_conciliacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(Float.parseFloat(detalleBean.getAmount()));
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getTlt_date_end());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getAuthorizationcode());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getAmount());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getChanel());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getName_bank());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(detalleBean.getDate_insert());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(8).setCellValue(detalleBean.getNegocio());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(9).setCellValue(detalleBean.getNumero_tarjeta());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(10).setCellValue(detalleBean.getTipo_numero());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(11).setCellValue(detalleBean.getTipo_tarjeta());
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
	
//*******************************************************************************************************************
//*********************************  QUERY PARA CARGAR LAS LISTAS INICIALES  **************************************

	public String loadEmpresas() {
//		logger.debug("============ ACTION: loadEmpresas ==========");
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = pagosBRMBanco.getPagosBRMBanco_CatEmpresas();

			if (respDet != null && respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje("Se obtuvo la informacion de las Empresas: ");
				result.setResult(respDet.getResult());
//					logger.debug("Se obtuvo la informacion de las Empresas ");
			} else {
//				logger.error("NO SE ENCONTRARON DATOS");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje("Detalle no encontrado");
			}
		} catch (Exception e) {
//			logger.error("loadEmpresas, ###ERROR### " + e.getMessage());
			setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
		}

		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
	      response.setContentType("application/json");
	      response.setCharacterEncoding("UTF-8");
		return null;
	}	
	
//****************************************************************************************************************
//************************  QUERY PARA CARGAR LOS CANALES SEGUN LA EMPRESA SELECCIONADA  ************************* 

	public String loadCanales() {
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = pagosBRMBanco.getPagosBRMBanco_CatCanales();

			if (respDet != null && respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje("Se obtuvo la informacion de los Canales: ");
				result.setResult(respDet.getResult());
			} else {
//				logger.error("NO SE ENCONTRARON DATOS");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje("Detalle no encontrado");
			}
		} catch (Exception e) {
//			logger.error("loadEmpresas, ###ERROR### " + e.getMessage());
			setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
		}

		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
	      response.setContentType("application/json");
	      response.setCharacterEncoding("UTF-8");
		return null;
	}	
	
//*************************************************************************************************
//************************************* GETTER Y SETTER *******************************************
	
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		Conversor conver=new Conversor();
		this.fecha=conver.conversor(fecha);
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}

	public String getId_conciliacion() {
		return id_conciliacion;
	}

	public void setId_conciliacion(String id_conciliacion) {
		this.id_conciliacion = id_conciliacion;
	}
}