
public class C03_Constructer {

	// # 클래스의 생성자 (Constructor)
	
	//	- 클래스의 이름과 똑같은 이름의 함수 
	//	- new와 함께 생성자를 호출하면 클래스에 정의된대로 인스턴스를 생성한다
	//	- 생성자가 모두 실행된 후에는 생성된 인스턴스의 주소가 반환된다
	//	- 생성자를 따로 정의하지 않으면 아무것도 정의되지 않은 
	//    기본 생성자가 자동으로 생성된다
	
	//	※ 기본 생성자 - 매개 변수가 없는 생성자 
	public static void main(String[] args) {
		Orange o1 = new Orange();
		Orange o2 = new Orange(5, 5, "green");
		
		System.out.println(o1.color);
		System.out.println(o1.size);
		System.out.println(o1.sweet);
		
		System.out.println(o2.color);
		
		Strawberry s1 = new Strawberry();
		
		Grape g1 = new Grape(30);
		Grape g2 = new Grape(25);
		Grape g3 = new Grape();
		
		for (int i = 0; i < 31; ++i) {
			g1.eat();
		}
		
		// 아까 정의한 클래스에 생성자를 2개씩 추가해보세요
		// * myobj.fruit, myobj.vehicle
	}
}

// 정의된 생성자가 있다면 기본 생성자가 자동으로 생성되지 않는다
class Grape {
	int podo;
	int skin;
	
	public Grape(int podo) {		
		this.podo = podo;
		this.skin = 0;		
	}
	
	// 자동으로 생성되지 않으므로, 기본 생성자를 사용하고 싶다면 직접 정의해야 한다 
	public Grape() {
		this(20); 

		// 생성자에서 this()를 통해 다른 생성자를 호출할 수 있다
		// 다른 생성자는 반드시 생성자 맨 윗줄에서 호출해야 한다
	}
	
	public void eat() {
		if (podo == 0) {
			System.err.println("이 포도는 다 먹었습니다.");
			System.out.printf("현재 남은 포도는 %d개, 잔해는 %d개 입니다.\n", podo, skin);
			return;
		}
		podo--;
		skin++;
		System.out.printf("현재 남은 포도는 %d개, 잔해는 %d개 입니다.\n", podo, skin);
	}
}

// 생성자를 만든적이 없다면 숨겨진 기본 생성자가 존재한다
class Strawberry {
	int seed;
	String color;
}

class Orange {
	
	int sweet;
	int size;
	String color;
	
	// # 생성자의 특징
	//	- 리턴 타입이 없고 클래스명과 같은 이름을 가진다
	//	- 인스턴스 생성시에 가장 먼저 호출된다
	//	- 주로 인스턴스 변수의 값을 초기화하는 용도로 사용한다 
	public Orange() {
		// 평상시에는 클래스 내부에서 this를 생략해도 필드에 접근할 수 있다
		sweet = 10;
		size = 5;
		color = "orange";
	}	
	
	// # 생성자도 함수처럼 오버로딩이 가능하다 
	//	- 하나의 클래스가 다양한 형태의 생성자를 가지고 있을 수 있다
	public Orange(int sweet, int size, String color) {
		// # this
		//	- 클래스 내부에서 현재 인스턴스를 참조할 때 사용하는 키워드
		
		// 필드값과 지역변수명이 겹치는 경우 
		// this를 이용해 어느쪽 변수인지 명확하게 지정할 수 있다
		
		// ※ this를 붙인 쪽이 인스턴스 변수가 된다
		this.sweet = sweet;
		this.size = size;
		this.color = color;
	}
}











