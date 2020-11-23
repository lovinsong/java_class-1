
public class D09_argument {

	// Eclipse에서 argument 테스트하기
	
	//	1. 해당 파일 우클릭
	//	2. Run/Debug Settings -> Edit
	//	3. Arguments에 원하는 값 추가 
	
	public static void main(String[] args) {
		
		System.out.println("받은 실행 옵션 : " + args.length);
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(i + "번째 프로그램 실행 옵션 : " + args[i]);			
		}
		
	}
	
}
