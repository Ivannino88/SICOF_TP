package com.mx.totalplay.vo;

import java.sql.Date;

public class ConciliacionTmIptvBrmVO {
	
	
	private int id;
	private Date fecha;
	private int no_iptv;
	private int no_brm;
	private int t_conciliados;
	private int error_total;
	private int error_iptv;
	private int error_brm;
	private int total;
	private String status;
	private int tipo_conciliacion;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getNo_iptv() {
		return no_iptv;
	}
	public void setNo_iptv(int no_iptv) {
		this.no_iptv = no_iptv;
	}
	public int getNo_brm() {
		return no_brm;
	}
	public void setNo_brm(int no_brm) {
		this.no_brm = no_brm;
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
	public int getError_iptv() {
		return error_iptv;
	}
	public void setError_iptv(int error_iptv) {
		this.error_iptv = error_iptv;
	}
	public int getError_brm() {
		return error_brm;
	}
	public void setError_brm(int error_brm) {
		this.error_brm = error_brm;
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
	public int getTipo_conciliacion() {
		return tipo_conciliacion;
	}
	public void setTipo_conciliacion(int tipo_conciliacion) {
		this.tipo_conciliacion = tipo_conciliacion;
	}

	
	
	
}
