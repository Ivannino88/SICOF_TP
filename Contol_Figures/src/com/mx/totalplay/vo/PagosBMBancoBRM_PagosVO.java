package com.mx.totalplay.vo;

public class PagosBMBancoBRM_PagosVO {

	String id_conciliacion;
	String fecha;
	String empresa;
	String account_no;
	String item_total;
	String fecha_pago;
	String descr;
	String fechainsert;
	String item_no;
	String recvd;
	String fechabrm;
	
	
	public String getId_conciliacion() {
		return id_conciliacion;
	}
	public void setId_conciliacion(String id_conciliacion) {
		this.id_conciliacion = id_conciliacion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha.substring(0, 11);
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getItem_total() {
		return item_total;
	}
	public void setItem_total(String item_total) {
		this.item_total = item_total;
	}
	public String getFecha_pago() {
		return fecha_pago;
	}
	public void setFecha_pago(String fecha_pago) {
		this.fecha_pago = fecha_pago;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getFechainsert() {
		return fechainsert;
	}
	public void setFechainsert(String fechainsert) {
		this.fechainsert = fechainsert;
	}
	public String getItem_no() {
		return item_no;
	}
	public void setItem_no(String item_no) {
		this.item_no = item_no;
	}
	public String getRecvd() {
		return recvd;
	}
	public void setRecvd(String recvd) {
		this.recvd = recvd;
	}
	public String getFechabrm() {
		return fechabrm;
	}
	public void setFechabrm(String fechabrm) {
		this.fechabrm = fechabrm;
	}
	
}
