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
//import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;

import com.mx.totalplay.dao.AjustesBRMvsAjustesSalesForceDAO;
import com.mx.totalplay.vo.AjustesBRMvAjustesSalesForceVO;
import com.mx.totalplay.vo.DetalleBRMvSalesForceVO;
import com.mx.totalplay.vo.DetalleBrmNoFfmVO;
import com.mx.totalplay.vo.DetalleProductosBrmVO;
import com.mx.totalplay.vo.ServiceResponse;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

public class AjustesBRMvsAjustesSalesForceAction extends CifrasControlAction{
	private static final Logger logger = Logger.getLogger(AjustesBRMvsAjustesSalesForceAction.class);
	private static final long serialVersionUID = 1L;	
	
	private String fecha;
	private String fechaReporte;
	private String reportFile;
	private InputStream inputStream;
	
	private String filtro;
	
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
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
	
	AjustesBRMvsAjustesSalesForceDAO AjustesBRMvsAjustesSalesForce = new AjustesBRMvsAjustesSalesForceDAO();	
	ServiceResponse respDet = new ServiceResponse();
	
	public String getAjustesBRMvsAjustesSalesForce(){
		ServiceResponse result = new ServiceResponse();
		try {
			respDet = AjustesBRMvsAjustesSalesForce.getAjustesBRMvsAjustesSF(getFecha());
			
			
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
			logger.error("getAjustesBRMvsAjustesSF(getFecha(), ###ERROR### " + e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	public String exportAjustesBRMvsAjustesSalesForceDetailsTablaJson(){
		ServiceResponse result = new ServiceResponse();
		try{
			ServiceResponse respDet = new ServiceResponse();
			if (getFiltro().equals("total")){
				respDet = AjustesBRMvsAjustesSalesForce.getDetalleBrmvsAjustesSF(getFechaTabla());
			}else{
				respDet = AjustesBRMvsAjustesSalesForce.getDetalleBrmvsAjustesSFFiltro(getFechaTabla(), getFiltro());
			}
			

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
	
	public String exportAjustesBRMvsAjustesSalesForceDetailsTablaJson2(){
		ServiceResponse result = new ServiceResponse();
		try{
			ServiceResponse respDet = new ServiceResponse();
			if (getFiltro().equals("total")){
				respDet = AjustesBRMvsAjustesSalesForce.getDetalleAjustesSFvsBrm(getFechaTabla());
			}else{
				respDet = AjustesBRMvsAjustesSalesForce.getDetalleAjustesSFvsBrmFiltro(getFechaTabla(), getFiltro());
			}		
			

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

	@SuppressWarnings({ "unused", "unchecked" })
	public String exportAjustesBRMvsAjustesSalesForceDetails() {
		  XSSFWorkbook myWorkBook = new XSSFWorkbook();
		  XSSFSheet mySheet = myWorkBook.createSheet("Detalle Ajustes_SF_NO_BRM");
		  XSSFSheet mySheet2 = myWorkBook.createSheet("Detalle Ajustes_BRM_NO_SF");

		  try {
		   Calendar calendar = Calendar.getInstance();
			ServiceResponse detalleBeans = AjustesBRMvsAjustesSalesForce.getDetalleBrmvsAjustesSF(getFechaReporte());
			ServiceResponse detalleBeans2 = AjustesBRMvsAjustesSalesForce.getDetalleAjustesSFvsBrm(getFechaReporte());
		   
		   String fechaReporte = getFechaReporte().replace("/", "-");
		   reportFile = "Detalle Ajustes BRM vs Ajustes SF " + fechaReporte + ".xlsx";
		 
		   Row headerRow = mySheet.createRow(0);
		   headerRow.setHeightInPoints(50);
		   Cell titleCell = headerRow.createCell(0);
		   titleCell.setCellValue("Detalle Ajustes BRM vs Ajustes SF" + fechaReporte + "");   
			setDetailedAllInfo(myWorkBook,mySheet, (List<DetalleBRMvSalesForceVO>) detalleBeans.getResult());
			setDetailedAllInfo2(myWorkBook,mySheet2, (List<DetalleBRMvSalesForceVO>) detalleBeans2.getResult());
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
		   List<DetalleBRMvSalesForceVO> detalleBeans) {
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
	        
	        
		  final String[] errorSource = { "Id", "Fecha","Cuenta","Empresa","Item no","Item total","Fecha Ajuste","Descripcion","" };
		  try {
			  Row header = mySheet.createRow(0);
				Cell monthCell = header.createCell(0);
				monthCell.setCellValue("Ajustes BRM vs Ajustes SalesForce");
				monthCell.setCellStyle(headstyle);
				mySheet.addMergedRegion(new CellRangeAddress(0,0,0,7));
				header = mySheet.createRow(1);
				monthCell = header.createCell(0);
				monthCell.setCellValue("Detalle AJUSTES_BRM_NO_SF");
				monthCell.setCellStyle(headstyle);

				
				header = mySheet.createRow(2);
		   for (int i = 0; i < errorSource.length; i++) {
		    monthCell = header.createCell(i);
		    monthCell.setCellValue(errorSource[i]);
		    monthCell.setCellStyle(headstyle2);
			
		   }
		   mySheet.addMergedRegion(new CellRangeAddress(1,1,0,7));
		   for (DetalleBRMvSalesForceVO detalleBean : detalleBeans) {
		    myRow = mySheet.createRow(rowNum++);
		    myRow.createCell(0).setCellValue(detalleBean.getId());
		    monthCell.setCellStyle(cellstyle);
		    myRow.createCell(1).setCellValue(detalleBean.getFechaShort());
		    monthCell.setCellStyle(cellstyle);
		    myRow.createCell(2).setCellValue(detalleBean.getCuenta());
		    monthCell.setCellStyle(cellstyle);
		    myRow.createCell(3).setCellValue(detalleBean.getEmpresa());
		    monthCell.setCellStyle(cellstyle);
		    myRow.createCell(4).setCellValue(detalleBean.getItem_no());
		    monthCell.setCellStyle(cellstyle);
		    myRow.createCell(5).setCellValue(detalleBean.getItem_total());
		    monthCell.setCellStyle(cellstyle);
		    myRow.createCell(6).setCellValue(detalleBean.getFecha_ajusteShort());
		    monthCell.setCellStyle(cellstyle);
		    myRow.createCell(7).setCellValue(detalleBean.getDescr());
		    monthCell.setCellStyle(cellstyle);
		   }
		   /*for (int i = 0; i < myWorkBook.getNumberOfSheets(); i++) {
	            XSSFSheet thisSheet = myWorkBook.getSheetAt(i);
	            XSSFRow rowexcel = thisSheet.getRow(thisSheet.getLastRowNum());
	            for (short j = 0; j < rowexcel.getLastCellNum(); j++) {
	            	myWorkBook.getSheetAt(i).autoSizeColumn(j);
	            }
	            // Freezing the top row
	            myWorkBook.getSheetAt(i).createFreezePane(0, 1);
	        }*/
		  } catch (Exception e) {
//		   e.printStackTrace();
		  }		 
		 }	
		@SuppressWarnings("deprecation")
		private void setDetailedAllInfo2(XSSFWorkbook myWorkBook,XSSFSheet mySheet,
			   List<DetalleBRMvSalesForceVO> detalleBeans) {
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
		        
		        
			  final String[] errorSource = { "Id", "Fecha","Log","Nombre","Cuenta","Empresa","Acción","Fecha Ajuste","Monto","Respuesta","Comentario","Usuario","" };
			  try {
				  Row header = mySheet.createRow(0);
					Cell monthCell = header.createCell(0);
					monthCell.setCellValue("Ajustes BRM vs Ajustes SalesForce");
					monthCell.setCellStyle(headstyle);
					mySheet.addMergedRegion(new CellRangeAddress(0,0,0,11));
					header = mySheet.createRow(1);
					monthCell = header.createCell(0);
					monthCell.setCellValue("Detalle AJUSTES_SF_NO_BRM");
					monthCell.setCellStyle(headstyle);

					
					header = mySheet.createRow(2);
			   for (int i = 0; i < errorSource.length; i++) {
			    monthCell = header.createCell(i);
			    monthCell.setCellValue(errorSource[i]);
			    monthCell.setCellStyle(headstyle2);
				
			   }
			   mySheet.addMergedRegion(new CellRangeAddress(1,1,0,11));
			   for (DetalleBRMvSalesForceVO detalleBean : detalleBeans) {
			    myRow = mySheet.createRow(rowNum++);
			    myRow.createCell(0).setCellValue(detalleBean.getId());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(1).setCellValue(detalleBean.getFechaShort());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(2).setCellValue(detalleBean.getLog());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(3).setCellValue(detalleBean.getNombre());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(4).setCellValue(detalleBean.getCuenta());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(5).setCellValue(detalleBean.getEmpresa());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(6).setCellValue(detalleBean.getAccion());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(7).setCellValue(detalleBean.getFecha_ajusteShort());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(8).setCellValue(detalleBean.getMonto());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(9).setCellValue(detalleBean.getRespuesta());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(10).setCellValue(detalleBean.getComentario());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(11).setCellValue(detalleBean.getUsuario());
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
		
		
}
