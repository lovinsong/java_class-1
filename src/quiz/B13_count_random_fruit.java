package quiz;

public class B13_count_random_fruit {

	// 1. 크기 100의 배열에 랜덤 과일 문자열을 저장해보세요
	//	  등장하는 과일 : apple, banana, orange, peach, kiwi
	
	// 2. 각 과일이 몇 번 등장했는지 모두 기록하고 출력해보세요	
	public static void main(String[] args) {
		int size = 100;
		int fruit_kind;
		
		String[] fruitNames = 
			{"apple", "banana", "orange", "peach", "kiwi"};			
		fruit_kind = fruitNames.length;
		
		String[] fruitBox = new String[size];
		
		for (int i = 0; i < size; ++i) {
			fruitBox[i] = fruitNames[(int)(Math.random() * 5)];
		}
		
		// fruitBox배열에 저장된 각 과일이 몇 번 등장했는지 모두 세어보세요
		int[] count = new int[5];
		
		for (int i = 0; i < size; ++i) {			
			for (int j = 0; j < fruit_kind; ++j) {				
				if (fruitNames[j].equals(fruitBox[i])) {
					count[j] += 1;
					break;
				}							
			}			
		}		
		
		// 집계가 끝난 후 count를 출력 해야 한다 
		for (int i = 0; i < count.length; ++i) {			
			System.out.printf("%s : %d회\n", fruitNames[i], count[i]);			
		}
	
		// # enum의 시초 
		int apple = 0;
		int banana = 1;
		int orange = 2;
		
		System.out.println("오렌지의 번호 : " + orange);
		System.out.println("오렌지가 몇번 등장? " + count[orange]);
		System.out.println("오렌지 이름 : " + fruitNames[orange]);		
	}
	
}









