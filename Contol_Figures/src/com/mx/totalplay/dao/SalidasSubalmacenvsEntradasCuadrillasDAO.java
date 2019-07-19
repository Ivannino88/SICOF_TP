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
import com.mx.totalplay.vo.SalidasSubalmacenvsEntradasCuadrillasVO;
import com.mx.totalplay.vo.ServiceResponse;

public class SalidasSubalmacenvsEntradasCuadrillasDAO {

	private static final Logger logger= Logger.getLogger(SalidasSubalmacenvsEntradasCuadrillasDAO.class);
	MyBatisConfig conexion= new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory=null;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getSalidasSubalmacenvsEntradasCuadrillas(String fecha)
	{
		//logger.debug("***DAO: SalidasSubalmacenvsEntradasCuadrillasDAO( "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		List<SalidasSubalmacenvsEntradasCuadrillasVO> reporte = new ArrayList<SalidasSubalmacenvsEntradasCuadrillasVO>();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("fecha", fecha);
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.getSalidaSubalmacenvsEntradasCuadrillas",map);
//			logger.info("reporte.size(): " + reporte.size());
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte SalidasSubalmacenvsEntradasCuadrillasDAO");
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
	
	@SuppressWarnings({"rawtypes","unchecked"})
	public ServiceResponse setDetalleSalidasSubalmacenvsEntradasCuadrillas( String fecha)
	{
		//logger.debug("***DAO: getDetalleSalidasSubalmacenvsEntradasCuadrillas( "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		List<SalidasSubalmacenvsEntradasCuadrillasVO> reporte = new ArrayList<SalidasSubalmacenvsEntradasCuadrillasVO>();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("fecha", fecha);
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.getSalidaSubalmacenvsEntradasCuadrillas",map);
			//logger.debug(reporte.size());
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte getDetalleSalidassubalmacenvsEntradasCuadrillas");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
			//e.printStackTrace();
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				//logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
		return response;
		
	}
	
	

}
