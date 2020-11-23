package quiz;

public class B10_Gugudan {
	// 1. 구구단을 다음과 같이 가로로 출력해보세요
	
	// 2단 : 2x1=2 2x2=4 2x3=6 ...
	// 3단 : 3x1=3 3x2=6 3x3=9 ...
	// 4단 : ...
	
	// 2. 구구단을 다음과 같이 세로로 출력해보세요 
	
	//	2단		3단		4단		...
	//	2x1=2	3x1=3	4x1=4	...
	//	2x2=4	3x2=6	4x2=8	...
	//	...
	public static void main(String[] args) {
		
		// Q1
		for (int dan = 2; dan <= 9; ++dan) {			
			System.out.printf("%d단 : ", dan);
			
			for (int gop = 1; gop <= 9; ++gop) {				
				System.out.printf("%dx%d=%-2d ", dan, gop, dan*gop);				
			}
			System.out.println();
		}
		
		// Q2
		for (int gop = 0; gop <= 9; ++gop) {
			// 줄의 시작
			for (int dan = 2; dan <= 9; ++dan) {
				if (gop == 0) {
					System.out.printf("%d단\t", dan);
				} else {
					System.out.printf("%dx%d=%d\t", dan, gop, dan*gop);					
				}
			}			
			System.out.println();
			// 줄의 끝
		}
	}
}













