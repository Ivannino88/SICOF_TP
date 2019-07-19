package com.mx.totalplay.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.ConciliacionBrmBancosVO;
import com.mx.totalplay.vo.DetalleIPTVAddONSNoBRMVO;
import com.mx.totalplay.vo.ServiceResponse;

public class ConciliacionBrmBancosDAO {
	private static final Logger logger = Logger.getLogger(ConciliacionBrmBancosDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	
	public ServiceResponse getListaCanal( String empresa){
		//logger.debug("***DAO: getConciliacionBrmBancos(Empresa: "+empresa+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<ConciliacionBrmBancosVO> central = new ArrayList<ConciliacionBrmBancosVO>();
			Map map = new HashMap();
			map.put("empresa", empresa);
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getSelectCanal", map);
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete:  [Lita canales]");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [Lita canales]");
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
	
	
	
	public ServiceResponse getConciliacionBrmBancos(ConciliacionBrmBancosVO conciliacionBrmBancos){
		//logger.debug("***DAO: getConciliacionBrmBancos(Fecha: "+conciliacionBrmBancos.getFecha()+")");
		//logger.debug("***DAO: getConciliacionBrmBancos(Empresa: "+conciliacionBrmBancos.getEmpresa()+")");
		//logger.debug("***DAO: getConciliacionBrmBancos(Canal: "+conciliacionBrmBancos.getTipo_conciliacion()+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			//logger.debug("***DAO: ");
			List<ConciliacionBrmBancosVO> ConciliacionBrmBancosList = new ArrayList<ConciliacionBrmBancosVO>();
			ConciliacionBrmBancosList = session.selectList("com.mx.totalplay.SDMapper_Selects.getConciliacionBrmBancos", conciliacionBrmBancos);
			if(ConciliacionBrmBancosList.size() > 0 && ConciliacionBrmBancosList!=null){
				response.setSuccess(true);
				response.setResult(ConciliacionBrmBancosList);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: [Conciliacion BRM vs Bancos ] ");
			}else{
				response.setSuccess(false);
				response.setResult(ConciliacionBrmBancosList);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Conciliacion BRM vs Bancos ] ");
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
	
	
	
	public ServiceResponse getConciliacionBrmBancos(String fecha, String empresa, String tipo_conciliacion){
		//logger.debug("***DAO: getConciliacionBrmBancos(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<ConciliacionBrmBancosVO> central = new ArrayList<ConciliacionBrmBancosVO>();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("empresa", empresa);
			map.put("tipo_conciliacion", tipo_conciliacion);
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getConciliacionBrmBancos", map);
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [Conciliacion BRM vs Bancos]");
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
	
	public ServiceResponse detalleConciliacionBrmBancos(String fecha,String empresa, String tipo_conciliacion){
		//logger.debug("***DAO: detalleConciliacionBrmBancos(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleIPTVAddONSNoBRMVO> central = new ArrayList<DetalleIPTVAddONSNoBRMVO>();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("empresa", empresa);
			map.put("tipo_conciliacion", tipo_conciliacion);
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.detalleConciliacionBrmBancos", map);
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [detalleConciliacionBrmBancos]");
			}
			//logger.debug("tamanio: "+ central.size());
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
	
	
}
