package com.mx.totalplay.vo;

import java.text.SimpleDateFormat;
import java.util.Date;


public class AjusteMantMactVO {
	private int id;
	private String concepto;
	private Date fecha_anterior; //tipo date
	private int monto_ajus_ant;
	private Date fecha_actual;   //tipo date
	private int monto_ajus_act;
	private String color;
	private int id_empresa;
	private String empresa;
	private int id_ajuste;
	private String ajuste;
	
	private String fechAntN;
	private String fechActN;
	
	public String getFechAntN() {
		SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
		return fechAntN=ff.format(fecha_anterior);
	}
	public void setFechAntN(String fechAntN) {
		this.fechAntN = fechAntN;
	}
	public String getFechActN() {
		SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
		return fechActN=ff.format(fecha_actual);
	}
	public void setFechActN(String fechActN) {
		this.fechActN = fechActN;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public Date getFecha_anterior() {
		return fecha_anterior;
	}
	public void setFecha_anterior(Date fecha_anterior) {
		this.fecha_anterior = fecha_anterior;
	}
	public int getmonto_ajus_ant() {
		return monto_ajus_ant;
	}
	public void setmonto_ajus_ant(int monto_ajus_ant) {
		this.monto_ajus_ant = monto_ajus_ant;
	}
	public Date getFecha_actual() {
		return fecha_actual;
	}
	public void setFecha_actual(Date fecha_actual) {
		this.fecha_actual = fecha_actual;
	}
	public int getmonto_ajus_act() {
		return monto_ajus_act;
	}
	public void setmonto_ajus_act(int monto_ajus_act) {
		this.monto_ajus_act = monto_ajus_act;
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
	public int getId_ajuste() {
		return id_ajuste;
	}
	public void setId_ajuste(int id_ajuste) {
		this.id_ajuste = id_ajuste;
	}
	public String getajuste() {
		return ajuste;
	}
	public void setajuste(String ajuste) {
		this.ajuste = ajuste;
	}
	
	
	

}
