package com.xk.util;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	public static SqlSessionFactory getSqlSessionFactory() throws IOException{
		
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		return sqlSessionFactory;
	}
	public static SqlSession getSqlSession() throws IOException{
		return getSqlSessionFactory().openSession();
	}
	//true 表示创建的SqlSession对象在执行完SQL之后会自动提交事务
	//false 表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.commit（）提交事务
	public static SqlSession getSqlSession(boolean autoCommit) throws IOException {
		return getSqlSessionFactory().openSession(autoCommit);
	}
}
