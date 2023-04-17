package 프로그래머스;

public class Nmultiple {
	
	public static int[] solution(int n, int[] numList) {
		int size = 0;
        for(int i = 0; i<numList.length; i++) {
        	if(numList[i] % n == 0) {
        		size ++;
        	}
        }
        
        int[] answer = new int[size];
        int j = 0;
        
        for(int i = 0; i<numList.length; i++) {
        	if(numList[i] % n == 0) {
        		answer[j] = numList[i];
        		j++;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] numList = {4, 5, 6, 7, 8, 9, 10, 11, 12};
		solution(3,numList);
	}

}
