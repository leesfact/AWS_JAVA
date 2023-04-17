package 프로그래머스;

import java.util.ArrayList;

public class MakeBWithA {
	public static int solution(String before, String after) {
        
        String[] beforeList = before.split("");
        String[] afterList = after.split("");
        ArrayList<String> str = new ArrayList<>();
        
        for(int i = 0; i < before.length(); i++) {
        	str.add(beforeList[i]);
        }
   
        for(int i = 0; i < before.length(); i++) {
        	if(str.contains(afterList[i])) {
        		str.remove(afterList[i]);
        	}
        }
        return str.isEmpty() ? 1 : 0;
    }
	
	public static void main(String[] args) {
		solution("olleh","hello");
	}

}

