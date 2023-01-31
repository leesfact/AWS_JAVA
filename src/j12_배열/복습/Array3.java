package j12_배열.복습;

import java.util.ArrayList;

public class Array3 {
	
	
	public static ArrayList solution(int n) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        for(int i=1; i<=n; i++){
          if(i % 2 != 0) {
              answer.add(i);

          } 
        }
        System.out.println(answer);
        return answer;
    }

	
	

	
	public static void main(String[] args) {
		
		solution(15);
		
	}
}
		
		


