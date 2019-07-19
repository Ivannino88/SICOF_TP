package com.mx.totalplay.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.DetalleBrmNoFfmVO;
import com.mx.totalplay.vo.DetalleBrmNoSapVO;
import com.mx.totalplay.vo.DetalleFfmNoBrmVO;
import com.mx.totalplay.vo.InstalacionesNuevasCuentasActivadasFfmBrmVO;
import com.mx.totalplay.vo.ServiceResponse;

public class InstalacionesNuevasCuentasActivadasFfmBrmDAO {

	private static final Logger logger = Logger.getLogger(InstalacionesNuevasCuentasActivadasFfmBrmDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	
	public ServiceResponse getInstalacionesNuevasCuentasActivadasFfmBrm(String fecha){
		//logger.info("***DAO: getInstalacionesNuevasCuentasActivadasFfmBrm(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<InstalacionesNuevasCuentasActivadasFfmBrmVO> central = new ArrayList<InstalacionesNuevasCuentasActivadasFfmBrmVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getInstalacionesNuevasCuentasActivadasFfmBrm", fecha);
			
			if(central.size() > 0 && central!=null){
//				logger.info("entrando: " + central.size());
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [Instalaciones Nuevas vs. Cuentas Activadas FFM- BRM]");
			}
			session.close();
//			logger.info("response.isSuccess(): " + response.isSuccess());
//			logger.info("response.getResult(): " + response.getResult());
//			logger.info("response.getMensaje(): " + response.getMensaje());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
	
	//Detalle en DetalleBrmNoFfmVO
	public ServiceResponse getDetalleBrmNoFfm(String fecha){
//		logger.info("***DAO: getDetalleBrmNoFfm(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleBrmNoFfmVO> central = new ArrayList<DetalleBrmNoFfmVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleBrmNoFfm", fecha);
//			logger.info("central.size: "+central.size());
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [DetalleBrmNoFfmVO]");
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
	//Detalle del reporte en excel DETALLE_FFM_NO_BRM
	public ServiceResponse getDetalleFfmNoBrm(String fecha){
//		logger.info("***DAO: getDetalleFfmNoBrm(Fecha: "+fecha+")");
		//System.out.println("getDetalleFfmNoBrm(Fecha:" +fecha);
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleFfmNoBrmVO> central = new ArrayList<DetalleFfmNoBrmVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleFfmNoBrm", fecha);
			//System.out.println("manda fecha "+fecha);
//			logger.info("central.size(): " + central.size());
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleFfmNoBrm]");
			}
			session.close();
//			logger.info("response.isSuccess(): "+response.isSuccess());
//			logger.info("response.getMensaje(): "+response.getMensaje());
//			logger.info("response.getResult(): "+response.getResult());
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
			ServiceResponse response = new ServiceResponse();
			SqlSession session=null;
			try {
				sqlSessionFactory=conexion.conexionMybatis();
				session=sqlSessionFactory.openSession();
				List<InstalacionesNuevasCuentasActivadasFfmBrmVO> reporte = new ArrayList<InstalacionesNuevasCuentasActivadasFfmBrmVO>();
				Map map= new HashMap();
				map.put("semana", semana);
				map.put("anio", anio);
				reporte =session.selectList("com.mx.totalplay.SDMapper_Selects.getSemanaActivadasFfmBrm",map);
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
				ServiceResponse response = new ServiceResponse();
				SqlSession session=null;
				try {
					sqlSessionFactory=conexion.conexionMybatis();
					session=sqlSessionFactory.openSession();
					List<InstalacionesNuevasCuentasActivadasFfmBrmVO> reporte = new ArrayList<InstalacionesNuevasCuentasActivadasFfmBrmVO>();
					Map map= new HashMap();
					map.put("mes", mes);
					map.put("anio", anio);
					reporte =session.selectList("com.mx.totalplay.SDMapper_Selects.getMesActivadasFfmBrm",map);
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
