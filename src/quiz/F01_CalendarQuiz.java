package quiz;

import java.sql.*;
import java.time.LocalTime;
import java.util.Calendar;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class F01_CalendarQuiz {
	
	// DB에 저장되어 있는 차량정보를 조회해서 차량 5부제를 적용해보세요
	
	// 오늘 출입 제한인 차량의 대수와	
	// 출입 제한을 위반한 차량의 모든 정보를 출력해보세요  
	
	public static void main(String[] args) {		
		HikariConfig config = new HikariConfig("some/path/hikari.properties");
		HikariDataSource ds = new HikariDataSource(config);
		
		
		try {
			Connection conn = ds.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(
				"SELECT * FROM random_car_table WHERE REGEXP_LIKE(car_plate, ?)"
			);
			
			pstmt.setString(1, getTodaysRegExp());			
			
			ResultSet rs = pstmt.executeQuery();
			
			int count = 0;
			System.out.println("번호판\t\t종류\t용도\t위반여부");
			System.out.println("-----------------------------------------");
			while (rs.next()) {
				System.out.printf("%s\t%s\t%s\t위반\n", 
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3));
				++count;
			}
			System.out.printf("오늘의 위반 차량은 총 %d대 입니다.\n", count);
						
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}			
	}
	
	private static String getTodaysRegExp() {
		Calendar c = Calendar.getInstance();
		
		switch (c.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.MONDAY:
			return ".*1$|6$";
		case Calendar.TUESDAY:
			return ".*2$|7$";
		case Calendar.WEDNESDAY:
			return ".*3$|8$";
		case Calendar.THURSDAY:
			return ".*4$|9$";
		default:
			return ".*";
		}
	}
}

















