import java.util.IllegalFormatConversionException;

public class C12_tryCatchFinally {

	// # 예외 처리 
	//	- 우리가 에러라고 알고 있던 빨간 글씨들을 예외(Exception)라고 부른다 
	//	- 문법적으로 틀린것은 예외가 아니라 에러이다
	//	- 프로그래머가 예외에 대한 적절한 조치를 취해준다면 
	//    프로그램을 강제 종료하지 않고 계속해서 진행하게 된다 
	
	// # try
	//	- 예외가 발생할 수 있는 코드를 try문 내부에 포함시킨다
	//	- 예외가 발생하지 않으면 모두 정상 실행된다
	//	- 예외가 발생한다면 해당 예외를 받는 catch문으로 넘어가게 된다
	
	// # catch
	//	- try문 내부의 코드에서 예외가 발생하면 해당 catch문으로 이동한다
	//	- 첫 번째 매개변수로 해당 예외에 관한 정보를 담고있는 객체를 받는다 
	//	- catch문은 중첩 사용이 가능하다 
	//	- Exception타입의 catch문은 모든 예외를 catch할 수 있다
	//	  ※ Exception : 모든 예외의 부모 타입
	
	// # finally
	//	- try문 내부의 예외 발생 여부와 관계없이 무조건 실행되는 영역
	
	public static void main(String[] args) {
		int[] abc = new int[10];
		
		try {
			System.out.println("try문의 시작");
			
			System.out.println(abc[0]); // 예외 발생 코드
			
			// Integer.parseInt(str) : 문자열을 int타입의 값으로 변환하는 메서드 
			System.out.println(Integer.parseInt("123")); // 예외 발생 코드 2
			
			System.out.printf("%d\n", 123);
			
			System.out.println("try문의 마지막");			
		} catch (Exception e) {			
			System.out.println("catch : " + e.getMessage());			
		} finally {
			System.out.println(" /)/)");
			System.out.println("(..  )");
			System.out.println("☆<  )");
		}
		
//		catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("인덱스 터짐 : catch문 실행");
//		} catch (NumberFormatException e) {
//			System.out.println("숫자가 아님 : catch문 실행");
//		} catch (IllegalFormatConversionException e) {
//			// catch문의 첫 번째 매개변수로 에러 정보 객체가 전달된다
//			System.out.println("catch문 실행 : " + e.getMessage());
//			
//			// 예외 발생시 기본동작이었던 것 
//			// e.printStackTrace(); 
//			// System.exit(0);
//		}
		
		System.out.println("여기까지 잘 실행되었습니다.");
	}
	
}






