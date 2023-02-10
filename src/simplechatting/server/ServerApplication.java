package simplechatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
class ConnectedSocket extends Thread{
	private static List<ConnectedSocket> socketList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private String username;
	
	public ConnectedSocket(Socket socket) {
		this.socket = socket;
		socketList.add(this);
	}
	
	@Override
	public void run() {
		try {
			outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream,true);
			out.println("join"); //client에게 전달
		
			inputStream = socket.getInputStream();  // 들어올 문을 열어줌
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
		
			username = in.readLine(); 
			System.out.println(username + "님이 접속하였습니다.");  //server console 창
			
			
			
			String userListStr = "";
			
			for(int i = 0; i<socketList.size(); i++) {
				
				userListStr += socketList.get(i).getUsername();
				
				if(i < socketList.size() - 1 ) { // Last Index가 아니면,
					userListStr += ",";
				}
			}

			for(ConnectedSocket connectedSocket : socketList) {
				outputStream = connectedSocket.getSocket().getOutputStream();
				out = new PrintWriter(outputStream, true);
				out.println("@welcome/" + username + "님이 접속하였습니다."); //클라이언트에게 돌려주는 용도	
				out.println("@userList/" + userListStr);
			}
			
			while(true) {  //서버 안꺼지게 하는 용도 
				String message = in.readLine();
				for(ConnectedSocket connectedSocket : socketList) {
					outputStream = connectedSocket.getSocket().getOutputStream();
					out = new PrintWriter(outputStream,true);
					out.println(message);
				}
			}
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}


public class ServerApplication {
	
	
	public static void main(String[] args) {
		
		
		ServerSocket serverSocket = null;
		try {
			 serverSocket = new ServerSocket(9090);
			 System.out.println("====<<< 서버 실행 >>>====");
			
			
				while(true) {
					Socket socket = serverSocket.accept(); // 클라이언트의 접속을 기다리는 녀석 // 연결버튼 누를때 까지
					
					ConnectedSocket connectedSocket = new ConnectedSocket(socket);
					connectedSocket.start();
				
				}
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("====<<< 서버 종료 >>>====");
			
		}
	}

}
