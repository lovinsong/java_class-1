import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class E10_GlobalMessageServer {

	public static void main(String[] args) {		
		ArrayList<Socket> clients = new ArrayList<>();
		
		// Socket을 Key값으로 이용해 OutputStream을 관리한다
		// 	개인 메세지를 보낼 때 : Key로 Socket을 전달
		//	전체 메세지를 보낼 때 : 저장된 모든 out에 메세지 전달 
		HashMap<Socket, PrintWriter> send_map = new HashMap<>();
		
		try {
			ServerSocket ss = new ServerSocket(3455);
			
			int count = 0;
			
			while (true) {
				// 접속에 성공한 클라이언트들을 List에 저장하여 관리한다
				System.out.println("연결을 기다리는중 ... ");
				Socket user = ss.accept();
				
				// 접속자 추가
				clients.add(user);		
				OutputStreamWriter osw = new OutputStreamWriter(user.getOutputStream());
				BufferedWriter bw = new BufferedWriter(osw);
				PrintWriter pw = new PrintWriter(bw);				
				send_map.put(user, pw);				
				
				for (PrintWriter out : send_map.values()) {
					out.printf("<%s>님이 채팅방에 접속하셨습니다.\n", user.getInetAddress());
					out.flush();				
				}
				
				for (int i = 0; i < clients.size(); ++i) {
					Socket client = clients.get(i);
					System.out.println(i + "번째 소켓: " + client);
					System.out.println("연결 여부 : " + client.getKeepAlive());
				}
				
				if (count++ == 30) { 
					break;
				}
			}
			
			System.out.println("서버가 종료되었습니다.");
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
}










