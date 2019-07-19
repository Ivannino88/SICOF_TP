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
import com.mx.totalplay.vo.FacturaAntActVO;
import com.mx.totalplay.vo.PagosBMBancoVO;
import com.mx.totalplay.vo.ServiceResponse;

public class FacturaAntActDAO {
	private static final Logger logger = Logger.getLogger(FacturaAntActDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getFacturacionDao(String fecha){
		//System.out.println("FacturaAntActDAO.getFacturacionDao()");
		//logger.debug("***DAO: SalidasAlmacenCvsEntradasSubalmacDAO("+fecha+" "+empresa+");
		ServiceResponse response = new ServiceResponse();
		List<FacturaAntActVO> reporte = new ArrayList<FacturaAntActVO>();
		SqlSession session = null;
		try {
			
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("fecha", fecha);
//			map.put("id_empresa", empresa);
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.facturaAntAct",map);
			for (FacturaAntActVO x : reporte) {
				x.getFechaFN(); x.getFecha_nuevaActu();
			}
			//logger.debug(reporte.size());
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte Facturacion Anterior y Actual");
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
	
	
	
//	public ServiceResponse getFacturacionDao_CatEmpresas(){
//		System.out.println("FacturaAntActDAO.getFacturacionDao_CatEmpresas()");
//		//logger.debug("***DAO: SalidasAlmacenCvsEntradasSubalmacDAO("+fecha+" "+empresa+")"+" "+canal);
//		ServiceResponse response = new ServiceResponse();
//		List<FacturaAntActVO> reporte = new ArrayList<FacturaAntActVO>();
//		SqlSession session = null;
//		try {
//			sqlSessionFactory = conexion.conexionMybatis();
//			session = sqlSessionFactory.openSession();
//			
//			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.facturaAntAct_catEmpresas");
//			//logger.debug(reporte.size());
//			response.setResult(reporte);
//			response.setMensaje("Se consulto reporte Facturacion Anterior y Actual CATALOGO EMPRESAS");
//			response.setSuccess(true);
//			session.close();
//		} catch (Exception e) {
//			//logger.error(e.getMessage());
//			e.printStackTrace();
//			if (e.getCause() instanceof SQLException) {
//				SQLException sqlE = (SQLException) e.getCause();
//				//logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()+ "] " + sqlE.getMessage());
//			}
//		}finally{
//			if(session != null)
//				session.close();
//		}
//		return response;
//	}		
//	

}
