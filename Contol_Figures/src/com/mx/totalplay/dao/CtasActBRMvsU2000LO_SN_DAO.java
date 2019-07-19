package com.mx.totalplay.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.CtasActBRMvsU2000VO;
import com.mx.totalplay.vo.LineasInternasVO;
import com.mx.totalplay.vo.ServiceResponse;

public class CtasActBRMvsU2000LO_SN_DAO {
	
	private static final Logger logger = Logger.getLogger(CtasActBRMvsU2000LO_SN_DAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getCtasActBRMvsU2000LO_SN_DAO(String fecha, String todos){
				ServiceResponse response = new ServiceResponse();
				List<LineasInternasVO> lineasInternasVOList = new ArrayList<LineasInternasVO>();
				
				SqlSession session = null;
				try {
					sqlSessionFactory = conexion.conexionMybatis();
					session = sqlSessionFactory.openSession();
					
					Map map = new HashMap();
					map.put("fecha", fecha);
					
					if(todos.equals("1"))
					lineasInternasVOList = session.selectList("com.mx.totalplay.SDMapper_Selects.ctasActBRMvsU2000LI_SNtodos", map);
					else
					lineasInternasVOList = session.selectList("com.mx.totalplay.SDMapper_Selects.ctasActBRMvsU2000LI_SN", map);
					
					if(lineasInternasVOList.size() >= 0){
						response.setSuccess(true);
						response.setResult(lineasInternasVOList);
						response.setMensaje("Lineas Internas DAO Cuentas Exitoso");
					}else{
						response.setSuccess(false);
						response.setResult(lineasInternasVOList);
						response.setMensaje("Lineas Internas DAO Cuentas NO Exitoso");
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ServiceResponse getCtasActBRMvsU2000LI_insertarSNDAO(List<LineasInternasVO> listas){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		Integer result = 0;
		int contador=0;
		int resultado=0;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			for(int i=0;i<listas.size();i++){
				Map map = new HashMap();
				map.put("sn", listas.get(i).getSn());
				map.put("fecha", listas.get(i).getFecha());
				map.put("empresa", listas.get(i).getEmpresa());
		
			result = session.insert("com.mx.totalplay.SDMapper_Inserts.CtasActBRMvsU2000LI_insertarSN",map);
			if(result!=0)
				contador++;
				
				resultado++;			
				}
			if(resultado!=0 && listas.size()==resultado){
				session.commit();
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se insertaron "+contador+" de "+resultado+" registros");
			}else{
				session.rollback();
				result=0;
				
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("Ocurrio un problema, favor de verificar el documento");
				
			}
			} catch (Exception e) {
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("Contenido con formato inválido");
				//logger.error(e.getMessage());
				
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
// **************************************** ELIMINAR
	public ServiceResponse getCtasActBRMvsU2000LI_eliminarSNDAO(List<LineasInternasVO> listas){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		Integer result = 0;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			result = session.delete("com.mx.totalplay.SDMapper_Deletes.CtasActBRMvsU2000LI_eliminarSN",listas);
			
			if(result!=0){
				session.commit();
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se borraron "+result+" registros");
			}else{
				session.rollback();
				result=0;
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("Ocurrio un problema");	
			}
			} catch (Exception e) {
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("Ocurrio un problema");
				//logger.error(e.getMessage());
				
		}finally{
			if(session != null)
				session.close();
		}
		
		return response;
	}
	
	public ServiceResponse getEliminarTodoSNDAO(){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		Integer result = 0;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			result = session.delete("com.mx.totalplay.SDMapper_Deletes.CtasActBRMvsU2000LI_eliminarTodoSN");
			
			if(result!=0){
				session.commit();
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se borraron "+result+" registros");
			}else{
				session.rollback();
				result=0;
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("Ocurrio un problema");	
			}
			} catch (Exception e) {
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("Ocurrio un problema");
				//logger.error(e.getMessage());
				
		}finally{
			if(session != null)
				session.close();
		}
		
		return response;
	}
	
}
