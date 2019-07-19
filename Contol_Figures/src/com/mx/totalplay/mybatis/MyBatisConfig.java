package com.mx.totalplay.mybatis;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {

	String resource = "mybatis.config.xml";
	SqlSessionFactory sqlSessionFactory = null;
	
	
	
	public SqlSessionFactory conexionMybatis() throws IOException{
		java.io.Reader reader = org.apache.ibatis.io.Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader,"mybatis");
		
		reader.close();
		return sqlSessionFactory;
	}	
	
	public SqlSessionFactory conexionMybatis2() throws IOException{
		java.io.Reader reader = org.apache.ibatis.io.Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader,"mybatis2");
		reader.close();
		return sqlSessionFactory;
	}
}
