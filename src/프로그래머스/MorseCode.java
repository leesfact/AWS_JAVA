package 프로그래머스;

public class MorseCode {
	   

	   public static String solution(String letter) {
	      
	      String[] Morse = {".-","-...","-.-.","-..",".","..-.","--.","....",
	            "..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
	            "...","-","..-","...-",".--","-..-","-.--","--.."};
	      
	      String[] convert = letter.split(" ");
	  
	        String answer = "";
	     
	        for(int i = 0; i < convert.length; i++) {
	           for(int j = 0; j < Morse.length; j++) {
	              if(convert[i].equals(Morse[j])) {
	            	  
	            	char letterChar = (char)(j + 'a');
	            	answer += Character.toString(letterChar);
	                
	              }
	           }
	        }
	        System.out.println(answer);
	        return answer;
	    }
	   
	   public static void main(String[] args) {
	      solution(".--. -.-- - .... --- -.");
	   }

	}

