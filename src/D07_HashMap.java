import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class D07_HashMap {

	// # Map
	//	- Key/Value가 한 세트를 이루는 자료구조
	//	- Key값을 통해 Value를 찾는 자료구조 
	//	- Key는 중복을 허용하지 않는다 
	
	public static void main(String[] args) {
		// # Map은 Key/Value 쌍을 이루기 때문에 제네릭을 두 개 받는다 
		Map<String, String> map1 = new HashMap<>();
		
		// # put메서드를 이용해 데이터를 저장한다
		// 	- Key는 해당 데이터의 카테고리(속성, property, attribute)을 의미한다
		//	- Value는 해당 항목의 값을 저장한다 
		map1.put("이름", "꼬맹이");
		map1.put("나이", "5살");
		map1.put("견종", "포메라니안");
		map1.put("견종", "치와와"); // 같은 Key를 이용하면 값을 수정한다
		map1.put("주인의 나이", "5살");
		
		// # get메서드에 Key값을 전달해 원하는 항목의 값을 꺼낸다 
		System.out.println(map1.get("견종"));
		
		// # 반복문으로 Map 활용하기		
		// 	- keySet 	: Key들로 이루어진 Set을 반환한다
		//	- values 	: Value들로 이루어진 Collection을 반환한다   
		//	- entrySet	: Entry<K, V>들로 이루어진 Set을 반환한다 	
		System.out.println("map1의 key들 : " + map1.keySet());
		System.out.println("map1의 value들 : " + map1.values());
		System.out.println("map1의 entry들 : " + map1.entrySet());
		
		// # keySet으로 돌리기 
		for (String key : map1.keySet()) {
			System.out.println(key + " - " + map1.get(key));
		}
		// # values로 돌리기
		//	- Key로 Value를 찾는것은 쉽지만 Value로 Key를 찾는것은 불가능하다
		for (String value : map1.values()) {
			System.out.println(value);
		}
		// # entrySet으로 돌리기
		for (Entry<String, String> entry : map1.entrySet()) {
			System.out.println(entry.getKey() + " / " + entry.getValue());
		}
		
		HashMap<String, String> map2 = new HashMap<>();		
		map2.put("TEST1", "ABC");
		map2.put("TEST2", "ABCD");
		map2.put("TEST3", "ABCDE");
		
		// # containsKey
		System.out.println(map1.containsKey("주인의 나이"));
		System.out.println(map1.containsKey("주인의 나이 "));
		
		// # containsValue
		System.out.println(map1.containsValue("5살"));
		
		// # putAll로 다른 Map의 데이터를 추가할 수 있다
		map1.putAll(map2);		
		System.out.println(map1);
		
		// # remove메서드로 원하는 데이터를 지울 수 있다
		//	- Key만 가지고 지우는 경우 : 방금 삭제한 값을 반환한다
		//	- Key와 Value모두를 가지고 지우는 경우 : 정확하게 값도 일치할 때 삭제한다 
		System.out.println(map1.remove("나이", "6살"));
		System.out.println(map1.size());
		System.out.println(map1.remove("나이", "5살"));
		System.out.println(map1.size());		
		
		// # get메서드를 사용하다가 데이터 혹은 키가 없는 경우 null이 반환되어
		//   NullPointerException이 발생할 위험이 있다 
		
		// # getOrDefault메서드를 이용해 null값이 반환되는 상황이라면 기본값을 
		//   반환받을 수 있다 
		System.out.println(map1.getOrDefault("엄마의 이름", "기본값").charAt(1));
		System.out.println(map1.get("엄마의 견종"));
		
		// # Map타입 내부에 Map타입 넣기 
		HashMap<String, HashMap<String, String>> phone_book = new HashMap<>();
		
		// 새로운 해쉬맵 인스턴스를 값으로 저장하면, 키값으로 해당 해쉬맵을 꺼낼 수 있게 된다
		phone_book.put("학원", new HashMap<>());
		phone_book.put("가족", new HashMap<>());
		phone_book.put("고등학교", new HashMap<>());
		phone_book.put("중학교", new HashMap<>());
		phone_book.put("동아리", new HashMap<>());
		
		HashMap<String, String> group_map = phone_book.get("학원");			
		
		// 중복되는 값은 키값으로 사용할 수 없기 때문에
		// 키값에는 이름보다는 전화번호 같은 값을 사용하는 것이 좋다	
		group_map.put("010-1234-1234", "김말숙");
		group_map.put("010-5678-5678", "김말숙");
		
		System.out.println(phone_book);
	}	
}


















