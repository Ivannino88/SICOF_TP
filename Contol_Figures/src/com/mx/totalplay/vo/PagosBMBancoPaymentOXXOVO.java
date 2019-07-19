package com.mx.totalplay.vo;

public class PagosBMBancoPaymentOXXOVO {

	String id;
	String account;
	String amount;
	String date_payment;
	String status;
	String hora;
	String plaza;
	String tienda;
	String folio;
	String authorizationcode;
	String ticket;
	String file_name;
	String number_line;
	String file_line;
	String date_insert;
	String date_update_last;
	String negocio;
	String cr_pyt;
	String id_conciliacion;


	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDate_payment() {
		return date_payment;
	}
	public void setDate_payment(String date_payment) {
		this.date_payment = date_payment.substring(0, 11);
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getPlaza() {
		return plaza;
	}
	public void setPlaza(String plaza) {
		this.plaza = plaza;
	}
	public String getTienda() {
		return tienda;
	}
	public void setTienda(String tienda) {
		this.tienda = tienda;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getAuthorizationcode() {
		return authorizationcode;
	}
	public void setAuthorizationcode(String authorizationcode) {
		this.authorizationcode = authorizationcode;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getNumber_line() {
		return number_line;
	}
	public void setNumber_line(String number_line) {
		this.number_line = number_line;
	}
	public String getFile_line() {
		return file_line;
	}
	public void setFile_line(String file_line) {
		this.file_line = file_line;
	}
	public String getDate_insert() {
		return date_insert;
	}
	public void setDate_insert(String date_insert) {
		this.date_insert = date_insert;
	}
	public String getDate_update_last() {
		return date_update_last;
	}
	public void setDate_update_last(String date_update_last) {
		this.date_update_last = date_update_last;
	}
	public String getNegocio() {
		return negocio;
	}
	public void setNegocio(String negocio) {
		this.negocio = negocio;
	}
	public String getCr_pyt() {
		return cr_pyt;
	}
	public void setCr_pyt(String cr_pyt) {
		this.cr_pyt = cr_pyt;
	}
	public String getId_conciliacion() {
		return id_conciliacion;
	}
	public void setId_conciliacion(String id_conciliacion) {
		this.id_conciliacion = id_conciliacion;
	}

}
