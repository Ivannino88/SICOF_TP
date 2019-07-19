package com.mx.totalplay.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.RhProyectoSinTransaccionesModalDetailVO;
import com.mx.totalplay.vo.RhProyectoSinTransaccionesModalVO;
import com.mx.totalplay.vo.RhProyectoSinTransaccionesVO;
import com.mx.totalplay.vo.ServiceResponse;

public class RhProyectoSinTransaccionesModalDao {
	private static final Logger logger = Logger.getLogger(RhProyectoSinTransaccionesModalDao.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	// °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°  CONSULTA PRINCIPAL  °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getRhProyectoSinTransaccionesModal(String semana, String anio, String id){
		ServiceResponse response = new ServiceResponse();
		List<RhProyectoSinTransaccionesModalVO> reporte = new ArrayList<RhProyectoSinTransaccionesModalVO>();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("semana", semana);
			map.put("anio", anio);
			map.put("id", id);
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectRhProyectoSinTransaccionesModal",map);
			//logger.info("reporte.size: " + reporte.size());
			for(int i = 0; i < reporte.size(); i++){
			//	logger.info("reporte.get(i).getDiasactividad(): " + reporte.get(i).getDiasactividad());
			}
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte RhProyectoSinTransaccionesModalDAO");
			response.setSuccess(true);
			session.close();
		}catch (Exception e) {
			//logger.error(e.getMessage());
			//e.printStackTrace();
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				//logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()	+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
		//logger.info("response: " + response);
		return response;
	}
	
