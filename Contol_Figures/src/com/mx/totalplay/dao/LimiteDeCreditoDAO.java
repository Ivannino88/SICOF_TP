package com.mx.totalplay.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.LimiteDeCreditoVO;

public class LimiteDeCreditoDAO {
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	public List<LimiteDeCreditoVO> getLimiteDeCredito(){
		List<LimiteDeCreditoVO> result = new ArrayList<LimiteDeCreditoVO>();
		SqlSession session = null;
		try{
			sqlSessionFactory = conexion.conexionMybatis();
			session = sqlSessionFactory.openSession();
			result = session.selectList("com.mx.totalplay.SDMapper_Selects.getLimiteCredito");
			if(result.size()>0 && result!=null){
		//--impresion de preedatos--	
			for (LimiteDeCreditoVO x: result) {
			x.getNueva_fecha_activa(); x.getNueva_fecha_entrada(); x.getNueva_ultima_factura();	
				System.out.println("porcentaje----------> "+x.getPorcentaje()+
										  "fecha_activacion----> "+x.getNueva_fecha_activa()+
									      "fecha_entrada------> "+x.getNueva_fecha_entrada()+
									      "fecha_factura-------> "+x.getNueva_ultima_factura()+
									     "estatusCuenta-------> "+x.getEstatusCuenta());
			}
			}
			session.close();
		}catch(Exception e){
			//logger.error(e.getMessage());
		}finally{
			if(session != null)
				session.close();
		}
		return result;
	}
	
}
