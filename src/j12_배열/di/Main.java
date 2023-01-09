package j12_배열.di;

public class Main {
	
	public static void main(String[] args) { //Dependency Injection
		Test_C tc = new Test_C();
		Test_B tb = new Test_B(tc);
		Test_A ta = new Test_A(tb);
		
		//ta.setTb(tb);
		ta.testA1();  //호출
		ta.testA2();
		
		
	}

}
