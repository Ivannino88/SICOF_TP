package com.mx.totalplay.dao;

/**
 * 
 * Julio 2017
 * DAO PARA EL REPORTE: 9. Cifra Control Paquetes vs. Productos Incluidos BRM - PRODUCT MASTER 
 */
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.DetallePaqvsProductIncBRMVO;
import com.mx.totalplay.vo.PaqvsProductIncBRMVO;
import com.mx.totalplay.vo.ServiceResponse;

public class PaqvsProductIncBRMDAO {
	private static final Logger logger = Logger.getLogger(PaqvsProductIncBRMDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	public ServiceResponse getPaqvsProductIncBRM(String fecha){
		//logger.debug("***DAO: getPaqvsProductIncBRM(Fecha: "+fecha );
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<PaqvsProductIncBRMVO> paqvsProductIncBRMVOList = new ArrayList<PaqvsProductIncBRMVO>();
			paqvsProductIncBRMVOList = session.selectList("com.mx.totalplay.SDMapper_Selects.selectPaqvsProductIncBRM", fecha);
			if(paqvsProductIncBRMVOList.size() > 0 && paqvsProductIncBRMVOList!=null){
				response.setSuccess(true);
				response.setResult(paqvsProductIncBRMVOList);
				response.setMensaje("Se obtuvo la informacion correctamente del reporte: [Paquetes vs. Productos Incluidos BRM - PRODUCT MASTER");
			}else{
				response.setSuccess(false);
				response.setResult(paqvsProductIncBRMVOList);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Paquetes vs. Productos Incluidos BRM - PRODUCT MASTER");
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


	public ServiceResponse getDetallePaqvsProductIncBRM(String fecha){
		//logger.debug("***DAO: selectDetallePaqvsProductIncBRM (Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;
		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<DetallePaqvsProductIncBRMVO> detPaqvsProductIncBRMVO = new ArrayList<DetallePaqvsProductIncBRMVO>();
			detPaqvsProductIncBRMVO = session.selectList("com.mx.totalplay.SDMapper_Selects.selectDetallePaqvsProductIncBRM",fecha);
//			logger.info("detPaqvsProductIncBRMVO.size: " + detPaqvsProductIncBRMVO.size());
			if(detPaqvsProductIncBRMVO.size() > 0 && detPaqvsProductIncBRMVO!=null){
				response.setSuccess(true);
				response.setResult(detPaqvsProductIncBRMVO);
				response.setMensaje("Se obtuvo la informacion correctamente del reporte: [Paquetes vs. Productos Incluidos BRM - PRODUCT MASTER");
			}else{
				response.setSuccess(false);
				response.setResult(detPaqvsProductIncBRMVO);
				response.setMensaje("NO se obtuvo la informacion correctamente del reporte: [Paquetes vs. Productos Incluidos BRM - PRODUCT MASTER");
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
	

}
