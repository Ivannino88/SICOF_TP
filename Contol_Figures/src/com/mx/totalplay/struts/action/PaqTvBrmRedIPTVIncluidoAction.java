package com.mx.totalplay.struts.action;
/**
 * 
 * @author 
 * ACTION PARA EL REPORTE
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

import com.mx.totalplay.dao.ConciliacionIptvBrmDAO;
import com.mx.totalplay.vo.DetalleIptvNoBrm;
import com.mx.totalplay.vo.DetalleNoBrmIptv;
import com.mx.totalplay.vo.ServiceResponse;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

public class PaqTvBrmRedIPTVIncluidoAction extends CifrasControlAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(PaqTvBrmRedIPTVIncluidoAction.class);
	ConciliacionIptvBrmDAO conciliacionIptvBrmDAO = new ConciliacionIptvBrmDAO();
	
	String fecha;
	String todos;
	String fechaReporte;
	String conciliacion;
	String id_detalle;
	
	String fechaTabla;
	String id_detalleTabla;
	
	String idDetalleTabla; 
	private String reportFile;
	private InputStream inputStream;
	private List<DetalleNoBrmIptv> detalleNoBrmIptvList = new ArrayList<DetalleNoBrmIptv>();
	private List<DetalleIptvNoBrm> detalleIptvNoBrmList = new ArrayList<DetalleIptvNoBrm>();
	
	public String getTodos() {
		return todos;
	}
	public void setTodos(String todos) {
		this.todos = todos;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		Conversor conver=new Conversor();
		this.fecha=conver.conversor(fecha);
	}
	public List<DetalleNoBrmIptv> getDetalleNoBrmIptvList() {
		return detalleNoBrmIptvList;
	}
	public void setDetalleNoBrmIptvList(List<DetalleNoBrmIptv> detalleNoBrmIptvList) {
		this.detalleNoBrmIptvList = detalleNoBrmIptvList;
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
	public String getConciliacion() {
		return conciliacion;
	}
	public void setConciliacion(String conciliacion) {
		this.conciliacion = conciliacion;
	}
	public String getId_detalle() {
		return id_detalle;
	}
	public void setId_detalle(String id_detalle) {
		this.id_detalle = id_detalle;
	}
	
	public String getFechaTabla() {
		return fechaTabla;
	}
	public void setFechaTabla(String fechaTabla) {
		this.fechaTabla = fechaTabla;
	}
	
	
	public String getIdDetalleTabla() {
		return idDetalleTabla;
	}
	public void setIdDetalleTabla(String idDetalleTabla) {
		this.idDetalleTabla = idDetalleTabla;
	}
	public String execute(){
		
//		System.out.println("Entrando a Excecute.....");
		
		return SUCCESS;
	}	
//*****************************************************************  REPORTE PRINCIPAL
	
	@SuppressWarnings("unused")
	public String getConciliacionIptvBrmService(){
		System.out	.println("PaqTvBrmRedIPTVIncluidoAction.getConciliacionIptvBrmService() stb");
		logger.debug("*** getConciliacionIptvBrmService() stb");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = conciliacionIptvBrmDAO.getConciliacionIptvBrm(getFecha(),getConciliacion());
			
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				//logger.debug("getConciliacionIptvBrmService SUCCESS");
			} else {
//				logger.error("getConciliacionIptvBrmService ERROR");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}

		} catch (Exception e) {
//			logger.error("getConciliacionIptvBrmService, ###ERROR### " + e);
			setActionError("Error.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
// **********************************************************************  DETALLES DAO
	
	@SuppressWarnings("unchecked")
	private List<DetalleNoBrmIptv> fetchList() {
		 System.out.println("PaqTvBrmRedIPTVIncluidoAction.fetchList()");
		 logger.debug("*** fetchList() ");
		  {
			  ServiceResponse result = new ServiceResponse();
				try {
					ServiceResponse respDet = new ServiceResponse();
					respDet = conciliacionIptvBrmDAO.getDetalleNoBrmIptv(getFechaReporte(),getId_detalle());
//					System.out.println("la fecha "+getFechaReporte());
					if (respDet.isSuccess()) {
						result.setSuccess(true);
						result.setMensaje(respDet.getMensaje());
						result.setResult(respDet.getResult());
						//logger.debug("getConciliacionIptvBrmService SUCCESS");
						
						List<DetalleNoBrmIptv> detalle = new ArrayList<DetalleNoBrmIptv>();
						detalle = (List<DetalleNoBrmIptv>)respDet.getResult();
						DetalleNoBrmIptv detalleNoBrmIptv = new DetalleNoBrmIptv();
						for(int i=0; i<detalle.size();i++){
							detalleNoBrmIptv = detalle.get(i);
							////logger.debug("Valor: " + detalleNoBrmIptv.getCuenta());
							detalleNoBrmIptvList.add(detalleNoBrmIptv);
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
		  return detalleNoBrmIptvList;
	}
	
	@SuppressWarnings("unchecked")
	private List<DetalleIptvNoBrm> fetchListIPTV() {
		 System.out.println("PaqTvBrmRedIPTVIncluidoAction.fetchListIPTV()");
		 logger.debug("*** fetchListIPTV() ");
		  {
			  ServiceResponse result = new ServiceResponse();
				try {
					ServiceResponse respDet = new ServiceResponse();
					respDet = conciliacionIptvBrmDAO.getDetalleIptvNoBrm(getFechaReporte(),getId_detalle());
					if (respDet.isSuccess()) {
						result.setSuccess(true);
						result.setMensaje(respDet.getMensaje());
						result.setResult(respDet.getResult());
						//logger.debug("getDetalleIptvNoBrm SUCCESS");
						
						List<DetalleIptvNoBrm> detalle = new ArrayList<DetalleIptvNoBrm>();
						detalle = (List<DetalleIptvNoBrm>)respDet.getResult();
						DetalleIptvNoBrm detalleIptvNoBrm = new DetalleIptvNoBrm();
						for(int i=0; i<detalle.size();i++){
							detalleIptvNoBrm = detalle.get(i);
							////logger.debug("Valor: " + detalleNoBrmIptv.getCuenta());
							detalleIptvNoBrmList.add(detalleIptvNoBrm);
						}
						
					} else {
//						logger.error("getDetalleIptvNoBrm ERROR");
						result.setSuccess(false);
						result.setResult(null);
						result.setMensaje(respDet.getMensaje());
					}

				} catch (Exception e) {
//					logger.error("getDetalleIptvNoBrm, ###ERROR### " + e);
				}
			  			  
		  }
		  return detalleIptvNoBrmList;
	}
	
	@SuppressWarnings("unused")
	public String exportDetallePaqTvBrmRedIPTVIncluidoTablaJson(){
		System.out	.println("PaqTvBrmRedIPTVIncluidoAction.exportDetallePaqTvBrmRedIPTVIncluidoTablaJson()");
		logger.debug("*** exportDetallePaqTvBrmRedIPTVIncluidoTablaJson()");
		logger.info("*** exportDetallePaqTvBrmRedIPTVIncluidoTablaJson()");
		System.out.println("fecha a evaluar"+getFechaTabla());
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
//			logger.info("getFechaTabla(): " + getFechaTabla() + " getIdDetalleTabla: " + getIdDetalleTabla());
			respDet = conciliacionIptvBrmDAO.getDetalleNoBrmIptv(getFechaTabla(), getIdDetalleTabla());
//			logger.info("respDet.isSuccess: " + respDet.isSuccess());
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				//logger.debug("getInstVsSalidasAlmacenSAPService SUCCESS");
			} else {
//				logger.error("getInstVsSalidasAlmacenSAPService NO INFO");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}

		} catch (Exception e) {
//			logger.error("getInstVsSalidasAlmacenSAPService, ###ERROR### " + e);
			setActionError("Error.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		logger.info("*** FIN exportDetallePaqTvBrmRedIPTVIncluidoTablaJson()");
		return null;
	}
	
	@SuppressWarnings("unused")
	public String exportDetallePaqTvBrmRedIPTVIncluidoTablaJson2(){
		System.out	.println("PaqTvBrmRedIPTVIncluidoAction.exportDetallePaqTvBrmRedIPTVIncluidoTablaJson2()");
		logger.debug("*** exportDetallePaqTvBrmRedIPTVIncluidoTablaJson2");
		logger.info("*** exportDetallePaqTvBrmRedIPTVIncluidoTablaJson2");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = conciliacionIptvBrmDAO.getDetalleIptvNoBrm(getFechaTabla(),getIdDetalleTabla());
			
//			System.out.println("fecha salidas "+getFecha());
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				//logger.debug("getInstVsSalidasAlmacenSAPService SUCCESS");
			} else {
//				logger.error("getInstVsSalidasAlmacenSAPService NO INFO");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}

		} catch (Exception e) {
//			logger.error("getInstVsSalidasAlmacenSAPService, ###ERROR### " + e);
			setActionError("Error.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		logger.info("*** FIN  exportDetallePaqTvBrmRedIPTVIncluidoTablaJson2");
		return null;
	}
	
	
	// **********************************************************************  DETALLES CREACION
	
	public String exportDetallePaqTvBrmRedIPTVIncluido() {
		System.out	.println("PaqTvBrmRedIPTVIncluidoAction.exportDetallePaqTvBrmRedIPTVIncluido()");
		logger.debug("*** exportDetallePaqTvBrmRedIPTVIncluido()  "+getFechaReporte()+")");
		logger.info("*** exportDetallePaqTvBrmRedIPTVIncluido()  "+getFechaReporte()+")");
		  XSSFWorkbook myWorkBook = new XSSFWorkbook();
		  XSSFSheet mySheet = myWorkBook.createSheet("BRM no IPTV");
		  XSSFSheet mySheetIPTV = myWorkBook.createSheet("IPTV no BRM");
		  
			//
		  
		  try {
		   Calendar calendar = Calendar.getInstance();
		   List<DetalleNoBrmIptv> detalleBeans = fetchList();
		   List<DetalleIptvNoBrm> detalleBeansIPTV = fetchListIPTV();
		   
		   reportFile = "PaqueteTvBrmRedIptv" + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH)
		     + "".concat(".xlsx");
		   //logger.debug("Nombre archivo: " + reportFile);
		   //setReportFile(reportFile);
		 
		   Row headerRow = mySheet.createRow(0);
		   headerRow.setHeightInPoints(50);
		   Cell titleCell = headerRow.createCell(0);
		   titleCell.setCellValue("Detalle de los cuentas existentes en BRM y no en IPTV " + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + "");
		   
		   Row headerRowIPTV = mySheetIPTV.createRow(0);
		   headerRowIPTV.setHeightInPoints(50);
		   Cell titleCellIPTV = headerRowIPTV.createCell(0);
		   titleCellIPTV.setCellValue("Detalle de los cuentas existentes en IPTV y no en BRM " + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + "");
		 
		   
		   
		   setDetailedAllInfo(myWorkBook,mySheet, detalleBeans);
		   setDetailedAllInfoIptv(myWorkBook,mySheetIPTV, detalleBeansIPTV);
		 
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
		  logger.info("*** FIN exportDetallePaqTvBrmRedIPTVIncluido()  ");
		  return SUCCESS;
		 }



		private void setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,
			   List<DetalleNoBrmIptv> detalleBeans) {
			System.out	.println("PaqTvBrmRedIPTVIncluidoAction.setDetailedAllInfo()");
			logger.info("*** setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet, List<DetalleNoBrmIptv> detalleBeans) ");
			logger.info("*** total a escribir en excel ::  List<DetalleNoBrmIptv> ---> "+ detalleBeans.size());
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
		        
		        
			  final String[] errorSource = { "Fecha", "Id de Conciliación","Cuenta","Plan","STB","TM Code",""};
			  try {
				  Row header = mySheet.createRow(0);
					Cell monthCell = header.createCell(0);
//					monthCell.setCellValue("STB TV con BRM vs RED IPTV - Incluido");
//					monthCell.setCellStyle(headstyle);
//					mySheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
					header = mySheet.createRow(1);
//					monthCell = header.createCell(0);
//					monthCell.setCellValue("Detalle BRM no IPTV");
//					monthCell.setCellStyle(headstyle);

					
					header = mySheet.createRow(0);
			   for (int i = 0; i < errorSource.length; i++) {
			     monthCell = header.createCell(i);
			    monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
				
			   }
//			   mySheet.addMergedRegion(new CellRangeAddress(1,1,0,5));
			   for (DetalleNoBrmIptv detalleBean : detalleBeans) {
			    myRow = mySheet.createRow(rowNum++);
			    myRow.createCell(0).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
			    myRow.createCell(1).setCellValue(detalleBean.getId_conciliacion());
				monthCell.setCellStyle(cellstyle);
			    myRow.createCell(2).setCellValue(detalleBean.getCuenta());
				monthCell.setCellStyle(cellstyle);
			    myRow.createCell(3).setCellValue(detalleBean.getPlan());
				monthCell.setCellStyle(cellstyle);
			    myRow.createCell(4).setCellValue(detalleBean.getStb());
				monthCell.setCellStyle(cellstyle);
			    myRow.createCell(5).setCellValue(detalleBean.getTmcode());
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
			  logger.info("*** FIN total a escribir en excel ::  List<DetalleNoBrmIptv> ---> ");
			 }
		
		
		
		
		private void setDetailedAllInfoIptv(XSSFWorkbook myWorkBook,XSSFSheet mySheet,
				   List<DetalleIptvNoBrm> detalleBeans) {
					System.out	.println("PaqTvBrmRedIPTVIncluidoAction.setDetailedAllInfoIptv()");
					logger.info("*** setDetailedAllInfoIptv(XSSFWorkbook myWorkBook,XSSFSheet mySheet, List<DetalleIptvNoBrm> detalleBeans)  ");
					logger.info("*** total a escribir en excel ::   List<DetalleIptvNoBrm>  --> "+ detalleBeans.size());
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
			        
				  final String[] errorSource = { "Fecha", "Id de Conciliación","Cuenta","Nombre","STB",""};
				  try {
					  Row header = mySheet.createRow(0);
						Cell monthCell = header.createCell(0);
//						monthCell.setCellValue("STB TV con BRM vs RED IPTV - Incluido");
//						monthCell.setCellStyle(headstyle);
//						mySheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
						header = mySheet.createRow(1);
//						monthCell = header.createCell(0);
//						monthCell.setCellValue("Detalle IPTV no BRM");
//						monthCell.setCellStyle(headstyle);

						
						header = mySheet.createRow(0);
				   for (int i = 0; i < errorSource.length; i++) {
				     monthCell = header.createCell(i);
				    monthCell.setCellValue(errorSource[i]);
					monthCell.setCellStyle(headstyle2);
					
				   }
//				   mySheet.addMergedRegion(new CellRangeAddress(1,1,0,4));
				   for (DetalleIptvNoBrm detalleBean : detalleBeans) {
				    myRow = mySheet.createRow(rowNum++);
				    myRow.createCell(0).setCellValue(detalleBean.getFecha());
					monthCell.setCellStyle(cellstyle);
				    myRow.createCell(1).setCellValue(detalleBean.getId_conciliacion());
					monthCell.setCellStyle(cellstyle);
				    myRow.createCell(2).setCellValue(detalleBean.getCuenta());
					monthCell.setCellStyle(cellstyle);
				    myRow.createCell(3).setCellValue(detalleBean.getNombre());
					monthCell.setCellStyle(cellstyle);
				    myRow.createCell(4).setCellValue(detalleBean.getStb());
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
				  logger.info("*** FIN total a escribir en excel ::   List<DetalleIptvNoBrm> ");
				 }
	
		

		
	
}
