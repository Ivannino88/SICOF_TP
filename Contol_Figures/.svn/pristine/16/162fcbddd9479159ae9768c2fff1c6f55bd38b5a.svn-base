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
import com.mx.totalplay.vo.FechaActualVO;
import com.mx.totalplay.vo.ServiceResponse;

public class FechaActualDAO {
	private static final Logger logger = Logger.getLogger(FechaActualDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	

	
	@SuppressWarnings({ "rawtypes"})
	public ServiceResponse getFechaActual(){
		ServiceResponse response = new ServiceResponse();
		List<FechaActualVO> reporte = new ArrayList<FechaActualVO>();
		
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map = new HashMap();
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectFechaActual",map);
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte FechaActualDAO");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
			//e.printStackTrace();
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				//logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()
					//	+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
		
		return response;
	}
			

}
