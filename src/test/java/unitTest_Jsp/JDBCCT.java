package unitTest_Jsp;

import java.sql.DriverManager;

import org.junit.Test;

public class JDBCCT {
	
	@Test
	public void getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
            DriverManager.getConnection(url,"system","oracle1");
            System.out.println("===> JDBC Connection ����  ===");
        } catch (Exception e) {
        	 System.out.println("===> JDBC Connection ����  ===");
            e.printStackTrace();
        }
        int i = 2/0;
    } // getConnection()
	
	@Test
	public int sum(int a, int b) {
		return a + b;
	}
}
