package j20_JSON.builder;

public class UserMain {
	
	public static void main(String[] args) {
		
//		User user = new User();
//		User.UserBuilder userBuilder = new User.UserBuilder();
		
		
		User user = new User.UserBuilder()
							.build();
		
		System.out.println(user);
		
		User user2 = User.builder()
				.userId(128)
				.username("aaa")
				.password("1234")
				.name("가나다라마")
				.email("aaa@gmail.com")
				.build();
		
		System.out.println(user2);
		
	}
}
