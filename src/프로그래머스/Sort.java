package 프로그래머스;

import java.util.Arrays;

public class Sort {
	public static int[] solution(String my_string) {
        char ch = 0;
        String intStr = "";
        for(int i = 0; i<my_string.length(); i++) {
        	ch = my_string.charAt(i); 
        	if(ch >= 48 && ch <= 57) {
        	intStr += ch;	
        	}
        }
        
        int[] answer = new int[intStr.length()]; // answer 배열 생성

        for(int i = 0; i < intStr.length(); i++) {
            answer[i] = Character.getNumericValue(intStr.charAt(i)); // 문자열의 각 문자를 숫자로 변환하여 배열에 추가
        }
        
        Arrays.sort(answer);
  
        return answer;
    }
	
	public static void main(String[] args) {
		solution("p2o4i8gj2");
	}

}
