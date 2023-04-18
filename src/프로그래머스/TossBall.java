package 프로그래머스;

import java.util.ArrayList;

public class TossBall {
	
	 public static int solution(int[] numbers, int k) {
	       int answer = 0;
	       ArrayList<Integer> oddList = new ArrayList<>();
	       ArrayList<Integer> evenList = new ArrayList<>();
	       int index = k % numbers.length;
	       int jump = 0;
	       for(int i = 0; i < numbers.length; i++) {
		       if(numbers.length / 2 == 0) { //even
		    	   evenList.add(numbers[index + jump]);
		       }else { //odd
		    	   oddList.add(numbers[index + jump]);
		       }
	       }
	       
	        System.out.println(evenList);
	        System.out.println(oddList);
	        
	        return answer;
	    }
	 
	 	
	 public static void main(String[] args) {
		int [] numbers =  {1, 2, 3};
		solution(numbers, 2);
	}

}
