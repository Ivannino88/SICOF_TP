package com.mx.totalplay.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.mx.totalplay.vo.ServiceResponse;

public class InsertDAO {
	
	private static final Logger logger = Logger.getLogger(InsertDAO.class);
	private DataSource ds;
	public InsertDAO(){
		ds=null;
		try{
				Context ctx=new InitialContext();
				ds=(DataSource) ctx.lookup("java:comp/env/jdbc/CICONUSR_DS");
		}
		catch(NamingException e){
			//e.printStackTrace();
		}
	}
		public ServiceResponse getQuery(String cadena){
			
			//logger.info("InsertDAO");
			ServiceResponse response = new ServiceResponse();		
			Connection con = null;
									
			try {
				con=ds.getConnection();				
				//logger.info("cadena " + cadena);		
				PreparedStatement ps = con.prepareStatement(cadena);
				ps.executeUpdate();
				con.commit();
				//logger.info("ps " + ps);	
				
				response.setResult(ps);					
				response.setSuccess(true);
				
				if(ps!=null)
					ps.close();
				}
			   catch(SQLException e){
					//e.printStackTrace();
					
			   }finally{
				   
					try{
						if(con!=null)
						con.close();
					}catch(SQLException e){
						//e.printStackTrace();
					}
			   }
			//logger.info("response: " + response);
			return response;
		}

}
