package 프로그래머스;

public class TossBall {
	
	 public static int solution(int[] numbers, int k) {
	        int answer = 0;
	       
	        for(int i = 1; i <= k; i++) {
	        	System.out.println(i+"번째");
	        	for(int j = 0; j < numbers.length; j +=2) {
	        		System.out.println(numbers[j]);
	        		answer = numbers[j];
	        	}
	        	
	        }
	        
	        System.out.println(answer);
	        return answer;
	    }
	 
	 
	 public static void main(String[] args) {
		int [] numbers =  {1, 2, 3, 4, 5, 6};
		solution(numbers, 5);
	}

}
