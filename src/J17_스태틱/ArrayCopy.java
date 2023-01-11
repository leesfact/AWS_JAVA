package J17_스태틱;



public class ArrayCopy {
	public static void main(String[] args) {
		
		int[] array1 = {10,20,30,40,50};
		int[] array2 = {1,2,3,4,5};
		
		System.arraycopy(array1, 0, array2, 1, 4); // array1에서 array2로 1번 인덱스에 0~4번까지를 차례로 카피  
		
		for(int i = 0; i<array2.length; i++) {
			System.out.println(array2[i]);
			
		
		}
	}

}
