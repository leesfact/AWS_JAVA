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
			System.out.println("================================");
		}
			
	
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("가",1));
		students.add(new Student("나",2));
		students.add(new Student("다",3));
		students.add(new Student("라",4));
		
		//System.out.println(students);
		
		String searchName = "바";  //선형탐색
	System.out.println();	
//		
//		boolean findFlag = true;
//		for(int i = 0; i < students.size(); i++) { // 검출 함수
//			Student student = students.get(i);
//			if(student.getName().equals(searchName) ) {  //접근 지정자 private가 걸려있음 
//				student.setYear(4);
//				findFlag = false;      
//				System.out.println("검색 성공");
//				break; // 안쪽 for문을 멈춰주는 break; 중복되지 않은 값을 찾았을때,
//			}
//		}
//		
//		if(findFlag) {
//			System.out.println("검색 실패 !!!");
//		}
		
		
		updateYear(students,"바",10);  //searchName 변수 넣어도 됨
		System.out.println(students);
	
		
		
		
		
		
	}
	

}
