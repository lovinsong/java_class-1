import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import java.sql.Date;	// LocalDate
import java.sql.Time;	// LocalTime
import java.sql.Timestamp;	// LocalDateTime

public class F03_Time {

	public static void main(String[] args) {
		
		// # java.time의 시간 객체들은 set이 없다.
		
		// 1. now()를 통해 지금 이 시간의 정보를 가진 인스턴스를 생성하기
		
		// 날짜만 저장
		LocalDate today = LocalDate.now();		
		System.out.println(today);
		
		// 시간만 저장 
		LocalTime now = LocalTime.now();
		System.out.println(now);		
		
		// 날짜와 시간을 저장 
		LocalDateTime datetime = LocalDateTime.now(ZoneId.of("US/Samoa"));		
		System.out.println(datetime);
				
		// 날짜와 시간과 경도를 저장
		ZonedDateTime zoned = ZonedDateTime.now(ZoneId.of("US/Samoa"));
		System.out.println(zoned);		
		
		
		// 2. of()를 이용해서 해당 날짜/시간의 인스턴스를 생성하기 
		LocalDate birthday = LocalDate.of(1994, 11, 25);
		System.out.println(birthday);
		
		LocalTime birthtime = LocalTime.of(5, 5, 5, 1234);
		System.out.println(birthtime);
		
		LocalDateTime birthdatetime = LocalDateTime.of(birthday, birthtime);
		System.out.println(birthdatetime);
		
		ZonedDateTime birthdayzoned = ZonedDateTime.of(
				birthdatetime, 
				ZoneId.of("Asia/Seoul"));
		System.out.println(birthdayzoned);
		
		
		Instant start_time = Instant.now();
		
		System.out.println("start: " + start_time);
		
		Instant end_time = Instant.now();
		
		// Instant클래스는 isAfter, isBefore를 이용해서 시간비교를 할 수 있다
		System.out.println(start_time.isAfter(end_time));
		System.out.println(start_time.isBefore(end_time));
		System.out.println(start_time.until(end_time, ChronoUnit.NANOS));
		
		
		// 날짜/시간 계산하기			
		today = LocalDate.now();
		
		// Calendar 클래스는 생성된 인스턴스 값 자체를 바꿀 수 있었지만, 
		
		// java.time의 클래스들은 해당 인스턴스는 변경되지 않은채로 
		// 인스턴스를 생성하여 반환해준다. (해당 인스턴스에 대한 시간 조작이 불가능하다) 
		System.out.println("오늘 -5년: " + today.minusYears(5));
		System.out.println("오늘 -3개월: " + today.minusMonths(3));
		System.out.println("오늘 -5일: " + today.minusDays(5));
		System.out.println("오늘 -4주: " + today.minusWeeks(4));
		
		System.out.println("오늘 +5년: " + today.plusYears(5));
		System.out.println("오늘 +3개월: " + today.plusMonths(3));
		System.out.println("오늘 +5일: " + today.plusDays(5));
		System.out.println("오늘 +4주: " + today.plusWeeks(4));

		System.out.println("1990년 오늘로 변경: " + today.withYear(1990));
		System.out.println("3월 오늘로 변경: " + today.withMonth(3));
		System.out.println("이번 달의 다섯번째 날로 변경: " + today.withDayOfMonth(5));
		System.out.println("올해의 다섯번째 날로 변경: " + today.withDayOfYear(5));		
		
		
		// 문자열을 날짜/시간 객체로 변환 (파싱, Parsing)
		
		// yyyy-MM-dd가 가장 기본 형태의 날짜 문자열이다
		LocalDate test1 = LocalDate.parse("1234-12-12");		
		System.out.println(test1.plusDays(5));
		
		// DateTimeFormatter.ofPattern()을 이용해 원하는 패턴을 생성할 수 있다
		LocalDateTime test2 = LocalDateTime.parse(
				"2021년 05월 05일 19시 05분 35초", 
				DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
		
		System.out.println(test2);
		
		
		// 이미 유명한 패턴들은 상수로 정의되어 있다
		test2 = LocalDateTime.parse(
				"2011-12-03T10:15:30+01:00",
				DateTimeFormatter.ISO_DATE_TIME
		);
		
		System.out.println(test2.plusHours(5));
		
		
		// # java.time 객체를 문자열로 변환하기
		
		// format() 메서드를 이용한다.
		// 날짜 객체를 문자열 변환할때도 DateTimeFormatter를 사용한다.
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println("BASIC_ISO_DATE: "
				+ zdt.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println("ISO_DATE: " 
				+ zdt.format(DateTimeFormatter.ISO_DATE));
		System.out.println("ISO_ZONED_DATE_TIME: "
				+ zdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
		
		
		// # java.time to java.sql.Date		
		//	- DB에 넣을 때 사용한다 
		LocalDate locald = LocalDate.of(1967, 06, 22);
		Date date = Date.valueOf(locald); // Magic happens here!
		
		java.sql.Time time 
				= java.sql.Time.valueOf(LocalTime.of(3, 44, 30, 9981234));
		java.sql.Timestamp timestamp 
				= java.sql.Timestamp.valueOf(LocalDateTime.of(
							2020,
							11,
							26,
							15,
							45,
							59,
							123456
						));
		
		System.out.println(date);
		System.out.println(time);
		System.out.println(timestamp);
	}
	
}




















