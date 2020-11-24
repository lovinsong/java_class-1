package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ResultSetMetaDataTest {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XEPDB1",
					"hr",
					"1234"
			);
			
			String sql = "SELECT * FROM employees INNER JOIN departments"
					+ " USING(department_id)";
			
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);		
		
			ResultSet rs = pstmt.executeQuery();	
			
			// 쿼리문으로 가져온 ResultSet에 대한 정보 목록 객체
			ResultSetMetaData rsmd = rs.getMetaData();
			
			
			
			System.out.println("컬럼 개수 : " + rsmd.getColumnCount());
			
			for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
				System.out.println(i + "번째 컬럼 정보:");				
				System.out.println("\t컬럼 이름 : " + rsmd.getColumnName(i));
				System.out.println("\t컬럼 타입 이름 : " + rsmd.getColumnTypeName(i));
				System.out.print("\t컬럼 타입 번호 : " + rsmd.getColumnType(i));				
				
				switch (rsmd.getColumnType(i)) {
				case java.sql.Types.VARCHAR:
					System.out.println(" (varchar2)");
					break;
				case java.sql.Types.NUMERIC:
					System.out.println(" (number)");
					break;
				case java.sql.Types.DATE:
					System.out.println(" (date)");
					break;
				case java.sql.Types.TIMESTAMP:
					System.out.println(" (timestamp)");
					break;
				default:
					System.out.println(" (i don't know)");
					break;
				}
				
				System.out.println("\t컬럼 크기 : " + rsmd.getColumnDisplaySize(i));				
			}
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}
	
}




