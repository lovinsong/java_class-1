package quiz;

public class B03_charQuiz {

	/*
    	[ 알맞은 조건식을 만들어보세요 ]
    
		1. char형 변수 a가 'q'또는 'Q'일 때 true
	   	2. char형 변수 b가 공백이나 탭이 아닐 때 true
		3. char형 변수 c가 문자('0' ~ '9')일 때 true
		4. char형 변수 d가 영문자(대문자 또는 소문자)일 때 true
		5. char형 변수 e가 한글일 때 true
		6. char형 변수 f가 일본어일 때 true	
	*/	
	public static void main(String[] args) {
		char a = 'q';	
		System.out.println(a == 'q' || a == 'Q');
		char b = '\t';
		System.out.println(b != '\t' && b != ' ');
		System.out.println(!(b == '\t' || b == ' '));
		char c = '1';
		System.out.println(c >= '0' && c <= '9');
		
		char d = ']';
		System.out.println((d >= 'A' && d <= 'Z') || 
				(d >= 'a' && d <= 'z'));
		
		char e = '가';
		
		// Hangul Jamo : 0x1100 - 0x11FF
		// Hangul Syllables : 0xAC00 - 0xD7A3		
		System.out.println((e >= 0xAC00 && e <= 0xD7A3) ||
				(e >= 0x1100 && e <= 0x11FF));
		
		char f = 'ぁ';
		System.out.println((f >= 0x3041 && f <= 0x309F) ||
				(f >= 0x30A0 && f <= 0x30FF));
		// System.out.println((char)0x3093);
	}
		
}




