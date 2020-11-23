package quiz;

import java.util.Scanner;

public class B04_scoreToGrade {
	// 점수를 입력받으면 해당하는 등급을 출력해주는 프로그램을 작성해보세요.
	
	// 	90점 이상	: A등급
	//	80점 이상	: B등급
	//	70점 이상	: C등급
	//	60점 이상	: D등급
	//	그 외 	: F등급
	
	// ※ 점수는 0점부터 100점까지 있습니다.
	public static void main(String[] args) {
		System.out.print("점수 > ");
		int score = new Scanner(System.in).nextInt();
		
		if (score < 0 || score > 100) {
			System.out.println("점수가 이상해서 프로그램을 종료합니다.");			
			return; // main()을 끝낸다
			// System.exit(0); // 프로그램을 종료한다
		}
		
		char grade = 'F';
		
		if (score >= 90)
			grade = 'A';
		else if (score >= 80)
			grade = 'B';
		else if (score >= 70)
			grade = 'C';
		else if (score >= 60)
			grade = 'D';
		
		System.out.printf("당신의 점수 : %d\n등급 : %c\n", score, grade);
	}
}








