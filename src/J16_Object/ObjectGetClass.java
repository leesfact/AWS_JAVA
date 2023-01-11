package J16_Object;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectGetClass {
	public static void main(String[] args) {
		
		
		Student st = new Student("홍길동", 31);
		
		System.out.println(st.getClass());
		System.out.println(Student.class);
		
		System.out.println(st.getClass().getName());  //1번
		
		Class stClass = st.getClass();
		
		System.out.println(stClass.getName()); //2번
		
		
		String className = stClass.getName();
		
		System.out.println("클래스 이름: "+ className); //3번
		//1번과 2번이 같다는걸 빨리 캐치해야함
		
		String simpleName = stClass.getSimpleName();
		System.out.println("클래스 이름만: " + simpleName);
		
		
		
		Field[] fields = stClass.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(field);
		}
		
		Method[] methods = stClass.getDeclaredMethods();
		
		for(Method method : methods) {
			System.out.println(method);
		}
		
	}

}
