package windowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;

import windowBuilder.view.frame.MainFrame;

public class UserManagementApplication extends JFrame {
	public UserManagementApplication() {
	} //JFrame 상속

	
	public static void main(String[] args) {
		
		Runnable runnable = new Runnable() {
		
		
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true); //
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}; // 익명 클래스
		
		EventQueue.invokeLater(runnable);   // Event가 꼬이지 않게 동기화 해주는...
		
	}
}
