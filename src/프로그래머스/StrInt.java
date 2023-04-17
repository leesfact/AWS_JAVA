package 프로그래머스;

public class StrInt {
	
	 public static int solution(String my_string) {
	     int answer = 0;
	        
	     String intStr = "";
	     
	     for(int i = 0; i<my_string.length(); i++) {
	    	 
	    	 char ch =  my_string.charAt(i);
	    	 
	    	 if(ch >= 48 && ch <= 57) {
	    		 intStr += ch;
	    	 }
	    	 
	     }
	      
	     for(int i = 0; i<intStr.length();i++) {
	    	 answer += Integer.parseInt(intStr);
	     }
	     

	      System.out.println(answer); 
	       
	        return answer;
	    }
	 
	 
	 public static void main(String[] args) {
		
		 
	
		 	solution("aAb1B2cC34oOp");
	}

}
