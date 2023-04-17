package 프로그래머스;

public class Square {
	public static int solution(int n) {
        
		/* 첫번째 방법
		int answer = 0;
		System.out.println(n);
        
        for(int i = 1; i<=1000000; i++) {
        	if(i*i == n) {
        		answer = 1;
        		break;
        	}else {
        		answer = 2;
        		continue;
        	}
        }
        System.out.println(answer);
			return answer;
			*/
		/* 두번째 방법
		int answer = 0;
		if (n % Math.sqrt(n) == 0) {
			answer = 1;
        } else {
        	answer = 2;
        }
       
        System.out.println(Math.sqrt(n));
        return answer;
        */
		
		/* 간단한 표현식 */
		return n % Math.sqrt(n) == 0 ? 1 : 2;
		
        
    }
	
	public static void main(String[] args) {
		
		solution(144);
	}

}
