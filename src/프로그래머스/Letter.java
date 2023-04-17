package 프로그래머스;

public class Letter {
	
	  public static int solution(String message) {
	        int answer = 0;
	        String[] letter = message.split("");
	        for(int i = 0; i<letter.length; i++) {
	        	answer++;
	       //System.out.println(letter[i]);
	        }
	        System.out.println(answer);
	        return answer;
	    }
	  
	  
	  public static void main(String[] args) {
		
		  
		  solution("hello bro~!");
		  
	}

}
