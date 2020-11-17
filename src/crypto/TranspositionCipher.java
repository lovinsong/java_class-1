package crypto;

public class TranspositionCipher extends Cipher {

	// # 전치 암호 	
	//  - 메세지를 Key값 만큼의 길이로 나눈 뒤 다른 방향으로 읽어서 암호화 하는 방식
	
	// ex> 
	
	//	plain : Common sense is not so common.
	//	key : 8
	
	//  0 1 2 3 4 5 6 7 
	//  ---------------
	//	C o m m o n   s
	//	e n s e   i s 	
	//	n o t   s o   c
	//	o m m o n .
	
	
	//  crypto : Cenoonommstmme oo snnio. s s c
	
	//  0 1 2 3
	//	C e n o
	//  o n o m
	//  m s t m
	//  m e   o
	//  o   s n
	//  n i o .
	//    s   X 
	//  s	c X
	
	private int key;
	
	public TranspositionCipher(int key) {
		this.key = key;
	}
	
	// encryption 메서드의 형식을 시저암호와 일치시키는 것이 좋다
	public String encryption(String plain) {
		StringBuilder[] builders = getBuilders(key);	
		
		int len = plain.length();
		
		for (int i = 0; i < len; ++i) {
			builders[i % key].append(plain.charAt(i));
		}
		
		return joinBuilders(builders);
	}
	
	public String decryption(String crypto) {
		int len = crypto.length();
			
		int columnSize = len % key > 0 ? len / key + 1 : len / key;
		int numOfBlanks = columnSize * key - len;
		int numOfFull = key - numOfBlanks;
		
		System.out.println(len);
		System.out.println(columnSize);
		System.out.println(numOfBlanks);
		System.out.println(numOfFull);
		
		StringBuilder[] builders = getBuilders(columnSize);	

		
		
		for (int column = 0; column < columnSize; ++column) {	
			
			int crypto_index = column;
			
			// 한 줄이 반복될때마다 FullLine인 경우 컬럼만큼 인덱스 증가 
			// FullLine이 아닌 경우 컬럼-1 만큼 인덱스 증가 
			for (int row = 0; row < key; ++row) {
				builders[column].append(crypto.charAt(crypto_index));
				
				 System.out.printf("%d번 빌더에 %c[%d]가 추가됨\n", 
						column, crypto.charAt(crypto_index), crypto_index);
				
				if (row < numOfFull) {
					crypto_index += columnSize;
				} else {
					crypto_index += columnSize - 1;
				}
				
				// 추가한 index가 마지막 컬럼이면서 동시에 마지막 fullline인 경우
				if (column == columnSize - 1 && row == numOfFull -1) {
					break;
				} else if (crypto_index >= len) {
					break;
				}
			}						
		}
		
		return joinBuilders(builders);
	}	
	
	
	private String joinBuilders(StringBuilder[] builders) {		
		StringBuilder result = new StringBuilder();
		
		for (StringBuilder builder : builders) {
			result.append(builder);
		}
		
		return result.toString();
	}
	
	
	private StringBuilder[] getBuilders(int columnSize) {
		StringBuilder[] builders = new StringBuilder[columnSize];		
		
		// ※ 잘못된 소스
		//	- 임시 변수인 builder에 새로운 인스턴스를 만들어 넣는 것이기 때문에
		//	  문제가 된다
//		for (StringBuilder builder : builders) {
//			builder = new StringBuilder();
//		}
		
		for (int i = 0; i < builders.length; ++i) {
			builders[i] = new StringBuilder();			
		}
		
		return builders;
	}
	
	
	public static void main(String[] args) {
		
		String crypto = new TranspositionCipher(8)
				.encryption("Common sense is not so common.  ");
		
		System.out.println(crypto);

		String plain = new TranspositionCipher(8)
				.decryption(crypto);
		
		System.out.println(plain);
	}
	
}









