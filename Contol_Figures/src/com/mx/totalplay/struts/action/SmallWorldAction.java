package com.mx.totalplay.struts.action;
/**
 * 
 * @author 
 * ACTION PARA EL REPORTE DE INSTALACIONES VS ALMACEN CIFRAS SAP-BRM
 */
import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//import org.apache.poi.hssf.util.CellRangeAddress;
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

import com.mx.totalplay.dao.SmallWorldDAO;
import com.mx.totalplay.vo.DetalleBrmNoSapVO;
import com.mx.totalplay.vo.DetalleFfmCuentasNoSwVO;
import com.mx.totalplay.vo.DetalleSWCuentasNoFFMVO;
import com.mx.totalplay.vo.DetalleSWDatosNoFFMVO;
import com.mx.totalplay.vo.ServiceResponse;


public class SmallWorldAction extends CifrasControlAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(SmallWorldAction.class);
	SmallWorldDAO smallWorldDAO = new SmallWorldDAO();
	String fecha;
	String fechaReporte;
	
	private List<DetalleFfmCuentasNoSwVO> detalleFfmCuentasNoSwVOList = new ArrayList<DetalleFfmCuentasNoSwVO>();
	private List<DetalleBrmNoSapVO> detalleBrmNoSapVOList = new ArrayList<DetalleBrmNoSapVO>();
	private List<DetalleSWCuentasNoFFMVO> detalleSWCuentasNoFFMVOList = new ArrayList<DetalleSWCuentasNoFFMVO>();
	private List<DetalleSWDatosNoFFMVO> detalleSWDatosNoFFMVOList  = new ArrayList<DetalleSWDatosNoFFMVO>();
	
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


	public String execute(){
		
		//System.out.println("Entrando a Excecute.....");
		
		return SUCCESS;
	}	
	
	
	

	@SuppressWarnings("unused")
	public String getSmallWorld(){
		//logger.debug("*** getInstVsSalidasAlmacenSAPService()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = smallWorldDAO.getSmallWorld(getFecha());
			
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				//logger.debug("getInstVsSalidasAlmacenSAPService SUCCESS");
			} else {
//				logger.error("getSmallWorld NO INFO");
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
		return null;
	}
	
	
	
	@SuppressWarnings("unchecked")
	private List<DetalleFfmCuentasNoSwVO> fetchList() {
		 
		  {
			  ServiceResponse result = new ServiceResponse();
				try {
					ServiceResponse respDet = new ServiceResponse();
					respDet = smallWorldDAO.getDetalleFfmCuentasNoSw(getFechaReporte());
					//System.out.println("respDet.isSuccess()"+respDet.isSuccess());
					if (respDet.isSuccess()) {
						result.setSuccess(true);
						result.setMensaje(respDet.getMensaje());
						result.setResult(respDet.getResult());
						//logger.debug("getDetalleFfmNoBrm SUCCESS");
						
						List<DetalleFfmCuentasNoSwVO> detalle = new ArrayList<DetalleFfmCuentasNoSwVO>();
						detalle = (List<DetalleFfmCuentasNoSwVO>)respDet.getResult();
						DetalleFfmCuentasNoSwVO detalleFfmCuentasNoSwVO = new DetalleFfmCuentasNoSwVO();
						for(int i=0; i<detalle.size();i++){
							detalleFfmCuentasNoSwVO = detalle.get(i);
							////logger.debug("Valor: " + detalleNoBrmIptv.getCuenta());
							detalleFfmCuentasNoSwVOList.add(detalleFfmCuentasNoSwVO);
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
		  return detalleFfmCuentasNoSwVOList;
	}
	
	@SuppressWarnings("unchecked")
	private List<DetalleSWCuentasNoFFMVO> fetchListNoFFM() {
		 
		  {
			  ServiceResponse result = new ServiceResponse();
				try {
					ServiceResponse respDet = new ServiceResponse();
					respDet = smallWorldDAO.getDetalleSWCuentasNoFFM(getFechaReporte());
					
					if (respDet.isSuccess()) {
						result.setSuccess(true);
						result.setMensaje(respDet.getMensaje());
						result.setResult(respDet.getResult());
						//logger.debug("fetchListFFM SUCCESS");
						
						List<DetalleSWCuentasNoFFMVO> detalle = new ArrayList<DetalleSWCuentasNoFFMVO>();
						detalle = (List<DetalleSWCuentasNoFFMVO>)respDet.getResult();
						DetalleSWCuentasNoFFMVO detalleSWCuentasNoFFMVO = new DetalleSWCuentasNoFFMVO();
						for(int i=0; i<detalle.size();i++){
							detalleSWCuentasNoFFMVO = detalle.get(i);
							////logger.debug("Valor: " + detalleNoBrmIptv.getCuenta());
							detalleSWCuentasNoFFMVOList.add(detalleSWCuentasNoFFMVO);
						}
						
					} else {
//						logger.error("fetchListNoFFM ERROR");
						result.setSuccess(false);
						result.setResult(null);
						result.setMensaje(respDet.getMensaje());
					}

				} catch (Exception e) {
//					logger.error("fetchListNoFFM, ###ERROR### " + e);
				}
			  			  
		  }
		  return detalleSWCuentasNoFFMVOList;
	}
	
	
	@SuppressWarnings("unchecked")
	private List<DetalleSWDatosNoFFMVO> fetchListDatosNoFFM() {
		 
		  {
			  ServiceResponse result = new ServiceResponse();
				try {
					ServiceResponse respDet = new ServiceResponse();
					respDet = smallWorldDAO.getDetalleSWDatosNoFFM(getFechaReporte());
					
					if (respDet.isSuccess()) {
						result.setSuccess(true);
						result.setMensaje(respDet.getMensaje());
						result.setResult(respDet.getResult());
						//logger.debug("fetchListDatosNoFFM SUCCESS");
						
						List<DetalleSWDatosNoFFMVO> detalle = new ArrayList<DetalleSWDatosNoFFMVO>();
						detalle = (List<DetalleSWDatosNoFFMVO>)respDet.getResult();
						DetalleSWDatosNoFFMVO detalleSWDatosNoFFMVO = new DetalleSWDatosNoFFMVO();
						for(int i=0; i<detalle.size();i++){
							detalleSWDatosNoFFMVO = detalle.get(i);
							////logger.debug("Valor: " + detalleNoBrmIptv.getCuenta());
							detalleSWDatosNoFFMVOList.add(detalleSWDatosNoFFMVO);
						}
						
					} else {
//						logger.error("fetchListDatosNoFFM ERROR");
						result.setSuccess(false);
						result.setResult(null);
						result.setMensaje(respDet.getMensaje());
					}

				} catch (Exception e) {
//					logger.error("fetchListNoFFM, ###ERROR### " + e);
				}
			  			  
		  }
		  return detalleSWDatosNoFFMVOList;
	}	
	
	
	public String exportDetalleFfmCuentasNoSwDetailsTablaJson(){
		ServiceResponse result = new ServiceResponse();
		try{
			ServiceResponse respDet = new ServiceResponse();
//			logger.info("**getFechaTabla(): "+getFechaTabla());			
			respDet = smallWorldDAO.getDetalleFfmCuentasNoSw(getFechaTabla());

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
	
	public String exportDetalleFfmCuentasNoSwDetailsTablaJson2(){
		ServiceResponse result = new ServiceResponse();
		try{
			ServiceResponse respDet = new ServiceResponse();
//			logger.info("**getFechaTabla(): "+getFechaTabla());			
			respDet = smallWorldDAO.getDetalleSWCuentasNoFFM(getFechaTabla());

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
	
	public String exportDetalleFfmCuentasNoSwDetailsTablaJson3(){
		ServiceResponse result = new ServiceResponse();
		try{
			ServiceResponse respDet = new ServiceResponse();
//			logger.info("**getFechaTabla(): "+getFechaTabla());			
			respDet = smallWorldDAO.getDetalleSWDatosNoFFM(getFechaTabla());

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
	public String exportDetalleFfmCuentasNoSwDetails() {
		  XSSFWorkbook myWorkBook = new XSSFWorkbook();
		  XSSFSheet mySheet    = myWorkBook.createSheet("FFM no SW");
//		  XSSFSheet mySheetFFM = myWorkBook.createSheet("BRM no SAP");
		  XSSFSheet mySheetBRMNoFFM = myWorkBook.createSheet("SW no FFM");
		  XSSFSheet mySheetDatosNoFFM = myWorkBook.createSheet("Datos _Inconsistentes");
		  
		  
		  
		  try {
		   Calendar calendar = Calendar.getInstance();
		   List<DetalleFfmCuentasNoSwVO> detalleBeans = fetchList();
		   List<DetalleSWCuentasNoFFMVO> detalleBeansNoFFM = fetchListNoFFM();
		   List<DetalleSWDatosNoFFMVO> detalleBeansDatosNoFFM = fetchListDatosNoFFM();
		   
		   String fechaReporte = getFechaReporte().replace("/", "-");
		   
		   reportFile = "DetalleFfmNoSw" + getFechaReporte()+ "".concat(".xlsx");
//		   logger.debug("Nombre archivo: " + reportFile + "fechaReporte: " + fechaReporte);
		   setReportFile(reportFile);
		 
		   Row headerRow = mySheet.createRow(0);
		   headerRow.setHeightInPoints(50);
		   Cell titleCell = headerRow.createCell(0);
		   titleCell.setCellValue("Detalle de los cuentas existentes en FFM y no en SW " + fechaReporte + "");
		   
//		   Row headerRowIPTV = mySheetBRMNoFFM.createRow(0);
//		   headerRowIPTV.setHeightInPoints(50);
//		   Cell titleCellIPTV = headerRowIPTV.createCell(0);
//		   titleCellIPTV.setCellValue("Detalle de los cuentas existentes en BRM y no en SAP " + fechaReporte + "");
		 
		   
		   
		   setDetailedAllInfo(myWorkBook, mySheet, detalleBeans);
		   setDetailedAllInfoBRMNoFFM(myWorkBook,mySheetBRMNoFFM,detalleBeansNoFFM);
		   setDetailedAllInfoDatosNoFFM(myWorkBook,mySheetDatosNoFFM,detalleBeansDatosNoFFM);
		 
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
//
		@SuppressWarnings("deprecation")
		private void setDetailedAllInfo (XSSFWorkbook myWorkBook, XSSFSheet mySheet, List<DetalleFfmCuentasNoSwVO> detalleBeans) {
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
		        
		        
			  final String[] errorSource = { "Fecha","ID Conciliación","No. de Cuenta","Splitter","Puerto Asignado","Candado","Fecha de Modificación","" };
			  try {
				  Row header = mySheet.createRow(0);
					Cell monthCell = header.createCell(0);
					monthCell.setCellValue("Small World vs FFM");
					monthCell.setCellStyle(headstyle);
					mySheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
					header = mySheet.createRow(1);
					monthCell = header.createCell(0);
					monthCell.setCellValue("Detalle FFM no SW");
					monthCell.setCellStyle(headstyle);

					header = mySheet.createRow(2);
			   for (int i = 0; i < errorSource.length; i++) {
			     monthCell = header.createCell(i);
			    monthCell.setCellValue(errorSource[i]);
			    monthCell.setCellStyle(headstyle2);
			   }

				mySheet.addMergedRegion(new CellRangeAddress(1,1,0,6));
			   for (DetalleFfmCuentasNoSwVO detalleBean : detalleBeans) {
			    myRow = mySheet.createRow(rowNum++);
			   
			    myRow.createCell(0).setCellValue(detalleBean.getFechaShort());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(1).setCellValue(detalleBean.getId_conciliacion());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(2).setCellValue(detalleBean.getNum_cuenta());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(3).setCellValue(detalleBean.getSplitter());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(4).setCellValue(detalleBean.getPuerto_asignado());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(5).setCellValue(detalleBean.getCandado());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(6).setCellValue(detalleBean.getFecha_modificacionShort());
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
		private void setDetailedAllInfoDatosNoFFM ( XSSFWorkbook myWorkBook, XSSFSheet mySheet, List<DetalleSWDatosNoFFMVO> detalleBeans) {
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
			        
			        //NUM_CUENTA	SPLITTER	PUERTO_ASIGNADO	CANDADO	TRUNC(FECHA_MODIFICACION)
			        //CUENTAS	SPLITTER_1	PUERTOS_ASIGNADO	CANDADO_1	FECHA


				  final String[] errorSource = { "Fecha",      "Id Conciliación", "Cuentas FFM",        "Splitter FFM", "Puerto Asignado FFM", "Candado FFM", "Fecha de Modificación FFM", 
			        		                     "Cuentas SW", "Splitter SW",     "Puerto Asignado SW", "Candado SW",   "Fecha de Modificación SW","" };
				  try {
					  Row header = mySheet.createRow(0);
						Cell monthCell = header.createCell(0);
						monthCell.setCellValue("SW Datos No FFM");
						monthCell.setCellStyle(headstyle);
						mySheet.addMergedRegion(new CellRangeAddress(0,0,0,12));
						header = mySheet.createRow(1);
						monthCell = header.createCell(0);
						monthCell.setCellValue("Detalle Datos no FFM");
						monthCell.setCellStyle(headstyle);

						header = mySheet.createRow(2);
				   for (int i = 0; i < errorSource.length; i++) {
				    monthCell = header.createCell(i);
				    monthCell.setCellValue(errorSource[i]);
				    monthCell.setCellStyle(headstyle2);
				   }

					mySheet.addMergedRegion(new CellRangeAddress(1,1,0,11));
				   for (DetalleSWDatosNoFFMVO detalleBean : detalleBeans) {
				    myRow = mySheet.createRow(rowNum++);
				    myRow.createCell(0).setCellValue(detalleBean.getFechaShortSw());
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(1).setCellValue(detalleBean.getId_conciliacion());
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(2).setCellValue(detalleBean.getCuentas_ffm());
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(3).setCellValue(detalleBean.getSplitter_ffm() );
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(4).setCellValue(detalleBean.getPuerto_asignado_ffm() );
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(5).setCellValue(detalleBean.getCandado_ffm());
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(6).setCellValue(detalleBean.getFecha_modificacion_ffmShort());
				    monthCell.setCellStyle(cellstyle);

				    myRow.createCell(7).setCellValue(detalleBean.getCuentas_sw());
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(8).setCellValue(detalleBean.getSplitter_sw() );
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(9).setCellValue(detalleBean.getPuerto_asignado_sw() );
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(10).setCellValue(detalleBean.getCandado_sw());
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(11).setCellValue(detalleBean.getFecha_modificacionShortSw());
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


		
		@SuppressWarnings("deprecation")
		private void setDetailedAllInfoBRMNoFFM ( XSSFWorkbook myWorkBook, XSSFSheet mySheet, List<DetalleSWCuentasNoFFMVO> detalleBeans) {
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
			        
				  final String[] errorSource = { "Fecha", "Id de conciliación", "Cuenta", "Splitter", "Puerto Asignado", "Candado", "Fecha de Modificación","" };
				  try {
					  Row header = mySheet.createRow(0);
						Cell monthCell = header.createCell(0);
						monthCell.setCellValue("SW Cuentas No FFM");
						monthCell.setCellStyle(headstyle);
						mySheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
						header = mySheet.createRow(1);
						monthCell = header.createCell(0);
						monthCell.setCellValue("Detalle SW no FFM");
						monthCell.setCellStyle(headstyle);

						header = mySheet.createRow(2);
				   for (int i = 0; i < errorSource.length; i++) {
				    monthCell = header.createCell(i);
				    monthCell.setCellValue(errorSource[i]);
				    monthCell.setCellStyle(headstyle2);
				   }

					mySheet.addMergedRegion(new CellRangeAddress(1,1,0,7));
				   for (DetalleSWCuentasNoFFMVO detalleBean : detalleBeans) {
				    myRow = mySheet.createRow(rowNum++);
				    
				    myRow.createCell(0).setCellValue(detalleBean.getFechaShort());
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(1).setCellValue(detalleBean.getId_conciliacion());
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(2).setCellValue(detalleBean.getCuentas());
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(3).setCellValue(detalleBean.getSplitter() );
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(4).setCellValue(detalleBean.getPuerto_asignado() );
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(5).setCellValue(detalleBean.getCandado() );
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(6).setCellValue(detalleBean.getFecha_modificacionShort());
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
}
