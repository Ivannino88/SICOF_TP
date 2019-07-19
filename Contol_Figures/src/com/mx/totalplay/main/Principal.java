package com.mx.totalplay.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.rpc.holders.StringHolder;

import com.mx.totalplay.dao.EvaluacionTfeDAO;
import com.mx.totalplay.dao.LimiteDeCreditoDAO;
import com.mx.totalplay.vo.ImplentacionTfeVO;


import functions.rfc.sap.document.sap_com.ZMMES_MOVGERNR;
import functions.rfc.sap.document.sap_com.ZMMWS_MOVSERIESProxy;
import functions.rfc.sap.document.sap_com.holders.ZMMTT_MOVGERNRHolder;



public class Principal {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String usuario="TOTALPLAY";
		String pw="enlace=15";
		String fecha1="20190415";
		String fecha2="20190416";
		StringHolder mensaje = new StringHolder();
		ZMMTT_MOVGERNRHolder series = new ZMMTT_MOVGERNRHolder();
		
		ZMMWS_MOVSERIESProxy m6 = new ZMMWS_MOVSERIESProxy();
		
		m6.ZMMMF_MOVSERIES(fecha1, fecha2, mensaje, series);
		
		System.out.println(mensaje.value);
		System.out.println("series totales: "+series.value.length);
		
		for (ZMMES_MOVGERNR x : series.value) {
			System.out.println(x.getNUMERO_DE_SERIE());
		}
	
	
//		System.out.println("Principal.main()");
//		ImplentacionTfeVO implementaTfe = new ImplentacionTfeVO();
//		Map<String, String> mapa= new HashMap<String, String>();
//		mapa.put("A","cuenta");
//		mapa.put("B","plan");
//		mapa.put("C","estatus");
//		try {
//			BigExcelReader.processAllSheets("C:/demo/allBDV1.xlsx", mapa, implementaTfe);
//			System.out.println("todo ok..");
//		} catch (Exception e) {
//			// TODO: handle exception 
//			e.printStackTrace();
//		}
		
//		EvaluacionTfeDAO consulta = new EvaluacionTfeDAO();
//        consulta.consultaImplementacion();
//		
		}
}
