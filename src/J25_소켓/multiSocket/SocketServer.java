package J25_소켓.multiSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer extends Thread {  //Thread를 상속
	
	public static List<SocketServer> clientList = new ArrayList<>();
	private Socket socket;
	private String name;
	
	public SocketServer(Socket socket) {
		this.socket = socket;
		clientList.add(this); // static 이라서 자기 자신을 담는 객체 this	
	}
	@Override // 상속 받은 것을 사용할 때는 ctrl + space 에서 오버라이딩 하여 사용
		public void run() {
			System.out.println("[연결된 클라이언트 정보]");
			System.out.println("IP: " + socket.getInetAddress());
			
			
			try {
				InputStream inputStream = socket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				
				OutputStream outputStream = socket.getOutputStream();
				PrintWriter writer = new PrintWriter(outputStream,true);
				
				writer.println("서버 접속 성공!");
				writer.println("사용자 이름을 입력하세요: ");
				
				
				String message = null;
				boolean loginFlag = false;
				while((message = reader.readLine()) != null) {
					if(name == null) {
						name = message;
						System.out.println("\n서버에 " + name + "님이 접속하였습니다.");
					}
					
					for(SocketServer s : clientList){
						try {
							 outputStream = s.socket.getOutputStream();
							 writer = new PrintWriter(outputStream,true);
							 if(loginFlag) {
								 writer.println("\n"+ s.name + "님이 접속하였습니다.");
							 	 loginFlag = true;
							 	 continue;
							 }
							 writer.println("\n" + s.name + ":" + message);
							 
							 
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
}
