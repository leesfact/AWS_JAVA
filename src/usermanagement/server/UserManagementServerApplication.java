package usermanagement.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class UserManagementServerApplication implements Runnable{
	
	
	private final static int PORT = 9090;
	private ServerSocket serverSocket;
	
	@Override
	public void run() { // Runnable을 구현했기때문에 오버라이딩 가능
		
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("==========< 서버 실행 >==========");
			
			socketConnection();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null) { // 서버가 열리지 않음
					serverSocket.close();	
				}
			
				System.out.println("==========< 서버 종료 >==========");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void socketConnection() throws IOException {
		while(true) {
			Socket socket = serverSocket.accept(); //클라이언트의 연결을 무한 기다림 //throws IOException 예외 던지기
			SocketServer socketServer = new SocketServer(socket); //연결이 됐으면, 
			socketServer.start(); //thread  
		}
	}
	
	public static void main(String[] args) {
		UserManagementServerApplication application = new UserManagementServerApplication();
		application.run();
		
	}

}
