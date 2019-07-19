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

import com.mx.totalplay.dao.CCanceladasvsU2000DAO;
import com.mx.totalplay.vo.CCanceladasvsU2000VO;
//import com.mx.totalplay.vo.DetalleBRMAddONSNoIPTVVO;
import com.mx.totalplay.vo.DetalleU2000CanceladasVO;
import com.mx.totalplay.vo.ServiceResponse;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;


public class CCanceladasvsU2000Action extends CifrasControlAction{

	@Override
	public String execute(){
		// TODO Auto-generated method stub
		//System.out.println("Entrando a Excecute.....");
		
		return SUCCESS;
	}

	/**
	 * @author Cesar Anguiano
	 * @author Maftec
	 * @category Reportes
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CifrasControlAction.class);
	
	CCanceladasvsU2000DAO dao = new CCanceladasvsU2000DAO();
	ServiceResponse result = new ServiceResponse();
	
	List<CCanceladasvsU2000VO> canceladasU2000 = new ArrayList<CCanceladasvsU2000VO>();
	
	public List<CCanceladasvsU2000VO> getCanceladasU2000() {
		return canceladasU2000;
	}
	public void setCanceladasU2000(List<CCanceladasvsU2000VO> canceladasU2000) {
		this.canceladasU2000 = canceladasU2000;
	}
	
	private String fecha;
	private String reportFile;
	private InputStream inputStream;
	
	private String fechaReporte;
	
	
	public String getFechaReporte() {
		return fechaReporte;
	}
	public void setFechaReporte(String fechaReporte) {
		Conversor conver=new Conversor();
//		this.fechaReporte = fechaReporte;
		this.fechaReporte=conver.conversor(fechaReporte);
	}

	private String filtro;
	
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
	private String fechaTabla;
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		Conversor conver=new Conversor();
		this.fecha=conver.conversor(fecha);
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
	

	public String getFechaTabla() {
		return fechaTabla;
	}
	public void setFechaTabla(String fechaTabla) {
		Conversor conver=new Conversor();
		this.fechaTabla =conver.conversor(fechaTabla);
	}
	@SuppressWarnings("unused")
	public String getcCanceladasvsU2000(){
//	System.out.println("CCanceladasvsU2000Action.getcCanceladasvsU2000()");
//	System.out.println("fecha"+ fecha);
		String resultAction = SUCCESS;
		try{
			
			canceladasU2000 = dao.getcCanceladasvsU2000(fecha);
			if(canceladasU2000.size() > 0){
				result.setSuccess(true);
				result.setResult(canceladasU2000);
				result.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				result.setSuccess(false);
				result.setResult(canceladasU2000);
				result.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [Cuentas Canceladas vs. Cuentas U2000 BRM - U2000]");
			}	
		}catch(Exception e){
			resultAction = "ERRORPAGE";
	//		logger.error(e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	public String exportCCanceladasvsU2000TablaJson(){
//		System.out.println("CCanceladasvsU2000Action.exportCCanceladasvsU2000TablaJson()");
//		System.out.println("formato para la consulta--> "+getFechaTabla());
		try{
			ServiceResponse respDet = new ServiceResponse();
			if (getFiltro().equals("total")){
				respDet = dao.detalleCanceladasBRMvsU2000(getFechaTabla());
			}else{
				respDet = dao.detalleCanceladasBRMvsU2000Filtro(getFechaTabla(), getFiltro());
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
	
	@SuppressWarnings("unchecked")
	public String exportCCanceladasvsU2000(){
//		System.out.println("CCanceladasvsU2000Action.exportCCanceladasvsU2000()");
//		System.out.println("fecha excel "+getFechaReporte());
		//logger.debug("***Action: exportCCanceladasvsU2000()");
		XSSFWorkbook myWorkBook = new XSSFWorkbook();
		XSSFSheet mySheet = myWorkBook.createSheet("Cuentas U2000 BRM - U2000");
		try {
			Calendar calendar = Calendar.getInstance();
//			List<DetalleU2000CanceladasVO> detalleBeans = dao.detalleCanceladasBRMvsU2000(getFecha());
			ServiceResponse detalleBeans = dao.detalleCanceladasBRMvsU2000(getFechaReporte());
			
			reportFile = "Cuentas Canceladas vs. Cuentas U2000 BRM - U2000" + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + "".concat(".xlsx");
			//logger.debug("Nombre archivo: " + reportFile);
			Row headerRow = mySheet.createRow(0);
			headerRow.setHeightInPoints(50);
			Cell titleCell = headerRow.createCell(0);
			titleCell.setCellValue("Detalle de las cuentas Canceladas vs. Cuentas U2000 BRM - U2000 " + calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + "");
			
			setDetailedAllInfo(myWorkBook,mySheet, (List<DetalleU2000CanceladasVO>) detalleBeans.getResult());
			try {
			    ByteArrayOutputStream boas = new ByteArrayOutputStream();
			    if(boas!=null)
			    boas.close();
				myWorkBook.write(boas);
				setInputStream(new ByteArrayInputStream(boas.toByteArray()));
				
				
				if(boas!=null)
		            boas.close();
			} catch (IOException e) {
			//    e.printStackTrace();
			}
		}catch(Exception e){
		//	e.printStackTrace();
		}
		  return SUCCESS;
	}
	
	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo(XSSFWorkbook myWorkBook ,XSSFSheet mySheet, List<DetalleU2000CanceladasVO> detalleBeans) {
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
		
		final String[] errorSource = { "Fecha", "Cuenta","Plan","Empresa","Fecha Cancelación","SN_STB","TMCode",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Cuentas Canceladas vs Cuentas U2000 BRM - U2000");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle Cuentas U2000 BRM - U2000");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
			    monthCell.setCellValue(errorSource[i]);
			    monthCell.setCellStyle(headstyle2);
				
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,6));
			for (DetalleU2000CanceladasVO detalleBean : detalleBeans) {
			    myRow = mySheet.createRow(rowNum++);
			    myRow.createCell(0).setCellValue(detalleBean.getFecha());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(1).setCellValue(detalleBean.getCuenta());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(2).setCellValue(detalleBean.getPlan());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(3).setCellValue(detalleBean.getEmpresa());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(4).setCellValue(detalleBean.getFecha_cancelacion());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(5).setCellValue(detalleBean.getSn_stb());
			    monthCell.setCellStyle(cellstyle);
			    myRow.createCell(6).setCellValue(detalleBean.getTmcode());
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
		//   e.printStackTrace();
		}
			 
	}

}
