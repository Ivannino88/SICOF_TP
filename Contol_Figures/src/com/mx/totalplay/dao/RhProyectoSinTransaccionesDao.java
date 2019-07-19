package com.mx.totalplay.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.DetalleRhProyectoSinTransaccionesVO;
import com.mx.totalplay.vo.RhProyectoSinTransaccionesModalVO;
import com.mx.totalplay.vo.RhProyectoSinTransaccionesVO;
import com.mx.totalplay.vo.ServiceResponse;

public class RhProyectoSinTransaccionesDao {
	private static final Logger logger = Logger.getLogger(RhProyectoSinTransaccionesDao.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getRhProyectoSinTransacciones(String semana, String anio){
		ServiceResponse response = new ServiceResponse();
		List<RhProyectoSinTransaccionesVO> reporte = new ArrayList<RhProyectoSinTransaccionesVO>();
		
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("semana", semana);
			map.put("anio", anio);
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectRhProyectoSinTransacciones",map);
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte RhProyectoSinTransaccionesDAO");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
			//System.out.println("entro al catch");
			//e.printStackTrace();
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				//logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()
					//	+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
		
		return response;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getDetalleRhProyectoSinTransaccionesV(String semana, String anio){
		ServiceResponse response = new ServiceResponse();
		List<DetalleRhProyectoSinTransaccionesVO> reporte = new ArrayList<DetalleRhProyectoSinTransaccionesVO>();
		
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("semana", semana);
			map.put("anio", anio);
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.detalleSelectRhProyectoSinTransaccionesV",map);
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte DetalleRhProyectoSinTransaccionesDAO");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
			//System.out.println("entro al catch");
			//e.printStackTrace();
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				//logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()
					//	+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
		
		return response;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getDetalleRhProyectoSinTransaccionesA(String semana, String anio){
		ServiceResponse response = new ServiceResponse();
		List<DetalleRhProyectoSinTransaccionesVO> reporte = new ArrayList<DetalleRhProyectoSinTransaccionesVO>();
		
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("semana", semana);
			map.put("anio", anio);
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.detalleSelectRhProyectoSinTransaccionesA",map);
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte DetalleRhProyectoSinTransaccionesDAO");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
			//System.out.println("entro al catch");
			//e.printStackTrace();
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				//logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()
					//	+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
		
		return response;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getDetalleRhProyectoSinTransaccionesR(String semana, String anio){
		ServiceResponse response = new ServiceResponse();
		List<DetalleRhProyectoSinTransaccionesVO> reporte = new ArrayList<DetalleRhProyectoSinTransaccionesVO>();
		
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("semana", semana);
			map.put("anio", anio);
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.detalleSelectRhProyectoSinTransaccionesR",map);
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte DetalleRhProyectoSinTransaccionesDAO");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
			//System.out.println("entro al catch");
			//e.printStackTrace();
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				//logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()
					//	+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
		
		return response;
	}
}
	


