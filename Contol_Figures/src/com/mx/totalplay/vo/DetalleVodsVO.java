package com.mx.totalplay.vo;

public class DetalleVodsVO {
	
	private String fecha;
	private String id_conciliacion;
	private String account;
	private String usuario;
	private String serie;
	private String titulo;
	private String categoria;
	private String calidad;
	private String precio;
	private String fecha_pe;
	private String hora;
	private String numero_parte;
	private String date_insert;
	private String date_last_update;
	private String status;
	private String login;
	private String vpu_id;
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCalida() {
		return calidad;
	}
	public void setCalida(String calidad) {
		this.calidad = calidad;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getFecha_pe() {
		return fecha_pe;
	}
	public void setFecha_pe(String fecha_pe) {
		this.fecha_pe = fecha_pe;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getNumero_parte() {
		return numero_parte;
	}
	public void setNumero_parte(String numero_parte) {
		this.numero_parte = numero_parte;
	}
	public String getDate_insert() {
		return date_insert;
	}
	public void setDate_insert(String date_insert) {
		this.date_insert = date_insert.substring(0, 11);
	}
	public String getDate_last_update() {
		return date_last_update;
	}
	public void setDate_last_update(String date_last_update) {
		this.date_last_update = date_last_update.substring(0, 11);
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getVpu_id() {
		return vpu_id;
	}
	public void setVpu_id(String vpu_id) {
		this.vpu_id = vpu_id;
	}
	
	

}
