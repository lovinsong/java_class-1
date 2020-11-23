
// # import 
// 	- 다른 패키지에 있는 클래스를 사용하기 위해서는 
// 	  해당 클래스를 import해야 한다
// ※ 다른 패키지에서 미리 만들어둔 소스를 가져와서 사용할 수 있다
// ※ 같은 패키지의 미리 만들어둔 소스는 import하지 않아도 쓸 수 있다

import java.util.Scanner;
// import quiz.A01_printQuiz;

public class B01_Scanner {

	// # java.util.Scanner 클래스
	//	- 프로그램 외부로부터 입력을 받을 수 있는 기능들이 모여있는 클래스
	//	- 어디에서 입력을 받을지 결정한 뒤 다양한 방법으로 입력받을 수 있다
	//	- 콘솔로부터 입력을 받을 때는 System.in을 이용한다
	
	public static void main(String[] args) {		
//		A01_printQuiz.main(null);		
//		A00_Hello.main(null);
//		A01_Escape.main(null);
//		Math.pow(3, 5);
		
		// 새로운 스캐너를 생성한 뒤 변수 sc에 생성한 스캐너를 담아놓는다
		// 새로운 스캐너를 생성할 때 어디에서 입력받을지를 설정할 수 있다
		//	System.out : 콘솔로 출력하는 통로
		// 	System.in  : 콘솔에서 입력받는 통로
		Scanner sc = new Scanner(System.in);
		
		// next()
		//	- 통로에 존재하는 다음 값을 하나만 꺼낸다
		//	- 타입을 바꾸지 않는다 (String)		
		//  - 통로에 아무 값도 없다면 입력이 될때까지 기다린다
				
		// next타입() 
		//	- 통로에 존재하는 다음 값을 하나만 꺼낸 뒤 해당 타입으로 변환한다
		//	- 통로에 아무 값도 없다면 입력이 될때까지 기다린다
		//	- 통로에 존재하는 다음 값이 해당 타입이 될 수 없다면 에러가 발생한다
		
		// nextLine()
		//	- 통로에 존재하는 값들 중 한 줄을 가져온다
		//	- 한 줄을 구분하는 기준은 '\n'이다
		System.out.print("아무 값이나 입력해보세요 > ");
		int num = sc.nextInt();
		
		System.out.println("입력 받은 값 : " + num);
		System.out.println(num + 10);
		System.out.println(num * 10);
		System.out.println(num / 10);
		System.out.println(num / 10.0);
		System.out.println(Math.pow(num, 2));
		
		int num2 = sc.nextInt();
		System.out.println("두번 째 값 : " + num2);
	}
}











