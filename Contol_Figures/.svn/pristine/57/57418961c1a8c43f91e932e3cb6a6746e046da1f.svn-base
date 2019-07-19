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
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.mx.totalplay.dao.MegasTfeDao;
import com.mx.totalplay.vo.MegasTfeDetallesVO;
import com.mx.totalplay.vo.ServiceResponse;

public class MegasTfeAction extends CifrasControlAction{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CifrasControlAction.class);
	private String reportFile;
	private InputStream inputStream;
	private List<MegasTfeDetallesVO> listaMegasTfe = new ArrayList<MegasTfeDetallesVO>();
	MegasTfeDao megasTfeDao = new MegasTfeDao();
	ServiceResponse result = new ServiceResponse();
	String fecha;
	String conciliacion;
	String id_conciliacion;
	String idConsulta;
	
// obtener JSON
	public String getMegasTfe(){
//		System.out.println("MegasTfeAction.getMegasTfe()");
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = megasTfeDao.getDetalleMegasTfe(getFecha());
			
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
			e.printStackTrace();
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	
	// CONSULTA TFE POR TIPO_CONCILIACION
	// obtener JSON
		public String getMegasTfeSoB(){
//			logger.info(" getMegasTfeSoB() _ valores obtenidos "+getFecha()+"   "+ getConciliacion());
			
			try {
				ServiceResponse respDet = new ServiceResponse();
				respDet = megasTfeDao.getDetalleMegasTfeSoB(getFecha(), getConciliacion());
				
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
				e.printStackTrace();
			}
			sendJSONObjectToResponse(result);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
	return null;
		}
		
		
// CONSULTA POR DETALLE 
public List<MegasTfeDetallesVO> megasTfeDetalle() {
//			System.out.println("MegasTfeAction.megasTfeDetalle()"+ getId_conciliacion());
			try{
				ServiceResponse respDet = new ServiceResponse();
				respDet = megasTfeDao.getDetalleMegasTfModal(getId_conciliacion());
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
			}
			sendJSONObjectToResponse(result);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			  return null;
		}

// CONSULTA PARA GENERAR  LISTA DE DATOS PARA EXCEL 
@SuppressWarnings({ "unused", "unchecked" })
private List<MegasTfeDetallesVO> datosMegasTfeSoB() {
//	logger.info("online ok.."+ getIdConsulta());
		  {
			  ServiceResponse result = new ServiceResponse();
				try {
					ServiceResponse respDet = new ServiceResponse();
					respDet = megasTfeDao.getDetalleMegasTfModal(getIdConsulta());
//					System.out.println("la fecha"+getFechaReporte());
					if (respDet.isSuccess()) {
						result.setSuccess(true);
						result.setMensaje(respDet.getMensaje());
						result.setResult(respDet.getResult());
						
						List<MegasTfeDetallesVO> detalle = new ArrayList<MegasTfeDetallesVO>();
						detalle = (List<MegasTfeDetallesVO>)respDet.getResult();
						MegasTfeDetallesVO detalleMegasTfe = new MegasTfeDetallesVO();
						for(int i=0; i<detalle.size();i++){
							detalleMegasTfe = detalle.get(i);
							////logger.debug("Valor: " + detalleNoBrmIptv.getCuenta());
							listaMegasTfe.add(detalleMegasTfe);
						}
					} else {
//						logger.error("getConciliacionIptvBrmService ERROR");
						result.setSuccess(false);
						result.setResult(null);
						result.setMensaje(respDet.getMensaje());
					}
				} catch (Exception e) {
//					logger.error("getConciliacionIptvBrmService, ###ERROR### " + e);
				}
		  }
		  return listaMegasTfe;
	}

// CREASION DE EL ARCHIVO EXCEL
public String exportMegasTfeSoB() {
	  XSSFWorkbook myWorkBook = new XSSFWorkbook();
	  XSSFSheet mySheet = myWorkBook.createSheet("Megas TFE");
	  
	  try {
	   Calendar calendar = Calendar.getInstance();
	   List<MegasTfeDetallesVO> detalleBeans = datosMegasTfeSoB();
	   
	   reportFile = "DetalleMegasTfe" + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH)
	     + "".concat(".xlsx");
	 
	   Row headerRow = mySheet.createRow(0);
	   headerRow.setHeightInPoints(50);
	   Cell titleCell = headerRow.createCell(0);
	   titleCell.setCellValue("Detalle de Megas  " + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + "");
	   
	   setDetailedAllInfo(myWorkBook,mySheet, detalleBeans);
	 
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


	private void setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<MegasTfeDetallesVO> detalleBeans) {
//		System.out.println("MegasTfeAction.setDetailedAllInfo()");
		
		int rowNum = 1;
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
	        
		  final String[] errorSource = { "ID_CONCILIACION", "FECHA","SN","MEGAS RED","MEGAS BRM",""};
		  try {
			  Row header = mySheet.createRow(0);
				Cell monthCell = header.createCell(0);
//				monthCell.setCellValue("STB TV con BRM vs RED IPTV - Incluido");
//				monthCell.setCellStyle(headstyle);
//				mySheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
				header = mySheet.createRow(1);
//				monthCell = header.createCell(0);
//				monthCell.setCellValue("Detalle BRM no IPTV");
//				monthCell.setCellStyle(headstyle);

				
				header = mySheet.createRow(0);
		   for (int i = 0; i < errorSource.length; i++) {
		     monthCell = header.createCell(i);
		    monthCell.setCellValue(errorSource[i]);
			monthCell.setCellStyle(headstyle2);
			
		   }
//		   mySheet.addMergedRegion(new CellRangeAddress(1,1,0,5));
		   for (MegasTfeDetallesVO detalleBean : detalleBeans) {
		    myRow = mySheet.createRow(rowNum++);
		    myRow.createCell(0).setCellValue(detalleBean.getId_conciliacion());
			monthCell.setCellStyle(cellstyle);
		    myRow.createCell(1).setCellValue(detalleBean.getFecha());
			monthCell.setCellStyle(cellstyle);
		    myRow.createCell(2).setCellValue(detalleBean.getSn());
			monthCell.setCellStyle(cellstyle);
		    myRow.createCell(3).setCellValue(detalleBean.getMegas_red());
			monthCell.setCellStyle(cellstyle);
		    myRow.createCell(4).setCellValue(detalleBean.getMegas_brm());
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
//		   e.printStackTrace();
		  }
		 
		 }
	
// setter y getters
	public String getFecha() { return fecha; }
	public void setFecha(String fecha) { 
		Conversor conversion = new Conversor();
		this.fecha = conversion.conversor(fecha); }

	public String getConciliacion() {
		return conciliacion;
	}

	public void setConciliacion(String conciliacion) {
		this.conciliacion = conciliacion;
	}

	public String getId_conciliacion() {
		return id_conciliacion;
	}

	public void setId_conciliacion(String id_conciliacion) {
		this.id_conciliacion = id_conciliacion;
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

	public String getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(String idConsulta) {
		this.idConsulta = idConsulta;
	}
}
