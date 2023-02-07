package J25_소켓.multiSocket.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientSend extends Thread {
	
	private final Socket socket;

	
	@Override
	public void run() {
		OutputStream outputStream;
		try {
			outputStream = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(outputStream,true);
			Scanner scanner = new Scanner(System.in);
			
			while(true) {
				
				if(Client.name == null) {
					System.out.println("이름 입력: ");
					writer.println(scanner.nextLine());
					continue;
				}
				System.out.println("메세지 입력: ");
				writer.println(scanner.nextLine()); // 입력을 기다린다 . . .
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	
		
	}
}
