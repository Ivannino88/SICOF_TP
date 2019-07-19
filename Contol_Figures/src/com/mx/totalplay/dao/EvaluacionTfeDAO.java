package com.mx.totalplay.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sun.print.resources.serviceui;

import com.google.gson.Gson;
import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.EvaluacionTfeTempVO;
import com.mx.totalplay.vo.EvaluacionTfeVO;
import com.mx.totalplay.vo.ImpleVO;
import com.mx.totalplay.vo.ServiceResponse;


public class EvaluacionTfeDAO {
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
@SuppressWarnings("unused")
private static final Logger logger = Logger.getLogger(EvaluacionTfeDAO.class);
List<ImpleVO> lista = new ArrayList<ImpleVO>();

// GUARDAR DATOS 
public ServiceResponse guardarDatos(String datos){
	logger.info("EvaluacionTfeDAO.guardarDatos()");
	ServiceResponse response = new ServiceResponse();
	SqlSession session = null;
	Integer result = 0; 
	int contador=0,resultado=0;
	
	Gson gson = new Gson();
	EvaluacionTfeTempVO [] tempVO = gson.fromJson(datos,
			EvaluacionTfeTempVO  [].class);

	try {
		sqlSessionFactory = conexion.conexionMybatis();
		session=sqlSessionFactory.openSession();
		for (EvaluacionTfeTempVO x : tempVO) {
			Map map = new HashMap();
			map.put("cuenta",x.getCuenta());
			result =session.insert("com.mx.totalplay.SDMapper_Inserts.implementacionTfe",map);
			if(result!=0)
				contador++;
				resultado++;			
				}
			if(resultado!=0 && tempVO.length==resultado){
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
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		response.setSuccess(false);
		response.setResult(result);
		response.setMensaje("Contenido con formato inválido");
	}finally{
		if(session != null)
			session.close();
	}
	return response;
	}

//GUARDAR UN DATO 
public ServiceResponse guardaUnDato(String cuenta){
	logger.info("EvaluacionTfeDAO.guardaUnDato()");
	ServiceResponse response = new ServiceResponse();
	SqlSession session = null;
	Integer result = 0; 
	int contador=0,resultado=0;

	try {
		sqlSessionFactory = conexion.conexionMybatis();
		session=sqlSessionFactory.openSession();
		System.out.println("estatus conexion"+session);
//		consultaImplementacion();
//		if (EvaluacionTfeTempVO x : tempVO) {
//			Map map = new HashMap();
//			map.put("cuenta",x.getCuenta());
			result =session.insert("com.mx.totalplay.SDMapper_Inserts.implementacionTfe",cuenta);
			if(result!=0)
				contador++;
				resultado++;			
//				}
			if(result!=0){
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
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		response.setSuccess(false);
		response.setResult(result);
		response.setMensaje("Contenido con formato inválido");
	}finally{
		if(session != null)
			session.close();
	}
	return response;
	}

// ---- consulta general ------
public ServiceResponse consultaImplementacionTfe(){
	logger.info("EvaluacionTfeDAO.consultaImplementacionTfe()");
	ServiceResponse response = new ServiceResponse();
	SqlSession session = null;
	try {
		sqlSessionFactory = conexion.conexionMybatis();
		session=sqlSessionFactory.openSession();
		List<ImpleVO> lista = new ArrayList<ImpleVO>();
//		System.out.println("session "+ session);
		lista=session.selectList("com.mx.totalplay.SDMapper_Selects.getImplementacionTfe");
		
		
		if (lista.size()>0 && lista!=null) {
			logger.info("datos : "+lista.size());
//			for (ImpleVO x : lista) {
//				System.out.println(x+" dato a mostrar: "+x.getSn());
//			}
			
			response.setSuccess(true);
			response.setResult(lista);
			response.setMensaje("Se obtuvo la informacion correctamnete");
		} else{
			logger.info(" sin datos ");
			response.setSuccess(false);
			response.setResult(lista);
			response.setMensaje("NO se obtuvo la informacion");
		}
		session.close();
	} catch (Exception e) {
		// TODO: handle exception
//		e.printStackTrace();
	}
	finally{
		if (session!=null) {
			session.close();
		}
	}
	return response;
}


// ELIMINAR TODO 
public ServiceResponse eliminarTodoDao(){
	logger.info("EvaluacionTfeDAO.eliminarTodoDao()");
	ServiceResponse response = new ServiceResponse();
	SqlSession session = null;
	Integer result = 0;
	try {
		sqlSessionFactory = conexion.conexionMybatis();
		session = sqlSessionFactory.openSession();
		result = session.delete("com.mx.totalplay.SDMapper_Deletes.eliminaImplementaTfe");
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

// ELIMINAR ELEMENTOS SELECCIONADOS 
public ServiceResponse eliminaElementosSeleccionadosDAO(List<ImpleVO> listas){
	logger.info("EvaluacionTfeDAO.eliminaElementosSeleccionadosDAO()");
	ServiceResponse response = new ServiceResponse();
	SqlSession session = null;
	Integer result = 0;
	try {
		sqlSessionFactory = conexion.conexionMybatis();
		session = sqlSessionFactory.openSession();
		result = session.delete("com.mx.totalplay.SDMapper_Deletes.eliminarListaSeleccionada",listas);
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


//LEER EXCEL Y CARGARLO EN PREVIO	
	public ServiceResponse getEvaluacionTfeExcel(File file){
		System.out.println("EvaluacionTfeDAO.getEvaluacionTfeExcel()");
		ServiceResponse response = new ServiceResponse();
		
		try {
			List<EvaluacionTfeVO> excelLibro= new ArrayList<EvaluacionTfeVO>();
			List<EvaluacionTfeVO> sinEspacio = new ArrayList<EvaluacionTfeVO>();

			excelLibro=leerExcel(file);
			
			logger.info("tamaño es: "+excelLibro.size());
			
			for (EvaluacionTfeVO x : excelLibro) {
				
				 if(x.getCuenta().indexOf(" ")>-1){
        			 //System.out.println("cadena con espacios: ");
        		 }else{
//        			 System.out.println("cadena SIN espacios: ");
//        			 System.out.println("------------ ccc ccccc------- "+x.getCuenta());
        			 sinEspacio.listIterator().add(x);
        		 }
			}
			validaExistencia(sinEspacio);
			
			
//			for(int i=0;i<excelLibro.size();i++){
//				if(excelLibro.get(i).toString().indexOf(" ")>-1){
//					
//				}else{
//					System.out.println("lista final: -->"+excelLibro.get(i));
//					excelLibrofinal.add(excelLibro.get(i));
//				}
//			}
			if(excelLibro.size() >= 0 && excelLibro.add(null)){
				System.out.println();
				response.setSuccess(true);
				response.setResult(sinEspacio);
				response.setMensaje("Se obtuvo la informacion correctamente");
			}else{
				response.setSuccess(false);
				response.setResult(sinEspacio);
				response.setMensaje("El archivo especificado no es el correcto");
			}
		} catch (Exception e) {
			//logger.error(e.getMessage());
			response.setMensaje("El archivo especificado no es el correcto");
			response.setSuccess(false);
		}
		return response;
	}
	
	// FORMATO .XLSX
	public ArrayList<EvaluacionTfeVO> leerExcel(File file) throws IOException {
		System.out.println("EvaluacionTfeDAO.leerExcel()");
		logger.info("EvaluacionTfeDAO.leerExcel()");
	    ArrayList<EvaluacionTfeVO> listBooks = new ArrayList<EvaluacionTfeVO>();
	    FileInputStream inputStream=null;
	    
	    try{
	    inputStream = new FileInputStream(file);
	 	   
	    Workbook workbook = new XSSFWorkbook(inputStream);
	    Sheet firstSheet = workbook.getSheetAt(0);
	    Iterator<Row> iterator = firstSheet.iterator();
	    Row nextRow;
	    
	    while (iterator.hasNext()) {
	        nextRow = iterator.next();
	        Iterator<Cell> cellIterator = nextRow.cellIterator();
	        EvaluacionTfeVO aBook = new EvaluacionTfeVO();
	        Boolean vacio=false;
	        
	        while (cellIterator.hasNext()) {
	            Cell nextCell = cellIterator.next();
	            int columnIndex = nextCell.getColumnIndex();
	           
	            switch (columnIndex) {
	            case 0:
	            	if(getCellValue(nextCell) !=null && getCellValue(nextCell).toString().length()<=20){
	            		 aBook.setCuenta(getCellValueStr(nextCell)+"");
	            	}else
	            	vacio=true;
	                break;
	                
	            case 1:
	            	if(getCellValue(nextCell)!=null)
	                aBook.setPlan(getCellValue(nextCell)+"");
	            	else
		            	vacio=true;
	                break;

	            case 2:
	                if(getCellValue(nextCell)!=null)
		                aBook.setEstatus(getCellValue(nextCell)+"");
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
	
// --- OBTENER VALOR CELDA	
	@SuppressWarnings("deprecation")
	private Object getCellValue(Cell cell) {
		
	    switch (cell.getCellType()) {
	    
	    case Cell.CELL_TYPE_STRING:
	        return cell.getStringCellValue().trim();
	 
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



// VALIDAR EXISTENCIA 
public ServiceResponse  validaExistencia(List<EvaluacionTfeVO> listaEntrada){
	System.out.println("EvaluacionTfeDAO.validaExistencia()");
	
	int repetidos=0,sinRepetir=0,entrada=0;
	logger.info("lista entrada");
	entrada=listaEntrada.size();
	logger.info("tamaño lista entrada "+entrada);
	for (EvaluacionTfeVO  j: listaEntrada) {
//		System.out.println("cuenta: "+j.getCuenta());
	}
	
	System.out.println("EvaluacionTfeDAO.validaExistencia()");

	ServiceResponse response = new ServiceResponse();
	SqlSession session = null;
	
	try {
		sqlSessionFactory = conexion.conexionMybatis();
		session=sqlSessionFactory.openSession();
		List<ImpleVO> lista = new ArrayList<ImpleVO>();
		lista=session.selectList("com.mx.totalplay.SDMapper_Selects.getImplementacionTfe");
		
//		for (int i = 0; i <listaEntrada.size(); i++) {
//			System.out.println("recorre lista entrada: "+listaEntrada.get(i));
//			for (ImpleVO x : lista) {
//				if(listaEntrada.get(i).equals(x.getSn())){
//					System.out.println("existe-----");
//				}
//				
//			}
//			System.out.println("no existe");
//		}
		for (EvaluacionTfeVO i : listaEntrada) {
			for (ImpleVO j : lista) {
				if(i.getCuenta().equals(j.getSn())){
//					System.out.println("foreach existe"+repetidos++);
					repetidos++;
				}
			}
//			System.out.println("sin repetir"+sinRepetir++);
			sinRepetir++;
		}
		System.out.println("repetido= "+repetidos+" "+"sinRepetir= "+sinRepetir);
		
		if (lista.size()>0 && lista!=null) {
//			logger.info("si hay datos son= "+lista.size());
//			for (ImpleVO x : lista) {
//				System.out.println(x+" dato a mostrar: "+x.getSn());
//			}
			
			response.setSuccess(true);
			response.setResult(lista);
			response.setMensaje("Se obtuvo la informacion correctamnete");
		} else{
			logger.info(" no hay datos ");
			response.setSuccess(false);
			response.setResult(lista);
			response.setMensaje("NO se obtuvo la informacion");
		}
		session.close();
	} catch (Exception e) {
	}
	finally{
		if (session!=null) {
			session.close();
		}
	}
	return response;
}


public ServiceResponse  validarElemento(String elemento){
	logger.info("EvaluacionTfeDAO.validarElemento()");
//	System.out.println("elementoes:  "+elemento);
	int status = 0;
//	logger.info(elemento);
	ServiceResponse response = new ServiceResponse();
	SqlSession session = null;
	try {
		sqlSessionFactory = conexion.conexionMybatis();
		session=sqlSessionFactory.openSession();
		List<ImpleVO> lista = new ArrayList<ImpleVO>();
		lista=session.selectList("com.mx.totalplay.SDMapper_Selects.getImplementacionTfe");
		if (lista.size()>0 && lista!=null) {
			for (ImpleVO impleVO : lista) {
				if (impleVO.getSn().equals(elemento) ) {
//					System.out.println("elemento ENCONTRADO ");
					status=1;
				} else {
//					System.out.println("sin elemento");
				}
			}
			
			response.setSuccess(true);
			response.setResult(status);
			response.setMensaje("elemento existente en la base de datos");
		} else{
			logger.info(" no hay datos ");
			response.setSuccess(false);
			response.setResult(status);
			response.setMensaje("elemento no existe en la base de datos");
		}
		session.close();
	} catch (Exception e) {
	}
	finally{
		if (session!=null) {
			session.close();
		}
	}
	return response;
}


}
