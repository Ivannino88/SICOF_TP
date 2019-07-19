package com.mx.totalplay.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mx.totalplay.mybatis.MyBatisConfig;
import com.mx.totalplay.vo.ServiceResponse;

public class XdemoDAO {
	
	Vector<String> columNames = new Vector<String>();
	MyBatisConfig conexion = new MyBatisConfig();
	SqlSessionFactory sqlSessionFactory = null;
	
	
		@SuppressWarnings("unused")
		public ServiceResponse valuarCadenaDao(String cadena){
			
			ServiceResponse response = new ServiceResponse();
			SqlSessionFactory statement = null;
			Connection conexion = null;
			try {
				conexion = DriverManager.getConnection("mybatis.config.xml");
				statement = (SqlSessionFactory) conexion.createStatement();
		    	
				PreparedStatement ps = null;
		        ps = conexion.prepareStatement(cadena);
		
		        // Se ejecuta una consulta SQL en la tabla.
		        ResultSet rs = ps.executeQuery();
		        
		        if (rs!=null) {
		        	ResultSetMetaData rsmd =rs.getMetaData();
		        	int x=0;
		        	while (x<rsmd.getColumnCount()) {
		        		x++;
					}			
		       
			        // Visualizar todos los datos de la tabla.
			        while (rs.next()) {
			        	for (int i = 0; i <columNames.size(); i++) {
							}
						}
			    	}//--FIN DE IF--
		        if(ps!=null)
					ps.close();
			   }catch (SQLException sqle) {
			   }finally{
			    	
		       try {
		    	   if(conexion!=null)
					conexion.close();
			   } catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
			   }
		    }
			return response;
		}
		
}

