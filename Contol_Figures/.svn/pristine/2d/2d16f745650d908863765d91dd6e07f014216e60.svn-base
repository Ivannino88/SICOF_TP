package com.mx.totalplay.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.struts.action.Conversor;
import com.mx.totalplay.vo.DetalleFfmCuentasNoSwVO;
import com.mx.totalplay.vo.DetalleSWCuentasNoFFMVO;
import com.mx.totalplay.vo.DetalleSWDatosNoFFMVO;
import com.mx.totalplay.vo.ServiceResponse;
import com.mx.totalplay.vo.SmallWorldVO;

public class SmallWorldDAO {

	private static final Logger logger = Logger.getLogger(SmallWorldDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	
	public ServiceResponse getSmallWorld(String fecha){
		//System.out.println(fecha);
		
		//logger.debug("***DAO: getSmallWorld(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<SmallWorldVO> central = new ArrayList<SmallWorldVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getSmallWorld", fecha);
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamente [Instalaciones vs. Salidas de Almacen SAP - BRM]");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Instalaciones vs. Salidas de Almacen SAP - BRM]");
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
	
	// detalle vista json* #1
	public ServiceResponse getDetalleFfmCuentasNoSw(String fecha){
		//logger.debug("***DAO: getDetalleFfmCuentasNoSw(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleFfmCuentasNoSwVO> central = new ArrayList<DetalleFfmCuentasNoSwVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleFfmCuentasNoSw", fecha);
			//logger.debug("***DAO: getDetalleFfmCuentasNoSw(Fecha: 2"+fecha+")");
			if(central.size() > 0 && central!=null){
				for (DetalleFfmCuentasNoSwVO x : central) {
					x.getFechaShort();
					x.getFecha_modificacionShort();
				}
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamente");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [DetalleFfmCuentasNoSwVO]");
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
	// detalle vista json* #2
	public ServiceResponse getDetalleSWCuentasNoFFM(String fecha){
		//logger.debug("***DAO: getDetalleSWCuentasNoFFM(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleSWCuentasNoFFMVO> central = new ArrayList<DetalleSWCuentasNoFFMVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleSWCuentasNoFFM", fecha);
			if(central.size() > 0 && central!=null){
				for (DetalleSWCuentasNoFFMVO x : central) {
					x.getFechaShort();
					x.getFecha_modificacionShort();
				}
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamente {getDetalleSWCuentasNoFFM}");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [getDetalleSWCuentasNoFFM]");
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
	// detalle vista json* #3
	public ServiceResponse getDetalleSWDatosNoFFM(String fecha){
		//logger.debug("***DAO: getDetalleSWDatosNoFFM(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleSWDatosNoFFMVO> central = new ArrayList<DetalleSWDatosNoFFMVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleSWDatosNoFFM", fecha);
			if(central.size() > 0 && central!=null){
				for (DetalleSWDatosNoFFMVO x : central) {
					x.getFechaShortSw();
					x.getFecha_modificacionShortSw();
					x.getFecha_modificacion_ffmShort();
				}
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamente {getDetalleSWDatosNoFFM}");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [getDetalleSWDatosNoFFM]");
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
