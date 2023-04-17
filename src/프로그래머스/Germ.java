package 프로그래머스;

public class Germ {
	 public static int solution(int n, int t) {
	        for(int i = 0; i<t; i++) {
	        	
	        	n= n*2;
	        }
	        return n;
	    }
	 public static void main(String[] args) {
		solution(7,15);
	}
}
