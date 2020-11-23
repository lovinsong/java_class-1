package quiz;

import java.util.Scanner;

public class B09_is_numeric_str {

	// 입력받은 문자열에 숫자만 포함되어 있으면 결과에 1을 저장
	// 다른 문자가 포함되어 있다면 0을 저장하여 출력
	
	// ※ 문자열이 비어있을때는 결과가 2
	public static void main(String[] args) {
		
		System.out.print("검사할 문장 > ");
		String str = new Scanner(System.in).nextLine();
		
		// # 문자열이 이상한 경우 3가지
		// 	- null : str이 가리키는 주소가 없는 경우
		//	- str의 값이 ""인 경우
		//	- str의 길이가 0인 경우 
		int status = 1;
		
		if (str == null || str.length() == 0) {
			status = 2;
		} else {				
			for (int i = 0, len = str.length(); i < len; ++i) {			
				char ch = str.charAt(i);
				
				if (ch < '0' || ch > '9') { 
					status = 0;
					break;
				}
			}
		}
		System.out.println("문자열 상태 : " + status);
		
	}
}











