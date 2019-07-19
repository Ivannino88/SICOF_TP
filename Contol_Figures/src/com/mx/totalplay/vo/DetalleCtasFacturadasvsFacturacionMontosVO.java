/***
 * @author RicardoM
 * Bean para el reporte  Cuentas Facturadas vs. Facturacion BRM - INTERFACTURA
 */
package com.mx.totalplay.vo;
public class DetalleCtasFacturadasvsFacturacionMontosVO {
	private String id_conciliacion;
	private String fecha_conci;
	private String empresa;
	private String archivo;
	private String account_no;
	private String num_factura;
	private String folio1;
	private String folio2;
	private String folio3;
	private String razon_social;
	private String total1;
	private String total2;
	private String total3;
	private String ciclo;
	private String fecha;
	private String tipo;
	private String error_t;
	private String fecha_i;
	private String rfc;
	private String folio_fiscal;
	private String folio_fiscal2;
	private String folio_fiscal3;
	private String serie1;
	private String rs_facturante1;
	private String serie2;
	private String rs_facturante2;
	private String serie3;
	private String rs_facturante3;
	
	
	public String getId_conciliacion() {
		return id_conciliacion;
	}
	public void setId_conciliacion(String id_conciliacion) {
		this.id_conciliacion = id_conciliacion;
	}
	public String getFecha_conci() {
		return fecha_conci;
	}
	public void setFecha_conci(String fecha_conci) {
		this.fecha_conci = fecha_conci.substring(0, 11);
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getNum_factura() {
		return num_factura;
	}
	public void setNum_factura(String num_factura) {
		this.num_factura = num_factura;
	}
	public String getFolio1() {
		return folio1;
	}
	public void setFolio1(String folio1) {
		this.folio1 = folio1;
	}
	public String getFolio2() {
		return folio2;
	}
	public void setFolio2(String folio2) {
		this.folio2 = folio2;
	}
	public String getFolio3() {
		return folio3;
	}
	public void setFolio3(String folio3) {
		this.folio3 = folio3;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public String getTotal1() {
		return total1;
	}
	public void setTotal1(String total1) {
		this.total1 = total1;
	}
	public String getTotal2() {
		return total2;
	}
	public void setTotal2(String total2) {
		this.total2 = total2;
	}
	public String getTotal3() {
		return total3;
	}
	public void setTotal3(String total3) {
		this.total3 = total3;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getError_t() {
		return error_t;
	}
	public void setError_t(String error_t) {
		this.error_t = error_t;
	}
	public String getFecha_i() {
		return fecha_i;
	}
	public void setFecha_i(String fecha_i) {
		this.fecha_i = fecha_i;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getFolio_fiscal() {
		return folio_fiscal;
	}
	public void setFolio_fiscal(String folio_fiscal) {
		this.folio_fiscal = folio_fiscal;
	}
	public String getFolio_fiscal2() {
		return folio_fiscal2;
	}
	public void setFolio_fiscal2(String folio_fiscal2) {
		this.folio_fiscal2 = folio_fiscal2;
	}
	public String getFolio_fiscal3() {
		return folio_fiscal3;
	}
	public void setFolio_fiscal3(String folio_fiscal3) {
		this.folio_fiscal3 = folio_fiscal3;
	}
	public String getSerie1() {
		return serie1;
	}
	public void setSerie1(String serie1) {
		this.serie1 = serie1;
	}
	public String getRs_facturante1() {
		return rs_facturante1;
	}
	public void setRs_facturante1(String rs_facturante1) {
		this.rs_facturante1 = rs_facturante1;
	}
	public String getSerie2() {
		return serie2;
	}
	public void setSerie2(String serie2) {
		this.serie2 = serie2;
	}
	public String getRs_facturante2() {
		return rs_facturante2;
	}
	public void setRs_facturante2(String rs_facturante2) {
		this.rs_facturante2 = rs_facturante2;
	}
	public String getSerie3() {
		return serie3;
	}
	public void setSerie3(String serie3) {
		this.serie3 = serie3;
	}
	public String getRs_facturante3() {
		return rs_facturante3;
	}
	public void setRs_facturante3(String rs_facturante3) {
		this.rs_facturante3 = rs_facturante3;
	}

	
}
