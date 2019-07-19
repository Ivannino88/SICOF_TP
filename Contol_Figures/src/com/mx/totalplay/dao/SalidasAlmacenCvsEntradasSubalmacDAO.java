/**
 * 
 * @author RicardoM
 * DAO PARA EL REPORTE DE SALIDAS ALMACEN CENTRAL VS ENTRADAS SUB ALMACENES
 */
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
import com.mx.totalplay.vo.SalidasAlmacenCvsEntradasSubalmacVO;
import com.mx.totalplay.vo.ServiceResponse;

public class SalidasAlmacenCvsEntradasSubalmacDAO {
	private static final Logger logger = Logger.getLogger(SalidasAlmacenCvsEntradasSubalmacDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getSalidasAlmacenCvsEntradasSubalmac(String fecha,String almacen){
		//logger.debug("***DAO: SalidasAlmacenCvsEntradasSubalmacDAO("+fecha+" "+almacen+")");
		ServiceResponse response = new ServiceResponse();
		List<SalidasAlmacenCvsEntradasSubalmacVO> reporte = new ArrayList<SalidasAlmacenCvsEntradasSubalmacVO>();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("almacen", almacen);
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectSalidasAlmacencvsEntradasSubAlmac",map);
			//logger.info("reporte.size(): " +reporte.size());
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte SalidasAlmacenCvsEntradasSubalmacDAO");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
			e.printStackTrace();
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				//logger.info("### SQL ERROR ###: [" + sqlE.getErrorCode()		+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getDetalleSalidasAlmacenCvsEntradasSubalmac(String fecha,String almacen){
		//logger.debug("***DAO: getDetalleSalidasAlmacenCvsEntradasSubalmac("+fecha+" "+almacen+")");
		ServiceResponse response = new ServiceResponse();
		List<SalidasAlmacenCvsEntradasSubalmacVO> reporte = new ArrayList<SalidasAlmacenCvsEntradasSubalmacVO>();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("almacen", almacen);
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectDetalleSalidasAlmacencvsEntradasSubAlmac",map);
			//logger.debug(reporte.size());
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte getDetalleSalidasAlmacenCvsEntradasSubalmac");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
			//e.printStackTrace();
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				//logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()	+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
}
