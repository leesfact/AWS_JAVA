package J18_제네릭;

public class Main {
	
	public static void main(String[] args) {
		
		
		/*
		 *   <?,?> // 필살기???
		 * 
		 * 
		 * 
		 */
		TestData<String, Integer> td = new TestData<String, Integer>("김준일", 30);
		TestData<String,Double> td2 = new TestData<String, Double>("junil", 100.05);
		System.out.println(td);
		System.out.println(td2);
		
		
		CMRespDto<TestData<String,Integer>> cm = 
		new CMRespDto<TestData<String,Integer>>(200, "성공", td);
		
		System.out.println(cm);
	}
	
}
