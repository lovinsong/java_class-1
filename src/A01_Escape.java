
public class A01_Escape {

	public static void main(String[] args) {
		
		// # Escape 문자
		//	- 특수한 기능을 가진 문자
		//	- 그냥 출력하려고 하면 문제가 생기는 문자들
		//	- 앞에 \(역슬래시)가 붙은 문자는 Escape 문자로 간주한다
		//	- 두 문자가 합쳐져 하나의 문자로 인식된다 
		
		// \n : 줄바꿈의 기능을 가진 특수 문자 (linebreak, linefeed, newline ..)
		System.out.println("안녕하세요!\n반\n갑\n습\n니\n다.");	
		
		// \t : Tab키의 기능을 가진 특수 문자
		System.out.println("안녕하세요!\t반갑습니다.");
		System.out.println("이름\t혈액형\t최근헌혈여부");
		System.out.println("홍길동\tA형\tNo");
		System.out.println("임꺽정\tO형\tYes");		
		
		// \\ : 그냥 역슬래시를 출력하고 싶을 때 사용한다
		//	ex> C:\Program Files\Java\jdk를 출력하고 싶은 경우
		System.out.println("C:\\Program Files\\Java\\jdk");
		
		// \" : 그냥 큰따옴표를 출력하고 싶을 때 사용한다
		//	ex> 저녁은 "지옥"에서 먹는다
		System.out.println("저녁은 \"지옥\"에서 먹는다");
		
		// \' : 그냥 작은따옴표를 출력하고 싶을 때 사용한다
		System.out.println("아침을 \'든든\'하게 먹어둬라");
		System.out.println("아침을 '든든'하게 먹어둬라");
		System.out.println('\'');
	}
	
}





