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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



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
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;


import com.mx.totalplay.dao.InstVsSalidasAlmacenSAPDAO;
import com.mx.totalplay.vo.DetalleBrmNoSapVO;
import com.mx.totalplay.vo.DetalleSapNoBrmVO;
import com.mx.totalplay.vo.ServiceResponse;


public class InstalacionesvsSalidasAlmacenSAPAction extends CifrasControlAction implements ServletRequestAware, ServletResponseAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(InstalacionesvsSalidasAlmacenSAPAction.class);
	InstVsSalidasAlmacenSAPDAO instVsSalidasAlmacenSAPDAO = new InstVsSalidasAlmacenSAPDAO();
	String fecha;
	String fechaReporte="";
	String fechatabla;
	private String reportFile;	
	private InputStream inputStream;
	
	private HttpServletRequest request;
    private HttpServletResponse response;
	
	private List<DetalleSapNoBrmVO> detalleSapNoBrmVOList = new ArrayList<DetalleSapNoBrmVO>();
	private List<DetalleBrmNoSapVO> detalleBrmNoSapVOList = new ArrayList<DetalleBrmNoSapVO>();
	
		

	@SuppressWarnings("unused")
	public String getInstVsSalidasAlmacenSAPService(){
//		System.out.println("InstalacionesvsSalidasAlmacenSAPAction.getInstVsSalidasAlmacenSAPService()");
		//logger.debug("*** getInstVsSalidasAlmacenSAPService()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = instVsSalidasAlmacenSAPDAO.getIinstVsSalidasAlmacenSAP(getFecha());
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
	
	
	@SuppressWarnings("unchecked")
	private List<DetalleSapNoBrmVO> fetchList() {
		 
		  {
			  ServiceResponse result = new ServiceResponse();
				try {
					ServiceResponse respDet = new ServiceResponse();
					respDet = instVsSalidasAlmacenSAPDAO.getDetalleSapNoBrm(getFechaReporte());
					
					
					if (respDet.isSuccess()) {
						result.setSuccess(true);
						result.setMensaje(respDet.getMensaje());
						result.setResult(respDet.getResult());
						//logger.debug("getDetalleFfmNoBrm SUCCESS");
						
						List<DetalleSapNoBrmVO> detalle = new ArrayList<DetalleSapNoBrmVO>();
						detalle = (List<DetalleSapNoBrmVO>)respDet.getResult();
						DetalleSapNoBrmVO detalleSapNoBrmVO = new DetalleSapNoBrmVO();
						for(int i=0; i<detalle.size();i++){
							detalleSapNoBrmVO = detalle.get(i);
							////logger.debug("Valor: " + detalleNoBrmIptv.getCuenta());
							detalleSapNoBrmVOList.add(detalleSapNoBrmVO);
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
		  return detalleSapNoBrmVOList;
	}
		
	
	@SuppressWarnings("unchecked")
	private List<DetalleBrmNoSapVO> fetchListSAP() {
		 
		  {
			  ServiceResponse result = new ServiceResponse();
				try {
					ServiceResponse respDet = new ServiceResponse();
					respDet = instVsSalidasAlmacenSAPDAO.getDetalleBrmNoSap(getFechaReporte());
					
					
					if (respDet.isSuccess()) {
						result.setSuccess(true);
						result.setMensaje(respDet.getMensaje());
						result.setResult(respDet.getResult());
						//logger.debug("fetchListFFM SUCCESS");
						
						List<DetalleBrmNoSapVO> detalle = new ArrayList<DetalleBrmNoSapVO>();
						detalle = (List<DetalleBrmNoSapVO>)respDet.getResult();
						DetalleBrmNoSapVO detalleBrmNoSapVO = new DetalleBrmNoSapVO();
						for(int i=0; i<detalle.size();i++){
							detalleBrmNoSapVO = detalle.get(i);
							////logger.debug("Valor: " + detalleNoBrmIptv.getCuenta());
							detalleBrmNoSapVOList.add(detalleBrmNoSapVO);
						}
						
					} else {
//						logger.error("fetchListFFM ERROR");
						result.setSuccess(false);
						result.setResult(null);
						result.setMensaje(respDet.getMensaje());
					}

				} catch (Exception e) {
//					logger.error("fetchListFFM, ###ERROR### " + e);
				}
			  			  
		  }
		  return detalleBrmNoSapVOList;
	}
		
// --- json#1 ---	
	@SuppressWarnings("unused")
	public String exportInstalacionesvsSalidasAlmacenSAPDetailsTablaJson(){
		//logger.debug("*** getInstVsSalidasAlmacenSAPService()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = instVsSalidasAlmacenSAPDAO.getDetalleSapNoBrm(getFechatabla());
			//logger.info("respDet: "+respDet.isSuccess());
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
	
// --- json#2 ---    	     
	@SuppressWarnings("unused")
	public String exportInstalacionesvsSalidasAlmacenSAPDetailsTablaJson2(){
		//logger.info("TablaJson2 getFechaReporte(): " + getFechaReporte() );
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = instVsSalidasAlmacenSAPDAO.getDetalleBrmNoSap(getFechatabla());
			
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
			//logger.info("respDet.isSuccess(): "+result.isSuccess());
		} catch (Exception e) {
			//logger.error("exportInstalacionesvsSalidasAlmacenSAPDetailsTablaJson2: " + e);
			setActionError("Error.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	//   ------------------------- GRAFICA LINEAL----------------------
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
						respDet = instVsSalidasAlmacenSAPDAO.getDatosGraficaSemana(getSemana(),getAnio());
						
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
						respDet = instVsSalidasAlmacenSAPDAO.getDatosGraficaMes(getMes(),getAnio());
						
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
// ----------------- FIN GRAFICA LINEAL--------------------------


	@SuppressWarnings("unused")
	public String exportInstalacionesvsSalidasAlmacenSAPDetails() {
		  XSSFWorkbook myWorkBook = new XSSFWorkbook();
		  XSSFSheet mySheet    = myWorkBook.createSheet("SAP no BRM");
		  XSSFSheet mySheetFFM = myWorkBook.createSheet("BRM no SAP");
		  
		  		  
		  try {
		   Calendar calendar = Calendar.getInstance();
		   List<DetalleSapNoBrmVO> detalleBeans = fetchList();
		   List<DetalleBrmNoSapVO> detalleBeansSAP = fetchListSAP();
		   
		   String fechaReporte = getFechaReporte().replace("/", "-");
		   
		   reportFile = "DetalleSapNoBrm" + getFechaReporte()+ "".concat(".xlsx");
		   //logger.debug("Nombre archivo: " + reportFile + "fechaReporte: " + fechaReporte);
		   //setReportFile(reportFile);
		 
		   Row headerRow = mySheet.createRow(0);
		   headerRow.setHeightInPoints(50);
		   Cell titleCell = headerRow.createCell(0);
		   titleCell.setCellValue("Detalle de los cuentas existentes en SAP y no en BRM " + fechaReporte + "");
		   
		   Row headerRowIPTV = mySheetFFM.createRow(0);
		   headerRowIPTV.setHeightInPoints(50);
		   Cell titleCellIPTV = headerRowIPTV.createCell(0);
		   titleCellIPTV.setCellValue("Detalle de los cuentas existentes en BRM y no en SAP " + fechaReporte + "");
		 
		   
		   
		   setDetailedAllInfo(myWorkBook,mySheet, detalleBeans);
		   setDetailedAllInfoFfm(myWorkBook,mySheetFFM, detalleBeansSAP);
		 
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
		private void setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,
			   List<DetalleSapNoBrmVO> detalleBeans) {
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
		        
		        
			  final String[] errorSource = { "Fecha", "Id de Conciliación","No. de Serie","Fecha Contable","Número de Material","" };
			  try {
				  Row header = mySheet.createRow(0);
					Cell monthCell = header.createCell(0);
					monthCell.setCellValue("Instalaciones vs Salidas de Almacén SAP - BRM");
					monthCell.setCellStyle(headstyle);
					mySheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
					header = mySheet.createRow(1);
					monthCell = header.createCell(0);
					monthCell.setCellValue("Detalle SAP no BRM");
					monthCell.setCellStyle(headstyle);

					header = mySheet.createRow(2);
			   for (int i = 0; i < errorSource.length; i++) {
			     monthCell = header.createCell(i);
			    monthCell.setCellValue(errorSource[i]);
			    monthCell.setCellStyle(headstyle2);
			   }

				mySheet.addMergedRegion(new CellRangeAddress(1,1,0,4));
			   for (DetalleSapNoBrmVO detalleBean : detalleBeans) {
			    myRow = mySheet.createRow(rowNum++);
			    myRow.createCell(0).setCellValue(detalleBean.getFecha());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(1).setCellValue(detalleBean.getId_conciliacion());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(2).setCellValue(detalleBean.getNo_serie());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(3).setCellValue(detalleBean.getFe_contable());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(4).setCellValue(detalleBean.getNumero_material());
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
				   List<DetalleBrmNoSapVO> detalleBeans) {
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
			        
				  final String[] errorSource = { "Fecha", "Id de Conciliación","Cuenta","Empresa","SN","" };
				  try {
					  Row header = mySheet.createRow(0);
						Cell monthCell = header.createCell(0);
						monthCell.setCellValue("Instalaciones vs Salidas de Almacén SAP - BRM");
						monthCell.setCellStyle(headstyle);
						mySheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
						header = mySheet.createRow(1);
						monthCell = header.createCell(0);
						monthCell.setCellValue("Detalle BRM no SAP");
						monthCell.setCellStyle(headstyle);

						header = mySheet.createRow(2);
				   for (int i = 0; i < errorSource.length; i++) {
				    monthCell = header.createCell(i);
				    monthCell.setCellValue(errorSource[i]);
				    monthCell.setCellStyle(headstyle2);
				   }

					mySheet.addMergedRegion(new CellRangeAddress(1,1,0,4));
				   for (DetalleBrmNoSapVO detalleBean : detalleBeans) {
				    myRow = mySheet.createRow(rowNum++);
				    myRow.createCell(0).setCellValue(detalleBean.getFecha());
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(1).setCellValue(detalleBean.getId_conciliacion());
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(2).setCellValue(detalleBean.getCuenta());
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(3).setCellValue(detalleBean.getEmpresa());
				    monthCell.setCellStyle(cellstyle);
				    myRow.createCell(4).setCellValue(detalleBean.getSn());
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
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			Conversor conver=new Conversor();
			this.fecha=conver.conversor(fecha);
		}
		
		
		public String getFechatabla() {
			return fechatabla;
		}


		public void setFechatabla(String fechatabla) {
			this.fechatabla = fechatabla;
		}


		@Override
		public void setServletResponse(HttpServletResponse hsr) {
			this.response = hsr;	
		}

		@Override
		public void setServletRequest(HttpServletRequest hsr) {
			this.request = hsr;		
		}
		//public String execute(){		
//			System.out.println("Entrando a Excecute.....");		
			//return SUCCESS;
		//}

}
