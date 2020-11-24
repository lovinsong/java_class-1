package jdbc.quiz;

public class Car {

	private String plateNumber; 
	private String usage;
	private String ctype;		
	
	//	중간 한글 분류	
	// 	 - 자가용 : 가나다라마거너더러머버서어저고노도로모보소오조구누두루무부수우주 (PRIVATE)
	// 	 - 일반용(택시와 같은 영업차량) : 아바사자 (BUSINESS)
	// 	 - 대여사업용(렌터카) : 허하호 (RENTAL) 
	final static String alls = "가나다라마거너더러머버서어저고노도로모보소오조구누두루무부수우주아바사자허하호";
	final static String normals = "가나다라마거너더러머버서어저고노도로모보소오조구누두루무부수우주";
	final static String taxis = "아바사자";
	final static String rents = "허하호";
	
	// 랜덤 자동차 정보를 만들어주는 메서드 
	public static Car ran() {	
		return new Car(
				String.format("%02d%c %04d",
					(int)(Math.random() * 99),
					alls.charAt((int)(Math.random() * alls.length())),
					(int)(Math.random() * 9900) + 100
				)
		);
	}
	
	// 	마지막 숫자 0100~9999 랜덤	
	private Car(String plateNumber) {
		this.plateNumber = plateNumber;
		init();		
	}	
	
	// plateNumber 예시 : 01가 1234
	private void init() {
		int num1 = Integer.parseInt(plateNumber.substring(0, 2));	
		String mid = plateNumber.substring(2, 3);
		int num2 = Integer.parseInt(plateNumber.substring(4));
		
		//  차량 번호판 
		//		01 ~ 69 : 승용차 / 
		//  	70 ~ 79 : 승합차 /
		// 		80 ~ 97 : 화물차 / 
		//		98 ~ 99 : 특수차(버스,택시,택배 등등)
		if (num1 < 1 || num1 > 99) {
			ctype = "불법차";
		} else if (num1 < 70) {
			ctype = "승용차";
		} else if (num1 < 80) {
			ctype = "승합차";
		} else if (num1 < 98) {
			ctype = "화물차";
		} else {
			ctype = "특수차";
		}
		
		if (normals.contains(mid)) {
			usage = "자가용";
		} else if (taxis.contains(mid)) {
			usage = "일반영업용";
		} else if (rents.contains(mid)) {
			usage = "대어사업용";
		} else {
			usage = "불법용";
		}
	}
	
	public static void main(String[] args) {
		Car car1 = Car.ran();
		
		System.out.println(car1.plateNumber);
		System.out.println(car1.usage);
		System.out.println(car1.ctype);		
	}
	
	public String getCtype() {
		return ctype;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public String getUsage() {
		return usage;
	}
}












