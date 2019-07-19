package com.mx.totalplay.struts.action;

/**
 *
 * Julio 2017
 * ACTION PARA EL REPORTE: 9. Cifra Control Paquetes vs. Productos Incluidos BRM - PRODUCT MASTER 
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

import com.mx.totalplay.dao.PaqvsProductIncBRMDAO;
import com.mx.totalplay.vo.DetallePaqvsProductIncBRMVO;
import com.mx.totalplay.vo.ServiceResponse;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;



public class PaqvsProductIncBRMAction extends CifrasControlAction{

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(PaqvsProductIncBRMAction.class);
	PaqvsProductIncBRMDAO paqvsProductIncBRMDAO = new PaqvsProductIncBRMDAO();
	String fecha;
	String fechaReporte;
	
	private List<DetallePaqvsProductIncBRMVO> detPaqvsProductIncBRMVOList = new ArrayList<DetallePaqvsProductIncBRMVO>();
	private String reportFile;
	private InputStream inputStream;
	
	private String fechaTabla;
	
	public String getFechaTabla() {
		return fechaTabla;
	}

	public void setFechaTabla(String fechaTabla) {
		Conversor conver=new Conversor();
		this.fechaTabla =conver.conversor(fechaTabla);
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
	
	public List<DetallePaqvsProductIncBRMVO> getDetPaqvsProductIncBRMVOList() {
		return detPaqvsProductIncBRMVOList;
	}

	public void setDetPaqvsProductIncBRMVOList(List<DetallePaqvsProductIncBRMVO> detPaqvsProductIncBRMVOList) {
		this.detPaqvsProductIncBRMVOList = detPaqvsProductIncBRMVOList;
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
	
	ServiceResponse result = new ServiceResponse();
	
	public String getPaqvsProductIncBRM(){
		//logger.debug("***Action: getPaqvsProductIncBRM(Fecha: "+fecha+")");
		

		try{
			result = paqvsProductIncBRMDAO.getPaqvsProductIncBRM(fecha);
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
	//		logger.error("Action getPaqvsProductIncBRM>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private List<DetallePaqvsProductIncBRMVO> fetchList() {
		{
			ServiceResponse result = new ServiceResponse();
			try {
				ServiceResponse respDet = new ServiceResponse();
				//logger.debug("FechaReporte>>>"+getFechaReporte());
				
				respDet = paqvsProductIncBRMDAO.getDetallePaqvsProductIncBRM(getFechaReporte());

				if (respDet.isSuccess()) {
					result.setSuccess(true);
					result.setMensaje(respDet.getMensaje());
					result.setResult(respDet.getResult());
					//logger.debug("getDetallePaqvsProductIncBRM fetchList SUCCESS");

					List<DetallePaqvsProductIncBRMVO> detalle = new ArrayList<DetallePaqvsProductIncBRMVO>();
					detalle = (List<DetallePaqvsProductIncBRMVO>) respDet.getResult();
					DetallePaqvsProductIncBRMVO detPaqvsProductIncBRMVO = new DetallePaqvsProductIncBRMVO();
					for (int i = 0; i < detalle.size(); i++) {
						detPaqvsProductIncBRMVO = detalle.get(i);
						detPaqvsProductIncBRMVOList.add(detPaqvsProductIncBRMVO);
					}

				} else {
		//			logger.error("getDetallePaqvsProductIncBRM fetchList  ERROR");
					result.setSuccess(false);
					result.setResult(null);
					result.setMensaje(respDet.getMensaje());
				}

			} catch (Exception e) {
	//			logger.error("getDetallePaqvsProductIncBRM fetchList, ###ERROR### " + e);
			}

		}
		return detPaqvsProductIncBRMVOList;
	}
	
	public String exportPaqvsProductIncBRMTablaJson(){
		ServiceResponse result = new ServiceResponse();
		try{
			ServiceResponse respDet = new ServiceResponse();
//			logger.info("**getFechaTabla(): "+getFechaTabla());			
			respDet = paqvsProductIncBRMDAO.getDetallePaqvsProductIncBRM(getFechaTabla());


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
	

	public String exportPaqvsProductIncBRM() {
		XSSFWorkbook myWorkBook = new XSSFWorkbook();
		XSSFSheet mySheet = myWorkBook.createSheet("PAQ vs PRODUCTOS INCLUIDOS BRM - PM");
	//	logger.debug("exportPaqvsProductIncBRM getFechaReporte: " + getFechaReporte());
		try {
			@SuppressWarnings("unused")
			Calendar calendar = Calendar.getInstance();
			List<DetallePaqvsProductIncBRMVO> detalleBeans = fetchList();

			String fechaReporte = getFechaReporte().replace("/", "-");
			
			reportFile = "DetallePaqvsProductIncBRM (" + getFechaReporte() + ")".concat(".xlsx");
			//logger.debug("Nombre archivo: " + reportFile + "fechaReporte: " + fechaReporte);
			// setReportFile(reportFile);

			Row headerRow = mySheet.createRow(0);
			headerRow.setHeightInPoints(50);
			Cell titleCell = headerRow.createCell(0);
			titleCell.setCellValue("Detalle de Paquetes vs. Productos Incluidos BRM - PRODUCT MASTER (" + fechaReporte + ")");

			setDetailedAllInfoPaqvsProductIncBRM(myWorkBook,mySheet, detalleBeans);

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
	//		e.printStackTrace();
		}
		return SUCCESS;
	}

	private void setDetailedAllInfoPaqvsProductIncBRM(XSSFWorkbook myWorkBook,XSSFSheet mySheet, List<DetallePaqvsProductIncBRMVO> detalleBeans) {
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
        
        
		final String[] errorSource = { "Id", "Fecha", "Cuenta", "Plan", "TM Code", "Empresa", "Tipo de Servicio",""};
		
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Paquetes vs. Productos Incluidos BRM - PRODUCT MASTER");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle de PAQ vs Productos Incluidos BRM - PM");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
				
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,6));
			for (DetallePaqvsProductIncBRMVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getId());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getFecha().substring(0, 11));
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getCuenta());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getPlan());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getTmcode());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getEmpresa());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getTipo_servicio());
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
	//		e.printStackTrace();
		}

	}
	
}
