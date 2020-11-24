package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CUD {

	// # CRUD
	//	- 모든 프로그램은 CRUD가 있다
	
	//	C : Create (INSERT)
	//	R : Read (SELECT)
	//	U : Update (UPDATE)
	//	D : Delete (DELETE)
	
	// JDBC에서 SELECT를 하면 ResultSet이 반환된다
	// 그 외의 INSERT, UPDATE, DELETE는 적용된 행이 반환된다
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XEPDB1",
					"hr",
					"1234"
			);
			
			String sql = "INSERT INTO coffees VALUES (empp_seq.nextval, ?, ?)";
			
			PreparedStatement pstmt = 
					conn.prepareStatement(sql);		
			
			pstmt.setString(1, "카페라떼");
			pstmt.setInt(2, 3200);
			
			// pstmt.executeQuery() 
			//	- ResultSet이 반환될 법한 쿼리(SELECT)를 실행시킬 때 사용한다 
			
			// pstmt.executeUpdate() 
			//	- DML인 INSERT, UPDATE, DELETE 또는 반환되는 값이 없는
			//	  DDL 같은 쿼리문을 실행시킬 때 사용한다 
			int row = pstmt.executeUpdate();
			
			System.out.printf("%d행이 변경되었습니다.\n", row);
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}
}





