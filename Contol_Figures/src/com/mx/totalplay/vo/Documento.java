package com.mx.totalplay.vo;

public class Documento {
	private String cuenta;
	private String tipoDoc;
	private Double monto;
	private String folioFiscal;
	private String id;
	
	public Documento (){}
	
	

	@Override
	public String toString() {
		return "Documento [cuenta=" + cuenta + ", tipoDoc=" + tipoDoc
				+ ", monto=" + monto + ", folioFiscal=" + folioFiscal + ", id="
				+ id + "]";
	}



	public String getCuenta() {
		return cuenta;
	}



	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}



	public String getTipoDoc() {
		return tipoDoc;
	}



	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}



	public Double getMonto() {
		return monto;
	}



	public void setMonto(Double monto) {
		this.monto = monto;
	}



	public String getFolioFiscal() {
		return folioFiscal;
	}



	public void setFolioFiscal(String folioFiscal) {
		this.folioFiscal = folioFiscal;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

	
	

	
}
