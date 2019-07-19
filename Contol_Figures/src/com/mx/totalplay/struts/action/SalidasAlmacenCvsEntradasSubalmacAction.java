/**
 * @author RicardoM
 * ACTION PARA EL REPORTE DE SALIDAS ALMACEN CENTRAL VS ENTRADAS SUB ALMACENES
 */
package com.mx.totalplay.struts.action;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.mx.totalplay.dao.SalidasAlmacenCvsEntradasSubalmacDAO;
import com.mx.totalplay.vo.SalidasAlmacenCvsEntradasSubalmacVO;
import com.mx.totalplay.vo.ServiceResponse;



public class SalidasAlmacenCvsEntradasSubalmacAction extends CifrasControlAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SalidasAlmacenCvsEntradasSubalmacAction.class);
	SalidasAlmacenCvsEntradasSubalmacDAO SalidasAlmacenCvsEntradasSubalmac =  new SalidasAlmacenCvsEntradasSubalmacDAO();
	private String fecha;
	private String almacen;
	private String fechatabla;
	
	private InputStream inputStream;
	private String reportFile;	
	
	@SuppressWarnings("unused")
	public String getSalidasAlmacenCvsEntradasSubalmac(){
		//logger.debug("*** getSalidasAlmacenCvsEntradasSubalmac()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = SalidasAlmacenCvsEntradasSubalmac.getSalidasAlmacenCvsEntradasSubalmac(getFecha(),getAlmacen());
			
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				//logger.debug("getSalidasAlmacenCvsEntradasSubalmac SUCCESS");
			} else {
//				logger.error("getSalidasAlmacenCvsEntradasSubalmac ERROR");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}

		} catch (Exception e) {
//			logger.error("getSalidasAlmacenCvsEntradasSubalmac, ###ERROR### " + e);
			setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	@SuppressWarnings("unused")
	public String exportDetalleSalidasAlmacenCvsEntradasSubalmacTablaJson(){
		//logger.info("*** exportDetalleSalidasAlmacenCvsEntradasSubalmacTablaJson()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		//logger.info("getFechatabla(): " + getFechatabla());
		try {
			ServiceResponse respDet = new ServiceResponse();
			
			//respDet = SalidasAlmacenCvsEntradasSubalmac.getSalidasAlmacenCvsEntradasSubalmac(getFecha(),getAlmacen());
			respDet = SalidasAlmacenCvsEntradasSubalmac.getDetalleSalidasAlmacenCvsEntradasSubalmac(getFechatabla(),getAlmacen());
			//logger.info("respDet.isSuccess(): "+respDet.isSuccess());
			//logger.info("respDet.isSuccess(): "+respDet.getMensaje());
			//logger.info("respDet.isSuccess(): "+respDet.getResult());
			if (respDet.isSuccess()) {
				//logger.info("entrando");
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				//logger.info("getDetalleFfmNoBrm");
			} else {
//				logger.error("getInstVsSalidasAlmacenSAPService NO INFO");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}
			
		} catch (Exception e) {
			//logger.error("exportDetalleSalidasAlmacenCvsEntradasSubalmacTablaJson: " + e);
			setActionError("Error.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	
	@SuppressWarnings({ "unused", "unchecked" })
	public String exportDetalleSalidasAlmacenCvsEntradasSubalmac() {
		//logger.debug("*********Action: SalidasAlmacenCvsEntradasSubalmac()");
		
		XSSFWorkbook myWorkBook = new XSSFWorkbook();
		XSSFSheet mySheet = myWorkBook.createSheet("DETALLE BRM NO INTERFACTURA");
		try {
			Calendar calendar = Calendar.getInstance();
			ServiceResponse detalleBeans1 = SalidasAlmacenCvsEntradasSubalmac.getDetalleSalidasAlmacenCvsEntradasSubalmac(getFecha(),getAlmacen());

			//String reportFile = "SalidasAlmacenCentralvsEntradasSubalmacen"+ calendar.get(Calendar.YEAR) + "-"+ calendar.get(Calendar.MONTH) + "-"+ calendar.get(Calendar.DAY_OF_MONTH) + "".concat(".xlsx");
			String reportFile = "SalidasAlmacenCentralvsEntradasSubalmacen.xlsx";
			setDetailedAllInfo(myWorkBook,mySheet, (List<SalidasAlmacenCvsEntradasSubalmacVO>) detalleBeans1.getResult());

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
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<SalidasAlmacenCvsEntradasSubalmacVO> detalleBeans) {
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
		        
		final String[] errorSource = { "Pedido", "Plaza","Fecha de Pedido","Nombre","Descripción","Cantidad","Semáforo",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Salidas Almacén Central vs Entradas Sub almacenes");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle SAP Central Regional");
			monthCell.setCellStyle(headstyle);

			
//			System.out.println("titulos registros"+errorSource.length);
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
				
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,6));
			for (SalidasAlmacenCvsEntradasSubalmacVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getPedido());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getPlaza());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getFecha_pedido());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getNombre());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getDescripcion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getCantidad());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getSemaforo());
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
	public String getAlmacen() {
		return almacen;
	}
	public void setAlmacen(String almacen) {
		this.almacen = almacen;
	}
	public String getFechatabla() {
		return fechatabla;
	}


	public void setFechatabla(String fechatabla) {
		this.fechatabla = fechatabla;
	}
	
}
