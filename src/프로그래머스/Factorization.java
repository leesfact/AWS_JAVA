package 프로그래머스;

import java.util.LinkedHashSet;
import java.util.Set;

public class Factorization {
    public static Set<Integer> solution(int n) {
        Set<Integer> answer = new LinkedHashSet<>();
       
        	for(int i = 2; i <= n; i++) {
        		System.out.println(i);
        		if(n%i == 0 ) {
        			
        			n /= i;
        			answer.add(i);
        			i = 1;
                   
        		}
        	}
//       System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
       
    solution(990);
            
        
    }
}