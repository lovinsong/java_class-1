package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D07_countFruits {
	
	private enum Fruit {
		APPLE,
		BANANA,
		ORNAGE,
		KIWI
	}
	
	// 다음 리스트를 이용해 각 과일이 몇 개인지를 저장한 Map을 생성해보세요 
	
	static List<Fruit> fruits;
	
	static {
		fruits = new ArrayList<>();
		
		for (int i = 0; i < 50; ++i) {
			fruits.add(Fruit.values()[(int)(Math.random() * 4)]);
		}		
	}
	
	public static void main(String[] args) {
		Map<Fruit, Integer> fruit_count_map = new HashMap<>(); 
		
		for (Fruit fruit : Fruit.values()) {
			int freq = Collections.frequency(fruits, fruit);			
			fruit_count_map.put(fruit, freq);
		}
		
		System.out.println(fruit_count_map);
	}
	
}






