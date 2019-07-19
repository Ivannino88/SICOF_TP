package com.mx.totalplay.dao;

/**
 * 
 * @author RicardoM
 * DAO PARA EL REPORTE DE INSTALACIONES VS ALMACEN CIFRAS SAP-BRM
 */
import java.sql.SQLException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.InstalacionesVSalmacen_cifras_sapbrm_VO;
import com.mx.totalplay.vo.ServiceResponse;

public class InstalacionesVSalmacen_cifras_sapbrm_DAO {
	private static final Logger logger = Logger.getLogger(InstalacionesVSalmacen_cifras_sapbrm_DAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	public ServiceResponse getReporteInstalacionesVSalmacen_cifras_sapbrms(String fecha){
		//logger.debug("***DAO: getReporteInstalacionesVSalmacen_cifras_sapbrms("+fecha+")");
		ServiceResponse response = new ServiceResponse();
		InstalacionesVSalmacen_cifras_sapbrm_VO reporte = new InstalacionesVSalmacen_cifras_sapbrm_VO();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			reporte = session.selectOne("com.mx.totalplay.SDMapper_Selects.select_INSTALACIONESVSALMACENCIFRASSAPBRM",fecha);
			
			response.setResult(reporte);
			response.setMensaje("Se consulto reporte getReporteInstalacionesVSalmacen_cifras_sapbrms");
			response.setSuccess(true);
			session.close();
		} catch (Exception e) {
			//logger.error(e.getMessage());
			//e.printStackTrace();
			if (e.getCause() instanceof SQLException) {
				SQLException sqlE = (SQLException) e.getCause();
				//logger.error("### SQL ERROR ###: [" + sqlE.getErrorCode()
				//		+ "] " + sqlE.getMessage());
			}
		}finally{
			if(session != null)
				session.close();
		}
		return response;
	}
}
