package j10_생성자;

public class J10_Student {
	
	public String name;
	public int age;
	
	J10_Student() {
		System.out.println("기본 생성자 호출");
	}
	
	J10_Student(int age) {
		System.out.println("학생의 나이: " + age);
	}
	
	J10_Student(String name) {
		System.out.println("학생의 이름: " + name);
	}
	
	J10_Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	void printInfo() {
		System.out.println("학생 이름: " + name);
		System.out.println("학생 나이: " + age);
	}
	
}





