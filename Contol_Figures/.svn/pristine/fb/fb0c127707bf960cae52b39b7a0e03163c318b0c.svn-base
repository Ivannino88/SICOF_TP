<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.io.FileInputStream;"%>

<%
         response.setContentType("application/vnd.ms-excel");
         FileInputStream archivo=null;
         ServletOutputStream ouputStream=null;
         
        try{
        archivo = new FileInputStream("/u01/crm/cifrasControl.log");
        int longitud = archivo.available();
        byte[] datos = new byte[longitud];
        archivo.read(datos);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment;filename=cifrasControl.log") ;
        ouputStream = response.getOutputStream();
        ouputStream.write(datos);
        ouputStream.flush();
        }catch(Exception e){ 
        e.printStackTrace(); 
        } 
        finally{
        if (archivo!=null) 
        archivo.close();
        if (ouputStream!=null) 
        ouputStream.close();
        }
     %>  