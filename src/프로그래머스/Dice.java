package 프로그래머스;

public class Dice {
	public static int solution(int[] box, int n) {
        for(int i = 0 ; i<box.length; i++) {
        	 box[i] = box[i]/n;
        }
        return box[0] *box[1] *box[2];
    }
	
	public static void main(String[] args) {
		int[] box = {10,8,6};
		
		solution(box,3);
	}

}
