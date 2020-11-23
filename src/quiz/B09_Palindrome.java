package quiz;

import java.util.Scanner;

public class B09_Palindrome {

	// 사용자로부터 단어를 하나 입력받고
	// 해당 단어가 회문이라면 "PALINDROME"을 출력
	// 회문이 아니라면 "NOT PALINDROME"을 출력해보세요
	
	// ※ ABBA, MADAM, BORROWORROB 처럼 좌우대칭인 단어를
	//   회문이라고 한다
	public static void main(String[] args) {
		
		System.out.print("input word > ");
		String word = new Scanner(System.in).nextLine();
		
		// # StringBuilder.reverse() 
		// 	- 여태까지 빌드한 문자열을 거꾸로 뒤집어준다 
		StringBuilder strb = new StringBuilder(word);		
		String reverse = strb.reverse().toString();		
		
		int half = word.length() / 2;
		
		boolean palin = true;
		
		for (int i = 0; i < half; ++i) {
			if (word.charAt(i) != reverse.charAt(i)) {
				palin = false;
				break;
			}
		}
		System.out.println(palin ? "PALINDROME" : "NOT PALINDROME");
		
//		boolean palin = true; 
//		
//		for (int i = 0, len = word.length(); i < len / 2; ++i) {
//			
//			char ch1 = word.charAt(i);
//			char ch2 = word.charAt(len - 1 - i);
//			
//			if (ch1 != ch2) {
//				palin = false;
//				break;
//			}
//		}
//		
//		if (palin) {
//			System.out.println("PALINDROME");
//		} else {
//			System.out.println("NOT PALINDROME");
//		}
	}
}

















