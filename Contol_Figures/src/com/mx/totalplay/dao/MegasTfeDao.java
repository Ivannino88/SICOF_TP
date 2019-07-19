package com.mx.totalplay.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.DetalleNoBrmIptv;
import com.mx.totalplay.vo.MegasTfeDetallesVO;
import com.mx.totalplay.vo.MegasTfeVO;
import com.mx.totalplay.vo.ServiceResponse;

public class MegasTfeDao {

	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;

	// detalle de la consulta principal
	public ServiceResponse getDetalleMegasTfe(String fecha){
//		System.out.println("MegasTfeDao.getDetalleMegasTfe()");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<MegasTfeVO> consulta = new ArrayList<MegasTfeVO>();
			consulta = session.selectList("com.mx.totalplay.SDMapper_Selects.getConsultaMegasTfe", fecha);
//			for (MegasTfeVO i: consulta) {
//				System.out.println(i.getTipo_conciliacion()+i.getId());
//			}

			if(consulta.size() > 0 && consulta!=null){
				response.setSuccess(true);
				response.setResult(consulta);
				response.setMensaje("Se obtuvo la informacion correctamnete{MegasTfeVO}");
			}else{
				response.setSuccess(false);
				response.setResult(consulta);
				response.setMensaje("Error al obtener informacion ó no hay informacion en : [MegasTfeVO]");
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
	
	
	// CONSULTA DE TFE SOB
		public ServiceResponse getDetalleMegasTfeSoB(String fecha, String conciliacion){
//			System.out.println("MegasTfeDao.getDetalleMegasTfe()");
			ServiceResponse response = new ServiceResponse();
			SqlSession session = null;
			
			try {
				sqlSessionFactory = conexion.conexionMybatis();
				session = sqlSessionFactory.openSession();
				List<MegasTfeVO> consulta = new ArrayList<MegasTfeVO>();
				Map map = new HashMap();
				map.put("fecha", fecha);
				map.put("conciliacion", conciliacion);
				
				consulta = session.selectList("com.mx.totalplay.SDMapper_Selects.getConsultaMegasTfeSoB", map);
				if(consulta.size() > 0 && consulta!=null){
					response.setSuccess(true);
					response.setResult(consulta);
					response.setMensaje("Se obtuvo la informacion correctamnete de MEGAS TFE SoB ");
				}else{
					response.setSuccess(false);
					response.setResult(consulta);
					response.setMensaje("Error al obtener informacion ó no hay informacion en  MEGAS TFE SoB ");
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
		
		
		// DETALLE megasTfe
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public ServiceResponse getDetalleMegasTfModal(String id){
			//logger.debug("***DAO: getDetalleNoBrmIptv(Fecha: "+fecha+")");
			ServiceResponse response = new ServiceResponse();
			SqlSession session = null;
			
			try {
				sqlSessionFactory = conexion.conexionMybatis();
				session = sqlSessionFactory.openSession();
				
				List<MegasTfeDetallesVO> central = new ArrayList<MegasTfeDetallesVO>();
				central = session.selectList("com.mx.totalplay.SDMapper_Selects.getConsultaMegasTfeDetallesSoB", id);
				if(central.size() > 0 && central!=null){
					response.setSuccess(true);
					response.setResult(central);
					response.setMensaje("Se obtuvo la informacion correctamente de DETALLE_MEGAS_TFE");
				}else{
					response.setSuccess(false);
					response.setResult(central);
					response.setMensaje("NO se obtuvo la informacion correctamente del reporte de DETALLE_MEGAS_TFE");
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
