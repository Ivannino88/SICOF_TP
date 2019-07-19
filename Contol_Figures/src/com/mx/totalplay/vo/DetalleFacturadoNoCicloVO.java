package com.mx.totalplay.vo;


public class DetalleFacturadoNoCicloVO {
	
	private int idConciliacion;
	private String fecha;
	private String cuenta;
	private String empresa;
	private String folio;
	private String monto;
	private String fecha_factura;
	private String fecha_vencimiento;
	
	public int getIdConciliacion() {
		return idConciliacion;
	}
	public void setIdConciliacion(int idConciliacion) {
		this.idConciliacion = idConciliacion;
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
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getFecha_Factura() {
		return fecha_factura;
	}
	public void setFecha_Factura(String fecha_factura) {
		this.fecha_factura = fecha_factura.substring(0, 11);
	}
	public String getFecha_Vencimiento() {
		return fecha_vencimiento;
	}
	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento.substring(0, 11);
	}
	public String getFecha_factura() {
		return fecha_factura;
	}
	public void setFecha_factura(String fecha_factura) {
		this.fecha_factura = fecha_factura;
	}
	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}
	@Override
	public String toString() {
		return "DetalleFacturadoNoCicloVO [idConciliacion=" + idConciliacion
				+ ", fecha=" + fecha + ", cuenta=" + cuenta + ", empresa="
				+ empresa + ", folio=" + folio + ", monto=" + monto
				+ ", fecha_factura=" + fecha_factura + ", fecha_vencimiento="
				+ fecha_vencimiento + "]";
	}
	public DetalleFacturadoNoCicloVO() {
		
	}
	
	 	

	
	
}
