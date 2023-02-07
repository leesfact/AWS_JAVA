package J25_소켓;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {
	
	public static final int PORT = 9090; 
	
	public static void main(String[] args) {
		
		List<Socket> clients = new ArrayList<>();
	
		/*
		 * 소켓통신 양방향 통신
		 * 서버(Server) - 클라이언트(Client) 
		 * ex) 채팅
		 * 
		 */
		
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			while(true) {
			System.out.println("클라이언트의 접속을 기다리는 중입니다.");
			Socket socket = serverSocket.accept(); // 소켓 하나당 클라이언트 하나
			clients.add(socket);
			System.out.println("클라이언트가 연결되었습니다.");
			System.out.println(clients);
			
			// Server → Client 메세지 보내기 
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream,true);
			out.println("___ 서버에 접속한 것을 환영합니다.");
			
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
