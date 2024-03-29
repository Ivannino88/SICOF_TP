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
import com.mx.totalplay.vo.AjusteMantMactVO;
import com.mx.totalplay.vo.ServiceResponse;

public class AjusteMantMactDAO {
	private static final Logger logger = Logger.getLogger(AjusteMantMactDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getAjustesMantMactDao(String fecha){
		//System.out.println("has entrado en metodo  getAjustesMantMactDao");
		ServiceResponse response = new ServiceResponse();
		List<AjusteMantMactVO> reporte = new ArrayList<AjusteMantMactVO>();
		SqlSession session = null;
		try {
			
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			map.put("fecha", fecha);
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.ajusteMantMact",map);
			for (AjusteMantMactVO x : reporte) {
				x.getFechAntN(); x.getFechActN();
			}
			//logger.debug(reporte.size());
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte ajustes con exito");
			response.setSuccess(true);
			for (AjusteMantMactVO x : reporte) {
				//System.out.println("┐recorriendo lista.......\n");
				
			}
			
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
