package 프로그래머스;

import java.util.LinkedHashSet;

public class DuplicateCharacter {
	public static String solution(String my_string) {
        String answer = "";
        String[] oldArray = my_string.split("");
        LinkedHashSet<String> DupRemoveArray = new LinkedHashSet<>();
        
        for(int i = 0; i < my_string.length();i++) {
        	DupRemoveArray.add(oldArray[i]);
        }
        
        for(String str : DupRemoveArray) {
        	answer += str;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		solution("We are the world");
	}	
}
