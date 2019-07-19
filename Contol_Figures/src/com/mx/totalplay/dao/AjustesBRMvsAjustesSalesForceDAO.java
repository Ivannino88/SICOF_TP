package com.mx.totalplay.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.AjustesBRMvAjustesSalesForceVO;
import com.mx.totalplay.vo.DetalleBRMvSalesForceVO;
import com.mx.totalplay.vo.DetalleFfmNoBrmVO;
import com.mx.totalplay.vo.DetalleProductosBrmVO;
import com.mx.totalplay.vo.PaquetesServiciosActivadosBrmPMVO;
import com.mx.totalplay.vo.ServiceResponse;

public class AjustesBRMvsAjustesSalesForceDAO {

	private static final Logger logger = Logger.getLogger(AjustesBRMvsAjustesSalesForceDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	
	public ServiceResponse getAjustesBRMvsAjustesSF(String fecha){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<AjustesBRMvAjustesSalesForceVO> result = new ArrayList<AjustesBRMvAjustesSalesForceVO>();
			result = session.selectList("com.mx.totalplay.SDMapper_Selects.selectAjustesBrmvsAjustesSF", fecha);
			
			if(result.size() > 0 && result!=null){
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se obtuvo la informacion correctamente getAjustesBRMvsAjustesSF");
			}else{
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("ERROR getAjustesBRMvsAjustesSF");
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
	
	public ServiceResponse getDetalleBrmvsAjustesSF(String fecha){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleBRMvSalesForceVO> result = new ArrayList<DetalleBRMvSalesForceVO>();
			result = session.selectList("com.mx.totalplay.SDMapper_Selects.selectBrmvsAjustesSFdetalle", fecha);
			//logger.debug(result.size());
			if(result.size() > 0 && result!=null){
				for (DetalleBRMvSalesForceVO d : result) {
					d.getFechaShort();
					d.getFecha_ajusteShort();
				}
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se obtuvo la informacion correctamente");
			}else{
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("ERROR: getDetalleAjustesBRMvsAjustesSF");
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
	
	public ServiceResponse getDetalleBrmvsAjustesSFFiltro(String fecha, String filtro){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleBRMvSalesForceVO> result = new ArrayList<DetalleBRMvSalesForceVO>();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("filtro", filtro);
			result = session.selectList("com.mx.totalplay.SDMapper_Selects.selectBrmvsAjustesSFdetalleFiltro", map);
			//logger.debug(result.size());
			if(result.size() > 0 && result !=null){
				for (DetalleBRMvSalesForceVO d : result) {
					d.getFechaShort();
					d.getFecha_ajusteShort();
				}
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se obtuvo la informacion correctamente");
			}else{
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("ERROR: getDetalleAjustesBRMvsAjustesSF");
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
	
	public ServiceResponse getDetalleAjustesSFvsBrm(String fecha){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleBRMvSalesForceVO> result = new ArrayList<DetalleBRMvSalesForceVO>();
			result = session.selectList("com.mx.totalplay.SDMapper_Selects.selectAjustesSFvsBrmdetalle", fecha);
			//logger.debug(result.size());
			if(result.size() > 0 && result!=null){
				for (DetalleBRMvSalesForceVO d : result) {
					d.getFechaShort();
					d.getFecha_ajusteShort();
				}
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se obtuvo la informacion correctamente");
			}else{
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("ERROR: getDetalleAjustesBRMvsAjustesSF");
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
	
	public ServiceResponse getDetalleAjustesSFvsBrmFiltro(String fecha, String filtro){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleBRMvSalesForceVO> result = new ArrayList<DetalleBRMvSalesForceVO>();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("filtro", filtro);
			result = session.selectList("com.mx.totalplay.SDMapper_Selects.selectAjustesSFvsBrmdetalleFiltro", map);
			//logger.debug(result.size());
			if(result.size() > 0 && result !=null){
				for (DetalleBRMvSalesForceVO d : result) {
					d.getFechaShort();
					d.getFecha_ajusteShort();
				}
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se obtuvo la informacion correctamente");
			}else{
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("ERROR: getDetalleAjustesBRMvsAjustesSF");
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
