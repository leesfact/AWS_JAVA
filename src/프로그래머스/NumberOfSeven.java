package 프로그래머스;

public class NumberOfSeven {
	public static int solution(int[] array) {
		int count = 0;
	    String str = "";
	    for (int num : array) {
	        str += num;
	    }

	    for (int i = 0; i < str.length(); i++) {
	        if (str.charAt(i) == '7') {
	            count++;
	        }
	    }

	    return count;
    }
	
	public static void main(String[] args) {
		
		solution(new int[]{7,77,17});
	}

}
