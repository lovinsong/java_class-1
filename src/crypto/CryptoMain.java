package crypto;

import java.util.Scanner;

public class CryptoMain {

	public static void main(String[] args) {
		// 사용자가 메세지와 키값을 설정하고 원하는 암호 알고리즘으로 
		// 암호화/복호화 작업을 할 수 있는 프로그램을 만들어보세요	
		
		String user_input = "Transposition";
		int user_input_key = 8;
		
		// 상속은 여러 클래스를 일반화(업캐스팅) 시키는 용도로 주로 많이 사용한다 
		Cipher cipher = null;
		
		if (user_input.equals("Caesar")) {
			cipher = new CaesarCipher(user_input_key);
		} else if (user_input.equals("Transposition")) {
			cipher = new TranspositionCipher(user_input_key);
		}
		
		String result = cipher.encryption("ABCDEFG  ABCDEFG  ABCDEFG  ABCDEFG");
		
		System.out.println(result);		

	}	
	
}





