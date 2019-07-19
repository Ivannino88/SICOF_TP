package com.mx.totalplay.vo;

public class DetalleAddonsBrmNoU2000VO {
	
	private String fecha;
	private String id_conciliacion;
	private String cuenta;
	private String plan;
	private String addons;
	private String megas;
	private String descr;
	private String ont;
	private String accion;
	private Boolean accion1;
	/*
	private int accion1;

	public int getAccion1() {
		int result = Integer.parseInt(accion);	
		return accion1=result;
	}
	public void setAccion1(int accion1) {
		System.out.println("conversion es= "+accion1);
		this.accion1 = accion1;
	}
*/
		
	public Boolean getAccion1() {
		boolean result;
		if (accion.equals("1")){
			result=true;}
		else{
			result=false;
		}
		return accion1=result;
	}
	public void setAccion1(Boolean accion1) {
		this.accion1 = accion1;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha.substring(0, 11);
	}
	public String getId_conciliacion() {
		return id_conciliacion;
	}
	public void setId_conciliacion(String id_conciliacion) {
		this.id_conciliacion = id_conciliacion;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getAddons() {
		return addons;
	}
	public void setAddons(String addons) {
		this.addons = addons;
	}
	public String getMegas() {
		return megas;
	}
	public void setMegas(String megas) {
		this.megas = megas;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getOnt() {
		return ont;
	}
	public void setOnt(String ont) {
		this.ont = ont;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	
	public DetalleAddonsBrmNoU2000VO() {
		// TODO Auto-generated constructor stub
	}
	public DetalleAddonsBrmNoU2000VO(String fecha, String id_conciliacion,
			String cuenta, String megas, String descr, String ont,
			String accion, Boolean accion1) {
		super();
		this.fecha = fecha;
		this.id_conciliacion = id_conciliacion;
		this.cuenta = cuenta;
		this.megas = megas;
		this.descr = descr;
		this.ont = ont;
		this.accion = accion;
		this.accion1 = accion1;
	}
	
//	public DetalleAddonsBrmNoU2000VO(String cuenta, String megas, String descr,
//			String ont, String accion, Boolean accion1) {
//		super();
//		this.cuenta = cuenta;
//		this.megas = megas;
//		this.descr = descr;
//		this.ont = ont;
//		this.accion = accion;
//		this.accion1 = accion1;
//	}

	
	
	
}
