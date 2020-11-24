package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

	// 보안을 위해 파일에서 읽어오는 것도 좋은 방법이다
	final static String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	final static String id = "hr";
	final static String password = "1234";	
	
	// 드라이버 로드는 한번만 하면 되기 때문에 static 블록에 진행
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		}
	}
	
	// 리스트에 커넥션을 미리 생성해두고, 사용중이지 않은 커넥션을 꺼내주기
	List<JdbcConnection> pool;
		
	public ConnectionPool(int size) {	
		pool = new ArrayList<>(size);
		
		for (int i = 0; i < size; ++i)
			pool.add(new JdbcConnection());		
	}
	
	public JdbcConnection getConnection() {
		for (JdbcConnection jconn : pool) {
			if (!jconn.using) {
				jconn.using = true;
				return jconn;
			}
		}		
		System.out.println("전부 사용중입니다.");
		return null;
	}
	
	class JdbcConnection {
		Connection conn;
		boolean using;
		
		public JdbcConnection() {
			try {
				conn = DriverManager.getConnection(url, id, password);
				using = false;				
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		public void close() {
			using = false;
		}
	}	
	
	public static void main(String[] args) {
		ConnectionPool src = new ConnectionPool(3);
		
		JdbcConnection conn1 = src.getConnection();
		System.out.println("conn1 addr : " + conn1);			
		
		JdbcConnection conn2 = src.getConnection();
		System.out.println("conn2 addr : " + conn2);
		
		JdbcConnection conn3 = src.getConnection();
		System.out.println("conn3 addr : " + conn3);
		
		// close를 하면 Connection을 끊는 대신 사용중이지 않은 상태로 변경한다
		conn1.close();
		conn2.close();
		conn3.close();
		
		JdbcConnection conn4 = src.getConnection();
		System.out.println("conn4 addr : " + conn4);
	}
}











