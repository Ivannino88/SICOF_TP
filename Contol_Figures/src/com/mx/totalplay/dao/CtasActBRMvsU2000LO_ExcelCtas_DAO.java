package com.mx.totalplay.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.CtasActBRMvsU2000VO;
import com.mx.totalplay.vo.LineasInternasVO;
import com.mx.totalplay.vo.ServiceResponse;

public class CtasActBRMvsU2000LO_ExcelCtas_DAO {
	
	private static final Logger logger = Logger.getLogger(CtasActBRMvsU2000LO_ExcelCtas_DAO.class);
	
	public ServiceResponse getCtasActBRMvsU2000_LO(File file){
		//logger.debug("***DAO: getCtasActBRMvsU2000(Fecha: "+ctasActBrmVO.getFecha()+")");
		ServiceResponse response = new ServiceResponse();
		
		try {
			List<LineasInternasVO> excelLibro= new ArrayList<LineasInternasVO>();
			List<LineasInternasVO> excelLibrofinal= new ArrayList<LineasInternasVO>();

			excelLibro=leerExcel(file);
			
			for(int i=1;i<excelLibro.size();i++){
				excelLibrofinal.add(excelLibro.get(i));
			}
			
			if(excelLibro.size() > 0 && excelLibro.get(0).getCuenta().equalsIgnoreCase("CUENTA")){
				response.setSuccess(true);
				response.setResult(excelLibrofinal);
				response.setMensaje("Se obtuvo la informacion correctamente");
			}else{
				response.setSuccess(false);
				response.setResult(excelLibrofinal);
				response.setMensaje("El archivo especificado no es el correcto");
			}
		} catch (Exception e) {
			//logger.error(e.getMessage());
			response.setMensaje("El archivo especificado no es el correcto");
			response.setSuccess(false);
		}
		
		return response;
		
		
	}
	
	public ArrayList<LineasInternasVO> leerExcel(File file) throws IOException {
	    ArrayList<LineasInternasVO> listBooks = new ArrayList<LineasInternasVO>();
	    FileInputStream inputStream=null;
	    
	    try{
	    inputStream = new FileInputStream(file);
	 	   
	    Workbook workbook = new XSSFWorkbook(inputStream);
	    Sheet firstSheet = workbook.getSheetAt(0);
	    Iterator<Row> iterator = firstSheet.iterator();
	    Row nextRow;
	    
//	    if(iterator.hasNext())
//	    iterator.next();

	    
	    while (iterator.hasNext()) {
	        nextRow = iterator.next();
	        Iterator<Cell> cellIterator = nextRow.cellIterator();
	        LineasInternasVO aBook = new LineasInternasVO();
	        Boolean vacio=false;
	        
	        
	        
	        while (cellIterator.hasNext()) {
	            Cell nextCell = cellIterator.next();
	            int columnIndex = nextCell.getColumnIndex();
	           
	            switch (columnIndex) {
	            case 0:
	            	if(getCellValue(nextCell)!=null)
	                aBook.setCuenta(getCellValueStr(nextCell)+"");
	            	else
	            	vacio=true;
	                break;
	                
	            case 1:
	            	if(getCellValue(nextCell)!=null)
	                aBook.setEmpresa(getCellValue(nextCell)+"");
	            	else
		            	vacio=true;
	                break;
	                
	            case 2:
	            	if(getCellValue(nextCell)!=null){
	
	            		SimpleDateFormat parseador = new SimpleDateFormat("MM/dd/yy");
	            		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
	            		Date date;
					
							try {
								date = parseador.parse(getCellValueStr(nextCell)+"");
								aBook.setFecha(formateador.format(date)+"");
							} catch (ParseException e) {
								aBook.setFecha(getCellValueStr(nextCell)+"");
							}

	            	}
	            	else
		            	vacio=true;
	                break;
	            }	 
	        }
	        if(vacio==false)
	        listBooks.add(aBook);
	        
	    }
        inputStream.close();

	    } catch (IOException e) {
	    	if(inputStream!=null)
				inputStream.close();
			}
	    return listBooks;
	}
	
	private Object getCellValue(Cell cell) {
		
	    switch (cell.getCellType()) {
	    
	    case Cell.CELL_TYPE_STRING:
	        return cell.getStringCellValue();
	 
	    case Cell.CELL_TYPE_BOOLEAN:
	        return cell.getBooleanCellValue();
	 
	    case Cell.CELL_TYPE_NUMERIC:
	        return cell.getNumericCellValue();
	    }
	    return null;
	}
	
private Object getCellValueStr(Cell cell) {
		
	 DataFormatter formatter = new DataFormatter();
     String str = formatter.formatCellValue(cell);
    return str;
}
}