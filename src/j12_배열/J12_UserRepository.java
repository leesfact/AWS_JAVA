package j12_배열;

// 저장소
public class J12_UserRepository {

	private J12_User[] userTable;

	public J12_UserRepository(J12_User[] userTable) {
		this.userTable = userTable;
	}
	
	public J12_User[] getUserTable() {
		return userTable;
	}
	
	public void saveUser(J12_User user) {
		extendArrayOne();
		userTable[userTable.length - 1] = user;
	}
	
	private void extendArray(int length) {
		J12_User[] newArray = new J12_User[userTable.length + length];
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
	}
	
	private void extendArrayOne() {
		J12_User[] newArray = new J12_User[userTable.length + 1];
		transferDataToNewArray(userTable, newArray);
		userTable = newArray;
	}

	private void transferDataToNewArray(J12_User[] oldArray, J12_User[] newArray) {
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}
	
	public J12_User findUserByUsername(String username) {
		
		J12_User user = null;
		for(J12_User u : userTable) {   //userTable 에 등록된 회원 정보가 저장돼 있음
			if(u == null) {
				continue;
			}
			if(u.getUsername().equals(username)) {
				user = u;
				System.out.println("일치하는 사용자가 있습니다.");
				break;
			}else {
				System.out.println("일치하는 사용자가 없습니다.");
				break;
			}
		}
		return user;
	}
	
	public J12_User ChangeUserPassword(String password) {
		J12_User user = null;
		
		for(J12_User u: userTable) {
			if(u == null) {
				continue;
			}
			if(u.getPassword().equals(password)) {
				user = u;
				System.out.println("비밀번호가 일치합니다.");
				System.out.println("새로운 비밀번호를 입력하세요: ");
				ConfirmPassword(password);
			}else {
				System.out.println("비밀번호가 일치하지않습니다.");
				System.out.println("수정 메뉴로 이동합니다.");
				break;
			}
		}
		return user;
	}
	
	 public J12_User ConfirmPassword(String password) {
			J12_User user = null;
		
		for(J12_User u: userTable) {
			if(u == null) {
				continue;
			}
			if(u.getPassword().equals(password)) {
				user = u;
//				System.out.println("비밀번호가 일치합니다.");
//				System.out.println("새로운 비밀번호를 입력하세요: ");
				//ConfirmPassword();
			}
		
		
		}
		return user;
	}
}
	








