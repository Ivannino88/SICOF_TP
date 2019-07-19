/**
 * 
 * 
 * 08 Agosto 2017
 */
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
import com.mx.totalplay.vo.PagosBMBancoBRM_PagosVO;
import com.mx.totalplay.vo.PagosBMBancoPaymentBATCHVO;
import com.mx.totalplay.vo.PagosBMBancoPaymentBAZVO;
import com.mx.totalplay.vo.PagosBMBancoPaymentDIESTELVO;
import com.mx.totalplay.vo.PagosBMBancoPaymentMIDVO;
import com.mx.totalplay.vo.PagosBMBancoPaymentOXXOVO;
import com.mx.totalplay.vo.PagosBMBancoPaymentRECVO;
import com.mx.totalplay.vo.PagosBMBancoPaymentREGALIVO;
import com.mx.totalplay.vo.PagosBMBancoVO;
import com.mx.totalplay.vo.ServiceResponse;

public class PagosBRMBancoDAO {
	private static final Logger logger = Logger.getLogger(PagosBRMBancoDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
//*********************************************************  PRINCIPAL Y DETALLE PRINCIPAL
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getPagosBRMBanco(String fecha,String empresa, String canal){
		
		ServiceResponse response = new ServiceResponse();
		List<PagosBMBancoVO> reporte = new ArrayList<PagosBMBancoVO>();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("fecha", fecha);
			map.put("id_empresa", empresa);
			map.put("id_canal", canal);
			
			
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.getPagosBRMBanco",map);
			//logger.debug(reporte.size());
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte Pagos BRM Banco");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
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

//************************************************************ DETALLE BRM  PAGOS Y PAYMENT

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getPagosBRMBancoBRM_PAGOS(String canal, String id_conciliacion){
		String nombretabla=null;
		
		if(canal.equals("1")){
			//System.out.println("NOMBRE DE TABLA DETALLE_BRM_PAGOS_EFECTI_BATCH");
			nombretabla="DETALLE_BRM_PAGOS_EFECTI_BATCH";
			}
		if(canal.equals("2")){
			//System.out.println("NOMBRE DE TABLA DETALLE_BRM_PAGOS_DOMICI_RECUR");
			nombretabla="DETALLE_BRM_PAGOS_DOMICI_RECUR";
			}
		if(canal.equals("3")){
			//System.out.println("NOMBRE DE TABLA DETALLE_BRM_PAGOS_BAZ");
			nombretabla="DETALLE_BRM_PAGOS_BAZ";
		}
		if(canal.equals("4")){
			//System.out.println("NOMBRE DE TABLA DETALLE_BRM_PAGOS_OXXO");
			nombretabla="DETALLE_BRM_PAGOS_OXXO";
		}
		if(canal.equals("5")){
			//System.out.println("NOMBRE DE TABLA DETALLE_BRM_PAGOS_DIESTEL");
			nombretabla="DETALLE_BRM_PAGOS_DIESTEL";		
			}
		if(canal.equals("6")){
			//System.out.println("NOMBRE DE TABLA DETALLE_BRM_PAGOS_REGALI");
			nombretabla="DETALLE_BRM_PAGOS_REGALI";		
			}
		if(canal.equals("7")){
			//System.out.println("NOMBRE DE TABLA DETALLE_BRM_PAGOS_MTP_CAT_IVR");
			nombretabla="DETALLE_BRM_PAGOS_MTP_CAT_IVR";		
			}
		if(canal.equals("8")){
			//System.out.println("NOMBRE DE TABLA DETALLE_BRM_PAGOS_OTROS");
			nombretabla="DETALLE_BRM_PAGOS_OTROS";		
			}
		ServiceResponse response = new ServiceResponse();
		List<PagosBMBancoBRM_PagosVO> reporte = new ArrayList<PagosBMBancoBRM_PagosVO>();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("id_conciliacion", id_conciliacion);
			map.put("nombretabla", ""+nombretabla+"");
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.getPagosBRMBancoBRM_PAGOS",map);
			//logger.debug(reporte.size());
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte getPagosBRMBancoBRM_PAGOS");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
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
	public ServiceResponse getPagosBRMBancoPayment(String canal, String id_conciliacion){
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		try {
			
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("id_conciliacion", id_conciliacion);
			
			if(canal.equals("1")){
				List<PagosBMBancoPaymentBATCHVO> reporte = new ArrayList<PagosBMBancoPaymentBATCHVO>();
				reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.getPagosBRMBancoPaymentBATCH",map);
				response.setResult(reporte);
				response.setMensaje("Se consulto reporte getPagosBRMBancoPaymentBATCH");
				//System.out.println("Se consulto reporte getPagosBRMBancoPaymentBATCH");
				}
				
				if(canal.equals("2")){
					List<PagosBMBancoPaymentRECVO> reporte = new ArrayList<PagosBMBancoPaymentRECVO>();
					reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.getPagosBRMBancoPaymentREC",map);
					response.setResult(reporte);
					response.setMensaje("Se consulto reporte getPagosBRMBancoPaymentREC");
					//System.out.println("Se consulto reporte getPagosBRMBancoPaymentREC");

					}
				
				if(canal.equals("3")){
					List<PagosBMBancoPaymentBAZVO> reporte = new ArrayList<PagosBMBancoPaymentBAZVO>();
					//System.out.println("entro correctamente");
					reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.getPagosBRMBancoPaymentBAZ",map);
					response.setResult(reporte);
					response.setMensaje("Se consulto reporte getPagosBRMBancoPaymentBAZ");
					//System.out.println("Se consulto reporte getPagosBRMBancoPaymentBAZ");

				}
				
				if(canal.equals("4")){
					List<PagosBMBancoPaymentOXXOVO> reporte = new ArrayList<PagosBMBancoPaymentOXXOVO>();
					//System.out.println("entro correctamenteeee");
					reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.getPagosBRMBancoPaymentOXXO",map);
					response.setResult(reporte);
					response.setMensaje("Se consulto reporte getPagosBRMBancoPaymentOXXO");
					//System.out.println("Se consulto reporte getPagosBRMBancoPaymentOXXO");
					}
				
				if(canal.equals("5")){
					List<PagosBMBancoPaymentDIESTELVO> reporte = new ArrayList<PagosBMBancoPaymentDIESTELVO>();
					reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.getPagosBRMBancoPaymentDIESTEL",map);
					response.setResult(reporte);
					response.setMensaje("Se consulto reporte getPagosBRMBancoPaymentDIESTEL");
					//System.out.println("Se consulto reporte getPagosBRMBancoPaymentDIESTEL");

					}
				
				if(canal.equals("6")){
					List<PagosBMBancoPaymentREGALIVO> reporte = new ArrayList<PagosBMBancoPaymentREGALIVO>();
					reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.getPagosBRMBancoPaymentREGALI",map);
					response.setResult(reporte);
					response.setMensaje("Se consulto reporte getPagosBRMBancoPaymentREGALI");
					//System.out.println("Se consulto reporte getPagosBRMBancoPaymentREGALI");

					}
				
				if(canal.equals("7")){
					List<PagosBMBancoPaymentMIDVO> reporte = new ArrayList<PagosBMBancoPaymentMIDVO>();
					reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.getPagosBRMBancoPaymentMID",map);
					response.setResult(reporte);
					response.setMensaje("Se consulto reporte getPagosBRMBancoPaymentCANAL_PROPIO");
					//System.out.println("Se consulto reporte getPagosBRMBancoPaymentCANAL_PROPIO");

					}
				
				
			
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
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
	
//************************************************************************  CARGA DE CANALES Y EMPRESA
	
	public ServiceResponse getPagosBRMBanco_CatCanales(){
		ServiceResponse response = new ServiceResponse();
		List<PagosBMBancoVO> reporte = new ArrayList<PagosBMBancoVO>();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.getPagosBRMBanco_catCanales");
			//logger.debug(reporte.size());
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte Pagos BRM Banco CATALOGO CANALES");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
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

	
	
	public ServiceResponse getPagosBRMBanco_CatEmpresas(){
		ServiceResponse response = new ServiceResponse();
		List<PagosBMBancoVO> reporte = new ArrayList<PagosBMBancoVO>();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.getPagosBRMBanco_catEmpresas");
			//logger.debug(reporte.size());
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte Pagos BRM Banco CATALOGO EMPRESAS");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
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
	
}