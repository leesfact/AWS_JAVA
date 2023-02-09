package simplechatting.client;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChattingClient extends JFrame {
	
	
	
	private Socket socket;
	private String username;
	
	

	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextArea contentView;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = new ChattingClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ChattingClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ipInput = new JTextField();
		ipInput.setBounds(337, 11, 97, 32);
		contentPane.add(ipInput);
		ipInput.setColumns(10);
		
		JButton connectButton = new JButton("연결");
		connectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ip = null;   // 텍스트 필드에 있는 값을 가져옴
				int port = 0; // 텍스트 필드에 있는 값을 가져옴
				
				ip = ipInput.getText();
				port = Integer.parseInt(portInput.getText());
				
				try {
					
					socket = new Socket(ip, port);   //client → server단의 serverSocket.accept(); 에게 전달→
					JOptionPane.showMessageDialog(null, 
							socket.getInetAddress().toString().replaceAll("/", "") + "서버 접속" , 
							"접속성공",
							JOptionPane.INFORMATION_MESSAGE);
					
					InputStream inputStream = socket.getInputStream(); // 서버로부터 올 메시지 통로를 열어줌
					BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
					
					if(in.readLine().equals("join")) {
						username = JOptionPane.showInputDialog(null,
								"사용자 이름을 입력하세요.",JOptionPane.INFORMATION_MESSAGE);
						
						OutputStream outputStream = socket.getOutputStream();  // 서버에게 갈 통로를 열어줌
						PrintWriter out = new PrintWriter(outputStream,true);	
						
						out.println(username + "님이 접속하였습니다."); // 서버로 전달
						
						String welcomMessage = in.readLine() ; //server단의 welcomeMessage
						contentView.append(welcomMessage);
						
					}
					
					
				}catch (ConnectException e1) {
					
					JOptionPane.showMessageDialog(null, 
							"서버 접속 실패" , 
							"접속실패",
							JOptionPane.ERROR_MESSAGE);
				}catch (UnknownHostException e1) {
					e1.printStackTrace();
				}catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		connectButton.setBounds(501, 10, 65, 33);
		contentPane.add(connectButton);
		
		portInput = new JTextField();
		portInput.setBounds(446, 11, 43, 32);
		contentPane.add(portInput);
		portInput.setColumns(10);
		
		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(12, 10, 313, 358);
		contentPane.add(contentScroll);
		
		contentView = new JTextArea();
		contentScroll.setViewportView(contentView);
		
		JScrollPane userListScroll = new JScrollPane();
		userListScroll.setBounds(337, 53, 222, 315);
		contentPane.add(userListScroll);
		
		JTextArea userList = new JTextArea();
		userListScroll.setViewportView(userList);
		
		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(12, 378, 488, 23);
		contentPane.add(messageScroll);
		
		JTextArea messageInput = new JTextArea();
		messageScroll.setViewportView(messageInput);
		
		JButton sendButton = new JButton("전송");
		sendButton.setBounds(505, 378, 61, 23);
		contentPane.add(sendButton);
	}
}
