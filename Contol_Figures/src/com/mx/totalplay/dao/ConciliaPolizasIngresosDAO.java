package com.mx.totalplay.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.ConciliaPolizasIngresosVO;
import com.mx.totalplay.vo.ServiceResponse;

public class ConciliaPolizasIngresosDAO {
	private static final Logger logger = Logger.getLogger(ConciliaPolizasIngresosDAO.class);
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ServiceResponse getConciliaPolizasIngresos(String fecha){
		//System.out.println("ConciliaPolizasIngresosDAO.getConciliaPolizasIngresos()");
		ServiceResponse response = new ServiceResponse();
		List<ConciliaPolizasIngresosVO> lista= new ArrayList<ConciliaPolizasIngresosVO>();
		SqlSession session = null;
		try {
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			Map map= new HashMap();
			map.put("fecha", fecha);
			lista = session.selectList("com.mx.totalplay.SDMapper_Selects.getConciliaPolizasIngresos",map);
			response.setResult(lista);
			response.setMensaje("SE CONSULTO CONCILIACION POLIZAS INGRESOS");
			response.setSuccess(true);
			//System.out.println("---consulta ok--");  
			for (ConciliaPolizasIngresosVO x : lista) {
				x.getFechaNew();
//				System.out.println("id-------->"+x.getId()       +"\n"+
//								   "fecha----->"+x.getFechaNew() +"\n"+
//								   "empresa--->"+x.getEmpresa()  +"\n"+
//								   "sociedad-->"+x.getSociedad() +"\n"+
//								   "moneda---->"+x.getMoneda()   +"\n"+
//								   "monto_sap->"+x.getMonto_sap()+"\n"+
//								   "montoBrm-->"+x.getMonto_brm()+"\n"+
//								   "semaforo-->"+x.getSemaforo());
			}
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//logger.error(e.getMessage());
			//e.printStackTrace();
			if (e.getCause() instanceof SQLException) {
				SQLException sqlException=(SQLException)e.getCause();
				//logger.error("### SQL ERROR ###: ["+sqlException.getErrorCode()+"] "+sqlException.getMessage());
			}
		}finally{
			if (session!=null) {
				session.close();
			}
		}
		return response;
	}
}
