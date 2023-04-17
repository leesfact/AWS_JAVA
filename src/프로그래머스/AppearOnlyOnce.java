package 프로그래머스;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class AppearOnlyOnce {
	
	public static String solution(String s) {
	   
		   String answer = "";
		   Set<String> dupliSet = new LinkedHashSet<>();
		   Set<String> nonDupliSet = new LinkedHashSet<>();
		   for(int i = 0; i < s.length(); i++) {
			  String c =  Character.toString(s.charAt(i));
			 if(nonDupliSet.contains(c)) {
				 dupliSet.add(c);
			 }else {
				 nonDupliSet.add(c);
			 }
		   }
		   
		   
		   System.out.println("중복값: " + dupliSet);
		   System.out.println("중복안된 값: "+ nonDupliSet);
		   nonDupliSet.removeAll(dupliSet);
		   System.out.println("중복 완전 제거 값: "+ nonDupliSet);
		   

		   String[] newStr = new String[nonDupliSet.size()];
		   newStr = nonDupliSet.toArray(newStr);
		   Arrays.sort(newStr);
		   
	       for(String str : newStr) {
	    	   answer += str;
	    	  
	       }

		  
		   return answer;
	}

	
	public static void main(String[] args) {
		solution("hello");
	}

}
