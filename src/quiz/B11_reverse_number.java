package quiz;

public class B11_reverse_number {

	// 사용자로부터 정수를 하나 입력받고 
	// 그 정수를 일의 자리부터 순서대로 출력해보세요 
	
	// 123456789 -> 987654321
	
	public static void main(String[] args) {		
		
		int user = 123456789;		
		
		int reversed = 0;
		
		while (true) {
			// System.out.print(user % 10);			
			reversed += user % 10;
			
			user /= 10;			
			
			if (user <= 0) {
				break;
			}
			reversed *= 10;
		}
		System.out.println(reversed);
	}
	
}









