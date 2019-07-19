package com.mx.totalplay.dao;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.AdicionalesU2000BrmVO;
import com.mx.totalplay.vo.DetalleAddonsBrmNoU2000VO;
import com.mx.totalplay.vo.DetalleAddonsU2000NoBrmVO;
import com.mx.totalplay.vo.ServiceResponse;

public class AdicionalesU2000BrmDAO {
	private static final Logger logger = Logger.getLogger(AdicionalesU2000BrmDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	public ServiceResponse getConciliacionAddonsBrmU2000(AdicionalesU2000BrmVO ctsCiclovsCtasBRM){
		System.out	.println("***DAO: getConciliacionAddonsBrmU2000(Fecha: "+ctsCiclovsCtasBRM.getFecha()+")");
		//logger.debug("***DAO: getConciliacionAddonsBrmU2000(tipo_cociliacion: "+ctsCiclovsCtasBRM.getTipo_conciliacion()+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			List<AdicionalesU2000BrmVO> ctasActBRMList = new ArrayList<AdicionalesU2000BrmVO>();
			ctasActBRMList = session.selectList("com.mx.totalplay.SDMapper_Selects.getConciliacionAddonsBrmU2000", ctsCiclovsCtasBRM);
			
			for (AdicionalesU2000BrmVO x : ctasActBRMList) {
				System.out.println("valor corregido: "+ x.getCorregido()+"valor fecha: "+x.getFecha());
			}
			
			if(ctasActBRMList.size() > 0 && ctasActBRMList!= null){
				response.setSuccess(true);
				response.setResult(ctasActBRMList);
				response.setMensaje("Se obtuvo la informacion correctamente  del reporte: [Cuentas por Ciclo vs. Cuentas Facturadas BRM- BRM ");
			}else{
				response.setSuccess(false);
				response.setResult(ctasActBRMList);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Cuentas por Ciclo vs. Cuentas Facturadas BRM- BRM ");
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
	
	
	
	// EXCEL LISTA #1
	
	public ServiceResponse getDetalleAddonsBrmNoU2000(String fecha){
		System.out	.println("AdicionalesU2000BrmDAO.getDetalleAddonsBrmNoU2000()  LISTA #1");
		logger.debug("***DAO: getDetalleAddonsBrmNoU2000(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleAddonsBrmNoU2000VO> central = new ArrayList<DetalleAddonsBrmNoU2000VO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleAddonsBrmNoU2000", fecha);
			logger.info("** central.size: #1 "+ central.size());
			for (DetalleAddonsBrmNoU2000VO x : central) {
//				System.out.println("accion :---"+x.getAccion()+" "+ "conversion =: "+x.getAccion1() );
				
			}
			if(central.isEmpty()){
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleAddonsBrmNoU2000]");
				
				
			}else{
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}
			logger.debug("tamanio: #2 "+ central.size());
			session.close();
		} catch (Exception e) {
			throw new RuntimeException("Error:Parse Excel", e);
//			logger.debug(e.getCause());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
	
	//   *****   consulta solo por mil registros para mostrarlos en el front  detalleXXX
	
	public ServiceResponse getDetalleAddonsBrmNoU2000Detalle(String fecha ,int row1, int row2){
		
		logger.debug("*** AdicionalesU2000BrmDAO.getDetalleAddonsBrmNoU2000()(Fecha: "+fecha+")");
		System.out.println("json detalle  #3");
		System.out.println("row1: "+row1);
		System.out.println("row2: "+row2);
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		List<DetalleAddonsBrmNoU2000VO> central = null;
		Map map = null;
		try {
			map= new HashMap();
			map.put("fecha", fecha);
			map.put("row1", row1);
			map.put("row2", row2);
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			 central = new ArrayList<DetalleAddonsBrmNoU2000VO>();
			 System.out.println("json detalle  #4");
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleAddonsBrmNoU2000Detalle", map);
			System.out.println("json detalle  #5");
			logger.info("** central detalle "+ central.size());
			
//			for (DetalleAddonsBrmNoU2000VO x : central) {
//				x.getAccion1();
////				System.out.println("accion :---"+x.getAccion()+" "+ "conversion =: "+x.getAccion1() );
//			}
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleAddonsBrmNoU2000]");
			}
			logger.debug("tamanio: detalle "+ central.size());
			session.close();
		} catch (Exception e) {
			throw new RuntimeException("Error:Parse Excel", e);
//			logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		logger.debug("fin detalle ");
		return response;
		
	}
	
public ServiceResponse getDetalleAddonsBrmNoU2000Detalle2(String fecha ,int row1, int row2){
		
		logger.debug("*** AdicionalesU2000BrmDAO.getDetalleAddonsBrmNoU2000()(Fecha: "+fecha+")");
		System.out.println("json detalle  #3");
		System.out.println("row1: "+row1);
		System.out.println("row2: "+row2);
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		List<DetalleAddonsBrmNoU2000VO> central = null;
		Map map = null;
		try {
			map= new HashMap();
			map.put("fecha", fecha);
			map.put("row1", row1);
			map.put("row2", row2);
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			 central = new ArrayList<DetalleAddonsBrmNoU2000VO>();
			 System.out.println("json detalle  #4");
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleAddonsBrmNoU2000Detalle", map);
			System.out.println("json detalle  #5");
			logger.info("** central detalle "+ central.size());
			
			for (DetalleAddonsBrmNoU2000VO x : central) {
				x.getAccion1();
//				System.out.println("accion :---"+x.getAccion()+" "+ "conversion =: "+x.getAccion1() );
			}
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleAddonsBrmNoU2000]");
			}
			logger.debug("tamanio: detalle "+ central.size());
			session.close();
		} catch (Exception e) {
			throw new RuntimeException("Error:Parse Excel", e);
//			logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		logger.debug("fin detalle ");
		return response;
		
	}
	
	//Obtener conteo para separarlo
	public int getDetalleAddonsBrmNoU2000Conteo(String fecha){
		System.out	.println("AdicionalesU2000BrmDAO.getDetalleAddonsBrmNoU2000Conteo()");
		logger.debug("*** AdicionalesU2000BrmDAO.getDetalleAddonsBrmNoU2000()(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		List<DetalleAddonsBrmNoU2000VO> central = null;
		Integer conteo=0;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			 //central = new ArrayList<DetalleAddonsBrmNoU2000VO>();
			logger.debug("*** aquiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
			conteo = session.selectOne("com.mx.totalplay.SDMapper_Selects.getDetalleAddonsBrmNoU2000Conteo", fecha);
			logger.debug("*** conteoooooooooooooooooo:::::::::"+conteo);
//			
//			logger.debug("tamanio: detalle "+ central.size());
			session.close();
		} catch (Exception e) {
			throw new RuntimeException("Error:Parse Excel", e);
//			logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		logger.debug("fin detalle ");
		return conteo;
		
	}
	
	
	
	
	
	// **********************************  construyendo **************************
	
	@SuppressWarnings("unused")
	public ServiceResponse getJsonActualizarLista( List<DetalleAddonsBrmNoU2000VO> lista, String fecha ){
		System.out.println("AdicionalesU2000BrmDAO.getJsonActualizarLista()");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		int corregido=0;

			try {
				System.out.println("Try  ..");
				sqlSessionFactory = conexion.conexionMybatis();
				session = sqlSessionFactory.openSession();
				List<DetalleAddonsBrmNoU2000VO> result = new ArrayList<DetalleAddonsBrmNoU2000VO>();
				result=lista;
				
				for(DetalleAddonsBrmNoU2000VO x : lista) {
//					System.out.println(" CUENTA: "+x.getCuenta()+" MEGAS BRM: "+x.getMegas()+" MEGAS RED: "+x.getDescr()+" ACCION: "+x.getAccion()+
//												" ACCION ACTUAL : "+x.getAccion1()+" ONT: "+x.getOnt()+
//												"FECHA: "+x.getFecha()+" ID: "+ x.getId_conciliacion());
					if (x.getAccion()=="1") {
						corregido++;
//						System.out.println(":::: dentro de for :::::: "+ corregido);
					}
				}
				actualizaConciliacionAddonsBrmU2000(corregido,fecha);
				System.out.println("###   totales Corregidos :::::: "+ corregido);
//				if(lista.size()>=1){
					System.out.println("se insertaran estatus Uno");
					for (int i = 0; i < lista.size(); i++) {
						Map map = new HashMap();
//						map.put("fecha", lista.get(i).getFecha());
						map.put("id", lista.get(i).getId_conciliacion());
						map.put("cuenta", lista.get(i).getCuenta());
						map.put("megas", lista.get(i).getMegas());
						map.put("descr", lista.get(i).getDescr());
						map.put("ont", lista.get(i).getOnt());
						map.put("accion", lista.get(i).getAccion());
						int actualiza=session.insert("com.mx.totalplay.SDMapper_Inserts.InsertStatus",map);
						session.commit();
					}
//				}else{
//					System.out.println("todo en estatus cero zzzz");
//					actualizaDetalleAddonsBrmU2000(corregido,fecha);
//				}
				
//				int inserta=session.insert("com.mx.totalplay.SDMapper_Inserts.InsertStatus",central);
//				session.commit();
				if(result.size()!=0){
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
		System.out.println("Fin AdicionalesU2000BrmDAO.getJsonActualizarLista()");
		
			return response;
	}
	
	@SuppressWarnings("unused")
	public ServiceResponse actualizarListaAll( String opc, String fecha ){
		System.out.println("AdicionalesU2000BrmDAO.actualizarListaAll()");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		int corregido=0;

			try {
				System.out.println("Try  .."+ opc+" "+fecha);
				sqlSessionFactory = conexion.conexionMybatis();
				session = sqlSessionFactory.openSession();
				int actualiza=0;
				
				Map map = new HashMap();
				map.put("accion", opc);
				map.put("fecha", fecha);
				 actualiza=session.update("com.mx.totalplay.SDMapper_Inserts.updateStatusAll",map);
				 System.out.println("------Act "+actualiza);
				if(actualiza!=0){
					response.setSuccess(true);
					response.setResult(actualiza);
					response.setMensaje("Se actualizo correctamente");
				}else{
					response.setSuccess(false);
					response.setResult(actualiza);
					response.setMensaje("NO se actualizo la informacion");
				}
				session.commit();
				session.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				response.setSuccess(false);
				response.setMensaje("Ocurrio un problema");
				//logger.error(e.getMessage());
			}finally{
				if(session != null)
					session.close();
			}
		System.out.println("Fin AdicionalesU2000BrmDAO.actualizarListaAll()");
		
			return response;
	}
	
	public ServiceResponse actualizaConciliacionAddonsBrmU2000(int contador,String fecha){
		System.out	.println("AdicionalesU2000BrmDAO.actualizaConciliacionAddonsBrmU2000()   valor corregido es "+contador);
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("corregido", contador);
			map.put("fecha", fecha);
			int actualiza=session.insert("com.mx.totalplay.SDMapper_Inserts.actualizaCorregidos",map);
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		System.out	.println(" Fin AdicionalesU2000BrmDAO.actualizaConciliacionAddonsBrmU2000()");
		return null;
	}
	
	public ServiceResponse actualizaDetalleAddonsBrmU2000(int contador,String fecha){
		System.out	.println("AdicionalesU2000BrmDAO.actualizaDetalleAddonsBrmU2000()");
		
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("corregido", contador);
			map.put("fecha", fecha);
			int actualiza=session.insert("com.mx.totalplay.SDMapper_Inserts.InsertStatusUno",map);
			session.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		System.out	.println(" Fin AdicionalesU2000BrmDAO.actualizaConciliacionAddonsBrmU2000()");
		return null;
	}
	
	
	
	
	
	
	// **********************************  construyendo **************************
	
	
	@SuppressWarnings("rawtypes")
	public List creaLista(Object datos){
		List<DetalleAddonsBrmNoU2000VO> lista = new ArrayList<DetalleAddonsBrmNoU2000VO>();
		List<DetalleAddonsBrmNoU2000VO> central = new ArrayList<DetalleAddonsBrmNoU2000VO>();
		com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
		String resultado="";
		Gson json = new Gson();
 		resultado=json.toJson(datos);
		JSONArray jsonArray = new JSONArray(resultado);
		
            for (int i = 0; i<jsonArray.length(); i++) {
            	DetalleAddonsBrmNoU2000VO lista1 = new DetalleAddonsBrmNoU2000VO();
				JSONObject object = jsonArray.getJSONObject(i);
				 String cuenta =object.getString("cuenta");
			     String megas =object.getString("megas");	
				 String descripcion = object.getString("descr");
				 String accion = object.getString("accion");
				 String ont = object.getString("ont");
				 Boolean accion1 = object.getBoolean("accion1");
				 
                lista1.setCuenta(cuenta);
                lista1.setMegas(megas);
                lista1.setDescr(descripcion);
                lista1.setAccion(accion);
                lista1.setOnt(ont);
                           
                if(accion1==true){
                	accion="1";
                }else{ accion="0";}
                lista1.setAccion(accion);
            }
            
			for(DetalleAddonsBrmNoU2000VO x : central) {
				System.out.println(" CUENTA: "+x.getCuenta()+" MEGAS BRM: "+x.getMegas()+" MEGAS RED: "+x.getDescr()+" ACCION: "+x.getAccion()+" ACCION ACTUAL : "+x.getAccion1()+" ONT: "+x.getOnt());
			}
		return lista;
	}
	// *********************************************************************************************
	
	
	public ServiceResponse getJsonActualizarMap( Object datos ){

		System.out.println("AdicionalesU2000BrmDAO.getJsonActualizar()");
		logger.info("recibidos: "+datos);
		
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		List<DetalleAddonsBrmNoU2000VO> result = new ArrayList<DetalleAddonsBrmNoU2000VO>();
		List<DetalleAddonsBrmNoU2000VO> central = new ArrayList<DetalleAddonsBrmNoU2000VO>();
		com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
		String resultado="";
		Gson json = new Gson();
 		resultado=json.toJson(datos);
		JSONArray jsonArray = new JSONArray(resultado);
		
		Map mapa = new HashMap();
		
		
            for (int i = 0; i<jsonArray.length(); i++) {
            	DetalleAddonsBrmNoU2000VO lista1 = new DetalleAddonsBrmNoU2000VO();
				JSONObject object = jsonArray.getJSONObject(i);
				 String cuenta =object.getString("cuenta");
			     String megas =object.getString("megas");	
				 String descripcion = object.getString("descr");
				 String accion = object.getString("accion");
				 String ont = object.getString("ont");
				 Boolean accion1 = object.getBoolean("accion1");
				 
			     
                
                lista1.setCuenta(cuenta);
                lista1.setMegas(megas);
                lista1.setDescr(descripcion);
                lista1.setAccion(accion);
                lista1.setOnt(ont);
                           
                if(accion1==true){
                	accion="1";
                }else{ accion="0";}
                lista1.setAccion(accion);
                
                mapa.put("cuenta", cuenta);
        		mapa.put("megas", megas);
        		mapa.put("descr", descripcion);
        		mapa.put("accion", accion);
                central.add(lista1);
            }
	
		try {
			for(DetalleAddonsBrmNoU2000VO x : central) {
				System.out.println(" CUENTA: "+x.getCuenta()+" MEGAS BRM: "+x.getMegas()+" MEGAS RED: "+x.getDescr()+" ACCION: "+x.getAccion()+" ACCION ACTUAL : "+x.getAccion1()+" ONT: "+x.getOnt());
			}
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			int inserta=session.update("com.mx.totalplay.SDMapper_Inserts.updateDetalleAddonsBrmNoU2000", mapa);
//			int inserta=session.insert("com.mx.totalplay.SDMapper_Inserts.updateDetalleAddonsBrmNoU2000",central);
				
          
			session.commit();	
			if(inserta>0){
				System.out.println("entrando a if");
				response.setSuccess(true);
				response.setResult(result);
				response.setMensaje("Se obtuvieron los datos correctamente ");
			}else{
				System.out.println("entrando a else");
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
		System.out.println("AdicionalesU2000BrmDAO.getJsonActualizar()----FIN");
			return response;
	}
	
	
	
	
	
	// ------------------------ **********************************************************************
	public ServiceResponse getDetalleAddonsU2000NoBrm(String fecha){
		System.out.println("***DAO: getDetalleAddonsU2000NoBrm(Fecha: "+fecha+")     LISTA #2" );
//		logger.debug("***DAO: getDetalleAddonsU2000NoBrm(Fecha: "+fecha+")     LISTA #2" );
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleAddonsU2000NoBrmVO> central = new ArrayList<DetalleAddonsU2000NoBrmVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleAddonsBrmNoU2000", fecha);
			logger.info("** central.size: #2 "+ central.size());
			for (DetalleAddonsU2000NoBrmVO x : central) {
				System.out.println("accion : + "+x.getAccion() +" cuenta:: "+x.getCuenta());
			}
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleAddonsU2000NoBrm]");
			}
//			logger.debug("Tamaño #2: " +central.size());
			session.close();
		} catch (Exception e) {
			throw new RuntimeException("Error:Parse Excel", e);
//			logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
	
	
	public ServiceResponse getDetalleAddonsU2000NoBrmPart(String fecha, int row1, int row2){
		System.out.println("***DAO: getDetalleAddonsU2000NoBrm(Fecha: "+fecha+")     Detalle por partes" );

		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetalleAddonsU2000NoBrmVO> central = new ArrayList<DetalleAddonsU2000NoBrmVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getDetalleAddonsBrmNoU2000DetallePart", fecha);
//			logger.info("** central.size: #2 "+ central.size());
//			for (DetalleAddonsU2000NoBrmVO x : central) {
////				System.out.println("accion : + "+x.getAccion() +" cuenta:: "+x.getCuenta());
//			}
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [getDetalleAddonsU2000NoBrm]");
			}
//			logger.debug("Tamaño #2: " +central.size());
			session.close();
		} catch (Exception e) {
			throw new RuntimeException("Error:Parse Excel", e);
//			logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}

	
	
}



