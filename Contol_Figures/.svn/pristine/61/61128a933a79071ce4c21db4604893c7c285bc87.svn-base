package com.mx.totalplay.struts.action;
/**
 * 
 * @author 
 * ACTION PARA EL REPORTE Instalaciones Nuevas vs Cuentas Activadas FFM - BRM
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
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;

import com.mx.totalplay.dao.PaquetesServiciosActivadosBrmPMDAO;
import com.mx.totalplay.vo.DetalleBrmNoFfmVO;
import com.mx.totalplay.vo.DetalleIPTVAddONSNoBRMVO;
import com.mx.totalplay.vo.DetalleProductosBrmVO;
import com.mx.totalplay.vo.ServiceResponse;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

public class PaquetesServiciosActivadosBrmPMAction extends CifrasControlAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(PaquetesServiciosActivadosBrmPMAction.class);
	PaquetesServiciosActivadosBrmPMDAO paquetesServiciosActivadosBrmPMDAO = new PaquetesServiciosActivadosBrmPMDAO();
	String fecha;
	String fechaReporte;
	
	private List<DetalleProductosBrmVO> detalleProductosBrmVOList = new ArrayList<DetalleProductosBrmVO>();
	@SuppressWarnings("unused")
	private List<DetalleBrmNoFfmVO> detalleBrmNoFfmVOList = new ArrayList<DetalleBrmNoFfmVO>();
	private String reportFile;
	
	private InputStream inputStream;
	
	private String fechaTabla;
	
	public String getFechaTabla() {
		return fechaTabla;
	}


	public void setFechaTabla(String fechaTabla) {
		Conversor conver=new Conversor();
		this.fechaTabla = conver.conversor(fechaTabla);
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		Conversor conver=new Conversor();
		this.fecha=conver.conversor(fecha);
	}


	public String execute(){
		
//		System.out.println("Entrando a Excecute.....");
		
		return SUCCESS;
	}	
	
	
	

	@SuppressWarnings("unused")
	public String getPaquetesServiciosActivadosBrmPMService(){
		//logger.debug("*** getPaquetesServiciosActivadosBrmPMService()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = paquetesServiciosActivadosBrmPMDAO.getPaquetesServiciosActivadosBrmPM(getFecha());
			
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				//logger.debug("getPaquetesServiciosActivadosBrmPMService SUCCESS");
			} else {
//				logger.error("getPaquetesServiciosActivadosBrmPMService NO INFO");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}

		} catch (Exception e) {
//			logger.error("getPaquetesServiciosActivadosBrmPMService, ###ERROR### " + e);
			setActionError("Error.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	
	public String exportPaquetesServiciosActivadosBrmPMDetailsTablaJson(){
		ServiceResponse result = new ServiceResponse();
		try{
			ServiceResponse respDet = new ServiceResponse();
//			logger.info("**getFechaTabla(): "+getFechaTabla());			
			//respDet = paqvsProductIncBRMDAO.getDetallePaqvsProductIncBRM(getFechaTabla());
			
			respDet = paquetesServiciosActivadosBrmPMDAO.getDetalleProductosBrm(getFechaTabla());

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

	@SuppressWarnings("unused")
	public String exportPaquetesServiciosActivadosBrmPMDetails() {
		  XSSFWorkbook myWorkBook = new XSSFWorkbook();
		  XSSFSheet mySheet = myWorkBook.createSheet("Detalle BRM");
		 // XSSFSheet mySheetFFM = myWorkBook.createSheet("FFM no BRM");
		  
		  
		  
		  try {
		   Calendar calendar = Calendar.getInstance();
			ServiceResponse detalleBeans = paquetesServiciosActivadosBrmPMDAO.getDetalleProductosBrm(getFechaReporte());

		   
		   String fechaReporte = getFechaReporte().replace("/", "-");
		   
		   reportFile = "DetalleProductosBRM" + getFechaReporte()
		     + "".concat(".xlsx");
		   //logger.debug("Nombre archivo: " + reportFile + "fechaReporte: " + fechaReporte);
		   //setReportFile(reportFile);
		 
		   Row headerRow = mySheet.createRow(0);
		   headerRow.setHeightInPoints(50);
		   Cell titleCell = headerRow.createCell(0);
		   titleCell.setCellValue("Detalle de los productos existentes en BRM " + fechaReporte + "");
		   
//		   Row headerRowIPTV = mySheetFFM.createRow(0);
//		   headerRowIPTV.setHeightInPoints(50);
//		   Cell titleCellIPTV = headerRowIPTV.createCell(0);
//		   titleCellIPTV.setCellValue("Detalle de los cuentas existentes en BRM y no en FFM " + fechaReporte + "");
//		 
		   
			setDetailedAllInfo(myWorkBook,mySheet, (List<DetalleProductosBrmVO>) detalleBeans.getResult());
//		   setDetailedAllInfo( myWorkBook,mySheet, detalleBeans);
		  // setDetailedAllInfoFfm(mySheetFFM, detalleBeansFFM);
		 
		   try {
		    ByteArrayOutputStream boas = new ByteArrayOutputStream();
		    if(boas!=null)
		    boas.close();
			myWorkBook.write(boas);
			setInputStream(new ByteArrayInputStream(boas.toByteArray()));
			
			
			if(boas!=null)
	            boas.close();
		   } catch (IOException e) {
//		    e.printStackTrace();
		   }
		  } catch (Exception e) {
//		   e.printStackTrace();
		  }
		  return SUCCESS;
		 }

		private void setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,
			   List<DetalleProductosBrmVO> detalleBeans) {
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
		        
		        
			  final String[] errorSource = { "Fecha", "Id","Cuenta","Plan","TM Code","Empresa","Tipo de Servicio","POID_Product","Nombre del Producto","Descripción","Cantidad","Tipo de Producto","" };
			  try {
				  Row header = mySheet.createRow(0);
					Cell monthCell = header.createCell(0);
					monthCell.setCellValue("Paquetes vs. Servicios Activados BRM - PRODUCT MASTER");
					monthCell.setCellStyle(headstyle);
					mySheet.addMergedRegion(new CellRangeAddress(0,0,0,11));
					header = mySheet.createRow(1);
					monthCell = header.createCell(0);
					monthCell.setCellValue("Detalle  Productos Existentes en BRM");
					monthCell.setCellStyle(headstyle);

					
					header = mySheet.createRow(2);
			   for (int i = 0; i < errorSource.length; i++) {
			    monthCell = header.createCell(i);
			    monthCell.setCellValue(errorSource[i]);
			    monthCell.setCellStyle(headstyle2);
				
			   }
			   mySheet.addMergedRegion(new CellRangeAddress(1,1,0,11));
			   for (DetalleProductosBrmVO detalleBean : detalleBeans) {
			    myRow = mySheet.createRow(rowNum++);
			    myRow.createCell(0).setCellValue(detalleBean.getFecha());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(1).setCellValue(detalleBean.getId());
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
			    myRow.createCell(7).setCellValue(detalleBean.getPoid_product());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(8).setCellValue(detalleBean.getNombre_producto());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(9).setCellValue(detalleBean.getDescr());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(10).setCellValue(detalleBean.getCantidad());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(11).setCellValue(detalleBean.getTipo_producto());
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
//			   e.printStackTrace();
			  }
			 
			 }
//		
//		private void setDetailedAllInfoFfm(XSSFSheet mySheet,
//				   List<DetalleBrmNoFfmVO> detalleBeans) {
//				  int rowNum = 2;
//				  XSSFRow myRow = null;
//				  final String[] errorSource = { "FECHA", "ID_CONCILIACION","CUENTA","PLAN","FECHA_ACTIVACION","EMPRESA" };
//				  try {
//				   Row header = mySheet.createRow(1);
//				   for (int i = 0; i < errorSource.length; i++) {
//				    Cell monthCell = header.createCell(i);
//				    monthCell.setCellValue(errorSource[i]);
//				   }
//				   for (DetalleBrmNoFfmVO detalleBean : detalleBeans) {
//				    myRow = mySheet.createRow(rowNum++);
//				    myRow.createCell(0).setCellValue(detalleBean.getFecha());
//				    myRow.createCell(1).setCellValue(detalleBean.getId_conciliacion());
//				    myRow.createCell(2).setCellValue(detalleBean.getCuenta());
//				    myRow.createCell(3).setCellValue(detalleBean.getPlan());
//				    myRow.createCell(4).setCellValue(detalleBean.getFecha_activacion());
//				    myRow.createCell(5).setCellValue(detalleBean.getEmpresa());
//				    
//				   }
//				  } catch (Exception e) {
//				   e.printStackTrace();
//				  }
//				 
//				 }
//

		

		public String getReportFile() {
			return reportFile;
		}

		public List<DetalleProductosBrmVO> getDetalleProductosBrmVOList() {
			return detalleProductosBrmVOList;
		}


		public void setDetalleProductosBrmVOList(
				List<DetalleProductosBrmVO> detalleProductosBrmVOList) {
			this.detalleProductosBrmVOList = detalleProductosBrmVOList;
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


		public String getFechaReporte() {
			return fechaReporte;
		}


		public void setFechaReporte(String fechaReporte) {
			Conversor conver=new Conversor();
			this.fechaReporte=conver.conversor(fechaReporte);
		}
		
		
		
	
}
