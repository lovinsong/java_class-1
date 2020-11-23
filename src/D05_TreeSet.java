import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import myobj.fruit.Mango;

public class D05_TreeSet {

	// # TreeSet
	//	- 중복값을 저장할 수 없다
	//	- 데이터를 저장할 때 오름차순으로 저장한다 
	//	- 요소로 null을 허용하지 않는다 
	//	- 저장 속도가 느린 대신 데이터 접근/검색 속도가 빠르다
	
	// ※ 중복제거 + 원하는 부분 집합 선택 + 정렬 
	
	public static void main(String[] args) {
		
		TreeSet<Mango> sweet_mango_tree = new TreeSet<>(new Comparator<Mango>() {

			@Override
			public int compare(Mango o1, Mango o2) {						
				// Set은 같은 데이터를 허용하지 않기 때문에, 
				// 같은 당도를 지닌 망고가 모두 사라지게 된다
				// return o1.sweet - o2.sweet;
				
				// 같은 당도를 지녔을때는 망고id 기준으로 다시 정렬하기
				int sweet_value = o1.sweet - o2.sweet;				
				
				// id대신 hashCode()를 사용해도 된다 (해당 객체를 유일하게 구분하는 값)
				return sweet_value == 0 ? 
						o1.hashCode() - o2.hashCode() : sweet_value;
			}
			
		});
		
		for (int i = 0; i < 1000; ++i) {
			sweet_mango_tree.add(new Mango());
		}
		
		System.out.println(sweet_mango_tree);
		System.out.println("TreeSet에 저장된 개수 : " + sweet_mango_tree.size());
		
		
		// Comparable에서 return 0은 같은 객체임을 의미한다 
		Set<Mango> basic_comp_tree = new TreeSet<>();
		
		for (int i = 0; i < 3000; ++i) {
			basic_comp_tree.add(new Mango());
		}
		System.out.println("Basic tree에 저장된 개수 : " + basic_comp_tree.size());
		
		
		// # TreeSet 활용
		
		// descendingSet() : 내림차순으로 정렬된 Set을 반환 
		System.out.println(sweet_mango_tree.descendingSet());
		
		
		// # TreeSet을 원하는 기준으로 나누어 사용하기 
		
		// headSet(toElement) : 맨 앞부터 원하는 기준까지의 Set을 반환			
		Set<Mango> hSet = sweet_mango_tree.headSet(new Mango(0, 5, 1000));		
		System.out.println("hSet의 개수 : " + hSet.size());
		
		// tailSet(fromElement) : 원하는 기준부터 맨 마지막까지의 Set을 반환
		SortedSet<Mango> tSet = sweet_mango_tree.tailSet(new Mango(0, 5, 1000));
		System.out.println("tSet의 개수 : " + tSet.size());
		
		SortedSet<Mango> h_tSet = tSet.headSet(new Mango(0, 8, 1000));
		System.out.println("h_tSet의 개수 : " + h_tSet.size());
		
		SortedSet<Mango> t_tSet = tSet.tailSet(new Mango(0, 8, 1000));
		System.out.println("t_tSet의 개수 : " + t_tSet.size());
		
		
		// subSet(from, to)
		SortedSet<Mango> result = sweet_mango_tree
				.subSet(new Mango(0, 7, 1000), new Mango(0, 9, 1000));
		
		System.out.println(result);
		
		// # TreeSet요소를 하나만 선택하기 
		TreeSet<Integer> int_tree = new TreeSet<>();
		
		int_tree.add(99);
		int_tree.add(1);
		int_tree.add(75);
		int_tree.add(3);
		int_tree.add(40);
		int_tree.add(11);
		
		// floor, ceiling 
		//	- 해당 값 기준으로 가장 가까운 낮은/높은 값을 하나 반환
		//	- 전달한 값과 같은 값이 있다면 해당 값을 반환한다
		System.out.println(int_tree.ceiling(11));		
		System.out.println(int_tree.floor(11));
		
		// lower, higher 
		//	- 해당 값 기준으로 가장 가까운 낮은/높은 값을 하나 반환
		//	- 전달한 값과 같은 값은 무시한다		
		System.out.println(int_tree.higher(11));
		System.out.println(int_tree.lower(11));
	}
	
}

















