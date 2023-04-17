package 프로그래머스;

public class BigNum {
	public static int[] solution(int[] array) {
        int a = 0;
        int[] answer = new int[2];
       
        for(int i = 0; i< array.length; i++) {
        	a = array[i] > a ? array[i] : a;
        }
        	answer[0] = a;
        for(int i = 0; i<array.length; i++) {
        	if(array[i]==a) {
        		answer[1]= i;
        		break;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] array = {9, 10, 11, 8};
		solution(array);
	}

}
