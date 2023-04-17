package 프로그래머스;

import java.util.Arrays;

public class SortString {
	public static String solution(String my_string) {
        String answer = "";
        
        
        for(int i= 0; i<my_string.length(); i++) {
        	char ch = my_string.charAt(i);
        	
        	if(ch>=65 && ch <= 90) {
        		answer += (char)(ch+32);
        	}else {
        		answer += (char)(ch);
        	}
        }
        char[] chars = answer.toCharArray();
        Arrays.sort(chars);
        String sortedAnswer = new String(chars);
        
        return sortedAnswer;
      
       }
        
     
	public static void main(String[] args) {
		String my_string = "Python";
		solution(my_string);
	}

}
