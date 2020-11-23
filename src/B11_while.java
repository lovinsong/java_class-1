import java.util.Scanner;

public class B11_while {

	public static void main(String[] args) {		
		// # while
		//	- for문과 사용법이 약간 다른 반복문 
		//	- 초기값과 증가값의 위치가 정해져 있지 않다
		//	- 증가값의 위치에 따라 반복의 결과가 달라질 수 있다		
		//  - ()안의 조건이 참인동안 {}안의 내용을 반복한다
		
		// # while문의 가장 기본적인 형태
		int i = 0;
		while (i++ < 10) {			
			System.out.println("hello, while! " + i);
		}
		
		for (int j = 0; j < 10; ++j) {
			System.out.println("hello, for! " + j);	
		}
	
		// # while문과 사용하게끔 설계된 클래스들
		//	- has, next등의 수식어가 붙은 함수(메서드)를 가지고 있다
		//	- ex: Scanner 
		
		// System.in : 콘솔을 통해 입력을 하는 통로(inputStream)
		
		// ※ System.in 대신 문자열을 통해 스캐너에 입력
		Scanner sc1 = new Scanner("apple banana orange");
		Scanner sc2 = new Scanner("dog cat rat bird");
		
		// sc1에 다음 내용이 있는동안 출력
		while (sc1.hasNext()) {
			System.out.println(sc1.next());
		}		
		while (sc2.hasNext()) {
			System.out.println(sc2.next());
		}
		
		// # 무한루프를 통해 프로그램 구성하기
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. 계속하기");
			System.out.println("2. 종료하기");
			System.out.print("> ");
			int cmd = sc.nextInt();
			
			switch (cmd) {
			case 1:
				System.out.println("계속합니다.");
				break;
			case 2:
				System.out.println("종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("올바른 선택이 아닙니다.");
				break;
			}
		}
	}
	
}









