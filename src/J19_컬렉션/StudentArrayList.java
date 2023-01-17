package J19_컬렉션;

import java.util.ArrayList;
import java.util.List;

public class StudentArrayList {
	
		
		public static void updateYear(
				List<Student> students,
				String serachName,
				int newYear
				) {
			for(Student student : students) {
				
				if(student.getName().equals(serachName)) {
					student.setYear(newYear);
					return;
				}
			}
			System.out.println("검색 실패");
		}
			
	
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("가",1));
		students.add(new Student("나",2));
		students.add(new Student("다",3));
		students.add(new Student("라",4));
		
		
		updateYear(students,"바",10);  //searchName 변수 넣어도 됨 // 객체 생성 없이 접근 가능
		System.out.println(students);		
	}
}
