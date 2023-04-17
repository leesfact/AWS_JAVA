package 프로그래머스;

public class PrintRepeat {
	
	public static String solution(String my_string, int n) {
        String answer = "";
        String[] arr = my_string.split(""); // 매개변수를 받아와 배열에 넣는 작업
      
        
        for(int i = 0; i<arr.length; i++) {
        	
        	 answer += arr[i].repeat(n);
        	
        }
        System.out.println(answer);
        return answer;
    }
	
	
	public static void main(String[] args) {
		
		solution("hello",3);
	}

}

