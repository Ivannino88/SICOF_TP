package com.mx.totalplay.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.ConciliacionIptvBrmVO;
import com.mx.totalplay.vo.CtasActBRMvsU2000VO;
import com.mx.totalplay.vo.DetalleIptvNoBrm;
import com.mx.totalplay.vo.DetalleNoBrmIptv;
import com.mx.totalplay.vo.ServiceResponse;

public class ConciliacionIptvBrmDAO {

	private static final Logger logger = Logger.getLogger(ConciliacionIptvBrmDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
//************************************************************************  DAO REPORTE PRINCIPAL  
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ServiceResponse getConciliacionIptvBrm(String fecha, String conciliacion){
		System.out.println("ConciliacionIptvBrmDAO.getConciliacionIptvBrm()");
		logger.debug("***DAO: getDetalleNoBrmIptv(Fecha: "+fecha+") ");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("Tipo_Conciliacion", conciliacion);
			
			List<ConciliacionIptvBrmVO> central = new ArrayList<ConciliacionIptvBrmVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getPaqTvBrmRedIPTVIncluido", map);
			logger.debug("Tamaño reporte Central: "+ central.size());
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamente");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: []");
			}
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		logger.info(":: FIN ConciliacionIptvBrmDAO.getConciliacionIptvBrm()");
		return response;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ServiceResponse getDetalleNoBrmIptv(String fecha, String id_detalle){
		System.out.println("ConciliacionIptvBrmDAO.getDetalleNoBrmIptv()");
		logger.debug("***DAO: getDetalleNoBrmIptv(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("Id", id_detalle);
			
			List<DetalleNoBrmIptv> central = new ArrayList<DetalleNoBrmIptv>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleNoBrmIptv", map);
			logger.info("central.size(): " + central.size());
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamente");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [DetalleNoBrmIptv]");
			}
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		logger.info(":: FIN  ConciliacionIptvBrmDAO.getDetalleNoBrmIptv()");
		return response;
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getDetalleIptvNoBrm(String fecha, String id_detalle){
		System.out.println("ConciliacionIptvBrmDAO.getDetalleIptvNoBrm()");
		logger.debug("***DAO: getDetalleIptvNoBrm(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("Id", id_detalle);
			
			List<DetalleIptvNoBrm> central = new ArrayList<DetalleIptvNoBrm>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleNoIptvBrm", map);
			logger.info("central.size(): " + central.size());
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamente");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [getDetalleNoIptvBrm]");
			}
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		logger.info(":: FIN ConciliacionIptvBrmDAO.getDetalleIptvNoBrm()");
		return response;
	}
	
	
}
