package 프로그래머스;

public class StringCal {
   public static int solution(String my_string) {
        int answer = 0;
        String[] str = my_string.split(" ");
        answer += Integer.parseInt(str[0]);  
       
        
        for(int i = 1; i < str.length; i++) {
        	if(str[i].equals("+")) {
        		answer += Integer.parseInt(str[i+1]);
        	}
        	if(str[i].equals("-")) {
        		answer -= Integer.parseInt(str[i+1]);
        	}
        }
        System.out.println(answer);
        return answer;
    }
   
   public static void main(String[] args) {
      solution("3 - 4 + 1000");
   }

}