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
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;

import com.mx.totalplay.dao.PaqueteTvBrmRedIptvIncluidoParrillaTmcdoeDAO;
import com.mx.totalplay.vo.DetalleTmBrmNoIptvVO;
import com.mx.totalplay.vo.DetalleTmIptvNoBrmVO;
import com.mx.totalplay.vo.ServiceResponse;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

public class PaqueteTvBrmRedIptvIncluidoParrillaTmcodeAction extends CifrasControlAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(PaqueteTvBrmRedIptvIncluidoParrillaTmcodeAction.class);
	
	private String fecha;
	private String fechaReporte;
	private String reportFile;
	private InputStream inputStream;
	private String paquete_brm;
	private String paquete_iptv;
	
	private String fechaTabla;
		
	public String getFechaTabla() {
		return fechaTabla;
	}
	public void setFechaTabla(String fechaTabla) {
		Conversor conver=new Conversor();
		this.fechaTabla = conver.conversor(fechaTabla);
	}
	public String getPaquete_brm() {
		return paquete_brm;
	}
	public void setPaquete_brm(String paquete_brm) {
		this.paquete_brm = paquete_brm;
	}
	public String getPaquete_iptv() {
		return paquete_iptv;
	}
	public void setPaquete_iptv(String paquete_iptv) {
		this.paquete_iptv = paquete_iptv;
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
	public String getFechaReporte() {
		return fechaReporte;
	}
	public void setFechaReporte(String fechaReporte) {
		Conversor conver=new Conversor();
		this.fechaReporte=conver.conversor(fechaReporte);
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		Conversor conver=new Conversor();
		this.fecha=conver.conversor(fecha);
	}	

private List<DetalleTmIptvNoBrmVO> detalleTmIptvNoBrmVOList = new ArrayList<DetalleTmIptvNoBrmVO>();
private List<DetalleTmBrmNoIptvVO> detalleTmBrmNoIptvVOList = new ArrayList<DetalleTmBrmNoIptvVO>();
PaqueteTvBrmRedIptvIncluidoParrillaTmcdoeDAO paqueteTvBrmRedIptvIncluidoParrillaTmcdoeDAO = new PaqueteTvBrmRedIptvIncluidoParrillaTmcdoeDAO();
	
	@SuppressWarnings("unused")
	public String getPaqueteTvBrmRedIptvIncluidoParrillaTmcodeService(){
		//logger.debug("*** getPaqueteTvBrmRedIptvIncluidoService()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = paqueteTvBrmRedIptvIncluidoParrillaTmcdoeDAO.getConciliacionTmIptvBrmParrillaTmcode(getFecha());
						
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				//logger.debug("getPaqueteTvBrmRedIptvIncluidoService SUCCESS");
			} else {
//				logger.error("getPaqueteTvBrmRedIptvIncluidoService NO INFO");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}
		} catch (Exception e) {
//			logger.error("getPaqueteTvBrmRedIptvIncluidoService, ###ERROR### " + e);
			setActionError("Error.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}	
	
	@SuppressWarnings("unchecked")
	private List<DetalleTmIptvNoBrmVO> fetchList() {
		 
		  {
			  ServiceResponse result = new ServiceResponse();
				try {
					ServiceResponse respDet = new ServiceResponse();
					respDet = paqueteTvBrmRedIptvIncluidoParrillaTmcdoeDAO.getDetalleTmIptvNoBrm(getFechaReporte());
//					System.out.println("respDet getDetalleTmIptvNoBrm" + respDet.isSuccess());
					if (respDet.isSuccess()) {
						result.setSuccess(true);
						result.setMensaje(respDet.getMensaje());
						result.setResult(respDet.getResult());
						//logger.debug("getDetalleProductosBrm SUCCESS");
						
						List<DetalleTmIptvNoBrmVO> detalle = new ArrayList<DetalleTmIptvNoBrmVO>();
						detalle = (List<DetalleTmIptvNoBrmVO>)respDet.getResult();
						DetalleTmIptvNoBrmVO detalleTmIptvNoBrmVO = new DetalleTmIptvNoBrmVO();
						for(int i=0; i<detalle.size();i++){
							detalleTmIptvNoBrmVO = detalle.get(i);
							////logger.debug("Valor: " + detalleNoBrmIptv.getCuenta());
							detalleTmIptvNoBrmVOList.add(detalleTmIptvNoBrmVO);
						}
						
					} else {
//						logger.error("getDetalleFfmNoBrm ERROR");
						result.setSuccess(false);
						result.setResult(null);
						result.setMensaje(respDet.getMensaje());
					}

				} catch (Exception e) {
//					logger.error("getDetalleFfmNoBrm, ###ERROR### " + e);
				}
			  			  
		  }
		  return detalleTmIptvNoBrmVOList;
	}
	
	@SuppressWarnings("unchecked")
	private List<DetalleTmBrmNoIptvVO> fetchListIPTV() {
		 
		  {
			  ServiceResponse result = new ServiceResponse();
				try {
					ServiceResponse respDet = new ServiceResponse();
					respDet = paqueteTvBrmRedIptvIncluidoParrillaTmcdoeDAO.getDetalleTmBrmNoIptv(getFechaReporte());
					
//					System.out.println("respDet getDetalleTmBrmNoIptv" + respDet.isSuccess());
					
					if (respDet.isSuccess()) {
						result.setSuccess(true);
						result.setMensaje(respDet.getMensaje());
						result.setResult(respDet.getResult());
						//logger.debug("fetchListFFM SUCCESS");
						
						List<DetalleTmBrmNoIptvVO> detalle = new ArrayList<DetalleTmBrmNoIptvVO>();
						detalle = (List<DetalleTmBrmNoIptvVO>)respDet.getResult();
						DetalleTmBrmNoIptvVO detalleTmBrmNoIptvVO = new DetalleTmBrmNoIptvVO();
						for(int i=0; i<detalle.size();i++){
							detalleTmBrmNoIptvVO = detalle.get(i);
							////logger.debug("Valor: " + detalleNoBrmIptv.getCuenta());
							detalleTmBrmNoIptvVOList.add(detalleTmBrmNoIptvVO);
						}
						
					} else {
	//					logger.error("fetchListFFM ERROR");
						result.setSuccess(false);
						result.setResult(null);
						result.setMensaje(respDet.getMensaje());
					}

				} catch (Exception e) {
//					logger.error("fetchListFFM, ###ERROR### " + e);
				}
			  			  
		  }
		  return detalleTmBrmNoIptvVOList;
	}
	
	public String exportPaqueteTvBrmRedIptvIncluidoParrillaTmcodeDetailsTablaJson(){
//		System.out.println("json #1 - "+getFechaTabla());
		ServiceResponse result = new ServiceResponse();
		try{
			ServiceResponse respDet = new ServiceResponse();
			//logger.info("**getFechaTabla(): "+getFechaTabla());			
			
			respDet = paqueteTvBrmRedIptvIncluidoParrillaTmcdoeDAO.getDetalleTmIptvNoBrm(getFechaTabla());			

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
	
	public String exportPaqueteTvBrmRedIptvIncluidoParrillaTmcodeDetailsTablaJson2(){
//		System.out.println("json #2 - "+getFechaTabla());
		ServiceResponse result = new ServiceResponse();
		try{
			ServiceResponse respDet = new ServiceResponse();
			//logger.info("**getFechaTabla(): "+getFechaTabla());			
			//respDet = dao.detalleCanceladasBRMvsU2000(getFechaTabla());
			respDet = paqueteTvBrmRedIptvIncluidoParrillaTmcdoeDAO.getDetalleTmBrmNoIptv(getFechaTabla());			

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
	public String exportPaqueteTvBrmRedIptvIncluidoParrillaTmcodeDetails() {
		  XSSFWorkbook myWorkBook = new XSSFWorkbook();
		  XSSFSheet mySheet     = myWorkBook.createSheet("Detalle TM IPTV NO BRM");
		  XSSFSheet mySheetIPTV = myWorkBook.createSheet("BRM NO IPTV");
		  
		  try {
		   Calendar calendar = Calendar.getInstance();
		   List<DetalleTmIptvNoBrmVO> detalleBeans = fetchList();
		   List<DetalleTmBrmNoIptvVO> detalleBeansIptv = fetchListIPTV();
		   
		   String fechaReporte = getFechaReporte().replace("/", "-");
		   
		   reportFile = "DetalleTMIPtvBRM" + getFechaReporte() + "".concat(".xlsx");
		   //logger.debug("Nombre archivo: " + reportFile + "fechaReporte: " + fechaReporte);
		   //setReportFile(reportFile);
		 
		   Row headerRow = mySheet.createRow(0);
		   headerRow.setHeightInPoints(50);
		   Cell titleCell = headerRow.createCell(0);
		   titleCell.setCellValue("Detalle de los productos existentes en BRM " + fechaReporte + "");
		   
		   Row headerRowIPTV = mySheetIPTV.createRow(0);
		   headerRowIPTV.setHeightInPoints(50);
		   Cell titleCellIPTV = headerRowIPTV.createCell(0);
		   titleCellIPTV.setCellValue("Detalle de los cuentas existentes en IPTV y no en BRM " + fechaReporte + "");
	   
		   setDetailedAllInfo( myWorkBook,mySheet, detalleBeans);
		   setDetailedAllInfoIptv( myWorkBook,mySheetIPTV, detalleBeansIptv);
		 
		   try {
		    ByteArrayOutputStream boas = new ByteArrayOutputStream();
		    if(boas!=null)
		    boas.close();
			myWorkBook.write(boas);
			setInputStream(new ByteArrayInputStream(boas.toByteArray()));
			
			
			if(boas!=null)
	            boas.close();
		   } catch (IOException e) {
//			   System.out.println("-------exportPaqueteTvBrmRedIptvIncluidoParrillaTmcodeDetails"+e);
//		    e.printStackTrace();
		   }
		  } catch (Exception e) {
//		   e.printStackTrace();
		  }
		  return SUCCESS;
		 }

		@SuppressWarnings("deprecation")
		private void setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleTmIptvNoBrmVO> detalleBeans) {
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
		      	cellfont.setColor(new XSSFColor(Color.WHITE));
		      	cellfont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		        XSSFCellStyle cellstyle = myWorkBook.createCellStyle();
		        cellstyle.setFont(cellfont);
		        
			  final String[] errorSource ={"Fecha", "Id","Cuenta","Plan","TM Code",""};
			  try {
				  Row header = mySheet.createRow(0);
					Cell monthCell = header.createCell(0);
					monthCell.setCellValue("Paquete TV con BRM vs RED IPTV - Incluido (PARRILLAS-TMCODE)");
					monthCell.setCellStyle(headstyle);
					mySheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
					header = mySheet.createRow(1);
					monthCell = header.createCell(0);
					monthCell.setCellValue("Detalle de Productos Existentes en BRM");
					monthCell.setCellStyle(headstyle);					
					header = mySheet.createRow(2);
			   for (int i = 0; i < errorSource.length; i++) {
			    monthCell = header.createCell(i);
			    monthCell.setCellValue(errorSource[i]);
			    monthCell.setCellStyle(headstyle2);
				
			   }
			   mySheet.addMergedRegion(new CellRangeAddress(1,1,0,4));
			   for (DetalleTmIptvNoBrmVO detalleBean : detalleBeans) {
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
		
		 @SuppressWarnings("deprecation")
		private void setDetailedAllInfoIptv(XSSFWorkbook myWorkBook,XSSFSheet mySheet, List<DetalleTmBrmNoIptvVO> detalleBeans) {
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
			        
				  final String[] errorSource = {"Fecha", "Id","Cuenta","Plan","TM Code",""};
				  try {
					  Row header = mySheet.createRow(0);
						Cell monthCell = header.createCell(0);
						monthCell.setCellValue("Paquete TV con BRM vs RED IPTV - Incluido (Parrillas-TM Code)");
						monthCell.setCellStyle(headstyle);
						mySheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
						header = mySheet.createRow(1);
						monthCell = header.createCell(0);
						monthCell.setCellValue("Detalle de Cuentas Existentes en IPTV y no en BRM");
						monthCell.setCellStyle(headstyle);						
						header = mySheet.createRow(2);						
												
				   for (int i = 0; i < errorSource.length; i++) {
				     monthCell = header.createCell(i);
				    monthCell.setCellValue(errorSource[i]);
				    monthCell.setCellStyle(headstyle2);
					
				   }
				   mySheet.addMergedRegion(new CellRangeAddress(1,1,0,4));
				   for (DetalleTmBrmNoIptvVO detalleBean : detalleBeans) {
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
//				   e.printStackTrace();
				  }
				 
				 }
		 
	public String getParrillasvsTMCodeTabla(){
				ServiceResponse result = new ServiceResponse();
				try {
					result = paqueteTvBrmRedIptvIncluidoParrillaTmcdoeDAO.getParrillasvsTMCode();
								
					if (result.isSuccess()) {
						result.setSuccess(true);
						result.setMensaje(result.getMensaje());
						result.setResult(result.getResult());
					} else {
						result.setSuccess(false);
						result.setResult(result.getResult());
						result.setMensaje(result.getMensaje());
					}
				} catch (Exception e) {
//					logger.error("Action getParrillasvsTMCodeTabla>>>"+e);
				}
				sendJSONObjectToResponse(result);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				return null;	 
	}
	
	public String getParrillasvsTMCodeInsert(){
		ServiceResponse result = new ServiceResponse();
		try {
			result = paqueteTvBrmRedIptvIncluidoParrillaTmcdoeDAO.parrillasvsTMCodeInsert(getPaquete_brm(),getPaquete_iptv());
						
			if (result.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
			} else {
				result.setSuccess(false);
				result.setResult(result.getResult());
				result.setMensaje(result.getMensaje());
			}
		} catch (Exception e) {
		//	logger.error("Action getParrillasvsTMCodeTablaINSERT>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;	 
	}
}
