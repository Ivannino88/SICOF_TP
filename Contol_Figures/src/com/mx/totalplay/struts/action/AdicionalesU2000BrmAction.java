package com.mx.totalplay.struts.action;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import org.apache.log4j.Logger;
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
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mx.totalplay.dao.AdicionalesU2000BrmDAO;
import com.mx.totalplay.vo.AdicionalesU2000BrmVO;
import com.mx.totalplay.vo.DetalleAddonsBrmNoU2000VO;
import com.mx.totalplay.vo.DetalleAddonsU2000NoBrmVO;
import com.mx.totalplay.vo.ServiceResponse;
import java.lang.reflect.Type;

public class AdicionalesU2000BrmAction extends CifrasControlAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AdicionalesU2000BrmAction.class);
	AdicionalesU2000BrmDAO adicionalesU2000BrmDAO = new AdicionalesU2000BrmDAO();
	String fecha;
	String fechaReporte;
	String jsonDatos;
	String fechActuCorre;
	int row1;
	int row2;
	String accion;
	
	private List<AdicionalesU2000BrmVO> ctasActCicloBRMVOList = new ArrayList<AdicionalesU2000BrmVO>();
	private String reportFile;
	private InputStream inputStream;
	
	private String fechaTabla;
	

	
	ServiceResponse result = new ServiceResponse();
	
	public String getConciliacionAddonsBrmU2000(){
		System.out	.println("AdicionalesU2000BrmAction.getConciliacionAddonsBrmU2000()");
		AdicionalesU2000BrmVO ctasActBrmVO = new AdicionalesU2000BrmVO();
		ctasActBrmVO.setFecha(getFecha());	
		ctasActBrmVO.setTipo_conciliacion("1");
		
		//System.out	.println("AdicionalesU2000BrmAction.getConciliacionAddonsBrmU2000()"ctasActBrmVO.getFecha());
		try{
			
			result = adicionalesU2000BrmDAO.getConciliacionAddonsBrmU2000(ctasActBrmVO);
			

			
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
		//	logger.error("Action getConciliacionAddonsBrmU2000>>>"+e);
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	//  ##################   CONSULTA BOTON DETALLE    detalleXXX
	
	public String exportDetalleConciliacionAddonsBrmU2000DetailsTablaJson(){
		
		System.out.println("json detalle  #1");
		
		List<DetalleAddonsBrmNoU2000VO> lista = new ArrayList<DetalleAddonsBrmNoU2000VO>();
		try{
			ServiceResponse respDet = new ServiceResponse();
			System.out.println("json detalle  #2");
			respDet = adicionalesU2000BrmDAO.getDetalleAddonsBrmNoU2000Detalle(getFechaTabla(),getRow1(),getRow2());
			System.out.println("json detalle  #6");
			if(respDet.isSuccess()){
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
				result.setSuccess(true);
//				System.out.println(respDet.getResult());
				
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
	
	
//  ##################   CONSULTA CONTEO DE DETALLE U2000
	
	public String getConteoDetails(){
		System.out.println("getConteoDetails");
		logger.debug("json detalle  #1  exportDetalleConciliacionAddonsBrmU2000DetailsTablaJson ");

		Integer conteo=0;
		try{
			conteo = adicionalesU2000BrmDAO.getDetalleAddonsBrmNoU2000Conteo(getFechaTabla());
		}catch(Exception e){
		}
		sendJSONObjectToResponse(conteo);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	// ************ INICIO *****************  MODULO DE ACTUALIZAR STATUS *********************************
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public String getJsonActualizar(){
		System.out.println("AdicionalesU2000BrmAction.getJsonActualizar()");
		com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
		Object obj = parser.parse(getJsonDatos());
//		System.out.println("fecha actualiza corregidos: "+getFechActuCorre());
		List<DetalleAddonsBrmNoU2000VO> listaTemp = new ArrayList<DetalleAddonsBrmNoU2000VO>();
		String resultado="";
		
		System.out.println(obj);
		Gson json = new Gson();
		resultado=json.toJson(obj);

		JSONArray jsonArray = new JSONArray(resultado);
		
		
            for (int i = 0; i<jsonArray.length(); i++) {
            	DetalleAddonsBrmNoU2000VO lista1 = new DetalleAddonsBrmNoU2000VO();
				JSONObject object = jsonArray.getJSONObject(i);
				String fecha1=object.getString("fecha");
				String accion = object.getString("accion");
				 boolean accion1 =object.getBoolean("accion1");
				 String addons=object.getString("addons");
				 String cuenta =object.getString("cuenta");
				 String descripcion = object.getString("descr");
				 String id_conciliacion=object.getString("id_conciliacion");
			     String megas =object.getString("megas");	
				 String ont = object.getString("ont");

//               System.out.println(" CUENTA: "+ cuenta+" MEGAS BRM: "+ megas+" MEGAS RED :"+descripcion+ " ACCION: "+ accion+ " ACCION ACTUAL: "
//            		   						+ accion1 + " ONT: "+ ont + " FECHA: "+ fecha1+ " ID: "+id_conciliacion);
               lista1.setFecha(fecha1);
               lista1.setId_conciliacion(id_conciliacion);
                lista1.setCuenta(cuenta);
                lista1.setMegas(megas);
                lista1.setDescr(descripcion);
                lista1.setOnt(ont);
                
                
                if(accion1==true){
                	accion="1";
                }
                else if(accion1==false){ 
                	accion="0";}
                lista1.setAccion(accion);
                
                listaTemp.add(lista1);
            }
           
            result =adicionalesU2000BrmDAO.getJsonActualizarLista(listaTemp,getFechActuCorre());
		try {
			if(result.isSuccess()){
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(true);
			}else{
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(false);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
        	System.out.println(" FIN -------------  AdicionalesU2000BrmAction.getJsonActualizar()");
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String updateListAll(){
		System.out.println("AdicionalesU2000BrmAction.updateListAll()");
		
		String resultado="";
            result =adicionalesU2000BrmDAO.actualizarListaAll(getAccion(),getFechActuCorre());
		try {
			if(result.isSuccess()){
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(true);
			}else{
				result.setMensaje(result.getMensaje());
				result.setResult(result.getResult());
				result.setSuccess(false);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
        	System.out.println(" FIN -------------  AdicionalesU2000BrmAction.updateListAll()");
		
		return null;
	}
	
	// ***************** FIN ************  MODULO DE ACTUALIZAR STATUS ********************************* 

	
	
	public String exportDetalleConciliacionAddonsBrmU2000DetailsTablaJson2(){
		System.out	.println("AdicionalesU2000BrmAction.exportDetalleConciliacionAddonsBrmU2000DetailsTablaJson2()");
		try{
			ServiceResponse respDet = new ServiceResponse();
			
			logger.info("**getFechaTabla(): "+getFechaTabla());			
			respDet = adicionalesU2000BrmDAO.getDetalleAddonsBrmNoU2000Detalle2(getFechaTabla(),getRow1(),getRow2());
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
		logger.info("  :: FIN AdicionalesU2000BrmAction.exportDetalleConciliacionAddonsBrmU2000DetailsTablaJson2()");
		return null;
	}
	
	public String execute(){
			
		return SUCCESS;
	}
	
	// --------------------------------------------- GENERACION DE EXCEL  ------------------------------------------------------ 
	@SuppressWarnings({ "unused", "unchecked" })
	public String exportDetalleConciliacionAddonsBrmU2000Details() {
		logger.debug("*********Action: exportDetalleConciliacionAddonsBrmU2000Details()");
		logger.info("***Action: exportDetalleConciliacionAddonsBrmU2000Details() "+fecha);
		XSSFWorkbook myWorkBook = new XSSFWorkbook();
		XSSFSheet mySheet = myWorkBook.createSheet("DETALLE_ADDONS_BRM_no_U2000 ");
//		XSSFSheet mySheetIPTV = myWorkBook.createSheet("DETALLE_ADDONS_U2000_NO_BRM");
		try {
			Calendar calendar = Calendar.getInstance();
			ServiceResponse detalleBeans1 = adicionalesU2000BrmDAO.getDetalleAddonsBrmNoU2000(getFecha());
//			ServiceResponse detalleBeans2 = adicionalesU2000BrmDAO.getDetalleAddonsU2000NoBrm(getFecha());

			String reportFile = "CONCILIACIÓN ADDONS BRM vs U2000"+ calendar.get(Calendar.YEAR) + "-"+ calendar.get(Calendar.MONTH) + "-"+ calendar.get(Calendar.DAY_OF_MONTH) + "".concat(".xlsx");
				
		//	logger.debug("*******   ******  "+detalleBeans1.getResult());
			
			setDetailedAllInfo( myWorkBook,mySheet, (List<DetalleAddonsBrmNoU2000VO>) detalleBeans1.getResult());
//			setDetailedAllInfoIptv( myWorkBook,mySheetIPTV, (List<DetalleAddonsU2000NoBrmVO>) detalleBeans2.getResult());

			try {
				ByteArrayOutputStream boas = new ByteArrayOutputStream();
				if(boas!=null)
				boas.close();
				myWorkBook.write(boas);
				setInputStream(new ByteArrayInputStream(boas.toByteArray()));
				
				
				if(boas!=null)
		            boas.close();
				
			} catch (Exception e) {
			//	e.printStackTrace();
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		logger.info("********* FIN Action: exportDetalleConciliacionAddonsBrmU2000Details()");
		return SUCCESS;
	}

	@SuppressWarnings("deprecation")
	private void setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleAddonsBrmNoU2000VO> detalleBeans) {
		System.out.println("AdicionalesU2000BrmAction.setDetailedAllInfo()  generando excel");
		logger.debug("  setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleAddonsBrmNoU2000VO> detalleBeans)  generando excel # 1");
		logger.info("  setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleAddonsBrmNoU2000VO> detalleBeans)  generando excel #1   INFO  recibida" +detalleBeans.size());
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
		final String[] errorSource = { "Fecha", "Cuenta", "Plan","ADDONS","Megas","Descripción","ONT",""};
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Conciliación ADDONS BRM vs U2000");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle ADDONS BRM NO U2000");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				 monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
				
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,6));
			for (DetalleAddonsBrmNoU2000VO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getCuenta());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getPlan());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getAddons());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getMegas());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getDescr());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getOnt());
				monthCell.setCellStyle(cellstyle);
				
			}
			for (int i = 0; i < myWorkBook.getNumberOfSheets(); i++) {
	            XSSFSheet thisSheet = myWorkBook.getSheetAt(i);
	            XSSFRow rowexcel = thisSheet.getRow(thisSheet.getLastRowNum());
	            if(rowexcel != null){
	            for (short j = 0; j < rowexcel.getLastCellNum(); j++) {
	            	myWorkBook.getSheetAt(i).autoSizeColumn(j);
	            }
	            // Freezing the top row
	            myWorkBook.getSheetAt(i).createFreezePane(0, 1);
	        }
			}
		} catch (Exception e) {
		//	e.printStackTrace();
		}
		logger.info(" FIN setDetailedAllInfo(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleAddonsBrmNoU2000VO> detalleBeans)");
	}

	@SuppressWarnings("deprecation")
	private void setDetailedAllInfoIptv(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleAddonsU2000NoBrmVO> detalleBeans) {
		System.out	.println("setDetailedAllInfoIptv(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleAddonsU2000NoBrmVO> detalleBeans)");
		logger.debug("  setDetailedAllInfoIptv(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleAddonsU2000NoBrmVO> detalleBeans)   generando excel # 2");
		logger.info("  setDetailedAllInfoIptv(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleAddonsU2000NoBrmVO> detalleBeans)  generando excel # 2" + detalleBeans.size());
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
		        
		final String[] errorSource = { "Fecha", "Cuenta", "ADDONS","Megas", "Descripción","ONT","Perfil Bajada","" };
		try {
			Row header = mySheet.createRow(0);
			Cell monthCell = header.createCell(0);
			monthCell.setCellValue("Conciliación ADDONS BRM vs U2000");
			monthCell.setCellStyle(headstyle);
			mySheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
			header = mySheet.createRow(1);
			monthCell = header.createCell(0);
			monthCell.setCellValue("Detalle ADDONS U2000 NO BRM");
			monthCell.setCellStyle(headstyle);

			
			header = mySheet.createRow(2);
			for (int i = 0; i < errorSource.length; i++) {
				monthCell = header.createCell(i);
				monthCell.setCellValue(errorSource[i]);
				monthCell.setCellStyle(headstyle2);
				
			}
			mySheet.addMergedRegion(new CellRangeAddress(1,1,0,6));
			for (DetalleAddonsU2000NoBrmVO detalleBean : detalleBeans) {
				myRow = mySheet.createRow(rowNum++);
				myRow.createCell(0).setCellValue(detalleBean.getFecha());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(1).setCellValue(detalleBean.getCuenta());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(2).setCellValue(detalleBean.getAddons());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(3).setCellValue(detalleBean.getMegas());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(4).setCellValue(detalleBean.getDescr());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(5).setCellValue(detalleBean.getOnt());
				monthCell.setCellStyle(cellstyle);
				myRow.createCell(6).setCellValue(detalleBean.getPerfil_bajada());
				monthCell.setCellStyle(cellstyle);

			}
			for (int i = 0; i < myWorkBook.getNumberOfSheets(); i++) {
	            XSSFSheet thisSheet = myWorkBook.getSheetAt(i);
	            XSSFRow rowexcel = thisSheet.getRow(thisSheet.getLastRowNum());
	            if(rowexcel != null){
	            for (short j = 0; j < rowexcel.getLastCellNum(); j++) {
	            	myWorkBook.getSheetAt(i).autoSizeColumn(j);
	            }
	            // Freezing the top row
	            myWorkBook.getSheetAt(i).createFreezePane(0, 1);
	        }
			}
		} catch (Exception e) {
		//	e.printStackTrace();
		}
		logger.info(" FIN  setDetailedAllInfoIptv(XSSFWorkbook myWorkBook,XSSFSheet mySheet,List<DetalleAddonsU2000NoBrmVO> detalleBeans)  generando excel # 2" + detalleBeans.size());
	}

	
	
	public int getRow1() {
		return row1;
	}

	public void setRow1(int row1) {
		this.row1 = row1;
	}

	public int getRow2() {
		return row2;
	}

	public void setRow2(int row2) {
		this.row2 = row2;
	}

	public String getFechaTabla() {
		return fechaTabla;
	}

	public void setFechaTabla(String fechaTabla) {
		this.fechaTabla = fechaTabla;
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
	
	public String getFechActuCorre() {
		return fechActuCorre;
	}

	public void setFechActuCorre(String fechActuCorre) {
		Conversor conver=new Conversor();
		this.fechActuCorre = conver.conversor(fechActuCorre);
	}

	public List<AdicionalesU2000BrmVO> getCtasActCicloBRMVOList() {
		return ctasActCicloBRMVOList;
	}

	public void setCtasActCicloBRMVOList(
			List<AdicionalesU2000BrmVO> ctasActCicloBRMVOList) {
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

	public String getJsonDatos() {
		return jsonDatos;
	}

	public void setJsonDatos(String jsonDatos) {
		this.jsonDatos = jsonDatos;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	

	

}
