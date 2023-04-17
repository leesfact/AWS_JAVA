package 프로그래머스;

import java.util.Arrays;

public class Emergency {
	
	public static int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] down = new int[emergency.length];
        
        for(int i = 0; i < emergency.length; i++) {
        	down[i] = emergency[i];
        }
        
        
        Arrays.sort(down);
        System.out.println("before : "+ Arrays.toString(down));
        
        
        for(int i = 0; i < emergency.length; i++) {
        	for(int j = 0; j < emergency.length;j++) {
        		if(down[i] == emergency[j]) {
        			answer[j] = emergency.length-i;
        		}
        	}
        }
        System.out.println("after : " + Arrays.toString(answer));
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int[] emergency = {30, 10, 23, 6, 100};
		
		solution(emergency);
	}

}
