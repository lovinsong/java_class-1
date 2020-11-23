package quiz;

public class B05_CheckWord {
	
	// 사용자로부터 단어를 하나 입력받고
	// 첫 번째 글자와 마지막 글자가 일치하면 "OK"를 출력
	// 아니라면 "NOT OK"를 출력해보세요
	
	public static void main(String[] args) {
		String word = "";
		
		// null : 아무값도 없는 상태
		if (word == null || word == "") {
			System.out.println("단어가 올바르지 않습니다.");
			return;
		}
		
		char first_letter = word.charAt(0);
		char last_letter = word.charAt(word.length() - 1);
		
		if (first_letter == last_letter) 
			System.out.println("OK");
		else
			System.out.println("NOT OK");		
	}
	
}




