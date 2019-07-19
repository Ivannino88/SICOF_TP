package com.mx.totalplay.struts.action;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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

import com.mx.totalplay.dao.CtasCiclovsCtasBRMDAO;
import com.mx.totalplay.vo.CtasCiclovsCtasBRMVO;
import com.mx.totalplay.vo.DetalleCicloNoFacturadoVO;
import com.mx.totalplay.vo.DetalleFacturadoNoCicloVO;
import com.mx.totalplay.vo.ServiceResponse;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

public class CtasCiclovsCtasBRMAction extends CifrasControlAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CtasCiclovsCtasBRMAction.class);
	CtasCiclovsCtasBRMDAO ctasCiclovsCtasBRMDAO = new CtasCiclovsCtasBRMDAO();
	String fecha;
	String fechaReporte;
	
	private String fechaTabla;
	
	private List<CtasCiclovsCtasBRMVO> ctasActCicloBRMVOList = new ArrayList<CtasCiclovsCtasBRMVO>();
	private String reportFile;
	private InputStream inputStream;
	
	private String filtro;
	
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
		

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
	
	public String getFechaReporte() {
		return fechaReporte;
	}

	public void setFechaReporte(String fechaReporte) {
		Conversor conver=new Conversor();
		this.fechaReporte=conver.conversor(fechaReporte);
	}

	public List<CtasCiclovsCtasBRMVO> getCtasActCicloBRMVOList() {
		return ctasActCicloBRMVOList;
	}

	public void setCtasActCicloBRMVOList(
			List<CtasCiclovsCtasBRMVO> ctasActCicloBRMVOList) {
		this.ctasActCicloBRMVOList = ctasActCicloBRMVOList;
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
	
	ServiceResponse result = new ServiceResponse();
	
	public String getCtasCiclovsCtasBRM(){
		//logger.debug("***Action: getCtasCiclovsCtasBRM(Fecha: "+fecha+")");
		
		CtasCiclovsCtasBRMVO ctasActBrmVO = new CtasCiclovsCtasBRMVO();
		ctasActBrmVO.setFecha(getFecha());	
		ctasActBrmVO.setTipo_conciliacion("1");
		
		//logger.debug("Action>getCtasCiclovsCtasBRM>fecha>"+getFecha());
		
		try{
			result = ctasCiclovsCtasBRMDAO.getCtasCiclovsCtasBRM(ctasActBrmVO);
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
	//		logger.error("Action getCtasCiclovsCtasBRM>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	
    public String exportDetalleCicloBRMDetailsTablaJson(){
				
		try{
			ServiceResponse respDet = new ServiceResponse();
			if (getFiltro().equals("total")){
				respDet = ctasCiclovsCtasBRMDAO.getDetalleCicloNoFacturado(getFechaTabla());
			}else{
				respDet = ctasCiclovsCtasBRMDAO.getDetalleCicloNoFacturadoFiltro(getFechaTabla(), getFiltro());
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
    
    public String exportDetalleCicloBRMDetailsTablaJson2(){
		
		try{
			ServiceResponse respDet = new ServiceResponse();
			if (getFiltro().equals("total")){
				respDet = ctasCiclovsCtasBRMDAO.getDetalleFacturadoNoCiclo(getFechaTabla());
			}else{
				respDet = ctasCiclovsCtasBRMDAO.getDetalleFacturadoNoCicloFiltro(getFechaTabla(), getFiltro());
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
	public String exportDetalleCicloBRMDetails() {
		//logger.debug("*********Action: exportDetalleDetalleCtasCiclovsCtasBRM()");
		//logger.debug("***Action: getCtasCiclovsCtasBRM(Fecha: "+fecha+")");
		XSSFWorkbook myWorkBook = new XSSFWorkbook();
		XSSFSheet mySheet = myWorkBook.createSheet("DETALLE_CICLO_NO_FACTURADO");
		XSSFSheet mySheetIPTV = myWorkBook.createSheet("DETALLE_FACTURADO_NO_CICLO");
		try {
			Calendar calendar = Calendar.getInstance();
			ServiceResponse detalleBeans1 = ctasCiclovsCtasBRMDAO.getDetalleCicloNoFacturado(getFecha());
			ServiceResponse detalleBeans2 = ctasCiclovsCtasBRMDAO.getDetalleFacturadoNoCiclo(getFecha());

			String reportFile = "Cuentas_Activas_BRMvsIMS"+ calendar.get(Calendar.YEAR) + "-"+ calendar.get(Calendar.MONTH) + "-"+ calendar.get(Calendar.DAY_OF_MONTH) + "".concat(".xlsx");
			setDetailedAllInfo( myWorkBook,mySheet, (List<DetalleCicloNoFacturadoVO>) detalleBeans1.getResult());
			setDetailedAllInfoIptv( myWorkBook,mySheetIPTV, (List<DetalleFacturadoNoCicloVO>) detalleBeans2.getResult());

			try {
				ByteArrayOutputStream boas = new ByteArrayOutputStream();
				if(boas!=null)
				boas.close();
				myWorkBook.write(boas);
				setInputStream(new ByteArrayInputStream(boas.toByteArray()));
				
				
				if(boas!=null)
		            boas.close();
				
			} catch (Exception e) {
//				e.printStackTrace();
			}
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleCicloNoFacturadoVO> detalleBeans) {
		int rowNum = 3;
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
        
        
		XSSFRow myRow = null;
		final String[] errorSource = { "Fecha", "Cuenta","Empresa", "Plan","Nombre Cliente",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Cuentas por ciclo VS Cuentas facturadas BRM - BRM");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle Ciclo no Facturado");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				 monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
				
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,4));
			for (DetalleCicloNoFacturadoVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getCuenta());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getEmpresa());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getPlan());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getNombreCliente());
				//System.out.println(detalleBean.getNombreCliente());
				monthCell.setCellStyle(cellstyle);

			}
//			for (int i = 0; i < myWorkBook.getNumberOfSheets(); i++) {
//	            XSSFSheet thisSheet = myWorkBook.getSheetAt(i);
//	            XSSFRow rowexcel = thisSheet.getRow(thisSheet.getLastRowNum());
//	            for (short j = 0; j < rowexcel.getLastCellNum(); j++) {
//	            	myWorkBook.getSheetAt(i).autoSizeColumn(j);
//	            }
//	         // Freezing the top row
//				 myWorkBook.getSheetAt(i).createFreezePane(0, 1);
//				
//	        }
			
			
		} catch (Exception e) {
	//		e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	private void setDetailedAllInfoIptv(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleFacturadoNoCicloVO> detalleBeans) {
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
		        
		final String[] errorSource = { "Fecha", "Cuenta", "Empresa","Folio", "Monto","Fecha de Factura","Fecha de Vencimiento","" };
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Cuentas por ciclo VS Cuentas facturadas BRM - BRM");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle Facturado no Ciclo");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
				
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,6));
			for (DetalleFacturadoNoCicloVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getCuenta());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getEmpresa());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getFolio());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getMonto());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getFecha_Factura());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getFecha_Vencimiento());
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
//			e.printStackTrace();
		}

	}

}
