package J16_Object;

public class ObjectHashcode {
	public static void main(String[] args) {
		
		
		Student s1 = new Student("이강용", 31);
		Student s2 = new Student("이강용", 31);
		SubStudent s3 = new SubStudent("이강용", 31);
		
		System.out.println(s1.hashCode());  // 주소값 // 메소드이기때문에 오버라이딩할 수 있음
		System.out.println(s2.hashCode());  // 주소값
		
		
		
		System.out.println(s1.hashCode() == s2.hashCode());
		System.out.println(s1.hashCode() == s3.hashCode());
		
	}

}
