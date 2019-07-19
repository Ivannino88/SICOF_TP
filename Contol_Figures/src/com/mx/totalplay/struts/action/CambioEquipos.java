package com.mx.totalplay.struts.action;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.rpc.holders.StringHolder;

import com.opensymphony.xwork2.conversion.impl.DateConverter;

import functions.rfc.sap.document.sap_com.ZMMES_MOVGERNR;
import functions.rfc.sap.document.sap_com.ZMMWS_MOVSERIESProxy;
import functions.rfc.sap.document.sap_com.holders.ZMMTT_MOVGERNRHolder;

public class CambioEquipos  extends CifrasControlAction{
	String fecha;
	
	@SuppressWarnings({ "unchecked", "deprecation", "static-access" })
	public String getCambioEquiposSap() throws ParseException{
		
		String fechaEnter="";
		String fechaEnter2="";
		Date fechajava= new Date(getFecha());
		Date fechajava2 = new Date(getFecha());

		fechajava.parse(getFecha());
		fechajava2.parse(getFecha());
		System.out.println("fecha java :: "+fechajava);


		SimpleDateFormat fecha = new SimpleDateFormat("yyyyMMdd");
		fechaEnter=fecha.format(fechajava);
		System.out.println("FECHA #1 --->  "+ fechaEnter);

		Calendar calendario = Calendar.getInstance();
		calendario.setTime (fechajava2); // convert your date to Calendar object
		int daysToDecrement = -1;
		calendario.add(Calendar.DATE, daysToDecrement);
		fechajava2 = calendario.getTime(); // again get back your date object

		SimpleDateFormat fecha2 = new SimpleDateFormat("yyyyMMdd");
		fechaEnter2=fecha.format(fechajava2);
		System.out.println("FECHA #2 ---> "+ fechaEnter2);
			
			 

		String usuario="TOTALPLAY";
		String pw="enlace=15";
//		String fecha1="20190415";
//		String fecha2="20190416";
		StringHolder mensaje = new StringHolder();
		ZMMTT_MOVGERNRHolder series = new ZMMTT_MOVGERNRHolder();
		ZMMWS_MOVSERIESProxy m6 = new ZMMWS_MOVSERIESProxy();
		
		try {
			m6.ZMMMF_MOVSERIES(fechaEnter, fechaEnter2, mensaje, series);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mensaje.value);
		System.out.println("series totales: "+series.value.length);
		
		for (ZMMES_MOVGERNR x : series.value) {
			System.out.println(x.getNUMERO_DE_SERIE());
		}
		
		return null;
	}

	
	
	

	
	@SuppressWarnings({ "deprecation", "static-access", "unused" })
	public  void conversionFecha(){
		
		System.out.println("CambioEquipos.conversionFecha()");
		String fechaEnter="";
		String fechaEnter2="";
		Date fechajava= new Date(getFecha());
		Date fechajava2 = new Date(getFecha());
		
		fechajava.parse(getFecha());
		fechajava2.parse(getFecha());
	   System.out.println("fecha java :: "+fechajava);
	   
	   
		SimpleDateFormat fecha = new SimpleDateFormat("yyyyMMdd");
		 fechaEnter=fecha.format(fechajava);
		 System.out.println("FECHA #1 --->  "+ fechaEnter);
		 
		 
		    Calendar calendario = Calendar.getInstance();
			calendario.setTime (fechajava2); // convert your date to Calendar object
			int daysToDecrement = -1;
			calendario.add(Calendar.DATE, daysToDecrement);
			fechajava2 = calendario.getTime(); // again get back your date object
			System.out.println("----- fecha --"+fechajava2);
			
			SimpleDateFormat fecha2 = new SimpleDateFormat("yyyyMMdd");
			 fechaEnter2=fecha.format(fechajava2);
			 System.out.println("FECHA #2 ---> "+ fechaEnter2);
			
			 fechasOk(fechaEnter, fechaEnter2);
			 
//			return null; 
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public String fechaEnter(){
		String fechaEnter;
		Date fechajava= new Date(getFecha());
		fechajava.parse(getFecha());
//		System.out.println("fecha java :: "+fechajava);
		SimpleDateFormat fecha = new SimpleDateFormat("yyyyMMdd");
		fechaEnter=fecha.format(fechajava);
//		System.out.println("FECHA #1 --->  "+ fechaEnter);
		return fechaEnter;
	}
	
	@SuppressWarnings({ "static-access", "deprecation" })
	public String fechaMns1(){
		String fechaEnter2;
		Date fechajava2 = new Date(getFecha());
		fechajava2.parse(getFecha());
		Calendar calendario = Calendar.getInstance();
		calendario.setTime (fechajava2); // convert your date to Calendar object
		int daysToDecrement = -1;
		calendario.add(Calendar.DATE, daysToDecrement);
		fechajava2 = calendario.getTime(); // again get back your date object
//		System.out.println("----- fecha --"+fechajava2);
		SimpleDateFormat fecha2 = new SimpleDateFormat("yyyyMMdd");
		fechaEnter2=fecha2.format(fechajava2);
//		System.out.println("FECHA #2 ---> "+ fechaEnter2);
		return fechaEnter2;
	}
	
	public String [] fechasOk(String fecha1, String fecha2){
		System.out.println("CambioEquipos.fechasOk()");
		 String[] fecha= new String[2];
	      fecha[0]=fecha1;
	      fecha[1]=fecha2;
		return fecha;
	}
	
	public String getFecha() {  return fecha; 	}
	public void setFecha(String fecha) {  this.fecha = fecha; }
	
	public List<ZMMES_MOVGERNR> getCambioEquiposSap1 (){
		List<ZMMES_MOVGERNR> listaSapSeries = new ArrayList<ZMMES_MOVGERNR>();
		return null;
	}
	
//	public String getFecha() {  	return fecha; }
//	public void setFecha(String fecha) { 
//		Conversor conversion = new Conversor();
//		this.fecha = conversion.conversor(fecha); }
}
