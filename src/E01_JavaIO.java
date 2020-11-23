import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class E01_JavaIO {

	// # Java I/O (Input and Output)
	//	- 자바는 스트림을 이용해 입출력을 다룬다
	//	- 프로그램으로 들어오는 모든 데이터들을 입력이라고 부른다 (Input)
	//	- 프로그램이 연산해서 내보내는 모든 데이터들을 출력이라고 부른다 (Output)
	
	// # Stream
	//	- 데이터들이 오가는 통로
	//	- 입력 받을 때 사용하는 통로를 InputStream이라고 부른다
	//	- 출력 할 때 사용하는 통로를 OutputStream이라고 부른다
	//	- 데이터가 Stream을 통해 이동할때는 데이터를 0과1로 변환하여 전송한다
	
	// # OutputStream 클래스의 공통 메서드
	//	- write(int)	
	//	- write(byte[])	
	//	- flush : 모아놨던 데이터를 전송한다
	//	- close : 스트림을 폐기한다 (닫는다, 메모리 해제)
	
	// # InputStream 클래스의 공통 메서드
	//	- int read() : 다음 한 바이트를 읽어온다, EOF에 도달하면 -1을 반환
	//	- int read(byte[])
	//	- int read(byte[], off, len)
	//	- close() : 스트림을 닫는다 (메모리 해제)
			
	// ※ EOF - end of file
	
	public static void main(String[] args) {
		
		// # java.io.FileOutputStream 
		//	- 파일로 출력하는데 특화된 OutputStream
		//	- Java IO 클래스들은 대부분 필수적으로 처리해야하는 예외가 존재한다
		
		try {
			FileOutputStream fout = 
					new FileOutputStream("D:\\java_io\\testout.txt");
			
			// 1. int를 사용하는 방식
			// fout.write(65);
			
			// 2. byte[]을 사용하는 방식
			byte[] data = "안녕하세요".getBytes();			
			fout.write(data);
			
			// Java IO의 스트림들은 메모리를 gc가 수거해가지 않기 때문에  
			// 다 쓴 스트림은 반드시 프로그래머가 직접 닫아주어야 한다
			fout.close(); 
			
			System.out.println("쓰기 성공");
		} catch (FileNotFoundException e) {
			System.err.println("파일을 못찾았습니다.");
		} catch (IOException e) {
			System.err.println("쓰다가 뭔가 발생한 에러");
		}
		
		
		// # java.io.FileInputStream
		//	- 파일로부터 입력을 받는데 특화된 InputStream

		
		try {
			FileInputStream fin = 
					new FileInputStream("D:\\java_io\\testout.txt");
			
			byte[] bytes = new byte[100];
			
			// 읽은 값이 -1이 아닌동안 계속 읽어들인다
			int ch = -1;
			int index = 0;
			while ((ch = fin.read()) != -1) {
				bytes[index++] = (byte) ch;
			}
			
			System.out.println("byte[]에 저장된 값들 : " 
					+ Arrays.toString(bytes));			
			System.out.println(new String(bytes));
			
			fin.close();
		} catch (FileNotFoundException e) {			
			System.err.println("해당 파일을 찾지 못했습니다.");
		} catch (IOException e) {
			System.err.println("IO도중 에러 발생");			
		}
	
		// # FileInputStream, FileOutputStream은 데이터를 코드로 읽어오기 때문에
		//   프로그래머가 원래 형태로 재조립하는 과정이 필요하다 
		
	}
	
}









