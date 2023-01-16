package J19_컬렉션;

import java.util.HashSet;
import java.util.Set;

public class StudentHashSet {
	
	
	private static Student searchStudent(Set<Student> students,String searchName) {
		
		Student student = null;
		
		for(Student s : students) {
			if(s.getName().equals(searchName)) {
				student = s;
				break;
			}
		}
		return student;
	}
	
	
	
	public static void main(String[] args) {
		
		Set<Student> students = new HashSet<>();
		
		students.add(new Student("가",1));
		students.add(new Student("나",2));
		students.add(new Student("다",3));
		students.add(new Student("라",4));
		
		System.out.println(students); //순서 없이 뒤죽박죽
		
		Student student = searchStudent(students, "나");
		
		if(student == null) {
			System.out.println("검색실패!");
		}else {
			System.out.println("검색성공!" + student);
		}
		
		
	}

}
