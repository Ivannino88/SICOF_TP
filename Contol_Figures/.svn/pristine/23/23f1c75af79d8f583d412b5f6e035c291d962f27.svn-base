package com.mx.totalplay.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.CCanceladasvsU2000VO;
import com.mx.totalplay.vo.CtasActBRMvsU2000VO;
import com.mx.totalplay.vo.DetalleBrmNoU2000VO;
import com.mx.totalplay.vo.DetalleU2000CanceladasVO;
import com.mx.totalplay.vo.ServiceResponse;

public class CCanceladasvsU2000DAO {

	private static final Logger logger = Logger.getLogger(CCanceladasvsU2000DAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	public List<CCanceladasvsU2000VO> getcCanceladasvsU2000(String fecha){

		//logger.debug("***DAO: getcCanceladasvsU2000(Fecha "+fecha+")");
		List<CCanceladasvsU2000VO> result = new ArrayList<CCanceladasvsU2000VO>();
		SqlSession session = null;
		try{
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			result = session.selectList("com.mx.totalplay.SDMapper_Selects.getcCanceladasvsU2000", fecha);
		//--impresion de preedatos--	
//			for (CCanceladasvsU2000VO x: result) {
//				System.out.println("error_brm--> "+x.getError_brm()+
//									"error_u2000--> "+x.getError_u2000()+
//									"no_brm------->"+x.getNo_brm()+
//									"no_u2000----->"+x.getNo_u2000());
//			}
			session.close();
			
			
		}catch(Exception e){
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return result;
	}
	
	public ServiceResponse detalleCanceladasBRMvsU2000(String fecha){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleU2000CanceladasVO> ctasActBRMList = new ArrayList<DetalleU2000CanceladasVO>();
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.detalleCanceladasvsU2000", fecha);
//			logger.info("ctasActBRMList.size: "+ ctasActBRMList.size());
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
	
	public ServiceResponse detalleCanceladasBRMvsU2000Filtro(String fecha, String filtro){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleU2000CanceladasVO> ctasActBRMList = new ArrayList<DetalleU2000CanceladasVO>();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("filtro", filtro);
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.detalleCanceladasvsU2000Filtro", map);
//			logger.info("ctasActBRMList.size: "+ ctasActBRMList.size());
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


	public ServiceResponse getCtasActBRMvsIMS(DetalleU2000CanceladasVO ctasActBrmVO){
		//logger.debug("***DAO: getCtasActBRMvsIMS (Fecha: "+ctasActBrmVO.getFecha()+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleU2000CanceladasVO> ctasActBRMList = new ArrayList<DetalleU2000CanceladasVO>();
			//logger.debug("Ejecutando cuero ctasActBRMvsISM");
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.ctasActBRMvsISM", ctasActBrmVO);
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
	
	
}
