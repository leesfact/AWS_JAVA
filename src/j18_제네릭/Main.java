package j18_제네릭;

public class Main {
	
	public static void main(String[] args) {
		TestData<? extends String, ?> td = new TestData<String, Integer>("김준일", 30);
		TestData<?, ? super Double> td2 = new TestData<String, Double>("junil", 100.05);
		System.out.println(td);
		System.out.println(td2);
	}
	
}
