package 프로그래머스;

import java.util.Arrays;

public class AlienDictionary {
	public static int solution(String[] spell, String[] dic) {
        int answer = 0;
        String[] word = new String[dic.length];
        
        for(int i = 0; i < dic.length; i++) {
        	word[i] = dic[i];
        	for(String s : spell) {
        		word[i] = word[i].replaceFirst(s, "");
        	}
        	//System.out.println(spell.length);
        	System.out.println(spell.length == dic[i].length());
        	if(spell.length == dic[i].length()) {
        		if(word[i].contains("")) {
        			answer = 1;        			
        		}else {
        			System.out.println("여기가 찍히는거야?");
        		}
        	}else {
        		answer = 2;
        	}
        }
        
        
        System.out.println(Arrays.toString(spell));
        System.out.println(Arrays.toString(word));
        System.out.println(answer);
        return answer;
        }
        	
        	
	
	public static void main(String[] args) {
		
		String[] spell = {"z", "d", "x"};
		String[] dic = {"def", "dww", "dzx", "loveaw"};		
		solution(spell, dic);
	}

}
