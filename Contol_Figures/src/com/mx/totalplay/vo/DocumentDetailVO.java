package com.mx.totalplay.vo;

import java.math.BigDecimal;

public class DocumentDetailVO {
	
private String posicion;
private String clave;
private String hkont;
private String nombrecta;
private BigDecimal importe;
private String moneda;
public String getPosicion() {
	return posicion;
}
public void setPosicion(String posicion) {
	this.posicion = posicion;
}
public String getClave() {
	return clave;
}
public void setClave(String clave) {
	this.clave = clave;
}
public String getHkont() {
	return hkont;
}
public void setHkont(String hkont) {
	this.hkont = hkont;
}
public String getNombrecta() {
	return nombrecta;
}
public void setNombrecta(String nombrecta) {
	this.nombrecta = nombrecta;
}
public BigDecimal getImporte() {
	return importe;
}
public void setImporte(BigDecimal importe) {
	this.importe = importe;
}
public String getMoneda() {
	return moneda;
}
public void setMoneda(String moneda) {
	this.moneda = moneda;
}


}
