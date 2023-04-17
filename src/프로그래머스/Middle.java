package 프로그래머스;

import java.util.Arrays;

public class Middle {
	
	 public static int solution(int[] array) {
		 int answer = 0;
		   Arrays.sort(array);
		    
			  
		  answer = (array.length)/2; 
		 System.out.println(array[answer]);
		   
	        
	        return answer;
	    }
	 
	 public static void main(String[] args) {
		int[] array = {1,2,7,10,11};
		 solution(array);
	}

}
