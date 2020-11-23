package quiz;

import java.util.Random;

public class B12_tempPassword {

	// 랜덤 4자리의 임시 비밀번호 문자열을 생성하는 프로그램을 만들어보세요
	// (비밀번호를 구성하는 문자 - 알파벳 대문자, 숫자)
	public static void main(String[] args) {		
		// String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";		
		StringBuilder temp_password = new StringBuilder();		
		Random ran = new Random();
		
		for (int i = 0; i < 40; ++i) {
			char ch;					
			// true일때 영어를 추가, 아니면 숫자 추가
			if (ran.nextBoolean()) {
				ch = (char)(ran.nextInt(26) + 'A');
			} else {
				ch = (char)(ran.nextInt(10) + '0');
			}
									
			temp_password.append(ch);
		}
		
		System.out.println(temp_password);
	}
}







