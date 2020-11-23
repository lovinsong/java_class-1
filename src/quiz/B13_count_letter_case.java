package quiz;

public class B13_count_letter_case {

	// 사용자로부터 문장을 하나 입력받았다 치고 
	// 해당 문장에 어떤 문자가 몇번 등장 했는지 세어서 출력해보세요
	// (대문자, 소문자, 숫자만 집계됩니다)
	
	public static void main(String[] args) {
		
		String msg = "The Quick Brown Fox Jumps Over a Lazy Dog";	
	
		int[] count_upper = new int[26];
		int[] count_lower = new int[26];
		int[] count_number = new int[10];		
		
		int[][] count = { count_upper, count_lower, count_number };			
		
		for (int i = 0, len = msg.length(); i < len; ++i) {
			
			char ch = msg.charAt(i);
			
			if (ch >= 'A' && ch <= 'Z') {
				count_upper[ch - 'A'] += 1;
			} else if (ch >= 'a' && ch <= 'z') {
				count_lower[ch - 'a'] += 1;
			} else if (ch >= '1' && ch <= '9') {
				count_number[ch - '9'] += 1;
			}
		}
		
		// # 2차원 배열을 반복문으로 조회하기
		for (int i = 0; i < count_upper.length; ++i) {
			if (count_upper[i] > 0) {			
				System.out.printf("%c : %d회\n", i + 'A', count_upper[i]);
			}
		}
		
		for (int i = 0; i < count_lower.length; ++i) {
			if (count_lower[i] > 0) {			
				System.out.printf("%c : %d회\n", i + 'a', count_lower[i]);
			}
		}
		
		for (int i = 0; i < count_number.length; ++i) {
			if (count_number[i] > 0) {			
				System.out.printf("%c : %d회\n", i + '0', count_number[i]);
			}
		}
	}
	
}








