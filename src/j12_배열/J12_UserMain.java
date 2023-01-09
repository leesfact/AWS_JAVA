package j12_배열;

public class J12_UserMain {
	
	public static void main(String[] args) {
		/*   먼저 로직을 구성해 놓고 코딩을 하는 습관을 가지자 
		 *   &100                        &200                         &300            UserTable = &400
		 *  `Main` <-------->          `Service`        <--------> `Repository`     <--------> `Array`
		 *                             run();
		 *  Repository(new)(300)                  
		 * 	Servie(new)(200)	   300.getUserTable();
		 * Array(new)/(400)
		 * 
		 * 
		 *                          stop();
		 */
		
		J12_User[] users = new J12_User[0];
		J12_UserRepository userRepository = new J12_UserRepository(users);
		J12_UserService service = new J12_UserService(userRepository); //매개변수가 존재함
		
		service.run();   // 메소드 호출
		service.stop();  // 메소드 호출
		
		
	}
	
}
