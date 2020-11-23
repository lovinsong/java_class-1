package quiz;

public class B09_printAlphabet {

	// 1. 반복문을 이용하여 A부터 Z까지 출력해보세요 
	
	// 2. 반복문을 이용하여 z부터 a까지 출력해보세요 
	
	public static void main(String[] args) {
		
		for (char ch = 'A'; ch <= 'Z'; ++ch) {
			System.out.print(ch);
		}
		System.out.println();
		
		for (char ch = 'z'; ch >= 'a'; --ch) {
			System.out.print(ch);
		}
	
	}
	
}
