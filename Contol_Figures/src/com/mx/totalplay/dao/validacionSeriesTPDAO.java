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

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.ServiceResponse;
import com.mx.totalplay.vo.validacionSeriesTPVO;

public class validacionSeriesTPDAO {
	private static final Logger logger = Logger.getLogger(validacionSeriesTPDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ServiceResponse getvalidacionSeriesTP_validar(List<validacionSeriesTPVO> listas) {
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		List<validacionSeriesTPVO> result =new ArrayList<validacionSeriesTPVO>();
		List<validacionSeriesTPVO> resultfinal =new ArrayList<validacionSeriesTPVO>();
		
		try {
			sqlSessionFactory = conexion.conexionMybatis2();
			session = sqlSessionFactory.openSession();
			
			for(int i=0;i<listas.size();i++){
			Map map = new HashMap();
			map.put("ACCOUNT_T_ACCOUNT_NO", listas.get(i).getACCOUNT_T_ACCOUNT_NO());
			map.put("SERVICE_T_LOGIN", listas.get(i).getSERVICE_T_LOGIN());
						
			result = session.selectList("com.mx.totalplay.SDMapper_Selects.selectValidacionSeriesTP",map);
			if(result.size()==0){
				listas.get(i).setSTATUS_BRM("0");
				resultfinal.add(listas.get(i));
			}
			else{
				resultfinal.addAll(result);
			}
			
			}
			if(resultfinal.size()>0 && resultfinal!=null){
				session.commit();
				response.setSuccess(true);
				response.setResult(resultfinal);
				response.setMensaje("Se detectaron "+resultfinal.size()+" movimientos");
			}else{
				session.rollback();
				response.setSuccess(false);
				response.setResult(resultfinal);
				response.setMensaje("Ocurrio un problema, favor de verificar el documento");
				
			}
			} catch (Exception e) {
				response.setSuccess(false);
				response.setResult(resultfinal);
				response.setMensaje("Contenido con formato inválido");
				logger.error(e.getMessage());
				
		}finally{
			if(session != null)
				session.close();
		}
		return response;
		
	}
	
	
// **********************************************************************************
// ****************** METODOS PARA LEER EXCEL Y DEVOLVER CONTENIDO *******************

	public List<validacionSeriesTPVO> getvalidacionSeriesTP(File file) {
		ServiceResponse response = new ServiceResponse();
		List<validacionSeriesTPVO> excelLibro = new ArrayList<validacionSeriesTPVO>();
		List<validacionSeriesTPVO> excelLibrofinal = new ArrayList<validacionSeriesTPVO>();
		try {
			excelLibro = leerExcel(file);

			for (int i = 1; i < excelLibro.size(); i++) {
				excelLibrofinal.add(excelLibro.get(i));
			}
			if (excelLibro.size() > 0
					&& excelLibro.get(0).getACCOUNT_T_ACCOUNT_NO().equalsIgnoreCase("CUENTA")) {
				response.setSuccess(true);
				response.setResult(excelLibrofinal);
				response.setMensaje("Se obtuvo la informacion correctamente");
			} else {
				response.setSuccess(false);
				response.setResult(excelLibrofinal);
				response.setMensaje("El archivo especificado no es el correcto");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setMensaje("El archivo especificado no es el correcto");
			response.setSuccess(false);
		}
		return excelLibrofinal;
	}
	

	public ArrayList<validacionSeriesTPVO> leerExcel(File file) throws IOException {
	
	
		ArrayList<validacionSeriesTPVO> listBooks = new ArrayList<validacionSeriesTPVO>();
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
			validacionSeriesTPVO aBook = new validacionSeriesTPVO();
			Boolean vacio = false;

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {
				case 0:
					if (getCellValue(nextCell) != null)
						aBook.setACCOUNT_T_ACCOUNT_NO(getCellValueStr(nextCell) + "");
					else
						vacio = true;
					break;

				case 1:
					if (getCellValue(nextCell) != null)
						aBook.setSERVICE_T_LOGIN(getCellValue(nextCell) + "");
					else
						vacio = true;
					break;
				}
			}
			if (vacio == false)
				listBooks.add(aBook);
		}
		if(inputStream!=null)
		inputStream.close();
		}
		 catch (IOException e) {
			 e.printStackTrace();
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