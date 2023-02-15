package kakaotalk.client;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class KakaoClient extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JPanel loginPanel;
    private JTextField userNameField;
    private JPanel chattingPanel;
    private CardLayout cardLayout;
    private JScrollPane userListScroll;
    private JPanel chattingPanel_1;
    
    public KakaoClient() throws IOException {
        setResizable(false);
        setTitle("KakaoTalk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 800);
        
        // 배경화면 이미지를 불러옵니다.
        final BufferedImage login_img = ImageIO.read(new File("C:\\junil\\AWS_LKY\\workspace\\AWS_JAVA\\src\\kakaotalk\\image\\kakao.png"));
        final ImageIcon imgButton = new ImageIcon("C:\\junil\\AWS_LKY\\workspace\\AWS_JAVA\\src\\kakaotalk\\image\\kakao_login_medium_narrow.png");
        final ImageIcon chattingPlusButton = new ImageIcon("C:\\junil\\AWS_LKY\\workspace\\AWS_JAVA\\src\\kakaotalk\\image\\plus2.png");
        final BufferedImage chatting_img = ImageIO.read(new File("C:\\junil\\AWS_LKY\\workspace\\AWS_JAVA\\src\\kakaotalk\\image\\kakaoChatting.png"));
        
        // 커스텀 JPanel 클래스를 생성합니다.
        JPanel mainPanel = new JPanel() {
            private static final long serialVersionUID = 1L;
            
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(login_img, 0, 0, getWidth(), getHeight(), null);
            }
        };
        
        JPanel chattingPanel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(chatting_img, 0, 0, getWidth(), getHeight(), null);
            }
        };
        
        
        setContentPane(mainPanel);
        mainPanel.setLayout(new CardLayout(0, 0));
        cardLayout = (CardLayout) mainPanel.getLayout();
        
        loginPanel = new JPanel();
        loginPanel.setOpaque(false);
        mainPanel.add(loginPanel, "loginPanel");
        loginPanel.setLayout(null);
        
        userNameField = new JTextField();
        userNameField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        userNameField.setHorizontalAlignment(SwingConstants.CENTER);
        userNameField.setBounds(101, 429, 256, 47);
        loginPanel.add(userNameField);
        userNameField.setColumns(10);
        
        JButton loginButton = new JButton(imgButton);
        loginButton.addMouseListener(new MouseAdapter() {
           
        });
        loginButton.setBounds(101, 486, 256, 47);
        loginButton.setBorderPainted(true);
        loginButton.setContentAreaFilled(false);
        loginButton.setFocusPainted(false);
        loginButton.setRolloverIcon(imgButton);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 로그인 버튼을 클릭했을 때, chattingPanel을 보여줍니다.
                cardLayout.show(mainPanel, "chattingPanel");
            }
        });
        loginPanel.add(loginButton);
        
        chattingPanel_1 = new JPanel();
        mainPanel.add(chattingPanel, "chattingPanel");
        chattingPanel.setLayout(null);
        
        JScrollPane chattingListScroll = new JScrollPane();
        chattingListScroll.setBounds(101, 112, 308, 602);
        chattingPanel.add(chattingListScroll);
        
        JList chattingList = new JList();
        chattingListScroll.setViewportView(chattingList);
        
        JButton chPlusButton = new JButton(chattingPlusButton);
        chPlusButton.setBounds(26, 92, 50, 50);
        loginButton.setBorderPainted(true);
        loginButton.setContentAreaFilled(false);
        loginButton.setFocusPainted(false);
        chattingPanel.add(chPlusButton);
        chattingPanel_1.setLayout(null);
        
        userListScroll = new JScrollPane();
        userListScroll.setBounds(454, 706, -359, -699);
        chattingPanel_1.add(userListScroll);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        try {
         new KakaoClient();
      } catch (IOException e) {
         e.printStackTrace();
      }
    }
}