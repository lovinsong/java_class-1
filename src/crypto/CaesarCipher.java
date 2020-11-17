package crypto;

public class CaesarCipher extends Cipher {
	
	// # 암호란? 
	//	- 비밀 메세지를 주고받기 위한 것 
	//	- 암호화(Encryption) 
	//		평문(일반 메세지)를 암호문(비밀 메세지)로 바꾸는 것 
	//	- 복호화(Decryption) 
	//		암호문을 평문으로 되돌리는 것
	//	- 키(Key)
	//		암호화와 복호화에 사용되는 비밀 값
	
	// # 시저(카이사르) 암호
	//	- 알파벳을 키(Key)값 만큼 오른쪽으로 이동시키는 암호 방식
	//	- 암호화 : 평문을 키 값 만큼 오른쪽으로 이동시킨다 
	//	- 복호화 : 암호문을 키 값 만큼 왼쪽으로 이동시킨다
	
	// # 암/복호화 예

	// ABCDEFGHIJKLMNOPQRSTUVWXYZ !@#$,abcdefghijklmnopqrstuv...
	
	//	* Key값이 3인 경우 암호화 (+3)
	//	"Hello, World!" 	=> 		"Khoorc#Zruog$"
	
	//	* Key값이 3인 경우 복호화 (-3)
	//	"Khoorc#Zruog$" 	=> 		"Hello, World!"
	
	char[] charset = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			+ " !@#$,abcdefghijklmnopqrstuvwxyz").toCharArray();
	int key;
	
	public CaesarCipher(int key) {
		this.key = key % charset.length;
	}
	
	public int indexOf(char ch) {
		for (int i = 0; i < charset.length; ++i) {
			if (ch == charset[i]) {
				return i; 
			}
		}		
		return -1;
	}
	
	public String encryption(String plain_text) {		
		// 매개변수로 받은 평문을 암호화 하여 리턴하는 함수를 구현해보세요 
		StringBuilder crypto = new StringBuilder();
		
		for (int i = 0, len = plain_text.length(); i < len; ++i) {
			char ch = plain_text.charAt(i);
			
			int index = indexOf(ch);
			
			if (index != -1) {
				// 찾은 경우 ch를 암호화				
				crypto.append(charset[(index + key) % charset.length]);
			} else {
				// 못 찾은 경우 ch를 그대로 유지 
				crypto.append(ch);
			}
		}		
		
		return crypto.toString();
	}
	
	public String decryption(String crypto_text) {
		// 매개변수로 받은 암호문을 복호화 하여 리턴하는 함수를 구현해보세요		
		StringBuilder plain = new StringBuilder();
		
		for (int i = 0, len = crypto_text.length(); i < len; ++i) {
			char ch = crypto_text.charAt(i);
			
			int index = indexOf(ch);
			
			if (index != -1) {
				// charset에 있는 문자는 복호화 
				int plain_index = index - key;
				plain_index = plain_index < 0 ? 
						plain_index + charset.length : plain_index; 
				
				plain.append(charset[plain_index]);
			} else {
				// charset에 없는 문자는 그대로 유지 
				plain.append(ch);
			}
		}		
		
		return plain.toString();
	}
	
	public static void main(String[] args) {
		String crypto = new CaesarCipher(999).encryption("hello, world!");
		
		System.out.println(crypto);
		
		String text = new CaesarCipher(999).decryption(crypto);
		
		System.out.println(text);
	}
}










