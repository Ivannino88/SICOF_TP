/**
 * @author G
 * ACTION PARA EL REPORTE Salida de Equipos vs. Equipos Capitalizados SAP
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
import org.apache.struts2.ServletActionContext;

import com.mx.totalplay.dao.SalidaEqvsEqCapitalizadosSAPDAO;
import com.mx.totalplay.vo.SalidaEqvsEqCapitalizadosSAPVO;
import com.mx.totalplay.vo.ServiceResponse;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

public class SalidaEqvsEqCapitalizadosSAPAction extends CifrasControlAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SalidaEqvsEqCapitalizadosSAPAction.class);
	SalidaEqvsEqCapitalizadosSAPDAO salidaEqvsEqCapitalizadosSAPDAO =  new SalidaEqvsEqCapitalizadosSAPDAO();
	private String fecha;
	private InputStream inputStream;
	private String fechatabla;
	
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
	
	public String getFechatabla() {
		return fechatabla;
	}

	public void setFechatabla(String fechatabla) {
		this.fechatabla = fechatabla;
	}
	
	
	@SuppressWarnings("unused")
	public String getSalidaEqvsEqCapitalizadosSAP(){
		//logger.debug("*** getSalidaEqvsEqCapitalizadosSAP()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = salidaEqvsEqCapitalizadosSAPDAO.getSalidaEqvsEqCapitalizadosSAP(getFecha());
			
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				//logger.debug("getSalidaEqvsEqCapitalizadosSAP SUCCESS");
			} else {
//				logger.error("getSalidaEqvsEqCapitalizadosSAP ERROR");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}

		} catch (Exception e) {
//			logger.error("getSalidaEqvsEqCapitalizadosSAP, ###ERROR### " + e);
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
	public String exportDetalleSalidaEqvsEqCapitalizadosSAPTablaJson(){
		//logger.info("*** exportDetalleSalidaEqvsEqCapitalizadosSAPTablaJson()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		//logger.info("getFechatabla(): " + getFechatabla());
		try {
			ServiceResponse respDet = new ServiceResponse();
			
			//respDet = SalidasSubalmacenvsEntradasCuadrillas.getSalidasSubalmacenvsEntradasCuadrillas(getFechatabla());
			respDet = salidaEqvsEqCapitalizadosSAPDAO.getDetalleSalidaEqvsEqCapitalizadosSAP(getFechatabla());
			//logger.info("respDet.isSuccess(): "+respDet.isSuccess());
			//logger.info("respDet.isSuccess(): "+respDet.getMensaje());
			//logger.info("respDet.isSuccess(): "+respDet.getResult());
			if (respDet.isSuccess()) {
				//logger.info("entrando");
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				//logger.info("getDetalleSalidaEqvsEqCapitalizadosSAP");
			} else {
//				logger.error("getInstVsSalidasAlmacenSAPService NO INFO");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}
			
		} catch (Exception e) {
			//logger.error("exportDetalleSalidaEqvsEqCapitalizadosSAPTablaJson: " + e);
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
	public String exportDetalleSalidaEqvsEqCapitalizadosSAP() {
		//logger.debug("*********Action: SalidaEqvsEqCapitalizadosSAPAction()");
		
		XSSFWorkbook myWorkBook = new XSSFWorkbook();
		XSSFSheet mySheet = myWorkBook.createSheet("SALIDA DE EQ VS EQ CAPITALIZADOS SAP");
		try {
			Calendar calendar = Calendar.getInstance();
			ServiceResponse detalleBeans1 = salidaEqvsEqCapitalizadosSAPDAO.getDetalleSalidaEqvsEqCapitalizadosSAP(getFecha());

			String reportFile = "SalidaEqvsEqCapitalizadosSAP"+ calendar.get(Calendar.YEAR) + "-"+ calendar.get(Calendar.MONTH) + "-"+ calendar.get(Calendar.DAY_OF_MONTH) + "".concat(".xlsx");
			setDetailedAllInfo(myWorkBook,mySheet, (List<SalidaEqvsEqCapitalizadosSAPVO>) detalleBeans1.getResult());

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

	private void setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<SalidaEqvsEqCapitalizadosSAPVO> detalleBeans) {
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
        
		final String[] errorSource = { "Fecha", "Salida de Almacén","Importe","Activo Fijo","Importe Activo Fijo","Estatus", "Fecha de Consulta",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Salida de equipos VS Equipos capitalizados SAP - SAP");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle SAP Salidas Capitalización");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
				
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,6));
			for (SalidaEqvsEqCapitalizadosSAPVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getSalida_almacen());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getImporte());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getActivo_fijo());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getImporte_activo_fijo());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getEstatus());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getFecha_consulta());
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
}
