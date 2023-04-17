package 프로그래머스;

import java.util.Arrays;

public class HiddenNumbers {
	
	public static int solution(String my_string) {
	   	
		
		int answer = 0;
        String[] str = my_string.split("[a-zA-Z]");
        
        System.out.println(Arrays.toString(str));
        for(int i = 0 ; i < str.length;i++){
            if(str[i].length() > 0)
                answer+=Integer.parseInt(str[i]);
        }
        return answer;
	}

	
	public static void main(String[] args) {
		solution("aAb1B2cC34oOp");
	}
}