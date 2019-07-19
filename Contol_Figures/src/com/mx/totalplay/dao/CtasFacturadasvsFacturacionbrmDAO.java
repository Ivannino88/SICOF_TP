package com.mx.totalplay.dao;

/**
 *@author RicardoM
 *DAO para Reporte  Cuentas Facturadas vs. Facturacion BRM - INTERFACTURA
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.CtasFacturadasvsFacturacionbrmVO;
import com.mx.totalplay.vo.DetalleCtasFacturadasvsFacturacionMontosVO;
import com.mx.totalplay.vo.DetalleCtasFacturadasvsFacturacionbrmVO;
import com.mx.totalplay.vo.DetalleInterfactura;
import com.mx.totalplay.vo.ResumenInterfactura;
import com.mx.totalplay.vo.ServiceResponse;

public class CtasFacturadasvsFacturacionbrmDAO {
	private static final Logger logger = Logger.getLogger(CtasFacturadasvsFacturacionbrmDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ServiceResponse reporteCtasFactvsFactBRMIF(String fecha, String t_conciliacion){
		//logger.debug("***DAO: reporteCtasFactvsFactBRMIF(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("t_conciliacion", t_conciliacion);
			map.put("fecha", fecha);

			
			
			List<CtasFacturadasvsFacturacionbrmVO> reporte = new ArrayList<CtasFacturadasvsFacturacionbrmVO>();
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.reporteCtasFactvsFactBRMIF", map);
			if(reporte.size() > 0 && reporte!=null){
				response.setSuccess(true);
				response.setResult(reporte);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(reporte);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: reporteCtasFactvsFactBRMIF");
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse obtieneDetalleCtasFacturadasvsFacturacionbrm(String cptp, String cpenl, String cptfe){
		//logger.debug("***DAO: obtieneDetalleCtasFacturadasvsFacturacionbrm(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			Map map = new HashMap();
			map.put("id_tp", cptp);
			map.put("id_enl", cpenl);
			map.put("id_tfe", cptfe);
			
			List<DetalleCtasFacturadasvsFacturacionbrmVO> reporte = new ArrayList<DetalleCtasFacturadasvsFacturacionbrmVO>();
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectDetalleCtasFactvsFactBRMIF", map);
//			logger.info("reporte.size: "+reporte.size());
			if(reporte.size() > 0 && reporte!=null){
				response.setSuccess(true);
				response.setResult(reporte);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(reporte);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: obtieneDetalleCtasFacturadasvsFacturacionbrm");
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getDetailInterfactura(String fecha){
		logger.debug("***DAO: obtieneDetalleCtasFacturadasvsFacturacionbrm(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			session.getConfiguration().setJdbcTypeForNull(null);
			Map map = new HashMap();
			map.put("fecha", fecha);

			
			List<DetalleInterfactura> reporte = new ArrayList<DetalleInterfactura>();
			System.out.println("fecha-----> "+fecha);
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetailInterfactura", map);

			if(reporte.size() > 0 && reporte!=null){
				response.setSuccess(true);
				response.setResult(reporte);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(reporte);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: obtieneDetalleCtasFacturadasvsFacturacionbrm");
			}
			session.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getResumeInterfactura(String fecha){
		
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			session.getConfiguration().setJdbcTypeForNull(null);
			Map map = new HashMap();
			map.put("fecha", fecha);

			
			List<ResumenInterfactura> reporte = new ArrayList<ResumenInterfactura>();
			System.out.println("fecha-----> "+fecha);
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.getResumeInterfactura", map);

			if(reporte.size() > 0 && reporte!=null){
				response.setSuccess(true);
				response.setResult(reporte);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(reporte);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: getResumeInterfactura");
			}
			session.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse obtieneDetalleCtasFacturadasvsFacturacionbrmFiltro(String cptp, String cpenl, String cptfe, String filtro){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			Map map = new HashMap();
			map.put("id_tp", cptp);
			map.put("id_enl", cpenl);
			map.put("id_tfe", cptfe);
			map.put("filtro", filtro);
			List<DetalleCtasFacturadasvsFacturacionbrmVO> reporte = new ArrayList<DetalleCtasFacturadasvsFacturacionbrmVO>();
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectDetalleCtasFactvsFactBRMIFFiltro", map);
//			logger.info("reporte.size: "+reporte.size());
			if(reporte.size() > 0 && reporte!=null){
				response.setSuccess(true);
				response.setResult(reporte);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(reporte);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: obtieneDetalleCtasFacturadasvsFacturacionbrm");
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
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse obtieneDetalleMontosInterfactura(String cptp, String cpenl, String cptfe){
		//logger.debug("***DAO: obtieneDetalleCtasFacturadasvsFacturacionbrm(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			Map map = new HashMap();
			map.put("id_tp", cptp);
			map.put("id_enl", cpenl);
			map.put("id_tfe", cptfe);
			
			List<DetalleCtasFacturadasvsFacturacionMontosVO> reporte = new ArrayList<DetalleCtasFacturadasvsFacturacionMontosVO>();
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectDetalleCtasFactvsFactMontos", map);
			if(reporte.size() > 0 && reporte!=null){
				response.setSuccess(true);
				response.setResult(reporte);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(reporte);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: obtieneDetalleCtasFacturadasvsFacturacionbrm");
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse obtieneDetalleMontosInterfacturaFiltro(String cptp, String cpenl, String cptfe, String filtro){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			Map map = new HashMap();
			map.put("id_tp", cptp);
			map.put("id_enl", cpenl);
			map.put("id_tfe", cptfe);
			map.put("filtro", filtro);
			
			List<DetalleCtasFacturadasvsFacturacionMontosVO> reporte = new ArrayList<DetalleCtasFacturadasvsFacturacionMontosVO>();
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectDetalleCtasFactvsFactMontosFiltro", map);
			if(reporte.size() > 0 && reporte!=null){
				response.setSuccess(true);
				response.setResult(reporte);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(reporte);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: obtieneDetalleCtasFacturadasvsFacturacionbrm");
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
	
}
