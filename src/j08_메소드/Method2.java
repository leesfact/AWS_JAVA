package j08_메소드;

public class Method2 {

	// 매개변수: x, 반환: x
	public static void method1() {
		System.out.println("단순 실행");
		System.out.println();
	}
	
	// 매개변수: int 하나입력, 반환: x
	public static void method2(int num) {
		System.out.println("num: " + num);
		System.out.println();
	}
	
	// 매개변수: int 두개 입력, 반환: x
	public static void method3(int num, int num2) {
		System.out.println("num: " + num);
		System.out.println("num2: " + num2);
		System.out.println();
	}
	
	public static String method4() {  //참조형 클래스 타입
		return "return data";
	}
	
	public static String method5(int age) {//void도 리턴타입
		String ageStr = age + "살";
		return ageStr;
	}
	
	public static void main(String[] args) {
		String ageStr = "30살";
		
		method1(); // 함수 호출
		method2(100);
		method3(200, 300);
		
		System.out.println(method4());
		System.out.println();
		
		String data1 = method4();
		System.out.println(data1);
		System.out.println();
		
		System.out.println(method5(30));
		System.err.println();
	}
	
	
	
}






