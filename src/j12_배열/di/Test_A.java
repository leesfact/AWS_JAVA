package j12_배열.di;

public class Test_A {
	
	
			private final Test_B tb ; // 멤버변수 //NULL //final 걸어주는 이유?? _ 초기화가 무조건 있어야함
			
			public Test_A(Test_B tb) { // 생성자를 통해서 주는 방법 (required argument constructor)
				this.tb = tb;          // 기본 생성자 (no argument constructor)
				                       // 전체 생성자 (All argument constructor)
			}
//			public void setTb(Test_B tb) { //getter & setter를 통해서 주는 방법
//				this.tb = tb;
//			}
			
			
			
			
			
			public void testA1() {
			System.out.println("테스트A1 메소드 호출!!");
			//Test_B b = new Test_B();
			tb.testB1(); //NULL.testB1()// error 발생
		}
		
			public void testA2() {
			System.out.println("테스트A2 메소드 호출!!");
			//Test_B b = new Test_B();
			tb.testB1();
		}

}
