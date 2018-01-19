package mytest;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webApp/WEB-INF/spring/root-context.xml"})
public class DataSourceTest {
	
	@Inject
	private DataSource ds;
	
	@Inject
	private SqlSessionFactory sf;
	
	@Test
	public void testSF() throws Exception{
		System.out.println("*******SqlSessionFactory Inject 성공********" + sf);
	}
	
	@Test
	public void testDS()throws Exception {
/*		try (Connection cn = ds.getConnection()) {
			System.out.println("*******DataSource Connection 성공********");
			System.out.println(cn);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
	}
}
