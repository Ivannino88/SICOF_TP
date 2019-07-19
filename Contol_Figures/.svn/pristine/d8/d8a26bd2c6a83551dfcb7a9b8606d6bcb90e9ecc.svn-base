package com.mx.totalplay.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.mx.totalplay.dao.ControlAccesoDAO;
import com.mx.totalplay.implement.encriptador.Encriptador;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//log.info("***Servlet: doPost()");
		try{
			String cadena=(request.getParameter("cad")!=null)?request.getParameter("cad"):"";//cadena de conexion
			Encriptador asd = new Encriptador();
	    	String cadenaDecodificada =asd.of_DesencriptarAES128(cadena, "CRMWeb");//la cadena que entra y la palabra clable para decodificar
	    	//log.info("Cadena conexion : "+ cadenaDecodificada);
	    	//log.info("Cadena conexion codificada  : "+ cadena);
	    	
	    	HttpSession sesion = request.getSession();
	    	
	    	StringTokenizer tokenCad  = new StringTokenizer(cadenaDecodificada, ",");
	    	boolean flagLogin	=	false;
	    	boolean flagEnlace	=	false;
	    	boolean flagTP		=	false;
	    	String  id			=  	"";
	    	while(tokenCad.hasMoreElements()){
	    		String elementoCad = tokenCad.nextElement().toString();
	    		if(elementoCad.contains("ACCESS_APP")){
	    			flagLogin = true;
	    		}
	    		if(elementoCad.contains("ENLACE")){
	    			flagEnlace = true;
	    		}
	    		if(elementoCad.contains("TOTALPLAY")){
	    			flagTP = true;
	    		}
	    		if(elementoCad.contains("noEmployee:")){
	    			id=elementoCad.substring(11,elementoCad.length());
	    		}
	    	}
	    	//log.info("flagLogin  : "+ flagLogin);
	    	//log.info("userID  : "+ id);
	    	//log.info("Enlace  : "+ flagEnlace);
	    	//log.info("TotalPlay  : "+ flagTP);
	    	
	    	sesion.setAttribute("flagLogin", flagLogin);
	    	sesion.setAttribute("userID", id);
	    	sesion.setAttribute("Enlace", flagEnlace);
	    	sesion.setAttribute("TotalPlay", flagTP);
	    	sesion.setAttribute("validacion", true);
	    	
	    	
	    	Date date = new Date();
	    	DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    	
	    	if(flagLogin){
	    		//log.info("Entrando flagLogin");
	    		try{
	    			ControlAccesoDAO controlaccesodao=new ControlAccesoDAO();
	    			controlaccesodao.getControlAccesoUpdate(id,hourdateFormat.format(date));
	    		}catch(Exception e){
	    			//log.info("problema con actualizacion de ultima conexion: " + e);
	    		}
	    		
	    		RequestDispatcher despachador = getServletContext().getRequestDispatcher("/jsp/home.jsp");
	            despachador.include(request, response);
	            //log.info("home.jsp");
	    	}else{
	    		RequestDispatcher despachador = getServletContext().getRequestDispatcher("/Close.jsp");
		        despachador.include(request, response);	
	    	}
	    	
		}catch(Exception e){
			//log.error("error",e);
		}

	}
	

}
