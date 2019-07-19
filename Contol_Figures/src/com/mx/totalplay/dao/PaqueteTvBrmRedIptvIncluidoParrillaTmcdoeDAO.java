package com.mx.totalplay.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.ConciliacionTmIptvBrmVO;
import com.mx.totalplay.vo.DetalleFfmNoBrmVO;
import com.mx.totalplay.vo.DetalleTmBrmNoIptvVO;
import com.mx.totalplay.vo.DetalleTmIptvNoBrmVO;
import com.mx.totalplay.vo.ParrillasvsTMCodeVO;
import com.mx.totalplay.vo.ServiceResponse;

public class PaqueteTvBrmRedIptvIncluidoParrillaTmcdoeDAO {

	private static final Logger logger = Logger.getLogger(PaqueteTvBrmRedIptvIncluidoParrillaTmcdoeDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	
	public ServiceResponse getConciliacionTmIptvBrmParrillaTmcode(String fecha){
		//logger.debug("***DAO: getConciliacionTmIptvBrm(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<ConciliacionTmIptvBrmVO> central = new ArrayList<ConciliacionTmIptvBrmVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.selectConciliacionTmIptvBrm", fecha);
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete [Paquete TV con BRM vs RED IPTV - Incluido (PARRILLAS-TMCODE)]");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [Paquete TV con BRM vs RED IPTV - Incluido (PARRILLAS-TMCODE)]");
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
	
	//Detalle en DetalleTmIptvNoBrmVO
	public ServiceResponse getDetalleTmIptvNoBrm(String fecha){
		//logger.debug("***DAO: getDetalleTmIptvNoBrm(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleTmIptvNoBrmVO> central = new ArrayList<DetalleTmIptvNoBrmVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.selectDetalleTmIptvNoBrm", fecha);
			//logger.info("central.size: " + central.size());
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete{DetalleTmIptvNoBrmVO}");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [DetalleProductosBrmVO]");
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
	//Detalle del reporte en excel DETALLE_TM_BRM_NO_IPTV
	public ServiceResponse getDetalleTmBrmNoIptv(String fecha){
		//logger.debug("***DAO: getDetalleTmBrmNoIptv(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleTmBrmNoIptvVO> central = new ArrayList<DetalleTmBrmNoIptvVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.selectDetalleTmBrmNoIptv", fecha);
						
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleTmBrmNoIptv]");
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

	//************************** CARGAR LA TABLA SECCION NUEVA
		public ServiceResponse getParrillasvsTMCode(){
			ServiceResponse response = new ServiceResponse();
			SqlSession session = null;
			try {
				sqlSessionFactory = conexion.conexionMybatis();
				session = sqlSessionFactory.openSession();
				List<ParrillasvsTMCodeVO> lista = new ArrayList<ParrillasvsTMCodeVO>();
				
				lista = session.selectList("com.mx.totalplay.SDMapper_Selects.selectParrillasvsTMCode");
				if(lista.size() > 0 && lista!=null){
					response.setSuccess(true);
					response.setResult(lista);
					response.setMensaje("Se obtuvo la informacion correctamnete{getParrillasvsTMCode}");
				}else{
					response.setSuccess(false);
					response.setResult(lista);
					response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getParrillasvsTMCode]");
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
	
	//************************** CARGAR LA TABLA SECCION NUEVA
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public ServiceResponse parrillasvsTMCodeInsert(String paquete_brm, String paquete_iptv){
				ServiceResponse response = new ServiceResponse();
				SqlSession session = null;
					try {
						sqlSessionFactory = conexion.conexionMybatis();
						session = sqlSessionFactory.openSession();
						
						Map map = new HashMap();
						map.put("paquete_brm", paquete_brm);
						map.put("paquete_iptv", paquete_iptv);
												
						int result=session.insert("com.mx.totalplay.SDMapper_Inserts.insertParrillasvsTMCode", map);
						
						if(result > 0){
							response.setSuccess(true);
							response.setResult(result);
							response.setMensaje("Se agrego registro");
						}else{
							response.setSuccess(false);
							response.setResult(result);
							response.setMensaje("No se pudo realizar la operación");
						}
					} catch (Exception e) {
					//	logger.error(e.getMessage());
					}finally{
						if(session != null){
							session.commit();
							session.close();
						}
					}
					return response;
				}
}
