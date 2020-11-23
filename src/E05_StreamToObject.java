import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class E05_StreamToObject {

	// # Serializable 인터페이스
	//	- 해당 객체를 직렬화 가능한 객체로 만든다
	//	※ 직렬화 - 데이터를 이진법으로 변환하는 것
	static class Apple implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		int size;
		String color;
		String local;
		
		public Apple(int size, String color, String local) {
			this.size = size;
			this.color = color;
			this.local = local;
		}
		
		@Override
		public String toString() {		
			return size + "/" + color + "/" + local;
		}
	}
	
	// # ObjectOutputStream/ObjectInputStream을 통해 
	//   객체도 Stream으로 지나다닐 수 있다 
	
	public static void main(String[] args) {	
		// AutoClosable 인터페이스가 구현된 클래스들은 
		// try-with-resources를 이용할 수 있다
		try (
			FileOutputStream fout = new FileOutputStream("D:\\java_io\\objectout.txt");				
			BufferedOutputStream bout = new BufferedOutputStream(fout);				
			ObjectOutputStream oout = new ObjectOutputStream(bout);						
		) {
			oout.writeObject(new Apple(9, "주황색", "대구"));
			oout.writeInt(12345); // DataOutputStream
			oout.writeObject(new Apple(11, "연두색", "홍콩"));
			oout.writeObject(new Apple(912, "노란색", "호주"));			
			
			System.out.println("객체 쓰기 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (
			FileInputStream fin = new FileInputStream("D:\\java_io\\objectout.txt");
			BufferedInputStream bin = new BufferedInputStream(fin);
			ObjectInputStream oin = new ObjectInputStream(bin);
		) {
			// ObjectInputStream의 readObject는 
			// 데이터를 Object타입으로 받아오기 때문에 
			// 제대로 사용하기 위해서는 다운캐스팅이 필요하다			
			System.out.println("<< 파일에서 읽어온 객체 출력하기 >>");
			System.out.println(oin.readObject());		
			System.out.println(oin.readInt()); // DataInputStream
			System.out.println(oin.readObject());
			System.out.println(oin.readObject());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}








