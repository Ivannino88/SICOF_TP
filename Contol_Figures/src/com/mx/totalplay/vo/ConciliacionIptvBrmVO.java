package com.mx.totalplay.vo;

import java.sql.Date;

public class ConciliacionIptvBrmVO {	

	private int Id;
    private Date Fecha;
    private int No_Iptv;
    private int No_Brm;
    private int T_Conciliados;
    private int Error_Total;
    private int Error_Iptv;
    private int Error_Brm;
    private int Total;
    private String Status;
    private String Empresa;
    private int Tipo_Conciliacion;
    
    
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public int getNo_Iptv() {
		return No_Iptv;
	}
	public void setNo_Iptv(int no_Iptv) {
		No_Iptv = no_Iptv;
	}
	public int getNo_Brm() {
		return No_Brm;
	}
	public void setNo_Brm(int no_Brm) {
		No_Brm = no_Brm;
	}
	public int getT_Conciliados() {
		return T_Conciliados;
	}
	public void setT_Conciliados(int t_Conciliados) {
		T_Conciliados = t_Conciliados;
	}
	public int getError_Total() {
		return Error_Total;
	}
	public void setError_Total(int error_Total) {
		Error_Total = error_Total;
	}
	public int getError_Iptv() {
		return Error_Iptv;
	}
	public void setError_Iptv(int error_Iptv) {
		Error_Iptv = error_Iptv;
	}
	public int getError_Brm() {
		return Error_Brm;
	}
	public void setError_Brm(int error_Brm) {
		Error_Brm = error_Brm;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getEmpresa() {
		return Empresa;
	}
	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}
	public int getTipo_Conciliacion() {
		return Tipo_Conciliacion;
	}
	public void setTipo_Conciliacion(int tipo_Conciliacion) {
		Tipo_Conciliacion = tipo_Conciliacion;
	}
    
    
    
}
