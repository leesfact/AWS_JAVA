package J16_Object; //최상위 클래스

import java.util.*;

public class Student  { // extends Object???? // 클래스는 다중상속 X, 단일상속// implements 다중상속
	
	private String name;   //멤버변수
	private int age;
	
	
	
	
	
	public Student(String name, int age) {
		super(); // 부모 클래스 생성자 호출(?)//object의 클래스를 상속
		this.name = name;
		this.age = age;
	}
	
	@Override
		public int hashCode() {
			return Objects.hash(name,age);
		}
	
	
	@Override
		public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}

		if(obj == null) {
			return false;
		}
		
//		if(!(obj instanceof Student)) { //명확한 문장은 아니다... getclass를 써야함
//			return false;
//		}
		
		if(!(obj.getClass() == Student.class)){ 
			
			return false; 
			}
		
		/*
		 *  Object
		 *    ↓
		 *  Person
		 *    ↓
		 * Student   (instance of 를 쓰면 Student가 Object, Person을 다 들고 있음)
		 * 프로그램의 오류를 야기할 수 있는 문제가 발생 getClass를 쓰는 이유
		 * 
		 *  if(!(obj.getClass() == Student.class)){ return false; }
		 *  이게 명확한 구조
		 */
		
		Student s = (Student)obj; //오 -> 왼쪽으로 다운캐스팅
		boolean result = name.equals(s.name) && age == s.age;  //private(접근 제한자) 같은 클래스 내에는 접근 가능
		
		return result;
		

		}
	
	
	@Override
		public String toString() {
			
			return "이름: " + name + "\n나이: " +age;
		}
}
