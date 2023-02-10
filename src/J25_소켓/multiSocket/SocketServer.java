package j25_소켓.multiSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer extends Thread {
	
	public static List<SocketServer> clientList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private static int autoIncrement = 1;
	private String name;
	
	public SocketServer(Socket socket) {
		this.socket = socket; // 해당 클라이언트랑 연결
		name = "user" + autoIncrement++ ;
		clientList.add(this); //List에 SocketServer들을 담는다
	}
	
	@Override
	public void run() {
		System.out.println("[연결된 클라이언트 정보]");
		System.out.println("IP: " + socket.getInetAddress());
		
		try {
			inputStream = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			sendToAll(name + "님이 접속하였습니다."); 
			
			while(true) {
				String message = reader.readLine(); // 메세지가 들어올때까지 기다린다
				if(message == null) {  // 공백이 들어가도 전송이 된다
					break; // while 문을 빠져 나감
				}
				sendToAll(message);
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				inputStream.close(); // Stream ex) 서버와 클라이언트를 만나게 해주는 통로 같은 역할
				outputStream.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	private void sendToAll(String message) throws IOException {
		for(SocketServer socketServer : clientList) {
			outputStream = socketServer.socket.getOutputStream();
			PrintWriter writer = new PrintWriter(outputStream,true);
			writer.println(name + ": "+ message); // 여기서 name은 자기 자신
		}
	}
	
}











