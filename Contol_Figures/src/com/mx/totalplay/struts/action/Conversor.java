package com.mx.totalplay.struts.action;

public class Conversor {
	String fecha_esp;
	String nueva_fecha;
	String mes;
	public String conversor(String cadena){
		// System.out.println(cadena);
		fecha_esp=cadena.charAt(3)+""+cadena.charAt(4)+""+cadena.charAt(5)+"";
		fecha_esp=fecha_esp.toUpperCase();
	//	System.out.println(fecha_esp);
		if("ENE".equals(fecha_esp)||"JAN".equals(fecha_esp))
			mes="01";
		if("FEB".equals(fecha_esp)||"FEB".equals(fecha_esp))
			mes="02";
		if("MAR".equals(fecha_esp)||"MAR".equals(fecha_esp))
			mes="03";
		if("ABR".equals(fecha_esp)||"APR".equals(fecha_esp))
			mes="04";
		if("MAY".equals(fecha_esp)||"MAY".equals(fecha_esp))
			mes="05";
		if("JUN".equals(fecha_esp)||"JUN".equals(fecha_esp))
			mes="06";
		if("JUL".equals(fecha_esp)||"JUL".equals(fecha_esp))
			mes="07";
		if("AGO".equals(fecha_esp)||"AUG".equals(fecha_esp))
			mes="08";
		if("SEP".equals(fecha_esp)||"SEP".equals(fecha_esp))
			mes="09";
		if("OCT".equals(fecha_esp)||"OCT".equals(fecha_esp))
			mes="10";
		if("NOV".equals(fecha_esp)||"NOV".equals(fecha_esp))
			mes="11";
		if("DIC".equals(fecha_esp)||"DEC".equals(fecha_esp))
			mes="12";
		nueva_fecha=cadena.charAt(0)+""+cadena.charAt(1)+"/"+mes+"/"+cadena.charAt(8)+""+
				cadena.charAt(9)+""+cadena.charAt(10)+""+cadena.charAt(11);
		//System.out.println(nueva_fecha);
		return nueva_fecha;
		
	}

}
