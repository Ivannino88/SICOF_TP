package com.mx.totalplay.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.mx.totalplay.vo.LineasInternasVO;
import com.mx.totalplay.vo.ServiceResponse;

public class PaqTvBrmRedIPTVIncluidoLI_Ctas_DAO {

	private static final Logger logger = Logger.getLogger(PaqTvBrmRedIPTVIncluidoLI_Ctas_DAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;

//**************** METODO PARA TABLA INICIAL **************************************
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getPaqTvBrmRedIPTVIncluidoLI_Ctas_DAO(String fecha, String todos){
		//logger.debug("***DAO: getCtasActBRMvsU2000(Fecha: "+ctasActBrmVO.getFecha()+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("fecha", fecha);
			
			List<LineasInternasVO> lineasInternasVOList = new ArrayList<LineasInternasVO>();
			
			if(todos.equals("1"))
			lineasInternasVOList = session.selectList("com.mx.totalplay.SDMapper_Selects.PaqTvBrmRedIPTVIncluidoLI_Ctastodos", map);
			else
			lineasInternasVOList = session.selectList("com.mx.totalplay.SDMapper_Selects.PaqTvBrmRedIPTVIncluidoLI_Ctas", map);

			if(lineasInternasVOList.size() >= 0){
				response.setSuccess(true);
				response.setResult(lineasInternasVOList);
				response.setMensaje("Lineas Internas DAO Cuentas Exitoso");
			}else{
				response.setSuccess(false);
				response.setResult(lineasInternasVOList);
				response.setMensaje("Lineas Internas DAO Cuentas NO Exitoso");
			}
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
//****************************************** INSERTAR NUEVOS REGISTROS **************************	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ServiceResponse getPaqTvBrmRedIPTVIncluidoLI_insertarCtas_DAO(List<LineasInternasVO> listas){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		Integer result = 0;
		int contador=0;
		int resultado=0;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			for(int i=0;i<listas.size();i++){
			Map map = new HashMap();
			map.put("cuenta", listas.get(i).getCuenta());
			map.put("fecha", listas.get(i).getFecha());
			map.put("empresa", listas.get(i).getEmpresa());
		
			result = session.insert("com.mx.totalplay.SDMapper_Inserts.PaqTvBrmRedIPTVIncluidoLI_insertarCtas",map);
			
			if(result!=0)
				contador++;
				
				resultado++;			
				}
				
				if(resultado!=0 && listas.size()==resultado){
					session.commit();
					response.setSuccess(true);
					response.setResult(result);
					response.setMensaje("Se insertaron "+contador+" de "+resultado+" registros");
				}else{
					session.rollback();
					result=0;
				
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("Ocurrio un problema, favor de verificar el documento");
				
			}
			} catch (Exception e) {
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("Contenido con formato inválido");
				//logger.error(e.getMessage());
				
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
//********************************* ELIMINAR REGISTROS **********************************************
	public ServiceResponse getPaqTvBrmRedIPTVIncluidoLI_eliminarCtas_DAO(List<LineasInternasVO> listas){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		Integer result = 0;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			result = session.delete("com.mx.totalplay.SDMapper_Deletes.PaqTvBrmRedIPTVIncluidoLI_eliminarCtas",listas);
			
			if(result!=0){
				session.commit();
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se borraron "+result+" registros");
			}else{
				session.rollback();
				result=0;
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("Ocurrio un problema");	
			}
			} catch (Exception e) {
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("Ocurrio un problema");
				//logger.error(e.getMessage());
				
		}finally{
			if(session != null)
				session.close();
		}
		
		return response;
	}
	
	public ServiceResponse getEliminarTodoCtas_DAO(){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		Integer result = 0;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			result = session.delete("com.mx.totalplay.SDMapper_Deletes.PaqTvBrmRedIPTVIncluidoLI_eliminarTodoCtas");
			
			if(result!=0){
				session.commit();
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se borraron "+result+" registros");
			}else{
				session.rollback();
				result=0;
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("Ocurrio un problema");	
			}
			} catch (Exception e) {
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("Ocurrio un problema");
				//logger.error(e.getMessage());
				
		}finally{
			if(session != null)
				session.close();
		}
		
		return response;
	}

//********************************* IMPORT PREVIO EXCEL ************************************************
//******************************************************************************************************

	public ServiceResponse getPaqTvBrmRedIPTVIncluidoLI_Excel(File file){
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
	    
	 //   if(iterator.hasNext())   ***leer desde el renglon 2
	//    iterator.next();

	    
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
	    }
	    catch (IOException e) {
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
