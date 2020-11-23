package quiz;

public class B13_count_letter {

	// 사용자로부터 문장을 하나 입력받았다 치고 
	// 해당 문장에 어떤 알파벳이 몇번 등장 했는지 세어서 출력해보세요
	// (대소문자 구분 X)	
	public static void main(String[] args) {
		
		String msg = "The Quick Brown Fox Jumps Over a Lazy Dog";				
		msg = msg.toLowerCase();
		
		int[] count = new int[26];		
		
		for (int i = 0; i < msg.length(); ++i) {
			
			char ch = msg.charAt(i);
			
			if (ch >= 'a' && ch <= 'z') {
				count[ch - 'a'] += 1;
			}
		}
		
		for (int i = 0; i < 26; ++i) {
			if (count[i] > 0) {
				System.out.printf("%c가 등장한 횟수는 %d번 입니다.\n",
						i + 'a', count[i]);
			}
		}
				
	}
	
}








