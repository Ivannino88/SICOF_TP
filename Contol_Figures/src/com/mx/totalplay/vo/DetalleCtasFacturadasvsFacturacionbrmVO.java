/**
 * @author RicardoM
 * Bean para el detalle del reporte
 * Cuentas Facturadas vs. Facturacion BRM - INTERFACTURA
 */
package com.mx.totalplay.vo;

import java.util.List;

public class DetalleCtasFacturadasvsFacturacionbrmVO {
	@Override
	public String toString() {
		return "DetalleCtasFacturadasvsFacturacionbrmVO [fecha=" + fecha
				+ ", cuenta=" + cuenta + ", empresa=" + empresa + ", monto="
				+ monto + ", fecha_factura=" + fecha_factura
				+ ", fecha_vencimiento=" + fecha_vencimiento
				+ ", fac_tele_Tel=" + fac_tele_Tel + ", fac_total_box="
				+ fac_total_box + ", fac_internet=" + fac_internet
				+ ", foliofis_tele_tel=" + foliofis_tele_tel
				+ ", foliofis_total_box=" + foliofis_total_box
				+ ", foliofis_internet=" + foliofis_internet + ", monto_tele="
				+ monto_tele + ", monto_box=" + monto_box + ", monto_internet="
				+ monto_internet + ", documentos=" + documentos + "]";
	}
	private String fecha;
	private String cuenta;
	private String empresa;
	private String monto;
	private String fecha_factura;
	private String fecha_vencimiento;
	private  String fac_tele_Tel;
    private String fac_total_box;
    private String fac_internet; 
    private String foliofis_tele_tel;
    private String foliofis_total_box;
    private String foliofis_internet;
	private Double monto_tele;
    private Double monto_box;
    private Double monto_internet;
	private List<Documento> documentos;
	
	
	 public String getFoliofis_internet() {
			return foliofis_internet;
		}
		public void setFoliofis_internet(String foliofis_internet) {
			this.foliofis_internet = foliofis_internet;
		}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha.substring(0, 11);
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getFecha_factura() {
		return fecha_factura;
	}
	public void setFecha_factura(String fecha_factura) {
		this.fecha_factura = fecha_factura.substring(0, 11);
	}
	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}
	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento.substring(0, 11);
	}
	public List<Documento> getDocumentos() {
		return documentos;
	}
	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
	public String getFac_tele_Tel() {
		return fac_tele_Tel;
	}
	public void setFac_tele_Tel(String fac_tele_Tel) {
		this.fac_tele_Tel = fac_tele_Tel;
	}
	public String getFac_total_box() {
		return fac_total_box;
	}
	public void setFac_total_box(String fac_total_box) {
		this.fac_total_box = fac_total_box;
	}
	public String getFac_internet() {
		return fac_internet;
	}
	public void setFac_internet(String fac_internet) {
		this.fac_internet = fac_internet;
	}
	public String getFoliofis_tele_tel() {
		return foliofis_tele_tel;
	}
	public void setFoliofis_tele_tel(String foliofis_tele_tel) {
		this.foliofis_tele_tel = foliofis_tele_tel;
	}
	public String getFoliofis_total_box() {
		return foliofis_total_box;
	}
	public void setFoliofis_total_box(String foliofis_total_box) {
		this.foliofis_total_box = foliofis_total_box;
	}

	public Double getMonto_tele() {
		return monto_tele;
	}
	public void setMonto_tele(Double monto_tele) {
		this.monto_tele = monto_tele;
	}
	public Double getMonto_box() {
		return monto_box;
	}
	public void setMonto_box(Double monto_box) {
		this.monto_box = monto_box;
	}
	public Double getMonto_internet() {
		return monto_internet;
	}
	public void setMonto_internet(Double monto_internet) {
		this.monto_internet = monto_internet;
	}
	
	
}
