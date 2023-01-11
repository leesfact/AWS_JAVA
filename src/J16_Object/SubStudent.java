package J16_Object;

import java.util.Objects;

public class SubStudent {
	
	private String name; //멤버변수 
	private int age;
	
	
	public SubStudent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	@Override
	public int hashCode() { //???int형?
		
		return Objects.hash(name,age);
	}

}
