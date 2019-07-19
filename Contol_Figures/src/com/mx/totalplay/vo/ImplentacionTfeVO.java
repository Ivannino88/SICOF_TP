package com.mx.totalplay.vo;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mx.totalplay.mybatis.MyBatisConfig;
//import com.rp.main.Procesable;

public class ImplentacionTfeVO {
	
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession session = null;
	Integer result = 0;
	
	
	private String cuenta;
	private String plan;
	private String estatus;
	int contador=0;
	
	public String getCuenta() { return cuenta; }
	public void setCuenta(String cuenta) { this.cuenta = cuenta; }

	public String getPlan() { return plan; }
	public void setPlan(String plan) { this.plan = plan; }

	public String getEstatus() { return estatus; }
	public void setEstatus(String estatus) { this.estatus = estatus; }
	
	public ImplentacionTfeVO(String cuenta, String plan, String estatus) {
		super();
		System.out.println("ImplentacionTfeVO.ImplentacionTfeVO()");
		this.cuenta = cuenta;
		this.plan = plan;
		this.estatus = estatus;
	}
	public ImplentacionTfeVO() {
		
		super();
		// TODO Auto-generated constructor stub
	}
//	@Override
//	public void procesar() {
//		// TODO Auto-generated method stub
//		guardaElemento(getCuenta(), getPlan(),getEstatus()); 
//		contador++;
//		System.out.println("estatus->"+ contador);
//	}
	
	public void guardaElemento(String cuenta,String plan,String estatus){
		System.out.println("ImplentacionTfeVO.guardaElemento()");
		System.out.println("cuenta: "+cuenta+" plan: "+plan+" estatus: "+estatus);
//		ImplementacionTfeV1VO lista = new ImplementacionTfeV1VO(cuenta, plan, estatus);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("cuenta", cuenta);
		map.put("plan", plan);
		map.put("estatus", estatus);
		
		result =session.insert("com.mx.totalplay.SDMapper_Inserts.evaluacionTfe",map);
		
		
	}
	
}
