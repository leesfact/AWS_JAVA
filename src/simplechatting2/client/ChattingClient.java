package simplechatting2.client;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import lombok.Getter;
import simplechatting2.dto.JoinReqDto;
import simplechatting2.dto.MessageReqDto;
import simplechatting2.dto.RequestDto;

@Getter
public class ChattingClient extends JFrame {
	
	// ChattingClient  singleton 생성
	private static ChattingClient instance;
	
	public static ChattingClient getInstance() {
		if(instance == null) {
			instance = new ChattingClient();
		}
		return instance;
	}
	
	private Socket socket;
	private Gson gson;
	private String username;
	
	

	private JPanel contentPane;
	private JTextField ipInput;
	private JTextField portInput;
	private JTextArea contentView;
	private JTextField messageInput;
	private JList<String> userList;
	private DefaultListModel<String> userListModel;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingClient frame = ChattingClient.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private ChattingClient() {
		gson = new Gson();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ipInput = new JTextField();
		ipInput.setText("127.0.0.1");
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
					
					socket = new Socket(ip, port);   //client → server단의 serverSocket.accept(); 에게 전달 →
					JOptionPane.showMessageDialog(null, 
							socket.getInetAddress().toString().replaceAll("/", "") + "서버 접속" , 
							"접속성공",
							JOptionPane.INFORMATION_MESSAGE);
						
					ClientRecive clientRecive = new ClientRecive(socket);
					clientRecive.start();
					username = JOptionPane.showInputDialog(null,"사용자 이름을 입력해 주세요.","이름입력",JOptionPane.INFORMATION_MESSAGE);
					JoinReqDto joinReqDto = new JoinReqDto(username);
					String joinReqDtoJson = gson.toJson(joinReqDto);
					RequestDto requestDto = new RequestDto("join", joinReqDtoJson);
					String requestDtoJson = gson.toJson(requestDto);
					
					
					OutputStream outputStream = socket.getOutputStream();
					PrintWriter out = new PrintWriter(outputStream,true);
					out.println(requestDtoJson);
					connectButton.setEnabled(false);
					connectButton.removeMouseListener(this);
					
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
		portInput.setText("9090");
		portInput.setBounds(446, 11, 43, 32);
		contentPane.add(portInput);
		portInput.setColumns(10);
		
		JScrollPane contentScroll = new JScrollPane();
		contentScroll.setBounds(12, 10, 313, 358);
		contentPane.add(contentScroll);
		
		contentView = new JTextArea();
		contentView.setEditable(false);
		contentScroll.setViewportView(contentView);
		
		JScrollPane userListScroll = new JScrollPane();
		userListScroll.setBounds(337, 53, 222, 315);
		contentPane.add(userListScroll);
		
		
		userListModel = new DefaultListModel<>();
		userList = new JList<String>(userListModel);
		userListScroll.setViewportView(userList);
		
		JScrollPane messageScroll = new JScrollPane();
		messageScroll.setBounds(12, 378, 488, 23);
		contentPane.add(messageScroll);
		
		messageInput = new JTextField();
		messageInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			
						sendMessage();
				}
				
			}
		});
		messageScroll.setViewportView(messageInput);
		
		JButton sendButton = new JButton("전송");
		sendButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					sendMessage();
			  
		    }
		});
		sendButton.setBounds(505, 378, 61, 23);
		contentPane.add(sendButton);
	}
	
	
	private void sendRequest(String resouce, String body) {
		OutputStream outputStream;
		try {
			outputStream = socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream,true);
			RequestDto requestDto = new RequestDto(resouce, body);
		
			out.println(gson.toJson(requestDto));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void sendMessage() {
		if(!messageInput.getText().isBlank()) { 
			
				String toUser = userList.getSelectedIndex() == 0 ? "all" : userList.getSelectedValue();
			
				MessageReqDto messageReqDto =
						new MessageReqDto(toUser, username, messageInput.getText());
				
				sendRequest("sendMessage", gson.toJson(messageReqDto));
				messageInput.setText("");
				
		  }
	}
}
