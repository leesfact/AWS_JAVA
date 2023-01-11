package j12_배열;

import java.util.Scanner;

public class J12_UserService {
	
	private Scanner scanner; 
	private J12_UserRepository userRepository;
	
	public J12_UserService(J12_UserRepository userRepository) {
		scanner = new Scanner(System.in);
		this.userRepository = userRepository;
	}
	
	public void run() {
		boolean loopFlag = true;
		char select = '\0';
		
		while(loopFlag) {
			showMainMenu();
			select = inputSelect("메인");
			loopFlag = mainMenu(select);
		}
	}
	
	
	
	public void stop() {
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				System.out.println("프로그램 종료중...(" + (i + 1) + "/10)");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료");
	}
	
	private char inputSelect(String menuName) {
		System.out.print(menuName + " 메뉴 선택: ");
		char select = scanner.next().charAt(0);
		scanner.nextLine();
		return select;
	}
	
	private void showMainMenu() {
		System.out.println("========<< 메인메뉴 >>========");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 등록");
		System.out.println("3. 사용자이름으로 회원 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("==============================");
		System.out.println("q. 프로그램 종료");
		System.out.println();
	}
	
	
	
	private void showUsers() {
		J12_User[] users = userRepository.getUserTable();
		
		System.out.println("========<< 회원 전체 조회 >>========");
		
		for(J12_User user : users) {
			System.out.println(user.toString());
		}
		
		System.out.println("====================================");
		
	}
	
	private void registerUser() {
		J12_User user = new J12_User();
		
		System.out.println("========<< 회원 등록 >>========");
		System.out.print("사용자이름: ");
		user.setUsername(scanner.nextLine());
		
		System.out.print("비밀번호: ");
		user.setPassword(scanner.nextLine());
		
		System.out.print("성명: ");
		user.setName(scanner.nextLine());
		
		System.out.print("이메일: ");
		user.setEmail(scanner.nextLine());
		
		userRepository.saveUser(user); // 신규 회원을 저장하는 메소드
	}
	
	private void showUser() {
		J12_User user = null; // J12_User user -> 회원 정보를 담고 있음
		
		System.out.println("========<< 회원 조회 >>========");
		user = verifyUsername();
		
		if(user == null) { // spacebar enter// 리턴시 , 메소드 종료
			System.out.println("존재하지 않는 사용자이름입니다.");
			return;
		}
		
		System.out.println(user.toString()); // 일치하면 user정보를 불러옴
		System.out.println("====================================");
		
	}
	
	private boolean mainMenu(char select) {
		boolean flag = true;
		
		if(isExit(select)) {
			flag = false;
			
		}else {
			if(select == '1') {
				showUsers();
			}else if(select == '2') {
				registerUser();
			}else if(select == '3') {
				showUser();
			}else if(select == '4') {
				updateUser();
			}else {
				System.out.println(getSelectedErrorMessage());
			}
		}
		System.out.println();
		
		return flag;
	}
	
	private boolean isExit(char select) {
		return select == 'q' || select == 'Q';
	}
	
	private boolean isBack(char select) {
		return select == 'b' || select == 'B';
	}
	
	private String getSelectedErrorMessage() {
		return "###<< 잘못된 입력입니다. 다시 입력하세요. >>###";
	}
	
	private J12_User verifyUsername() {
		String username = null;
		System.out.print("사용자이름: ");
		username = scanner.nextLine();
		return userRepository.findUserByUsername(username);
	}
	
	private void updateUser() {
		J12_User user = verifyUsername();
		if(user == null) {
			System.out.println("존재하지 않는 사용자이름입니다.");
			return;
		} // 사용자이름을 입력하여 같이 않으면 메소드를 탈출한다.
		
		boolean loopFlag = true;
		char select = '\0';
		
		while(loopFlag) {
			showUpdateMenu(user);
			select = inputSelect("수정");
			loopFlag = updateMenu(user, select);
		}
	}
	
	private void showUpdateMenu(J12_User user) {
		System.out.println("========<< 수정메뉴 >>========");
		System.out.println("사용자이름: " + user.getUsername());	
		//현재 저장된 user 사용자 이름 : aaa
		System.out.println("==============================");		
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 이름 변경");
		System.out.println("3. 이메일 변경");
		System.out.println("==============================");
		System.out.println("b. 뒤로가기");
		System.out.println();
	}
	
	private void updatePassword(J12_User user) {
		String oldPassword = null; // 이전 비번
		String newPassword = null; // 새로운 비번
		String confirmPassword = null; // 확인받을 비번
		
		System.out.println("========<< 비밀번호 변경 >>========");
		
		System.out.print("기존 비밀번호 입력: ");
		oldPassword = scanner.nextLine();
		
		if(!comparePassword(user.getPassword(), oldPassword)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}// comparePassword 메소드 실행, user가 갖고 있는 패스워드랑
		// 사용자가 입력한 이전 비번을 비교 하는 메소드 , 같지 않으면 일치 하지않으면, 메소드 탈출
		
		System.out.print("새로운 비밀번호 입력: ");
		newPassword = scanner.nextLine();
		System.out.print("새로운 비밀번호 확인: ");
		confirmPassword = scanner.nextLine();
		
		if(!comparePassword(newPassword, confirmPassword)) {
			System.out.println("새로운 비밀번호가 서로 일치하지 않습니다.");
			return;
		}//  comparePassword 메소드 한번 더 실행,  새로운 비번과 확인할 비번 비교
		// 두개가 일치하면, user의 비밀번호를 새로운 비번으로 저장
		user.setPassword(newPassword);
		System.out.println("비밀번호 변경 완료.");
	}
	
	private boolean comparePassword(String prePassword, String nextPassword) {
		return prePassword.equals(nextPassword);
	}
	
	private boolean updateMenu(J12_User user, char select) {
		boolean flag = true;
		
		if(isBack(select)) {
			flag = false;
			
		}else {
			if(select == '1') {
				updatePassword(user);
			}else if(select == '2') {
				
			}else if(select == '3') {
				
			}else {
				System.out.println(getSelectedErrorMessage());
			}
		}
		System.out.println();
		
		return flag;
	}
	
	
}









