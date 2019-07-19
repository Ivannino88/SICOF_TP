package com.mx.totalplay.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.DetalleFfmNoBrmVO;
import com.mx.totalplay.vo.DetalleProductosBrmVO;
import com.mx.totalplay.vo.PaquetesServiciosActivadosBrmPMVO;
import com.mx.totalplay.vo.ServiceResponse;

public class PaquetesServiciosActivadosBrmPMDAO {

	private static final Logger logger = Logger.getLogger(PaquetesServiciosActivadosBrmPMDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	
	public ServiceResponse getPaquetesServiciosActivadosBrmPM(String fecha){
		//logger.debug("***DAO: getPaquetesServiciosActivadosBrmPM(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<PaquetesServiciosActivadosBrmPMVO> central = new ArrayList<PaquetesServiciosActivadosBrmPMVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.selectPaquetesServiciosActivadosBrmPM", fecha);
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [Paquetes vs. Servicios Activados BRM - PRODUCT MASTER ]");
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
	
	//Detalle en DetalleProductosBrmVO
	public ServiceResponse getDetalleProductosBrm(String fecha){
	//logger.debug("***DAO: getDetalleProductosBrmVO(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleProductosBrmVO> central = new ArrayList<DetalleProductosBrmVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.selectDetalleProductosBrm", fecha);
			//logger.debug(central.size());
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete{DetalleProductosBrmVO}");
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
	//Detalle del reporte en excel DETALLE_FFM_NO_BRM
	public ServiceResponse getDetalleFfmNoBrm(String fecha){
		//logger.debug("***DAO: getDetalleFfmNoBrm(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleFfmNoBrmVO> central = new ArrayList<DetalleFfmNoBrmVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleFfmNoBrm", fecha);
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
		} catch (Exception e) {
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
}
