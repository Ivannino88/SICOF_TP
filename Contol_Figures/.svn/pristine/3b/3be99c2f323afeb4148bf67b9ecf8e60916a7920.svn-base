package com.mx.totalplay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import com.mx.totalplay.vo.ServiceResponse;

public class QueryDAO {
	
	private static final Logger logger = Logger.getLogger(QueryDAO.class);
	private DataSource ds;
	
	public QueryDAO(){
		ds=null;
		try{
				Context ctx=new InitialContext();
				ds=(DataSource) ctx.lookup("java:comp/env/jdbc/CICONUSR_DS");
		}
		catch(NamingException e){
			//e.printStackTrace();
		}
	}
	ArrayList<String> columNames = new ArrayList<String>();
	ArrayList<String> datos = new ArrayList<String>();
	
		public ServiceResponse getQuery(String cadena){
			Connection con = null;
			ServiceResponse response = new ServiceResponse();				
			try {
				con=ds.getConnection();
				
				//logger.info("conexion ok..");
				//logger.info("cadena " + cadena);
				PreparedStatement ps = con.prepareStatement(cadena);
				ResultSet rs= ps.executeQuery();
				//logger.info("ps: " + ps);
			
				
				int count=0;
				
				if (rs!=null) {
		        	ResultSetMetaData rsmd =rs.getMetaData();
		        	//logger.info("rsmd: " + rsmd);
		        	int x=0;
		        	while (x<rsmd.getColumnCount()) {
		        		x++;		        		
		        		columNames.add(rsmd.getColumnName(x));
		        		
					}
		        	//logger.info("\n");
		        	//logger.info("columNames: " + columNames);
		        	
		        	
		        	
			        // Visualizar todos los datos de la tabla.
			        while (rs.next()) {
			        	++count;
			        	for (int i = 0; i <columNames.size(); i++) {
			        		//logger.info(rs.getString(columNames.get(i))+"\t");
			        		datos.add(rs.getString(columNames.get(i)) );
							}
						}
			    	}//--FIN DE IF--
					//logger.info("columDatos: " + datos);
					//logger.info("rows: " + count);
					
					
					response.setResult(columNames);
					response.setResult2(datos);
					response.setResult3(count);
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
				
			
			return response;
		}

}
