package com.mx.totalplay.vo;

import java.text.SimpleDateFormat;
import java.util.Date;


public class FacturaAntActVO {
	
	private int  	id;
	private Date  fecha_anterior;
	private String  monto_fact_ant;
	private Date  fecha_actual;
	private int  	monto_fact_act;
	private String  color;
	private int  	id_empresa;
	private String  empresa;
	private String fechaFN;
	private String fecha_nuevaActu;
	
	
	
	public String getFechaFN() {
		SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
		return fechaFN=ff.format(fecha_anterior);
	}
	public void setFechaFN(String fechaFN ) {
		this.fechaFN = fechaFN;
	}
	public String getFecha_nuevaActu() {
		SimpleDateFormat ff1 = new SimpleDateFormat("dd/MM/yyyy");
		return fecha_nuevaActu=ff1.format(fecha_actual);
	}
	public void setFecha_nuevaActu(String fecha_nuevaActu) {
		this.fecha_nuevaActu = fecha_nuevaActu;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha_anterior() {
		return fecha_anterior;
	}
	public void setFecha_anterior(Date fecha_anterior) {
		this.fecha_anterior = fecha_anterior;
	}
	public String getMonto_fact_ant() {
		return monto_fact_ant;
	}
	public void setMonto_fact_ant(String monto_fact_ant) {
		this.monto_fact_ant = monto_fact_ant;
	}
	public Date getFecha_actual() {
		return fecha_actual;
	}
	public void setFecha_actual(Date fecha_actual) {
//		this.fecha_actual = fecha_actual.substring(0,10);
		this.fecha_actual=fecha_actual;
	}
	public int getMonto_fact_act() {
		return monto_fact_act;
	}
	public void setMonto_fact_act(int monto_fact_act) {
		this.monto_fact_act = monto_fact_act;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	
	
}
