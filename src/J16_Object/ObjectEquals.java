package J16_Object;

public class ObjectEquals {
	
	public static void main(String[] args) {
		
		String name1 = "김준일"; //리터널 // 정해진 값 //변하지 않는 데이터
		String name2 = "김준일";
		String name3 = new String("김준일");
		
		System.out.println(name1);
		System.out.println(name2);
		//문자열 비교할때는 equals를 써라
		System.out.println(name1 == name2); // 이것은 주소 비교다
		System.out.println(name1 == name3);
		System.out.println(name1.equals(name3));
		
		///////////////////////////////////////////////////////////
		
		
		Student s1 = new Student("김준일", 30);  // 주소가 달라서 (생성자 다르게 생성)
		Student s2 = new Student("김준일", 30);
		SubStudent s3 = new SubStudent("김준일", 30);
		
		
//		Student s1 = s; // 같은 주소
//		Student s2 = s; // 같은 주소
//		System.out.println("==========");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));   //object 내 equals 메소드도 기본적인 주소 비교
		
		
		//
	}

}
