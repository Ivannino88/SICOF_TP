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
import com.mx.totalplay.vo.BeanGraficaVo;
import com.mx.totalplay.vo.DetalleBrmNoSapVO;
import com.mx.totalplay.vo.DetalleSapNoBrmVO;
import com.mx.totalplay.vo.InstVsSalidasAlmacenSAPVO;
import com.mx.totalplay.vo.ServiceResponse;

public class InstVsSalidasAlmacenSAPDAO {

	private static final Logger logger = Logger.getLogger(InstVsSalidasAlmacenSAPDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	
	public ServiceResponse getIinstVsSalidasAlmacenSAP(String fecha){
		//logger.debug("***DAO: getIinstVsSalidasAlmacenSAP(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<InstVsSalidasAlmacenSAPVO> central = new ArrayList<InstVsSalidasAlmacenSAPVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getInstVsSalidasAlmacenSAP", fecha);
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete [Instalaciones vs. Salidas de Almacen SAP - BRM]");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [Instalaciones vs. Salidas de Almacen SAP - BRM]");
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
	
	// --- json#1 --- Detalle en getDetalleSapNoBrm
	public ServiceResponse getDetalleSapNoBrm(String fecha){
		//logger.debug("***DAO: getDetalleBrmNoFfm(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleSapNoBrmVO> central = new ArrayList<DetalleSapNoBrmVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleSapNoBrm", fecha);
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [DetalleSapNoBrmVO]");
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
	// ---json#2--- getDetalleBrmNoSap
	public ServiceResponse getDetalleBrmNoSap(String fecha){
		//logger.debug("***DAO: getDetalleBrmNoSap(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleBrmNoSapVO> central = new ArrayList<DetalleBrmNoSapVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleBrmNoSap", fecha);
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete {getDetalleBrmNoSap}");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleBrmNoSap]");
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
//		System.out.println("InstVsSalidasAlmacenSAPDAO.getDatosGrafica()");
		ServiceResponse response = new ServiceResponse();
		SqlSession session=null;
		try {
			sqlSessionFactory=conexion.conexionMybatis();
			session=sqlSessionFactory.openSession();
			List<DetalleBrmNoSapVO> reporte = new ArrayList<DetalleBrmNoSapVO>();
			Map map= new HashMap();
			map.put("semana", semana);
			map.put("anio", anio);
			reporte =session.selectList("com.mx.totalplay.SDMapper_Selects.getInstVsSalidasAlmacenSAPSemana",map);
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
//			System.out.println("InstVsSalidasAlmacenSAPDAO.getDatosGrafica()");
			ServiceResponse response = new ServiceResponse();
			SqlSession session=null;
			try {
				sqlSessionFactory=conexion.conexionMybatis();
				session=sqlSessionFactory.openSession();
				List<DetalleBrmNoSapVO> reporte = new ArrayList<DetalleBrmNoSapVO>();
				Map map= new HashMap();
				map.put("mes", mes);
				map.put("anio", anio);
				reporte =session.selectList("com.mx.totalplay.SDMapper_Selects.getInstVsSalidasAlmacenSAPMes",map);
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
