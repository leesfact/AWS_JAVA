package 프로그래머스;

public class PizzaEat {
	public static int solution(int n) {
        int answer = 0;
        int pizcnt = 1;
        
        
        while(true) {
        	if((6*pizcnt) % n == 0) {
        		answer =  (6 * pizcnt) / 6;
        		break;
        	}
        	pizcnt++;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		solution(4);
	}

}
