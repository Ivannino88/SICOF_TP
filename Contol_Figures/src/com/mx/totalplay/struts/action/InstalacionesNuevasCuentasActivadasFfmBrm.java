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

import com.mx.totalplay.dao.InstalacionesNuevasCuentasActivadasFfmBrmDAO;
import com.mx.totalplay.vo.DetalleBrmNoFfmVO;
import com.mx.totalplay.vo.DetalleFfmNoBrmVO;
import com.mx.totalplay.vo.ServiceResponse;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;


public class InstalacionesNuevasCuentasActivadasFfmBrm extends CifrasControlAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(InstalacionesNuevasCuentasActivadasFfmBrm.class);
	InstalacionesNuevasCuentasActivadasFfmBrmDAO instalacionesNuevasCuentasActivadasFfmBrmDAO = new InstalacionesNuevasCuentasActivadasFfmBrmDAO();
	String fecha;
	String fechaReporte;
	String fechatabla;
	
	private List<DetalleFfmNoBrmVO> detalleFfmNoBrmVOList = new ArrayList<DetalleFfmNoBrmVO>();
	private List<DetalleBrmNoFfmVO> detalleBrmNoFfmVOList = new ArrayList<DetalleBrmNoFfmVO>();
	private String reportFile;
	
	private InputStream inputStream;
	
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
	public String getInstalacionesNuevasCuentasActivadasFfmBrmService(){
		//logger.debug("*** getInstalacionesNuevasCuentasActivadasFfmBrmService()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = instalacionesNuevasCuentasActivadasFfmBrmDAO.getInstalacionesNuevasCuentasActivadasFfmBrm(getFecha());
			
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				//logger.debug("getInstalacionesNuevasCuentasActivadasFfmBrmService SUCCESS");
			} else {
//				logger.error("getInstalacionesNuevasCuentasActivadasFfmBrmService NO INFO");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}

		} catch (Exception e) {
//			logger.error("getInstalacionesNuevasCuentasActivadasFfmBrmService, ###ERROR### " + e);
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
	private List<DetalleFfmNoBrmVO> fetchList() {
		 
		  {		
			  ServiceResponse result = new ServiceResponse();
				try {
					ServiceResponse respDet = new ServiceResponse();
					respDet = instalacionesNuevasCuentasActivadasFfmBrmDAO.getDetalleFfmNoBrm(getFechaReporte());
//					System.out.println("la fecha del reporte"+getFechaReporte());
					if (respDet.isSuccess()) {
						result.setSuccess(true);
						result.setMensaje(respDet.getMensaje());
						result.setResult(respDet.getResult());
						//logger.debug("getDetalleFfmNoBrm SUCCESS");
						
						List<DetalleFfmNoBrmVO> detalle = new ArrayList<DetalleFfmNoBrmVO>();
						detalle = (List<DetalleFfmNoBrmVO>)respDet.getResult();
						DetalleFfmNoBrmVO detalleFfmNoBrmVO = new DetalleFfmNoBrmVO();
						for(int i=0; i<detalle.size();i++){
							detalleFfmNoBrmVO = detalle.get(i);
							////logger.debug("Valor: " + detalleNoBrmIptv.getCuenta());
							detalleFfmNoBrmVOList.add(detalleFfmNoBrmVO);
						}
						
					} else {
						//logger.error("getDetalleFfmNoBrm ERROR");
						result.setSuccess(false);
						result.setResult(null);
						result.setMensaje(respDet.getMensaje());
					}

				} catch (Exception e) {
					//logger.error("getDetalleFfmNoBrm, ###ERROR### " + e);
				}
			  			  
		  }
		  return detalleFfmNoBrmVOList;
	}
	
	@SuppressWarnings("unchecked")
	private List<DetalleBrmNoFfmVO> fetchListFFM() {
		 
		  {
			  ServiceResponse result = new ServiceResponse();
				try {
					ServiceResponse respDet = new ServiceResponse();
					respDet = instalacionesNuevasCuentasActivadasFfmBrmDAO.getDetalleBrmNoFfm(getFechaReporte());
					
					if (respDet.isSuccess()) {
						result.setSuccess(true);
						result.setMensaje(respDet.getMensaje());
						result.setResult(respDet.getResult());
						//logger.debug("fetchListFFM SUCCESS");
						
						List<DetalleBrmNoFfmVO> detalle = new ArrayList<DetalleBrmNoFfmVO>();
						detalle = (List<DetalleBrmNoFfmVO>)respDet.getResult();
						DetalleBrmNoFfmVO detalleBrmNoFfmVO = new DetalleBrmNoFfmVO();
						for(int i=0; i<detalle.size();i++){
							detalleBrmNoFfmVO = detalle.get(i);
							////logger.debug("Valor: " + detalleNoBrmIptv.getCuenta());
							detalleBrmNoFfmVOList.add(detalleBrmNoFfmVO);
						}
						
					} else {
						//logger.error("fetchListFFM ERROR");
						result.setSuccess(false);
						result.setResult(null);
						result.setMensaje(respDet.getMensaje());
					}

				} catch (Exception e) {
					//logger.error("fetchListFFM, ###ERROR### " + e);
				}
			  			  
		  }
		  return detalleBrmNoFfmVOList;
	}
// json#1	
	@SuppressWarnings("unused")
	public String exportInstalacionesNuevasCuentasActivadasFfmBrmDetailsTablaJson(){
		//logger.info("*** exportInstalacionesNuevasCuentasActivadasFfmBrmDetailsTablaJson()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		//logger.info("getFechatabla(): " + getFechatabla());
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = instalacionesNuevasCuentasActivadasFfmBrmDAO.getDetalleFfmNoBrm(getFechatabla());
			//logger.info("respDet.isSuccess(): "+respDet.isSuccess());
			//logger.info("respDet.isSuccess(): "+respDet.getMensaje());
			//logger.info("respDet.isSuccess(): "+respDet.getResult());
			if (respDet.isSuccess()) {
				//logger.info("entrando");
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				//logger.debug("getDetalleFfmNoBrm");
			} else {
//				logger.error("getInstVsSalidasAlmacenSAPService NO INFO");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}
			
		} catch (Exception e) {
			//logger.error("exportInstalacionesNuevasCuentasActivadasFfmBrmDetailsTablaJson: " + e);
			setActionError("Error.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
// json#2	
	@SuppressWarnings("unused")
	public String exportInstalacionesNuevasCuentasActivadasFfmBrmDetailsTablaJson2(){
		//logger.info("*** exportInstalacionesNuevasCuentasActivadasFfmBrmDetailsTablaJson2()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		//logger.info("getFechatabla(): " + getFechatabla());
		try {
			ServiceResponse respDet = new ServiceResponse();
			//respDet = instVsSalidasAlmacenSAPDAO.getDetalleSapNoBrm(getFechatabla());
			respDet = instalacionesNuevasCuentasActivadasFfmBrmDAO.getDetalleBrmNoFfm(getFechatabla());
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
		return null;
	}
//  ------------------------- GRAFICA LINEAL----------------------
			private String semana;
			private String mes;
			private String anio;
			// #######---datos por semana	
		public String getDatosGraficaSemana(){
//			System.out.println("InstalacionesvsSalidasAlmacenSAPAction.getDatosGraficaSm()");
//			System.out.println("semana"+getSemana()+"año"+getAnio());
			String resultAction = SUCCESS;
					ServiceResponse result = new ServiceResponse();
					try {
						ServiceResponse respDet = new ServiceResponse();
						respDet = instalacionesNuevasCuentasActivadasFfmBrmDAO.getDatosGraficaSemana(getSemana(),getAnio());
						
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
						setActionError("Error.");
						resultAction = "ERRORPAGE";
					}
					sendJSONObjectToResponse(result);
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					return null;
		}
		// #######---datos por mes
		public String getDatosGraficaMes(){
//			System.out.println("InstalacionesvsSalidasAlmacenSAPAction.getDatosGraficaMes()");
//			System.out.println("mes"+getMes()+"año"+getAnio());
			String resultAction = SUCCESS;
					ServiceResponse result = new ServiceResponse();
					try {
						ServiceResponse respDet = new ServiceResponse();
						respDet = instalacionesNuevasCuentasActivadasFfmBrmDAO.getDatosGraficaMes(getMes(),getAnio());
						
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
						setActionError("Error.");
						resultAction = "ERRORPAGE";
					}
					sendJSONObjectToResponse(result);
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					return null;
		}	
		public String getSemana() { return semana; 	}
		public void setSemana(String semana) { this.semana = semana;}
		public String getMes() { return mes; }
		public void setMes(String mes) { this.mes = mes; }
		public String getAnio() { return anio; }
		public void setAnio(String anio) { this.anio = anio; }
//----------------- FIN GRAFICA LINEAL--------------------------

	
	
	
	@SuppressWarnings("unused")
	public String exportInstalacionesNuevasCuentasActivadasFfmBrmDetails() {
		  XSSFWorkbook myWorkBook = new XSSFWorkbook();
		  XSSFSheet mySheet = myWorkBook.createSheet("FFM no BRM");
		  XSSFSheet mySheetFFM = myWorkBook.createSheet("BRM no FFM");
		  
		  
		  
		  try {
		   Calendar calendar = Calendar.getInstance();
		   List<DetalleFfmNoBrmVO> detalleBeans = fetchList();
		   List<DetalleBrmNoFfmVO> detalleBeansFFM = fetchListFFM();
		   
		   String fechaReporte = getFechaReporte().replace("/", "-");
		   
		   reportFile = "DetalleFfmNoBRM" + getFechaReporte()
		     + "".concat(".xlsx");
		   //logger.debug("Nombre archivo: " + reportFile + "fechaReporte: " + fechaReporte);
		   //setReportFile(reportFile);
		 
		   Row headerRow = mySheetFFM.createRow(0);
		   headerRow.setHeightInPoints(50);
		   Cell titleCell = headerRow.createCell(0);
		   titleCell.setCellValue("Detalle de los cuentas existentes en FFM y no en BRM " + fechaReporte + "");
		   
		   Row headerRowIPTV = mySheet.createRow(0);
		   headerRowIPTV.setHeightInPoints(50);
		   Cell titleCellIPTV = headerRowIPTV.createCell(0);
		   titleCellIPTV.setCellValue("Detalle de los cuentas existentes en BRM y no en FFM " + fechaReporte + "");
		 
		   
		   
		   setDetailedAllInfo( myWorkBook,mySheet, detalleBeans);
		   setDetailedAllInfoFfm(myWorkBook,mySheetFFM, detalleBeansFFM);
		 
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

		@SuppressWarnings("deprecation")
		private void setDetailedAllInfo( XSSFWorkbook myWorkBook,XSSFSheet mySheet,
			   List<DetalleFfmNoBrmVO> detalleBeans) {
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
			  
			  
			  final String[] errorSource = { "Fecha", "Id de Conciliación","Cuenta","Fecha de Activación","Empresa" ,""};
			  try {
				  Row header = mySheet.createRow(0);
					Cell monthCell = header.createCell(0);
					monthCell.setCellValue("Instalaciones Nuevas vs Cuentas Activadas FFM- BRM");
					monthCell.setCellStyle(headstyle);
					mySheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
					header = mySheet.createRow(1);
					monthCell = header.createCell(0);
					monthCell.setCellValue("Detalle BRM no FFM");
					monthCell.setCellStyle(headstyle);

					
					header = mySheet.createRow(2);
			   for (int i = 0; i < errorSource.length; i++) {
			    monthCell = header.createCell(i);
			    monthCell.setCellValue(errorSource[i]);
			    monthCell.setCellStyle(headstyle2);
				//mySheet.addMergedRegion(new CellRangeAddress(1,1,0,4)); 
			   }
			   mySheet.addMergedRegion(new CellRangeAddress(1,1,0,4)); 
			   for (DetalleFfmNoBrmVO detalleBean : detalleBeans) {
			    myRow = mySheet.createRow(rowNum++);
			    myRow.createCell(0).setCellValue(detalleBean.getFecha());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(1).setCellValue(detalleBean.getId_conciliacion());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(2).setCellValue(detalleBean.getCuenta());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(3).setCellValue(detalleBean.getFecha_activacion());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(4).setCellValue(detalleBean.getEmpresa());
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
		private void setDetailedAllInfoFfm(XSSFWorkbook myWorkBook,XSSFSheet mySheet,
				   List<DetalleBrmNoFfmVO> detalleBeans) {
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
					  
				  
				  final String[] errorSource = { "Fecha", "Id de Conciliación","Cuenta","Plan","Fecha de Activación","Empresa","" };
				  try {
					  Row header = mySheet.createRow(0);
						Cell monthCell = header.createCell(0);
						monthCell.setCellValue("Instalaciones Nuevas vs Cuentas Activadas FFM- BRM");
						monthCell.setCellStyle(headstyle);
						mySheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
						header = mySheet.createRow(1);
						monthCell = header.createCell(0);
						monthCell.setCellValue("Detalle BRM no FFM");
						monthCell.setCellStyle(headstyle);

						
//						System.out.println("titulos registros"+errorSource.length);
						header = mySheet.createRow(2);
				   for (int i = 0; i < errorSource.length; i++) {
				     monthCell = header.createCell(i);
				    monthCell.setCellValue(errorSource[i]);
					monthCell.setCellStyle(headstyle2);
					
				   }
				   mySheet.addMergedRegion(new CellRangeAddress(1,1,0,5));
				   for (DetalleBrmNoFfmVO detalleBean : detalleBeans) {
				    myRow = mySheet.createRow(rowNum++);
				    myRow.createCell(0).setCellValue(detalleBean.getFecha());
					monthCell.setCellStyle(cellstyle);
				    myRow.createCell(1).setCellValue(detalleBean.getId_conciliacion());
					monthCell.setCellStyle(cellstyle);
				    myRow.createCell(2).setCellValue(detalleBean.getCuenta());
					monthCell.setCellStyle(cellstyle);
				    myRow.createCell(3).setCellValue(detalleBean.getPlan());
					monthCell.setCellStyle(cellstyle);
				    myRow.createCell(4).setCellValue(detalleBean.getFecha_activacion());
					monthCell.setCellStyle(cellstyle);
				    myRow.createCell(5).setCellValue(detalleBean.getEmpresa());
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


		public List<DetalleFfmNoBrmVO> getDetalleFfmNoBrmVOList() {
			return detalleFfmNoBrmVOList;
		}


		public void setDetalleFfmNoBrmVOList(
				List<DetalleFfmNoBrmVO> detalleFfmNoBrmVOList) {
			this.detalleFfmNoBrmVOList = detalleFfmNoBrmVOList;
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
		
		public String getFechatabla() {
			return fechatabla;
		}


		public void setFechatabla(String fechatabla) {
			this.fechatabla = fechatabla;
		}
		
	
}
