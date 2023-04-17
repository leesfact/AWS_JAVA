package 프로그래머스;

public class Sum {
	public static int solution(int n) {
		
	  int answer = 0;
	  String st1 = Integer.toString(n);
	  
	  String[] arr = st1.split(""); 
		
		
		
		
		for(int i = 0; i<arr.length; i++) {
			
			System.out.println(arr[i]);
			answer += Integer.parseInt(arr[i]);
		}
		
		
		System.out.println(answer);
   
        return answer;
    }

	
	public static void main(String[] args) {
		
		solution(930211);
		
	}
	
	
}
