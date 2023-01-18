package usermanagement.frame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.google.gson.JsonObject;

import usermanagement.service.UserService;

public class UserManagementFrame extends JFrame {
	
	private List<JTextField> loginFields;
	private List<JTextField> registerFields; 
	
	private CardLayout mainCard;
	private JPanel mainPanel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel forgotPasswordLink;
	private JTextField registerUsernameField;
	private JPasswordField registerPasswordField;
	private JTextField registerNameField;
	private JTextField registerEmailField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagementFrame frame = new UserManagementFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public UserManagementFrame() {
		
	    loginFields = new ArrayList<>();
	    registerFields = new ArrayList<>();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		mainPanel.setBorder(null);

		setContentPane(mainPanel);
		
		mainCard = new CardLayout();
		mainPanel.setLayout(mainCard);
		
		JPanel loginPanel = new JPanel();
		//loginPanel.setOpaque(false); // 투명설정
		loginPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(loginPanel, "loginPanel");
		loginPanel.setLayout(null);
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(registerPanel, "registerPanel");
		registerPanel.setLayout(null);

		JLabel signupLink = new JLabel("Sign up");
		signupLink.addMouseListener(new MouseAdapter() { //익명클래스 1회 사용 후 재사용 X
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "registerPanel");
				clearFields(loginFields);
			}
		});
			
		
		JLabel registerLogoText = new JLabel("User Management");
		registerLogoText.setHorizontalAlignment(SwingConstants.CENTER);
		registerLogoText.setFont(new Font("CookieRun Regular", Font.BOLD, 20));
		registerLogoText.setBounds(57, 45, 286, 60);
		registerPanel.add(registerLogoText);
		
		JLabel registerText = new JLabel("Register");
		registerText.setHorizontalAlignment(SwingConstants.CENTER);
		registerText.setFont(new Font("CookieRun Regular", Font.BOLD, 20));
		registerText.setBounds(136, 91, 130, 46);
		registerPanel.add(registerText);
		
		JLabel registerUsernameLabel = new JLabel("Username");
		registerUsernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerUsernameLabel.setFont(new Font("Consolas", Font.BOLD, 12));
		registerUsernameLabel.setBounds(57, 147, 140, 21);
		registerPanel.add(registerUsernameLabel);
		
		registerUsernameField = new JTextField();
		registerUsernameField.setFont(new Font("Consolas", Font.PLAIN, 14));
		registerUsernameField.setToolTipText("User");
		registerUsernameField.setColumns(10);
		registerUsernameField.setBounds(57, 169, 286, 21);
		registerPanel.add(registerUsernameField);
		
		JLabel registerPasswordLabel = new JLabel("Password");
		registerPasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerPasswordLabel.setFont(new Font("Consolas", Font.BOLD, 12));
		registerPasswordLabel.setBounds(57, 200, 140, 21);
		registerPanel.add(registerPasswordLabel);
		
		registerPasswordField = new JPasswordField();
		//registerPasswordField.setFont(new Font("Consolas", Font.PLAIN, 14));
		registerPasswordField.setBounds(57, 219, 286, 21);
		registerPanel.add(registerPasswordField);
		
		JLabel registerNameLabel = new JLabel("Name");
		registerNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		registerNameLabel.setFont(new Font("Consolas", Font.BOLD, 12));
		registerNameLabel.setBounds(57, 250, 140, 21);
		registerPanel.add(registerNameLabel);
		
		registerNameField = new JTextField();
		//registerNameField.setFont(new Font("Consolas", Font.PLAIN, 14));
		registerNameField.setToolTipText("User");
		registerNameField.setColumns(10);
		registerNameField.setBounds(57, 272, 286, 21);
		registerPanel.add(registerNameField);
		
		JLabel registerEmailLabel = new JLabel("Email");
		registerEmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		//registerEmailLabel.setFont(new Font("Consolas", Font.BOLD, 12));
		registerEmailLabel.setBounds(57, 303, 140, 21);
		registerPanel.add(registerEmailLabel);
		
		registerEmailField = new JTextField();
		//registerEmailField.setFont(new Font("Consolas", Font.PLAIN, 14));
		registerEmailField.setToolTipText("User");
		registerEmailField.setColumns(10);
		registerEmailField.setBounds(57, 325, 286, 21);
		registerPanel.add(registerEmailField);
		
		JButton registerButton = new JButton("Register");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				JsonObject userJson = new JsonObject();
				userJson.addProperty("username", registerUsernameField.getText());
				userJson.addProperty("password", registerPasswordField.getText());
				userJson.addProperty("name", registerNameField.getText());
				userJson.addProperty("email", registerEmailField.getText());
				
				//System.out.println(userJson.toString());
				
				
				UserService userService = UserService.getInstanece(); // userService가 싱글톤이기 때문에
				
				Map<String,String> response = userService.register(userJson.toString());
				
				
				if(response.containsKey("error")) {
					JOptionPane.showMessageDialog(null, response.get("error"),"error",JOptionPane.ERROR_MESSAGE);	
					return;  // 클릭 메서드 탈출
				}
				
				JOptionPane.showMessageDialog(null, response.get("ok"),"ok",JOptionPane.INFORMATION_MESSAGE);
				mainCard.show(mainPanel,"loginPanel");
				clearFields(registerFields);
				
				
			}
		});
		
		JLabel logoText_1 = new JLabel("User Management");
		logoText_1.setFont(new Font("CookieRun Regular", Font.BOLD, 20));
		logoText_1.setHorizontalAlignment(SwingConstants.CENTER);
		logoText_1.setBounds(57, 45, 286, 60);
		loginPanel.add(logoText_1);
		
		JLabel loginText = new JLabel("LOGIN");
		loginText.setFont(new Font("CookieRun Regular", Font.BOLD, 20));
		loginText.setHorizontalAlignment(SwingConstants.CENTER);
		loginText.setBounds(136, 91, 130, 46);
		loginPanel.add(loginText);
		
		usernameField = new JTextField();
		usernameField.setToolTipText("User");
		usernameField.setBounds(57, 169, 286, 21);
		loginPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(57, 219, 286, 21);
		loginPanel.add(passwordField);
		
		JLabel usernameLabel = new JLabel("Username or email");
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		//usernameLabel.setFont(new Font("Consolas", Font.BOLD, 12));
		usernameLabel.setBounds(57, 147, 140, 21);
		loginPanel.add(usernameLabel);
		
		JLabel PasswordField = new JLabel("Password");
		PasswordField.setHorizontalAlignment(SwingConstants.LEFT);
		//PasswordField.setFont(new Font("Consolas", Font.BOLD, 12));
		PasswordField.setBounds(57, 200, 140, 21);
		loginPanel.add(PasswordField);
		
		JButton loginButton = new JButton("Login");
		
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				JsonObject loginUserJson = new JsonObject();
				loginUserJson.addProperty("usernameAndEmail", usernameField.getText());
				loginUserJson.addProperty("password", passwordField.getText());
				System.out.println(loginUserJson.toString());
				//System.out.println("===================================");
				
				UserService userService = UserService.getInstanece(); // userService가 싱글톤이기 때문에
				
				Map<String,String> response = userService.authorize(loginUserJson.toString()); 
				
				if(response.containsKey("error")) {
					JOptionPane.showInternalMessageDialog(null,response.get("error"),"error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				JOptionPane.showInternalMessageDialog(null,response.get("ok"),"ok", JOptionPane.INFORMATION_MESSAGE);
			
				
				
			}
		});
		loginButton.setBackground(new Color(255, 255, 255));
		loginButton.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
		loginButton.setBounds(57, 250, 286, 33);
		loginPanel.add(loginButton);
		
		JLabel signupDesc = new JLabel("Don't have an accout ?");
		signupDesc.setBackground(new Color(0, 128, 192));
		signupDesc.setHorizontalAlignment(SwingConstants.CENTER);
		signupDesc.setFont(new Font("Century Gothic", Font.BOLD, 14));
		signupDesc.setBounds(67, 288, 199, 20);
		loginPanel.add(signupDesc);
		

		
		JLabel signinLink = new JLabel("Sign in");
		signinLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainCard.show(mainPanel, "loginPanel");
				clearFields(registerFields);
			}
		});
		
		signinLink.setFont(new Font("Century Gothic", Font.BOLD, 14));
		signinLink.setHorizontalAlignment(SwingConstants.CENTER);
		signinLink.setBounds(252, 409, 91, 30);
		registerPanel.add(signinLink);
		
		registerButton.setFont(new Font("Harlow Solid Italic", Font.BOLD, 18));
		registerButton.setBackground(Color.WHITE);
		registerButton.setBounds(57, 366, 286, 33);
		registerPanel.add(registerButton);
		
		signupLink.setForeground(new Color(0, 128, 255));
		signupLink.setBackground(new Color(0, 128, 192));
		signupLink.setHorizontalAlignment(SwingConstants.CENTER);
		signupLink.setFont(new Font("Century Gothic", Font.BOLD, 14));
		signupLink.setBounds(249, 285, 66, 26);
		loginPanel.add(signupLink);
		
		forgotPasswordLink = new JLabel("Forgot your password ?");
		forgotPasswordLink.setHorizontalAlignment(SwingConstants.CENTER);
		forgotPasswordLink.setForeground(new Color(0, 128, 255));
		forgotPasswordLink.setFont(new Font("Century Gothic", Font.BOLD, 14));
		forgotPasswordLink.setBackground(new Color(0, 128, 192));
		forgotPasswordLink.setBounds(120, 318, 177, 26);
		loginPanel.add(forgotPasswordLink);
		
		
		loginFields.add(usernameField);
		loginFields.add(passwordField);
		
		registerFields.add(registerUsernameField);
		registerFields.add(registerPasswordField);
		registerFields.add(registerNameField);
		registerFields.add(registerEmailField);
		
	}
	
	private void clearFields(List<JTextField>textFields) {
		for(JTextField field : textFields) {
			if(field.getText().isEmpty()) {
				continue;
			}
			field.setText("");
		}
	}
	
}
