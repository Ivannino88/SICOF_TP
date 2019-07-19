package com.mx.totalplay.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LimiteDeCreditoVO {

	private String cuenta;
	private String paquete;
	private String consumos_addons;
	private String renta_paquete;
	private String limite;
	private String porcentaje;
	private Date   fecha_activacion;
	private Date   fecha_entrada;
	private String saldo;
	private String status;
	private String ciclo;
	private Date   ultima_factura;
	private String estatusCuenta;
	
	// conversion de fechas
	private String Nueva_fecha_activa;
	private String Nueva_fecha_entrada;
	private String Nueva_ultima_factura;
	
	// metodos de conversion de fechas para fecha corta
	public String getNueva_fecha_activa() {
		SimpleDateFormat nfa = new SimpleDateFormat("dd/MM/yyyy");
		return Nueva_fecha_activa=nfa.format(fecha_activacion);
	}
	public void setNueva_fecha_activa(String nueva_fecha_activa) {
		Nueva_fecha_activa = nueva_fecha_activa;
	}
	public String getNueva_fecha_entrada() {
		SimpleDateFormat nfe = new SimpleDateFormat("dd/MM/yyyy");
		return Nueva_fecha_entrada=nfe.format(fecha_entrada);
	}
	public void setNueva_fecha_entrada(String nueva_fecha_entrada) {
		Nueva_fecha_entrada = nueva_fecha_entrada;
	}
	public String getNueva_ultima_factura() {
		SimpleDateFormat nuf = new SimpleDateFormat("dd/MM/yyyy");
		return Nueva_ultima_factura=nuf.format(ultima_factura);
	}
	public void setNueva_ultima_factura(String nueva_ultima_factura) {
		Nueva_ultima_factura = nueva_ultima_factura;
	}
	
	
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getPaquete() {
		return paquete;
	}
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
	public String getConsumos_addons() {
		return consumos_addons;
	}
	public void setConsumos_addons(String consumos_addons) {
		this.consumos_addons = consumos_addons;
	}
	public String getRenta_paquete() {
		return renta_paquete;
	}
	public void setRenta_paquete(String renta_paquete) {
		this.renta_paquete = renta_paquete;
	}
	public String getLimite() {
		return limite;
	}
	public void setLimite(String limite) {
		this.limite = limite;
	}
	public String getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Date getFecha_activacion() {
		return fecha_activacion;
	}
	public void setFecha_activacion(Date fecha_activacion) {
		this.fecha_activacion = fecha_activacion;
	}
	public Date getFecha_entrada() {
		return fecha_entrada;
	}
	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public Date getUltima_factura() {
		return ultima_factura;
	}
	public void setUltima_factura(Date ultima_factura) {
		this.ultima_factura = ultima_factura;
	}
	public String getEstatusCuenta() {
		return estatusCuenta;
	}
	public void setEstatusCuenta(String estatusCuenta) {
		this.estatusCuenta = estatusCuenta;
	}
}
