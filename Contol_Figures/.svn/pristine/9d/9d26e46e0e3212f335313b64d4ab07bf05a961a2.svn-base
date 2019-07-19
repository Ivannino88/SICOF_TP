/**
 * 
 * @author G
 * DAO PARA EL REPORTE Salida de Equipos vs. Equipos Capitalizados SAP
 */
package com.mx.totalplay.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.SalidaEqvsEqCapitalizadosSAPVO;
import com.mx.totalplay.vo.ServiceResponse;

public class SalidaEqvsEqCapitalizadosSAPDAO {
	private static final Logger logger = Logger.getLogger(SalidaEqvsEqCapitalizadosSAPDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	public ServiceResponse getSalidaEqvsEqCapitalizadosSAP(String fecha){
		//logger.debug("***DAO: SalidaEqvsEqCapitalizadosSAPDAO>FECHA CONSULTA: ("+fecha+")");
		ServiceResponse response = new ServiceResponse();
		List<SalidaEqvsEqCapitalizadosSAPVO> reporte = new ArrayList<SalidaEqvsEqCapitalizadosSAPVO>();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectSalidaEqvsEqCapitalizadosSAP",fecha);
			//logger.debug(reporte.size());
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte SalidaEqvsEqCapitalizadosSAPDAO");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
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
	
	public ServiceResponse getDetalleSalidaEqvsEqCapitalizadosSAP(String fecha){
		//logger.debug("***DAO: getDetalleSalidaEqvsEqCapitalizadosSAP("+fecha+")");
		ServiceResponse response = new ServiceResponse();
		List<SalidaEqvsEqCapitalizadosSAPVO> reporte = new ArrayList<SalidaEqvsEqCapitalizadosSAPVO>();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			
			reporte = session.selectList("com.mx.totalplay.SDMapper_Selects.selectSalidaEqvsEqCapitalizadosSAP",fecha);
			//logger.debug(reporte.size());
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte getDetalleSalidaEqvsEqCapitalizadosSAP");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
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
}
