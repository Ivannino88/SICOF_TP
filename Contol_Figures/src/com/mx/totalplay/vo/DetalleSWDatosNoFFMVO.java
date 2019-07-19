package com.mx.totalplay.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DetalleSWDatosNoFFMVO {


	private Date fecha;
	private String id_conciliacion;
	private String cuentas_ffm;
	private String splitter_ffm;
	private String puerto_asignado_ffm;
	private String candado_ffm;
	private Date fecha_modificacion_ffm;
	
	private String cuentas_sw;
	private String splitter_sw;
	private String puerto_asignado_sw;
	private String candado_sw;
	private Date fecha_modificacion_sw;
	
	// conversion de fecha
			private String fechaShortSw;
			private String fecha_modificacionShortSw;
			private String fecha_modificacion_ffmShort;
			
			
			public String getFecha_modificacion_ffmShort() {
				SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
				return fecha_modificacion_ffmShort=ff.format(fecha_modificacion_ffm);
			}
			public void setFecha_modificacion_ffmShort(String fecha_modificacion_ffmShort) {
				this.fecha_modificacion_ffmShort = fecha_modificacion_ffmShort;
			}
			
			public String getFechaShortSw() {
				SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
				return fechaShortSw=ff.format(fecha);
			}
			public void setFechaShortSw(String fechaShortSw) {
				this.fechaShortSw = fechaShortSw;
			}
			
			public String getFecha_modificacionShortSw() {
				SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
				return fecha_modificacionShortSw=ff.format(fecha_modificacion_sw);
			}
			public void setFecha_modificacionShortSw(String fecha_modificacionShortSw) {
				this.fecha_modificacionShortSw = fecha_modificacionShortSw;
			}
			
			

	public Date getFecha() {
				return fecha;
			}
	
	public void setFecha(Date fecha) {
				this.fecha = fecha;
			}
	public Date getFecha_modificacion_sw() {
				return fecha_modificacion_sw;
			}
	public void setFecha_modificacion_sw(Date fecha_modificacion_sw) {
				this.fecha_modificacion_sw = fecha_modificacion_sw;
			}
	
	public String getId_conciliacion() {
		return id_conciliacion;
	}
	public void setId_conciliacion(String id_conciliacion) {
		this.id_conciliacion = id_conciliacion;
	}
	public String getCuentas_ffm() {
		return cuentas_ffm;
	}
	public void setCuentas_ffm(String cuentas_ffm) {
		this.cuentas_ffm = cuentas_ffm;
	}
	public String getSplitter_ffm() {
		return splitter_ffm;
	}
	public void setSplitter_ffm(String splitter_ffm) {
		this.splitter_ffm = splitter_ffm;
	}
	public String getPuerto_asignado_ffm() {
		return puerto_asignado_ffm;
	}
	public void setPuerto_asignado_ffm(String puerto_asignado_ffm) {
		this.puerto_asignado_ffm = puerto_asignado_ffm;
	}
	public String getCandado_ffm() {
		return candado_ffm;
	}
	public void setCandado_ffm(String candado_ffm) {
		this.candado_ffm = candado_ffm;
	}
	public Date getFecha_modificacion_ffm() {
		return fecha_modificacion_ffm;
	}
	public void setFecha_modificacion_ffm(Date fecha_modificacion_ffm) {
		this.fecha_modificacion_ffm = fecha_modificacion_ffm;
	}

	public String getCuentas_sw() {
		return cuentas_sw;
	}
	public void setCuentas_sw(String cuentas_sw) {
		this.cuentas_sw = cuentas_sw;
	}
	public String getSplitter_sw() {
		return splitter_sw;
	}
	public void setSplitter_sw(String splitter_sw) {
		this.splitter_sw = splitter_sw;
	}
	public String getPuerto_asignado_sw() {
		return puerto_asignado_sw;
	}
	public void setPuerto_asignado_sw(String puerto_asignado_sw) {
		this.puerto_asignado_sw = puerto_asignado_sw;
	}
	public String getCandado_sw() {
		return candado_sw;
	}
	public void setCandado_sw(String candado_sw) {
		this.candado_sw = candado_sw;
	}
	
	

}
