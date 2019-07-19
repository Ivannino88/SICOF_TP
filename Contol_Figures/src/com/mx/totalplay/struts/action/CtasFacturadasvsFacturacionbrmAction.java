/**
 * @author RicardoM
 * Action para el reporte  Cuentas Facturadas vs. Facturacion BRM - INTERFACTURA
 */
package com.mx.totalplay.struts.action;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.lang.reflect.Type; 

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







import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.mx.totalplay.dao.CtasFacturadasvsFacturacionbrmDAO;
import com.mx.totalplay.vo.DetalleCtasFacturadasvsFacturacionMontosVO;
import com.mx.totalplay.vo.DetalleCtasFacturadasvsFacturacionbrmVO;
import com.mx.totalplay.vo.DetalleInterfactura;
import com.mx.totalplay.vo.Documento;
import com.mx.totalplay.vo.ServiceResponse;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

public class CtasFacturadasvsFacturacionbrmAction extends CifrasControlAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CtasActBRMvsU2000Action.class);
	CtasFacturadasvsFacturacionbrmDAO ctasFacturadasvsFacturacionbrmDAO = new CtasFacturadasvsFacturacionbrmDAO();
	private InputStream inputStream;
	String fecha;
	private String opcion;
	private String cptp, cpenl, cptfe;
	
	private String cptpTabla, cpenlTabla, cptfeTabla;
	
	private List<DetalleCtasFacturadasvsFacturacionbrmVO> test=null;
	private String filtro;
	
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
		
	
	
	public String getCptpTabla() {
		return cptpTabla;
	}
	public void setCptpTabla(String cptpTabla) {
		this.cptpTabla = cptpTabla;
	}
	public String getCpenlTabla() {
		return cpenlTabla;
	}
	public void setCpenlTabla(String cpenlTabla) {
		this.cpenlTabla = cpenlTabla;
	}
	public String getCptfeTabla() {
		return cptfeTabla;
	}
	public void setCptfeTabla(String cptfeTabla) {
		this.cptfeTabla = cptfeTabla;
	}
	public String getCptp() {
		return cptp;
	}
	public void setCptp(String cptp) {
		this.cptp = cptp;
	}
	public String getCpenl() {
		return cpenl;
	}
	public void setCpenl(String cpenl) {
		this.cpenl = cpenl;
	}
	public String getCptfe() {
		return cptfe;
	}
	public void setCptfe(String cptfe) {
		this.cptfe = cptfe;
	}
	public String getOpcion() {
		return opcion;
	}
	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		Conversor conver=new Conversor();
		this.fecha=conver.conversor(fecha);
	}

