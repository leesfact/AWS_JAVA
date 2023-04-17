package 프로그래머스;

public class Equals {
	 public static int solution(String str1, String str2) {
	        int answer = 0;
	        
	        
	        if(str1.contains(str2)== true) {
	        	answer = 1;
	        }else {
	        	answer = 2;
	        }
	        
	        
	        
	        System.out.println(answer);
	        return answer;
	    }
	 
	 
	 public static void main(String[] args) {
		
		 solution("ab6CDE443fgh22iJKlmn1o","6CD");
		 
	}

}
