package quiz;

import java.util.Scanner;

public class D10_OnlyPhoneNumber {

	// 사용자로부터 전화번호만 입력 받아 출력해보세요.
	// 전화번호 형태가 아닐 경우 에러 메세지를 출력 후 다시 입력해야 합니다.	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		String phoneNumber = null;
		String regex = "01[01679]-[\\d]{3,4}-[\\d]{4}";
		
		while (true) {
			System.out.print("Tel > ");
			phoneNumber = sc.nextLine();
			
			if (java.util.regex.Pattern.matches(regex, phoneNumber)) {
				System.out.println("올바른 전화번호");
				break;
			} else {
				System.err.println("잘못된 전화번호");
			}
		}
		System.out.println("Tel : " + phoneNumber);
	}
	
}









