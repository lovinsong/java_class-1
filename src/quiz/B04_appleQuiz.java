package quiz;

// Ctrl + Shift + O : 자동 import
import java.util.Scanner;

public class B04_appleQuiz {

	// 사과를 10개씩 담을 수 있는 바구니가 있다.
	
	// 사용자가 사과의 개수를 입력하면 사과를 모두 담기 위해 필요한
	// 바구니의 개수를 출력해보세요.
	public static void main(String[] args) {
		// 변수 앞에 final : 수정이 불가능한 변수가 된다
		final double BASKET_SIZE = 13;
		
		System.out.print("사과 > ");
		int appleCount = new Scanner(System.in).nextInt();
		
		if (appleCount < 0) {
			System.out.println("0 이상의 숫자를 입력하셔야 합니다.");
		} else {
			int needBasket = (int) Math.ceil(appleCount / BASKET_SIZE);
			System.out.printf("필요한 바구니는 %d개 입니다.\n", needBasket);
		}
		
		System.out.println("프로그램을 종료합니다.");
	}
}





