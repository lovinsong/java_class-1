package jdbc.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class GenerateRandomCar {

	//	차량 번호판 정보
	//	https://post.naver.com/viewer/postView.nhn?volumeNo=24171702&memberNo=35787715 
	
	// 	랜덤 값을 가진 자동차들이 100대 생성되어 DB에 저장되는 프로그램을 만들어보세요 
	
	//  차량 번호판 
	//		01 ~ 69 : 승용차 / 
	//  	70 ~ 79 : 승합차 /
	// 		80 ~ 97 : 화물차 / 
	//		98 ~ 99 : 특수차(버스,택시,택배 등등)
	//	중간 한글 분류	
	// 	 - 자가용 : 가나다라마거너더러머버서어저고노도로모보소오조구누두루무부수우주 (PRIVATE)
	// 	 - 일반용(택시와 같은 영업차량) : 아바사자 (BUSINESS)
	// 	 - 대여사업용(렌터카) : 허하호 (RENTAL) 
	//  0100~9999 랜덤	
	
	// 	차량번호판 정보 - 사이트 참조 
	// 	번호를 랜덤 생성한 뒤에 번호에 따라 결정되는 것들 적용하여
	// 	차량객체를 생성한 후 DB에 알맞게 저장해보세요
	
	// 	※ JAVA코드와 DB스크린샷을 보여주시면 됩니다
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");		
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XEPDB1",
					"hr",
					"1234"
			);
			PreparedStatement pstmt = 
					conn.prepareStatement("INSERT INTO random_car_table"
							+ " VALUES(?, ?, ?)");
			
			// Batch : 일괄처리 
			for (int i = 0; i < 100; ++i) {
				Car car = Car.ran();
				pstmt.setString(1, car.getPlateNumber());
				pstmt.setString(2, car.getCtype());
				pstmt.setString(3, car.getUsage());				
				pstmt.addBatch();
				// int row = pstmt.executeUpdate();
				// System.out.println(row + "행이 업데이트 되었습니다.");
			}
			// 모았다가 한번에 executeBatch()하면 각 쿼리의 실행결과가 배열로 반환된다
			int[] rows = pstmt.executeBatch();			
			System.out.println(Arrays.toString(rows));
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		
			System.out.println("성공");
		} catch (SQLException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {			
			System.out.println("[ojdbc] 클래스 경로가 틀렸습니다.");
		}
	}
}








