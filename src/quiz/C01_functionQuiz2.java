package quiz;

import java.util.Arrays;

public class C01_functionQuiz2 {
	// 1. 최소값과 최대값을 매개변수로 받으면, 그 사이의 모든 값을 포함하는 
	//    int배열을 생성하여 반환하는 range 함수를 만들어보세요
	//	  (최소값 이상, 최대값 미만)
	public static int[] range(int min, int max) {
		int[] arr = new int[max - min];	
		
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = min + i;
		}	
		
		return arr;
	}	

	
	// 2. 최대값을 매개변수로 전달 받으면, 0부터 최대값 미만의 모든 값을 포함하는
	// 	  int배열을 생성하여 반환하는 range2 함수를 만들어보세요 
	public static int[] range(int max) {
		int[] arr = new int[max];	
		
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = i;
		}	
		
		return arr;
	}
	
	// 3. 문자열 배열을 전달 받으면, 해당 배열을 모두 "/"를 붙여 이어붙이는 
	//    join 함수를 만들어 보세요
	//	  ex: {"apple", "banana", "orange"}
	//		  -> "apple/banana/orange"
	public static String join(String[] arr, String sep) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < arr.length; ++i) {
			if (i == 0) {
				result.append(arr[i]);
			} else {
				result.append(sep + arr[i]);
			}
		}		
		return result.toString();
	}
	

	// 4. 문자열 타입의 숫자(num), 원래 진법(base_from), 바꾸려는 진법(base_to)
	//    를 전달받으면 base_from의 진법이었던 num을 
	//    base_to 진법의 문자열로 변환하여 반환하는 함수를 만들어 보세요 
	//	  ※ 만약, 진법이 잘못된 경우 null을 반환합니다.
	//	  ※ 변환할 수 있는 최대 진법은 36진법이고, 최소 진법은 2입니다.
	
	public static char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	public static char getSymbol(int value) {		
		return digits[value];
	}

	public static int getValue(char digit) {		
		for (int i = 0; i < digits.length; ++i) {			
			if (digits[i] == digit) {
				return i;
			}			
		}
		return -1;
	}
	
	public static String convert_base(String num, int base_from, int base_to) {
				
		if (base_from < 2 || base_from > 36 || base_to < 2 || base_to > 36) {
			System.err.println("RadixError : 사용가능한 진법은 2부터 36입니다.");
			return null;
		}
		
		num = num.toUpperCase();
		
		int pow = num.length() - 1;
		long real_value = 0; 
		
		for (int i = pow; i > -1; --i) {
			
			char digit = num.charAt(pow - i);
			int value = getValue(digit);
			
			// 8진법인데 8이상의 숫자가 있으면 에러
			if (value >= base_from) {
				System.err.println("base_from 이상의 값을 지닌 문자가 있습니다.");
				return null;
			}
			
			System.out.println(digit);
			System.out.println("\t실제 값 : " + value);
			System.out.println("\t" + Math.pow(base_from, i) + "의 자리");
			
			
			real_value += value * Math.pow(base_from, i); 
		}
		
		System.out.println(base_from + "진법 문자열 \"" + num + "\"의 값은 실제로 "
				+ real_value + "입니다.");
		
		StringBuilder result = new StringBuilder();
		
		while (real_value > 0) {
			result.append(getSymbol((int)(real_value % base_to)));		
			real_value /= base_to;
		}
		
		return result.reverse().toString();
	}
	
	
	public static void main(String[] args) {
		
		// # 함수의 오버로딩
		// 	- 같은 함수 이름으로 다양한 형태의 함수를 정의할 수 있다
		//	- 다른 형태의 함수로 인정받기 위해서는 
		//    매개변수의 개수 혹은 타입이 달라야 한다		
		System.out.println(Arrays.toString(range(33, 36)));		
		System.out.println(Arrays.toString(range(10)));
		
		// # println은 다양한 매개변수 타입을 받을 수 있도록 오버로딩 되어 있다
		System.out.println(123);
		System.out.println("123");
		System.out.println('a');
		System.out.println(123.123);
		
		System.out.println("-----------------------------------");
		String[] fruits = {"apple", "banana", "orange"};
		System.out.println(join(fruits, "/"));
		System.out.println(join(fruits, "&"));
		System.out.println(join(fruits, ", "));
		
		System.out.println("-----------------------------------");
		System.out.println(convert_base("10", 10, 2));
		System.out.println(convert_base("1010", 2, 10));
		System.out.println(convert_base("ABCDEF", 16, 32));
		System.out.println(convert_base("123", 2, 2));
	}
	
}











