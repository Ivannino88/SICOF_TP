package com.mx.totalplay.vo;

import java.util.ArrayList;
import java.util.List;

public class EvaluacionTfeTempVO {

	private String cuenta;
	private String  plan;
	private String estatus;
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public EvaluacionTfeTempVO(String cuenta, String plan, String estatus) {
		super();
		this.cuenta = cuenta;
		this.plan = plan;
		this.estatus = estatus;
	}
	@Override
	public String toString() {
		return "EvaluacionTfeTempVO [cuenta=" + cuenta + ", plan=" + plan
				+ ", estatus=" + estatus + "]";
	}
	List<EvaluacionTfeTempVO> lista = new ArrayList<EvaluacionTfeTempVO>();
	public List<EvaluacionTfeTempVO> getLista() {
		return lista;
	}
	public void setLista(List<EvaluacionTfeTempVO> lista) {
		this.lista = lista;
	}
	
	
	
}
