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

import com.mx.totalplay.dao.FacturaAntActDAO;
import com.mx.totalplay.vo.FacturaAntActVO;
import com.mx.totalplay.vo.ServiceResponse;

public class FacturaAntActAction extends CifrasControlAction{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(FacturaAntActAction.class);
	FacturaAntActDAO factAntActDAO =  new FacturaAntActDAO();
	private String fecha;
//	private String empresa;
	private InputStream inputStream;
	private String reportFile;
	
	private List<FacturaAntActVO> facturaAntActVOList = new ArrayList<FacturaAntActVO>();
	
	@SuppressWarnings("unused")
	public String getFacturaAntActAction(){
//		System.out.println("FacturaAntActAction.getFacturaAntActAction()");
		//logger.debug("*** getPagosBRMBanco()");
		String resultAction = SUCCESS;
		ServiceResponse result = new ServiceResponse();
		try {
			ServiceResponse respDet = new ServiceResponse();
			respDet = factAntActDAO.getFacturacionDao(getFecha());
			if (respDet.isSuccess()) {
				result.setSuccess(true);
				result.setMensaje(respDet.getMensaje());
				result.setResult(respDet.getResult());
			} else {
//				logger.error("getPagosBRMBanco ERROR");
				result.setSuccess(false);
				result.setResult(null);
				result.setMensaje(respDet.getMensaje());
			}

		} catch (Exception e) {
//			logger.error("getPagosBRMBanco, ###ERROR### " + e);
			setActionError("Estimado usuario, ocurrio un problema con su operacion, por favor reintentelo.");
			resultAction = "ERRORPAGE";
		}
		sendJSONObjectToResponse(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		return null;
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

	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

//	public String getEmpresa() {
//		return empresa;
//	}
//
//	public void setEmpresa(String empresa) {
//		this.empresa = empresa;
//	}

	

}