//  *********************************************  REPORTE PRINCIPAL
	ServiceResponse result = new ServiceResponse();
	public String reporteCtasFactvsFactBRMIF() {
		//logger.debug("***Action reporteCtasFactvsFactBRMIF(Fecha: " + fecha + ")");
		try {
			result = ctasFacturadasvsFacturacionbrmDAO.reporteCtasFactvsFactBRMIF(getFecha(),getOpcion());
			if (result.isSuccess()) {
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(true);
			} else {
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(false);
			}
		} catch (Exception e) {
//			logger.error("Action reporteCtasFactvsFactBRMIF>>>" + e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
// ******************************************************** DETALLE
	
    public String exportDetallectasFactvsFactBRMIFTablaJson(){
    	//logger.info("getFiltro(): "+getFiltro());
    	//logger.info("getCptpTabla(): "+getCptpTabla());
    	//logger.info("getCpenlTabla(): "+getCpenlTabla());
    	//logger.info("getCptfeTabla(): "+getCptfeTabla());
//    	System.out.println("#1"+getCptpTabla());
//    	System.out.println("#2"+getCpenlTabla());
//    	System.out.println("#3"+getCptfeTabla());
		try{
			ServiceResponse respDet = new ServiceResponse();
			if (getFiltro().equals("total")){
				//logger.info("entrando con total");
				respDet = ctasFacturadasvsFacturacionbrmDAO.obtieneDetalleCtasFacturadasvsFacturacionbrm(getCptpTabla(), getCpenlTabla(), getCptfeTabla());
			}else{
				//logger.info("entrando con diferente de total");
				respDet = ctasFacturadasvsFacturacionbrmDAO.obtieneDetalleCtasFacturadasvsFacturacionbrmFiltro(getCptpTabla(), getCpenlTabla(), getCptfeTabla(), getFiltro());				
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
    
    public String exportDetallectasFactvsFactBRMIFTablaJson2(){
		
		try{
			ServiceResponse respDet = new ServiceResponse();
			if (getFiltro().equals("total")){
				respDet = ctasFacturadasvsFacturacionbrmDAO.obtieneDetalleMontosInterfactura(getCptpTabla(), getCpenlTabla(), getCptfeTabla());
			}else{
				respDet = ctasFacturadasvsFacturacionbrmDAO.obtieneDetalleMontosInterfacturaFiltro(getCptpTabla(), getCpenlTabla(), getCptfeTabla(), getFiltro());				
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
    
    public String getDetailInterfactura(){

		try{
			ServiceResponse respDet = new ServiceResponse();
			//fecha
			
			respDet = ctasFacturadasvsFacturacionbrmDAO.getDetailInterfactura(getFecha());

//			Documento tel=null;
//			Documento total=null;
//			Documento internet=null;
//			Documento edoCta=null;
//			List<Documento> listaDocs=new ArrayList<Documento>();
//			 test=(List<DetalleCtasFacturadasvsFacturacionbrmVO>) respDet.getResult();
//			System.out.println("tammmmmm: "+test.size());
//			int i=1;
//			for (DetalleCtasFacturadasvsFacturacionbrmVO detail : test) {
//				System.out.println("Detail: "+detail.toString());
//				//tel
//				tel=new Documento();
//				total=new Documento();
//				internet=new Documento();
//				edoCta=new Documento();
//				tel.setCuenta(detail.getCuenta());
//				tel.setTipoDoc("Television y telefono");
//				tel.setId(detail.getFac_tele_Tel());
//				tel.setFolioFiscal(detail.getFoliofis_tele_tel());
//				tel.setMonto(detail.getMonto_tele());
//				System.out.println("Telefono: "+tel.toString());
//				listaDocs.add(tel);
//				//totalBox
//				total.setCuenta(detail.getCuenta());
//				total.setTipoDoc("Total Box");
//				total.setId(detail.getFac_total_box());
//				total.setFolioFiscal(detail.getFoliofis_total_box());
//				total.setMonto(detail.getMonto_box());
//				System.out.println("total box: "+total.toString());
//				listaDocs.add(total);
//				//internet
//				internet.setCuenta(detail.getCuenta());
//				internet.setTipoDoc("Internet");
//				internet.setId(detail.getFac_internet());
//				internet.setFolioFiscal(detail.getFoliofis_internet());
//				internet.setMonto(detail.getMonto_internet());
//				System.out.println("Internet: "+internet.toString());
//				listaDocs.add(internet);
//				
//				//Edo cta
////				edoCta.setCuenta(detail.getCuenta());
////				edoCta.setTipoDoc("Estado de Cuenta");
////				edoCta.setId("Estado de cuenta");
////				edoCta.setFolioFiscal("Estado de cuenta");
////				edoCta.setMonto(0.0);
////				listaDocs.add(internet);
////				System.out.println("Imtems: "+listaDocs.size());
////				for(Documento doc: listaDocs){
////					System.out.println("DetalleDoc: "+doc.toString());
////				}
//				System.out.println("--------------------------------------------------"+i);
//				detail.setDocumentos(listaDocs);
//				listaDocs.clear();
//				i++;
//			}
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
			logger.error("Action getConciliacionVodBrm>>>"+e.getMessage());
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		sendJSONObjectToResponse(result);
		return null;
	}
    
    public String getResumeInterfactura(){

		try{
			ServiceResponse respDet = new ServiceResponse();
			
			respDet = ctasFacturadasvsFacturacionbrmDAO.getResumeInterfactura(getFecha());

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
			logger.error("Action getConciliacionVodBrm>>>"+e.getMessage());
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		sendJSONObjectToResponse(result);
		return null;
	}
	
	
	@SuppressWarnings({ "unused", "unchecked" })
	public String exportDetallectasFactvsFactBRMIF() {
		
		//************************************************* SI T_CONCILIACION 1
		if(getOpcion().equals("1")){
			//System.out.println("entro a opcion1");
			XSSFWorkbook myWorkBook = new XSSFWorkbook();
			XSSFSheet mySheet = myWorkBook.createSheet("Detalle BRM no INTERFACTURA");
			try {
				Calendar calendar = Calendar.getInstance();
				ServiceResponse detalleBeans1 = ctasFacturadasvsFacturacionbrmDAO.obtieneDetalleCtasFacturadasvsFacturacionbrm(getCptp(), getCpenl(), getCptfe());
				//System.out.println("se obtiene info");
				String reportFile = "Cuentas Facturadas vs. Facturacion BRM - INTERFACTURA"+ calendar.get(Calendar.YEAR) + "-"+ calendar.get(Calendar.MONTH) + "-"+ calendar.get(Calendar.DAY_OF_MONTH) + "".concat(".xlsx");
				setDetailedAllInfo( myWorkBook,mySheet, (List<DetalleCtasFacturadasvsFacturacionbrmVO>) detalleBeans1.getResult());
				try {
					ByteArrayOutputStream boas = new ByteArrayOutputStream();
					if(boas!=null)
					boas.close();
					myWorkBook.write(boas);
					setInputStream(new ByteArrayInputStream(boas.toByteArray()));
					if(boas!=null)
			            boas.close();
				} catch (Exception e) {
//					e.printStackTrace();
				}
			} catch (Exception e) {
//				e.printStackTrace();
			}	
		}
		
		//************************************************* SI T_CONCILIACION 2
		if(getOpcion().equals("2")){
			XSSFWorkbook myWorkBook = new XSSFWorkbook();
			XSSFSheet mySheet = myWorkBook.createSheet("Detalle Montos-INTERFACTURA");
			try {
				Calendar calendar = Calendar.getInstance();
				ServiceResponse detalleBeans1 = ctasFacturadasvsFacturacionbrmDAO.obtieneDetalleMontosInterfactura(getCptp(), getCpenl(), getCptfe());
				String reportFile = "Montos - INTERFACTURA"+ calendar.get(Calendar.YEAR) + "-"+ calendar.get(Calendar.MONTH) + "-"+ calendar.get(Calendar.DAY_OF_MONTH) + "".concat(".xlsx");
				setDetailedAllInfoMontos( myWorkBook,mySheet, (List<DetalleCtasFacturadasvsFacturacionMontosVO>) detalleBeans1.getResult());
				try {
					ByteArrayOutputStream boas = new ByteArrayOutputStream();
					boas.close();
					myWorkBook.write(boas);
					setInputStream(new ByteArrayInputStream(boas.toByteArray()));
					if(boas!=null)
			            boas.close();
				} catch (Exception e) {
//					e.printStackTrace();
				}
			} catch (Exception e) {
//				e.printStackTrace();
			}	
		}
		
		return SUCCESS;
	}

	private void setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleCtasFacturadasvsFacturacionbrmVO> detalleBeans) {
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
        
		final String[] errorSource = { "Fecha", "Cuenta","Empresa","Monto","Fecha de Factura","Fecha de Vencimiento",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Cuentas Facturadas vs. Facturacion BRM - INTERFACTURA");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle ENVIADAS");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
				
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,5));
			for (DetalleCtasFacturadasvsFacturacionbrmVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getCuenta());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getEmpresa());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getMonto());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getFecha_factura());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getFecha_vencimiento());
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
	
	
	private void setDetailedAllInfoMontos(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleCtasFacturadasvsFacturacionMontosVO> detalleBeans) {
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
        
		final String[] errorSource = { "Id_conciliacion", "Fecha_conci","Empresa","Archivo",
				"Account_no","Num_factura","Folio1","Folio2","Folio3","Razon_social","Total1","Total2","Total3",
				"Ciclo","Fecha","Tipo","Error_t","Fecha_i","Rfc","Folio_fiscal","Folio_fiscal2","Folio_fiscal3","Serie1",
				"Rs_facturante1","Serie2","Rs_facturante2","Serie3","Rs_facturante3",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Cuentas Facturadas vs. Facturacion BRM - INTERFACTURA");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,27));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle MONTOS");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
				
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,27));
			for (DetalleCtasFacturadasvsFacturacionMontosVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getId_conciliacion());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getFecha_conci());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getEmpresa());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getArchivo());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getAccount_no());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getNum_factura());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getFolio1());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(7).setCellValue(detalleBean.getFolio2());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(8).setCellValue(detalleBean.getFolio3());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(9).setCellValue(detalleBean.getRazon_social());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(10).setCellValue(detalleBean.getTotal1());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(11).setCellValue(detalleBean.getTotal2());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(12).setCellValue(detalleBean.getTotal3());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(13).setCellValue(detalleBean.getCiclo());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(14).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(15).setCellValue(detalleBean.getTipo());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(16).setCellValue(detalleBean.getError_t());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(17).setCellValue(detalleBean.getFecha_i());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(18).setCellValue(detalleBean.getRfc());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(19).setCellValue(detalleBean.getFolio_fiscal());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(20).setCellValue(detalleBean.getFolio_fiscal2());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(21).setCellValue(detalleBean.getFolio_fiscal3());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(22).setCellValue(detalleBean.getSerie1());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(23).setCellValue(detalleBean.getRs_facturante1());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(24).setCellValue(detalleBean.getSerie2());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(25).setCellValue(detalleBean.getRs_facturante2());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(26).setCellValue(detalleBean.getSerie3());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(27).setCellValue(detalleBean.getRs_facturante3());
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
