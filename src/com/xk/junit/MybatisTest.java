package com.xk.junit;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.xk.javabean.User;
import com.xk.util.MybatisUtil;

public class MybatisTest {

	@Test
	public void testAdd() throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisUtil.getSqlSession(true);
		String statement = "sqlmap.addUser";
		User user = new User();
		user.setUsername("ysc");
		user.setPassword("123");
		user.setGrade("1");
		user.setEmail("ysc@126.com");
		
		int result = sqlSession.insert(statement, user);
		System.out.println(user);
	}
	@Test
	public void testDelete() throws IOException {
		SqlSession sqlSession = MybatisUtil.getSqlSession(true);
		String statement = "sqlmap.deleteUser";
		int result = sqlSession.delete(statement, 46);
		sqlSession.close();
		System.out.println(result);
	}
	@Test
	public void testUpdate() throws IOException {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MybatisUtil.getSqlSession(true);
		String statement = "sqlmap.updateUser";
		User user = new User();
		user.setId("50");
		user.setUsername("hive");
		user.setPassword("123");
		user.setGrade("1");
		user.setEmail("hive@126.com");
		int result = sqlSession.update(statement, user);
		sqlSession.close();
		System.out.println(user);
	}
	@Test
	public void testGetAll() throws IOException {
		SqlSession sqlSession = MybatisUtil.getSqlSession(true);
		String statement = "sqlmap.getAllUser";
		List<User> users = sqlSession.selectList(statement);
		sqlSession.close();
		System.out.println(users);
	}
}
