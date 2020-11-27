import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class F02_SimpleDateFormat {

	public static void main(String[] args) {
		
		// 간편하게 날짜/시간을 문자열로 변환하는 방법	
		
		/*
		 	y : 년
		 	M : 월
		 	d : 일
		 	D : 월 구분이 없는 일 (1 ~ 365)
		 	K : 시 (0 ~ 11)
		 	k : 시 (1 ~ 24)
		 	H : 시 (0 ~ 23)
		 	h : 시 (1 ~ 12)		 	
		 	m : 분
		 	s : 초
		 	S : 밀리세컨드(1/1000초)
		 	E : 요일		 	
		 	a : 오전/오후
		 	w : 년의 몇 번째 주
		 	W : 월의 몇 번째 주
		*/
		SimpleDateFormat simple = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		Date now = new Date();
		
		// Calendar 인스턴스는 getTime() 메서드를 이용하면 Date타입으로 변환이 가능하다
		Calendar korea_time = Calendar.getInstance();
		System.out.println(korea_time.getTime());
		
		System.out.println("Date 클래스의 toString() - " + now);
		System.out.println("simple format을 사용 - " 
				+ simple.format(now));
		System.out.println("simple format을 사용 - " 
				+ simple.format(korea_time.getTime()));
		
		
	}
	
}











