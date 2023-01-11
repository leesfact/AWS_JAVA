package J16_Object;

public class ToString {
	
	public static void main(String[] args) {
		
		Student st1 = new Student("조병철", 34);   //인스턴스( 메모리 할당 ) // 생성자 생성 //스택에 st1 할당
		Student st2 = new Student("가", 3);
		Student st3 = new Student("나", 4);
		Student st4 = new Student("다", 5);
		
				
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
		System.out.println(st4);
		
		System.out.println("====<같은 결과>=====");
		
		System.out.println(st1.toString());
		System.out.println(st2.toString());
		System.out.println(st3.toString());
		System.out.println(st4.toString());
		
		
		
		
		
		
	}

}
