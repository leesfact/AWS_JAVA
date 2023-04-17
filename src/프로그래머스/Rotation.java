package 프로그래머스;

import java.util.Arrays;

public class Rotation {
	 public static int[] solution(int[] numbers, String direction) {
		 int length = numbers.length;
	        int[] rotated = new int[length];
	        
	        if (direction.equals("right")) { // 시계방향 회전
	            for (int i = 0; i < length; i++) {
	                rotated[(i+1)%length] = numbers[i];
	                System.out.println(rotated[(i+1)%length]);
	            }
	        } else { // 반시계방향 회전
	            for (int i = 0; i < length; i++) {
	                rotated[i] = numbers[(i+1)%length];
	            }
	        }
	        System.out.println(Arrays.toString(rotated));
	        return rotated;
	    }
	 
	 public static void main(String[] args) {
		 int[] numbers = {1,2,3};
		solution(numbers,"right");
	}

}

