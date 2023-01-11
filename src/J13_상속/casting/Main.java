package J13_상속.casting;

public class Main {

	public static void main(String[] args) {
		
		Controller controller = new Controller(new MainView());  // 자식클래스( 부모클래스를 상속받음) 부모클래스의 메소드를 사용
		
		controller.run();
		
		System.out.println("프로그램 종료");
		
	}
}
