package 프로그래머스;

public class Decryption {
	public static String solution(String cipher, int code) {
        String answer = "";
        String[] letter = cipher.split("");
        
        for(int i = code-1; i<letter.length; i+=code) {
        	 answer += letter[i];
        }
        return answer;
    }
	public static void main(String[] args) {
		solution("pfqallllabwaoclk",2);
	}

}
