package com.mx.totalplay.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.ServiceResponse;
import com.mx.totalplay.vo.aCentralvsEntradaSaVO;

public class aCentralvsEntradaSaDAO {

	private static final Logger logger = Logger.getLogger(aCentralvsEntradaSaDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	public ServiceResponse getCentalvsEntradaAlamacen(String fecha){
		//logger.debug("***DAO: getReporteaCentralvsEntradaS(Fecha: "+fecha+")");
		ServiceResponse response = new ServiceResponse();
		SqlSession session = null;		
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			List<aCentralvsEntradaSaVO> central = new ArrayList<aCentralvsEntradaSaVO>();
			central = session.selectList("com.mx.totalplay.SDMapper_Selects.getaCentralvsEntradaSaVO", fecha);
			if(central.size() > 0 && central!=null){
				response.setSuccess(true);
				response.setResult(central);
				response.setMensaje("Se obtuvo la informacion correctamnete");
			}else{
				response.setSuccess(false);
				response.setResult(central);
				response.setMensaje("NO se obtuvo la informacion correctamnete del reporte: [Almacen Central vs Entradas Sub almacenes]");
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
