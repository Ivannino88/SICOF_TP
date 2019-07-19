package com.mx.totalplay.dao;

/**
 * 
 * Junio 2017
 * DAO PARA EL REPORTE: 4. Cifra Control Cuentas Activas BRM vs. U2000 – BRM
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.CtasActBRMvsU2000VO;
import com.mx.totalplay.vo.Detalle2000NoBrmVO;
import com.mx.totalplay.vo.DetalleBrmNoSapVO;
import com.mx.totalplay.vo.DetalleBrmNoU2000VO;
import com.mx.totalplay.vo.ServiceResponse;
import com.mx.totalplay.vo.cuentasactivasbrmvsimsVO;
import com.mx.totalplay.vo.cuentasactivasimsvsbrmVO;

public class CtasActBRMvsU2000DAO {
	private static final Logger logger = Logger.getLogger(CtasActBRMvsU2000DAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	public ServiceResponse getCtasActBRMvsU2000(CtasActBRMvsU2000VO ctasActBrmVO){
//		System.out.println("CtasActBRMvsU2000DAO.getCtasActBRMvsU2000()");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<CtasActBRMvsU2000VO> ctasActBRMList = new ArrayList<CtasActBRMvsU2000VO>();
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.ctasActBRMvsU2000", ctasActBrmVO);
			if(ctasActBRMList.size() > 0 && ctasActBRMList!=null){
				response.setSuccess(true);
				response.setResult(ctasActBRMList);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: [Cuentas Activas BRM vs U2000");
			}else{
				response.setSuccess(false);
				response.setResult(ctasActBRMList);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Cuentas Activas BRM vs U2000");
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
	
	
	public ServiceResponse detalleCtasActBRMvsU2000(String fecha){
//		System.out.println("CtasActBRMvsU2000DAO.detalleCtasActBRMvsU2000()");
		//logger.debug("***DAO: getCtasActBRMvsU2000(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleBrmNoU2000VO> ctasActBRMList = new ArrayList<DetalleBrmNoU2000VO>();
			
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.detalleActBRMvsU2000", fecha);
			//logger.info("**ctasActBRMList.size: "+ctasActBRMList.size());
			if(ctasActBRMList.size() > 0 && ctasActBRMList!=null){
				response.setSuccess(true);
				response.setResult(ctasActBRMList);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: [Cuentas Activas BRM vs U2000");
			}else{
				response.setSuccess(false);
				response.setResult(ctasActBRMList);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Cuentas Activas BRM vs U2000");
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
	
	public ServiceResponse detalleCtasActBRMvsU2000Filtro(String fecha, String filtro){
//		System.out.println("CtasActBRMvsU2000DAO.detalleCtasActBRMvsU2000()");
		//logger.debug("***DAO: getCtasActBRMvsU2000(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleBrmNoU2000VO> ctasActBRMList = new ArrayList<DetalleBrmNoU2000VO>();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("filtro", filtro);
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.detalleActBRMvsU2000Filtro", map);
			//logger.info("**ctasActBRMList.size: "+ctasActBRMList.size());
			if(ctasActBRMList.size() > 0 && ctasActBRMList!=null){
				response.setSuccess(true);
				response.setResult(ctasActBRMList);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: [Cuentas Activas BRM vs U2000");
			}else{
				response.setSuccess(false);
				response.setResult(ctasActBRMList);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Cuentas Activas BRM vs U2000");
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

	public ServiceResponse detalleCtasActU2000(String fecha){		
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<Detalle2000NoBrmVO> ctasActBRMList = new ArrayList<Detalle2000NoBrmVO>();
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.detalleAct2000", fecha);
			if(ctasActBRMList.size() > 0 && ctasActBRMList!=null){
				response.setSuccess(true);
				response.setResult(ctasActBRMList);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: [Cuentas Activas BRM vs U2000");
			}else{
				response.setSuccess(false);
				response.setResult(ctasActBRMList);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Cuentas Activas BRM vs U2000");
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
	
	public ServiceResponse detalleCtasActU2000Filtro(String fecha, String filtro){		
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<Detalle2000NoBrmVO> ctasActBRMList = new ArrayList<Detalle2000NoBrmVO>();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("filtro", filtro);
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.detalleAct2000Filtro", map);
			if(ctasActBRMList.size() > 0 && ctasActBRMList!=null){
				response.setSuccess(true);
				response.setResult(ctasActBRMList);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: [Cuentas Activas BRM vs U2000");
			}else{
				response.setSuccess(false);
				response.setResult(ctasActBRMList);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Cuentas Activas BRM vs U2000");
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

	public ServiceResponse detalleCtasActU2000SN(String fecha){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleBrmNoU2000VO> ctasActBRMList = new ArrayList<DetalleBrmNoU2000VO>();
			
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.detalleCUENTASN", fecha);
			if(ctasActBRMList.size() > 0 && ctasActBRMList!=null){
				response.setSuccess(true);
				response.setResult(ctasActBRMList);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: [Cuentas Activas BRM vs U2000");
			}else{
				response.setSuccess(false);
				response.setResult(ctasActBRMList);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Cuentas Activas BRM vs U2000");
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
	
	public ServiceResponse detalleCtasActU2000SNFiltro(String fecha, String filtro){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleBrmNoU2000VO> ctasActBRMList = new ArrayList<DetalleBrmNoU2000VO>();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("filtro", filtro);
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.detalleCUENTASNFiltro", map);
			if(ctasActBRMList.size() > 0 && ctasActBRMList!=null){
				response.setSuccess(true);
				response.setResult(ctasActBRMList);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: [Cuentas Activas BRM vs U2000");
			}else{
				response.setSuccess(false);
				response.setResult(ctasActBRMList);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Cuentas Activas BRM vs U2000");
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


//********************************* BRM VS IMS *******************************
	
	public ServiceResponse getCtasActBRMvsIMS(CtasActBRMvsU2000VO ctasActBrmVO){
		//logger.debug("***DAO: getCtasActBRMvsIMS (Fecha: "+ctasActBrmVO.getFecha()+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<CtasActBRMvsU2000VO> ctasActBRMList = new ArrayList<CtasActBRMvsU2000VO>();
			//logger.debug("Ejecutando cuero ctasActBRMvsISM");
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.ctasActBRMvsIMS", ctasActBrmVO);
			if(ctasActBRMList.size() > 0 && ctasActBRMList!=null){
				response.setSuccess(true);
				response.setResult(ctasActBRMList);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: [Cuentas Activas BRM vs U2000");
			}else{
				response.setSuccess(false);
				response.setResult(ctasActBRMList);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Cuentas Activas BRM vs U2000");
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
	
	public ServiceResponse getDetalleimsnobrmJson(String fecha){
//		System.out.println("###  2");
		//logger.info("***DAO: getDetalleimsnobrmJson(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<cuentasactivasimsvsbrmVO> cuentasactivasbrmvsims = new ArrayList<cuentasactivasimsvsbrmVO>();
			
			cuentasactivasbrmvsims = session.selectList("com.mx.totalplay.SDMapper_Selects.selectDetalleIMSNOBRM", fecha);
			//logger.info("***cuentasactivasIMS: "+cuentasactivasbrmvsims);
			if(cuentasactivasbrmvsims.size() > 0 && cuentasactivasbrmvsims!=null){
				for (cuentasactivasimsvsbrmVO x: cuentasactivasbrmvsims) {
					x.getFechaShort();
				}
				response.setSuccess(true);
				response.setResult(cuentasactivasbrmvsims);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: [Cuentas Activas IMS NO BRM");
			}else{
				response.setSuccess(false);
				response.setResult(cuentasactivasbrmvsims);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Cuentas Activas IMS NO BRM");
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
	
	public List<cuentasactivasimsvsbrmVO> getDetalleimsnobrm(String fecha){
		//logger.debug("***DAO: getDetalleimsnobrm (Fecha: "+fecha+")");
		SqlSession session = null;
		List<cuentasactivasimsvsbrmVO> cuentasactivasbrmvsims = new ArrayList<cuentasactivasimsvsbrmVO>();
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			//logger.debug("ejecutando getDetalleimsnobrm(): ");
			cuentasactivasbrmvsims = session.selectList("com.mx.totalplay.SDMapper_Selects.selectDetalleIMSNOBRM",fecha);
			//logger.debug("cuentasactivasbrmvsims.size(): "+ cuentasactivasbrmvsims.size());
		
			session.close();
		} catch (Exception e) {
			//logger.error(e);
		}finally{
			if(session != null)
				session.close();
		}
		return cuentasactivasbrmvsims;
	}
// --jason #1	
	public ServiceResponse getDetallebrmnoimsJson(String fecha){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<cuentasactivasbrmvsimsVO> cuentasactivasbrmvsims = new ArrayList<cuentasactivasbrmvsimsVO>();
			
			cuentasactivasbrmvsims = session.selectList("com.mx.totalplay.SDMapper_Selects.selectDetalleBRMNOIMS",fecha);
			//logger.info("***cuentasactivasbrmvsims.size(): "+cuentasactivasbrmvsims.size());
			if(cuentasactivasbrmvsims.size() > 0 && cuentasactivasbrmvsims!=null){
				for (cuentasactivasbrmvsimsVO  x: cuentasactivasbrmvsims) {
//					System.out.println("###---"+x.getFecha());
					x.getFechaShort();
					
				}
				
				response.setSuccess(true);
				response.setResult(cuentasactivasbrmvsims);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: [Cuentas Activas BRM NO IMS ");
			}else{
				response.setSuccess(false);
				response.setResult(cuentasactivasbrmvsims);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Cuentas Activas BRM NO IMS");
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
	
	public ServiceResponse getDetallebrmnoimsJsonFiltro(String fecha, String filtro){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<cuentasactivasbrmvsimsVO> cuentasactivasbrmvsims = new ArrayList<cuentasactivasbrmvsimsVO>();
			
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("filtro", filtro);
			cuentasactivasbrmvsims = session.selectList("com.mx.totalplay.SDMapper_Selects.selectDetalleBRMNOIMSFiltro",map);
			//logger.info("***cuentasactivasbrmvsims.size(): "+cuentasactivasbrmvsims.size());
			if(cuentasactivasbrmvsims.size() > 0 && cuentasactivasbrmvsims!=null){
				response.setSuccess(true);
				response.setResult(cuentasactivasbrmvsims);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: [Cuentas Activas BRM NO IMS ");
			}else{
				response.setSuccess(false);
				response.setResult(cuentasactivasbrmvsims);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Cuentas Activas BRM NO IMS");
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
	
	public List<cuentasactivasbrmvsimsVO> getDetallebrmnoims(String fecha){
		//logger.debug("***DAO: getDetallebrmnoims (Fecha: "+fecha+")");
		SqlSession session = null;
		List<cuentasactivasbrmvsimsVO> cuentasactivasbrmvsims = new ArrayList<cuentasactivasbrmvsimsVO>();
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			//logger.debug("Ejecutando cuero ctasActBRMvsISM");
			cuentasactivasbrmvsims = session.selectList("com.mx.totalplay.SDMapper_Selects.selectDetalleBRMNOIMS",fecha);
			//logger.debug("cuentasactivasbrmvsims.size(): "+ cuentasactivasbrmvsims.size());
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return cuentasactivasbrmvsims;
	}
//	°°°°°°°--METODO CONSULTA DETALLE_BRM_NO_U2000_SIN_ONT --°°°°°°°--METODO CONSULTA DETALLE_BRM_NO_U2000_SIN_ONT --....	
	public ServiceResponse detalleCtasActBRMvsU2000sinOnt(String fecha){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleBrmNoU2000VO> ctasActBRMList = new ArrayList<DetalleBrmNoU2000VO>();			
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.detalleActBRMvsU2000SinOnt", fecha);			
			if(ctasActBRMList.size() > 0 && ctasActBRMList!=null){
				response.setSuccess(true);
				response.setResult(ctasActBRMList);
				response.setMensaje("-># Se obtuvo la informacion DETALLE_BRM_NO_U2000_SIN_ONT..");
			}else{
				response.setSuccess(false);
				response.setResult(ctasActBRMList);
				response.setMensaje("-># Inconveniente. al consultar DETALLE_BRM_NO_U2000_SIN_ONT.!!");
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
	
	public ServiceResponse detalleCtasActBRMvsU2000sinOntFiltro(String fecha, String filtro){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleBrmNoU2000VO> ctasActBRMList = new ArrayList<DetalleBrmNoU2000VO>();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("filtro", filtro);
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.detalleActBRMvsU2000SinOntFiltro", map);			
			if(ctasActBRMList.size() > 0 && ctasActBRMList!=null){
				response.setSuccess(true);
				response.setResult(ctasActBRMList);
				response.setMensaje("-># Se obtuvo la informacion DETALLE_BRM_NO_U2000_SIN_ONT..");
			}else{
				response.setSuccess(false);
				response.setResult(ctasActBRMList);
				response.setMensaje("-># Inconveniente. al consultar DETALLE_BRM_NO_U2000_SIN_ONT.!!");
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
	
// ---------------------------------------- DAO GRAFICA LINEAL---------------------------------
		// #######---datos por semana
		public ServiceResponse getDatosGraficaSemana(String semana,String anio){
//			System.out.println("InstVsSalidasAlmacenSAPDAO.getDatosGrafica()");
			System.out.println("CtasActBRMvsU2000DAO.getCtasActBRMvsU2000()--- semana");
			ServiceResponse response = new ServiceResponse();
			SqlSession session=null;
			try {
				sqlSessionFactory=conexion.conexionMybatis();
				session=sqlSessionFactory.openSession();
				List<CtasActBRMvsU2000VO> reporte = new ArrayList<CtasActBRMvsU2000VO>();
				Map map= new HashMap();
				map.put("semana", semana);
				map.put("anio", anio);
				reporte =session.selectList("com.mx.totalplay.SDMapper_Selects.ctasActBRMvsU2000Semana",map);
				if (reporte.size()>0 && reporte!=null) {
					response.setSuccess(true);
					response.setResult(reporte);
					response.setMensaje("consulto datos de grafica ok..");
				}else{
					response.setSuccess(true);
					response.setResult(reporte);
					response.setMensaje("error al consultar");
				}
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(session != null)
					session.close();
			}
			return response;
		}
		// #######---datos por mes
			public ServiceResponse getDatosGraficaMes(String mes,String anio){
//				System.out.println("InstVsSalidasAlmacenSAPDAO.getDatosGrafica()");
				System.out.println("CtasActBRMvsU2000DAO.getCtasActBRMvsU2000()--- mes");
				ServiceResponse response = new ServiceResponse();
				SqlSession session=null;
				try {
					sqlSessionFactory=conexion.conexionMybatis();
					session=sqlSessionFactory.openSession();
					List<CtasActBRMvsU2000VO> reporte = new ArrayList<CtasActBRMvsU2000VO>();
					Map map= new HashMap();
					map.put("mes", mes);
					map.put("anio", anio);
					reporte =session.selectList("com.mx.totalplay.SDMapper_Selects.ctasActBRMvsU2000Mes",map);
					if (reporte.size()>0 && reporte!=null) {
						response.setSuccess(true);
						response.setResult(reporte);
						response.setMensaje("consulto datos de grafica ok..");
					}else{
						response.setSuccess(true);
						response.setResult(reporte);
						response.setMensaje("error al consultar");
					}
					session.close();
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					if(session != null)
						session.close();
				}
				return response;
			}
		// -----------------FIN DAO GRAFICA LINEAL--------------------------

}

