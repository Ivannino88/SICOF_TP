package com.mx.totalplay.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.AddONSCanalesBRMvsIPTVAdicionalesVO;
import com.mx.totalplay.vo.DetalleBRMAddONSNoIPTVVO;
import com.mx.totalplay.vo.DetalleIPTVAddONSNoBRMVO;
import com.mx.totalplay.vo.ServiceResponse;

public class AddONSCanalesBRMvsIPTVAdicionalesDAO {
	private static final Logger logger = Logger.getLogger(AddONSCanalesBRMvsIPTVAdicionalesDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	public ServiceResponse getCanalesBRMvsIPTVAdicionales(AddONSCanalesBRMvsIPTVAdicionalesVO canalesBRMvsIPTVAdicionales){
		//logger.debug("***DAO: getCanalesBRMvsIPTVAdicionales(Fecha: "+canalesBRMvsIPTVAdicionales.getFecha()+")");
		//logger.debug("***DAO: getCanalesBRMvsIPTVAdicionales(tipo_cociliacion: "+canalesBRMvsIPTVAdicionales.getT_conciliados()+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			//logger.debug("***DAO: ");
			List<AddONSCanalesBRMvsIPTVAdicionalesVO> ctasActBRMList = new ArrayList<AddONSCanalesBRMvsIPTVAdicionalesVO>();
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.getCanalesBRMvsIPTVAdicionales", canalesBRMvsIPTVAdicionales);
			if(ctasActBRMList.size() > 0 && ctasActBRMList!=null){
				response.setSuccess(true);
				response.setResult(ctasActBRMList);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: [ADD ONS Canales BRM vs IPTV - Adicionales ] ");
			}else{
				response.setSuccess(false);
				response.setResult(ctasActBRMList);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [ADD ONS Canales BRM vs IPTV - Adicionales ] ");
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
	
	
	
	public ServiceResponse getCanalesBRMvsIPTVAdicionales(String fecha){
//		logger.debug("***DAO: getCanalesBRMvsIPTVAdicionales(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<AddONSCanalesBRMvsIPTVAdicionalesVO> central = new ArrayList<AddONSCanalesBRMvsIPTVAdicionalesVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getCanalesBRMvsIPTVAdicionales", fecha);
			
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [ADD ONS Canales BRM vs IPTV - Adicionales]");
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
	
	public ServiceResponse getDetalleIPTVAddONSNoBRM(String fecha){
//		System.out.println("dao-- fecha entrada"+ fecha);
//		logger.debug("***DAO: getDetalleIPTVAddONSNoBRM(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleIPTVAddONSNoBRMVO> central = new ArrayList<DetalleIPTVAddONSNoBRMVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleIPTVAddONSNoBRM", fecha);
//			logger.info("central.size(): "+ central.size());
			if(central.size() > 0 && central !=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleIPTVAddONSNoBRM]");
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
	
	public ServiceResponse getDetalleBRMAddONSNoIPTV(String fecha){
//	logger.debug("***DAO: getDetalleBRMAddONSNoIPTV(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleBRMAddONSNoIPTVVO> central = new ArrayList<DetalleBRMAddONSNoIPTVVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleBRMAddONSNoIPTV", fecha);
			
//			logger.debug("tamaño"+ central.get(1).getDescr());
			if(central.size() > 0 && central != null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleBRMAddONSNoIPTV]");
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
