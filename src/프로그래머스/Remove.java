package 프로그래머스;

public class Remove {
	public static String solution(String my_string) {
        String answer = my_string.replaceAll("[aeiou]", "");
        System.out.println(answer);
        return answer;
    }
    
    public static void main(String[] args) {
        solution("nice to meet you");
    }
}

