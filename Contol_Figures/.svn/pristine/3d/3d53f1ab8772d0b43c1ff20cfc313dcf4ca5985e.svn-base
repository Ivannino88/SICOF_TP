package com.mx.totalplay.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.ConsumosVodBrmIptvVO;
import com.mx.totalplay.vo.DetalleVodsVO;
import com.mx.totalplay.vo.ServiceResponse;

public class ConsumosVodBrmIptvDAO {
	private static final Logger logger = Logger.getLogger(ConsumosVodBrmIptvDAO.class);
	List<ConsumosVodBrmIptvVO> lista = new ArrayList<ConsumosVodBrmIptvVO>();
	List<DetalleVodsVO> lista1 = new ArrayList<DetalleVodsVO>();
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	public ServiceResponse getConciliacionVodBrm(ConsumosVodBrmIptvVO consumosVodBrmIptv){
	//logger.debug("***DAO: getconsumosVodBrmIptv(Fecha: "+consumosVodBrmIptv.getFecha()+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			//logger.debug("***DAO: ");
			List<ConsumosVodBrmIptvVO> ctasActBRMList = new ArrayList<ConsumosVodBrmIptvVO>();
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.getConciliacionVodBrm", consumosVodBrmIptv);
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
	
	
	// ---- consulta Json* 
	public ServiceResponse getDetalleVods(String fecha){
//		System.out.println("fecha de entrada ---"+fecha);
//		logger.debug("***DAO: getDetalleVods(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleVodsVO> central = new ArrayList<DetalleVodsVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleVods", fecha);
//			logger.debug("tamaño"+ central.size());
			
			if(central.size() > 0 && central!=null){
				
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleVods]");
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
	
	
	
	//-- ------------------------------- CONSULTA PRINCIPAL  POR SEMANA ----------------------------------
	 @SuppressWarnings("unchecked")
		public ServiceResponse getConciliacionVodBrm02(int  semana, int fechaAnho){
			logger.info("getConciliacionVodBrm02()" + " semana: "+ semana + " año: "+fechaAnho);
			System.out.println("evaluar grafica --- "+semana);
			ServiceResponse response = new ServiceResponse();
			SqlSession session = null;
			
			try {
				sqlSessionFactory = conexion.conexionMybatis();
				session = sqlSessionFactory.openSession();
				@SuppressWarnings("rawtypes")
				Map map = new HashMap();
				map.put("semana", semana);
				map.put("anhio", fechaAnho);
				
				logger.info("entrando a try");
				lista = session.selectList("com.mx.totalplay.SDMapper_Selects.getConciliacionVodBrm02", map);
				
				if(lista.size() > 0 && lista!=null){
					logger.info("datos= "+lista.size());
					response.setSuccess(true);
					response.setResult(lista);
					response.setMensaje("Se obtuvo la informacion correctamente  del reporte: consulta semanal ");
				}else{
					logger.info("sin datos: ");
					response.setSuccess(false);
					response.setResult(lista);
					response.setMensaje("NO se obtuvo la informacion correctamente del reporte: consulta semanal ");
				}
				session.close();
			} catch (Exception e) {
				//logger.error(e.getMessage());
				e.printStackTrace();
			}finally{
				if(session != null)
					session.close();
			}
			return response;
		}
	
	/*
	 
	  @SuppressWarnings("unchecked")
	public ServiceResponse getConciliacionVodBrm02(int  semana, int fechaAnho){
		logger.info("getConciliacionVodBrm02()" + " semana: "+ semana + " año: "+fechaAnho);
		System.out.println("MAIN() SEMANA");
		System.out.println("evaluar grafica --- "+semana);
	//logger.debug("***DAO: getconsumosVodBrmIptv(Fecha: "+consumosVodBrmIptv.getFecha()+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			@SuppressWarnings("rawtypes")
			Map map = new HashMap();
			map.put("semana", semana);
			map.put("anhio", fechaAnho);
			
			logger.info("entrando a try");
			lista = session.selectList("com.mx.totalplay.SDMapper_Selects.getConciliacionVodBrm02", map);
			
			if(lista.size() > 0 && lista!=null){
				logger.info("datos= "+lista.size());
				response.setSuccess(true);
				response.setResult(lista);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: consulta semanal ");
			}else{
				logger.info("sin datos: ");
				response.setSuccess(false);
				response.setResult(lista);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: consulta semanal ");
				
			}
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
	 */
	
	// ---- consulta Json para semana* 
		public ServiceResponse getDetalleVodsSemana(int  semana,int fechaAnho){
			System.out.println("ConsumosVodBrmIptvDAO---- detalle semana "+ semana);
			
			ServiceResponse response = new ServiceResponse();
			SqlSession session = null;
			
			try {
				logger.info("try detalles semana--------"+ semana);
				sqlSessionFactory = conexion.conexionMybatis();
				session = sqlSessionFactory.openSession();
				Map map = new HashMap();
				map.put("semana", semana);
				map.put("anhio", fechaAnho);
				
				lista1 = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleVodsSemana", map);
				logger.info(" la lista es :----------- "+lista1.size());
//				for (DetalleVodsVO  x: lista1) {
//					System.out.println(x.getCalida());
//					
//				}
				
				if(lista1.size() > 0 && lista1!=null){
					logger.info("tamaño:"+ lista1.size());
					response.setSuccess(true);
					response.setResult(lista1);
					response.setMensaje("Se obtuvo la informacion correctamnete");
				}else{
					logger.info("sin informacion -->");
					response.setSuccess(false);
					response.setResult(lista1);
					response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleVods]");
				}
				//logger.debug("tamanio: "+ central.size());
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(session != null)
					session.close();
			}
			return response;
		}
		

	
}
