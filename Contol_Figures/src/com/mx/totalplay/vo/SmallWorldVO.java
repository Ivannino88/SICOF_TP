package com.mx.totalplay.vo;

import java.sql.Date;

public class SmallWorldVO {
	
	private int id;
	private String fecha;
	private int no_ffm;
	private int no_sw;
	private int t_conciliados;
	private int error_total;
	private int error_ffm;
	private int error_sw;
	private int total;
	private String status;
	private String empresa;
	private int tipo_conciliacion;
	private int porcentaje_conc;
	private int porcentaje_no_conc;
	private String porcentaje_error_ffm;
	private String porcentaje_error_sm;
	
	
	
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNo_ffm() {
		return no_ffm;
	}
	public void setNo_ffm(int no_ffm) {
		this.no_ffm = no_ffm;
	}
	public int getNo_sw() {
		return no_sw;
	}
	public void setNo_sw(int no_sw) {
		this.no_sw = no_sw;
	}
	public int getT_conciliados() {
		return t_conciliados;
	}
	public void setT_conciliados(int t_conciliados) {
		this.t_conciliados = t_conciliados;
	}
	public int getError_total() {
		return error_total;
	}
	public void setError_total(int error_total) {
		this.error_total = error_total;
	}
	public int getError_ffm() {
		return error_ffm;
	}
	public void setError_ffm(int error_ffm) {
		this.error_ffm = error_ffm;
	}
	public int getError_sw() {
		return error_sw;
	}
	public void setError_sw(int error_sw) {
		this.error_sw = error_sw;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public int getTipo_conciliacion() {
		return tipo_conciliacion;
	}
	public void setTipo_conciliacion(int tipo_conciliacion) {
		this.tipo_conciliacion = tipo_conciliacion;
	}
	public int getPorcentaje_conc() {
		return porcentaje_conc;
	}
	public void setPorcentaje_conc(int porcentaje_conc) {
		this.porcentaje_conc = porcentaje_conc;
	}
	public int getPorcentaje_no_conc() {
		return porcentaje_no_conc;
	}
	public void setPorcentaje_no_conc(int porcentaje_no_conc) {
		this.porcentaje_no_conc = porcentaje_no_conc;
	}
	public String getPorcentaje_error_ffm() {
		return porcentaje_error_ffm;
	}
	public void setPorcentaje_error_ffm(String porcentaje_error_ffm) {
		this.porcentaje_error_ffm = porcentaje_error_ffm;
	}
	public String getPorcentaje_error_sm() {
		return porcentaje_error_sm;
	}
	public void setPorcentaje_error_sm(String porcentaje_error_sm) {
		this.porcentaje_error_sm = porcentaje_error_sm;
	}
	
	
	

}


