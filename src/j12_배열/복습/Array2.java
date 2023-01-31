package j12_배열.복습;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class User{
	private String username;
	private String password;
}




public class Array2 {
	
	public static void main(String[] args) {
		
		
/*
	        String[] arr = {"a", "a", "a", "b", "C", "D", "A"};

	        Set<String> set = new HashSet<>(Arrays.asList(arr));
	        String[] newArray = set.toArray(new String[0]);

	        System.out.println(Arrays.asList(newArray));
	        */
	    
		
		
//		User user1 = new User("aaa","1234");
//		User user2 = new User("bbb","2222");
//		User user3 = new User("ccc","3333");
//		
		String str = "aBcde";
		String[] arr = str.split("");
		String[] newArray = new String[] {"a","B","c","d","e"};
	
		
//		for(int i = 0; i<arr.length;i++) {
//			
//			System.out.println(arr[i]);
//			System.out.println(newArray[i]);
//			
//			if(arr[i].equals(newArray[i])) {
//				System.out.println("같습니다.");
//			}else{
//				System.out.println("같지않습니다.");
//			}
//		}
		
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i].equals("B")) {
				//System.out.println(" 이문장 실행하냐?");
				continue;
			}else {
				System.out.println(newArray[i]);
			}
		}
//		
//		User[] users = new User[3];
//		users[0] = new User("aaa","1234");
//		users[1] = new User("bbb","2222");
//		users[2] = new User("ccc","3333");
		
//		User[] users = new User[]
//				{
//						new User("aaa","1234"),	
//						new User("bbb","2222"),
//						new User("ccc","3333")
//				};
//		
//		System.out.println(user1);
//		System.out.println(user2);
//		System.out.println(user3);
//		
//		for(int i = 0; i<users.length; i++) {
//			System.out.println(users[i].getUsername());
//			
//		
//		}
//		
//		for(User u : users) {
//			System.out.println(u);
//		}
//		
//		List<User> userList = Arrays.asList(users);
//		System.out.println(userList);
		
		
		
//		String[] arr = {"a", "b", "c", "d", "e"};
//
//        String[] newArr = new String[3];
//        for (int i = 0; i < newArr.length; i++) {
//            newArr[i] = arr[i];
//        }
//        System.out.println(Arrays.asList(newArr));
		
	}

}
 