package j12_배열;

import java.util.Scanner;

public class J12_UserService {
	
	private Scanner scanner; 
	private J12_UserRepository userRepository;
	
	public J12_UserService(J12_UserRepository userRepository) {  //Repository가 Service를 의존
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
		System.out.println("=======<< 회원 전체 조회 >>=======");
		for(J12_User user:users) {
			System.out.println(user.toString()); // 변수의 값을 출력하는 용도
		}
		System.out.println("===============================");
	}
	
	private void registerUser() {
		J12_User user = new J12_User();
		System.out.println("=======<< 회원 등록 >>=======");
		System.out.print("사용자이름: ");
		user.setUsername(scanner.nextLine());;
		System.out.print("비밀번호: ");
		user.setPassword(scanner.nextLine());
		System.out.print("성명: ");
		user.setName(scanner.nextLine());
		System.out.print("이메일: ");
		user.setEmail(scanner.nextLine());
		userRepository.saveUser(user);
	}
	
	private void memberCheckUser() {
		J12_User user = new J12_User();
		System.out.println("====<< 사용자 이름으로 회원 조회 >>====");
		System.out.print("조회 할 이름: ");
		userRepository.findUserByUsername(scanner.nextLine());
		
		
	}
	
	private void passwordChange() {
		J12_User user = new J12_User();
		System.out.println("====<< 비밀번호 변경 >>====");
		System.out.println("기존의 비밀번호를 입력하세요: ");
		userRepository.ChangeUserPassword(scanner.nextLine());
		user.setPassword(scanner.nextLine());
		System.out.println("새로운 비밀번호를 확인해주세요: ");
		user.setPassword(scanner.nextLine());
	
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
				
			}else if(select == '3') {   //이름으로 객체를 가지고 와주는 메소드 필요 -> 레파지토리  // 배열에서 필요한 정보를 끄집어 내는 ~
				memberCheckUser();
				
				
			}else if(select == '4') { // 3가지 옵션 while~ //비밀번호(기존의 비번과 일치하는지 확인), 이름 , 이메일// b써서 뒤로가기
				passwordChange();
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
	
	private String getSelectedErrorMessage() {
		return "###<< 잘못된 입력입니다. 다시 입력하세요. >>###";
	}
	
	
	
	
}

/*
 * 1. 사용자 이름으로 회원 조회
 * 
 * 2. 회원 정보 수정
 *   - 1. 비밀번호 변경
 *   =========<<비밀번호 변경>>=========
 *   기존의 비밀번호를 입력하세요: 1234
 *   
 *   [비밀번호가 틀리면] 비밀번호가 일치하지 않습니다. (수정 메뉴로 이동)
 *   [비밀번호가 일치하면] 
 *   새로운 비밀번호를 입력하세요: 1111
 *   새로운 비밀번호를 확인해주세요: 1234
 *   
 *   [비밀번호가 틀리면] 비밀번호가 서로 일치하지 않습니다.(수정 메뉴로 이동)
 *   [비밀번호가 일치하면]
 *   비밀번호 변경 완료.
 *   
 *   
 *   - 2. 이름 변경 
 *   - 3. 이메일 변경
 *   
 *   - b. 뒤로가기
 * 
 * 
 * 
 * 
 */







