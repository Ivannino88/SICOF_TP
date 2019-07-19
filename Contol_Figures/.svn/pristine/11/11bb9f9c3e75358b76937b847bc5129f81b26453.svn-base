package com.mx.totalplay.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.AdicionalesU2000BrmPromocionesVO;
import com.mx.totalplay.vo.AdicionalesU2000BrmVO;
import com.mx.totalplay.vo.DetalleAddonsBrmNoU2000VO;
import com.mx.totalplay.vo.DetalleAddonsU2000NoBrmVO;
import com.mx.totalplay.vo.ServiceResponse;

public class AdicionalesU2000BrmPromocionesDAO {
	private static final Logger logger = Logger.getLogger(AdicionalesU2000BrmPromocionesDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;

// CONSULTAS PROMOCIONES
	public ServiceResponse getPromocionesAddonsBrmU2000(String opcion){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<AdicionalesU2000BrmPromocionesVO> lista = new ArrayList<AdicionalesU2000BrmPromocionesVO>();
			
			if(opcion.equals("1"))
			lista = session.selectList("com.mx.totalplay.SDMapper_Selects.getPromociones_dobleCAT");
			if(opcion.equals("2"))
			lista = session.selectList("com.mx.totalplay.SDMapper_Selects.getPromociones_paqueteIntermedia");
			if(opcion.equals("3"))
			lista = session.selectList("com.mx.totalplay.SDMapper_Selects.getPromociones_creceloCAT");
			if(opcion.equals("4"))
			lista = session.selectList("com.mx.totalplay.SDMapper_Selects.getPromociones_addCAT");

			
			if(lista.size() > 0 && lista!=null){
				response.setSuccess(true);
				response.setResult(lista);
				response.setMensaje("CONSULTA EXITOSA");
			}else{
				response.setSuccess(false);
				response.setResult(lista);
				response.setMensaje("OCURRIO UN ERROR");
			}
			session.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse InsertarAdicionalesU2000BrmPromo(String p, String prod_megas, String megas, String opcion){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			int result=0;
			Map map = new HashMap();
			//logger.info("DAO Opcion: "+opcion+" p: "+p+" prod_megas: "+prod_megas+" megas: "+megas);
			
			if(opcion.equals("1")){
				//logger.info("Entrando en opcion: 1");
				//logger.info("Inserts.insertPromociones_dobleCAT");
				map.put("poid", p);
				map.put("producto", prod_megas);
				result = session.insert("com.mx.totalplay.SDMapper_Inserts.insertPromociones_dobleCAT",map);
			}	
			
			else if(opcion.equals("2")) {
				//logger.info("Entrando en opcion: 2");
				//logger.info("Inserts.insertPromociones_paqueteIntermedia");
				map.put("paquete", p);
				map.put("megas_bajada", prod_megas);
				result = session.insert("com.mx.totalplay.SDMapper_Inserts.insertPromociones_paqueteIntermedia", map);
			}	
				
			else if(opcion.equals("3")) {
				//logger.info("Entrando en opcion: 3");
				//logger.info("Inserts.insertPromociones_creceloCAT");
				map.put("poid", p);
				map.put("producto", prod_megas);
				map.put("megas", megas);
				result = session.insert("com.mx.totalplay.SDMapper_Inserts.insertPromociones_creceloCAT", map);
			}	
			
			else if(opcion.equals("4")) {
				//logger.info("Entrando en opcion: 4");
				//logger.info("Inserts.insertPromociones_addCAT");
				map.put("poid", p);
				map.put("producto", prod_megas);
				map.put("megas", megas);
				result = session.insert("com.mx.totalplay.SDMapper_Inserts.insertPromociones_addCAT", map);
			}	
						
			
			if(result > 0){
				if(session != null)
				session.commit();
				
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se inserto registro");
			}else{
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("No se realizó la operación");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
	
}
