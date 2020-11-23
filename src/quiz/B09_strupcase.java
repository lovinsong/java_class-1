package quiz;

import java.util.Scanner;

public class B09_strupcase {

	// 입력받은 문자열의 모든 알파벳을 대문자로 만들어보세요
	// ※ 원본이 훼손되지 않고, 새로운 문자열이 생성되어야 함
	
	public static void main(String[] args) {
		
		StringBuilder strb = new StringBuilder();
		
		System.out.print("문장 > ");
		String str = new Scanner(System.in).nextLine();
		
		for (int i = 0, len = str.length(); i < len; ++i) {
			char ch = str.charAt(i);
			
			if (ch >= 'a' && ch <= 'z') {
				// 소문자를 대문자로 변환하는 방법
				// ch -= Math.abs('a' - 'A');
				// ch -= Math.abs('A' - 'a');
				// ch = (char)(ch - 'a' + 'A');
				ch -= 32;
			}
			strb.append(ch);
		}
		System.out.println(strb);
	}
}








