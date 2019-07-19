package com.mx.totalplay.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.CtasCiclovsCtasBRMVO;
import com.mx.totalplay.vo.DetalleCicloNoFacturadoVO;
import com.mx.totalplay.vo.DetalleFacturadoNoCicloVO;
import com.mx.totalplay.vo.ServiceResponse;

public class CtasCiclovsCtasBRMDAO {
	private static final Logger logger = Logger.getLogger(CtasCiclovsCtasBRMDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	public ServiceResponse getCtasCiclovsCtasBRM(CtasCiclovsCtasBRMVO ctsCiclovsCtasBRM){
		//logger.debug("***DAO: getCtasCiclovsCtasBRM(Fecha: "+ctsCiclovsCtasBRM.getFecha()+")");
		//logger.debug("***DAO: getCtasCiclovsCtasBRM(tipo_cociliacion: "+ctsCiclovsCtasBRM.getTipo_conciliacion()+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<CtasCiclovsCtasBRMVO> ctasActBRMList = new ArrayList<CtasCiclovsCtasBRMVO>();
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.CtasCiclovsCtasBRM", ctsCiclovsCtasBRM);
			if(ctasActBRMList.size() > 0 && ctasActBRMList!=null){
				response.setSuccess(true);
				response.setResult(ctasActBRMList);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: [Cuentas por Ciclo vs. Cuentas Facturadas BRM- BRM ");
			}else{
				response.setSuccess(false);
				response.setResult(ctasActBRMList);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Cuentas por Ciclo vs. Cuentas Facturadas BRM- BRM ");
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
	
	
	
	public ServiceResponse getConciliacionIptvBrm(String fecha){
		//logger.debug("***DAO: getConciliacionIptvBrm(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<CtasCiclovsCtasBRMVO> central = new ArrayList<CtasCiclovsCtasBRMVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getPaqTvBrmRedIPTVIncluido", fecha);
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [Almacen Central vs Entradas Sub almacenes]");
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
	
	public ServiceResponse getDetalleFacturadoNoCiclo(String fecha){
		//logger.debug("***DAO: getDetalleFacturadoNoCiclo(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			List<DetalleFacturadoNoCicloVO> central = new ArrayList<DetalleFacturadoNoCicloVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleFacturadoNoCiclo", fecha);
			//logger.debug("tamanio: "+ central.size());
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleFacturadoNoCiclo]");
			}
			System.out.println("tamanio: "+ central.get(0).toString());
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
	public ServiceResponse getDetalleFacturadoNoCicloFiltro(String fecha, String filtro){
		//logger.debug("***DAO: getDetalleFacturadoNoCiclo(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleCicloNoFacturadoVO> central = new ArrayList<DetalleCicloNoFacturadoVO>();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("filtro", filtro);
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleFacturadoNoCicloFiltro", map);
			//logger.debug("tamanio: "+ central.size());
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleFacturadoNoCiclo]");
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
	
	public ServiceResponse getDetalleCicloNoFacturado(String fecha){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleCicloNoFacturadoVO> central = new ArrayList<DetalleCicloNoFacturadoVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleCicloNoFacturado", fecha);
			
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleCicloNoFacturado]");
			}
			//logger.debug("Tamnio: " +central.size());
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
	public ServiceResponse getDetalleCicloNoFacturadoFiltro(String fecha, String filtro){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleCicloNoFacturadoVO> central = new ArrayList<DetalleCicloNoFacturadoVO>();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("filtro", filtro);
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleCicloNoFacturadoFiltro", map);
			
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleCicloNoFacturado]");
			}
			//logger.debug("Tamnio: " +central.size());
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
