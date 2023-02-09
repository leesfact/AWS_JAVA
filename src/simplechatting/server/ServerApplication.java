package simplechatting.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {
	
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			 serverSocket = new ServerSocket(9090);
			System.out.println("====<<< 서버 실행 >>>====");
			
			
				Socket socket = serverSocket.accept(); // 클라이언트의 접속을 기다리는 녀석 // 연결버튼 누를때 까지
				
				OutputStream outputStream = socket.getOutputStream(); //client에게 통로를 열어줌
				PrintWriter out = new PrintWriter(outputStream,true);
				out.println("join"); //client에게 전달
				
				InputStream inputStream = socket.getInputStream();  // 들어올 문을 열어줌
				BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
				
				String welcomeMessage = in.readLine(); 
				System.out.println(welcomeMessage);  //server console 창
				out.println(welcomeMessage); //클라이언트에게 돌려주는 용도				
				
				while(true) {  //서버 안꺼지게 하는 용도 
				in.readLine();	
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
