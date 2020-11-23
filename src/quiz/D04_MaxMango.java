package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import myobj.fruit.Mango;

public class D04_MaxMango {
	// 생성시 칼로리와 당도가 랜덤으로 설정되는 망고 클래스를 하나 생성하고
	// 100개의 망고 인스턴스 중 가장 칼로리가 높은 망고를 선택해보세요
	
	// ※ 만약 칼로리가 같은 경우 더 높은 당도를 가진 인스턴스를 선택해야 함 
	
	public static void main(String[] args) {
		
		List<Mango> mangos = new ArrayList<>(100);
		
		for (int i = 0; i < 100; ++i) {
			mangos.add(new Mango());
		}
		
		Mango most_delicious = Collections.max(mangos);
		
		System.out.println("가장 맛있는 망고의 칼로리 : " + most_delicious.calorie);
		System.out.println("가장 맛있는 망고의 당도 : " + most_delicious.sweet);
	}
}










