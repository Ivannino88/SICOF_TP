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
import com.mx.totalplay.struts.action.CifrasControlAction;
import com.mx.totalplay.vo.BeanGraficaVo;
import com.mx.totalplay.vo.ServiceResponse;

public class GraficaLinealDao extends CifrasControlAction{
	private static final Logger logger = Logger.getLogger(GraficaLinealDao.class);
	private static final long serialVersionUID = 1L;
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory=null;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getDatosGraficaSemana(String semana,String anio){
//		logger.info("getDatosGraficaSemana()");
		ServiceResponse response = new ServiceResponse();
		List<BeanGraficaVo> reporte = new ArrayList<BeanGraficaVo>();
		SqlSession session=null;
		try {
			sqlSessionFactory=conexion.conexionMybatis();
			session=sqlSessionFactory.openSession();
			Map map= new HashMap();
			if (semana.length() == 1){
				semana = "0"+semana;
			}
			map.put("semana", semana);
			map.put("anio", anio);
				
			reporte =session.selectList("com.mx.totalplay.SDMapper_Selects.dtsGrafica",map);
//			for (BeanGraficaVo bgv : reporte) {
//				System.out.println("semana # "+bgv.getSemana()+""
//									+"año # "+bgv.getAño());
//			}
//			logger.info("datos de dao "+reporte);
			response.setResult(reporte);
			response.setMensaje("consulto datos de grafica ok..");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				logger.error("erro al consultar en dao");
				//logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
//		logger.info("fin getDatosGraficaSemana");
		return response;
	}
	// -------------###############  CONSULTA POR MES -------------------	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getDatosGraficaMes(String mes,String anio){
//		logger.info("getDatosGraficaMes()");
		ServiceResponse response = new ServiceResponse();
		List<BeanGraficaVo> reporte = new ArrayList<BeanGraficaVo>();
		SqlSession session=null;
		//System.out.println("###############");
		int m = 0;
		m = Integer.parseInt(mes);
		try {
			sqlSessionFactory=conexion.conexionMybatis();
			session=sqlSessionFactory.openSession();
			Map map2= new HashMap();
			if (mes.length() == 1){
				mes = "0"+mes;
			}
			map2.put("m", mes);
			map2.put("anio", anio);
//			logger.info("mes: "+mes+" anio: "+anio);	
			reporte =session.selectList("com.mx.totalplay.SDMapper_Selects.dtsGraficaMes",map2);
//			logger.info("reporte.size: "+reporte.size());
			for (BeanGraficaVo bgv : reporte) {
//				logger.info("mes: "+bgv.getMes());
			//						+"anio: "+bgv.getAño()+""
			//								+"empresa: "+bgv.getEmpresa());
			}
			response.setResult(reporte);
			response.setMensaje("consulto datos de grafica ok..");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				logger.error("error al consultar getDatosGraficaMes");
				logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
//		logger.info("fin metodo getDatosGraficaMes");
		return response;
	}
}
