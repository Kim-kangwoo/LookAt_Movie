package com.lookat.mybatis;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService {
	
	private static SqlSessionFactory factory;
	
	static {
			try {
				
				factory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsReader("com/lookat/mybatis/config.xml"));
			
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("SqlSession 빌드 실패");
			}
	} 
		
	
	public static SqlSessionFactory getFactory() {
		
		return factory;
	}

}
