package 프로그래머스;

import java.util.HashSet;
import java.util.Set;

public class Arraytest {
	
	public static int solution(String[] s1, String[] s2) {
        int answer = 0;
        int count = 0;
        
        Set<String> set = new HashSet<>();
        for(int i = 0; i<s1.length; i++) {
        	set.add(s1[i]);
        	count++;
        }
        for(int i = 0; i<s2.length; i++) {
        	set.add(s2[i]);
        	count++;
        }
        answer = count-set.size();
        System.out.println(set);
        System.out.println(answer);
        return answer;
    }
	
	
	
	
	public static void main(String[] args) {
		
		String[] a = {"m","omg"};
		String[] b = {"m","dot"};
	
		solution(a,b);
		
		
	}

}



