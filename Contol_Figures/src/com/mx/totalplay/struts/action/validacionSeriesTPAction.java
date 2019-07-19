package com.mx.totalplay.struts.action;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mx.totalplay.dao.validacionSeriesTPDAO;
import com.mx.totalplay.vo.ServiceResponse;
import com.mx.totalplay.vo.validacionSeriesTPVO;

import java.io.File;
import java.io.IOException; 
import java.lang.reflect.Type;

public class validacionSeriesTPAction extends CifrasControlAction{
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(validacionSeriesTPAction.class);
	validacionSeriesTPDAO validacionSeries = new validacionSeriesTPDAO();

	private File myFile;
	private String json_string;
	private InputStream inputStream;
	private String reportFile;
	
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
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getJson_string() {
		return json_string;
	}
	public void setJson_string(String json_string) {
		this.json_string = json_string;
	}
	
//********************************************************************	
//*************METODO PARA PREVISUALIZAR EXCEL***********************
	ServiceResponse result = new ServiceResponse();
	
	/*@SuppressWarnings("unused")
	public String getvalidacionSeriesTPprevio(){
		String resultAction = SUCCESS;	
	
		try{
			result = validacionSeries.getvalidacionSeriesTP(getMyFile());
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
	}*/

//******************** METODO PARA VERIFICACION PREVIO VS EXISTENTE **************************
//****************************************************************************************
/*		@SuppressWarnings("unchecked")
		public String getvalidacionSeriesTP(){
			//logger.info("contenido del arreglo: "+getJson_string());
			Gson gson = new Gson();
			Type listType = new TypeToken<List<validacionSeriesTPVO>>(){}.getType();
			List<validacionSeriesTPVO> listas = (List<validacionSeriesTPVO>) gson.fromJson(getJson_string(), listType);
				
			try{
					result = validacionSeries.getvalidacionSeriesTP_validar(listas);
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
		//			logger.error("Action getCtasActBRMvsU2000>>>"+e);
				}
				
				sendJSONObjectToResponse(result);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				return null;
		}	*/
		
		@SuppressWarnings("unchecked")
		public String exportvalidacionSeriesTPDetail(){
			List<validacionSeriesTPVO> listas=null;
//			logger.info("export method");
			
			XSSFWorkbook  myWorkBook = new XSSFWorkbook ();
			XSSFSheet  mySheet = myWorkBook.createSheet("ValidacionSeriesTP");
		
			try {
				listas=validacionSeries.getvalidacionSeriesTP(getMyFile());
				
				Calendar calendar = Calendar.getInstance();
				ServiceResponse detalleBeans1=validacionSeries.getvalidacionSeriesTP_validar(listas);
				
				reportFile = "TOTAL_Validación de series "+ calendar.get(Calendar.YEAR) + "-"+ calendar.get(Calendar.MONTH) + "-"+ calendar.get(Calendar.DAY_OF_MONTH) + "".concat(".xlsx");
				setDetailedAllInfo( myWorkBook, mySheet,(List<validacionSeriesTPVO>)detalleBeans1.getResult());
//				logger.info("trysuccess");
				try {
					ByteArrayOutputStream boas = new ByteArrayOutputStream();
					if(boas!=null)
					boas.close();
					myWorkBook.write(boas);
					setInputStream(new ByteArrayInputStream(boas.toByteArray()));
			
					
					if(boas!=null)
			            boas.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return SUCCESS;
		}
		
		@SuppressWarnings("deprecation")
		private void setDetailedAllInfo(XSSFWorkbook  myWorkBook,XSSFSheet  mySheet, List<validacionSeriesTPVO> detalleBeans) {
			
			String estatus_brm;
			String sstatus="";
			int rowNum = 1;   
		//	int rowNum = 3; 
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

			final String[] errorSource = { "Cuenta", "Serie","Estatus","Ultimo Cambio","Encontrado BRM",""};
			try {
				
				Row header = null;
				Cell monthCell = null;
				
				header = mySheet.createRow(0);
				for (int i = 0; i < errorSource.length; i++) {
					monthCell = header.createCell(i);
					monthCell.setCellValue(errorSource[i]);
					monthCell.setCellStyle(headstyle2);	
				}
			//	logger.debug("Termino el Titulo de registros");
				
				for (validacionSeriesTPVO detalleBean : detalleBeans) {
					myRow = mySheet.createRow(rowNum++);
					myRow.createCell(0).setCellValue(detalleBean.getACCOUNT_T_ACCOUNT_NO());
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(1).setCellValue(detalleBean.getSERVICE_T_LOGIN());
					monthCell.setCellStyle(cellstyle);
					
					if(detalleBean.getSERVICE_T_STATUS()==null)
						sstatus="";
					else{
					if(detalleBean.getSERVICE_T_STATUS().equals("10100"))
						sstatus="ACTIVO";
					if(detalleBean.getSERVICE_T_STATUS().equals("10102"))
						sstatus="INACTIVO";
					if(detalleBean.getSERVICE_T_STATUS().equals("10103"))
						sstatus="CANCELADO";
					}
					
					myRow.createCell(2).setCellValue(sstatus);
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(3).setCellValue(detalleBean.getSERVICE_T_LAST_STATUS_T());
					monthCell.setCellStyle(cellstyle);
					if(detalleBean.getSTATUS_BRM()=="0")
						estatus_brm="NO ENCONTRADO";
					else
						estatus_brm="ENCONTRADO";
	
					myRow.createCell(4).setCellValue(estatus_brm);
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
				e.printStackTrace();
			}

		}

	


}