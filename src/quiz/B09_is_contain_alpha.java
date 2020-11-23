package quiz;

import java.util.Scanner;

public class B09_is_contain_alpha {

	// 사용자가 입력한 문자열에 알파벳이 포함되어 있으면 true를 출력
	// 없으면 false를 출력
	
	public static void main(String[] args) {
		System.out.print("검사 할 문장 > ");
		String str = new Scanner(System.in).nextLine();
		
		// "a123456"
		// "123456a"
		
		boolean result = false;		
		// str.length()를 한번만 호출하는 방식 
		for (int i = 0, len = str.length(); i < len; ++i) {
			char ch = str.charAt(i);
			
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				result = true;
				break; // 만나면 반복문을 끝낸다
			}			
		}
		System.out.println(result);
	}
}











