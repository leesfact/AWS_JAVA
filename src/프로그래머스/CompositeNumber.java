package 프로그래머스;

public class CompositeNumber {
	public static int solution(int n) {
        int answer = 0;
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= i; j++ ) {
        		if(i % j == 0) {
        			cnt++;
    		   }
    		}
        	if(cnt >= 3) {
        		answer++;
        	}
        	cnt = 0;
        	}
        return answer;
    }
	
	public static void main(String[] args) {
		solution(4);
	}

}

