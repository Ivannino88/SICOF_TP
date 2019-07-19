package com.mx.totalplay.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.mx.totalplay.vo.ControlAccesoVO;

public class ControlAccesoDAO {

	private static final Logger logger = Logger.getLogger(ControlAccesoDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	List<ControlAccesoVO> result = new ArrayList<ControlAccesoVO>();

// **************** METODO PARA CONSULTA DE PERMISOS (PARA PAGINA PRINCIPAL)
	
	public ServiceResponse getControlAcceso(String no_empleado){
//		logger.info("ControlAccesoDAO.getControlAcceso() trabajando");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			result = session.selectList("com.mx.totalplay.SDMapper_Selects.getControlAcceso", no_empleado);
//			for (ControlAccesoVO  x : result) {
//				logger.info("modulo-> "+x.getNombre_modulo()+"valor boton-> "+x.getBtnexc()+
//						" no_empleado-> "+x.getNo_empleado());
//			}
//			logger.info("result.size(): " + result.size());
			if(result.size()>0 && result!=null){
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se valido usuario correctamente ");
			}else{
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("NO valido usuario correctamente ");
			}
			session.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setSuccess(false);
			response.setResult(result);
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
// forech	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ServiceResponse getControlAccesoDesplegables(String no_empleado, String modulo_desplegables){
//		System.out.println("ControlAccesoDAO.getControlAccesoDesplegables()");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			Map map = new HashMap();
			map.put("no_empleado", no_empleado);
			map.put("id_modulo", modulo_desplegables);
			
			result = session.selectList("com.mx.totalplay.SDMapper_Selects.getControlAccesoDesplegables", map);
			if(result.size() > 0 && result!=null){
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se valido usuario correctamente ");
			}else{
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("NO valido usuario correctamente ");
			}
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
			response.setSuccess(false);
			response.setResult(result);
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
//*************************ACTUALIZACION DE ULTIMA CONEXION*********************	
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	public void getControlAccesoUpdate(String no_empleado, String last_connection){
//		System.out.println("ControlAccesoDAO.getControlAccesoUpdate()");
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			Map map = new HashMap();
			map.put("no_empleado", no_empleado);
			map.put("last_connection", last_connection);
			
			int resultado=session.insert("com.mx.totalplay.SDMapper_Inserts.getUpdateLastConnection", map);
			if(resultado>0)
				session.commit();
			else
				session.rollback();
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
	}

// ************************************** LISTA DE MODULOS
	
	public ServiceResponse getControlAccesoModulos(){
//		System.out.println("ControlAccesoDAO.getControlAccesoModulos()");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<ControlAccesoVO> result = new ArrayList<ControlAccesoVO>();
			result = session.selectList("com.mx.totalplay.SDMapper_Selects.getControlAccesoModulos");
			if(result.size() > 0 && result!=null){
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se obtuvieron los datos correctamente ");
			}else{
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("NO se econtraron datos ");
			}
			session.close();
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMensaje("Ocurrio un problema");
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
// ************************************************* LISTA DE CIFRAS (POR MODULO)
	public ServiceResponse getControlAccesoCifras(String modulo){
//		System.out.println("ControlAccesoDAO.getControlAccesoCifras()");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<ControlAccesoVO> result = new ArrayList<ControlAccesoVO>();
			result = session.selectList("com.mx.totalplay.SDMapper_Selects.getControlAccesoCifras",modulo);
			if(result.size() > 0 && result!=null){
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se obtuvieron los datos correctamente ");
			}else{
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("NO se econtraron datos ");
			}
			session.close();
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMensaje("Ocurrio un problema");
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
// ***************************** BUSCA INFO DE EMPLEADO(NOMBRE, APELLIDOS Y ULTIMA CONEXION)
	public ServiceResponse getControlAccesoCifrasBuscarEmp(String no_empleado){
//		System.out.println("ControlAccesoDAO.getControlAccesoCifrasBuscarEmp()");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		try {
			
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<ControlAccesoVO> result = new ArrayList<ControlAccesoVO>();
			result = session.selectList("com.mx.totalplay.SDMapper_Selects.getControlAccesoInfoEmpleado",no_empleado);
			if(result.size() > 0 && result!=null){
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se obtuvieron los datos correctamente ");
			}else{
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("NO se econtraron datos ");
			}
			session.close();
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMensaje("Ocurrio un problema");
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
			
		}
		return response;
	}

// ***********UPDATE EMPLEADO Y PERMISOS 
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public ServiceResponse getControlAccesoUpdatePermisos(List<ControlAccesoVO> lista, String nombre, String apellido, String no_empleado){
//		System.out.println("ControlAccesoDAO.getControlAccesoUpdatePermisos()");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<ControlAccesoVO> result = new ArrayList<ControlAccesoVO>();
			List<ControlAccesoVO> encontrado=new ArrayList<ControlAccesoVO>();
			List<ControlAccesoVO> noencontrado=new ArrayList<ControlAccesoVO>();
			
			
			Map mapa = new HashMap();
			mapa.put("nombre", nombre);
			mapa.put("apellido", apellido);
			mapa.put("no_empleado", no_empleado);
			session.update("com.mx.totalplay.SDMapper_Inserts.getUpdateEmpleado",mapa);
			
			for(int i=0;i<lista.size();i++){
				Map map = new HashMap();
				map.put("no_empleado", lista.get(i).getNo_empleado());
				map.put("id_modulo", lista.get(i).getId_modulo());
				map.put("id_cifra", lista.get(i).getId_cifra());
				map.put("estatus", lista.get(i).getEstatus());
				
			result = session.selectList("com.mx.totalplay.SDMapper_Selects.getSelectPermisos",map);
			if(result.size() == 0)
			noencontrado.add(lista.get(i));
			if(result.size() != 0)
			encontrado.add(lista.get(i));
			}
			int inserta=0;
			int actualiza=0;
			int actualizaf=0;
			
			if(noencontrado.size() >0){
				inserta=session.insert("com.mx.totalplay.SDMapper_Inserts.getInsertPermisos",noencontrado);
			}
			for(int i=0;i<encontrado.size();i++){
				Map map = new HashMap();
				map.put("no_empleado", encontrado.get(i).getNo_empleado());
				map.put("id_cifra", encontrado.get(i).getId_cifra());
				map.put("estatus", encontrado.get(i).getEstatus());
				actualiza=session.update("com.mx.totalplay.SDMapper_Inserts.getUpdatePermisos",map);
				actualizaf=actualizaf+actualiza;
			}
			session.commit();	
			
			if(result.size()==(inserta+actualiza)){
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se obtuvieron los datos correctamente ");
			}else{
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("NO se econtraron datos ");
			}
			session.close();
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMensaje("Ocurrio un problema");
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public ServiceResponse getControlAccesoNuevoEmp(List<ControlAccesoVO> lista, String nombre, String apellido, String no_empleado){
//		System.out.println("ControlAccesoDAO.getControlAccesoNuevoEmp()");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<ControlAccesoVO> result = new ArrayList<ControlAccesoVO>();
			
			
			Map mapa = new HashMap();
			mapa.put("nombre", nombre);
			mapa.put("apellido", apellido);
			mapa.put("no_empleado", no_empleado);
			session.update("com.mx.totalplay.SDMapper_Inserts.getInsertEmpleado",mapa);
			
			int inserta=session.insert("com.mx.totalplay.SDMapper_Inserts.getInsertPermisos",lista);
			
			session.commit();	
			
			if(lista.size()==inserta){
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se obtuvieron los datos correctamente ");
			}else{
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("NO se econtraron datos ");
			}
			session.close();
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMensaje("Ocurrio un problema");
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
	
	public ServiceResponse getControlAccesoEliminarEmp(String no_empleado){
//		System.out.println("ControlAccesoDAO.getControlAccesoEliminarEmp()");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<ControlAccesoVO> result = new ArrayList<ControlAccesoVO>();
			
			int empleado=session.delete("com.mx.totalplay.SDMapper_Deletes.getDeleteEmpleado",no_empleado);
			int permisos=session.delete("com.mx.totalplay.SDMapper_Deletes.getDeletePermisos",no_empleado);
			
			session.commit();	
			
			if(empleado+permisos>0){
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se eliminaron los datos correctamente ");
			}else{
				response.setSuccess(false);
				response.setResult(result);
				response.setMensaje("NO se econtraron datos ");
			}
			session.close();
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMensaje("Ocurrio un problema");
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
}