		// °°°°°°°°°°°°°°°°°°°°° --- LISTA PUESTOS PARA MENU DE FRONT--- °°°°°°°°°°°°°°°	
				@SuppressWarnings({ "rawtypes", "unchecked" })
				public List<RhProyectoSinTransaccionesModalVO> getPuestosLista(){
					System.out.println("ModalDao.getPuestosLista()");
					List<RhProyectoSinTransaccionesModalVO> lista = new ArrayList<RhProyectoSinTransaccionesModalVO>();
					SqlSession session = null;
					try {
						sqlSessionFactory = conexion.conexionMybatis();
						session = sqlSessionFactory.openSession();
						lista = session.selectList("com.mx.totalplay.SDMapper_Selects.listaPuesto");
						if (lista.size()>0 && lista!=null) {
							for (RhProyectoSinTransaccionesModalVO pV : lista) {
								System.out.print("lista de puestos -># "+pV.getPuesto()+" ");
							}
						}
						session.close();
					} catch (Exception e) {
						if (e.getCause() instanceof SQLException) {
							SQLException sqlE = (SQLException) e.getCause();
						}
					}finally{
						if(session != null)
							session.close();
					}
					return lista;
				}
				
// ----------------- CONSULTA DE PUESTOS SELECCIONADO SEGUN SU PUESTO -------------				
				public ServiceResponse getConsultaPuestoSelect(String array,String semana,String anio ){
					System.out.println("Dao_getConsultaPuestoSelect()");
					String arrayout;
					System.out.println("array--->"+array);
					System.out.println("semana-->"+semana);
					System.out.println("año----->"+anio);
					// remplazar " por '
					array=array.replaceAll("\"", "\'");
					System.out.println("salida---x>"+array);
					// remplazar [] por ()
					String salida1=array.replace('[', '(');
					String salidaOk=salida1.replace(']', ')');
					System.out.println(" okkk ----->"+salidaOk);
					
					ServiceResponse response = new ServiceResponse();
					List<RhProyectoSinTransaccionesModalVO> reporte = new ArrayList<RhProyectoSinTransaccionesModalVO>();
					SqlSession session = null;
					try {
						sqlSessionFactory = conexion.conexionMybatis();
						session = sqlSessionFactory.openSession();
						Map map = new HashMap();
						map.put("salidaOk", salidaOk);
						map.put("semana", semana);
						map.put("anio", anio);
						
						reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectPuestoOp",map);
						if(reporte.size()>0 && reporte!=null){
							System.out.println("-----datos ok------");
						for (RhProyectoSinTransaccionesModalVO p : reporte) {
							System.out.println("puesto->"+p.getPuesto()+" situacion-->"+p.getSituacion());
						}
						response.setResult(reporte);
						response.setMensaje("Se consulto reporte RhProyectoSinTransaccionesModalDetailDAO");
						response.setSuccess(true);
						}
						else{
							System.out.println("----- sin datos------");
						}
						session.close();
					}catch (Exception e) {
						if (e.getCause() instanceof SQLException) {
							SQLException sqlE = (SQLException) e.getCause();
						}
					}finally{
						if(session != null)
							session.close();
					}
					return response;
				}

				
// ----------------- CONSULTA DE PUESTOS SELECCIONADO SEGUN SU PUESTO  DEMO -------------				
				public List<RhProyectoSinTransaccionesModalVO> getPuestoDemo(String array,String semana,String anio){
					System.out.println("Dao.getPuestoDemo()");
					System.out.println("semana:-> "+semana+" año:-> "+anio);
					String arrayout;
					// remplazar " por '
					arrayout=array.replaceAll("\"", "\'");
					System.out.println("salida--->"+arrayout);
					// remplazar [] por ()
					String salida1=array.replace('[', '(');
					String salidaOk=salida1.replace(']', ')');
					System.out.println(" okkk ----->"+salidaOk);
					List<RhProyectoSinTransaccionesModalVO> reporte = new ArrayList<RhProyectoSinTransaccionesModalVO>();
					SqlSession session = null;
					
					try {
						sqlSessionFactory = conexion.conexionMybatis();
						session = sqlSessionFactory.openSession();
						Map map = new HashMap();
						map.put("array", salidaOk);
						map.put("semana", semana);
						map.put("anio", anio);
						
						reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectPuestoOp",map);
						if (reporte.size()>0 && reporte!=null) {
							System.out.println("---------elementos ok.......");
							for (RhProyectoSinTransaccionesModalVO x : reporte) {
								System.out.println("nombre "+x.getNombre()+
										"puesto "+x.getPuesto()+"fecha "+x.getSituacion());
							}

						} else {
							System.out.println("...........sin elementos.........");
						}
						session.close();
					}catch (Exception e) {
						// TODO: handle exception
					}
						
					System.out.println("fin demo");
					return reporte;
				}
				
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getRhProyectoSinTransaccionesModalDetail(String id, String idconciliacion){
		ServiceResponse response = new ServiceResponse();
		List<RhProyectoSinTransaccionesModalDetailVO> reporte = new ArrayList<RhProyectoSinTransaccionesModalDetailVO>();
		
		
		SqlSession session = null;
		

		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			//map.put("semana", semana);
			map.put("con", idconciliacion);
			map.put("id", id);
			//logger.info("DAO id: " + id);
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectRhProyectoSinTransaccionesModalDetail",map);
			//logger.info("reporte.size: " + reporte.size());
			for(int i = 0; i < reporte.size(); i++){
			//	logger.info("reporte.get(i).getFechaactividad(): " + reporte.get(i).getFechaactividad());
			//	logger.info("reporte.get(i).getIdconciliacion(): " + reporte.get(i).getIdconciliacion());
			}
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte RhProyectoSinTransaccionesModalDetailDAO");
			response.setSuccess(true);
			session.close();
		}catch (Exception e) {
			//logger.error(e.getMessage());
			//e.printStackTrace();
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				//logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
		
		return response;
	}

	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getRhProyectoSinTransaccionesModalDetalleV(String semana, String anio, String id){
		ServiceResponse response = new ServiceResponse();
		List<RhProyectoSinTransaccionesModalVO> reporte = new ArrayList<RhProyectoSinTransaccionesModalVO>();
		
		SqlSession session = null;
		

		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("semana", semana);
			map.put("anio", anio);
			map.put("id", id);
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectRhProyectoSinTransaccionesModalDetalleV",map);
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte RhProyectoSinTransaccionesModalDAO");
			response.setSuccess(true);
			session.close();
		}catch (Exception e) {
			//logger.error(e.getMessage());
			//e.printStackTrace();
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				//logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()	+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}

	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getRhProyectoSinTransaccionesModalDetalleA(String semana, String anio, String id){
		ServiceResponse response = new ServiceResponse();
		List<RhProyectoSinTransaccionesModalVO> reporte = new ArrayList<RhProyectoSinTransaccionesModalVO>();
		
		SqlSession session = null;
		

		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("semana", semana);
			map.put("anio", anio);
			map.put("id", id);
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectRhProyectoSinTransaccionesModalDetalleA",map);
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte RhProyectoSinTransaccionesModalDAO");
			response.setSuccess(true);
			session.close();
		}catch (Exception e) {
			//logger.error(e.getMessage());
			//e.printStackTrace();
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				//logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()	+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}

	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getRhProyectoSinTransaccionesModalDetalleR(String semana, String anio, String id){
		ServiceResponse response = new ServiceResponse();
		List<RhProyectoSinTransaccionesModalVO> reporte = new ArrayList<RhProyectoSinTransaccionesModalVO>();
		
		SqlSession session = null;
		

		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("semana", semana);
			map.put("anio", anio);
			map.put("id", id);
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectRhProyectoSinTransaccionesModalDetalleR",map);
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte RhProyectoSinTransaccionesModalDAO");
			response.setSuccess(true);
			session.close();
		}catch (Exception e) {
			//logger.error(e.getMessage());
			//e.printStackTrace();
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				//logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()		+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}

	
	
}
