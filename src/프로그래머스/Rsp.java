package 프로그래머스;

public class Rsp {
	 public static String solution(String rsp) {
	        String answer = "";
	        for(int i = 0; i < rsp.length(); i++) {
	        	if(rsp.charAt(i)=='5') {
	        		answer +='2';
	        	}else if(rsp.charAt(i) == '0') {
	        		answer +='5';
	        	}else {
	        		answer +='0';
	        	}
	        }
	        return answer;
	    }
	 
	 public static void main(String[] args) {
		solution("5022000555252000");
		/* 
		 * 가위 : 2
		 * 바위 : 0
		 * 보  : 5
 		 * */
	}

}
