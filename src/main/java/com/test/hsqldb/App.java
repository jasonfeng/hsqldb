package com.test.hsqldb;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.test.hsqldb.mapper.UserMapper;

/**
 * Hello world!
 *
 */
public class App {
	private static SqlSessionFactory sqlSessionFactory;

	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");// create a SqlSessionFactory
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		reader.close();

		// populate in-memory database
		SqlSession session = sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		reader = Resources.getResourceAsReader("hsqldb.sql");
		ScriptRunner runner = new ScriptRunner(conn);
		runner.setLogWriter(null);
		runner.runScript(reader);
		reader.close();
		session.close();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			User user = mapper.getUser(1);
			System.out.println(user.getName());
		} finally {
			sqlSession.close();
		}
		System.out.println(1111);
	}
	// public static void main(String[] args) {
	// ApplicationContext context = new ClassPathXmlApplicationContext(
	// new String[] { "app-context.xml" });
	// BeanFactory factory = (BeanFactory) context;
	//
	// UserService userService = (UserService) factory.getBean("userService");
	// System.out.println(userService.getUser(1).getName());
	// }
}
