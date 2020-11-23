package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class C12_inputRightThing {

	public static int input(String msg) {		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print(msg);
			
			try {
				return sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("숫자만 입력해주세요!");
				sc.nextLine();
			}
		}
	}
	
	public static void main(String[] args) {		
		// 사용자로부터 int타입의 데이터를 입력받고 출력해 보세요.
		// 잘못된 타입의 데이터가 들어오더라도 프로그램이 종료되지 않아야 합니다.
		// (올바르게 int가 입력된 경우 프로그램이 종료됩니다)		
		int value = input("반드시 숫자만 입력해 주세요 > ");		
		System.out.println("입력받은 숫자는 " + value + "입니다.");
	}
	
}









