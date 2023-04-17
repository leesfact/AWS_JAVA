package 프로그래머스;

public class IndexChange {
	public static String solution(String my_string, int num1, int num2) {
        String answer = "";
        StringBuilder str = new StringBuilder(my_string);
        char temp = str.charAt(num1);
        str.setCharAt(num1, str.charAt(num2));
        str.setCharAt(num2, temp);
        answer+= str;
     
        return answer;
    }
	
	
	public static void main(String[] args) {
		solution("I love you",3,6);
	}
}
