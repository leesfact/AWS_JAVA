package j12_배열;

public class Array6 {
	public static void main(String[] args) {
		
		
		String[] names = {"A", "B", "C"};
		
		for(int i = 0; i<names.length; i++) {
			
			System.out.println(names[i] + " ");
		}
		System.out.println("=========<for-Each>=========");
		for(String name: names) {
			System.out.println(name);
		}
		
		System.out.println("============================");
		int[] nums = {1,2,3,4,5};
		
		for(int num: nums) {
			System.out.println("i: "+ num);
		}
		
	}

}
