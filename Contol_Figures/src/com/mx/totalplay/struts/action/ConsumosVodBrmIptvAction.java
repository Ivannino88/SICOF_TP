package com.mx.totalplay.struts.action;

import java.awt.Color;
//import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
//import org.apache.poi.hssf.util.CellRangeAddress;
//import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.util.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.mx.totalplay.dao.ConsumosVodBrmIptvDAO;
import com.mx.totalplay.vo.ConsumosVodBrmIptvVO;
//import com.mx.totalplay.vo.DetalleBRMAddONSNoIPTVVO;
import com.mx.totalplay.vo.DetalleNoBrmIptv;
import com.mx.totalplay.vo.DetalleVodsVO;
import com.mx.totalplay.vo.ServiceResponse;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;


public class ConsumosVodBrmIptvAction extends CifrasControlAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(ConsumosVodBrmIptvAction.class);
	ConsumosVodBrmIptvDAO consumosVodBrmIptvDAO = new ConsumosVodBrmIptvDAO();
	private InputStream inputStream;
	private InputStream inputStream1;
	private List<DetalleVodsVO> detalleVodsVo = new ArrayList<DetalleVodsVO>();
	String fecha;
	String fechaReporte;
	private String fechatabla;
	private int semana;
	private int selectsem;
	int fechaAnhio;
	int fechaAnhioDown;
	
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
		Conversor conver=new Conversor();
		this.fechatabla =conver.conversor(fechatabla);
	}

	ServiceResponse result = new ServiceResponse();
	
	
	
	
	public String getConciliacionVodBrm(){
		//logger.debug("***Action: getConciliacionVodBrm(Fecha: "+fecha+")");
		
		ConsumosVodBrmIptvVO ctasActBrmVO = new ConsumosVodBrmIptvVO();
		ctasActBrmVO.setFecha(getFecha());
		ctasActBrmVO.setTipo_conciliacion("1");
		
		//logger.debug("Action>getConciliacionVodBrm>fecha>"+getFecha());
		
		try{
			result = consumosVodBrmIptvDAO.getConciliacionVodBrm(ctasActBrmVO);
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
		//	logger.error("Action getConciliacionVodBrm>>>"+e);
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
	// -- json* #1
	public String exportgetDetalleVodsTablaJson(){
		//logger.debug("***Action: getConciliacionVodBrm(Fecha: "+fecha+")");
				
		try{
			ServiceResponse respDet = new ServiceResponse();
//			System.out.println("fecha es "+getFechatabla());
			respDet = consumosVodBrmIptvDAO.getDetalleVods(getFechatabla());
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
	public String exportgetDetalleVods() {
		//logger.debug("*********Action: exportgetDetalleVods()");
		//logger.debug("*********fecha: "+getFecha());
		XSSFWorkbook myWorkBook = new XSSFWorkbook();
		XSSFCellStyle style_col = myWorkBook.createCellStyle();
		style_col.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		style_col.setAlignment(XSSFCellStyle.ALIGN_JUSTIFY);
		 
		XSSFSheet mySheet = myWorkBook.createSheet("DETALLE_VODS");
		try {
			Calendar calendar = Calendar.getInstance();
			System.out.println("----------------- #"+getFecha());
			ServiceResponse detalleBeans1 = consumosVodBrmIptvDAO.getDetalleVods(getFecha());
			                                                                                                              
			String reportFile = "CONCILIACIÓN VOD'S BRM vs IPTV "+ calendar.get(Calendar.YEAR) + "-"+ calendar.get(Calendar.MONTH) + "-"+ calendar.get(Calendar.DAY_OF_MONTH) + "".concat(".xlsx");
			setDetailedAllInfo(myWorkBook,mySheet, (List<DetalleVodsVO>) detalleBeans1.getResult());

			try {
				ByteArrayOutputStream boas = new ByteArrayOutputStream();
				if(boas!=null)
				boas.close();
				myWorkBook.write(boas);
				setInputStream(new ByteArrayInputStream(boas.toByteArray()));
				
				
				if(boas!=null)
		            boas.close();
				
			} catch (Exception e) {
			//	e.printStackTrace();
			}
		} catch (Exception e) {
		//	e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleVodsVO> detalleBeans) throws IOException {
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
        
        
        
         
        
        String[] errorSource = { "Fecha", "Account","Usuario","Serie","Título","Categoría","Calidad","Precio","Fecha PE","Hora","Número de Parte","Date Insert","Date Last Update","Status","Login",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Conciliación VOD'S BRM vs IPTV ");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,14));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle VODS ");
			monthCell.setCellStyle(headstyle);

			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);

			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,14));
			for (DetalleVodsVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getAccount());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getUsuario());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getSerie());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getTitulo());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getCategoria());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getCalida());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(detalleBean.getPrecio());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(8).setCellValue(detalleBean.getFecha_pe());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(9).setCellValue(detalleBean.getHora());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(10).setCellValue(detalleBean.getNumero_parte());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(11).setCellValue(detalleBean.getDate_insert());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(12).setCellValue(detalleBean.getDate_last_update());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(13).setCellValue(detalleBean.getStatus());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(14).setCellValue(detalleBean.getLogin());
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
//	 ---------------------------------------------------------------   CONSULTA PRINCIPAL POR SEMANA   ----------------------
	public String getConciliacionVodBrm02(){
		System.out	.println("ConsumosVodBrmIptvAction.getConciliacionVodBrm02()");
		logger.info("ConsumosVodBrmIptvAction.getConciliacionVodBrm02() -- ACTION----");
		logger.info("semana: "+getSemana()+ " año es:  "+getFechaAnhio());
		
		try{
			
			result = consumosVodBrmIptvDAO.getConciliacionVodBrm02(getSemana(),getFechaAnhio());
			logger.info("datos a enviar semana: # "+getSemana()+ " año es: #  "+getFechaAnhio());
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
			logger.info("error--");
			e.printStackTrace();
			
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	
		return null;
	}

	
	
	
	
	// CONSULTA DE DETALLES 
	
	// -- json*  #2
		public String exportgetDetalleVodsTablaJsonSemana(){
			System.out	.println("ConsumosVodBrmIptvAction.exportgetDetalleVodsTablaJson02()");
			logger.info("ACTION semana---------> :"+getSemana());
			logger.info("ACTION año ------------->:"+getFechaAnhio());
					
			try{
				ServiceResponse respDet = new ServiceResponse();
//				System.out.println("fecha es "+getFechatabla());
				respDet = consumosVodBrmIptvDAO.getDetalleVodsSemana(getSemana(),getFechaAnhio());
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
		
		
		
		@SuppressWarnings("unchecked")
		private List<DetalleVodsVO> fetchList() {
			System.out.println("ConsumosVodBrmIptvAction.fetchList() -------------------excel------------------");
			 
			  {
				  ServiceResponse result = new ServiceResponse();
					try {
						ServiceResponse respDet = new ServiceResponse();
						respDet = consumosVodBrmIptvDAO.getDetalleVodsSemana(getSelectsem(),getFechaAnhioDown());
//						System.out.println("la fecha "+getFechaReporte());
						if (respDet.isSuccess()) {
							result.setSuccess(true);
							result.setMensaje(respDet.getMensaje());
							result.setResult(respDet.getResult());
							
							List<DetalleVodsVO> detalle = new ArrayList<DetalleVodsVO>();
							detalle = (List<DetalleVodsVO>)respDet.getResult();
							DetalleVodsVO detalleNoBrmIptv = new DetalleVodsVO();
							for(int i=0; i<detalle.size();i++){
								detalleNoBrmIptv = detalle.get(i);
								detalleVodsVo.add(detalleNoBrmIptv);
							}
							
						} else {
							result.setSuccess(false);
							result.setResult(null);
							result.setMensaje(respDet.getMensaje());
						}

					} catch (Exception e) {
					}
				  			  
			  }
			  return detalleVodsVo;
		}
		
	
		
// EXCEL DETALLE POR SEMANA		
//		@SuppressWarnings({ "unused", "unchecked", "deprecation" })
		public String exportgetDetalleVodsSemana() {
			logger.info("generando archivo excel: "+getSelectsem());
			logger.info("generando archivo excel: "+getFechaAnhioDown());
			XSSFWorkbook myWorkBook = new XSSFWorkbook();
			XSSFCellStyle style_col = myWorkBook.createCellStyle();
			style_col.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
			style_col.setAlignment(XSSFCellStyle.ALIGN_JUSTIFY);
			 
			XSSFSheet mySheet = myWorkBook.createSheet("DETALLE_VODS SEMANA");
			try {
				Calendar calendar = Calendar.getInstance();

				List<DetalleVodsVO> detalleBeans1 = fetchList();
				     
				   
				String reportFile = "CONCILIACIÓN VOD'S BRM vs IPTV "+ calendar.get(Calendar.YEAR) + "-"+ calendar.get(Calendar.MONTH) + "-"+ calendar.get(Calendar.DAY_OF_MONTH) + "".concat(".xlsx");
				
				setDetailedAllInfoSemana(myWorkBook,mySheet, (List<DetalleVodsVO>) detalleBeans1);

				try {
					ByteArrayOutputStream boas = new ByteArrayOutputStream();
					if(boas!=null)
					boas.close();
					myWorkBook.write(boas);
					setInputStream(new ByteArrayInputStream(boas.toByteArray()));
					
					
					if(boas!=null)
			            boas.close();
					
				} catch (Exception e) {
				//	e.printStackTrace();
				}
			} catch (Exception e) {
			//	e.printStackTrace();
			}
			return SUCCESS;
		}

		@SuppressWarnings("deprecation")
		private void setDetailedAllInfoSemana(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleVodsVO> detalleBeans) throws IOException {
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
	        
	        
	        
	         
	        
	        String[] errorSource = { "Fecha", "Account","Usuario","Serie","Título","Categoría","Calidad","Precio","Fecha PE","Hora","Número de Parte","Date Insert","Date Last Update","Status","Login",""};
			try {
				Row header = mySheet.createRow(0);
				Cell monthCell = header.createCell(0);
				monthCell.setCellValue("Conciliación VOD'S BRM vs IPTV ");
				monthCell.setCellStyle(headstyle);
				mySheet.addMergedRegion(new CellRangeAddress(0,0,0,14));
				header = mySheet.createRow(1);
				monthCell = header.createCell(0);
				monthCell.setCellValue("Detalle VODS ");
				monthCell.setCellStyle(headstyle);

				header = mySheet.createRow(2);
				for (int i = 0; i < errorSource.length; i++) {
					monthCell = header.createCell(i);
					monthCell.setCellValue(errorSource[i]);
					monthCell.setCellStyle(headstyle2);

				}
				mySheet.addMergedRegion(new CellRangeAddress(1,1,0,14));
				for (DetalleVodsVO detalleBean : detalleBeans) {
					myRow = mySheet.createRow(rowNum++);
					myRow.createCell(0).setCellValue(detalleBean.getFecha());
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(1).setCellValue(detalleBean.getAccount());
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(2).setCellValue(detalleBean.getUsuario());
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(3).setCellValue(detalleBean.getSerie());
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(4).setCellValue(detalleBean.getTitulo());
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(5).setCellValue(detalleBean.getCategoria());
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(6).setCellValue(detalleBean.getCalida());
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(7).setCellValue(detalleBean.getPrecio());
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(8).setCellValue(detalleBean.getFecha_pe());
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(9).setCellValue(detalleBean.getHora());
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(10).setCellValue(detalleBean.getNumero_parte());
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(11).setCellValue(detalleBean.getDate_insert());
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(12).setCellValue(detalleBean.getDate_last_update());
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(13).setCellValue(detalleBean.getStatus());
					monthCell.setCellStyle(cellstyle);
					myRow.createCell(14).setCellValue(detalleBean.getLogin());
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
		
		
		public String obtenerValor(){
			System.out.println("VALOR 01: "+getSemana());
			System.out.println("VALOR 02: "+getSelectsem());
			return SUCCESS;
		}
		
		public int getSemana() {
			return semana;
		}

		public void setSemana(int semana) {
			this.semana = semana;
		}

		public int getSelectsem() {
			return selectsem;
		}

		public void setSelectsem(int selectsem) {
			this.selectsem = selectsem;
		}

		public InputStream getInputStream1() {
			return inputStream1;
		}

		public void setInputStream1(InputStream inputStream1) {
			this.inputStream1 = inputStream1;
		}

		public int getFechaAnhio() {
			return fechaAnhio;
		}

		public void setFechaAnhio(int fechaAnhio) {
			this.fechaAnhio = fechaAnhio;
		}

		public int getFechaAnhioDown() {
			return fechaAnhioDown;
		}

		public void setFechaAnhioDown(int fechaAnhioDown) {
			this.fechaAnhioDown = fechaAnhioDown;
		}

}
