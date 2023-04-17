package 프로그래머스;

public class Pair {
	
	public static int solution(int n) {
        int answer = 0;
 
        
        
        for(int i = 1; i<=n; i++) {
        	if( n % i == 0) {    // 1,2,4,5,10,20
        		answer++;
        	}
        }
        
        
        
        System.out.println(answer);
        
        
        return answer;
    }
	
	
	
	
	public static void main(String[] args) {
		
		solution(100);
	}

}
